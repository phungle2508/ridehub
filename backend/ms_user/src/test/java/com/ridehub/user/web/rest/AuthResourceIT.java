package com.ridehub.user.web.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.nio.file.Files;
import java.nio.file.Path;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ridehub.user.IntegrationTest;
import com.ridehub.user.service.dto.auth.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

/**
 * Integration tests for the {@link AuthResource} REST controller.
 * Note: These tests will make actual HTTP calls to Keycloak SPI endpoints.
 * For unit tests, mock the KeycloakAuthService.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithUnauthenticatedMockUser
class AuthResourceIT {

    private static final String DEFAULT_PHONE = "+84382508253";
    private static final String DEFAULT_CODE = "646118";
    private static final String DEFAULT_EMAIL = "test@example.com";
    private static final String DEFAULT_FIRST_NAME = "John";
    private static final String DEFAULT_LAST_NAME = "Doe";
    private static final String DEFAULT_PASSWORD = "password123";

    @Autowired
    private MockMvc restAuthMockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void sendRegistrationOtp() throws Exception {
        SendOtpRequestDTO request = new SendOtpRequestDTO(DEFAULT_PHONE);

        restAuthMockMvc
            .perform(
                post("/api/auth/register/send-otp")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(request))
            )
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
            // Note: Actual response depends on Keycloak SPI being available
    }

    @Test
    void sendRegistrationOtpWithInvalidPhone() throws Exception {
        SendOtpRequestDTO request = new SendOtpRequestDTO("invalid-phone");

        restAuthMockMvc
            .perform(
                post("/api/auth/register/send-otp")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(request))
            )
            .andExpect(status().isBadRequest());
    }

    @Test
    void verifyRegistrationOtp() throws Exception {
        VerifyOtpRequestDTO request = new VerifyOtpRequestDTO("test-txn-id", DEFAULT_CODE);

        MvcResult result = restAuthMockMvc
            .perform(
                post("/api/auth/register/verify-otp")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(request))
            )
            .andExpect(status().isBadRequest())
            .andReturn();

        String responseBody = result.getResponse().getContentAsString();

        // write to file under target/test-results/verifyRegistrationOtp.txt
        Path outFile = Path.of("target", "test-results", "verifyRegistrationOtp.txt");
        Files.createDirectories(outFile.getParent());
        Files.writeString(outFile, responseBody);

        System.out.println("Response written to: " + outFile.toAbsolutePath());
    }


    @Test
    void completeRegistration() throws Exception {
        RegistrationCompleteRequestDTO request = new RegistrationCompleteRequestDTO(
            "test-reg-token",
            DEFAULT_EMAIL,
            DEFAULT_FIRST_NAME,
            DEFAULT_LAST_NAME,
            DEFAULT_PASSWORD
        );

        restAuthMockMvc
            .perform(
                post("/api/auth/register/complete")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(request))
            )
            .andExpect(status().isBadRequest()); // Will fail without valid regToken from Keycloak
    }

    @Test
    void requestPasswordReset() throws Exception {
        SendOtpRequestDTO request = new SendOtpRequestDTO(DEFAULT_PHONE);

        restAuthMockMvc
            .perform(
                post("/api/auth/password-reset/request")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(request))
            )
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
            // Note: Actual response depends on Keycloak SPI being available
    }

    @Test
    void verifyPasswordResetOtp() throws Exception {
        VerifyOtpRequestDTO request = new VerifyOtpRequestDTO("test-txn-id", DEFAULT_CODE);

        restAuthMockMvc
            .perform(
                post("/api/auth/password-reset/verify-otp")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(request))
            )
            .andExpect(status().isBadRequest()); // Will fail without valid txnId from Keycloak
    }

    @Test
    void completePasswordReset() throws Exception {
        PasswordResetRequestDTO request = new PasswordResetRequestDTO("test-reset-token", "newPassword123");

        restAuthMockMvc
            .perform(
                post("/api/auth/password-reset/complete")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(request))
            )
            .andExpect(status().isBadRequest()); // Will fail without valid resetToken from Keycloak
    }

    @Test
    void healthCheck() throws Exception {
        restAuthMockMvc
            .perform(get("/api/auth/health"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.status").value("UP"))
            .andExpect(jsonPath("$.service").value("auth-service"))
            .andExpect(jsonPath("$.keycloak").value("connected"));
    }

    @Test
    void sendRegistrationOtpWithEmptyPhone() throws Exception {
        SendOtpRequestDTO request = new SendOtpRequestDTO("");

        restAuthMockMvc
            .perform(
                post("/api/auth/register/send-otp")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(request))
            )
            .andExpect(status().isBadRequest());
    }

    @Test
    void verifyOtpWithInvalidCode() throws Exception {
        VerifyOtpRequestDTO request = new VerifyOtpRequestDTO("test-txn-id", "12345"); // Invalid: only 5 digits

        restAuthMockMvc
            .perform(
                post("/api/auth/register/verify-otp")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(request))
            )
            .andExpect(status().isBadRequest());
    }

    @Test
    void completeRegistrationWithInvalidEmail() throws Exception {
        RegistrationCompleteRequestDTO request = new RegistrationCompleteRequestDTO(
            "test-reg-token",
            "invalid-email",
            DEFAULT_FIRST_NAME,
            DEFAULT_LAST_NAME,
            DEFAULT_PASSWORD
        );

        restAuthMockMvc
            .perform(
                post("/api/auth/register/complete")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(request))
            )
            .andExpect(status().isBadRequest());
    }

    @Test
    void completeRegistrationWithShortPassword() throws Exception {
        RegistrationCompleteRequestDTO request = new RegistrationCompleteRequestDTO(
            "test-reg-token",
            DEFAULT_EMAIL,
            DEFAULT_FIRST_NAME,
            DEFAULT_LAST_NAME,
            "123" // Too short
        );

        restAuthMockMvc
            .perform(
                post("/api/auth/register/complete")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(request))
            )
            .andExpect(status().isBadRequest());
    }

    @Test
    void login() throws Exception {
        LoginRequestDTO request = new LoginRequestDTO("admin", "admin");

        restAuthMockMvc
            .perform(
                post("/api/auth/login")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(request))
            )
            .andExpect(status().isUnauthorized()); // Will fail without valid user in Keycloak
    }

    @Test
    void loginWithInvalidCredentials() throws Exception {
        LoginRequestDTO request = new LoginRequestDTO("invalid-user", "invalid-password");

        restAuthMockMvc
            .perform(
                post("/api/auth/login")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(request))
            )
            .andExpect(status().isUnauthorized());
    }

    @Test
    void loginWithEmptyUsername() throws Exception {
        LoginRequestDTO request = new LoginRequestDTO("", DEFAULT_PASSWORD);

        restAuthMockMvc
            .perform(
                post("/api/auth/login")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(request))
            )
            .andExpect(status().isBadRequest());
    }

    @Test
    void loginWithEmptyPassword() throws Exception {
        LoginRequestDTO request = new LoginRequestDTO(DEFAULT_PHONE, "");

        restAuthMockMvc
            .perform(
                post("/api/auth/login")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(request))
            )
            .andExpect(status().isBadRequest());
    }
}
