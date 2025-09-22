package com.ridehub.user.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ridehub.user.service.AppUserService;
import com.ridehub.user.service.KeycloakAuthService;
import com.ridehub.user.service.dto.auth.*;
import com.ridehub.user.util.PhoneUtil;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Map;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Service Implementation for communicating with Keycloak custom registration
 * SPI.
 */
@Service
public class KeycloakAuthServiceImpl implements KeycloakAuthService {

    private static final Logger log = LoggerFactory.getLogger(KeycloakAuthServiceImpl.class);

    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;
    private final String keycloakBaseUrl;
    private final AppUserService appUserService;
    private final String keycloakClientId;
    private final String keycloakClientSecret;

    private static String enc(String v) {
        return URLEncoder.encode(v, StandardCharsets.UTF_8);
    }

    public KeycloakAuthServiceImpl(
            ObjectMapper objectMapper,
            AppUserService appUserService,
            @Value("${spring.security.oauth2.client.provider.oidc.client-id}") String keycloakClientId,
            @Value("${spring.security.oauth2.client.provider.oidc.client-secret}") String keycloakClientSecret,
            @Value("${app.keycloak.base-url:https://keycloak.appf4s.io.vn}") String keycloakBaseUrl) {
        this.objectMapper = objectMapper;
        this.appUserService = appUserService;
        this.keycloakBaseUrl = keycloakBaseUrl;
        this.keycloakClientId = keycloakClientId;
        this.keycloakClientSecret = keycloakClientSecret;
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();
    }

    @Override
    public SendOtpResponseDTO sendRegistrationOtp(String phone) {
        log.debug("Sending registration OTP to phone: {}", phone);

        try {
            Map<String, String> requestBody = Map.of("phone", phone);
            String jsonBody = objectMapper.writeValueAsString(requestBody);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(keycloakBaseUrl + "/realms/jhipster/customreg/send-otp"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .timeout(Duration.ofSeconds(30))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Map<String, Object> responseMap = objectMapper.readValue(response.body(),
                        new TypeReference<Map<String, Object>>() {
                        });
                String txnId = (String) responseMap.get("txnId");
                Number expiresIn = (Number) responseMap.get("expiresIn");

                return SendOtpResponseDTO.success(txnId, expiresIn.longValue());
            } else {
                Map<String, Object> errorMap = objectMapper.readValue(response.body(),
                        new TypeReference<Map<String, Object>>() {
                        });
                String error = (String) errorMap.get("error");
                return SendOtpResponseDTO.error(getErrorMessage(error));
            }

        } catch (Exception e) {
            log.error("Error sending registration OTP: {}", e.getMessage(), e);
            return SendOtpResponseDTO.error("Failed to send OTP: " + e.getMessage());
        }
    }

    @Override
    public VerifyOtpResponseDTO verifyRegistrationOtp(String txnId, String code) {
        log.debug("Verifying registration OTP for txnId: {}", txnId);

        try {
            Map<String, String> requestBody = Map.of("txnId", txnId, "code", code);
            String jsonBody = objectMapper.writeValueAsString(requestBody);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(keycloakBaseUrl + "/realms/jhipster/customreg/verify-otp"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .timeout(Duration.ofSeconds(30))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Map<String, Object> responseMap = objectMapper.readValue(response.body(),
                        new TypeReference<Map<String, Object>>() {
                        });
                String regToken = (String) responseMap.get("regToken");
                Number expiresIn = (Number) responseMap.get("expiresIn");

                return VerifyOtpResponseDTO.registrationToken(regToken, expiresIn.longValue());
            } else {
                Map<String, Object> errorMap = objectMapper.readValue(response.body(),
                        new TypeReference<Map<String, Object>>() {
                        });
                String error = (String) errorMap.get("error");
                return VerifyOtpResponseDTO.error(getErrorMessage(error));
            }

        } catch (Exception e) {
            log.error("Error verifying registration OTP: {}", e.getMessage(), e);
            return VerifyOtpResponseDTO.error("Failed to verify OTP: " + e.getMessage());
        }
    }

