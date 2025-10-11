package com.ridehub.booking.service;

import com.ridehub.booking.domain.PaymentTransaction;
import com.ridehub.booking.domain.enumeration.PaymentMethod;
import com.ridehub.booking.domain.enumeration.PaymentStatus;
import com.ridehub.booking.repository.PaymentTransactionRepository;
import com.ridehub.booking.service.payment.vnpay.VNPayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Service for auto-polling VNPay transactions to handle payment status updates
 * when IPN (Instant Payment Notification) is not available in test mode.
 */
@Service
@Transactional
public class VNPayPollingService {

    private static final Logger LOG = LoggerFactory.getLogger(VNPayPollingService.class);
    
    private static final String POLLING_IP_ADDRESS = "127.0.0.1";
    private static final int MAX_POLLING_ATTEMPTS = 30; // 30 attempts = 1 hour with 2-minute intervals
    private static final int POLLING_TIMEOUT_HOURS = 24; // Stop polling after 24 hours
    
    private final PaymentTransactionRepository paymentTransactionRepository;
    private final VNPayService vnPayService;
    private final PaymentService paymentService;
    
    // Cache to track polling attempts and avoid excessive API calls
    private final Map<String, Integer> pollingAttempts = new ConcurrentHashMap<>();
    private final Map<String, Instant> lastPollTime = new ConcurrentHashMap<>();

    public VNPayPollingService(PaymentTransactionRepository paymentTransactionRepository,
                               VNPayService vnPayService,
                               PaymentService paymentService) {
        this.paymentTransactionRepository = paymentTransactionRepository;
        this.vnPayService = vnPayService;
        this.paymentService = paymentService;
    }

    /**
     * Auto-poll VNPay transactions every 2 minutes to check for payment status updates.
     * This replaces IPN functionality in test mode.
     */
    @Scheduled(fixedRate = 120000) // 2 minutes = 120000 milliseconds
    public void pollPendingTransactions() {
        LOG.debug("Starting VNPay transaction polling cycle");
        
        try {
            // Find VNPay transactions that are still in INITIATED or PROCESSING status
            // and were created within the last 24 hours
            Instant cutoffTime = Instant.now().minus(POLLING_TIMEOUT_HOURS, ChronoUnit.HOURS);
            
            List<PaymentTransaction> pendingTransactions = paymentTransactionRepository
                .findByMethodAndStatusInAndCreatedAtAfterAndIsDeletedFalseOrIsDeletedIsNull(
                    PaymentMethod.VNPAY,
                    List.of(PaymentStatus.INITIATED, PaymentStatus.PROCESSING),
                    cutoffTime
                );
            
            LOG.info("Found {} pending VNPay transactions to poll", pendingTransactions.size());
            
            int processedCount = 0;
            int successCount = 0;
            int failedCount = 0;
            
            for (PaymentTransaction transaction : pendingTransactions) {
                try {
                    if (shouldPollTransaction(transaction)) {
                        boolean updated = pollAndUpdateTransaction(transaction);
                        if (updated) {
                            processedCount++;
                            if (transaction.getStatus() == PaymentStatus.SUCCESS) {
                                successCount++;
                            } else if (transaction.getStatus() == PaymentStatus.FAILED) {
                                failedCount++;
                            }
                        }
                    }
                } catch (Exception e) {
                    LOG.error("Error polling transaction {}: {}", transaction.getTransactionId(), e.getMessage(), e);
                }
            }
            
            if (processedCount > 0) {
                LOG.info("VNPay polling cycle completed: {} transactions processed, {} succeeded, {} failed", 
                    processedCount, successCount, failedCount);
            } else {
                LOG.debug("VNPay polling cycle completed: no transactions updated");
            }
            
        } catch (Exception e) {
            LOG.error("Error in VNPay polling cycle", e);
        }
    }

