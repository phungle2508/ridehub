package com.ridehub.booking.web.rest;

import com.ridehub.booking.service.PaymentService;
import com.ridehub.booking.service.payment.zalopay.ZaloPayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * REST controller for handling ZaloPay callbacks and webhooks.
 */
@RestController
@RequestMapping("/api/payment/zalopay")
public class ZaloPayCallbackResource {

    private static final Logger LOG = LoggerFactory.getLogger(ZaloPayCallbackResource.class);

    private final PaymentService paymentService;
    private final ZaloPayService zaloPayService;

    public ZaloPayCallbackResource(PaymentService paymentService, ZaloPayService zaloPayService) {
        this.paymentService = paymentService;
        this.zaloPayService = zaloPayService;
    }

    /**
     * Handle ZaloPay return callback (user redirected back to merchant site)
     */
    @GetMapping("/callback")
    public ResponseEntity<Map<String, Object>> handleCallback(HttpServletRequest request) {
        LOG.debug("Received ZaloPay callback");

        try {
            // Extract all parameters from the request
            Map<String, String> params = new HashMap<>();
            request.getParameterMap().forEach((key, values) -> {
                if (values.length > 0) {
                    params.put(key, values[0]);
                }
            });

            // Verify the callback
            ZaloPayService.ZaloPayCallbackResult result = zaloPayService.verifyCallback(params);

            Map<String, Object> response = new HashMap<>();
            if (result.isValid()) {
                response.put("status", "success");
                response.put("message", result.getMessage());
                response.put("transactionId", result.getTransactionId());
                response.put("paymentStatus", result.getStatus());
                
                LOG.info("ZaloPay callback verified successfully for transaction: {}", result.getTransactionId());
            } else {
                response.put("status", "error");
                response.put("message", result.getMessage());
                
                LOG.warn("ZaloPay callback verification failed: {}", result.getMessage());
            }

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            LOG.error("Error processing ZaloPay callback", e);
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "Internal server error");
            return ResponseEntity.internalServerError().body(errorResponse);
        }
    }

    /**
     * Handle ZaloPay IPN (Instant Payment Notification) webhook
     */
    @PostMapping("/webhook")
    public ResponseEntity<String> handleWebhook(@RequestBody String payload,
                                                @RequestHeader(value = "X-Signature", required = false) String signature) {
        LOG.debug("Received ZaloPay webhook");

        try {
            String result = paymentService.processWebhook("ZALOPAY", payload, signature);
            
            if ("SUCCESS".equals(result)) {
                return ResponseEntity.ok("OK");
            } else if ("ALREADY_PROCESSED".equals(result)) {
                return ResponseEntity.ok("ALREADY_PROCESSED");
            } else {
                return ResponseEntity.badRequest().body(result);
            }

        } catch (Exception e) {
            LOG.error("Error processing ZaloPay webhook", e);
            return ResponseEntity.internalServerError().body("ERROR");
        }
    }

    /**
     * Handle ZaloPay query transaction status
     */
    @GetMapping("/query/{transactionId}")
    public ResponseEntity<Map<String, Object>> queryTransaction(@PathVariable String transactionId) {
        LOG.debug("Querying ZaloPay transaction status: {}", transactionId);

        try {
            // This would typically involve calling ZaloPay's query API
            // For now, return a placeholder response
            Map<String, Object> response = new HashMap<>();
            response.put("transactionId", transactionId);
            response.put("status", "PENDING");
            response.put("message", "Transaction query not implemented yet");

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            LOG.error("Error querying ZaloPay transaction: {}", transactionId, e);
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "Internal server error");
            return ResponseEntity.internalServerError().body(errorResponse);
        }
    }

    /**
     * Handle ZaloPay refund request
     */
    @PostMapping("/refund")
    public ResponseEntity<Map<String, Object>> processRefund(@RequestBody Map<String, Object> refundRequest) {
        LOG.debug("Processing ZaloPay refund request");

        try {
            // This would typically involve calling ZaloPay's refund API
            // For now, return a placeholder response
            Map<String, Object> response = new HashMap<>();
            response.put("status", "pending");
            response.put("message", "Refund request submitted");
            response.put("refundId", "REF-" + System.currentTimeMillis());

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            LOG.error("Error processing ZaloPay refund", e);
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "Internal server error");
            return ResponseEntity.internalServerError().body(errorResponse);
        }
    }
}
