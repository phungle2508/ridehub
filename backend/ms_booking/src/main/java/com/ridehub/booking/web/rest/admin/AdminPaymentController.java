package com.ridehub.booking.web.rest.admin;

import com.ridehub.booking.domain.PaymentTransaction;
import com.ridehub.booking.domain.enumeration.PaymentStatus;
import com.ridehub.booking.repository.PaymentTransactionRepository;
import com.ridehub.booking.service.PaymentGatewayService;
import com.ridehub.booking.web.rest.errors.BadRequestAlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.persistence.criteria.Predicate;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for admin payment management.
 */
@RestController
@RequestMapping("/api/admin/payments")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminPaymentController {

    private final Logger log = LoggerFactory.getLogger(AdminPaymentController.class);

    private static final String ENTITY_NAME = "paymentTransaction";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PaymentTransactionRepository paymentTransactionRepository;
    private final PaymentGatewayService paymentGatewayService;

    public AdminPaymentController(
        PaymentTransactionRepository paymentTransactionRepository,
        PaymentGatewayService paymentGatewayService
    ) {
        this.paymentTransactionRepository = paymentTransactionRepository;
        this.paymentGatewayService = paymentGatewayService;
    }

    /**
     * {@code GET  /api/admin/payments} : get all payment transactions with optional filtering.
     *
     * @param status the payment status to filter by (optional).
     * @param orderRef the order reference to filter by (optional).
     * @param bookingId the booking ID to filter by (optional).
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of payment transactions in body.
     */
    @GetMapping("")
    public ResponseEntity<Page<PaymentTransaction>> getAllPaymentTransactions(
        @RequestParam(required = false) PaymentStatus status,
        @RequestParam(required = false) String orderRef,
        @RequestParam(required = false) Long bookingId,
        Pageable pageable
    ) {
        log.debug("REST request to get PaymentTransactions with filters - status: {}, orderRef: {}, bookingId: {}", 
            status, orderRef, bookingId);

        Specification<PaymentTransaction> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();
            
            if (status != null) {
                predicates.add(criteriaBuilder.equal(root.get("status"), status));
            }
            
            if (orderRef != null && !orderRef.trim().isEmpty()) {
                predicates.add(criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("orderRef")), 
                    "%" + orderRef.toLowerCase() + "%"
                ));
            }
            
            if (bookingId != null) {
                predicates.add(criteriaBuilder.equal(root.get("booking").get("id"), bookingId));
            }
            
            // Exclude deleted transactions
            predicates.add(criteriaBuilder.or(
                criteriaBuilder.isNull(root.get("isDeleted")),
                criteriaBuilder.equal(root.get("isDeleted"), false)
            ));
            
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        Page<PaymentTransaction> transactions = paymentTransactionRepository.findAll(spec, pageable);
        return ResponseEntity.ok().body(transactions);
    }

    /**
     * {@code GET  /api/admin/payments/{id}} : get the payment transaction by id.
     *
     * @param id the id of the payment transaction to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the payment transaction.
     */
    @GetMapping("/{id}")
    public ResponseEntity<PaymentTransaction> getPaymentTransaction(@PathVariable Long id) {
        log.debug("REST request to get PaymentTransaction : {}", id);
        Optional<PaymentTransaction> paymentTransaction = paymentTransactionRepository.findById(id);
        return paymentTransaction.map(response -> ResponseEntity.ok().body(response))
            .orElse(ResponseEntity.notFound().build());
    }

    /**
     * {@code POST  /api/admin/payments/{id}/refund} : process a refund for a payment transaction.
     *
     * @param id the id of the payment transaction to refund.
     * @param refundRequest the refund request details.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)}.
     */
    @PostMapping("/{id}/refund")
    public ResponseEntity<RefundResponse> processRefund(
        @PathVariable Long id, 
        @RequestBody RefundRequest refundRequest
    ) {
        log.debug("REST request to refund PaymentTransaction : {}", id);

        PaymentTransaction transaction = paymentTransactionRepository.findById(id)
                .orElseThrow(() -> new BadRequestAlertException("Payment transaction not found", ENTITY_NAME, "transactionnotfound"));
        
        if (transaction.getStatus() != PaymentStatus.SUCCESS) {
            throw new BadRequestAlertException("Can only refund completed payments", ENTITY_NAME, "invalidstatus");
        }

        if (transaction.getStatus() == PaymentStatus.REFUNDED) {
            throw new BadRequestAlertException("Payment already refunded", ENTITY_NAME, "alreadyrefunded");
        }

        try {
            // Process refund through payment gateway
            PaymentGatewayService.RefundResult refundResult = paymentGatewayService.processRefund(
                transaction.getOrderRef(),
                refundRequest.getAmount(),
                refundRequest.getReason()
            );

            if (refundResult.isSuccess()) {
                // Update transaction status
                transaction.setStatus(PaymentStatus.REFUNDED);
                transaction.setUpdatedAt(Instant.now());
                paymentTransactionRepository.save(transaction);

                log.info("Successfully processed refund for transaction: {}", transaction.getOrderRef());
                
                RefundResponse response = new RefundResponse(
                    true,
                    refundResult.getRefundId(),
                    "Refund processed successfully"
                );
                return ResponseEntity.ok().body(response);
            } else {
                log.error("Refund failed for transaction: {}. Reason: {}", 
                    transaction.getOrderRef(), refundResult.getErrorMessage());
                
                RefundResponse response = new RefundResponse(
                    false,
                    null,
                    refundResult.getErrorMessage()
                );
                return ResponseEntity.badRequest().body(response);
            }

        } catch (Exception e) {
            log.error("Error processing refund for transaction: {}", transaction.getOrderRef(), e);
            throw new BadRequestAlertException("Failed to process refund", ENTITY_NAME, "refunderror");
        }
    }

    /**
     * Request class for refund operations.
     */
    public static class RefundRequest {
        private java.math.BigDecimal amount;
        private String reason;

        public java.math.BigDecimal getAmount() {
            return amount;
        }

        public void setAmount(java.math.BigDecimal amount) {
            this.amount = amount;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }
    }

    /**
     * Response class for refund operations.
     */
    public static class RefundResponse {
        private boolean success;
        private String refundId;
        private String message;

        public RefundResponse(boolean success, String refundId, String message) {
            this.success = success;
            this.refundId = refundId;
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getRefundId() {
            return refundId;
        }

        public void setRefundId(String refundId) {
            this.refundId = refundId;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
