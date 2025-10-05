package com.ridehub.booking.service.payment.zalopay;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * ZaloPay utility class for handling payment operations
 */
public class ZaloPayUtils {
    
    private static final Logger LOG = LoggerFactory.getLogger(ZaloPayUtils.class);
    private static final String HMAC_SHA256 = "HmacSHA256";
    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    /**
     * Generate HMAC SHA256 signature
     */
    public static String generateSignature(String data, String key) {
        try {
            Mac mac = Mac.getInstance(HMAC_SHA256);
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), HMAC_SHA256);
            mac.init(secretKeySpec);
            byte[] hash = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException("Error generating HMAC SHA256 signature", e);
        }
    }
    
    /**
     * Convert byte array to hex string
     */
    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02x", b));
        }
        return result.toString();
    }
    
    /**
     * Generate ZaloPay transaction ID format: yyMMdd_appid_xxxxxx
     */
    public static String generateTransId(String appId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        String dateStr = sdf.format(new Date());
        long timestamp = System.currentTimeMillis();
        String suffix = String.valueOf(timestamp).substring(7); // Last 6 digits
        return dateStr + "_" + appId + "_" + suffix;
    }
    
    /**
     * Get current timestamp in milliseconds
     */
    public static long getCurrentTimestamp() {
        return System.currentTimeMillis();
    }
    
    /**
     * Build signature string for ZaloPay create order
     */
    public static String buildCreateOrderSignature(String appId, String appTransId, String appUser,
                                                   String amount, String appTime, String embedData,
                                                   String item) {
        return appId + "|" + appTransId + "|" + appUser + "|" + amount + "|" + appTime + "|" + embedData + "|" + item;
    }
    
    /**
     * Build signature string for ZaloPay callback verification
     */
    public static String buildCallbackSignature(String appId, String appTransId, String pmcId,
                                                String bankCode, String amount, String discountAmount,
                                                String status) {
        return appId + "|" + appTransId + "|" + pmcId + "|" + bankCode + "|" + amount + "|" + discountAmount + "|" + status;
    }
    
    /**
     * Verify ZaloPay callback signature
     */
    public static boolean verifyCallbackSignature(String data, String signature, String key) {
        try {
            String expectedSignature = generateSignature(data, key);
            return expectedSignature.equals(signature);
        } catch (Exception e) {
            LOG.error("Error verifying ZaloPay signature", e);
            return false;
        }
    }
    
    /**
     * Parse JSON string to Map
     */
    public static Map<String, Object> parseJson(String json) {
        try {
            return objectMapper.readValue(json, Map.class);
        } catch (Exception e) {
            LOG.error("Error parsing JSON: {}", json, e);
            throw new RuntimeException("Error parsing JSON", e);
        }
    }
    
    /**
     * Convert object to JSON string
     */
    public static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            LOG.error("Error converting to JSON", e);
            throw new RuntimeException("Error converting to JSON", e);
        }
    }
    
    /**
     * Validate ZaloPay response status
     */
    public static boolean isSuccessResponse(int returnCode) {
        return returnCode == 1;
    }
    
    /**
     * Map ZaloPay status to payment status
     */
    public static String mapStatusToPaymentStatus(int status) {
        return switch (status) {
            case 1 -> "SUCCESS";
            case 2 -> "FAILED";
            case 3 -> "PENDING";
            default -> "UNKNOWN";
        };
    }
    
    /**
     * Map ZaloPay return code to status
     */
    public static String mapReturnCodeToStatus(int returnCode) {
        return switch (returnCode) {
            case 1 -> "SUCCESS";
            case 2 -> "FAILED";
            case 3 -> "PENDING";
            default -> "FAILED";
        };
    }
}
