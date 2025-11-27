package com.ridehub.msuser.client.api;

import com.ridehub.msuser.client.invoker.ApiClient;
import com.ridehub.msuser.client.invoker.EncodingUtils;
import com.ridehub.msuser.client.model.ApiResponse;

import com.ridehub.msuser.client.model.AppUserDTO;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface AppUserResourceMsuserApi extends ApiClient.Api {


  /**
   * 
   * 
   * @param idGreaterThan  (optional)
   * @param idLessThan  (optional)
   * @param idGreaterThanOrEqual  (optional)
   * @param idLessThanOrEqual  (optional)
   * @param idEquals  (optional)
   * @param idNotEquals  (optional)
   * @param idSpecified  (optional)
   * @param idIn  (optional)
   * @param idNotIn  (optional)
   * @param keycloakIdEquals  (optional)
   * @param keycloakIdNotEquals  (optional)
   * @param keycloakIdSpecified  (optional)
   * @param keycloakIdIn  (optional)
   * @param keycloakIdNotIn  (optional)
   * @param emailContains  (optional)
   * @param emailDoesNotContain  (optional)
   * @param emailEquals  (optional)
   * @param emailNotEquals  (optional)
   * @param emailSpecified  (optional)
   * @param emailIn  (optional)
   * @param emailNotIn  (optional)
   * @param phoneNumberContains  (optional)
   * @param phoneNumberDoesNotContain  (optional)
   * @param phoneNumberEquals  (optional)
   * @param phoneNumberNotEquals  (optional)
   * @param phoneNumberSpecified  (optional)
   * @param phoneNumberIn  (optional)
   * @param phoneNumberNotIn  (optional)
   * @param firstNameContains  (optional)
   * @param firstNameDoesNotContain  (optional)
   * @param firstNameEquals  (optional)
   * @param firstNameNotEquals  (optional)
   * @param firstNameSpecified  (optional)
   * @param firstNameIn  (optional)
   * @param firstNameNotIn  (optional)
   * @param lastNameContains  (optional)
   * @param lastNameDoesNotContain  (optional)
   * @param lastNameEquals  (optional)
   * @param lastNameNotEquals  (optional)
   * @param lastNameSpecified  (optional)
   * @param lastNameIn  (optional)
   * @param lastNameNotIn  (optional)
   * @param dateOfBirthGreaterThan  (optional)
   * @param dateOfBirthLessThan  (optional)
   * @param dateOfBirthGreaterThanOrEqual  (optional)
   * @param dateOfBirthLessThanOrEqual  (optional)
   * @param dateOfBirthEquals  (optional)
   * @param dateOfBirthNotEquals  (optional)
   * @param dateOfBirthSpecified  (optional)
   * @param dateOfBirthIn  (optional)
   * @param dateOfBirthNotIn  (optional)
   * @param isVerifiedEquals  (optional)
   * @param isVerifiedNotEquals  (optional)
   * @param isVerifiedSpecified  (optional)
   * @param isVerifiedIn  (optional)
   * @param isVerifiedNotIn  (optional)
   * @param isActiveEquals  (optional)
   * @param isActiveNotEquals  (optional)
   * @param isActiveSpecified  (optional)
   * @param isActiveIn  (optional)
   * @param isActiveNotIn  (optional)
   * @param lastLoginAtGreaterThan  (optional)
   * @param lastLoginAtLessThan  (optional)
   * @param lastLoginAtGreaterThanOrEqual  (optional)
   * @param lastLoginAtLessThanOrEqual  (optional)
   * @param lastLoginAtEquals  (optional)
   * @param lastLoginAtNotEquals  (optional)
   * @param lastLoginAtSpecified  (optional)
   * @param lastLoginAtIn  (optional)
   * @param lastLoginAtNotIn  (optional)
   * @param createdAtGreaterThan  (optional)
   * @param createdAtLessThan  (optional)
   * @param createdAtGreaterThanOrEqual  (optional)
   * @param createdAtLessThanOrEqual  (optional)
   * @param createdAtEquals  (optional)
   * @param createdAtNotEquals  (optional)
   * @param createdAtSpecified  (optional)
   * @param createdAtIn  (optional)
   * @param createdAtNotIn  (optional)
   * @param updatedAtGreaterThan  (optional)
   * @param updatedAtLessThan  (optional)
   * @param updatedAtGreaterThanOrEqual  (optional)
   * @param updatedAtLessThanOrEqual  (optional)
   * @param updatedAtEquals  (optional)
   * @param updatedAtNotEquals  (optional)
   * @param updatedAtSpecified  (optional)
   * @param updatedAtIn  (optional)
   * @param updatedAtNotIn  (optional)
   * @param isDeletedEquals  (optional)
   * @param isDeletedNotEquals  (optional)
   * @param isDeletedSpecified  (optional)
   * @param isDeletedIn  (optional)
   * @param isDeletedNotIn  (optional)
   * @param deletedAtGreaterThan  (optional)
   * @param deletedAtLessThan  (optional)
   * @param deletedAtGreaterThanOrEqual  (optional)
   * @param deletedAtLessThanOrEqual  (optional)
   * @param deletedAtEquals  (optional)
   * @param deletedAtNotEquals  (optional)
   * @param deletedAtSpecified  (optional)
   * @param deletedAtIn  (optional)
   * @param deletedAtNotIn  (optional)
   * @param deletedByEquals  (optional)
   * @param deletedByNotEquals  (optional)
   * @param deletedBySpecified  (optional)
   * @param deletedByIn  (optional)
   * @param deletedByNotIn  (optional)
   * @param profileIdGreaterThan  (optional)
   * @param profileIdLessThan  (optional)
   * @param profileIdGreaterThanOrEqual  (optional)
   * @param profileIdLessThanOrEqual  (optional)
   * @param profileIdEquals  (optional)
   * @param profileIdNotEquals  (optional)
   * @param profileIdSpecified  (optional)
   * @param profileIdIn  (optional)
   * @param profileIdNotIn  (optional)
   * @param distinct  (optional)
   * @return Long
   */
  @RequestLine("GET /api/app-users/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&keycloakId.equals={keycloakIdEquals}&keycloakId.notEquals={keycloakIdNotEquals}&keycloakId.specified={keycloakIdSpecified}&keycloakId.in={keycloakIdIn}&keycloakId.notIn={keycloakIdNotIn}&email.contains={emailContains}&email.doesNotContain={emailDoesNotContain}&email.equals={emailEquals}&email.notEquals={emailNotEquals}&email.specified={emailSpecified}&email.in={emailIn}&email.notIn={emailNotIn}&phoneNumber.contains={phoneNumberContains}&phoneNumber.doesNotContain={phoneNumberDoesNotContain}&phoneNumber.equals={phoneNumberEquals}&phoneNumber.notEquals={phoneNumberNotEquals}&phoneNumber.specified={phoneNumberSpecified}&phoneNumber.in={phoneNumberIn}&phoneNumber.notIn={phoneNumberNotIn}&firstName.contains={firstNameContains}&firstName.doesNotContain={firstNameDoesNotContain}&firstName.equals={firstNameEquals}&firstName.notEquals={firstNameNotEquals}&firstName.specified={firstNameSpecified}&firstName.in={firstNameIn}&firstName.notIn={firstNameNotIn}&lastName.contains={lastNameContains}&lastName.doesNotContain={lastNameDoesNotContain}&lastName.equals={lastNameEquals}&lastName.notEquals={lastNameNotEquals}&lastName.specified={lastNameSpecified}&lastName.in={lastNameIn}&lastName.notIn={lastNameNotIn}&dateOfBirth.greaterThan={dateOfBirthGreaterThan}&dateOfBirth.lessThan={dateOfBirthLessThan}&dateOfBirth.greaterThanOrEqual={dateOfBirthGreaterThanOrEqual}&dateOfBirth.lessThanOrEqual={dateOfBirthLessThanOrEqual}&dateOfBirth.equals={dateOfBirthEquals}&dateOfBirth.notEquals={dateOfBirthNotEquals}&dateOfBirth.specified={dateOfBirthSpecified}&dateOfBirth.in={dateOfBirthIn}&dateOfBirth.notIn={dateOfBirthNotIn}&isVerified.equals={isVerifiedEquals}&isVerified.notEquals={isVerifiedNotEquals}&isVerified.specified={isVerifiedSpecified}&isVerified.in={isVerifiedIn}&isVerified.notIn={isVerifiedNotIn}&isActive.equals={isActiveEquals}&isActive.notEquals={isActiveNotEquals}&isActive.specified={isActiveSpecified}&isActive.in={isActiveIn}&isActive.notIn={isActiveNotIn}&lastLoginAt.greaterThan={lastLoginAtGreaterThan}&lastLoginAt.lessThan={lastLoginAtLessThan}&lastLoginAt.greaterThanOrEqual={lastLoginAtGreaterThanOrEqual}&lastLoginAt.lessThanOrEqual={lastLoginAtLessThanOrEqual}&lastLoginAt.equals={lastLoginAtEquals}&lastLoginAt.notEquals={lastLoginAtNotEquals}&lastLoginAt.specified={lastLoginAtSpecified}&lastLoginAt.in={lastLoginAtIn}&lastLoginAt.notIn={lastLoginAtNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&profileId.greaterThan={profileIdGreaterThan}&profileId.lessThan={profileIdLessThan}&profileId.greaterThanOrEqual={profileIdGreaterThanOrEqual}&profileId.lessThanOrEqual={profileIdLessThanOrEqual}&profileId.equals={profileIdEquals}&profileId.notEquals={profileIdNotEquals}&profileId.specified={profileIdSpecified}&profileId.in={profileIdIn}&profileId.notIn={profileIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  Long countAppUsers(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("keycloakIdEquals") @jakarta.annotation.Nullable UUID keycloakIdEquals, @Param("keycloakIdNotEquals") @jakarta.annotation.Nullable UUID keycloakIdNotEquals, @Param("keycloakIdSpecified") @jakarta.annotation.Nullable Boolean keycloakIdSpecified, @Param("keycloakIdIn") @jakarta.annotation.Nullable List<UUID> keycloakIdIn, @Param("keycloakIdNotIn") @jakarta.annotation.Nullable List<UUID> keycloakIdNotIn, @Param("emailContains") @jakarta.annotation.Nullable String emailContains, @Param("emailDoesNotContain") @jakarta.annotation.Nullable String emailDoesNotContain, @Param("emailEquals") @jakarta.annotation.Nullable String emailEquals, @Param("emailNotEquals") @jakarta.annotation.Nullable String emailNotEquals, @Param("emailSpecified") @jakarta.annotation.Nullable Boolean emailSpecified, @Param("emailIn") @jakarta.annotation.Nullable List<String> emailIn, @Param("emailNotIn") @jakarta.annotation.Nullable List<String> emailNotIn, @Param("phoneNumberContains") @jakarta.annotation.Nullable String phoneNumberContains, @Param("phoneNumberDoesNotContain") @jakarta.annotation.Nullable String phoneNumberDoesNotContain, @Param("phoneNumberEquals") @jakarta.annotation.Nullable String phoneNumberEquals, @Param("phoneNumberNotEquals") @jakarta.annotation.Nullable String phoneNumberNotEquals, @Param("phoneNumberSpecified") @jakarta.annotation.Nullable Boolean phoneNumberSpecified, @Param("phoneNumberIn") @jakarta.annotation.Nullable List<String> phoneNumberIn, @Param("phoneNumberNotIn") @jakarta.annotation.Nullable List<String> phoneNumberNotIn, @Param("firstNameContains") @jakarta.annotation.Nullable String firstNameContains, @Param("firstNameDoesNotContain") @jakarta.annotation.Nullable String firstNameDoesNotContain, @Param("firstNameEquals") @jakarta.annotation.Nullable String firstNameEquals, @Param("firstNameNotEquals") @jakarta.annotation.Nullable String firstNameNotEquals, @Param("firstNameSpecified") @jakarta.annotation.Nullable Boolean firstNameSpecified, @Param("firstNameIn") @jakarta.annotation.Nullable List<String> firstNameIn, @Param("firstNameNotIn") @jakarta.annotation.Nullable List<String> firstNameNotIn, @Param("lastNameContains") @jakarta.annotation.Nullable String lastNameContains, @Param("lastNameDoesNotContain") @jakarta.annotation.Nullable String lastNameDoesNotContain, @Param("lastNameEquals") @jakarta.annotation.Nullable String lastNameEquals, @Param("lastNameNotEquals") @jakarta.annotation.Nullable String lastNameNotEquals, @Param("lastNameSpecified") @jakarta.annotation.Nullable Boolean lastNameSpecified, @Param("lastNameIn") @jakarta.annotation.Nullable List<String> lastNameIn, @Param("lastNameNotIn") @jakarta.annotation.Nullable List<String> lastNameNotIn, @Param("dateOfBirthGreaterThan") @jakarta.annotation.Nullable LocalDate dateOfBirthGreaterThan, @Param("dateOfBirthLessThan") @jakarta.annotation.Nullable LocalDate dateOfBirthLessThan, @Param("dateOfBirthGreaterThanOrEqual") @jakarta.annotation.Nullable LocalDate dateOfBirthGreaterThanOrEqual, @Param("dateOfBirthLessThanOrEqual") @jakarta.annotation.Nullable LocalDate dateOfBirthLessThanOrEqual, @Param("dateOfBirthEquals") @jakarta.annotation.Nullable LocalDate dateOfBirthEquals, @Param("dateOfBirthNotEquals") @jakarta.annotation.Nullable LocalDate dateOfBirthNotEquals, @Param("dateOfBirthSpecified") @jakarta.annotation.Nullable Boolean dateOfBirthSpecified, @Param("dateOfBirthIn") @jakarta.annotation.Nullable List<LocalDate> dateOfBirthIn, @Param("dateOfBirthNotIn") @jakarta.annotation.Nullable List<LocalDate> dateOfBirthNotIn, @Param("isVerifiedEquals") @jakarta.annotation.Nullable Boolean isVerifiedEquals, @Param("isVerifiedNotEquals") @jakarta.annotation.Nullable Boolean isVerifiedNotEquals, @Param("isVerifiedSpecified") @jakarta.annotation.Nullable Boolean isVerifiedSpecified, @Param("isVerifiedIn") @jakarta.annotation.Nullable List<Boolean> isVerifiedIn, @Param("isVerifiedNotIn") @jakarta.annotation.Nullable List<Boolean> isVerifiedNotIn, @Param("isActiveEquals") @jakarta.annotation.Nullable Boolean isActiveEquals, @Param("isActiveNotEquals") @jakarta.annotation.Nullable Boolean isActiveNotEquals, @Param("isActiveSpecified") @jakarta.annotation.Nullable Boolean isActiveSpecified, @Param("isActiveIn") @jakarta.annotation.Nullable List<Boolean> isActiveIn, @Param("isActiveNotIn") @jakarta.annotation.Nullable List<Boolean> isActiveNotIn, @Param("lastLoginAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime lastLoginAtGreaterThan, @Param("lastLoginAtLessThan") @jakarta.annotation.Nullable OffsetDateTime lastLoginAtLessThan, @Param("lastLoginAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime lastLoginAtGreaterThanOrEqual, @Param("lastLoginAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime lastLoginAtLessThanOrEqual, @Param("lastLoginAtEquals") @jakarta.annotation.Nullable OffsetDateTime lastLoginAtEquals, @Param("lastLoginAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime lastLoginAtNotEquals, @Param("lastLoginAtSpecified") @jakarta.annotation.Nullable Boolean lastLoginAtSpecified, @Param("lastLoginAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> lastLoginAtIn, @Param("lastLoginAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> lastLoginAtNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("profileIdGreaterThan") @jakarta.annotation.Nullable Long profileIdGreaterThan, @Param("profileIdLessThan") @jakarta.annotation.Nullable Long profileIdLessThan, @Param("profileIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long profileIdGreaterThanOrEqual, @Param("profileIdLessThanOrEqual") @jakarta.annotation.Nullable Long profileIdLessThanOrEqual, @Param("profileIdEquals") @jakarta.annotation.Nullable Long profileIdEquals, @Param("profileIdNotEquals") @jakarta.annotation.Nullable Long profileIdNotEquals, @Param("profileIdSpecified") @jakarta.annotation.Nullable Boolean profileIdSpecified, @Param("profileIdIn") @jakarta.annotation.Nullable List<Long> profileIdIn, @Param("profileIdNotIn") @jakarta.annotation.Nullable List<Long> profileIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>countAppUsers</code> but it also returns the http response headers .
   * 
   * @param idGreaterThan  (optional)
   * @param idLessThan  (optional)
   * @param idGreaterThanOrEqual  (optional)
   * @param idLessThanOrEqual  (optional)
   * @param idEquals  (optional)
   * @param idNotEquals  (optional)
   * @param idSpecified  (optional)
   * @param idIn  (optional)
   * @param idNotIn  (optional)
   * @param keycloakIdEquals  (optional)
   * @param keycloakIdNotEquals  (optional)
   * @param keycloakIdSpecified  (optional)
   * @param keycloakIdIn  (optional)
   * @param keycloakIdNotIn  (optional)
   * @param emailContains  (optional)
   * @param emailDoesNotContain  (optional)
   * @param emailEquals  (optional)
   * @param emailNotEquals  (optional)
   * @param emailSpecified  (optional)
   * @param emailIn  (optional)
   * @param emailNotIn  (optional)
   * @param phoneNumberContains  (optional)
   * @param phoneNumberDoesNotContain  (optional)
   * @param phoneNumberEquals  (optional)
   * @param phoneNumberNotEquals  (optional)
   * @param phoneNumberSpecified  (optional)
   * @param phoneNumberIn  (optional)
   * @param phoneNumberNotIn  (optional)
   * @param firstNameContains  (optional)
   * @param firstNameDoesNotContain  (optional)
   * @param firstNameEquals  (optional)
   * @param firstNameNotEquals  (optional)
   * @param firstNameSpecified  (optional)
   * @param firstNameIn  (optional)
   * @param firstNameNotIn  (optional)
   * @param lastNameContains  (optional)
   * @param lastNameDoesNotContain  (optional)
   * @param lastNameEquals  (optional)
   * @param lastNameNotEquals  (optional)
   * @param lastNameSpecified  (optional)
   * @param lastNameIn  (optional)
   * @param lastNameNotIn  (optional)
   * @param dateOfBirthGreaterThan  (optional)
   * @param dateOfBirthLessThan  (optional)
   * @param dateOfBirthGreaterThanOrEqual  (optional)
   * @param dateOfBirthLessThanOrEqual  (optional)
   * @param dateOfBirthEquals  (optional)
   * @param dateOfBirthNotEquals  (optional)
   * @param dateOfBirthSpecified  (optional)
   * @param dateOfBirthIn  (optional)
   * @param dateOfBirthNotIn  (optional)
   * @param isVerifiedEquals  (optional)
   * @param isVerifiedNotEquals  (optional)
   * @param isVerifiedSpecified  (optional)
   * @param isVerifiedIn  (optional)
   * @param isVerifiedNotIn  (optional)
   * @param isActiveEquals  (optional)
   * @param isActiveNotEquals  (optional)
   * @param isActiveSpecified  (optional)
   * @param isActiveIn  (optional)
   * @param isActiveNotIn  (optional)
   * @param lastLoginAtGreaterThan  (optional)
   * @param lastLoginAtLessThan  (optional)
   * @param lastLoginAtGreaterThanOrEqual  (optional)
   * @param lastLoginAtLessThanOrEqual  (optional)
   * @param lastLoginAtEquals  (optional)
   * @param lastLoginAtNotEquals  (optional)
   * @param lastLoginAtSpecified  (optional)
   * @param lastLoginAtIn  (optional)
   * @param lastLoginAtNotIn  (optional)
   * @param createdAtGreaterThan  (optional)
   * @param createdAtLessThan  (optional)
   * @param createdAtGreaterThanOrEqual  (optional)
   * @param createdAtLessThanOrEqual  (optional)
   * @param createdAtEquals  (optional)
   * @param createdAtNotEquals  (optional)
   * @param createdAtSpecified  (optional)
   * @param createdAtIn  (optional)
   * @param createdAtNotIn  (optional)
   * @param updatedAtGreaterThan  (optional)
   * @param updatedAtLessThan  (optional)
   * @param updatedAtGreaterThanOrEqual  (optional)
   * @param updatedAtLessThanOrEqual  (optional)
   * @param updatedAtEquals  (optional)
   * @param updatedAtNotEquals  (optional)
   * @param updatedAtSpecified  (optional)
   * @param updatedAtIn  (optional)
   * @param updatedAtNotIn  (optional)
   * @param isDeletedEquals  (optional)
   * @param isDeletedNotEquals  (optional)
   * @param isDeletedSpecified  (optional)
   * @param isDeletedIn  (optional)
   * @param isDeletedNotIn  (optional)
   * @param deletedAtGreaterThan  (optional)
   * @param deletedAtLessThan  (optional)
   * @param deletedAtGreaterThanOrEqual  (optional)
   * @param deletedAtLessThanOrEqual  (optional)
   * @param deletedAtEquals  (optional)
   * @param deletedAtNotEquals  (optional)
   * @param deletedAtSpecified  (optional)
   * @param deletedAtIn  (optional)
   * @param deletedAtNotIn  (optional)
   * @param deletedByEquals  (optional)
   * @param deletedByNotEquals  (optional)
   * @param deletedBySpecified  (optional)
   * @param deletedByIn  (optional)
   * @param deletedByNotIn  (optional)
   * @param profileIdGreaterThan  (optional)
   * @param profileIdLessThan  (optional)
   * @param profileIdGreaterThanOrEqual  (optional)
   * @param profileIdLessThanOrEqual  (optional)
   * @param profileIdEquals  (optional)
   * @param profileIdNotEquals  (optional)
   * @param profileIdSpecified  (optional)
   * @param profileIdIn  (optional)
   * @param profileIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/app-users/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&keycloakId.equals={keycloakIdEquals}&keycloakId.notEquals={keycloakIdNotEquals}&keycloakId.specified={keycloakIdSpecified}&keycloakId.in={keycloakIdIn}&keycloakId.notIn={keycloakIdNotIn}&email.contains={emailContains}&email.doesNotContain={emailDoesNotContain}&email.equals={emailEquals}&email.notEquals={emailNotEquals}&email.specified={emailSpecified}&email.in={emailIn}&email.notIn={emailNotIn}&phoneNumber.contains={phoneNumberContains}&phoneNumber.doesNotContain={phoneNumberDoesNotContain}&phoneNumber.equals={phoneNumberEquals}&phoneNumber.notEquals={phoneNumberNotEquals}&phoneNumber.specified={phoneNumberSpecified}&phoneNumber.in={phoneNumberIn}&phoneNumber.notIn={phoneNumberNotIn}&firstName.contains={firstNameContains}&firstName.doesNotContain={firstNameDoesNotContain}&firstName.equals={firstNameEquals}&firstName.notEquals={firstNameNotEquals}&firstName.specified={firstNameSpecified}&firstName.in={firstNameIn}&firstName.notIn={firstNameNotIn}&lastName.contains={lastNameContains}&lastName.doesNotContain={lastNameDoesNotContain}&lastName.equals={lastNameEquals}&lastName.notEquals={lastNameNotEquals}&lastName.specified={lastNameSpecified}&lastName.in={lastNameIn}&lastName.notIn={lastNameNotIn}&dateOfBirth.greaterThan={dateOfBirthGreaterThan}&dateOfBirth.lessThan={dateOfBirthLessThan}&dateOfBirth.greaterThanOrEqual={dateOfBirthGreaterThanOrEqual}&dateOfBirth.lessThanOrEqual={dateOfBirthLessThanOrEqual}&dateOfBirth.equals={dateOfBirthEquals}&dateOfBirth.notEquals={dateOfBirthNotEquals}&dateOfBirth.specified={dateOfBirthSpecified}&dateOfBirth.in={dateOfBirthIn}&dateOfBirth.notIn={dateOfBirthNotIn}&isVerified.equals={isVerifiedEquals}&isVerified.notEquals={isVerifiedNotEquals}&isVerified.specified={isVerifiedSpecified}&isVerified.in={isVerifiedIn}&isVerified.notIn={isVerifiedNotIn}&isActive.equals={isActiveEquals}&isActive.notEquals={isActiveNotEquals}&isActive.specified={isActiveSpecified}&isActive.in={isActiveIn}&isActive.notIn={isActiveNotIn}&lastLoginAt.greaterThan={lastLoginAtGreaterThan}&lastLoginAt.lessThan={lastLoginAtLessThan}&lastLoginAt.greaterThanOrEqual={lastLoginAtGreaterThanOrEqual}&lastLoginAt.lessThanOrEqual={lastLoginAtLessThanOrEqual}&lastLoginAt.equals={lastLoginAtEquals}&lastLoginAt.notEquals={lastLoginAtNotEquals}&lastLoginAt.specified={lastLoginAtSpecified}&lastLoginAt.in={lastLoginAtIn}&lastLoginAt.notIn={lastLoginAtNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&profileId.greaterThan={profileIdGreaterThan}&profileId.lessThan={profileIdLessThan}&profileId.greaterThanOrEqual={profileIdGreaterThanOrEqual}&profileId.lessThanOrEqual={profileIdLessThanOrEqual}&profileId.equals={profileIdEquals}&profileId.notEquals={profileIdNotEquals}&profileId.specified={profileIdSpecified}&profileId.in={profileIdIn}&profileId.notIn={profileIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Long> countAppUsersWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("keycloakIdEquals") @jakarta.annotation.Nullable UUID keycloakIdEquals, @Param("keycloakIdNotEquals") @jakarta.annotation.Nullable UUID keycloakIdNotEquals, @Param("keycloakIdSpecified") @jakarta.annotation.Nullable Boolean keycloakIdSpecified, @Param("keycloakIdIn") @jakarta.annotation.Nullable List<UUID> keycloakIdIn, @Param("keycloakIdNotIn") @jakarta.annotation.Nullable List<UUID> keycloakIdNotIn, @Param("emailContains") @jakarta.annotation.Nullable String emailContains, @Param("emailDoesNotContain") @jakarta.annotation.Nullable String emailDoesNotContain, @Param("emailEquals") @jakarta.annotation.Nullable String emailEquals, @Param("emailNotEquals") @jakarta.annotation.Nullable String emailNotEquals, @Param("emailSpecified") @jakarta.annotation.Nullable Boolean emailSpecified, @Param("emailIn") @jakarta.annotation.Nullable List<String> emailIn, @Param("emailNotIn") @jakarta.annotation.Nullable List<String> emailNotIn, @Param("phoneNumberContains") @jakarta.annotation.Nullable String phoneNumberContains, @Param("phoneNumberDoesNotContain") @jakarta.annotation.Nullable String phoneNumberDoesNotContain, @Param("phoneNumberEquals") @jakarta.annotation.Nullable String phoneNumberEquals, @Param("phoneNumberNotEquals") @jakarta.annotation.Nullable String phoneNumberNotEquals, @Param("phoneNumberSpecified") @jakarta.annotation.Nullable Boolean phoneNumberSpecified, @Param("phoneNumberIn") @jakarta.annotation.Nullable List<String> phoneNumberIn, @Param("phoneNumberNotIn") @jakarta.annotation.Nullable List<String> phoneNumberNotIn, @Param("firstNameContains") @jakarta.annotation.Nullable String firstNameContains, @Param("firstNameDoesNotContain") @jakarta.annotation.Nullable String firstNameDoesNotContain, @Param("firstNameEquals") @jakarta.annotation.Nullable String firstNameEquals, @Param("firstNameNotEquals") @jakarta.annotation.Nullable String firstNameNotEquals, @Param("firstNameSpecified") @jakarta.annotation.Nullable Boolean firstNameSpecified, @Param("firstNameIn") @jakarta.annotation.Nullable List<String> firstNameIn, @Param("firstNameNotIn") @jakarta.annotation.Nullable List<String> firstNameNotIn, @Param("lastNameContains") @jakarta.annotation.Nullable String lastNameContains, @Param("lastNameDoesNotContain") @jakarta.annotation.Nullable String lastNameDoesNotContain, @Param("lastNameEquals") @jakarta.annotation.Nullable String lastNameEquals, @Param("lastNameNotEquals") @jakarta.annotation.Nullable String lastNameNotEquals, @Param("lastNameSpecified") @jakarta.annotation.Nullable Boolean lastNameSpecified, @Param("lastNameIn") @jakarta.annotation.Nullable List<String> lastNameIn, @Param("lastNameNotIn") @jakarta.annotation.Nullable List<String> lastNameNotIn, @Param("dateOfBirthGreaterThan") @jakarta.annotation.Nullable LocalDate dateOfBirthGreaterThan, @Param("dateOfBirthLessThan") @jakarta.annotation.Nullable LocalDate dateOfBirthLessThan, @Param("dateOfBirthGreaterThanOrEqual") @jakarta.annotation.Nullable LocalDate dateOfBirthGreaterThanOrEqual, @Param("dateOfBirthLessThanOrEqual") @jakarta.annotation.Nullable LocalDate dateOfBirthLessThanOrEqual, @Param("dateOfBirthEquals") @jakarta.annotation.Nullable LocalDate dateOfBirthEquals, @Param("dateOfBirthNotEquals") @jakarta.annotation.Nullable LocalDate dateOfBirthNotEquals, @Param("dateOfBirthSpecified") @jakarta.annotation.Nullable Boolean dateOfBirthSpecified, @Param("dateOfBirthIn") @jakarta.annotation.Nullable List<LocalDate> dateOfBirthIn, @Param("dateOfBirthNotIn") @jakarta.annotation.Nullable List<LocalDate> dateOfBirthNotIn, @Param("isVerifiedEquals") @jakarta.annotation.Nullable Boolean isVerifiedEquals, @Param("isVerifiedNotEquals") @jakarta.annotation.Nullable Boolean isVerifiedNotEquals, @Param("isVerifiedSpecified") @jakarta.annotation.Nullable Boolean isVerifiedSpecified, @Param("isVerifiedIn") @jakarta.annotation.Nullable List<Boolean> isVerifiedIn, @Param("isVerifiedNotIn") @jakarta.annotation.Nullable List<Boolean> isVerifiedNotIn, @Param("isActiveEquals") @jakarta.annotation.Nullable Boolean isActiveEquals, @Param("isActiveNotEquals") @jakarta.annotation.Nullable Boolean isActiveNotEquals, @Param("isActiveSpecified") @jakarta.annotation.Nullable Boolean isActiveSpecified, @Param("isActiveIn") @jakarta.annotation.Nullable List<Boolean> isActiveIn, @Param("isActiveNotIn") @jakarta.annotation.Nullable List<Boolean> isActiveNotIn, @Param("lastLoginAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime lastLoginAtGreaterThan, @Param("lastLoginAtLessThan") @jakarta.annotation.Nullable OffsetDateTime lastLoginAtLessThan, @Param("lastLoginAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime lastLoginAtGreaterThanOrEqual, @Param("lastLoginAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime lastLoginAtLessThanOrEqual, @Param("lastLoginAtEquals") @jakarta.annotation.Nullable OffsetDateTime lastLoginAtEquals, @Param("lastLoginAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime lastLoginAtNotEquals, @Param("lastLoginAtSpecified") @jakarta.annotation.Nullable Boolean lastLoginAtSpecified, @Param("lastLoginAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> lastLoginAtIn, @Param("lastLoginAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> lastLoginAtNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("profileIdGreaterThan") @jakarta.annotation.Nullable Long profileIdGreaterThan, @Param("profileIdLessThan") @jakarta.annotation.Nullable Long profileIdLessThan, @Param("profileIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long profileIdGreaterThanOrEqual, @Param("profileIdLessThanOrEqual") @jakarta.annotation.Nullable Long profileIdLessThanOrEqual, @Param("profileIdEquals") @jakarta.annotation.Nullable Long profileIdEquals, @Param("profileIdNotEquals") @jakarta.annotation.Nullable Long profileIdNotEquals, @Param("profileIdSpecified") @jakarta.annotation.Nullable Boolean profileIdSpecified, @Param("profileIdIn") @jakarta.annotation.Nullable List<Long> profileIdIn, @Param("profileIdNotIn") @jakarta.annotation.Nullable List<Long> profileIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>countAppUsers</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CountAppUsersQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>idGreaterThan -  (optional)</li>
   *   <li>idLessThan -  (optional)</li>
   *   <li>idGreaterThanOrEqual -  (optional)</li>
   *   <li>idLessThanOrEqual -  (optional)</li>
   *   <li>idEquals -  (optional)</li>
   *   <li>idNotEquals -  (optional)</li>
   *   <li>idSpecified -  (optional)</li>
   *   <li>idIn -  (optional)</li>
   *   <li>idNotIn -  (optional)</li>
   *   <li>keycloakIdEquals -  (optional)</li>
   *   <li>keycloakIdNotEquals -  (optional)</li>
   *   <li>keycloakIdSpecified -  (optional)</li>
   *   <li>keycloakIdIn -  (optional)</li>
   *   <li>keycloakIdNotIn -  (optional)</li>
   *   <li>emailContains -  (optional)</li>
   *   <li>emailDoesNotContain -  (optional)</li>
   *   <li>emailEquals -  (optional)</li>
   *   <li>emailNotEquals -  (optional)</li>
   *   <li>emailSpecified -  (optional)</li>
   *   <li>emailIn -  (optional)</li>
   *   <li>emailNotIn -  (optional)</li>
   *   <li>phoneNumberContains -  (optional)</li>
   *   <li>phoneNumberDoesNotContain -  (optional)</li>
   *   <li>phoneNumberEquals -  (optional)</li>
   *   <li>phoneNumberNotEquals -  (optional)</li>
   *   <li>phoneNumberSpecified -  (optional)</li>
   *   <li>phoneNumberIn -  (optional)</li>
   *   <li>phoneNumberNotIn -  (optional)</li>
   *   <li>firstNameContains -  (optional)</li>
   *   <li>firstNameDoesNotContain -  (optional)</li>
   *   <li>firstNameEquals -  (optional)</li>
   *   <li>firstNameNotEquals -  (optional)</li>
   *   <li>firstNameSpecified -  (optional)</li>
   *   <li>firstNameIn -  (optional)</li>
   *   <li>firstNameNotIn -  (optional)</li>
   *   <li>lastNameContains -  (optional)</li>
   *   <li>lastNameDoesNotContain -  (optional)</li>
   *   <li>lastNameEquals -  (optional)</li>
   *   <li>lastNameNotEquals -  (optional)</li>
   *   <li>lastNameSpecified -  (optional)</li>
   *   <li>lastNameIn -  (optional)</li>
   *   <li>lastNameNotIn -  (optional)</li>
   *   <li>dateOfBirthGreaterThan -  (optional)</li>
   *   <li>dateOfBirthLessThan -  (optional)</li>
   *   <li>dateOfBirthGreaterThanOrEqual -  (optional)</li>
   *   <li>dateOfBirthLessThanOrEqual -  (optional)</li>
   *   <li>dateOfBirthEquals -  (optional)</li>
   *   <li>dateOfBirthNotEquals -  (optional)</li>
   *   <li>dateOfBirthSpecified -  (optional)</li>
   *   <li>dateOfBirthIn -  (optional)</li>
   *   <li>dateOfBirthNotIn -  (optional)</li>
   *   <li>isVerifiedEquals -  (optional)</li>
   *   <li>isVerifiedNotEquals -  (optional)</li>
   *   <li>isVerifiedSpecified -  (optional)</li>
   *   <li>isVerifiedIn -  (optional)</li>
   *   <li>isVerifiedNotIn -  (optional)</li>
   *   <li>isActiveEquals -  (optional)</li>
   *   <li>isActiveNotEquals -  (optional)</li>
   *   <li>isActiveSpecified -  (optional)</li>
   *   <li>isActiveIn -  (optional)</li>
   *   <li>isActiveNotIn -  (optional)</li>
   *   <li>lastLoginAtGreaterThan -  (optional)</li>
   *   <li>lastLoginAtLessThan -  (optional)</li>
   *   <li>lastLoginAtGreaterThanOrEqual -  (optional)</li>
   *   <li>lastLoginAtLessThanOrEqual -  (optional)</li>
   *   <li>lastLoginAtEquals -  (optional)</li>
   *   <li>lastLoginAtNotEquals -  (optional)</li>
   *   <li>lastLoginAtSpecified -  (optional)</li>
   *   <li>lastLoginAtIn -  (optional)</li>
   *   <li>lastLoginAtNotIn -  (optional)</li>
   *   <li>createdAtGreaterThan -  (optional)</li>
   *   <li>createdAtLessThan -  (optional)</li>
   *   <li>createdAtGreaterThanOrEqual -  (optional)</li>
   *   <li>createdAtLessThanOrEqual -  (optional)</li>
   *   <li>createdAtEquals -  (optional)</li>
   *   <li>createdAtNotEquals -  (optional)</li>
   *   <li>createdAtSpecified -  (optional)</li>
   *   <li>createdAtIn -  (optional)</li>
   *   <li>createdAtNotIn -  (optional)</li>
   *   <li>updatedAtGreaterThan -  (optional)</li>
   *   <li>updatedAtLessThan -  (optional)</li>
   *   <li>updatedAtGreaterThanOrEqual -  (optional)</li>
   *   <li>updatedAtLessThanOrEqual -  (optional)</li>
   *   <li>updatedAtEquals -  (optional)</li>
   *   <li>updatedAtNotEquals -  (optional)</li>
   *   <li>updatedAtSpecified -  (optional)</li>
   *   <li>updatedAtIn -  (optional)</li>
   *   <li>updatedAtNotIn -  (optional)</li>
   *   <li>isDeletedEquals -  (optional)</li>
   *   <li>isDeletedNotEquals -  (optional)</li>
   *   <li>isDeletedSpecified -  (optional)</li>
   *   <li>isDeletedIn -  (optional)</li>
   *   <li>isDeletedNotIn -  (optional)</li>
   *   <li>deletedAtGreaterThan -  (optional)</li>
   *   <li>deletedAtLessThan -  (optional)</li>
   *   <li>deletedAtGreaterThanOrEqual -  (optional)</li>
   *   <li>deletedAtLessThanOrEqual -  (optional)</li>
   *   <li>deletedAtEquals -  (optional)</li>
   *   <li>deletedAtNotEquals -  (optional)</li>
   *   <li>deletedAtSpecified -  (optional)</li>
   *   <li>deletedAtIn -  (optional)</li>
   *   <li>deletedAtNotIn -  (optional)</li>
   *   <li>deletedByEquals -  (optional)</li>
   *   <li>deletedByNotEquals -  (optional)</li>
   *   <li>deletedBySpecified -  (optional)</li>
   *   <li>deletedByIn -  (optional)</li>
   *   <li>deletedByNotIn -  (optional)</li>
   *   <li>profileIdGreaterThan -  (optional)</li>
   *   <li>profileIdLessThan -  (optional)</li>
   *   <li>profileIdGreaterThanOrEqual -  (optional)</li>
   *   <li>profileIdLessThanOrEqual -  (optional)</li>
   *   <li>profileIdEquals -  (optional)</li>
   *   <li>profileIdNotEquals -  (optional)</li>
   *   <li>profileIdSpecified -  (optional)</li>
   *   <li>profileIdIn -  (optional)</li>
   *   <li>profileIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return Long
   */
  @RequestLine("GET /api/app-users/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&keycloakId.equals={keycloakIdEquals}&keycloakId.notEquals={keycloakIdNotEquals}&keycloakId.specified={keycloakIdSpecified}&keycloakId.in={keycloakIdIn}&keycloakId.notIn={keycloakIdNotIn}&email.contains={emailContains}&email.doesNotContain={emailDoesNotContain}&email.equals={emailEquals}&email.notEquals={emailNotEquals}&email.specified={emailSpecified}&email.in={emailIn}&email.notIn={emailNotIn}&phoneNumber.contains={phoneNumberContains}&phoneNumber.doesNotContain={phoneNumberDoesNotContain}&phoneNumber.equals={phoneNumberEquals}&phoneNumber.notEquals={phoneNumberNotEquals}&phoneNumber.specified={phoneNumberSpecified}&phoneNumber.in={phoneNumberIn}&phoneNumber.notIn={phoneNumberNotIn}&firstName.contains={firstNameContains}&firstName.doesNotContain={firstNameDoesNotContain}&firstName.equals={firstNameEquals}&firstName.notEquals={firstNameNotEquals}&firstName.specified={firstNameSpecified}&firstName.in={firstNameIn}&firstName.notIn={firstNameNotIn}&lastName.contains={lastNameContains}&lastName.doesNotContain={lastNameDoesNotContain}&lastName.equals={lastNameEquals}&lastName.notEquals={lastNameNotEquals}&lastName.specified={lastNameSpecified}&lastName.in={lastNameIn}&lastName.notIn={lastNameNotIn}&dateOfBirth.greaterThan={dateOfBirthGreaterThan}&dateOfBirth.lessThan={dateOfBirthLessThan}&dateOfBirth.greaterThanOrEqual={dateOfBirthGreaterThanOrEqual}&dateOfBirth.lessThanOrEqual={dateOfBirthLessThanOrEqual}&dateOfBirth.equals={dateOfBirthEquals}&dateOfBirth.notEquals={dateOfBirthNotEquals}&dateOfBirth.specified={dateOfBirthSpecified}&dateOfBirth.in={dateOfBirthIn}&dateOfBirth.notIn={dateOfBirthNotIn}&isVerified.equals={isVerifiedEquals}&isVerified.notEquals={isVerifiedNotEquals}&isVerified.specified={isVerifiedSpecified}&isVerified.in={isVerifiedIn}&isVerified.notIn={isVerifiedNotIn}&isActive.equals={isActiveEquals}&isActive.notEquals={isActiveNotEquals}&isActive.specified={isActiveSpecified}&isActive.in={isActiveIn}&isActive.notIn={isActiveNotIn}&lastLoginAt.greaterThan={lastLoginAtGreaterThan}&lastLoginAt.lessThan={lastLoginAtLessThan}&lastLoginAt.greaterThanOrEqual={lastLoginAtGreaterThanOrEqual}&lastLoginAt.lessThanOrEqual={lastLoginAtLessThanOrEqual}&lastLoginAt.equals={lastLoginAtEquals}&lastLoginAt.notEquals={lastLoginAtNotEquals}&lastLoginAt.specified={lastLoginAtSpecified}&lastLoginAt.in={lastLoginAtIn}&lastLoginAt.notIn={lastLoginAtNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&profileId.greaterThan={profileIdGreaterThan}&profileId.lessThan={profileIdLessThan}&profileId.greaterThanOrEqual={profileIdGreaterThanOrEqual}&profileId.lessThanOrEqual={profileIdLessThanOrEqual}&profileId.equals={profileIdEquals}&profileId.notEquals={profileIdNotEquals}&profileId.specified={profileIdSpecified}&profileId.in={profileIdIn}&profileId.notIn={profileIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  Long countAppUsers(@QueryMap(encoded=true) CountAppUsersQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>countAppUsers</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>idGreaterThan -  (optional)</li>
          *   <li>idLessThan -  (optional)</li>
          *   <li>idGreaterThanOrEqual -  (optional)</li>
          *   <li>idLessThanOrEqual -  (optional)</li>
          *   <li>idEquals -  (optional)</li>
          *   <li>idNotEquals -  (optional)</li>
          *   <li>idSpecified -  (optional)</li>
          *   <li>idIn -  (optional)</li>
          *   <li>idNotIn -  (optional)</li>
          *   <li>keycloakIdEquals -  (optional)</li>
          *   <li>keycloakIdNotEquals -  (optional)</li>
          *   <li>keycloakIdSpecified -  (optional)</li>
          *   <li>keycloakIdIn -  (optional)</li>
          *   <li>keycloakIdNotIn -  (optional)</li>
          *   <li>emailContains -  (optional)</li>
          *   <li>emailDoesNotContain -  (optional)</li>
          *   <li>emailEquals -  (optional)</li>
          *   <li>emailNotEquals -  (optional)</li>
          *   <li>emailSpecified -  (optional)</li>
          *   <li>emailIn -  (optional)</li>
          *   <li>emailNotIn -  (optional)</li>
          *   <li>phoneNumberContains -  (optional)</li>
          *   <li>phoneNumberDoesNotContain -  (optional)</li>
          *   <li>phoneNumberEquals -  (optional)</li>
          *   <li>phoneNumberNotEquals -  (optional)</li>
          *   <li>phoneNumberSpecified -  (optional)</li>
          *   <li>phoneNumberIn -  (optional)</li>
          *   <li>phoneNumberNotIn -  (optional)</li>
          *   <li>firstNameContains -  (optional)</li>
          *   <li>firstNameDoesNotContain -  (optional)</li>
          *   <li>firstNameEquals -  (optional)</li>
          *   <li>firstNameNotEquals -  (optional)</li>
          *   <li>firstNameSpecified -  (optional)</li>
          *   <li>firstNameIn -  (optional)</li>
          *   <li>firstNameNotIn -  (optional)</li>
          *   <li>lastNameContains -  (optional)</li>
          *   <li>lastNameDoesNotContain -  (optional)</li>
          *   <li>lastNameEquals -  (optional)</li>
          *   <li>lastNameNotEquals -  (optional)</li>
          *   <li>lastNameSpecified -  (optional)</li>
          *   <li>lastNameIn -  (optional)</li>
          *   <li>lastNameNotIn -  (optional)</li>
          *   <li>dateOfBirthGreaterThan -  (optional)</li>
          *   <li>dateOfBirthLessThan -  (optional)</li>
          *   <li>dateOfBirthGreaterThanOrEqual -  (optional)</li>
          *   <li>dateOfBirthLessThanOrEqual -  (optional)</li>
          *   <li>dateOfBirthEquals -  (optional)</li>
          *   <li>dateOfBirthNotEquals -  (optional)</li>
          *   <li>dateOfBirthSpecified -  (optional)</li>
          *   <li>dateOfBirthIn -  (optional)</li>
          *   <li>dateOfBirthNotIn -  (optional)</li>
          *   <li>isVerifiedEquals -  (optional)</li>
          *   <li>isVerifiedNotEquals -  (optional)</li>
          *   <li>isVerifiedSpecified -  (optional)</li>
          *   <li>isVerifiedIn -  (optional)</li>
          *   <li>isVerifiedNotIn -  (optional)</li>
          *   <li>isActiveEquals -  (optional)</li>
          *   <li>isActiveNotEquals -  (optional)</li>
          *   <li>isActiveSpecified -  (optional)</li>
          *   <li>isActiveIn -  (optional)</li>
          *   <li>isActiveNotIn -  (optional)</li>
          *   <li>lastLoginAtGreaterThan -  (optional)</li>
          *   <li>lastLoginAtLessThan -  (optional)</li>
          *   <li>lastLoginAtGreaterThanOrEqual -  (optional)</li>
          *   <li>lastLoginAtLessThanOrEqual -  (optional)</li>
          *   <li>lastLoginAtEquals -  (optional)</li>
          *   <li>lastLoginAtNotEquals -  (optional)</li>
          *   <li>lastLoginAtSpecified -  (optional)</li>
          *   <li>lastLoginAtIn -  (optional)</li>
          *   <li>lastLoginAtNotIn -  (optional)</li>
          *   <li>createdAtGreaterThan -  (optional)</li>
          *   <li>createdAtLessThan -  (optional)</li>
          *   <li>createdAtGreaterThanOrEqual -  (optional)</li>
          *   <li>createdAtLessThanOrEqual -  (optional)</li>
          *   <li>createdAtEquals -  (optional)</li>
          *   <li>createdAtNotEquals -  (optional)</li>
          *   <li>createdAtSpecified -  (optional)</li>
          *   <li>createdAtIn -  (optional)</li>
          *   <li>createdAtNotIn -  (optional)</li>
          *   <li>updatedAtGreaterThan -  (optional)</li>
          *   <li>updatedAtLessThan -  (optional)</li>
          *   <li>updatedAtGreaterThanOrEqual -  (optional)</li>
          *   <li>updatedAtLessThanOrEqual -  (optional)</li>
          *   <li>updatedAtEquals -  (optional)</li>
          *   <li>updatedAtNotEquals -  (optional)</li>
          *   <li>updatedAtSpecified -  (optional)</li>
          *   <li>updatedAtIn -  (optional)</li>
          *   <li>updatedAtNotIn -  (optional)</li>
          *   <li>isDeletedEquals -  (optional)</li>
          *   <li>isDeletedNotEquals -  (optional)</li>
          *   <li>isDeletedSpecified -  (optional)</li>
          *   <li>isDeletedIn -  (optional)</li>
          *   <li>isDeletedNotIn -  (optional)</li>
          *   <li>deletedAtGreaterThan -  (optional)</li>
          *   <li>deletedAtLessThan -  (optional)</li>
          *   <li>deletedAtGreaterThanOrEqual -  (optional)</li>
          *   <li>deletedAtLessThanOrEqual -  (optional)</li>
          *   <li>deletedAtEquals -  (optional)</li>
          *   <li>deletedAtNotEquals -  (optional)</li>
          *   <li>deletedAtSpecified -  (optional)</li>
          *   <li>deletedAtIn -  (optional)</li>
          *   <li>deletedAtNotIn -  (optional)</li>
          *   <li>deletedByEquals -  (optional)</li>
          *   <li>deletedByNotEquals -  (optional)</li>
          *   <li>deletedBySpecified -  (optional)</li>
          *   <li>deletedByIn -  (optional)</li>
          *   <li>deletedByNotIn -  (optional)</li>
          *   <li>profileIdGreaterThan -  (optional)</li>
          *   <li>profileIdLessThan -  (optional)</li>
          *   <li>profileIdGreaterThanOrEqual -  (optional)</li>
          *   <li>profileIdLessThanOrEqual -  (optional)</li>
          *   <li>profileIdEquals -  (optional)</li>
          *   <li>profileIdNotEquals -  (optional)</li>
          *   <li>profileIdSpecified -  (optional)</li>
          *   <li>profileIdIn -  (optional)</li>
          *   <li>profileIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return Long
      */
      @RequestLine("GET /api/app-users/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&keycloakId.equals={keycloakIdEquals}&keycloakId.notEquals={keycloakIdNotEquals}&keycloakId.specified={keycloakIdSpecified}&keycloakId.in={keycloakIdIn}&keycloakId.notIn={keycloakIdNotIn}&email.contains={emailContains}&email.doesNotContain={emailDoesNotContain}&email.equals={emailEquals}&email.notEquals={emailNotEquals}&email.specified={emailSpecified}&email.in={emailIn}&email.notIn={emailNotIn}&phoneNumber.contains={phoneNumberContains}&phoneNumber.doesNotContain={phoneNumberDoesNotContain}&phoneNumber.equals={phoneNumberEquals}&phoneNumber.notEquals={phoneNumberNotEquals}&phoneNumber.specified={phoneNumberSpecified}&phoneNumber.in={phoneNumberIn}&phoneNumber.notIn={phoneNumberNotIn}&firstName.contains={firstNameContains}&firstName.doesNotContain={firstNameDoesNotContain}&firstName.equals={firstNameEquals}&firstName.notEquals={firstNameNotEquals}&firstName.specified={firstNameSpecified}&firstName.in={firstNameIn}&firstName.notIn={firstNameNotIn}&lastName.contains={lastNameContains}&lastName.doesNotContain={lastNameDoesNotContain}&lastName.equals={lastNameEquals}&lastName.notEquals={lastNameNotEquals}&lastName.specified={lastNameSpecified}&lastName.in={lastNameIn}&lastName.notIn={lastNameNotIn}&dateOfBirth.greaterThan={dateOfBirthGreaterThan}&dateOfBirth.lessThan={dateOfBirthLessThan}&dateOfBirth.greaterThanOrEqual={dateOfBirthGreaterThanOrEqual}&dateOfBirth.lessThanOrEqual={dateOfBirthLessThanOrEqual}&dateOfBirth.equals={dateOfBirthEquals}&dateOfBirth.notEquals={dateOfBirthNotEquals}&dateOfBirth.specified={dateOfBirthSpecified}&dateOfBirth.in={dateOfBirthIn}&dateOfBirth.notIn={dateOfBirthNotIn}&isVerified.equals={isVerifiedEquals}&isVerified.notEquals={isVerifiedNotEquals}&isVerified.specified={isVerifiedSpecified}&isVerified.in={isVerifiedIn}&isVerified.notIn={isVerifiedNotIn}&isActive.equals={isActiveEquals}&isActive.notEquals={isActiveNotEquals}&isActive.specified={isActiveSpecified}&isActive.in={isActiveIn}&isActive.notIn={isActiveNotIn}&lastLoginAt.greaterThan={lastLoginAtGreaterThan}&lastLoginAt.lessThan={lastLoginAtLessThan}&lastLoginAt.greaterThanOrEqual={lastLoginAtGreaterThanOrEqual}&lastLoginAt.lessThanOrEqual={lastLoginAtLessThanOrEqual}&lastLoginAt.equals={lastLoginAtEquals}&lastLoginAt.notEquals={lastLoginAtNotEquals}&lastLoginAt.specified={lastLoginAtSpecified}&lastLoginAt.in={lastLoginAtIn}&lastLoginAt.notIn={lastLoginAtNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&profileId.greaterThan={profileIdGreaterThan}&profileId.lessThan={profileIdLessThan}&profileId.greaterThanOrEqual={profileIdGreaterThanOrEqual}&profileId.lessThanOrEqual={profileIdLessThanOrEqual}&profileId.equals={profileIdEquals}&profileId.notEquals={profileIdNotEquals}&profileId.specified={profileIdSpecified}&profileId.in={profileIdIn}&profileId.notIn={profileIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Long> countAppUsersWithHttpInfo(@QueryMap(encoded=true) CountAppUsersQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>countAppUsers</code> method in a fluent style.
   */
  public static class CountAppUsersQueryParams extends HashMap<String, Object> {
    public CountAppUsersQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppUsersQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppUsersQueryParams keycloakIdEquals(@jakarta.annotation.Nullable final UUID value) {
      put("keycloakId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams keycloakIdNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("keycloakId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams keycloakIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("keycloakId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams keycloakIdIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("keycloakId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppUsersQueryParams keycloakIdNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("keycloakId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppUsersQueryParams emailContains(@jakarta.annotation.Nullable final String value) {
      put("email.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams emailDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("email.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams emailEquals(@jakarta.annotation.Nullable final String value) {
      put("email.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams emailNotEquals(@jakarta.annotation.Nullable final String value) {
      put("email.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams emailSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("email.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams emailIn(@jakarta.annotation.Nullable final List<String> value) {
      put("email.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppUsersQueryParams emailNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("email.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppUsersQueryParams phoneNumberContains(@jakarta.annotation.Nullable final String value) {
      put("phoneNumber.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams phoneNumberDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("phoneNumber.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams phoneNumberEquals(@jakarta.annotation.Nullable final String value) {
      put("phoneNumber.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams phoneNumberNotEquals(@jakarta.annotation.Nullable final String value) {
      put("phoneNumber.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams phoneNumberSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("phoneNumber.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams phoneNumberIn(@jakarta.annotation.Nullable final List<String> value) {
      put("phoneNumber.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppUsersQueryParams phoneNumberNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("phoneNumber.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppUsersQueryParams firstNameContains(@jakarta.annotation.Nullable final String value) {
      put("firstName.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams firstNameDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("firstName.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams firstNameEquals(@jakarta.annotation.Nullable final String value) {
      put("firstName.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams firstNameNotEquals(@jakarta.annotation.Nullable final String value) {
      put("firstName.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams firstNameSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("firstName.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams firstNameIn(@jakarta.annotation.Nullable final List<String> value) {
      put("firstName.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppUsersQueryParams firstNameNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("firstName.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppUsersQueryParams lastNameContains(@jakarta.annotation.Nullable final String value) {
      put("lastName.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams lastNameDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("lastName.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams lastNameEquals(@jakarta.annotation.Nullable final String value) {
      put("lastName.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams lastNameNotEquals(@jakarta.annotation.Nullable final String value) {
      put("lastName.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams lastNameSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("lastName.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams lastNameIn(@jakarta.annotation.Nullable final List<String> value) {
      put("lastName.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppUsersQueryParams lastNameNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("lastName.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppUsersQueryParams dateOfBirthGreaterThan(@jakarta.annotation.Nullable final LocalDate value) {
      put("dateOfBirth.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams dateOfBirthLessThan(@jakarta.annotation.Nullable final LocalDate value) {
      put("dateOfBirth.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams dateOfBirthGreaterThanOrEqual(@jakarta.annotation.Nullable final LocalDate value) {
      put("dateOfBirth.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams dateOfBirthLessThanOrEqual(@jakarta.annotation.Nullable final LocalDate value) {
      put("dateOfBirth.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams dateOfBirthEquals(@jakarta.annotation.Nullable final LocalDate value) {
      put("dateOfBirth.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams dateOfBirthNotEquals(@jakarta.annotation.Nullable final LocalDate value) {
      put("dateOfBirth.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams dateOfBirthSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("dateOfBirth.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams dateOfBirthIn(@jakarta.annotation.Nullable final List<LocalDate> value) {
      put("dateOfBirth.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppUsersQueryParams dateOfBirthNotIn(@jakarta.annotation.Nullable final List<LocalDate> value) {
      put("dateOfBirth.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppUsersQueryParams isVerifiedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isVerified.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams isVerifiedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isVerified.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams isVerifiedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isVerified.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams isVerifiedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isVerified.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppUsersQueryParams isVerifiedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isVerified.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppUsersQueryParams isActiveEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isActive.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams isActiveNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isActive.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams isActiveSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isActive.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams isActiveIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isActive.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppUsersQueryParams isActiveNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isActive.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppUsersQueryParams lastLoginAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("lastLoginAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams lastLoginAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("lastLoginAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams lastLoginAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("lastLoginAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams lastLoginAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("lastLoginAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams lastLoginAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("lastLoginAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams lastLoginAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("lastLoginAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams lastLoginAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("lastLoginAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams lastLoginAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("lastLoginAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppUsersQueryParams lastLoginAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("lastLoginAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppUsersQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppUsersQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppUsersQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppUsersQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppUsersQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppUsersQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppUsersQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppUsersQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppUsersQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppUsersQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppUsersQueryParams profileIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("profileId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams profileIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("profileId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams profileIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("profileId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams profileIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("profileId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams profileIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("profileId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams profileIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("profileId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams profileIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("profileId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAppUsersQueryParams profileIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("profileId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppUsersQueryParams profileIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("profileId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppUsersQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param appUserDTO  (required)
   * @return AppUserDTO
   */
  @RequestLine("POST /api/app-users")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  AppUserDTO createAppUser(@jakarta.annotation.Nonnull AppUserDTO appUserDTO);

  /**
   * 
   * Similar to <code>createAppUser</code> but it also returns the http response headers .
   * 
   * @param appUserDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/app-users")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<AppUserDTO> createAppUserWithHttpInfo(@jakarta.annotation.Nonnull AppUserDTO appUserDTO);



  /**
   * 
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/app-users/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteAppUser(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>deleteAppUser</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/app-users/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteAppUserWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param id  (required)
   * @return Map&lt;String, Object&gt;
   */
  @RequestLine("PUT /api/app-users/{id}/disable")
  @Headers({
    "Accept: */*",
  })
  Map<String, Object> disableAppUser(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>disableAppUser</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/app-users/{id}/disable")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Map<String, Object>> disableAppUserWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param idGreaterThan  (optional)
   * @param idLessThan  (optional)
   * @param idGreaterThanOrEqual  (optional)
   * @param idLessThanOrEqual  (optional)
   * @param idEquals  (optional)
   * @param idNotEquals  (optional)
   * @param idSpecified  (optional)
   * @param idIn  (optional)
   * @param idNotIn  (optional)
   * @param keycloakIdEquals  (optional)
   * @param keycloakIdNotEquals  (optional)
   * @param keycloakIdSpecified  (optional)
   * @param keycloakIdIn  (optional)
   * @param keycloakIdNotIn  (optional)
   * @param emailContains  (optional)
   * @param emailDoesNotContain  (optional)
   * @param emailEquals  (optional)
   * @param emailNotEquals  (optional)
   * @param emailSpecified  (optional)
   * @param emailIn  (optional)
   * @param emailNotIn  (optional)
   * @param phoneNumberContains  (optional)
   * @param phoneNumberDoesNotContain  (optional)
   * @param phoneNumberEquals  (optional)
   * @param phoneNumberNotEquals  (optional)
   * @param phoneNumberSpecified  (optional)
   * @param phoneNumberIn  (optional)
   * @param phoneNumberNotIn  (optional)
   * @param firstNameContains  (optional)
   * @param firstNameDoesNotContain  (optional)
   * @param firstNameEquals  (optional)
   * @param firstNameNotEquals  (optional)
   * @param firstNameSpecified  (optional)
   * @param firstNameIn  (optional)
   * @param firstNameNotIn  (optional)
   * @param lastNameContains  (optional)
   * @param lastNameDoesNotContain  (optional)
   * @param lastNameEquals  (optional)
   * @param lastNameNotEquals  (optional)
   * @param lastNameSpecified  (optional)
   * @param lastNameIn  (optional)
   * @param lastNameNotIn  (optional)
   * @param dateOfBirthGreaterThan  (optional)
   * @param dateOfBirthLessThan  (optional)
   * @param dateOfBirthGreaterThanOrEqual  (optional)
   * @param dateOfBirthLessThanOrEqual  (optional)
   * @param dateOfBirthEquals  (optional)
   * @param dateOfBirthNotEquals  (optional)
   * @param dateOfBirthSpecified  (optional)
   * @param dateOfBirthIn  (optional)
   * @param dateOfBirthNotIn  (optional)
   * @param isVerifiedEquals  (optional)
   * @param isVerifiedNotEquals  (optional)
   * @param isVerifiedSpecified  (optional)
   * @param isVerifiedIn  (optional)
   * @param isVerifiedNotIn  (optional)
   * @param isActiveEquals  (optional)
   * @param isActiveNotEquals  (optional)
   * @param isActiveSpecified  (optional)
   * @param isActiveIn  (optional)
   * @param isActiveNotIn  (optional)
   * @param lastLoginAtGreaterThan  (optional)
   * @param lastLoginAtLessThan  (optional)
   * @param lastLoginAtGreaterThanOrEqual  (optional)
   * @param lastLoginAtLessThanOrEqual  (optional)
   * @param lastLoginAtEquals  (optional)
   * @param lastLoginAtNotEquals  (optional)
   * @param lastLoginAtSpecified  (optional)
   * @param lastLoginAtIn  (optional)
   * @param lastLoginAtNotIn  (optional)
   * @param createdAtGreaterThan  (optional)
   * @param createdAtLessThan  (optional)
   * @param createdAtGreaterThanOrEqual  (optional)
   * @param createdAtLessThanOrEqual  (optional)
   * @param createdAtEquals  (optional)
   * @param createdAtNotEquals  (optional)
   * @param createdAtSpecified  (optional)
   * @param createdAtIn  (optional)
   * @param createdAtNotIn  (optional)
   * @param updatedAtGreaterThan  (optional)
   * @param updatedAtLessThan  (optional)
   * @param updatedAtGreaterThanOrEqual  (optional)
   * @param updatedAtLessThanOrEqual  (optional)
   * @param updatedAtEquals  (optional)
   * @param updatedAtNotEquals  (optional)
   * @param updatedAtSpecified  (optional)
   * @param updatedAtIn  (optional)
   * @param updatedAtNotIn  (optional)
   * @param isDeletedEquals  (optional)
   * @param isDeletedNotEquals  (optional)
   * @param isDeletedSpecified  (optional)
   * @param isDeletedIn  (optional)
   * @param isDeletedNotIn  (optional)
   * @param deletedAtGreaterThan  (optional)
   * @param deletedAtLessThan  (optional)
   * @param deletedAtGreaterThanOrEqual  (optional)
   * @param deletedAtLessThanOrEqual  (optional)
   * @param deletedAtEquals  (optional)
   * @param deletedAtNotEquals  (optional)
   * @param deletedAtSpecified  (optional)
   * @param deletedAtIn  (optional)
   * @param deletedAtNotIn  (optional)
   * @param deletedByEquals  (optional)
   * @param deletedByNotEquals  (optional)
   * @param deletedBySpecified  (optional)
   * @param deletedByIn  (optional)
   * @param deletedByNotIn  (optional)
   * @param profileIdGreaterThan  (optional)
   * @param profileIdLessThan  (optional)
   * @param profileIdGreaterThanOrEqual  (optional)
   * @param profileIdLessThanOrEqual  (optional)
   * @param profileIdEquals  (optional)
   * @param profileIdNotEquals  (optional)
   * @param profileIdSpecified  (optional)
   * @param profileIdIn  (optional)
   * @param profileIdNotIn  (optional)
   * @param distinct  (optional)
   * @return List&lt;AppUserDTO&gt;
   */
  @RequestLine("GET /api/app-users?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&keycloakId.equals={keycloakIdEquals}&keycloakId.notEquals={keycloakIdNotEquals}&keycloakId.specified={keycloakIdSpecified}&keycloakId.in={keycloakIdIn}&keycloakId.notIn={keycloakIdNotIn}&email.contains={emailContains}&email.doesNotContain={emailDoesNotContain}&email.equals={emailEquals}&email.notEquals={emailNotEquals}&email.specified={emailSpecified}&email.in={emailIn}&email.notIn={emailNotIn}&phoneNumber.contains={phoneNumberContains}&phoneNumber.doesNotContain={phoneNumberDoesNotContain}&phoneNumber.equals={phoneNumberEquals}&phoneNumber.notEquals={phoneNumberNotEquals}&phoneNumber.specified={phoneNumberSpecified}&phoneNumber.in={phoneNumberIn}&phoneNumber.notIn={phoneNumberNotIn}&firstName.contains={firstNameContains}&firstName.doesNotContain={firstNameDoesNotContain}&firstName.equals={firstNameEquals}&firstName.notEquals={firstNameNotEquals}&firstName.specified={firstNameSpecified}&firstName.in={firstNameIn}&firstName.notIn={firstNameNotIn}&lastName.contains={lastNameContains}&lastName.doesNotContain={lastNameDoesNotContain}&lastName.equals={lastNameEquals}&lastName.notEquals={lastNameNotEquals}&lastName.specified={lastNameSpecified}&lastName.in={lastNameIn}&lastName.notIn={lastNameNotIn}&dateOfBirth.greaterThan={dateOfBirthGreaterThan}&dateOfBirth.lessThan={dateOfBirthLessThan}&dateOfBirth.greaterThanOrEqual={dateOfBirthGreaterThanOrEqual}&dateOfBirth.lessThanOrEqual={dateOfBirthLessThanOrEqual}&dateOfBirth.equals={dateOfBirthEquals}&dateOfBirth.notEquals={dateOfBirthNotEquals}&dateOfBirth.specified={dateOfBirthSpecified}&dateOfBirth.in={dateOfBirthIn}&dateOfBirth.notIn={dateOfBirthNotIn}&isVerified.equals={isVerifiedEquals}&isVerified.notEquals={isVerifiedNotEquals}&isVerified.specified={isVerifiedSpecified}&isVerified.in={isVerifiedIn}&isVerified.notIn={isVerifiedNotIn}&isActive.equals={isActiveEquals}&isActive.notEquals={isActiveNotEquals}&isActive.specified={isActiveSpecified}&isActive.in={isActiveIn}&isActive.notIn={isActiveNotIn}&lastLoginAt.greaterThan={lastLoginAtGreaterThan}&lastLoginAt.lessThan={lastLoginAtLessThan}&lastLoginAt.greaterThanOrEqual={lastLoginAtGreaterThanOrEqual}&lastLoginAt.lessThanOrEqual={lastLoginAtLessThanOrEqual}&lastLoginAt.equals={lastLoginAtEquals}&lastLoginAt.notEquals={lastLoginAtNotEquals}&lastLoginAt.specified={lastLoginAtSpecified}&lastLoginAt.in={lastLoginAtIn}&lastLoginAt.notIn={lastLoginAtNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&profileId.greaterThan={profileIdGreaterThan}&profileId.lessThan={profileIdLessThan}&profileId.greaterThanOrEqual={profileIdGreaterThanOrEqual}&profileId.lessThanOrEqual={profileIdLessThanOrEqual}&profileId.equals={profileIdEquals}&profileId.notEquals={profileIdNotEquals}&profileId.specified={profileIdSpecified}&profileId.in={profileIdIn}&profileId.notIn={profileIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  List<AppUserDTO> getAllAppUsers(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("keycloakIdEquals") @jakarta.annotation.Nullable UUID keycloakIdEquals, @Param("keycloakIdNotEquals") @jakarta.annotation.Nullable UUID keycloakIdNotEquals, @Param("keycloakIdSpecified") @jakarta.annotation.Nullable Boolean keycloakIdSpecified, @Param("keycloakIdIn") @jakarta.annotation.Nullable List<UUID> keycloakIdIn, @Param("keycloakIdNotIn") @jakarta.annotation.Nullable List<UUID> keycloakIdNotIn, @Param("emailContains") @jakarta.annotation.Nullable String emailContains, @Param("emailDoesNotContain") @jakarta.annotation.Nullable String emailDoesNotContain, @Param("emailEquals") @jakarta.annotation.Nullable String emailEquals, @Param("emailNotEquals") @jakarta.annotation.Nullable String emailNotEquals, @Param("emailSpecified") @jakarta.annotation.Nullable Boolean emailSpecified, @Param("emailIn") @jakarta.annotation.Nullable List<String> emailIn, @Param("emailNotIn") @jakarta.annotation.Nullable List<String> emailNotIn, @Param("phoneNumberContains") @jakarta.annotation.Nullable String phoneNumberContains, @Param("phoneNumberDoesNotContain") @jakarta.annotation.Nullable String phoneNumberDoesNotContain, @Param("phoneNumberEquals") @jakarta.annotation.Nullable String phoneNumberEquals, @Param("phoneNumberNotEquals") @jakarta.annotation.Nullable String phoneNumberNotEquals, @Param("phoneNumberSpecified") @jakarta.annotation.Nullable Boolean phoneNumberSpecified, @Param("phoneNumberIn") @jakarta.annotation.Nullable List<String> phoneNumberIn, @Param("phoneNumberNotIn") @jakarta.annotation.Nullable List<String> phoneNumberNotIn, @Param("firstNameContains") @jakarta.annotation.Nullable String firstNameContains, @Param("firstNameDoesNotContain") @jakarta.annotation.Nullable String firstNameDoesNotContain, @Param("firstNameEquals") @jakarta.annotation.Nullable String firstNameEquals, @Param("firstNameNotEquals") @jakarta.annotation.Nullable String firstNameNotEquals, @Param("firstNameSpecified") @jakarta.annotation.Nullable Boolean firstNameSpecified, @Param("firstNameIn") @jakarta.annotation.Nullable List<String> firstNameIn, @Param("firstNameNotIn") @jakarta.annotation.Nullable List<String> firstNameNotIn, @Param("lastNameContains") @jakarta.annotation.Nullable String lastNameContains, @Param("lastNameDoesNotContain") @jakarta.annotation.Nullable String lastNameDoesNotContain, @Param("lastNameEquals") @jakarta.annotation.Nullable String lastNameEquals, @Param("lastNameNotEquals") @jakarta.annotation.Nullable String lastNameNotEquals, @Param("lastNameSpecified") @jakarta.annotation.Nullable Boolean lastNameSpecified, @Param("lastNameIn") @jakarta.annotation.Nullable List<String> lastNameIn, @Param("lastNameNotIn") @jakarta.annotation.Nullable List<String> lastNameNotIn, @Param("dateOfBirthGreaterThan") @jakarta.annotation.Nullable LocalDate dateOfBirthGreaterThan, @Param("dateOfBirthLessThan") @jakarta.annotation.Nullable LocalDate dateOfBirthLessThan, @Param("dateOfBirthGreaterThanOrEqual") @jakarta.annotation.Nullable LocalDate dateOfBirthGreaterThanOrEqual, @Param("dateOfBirthLessThanOrEqual") @jakarta.annotation.Nullable LocalDate dateOfBirthLessThanOrEqual, @Param("dateOfBirthEquals") @jakarta.annotation.Nullable LocalDate dateOfBirthEquals, @Param("dateOfBirthNotEquals") @jakarta.annotation.Nullable LocalDate dateOfBirthNotEquals, @Param("dateOfBirthSpecified") @jakarta.annotation.Nullable Boolean dateOfBirthSpecified, @Param("dateOfBirthIn") @jakarta.annotation.Nullable List<LocalDate> dateOfBirthIn, @Param("dateOfBirthNotIn") @jakarta.annotation.Nullable List<LocalDate> dateOfBirthNotIn, @Param("isVerifiedEquals") @jakarta.annotation.Nullable Boolean isVerifiedEquals, @Param("isVerifiedNotEquals") @jakarta.annotation.Nullable Boolean isVerifiedNotEquals, @Param("isVerifiedSpecified") @jakarta.annotation.Nullable Boolean isVerifiedSpecified, @Param("isVerifiedIn") @jakarta.annotation.Nullable List<Boolean> isVerifiedIn, @Param("isVerifiedNotIn") @jakarta.annotation.Nullable List<Boolean> isVerifiedNotIn, @Param("isActiveEquals") @jakarta.annotation.Nullable Boolean isActiveEquals, @Param("isActiveNotEquals") @jakarta.annotation.Nullable Boolean isActiveNotEquals, @Param("isActiveSpecified") @jakarta.annotation.Nullable Boolean isActiveSpecified, @Param("isActiveIn") @jakarta.annotation.Nullable List<Boolean> isActiveIn, @Param("isActiveNotIn") @jakarta.annotation.Nullable List<Boolean> isActiveNotIn, @Param("lastLoginAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime lastLoginAtGreaterThan, @Param("lastLoginAtLessThan") @jakarta.annotation.Nullable OffsetDateTime lastLoginAtLessThan, @Param("lastLoginAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime lastLoginAtGreaterThanOrEqual, @Param("lastLoginAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime lastLoginAtLessThanOrEqual, @Param("lastLoginAtEquals") @jakarta.annotation.Nullable OffsetDateTime lastLoginAtEquals, @Param("lastLoginAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime lastLoginAtNotEquals, @Param("lastLoginAtSpecified") @jakarta.annotation.Nullable Boolean lastLoginAtSpecified, @Param("lastLoginAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> lastLoginAtIn, @Param("lastLoginAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> lastLoginAtNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("profileIdGreaterThan") @jakarta.annotation.Nullable Long profileIdGreaterThan, @Param("profileIdLessThan") @jakarta.annotation.Nullable Long profileIdLessThan, @Param("profileIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long profileIdGreaterThanOrEqual, @Param("profileIdLessThanOrEqual") @jakarta.annotation.Nullable Long profileIdLessThanOrEqual, @Param("profileIdEquals") @jakarta.annotation.Nullable Long profileIdEquals, @Param("profileIdNotEquals") @jakarta.annotation.Nullable Long profileIdNotEquals, @Param("profileIdSpecified") @jakarta.annotation.Nullable Boolean profileIdSpecified, @Param("profileIdIn") @jakarta.annotation.Nullable List<Long> profileIdIn, @Param("profileIdNotIn") @jakarta.annotation.Nullable List<Long> profileIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>getAllAppUsers</code> but it also returns the http response headers .
   * 
   * @param idGreaterThan  (optional)
   * @param idLessThan  (optional)
   * @param idGreaterThanOrEqual  (optional)
   * @param idLessThanOrEqual  (optional)
   * @param idEquals  (optional)
   * @param idNotEquals  (optional)
   * @param idSpecified  (optional)
   * @param idIn  (optional)
   * @param idNotIn  (optional)
   * @param keycloakIdEquals  (optional)
   * @param keycloakIdNotEquals  (optional)
   * @param keycloakIdSpecified  (optional)
   * @param keycloakIdIn  (optional)
   * @param keycloakIdNotIn  (optional)
   * @param emailContains  (optional)
   * @param emailDoesNotContain  (optional)
   * @param emailEquals  (optional)
   * @param emailNotEquals  (optional)
   * @param emailSpecified  (optional)
   * @param emailIn  (optional)
   * @param emailNotIn  (optional)
   * @param phoneNumberContains  (optional)
   * @param phoneNumberDoesNotContain  (optional)
   * @param phoneNumberEquals  (optional)
   * @param phoneNumberNotEquals  (optional)
   * @param phoneNumberSpecified  (optional)
   * @param phoneNumberIn  (optional)
   * @param phoneNumberNotIn  (optional)
   * @param firstNameContains  (optional)
   * @param firstNameDoesNotContain  (optional)
   * @param firstNameEquals  (optional)
   * @param firstNameNotEquals  (optional)
   * @param firstNameSpecified  (optional)
   * @param firstNameIn  (optional)
   * @param firstNameNotIn  (optional)
   * @param lastNameContains  (optional)
   * @param lastNameDoesNotContain  (optional)
   * @param lastNameEquals  (optional)
   * @param lastNameNotEquals  (optional)
   * @param lastNameSpecified  (optional)
   * @param lastNameIn  (optional)
   * @param lastNameNotIn  (optional)
   * @param dateOfBirthGreaterThan  (optional)
   * @param dateOfBirthLessThan  (optional)
   * @param dateOfBirthGreaterThanOrEqual  (optional)
   * @param dateOfBirthLessThanOrEqual  (optional)
   * @param dateOfBirthEquals  (optional)
   * @param dateOfBirthNotEquals  (optional)
   * @param dateOfBirthSpecified  (optional)
   * @param dateOfBirthIn  (optional)
   * @param dateOfBirthNotIn  (optional)
   * @param isVerifiedEquals  (optional)
   * @param isVerifiedNotEquals  (optional)
   * @param isVerifiedSpecified  (optional)
   * @param isVerifiedIn  (optional)
   * @param isVerifiedNotIn  (optional)
   * @param isActiveEquals  (optional)
   * @param isActiveNotEquals  (optional)
   * @param isActiveSpecified  (optional)
   * @param isActiveIn  (optional)
   * @param isActiveNotIn  (optional)
   * @param lastLoginAtGreaterThan  (optional)
   * @param lastLoginAtLessThan  (optional)
   * @param lastLoginAtGreaterThanOrEqual  (optional)
   * @param lastLoginAtLessThanOrEqual  (optional)
   * @param lastLoginAtEquals  (optional)
   * @param lastLoginAtNotEquals  (optional)
   * @param lastLoginAtSpecified  (optional)
   * @param lastLoginAtIn  (optional)
   * @param lastLoginAtNotIn  (optional)
   * @param createdAtGreaterThan  (optional)
   * @param createdAtLessThan  (optional)
   * @param createdAtGreaterThanOrEqual  (optional)
   * @param createdAtLessThanOrEqual  (optional)
   * @param createdAtEquals  (optional)
   * @param createdAtNotEquals  (optional)
   * @param createdAtSpecified  (optional)
   * @param createdAtIn  (optional)
   * @param createdAtNotIn  (optional)
   * @param updatedAtGreaterThan  (optional)
   * @param updatedAtLessThan  (optional)
   * @param updatedAtGreaterThanOrEqual  (optional)
   * @param updatedAtLessThanOrEqual  (optional)
   * @param updatedAtEquals  (optional)
   * @param updatedAtNotEquals  (optional)
   * @param updatedAtSpecified  (optional)
   * @param updatedAtIn  (optional)
   * @param updatedAtNotIn  (optional)
   * @param isDeletedEquals  (optional)
   * @param isDeletedNotEquals  (optional)
   * @param isDeletedSpecified  (optional)
   * @param isDeletedIn  (optional)
   * @param isDeletedNotIn  (optional)
   * @param deletedAtGreaterThan  (optional)
   * @param deletedAtLessThan  (optional)
   * @param deletedAtGreaterThanOrEqual  (optional)
   * @param deletedAtLessThanOrEqual  (optional)
   * @param deletedAtEquals  (optional)
   * @param deletedAtNotEquals  (optional)
   * @param deletedAtSpecified  (optional)
   * @param deletedAtIn  (optional)
   * @param deletedAtNotIn  (optional)
   * @param deletedByEquals  (optional)
   * @param deletedByNotEquals  (optional)
   * @param deletedBySpecified  (optional)
   * @param deletedByIn  (optional)
   * @param deletedByNotIn  (optional)
   * @param profileIdGreaterThan  (optional)
   * @param profileIdLessThan  (optional)
   * @param profileIdGreaterThanOrEqual  (optional)
   * @param profileIdLessThanOrEqual  (optional)
   * @param profileIdEquals  (optional)
   * @param profileIdNotEquals  (optional)
   * @param profileIdSpecified  (optional)
   * @param profileIdIn  (optional)
   * @param profileIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/app-users?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&keycloakId.equals={keycloakIdEquals}&keycloakId.notEquals={keycloakIdNotEquals}&keycloakId.specified={keycloakIdSpecified}&keycloakId.in={keycloakIdIn}&keycloakId.notIn={keycloakIdNotIn}&email.contains={emailContains}&email.doesNotContain={emailDoesNotContain}&email.equals={emailEquals}&email.notEquals={emailNotEquals}&email.specified={emailSpecified}&email.in={emailIn}&email.notIn={emailNotIn}&phoneNumber.contains={phoneNumberContains}&phoneNumber.doesNotContain={phoneNumberDoesNotContain}&phoneNumber.equals={phoneNumberEquals}&phoneNumber.notEquals={phoneNumberNotEquals}&phoneNumber.specified={phoneNumberSpecified}&phoneNumber.in={phoneNumberIn}&phoneNumber.notIn={phoneNumberNotIn}&firstName.contains={firstNameContains}&firstName.doesNotContain={firstNameDoesNotContain}&firstName.equals={firstNameEquals}&firstName.notEquals={firstNameNotEquals}&firstName.specified={firstNameSpecified}&firstName.in={firstNameIn}&firstName.notIn={firstNameNotIn}&lastName.contains={lastNameContains}&lastName.doesNotContain={lastNameDoesNotContain}&lastName.equals={lastNameEquals}&lastName.notEquals={lastNameNotEquals}&lastName.specified={lastNameSpecified}&lastName.in={lastNameIn}&lastName.notIn={lastNameNotIn}&dateOfBirth.greaterThan={dateOfBirthGreaterThan}&dateOfBirth.lessThan={dateOfBirthLessThan}&dateOfBirth.greaterThanOrEqual={dateOfBirthGreaterThanOrEqual}&dateOfBirth.lessThanOrEqual={dateOfBirthLessThanOrEqual}&dateOfBirth.equals={dateOfBirthEquals}&dateOfBirth.notEquals={dateOfBirthNotEquals}&dateOfBirth.specified={dateOfBirthSpecified}&dateOfBirth.in={dateOfBirthIn}&dateOfBirth.notIn={dateOfBirthNotIn}&isVerified.equals={isVerifiedEquals}&isVerified.notEquals={isVerifiedNotEquals}&isVerified.specified={isVerifiedSpecified}&isVerified.in={isVerifiedIn}&isVerified.notIn={isVerifiedNotIn}&isActive.equals={isActiveEquals}&isActive.notEquals={isActiveNotEquals}&isActive.specified={isActiveSpecified}&isActive.in={isActiveIn}&isActive.notIn={isActiveNotIn}&lastLoginAt.greaterThan={lastLoginAtGreaterThan}&lastLoginAt.lessThan={lastLoginAtLessThan}&lastLoginAt.greaterThanOrEqual={lastLoginAtGreaterThanOrEqual}&lastLoginAt.lessThanOrEqual={lastLoginAtLessThanOrEqual}&lastLoginAt.equals={lastLoginAtEquals}&lastLoginAt.notEquals={lastLoginAtNotEquals}&lastLoginAt.specified={lastLoginAtSpecified}&lastLoginAt.in={lastLoginAtIn}&lastLoginAt.notIn={lastLoginAtNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&profileId.greaterThan={profileIdGreaterThan}&profileId.lessThan={profileIdLessThan}&profileId.greaterThanOrEqual={profileIdGreaterThanOrEqual}&profileId.lessThanOrEqual={profileIdLessThanOrEqual}&profileId.equals={profileIdEquals}&profileId.notEquals={profileIdNotEquals}&profileId.specified={profileIdSpecified}&profileId.in={profileIdIn}&profileId.notIn={profileIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<AppUserDTO>> getAllAppUsersWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("keycloakIdEquals") @jakarta.annotation.Nullable UUID keycloakIdEquals, @Param("keycloakIdNotEquals") @jakarta.annotation.Nullable UUID keycloakIdNotEquals, @Param("keycloakIdSpecified") @jakarta.annotation.Nullable Boolean keycloakIdSpecified, @Param("keycloakIdIn") @jakarta.annotation.Nullable List<UUID> keycloakIdIn, @Param("keycloakIdNotIn") @jakarta.annotation.Nullable List<UUID> keycloakIdNotIn, @Param("emailContains") @jakarta.annotation.Nullable String emailContains, @Param("emailDoesNotContain") @jakarta.annotation.Nullable String emailDoesNotContain, @Param("emailEquals") @jakarta.annotation.Nullable String emailEquals, @Param("emailNotEquals") @jakarta.annotation.Nullable String emailNotEquals, @Param("emailSpecified") @jakarta.annotation.Nullable Boolean emailSpecified, @Param("emailIn") @jakarta.annotation.Nullable List<String> emailIn, @Param("emailNotIn") @jakarta.annotation.Nullable List<String> emailNotIn, @Param("phoneNumberContains") @jakarta.annotation.Nullable String phoneNumberContains, @Param("phoneNumberDoesNotContain") @jakarta.annotation.Nullable String phoneNumberDoesNotContain, @Param("phoneNumberEquals") @jakarta.annotation.Nullable String phoneNumberEquals, @Param("phoneNumberNotEquals") @jakarta.annotation.Nullable String phoneNumberNotEquals, @Param("phoneNumberSpecified") @jakarta.annotation.Nullable Boolean phoneNumberSpecified, @Param("phoneNumberIn") @jakarta.annotation.Nullable List<String> phoneNumberIn, @Param("phoneNumberNotIn") @jakarta.annotation.Nullable List<String> phoneNumberNotIn, @Param("firstNameContains") @jakarta.annotation.Nullable String firstNameContains, @Param("firstNameDoesNotContain") @jakarta.annotation.Nullable String firstNameDoesNotContain, @Param("firstNameEquals") @jakarta.annotation.Nullable String firstNameEquals, @Param("firstNameNotEquals") @jakarta.annotation.Nullable String firstNameNotEquals, @Param("firstNameSpecified") @jakarta.annotation.Nullable Boolean firstNameSpecified, @Param("firstNameIn") @jakarta.annotation.Nullable List<String> firstNameIn, @Param("firstNameNotIn") @jakarta.annotation.Nullable List<String> firstNameNotIn, @Param("lastNameContains") @jakarta.annotation.Nullable String lastNameContains, @Param("lastNameDoesNotContain") @jakarta.annotation.Nullable String lastNameDoesNotContain, @Param("lastNameEquals") @jakarta.annotation.Nullable String lastNameEquals, @Param("lastNameNotEquals") @jakarta.annotation.Nullable String lastNameNotEquals, @Param("lastNameSpecified") @jakarta.annotation.Nullable Boolean lastNameSpecified, @Param("lastNameIn") @jakarta.annotation.Nullable List<String> lastNameIn, @Param("lastNameNotIn") @jakarta.annotation.Nullable List<String> lastNameNotIn, @Param("dateOfBirthGreaterThan") @jakarta.annotation.Nullable LocalDate dateOfBirthGreaterThan, @Param("dateOfBirthLessThan") @jakarta.annotation.Nullable LocalDate dateOfBirthLessThan, @Param("dateOfBirthGreaterThanOrEqual") @jakarta.annotation.Nullable LocalDate dateOfBirthGreaterThanOrEqual, @Param("dateOfBirthLessThanOrEqual") @jakarta.annotation.Nullable LocalDate dateOfBirthLessThanOrEqual, @Param("dateOfBirthEquals") @jakarta.annotation.Nullable LocalDate dateOfBirthEquals, @Param("dateOfBirthNotEquals") @jakarta.annotation.Nullable LocalDate dateOfBirthNotEquals, @Param("dateOfBirthSpecified") @jakarta.annotation.Nullable Boolean dateOfBirthSpecified, @Param("dateOfBirthIn") @jakarta.annotation.Nullable List<LocalDate> dateOfBirthIn, @Param("dateOfBirthNotIn") @jakarta.annotation.Nullable List<LocalDate> dateOfBirthNotIn, @Param("isVerifiedEquals") @jakarta.annotation.Nullable Boolean isVerifiedEquals, @Param("isVerifiedNotEquals") @jakarta.annotation.Nullable Boolean isVerifiedNotEquals, @Param("isVerifiedSpecified") @jakarta.annotation.Nullable Boolean isVerifiedSpecified, @Param("isVerifiedIn") @jakarta.annotation.Nullable List<Boolean> isVerifiedIn, @Param("isVerifiedNotIn") @jakarta.annotation.Nullable List<Boolean> isVerifiedNotIn, @Param("isActiveEquals") @jakarta.annotation.Nullable Boolean isActiveEquals, @Param("isActiveNotEquals") @jakarta.annotation.Nullable Boolean isActiveNotEquals, @Param("isActiveSpecified") @jakarta.annotation.Nullable Boolean isActiveSpecified, @Param("isActiveIn") @jakarta.annotation.Nullable List<Boolean> isActiveIn, @Param("isActiveNotIn") @jakarta.annotation.Nullable List<Boolean> isActiveNotIn, @Param("lastLoginAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime lastLoginAtGreaterThan, @Param("lastLoginAtLessThan") @jakarta.annotation.Nullable OffsetDateTime lastLoginAtLessThan, @Param("lastLoginAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime lastLoginAtGreaterThanOrEqual, @Param("lastLoginAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime lastLoginAtLessThanOrEqual, @Param("lastLoginAtEquals") @jakarta.annotation.Nullable OffsetDateTime lastLoginAtEquals, @Param("lastLoginAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime lastLoginAtNotEquals, @Param("lastLoginAtSpecified") @jakarta.annotation.Nullable Boolean lastLoginAtSpecified, @Param("lastLoginAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> lastLoginAtIn, @Param("lastLoginAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> lastLoginAtNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("profileIdGreaterThan") @jakarta.annotation.Nullable Long profileIdGreaterThan, @Param("profileIdLessThan") @jakarta.annotation.Nullable Long profileIdLessThan, @Param("profileIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long profileIdGreaterThanOrEqual, @Param("profileIdLessThanOrEqual") @jakarta.annotation.Nullable Long profileIdLessThanOrEqual, @Param("profileIdEquals") @jakarta.annotation.Nullable Long profileIdEquals, @Param("profileIdNotEquals") @jakarta.annotation.Nullable Long profileIdNotEquals, @Param("profileIdSpecified") @jakarta.annotation.Nullable Boolean profileIdSpecified, @Param("profileIdIn") @jakarta.annotation.Nullable List<Long> profileIdIn, @Param("profileIdNotIn") @jakarta.annotation.Nullable List<Long> profileIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllAppUsers</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllAppUsersQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>idGreaterThan -  (optional)</li>
   *   <li>idLessThan -  (optional)</li>
   *   <li>idGreaterThanOrEqual -  (optional)</li>
   *   <li>idLessThanOrEqual -  (optional)</li>
   *   <li>idEquals -  (optional)</li>
   *   <li>idNotEquals -  (optional)</li>
   *   <li>idSpecified -  (optional)</li>
   *   <li>idIn -  (optional)</li>
   *   <li>idNotIn -  (optional)</li>
   *   <li>keycloakIdEquals -  (optional)</li>
   *   <li>keycloakIdNotEquals -  (optional)</li>
   *   <li>keycloakIdSpecified -  (optional)</li>
   *   <li>keycloakIdIn -  (optional)</li>
   *   <li>keycloakIdNotIn -  (optional)</li>
   *   <li>emailContains -  (optional)</li>
   *   <li>emailDoesNotContain -  (optional)</li>
   *   <li>emailEquals -  (optional)</li>
   *   <li>emailNotEquals -  (optional)</li>
   *   <li>emailSpecified -  (optional)</li>
   *   <li>emailIn -  (optional)</li>
   *   <li>emailNotIn -  (optional)</li>
   *   <li>phoneNumberContains -  (optional)</li>
   *   <li>phoneNumberDoesNotContain -  (optional)</li>
   *   <li>phoneNumberEquals -  (optional)</li>
   *   <li>phoneNumberNotEquals -  (optional)</li>
   *   <li>phoneNumberSpecified -  (optional)</li>
   *   <li>phoneNumberIn -  (optional)</li>
   *   <li>phoneNumberNotIn -  (optional)</li>
   *   <li>firstNameContains -  (optional)</li>
   *   <li>firstNameDoesNotContain -  (optional)</li>
   *   <li>firstNameEquals -  (optional)</li>
   *   <li>firstNameNotEquals -  (optional)</li>
   *   <li>firstNameSpecified -  (optional)</li>
   *   <li>firstNameIn -  (optional)</li>
   *   <li>firstNameNotIn -  (optional)</li>
   *   <li>lastNameContains -  (optional)</li>
   *   <li>lastNameDoesNotContain -  (optional)</li>
   *   <li>lastNameEquals -  (optional)</li>
   *   <li>lastNameNotEquals -  (optional)</li>
   *   <li>lastNameSpecified -  (optional)</li>
   *   <li>lastNameIn -  (optional)</li>
   *   <li>lastNameNotIn -  (optional)</li>
   *   <li>dateOfBirthGreaterThan -  (optional)</li>
   *   <li>dateOfBirthLessThan -  (optional)</li>
   *   <li>dateOfBirthGreaterThanOrEqual -  (optional)</li>
   *   <li>dateOfBirthLessThanOrEqual -  (optional)</li>
   *   <li>dateOfBirthEquals -  (optional)</li>
   *   <li>dateOfBirthNotEquals -  (optional)</li>
   *   <li>dateOfBirthSpecified -  (optional)</li>
   *   <li>dateOfBirthIn -  (optional)</li>
   *   <li>dateOfBirthNotIn -  (optional)</li>
   *   <li>isVerifiedEquals -  (optional)</li>
   *   <li>isVerifiedNotEquals -  (optional)</li>
   *   <li>isVerifiedSpecified -  (optional)</li>
   *   <li>isVerifiedIn -  (optional)</li>
   *   <li>isVerifiedNotIn -  (optional)</li>
   *   <li>isActiveEquals -  (optional)</li>
   *   <li>isActiveNotEquals -  (optional)</li>
   *   <li>isActiveSpecified -  (optional)</li>
   *   <li>isActiveIn -  (optional)</li>
   *   <li>isActiveNotIn -  (optional)</li>
   *   <li>lastLoginAtGreaterThan -  (optional)</li>
   *   <li>lastLoginAtLessThan -  (optional)</li>
   *   <li>lastLoginAtGreaterThanOrEqual -  (optional)</li>
   *   <li>lastLoginAtLessThanOrEqual -  (optional)</li>
   *   <li>lastLoginAtEquals -  (optional)</li>
   *   <li>lastLoginAtNotEquals -  (optional)</li>
   *   <li>lastLoginAtSpecified -  (optional)</li>
   *   <li>lastLoginAtIn -  (optional)</li>
   *   <li>lastLoginAtNotIn -  (optional)</li>
   *   <li>createdAtGreaterThan -  (optional)</li>
   *   <li>createdAtLessThan -  (optional)</li>
   *   <li>createdAtGreaterThanOrEqual -  (optional)</li>
   *   <li>createdAtLessThanOrEqual -  (optional)</li>
   *   <li>createdAtEquals -  (optional)</li>
   *   <li>createdAtNotEquals -  (optional)</li>
   *   <li>createdAtSpecified -  (optional)</li>
   *   <li>createdAtIn -  (optional)</li>
   *   <li>createdAtNotIn -  (optional)</li>
   *   <li>updatedAtGreaterThan -  (optional)</li>
   *   <li>updatedAtLessThan -  (optional)</li>
   *   <li>updatedAtGreaterThanOrEqual -  (optional)</li>
   *   <li>updatedAtLessThanOrEqual -  (optional)</li>
   *   <li>updatedAtEquals -  (optional)</li>
   *   <li>updatedAtNotEquals -  (optional)</li>
   *   <li>updatedAtSpecified -  (optional)</li>
   *   <li>updatedAtIn -  (optional)</li>
   *   <li>updatedAtNotIn -  (optional)</li>
   *   <li>isDeletedEquals -  (optional)</li>
   *   <li>isDeletedNotEquals -  (optional)</li>
   *   <li>isDeletedSpecified -  (optional)</li>
   *   <li>isDeletedIn -  (optional)</li>
   *   <li>isDeletedNotIn -  (optional)</li>
   *   <li>deletedAtGreaterThan -  (optional)</li>
   *   <li>deletedAtLessThan -  (optional)</li>
   *   <li>deletedAtGreaterThanOrEqual -  (optional)</li>
   *   <li>deletedAtLessThanOrEqual -  (optional)</li>
   *   <li>deletedAtEquals -  (optional)</li>
   *   <li>deletedAtNotEquals -  (optional)</li>
   *   <li>deletedAtSpecified -  (optional)</li>
   *   <li>deletedAtIn -  (optional)</li>
   *   <li>deletedAtNotIn -  (optional)</li>
   *   <li>deletedByEquals -  (optional)</li>
   *   <li>deletedByNotEquals -  (optional)</li>
   *   <li>deletedBySpecified -  (optional)</li>
   *   <li>deletedByIn -  (optional)</li>
   *   <li>deletedByNotIn -  (optional)</li>
   *   <li>profileIdGreaterThan -  (optional)</li>
   *   <li>profileIdLessThan -  (optional)</li>
   *   <li>profileIdGreaterThanOrEqual -  (optional)</li>
   *   <li>profileIdLessThanOrEqual -  (optional)</li>
   *   <li>profileIdEquals -  (optional)</li>
   *   <li>profileIdNotEquals -  (optional)</li>
   *   <li>profileIdSpecified -  (optional)</li>
   *   <li>profileIdIn -  (optional)</li>
   *   <li>profileIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return List&lt;AppUserDTO&gt;
   */
  @RequestLine("GET /api/app-users?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&keycloakId.equals={keycloakIdEquals}&keycloakId.notEquals={keycloakIdNotEquals}&keycloakId.specified={keycloakIdSpecified}&keycloakId.in={keycloakIdIn}&keycloakId.notIn={keycloakIdNotIn}&email.contains={emailContains}&email.doesNotContain={emailDoesNotContain}&email.equals={emailEquals}&email.notEquals={emailNotEquals}&email.specified={emailSpecified}&email.in={emailIn}&email.notIn={emailNotIn}&phoneNumber.contains={phoneNumberContains}&phoneNumber.doesNotContain={phoneNumberDoesNotContain}&phoneNumber.equals={phoneNumberEquals}&phoneNumber.notEquals={phoneNumberNotEquals}&phoneNumber.specified={phoneNumberSpecified}&phoneNumber.in={phoneNumberIn}&phoneNumber.notIn={phoneNumberNotIn}&firstName.contains={firstNameContains}&firstName.doesNotContain={firstNameDoesNotContain}&firstName.equals={firstNameEquals}&firstName.notEquals={firstNameNotEquals}&firstName.specified={firstNameSpecified}&firstName.in={firstNameIn}&firstName.notIn={firstNameNotIn}&lastName.contains={lastNameContains}&lastName.doesNotContain={lastNameDoesNotContain}&lastName.equals={lastNameEquals}&lastName.notEquals={lastNameNotEquals}&lastName.specified={lastNameSpecified}&lastName.in={lastNameIn}&lastName.notIn={lastNameNotIn}&dateOfBirth.greaterThan={dateOfBirthGreaterThan}&dateOfBirth.lessThan={dateOfBirthLessThan}&dateOfBirth.greaterThanOrEqual={dateOfBirthGreaterThanOrEqual}&dateOfBirth.lessThanOrEqual={dateOfBirthLessThanOrEqual}&dateOfBirth.equals={dateOfBirthEquals}&dateOfBirth.notEquals={dateOfBirthNotEquals}&dateOfBirth.specified={dateOfBirthSpecified}&dateOfBirth.in={dateOfBirthIn}&dateOfBirth.notIn={dateOfBirthNotIn}&isVerified.equals={isVerifiedEquals}&isVerified.notEquals={isVerifiedNotEquals}&isVerified.specified={isVerifiedSpecified}&isVerified.in={isVerifiedIn}&isVerified.notIn={isVerifiedNotIn}&isActive.equals={isActiveEquals}&isActive.notEquals={isActiveNotEquals}&isActive.specified={isActiveSpecified}&isActive.in={isActiveIn}&isActive.notIn={isActiveNotIn}&lastLoginAt.greaterThan={lastLoginAtGreaterThan}&lastLoginAt.lessThan={lastLoginAtLessThan}&lastLoginAt.greaterThanOrEqual={lastLoginAtGreaterThanOrEqual}&lastLoginAt.lessThanOrEqual={lastLoginAtLessThanOrEqual}&lastLoginAt.equals={lastLoginAtEquals}&lastLoginAt.notEquals={lastLoginAtNotEquals}&lastLoginAt.specified={lastLoginAtSpecified}&lastLoginAt.in={lastLoginAtIn}&lastLoginAt.notIn={lastLoginAtNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&profileId.greaterThan={profileIdGreaterThan}&profileId.lessThan={profileIdLessThan}&profileId.greaterThanOrEqual={profileIdGreaterThanOrEqual}&profileId.lessThanOrEqual={profileIdLessThanOrEqual}&profileId.equals={profileIdEquals}&profileId.notEquals={profileIdNotEquals}&profileId.specified={profileIdSpecified}&profileId.in={profileIdIn}&profileId.notIn={profileIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  List<AppUserDTO> getAllAppUsers(@QueryMap(encoded=true) GetAllAppUsersQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllAppUsers</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>idGreaterThan -  (optional)</li>
          *   <li>idLessThan -  (optional)</li>
          *   <li>idGreaterThanOrEqual -  (optional)</li>
          *   <li>idLessThanOrEqual -  (optional)</li>
          *   <li>idEquals -  (optional)</li>
          *   <li>idNotEquals -  (optional)</li>
          *   <li>idSpecified -  (optional)</li>
          *   <li>idIn -  (optional)</li>
          *   <li>idNotIn -  (optional)</li>
          *   <li>keycloakIdEquals -  (optional)</li>
          *   <li>keycloakIdNotEquals -  (optional)</li>
          *   <li>keycloakIdSpecified -  (optional)</li>
          *   <li>keycloakIdIn -  (optional)</li>
          *   <li>keycloakIdNotIn -  (optional)</li>
          *   <li>emailContains -  (optional)</li>
          *   <li>emailDoesNotContain -  (optional)</li>
          *   <li>emailEquals -  (optional)</li>
          *   <li>emailNotEquals -  (optional)</li>
          *   <li>emailSpecified -  (optional)</li>
          *   <li>emailIn -  (optional)</li>
          *   <li>emailNotIn -  (optional)</li>
          *   <li>phoneNumberContains -  (optional)</li>
          *   <li>phoneNumberDoesNotContain -  (optional)</li>
          *   <li>phoneNumberEquals -  (optional)</li>
          *   <li>phoneNumberNotEquals -  (optional)</li>
          *   <li>phoneNumberSpecified -  (optional)</li>
          *   <li>phoneNumberIn -  (optional)</li>
          *   <li>phoneNumberNotIn -  (optional)</li>
          *   <li>firstNameContains -  (optional)</li>
          *   <li>firstNameDoesNotContain -  (optional)</li>
          *   <li>firstNameEquals -  (optional)</li>
          *   <li>firstNameNotEquals -  (optional)</li>
          *   <li>firstNameSpecified -  (optional)</li>
          *   <li>firstNameIn -  (optional)</li>
          *   <li>firstNameNotIn -  (optional)</li>
          *   <li>lastNameContains -  (optional)</li>
          *   <li>lastNameDoesNotContain -  (optional)</li>
          *   <li>lastNameEquals -  (optional)</li>
          *   <li>lastNameNotEquals -  (optional)</li>
          *   <li>lastNameSpecified -  (optional)</li>
          *   <li>lastNameIn -  (optional)</li>
          *   <li>lastNameNotIn -  (optional)</li>
          *   <li>dateOfBirthGreaterThan -  (optional)</li>
          *   <li>dateOfBirthLessThan -  (optional)</li>
          *   <li>dateOfBirthGreaterThanOrEqual -  (optional)</li>
          *   <li>dateOfBirthLessThanOrEqual -  (optional)</li>
          *   <li>dateOfBirthEquals -  (optional)</li>
          *   <li>dateOfBirthNotEquals -  (optional)</li>
          *   <li>dateOfBirthSpecified -  (optional)</li>
          *   <li>dateOfBirthIn -  (optional)</li>
          *   <li>dateOfBirthNotIn -  (optional)</li>
          *   <li>isVerifiedEquals -  (optional)</li>
          *   <li>isVerifiedNotEquals -  (optional)</li>
          *   <li>isVerifiedSpecified -  (optional)</li>
          *   <li>isVerifiedIn -  (optional)</li>
          *   <li>isVerifiedNotIn -  (optional)</li>
          *   <li>isActiveEquals -  (optional)</li>
          *   <li>isActiveNotEquals -  (optional)</li>
          *   <li>isActiveSpecified -  (optional)</li>
          *   <li>isActiveIn -  (optional)</li>
          *   <li>isActiveNotIn -  (optional)</li>
          *   <li>lastLoginAtGreaterThan -  (optional)</li>
          *   <li>lastLoginAtLessThan -  (optional)</li>
          *   <li>lastLoginAtGreaterThanOrEqual -  (optional)</li>
          *   <li>lastLoginAtLessThanOrEqual -  (optional)</li>
          *   <li>lastLoginAtEquals -  (optional)</li>
          *   <li>lastLoginAtNotEquals -  (optional)</li>
          *   <li>lastLoginAtSpecified -  (optional)</li>
          *   <li>lastLoginAtIn -  (optional)</li>
          *   <li>lastLoginAtNotIn -  (optional)</li>
          *   <li>createdAtGreaterThan -  (optional)</li>
          *   <li>createdAtLessThan -  (optional)</li>
          *   <li>createdAtGreaterThanOrEqual -  (optional)</li>
          *   <li>createdAtLessThanOrEqual -  (optional)</li>
          *   <li>createdAtEquals -  (optional)</li>
          *   <li>createdAtNotEquals -  (optional)</li>
          *   <li>createdAtSpecified -  (optional)</li>
          *   <li>createdAtIn -  (optional)</li>
          *   <li>createdAtNotIn -  (optional)</li>
          *   <li>updatedAtGreaterThan -  (optional)</li>
          *   <li>updatedAtLessThan -  (optional)</li>
          *   <li>updatedAtGreaterThanOrEqual -  (optional)</li>
          *   <li>updatedAtLessThanOrEqual -  (optional)</li>
          *   <li>updatedAtEquals -  (optional)</li>
          *   <li>updatedAtNotEquals -  (optional)</li>
          *   <li>updatedAtSpecified -  (optional)</li>
          *   <li>updatedAtIn -  (optional)</li>
          *   <li>updatedAtNotIn -  (optional)</li>
          *   <li>isDeletedEquals -  (optional)</li>
          *   <li>isDeletedNotEquals -  (optional)</li>
          *   <li>isDeletedSpecified -  (optional)</li>
          *   <li>isDeletedIn -  (optional)</li>
          *   <li>isDeletedNotIn -  (optional)</li>
          *   <li>deletedAtGreaterThan -  (optional)</li>
          *   <li>deletedAtLessThan -  (optional)</li>
          *   <li>deletedAtGreaterThanOrEqual -  (optional)</li>
          *   <li>deletedAtLessThanOrEqual -  (optional)</li>
          *   <li>deletedAtEquals -  (optional)</li>
          *   <li>deletedAtNotEquals -  (optional)</li>
          *   <li>deletedAtSpecified -  (optional)</li>
          *   <li>deletedAtIn -  (optional)</li>
          *   <li>deletedAtNotIn -  (optional)</li>
          *   <li>deletedByEquals -  (optional)</li>
          *   <li>deletedByNotEquals -  (optional)</li>
          *   <li>deletedBySpecified -  (optional)</li>
          *   <li>deletedByIn -  (optional)</li>
          *   <li>deletedByNotIn -  (optional)</li>
          *   <li>profileIdGreaterThan -  (optional)</li>
          *   <li>profileIdLessThan -  (optional)</li>
          *   <li>profileIdGreaterThanOrEqual -  (optional)</li>
          *   <li>profileIdLessThanOrEqual -  (optional)</li>
          *   <li>profileIdEquals -  (optional)</li>
          *   <li>profileIdNotEquals -  (optional)</li>
          *   <li>profileIdSpecified -  (optional)</li>
          *   <li>profileIdIn -  (optional)</li>
          *   <li>profileIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return List&lt;AppUserDTO&gt;
      */
      @RequestLine("GET /api/app-users?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&keycloakId.equals={keycloakIdEquals}&keycloakId.notEquals={keycloakIdNotEquals}&keycloakId.specified={keycloakIdSpecified}&keycloakId.in={keycloakIdIn}&keycloakId.notIn={keycloakIdNotIn}&email.contains={emailContains}&email.doesNotContain={emailDoesNotContain}&email.equals={emailEquals}&email.notEquals={emailNotEquals}&email.specified={emailSpecified}&email.in={emailIn}&email.notIn={emailNotIn}&phoneNumber.contains={phoneNumberContains}&phoneNumber.doesNotContain={phoneNumberDoesNotContain}&phoneNumber.equals={phoneNumberEquals}&phoneNumber.notEquals={phoneNumberNotEquals}&phoneNumber.specified={phoneNumberSpecified}&phoneNumber.in={phoneNumberIn}&phoneNumber.notIn={phoneNumberNotIn}&firstName.contains={firstNameContains}&firstName.doesNotContain={firstNameDoesNotContain}&firstName.equals={firstNameEquals}&firstName.notEquals={firstNameNotEquals}&firstName.specified={firstNameSpecified}&firstName.in={firstNameIn}&firstName.notIn={firstNameNotIn}&lastName.contains={lastNameContains}&lastName.doesNotContain={lastNameDoesNotContain}&lastName.equals={lastNameEquals}&lastName.notEquals={lastNameNotEquals}&lastName.specified={lastNameSpecified}&lastName.in={lastNameIn}&lastName.notIn={lastNameNotIn}&dateOfBirth.greaterThan={dateOfBirthGreaterThan}&dateOfBirth.lessThan={dateOfBirthLessThan}&dateOfBirth.greaterThanOrEqual={dateOfBirthGreaterThanOrEqual}&dateOfBirth.lessThanOrEqual={dateOfBirthLessThanOrEqual}&dateOfBirth.equals={dateOfBirthEquals}&dateOfBirth.notEquals={dateOfBirthNotEquals}&dateOfBirth.specified={dateOfBirthSpecified}&dateOfBirth.in={dateOfBirthIn}&dateOfBirth.notIn={dateOfBirthNotIn}&isVerified.equals={isVerifiedEquals}&isVerified.notEquals={isVerifiedNotEquals}&isVerified.specified={isVerifiedSpecified}&isVerified.in={isVerifiedIn}&isVerified.notIn={isVerifiedNotIn}&isActive.equals={isActiveEquals}&isActive.notEquals={isActiveNotEquals}&isActive.specified={isActiveSpecified}&isActive.in={isActiveIn}&isActive.notIn={isActiveNotIn}&lastLoginAt.greaterThan={lastLoginAtGreaterThan}&lastLoginAt.lessThan={lastLoginAtLessThan}&lastLoginAt.greaterThanOrEqual={lastLoginAtGreaterThanOrEqual}&lastLoginAt.lessThanOrEqual={lastLoginAtLessThanOrEqual}&lastLoginAt.equals={lastLoginAtEquals}&lastLoginAt.notEquals={lastLoginAtNotEquals}&lastLoginAt.specified={lastLoginAtSpecified}&lastLoginAt.in={lastLoginAtIn}&lastLoginAt.notIn={lastLoginAtNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&profileId.greaterThan={profileIdGreaterThan}&profileId.lessThan={profileIdLessThan}&profileId.greaterThanOrEqual={profileIdGreaterThanOrEqual}&profileId.lessThanOrEqual={profileIdLessThanOrEqual}&profileId.equals={profileIdEquals}&profileId.notEquals={profileIdNotEquals}&profileId.specified={profileIdSpecified}&profileId.in={profileIdIn}&profileId.notIn={profileIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<AppUserDTO>> getAllAppUsersWithHttpInfo(@QueryMap(encoded=true) GetAllAppUsersQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllAppUsers</code> method in a fluent style.
   */
  public static class GetAllAppUsersQueryParams extends HashMap<String, Object> {
    public GetAllAppUsersQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppUsersQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppUsersQueryParams keycloakIdEquals(@jakarta.annotation.Nullable final UUID value) {
      put("keycloakId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams keycloakIdNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("keycloakId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams keycloakIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("keycloakId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams keycloakIdIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("keycloakId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppUsersQueryParams keycloakIdNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("keycloakId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppUsersQueryParams emailContains(@jakarta.annotation.Nullable final String value) {
      put("email.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams emailDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("email.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams emailEquals(@jakarta.annotation.Nullable final String value) {
      put("email.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams emailNotEquals(@jakarta.annotation.Nullable final String value) {
      put("email.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams emailSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("email.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams emailIn(@jakarta.annotation.Nullable final List<String> value) {
      put("email.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppUsersQueryParams emailNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("email.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppUsersQueryParams phoneNumberContains(@jakarta.annotation.Nullable final String value) {
      put("phoneNumber.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams phoneNumberDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("phoneNumber.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams phoneNumberEquals(@jakarta.annotation.Nullable final String value) {
      put("phoneNumber.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams phoneNumberNotEquals(@jakarta.annotation.Nullable final String value) {
      put("phoneNumber.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams phoneNumberSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("phoneNumber.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams phoneNumberIn(@jakarta.annotation.Nullable final List<String> value) {
      put("phoneNumber.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppUsersQueryParams phoneNumberNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("phoneNumber.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppUsersQueryParams firstNameContains(@jakarta.annotation.Nullable final String value) {
      put("firstName.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams firstNameDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("firstName.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams firstNameEquals(@jakarta.annotation.Nullable final String value) {
      put("firstName.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams firstNameNotEquals(@jakarta.annotation.Nullable final String value) {
      put("firstName.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams firstNameSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("firstName.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams firstNameIn(@jakarta.annotation.Nullable final List<String> value) {
      put("firstName.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppUsersQueryParams firstNameNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("firstName.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppUsersQueryParams lastNameContains(@jakarta.annotation.Nullable final String value) {
      put("lastName.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams lastNameDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("lastName.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams lastNameEquals(@jakarta.annotation.Nullable final String value) {
      put("lastName.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams lastNameNotEquals(@jakarta.annotation.Nullable final String value) {
      put("lastName.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams lastNameSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("lastName.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams lastNameIn(@jakarta.annotation.Nullable final List<String> value) {
      put("lastName.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppUsersQueryParams lastNameNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("lastName.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppUsersQueryParams dateOfBirthGreaterThan(@jakarta.annotation.Nullable final LocalDate value) {
      put("dateOfBirth.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams dateOfBirthLessThan(@jakarta.annotation.Nullable final LocalDate value) {
      put("dateOfBirth.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams dateOfBirthGreaterThanOrEqual(@jakarta.annotation.Nullable final LocalDate value) {
      put("dateOfBirth.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams dateOfBirthLessThanOrEqual(@jakarta.annotation.Nullable final LocalDate value) {
      put("dateOfBirth.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams dateOfBirthEquals(@jakarta.annotation.Nullable final LocalDate value) {
      put("dateOfBirth.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams dateOfBirthNotEquals(@jakarta.annotation.Nullable final LocalDate value) {
      put("dateOfBirth.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams dateOfBirthSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("dateOfBirth.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams dateOfBirthIn(@jakarta.annotation.Nullable final List<LocalDate> value) {
      put("dateOfBirth.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppUsersQueryParams dateOfBirthNotIn(@jakarta.annotation.Nullable final List<LocalDate> value) {
      put("dateOfBirth.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppUsersQueryParams isVerifiedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isVerified.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams isVerifiedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isVerified.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams isVerifiedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isVerified.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams isVerifiedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isVerified.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppUsersQueryParams isVerifiedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isVerified.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppUsersQueryParams isActiveEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isActive.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams isActiveNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isActive.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams isActiveSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isActive.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams isActiveIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isActive.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppUsersQueryParams isActiveNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isActive.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppUsersQueryParams lastLoginAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("lastLoginAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams lastLoginAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("lastLoginAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams lastLoginAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("lastLoginAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams lastLoginAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("lastLoginAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams lastLoginAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("lastLoginAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams lastLoginAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("lastLoginAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams lastLoginAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("lastLoginAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams lastLoginAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("lastLoginAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppUsersQueryParams lastLoginAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("lastLoginAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppUsersQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppUsersQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppUsersQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppUsersQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppUsersQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppUsersQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppUsersQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppUsersQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppUsersQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppUsersQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppUsersQueryParams profileIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("profileId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams profileIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("profileId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams profileIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("profileId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams profileIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("profileId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams profileIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("profileId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams profileIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("profileId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams profileIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("profileId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppUsersQueryParams profileIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("profileId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppUsersQueryParams profileIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("profileId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppUsersQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @return AppUserDTO
   */
  @RequestLine("GET /api/app-users/{id}")
  @Headers({
    "Accept: */*",
  })
  AppUserDTO getAppUser(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>getAppUser</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/app-users/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<AppUserDTO> getAppUserWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param id  (required)
   * @param appUserDTO  (required)
   * @return AppUserDTO
   */
  @RequestLine("PATCH /api/app-users/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  AppUserDTO partialUpdateAppUser(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull AppUserDTO appUserDTO);

  /**
   * 
   * Similar to <code>partialUpdateAppUser</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param appUserDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /api/app-users/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<AppUserDTO> partialUpdateAppUserWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull AppUserDTO appUserDTO);



  /**
   * 
   * 
   * @param id  (required)
   * @param appUserDTO  (required)
   * @return AppUserDTO
   */
  @RequestLine("PUT /api/app-users/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  AppUserDTO updateAppUser(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull AppUserDTO appUserDTO);

  /**
   * 
   * Similar to <code>updateAppUser</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param appUserDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/app-users/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<AppUserDTO> updateAppUserWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull AppUserDTO appUserDTO);


}
