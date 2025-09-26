package com.ridehub.user.service.impl;

import com.ridehub.user.service.dto.auth.SendOtpResponseDTO;
import com.ridehub.user.service.dto.auth.VerifyOtpResponseDTO;
import com.ridehub.user.service.dto.auth.LoginResponseDTO;
import com.ridehub.user.service.dto.auth.RegistrationCompleteResponseDTO;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for enhanced error handling in Keycloak responses.
 */
class KeycloakErrorHandlingTest {

    @Test
    void sendOtpResponseDTO_shouldIncludeErrorDetails() {
        // Given
        String message = "Invalid phone number format";
        String errorCode = "bad_phone";
        String errorDescription = "The provided phone number is not in a valid format";

        // When
        SendOtpResponseDTO response = SendOtpResponseDTO.error(message, errorCode, errorDescription);

        // Then
        assertThat(response.getMessage()).isEqualTo(message);
        assertThat(response.getErrorCode()).isEqualTo(errorCode);
        assertThat(response.getErrorDescription()).isEqualTo(errorDescription);
        assertThat(response.getTxnId()).isNull();
        assertThat(response.getExpiresIn()).isEqualTo(0);
    }

    @Test
    void sendOtpResponseDTO_shouldHandleSimpleError() {
        // Given
        String message = "Failed to send OTP";

        // When
        SendOtpResponseDTO response = SendOtpResponseDTO.error(message);

        // Then
        assertThat(response.getMessage()).isEqualTo(message);
        assertThat(response.getErrorCode()).isNull();
        assertThat(response.getErrorDescription()).isNull();
    }

    @Test
    void verifyOtpResponseDTO_shouldIncludeErrorDetails() {
        // Given
        String message = "Invalid or expired OTP code";
        String errorCode = "invalid_code";
        String errorDescription = "The OTP code provided is either invalid or has expired";

        // When
        VerifyOtpResponseDTO response = VerifyOtpResponseDTO.error(message, errorCode, errorDescription);

        // Then
        assertThat(response.getMessage()).isEqualTo(message);
        assertThat(response.getErrorCode()).isEqualTo(errorCode);
        assertThat(response.getErrorDescription()).isEqualTo(errorDescription);
        assertThat(response.getToken()).isNull();
        assertThat(response.getExpiresIn()).isEqualTo(0);
        assertThat(response.getTokenType()).isNull();
    }

    @Test
    void verifyOtpResponseDTO_shouldHandleSimpleError() {
        // Given
        String message = "Verification failed";

        // When
        VerifyOtpResponseDTO response = VerifyOtpResponseDTO.error(message);

        // Then
        assertThat(response.getMessage()).isEqualTo(message);
        assertThat(response.getErrorCode()).isNull();
        assertThat(response.getErrorDescription()).isNull();
    }

    @Test
    void sendOtpResponseDTO_toStringShouldIncludeErrorFields() {
        // Given
        SendOtpResponseDTO response = SendOtpResponseDTO.error("Test message", "test_code", "Test description");

        // When
        String toString = response.toString();

        // Then
        assertThat(toString).contains("errorCode='test_code'");
        assertThat(toString).contains("errorDescription='Test description'");
        assertThat(toString).contains("message='Test message'");
    }

    @Test
    void verifyOtpResponseDTO_toStringShouldIncludeErrorFields() {
        // Given
        VerifyOtpResponseDTO response = VerifyOtpResponseDTO.error("Test message", "test_code", "Test description");

        // When
        String toString = response.toString();

        // Then
        assertThat(toString).contains("errorCode='test_code'");
        assertThat(toString).contains("errorDescription='Test description'");
        assertThat(toString).contains("message='Test message'");
    }

    @Test
    void loginResponseDTO_shouldIncludeErrorDetails() {
        // Given
        String message = "Invalid username or password";
        String errorCode = "invalid_grant";
        String errorDescription = "The provided username and password combination is invalid";

        // When
        LoginResponseDTO response = LoginResponseDTO.error(message, errorCode, errorDescription);

        // Then
        assertThat(response.getMessage()).isEqualTo(message);
        assertThat(response.getErrorCode()).isEqualTo(errorCode);
        assertThat(response.getErrorDescription()).isEqualTo(errorDescription);
        assertThat(response.isSuccess()).isFalse();
        assertThat(response.getAccessToken()).isNull();
        assertThat(response.getRefreshToken()).isNull();
    }

    @Test
    void registrationCompleteResponseDTO_shouldIncludeErrorDetails() {
        // Given
        String message = "Phone number already registered";
        String errorCode = "phone_exists";
        String errorDescription = "A user with this phone number already exists in the system";

        // When
        RegistrationCompleteResponseDTO response = RegistrationCompleteResponseDTO.error(message, errorCode, errorDescription);

        // Then
        assertThat(response.getMessage()).isEqualTo(message);
        assertThat(response.getErrorCode()).isEqualTo(errorCode);
        assertThat(response.getErrorDescription()).isEqualTo(errorDescription);
        assertThat(response.isSuccess()).isFalse();
        assertThat(response.getUserId()).isNull();
        assertThat(response.getKeycloakId()).isNull();
    }

    @Test
    void allResponseDTOs_shouldPreserveKeycloakErrorDetails() {
        // This test demonstrates that all response DTOs now preserve original Keycloak error information
        String originalErrorCode = "custom_keycloak_error";
        String originalErrorDescription = "This is the original error message from Keycloak";
        String userFriendlyMessage = "A user-friendly error message";

        // Test all response DTOs
        SendOtpResponseDTO sendOtpResponse = SendOtpResponseDTO.error(userFriendlyMessage, originalErrorCode, originalErrorDescription);
        VerifyOtpResponseDTO verifyOtpResponse = VerifyOtpResponseDTO.error(userFriendlyMessage, originalErrorCode, originalErrorDescription);
        LoginResponseDTO loginResponse = LoginResponseDTO.error(userFriendlyMessage, originalErrorCode, originalErrorDescription);
        RegistrationCompleteResponseDTO regResponse = RegistrationCompleteResponseDTO.error(userFriendlyMessage, originalErrorCode, originalErrorDescription);

        // Verify all preserve the original Keycloak error details
        assertThat(sendOtpResponse.getErrorCode()).isEqualTo(originalErrorCode);
        assertThat(sendOtpResponse.getErrorDescription()).isEqualTo(originalErrorDescription);

        assertThat(verifyOtpResponse.getErrorCode()).isEqualTo(originalErrorCode);
        assertThat(verifyOtpResponse.getErrorDescription()).isEqualTo(originalErrorDescription);

        assertThat(loginResponse.getErrorCode()).isEqualTo(originalErrorCode);
        assertThat(loginResponse.getErrorDescription()).isEqualTo(originalErrorDescription);

        assertThat(regResponse.getErrorCode()).isEqualTo(originalErrorCode);
        assertThat(regResponse.getErrorDescription()).isEqualTo(originalErrorDescription);
    }
}