    /**
     * Check if a transaction should be polled based on attempt limits and timing.
     */
    private boolean shouldPollTransaction(PaymentTransaction transaction) {
        String transactionId = transaction.getTransactionId();
        
        // Check if we've exceeded max polling attempts
        Integer attempts = pollingAttempts.getOrDefault(transactionId, 0);
        if (attempts >= MAX_POLLING_ATTEMPTS) {
            LOG.debug("Skipping transaction {} - max polling attempts reached", transactionId);
            return false;
        }
        
        // Check if we've polled this transaction recently (to avoid rate limiting)
        Instant lastPoll = lastPollTime.get(transactionId);
        if (lastPoll != null && lastPoll.isAfter(Instant.now().minus(90, ChronoUnit.SECONDS))) {
            LOG.debug("Skipping transaction {} - polled recently", transactionId);
            return false;
        }
        
        return true;
    }

    /**
     * Poll a single transaction and update its status if needed.
     */
    private boolean pollAndUpdateTransaction(PaymentTransaction transaction) {
        String transactionId = transaction.getTransactionId();
        String orderRef = transaction.getOrderRef();
        
        LOG.debug("Polling VNPay transaction: {} for order: {}", transactionId, orderRef);
        
        try {
            // Update polling tracking
            pollingAttempts.put(transactionId, pollingAttempts.getOrDefault(transactionId, 0) + 1);
            lastPollTime.put(transactionId, Instant.now());
            
            // Query transaction status from VNPay using PaymentTransaction data
            VNPayService.VNPayQueryResult queryResult = vnPayService.queryTransaction(
                transaction, 
                POLLING_IP_ADDRESS
            );
            
            if (queryResult.isSuccess()) {
                LOG.info("VNPay query successful for transaction {}: status={}, amount={}, code={}", 
                    transactionId, queryResult.getTransactionStatus(), queryResult.getAmount(), queryResult.getResponseCode());
                
                // Determine the new payment status based on VNPay response
                PaymentStatus newStatus = determinePaymentStatus(queryResult);
                
                // Only update if status has changed
                if (newStatus != transaction.getStatus()) {
                    LOG.info("Updating transaction {} status from {} to {}", 
                        transactionId, transaction.getStatus(), newStatus);
                    
                    // Update transaction
                    transaction.setStatus(newStatus);
                    transaction.setUpdatedAt(Instant.now());
                    
                    // Set gateway information if available
                    if (queryResult.getAmount() != null) {
                        transaction.setAmount(queryResult.getAmount());
                    }
                    
                    // Save the updated transaction
                    paymentTransactionRepository.save(transaction);
                    
                    // Synthesize webhook event for the status change
                    synthesizeWebhookEvent(transaction, queryResult);
                    
                    // Clean up polling tracking for completed transactions
                    if (newStatus == PaymentStatus.SUCCESS || newStatus == PaymentStatus.FAILED) {
                        pollingAttempts.remove(transactionId);
                        lastPollTime.remove(transactionId);
                    }
                    
                    return true;
                } else {
                    LOG.debug("Transaction {} status unchanged: {}", transactionId, newStatus);
                    
                    // If this was a duplicate request (code=94) and status is unchanged, 
                    // we should back off to avoid repeated duplicate requests
                    if ("94".equals(queryResult.getResponseCode())) {
                        LOG.debug("Duplicate request detected for transaction {}, backing off polling", transactionId);
                        // Increase the polling attempt count to trigger backoff
                        pollingAttempts.put(transactionId, MAX_POLLING_ATTEMPTS - 5);
                        return false;
                    }
                }
            } else {
                LOG.warn("VNPay query failed for transaction {}: code={}, message={}", 
                    transactionId, queryResult.getResponseCode(), queryResult.getMessage());
            }
            
        } catch (Exception e) {
            LOG.error("Error polling VNPay transaction {}: {}", transactionId, e.getMessage(), e);
        }
        
        return false;
    }

    /**
     * Determine payment status based on VNPay query response.
     */
    private PaymentStatus determinePaymentStatus(VNPayService.VNPayQueryResult queryResult) {
        String responseCode = queryResult.getResponseCode();
        String transactionStatus = queryResult.getTransactionStatus();
        
        // VNPay response codes:
        // 00 = Successful transaction
        // 01 = Transaction not found
        // 02 = Invalid order info
        // 04 = Invalid amount
        // 05 = Invalid signature
        // 06 = Other errors
        // 07 = Transaction is in processing
        // 09 = Transaction refunded
        // 10 = Transaction is waiting for payment
        // 20, 21 = Duplicate request
        // 99 = Other errors
        
        if ("00".equals(responseCode) && "00".equals(transactionStatus)) {
            return PaymentStatus.SUCCESS;
        } else if ("07".equals(responseCode) || "10".equals(responseCode)) {
            return PaymentStatus.PROCESSING;
        } else if ("09".equals(responseCode)) {
            return PaymentStatus.REFUNDED;
        } else {
            // For most error codes, consider the transaction failed
            return PaymentStatus.FAILED;
        }
    }