    @Override
    public RegistrationCompleteResponseDTO completeRegistration(String regToken, String email, String firstName,
            String lastName, String password) {
        log.debug("Completing registration for user: {} {}", firstName, lastName);

        try {
            Map<String, String> requestBody = Map.of(
                    "regToken", regToken,
                    "email", email != null ? email : "",
                    "firstName", firstName,
                    "lastName", lastName,
                    "password", password);
            String jsonBody = objectMapper.writeValueAsString(requestBody);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(keycloakBaseUrl + "/realms/jhipster/customreg/complete"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .timeout(Duration.ofSeconds(30))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 201) {
                Map<String, Object> responseMap = objectMapper.readValue(response.body(),
                        new TypeReference<Map<String, Object>>() {
                        });
                String keycloakUserId = (String) responseMap.get("userId");

                // Automatically sync user data to ms_user database
                try {
                    syncUserDataAfterRegistration(keycloakUserId, email, firstName, lastName, regToken);
                    log.info("Successfully synced user data after registration for Keycloak user: {}", keycloakUserId);
                } catch (Exception e) {
                    log.warn("Failed to sync user data after registration: {}", e.getMessage());
                    // Don't fail the registration if sync fails
                }

                return RegistrationCompleteResponseDTO.success(keycloakUserId, keycloakUserId);
            } else {
                Map<String, Object> errorMap = objectMapper.readValue(response.body(),
                        new TypeReference<Map<String, Object>>() {
                        });
                String error = (String) errorMap.get("error");
                return RegistrationCompleteResponseDTO.error(getErrorMessage(error));
            }

        } catch (Exception e) {
            log.error("Error completing registration: {}", e.getMessage(), e);
            return RegistrationCompleteResponseDTO.error("Failed to complete registration: " + e.getMessage());
        }
    }

    @Override
    public SendOtpResponseDTO requestPasswordReset(String phone) {
        log.debug("Requesting password reset OTP for phone: {}", phone);

        try {
            Map<String, String> requestBody = Map.of("phone", phone);
            String jsonBody = objectMapper.writeValueAsString(requestBody);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(keycloakBaseUrl + "/realms/jhipster/customreg/reset/request"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .timeout(Duration.ofSeconds(30))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Map<String, Object> responseMap = objectMapper.readValue(response.body(), Map.class);
                String txnId = (String) responseMap.get("txnId");
                Number expiresIn = (Number) responseMap.get("expiresIn");

                return SendOtpResponseDTO.success(txnId, expiresIn.longValue());
            } else {
                Map<String, Object> errorMap = objectMapper.readValue(response.body(), Map.class);
                String error = (String) errorMap.get("error");
                return SendOtpResponseDTO.error(getErrorMessage(error));
            }

        } catch (Exception e) {
            log.error("Error requesting password reset: {}", e.getMessage(), e);
            return SendOtpResponseDTO.error("Failed to request password reset: " + e.getMessage());
        }
    }

    @Override
    public VerifyOtpResponseDTO verifyPasswordResetOtp(String txnId, String code) {
        log.debug("Verifying password reset OTP for txnId: {}", txnId);

        try {
            Map<String, String> requestBody = Map.of("txnId", txnId, "code", code);
            String jsonBody = objectMapper.writeValueAsString(requestBody);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(keycloakBaseUrl + "/realms/jhipster/customreg/reset/verify"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .timeout(Duration.ofSeconds(30))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Map<String, Object> responseMap = objectMapper.readValue(response.body(), Map.class);
                String resetToken = (String) responseMap.get("resetToken");
                Number expiresIn = (Number) responseMap.get("expiresIn");

                return VerifyOtpResponseDTO.resetToken(resetToken, expiresIn.longValue());
            } else {
                Map<String, Object> errorMap = objectMapper.readValue(response.body(), Map.class);
                String error = (String) errorMap.get("error");
                return VerifyOtpResponseDTO.error(getErrorMessage(error));
            }

        } catch (Exception e) {
            log.error("Error verifying password reset OTP: {}", e.getMessage(), e);
            return VerifyOtpResponseDTO.error("Failed to verify OTP: " + e.getMessage());
        }
    }

