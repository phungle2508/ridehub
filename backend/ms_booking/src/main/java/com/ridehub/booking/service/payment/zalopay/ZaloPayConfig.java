package com.ridehub.booking.service.payment.zalopay;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ZaloPay payment configuration properties
 */
@Component
@ConfigurationProperties(prefix = "zalopay")
public class ZaloPayConfig {
    
    private String appId;
    private String key1;
    private String key2;
    private String endpoint;
    private String callbackUrl;
    private String description = "Payment via ZaloPay";
    private String embedData = "{}";
    private String bankCode = "";
    private String itemData = "[]";
    
    // Getters and Setters
    public String getAppId() {
        return appId;
    }
    
    public void setAppId(String appId) {
        this.appId = appId;
    }
    
    public String getKey1() {
        return key1;
    }
    
    public void setKey1(String key1) {
        this.key1 = key1;
    }
    
    public String getKey2() {
        return key2;
    }
    
    public void setKey2(String key2) {
        this.key2 = key2;
    }
    
    public String getEndpoint() {
        return endpoint;
    }
    
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }
    
    public String getCallbackUrl() {
        return callbackUrl;
    }
    
    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getEmbedData() {
        return embedData;
    }
    
    public void setEmbedData(String embedData) {
        this.embedData = embedData;
    }
    
    public String getBankCode() {
        return bankCode;
    }
    
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }
    
    public String getItemData() {
        return itemData;
    }
    
    public void setItemData(String itemData) {
        this.itemData = itemData;
    }
}
