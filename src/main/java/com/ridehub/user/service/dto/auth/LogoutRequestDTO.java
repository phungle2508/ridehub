package com.ridehub.user.service.dto.auth;

import jakarta.validation.constraints.NotBlank;

/**
 * DTO for logout request
 */
public class LogoutRequestDTO {

    @NotBlank(message = "Refresh token is required")
    private String refreshToken;

    // Constructors
    public LogoutRequestDTO() {}

    public LogoutRequestDTO(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    // Getters and Setters
    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Override
    public String toString() {
        return "LogoutRequestDTO{" +
            "refreshToken='***'" + // Don't log the actual token for security
            '}';
    }
}
