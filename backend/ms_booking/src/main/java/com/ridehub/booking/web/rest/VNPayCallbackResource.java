package com.ridehub.booking.web.rest;

import com.ridehub.booking.service.PaymentService;
import com.ridehub.booking.service.payment.vnpay.VNPayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
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

    public VNPayCallbackResource(PaymentService paymentService, VNPayService vnPayService) {
        this.paymentService = paymentService;
        this.vnPayService = vnPayService;
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
     */
    @GetMapping("/query/{transactionId}")
    public ResponseEntity<Map<String, Object>> queryTransaction(@PathVariable String transactionId) {
        LOG.debug("Querying VNPay transaction status: {}", transactionId);

        try {
            // This would typically involve calling VNPay's query API
            // For now, return a placeholder response
            Map<String, Object> response = new HashMap<>();
            response.put("transactionId", transactionId);
            response.put("status", "PENDING");
            response.put("message", "Transaction query not implemented yet");

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            LOG.error("Error querying VNPay transaction: {}", transactionId, e);
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "Internal server error");
            return ResponseEntity.internalServerError().body(errorResponse);
        }
    }
}
