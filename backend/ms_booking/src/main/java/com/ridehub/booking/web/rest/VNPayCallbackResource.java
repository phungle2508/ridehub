package com.ridehub.booking.web.rest;

import com.ridehub.booking.domain.PaymentTransaction;
import com.ridehub.booking.repository.PaymentTransactionRepository;
import com.ridehub.booking.service.PaymentService;
import com.ridehub.booking.service.VNPayPollingService;
import com.ridehub.booking.service.payment.vnpay.VNPayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * REST controller for handling VNPay callbacks and webhooks.
 */
@RestController
@RequestMapping("/api/payment/vnpay")
public class VNPayCallbackResource {

    private static final Logger LOG = LoggerFactory.getLogger(VNPayCallbackResource.class);

    private final PaymentService paymentService;
    private final VNPayService vnPayService;
    private final VNPayPollingService vnPayPollingService;
    private final PaymentTransactionRepository paymentTransactionRepository;

    public VNPayCallbackResource(PaymentService paymentService, VNPayService vnPayService, VNPayPollingService vnPayPollingService, PaymentTransactionRepository paymentTransactionRepository) {
        this.paymentService = paymentService;
        this.vnPayService = vnPayService;
        this.vnPayPollingService = vnPayPollingService;
        this.paymentTransactionRepository = paymentTransactionRepository;
    }

