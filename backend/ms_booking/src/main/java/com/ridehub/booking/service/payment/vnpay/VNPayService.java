package com.ridehub.booking.service.payment.vnpay;

import com.ridehub.booking.service.vm.InitiatePaymentRequestVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * VNPay payment service implementation
 */
@Service
public class VNPayService {
    
    private static final Logger LOG = LoggerFactory.getLogger(VNPayService.class);
    
    private final VNPayConfig vnPayConfig;
    
    public VNPayService(VNPayConfig vnPayConfig) {
        this.vnPayConfig = vnPayConfig;
    }
    
    /**
     * Create VNPay payment URL
     */
    public String createPaymentUrl(InitiatePaymentRequestVM request, String transactionId, 
                                   String orderRef, BigDecimal amount, String returnUrl, String ipAddress) {
        LOG.debug("Creating VNPay payment URL for transaction: {}", transactionId);
        
        Map<String, String> vnpParams = new HashMap<>();
        vnpParams.put("vnp_Version", vnPayConfig.getVersion());
        vnpParams.put("vnp_Command", vnPayConfig.getCommand());
        vnpParams.put("vnp_TmnCode", vnPayConfig.getTmnCode());
        vnpParams.put("vnp_Amount", String.valueOf(amount.multiply(new BigDecimal("100")).longValue()));
        vnpParams.put("vnp_CurrCode", vnPayConfig.getCurrCode());
        vnpParams.put("vnp_TxnRef", transactionId);
        vnpParams.put("vnp_OrderInfo", "Payment for booking: " + orderRef);
        vnpParams.put("vnp_OrderType", vnPayConfig.getOrderType());
        vnpParams.put("vnp_Locale", vnPayConfig.getLocale());
        vnpParams.put("vnp_ReturnUrl", returnUrl);
        vnpParams.put("vnp_IpAddr", ipAddress);
        vnpParams.put("vnp_CreateDate", VNPayUtils.getVNPayDate());
        vnpParams.put("vnp_ExpireDate", VNPayUtils.getVNPayExpireDate());
        
        // Build query string
        String query = VNPayUtils.buildQuery(vnpParams);
        
        // Generate secure hash
        String secureHash = VNPayUtils.hmacSHA512(vnPayConfig.getHashSecret(), query);
        
        // Build final payment URL
        String paymentUrl = vnPayConfig.getPayUrl() + "?" + query + "&vnp_SecureHash=" + secureHash;
        
        LOG.debug("VNPay payment URL created successfully for transaction: {}", transactionId);
        return paymentUrl;
    }
    
    /**
     * Verify VNPay callback/webhook
     */
    public VNPayCallbackResult verifyCallback(Map<String, String> params) {
        LOG.debug("Verifying VNPay callback");
        
        // Validate signature
        if (!VNPayUtils.validateSignature(new HashMap<>(params), vnPayConfig.getHashSecret())) {
            LOG.warn("Invalid VNPay callback signature");
            return new VNPayCallbackResult(false, null, null, "Invalid signature");
        }
        
        String responseCode = params.get("vnp_ResponseCode");
        String transactionId = params.get("vnp_TxnRef");
        String amount = params.get("vnp_Amount");
        
        boolean isSuccess = "00".equals(responseCode);
        String status = isSuccess ? "SUCCESS" : "FAILED";
        
        LOG.debug("VNPay callback verified - Status: {}, Transaction: {}", status, transactionId);
        
        return new VNPayCallbackResult(true, transactionId, status, 
                isSuccess ? "Payment successful" : "Payment failed: " + responseCode);
    }
    
    /**
     * Parse VNPay webhook payload
     */
    public VNPayWebhookData parseWebhookPayload(String payload) {
        LOG.debug("Parsing VNPay webhook payload");
        
        Map<String, String> params = VNPayUtils.parseQuery(payload);
        
        String transactionId = params.get("vnp_TxnRef");
        String responseCode = params.get("vnp_ResponseCode");
        String amountStr = params.get("vnp_Amount");
        
        String status = "00".equals(responseCode) ? "SUCCESS" : "FAILED";
        BigDecimal amount = amountStr != null ? 
                new BigDecimal(amountStr).divide(new BigDecimal("100")) : BigDecimal.ZERO;
        
        return new VNPayWebhookData(transactionId, status, amount, params);
    }
    
    
    /**
     * VNPay callback result
     */
    public static class VNPayCallbackResult {
        private final boolean valid;
        private final String transactionId;
        private final String status;
        private final String message;
        
        public VNPayCallbackResult(boolean valid, String transactionId, String status, String message) {
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
     * VNPay webhook data
     */
    public static class VNPayWebhookData {
        private final String transactionId;
        private final String status;
        private final BigDecimal amount;
        private final Map<String, String> rawParams;
        
        public VNPayWebhookData(String transactionId, String status, BigDecimal amount, Map<String, String> rawParams) {
            this.transactionId = transactionId;
            this.status = status;
            this.amount = amount;
            this.rawParams = rawParams;
        }
        
        public String getTransactionId() { return transactionId; }
        public String getStatus() { return status; }
        public BigDecimal getAmount() { return amount; }
        public Map<String, String> getRawParams() { return rawParams; }
    }
}
