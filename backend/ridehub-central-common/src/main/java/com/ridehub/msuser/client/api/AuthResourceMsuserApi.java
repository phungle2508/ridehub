package com.ridehub.msuser.client.api;

import com.ridehub.msuser.client.invoker.ApiClient;
import com.ridehub.msuser.client.invoker.EncodingUtils;
import com.ridehub.msuser.client.model.ApiResponse;

import com.ridehub.msuser.client.model.AdminUpdatePasswordRequest;
import com.ridehub.msuser.client.model.AdminUpdateUserRequest;
import com.ridehub.msuser.client.model.CreateAdminRequest;
import com.ridehub.msuser.client.model.LoginRequestDTO;
import com.ridehub.msuser.client.model.LoginResponseDTO;
import com.ridehub.msuser.client.model.PasswordResetRequestDTO;
import com.ridehub.msuser.client.model.RegistrationCompleteRequestDTO;
import com.ridehub.msuser.client.model.RegistrationCompleteResponseDTO;
import com.ridehub.msuser.client.model.SendOtpRequestDTO;
import com.ridehub.msuser.client.model.SendOtpResponseDTO;
import com.ridehub.msuser.client.model.UpdateProfileRequest;
import com.ridehub.msuser.client.model.VerifyOtpRequestDTO;
import com.ridehub.msuser.client.model.VerifyOtpResponseDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface AuthResourceMsuserApi extends ApiClient.Api {


  /**
   * 
   * 
   * @param passwordResetRequestDTO  (required)
   * @return Map&lt;String, Object&gt;
   */
  @RequestLine("POST /api/auth/password-reset/complete")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  Map<String, Object> completePasswordReset(@jakarta.annotation.Nonnull PasswordResetRequestDTO passwordResetRequestDTO);

  /**
   * 
   * Similar to <code>completePasswordReset</code> but it also returns the http response headers .
   * 
   * @param passwordResetRequestDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/auth/password-reset/complete")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<Map<String, Object>> completePasswordResetWithHttpInfo(@jakarta.annotation.Nonnull PasswordResetRequestDTO passwordResetRequestDTO);



  /**
   * 
   * 
   * @param registrationCompleteRequestDTO  (required)
   * @return RegistrationCompleteResponseDTO
   */
  @RequestLine("POST /api/auth/register/complete")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  RegistrationCompleteResponseDTO completeRegistration(@jakarta.annotation.Nonnull RegistrationCompleteRequestDTO registrationCompleteRequestDTO);

  /**
   * 
   * Similar to <code>completeRegistration</code> but it also returns the http response headers .
   * 
   * @param registrationCompleteRequestDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/auth/register/complete")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<RegistrationCompleteResponseDTO> completeRegistrationWithHttpInfo(@jakarta.annotation.Nonnull RegistrationCompleteRequestDTO registrationCompleteRequestDTO);



  /**
   * 
   * 
   * @param createAdminRequest  (required)
   * @return Object
   */
  @RequestLine("POST /api/auth/create")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  Object create(@jakarta.annotation.Nonnull CreateAdminRequest createAdminRequest);

  /**
   * 
   * Similar to <code>create</code> but it also returns the http response headers .
   * 
   * @param createAdminRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/auth/create")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<Object> createWithHttpInfo(@jakarta.annotation.Nonnull CreateAdminRequest createAdminRequest);



  /**
   * 
   * 
   * @return Map&lt;String, Object&gt;
   */
  @RequestLine("GET /api/auth/health")
  @Headers({
    "Accept: */*",
  })
  Map<String, Object> healthCheck();

  /**
   * 
   * Similar to <code>healthCheck</code> but it also returns the http response headers .
   * 
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/auth/health")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Map<String, Object>> healthCheckWithHttpInfo();



  /**
   * 
   * 
   * @param loginRequestDTO  (required)
   * @return LoginResponseDTO
   */
  @RequestLine("POST /api/auth/login")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  LoginResponseDTO login(@jakarta.annotation.Nonnull LoginRequestDTO loginRequestDTO);

  /**
   * 
   * Similar to <code>login</code> but it also returns the http response headers .
   * 
   * @param loginRequestDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/auth/login")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<LoginResponseDTO> loginWithHttpInfo(@jakarta.annotation.Nonnull LoginRequestDTO loginRequestDTO);



  /**
   * 
   * 
   * @param body  (required)
   * @return Map&lt;String, Object&gt;
   */
  @RequestLine("POST /api/auth/logout")
  @Headers({
    "Content-Type: text/plain",
    "Accept: */*",
  })
  Map<String, Object> logout(@jakarta.annotation.Nonnull String body);

  /**
   * 
   * Similar to <code>logout</code> but it also returns the http response headers .
   * 
   * @param body  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/auth/logout")
  @Headers({
    "Content-Type: text/plain",
    "Accept: */*",
  })
  ApiResponse<Map<String, Object>> logoutWithHttpInfo(@jakarta.annotation.Nonnull String body);



  /**
   * 
   * 
   * @param body  (required)
   * @return LoginResponseDTO
   */
  @RequestLine("POST /api/auth/refresh")
  @Headers({
    "Content-Type: text/plain",
    "Accept: */*",
  })
  LoginResponseDTO refreshToken(@jakarta.annotation.Nonnull String body);

  /**
   * 
   * Similar to <code>refreshToken</code> but it also returns the http response headers .
   * 
   * @param body  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/auth/refresh")
  @Headers({
    "Content-Type: text/plain",
    "Accept: */*",
  })
  ApiResponse<LoginResponseDTO> refreshTokenWithHttpInfo(@jakarta.annotation.Nonnull String body);



  /**
   * 
   * 
   * @param sendOtpRequestDTO  (required)
   * @return SendOtpResponseDTO
   */
  @RequestLine("POST /api/auth/password-reset/request")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  SendOtpResponseDTO requestPasswordReset(@jakarta.annotation.Nonnull SendOtpRequestDTO sendOtpRequestDTO);

  /**
   * 
   * Similar to <code>requestPasswordReset</code> but it also returns the http response headers .
   * 
   * @param sendOtpRequestDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/auth/password-reset/request")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<SendOtpResponseDTO> requestPasswordResetWithHttpInfo(@jakarta.annotation.Nonnull SendOtpRequestDTO sendOtpRequestDTO);



  /**
   * 
   * 
   * @param sendOtpRequestDTO  (required)
   * @return SendOtpResponseDTO
   */
  @RequestLine("POST /api/auth/register/send-otp")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  SendOtpResponseDTO sendRegistrationOtp(@jakarta.annotation.Nonnull SendOtpRequestDTO sendOtpRequestDTO);

  /**
   * 
   * Similar to <code>sendRegistrationOtp</code> but it also returns the http response headers .
   * 
   * @param sendOtpRequestDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/auth/register/send-otp")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<SendOtpResponseDTO> sendRegistrationOtpWithHttpInfo(@jakarta.annotation.Nonnull SendOtpRequestDTO sendOtpRequestDTO);



  /**
   * 
   * 
   * @param keycloakId  (required)
   * @param adminUpdateUserRequest  (required)
   * @return Object
   */
  @RequestLine("PUT /api/auth/{keycloakId}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  Object updateDetails(@Param("keycloakId") @jakarta.annotation.Nonnull String keycloakId, @jakarta.annotation.Nonnull AdminUpdateUserRequest adminUpdateUserRequest);

  /**
   * 
   * Similar to <code>updateDetails</code> but it also returns the http response headers .
   * 
   * @param keycloakId  (required)
   * @param adminUpdateUserRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/auth/{keycloakId}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<Object> updateDetailsWithHttpInfo(@Param("keycloakId") @jakarta.annotation.Nonnull String keycloakId, @jakarta.annotation.Nonnull AdminUpdateUserRequest adminUpdateUserRequest);



  /**
   * 
   * 
   * @param keycloakId  (required)
   * @param adminUpdatePasswordRequest  (required)
   * @return Object
   */
  @RequestLine("PUT /api/auth/{keycloakId}/password")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  Object updatePassword(@Param("keycloakId") @jakarta.annotation.Nonnull String keycloakId, @jakarta.annotation.Nonnull AdminUpdatePasswordRequest adminUpdatePasswordRequest);

  /**
   * 
   * Similar to <code>updatePassword</code> but it also returns the http response headers .
   * 
   * @param keycloakId  (required)
   * @param adminUpdatePasswordRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/auth/{keycloakId}/password")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<Object> updatePasswordWithHttpInfo(@Param("keycloakId") @jakarta.annotation.Nonnull String keycloakId, @jakarta.annotation.Nonnull AdminUpdatePasswordRequest adminUpdatePasswordRequest);



  /**
   * 
   * 
   * @param authorization  (required)
   * @param updateProfileRequest  (required)
   * @return Map&lt;String, Object&gt;
   */
  @RequestLine("PUT /api/auth/profile")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
    "Authorization: {authorization}"
  })
  Map<String, Object> updateProfile1(@Param("authorization") @jakarta.annotation.Nonnull String authorization, @jakarta.annotation.Nonnull UpdateProfileRequest updateProfileRequest);

  /**
   * 
   * Similar to <code>updateProfile1</code> but it also returns the http response headers .
   * 
   * @param authorization  (required)
   * @param updateProfileRequest  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/auth/profile")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
    "Authorization: {authorization}"
  })
  ApiResponse<Map<String, Object>> updateProfile1WithHttpInfo(@Param("authorization") @jakarta.annotation.Nonnull String authorization, @jakarta.annotation.Nonnull UpdateProfileRequest updateProfileRequest);



  /**
   * 
   * 
   * @param verifyOtpRequestDTO  (required)
   * @return VerifyOtpResponseDTO
   */
  @RequestLine("POST /api/auth/password-reset/verify-otp")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  VerifyOtpResponseDTO verifyPasswordResetOtp(@jakarta.annotation.Nonnull VerifyOtpRequestDTO verifyOtpRequestDTO);

  /**
   * 
   * Similar to <code>verifyPasswordResetOtp</code> but it also returns the http response headers .
   * 
   * @param verifyOtpRequestDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/auth/password-reset/verify-otp")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<VerifyOtpResponseDTO> verifyPasswordResetOtpWithHttpInfo(@jakarta.annotation.Nonnull VerifyOtpRequestDTO verifyOtpRequestDTO);



  /**
   * 
   * 
   * @param verifyOtpRequestDTO  (required)
   * @return VerifyOtpResponseDTO
   */
  @RequestLine("POST /api/auth/register/verify-otp")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  VerifyOtpResponseDTO verifyRegistrationOtp(@jakarta.annotation.Nonnull VerifyOtpRequestDTO verifyOtpRequestDTO);

  /**
   * 
   * Similar to <code>verifyRegistrationOtp</code> but it also returns the http response headers .
   * 
   * @param verifyOtpRequestDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/auth/register/verify-otp")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<VerifyOtpResponseDTO> verifyRegistrationOtpWithHttpInfo(@jakarta.annotation.Nonnull VerifyOtpRequestDTO verifyOtpRequestDTO);


}
