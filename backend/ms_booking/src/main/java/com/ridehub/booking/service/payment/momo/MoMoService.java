package com.ridehub.booking.service.payment.momo;

import com.ridehub.booking.service.vm.InitiatePaymentRequestVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * MoMo payment service implementation
 */
@Service
public class MoMoService {
    
    private static final Logger LOG = LoggerFactory.getLogger(MoMoService.class);
    
    private final MoMoConfig moMoConfig;
    private final RestTemplate restTemplate;
    
    public MoMoService(MoMoConfig moMoConfig) {
        this.moMoConfig = moMoConfig;
        this.restTemplate = new RestTemplate();
    }
    
    /**
     * Create MoMo payment URL
     */
    public String createPaymentUrl(InitiatePaymentRequestVM request, String transactionId, 
                                   String orderRef, BigDecimal amount) {
        LOG.debug("Creating MoMo payment URL for transaction: {}", transactionId);
        
        try {
            String requestId = MoMoUtils.generateRequestId();
            String orderId = transactionId;
            String amountStr = String.valueOf(amount.longValue());
            String extraData = "";
            
            // Build signature string
            String signatureString = MoMoUtils.buildSignatureString(
                moMoConfig.getAccessKey(),
                amountStr,
                extraData,
                moMoConfig.getNotifyUrl(),
                orderId,
                moMoConfig.getOrderInfo() + " " + orderRef,
                moMoConfig.getPartnerCode(),
                request.getReturnUrl(),
                requestId,
                moMoConfig.getRequestType()
            );
            
            // Generate signature
            String signature = MoMoUtils.generateSignature(signatureString, moMoConfig.getSecretKey());
            
            // Prepare request body
            Map<String, Object> requestBody = new HashMap<>();
            requestBody.put("partnerCode", moMoConfig.getPartnerCode());
            requestBody.put("accessKey", moMoConfig.getAccessKey());
            requestBody.put("requestId", requestId);
            requestBody.put("amount", amountStr);
            requestBody.put("orderId", orderId);
            requestBody.put("orderInfo", moMoConfig.getOrderInfo() + " " + orderRef);
            requestBody.put("redirectUrl", request.getReturnUrl());
            requestBody.put("ipnUrl", moMoConfig.getNotifyUrl());
            requestBody.put("extraData", extraData);
            requestBody.put("requestType", moMoConfig.getRequestType());
            requestBody.put("signature", signature);
            requestBody.put("lang", moMoConfig.getLang());
            
            // Make API call to MoMo
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            
            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);
            ResponseEntity<Map> response = restTemplate.postForEntity(moMoConfig.getEndpoint(), entity, Map.class);
            
            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                Map<String, Object> responseBody = response.getBody();
                Integer resultCode = (Integer) responseBody.get("resultCode");
                
                if (MoMoUtils.isSuccessResponse(resultCode)) {
                    String payUrl = (String) responseBody.get("payUrl");
                    LOG.debug("MoMo payment URL created successfully for transaction: {}", transactionId);
                    return payUrl;
                } else {
                    String message = (String) responseBody.get("message");
                    throw new RuntimeException("MoMo API error: " + message);
                }
            } else {
                throw new RuntimeException("Failed to call MoMo API");
            }
            
        } catch (Exception e) {
            LOG.error("Error creating MoMo payment URL for transaction: {}", transactionId, e);
            throw new RuntimeException("Failed to create MoMo payment URL", e);
        }
    }
    
    /**
     * Verify MoMo callback/webhook
     */
    public MoMoCallbackResult verifyCallback(Map<String, String> params) {
        LOG.debug("Verifying MoMo callback");
        
        try {
            String signature = params.get("signature");
            String partnerCode = params.get("partnerCode");
            String accessKey = params.get("accessKey");
            String requestId = params.get("requestId");
            String amount = params.get("amount");
            String orderId = params.get("orderId");
            String orderInfo = params.get("orderInfo");
            String orderType = params.get("orderType");
            String transId = params.get("transId");
            String resultCode = params.get("resultCode");
            String message = params.get("message");
            String payType = params.get("payType");
            String responseTime = params.get("responseTime");
            String extraData = params.get("extraData");
            
            // Build signature string for verification
            String signatureString = "accessKey=" + accessKey +
                    "&amount=" + amount +
                    "&extraData=" + extraData +
                    "&message=" + message +
                    "&orderId=" + orderId +
                    "&orderInfo=" + orderInfo +
                    "&orderType=" + orderType +
                    "&partnerCode=" + partnerCode +
                    "&payType=" + payType +
                    "&requestId=" + requestId +
                    "&responseTime=" + responseTime +
                    "&resultCode=" + resultCode +
                    "&transId=" + transId;
            
            // Verify signature
            if (!MoMoUtils.verifySignature(signatureString, signature, moMoConfig.getSecretKey())) {
                LOG.warn("Invalid MoMo callback signature");
                return new MoMoCallbackResult(false, null, null, "Invalid signature");
            }
            
            int resultCodeInt = Integer.parseInt(resultCode);
            String status = MoMoUtils.mapResultCodeToStatus(resultCodeInt);
            
            LOG.debug("MoMo callback verified - Status: {}, Transaction: {}", status, orderId);
            
            return new MoMoCallbackResult(true, orderId, status, message);
            
        } catch (Exception e) {
            LOG.error("Error verifying MoMo callback", e);
            return new MoMoCallbackResult(false, null, null, "Verification error: " + e.getMessage());
        }
    }
    
    /**
     * Parse MoMo webhook payload
     */
    public MoMoWebhookData parseWebhookPayload(String payload) {
        LOG.debug("Parsing MoMo webhook payload");
        
        try {
            Map<String, Object> data = MoMoUtils.parseJson(payload);
            
            String transactionId = (String) data.get("orderId");
            Integer resultCode = (Integer) data.get("resultCode");
            String amountStr = String.valueOf(data.get("amount"));
            
            String status = MoMoUtils.mapResultCodeToStatus(resultCode);
            BigDecimal amount = new BigDecimal(amountStr);
            
            return new MoMoWebhookData(transactionId, status, amount, data);
            
        } catch (Exception e) {
            LOG.error("Error parsing MoMo webhook payload", e);
            throw new RuntimeException("Failed to parse MoMo webhook payload", e);
        }
    }
    
    /**
     * MoMo callback result
     */
    public static class MoMoCallbackResult {
        private final boolean valid;
        private final String transactionId;
        private final String status;
        private final String message;
        
        public MoMoCallbackResult(boolean valid, String transactionId, String status, String message) {
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
     * MoMo webhook data
     */
    public static class MoMoWebhookData {
        private final String transactionId;
        private final String status;
        private final BigDecimal amount;
        private final Map<String, Object> rawData;
        
        public MoMoWebhookData(String transactionId, String status, BigDecimal amount, Map<String, Object> rawData) {
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
