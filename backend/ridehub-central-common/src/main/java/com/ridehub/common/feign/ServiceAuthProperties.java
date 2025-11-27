// src/main/java/com/ridehub/common/feign/ServiceAuthProperties.java
package com.ridehub.common.feign;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "ridehub.s2s")
public class ServiceAuthProperties {
    /**
     * Full token endpoint URL:
     * https://keycloak.../realms/<realm>/protocol/openid-connect/token
     */
    private String tokenUrl;
    private String clientId; // e.g. ms-booking
    private String clientSecret; // Keycloak client secret
    private String scope; // optional
    // getters/setters

    public String getTokenUrl() {
        return tokenUrl;
    }

    public void setTokenUrl(String tokenUrl) {
        this.tokenUrl = tokenUrl;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

}
