package com.ridehub.booking.service.payment.momo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * MoMo payment configuration properties
 */
@Component
@ConfigurationProperties(prefix = "momo")
public class MoMoConfig {
    
    private String partnerCode;
    private String accessKey;
    private String secretKey;
    private String endpoint;
    private String returnUrl;
    private String notifyUrl;
    private String requestType = "payWithATM";
    private String orderInfo = "Payment via MoMo";
    private String lang = "vi";
    private boolean autoCapture = true;
    
    // Getters and Setters
    public String getPartnerCode() {
        return partnerCode;
    }
    
    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }
    
    public String getAccessKey() {
        return accessKey;
    }
    
    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }
    
    public String getSecretKey() {
        return secretKey;
    }
    
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
    
    public String getEndpoint() {
        return endpoint;
    }
    
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
    
    public String getReturnUrl() {
        return returnUrl;
    }
    
    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }
    
    public String getNotifyUrl() {
        return notifyUrl;
    }
    
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }
    
    public String getRequestType() {
        return requestType;
    }
    
    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }
    
    public String getOrderInfo() {
        return orderInfo;
    }
    
    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }
    
    public String getLang() {
        return lang;
    }
    
    public void setLang(String lang) {
        this.lang = lang;
    }
    
    public boolean isAutoCapture() {
        return autoCapture;
    }
    
    public void setAutoCapture(boolean autoCapture) {
        this.autoCapture = autoCapture;
    }
}
