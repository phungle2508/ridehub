package com.ridehub.booking.web.rest;

import com.ridehub.booking.domain.PaymentWebhookLog;
import com.ridehub.booking.repository.PaymentWebhookLogRepository;
import com.ridehub.booking.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * REST controller for handling Payment Webhooks.
 */
@RestController
@RequestMapping("/api")
public class PaymentWebhookResource {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentWebhookResource.class);

    private final PaymentService paymentService;
    private final PaymentWebhookLogRepository paymentWebhookLogRepository;

    public PaymentWebhookResource(PaymentService paymentService, PaymentWebhookLogRepository paymentWebhookLogRepository) {
        this.paymentService = paymentService;
        this.paymentWebhookLogRepository = paymentWebhookLogRepository;
    }

    /**
     * {@code POST /payments/webhook/{provider}} : Handle payment webhook from gateway.
     *
     * @param provider the payment provider (e.g., vnpay, momo)
     * @param payload the request body containing the webhook data
     * @param signature the signature from the gateway for verification
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and a result message.
     */
    @PostMapping("/payments/webhook/{provider}")
    public ResponseEntity<String> handleWebhook(
            @PathVariable String provider,
            @RequestBody String payload,
            @RequestHeader(value = "X-Signature", required = false) String signature) {
        
        LOG.debug("Received webhook from provider: {}", provider);
        
        String result = paymentService.processWebhook(provider, payload, signature);
        
        return ResponseEntity.ok(result);
    }

    /**
     * {@code GET /admin/webhooks} : get all webhook logs for admin.
     *
     * @param provider the payment provider to filter by (optional).
     * @param status the webhook status to filter by (optional).
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of webhook logs in body.
     */
    @GetMapping("/admin/webhooks")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Page<PaymentWebhookLog>> getWebhookLogs(
        @RequestParam(required = false) String provider,
        @RequestParam(required = false) String status,
        Pageable pageable
    ) {
        LOG.debug("REST request to get PaymentWebhookLogs with filters - provider: {}, status: {}",
            provider, status);

        Specification<PaymentWebhookLog> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (provider != null && !provider.trim().isEmpty()) {
                predicates.add(criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("provider")),
                    "%" + provider.toLowerCase() + "%"
                ));
            }

            if (status != null && !status.trim().isEmpty()) {
                predicates.add(criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("status")),
                    "%" + status.toLowerCase() + "%"
                ));
            }

            // Exclude deleted logs
            predicates.add(criteriaBuilder.or(
                criteriaBuilder.isNull(root.get("isDeleted")),
                criteriaBuilder.equal(root.get("isDeleted"), false)
            ));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        Page<PaymentWebhookLog> webhookLogs = paymentWebhookLogRepository.findAll(spec, pageable);
        return ResponseEntity.ok().body(webhookLogs);
    }
}
