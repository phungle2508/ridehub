package com.ridehub.booking.service.payment.momo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/**
 * MoMo utility class for handling payment operations
 */
public class MoMoUtils {
    
    private static final Logger LOG = LoggerFactory.getLogger(MoMoUtils.class);
    private static final String HMAC_SHA256 = "HmacSHA256";
    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    /**
     * Generate HMAC SHA256 signature
     */
    public static String generateSignature(String data, String secretKey) {
        try {
            Mac mac = Mac.getInstance(HMAC_SHA256);
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), HMAC_SHA256);
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
     * Build signature string for MoMo request
     */
    public static String buildSignatureString(String accessKey, String amount, String extraData,
                                              String ipnUrl, String orderId, String orderInfo,
                                              String partnerCode, String redirectUrl, String requestId,
                                              String requestType) {
        return "accessKey=" + accessKey +
               "&amount=" + amount +
               "&extraData=" + extraData +
               "&ipnUrl=" + ipnUrl +
               "&orderId=" + orderId +
               "&orderInfo=" + orderInfo +
               "&partnerCode=" + partnerCode +
               "&redirectUrl=" + redirectUrl +
               "&requestId=" + requestId +
               "&requestType=" + requestType;
    }
    
    /**
     * Verify MoMo webhook signature
     */
    public static boolean verifySignature(String rawData, String signature, String secretKey) {
        try {
            String expectedSignature = generateSignature(rawData, secretKey);
            return expectedSignature.equals(signature);
        } catch (Exception e) {
            LOG.error("Error verifying MoMo signature", e);
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
     * Generate request ID (timestamp + random)
     */
    public static String generateRequestId() {
        return String.valueOf(System.currentTimeMillis());
    }
    
    /**
     * Validate MoMo response status
     */
    public static boolean isSuccessResponse(int resultCode) {
        return resultCode == 0;
    }
    
    /**
     * Map MoMo result code to payment status
     */
    public static String mapResultCodeToStatus(int resultCode) {
        return switch (resultCode) {
            case 0 -> "SUCCESS";
            case 9000 -> "PENDING";
            case 8000, 7000, 6000 -> "FAILED";
            case 1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007 -> "FAILED";
            default -> "UNKNOWN";
        };
    }
}
