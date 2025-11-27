package com.ridehub.msuser.client.api;

import com.ridehub.msuser.client.invoker.ApiClient;
import com.ridehub.msuser.client.invoker.EncodingUtils;
import com.ridehub.msuser.client.model.ApiResponse;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import com.ridehub.msuser.client.model.ProfileDTO;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface ProfileResourceMsuserApi extends ApiClient.Api {


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
   * @param fullNameContains  (optional)
   * @param fullNameDoesNotContain  (optional)
   * @param fullNameEquals  (optional)
   * @param fullNameNotEquals  (optional)
   * @param fullNameSpecified  (optional)
   * @param fullNameIn  (optional)
   * @param fullNameNotIn  (optional)
   * @param birthDateGreaterThan  (optional)
   * @param birthDateLessThan  (optional)
   * @param birthDateGreaterThanOrEqual  (optional)
   * @param birthDateLessThanOrEqual  (optional)
   * @param birthDateEquals  (optional)
   * @param birthDateNotEquals  (optional)
   * @param birthDateSpecified  (optional)
   * @param birthDateIn  (optional)
   * @param birthDateNotIn  (optional)
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
   * @param avatarIdGreaterThan  (optional)
   * @param avatarIdLessThan  (optional)
   * @param avatarIdGreaterThanOrEqual  (optional)
   * @param avatarIdLessThanOrEqual  (optional)
   * @param avatarIdEquals  (optional)
   * @param avatarIdNotEquals  (optional)
   * @param avatarIdSpecified  (optional)
   * @param avatarIdIn  (optional)
   * @param avatarIdNotIn  (optional)
   * @param userIdGreaterThan  (optional)
   * @param userIdLessThan  (optional)
   * @param userIdGreaterThanOrEqual  (optional)
   * @param userIdLessThanOrEqual  (optional)
   * @param userIdEquals  (optional)
   * @param userIdNotEquals  (optional)
   * @param userIdSpecified  (optional)
   * @param userIdIn  (optional)
   * @param userIdNotIn  (optional)
   * @param distinct  (optional)
   * @return Long
   */
  @RequestLine("GET /api/profiles/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&fullName.contains={fullNameContains}&fullName.doesNotContain={fullNameDoesNotContain}&fullName.equals={fullNameEquals}&fullName.notEquals={fullNameNotEquals}&fullName.specified={fullNameSpecified}&fullName.in={fullNameIn}&fullName.notIn={fullNameNotIn}&birthDate.greaterThan={birthDateGreaterThan}&birthDate.lessThan={birthDateLessThan}&birthDate.greaterThanOrEqual={birthDateGreaterThanOrEqual}&birthDate.lessThanOrEqual={birthDateLessThanOrEqual}&birthDate.equals={birthDateEquals}&birthDate.notEquals={birthDateNotEquals}&birthDate.specified={birthDateSpecified}&birthDate.in={birthDateIn}&birthDate.notIn={birthDateNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&avatarId.greaterThan={avatarIdGreaterThan}&avatarId.lessThan={avatarIdLessThan}&avatarId.greaterThanOrEqual={avatarIdGreaterThanOrEqual}&avatarId.lessThanOrEqual={avatarIdLessThanOrEqual}&avatarId.equals={avatarIdEquals}&avatarId.notEquals={avatarIdNotEquals}&avatarId.specified={avatarIdSpecified}&avatarId.in={avatarIdIn}&avatarId.notIn={avatarIdNotIn}&userId.greaterThan={userIdGreaterThan}&userId.lessThan={userIdLessThan}&userId.greaterThanOrEqual={userIdGreaterThanOrEqual}&userId.lessThanOrEqual={userIdLessThanOrEqual}&userId.equals={userIdEquals}&userId.notEquals={userIdNotEquals}&userId.specified={userIdSpecified}&userId.in={userIdIn}&userId.notIn={userIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  Long countProfiles(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("fullNameContains") @jakarta.annotation.Nullable String fullNameContains, @Param("fullNameDoesNotContain") @jakarta.annotation.Nullable String fullNameDoesNotContain, @Param("fullNameEquals") @jakarta.annotation.Nullable String fullNameEquals, @Param("fullNameNotEquals") @jakarta.annotation.Nullable String fullNameNotEquals, @Param("fullNameSpecified") @jakarta.annotation.Nullable Boolean fullNameSpecified, @Param("fullNameIn") @jakarta.annotation.Nullable List<String> fullNameIn, @Param("fullNameNotIn") @jakarta.annotation.Nullable List<String> fullNameNotIn, @Param("birthDateGreaterThan") @jakarta.annotation.Nullable LocalDate birthDateGreaterThan, @Param("birthDateLessThan") @jakarta.annotation.Nullable LocalDate birthDateLessThan, @Param("birthDateGreaterThanOrEqual") @jakarta.annotation.Nullable LocalDate birthDateGreaterThanOrEqual, @Param("birthDateLessThanOrEqual") @jakarta.annotation.Nullable LocalDate birthDateLessThanOrEqual, @Param("birthDateEquals") @jakarta.annotation.Nullable LocalDate birthDateEquals, @Param("birthDateNotEquals") @jakarta.annotation.Nullable LocalDate birthDateNotEquals, @Param("birthDateSpecified") @jakarta.annotation.Nullable Boolean birthDateSpecified, @Param("birthDateIn") @jakarta.annotation.Nullable List<LocalDate> birthDateIn, @Param("birthDateNotIn") @jakarta.annotation.Nullable List<LocalDate> birthDateNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("avatarIdGreaterThan") @jakarta.annotation.Nullable Long avatarIdGreaterThan, @Param("avatarIdLessThan") @jakarta.annotation.Nullable Long avatarIdLessThan, @Param("avatarIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long avatarIdGreaterThanOrEqual, @Param("avatarIdLessThanOrEqual") @jakarta.annotation.Nullable Long avatarIdLessThanOrEqual, @Param("avatarIdEquals") @jakarta.annotation.Nullable Long avatarIdEquals, @Param("avatarIdNotEquals") @jakarta.annotation.Nullable Long avatarIdNotEquals, @Param("avatarIdSpecified") @jakarta.annotation.Nullable Boolean avatarIdSpecified, @Param("avatarIdIn") @jakarta.annotation.Nullable List<Long> avatarIdIn, @Param("avatarIdNotIn") @jakarta.annotation.Nullable List<Long> avatarIdNotIn, @Param("userIdGreaterThan") @jakarta.annotation.Nullable Long userIdGreaterThan, @Param("userIdLessThan") @jakarta.annotation.Nullable Long userIdLessThan, @Param("userIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long userIdGreaterThanOrEqual, @Param("userIdLessThanOrEqual") @jakarta.annotation.Nullable Long userIdLessThanOrEqual, @Param("userIdEquals") @jakarta.annotation.Nullable Long userIdEquals, @Param("userIdNotEquals") @jakarta.annotation.Nullable Long userIdNotEquals, @Param("userIdSpecified") @jakarta.annotation.Nullable Boolean userIdSpecified, @Param("userIdIn") @jakarta.annotation.Nullable List<Long> userIdIn, @Param("userIdNotIn") @jakarta.annotation.Nullable List<Long> userIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>countProfiles</code> but it also returns the http response headers .
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
   * @param fullNameContains  (optional)
   * @param fullNameDoesNotContain  (optional)
   * @param fullNameEquals  (optional)
   * @param fullNameNotEquals  (optional)
   * @param fullNameSpecified  (optional)
   * @param fullNameIn  (optional)
   * @param fullNameNotIn  (optional)
   * @param birthDateGreaterThan  (optional)
   * @param birthDateLessThan  (optional)
   * @param birthDateGreaterThanOrEqual  (optional)
   * @param birthDateLessThanOrEqual  (optional)
   * @param birthDateEquals  (optional)
   * @param birthDateNotEquals  (optional)
   * @param birthDateSpecified  (optional)
   * @param birthDateIn  (optional)
   * @param birthDateNotIn  (optional)
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
   * @param avatarIdGreaterThan  (optional)
   * @param avatarIdLessThan  (optional)
   * @param avatarIdGreaterThanOrEqual  (optional)
   * @param avatarIdLessThanOrEqual  (optional)
   * @param avatarIdEquals  (optional)
   * @param avatarIdNotEquals  (optional)
   * @param avatarIdSpecified  (optional)
   * @param avatarIdIn  (optional)
   * @param avatarIdNotIn  (optional)
   * @param userIdGreaterThan  (optional)
   * @param userIdLessThan  (optional)
   * @param userIdGreaterThanOrEqual  (optional)
   * @param userIdLessThanOrEqual  (optional)
   * @param userIdEquals  (optional)
   * @param userIdNotEquals  (optional)
   * @param userIdSpecified  (optional)
   * @param userIdIn  (optional)
   * @param userIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/profiles/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&fullName.contains={fullNameContains}&fullName.doesNotContain={fullNameDoesNotContain}&fullName.equals={fullNameEquals}&fullName.notEquals={fullNameNotEquals}&fullName.specified={fullNameSpecified}&fullName.in={fullNameIn}&fullName.notIn={fullNameNotIn}&birthDate.greaterThan={birthDateGreaterThan}&birthDate.lessThan={birthDateLessThan}&birthDate.greaterThanOrEqual={birthDateGreaterThanOrEqual}&birthDate.lessThanOrEqual={birthDateLessThanOrEqual}&birthDate.equals={birthDateEquals}&birthDate.notEquals={birthDateNotEquals}&birthDate.specified={birthDateSpecified}&birthDate.in={birthDateIn}&birthDate.notIn={birthDateNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&avatarId.greaterThan={avatarIdGreaterThan}&avatarId.lessThan={avatarIdLessThan}&avatarId.greaterThanOrEqual={avatarIdGreaterThanOrEqual}&avatarId.lessThanOrEqual={avatarIdLessThanOrEqual}&avatarId.equals={avatarIdEquals}&avatarId.notEquals={avatarIdNotEquals}&avatarId.specified={avatarIdSpecified}&avatarId.in={avatarIdIn}&avatarId.notIn={avatarIdNotIn}&userId.greaterThan={userIdGreaterThan}&userId.lessThan={userIdLessThan}&userId.greaterThanOrEqual={userIdGreaterThanOrEqual}&userId.lessThanOrEqual={userIdLessThanOrEqual}&userId.equals={userIdEquals}&userId.notEquals={userIdNotEquals}&userId.specified={userIdSpecified}&userId.in={userIdIn}&userId.notIn={userIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Long> countProfilesWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("fullNameContains") @jakarta.annotation.Nullable String fullNameContains, @Param("fullNameDoesNotContain") @jakarta.annotation.Nullable String fullNameDoesNotContain, @Param("fullNameEquals") @jakarta.annotation.Nullable String fullNameEquals, @Param("fullNameNotEquals") @jakarta.annotation.Nullable String fullNameNotEquals, @Param("fullNameSpecified") @jakarta.annotation.Nullable Boolean fullNameSpecified, @Param("fullNameIn") @jakarta.annotation.Nullable List<String> fullNameIn, @Param("fullNameNotIn") @jakarta.annotation.Nullable List<String> fullNameNotIn, @Param("birthDateGreaterThan") @jakarta.annotation.Nullable LocalDate birthDateGreaterThan, @Param("birthDateLessThan") @jakarta.annotation.Nullable LocalDate birthDateLessThan, @Param("birthDateGreaterThanOrEqual") @jakarta.annotation.Nullable LocalDate birthDateGreaterThanOrEqual, @Param("birthDateLessThanOrEqual") @jakarta.annotation.Nullable LocalDate birthDateLessThanOrEqual, @Param("birthDateEquals") @jakarta.annotation.Nullable LocalDate birthDateEquals, @Param("birthDateNotEquals") @jakarta.annotation.Nullable LocalDate birthDateNotEquals, @Param("birthDateSpecified") @jakarta.annotation.Nullable Boolean birthDateSpecified, @Param("birthDateIn") @jakarta.annotation.Nullable List<LocalDate> birthDateIn, @Param("birthDateNotIn") @jakarta.annotation.Nullable List<LocalDate> birthDateNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("avatarIdGreaterThan") @jakarta.annotation.Nullable Long avatarIdGreaterThan, @Param("avatarIdLessThan") @jakarta.annotation.Nullable Long avatarIdLessThan, @Param("avatarIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long avatarIdGreaterThanOrEqual, @Param("avatarIdLessThanOrEqual") @jakarta.annotation.Nullable Long avatarIdLessThanOrEqual, @Param("avatarIdEquals") @jakarta.annotation.Nullable Long avatarIdEquals, @Param("avatarIdNotEquals") @jakarta.annotation.Nullable Long avatarIdNotEquals, @Param("avatarIdSpecified") @jakarta.annotation.Nullable Boolean avatarIdSpecified, @Param("avatarIdIn") @jakarta.annotation.Nullable List<Long> avatarIdIn, @Param("avatarIdNotIn") @jakarta.annotation.Nullable List<Long> avatarIdNotIn, @Param("userIdGreaterThan") @jakarta.annotation.Nullable Long userIdGreaterThan, @Param("userIdLessThan") @jakarta.annotation.Nullable Long userIdLessThan, @Param("userIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long userIdGreaterThanOrEqual, @Param("userIdLessThanOrEqual") @jakarta.annotation.Nullable Long userIdLessThanOrEqual, @Param("userIdEquals") @jakarta.annotation.Nullable Long userIdEquals, @Param("userIdNotEquals") @jakarta.annotation.Nullable Long userIdNotEquals, @Param("userIdSpecified") @jakarta.annotation.Nullable Boolean userIdSpecified, @Param("userIdIn") @jakarta.annotation.Nullable List<Long> userIdIn, @Param("userIdNotIn") @jakarta.annotation.Nullable List<Long> userIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>countProfiles</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CountProfilesQueryParams} class that allows for
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
   *   <li>fullNameContains -  (optional)</li>
   *   <li>fullNameDoesNotContain -  (optional)</li>
   *   <li>fullNameEquals -  (optional)</li>
   *   <li>fullNameNotEquals -  (optional)</li>
   *   <li>fullNameSpecified -  (optional)</li>
   *   <li>fullNameIn -  (optional)</li>
   *   <li>fullNameNotIn -  (optional)</li>
   *   <li>birthDateGreaterThan -  (optional)</li>
   *   <li>birthDateLessThan -  (optional)</li>
   *   <li>birthDateGreaterThanOrEqual -  (optional)</li>
   *   <li>birthDateLessThanOrEqual -  (optional)</li>
   *   <li>birthDateEquals -  (optional)</li>
   *   <li>birthDateNotEquals -  (optional)</li>
   *   <li>birthDateSpecified -  (optional)</li>
   *   <li>birthDateIn -  (optional)</li>
   *   <li>birthDateNotIn -  (optional)</li>
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
   *   <li>avatarIdGreaterThan -  (optional)</li>
   *   <li>avatarIdLessThan -  (optional)</li>
   *   <li>avatarIdGreaterThanOrEqual -  (optional)</li>
   *   <li>avatarIdLessThanOrEqual -  (optional)</li>
   *   <li>avatarIdEquals -  (optional)</li>
   *   <li>avatarIdNotEquals -  (optional)</li>
   *   <li>avatarIdSpecified -  (optional)</li>
   *   <li>avatarIdIn -  (optional)</li>
   *   <li>avatarIdNotIn -  (optional)</li>
   *   <li>userIdGreaterThan -  (optional)</li>
   *   <li>userIdLessThan -  (optional)</li>
   *   <li>userIdGreaterThanOrEqual -  (optional)</li>
   *   <li>userIdLessThanOrEqual -  (optional)</li>
   *   <li>userIdEquals -  (optional)</li>
   *   <li>userIdNotEquals -  (optional)</li>
   *   <li>userIdSpecified -  (optional)</li>
   *   <li>userIdIn -  (optional)</li>
   *   <li>userIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return Long
   */
  @RequestLine("GET /api/profiles/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&fullName.contains={fullNameContains}&fullName.doesNotContain={fullNameDoesNotContain}&fullName.equals={fullNameEquals}&fullName.notEquals={fullNameNotEquals}&fullName.specified={fullNameSpecified}&fullName.in={fullNameIn}&fullName.notIn={fullNameNotIn}&birthDate.greaterThan={birthDateGreaterThan}&birthDate.lessThan={birthDateLessThan}&birthDate.greaterThanOrEqual={birthDateGreaterThanOrEqual}&birthDate.lessThanOrEqual={birthDateLessThanOrEqual}&birthDate.equals={birthDateEquals}&birthDate.notEquals={birthDateNotEquals}&birthDate.specified={birthDateSpecified}&birthDate.in={birthDateIn}&birthDate.notIn={birthDateNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&avatarId.greaterThan={avatarIdGreaterThan}&avatarId.lessThan={avatarIdLessThan}&avatarId.greaterThanOrEqual={avatarIdGreaterThanOrEqual}&avatarId.lessThanOrEqual={avatarIdLessThanOrEqual}&avatarId.equals={avatarIdEquals}&avatarId.notEquals={avatarIdNotEquals}&avatarId.specified={avatarIdSpecified}&avatarId.in={avatarIdIn}&avatarId.notIn={avatarIdNotIn}&userId.greaterThan={userIdGreaterThan}&userId.lessThan={userIdLessThan}&userId.greaterThanOrEqual={userIdGreaterThanOrEqual}&userId.lessThanOrEqual={userIdLessThanOrEqual}&userId.equals={userIdEquals}&userId.notEquals={userIdNotEquals}&userId.specified={userIdSpecified}&userId.in={userIdIn}&userId.notIn={userIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  Long countProfiles(@QueryMap(encoded=true) CountProfilesQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>countProfiles</code> that receives the query parameters as a map,
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
          *   <li>fullNameContains -  (optional)</li>
          *   <li>fullNameDoesNotContain -  (optional)</li>
          *   <li>fullNameEquals -  (optional)</li>
          *   <li>fullNameNotEquals -  (optional)</li>
          *   <li>fullNameSpecified -  (optional)</li>
          *   <li>fullNameIn -  (optional)</li>
          *   <li>fullNameNotIn -  (optional)</li>
          *   <li>birthDateGreaterThan -  (optional)</li>
          *   <li>birthDateLessThan -  (optional)</li>
          *   <li>birthDateGreaterThanOrEqual -  (optional)</li>
          *   <li>birthDateLessThanOrEqual -  (optional)</li>
          *   <li>birthDateEquals -  (optional)</li>
          *   <li>birthDateNotEquals -  (optional)</li>
          *   <li>birthDateSpecified -  (optional)</li>
          *   <li>birthDateIn -  (optional)</li>
          *   <li>birthDateNotIn -  (optional)</li>
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
          *   <li>avatarIdGreaterThan -  (optional)</li>
          *   <li>avatarIdLessThan -  (optional)</li>
          *   <li>avatarIdGreaterThanOrEqual -  (optional)</li>
          *   <li>avatarIdLessThanOrEqual -  (optional)</li>
          *   <li>avatarIdEquals -  (optional)</li>
          *   <li>avatarIdNotEquals -  (optional)</li>
          *   <li>avatarIdSpecified -  (optional)</li>
          *   <li>avatarIdIn -  (optional)</li>
          *   <li>avatarIdNotIn -  (optional)</li>
          *   <li>userIdGreaterThan -  (optional)</li>
          *   <li>userIdLessThan -  (optional)</li>
          *   <li>userIdGreaterThanOrEqual -  (optional)</li>
          *   <li>userIdLessThanOrEqual -  (optional)</li>
          *   <li>userIdEquals -  (optional)</li>
          *   <li>userIdNotEquals -  (optional)</li>
          *   <li>userIdSpecified -  (optional)</li>
          *   <li>userIdIn -  (optional)</li>
          *   <li>userIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return Long
      */
      @RequestLine("GET /api/profiles/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&fullName.contains={fullNameContains}&fullName.doesNotContain={fullNameDoesNotContain}&fullName.equals={fullNameEquals}&fullName.notEquals={fullNameNotEquals}&fullName.specified={fullNameSpecified}&fullName.in={fullNameIn}&fullName.notIn={fullNameNotIn}&birthDate.greaterThan={birthDateGreaterThan}&birthDate.lessThan={birthDateLessThan}&birthDate.greaterThanOrEqual={birthDateGreaterThanOrEqual}&birthDate.lessThanOrEqual={birthDateLessThanOrEqual}&birthDate.equals={birthDateEquals}&birthDate.notEquals={birthDateNotEquals}&birthDate.specified={birthDateSpecified}&birthDate.in={birthDateIn}&birthDate.notIn={birthDateNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&avatarId.greaterThan={avatarIdGreaterThan}&avatarId.lessThan={avatarIdLessThan}&avatarId.greaterThanOrEqual={avatarIdGreaterThanOrEqual}&avatarId.lessThanOrEqual={avatarIdLessThanOrEqual}&avatarId.equals={avatarIdEquals}&avatarId.notEquals={avatarIdNotEquals}&avatarId.specified={avatarIdSpecified}&avatarId.in={avatarIdIn}&avatarId.notIn={avatarIdNotIn}&userId.greaterThan={userIdGreaterThan}&userId.lessThan={userIdLessThan}&userId.greaterThanOrEqual={userIdGreaterThanOrEqual}&userId.lessThanOrEqual={userIdLessThanOrEqual}&userId.equals={userIdEquals}&userId.notEquals={userIdNotEquals}&userId.specified={userIdSpecified}&userId.in={userIdIn}&userId.notIn={userIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Long> countProfilesWithHttpInfo(@QueryMap(encoded=true) CountProfilesQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>countProfiles</code> method in a fluent style.
   */
  public static class CountProfilesQueryParams extends HashMap<String, Object> {
    public CountProfilesQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProfilesQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProfilesQueryParams fullNameContains(@jakarta.annotation.Nullable final String value) {
      put("fullName.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams fullNameDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("fullName.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams fullNameEquals(@jakarta.annotation.Nullable final String value) {
      put("fullName.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams fullNameNotEquals(@jakarta.annotation.Nullable final String value) {
      put("fullName.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams fullNameSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("fullName.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams fullNameIn(@jakarta.annotation.Nullable final List<String> value) {
      put("fullName.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProfilesQueryParams fullNameNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("fullName.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProfilesQueryParams birthDateGreaterThan(@jakarta.annotation.Nullable final LocalDate value) {
      put("birthDate.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams birthDateLessThan(@jakarta.annotation.Nullable final LocalDate value) {
      put("birthDate.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams birthDateGreaterThanOrEqual(@jakarta.annotation.Nullable final LocalDate value) {
      put("birthDate.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams birthDateLessThanOrEqual(@jakarta.annotation.Nullable final LocalDate value) {
      put("birthDate.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams birthDateEquals(@jakarta.annotation.Nullable final LocalDate value) {
      put("birthDate.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams birthDateNotEquals(@jakarta.annotation.Nullable final LocalDate value) {
      put("birthDate.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams birthDateSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("birthDate.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams birthDateIn(@jakarta.annotation.Nullable final List<LocalDate> value) {
      put("birthDate.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProfilesQueryParams birthDateNotIn(@jakarta.annotation.Nullable final List<LocalDate> value) {
      put("birthDate.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProfilesQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProfilesQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProfilesQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProfilesQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProfilesQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProfilesQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProfilesQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProfilesQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProfilesQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProfilesQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProfilesQueryParams avatarIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("avatarId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams avatarIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("avatarId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams avatarIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("avatarId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams avatarIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("avatarId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams avatarIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("avatarId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams avatarIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("avatarId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams avatarIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("avatarId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams avatarIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("avatarId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProfilesQueryParams avatarIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("avatarId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProfilesQueryParams userIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("userId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams userIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("userId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams userIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("userId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams userIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("userId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams userIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("userId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams userIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("userId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams userIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("userId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountProfilesQueryParams userIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("userId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProfilesQueryParams userIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("userId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProfilesQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param profileDTO  (required)
   * @return ProfileDTO
   */
  @RequestLine("POST /api/profiles")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ProfileDTO createProfile(@jakarta.annotation.Nonnull ProfileDTO profileDTO);

  /**
   * 
   * Similar to <code>createProfile</code> but it also returns the http response headers .
   * 
   * @param profileDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/profiles")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<ProfileDTO> createProfileWithHttpInfo(@jakarta.annotation.Nonnull ProfileDTO profileDTO);



  /**
   * 
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/profiles/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteProfile(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>deleteProfile</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/profiles/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteProfileWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



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
   * @param fullNameContains  (optional)
   * @param fullNameDoesNotContain  (optional)
   * @param fullNameEquals  (optional)
   * @param fullNameNotEquals  (optional)
   * @param fullNameSpecified  (optional)
   * @param fullNameIn  (optional)
   * @param fullNameNotIn  (optional)
   * @param birthDateGreaterThan  (optional)
   * @param birthDateLessThan  (optional)
   * @param birthDateGreaterThanOrEqual  (optional)
   * @param birthDateLessThanOrEqual  (optional)
   * @param birthDateEquals  (optional)
   * @param birthDateNotEquals  (optional)
   * @param birthDateSpecified  (optional)
   * @param birthDateIn  (optional)
   * @param birthDateNotIn  (optional)
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
   * @param avatarIdGreaterThan  (optional)
   * @param avatarIdLessThan  (optional)
   * @param avatarIdGreaterThanOrEqual  (optional)
   * @param avatarIdLessThanOrEqual  (optional)
   * @param avatarIdEquals  (optional)
   * @param avatarIdNotEquals  (optional)
   * @param avatarIdSpecified  (optional)
   * @param avatarIdIn  (optional)
   * @param avatarIdNotIn  (optional)
   * @param userIdGreaterThan  (optional)
   * @param userIdLessThan  (optional)
   * @param userIdGreaterThanOrEqual  (optional)
   * @param userIdLessThanOrEqual  (optional)
   * @param userIdEquals  (optional)
   * @param userIdNotEquals  (optional)
   * @param userIdSpecified  (optional)
   * @param userIdIn  (optional)
   * @param userIdNotIn  (optional)
   * @param distinct  (optional)
   * @return List&lt;ProfileDTO&gt;
   */
  @RequestLine("GET /api/profiles?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&fullName.contains={fullNameContains}&fullName.doesNotContain={fullNameDoesNotContain}&fullName.equals={fullNameEquals}&fullName.notEquals={fullNameNotEquals}&fullName.specified={fullNameSpecified}&fullName.in={fullNameIn}&fullName.notIn={fullNameNotIn}&birthDate.greaterThan={birthDateGreaterThan}&birthDate.lessThan={birthDateLessThan}&birthDate.greaterThanOrEqual={birthDateGreaterThanOrEqual}&birthDate.lessThanOrEqual={birthDateLessThanOrEqual}&birthDate.equals={birthDateEquals}&birthDate.notEquals={birthDateNotEquals}&birthDate.specified={birthDateSpecified}&birthDate.in={birthDateIn}&birthDate.notIn={birthDateNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&avatarId.greaterThan={avatarIdGreaterThan}&avatarId.lessThan={avatarIdLessThan}&avatarId.greaterThanOrEqual={avatarIdGreaterThanOrEqual}&avatarId.lessThanOrEqual={avatarIdLessThanOrEqual}&avatarId.equals={avatarIdEquals}&avatarId.notEquals={avatarIdNotEquals}&avatarId.specified={avatarIdSpecified}&avatarId.in={avatarIdIn}&avatarId.notIn={avatarIdNotIn}&userId.greaterThan={userIdGreaterThan}&userId.lessThan={userIdLessThan}&userId.greaterThanOrEqual={userIdGreaterThanOrEqual}&userId.lessThanOrEqual={userIdLessThanOrEqual}&userId.equals={userIdEquals}&userId.notEquals={userIdNotEquals}&userId.specified={userIdSpecified}&userId.in={userIdIn}&userId.notIn={userIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  List<ProfileDTO> getAllProfiles(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("fullNameContains") @jakarta.annotation.Nullable String fullNameContains, @Param("fullNameDoesNotContain") @jakarta.annotation.Nullable String fullNameDoesNotContain, @Param("fullNameEquals") @jakarta.annotation.Nullable String fullNameEquals, @Param("fullNameNotEquals") @jakarta.annotation.Nullable String fullNameNotEquals, @Param("fullNameSpecified") @jakarta.annotation.Nullable Boolean fullNameSpecified, @Param("fullNameIn") @jakarta.annotation.Nullable List<String> fullNameIn, @Param("fullNameNotIn") @jakarta.annotation.Nullable List<String> fullNameNotIn, @Param("birthDateGreaterThan") @jakarta.annotation.Nullable LocalDate birthDateGreaterThan, @Param("birthDateLessThan") @jakarta.annotation.Nullable LocalDate birthDateLessThan, @Param("birthDateGreaterThanOrEqual") @jakarta.annotation.Nullable LocalDate birthDateGreaterThanOrEqual, @Param("birthDateLessThanOrEqual") @jakarta.annotation.Nullable LocalDate birthDateLessThanOrEqual, @Param("birthDateEquals") @jakarta.annotation.Nullable LocalDate birthDateEquals, @Param("birthDateNotEquals") @jakarta.annotation.Nullable LocalDate birthDateNotEquals, @Param("birthDateSpecified") @jakarta.annotation.Nullable Boolean birthDateSpecified, @Param("birthDateIn") @jakarta.annotation.Nullable List<LocalDate> birthDateIn, @Param("birthDateNotIn") @jakarta.annotation.Nullable List<LocalDate> birthDateNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("avatarIdGreaterThan") @jakarta.annotation.Nullable Long avatarIdGreaterThan, @Param("avatarIdLessThan") @jakarta.annotation.Nullable Long avatarIdLessThan, @Param("avatarIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long avatarIdGreaterThanOrEqual, @Param("avatarIdLessThanOrEqual") @jakarta.annotation.Nullable Long avatarIdLessThanOrEqual, @Param("avatarIdEquals") @jakarta.annotation.Nullable Long avatarIdEquals, @Param("avatarIdNotEquals") @jakarta.annotation.Nullable Long avatarIdNotEquals, @Param("avatarIdSpecified") @jakarta.annotation.Nullable Boolean avatarIdSpecified, @Param("avatarIdIn") @jakarta.annotation.Nullable List<Long> avatarIdIn, @Param("avatarIdNotIn") @jakarta.annotation.Nullable List<Long> avatarIdNotIn, @Param("userIdGreaterThan") @jakarta.annotation.Nullable Long userIdGreaterThan, @Param("userIdLessThan") @jakarta.annotation.Nullable Long userIdLessThan, @Param("userIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long userIdGreaterThanOrEqual, @Param("userIdLessThanOrEqual") @jakarta.annotation.Nullable Long userIdLessThanOrEqual, @Param("userIdEquals") @jakarta.annotation.Nullable Long userIdEquals, @Param("userIdNotEquals") @jakarta.annotation.Nullable Long userIdNotEquals, @Param("userIdSpecified") @jakarta.annotation.Nullable Boolean userIdSpecified, @Param("userIdIn") @jakarta.annotation.Nullable List<Long> userIdIn, @Param("userIdNotIn") @jakarta.annotation.Nullable List<Long> userIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>getAllProfiles</code> but it also returns the http response headers .
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
   * @param fullNameContains  (optional)
   * @param fullNameDoesNotContain  (optional)
   * @param fullNameEquals  (optional)
   * @param fullNameNotEquals  (optional)
   * @param fullNameSpecified  (optional)
   * @param fullNameIn  (optional)
   * @param fullNameNotIn  (optional)
   * @param birthDateGreaterThan  (optional)
   * @param birthDateLessThan  (optional)
   * @param birthDateGreaterThanOrEqual  (optional)
   * @param birthDateLessThanOrEqual  (optional)
   * @param birthDateEquals  (optional)
   * @param birthDateNotEquals  (optional)
   * @param birthDateSpecified  (optional)
   * @param birthDateIn  (optional)
   * @param birthDateNotIn  (optional)
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
   * @param avatarIdGreaterThan  (optional)
   * @param avatarIdLessThan  (optional)
   * @param avatarIdGreaterThanOrEqual  (optional)
   * @param avatarIdLessThanOrEqual  (optional)
   * @param avatarIdEquals  (optional)
   * @param avatarIdNotEquals  (optional)
   * @param avatarIdSpecified  (optional)
   * @param avatarIdIn  (optional)
   * @param avatarIdNotIn  (optional)
   * @param userIdGreaterThan  (optional)
   * @param userIdLessThan  (optional)
   * @param userIdGreaterThanOrEqual  (optional)
   * @param userIdLessThanOrEqual  (optional)
   * @param userIdEquals  (optional)
   * @param userIdNotEquals  (optional)
   * @param userIdSpecified  (optional)
   * @param userIdIn  (optional)
   * @param userIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/profiles?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&fullName.contains={fullNameContains}&fullName.doesNotContain={fullNameDoesNotContain}&fullName.equals={fullNameEquals}&fullName.notEquals={fullNameNotEquals}&fullName.specified={fullNameSpecified}&fullName.in={fullNameIn}&fullName.notIn={fullNameNotIn}&birthDate.greaterThan={birthDateGreaterThan}&birthDate.lessThan={birthDateLessThan}&birthDate.greaterThanOrEqual={birthDateGreaterThanOrEqual}&birthDate.lessThanOrEqual={birthDateLessThanOrEqual}&birthDate.equals={birthDateEquals}&birthDate.notEquals={birthDateNotEquals}&birthDate.specified={birthDateSpecified}&birthDate.in={birthDateIn}&birthDate.notIn={birthDateNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&avatarId.greaterThan={avatarIdGreaterThan}&avatarId.lessThan={avatarIdLessThan}&avatarId.greaterThanOrEqual={avatarIdGreaterThanOrEqual}&avatarId.lessThanOrEqual={avatarIdLessThanOrEqual}&avatarId.equals={avatarIdEquals}&avatarId.notEquals={avatarIdNotEquals}&avatarId.specified={avatarIdSpecified}&avatarId.in={avatarIdIn}&avatarId.notIn={avatarIdNotIn}&userId.greaterThan={userIdGreaterThan}&userId.lessThan={userIdLessThan}&userId.greaterThanOrEqual={userIdGreaterThanOrEqual}&userId.lessThanOrEqual={userIdLessThanOrEqual}&userId.equals={userIdEquals}&userId.notEquals={userIdNotEquals}&userId.specified={userIdSpecified}&userId.in={userIdIn}&userId.notIn={userIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<ProfileDTO>> getAllProfilesWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("fullNameContains") @jakarta.annotation.Nullable String fullNameContains, @Param("fullNameDoesNotContain") @jakarta.annotation.Nullable String fullNameDoesNotContain, @Param("fullNameEquals") @jakarta.annotation.Nullable String fullNameEquals, @Param("fullNameNotEquals") @jakarta.annotation.Nullable String fullNameNotEquals, @Param("fullNameSpecified") @jakarta.annotation.Nullable Boolean fullNameSpecified, @Param("fullNameIn") @jakarta.annotation.Nullable List<String> fullNameIn, @Param("fullNameNotIn") @jakarta.annotation.Nullable List<String> fullNameNotIn, @Param("birthDateGreaterThan") @jakarta.annotation.Nullable LocalDate birthDateGreaterThan, @Param("birthDateLessThan") @jakarta.annotation.Nullable LocalDate birthDateLessThan, @Param("birthDateGreaterThanOrEqual") @jakarta.annotation.Nullable LocalDate birthDateGreaterThanOrEqual, @Param("birthDateLessThanOrEqual") @jakarta.annotation.Nullable LocalDate birthDateLessThanOrEqual, @Param("birthDateEquals") @jakarta.annotation.Nullable LocalDate birthDateEquals, @Param("birthDateNotEquals") @jakarta.annotation.Nullable LocalDate birthDateNotEquals, @Param("birthDateSpecified") @jakarta.annotation.Nullable Boolean birthDateSpecified, @Param("birthDateIn") @jakarta.annotation.Nullable List<LocalDate> birthDateIn, @Param("birthDateNotIn") @jakarta.annotation.Nullable List<LocalDate> birthDateNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("avatarIdGreaterThan") @jakarta.annotation.Nullable Long avatarIdGreaterThan, @Param("avatarIdLessThan") @jakarta.annotation.Nullable Long avatarIdLessThan, @Param("avatarIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long avatarIdGreaterThanOrEqual, @Param("avatarIdLessThanOrEqual") @jakarta.annotation.Nullable Long avatarIdLessThanOrEqual, @Param("avatarIdEquals") @jakarta.annotation.Nullable Long avatarIdEquals, @Param("avatarIdNotEquals") @jakarta.annotation.Nullable Long avatarIdNotEquals, @Param("avatarIdSpecified") @jakarta.annotation.Nullable Boolean avatarIdSpecified, @Param("avatarIdIn") @jakarta.annotation.Nullable List<Long> avatarIdIn, @Param("avatarIdNotIn") @jakarta.annotation.Nullable List<Long> avatarIdNotIn, @Param("userIdGreaterThan") @jakarta.annotation.Nullable Long userIdGreaterThan, @Param("userIdLessThan") @jakarta.annotation.Nullable Long userIdLessThan, @Param("userIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long userIdGreaterThanOrEqual, @Param("userIdLessThanOrEqual") @jakarta.annotation.Nullable Long userIdLessThanOrEqual, @Param("userIdEquals") @jakarta.annotation.Nullable Long userIdEquals, @Param("userIdNotEquals") @jakarta.annotation.Nullable Long userIdNotEquals, @Param("userIdSpecified") @jakarta.annotation.Nullable Boolean userIdSpecified, @Param("userIdIn") @jakarta.annotation.Nullable List<Long> userIdIn, @Param("userIdNotIn") @jakarta.annotation.Nullable List<Long> userIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllProfiles</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllProfilesQueryParams} class that allows for
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
   *   <li>fullNameContains -  (optional)</li>
   *   <li>fullNameDoesNotContain -  (optional)</li>
   *   <li>fullNameEquals -  (optional)</li>
   *   <li>fullNameNotEquals -  (optional)</li>
   *   <li>fullNameSpecified -  (optional)</li>
   *   <li>fullNameIn -  (optional)</li>
   *   <li>fullNameNotIn -  (optional)</li>
   *   <li>birthDateGreaterThan -  (optional)</li>
   *   <li>birthDateLessThan -  (optional)</li>
   *   <li>birthDateGreaterThanOrEqual -  (optional)</li>
   *   <li>birthDateLessThanOrEqual -  (optional)</li>
   *   <li>birthDateEquals -  (optional)</li>
   *   <li>birthDateNotEquals -  (optional)</li>
   *   <li>birthDateSpecified -  (optional)</li>
   *   <li>birthDateIn -  (optional)</li>
   *   <li>birthDateNotIn -  (optional)</li>
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
   *   <li>avatarIdGreaterThan -  (optional)</li>
   *   <li>avatarIdLessThan -  (optional)</li>
   *   <li>avatarIdGreaterThanOrEqual -  (optional)</li>
   *   <li>avatarIdLessThanOrEqual -  (optional)</li>
   *   <li>avatarIdEquals -  (optional)</li>
   *   <li>avatarIdNotEquals -  (optional)</li>
   *   <li>avatarIdSpecified -  (optional)</li>
   *   <li>avatarIdIn -  (optional)</li>
   *   <li>avatarIdNotIn -  (optional)</li>
   *   <li>userIdGreaterThan -  (optional)</li>
   *   <li>userIdLessThan -  (optional)</li>
   *   <li>userIdGreaterThanOrEqual -  (optional)</li>
   *   <li>userIdLessThanOrEqual -  (optional)</li>
   *   <li>userIdEquals -  (optional)</li>
   *   <li>userIdNotEquals -  (optional)</li>
   *   <li>userIdSpecified -  (optional)</li>
   *   <li>userIdIn -  (optional)</li>
   *   <li>userIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return List&lt;ProfileDTO&gt;
   */
  @RequestLine("GET /api/profiles?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&fullName.contains={fullNameContains}&fullName.doesNotContain={fullNameDoesNotContain}&fullName.equals={fullNameEquals}&fullName.notEquals={fullNameNotEquals}&fullName.specified={fullNameSpecified}&fullName.in={fullNameIn}&fullName.notIn={fullNameNotIn}&birthDate.greaterThan={birthDateGreaterThan}&birthDate.lessThan={birthDateLessThan}&birthDate.greaterThanOrEqual={birthDateGreaterThanOrEqual}&birthDate.lessThanOrEqual={birthDateLessThanOrEqual}&birthDate.equals={birthDateEquals}&birthDate.notEquals={birthDateNotEquals}&birthDate.specified={birthDateSpecified}&birthDate.in={birthDateIn}&birthDate.notIn={birthDateNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&avatarId.greaterThan={avatarIdGreaterThan}&avatarId.lessThan={avatarIdLessThan}&avatarId.greaterThanOrEqual={avatarIdGreaterThanOrEqual}&avatarId.lessThanOrEqual={avatarIdLessThanOrEqual}&avatarId.equals={avatarIdEquals}&avatarId.notEquals={avatarIdNotEquals}&avatarId.specified={avatarIdSpecified}&avatarId.in={avatarIdIn}&avatarId.notIn={avatarIdNotIn}&userId.greaterThan={userIdGreaterThan}&userId.lessThan={userIdLessThan}&userId.greaterThanOrEqual={userIdGreaterThanOrEqual}&userId.lessThanOrEqual={userIdLessThanOrEqual}&userId.equals={userIdEquals}&userId.notEquals={userIdNotEquals}&userId.specified={userIdSpecified}&userId.in={userIdIn}&userId.notIn={userIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  List<ProfileDTO> getAllProfiles(@QueryMap(encoded=true) GetAllProfilesQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllProfiles</code> that receives the query parameters as a map,
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
          *   <li>fullNameContains -  (optional)</li>
          *   <li>fullNameDoesNotContain -  (optional)</li>
          *   <li>fullNameEquals -  (optional)</li>
          *   <li>fullNameNotEquals -  (optional)</li>
          *   <li>fullNameSpecified -  (optional)</li>
          *   <li>fullNameIn -  (optional)</li>
          *   <li>fullNameNotIn -  (optional)</li>
          *   <li>birthDateGreaterThan -  (optional)</li>
          *   <li>birthDateLessThan -  (optional)</li>
          *   <li>birthDateGreaterThanOrEqual -  (optional)</li>
          *   <li>birthDateLessThanOrEqual -  (optional)</li>
          *   <li>birthDateEquals -  (optional)</li>
          *   <li>birthDateNotEquals -  (optional)</li>
          *   <li>birthDateSpecified -  (optional)</li>
          *   <li>birthDateIn -  (optional)</li>
          *   <li>birthDateNotIn -  (optional)</li>
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
          *   <li>avatarIdGreaterThan -  (optional)</li>
          *   <li>avatarIdLessThan -  (optional)</li>
          *   <li>avatarIdGreaterThanOrEqual -  (optional)</li>
          *   <li>avatarIdLessThanOrEqual -  (optional)</li>
          *   <li>avatarIdEquals -  (optional)</li>
          *   <li>avatarIdNotEquals -  (optional)</li>
          *   <li>avatarIdSpecified -  (optional)</li>
          *   <li>avatarIdIn -  (optional)</li>
          *   <li>avatarIdNotIn -  (optional)</li>
          *   <li>userIdGreaterThan -  (optional)</li>
          *   <li>userIdLessThan -  (optional)</li>
          *   <li>userIdGreaterThanOrEqual -  (optional)</li>
          *   <li>userIdLessThanOrEqual -  (optional)</li>
          *   <li>userIdEquals -  (optional)</li>
          *   <li>userIdNotEquals -  (optional)</li>
          *   <li>userIdSpecified -  (optional)</li>
          *   <li>userIdIn -  (optional)</li>
          *   <li>userIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return List&lt;ProfileDTO&gt;
      */
      @RequestLine("GET /api/profiles?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&fullName.contains={fullNameContains}&fullName.doesNotContain={fullNameDoesNotContain}&fullName.equals={fullNameEquals}&fullName.notEquals={fullNameNotEquals}&fullName.specified={fullNameSpecified}&fullName.in={fullNameIn}&fullName.notIn={fullNameNotIn}&birthDate.greaterThan={birthDateGreaterThan}&birthDate.lessThan={birthDateLessThan}&birthDate.greaterThanOrEqual={birthDateGreaterThanOrEqual}&birthDate.lessThanOrEqual={birthDateLessThanOrEqual}&birthDate.equals={birthDateEquals}&birthDate.notEquals={birthDateNotEquals}&birthDate.specified={birthDateSpecified}&birthDate.in={birthDateIn}&birthDate.notIn={birthDateNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&avatarId.greaterThan={avatarIdGreaterThan}&avatarId.lessThan={avatarIdLessThan}&avatarId.greaterThanOrEqual={avatarIdGreaterThanOrEqual}&avatarId.lessThanOrEqual={avatarIdLessThanOrEqual}&avatarId.equals={avatarIdEquals}&avatarId.notEquals={avatarIdNotEquals}&avatarId.specified={avatarIdSpecified}&avatarId.in={avatarIdIn}&avatarId.notIn={avatarIdNotIn}&userId.greaterThan={userIdGreaterThan}&userId.lessThan={userIdLessThan}&userId.greaterThanOrEqual={userIdGreaterThanOrEqual}&userId.lessThanOrEqual={userIdLessThanOrEqual}&userId.equals={userIdEquals}&userId.notEquals={userIdNotEquals}&userId.specified={userIdSpecified}&userId.in={userIdIn}&userId.notIn={userIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<ProfileDTO>> getAllProfilesWithHttpInfo(@QueryMap(encoded=true) GetAllProfilesQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllProfiles</code> method in a fluent style.
   */
  public static class GetAllProfilesQueryParams extends HashMap<String, Object> {
    public GetAllProfilesQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProfilesQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProfilesQueryParams fullNameContains(@jakarta.annotation.Nullable final String value) {
      put("fullName.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams fullNameDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("fullName.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams fullNameEquals(@jakarta.annotation.Nullable final String value) {
      put("fullName.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams fullNameNotEquals(@jakarta.annotation.Nullable final String value) {
      put("fullName.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams fullNameSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("fullName.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams fullNameIn(@jakarta.annotation.Nullable final List<String> value) {
      put("fullName.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProfilesQueryParams fullNameNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("fullName.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProfilesQueryParams birthDateGreaterThan(@jakarta.annotation.Nullable final LocalDate value) {
      put("birthDate.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams birthDateLessThan(@jakarta.annotation.Nullable final LocalDate value) {
      put("birthDate.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams birthDateGreaterThanOrEqual(@jakarta.annotation.Nullable final LocalDate value) {
      put("birthDate.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams birthDateLessThanOrEqual(@jakarta.annotation.Nullable final LocalDate value) {
      put("birthDate.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams birthDateEquals(@jakarta.annotation.Nullable final LocalDate value) {
      put("birthDate.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams birthDateNotEquals(@jakarta.annotation.Nullable final LocalDate value) {
      put("birthDate.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams birthDateSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("birthDate.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams birthDateIn(@jakarta.annotation.Nullable final List<LocalDate> value) {
      put("birthDate.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProfilesQueryParams birthDateNotIn(@jakarta.annotation.Nullable final List<LocalDate> value) {
      put("birthDate.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProfilesQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProfilesQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProfilesQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProfilesQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProfilesQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProfilesQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProfilesQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProfilesQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProfilesQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProfilesQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProfilesQueryParams avatarIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("avatarId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams avatarIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("avatarId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams avatarIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("avatarId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams avatarIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("avatarId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams avatarIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("avatarId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams avatarIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("avatarId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams avatarIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("avatarId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams avatarIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("avatarId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProfilesQueryParams avatarIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("avatarId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProfilesQueryParams userIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("userId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams userIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("userId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams userIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("userId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams userIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("userId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams userIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("userId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams userIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("userId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams userIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("userId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProfilesQueryParams userIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("userId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProfilesQueryParams userIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("userId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProfilesQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @return ProfileDTO
   */
  @RequestLine("GET /api/profiles/{id}")
  @Headers({
    "Accept: */*",
  })
  ProfileDTO getProfile(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>getProfile</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/profiles/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<ProfileDTO> getProfileWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param id  (required)
   * @param profileDTO  (required)
   * @return ProfileDTO
   */
  @RequestLine("PATCH /api/profiles/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ProfileDTO partialUpdateProfile(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull ProfileDTO profileDTO);

  /**
   * 
   * Similar to <code>partialUpdateProfile</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param profileDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /api/profiles/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<ProfileDTO> partialUpdateProfileWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull ProfileDTO profileDTO);



  /**
   * 
   * 
   * @param id  (required)
   * @param profileDTO  (required)
   * @return ProfileDTO
   */
  @RequestLine("PUT /api/profiles/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ProfileDTO updateProfile(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull ProfileDTO profileDTO);

  /**
   * 
   * Similar to <code>updateProfile</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param profileDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/profiles/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<ProfileDTO> updateProfileWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull ProfileDTO profileDTO);


}
