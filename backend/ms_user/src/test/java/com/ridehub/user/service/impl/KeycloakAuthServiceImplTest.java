package com.ridehub.user.service.impl;

import com.ridehub.user.service.AppUserService;
import com.ridehub.user.service.dto.AppUserDTO;
import com.ridehub.user.service.dto.auth.LoginResponseDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

/**
 * Unit tests for {@link KeycloakAuthServiceImpl}.
 */
@ExtendWith(MockitoExtension.class)
class KeycloakAuthServiceImplTest {

    @Mock
    private AppUserService appUserService;

    @InjectMocks
    private KeycloakAuthServiceImpl keycloakAuthService;

    private LoginResponseDTO.UserInfoDTO userInfo;
    private UUID keycloakId;

    @BeforeEach
    void setUp() {
        keycloakId = UUID.randomUUID();
        userInfo = new LoginResponseDTO.UserInfoDTO();
        userInfo.setKeycloakId(keycloakId.toString());
        userInfo.setEmail("test@example.com");
        userInfo.setPhoneNumber("+1234567890");
        userInfo.setFirstName("John");
        userInfo.setLastName("Doe");
        userInfo.setUsername("johndoe");
        userInfo.setEmailVerified(true);
        userInfo.setPhoneVerified(false);
    }

    @Test
    void syncUserDataAfterLogin_shouldUpdateLastLoginForExistingUser() throws Exception {
        // Given
        AppUserDTO existingUser = new AppUserDTO();
        existingUser.setKeycloakId(keycloakId);
        when(appUserService.updateLastLogin(keycloakId)).thenReturn(Optional.of(existingUser));

        // When
        // Use reflection to call the private method
        java.lang.reflect.Method method = KeycloakAuthServiceImpl.class.getDeclaredMethod("syncUserDataAfterLogin", LoginResponseDTO.UserInfoDTO.class);
        method.setAccessible(true);
        method.invoke(keycloakAuthService, userInfo);

        // Then
        verify(appUserService).updateLastLogin(keycloakId);
        verify(appUserService, never()).syncUserAfterRegistration(any(), any(), any(), any(), any(), any(), any(), any());
    }

    @Test
    void syncUserDataAfterLogin_shouldCreateUserWhenNotExists() throws Exception {
        // Given
        when(appUserService.updateLastLogin(keycloakId)).thenReturn(Optional.empty());
        AppUserDTO newUser = new AppUserDTO();
        newUser.setKeycloakId(keycloakId);
        when(appUserService.syncUserAfterRegistration(any(), any(), any(), any(), any(), any(), any(), any()))
                .thenReturn(newUser);

        // When
        // Use reflection to call the private method
        java.lang.reflect.Method method = KeycloakAuthServiceImpl.class.getDeclaredMethod("syncUserDataAfterLogin", LoginResponseDTO.UserInfoDTO.class);
        method.setAccessible(true);
        method.invoke(keycloakAuthService, userInfo);

        // Then
        verify(appUserService).updateLastLogin(keycloakId);
        verify(appUserService).syncUserAfterRegistration(
                eq(keycloakId),
                eq("test@example.com"),
                eq("+1234567890"),
                eq("John"),
                eq("Doe"),
                eq(true), // isVerified (email is verified)
                eq(true), // isActive
                eq("johndoe") // username
        );
    }

    @Test
    void syncUserDataAfterLogin_shouldHandleNullKeycloakId() throws Exception {
        // Given
        userInfo.setKeycloakId(null);

        // When
        // Use reflection to call the private method
        java.lang.reflect.Method method = KeycloakAuthServiceImpl.class.getDeclaredMethod("syncUserDataAfterLogin", LoginResponseDTO.UserInfoDTO.class);
        method.setAccessible(true);
        method.invoke(keycloakAuthService, userInfo);

        // Then
        verify(appUserService, never()).updateLastLogin(any());
        verify(appUserService, never()).syncUserAfterRegistration(any(), any(), any(), any(), any(), any(), any(), any());
    }

    @Test
    void syncUserDataAfterLogin_shouldSetVerifiedTrueWhenEitherEmailOrPhoneVerified() throws Exception {
        // Given - phone verified but email not verified
        userInfo.setEmailVerified(false);
        userInfo.setPhoneVerified(true);
        when(appUserService.updateLastLogin(keycloakId)).thenReturn(Optional.empty());
        AppUserDTO newUser = new AppUserDTO();
        newUser.setKeycloakId(keycloakId);
        when(appUserService.syncUserAfterRegistration(any(), any(), any(), any(), any(), any(), any(), any()))
                .thenReturn(newUser);

        // When
        // Use reflection to call the private method
        java.lang.reflect.Method method = KeycloakAuthServiceImpl.class.getDeclaredMethod("syncUserDataAfterLogin", LoginResponseDTO.UserInfoDTO.class);
        method.setAccessible(true);
        method.invoke(keycloakAuthService, userInfo);

        // Then
        verify(appUserService).syncUserAfterRegistration(
                eq(keycloakId),
                eq("test@example.com"),
                eq("+1234567890"),
                eq("John"),
                eq("Doe"),
                eq(true), // isVerified (phone is verified)
                eq(true), // isActive
                eq("johndoe") // username
        );
    }

    @Test
    void syncUserDataAfterLogin_shouldSetVerifiedFalseWhenNeitherEmailNorPhoneVerified() throws Exception {
        // Given - neither email nor phone verified
        userInfo.setEmailVerified(false);
        userInfo.setPhoneVerified(false);
        when(appUserService.updateLastLogin(keycloakId)).thenReturn(Optional.empty());
        AppUserDTO newUser = new AppUserDTO();
        newUser.setKeycloakId(keycloakId);
        when(appUserService.syncUserAfterRegistration(any(), any(), any(), any(), any(), any(), any(), any()))
                .thenReturn(newUser);

        // When
        // Use reflection to call the private method
        java.lang.reflect.Method method = KeycloakAuthServiceImpl.class.getDeclaredMethod("syncUserDataAfterLogin", LoginResponseDTO.UserInfoDTO.class);
        method.setAccessible(true);
        method.invoke(keycloakAuthService, userInfo);

        // Then
        verify(appUserService).syncUserAfterRegistration(
                eq(keycloakId),
                eq("test@example.com"),
                eq("+1234567890"),
                eq("John"),
                eq("Doe"),
                eq(false), // isVerified (neither email nor phone verified)
                eq(true), // isActive
                eq("johndoe") // username
        );
    }
}