    /**
     * Handle VNPay return callback (user redirected back to merchant site)
     */
    @GetMapping("/callback")
    public ResponseEntity<Map<String, Object>> handleCallback(HttpServletRequest request) {
        LOG.debug("Received VNPay callback");

        try {
            // Extract all parameters from the request
            Map<String, String> params = new HashMap<>();
            request.getParameterMap().forEach((key, values) -> {
                if (values.length > 0) {
                    params.put(key, values[0]);
                }
            });

            // Verify the callback
            VNPayService.VNPayCallbackResult result = vnPayService.verifyCallback(params);

            Map<String, Object> response = new HashMap<>();
            if (result.isValid()) {
                response.put("status", "success");
                response.put("message", result.getMessage());
                response.put("transactionId", result.getTransactionId());
                response.put("paymentStatus", result.getStatus());
                
                LOG.info("VNPay callback verified successfully for transaction: {}", result.getTransactionId());
            } else {
                response.put("status", "error");
                response.put("message", result.getMessage());
                
                LOG.warn("VNPay callback verification failed: {}", result.getMessage());
            }

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            LOG.error("Error processing VNPay callback", e);
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "Internal server error");
            return ResponseEntity.internalServerError().body(errorResponse);
        }
    }

    /**
     * Handle VNPay IPN (Instant Payment Notification) webhook
     */
    @PostMapping("/webhook")
    public ResponseEntity<String> handleWebhook(@RequestBody String payload,
                                                @RequestHeader(value = "X-Signature", required = false) String signature) {
        LOG.debug("Received VNPay webhook");

        try {
            String result = paymentService.processWebhook("VNPAY", payload, signature);
            
            if ("SUCCESS".equals(result)) {
                return ResponseEntity.ok("OK");
            } else if ("ALREADY_PROCESSED".equals(result)) {
                return ResponseEntity.ok("ALREADY_PROCESSED");
            } else {
                return ResponseEntity.badRequest().body(result);
            }

        } catch (Exception e) {
            LOG.error("Error processing VNPay webhook", e);
            return ResponseEntity.internalServerError().body("ERROR");
        }
    }

    /**
     * Handle VNPay query transaction status
     * This endpoint is used for reconciliation and manual transaction status checking
     * Now gets transactionDate and orderRef from database instead of parameters
     */
    @GetMapping("/query/{transactionId}")
    public ResponseEntity<Map<String, Object>> queryTransaction(@PathVariable String transactionId,
                                                                HttpServletRequest request) {
        LOG.debug("Querying VNPay transaction status: {}", transactionId);

        try {
            // Get transaction from database to obtain orderRef and transactionDate
            PaymentTransaction transaction = paymentTransactionRepository
                .findByTransactionIdAndIsDeletedFalseOrIsDeletedIsNull(transactionId)
                .orElse(null);

            if (transaction == null) {
                Map<String, Object> errorResponse = new HashMap<>();
                errorResponse.put("transactionId", transactionId);
                errorResponse.put("success", false);
                errorResponse.put("responseCode", "01");
                errorResponse.put("message", "Transaction not found in database");
                errorResponse.put("paymentMethod", "VNPAY");
                errorResponse.put("queryTime", System.currentTimeMillis());
                errorResponse.put("canSynthesizeWebhook", false);
                return ResponseEntity.status(404).body(errorResponse);
            }

            String ipAddress = getClientIpAddress(request);
            String orderRef = transaction.getOrderRef();
            
            // Use new method that gets data from PaymentTransaction object
            VNPayService.VNPayQueryResult result = vnPayService.queryTransaction(transaction, ipAddress);

            Map<String, Object> response = new HashMap<>();
            response.put("transactionId", transactionId);
            response.put("orderRef", orderRef);
            response.put("success", result.isSuccess());
            response.put("responseCode", result.getResponseCode());
            response.put("message", result.getMessage());
            response.put("transactionStatus", result.getTransactionStatus());
            response.put("amount", result.getAmount());
            response.put("paymentMethod", "VNPAY");
            response.put("queryTime", System.currentTimeMillis());

            // Add additional fields for reconciliation
            if (result.isSuccess()) {
                response.put("canSynthesizeWebhook", true);
                Map<String, Object> reconciliationData = new HashMap<>();
                reconciliationData.put("gatewayStatus", result.getTransactionStatus());
                reconciliationData.put("amount", result.getAmount());
                reconciliationData.put("transactionId", transactionId);
                reconciliationData.put("orderRef", orderRef);
                reconciliationData.put("responseCode", result.getResponseCode());
                response.put("reconciliationData", reconciliationData);
                return ResponseEntity.ok(response);
            } else {
                response.put("canSynthesizeWebhook", false);
                return ResponseEntity.badRequest().body(response);
            }

        } catch (Exception e) {
            LOG.error("Error querying VNPay transaction: {}", transactionId, e);
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("transactionId", transactionId);
            errorResponse.put("success", false);
            errorResponse.put("responseCode", "99");
            errorResponse.put("message", "Internal server error: " + e.getMessage());
            errorResponse.put("paymentMethod", "VNPAY");
            errorResponse.put("queryTime", System.currentTimeMillis());
            errorResponse.put("canSynthesizeWebhook", false);
            return ResponseEntity.internalServerError().body(errorResponse);
        }
    }

    /**
     * Handle VNPay refund transaction
     */
    @PostMapping("/refund/{transactionId}")
    public ResponseEntity<Map<String, Object>> refundTransaction(@PathVariable String transactionId,
                                                                  @RequestBody Map<String, Object> refundRequest,
                                                                  HttpServletRequest request) {
        LOG.debug("Refunding VNPay transaction: {}", transactionId);

        try {
            String ipAddress = getClientIpAddress(request);
            BigDecimal amount = refundRequest.containsKey("amount") ? 
                new BigDecimal(refundRequest.get("amount").toString()) : null;
            String orderInfo = refundRequest.containsKey("orderInfo") ? 
                refundRequest.get("orderInfo").toString() : null;
            String transactionType = refundRequest.containsKey("transactionType") ? 
                refundRequest.get("transactionType").toString() : null;

            if (amount == null) {
                Map<String, Object> errorResponse = new HashMap<>();
                errorResponse.put("success", false);
                errorResponse.put("responseCode", "03");
                errorResponse.put("message", "Amount is required");
                return ResponseEntity.badRequest().body(errorResponse);
            }

            VNPayService.VNPayRefundResult result = vnPayService.refundTransaction(
                transactionId, amount, ipAddress, orderInfo, transactionType);

            Map<String, Object> response = new HashMap<>();
            response.put("transactionId", transactionId);
            response.put("success", result.isSuccess());
            response.put("responseCode", result.getResponseCode());
            response.put("message", result.getMessage());
            response.put("transactionNo", result.getTransactionNo());
            response.put("transactionType", result.getTransactionType());
            response.put("transactionStatus", result.getTransactionStatus());

            if (result.isSuccess()) {
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.badRequest().body(response);
            }

        } catch (Exception e) {
            LOG.error("Error refunding VNPay transaction: {}", transactionId, e);
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("success", false);
            errorResponse.put("responseCode", "99");
            errorResponse.put("message", "Internal server error: " + e.getMessage());
            return ResponseEntity.internalServerError().body(errorResponse);
        }
    }

    /**
     * Manually trigger polling for a specific transaction
     * This endpoint is useful for testing and admin purposes when IPN is not available
     */
    @PostMapping("/poll/{transactionId}")
    public ResponseEntity<Map<String, Object>> pollTransaction(@PathVariable String transactionId) {
        LOG.info("Manual polling triggered for transaction: {}", transactionId);

        try {
            boolean updated = vnPayPollingService.pollSpecificTransaction(transactionId);
            
            Map<String, Object> response = new HashMap<>();
            response.put("transactionId", transactionId);
            response.put("polled", true);
            response.put("updated", updated);
            response.put("timestamp", System.currentTimeMillis());
            
            if (updated) {
                response.put("message", "Transaction status updated successfully");
                return ResponseEntity.ok(response);
            } else {
                response.put("message", "Transaction polled but no status change detected or transaction not found");
                return ResponseEntity.ok(response);
            }

        } catch (Exception e) {
            LOG.error("Error manually polling VNPay transaction: {}", transactionId, e);
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("transactionId", transactionId);
            errorResponse.put("polled", false);
            errorResponse.put("updated", false);
            errorResponse.put("message", "Error polling transaction: " + e.getMessage());
            errorResponse.put("timestamp", System.currentTimeMillis());
            return ResponseEntity.internalServerError().body(errorResponse);
        }
    }

    /**
     * Get client IP address
     */
    private String getClientIpAddress(HttpServletRequest request) {
        String xForwardedFor = request.getHeader("X-Forwarded-For");
        if (xForwardedFor != null && !xForwardedFor.isEmpty() && !"unknown".equalsIgnoreCase(xForwardedFor)) {
            return xForwardedFor.split(",")[0].trim();
        }
        
        String xRealIp = request.getHeader("X-Real-IP");
        if (xRealIp != null && !xRealIp.isEmpty() && !"unknown".equalsIgnoreCase(xRealIp)) {
            return xRealIp;
        }
        
        return request.getRemoteAddr();
    }
}
