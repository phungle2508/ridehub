package com.ridehub.msroute.client.api;

import com.ridehub.msroute.client.invoker.ApiClient;
import com.ridehub.msroute.client.invoker.EncodingUtils;
import com.ridehub.msroute.client.model.ApiResponse;

import java.time.OffsetDateTime;
import com.ridehub.msroute.client.model.StaffDTO;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface StaffResourceMsrouteApi extends ApiClient.Api {


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
   * @param nameContains  (optional)
   * @param nameDoesNotContain  (optional)
   * @param nameEquals  (optional)
   * @param nameNotEquals  (optional)
   * @param nameSpecified  (optional)
   * @param nameIn  (optional)
   * @param nameNotIn  (optional)
   * @param ageGreaterThan  (optional)
   * @param ageLessThan  (optional)
   * @param ageGreaterThanOrEqual  (optional)
   * @param ageLessThanOrEqual  (optional)
   * @param ageEquals  (optional)
   * @param ageNotEquals  (optional)
   * @param ageSpecified  (optional)
   * @param ageIn  (optional)
   * @param ageNotIn  (optional)
   * @param genderEquals  (optional)
   * @param genderNotEquals  (optional)
   * @param genderSpecified  (optional)
   * @param genderIn  (optional)
   * @param genderNotIn  (optional)
   * @param phoneNumberContains  (optional)
   * @param phoneNumberDoesNotContain  (optional)
   * @param phoneNumberEquals  (optional)
   * @param phoneNumberNotEquals  (optional)
   * @param phoneNumberSpecified  (optional)
   * @param phoneNumberIn  (optional)
   * @param phoneNumberNotIn  (optional)
   * @param statusEquals  (optional)
   * @param statusNotEquals  (optional)
   * @param statusSpecified  (optional)
   * @param statusIn  (optional)
   * @param statusNotIn  (optional)
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
   * @param driverIdGreaterThan  (optional)
   * @param driverIdLessThan  (optional)
   * @param driverIdGreaterThanOrEqual  (optional)
   * @param driverIdLessThanOrEqual  (optional)
   * @param driverIdEquals  (optional)
   * @param driverIdNotEquals  (optional)
   * @param driverIdSpecified  (optional)
   * @param driverIdIn  (optional)
   * @param driverIdNotIn  (optional)
   * @param attendantIdGreaterThan  (optional)
   * @param attendantIdLessThan  (optional)
   * @param attendantIdGreaterThanOrEqual  (optional)
   * @param attendantIdLessThanOrEqual  (optional)
   * @param attendantIdEquals  (optional)
   * @param attendantIdNotEquals  (optional)
   * @param attendantIdSpecified  (optional)
   * @param attendantIdIn  (optional)
   * @param attendantIdNotIn  (optional)
   * @param distinct  (optional)
   * @return Long
   */
  @RequestLine("GET /api/staff/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&age.greaterThan={ageGreaterThan}&age.lessThan={ageLessThan}&age.greaterThanOrEqual={ageGreaterThanOrEqual}&age.lessThanOrEqual={ageLessThanOrEqual}&age.equals={ageEquals}&age.notEquals={ageNotEquals}&age.specified={ageSpecified}&age.in={ageIn}&age.notIn={ageNotIn}&gender.equals={genderEquals}&gender.notEquals={genderNotEquals}&gender.specified={genderSpecified}&gender.in={genderIn}&gender.notIn={genderNotIn}&phoneNumber.contains={phoneNumberContains}&phoneNumber.doesNotContain={phoneNumberDoesNotContain}&phoneNumber.equals={phoneNumberEquals}&phoneNumber.notEquals={phoneNumberNotEquals}&phoneNumber.specified={phoneNumberSpecified}&phoneNumber.in={phoneNumberIn}&phoneNumber.notIn={phoneNumberNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&driverId.greaterThan={driverIdGreaterThan}&driverId.lessThan={driverIdLessThan}&driverId.greaterThanOrEqual={driverIdGreaterThanOrEqual}&driverId.lessThanOrEqual={driverIdLessThanOrEqual}&driverId.equals={driverIdEquals}&driverId.notEquals={driverIdNotEquals}&driverId.specified={driverIdSpecified}&driverId.in={driverIdIn}&driverId.notIn={driverIdNotIn}&attendantId.greaterThan={attendantIdGreaterThan}&attendantId.lessThan={attendantIdLessThan}&attendantId.greaterThanOrEqual={attendantIdGreaterThanOrEqual}&attendantId.lessThanOrEqual={attendantIdLessThanOrEqual}&attendantId.equals={attendantIdEquals}&attendantId.notEquals={attendantIdNotEquals}&attendantId.specified={attendantIdSpecified}&attendantId.in={attendantIdIn}&attendantId.notIn={attendantIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  Long countStaff(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("nameContains") @jakarta.annotation.Nullable String nameContains, @Param("nameDoesNotContain") @jakarta.annotation.Nullable String nameDoesNotContain, @Param("nameEquals") @jakarta.annotation.Nullable String nameEquals, @Param("nameNotEquals") @jakarta.annotation.Nullable String nameNotEquals, @Param("nameSpecified") @jakarta.annotation.Nullable Boolean nameSpecified, @Param("nameIn") @jakarta.annotation.Nullable List<String> nameIn, @Param("nameNotIn") @jakarta.annotation.Nullable List<String> nameNotIn, @Param("ageGreaterThan") @jakarta.annotation.Nullable Integer ageGreaterThan, @Param("ageLessThan") @jakarta.annotation.Nullable Integer ageLessThan, @Param("ageGreaterThanOrEqual") @jakarta.annotation.Nullable Integer ageGreaterThanOrEqual, @Param("ageLessThanOrEqual") @jakarta.annotation.Nullable Integer ageLessThanOrEqual, @Param("ageEquals") @jakarta.annotation.Nullable Integer ageEquals, @Param("ageNotEquals") @jakarta.annotation.Nullable Integer ageNotEquals, @Param("ageSpecified") @jakarta.annotation.Nullable Boolean ageSpecified, @Param("ageIn") @jakarta.annotation.Nullable List<Integer> ageIn, @Param("ageNotIn") @jakarta.annotation.Nullable List<Integer> ageNotIn, @Param("genderEquals") @jakarta.annotation.Nullable String genderEquals, @Param("genderNotEquals") @jakarta.annotation.Nullable String genderNotEquals, @Param("genderSpecified") @jakarta.annotation.Nullable Boolean genderSpecified, @Param("genderIn") @jakarta.annotation.Nullable List<String> genderIn, @Param("genderNotIn") @jakarta.annotation.Nullable List<String> genderNotIn, @Param("phoneNumberContains") @jakarta.annotation.Nullable String phoneNumberContains, @Param("phoneNumberDoesNotContain") @jakarta.annotation.Nullable String phoneNumberDoesNotContain, @Param("phoneNumberEquals") @jakarta.annotation.Nullable String phoneNumberEquals, @Param("phoneNumberNotEquals") @jakarta.annotation.Nullable String phoneNumberNotEquals, @Param("phoneNumberSpecified") @jakarta.annotation.Nullable Boolean phoneNumberSpecified, @Param("phoneNumberIn") @jakarta.annotation.Nullable List<String> phoneNumberIn, @Param("phoneNumberNotIn") @jakarta.annotation.Nullable List<String> phoneNumberNotIn, @Param("statusEquals") @jakarta.annotation.Nullable String statusEquals, @Param("statusNotEquals") @jakarta.annotation.Nullable String statusNotEquals, @Param("statusSpecified") @jakarta.annotation.Nullable Boolean statusSpecified, @Param("statusIn") @jakarta.annotation.Nullable List<String> statusIn, @Param("statusNotIn") @jakarta.annotation.Nullable List<String> statusNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("driverIdGreaterThan") @jakarta.annotation.Nullable Long driverIdGreaterThan, @Param("driverIdLessThan") @jakarta.annotation.Nullable Long driverIdLessThan, @Param("driverIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long driverIdGreaterThanOrEqual, @Param("driverIdLessThanOrEqual") @jakarta.annotation.Nullable Long driverIdLessThanOrEqual, @Param("driverIdEquals") @jakarta.annotation.Nullable Long driverIdEquals, @Param("driverIdNotEquals") @jakarta.annotation.Nullable Long driverIdNotEquals, @Param("driverIdSpecified") @jakarta.annotation.Nullable Boolean driverIdSpecified, @Param("driverIdIn") @jakarta.annotation.Nullable List<Long> driverIdIn, @Param("driverIdNotIn") @jakarta.annotation.Nullable List<Long> driverIdNotIn, @Param("attendantIdGreaterThan") @jakarta.annotation.Nullable Long attendantIdGreaterThan, @Param("attendantIdLessThan") @jakarta.annotation.Nullable Long attendantIdLessThan, @Param("attendantIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long attendantIdGreaterThanOrEqual, @Param("attendantIdLessThanOrEqual") @jakarta.annotation.Nullable Long attendantIdLessThanOrEqual, @Param("attendantIdEquals") @jakarta.annotation.Nullable Long attendantIdEquals, @Param("attendantIdNotEquals") @jakarta.annotation.Nullable Long attendantIdNotEquals, @Param("attendantIdSpecified") @jakarta.annotation.Nullable Boolean attendantIdSpecified, @Param("attendantIdIn") @jakarta.annotation.Nullable List<Long> attendantIdIn, @Param("attendantIdNotIn") @jakarta.annotation.Nullable List<Long> attendantIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>countStaff</code> but it also returns the http response headers .
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
   * @param nameContains  (optional)
   * @param nameDoesNotContain  (optional)
   * @param nameEquals  (optional)
   * @param nameNotEquals  (optional)
   * @param nameSpecified  (optional)
   * @param nameIn  (optional)
   * @param nameNotIn  (optional)
   * @param ageGreaterThan  (optional)
   * @param ageLessThan  (optional)
   * @param ageGreaterThanOrEqual  (optional)
   * @param ageLessThanOrEqual  (optional)
   * @param ageEquals  (optional)
   * @param ageNotEquals  (optional)
   * @param ageSpecified  (optional)
   * @param ageIn  (optional)
   * @param ageNotIn  (optional)
   * @param genderEquals  (optional)
   * @param genderNotEquals  (optional)
   * @param genderSpecified  (optional)
   * @param genderIn  (optional)
   * @param genderNotIn  (optional)
   * @param phoneNumberContains  (optional)
   * @param phoneNumberDoesNotContain  (optional)
   * @param phoneNumberEquals  (optional)
   * @param phoneNumberNotEquals  (optional)
   * @param phoneNumberSpecified  (optional)
   * @param phoneNumberIn  (optional)
   * @param phoneNumberNotIn  (optional)
   * @param statusEquals  (optional)
   * @param statusNotEquals  (optional)
   * @param statusSpecified  (optional)
   * @param statusIn  (optional)
   * @param statusNotIn  (optional)
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
   * @param driverIdGreaterThan  (optional)
   * @param driverIdLessThan  (optional)
   * @param driverIdGreaterThanOrEqual  (optional)
   * @param driverIdLessThanOrEqual  (optional)
   * @param driverIdEquals  (optional)
   * @param driverIdNotEquals  (optional)
   * @param driverIdSpecified  (optional)
   * @param driverIdIn  (optional)
   * @param driverIdNotIn  (optional)
   * @param attendantIdGreaterThan  (optional)
   * @param attendantIdLessThan  (optional)
   * @param attendantIdGreaterThanOrEqual  (optional)
   * @param attendantIdLessThanOrEqual  (optional)
   * @param attendantIdEquals  (optional)
   * @param attendantIdNotEquals  (optional)
   * @param attendantIdSpecified  (optional)
   * @param attendantIdIn  (optional)
   * @param attendantIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/staff/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&age.greaterThan={ageGreaterThan}&age.lessThan={ageLessThan}&age.greaterThanOrEqual={ageGreaterThanOrEqual}&age.lessThanOrEqual={ageLessThanOrEqual}&age.equals={ageEquals}&age.notEquals={ageNotEquals}&age.specified={ageSpecified}&age.in={ageIn}&age.notIn={ageNotIn}&gender.equals={genderEquals}&gender.notEquals={genderNotEquals}&gender.specified={genderSpecified}&gender.in={genderIn}&gender.notIn={genderNotIn}&phoneNumber.contains={phoneNumberContains}&phoneNumber.doesNotContain={phoneNumberDoesNotContain}&phoneNumber.equals={phoneNumberEquals}&phoneNumber.notEquals={phoneNumberNotEquals}&phoneNumber.specified={phoneNumberSpecified}&phoneNumber.in={phoneNumberIn}&phoneNumber.notIn={phoneNumberNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&driverId.greaterThan={driverIdGreaterThan}&driverId.lessThan={driverIdLessThan}&driverId.greaterThanOrEqual={driverIdGreaterThanOrEqual}&driverId.lessThanOrEqual={driverIdLessThanOrEqual}&driverId.equals={driverIdEquals}&driverId.notEquals={driverIdNotEquals}&driverId.specified={driverIdSpecified}&driverId.in={driverIdIn}&driverId.notIn={driverIdNotIn}&attendantId.greaterThan={attendantIdGreaterThan}&attendantId.lessThan={attendantIdLessThan}&attendantId.greaterThanOrEqual={attendantIdGreaterThanOrEqual}&attendantId.lessThanOrEqual={attendantIdLessThanOrEqual}&attendantId.equals={attendantIdEquals}&attendantId.notEquals={attendantIdNotEquals}&attendantId.specified={attendantIdSpecified}&attendantId.in={attendantIdIn}&attendantId.notIn={attendantIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Long> countStaffWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("nameContains") @jakarta.annotation.Nullable String nameContains, @Param("nameDoesNotContain") @jakarta.annotation.Nullable String nameDoesNotContain, @Param("nameEquals") @jakarta.annotation.Nullable String nameEquals, @Param("nameNotEquals") @jakarta.annotation.Nullable String nameNotEquals, @Param("nameSpecified") @jakarta.annotation.Nullable Boolean nameSpecified, @Param("nameIn") @jakarta.annotation.Nullable List<String> nameIn, @Param("nameNotIn") @jakarta.annotation.Nullable List<String> nameNotIn, @Param("ageGreaterThan") @jakarta.annotation.Nullable Integer ageGreaterThan, @Param("ageLessThan") @jakarta.annotation.Nullable Integer ageLessThan, @Param("ageGreaterThanOrEqual") @jakarta.annotation.Nullable Integer ageGreaterThanOrEqual, @Param("ageLessThanOrEqual") @jakarta.annotation.Nullable Integer ageLessThanOrEqual, @Param("ageEquals") @jakarta.annotation.Nullable Integer ageEquals, @Param("ageNotEquals") @jakarta.annotation.Nullable Integer ageNotEquals, @Param("ageSpecified") @jakarta.annotation.Nullable Boolean ageSpecified, @Param("ageIn") @jakarta.annotation.Nullable List<Integer> ageIn, @Param("ageNotIn") @jakarta.annotation.Nullable List<Integer> ageNotIn, @Param("genderEquals") @jakarta.annotation.Nullable String genderEquals, @Param("genderNotEquals") @jakarta.annotation.Nullable String genderNotEquals, @Param("genderSpecified") @jakarta.annotation.Nullable Boolean genderSpecified, @Param("genderIn") @jakarta.annotation.Nullable List<String> genderIn, @Param("genderNotIn") @jakarta.annotation.Nullable List<String> genderNotIn, @Param("phoneNumberContains") @jakarta.annotation.Nullable String phoneNumberContains, @Param("phoneNumberDoesNotContain") @jakarta.annotation.Nullable String phoneNumberDoesNotContain, @Param("phoneNumberEquals") @jakarta.annotation.Nullable String phoneNumberEquals, @Param("phoneNumberNotEquals") @jakarta.annotation.Nullable String phoneNumberNotEquals, @Param("phoneNumberSpecified") @jakarta.annotation.Nullable Boolean phoneNumberSpecified, @Param("phoneNumberIn") @jakarta.annotation.Nullable List<String> phoneNumberIn, @Param("phoneNumberNotIn") @jakarta.annotation.Nullable List<String> phoneNumberNotIn, @Param("statusEquals") @jakarta.annotation.Nullable String statusEquals, @Param("statusNotEquals") @jakarta.annotation.Nullable String statusNotEquals, @Param("statusSpecified") @jakarta.annotation.Nullable Boolean statusSpecified, @Param("statusIn") @jakarta.annotation.Nullable List<String> statusIn, @Param("statusNotIn") @jakarta.annotation.Nullable List<String> statusNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("driverIdGreaterThan") @jakarta.annotation.Nullable Long driverIdGreaterThan, @Param("driverIdLessThan") @jakarta.annotation.Nullable Long driverIdLessThan, @Param("driverIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long driverIdGreaterThanOrEqual, @Param("driverIdLessThanOrEqual") @jakarta.annotation.Nullable Long driverIdLessThanOrEqual, @Param("driverIdEquals") @jakarta.annotation.Nullable Long driverIdEquals, @Param("driverIdNotEquals") @jakarta.annotation.Nullable Long driverIdNotEquals, @Param("driverIdSpecified") @jakarta.annotation.Nullable Boolean driverIdSpecified, @Param("driverIdIn") @jakarta.annotation.Nullable List<Long> driverIdIn, @Param("driverIdNotIn") @jakarta.annotation.Nullable List<Long> driverIdNotIn, @Param("attendantIdGreaterThan") @jakarta.annotation.Nullable Long attendantIdGreaterThan, @Param("attendantIdLessThan") @jakarta.annotation.Nullable Long attendantIdLessThan, @Param("attendantIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long attendantIdGreaterThanOrEqual, @Param("attendantIdLessThanOrEqual") @jakarta.annotation.Nullable Long attendantIdLessThanOrEqual, @Param("attendantIdEquals") @jakarta.annotation.Nullable Long attendantIdEquals, @Param("attendantIdNotEquals") @jakarta.annotation.Nullable Long attendantIdNotEquals, @Param("attendantIdSpecified") @jakarta.annotation.Nullable Boolean attendantIdSpecified, @Param("attendantIdIn") @jakarta.annotation.Nullable List<Long> attendantIdIn, @Param("attendantIdNotIn") @jakarta.annotation.Nullable List<Long> attendantIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>countStaff</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CountStaffQueryParams} class that allows for
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
   *   <li>nameContains -  (optional)</li>
   *   <li>nameDoesNotContain -  (optional)</li>
   *   <li>nameEquals -  (optional)</li>
   *   <li>nameNotEquals -  (optional)</li>
   *   <li>nameSpecified -  (optional)</li>
   *   <li>nameIn -  (optional)</li>
   *   <li>nameNotIn -  (optional)</li>
   *   <li>ageGreaterThan -  (optional)</li>
   *   <li>ageLessThan -  (optional)</li>
   *   <li>ageGreaterThanOrEqual -  (optional)</li>
   *   <li>ageLessThanOrEqual -  (optional)</li>
   *   <li>ageEquals -  (optional)</li>
   *   <li>ageNotEquals -  (optional)</li>
   *   <li>ageSpecified -  (optional)</li>
   *   <li>ageIn -  (optional)</li>
   *   <li>ageNotIn -  (optional)</li>
   *   <li>genderEquals -  (optional)</li>
   *   <li>genderNotEquals -  (optional)</li>
   *   <li>genderSpecified -  (optional)</li>
   *   <li>genderIn -  (optional)</li>
   *   <li>genderNotIn -  (optional)</li>
   *   <li>phoneNumberContains -  (optional)</li>
   *   <li>phoneNumberDoesNotContain -  (optional)</li>
   *   <li>phoneNumberEquals -  (optional)</li>
   *   <li>phoneNumberNotEquals -  (optional)</li>
   *   <li>phoneNumberSpecified -  (optional)</li>
   *   <li>phoneNumberIn -  (optional)</li>
   *   <li>phoneNumberNotIn -  (optional)</li>
   *   <li>statusEquals -  (optional)</li>
   *   <li>statusNotEquals -  (optional)</li>
   *   <li>statusSpecified -  (optional)</li>
   *   <li>statusIn -  (optional)</li>
   *   <li>statusNotIn -  (optional)</li>
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
   *   <li>driverIdGreaterThan -  (optional)</li>
   *   <li>driverIdLessThan -  (optional)</li>
   *   <li>driverIdGreaterThanOrEqual -  (optional)</li>
   *   <li>driverIdLessThanOrEqual -  (optional)</li>
   *   <li>driverIdEquals -  (optional)</li>
   *   <li>driverIdNotEquals -  (optional)</li>
   *   <li>driverIdSpecified -  (optional)</li>
   *   <li>driverIdIn -  (optional)</li>
   *   <li>driverIdNotIn -  (optional)</li>
   *   <li>attendantIdGreaterThan -  (optional)</li>
   *   <li>attendantIdLessThan -  (optional)</li>
   *   <li>attendantIdGreaterThanOrEqual -  (optional)</li>
   *   <li>attendantIdLessThanOrEqual -  (optional)</li>
   *   <li>attendantIdEquals -  (optional)</li>
   *   <li>attendantIdNotEquals -  (optional)</li>
   *   <li>attendantIdSpecified -  (optional)</li>
   *   <li>attendantIdIn -  (optional)</li>
   *   <li>attendantIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return Long
   */
  @RequestLine("GET /api/staff/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&age.greaterThan={ageGreaterThan}&age.lessThan={ageLessThan}&age.greaterThanOrEqual={ageGreaterThanOrEqual}&age.lessThanOrEqual={ageLessThanOrEqual}&age.equals={ageEquals}&age.notEquals={ageNotEquals}&age.specified={ageSpecified}&age.in={ageIn}&age.notIn={ageNotIn}&gender.equals={genderEquals}&gender.notEquals={genderNotEquals}&gender.specified={genderSpecified}&gender.in={genderIn}&gender.notIn={genderNotIn}&phoneNumber.contains={phoneNumberContains}&phoneNumber.doesNotContain={phoneNumberDoesNotContain}&phoneNumber.equals={phoneNumberEquals}&phoneNumber.notEquals={phoneNumberNotEquals}&phoneNumber.specified={phoneNumberSpecified}&phoneNumber.in={phoneNumberIn}&phoneNumber.notIn={phoneNumberNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&driverId.greaterThan={driverIdGreaterThan}&driverId.lessThan={driverIdLessThan}&driverId.greaterThanOrEqual={driverIdGreaterThanOrEqual}&driverId.lessThanOrEqual={driverIdLessThanOrEqual}&driverId.equals={driverIdEquals}&driverId.notEquals={driverIdNotEquals}&driverId.specified={driverIdSpecified}&driverId.in={driverIdIn}&driverId.notIn={driverIdNotIn}&attendantId.greaterThan={attendantIdGreaterThan}&attendantId.lessThan={attendantIdLessThan}&attendantId.greaterThanOrEqual={attendantIdGreaterThanOrEqual}&attendantId.lessThanOrEqual={attendantIdLessThanOrEqual}&attendantId.equals={attendantIdEquals}&attendantId.notEquals={attendantIdNotEquals}&attendantId.specified={attendantIdSpecified}&attendantId.in={attendantIdIn}&attendantId.notIn={attendantIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  Long countStaff(@QueryMap(encoded=true) CountStaffQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>countStaff</code> that receives the query parameters as a map,
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
          *   <li>nameContains -  (optional)</li>
          *   <li>nameDoesNotContain -  (optional)</li>
          *   <li>nameEquals -  (optional)</li>
          *   <li>nameNotEquals -  (optional)</li>
          *   <li>nameSpecified -  (optional)</li>
          *   <li>nameIn -  (optional)</li>
          *   <li>nameNotIn -  (optional)</li>
          *   <li>ageGreaterThan -  (optional)</li>
          *   <li>ageLessThan -  (optional)</li>
          *   <li>ageGreaterThanOrEqual -  (optional)</li>
          *   <li>ageLessThanOrEqual -  (optional)</li>
          *   <li>ageEquals -  (optional)</li>
          *   <li>ageNotEquals -  (optional)</li>
          *   <li>ageSpecified -  (optional)</li>
          *   <li>ageIn -  (optional)</li>
          *   <li>ageNotIn -  (optional)</li>
          *   <li>genderEquals -  (optional)</li>
          *   <li>genderNotEquals -  (optional)</li>
          *   <li>genderSpecified -  (optional)</li>
          *   <li>genderIn -  (optional)</li>
          *   <li>genderNotIn -  (optional)</li>
          *   <li>phoneNumberContains -  (optional)</li>
          *   <li>phoneNumberDoesNotContain -  (optional)</li>
          *   <li>phoneNumberEquals -  (optional)</li>
          *   <li>phoneNumberNotEquals -  (optional)</li>
          *   <li>phoneNumberSpecified -  (optional)</li>
          *   <li>phoneNumberIn -  (optional)</li>
          *   <li>phoneNumberNotIn -  (optional)</li>
          *   <li>statusEquals -  (optional)</li>
          *   <li>statusNotEquals -  (optional)</li>
          *   <li>statusSpecified -  (optional)</li>
          *   <li>statusIn -  (optional)</li>
          *   <li>statusNotIn -  (optional)</li>
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
          *   <li>driverIdGreaterThan -  (optional)</li>
          *   <li>driverIdLessThan -  (optional)</li>
          *   <li>driverIdGreaterThanOrEqual -  (optional)</li>
          *   <li>driverIdLessThanOrEqual -  (optional)</li>
          *   <li>driverIdEquals -  (optional)</li>
          *   <li>driverIdNotEquals -  (optional)</li>
          *   <li>driverIdSpecified -  (optional)</li>
          *   <li>driverIdIn -  (optional)</li>
          *   <li>driverIdNotIn -  (optional)</li>
          *   <li>attendantIdGreaterThan -  (optional)</li>
          *   <li>attendantIdLessThan -  (optional)</li>
          *   <li>attendantIdGreaterThanOrEqual -  (optional)</li>
          *   <li>attendantIdLessThanOrEqual -  (optional)</li>
          *   <li>attendantIdEquals -  (optional)</li>
          *   <li>attendantIdNotEquals -  (optional)</li>
          *   <li>attendantIdSpecified -  (optional)</li>
          *   <li>attendantIdIn -  (optional)</li>
          *   <li>attendantIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return Long
      */
      @RequestLine("GET /api/staff/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&age.greaterThan={ageGreaterThan}&age.lessThan={ageLessThan}&age.greaterThanOrEqual={ageGreaterThanOrEqual}&age.lessThanOrEqual={ageLessThanOrEqual}&age.equals={ageEquals}&age.notEquals={ageNotEquals}&age.specified={ageSpecified}&age.in={ageIn}&age.notIn={ageNotIn}&gender.equals={genderEquals}&gender.notEquals={genderNotEquals}&gender.specified={genderSpecified}&gender.in={genderIn}&gender.notIn={genderNotIn}&phoneNumber.contains={phoneNumberContains}&phoneNumber.doesNotContain={phoneNumberDoesNotContain}&phoneNumber.equals={phoneNumberEquals}&phoneNumber.notEquals={phoneNumberNotEquals}&phoneNumber.specified={phoneNumberSpecified}&phoneNumber.in={phoneNumberIn}&phoneNumber.notIn={phoneNumberNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&driverId.greaterThan={driverIdGreaterThan}&driverId.lessThan={driverIdLessThan}&driverId.greaterThanOrEqual={driverIdGreaterThanOrEqual}&driverId.lessThanOrEqual={driverIdLessThanOrEqual}&driverId.equals={driverIdEquals}&driverId.notEquals={driverIdNotEquals}&driverId.specified={driverIdSpecified}&driverId.in={driverIdIn}&driverId.notIn={driverIdNotIn}&attendantId.greaterThan={attendantIdGreaterThan}&attendantId.lessThan={attendantIdLessThan}&attendantId.greaterThanOrEqual={attendantIdGreaterThanOrEqual}&attendantId.lessThanOrEqual={attendantIdLessThanOrEqual}&attendantId.equals={attendantIdEquals}&attendantId.notEquals={attendantIdNotEquals}&attendantId.specified={attendantIdSpecified}&attendantId.in={attendantIdIn}&attendantId.notIn={attendantIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Long> countStaffWithHttpInfo(@QueryMap(encoded=true) CountStaffQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>countStaff</code> method in a fluent style.
   */
  public static class CountStaffQueryParams extends HashMap<String, Object> {
    public CountStaffQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStaffQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStaffQueryParams nameContains(@jakarta.annotation.Nullable final String value) {
      put("name.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams nameDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("name.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams nameEquals(@jakarta.annotation.Nullable final String value) {
      put("name.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams nameNotEquals(@jakarta.annotation.Nullable final String value) {
      put("name.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams nameSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("name.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams nameIn(@jakarta.annotation.Nullable final List<String> value) {
      put("name.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStaffQueryParams nameNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("name.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStaffQueryParams ageGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("age.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams ageLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("age.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams ageGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("age.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams ageLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("age.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams ageEquals(@jakarta.annotation.Nullable final Integer value) {
      put("age.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams ageNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("age.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams ageSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("age.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams ageIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("age.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStaffQueryParams ageNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("age.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStaffQueryParams genderEquals(@jakarta.annotation.Nullable final String value) {
      put("gender.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams genderNotEquals(@jakarta.annotation.Nullable final String value) {
      put("gender.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams genderSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("gender.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams genderIn(@jakarta.annotation.Nullable final List<String> value) {
      put("gender.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStaffQueryParams genderNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("gender.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStaffQueryParams phoneNumberContains(@jakarta.annotation.Nullable final String value) {
      put("phoneNumber.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams phoneNumberDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("phoneNumber.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams phoneNumberEquals(@jakarta.annotation.Nullable final String value) {
      put("phoneNumber.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams phoneNumberNotEquals(@jakarta.annotation.Nullable final String value) {
      put("phoneNumber.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams phoneNumberSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("phoneNumber.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams phoneNumberIn(@jakarta.annotation.Nullable final List<String> value) {
      put("phoneNumber.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStaffQueryParams phoneNumberNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("phoneNumber.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStaffQueryParams statusEquals(@jakarta.annotation.Nullable final String value) {
      put("status.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams statusNotEquals(@jakarta.annotation.Nullable final String value) {
      put("status.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams statusSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("status.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams statusIn(@jakarta.annotation.Nullable final List<String> value) {
      put("status.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStaffQueryParams statusNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("status.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStaffQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStaffQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStaffQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStaffQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStaffQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStaffQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStaffQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStaffQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStaffQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStaffQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStaffQueryParams driverIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("driverId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams driverIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("driverId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams driverIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("driverId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams driverIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("driverId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams driverIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("driverId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams driverIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("driverId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams driverIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("driverId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams driverIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("driverId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStaffQueryParams driverIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("driverId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStaffQueryParams attendantIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("attendantId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams attendantIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("attendantId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams attendantIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("attendantId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams attendantIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("attendantId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams attendantIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("attendantId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams attendantIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("attendantId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams attendantIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("attendantId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountStaffQueryParams attendantIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("attendantId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStaffQueryParams attendantIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("attendantId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStaffQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param staffDTO  (required)
   * @return StaffDTO
   */
  @RequestLine("POST /api/staff")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  StaffDTO createStaff(@jakarta.annotation.Nonnull StaffDTO staffDTO);

  /**
   * 
   * Similar to <code>createStaff</code> but it also returns the http response headers .
   * 
   * @param staffDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/staff")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<StaffDTO> createStaffWithHttpInfo(@jakarta.annotation.Nonnull StaffDTO staffDTO);



  /**
   * 
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/staff/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteStaff(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>deleteStaff</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/staff/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteStaffWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



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
   * @param nameContains  (optional)
   * @param nameDoesNotContain  (optional)
   * @param nameEquals  (optional)
   * @param nameNotEquals  (optional)
   * @param nameSpecified  (optional)
   * @param nameIn  (optional)
   * @param nameNotIn  (optional)
   * @param ageGreaterThan  (optional)
   * @param ageLessThan  (optional)
   * @param ageGreaterThanOrEqual  (optional)
   * @param ageLessThanOrEqual  (optional)
   * @param ageEquals  (optional)
   * @param ageNotEquals  (optional)
   * @param ageSpecified  (optional)
   * @param ageIn  (optional)
   * @param ageNotIn  (optional)
   * @param genderEquals  (optional)
   * @param genderNotEquals  (optional)
   * @param genderSpecified  (optional)
   * @param genderIn  (optional)
   * @param genderNotIn  (optional)
   * @param phoneNumberContains  (optional)
   * @param phoneNumberDoesNotContain  (optional)
   * @param phoneNumberEquals  (optional)
   * @param phoneNumberNotEquals  (optional)
   * @param phoneNumberSpecified  (optional)
   * @param phoneNumberIn  (optional)
   * @param phoneNumberNotIn  (optional)
   * @param statusEquals  (optional)
   * @param statusNotEquals  (optional)
   * @param statusSpecified  (optional)
   * @param statusIn  (optional)
   * @param statusNotIn  (optional)
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
   * @param driverIdGreaterThan  (optional)
   * @param driverIdLessThan  (optional)
   * @param driverIdGreaterThanOrEqual  (optional)
   * @param driverIdLessThanOrEqual  (optional)
   * @param driverIdEquals  (optional)
   * @param driverIdNotEquals  (optional)
   * @param driverIdSpecified  (optional)
   * @param driverIdIn  (optional)
   * @param driverIdNotIn  (optional)
   * @param attendantIdGreaterThan  (optional)
   * @param attendantIdLessThan  (optional)
   * @param attendantIdGreaterThanOrEqual  (optional)
   * @param attendantIdLessThanOrEqual  (optional)
   * @param attendantIdEquals  (optional)
   * @param attendantIdNotEquals  (optional)
   * @param attendantIdSpecified  (optional)
   * @param attendantIdIn  (optional)
   * @param attendantIdNotIn  (optional)
   * @param distinct  (optional)
   * @return List&lt;StaffDTO&gt;
   */
  @RequestLine("GET /api/staff?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&age.greaterThan={ageGreaterThan}&age.lessThan={ageLessThan}&age.greaterThanOrEqual={ageGreaterThanOrEqual}&age.lessThanOrEqual={ageLessThanOrEqual}&age.equals={ageEquals}&age.notEquals={ageNotEquals}&age.specified={ageSpecified}&age.in={ageIn}&age.notIn={ageNotIn}&gender.equals={genderEquals}&gender.notEquals={genderNotEquals}&gender.specified={genderSpecified}&gender.in={genderIn}&gender.notIn={genderNotIn}&phoneNumber.contains={phoneNumberContains}&phoneNumber.doesNotContain={phoneNumberDoesNotContain}&phoneNumber.equals={phoneNumberEquals}&phoneNumber.notEquals={phoneNumberNotEquals}&phoneNumber.specified={phoneNumberSpecified}&phoneNumber.in={phoneNumberIn}&phoneNumber.notIn={phoneNumberNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&driverId.greaterThan={driverIdGreaterThan}&driverId.lessThan={driverIdLessThan}&driverId.greaterThanOrEqual={driverIdGreaterThanOrEqual}&driverId.lessThanOrEqual={driverIdLessThanOrEqual}&driverId.equals={driverIdEquals}&driverId.notEquals={driverIdNotEquals}&driverId.specified={driverIdSpecified}&driverId.in={driverIdIn}&driverId.notIn={driverIdNotIn}&attendantId.greaterThan={attendantIdGreaterThan}&attendantId.lessThan={attendantIdLessThan}&attendantId.greaterThanOrEqual={attendantIdGreaterThanOrEqual}&attendantId.lessThanOrEqual={attendantIdLessThanOrEqual}&attendantId.equals={attendantIdEquals}&attendantId.notEquals={attendantIdNotEquals}&attendantId.specified={attendantIdSpecified}&attendantId.in={attendantIdIn}&attendantId.notIn={attendantIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  List<StaffDTO> getAllStaff(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("nameContains") @jakarta.annotation.Nullable String nameContains, @Param("nameDoesNotContain") @jakarta.annotation.Nullable String nameDoesNotContain, @Param("nameEquals") @jakarta.annotation.Nullable String nameEquals, @Param("nameNotEquals") @jakarta.annotation.Nullable String nameNotEquals, @Param("nameSpecified") @jakarta.annotation.Nullable Boolean nameSpecified, @Param("nameIn") @jakarta.annotation.Nullable List<String> nameIn, @Param("nameNotIn") @jakarta.annotation.Nullable List<String> nameNotIn, @Param("ageGreaterThan") @jakarta.annotation.Nullable Integer ageGreaterThan, @Param("ageLessThan") @jakarta.annotation.Nullable Integer ageLessThan, @Param("ageGreaterThanOrEqual") @jakarta.annotation.Nullable Integer ageGreaterThanOrEqual, @Param("ageLessThanOrEqual") @jakarta.annotation.Nullable Integer ageLessThanOrEqual, @Param("ageEquals") @jakarta.annotation.Nullable Integer ageEquals, @Param("ageNotEquals") @jakarta.annotation.Nullable Integer ageNotEquals, @Param("ageSpecified") @jakarta.annotation.Nullable Boolean ageSpecified, @Param("ageIn") @jakarta.annotation.Nullable List<Integer> ageIn, @Param("ageNotIn") @jakarta.annotation.Nullable List<Integer> ageNotIn, @Param("genderEquals") @jakarta.annotation.Nullable String genderEquals, @Param("genderNotEquals") @jakarta.annotation.Nullable String genderNotEquals, @Param("genderSpecified") @jakarta.annotation.Nullable Boolean genderSpecified, @Param("genderIn") @jakarta.annotation.Nullable List<String> genderIn, @Param("genderNotIn") @jakarta.annotation.Nullable List<String> genderNotIn, @Param("phoneNumberContains") @jakarta.annotation.Nullable String phoneNumberContains, @Param("phoneNumberDoesNotContain") @jakarta.annotation.Nullable String phoneNumberDoesNotContain, @Param("phoneNumberEquals") @jakarta.annotation.Nullable String phoneNumberEquals, @Param("phoneNumberNotEquals") @jakarta.annotation.Nullable String phoneNumberNotEquals, @Param("phoneNumberSpecified") @jakarta.annotation.Nullable Boolean phoneNumberSpecified, @Param("phoneNumberIn") @jakarta.annotation.Nullable List<String> phoneNumberIn, @Param("phoneNumberNotIn") @jakarta.annotation.Nullable List<String> phoneNumberNotIn, @Param("statusEquals") @jakarta.annotation.Nullable String statusEquals, @Param("statusNotEquals") @jakarta.annotation.Nullable String statusNotEquals, @Param("statusSpecified") @jakarta.annotation.Nullable Boolean statusSpecified, @Param("statusIn") @jakarta.annotation.Nullable List<String> statusIn, @Param("statusNotIn") @jakarta.annotation.Nullable List<String> statusNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("driverIdGreaterThan") @jakarta.annotation.Nullable Long driverIdGreaterThan, @Param("driverIdLessThan") @jakarta.annotation.Nullable Long driverIdLessThan, @Param("driverIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long driverIdGreaterThanOrEqual, @Param("driverIdLessThanOrEqual") @jakarta.annotation.Nullable Long driverIdLessThanOrEqual, @Param("driverIdEquals") @jakarta.annotation.Nullable Long driverIdEquals, @Param("driverIdNotEquals") @jakarta.annotation.Nullable Long driverIdNotEquals, @Param("driverIdSpecified") @jakarta.annotation.Nullable Boolean driverIdSpecified, @Param("driverIdIn") @jakarta.annotation.Nullable List<Long> driverIdIn, @Param("driverIdNotIn") @jakarta.annotation.Nullable List<Long> driverIdNotIn, @Param("attendantIdGreaterThan") @jakarta.annotation.Nullable Long attendantIdGreaterThan, @Param("attendantIdLessThan") @jakarta.annotation.Nullable Long attendantIdLessThan, @Param("attendantIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long attendantIdGreaterThanOrEqual, @Param("attendantIdLessThanOrEqual") @jakarta.annotation.Nullable Long attendantIdLessThanOrEqual, @Param("attendantIdEquals") @jakarta.annotation.Nullable Long attendantIdEquals, @Param("attendantIdNotEquals") @jakarta.annotation.Nullable Long attendantIdNotEquals, @Param("attendantIdSpecified") @jakarta.annotation.Nullable Boolean attendantIdSpecified, @Param("attendantIdIn") @jakarta.annotation.Nullable List<Long> attendantIdIn, @Param("attendantIdNotIn") @jakarta.annotation.Nullable List<Long> attendantIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>getAllStaff</code> but it also returns the http response headers .
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
   * @param nameContains  (optional)
   * @param nameDoesNotContain  (optional)
   * @param nameEquals  (optional)
   * @param nameNotEquals  (optional)
   * @param nameSpecified  (optional)
   * @param nameIn  (optional)
   * @param nameNotIn  (optional)
   * @param ageGreaterThan  (optional)
   * @param ageLessThan  (optional)
   * @param ageGreaterThanOrEqual  (optional)
   * @param ageLessThanOrEqual  (optional)
   * @param ageEquals  (optional)
   * @param ageNotEquals  (optional)
   * @param ageSpecified  (optional)
   * @param ageIn  (optional)
   * @param ageNotIn  (optional)
   * @param genderEquals  (optional)
   * @param genderNotEquals  (optional)
   * @param genderSpecified  (optional)
   * @param genderIn  (optional)
   * @param genderNotIn  (optional)
   * @param phoneNumberContains  (optional)
   * @param phoneNumberDoesNotContain  (optional)
   * @param phoneNumberEquals  (optional)
   * @param phoneNumberNotEquals  (optional)
   * @param phoneNumberSpecified  (optional)
   * @param phoneNumberIn  (optional)
   * @param phoneNumberNotIn  (optional)
   * @param statusEquals  (optional)
   * @param statusNotEquals  (optional)
   * @param statusSpecified  (optional)
   * @param statusIn  (optional)
   * @param statusNotIn  (optional)
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
   * @param driverIdGreaterThan  (optional)
   * @param driverIdLessThan  (optional)
   * @param driverIdGreaterThanOrEqual  (optional)
   * @param driverIdLessThanOrEqual  (optional)
   * @param driverIdEquals  (optional)
   * @param driverIdNotEquals  (optional)
   * @param driverIdSpecified  (optional)
   * @param driverIdIn  (optional)
   * @param driverIdNotIn  (optional)
   * @param attendantIdGreaterThan  (optional)
   * @param attendantIdLessThan  (optional)
   * @param attendantIdGreaterThanOrEqual  (optional)
   * @param attendantIdLessThanOrEqual  (optional)
   * @param attendantIdEquals  (optional)
   * @param attendantIdNotEquals  (optional)
   * @param attendantIdSpecified  (optional)
   * @param attendantIdIn  (optional)
   * @param attendantIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/staff?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&age.greaterThan={ageGreaterThan}&age.lessThan={ageLessThan}&age.greaterThanOrEqual={ageGreaterThanOrEqual}&age.lessThanOrEqual={ageLessThanOrEqual}&age.equals={ageEquals}&age.notEquals={ageNotEquals}&age.specified={ageSpecified}&age.in={ageIn}&age.notIn={ageNotIn}&gender.equals={genderEquals}&gender.notEquals={genderNotEquals}&gender.specified={genderSpecified}&gender.in={genderIn}&gender.notIn={genderNotIn}&phoneNumber.contains={phoneNumberContains}&phoneNumber.doesNotContain={phoneNumberDoesNotContain}&phoneNumber.equals={phoneNumberEquals}&phoneNumber.notEquals={phoneNumberNotEquals}&phoneNumber.specified={phoneNumberSpecified}&phoneNumber.in={phoneNumberIn}&phoneNumber.notIn={phoneNumberNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&driverId.greaterThan={driverIdGreaterThan}&driverId.lessThan={driverIdLessThan}&driverId.greaterThanOrEqual={driverIdGreaterThanOrEqual}&driverId.lessThanOrEqual={driverIdLessThanOrEqual}&driverId.equals={driverIdEquals}&driverId.notEquals={driverIdNotEquals}&driverId.specified={driverIdSpecified}&driverId.in={driverIdIn}&driverId.notIn={driverIdNotIn}&attendantId.greaterThan={attendantIdGreaterThan}&attendantId.lessThan={attendantIdLessThan}&attendantId.greaterThanOrEqual={attendantIdGreaterThanOrEqual}&attendantId.lessThanOrEqual={attendantIdLessThanOrEqual}&attendantId.equals={attendantIdEquals}&attendantId.notEquals={attendantIdNotEquals}&attendantId.specified={attendantIdSpecified}&attendantId.in={attendantIdIn}&attendantId.notIn={attendantIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<StaffDTO>> getAllStaffWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("nameContains") @jakarta.annotation.Nullable String nameContains, @Param("nameDoesNotContain") @jakarta.annotation.Nullable String nameDoesNotContain, @Param("nameEquals") @jakarta.annotation.Nullable String nameEquals, @Param("nameNotEquals") @jakarta.annotation.Nullable String nameNotEquals, @Param("nameSpecified") @jakarta.annotation.Nullable Boolean nameSpecified, @Param("nameIn") @jakarta.annotation.Nullable List<String> nameIn, @Param("nameNotIn") @jakarta.annotation.Nullable List<String> nameNotIn, @Param("ageGreaterThan") @jakarta.annotation.Nullable Integer ageGreaterThan, @Param("ageLessThan") @jakarta.annotation.Nullable Integer ageLessThan, @Param("ageGreaterThanOrEqual") @jakarta.annotation.Nullable Integer ageGreaterThanOrEqual, @Param("ageLessThanOrEqual") @jakarta.annotation.Nullable Integer ageLessThanOrEqual, @Param("ageEquals") @jakarta.annotation.Nullable Integer ageEquals, @Param("ageNotEquals") @jakarta.annotation.Nullable Integer ageNotEquals, @Param("ageSpecified") @jakarta.annotation.Nullable Boolean ageSpecified, @Param("ageIn") @jakarta.annotation.Nullable List<Integer> ageIn, @Param("ageNotIn") @jakarta.annotation.Nullable List<Integer> ageNotIn, @Param("genderEquals") @jakarta.annotation.Nullable String genderEquals, @Param("genderNotEquals") @jakarta.annotation.Nullable String genderNotEquals, @Param("genderSpecified") @jakarta.annotation.Nullable Boolean genderSpecified, @Param("genderIn") @jakarta.annotation.Nullable List<String> genderIn, @Param("genderNotIn") @jakarta.annotation.Nullable List<String> genderNotIn, @Param("phoneNumberContains") @jakarta.annotation.Nullable String phoneNumberContains, @Param("phoneNumberDoesNotContain") @jakarta.annotation.Nullable String phoneNumberDoesNotContain, @Param("phoneNumberEquals") @jakarta.annotation.Nullable String phoneNumberEquals, @Param("phoneNumberNotEquals") @jakarta.annotation.Nullable String phoneNumberNotEquals, @Param("phoneNumberSpecified") @jakarta.annotation.Nullable Boolean phoneNumberSpecified, @Param("phoneNumberIn") @jakarta.annotation.Nullable List<String> phoneNumberIn, @Param("phoneNumberNotIn") @jakarta.annotation.Nullable List<String> phoneNumberNotIn, @Param("statusEquals") @jakarta.annotation.Nullable String statusEquals, @Param("statusNotEquals") @jakarta.annotation.Nullable String statusNotEquals, @Param("statusSpecified") @jakarta.annotation.Nullable Boolean statusSpecified, @Param("statusIn") @jakarta.annotation.Nullable List<String> statusIn, @Param("statusNotIn") @jakarta.annotation.Nullable List<String> statusNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("driverIdGreaterThan") @jakarta.annotation.Nullable Long driverIdGreaterThan, @Param("driverIdLessThan") @jakarta.annotation.Nullable Long driverIdLessThan, @Param("driverIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long driverIdGreaterThanOrEqual, @Param("driverIdLessThanOrEqual") @jakarta.annotation.Nullable Long driverIdLessThanOrEqual, @Param("driverIdEquals") @jakarta.annotation.Nullable Long driverIdEquals, @Param("driverIdNotEquals") @jakarta.annotation.Nullable Long driverIdNotEquals, @Param("driverIdSpecified") @jakarta.annotation.Nullable Boolean driverIdSpecified, @Param("driverIdIn") @jakarta.annotation.Nullable List<Long> driverIdIn, @Param("driverIdNotIn") @jakarta.annotation.Nullable List<Long> driverIdNotIn, @Param("attendantIdGreaterThan") @jakarta.annotation.Nullable Long attendantIdGreaterThan, @Param("attendantIdLessThan") @jakarta.annotation.Nullable Long attendantIdLessThan, @Param("attendantIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long attendantIdGreaterThanOrEqual, @Param("attendantIdLessThanOrEqual") @jakarta.annotation.Nullable Long attendantIdLessThanOrEqual, @Param("attendantIdEquals") @jakarta.annotation.Nullable Long attendantIdEquals, @Param("attendantIdNotEquals") @jakarta.annotation.Nullable Long attendantIdNotEquals, @Param("attendantIdSpecified") @jakarta.annotation.Nullable Boolean attendantIdSpecified, @Param("attendantIdIn") @jakarta.annotation.Nullable List<Long> attendantIdIn, @Param("attendantIdNotIn") @jakarta.annotation.Nullable List<Long> attendantIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllStaff</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllStaffQueryParams} class that allows for
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
   *   <li>nameContains -  (optional)</li>
   *   <li>nameDoesNotContain -  (optional)</li>
   *   <li>nameEquals -  (optional)</li>
   *   <li>nameNotEquals -  (optional)</li>
   *   <li>nameSpecified -  (optional)</li>
   *   <li>nameIn -  (optional)</li>
   *   <li>nameNotIn -  (optional)</li>
   *   <li>ageGreaterThan -  (optional)</li>
   *   <li>ageLessThan -  (optional)</li>
   *   <li>ageGreaterThanOrEqual -  (optional)</li>
   *   <li>ageLessThanOrEqual -  (optional)</li>
   *   <li>ageEquals -  (optional)</li>
   *   <li>ageNotEquals -  (optional)</li>
   *   <li>ageSpecified -  (optional)</li>
   *   <li>ageIn -  (optional)</li>
   *   <li>ageNotIn -  (optional)</li>
   *   <li>genderEquals -  (optional)</li>
   *   <li>genderNotEquals -  (optional)</li>
   *   <li>genderSpecified -  (optional)</li>
   *   <li>genderIn -  (optional)</li>
   *   <li>genderNotIn -  (optional)</li>
   *   <li>phoneNumberContains -  (optional)</li>
   *   <li>phoneNumberDoesNotContain -  (optional)</li>
   *   <li>phoneNumberEquals -  (optional)</li>
   *   <li>phoneNumberNotEquals -  (optional)</li>
   *   <li>phoneNumberSpecified -  (optional)</li>
   *   <li>phoneNumberIn -  (optional)</li>
   *   <li>phoneNumberNotIn -  (optional)</li>
   *   <li>statusEquals -  (optional)</li>
   *   <li>statusNotEquals -  (optional)</li>
   *   <li>statusSpecified -  (optional)</li>
   *   <li>statusIn -  (optional)</li>
   *   <li>statusNotIn -  (optional)</li>
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
   *   <li>driverIdGreaterThan -  (optional)</li>
   *   <li>driverIdLessThan -  (optional)</li>
   *   <li>driverIdGreaterThanOrEqual -  (optional)</li>
   *   <li>driverIdLessThanOrEqual -  (optional)</li>
   *   <li>driverIdEquals -  (optional)</li>
   *   <li>driverIdNotEquals -  (optional)</li>
   *   <li>driverIdSpecified -  (optional)</li>
   *   <li>driverIdIn -  (optional)</li>
   *   <li>driverIdNotIn -  (optional)</li>
   *   <li>attendantIdGreaterThan -  (optional)</li>
   *   <li>attendantIdLessThan -  (optional)</li>
   *   <li>attendantIdGreaterThanOrEqual -  (optional)</li>
   *   <li>attendantIdLessThanOrEqual -  (optional)</li>
   *   <li>attendantIdEquals -  (optional)</li>
   *   <li>attendantIdNotEquals -  (optional)</li>
   *   <li>attendantIdSpecified -  (optional)</li>
   *   <li>attendantIdIn -  (optional)</li>
   *   <li>attendantIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return List&lt;StaffDTO&gt;
   */
  @RequestLine("GET /api/staff?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&age.greaterThan={ageGreaterThan}&age.lessThan={ageLessThan}&age.greaterThanOrEqual={ageGreaterThanOrEqual}&age.lessThanOrEqual={ageLessThanOrEqual}&age.equals={ageEquals}&age.notEquals={ageNotEquals}&age.specified={ageSpecified}&age.in={ageIn}&age.notIn={ageNotIn}&gender.equals={genderEquals}&gender.notEquals={genderNotEquals}&gender.specified={genderSpecified}&gender.in={genderIn}&gender.notIn={genderNotIn}&phoneNumber.contains={phoneNumberContains}&phoneNumber.doesNotContain={phoneNumberDoesNotContain}&phoneNumber.equals={phoneNumberEquals}&phoneNumber.notEquals={phoneNumberNotEquals}&phoneNumber.specified={phoneNumberSpecified}&phoneNumber.in={phoneNumberIn}&phoneNumber.notIn={phoneNumberNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&driverId.greaterThan={driverIdGreaterThan}&driverId.lessThan={driverIdLessThan}&driverId.greaterThanOrEqual={driverIdGreaterThanOrEqual}&driverId.lessThanOrEqual={driverIdLessThanOrEqual}&driverId.equals={driverIdEquals}&driverId.notEquals={driverIdNotEquals}&driverId.specified={driverIdSpecified}&driverId.in={driverIdIn}&driverId.notIn={driverIdNotIn}&attendantId.greaterThan={attendantIdGreaterThan}&attendantId.lessThan={attendantIdLessThan}&attendantId.greaterThanOrEqual={attendantIdGreaterThanOrEqual}&attendantId.lessThanOrEqual={attendantIdLessThanOrEqual}&attendantId.equals={attendantIdEquals}&attendantId.notEquals={attendantIdNotEquals}&attendantId.specified={attendantIdSpecified}&attendantId.in={attendantIdIn}&attendantId.notIn={attendantIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  List<StaffDTO> getAllStaff(@QueryMap(encoded=true) GetAllStaffQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllStaff</code> that receives the query parameters as a map,
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
          *   <li>nameContains -  (optional)</li>
          *   <li>nameDoesNotContain -  (optional)</li>
          *   <li>nameEquals -  (optional)</li>
          *   <li>nameNotEquals -  (optional)</li>
          *   <li>nameSpecified -  (optional)</li>
          *   <li>nameIn -  (optional)</li>
          *   <li>nameNotIn -  (optional)</li>
          *   <li>ageGreaterThan -  (optional)</li>
          *   <li>ageLessThan -  (optional)</li>
          *   <li>ageGreaterThanOrEqual -  (optional)</li>
          *   <li>ageLessThanOrEqual -  (optional)</li>
          *   <li>ageEquals -  (optional)</li>
          *   <li>ageNotEquals -  (optional)</li>
          *   <li>ageSpecified -  (optional)</li>
          *   <li>ageIn -  (optional)</li>
          *   <li>ageNotIn -  (optional)</li>
          *   <li>genderEquals -  (optional)</li>
          *   <li>genderNotEquals -  (optional)</li>
          *   <li>genderSpecified -  (optional)</li>
          *   <li>genderIn -  (optional)</li>
          *   <li>genderNotIn -  (optional)</li>
          *   <li>phoneNumberContains -  (optional)</li>
          *   <li>phoneNumberDoesNotContain -  (optional)</li>
          *   <li>phoneNumberEquals -  (optional)</li>
          *   <li>phoneNumberNotEquals -  (optional)</li>
          *   <li>phoneNumberSpecified -  (optional)</li>
          *   <li>phoneNumberIn -  (optional)</li>
          *   <li>phoneNumberNotIn -  (optional)</li>
          *   <li>statusEquals -  (optional)</li>
          *   <li>statusNotEquals -  (optional)</li>
          *   <li>statusSpecified -  (optional)</li>
          *   <li>statusIn -  (optional)</li>
          *   <li>statusNotIn -  (optional)</li>
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
          *   <li>driverIdGreaterThan -  (optional)</li>
          *   <li>driverIdLessThan -  (optional)</li>
          *   <li>driverIdGreaterThanOrEqual -  (optional)</li>
          *   <li>driverIdLessThanOrEqual -  (optional)</li>
          *   <li>driverIdEquals -  (optional)</li>
          *   <li>driverIdNotEquals -  (optional)</li>
          *   <li>driverIdSpecified -  (optional)</li>
          *   <li>driverIdIn -  (optional)</li>
          *   <li>driverIdNotIn -  (optional)</li>
          *   <li>attendantIdGreaterThan -  (optional)</li>
          *   <li>attendantIdLessThan -  (optional)</li>
          *   <li>attendantIdGreaterThanOrEqual -  (optional)</li>
          *   <li>attendantIdLessThanOrEqual -  (optional)</li>
          *   <li>attendantIdEquals -  (optional)</li>
          *   <li>attendantIdNotEquals -  (optional)</li>
          *   <li>attendantIdSpecified -  (optional)</li>
          *   <li>attendantIdIn -  (optional)</li>
          *   <li>attendantIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return List&lt;StaffDTO&gt;
      */
      @RequestLine("GET /api/staff?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&age.greaterThan={ageGreaterThan}&age.lessThan={ageLessThan}&age.greaterThanOrEqual={ageGreaterThanOrEqual}&age.lessThanOrEqual={ageLessThanOrEqual}&age.equals={ageEquals}&age.notEquals={ageNotEquals}&age.specified={ageSpecified}&age.in={ageIn}&age.notIn={ageNotIn}&gender.equals={genderEquals}&gender.notEquals={genderNotEquals}&gender.specified={genderSpecified}&gender.in={genderIn}&gender.notIn={genderNotIn}&phoneNumber.contains={phoneNumberContains}&phoneNumber.doesNotContain={phoneNumberDoesNotContain}&phoneNumber.equals={phoneNumberEquals}&phoneNumber.notEquals={phoneNumberNotEquals}&phoneNumber.specified={phoneNumberSpecified}&phoneNumber.in={phoneNumberIn}&phoneNumber.notIn={phoneNumberNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&driverId.greaterThan={driverIdGreaterThan}&driverId.lessThan={driverIdLessThan}&driverId.greaterThanOrEqual={driverIdGreaterThanOrEqual}&driverId.lessThanOrEqual={driverIdLessThanOrEqual}&driverId.equals={driverIdEquals}&driverId.notEquals={driverIdNotEquals}&driverId.specified={driverIdSpecified}&driverId.in={driverIdIn}&driverId.notIn={driverIdNotIn}&attendantId.greaterThan={attendantIdGreaterThan}&attendantId.lessThan={attendantIdLessThan}&attendantId.greaterThanOrEqual={attendantIdGreaterThanOrEqual}&attendantId.lessThanOrEqual={attendantIdLessThanOrEqual}&attendantId.equals={attendantIdEquals}&attendantId.notEquals={attendantIdNotEquals}&attendantId.specified={attendantIdSpecified}&attendantId.in={attendantIdIn}&attendantId.notIn={attendantIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<StaffDTO>> getAllStaffWithHttpInfo(@QueryMap(encoded=true) GetAllStaffQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllStaff</code> method in a fluent style.
   */
  public static class GetAllStaffQueryParams extends HashMap<String, Object> {
    public GetAllStaffQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStaffQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStaffQueryParams nameContains(@jakarta.annotation.Nullable final String value) {
      put("name.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams nameDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("name.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams nameEquals(@jakarta.annotation.Nullable final String value) {
      put("name.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams nameNotEquals(@jakarta.annotation.Nullable final String value) {
      put("name.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams nameSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("name.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams nameIn(@jakarta.annotation.Nullable final List<String> value) {
      put("name.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStaffQueryParams nameNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("name.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStaffQueryParams ageGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("age.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams ageLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("age.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams ageGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("age.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams ageLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("age.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams ageEquals(@jakarta.annotation.Nullable final Integer value) {
      put("age.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams ageNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("age.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams ageSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("age.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams ageIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("age.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStaffQueryParams ageNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("age.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStaffQueryParams genderEquals(@jakarta.annotation.Nullable final String value) {
      put("gender.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams genderNotEquals(@jakarta.annotation.Nullable final String value) {
      put("gender.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams genderSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("gender.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams genderIn(@jakarta.annotation.Nullable final List<String> value) {
      put("gender.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStaffQueryParams genderNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("gender.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStaffQueryParams phoneNumberContains(@jakarta.annotation.Nullable final String value) {
      put("phoneNumber.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams phoneNumberDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("phoneNumber.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams phoneNumberEquals(@jakarta.annotation.Nullable final String value) {
      put("phoneNumber.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams phoneNumberNotEquals(@jakarta.annotation.Nullable final String value) {
      put("phoneNumber.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams phoneNumberSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("phoneNumber.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams phoneNumberIn(@jakarta.annotation.Nullable final List<String> value) {
      put("phoneNumber.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStaffQueryParams phoneNumberNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("phoneNumber.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStaffQueryParams statusEquals(@jakarta.annotation.Nullable final String value) {
      put("status.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams statusNotEquals(@jakarta.annotation.Nullable final String value) {
      put("status.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams statusSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("status.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams statusIn(@jakarta.annotation.Nullable final List<String> value) {
      put("status.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStaffQueryParams statusNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("status.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStaffQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStaffQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStaffQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStaffQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStaffQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStaffQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStaffQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStaffQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStaffQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStaffQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStaffQueryParams driverIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("driverId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams driverIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("driverId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams driverIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("driverId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams driverIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("driverId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams driverIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("driverId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams driverIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("driverId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams driverIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("driverId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams driverIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("driverId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStaffQueryParams driverIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("driverId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStaffQueryParams attendantIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("attendantId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams attendantIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("attendantId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams attendantIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("attendantId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams attendantIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("attendantId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams attendantIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("attendantId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams attendantIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("attendantId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams attendantIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("attendantId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStaffQueryParams attendantIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("attendantId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStaffQueryParams attendantIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("attendantId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStaffQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @return StaffDTO
   */
  @RequestLine("GET /api/staff/{id}")
  @Headers({
    "Accept: */*",
  })
  StaffDTO getStaff(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>getStaff</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/staff/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<StaffDTO> getStaffWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param id  (required)
   * @param staffDTO  (required)
   * @return StaffDTO
   */
  @RequestLine("PATCH /api/staff/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  StaffDTO partialUpdateStaff(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull StaffDTO staffDTO);

  /**
   * 
   * Similar to <code>partialUpdateStaff</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param staffDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /api/staff/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<StaffDTO> partialUpdateStaffWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull StaffDTO staffDTO);



  /**
   * 
   * 
   * @param id  (required)
   * @param staffDTO  (required)
   * @return StaffDTO
   */
  @RequestLine("PUT /api/staff/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  StaffDTO updateStaff(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull StaffDTO staffDTO);

  /**
   * 
   * Similar to <code>updateStaff</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param staffDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/staff/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<StaffDTO> updateStaffWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull StaffDTO staffDTO);


}
