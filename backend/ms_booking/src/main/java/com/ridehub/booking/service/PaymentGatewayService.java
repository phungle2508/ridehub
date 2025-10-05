package com.ridehub.booking.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Service for integrating with payment gateway for refund operations.
 */
@Service
public class PaymentGatewayService {

    private final Logger log = LoggerFactory.getLogger(PaymentGatewayService.class);

    private final RestTemplate restTemplate;

    @Value("${app.payment-gateway.base-url:http://localhost:8082}")
    private String paymentGatewayBaseUrl;

    @Value("${app.payment-gateway.api-key:}")
    private String apiKey;

    public PaymentGatewayService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Process a refund through the payment gateway.
     * 
     * @param orderRef the original order reference
     * @param amount the refund amount
     * @param reason the reason for refund
     * @return RefundResult containing success status and details
     */
    public RefundResult processRefund(String orderRef, BigDecimal amount, String reason) {
        log.debug("Processing refund for order: {}, amount: {}, reason: {}", orderRef, amount, reason);
        
        try {
            String url = paymentGatewayBaseUrl + "/refunds";
            
            // Prepare request body
            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("orderRef", orderRef);
            requestBody.put("amount", amount);
            requestBody.put("reason", reason != null ? reason : "Admin refund");
            
            // Set headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            if (apiKey != null && !apiKey.isEmpty()) {
                headers.set("Authorization", "Bearer " + apiKey);
            }
            
            HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);
            
            // Make the request
            ResponseEntity<Map> response = restTemplate.exchange(
                url, 
                HttpMethod.POST, 
                request, 
                Map.class
            );
            
            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                Map<String, Object> responseBody = response.getBody();
                String refundId = (String) responseBody.get("refundId");
                String status = (String) responseBody.get("status");
                
                if ("SUCCESS".equals(status) || "COMPLETED".equals(status)) {
                    log.info("Successfully processed refund for order: {}. Refund ID: {}", orderRef, refundId);
                    return new RefundResult(true, refundId, null);
                } else {
                    String errorMessage = (String) responseBody.get("message");
                    log.warn("Refund failed for order: {}. Status: {}, Message: {}", orderRef, status, errorMessage);
                    return new RefundResult(false, null, errorMessage);
                }
            } else {
                log.error("Unexpected response when processing refund for order: {}. Status: {}", 
                    orderRef, response.getStatusCode());
                return new RefundResult(false, null, "Unexpected response from payment gateway");
            }
            
        } catch (RestClientException e) {
            log.error("Failed to process refund for order: {} due to communication error", orderRef, e);
            return new RefundResult(false, null, "Communication error with payment gateway");
        } catch (Exception e) {
            log.error("Unexpected error when processing refund for order: {}", orderRef, e);
            return new RefundResult(false, null, "Unexpected error occurred");
        }
    }

    /**
     * Check refund status by refund ID.
     * 
     * @param refundId the refund ID to check
     * @return RefundStatus containing current status
     */
    public RefundStatus checkRefundStatus(String refundId) {
        log.debug("Checking refund status for refund ID: {}", refundId);
        
        try {
            String url = paymentGatewayBaseUrl + "/refunds/" + refundId + "/status";
            
            HttpHeaders headers = new HttpHeaders();
            if (apiKey != null && !apiKey.isEmpty()) {
                headers.set("Authorization", "Bearer " + apiKey);
            }
            
            HttpEntity<Void> request = new HttpEntity<>(headers);
            
            ResponseEntity<Map> response = restTemplate.exchange(
                url, 
                HttpMethod.GET, 
                request, 
                Map.class
            );
            
            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                Map<String, Object> responseBody = response.getBody();
                String status = (String) responseBody.get("status");
                BigDecimal amount = new BigDecimal(responseBody.get("amount").toString());
                
                return new RefundStatus(refundId, status, amount);
            } else {
                log.error("Failed to check refund status for refund ID: {}. Status: {}", 
                    refundId, response.getStatusCode());
                return new RefundStatus(refundId, "UNKNOWN", null);
            }
            
        } catch (RestClientException e) {
            log.error("Failed to check refund status for refund ID: {} due to communication error", refundId, e);
            return new RefundStatus(refundId, "ERROR", null);
        } catch (Exception e) {
            log.error("Unexpected error when checking refund status for refund ID: {}", refundId, e);
            return new RefundStatus(refundId, "ERROR", null);
        }
    }

    /**
     * Simulate refund processing for testing purposes.
     * This method can be used when no actual payment gateway is available.
     */
    public RefundResult simulateRefund(String orderRef, BigDecimal amount, String reason) {
        log.info("Simulating refund for order: {}, amount: {}", orderRef, amount);
        
        // Simulate processing delay
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Generate a mock refund ID
        String refundId = "REF-" + System.currentTimeMillis();
        
        // Simulate success (90% success rate for testing)
        boolean success = Math.random() < 0.9;
        
        if (success) {
            return new RefundResult(true, refundId, null);
        } else {
            return new RefundResult(false, null, "Simulated refund failure");
        }
    }

    /**
     * Result class for refund operations.
     */
    public static class RefundResult {
        private final boolean success;
        private final String refundId;
        private final String errorMessage;

        public RefundResult(boolean success, String refundId, String errorMessage) {
            this.success = success;
            this.refundId = refundId;
            this.errorMessage = errorMessage;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getRefundId() {
            return refundId;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }

    /**
     * Status class for refund status checks.
     */
    public static class RefundStatus {
        private final String refundId;
        private final String status;
        private final BigDecimal amount;

        public RefundStatus(String refundId, String status, BigDecimal amount) {
            this.refundId = refundId;
            this.status = status;
            this.amount = amount;
        }

        public String getRefundId() {
            return refundId;
        }

        public String getStatus() {
            return status;
        }

        public BigDecimal getAmount() {
            return amount;
        }
    }
}
