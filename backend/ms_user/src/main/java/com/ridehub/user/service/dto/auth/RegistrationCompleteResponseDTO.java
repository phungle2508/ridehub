package com.ridehub.user.service.dto.auth;

/**
 * DTO for registration completion response
 */
public class RegistrationCompleteResponseDTO {

    private String userId;
    private String keycloakId;
    private String message;
    private boolean success;

    // Constructors
    public RegistrationCompleteResponseDTO() {}

    public RegistrationCompleteResponseDTO(String userId, String keycloakId, boolean success) {
        this.userId = userId;
        this.keycloakId = keycloakId;
        this.success = success;
        this.message = success ? "Registration completed successfully" : "Registration failed";
    }

    // Static factory methods
    public static RegistrationCompleteResponseDTO success(String userId, String keycloakId) {
        return new RegistrationCompleteResponseDTO(userId, keycloakId, true);
    }

    public static RegistrationCompleteResponseDTO success(String userId) {
        return new RegistrationCompleteResponseDTO(userId, null, true);
    }

    public static RegistrationCompleteResponseDTO error(String message) {
        RegistrationCompleteResponseDTO response = new RegistrationCompleteResponseDTO();
        response.setSuccess(false);
        response.setMessage(message);
        return response;
    }

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getKeycloakId() {
        return keycloakId;
    }

    public void setKeycloakId(String keycloakId) {
        this.keycloakId = keycloakId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "RegistrationCompleteResponseDTO{" +
            "userId='" + userId + '\'' +
            ", keycloakId='" + keycloakId + '\'' +
            ", message='" + message + '\'' +
            ", success=" + success +
            '}';
    }
}
