// src/main/java/com/ridehub/common/feign/ServiceTokenManager.java
package com.ridehub.common.feign;

import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.util.Map;

public class ServiceTokenManager {
    private final String tokenUrl; // e.g.
                                   // https://keycloak.appf4s.io.vn/realms/jhipster/protocol/openid-connect/token
    private final String clientId;
    private final String clientSecret;
    private final String scope; // optional, can be null
    private final RestTemplate rt = new RestTemplate();

    private volatile String cachedToken;
    private volatile Instant expiresAt = Instant.EPOCH;

    public ServiceTokenManager(String tokenUrl, String clientId, String clientSecret, String scope) {
        this.tokenUrl = tokenUrl;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.scope = scope;
    }

    public synchronized String getAccessToken() {
        if (cachedToken != null && Instant.now().isBefore(expiresAt.minusSeconds(30))) {
            return cachedToken;
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> form = new LinkedMultiValueMap<>();
        form.add("grant_type", "client_credentials");
        form.add("client_id", clientId);
        form.add("client_secret", clientSecret);
        if (scope != null && !scope.isBlank())
            form.add("scope", scope);

        ResponseEntity<Map> resp = rt.postForEntity(tokenUrl, new HttpEntity<>(form, headers), Map.class);
        if (!resp.getStatusCode().is2xxSuccessful() || resp.getBody() == null) {
            throw new IllegalStateException("Failed to fetch service token: " + resp.getStatusCode());
        }
        String token = (String) resp.getBody().get("access_token");
        Number expiresIn = (Number) resp.getBody().get("expires_in");
        if (token == null || expiresIn == null) {
            throw new IllegalStateException("Token response missing fields");
        }
        cachedToken = token;
        expiresAt = Instant.now().plusSeconds(expiresIn.longValue());
        return cachedToken;
    }
}