    @Override
    public Map<String, Object> completePasswordReset(String resetToken, String newPassword) {
        log.debug("Completing password reset");

        try {
            Map<String, String> requestBody = Map.of(
                    "resetToken", resetToken,
                    "newPassword", newPassword);
            String jsonBody = objectMapper.writeValueAsString(requestBody);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(keycloakBaseUrl + "/realms/jhipster/customreg/reset/complete"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .timeout(Duration.ofSeconds(30))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                return Map.of("status", "success", "message", "Password reset successfully");
            } else {
                Map<String, Object> errorMap = objectMapper.readValue(response.body(), Map.class);
                String error = (String) errorMap.get("error");
                return Map.of("status", "error", "message", getErrorMessage(error));
            }

        } catch (Exception e) {
            log.error("Error completing password reset: {}", e.getMessage(), e);
            return Map.of("status", "error", "message", "Failed to reset password: " + e.getMessage());
        }
    }

    @Override
    public LoginResponseDTO login(String username, String password) {
        log.debug("Logging in user: {}", username);

        try {
            // Normalize phone number if the username looks like a phone number
            String normalizedUsername = username;
            if (PhoneUtil.looksLikePhoneNumber(username)) {
                String normalized = PhoneUtil.normalizePhone(username);
                if (normalized != null) {
                    normalizedUsername = normalized;
                    log.debug("Normalized phone number from {} to {}", username, normalizedUsername);
                }
            }

            // Prepare OAuth2 token request
            String tokenUrl = keycloakBaseUrl + "/realms/jhipster/protocol/openid-connect/token";

            String formData = "grant_type=" + enc("password") +
                    "&client_id=" + enc(keycloakClientId) +
                    (keycloakClientSecret != null && !keycloakClientSecret.isBlank()
                            ? "&client_secret=" + enc(keycloakClientSecret)
                            : "")
                    +
                    "&username=" + enc(normalizedUsername) +
                    "&password=" + enc(password);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(tokenUrl))
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .POST(HttpRequest.BodyPublishers.ofString(formData))
                    .timeout(Duration.ofSeconds(30))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Map<String, Object> tokenResponse = objectMapper.readValue(response.body(),
                        new TypeReference<Map<String, Object>>() {
                        });

                String accessToken = (String) tokenResponse.get("access_token");
                String refreshToken = (String) tokenResponse.get("refresh_token");
                String tokenType = (String) tokenResponse.get("token_type");
                Number expiresIn = (Number) tokenResponse.get("expires_in");
                String scope = (String) tokenResponse.get("scope");

                LoginResponseDTO loginResponse = LoginResponseDTO.success(
                        accessToken,
                        refreshToken,
                        tokenType,
                        expiresIn.longValue());
                loginResponse.setScope(scope);

                // Get user info from token and sync with ms_user
                try {
                    LoginResponseDTO.UserInfoDTO userInfo = extractUserInfoFromToken(accessToken);
                    loginResponse.setUserInfo(userInfo);

                    // Sync user data and update last login
                    syncUserDataAfterLogin(userInfo);

                } catch (Exception e) {
                    log.warn("Failed to extract user info or sync data: {}", e.getMessage());
                }

                return loginResponse;

            } else {
                Map<String, Object> errorResponse = objectMapper.readValue(response.body(),
                        new TypeReference<Map<String, Object>>() {
                        });
                String error = (String) errorResponse.get("error");
                String errorDescription = (String) errorResponse.get("error_description");

                return LoginResponseDTO.error(getLoginErrorMessage(error, errorDescription));
            }

        } catch (Exception e) {
            log.error("Error during login: {}", e.getMessage(), e);
            return LoginResponseDTO.error("Login failed: " + e.getMessage());
        }
    }

    private String getErrorMessage(String errorCode) {
        return switch (errorCode) {
            case "bad_phone" -> "Invalid phone number format";
            case "sms_failed" -> "Failed to send SMS";
            case "invalid_code" -> "Invalid or expired OTP code";
            case "no_phone" -> "Phone number not found in token";
            case "phone_exists" -> "Phone number already registered";
            case "no_user" -> "User not found";
            default -> "Unknown error: " + errorCode;
        };
    }

    private String getLoginErrorMessage(String error, String errorDescription) {
        return switch (error) {
            case "invalid_grant" -> "Invalid username or password";
            case "invalid_client" -> "Invalid client configuration";
            case "unauthorized_client" -> "Client not authorized";
            case "unsupported_grant_type" -> "Unsupported grant type";
            case "invalid_scope" -> "Invalid scope";
            default -> errorDescription != null ? errorDescription : "Login failed: " + error;
        };
    }

    private LoginResponseDTO.UserInfoDTO extractUserInfoFromToken(String accessToken) {
        try {
            // Decode JWT token to extract user information
            // Note: This is a simplified version. In production, you should properly
            // validate the JWT
            String[] tokenParts = accessToken.split("\\.");
            if (tokenParts.length != 3) {
                throw new IllegalArgumentException("Invalid JWT token format");
            }

            // Decode the payload (second part)
            String payload = new String(java.util.Base64.getUrlDecoder().decode(tokenParts[1]));
            Map<String, Object> claims = objectMapper.readValue(payload, new TypeReference<Map<String, Object>>() {
            });

            LoginResponseDTO.UserInfoDTO userInfo = new LoginResponseDTO.UserInfoDTO();
            userInfo.setKeycloakId((String) claims.get("sub"));
            userInfo.setUsername((String) claims.get("preferred_username"));
            userInfo.setEmail((String) claims.get("email"));
            userInfo.setFirstName((String) claims.get("given_name"));
            userInfo.setLastName((String) claims.get("family_name"));
            userInfo.setPhoneNumber((String) claims.get("phone_number"));
            userInfo.setEmailVerified(Boolean.TRUE.equals(claims.get("email_verified")));
            userInfo.setPhoneVerified(Boolean.TRUE.equals(claims.get("phone_number_verified")));

            return userInfo;

        } catch (Exception e) {
            log.error("Error extracting user info from token: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to extract user info from token", e);
        }
    }

    private void syncUserDataAfterLogin(LoginResponseDTO.UserInfoDTO userInfo) {
        try {
            // Use local AppUserService to update last login
            if (userInfo.getKeycloakId() != null) {
                UUID keycloakUuid = UUID.fromString(userInfo.getKeycloakId());

                appUserService.updateLastLogin(keycloakUuid)
                        .ifPresentOrElse(
                                updatedUser -> log.debug("Successfully updated last login for user: {}",
                                        userInfo.getKeycloakId()),
                                () -> log.warn("User not found for last login update: {}", userInfo.getKeycloakId()));
            }
        } catch (Exception e) {
            log.warn("Error syncing user data after login: {}", e.getMessage());
            // Don't throw exception here as login was successful
        }
    }

    private void syncUserDataAfterRegistration(String keycloakUserId, String email, String firstName, String lastName,
            String regToken) {
        try {
            // Extract phone number from registration token
            String phoneNumber = extractPhoneFromRegToken(regToken);

            // Convert keycloakUserId string to UUID
            UUID keycloakUuid = UUID.fromString(keycloakUserId);

            // Use local AppUserService instead of HTTP call
            appUserService.syncUserAfterRegistration(
                    keycloakUuid,
                    email,
                    phoneNumber,
                    firstName,
                    lastName,
                    true, // isVerified
                    true, // isActive
                    phoneNumber // username
            );

            log.debug("Successfully synced user data for Keycloak user: {}", keycloakUserId);

        } catch (Exception e) {
            log.error("Error syncing user data after registration: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to sync user data", e);
        }
    }

    private String extractPhoneFromRegToken(String regToken) {
        try {
            // Decode JWT token to extract phone number
            String[] tokenParts = regToken.split("\\.");
            if (tokenParts.length != 3) {
                return null;
            }

            String payload = new String(java.util.Base64.getUrlDecoder().decode(tokenParts[1]));
            Map<String, Object> claims = objectMapper.readValue(payload, new TypeReference<Map<String, Object>>() {
            });

            return (String) claims.get("phone");
        } catch (Exception e) {
            log.warn("Failed to extract phone from registration token: {}", e.getMessage());
            return null;
        }
    }
}
