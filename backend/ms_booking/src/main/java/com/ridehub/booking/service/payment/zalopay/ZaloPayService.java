package com.ridehub.booking.service.payment.zalopay;

import com.ridehub.booking.service.vm.InitiatePaymentRequestVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * ZaloPay payment service implementation
 */
@Service
public class ZaloPayService {
    
    private static final Logger LOG = LoggerFactory.getLogger(ZaloPayService.class);
    
    private final ZaloPayConfig zaloPayConfig;
    private final RestTemplate restTemplate;
    
    public ZaloPayService(ZaloPayConfig zaloPayConfig) {
        this.zaloPayConfig = zaloPayConfig;
        this.restTemplate = new RestTemplate();
    }
    
    /**
     * Create ZaloPay payment URL
     */
    public String createPaymentUrl(InitiatePaymentRequestVM request, String transactionId, 
                                   String orderRef, BigDecimal amount) {
        LOG.debug("Creating ZaloPay payment URL for transaction: {}", transactionId);
        
        try {
            String appTransId = ZaloPayUtils.generateTransId(zaloPayConfig.getAppId());
            String appTime = String.valueOf(ZaloPayUtils.getCurrentTimestamp());
            String amountStr = String.valueOf(amount.longValue());
            
            // Build signature string
            String signatureData = ZaloPayUtils.buildCreateOrderSignature(
                zaloPayConfig.getAppId(),
                appTransId,
                "user_" + transactionId,
                amountStr,
                appTime,
                zaloPayConfig.getEmbedData(),
                zaloPayConfig.getItemData()
            );
            
            // Generate signature
            String mac = ZaloPayUtils.generateSignature(signatureData, zaloPayConfig.getKey1());
            
            // Prepare request parameters
            MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
            params.add("app_id", zaloPayConfig.getAppId());
            params.add("app_user", "user_" + transactionId);
            params.add("app_trans_id", appTransId);
            params.add("app_time", appTime);
            params.add("amount", amountStr);
            params.add("item", zaloPayConfig.getItemData());
            params.add("embed_data", zaloPayConfig.getEmbedData());
            params.add("bank_code", zaloPayConfig.getBankCode());
            params.add("description", zaloPayConfig.getDescription() + " " + orderRef);
            params.add("mac", mac);
            params.add("callback_url", zaloPayConfig.getCallbackUrl());
            
            // Make API call to ZaloPay
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            
            HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(params, headers);
            ResponseEntity<Map> response = restTemplate.postForEntity(zaloPayConfig.getEndpoint(), entity, Map.class);
            
            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                Map<String, Object> responseBody = response.getBody();
                Integer returnCode = (Integer) responseBody.get("return_code");
                
                if (ZaloPayUtils.isSuccessResponse(returnCode)) {
                    String orderUrl = (String) responseBody.get("order_url");
                    LOG.debug("ZaloPay payment URL created successfully for transaction: {}", transactionId);
                    return orderUrl;
                } else {
                    String returnMessage = (String) responseBody.get("return_message");
                    throw new RuntimeException("ZaloPay API error: " + returnMessage);
                }
            } else {
                throw new RuntimeException("Failed to call ZaloPay API");
            }
            
        } catch (Exception e) {
            LOG.error("Error creating ZaloPay payment URL for transaction: {}", transactionId, e);
            throw new RuntimeException("Failed to create ZaloPay payment URL", e);
        }
    }
    
    /**
     * Verify ZaloPay callback/webhook
     */
    public ZaloPayCallbackResult verifyCallback(Map<String, String> params) {
        LOG.debug("Verifying ZaloPay callback");
        
        try {
            String mac = params.get("mac");
            String appId = params.get("app_id");
            String appTransId = params.get("app_trans_id");
            String pmcId = params.get("pmc_id");
            String bankCode = params.get("bank_code");
            String amount = params.get("amount");
            String discountAmount = params.get("discount_amount");
            String status = params.get("status");
            
            // Build signature string for verification
            String signatureData = ZaloPayUtils.buildCallbackSignature(
                appId, appTransId, pmcId, bankCode, amount, discountAmount, status
            );
            
            // Verify signature
            if (!ZaloPayUtils.verifyCallbackSignature(signatureData, mac, zaloPayConfig.getKey2())) {
                LOG.warn("Invalid ZaloPay callback signature");
                return new ZaloPayCallbackResult(false, null, null, "Invalid signature");
            }
            
            int statusInt = Integer.parseInt(status);
            String paymentStatus = ZaloPayUtils.mapStatusToPaymentStatus(statusInt);
            
            LOG.debug("ZaloPay callback verified - Status: {}, Transaction: {}", paymentStatus, appTransId);
            
            return new ZaloPayCallbackResult(true, appTransId, paymentStatus, "Callback verified");
            
        } catch (Exception e) {
            LOG.error("Error verifying ZaloPay callback", e);
            return new ZaloPayCallbackResult(false, null, null, "Verification error: " + e.getMessage());
        }
    }
    
    /**
     * Parse ZaloPay webhook payload
     */
    public ZaloPayWebhookData parseWebhookPayload(String payload) {
        LOG.debug("Parsing ZaloPay webhook payload");
        
        try {
            Map<String, Object> data = ZaloPayUtils.parseJson(payload);
            
            String appTransId = (String) data.get("app_trans_id");
            Integer status = (Integer) data.get("status");
            String amountStr = String.valueOf(data.get("amount"));
            
            String paymentStatus = ZaloPayUtils.mapStatusToPaymentStatus(status);
            BigDecimal amount = new BigDecimal(amountStr);
            
            return new ZaloPayWebhookData(appTransId, paymentStatus, amount, data);
            
        } catch (Exception e) {
            LOG.error("Error parsing ZaloPay webhook payload", e);
            throw new RuntimeException("Failed to parse ZaloPay webhook payload", e);
        }
    }
    
    /**
     * ZaloPay callback result
     */
    public static class ZaloPayCallbackResult {
        private final boolean valid;
        private final String transactionId;
        private final String status;
        private final String message;
        
        public ZaloPayCallbackResult(boolean valid, String transactionId, String status, String message) {
            this.valid = valid;
            this.transactionId = transactionId;
            this.status = status;
            this.message = message;
        }
        
        public boolean isValid() { return valid; }
        public String getTransactionId() { return transactionId; }
        public String getStatus() { return status; }
        public String getMessage() { return message; }
    }
    
    /**
     * ZaloPay webhook data
     */
    public static class ZaloPayWebhookData {
        private final String transactionId;
        private final String status;
        private final BigDecimal amount;
        private final Map<String, Object> rawData;
        
        public ZaloPayWebhookData(String transactionId, String status, BigDecimal amount, Map<String, Object> rawData) {
            this.transactionId = transactionId;
            this.status = status;
            this.amount = amount;
            this.rawData = rawData;
        }
        
        public String getTransactionId() { return transactionId; }
        public String getStatus() { return status; }
        public BigDecimal getAmount() { return amount; }
        public Map<String, Object> getRawData() { return rawData; }
    }
}
