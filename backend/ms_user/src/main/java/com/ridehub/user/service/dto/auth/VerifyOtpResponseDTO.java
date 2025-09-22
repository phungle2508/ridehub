package com.ridehub.user.service.dto.auth;

/**
 * DTO for OTP verification response
 */
public class VerifyOtpResponseDTO {

    private String token; // regToken or resetToken
    private long expiresIn;
    private String message;
    private String tokenType; // "registration" or "reset"

    // Constructors
    public VerifyOtpResponseDTO() {}

    public VerifyOtpResponseDTO(String token, long expiresIn, String tokenType) {
        this.token = token;
        this.expiresIn = expiresIn;
        this.tokenType = tokenType;
        this.message = "OTP verified successfully";
    }

    // Static factory methods
    public static VerifyOtpResponseDTO registrationToken(String regToken, long expiresIn) {
        return new VerifyOtpResponseDTO(regToken, expiresIn, "registration");
    }

    public static VerifyOtpResponseDTO resetToken(String resetToken, long expiresIn) {
        return new VerifyOtpResponseDTO(resetToken, expiresIn, "reset");
    }

    public static VerifyOtpResponseDTO error(String message) {
        VerifyOtpResponseDTO response = new VerifyOtpResponseDTO();
        response.setMessage(message);
        return response;
    }

    // Getters and Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    @Override
    public String toString() {
        return "VerifyOtpResponseDTO{" +
            "token='***'" + // Don't log the actual token for security
            ", expiresIn=" + expiresIn +
            ", message='" + message + '\'' +
            ", tokenType='" + tokenType + '\'' +
            '}';
    }
}