    /**
     * Synthesize a webhook event for the transaction status change.
     * This mimics what would happen with a real VNPay IPN webhook.
     */
    private void synthesizeWebhookEvent(PaymentTransaction transaction, VNPayService.VNPayQueryResult queryResult) {
        try {
            LOG.debug("Synthesizing webhook event for transaction {}: status={}", 
                transaction.getTransactionId(), transaction.getStatus());
            
            // Build webhook payload that mimics VNPay IPN format
            StringBuilder webhookPayload = new StringBuilder();
            webhookPayload.append("vnp_TxnRef=").append(transaction.getTransactionId());
            webhookPayload.append("&vnp_OrderInfo=").append("Payment for booking: " + transaction.getOrderRef());
            webhookPayload.append("&vnp_ResponseCode=").append(queryResult.getResponseCode());
            webhookPayload.append("&vnp_TransactionStatus=").append(queryResult.getTransactionStatus());
            
            if (queryResult.getAmount() != null) {
                // VNPay returns amount in the smallest currency unit (e.g., VND * 100)
                long amountInSmallestUnit = queryResult.getAmount().multiply(new java.math.BigDecimal("100")).longValue();
                webhookPayload.append("&vnp_Amount=").append(amountInSmallestUnit);
            }
            
            if (transaction.getGatewayCreateDate() != null) {
                webhookPayload.append("&vnp_PayDate=").append(transaction.getGatewayCreateDate());
            }
            
            webhookPayload.append("&vnp_BankCode=VNPAY");
            webhookPayload.append("&vnp_CardType=ATM");
            
            // Generate a synthetic signature (in real scenario this would come from VNPay)
            String syntheticSignature = "POLLING_SYNTHESIZED_" + System.currentTimeMillis();
            
            // Process the synthetic webhook through the existing payment service
            String result = paymentService.processWebhook("VNPAY", webhookPayload.toString(), syntheticSignature);
            
            LOG.info("Synthesized webhook processed for transaction {}: result={}", 
                transaction.getTransactionId(), result);
            
        } catch (Exception e) {
            LOG.error("Error synthesizing webhook event for transaction {}: {}", 
                transaction.getTransactionId(), e.getMessage(), e);
        }
    }

    /**
     * Manual trigger for polling a specific transaction (for testing/admin purposes).
     */
    @Transactional
    public boolean pollSpecificTransaction(String transactionId) {
        LOG.info("Manual polling triggered for transaction: {}", transactionId);
        
        return paymentTransactionRepository
            .findByTransactionIdAndIsDeletedFalseOrIsDeletedIsNull(transactionId)
            .map(transaction -> {
                if (transaction.getMethod() == PaymentMethod.VNPAY) {
                    return pollAndUpdateTransaction(transaction);
                } else {
                    LOG.warn("Transaction {} is not a VNPay transaction", transactionId);
                    return false;
                }
            })
            .orElse(false);
    }

    /**
     * Clean up old polling tracking data to prevent memory leaks.
     */
    @Scheduled(fixedRate = 3600000) // 1 hour
    public void cleanupPollingTracking() {
        LOG.debug("Cleaning up old polling tracking data");
        
        Instant cutoff = Instant.now().minus(2, ChronoUnit.HOURS);
        
        // Remove entries older than 2 hours
        pollingAttempts.entrySet().removeIf(entry -> {
            Instant lastPoll = lastPollTime.get(entry.getKey());
            return lastPoll == null || lastPoll.isBefore(cutoff);
        });
        
        lastPollTime.entrySet().removeIf(entry -> entry.getValue().isBefore(cutoff));
        
        LOG.debug("Polling tracking cleanup completed");
    }
}
