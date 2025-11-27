package com.ridehub.msroute.client.api;

import com.ridehub.msroute.client.invoker.ApiClient;
import com.ridehub.msroute.client.invoker.EncodingUtils;
import com.ridehub.msroute.client.model.ApiResponse;

import com.ridehub.msroute.client.model.DriverDTO;
import java.time.OffsetDateTime;
import com.ridehub.msroute.client.model.SimpleDriverRequestDTO;
import com.ridehub.msroute.client.model.SimpleDriverResponseDTO;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface DriverResourceMsrouteApi extends ApiClient.Api {


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
   * @param licenseClassContains  (optional)
   * @param licenseClassDoesNotContain  (optional)
   * @param licenseClassEquals  (optional)
   * @param licenseClassNotEquals  (optional)
   * @param licenseClassSpecified  (optional)
   * @param licenseClassIn  (optional)
   * @param licenseClassNotIn  (optional)
   * @param yearsExperienceGreaterThan  (optional)
   * @param yearsExperienceLessThan  (optional)
   * @param yearsExperienceGreaterThanOrEqual  (optional)
   * @param yearsExperienceLessThanOrEqual  (optional)
   * @param yearsExperienceEquals  (optional)
   * @param yearsExperienceNotEquals  (optional)
   * @param yearsExperienceSpecified  (optional)
   * @param yearsExperienceIn  (optional)
   * @param yearsExperienceNotIn  (optional)
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
   * @param staffIdGreaterThan  (optional)
   * @param staffIdLessThan  (optional)
   * @param staffIdGreaterThanOrEqual  (optional)
   * @param staffIdLessThanOrEqual  (optional)
   * @param staffIdEquals  (optional)
   * @param staffIdNotEquals  (optional)
   * @param staffIdSpecified  (optional)
   * @param staffIdIn  (optional)
   * @param staffIdNotIn  (optional)
   * @param distinct  (optional)
   * @return Long
   */
  @RequestLine("GET /api/drivers/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&licenseClass.contains={licenseClassContains}&licenseClass.doesNotContain={licenseClassDoesNotContain}&licenseClass.equals={licenseClassEquals}&licenseClass.notEquals={licenseClassNotEquals}&licenseClass.specified={licenseClassSpecified}&licenseClass.in={licenseClassIn}&licenseClass.notIn={licenseClassNotIn}&yearsExperience.greaterThan={yearsExperienceGreaterThan}&yearsExperience.lessThan={yearsExperienceLessThan}&yearsExperience.greaterThanOrEqual={yearsExperienceGreaterThanOrEqual}&yearsExperience.lessThanOrEqual={yearsExperienceLessThanOrEqual}&yearsExperience.equals={yearsExperienceEquals}&yearsExperience.notEquals={yearsExperienceNotEquals}&yearsExperience.specified={yearsExperienceSpecified}&yearsExperience.in={yearsExperienceIn}&yearsExperience.notIn={yearsExperienceNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&staffId.greaterThan={staffIdGreaterThan}&staffId.lessThan={staffIdLessThan}&staffId.greaterThanOrEqual={staffIdGreaterThanOrEqual}&staffId.lessThanOrEqual={staffIdLessThanOrEqual}&staffId.equals={staffIdEquals}&staffId.notEquals={staffIdNotEquals}&staffId.specified={staffIdSpecified}&staffId.in={staffIdIn}&staffId.notIn={staffIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  Long countDrivers(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("licenseClassContains") @jakarta.annotation.Nullable String licenseClassContains, @Param("licenseClassDoesNotContain") @jakarta.annotation.Nullable String licenseClassDoesNotContain, @Param("licenseClassEquals") @jakarta.annotation.Nullable String licenseClassEquals, @Param("licenseClassNotEquals") @jakarta.annotation.Nullable String licenseClassNotEquals, @Param("licenseClassSpecified") @jakarta.annotation.Nullable Boolean licenseClassSpecified, @Param("licenseClassIn") @jakarta.annotation.Nullable List<String> licenseClassIn, @Param("licenseClassNotIn") @jakarta.annotation.Nullable List<String> licenseClassNotIn, @Param("yearsExperienceGreaterThan") @jakarta.annotation.Nullable Integer yearsExperienceGreaterThan, @Param("yearsExperienceLessThan") @jakarta.annotation.Nullable Integer yearsExperienceLessThan, @Param("yearsExperienceGreaterThanOrEqual") @jakarta.annotation.Nullable Integer yearsExperienceGreaterThanOrEqual, @Param("yearsExperienceLessThanOrEqual") @jakarta.annotation.Nullable Integer yearsExperienceLessThanOrEqual, @Param("yearsExperienceEquals") @jakarta.annotation.Nullable Integer yearsExperienceEquals, @Param("yearsExperienceNotEquals") @jakarta.annotation.Nullable Integer yearsExperienceNotEquals, @Param("yearsExperienceSpecified") @jakarta.annotation.Nullable Boolean yearsExperienceSpecified, @Param("yearsExperienceIn") @jakarta.annotation.Nullable List<Integer> yearsExperienceIn, @Param("yearsExperienceNotIn") @jakarta.annotation.Nullable List<Integer> yearsExperienceNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("staffIdGreaterThan") @jakarta.annotation.Nullable Long staffIdGreaterThan, @Param("staffIdLessThan") @jakarta.annotation.Nullable Long staffIdLessThan, @Param("staffIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long staffIdGreaterThanOrEqual, @Param("staffIdLessThanOrEqual") @jakarta.annotation.Nullable Long staffIdLessThanOrEqual, @Param("staffIdEquals") @jakarta.annotation.Nullable Long staffIdEquals, @Param("staffIdNotEquals") @jakarta.annotation.Nullable Long staffIdNotEquals, @Param("staffIdSpecified") @jakarta.annotation.Nullable Boolean staffIdSpecified, @Param("staffIdIn") @jakarta.annotation.Nullable List<Long> staffIdIn, @Param("staffIdNotIn") @jakarta.annotation.Nullable List<Long> staffIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>countDrivers</code> but it also returns the http response headers .
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
   * @param licenseClassContains  (optional)
   * @param licenseClassDoesNotContain  (optional)
   * @param licenseClassEquals  (optional)
   * @param licenseClassNotEquals  (optional)
   * @param licenseClassSpecified  (optional)
   * @param licenseClassIn  (optional)
   * @param licenseClassNotIn  (optional)
   * @param yearsExperienceGreaterThan  (optional)
   * @param yearsExperienceLessThan  (optional)
   * @param yearsExperienceGreaterThanOrEqual  (optional)
   * @param yearsExperienceLessThanOrEqual  (optional)
   * @param yearsExperienceEquals  (optional)
   * @param yearsExperienceNotEquals  (optional)
   * @param yearsExperienceSpecified  (optional)
   * @param yearsExperienceIn  (optional)
   * @param yearsExperienceNotIn  (optional)
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
   * @param staffIdGreaterThan  (optional)
   * @param staffIdLessThan  (optional)
   * @param staffIdGreaterThanOrEqual  (optional)
   * @param staffIdLessThanOrEqual  (optional)
   * @param staffIdEquals  (optional)
   * @param staffIdNotEquals  (optional)
   * @param staffIdSpecified  (optional)
   * @param staffIdIn  (optional)
   * @param staffIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/drivers/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&licenseClass.contains={licenseClassContains}&licenseClass.doesNotContain={licenseClassDoesNotContain}&licenseClass.equals={licenseClassEquals}&licenseClass.notEquals={licenseClassNotEquals}&licenseClass.specified={licenseClassSpecified}&licenseClass.in={licenseClassIn}&licenseClass.notIn={licenseClassNotIn}&yearsExperience.greaterThan={yearsExperienceGreaterThan}&yearsExperience.lessThan={yearsExperienceLessThan}&yearsExperience.greaterThanOrEqual={yearsExperienceGreaterThanOrEqual}&yearsExperience.lessThanOrEqual={yearsExperienceLessThanOrEqual}&yearsExperience.equals={yearsExperienceEquals}&yearsExperience.notEquals={yearsExperienceNotEquals}&yearsExperience.specified={yearsExperienceSpecified}&yearsExperience.in={yearsExperienceIn}&yearsExperience.notIn={yearsExperienceNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&staffId.greaterThan={staffIdGreaterThan}&staffId.lessThan={staffIdLessThan}&staffId.greaterThanOrEqual={staffIdGreaterThanOrEqual}&staffId.lessThanOrEqual={staffIdLessThanOrEqual}&staffId.equals={staffIdEquals}&staffId.notEquals={staffIdNotEquals}&staffId.specified={staffIdSpecified}&staffId.in={staffIdIn}&staffId.notIn={staffIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Long> countDriversWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("licenseClassContains") @jakarta.annotation.Nullable String licenseClassContains, @Param("licenseClassDoesNotContain") @jakarta.annotation.Nullable String licenseClassDoesNotContain, @Param("licenseClassEquals") @jakarta.annotation.Nullable String licenseClassEquals, @Param("licenseClassNotEquals") @jakarta.annotation.Nullable String licenseClassNotEquals, @Param("licenseClassSpecified") @jakarta.annotation.Nullable Boolean licenseClassSpecified, @Param("licenseClassIn") @jakarta.annotation.Nullable List<String> licenseClassIn, @Param("licenseClassNotIn") @jakarta.annotation.Nullable List<String> licenseClassNotIn, @Param("yearsExperienceGreaterThan") @jakarta.annotation.Nullable Integer yearsExperienceGreaterThan, @Param("yearsExperienceLessThan") @jakarta.annotation.Nullable Integer yearsExperienceLessThan, @Param("yearsExperienceGreaterThanOrEqual") @jakarta.annotation.Nullable Integer yearsExperienceGreaterThanOrEqual, @Param("yearsExperienceLessThanOrEqual") @jakarta.annotation.Nullable Integer yearsExperienceLessThanOrEqual, @Param("yearsExperienceEquals") @jakarta.annotation.Nullable Integer yearsExperienceEquals, @Param("yearsExperienceNotEquals") @jakarta.annotation.Nullable Integer yearsExperienceNotEquals, @Param("yearsExperienceSpecified") @jakarta.annotation.Nullable Boolean yearsExperienceSpecified, @Param("yearsExperienceIn") @jakarta.annotation.Nullable List<Integer> yearsExperienceIn, @Param("yearsExperienceNotIn") @jakarta.annotation.Nullable List<Integer> yearsExperienceNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("staffIdGreaterThan") @jakarta.annotation.Nullable Long staffIdGreaterThan, @Param("staffIdLessThan") @jakarta.annotation.Nullable Long staffIdLessThan, @Param("staffIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long staffIdGreaterThanOrEqual, @Param("staffIdLessThanOrEqual") @jakarta.annotation.Nullable Long staffIdLessThanOrEqual, @Param("staffIdEquals") @jakarta.annotation.Nullable Long staffIdEquals, @Param("staffIdNotEquals") @jakarta.annotation.Nullable Long staffIdNotEquals, @Param("staffIdSpecified") @jakarta.annotation.Nullable Boolean staffIdSpecified, @Param("staffIdIn") @jakarta.annotation.Nullable List<Long> staffIdIn, @Param("staffIdNotIn") @jakarta.annotation.Nullable List<Long> staffIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>countDrivers</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CountDriversQueryParams} class that allows for
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
   *   <li>licenseClassContains -  (optional)</li>
   *   <li>licenseClassDoesNotContain -  (optional)</li>
   *   <li>licenseClassEquals -  (optional)</li>
   *   <li>licenseClassNotEquals -  (optional)</li>
   *   <li>licenseClassSpecified -  (optional)</li>
   *   <li>licenseClassIn -  (optional)</li>
   *   <li>licenseClassNotIn -  (optional)</li>
   *   <li>yearsExperienceGreaterThan -  (optional)</li>
   *   <li>yearsExperienceLessThan -  (optional)</li>
   *   <li>yearsExperienceGreaterThanOrEqual -  (optional)</li>
   *   <li>yearsExperienceLessThanOrEqual -  (optional)</li>
   *   <li>yearsExperienceEquals -  (optional)</li>
   *   <li>yearsExperienceNotEquals -  (optional)</li>
   *   <li>yearsExperienceSpecified -  (optional)</li>
   *   <li>yearsExperienceIn -  (optional)</li>
   *   <li>yearsExperienceNotIn -  (optional)</li>
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
   *   <li>staffIdGreaterThan -  (optional)</li>
   *   <li>staffIdLessThan -  (optional)</li>
   *   <li>staffIdGreaterThanOrEqual -  (optional)</li>
   *   <li>staffIdLessThanOrEqual -  (optional)</li>
   *   <li>staffIdEquals -  (optional)</li>
   *   <li>staffIdNotEquals -  (optional)</li>
   *   <li>staffIdSpecified -  (optional)</li>
   *   <li>staffIdIn -  (optional)</li>
   *   <li>staffIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return Long
   */
  @RequestLine("GET /api/drivers/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&licenseClass.contains={licenseClassContains}&licenseClass.doesNotContain={licenseClassDoesNotContain}&licenseClass.equals={licenseClassEquals}&licenseClass.notEquals={licenseClassNotEquals}&licenseClass.specified={licenseClassSpecified}&licenseClass.in={licenseClassIn}&licenseClass.notIn={licenseClassNotIn}&yearsExperience.greaterThan={yearsExperienceGreaterThan}&yearsExperience.lessThan={yearsExperienceLessThan}&yearsExperience.greaterThanOrEqual={yearsExperienceGreaterThanOrEqual}&yearsExperience.lessThanOrEqual={yearsExperienceLessThanOrEqual}&yearsExperience.equals={yearsExperienceEquals}&yearsExperience.notEquals={yearsExperienceNotEquals}&yearsExperience.specified={yearsExperienceSpecified}&yearsExperience.in={yearsExperienceIn}&yearsExperience.notIn={yearsExperienceNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&staffId.greaterThan={staffIdGreaterThan}&staffId.lessThan={staffIdLessThan}&staffId.greaterThanOrEqual={staffIdGreaterThanOrEqual}&staffId.lessThanOrEqual={staffIdLessThanOrEqual}&staffId.equals={staffIdEquals}&staffId.notEquals={staffIdNotEquals}&staffId.specified={staffIdSpecified}&staffId.in={staffIdIn}&staffId.notIn={staffIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  Long countDrivers(@QueryMap(encoded=true) CountDriversQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>countDrivers</code> that receives the query parameters as a map,
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
          *   <li>licenseClassContains -  (optional)</li>
          *   <li>licenseClassDoesNotContain -  (optional)</li>
          *   <li>licenseClassEquals -  (optional)</li>
          *   <li>licenseClassNotEquals -  (optional)</li>
          *   <li>licenseClassSpecified -  (optional)</li>
          *   <li>licenseClassIn -  (optional)</li>
          *   <li>licenseClassNotIn -  (optional)</li>
          *   <li>yearsExperienceGreaterThan -  (optional)</li>
          *   <li>yearsExperienceLessThan -  (optional)</li>
          *   <li>yearsExperienceGreaterThanOrEqual -  (optional)</li>
          *   <li>yearsExperienceLessThanOrEqual -  (optional)</li>
          *   <li>yearsExperienceEquals -  (optional)</li>
          *   <li>yearsExperienceNotEquals -  (optional)</li>
          *   <li>yearsExperienceSpecified -  (optional)</li>
          *   <li>yearsExperienceIn -  (optional)</li>
          *   <li>yearsExperienceNotIn -  (optional)</li>
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
          *   <li>staffIdGreaterThan -  (optional)</li>
          *   <li>staffIdLessThan -  (optional)</li>
          *   <li>staffIdGreaterThanOrEqual -  (optional)</li>
          *   <li>staffIdLessThanOrEqual -  (optional)</li>
          *   <li>staffIdEquals -  (optional)</li>
          *   <li>staffIdNotEquals -  (optional)</li>
          *   <li>staffIdSpecified -  (optional)</li>
          *   <li>staffIdIn -  (optional)</li>
          *   <li>staffIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return Long
      */
      @RequestLine("GET /api/drivers/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&licenseClass.contains={licenseClassContains}&licenseClass.doesNotContain={licenseClassDoesNotContain}&licenseClass.equals={licenseClassEquals}&licenseClass.notEquals={licenseClassNotEquals}&licenseClass.specified={licenseClassSpecified}&licenseClass.in={licenseClassIn}&licenseClass.notIn={licenseClassNotIn}&yearsExperience.greaterThan={yearsExperienceGreaterThan}&yearsExperience.lessThan={yearsExperienceLessThan}&yearsExperience.greaterThanOrEqual={yearsExperienceGreaterThanOrEqual}&yearsExperience.lessThanOrEqual={yearsExperienceLessThanOrEqual}&yearsExperience.equals={yearsExperienceEquals}&yearsExperience.notEquals={yearsExperienceNotEquals}&yearsExperience.specified={yearsExperienceSpecified}&yearsExperience.in={yearsExperienceIn}&yearsExperience.notIn={yearsExperienceNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&staffId.greaterThan={staffIdGreaterThan}&staffId.lessThan={staffIdLessThan}&staffId.greaterThanOrEqual={staffIdGreaterThanOrEqual}&staffId.lessThanOrEqual={staffIdLessThanOrEqual}&staffId.equals={staffIdEquals}&staffId.notEquals={staffIdNotEquals}&staffId.specified={staffIdSpecified}&staffId.in={staffIdIn}&staffId.notIn={staffIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Long> countDriversWithHttpInfo(@QueryMap(encoded=true) CountDriversQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>countDrivers</code> method in a fluent style.
   */
  public static class CountDriversQueryParams extends HashMap<String, Object> {
    public CountDriversQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDriversQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDriversQueryParams licenseClassContains(@jakarta.annotation.Nullable final String value) {
      put("licenseClass.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams licenseClassDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("licenseClass.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams licenseClassEquals(@jakarta.annotation.Nullable final String value) {
      put("licenseClass.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams licenseClassNotEquals(@jakarta.annotation.Nullable final String value) {
      put("licenseClass.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams licenseClassSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("licenseClass.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams licenseClassIn(@jakarta.annotation.Nullable final List<String> value) {
      put("licenseClass.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDriversQueryParams licenseClassNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("licenseClass.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDriversQueryParams yearsExperienceGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("yearsExperience.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams yearsExperienceLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("yearsExperience.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams yearsExperienceGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("yearsExperience.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams yearsExperienceLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("yearsExperience.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams yearsExperienceEquals(@jakarta.annotation.Nullable final Integer value) {
      put("yearsExperience.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams yearsExperienceNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("yearsExperience.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams yearsExperienceSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("yearsExperience.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams yearsExperienceIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("yearsExperience.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDriversQueryParams yearsExperienceNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("yearsExperience.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDriversQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDriversQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDriversQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDriversQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDriversQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDriversQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDriversQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDriversQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDriversQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDriversQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDriversQueryParams staffIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("staffId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams staffIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("staffId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams staffIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("staffId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams staffIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("staffId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams staffIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("staffId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams staffIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("staffId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams staffIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("staffId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountDriversQueryParams staffIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("staffId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDriversQueryParams staffIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("staffId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDriversQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param driverDTO  (required)
   * @return DriverDTO
   */
  @RequestLine("POST /api/drivers")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  DriverDTO createDriver(@jakarta.annotation.Nonnull DriverDTO driverDTO);

  /**
   * 
   * Similar to <code>createDriver</code> but it also returns the http response headers .
   * 
   * @param driverDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/drivers")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<DriverDTO> createDriverWithHttpInfo(@jakarta.annotation.Nonnull DriverDTO driverDTO);



  /**
   * 
   * 
   * @param simpleDriverRequestDTO  (required)
   * @return SimpleDriverResponseDTO
   */
  @RequestLine("POST /api/drivers/simple")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  SimpleDriverResponseDTO createSimpleDriver(@jakarta.annotation.Nonnull SimpleDriverRequestDTO simpleDriverRequestDTO);

  /**
   * 
   * Similar to <code>createSimpleDriver</code> but it also returns the http response headers .
   * 
   * @param simpleDriverRequestDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/drivers/simple")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<SimpleDriverResponseDTO> createSimpleDriverWithHttpInfo(@jakarta.annotation.Nonnull SimpleDriverRequestDTO simpleDriverRequestDTO);



  /**
   * 
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/drivers/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteDriver(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>deleteDriver</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/drivers/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteDriverWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



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
   * @param licenseClassContains  (optional)
   * @param licenseClassDoesNotContain  (optional)
   * @param licenseClassEquals  (optional)
   * @param licenseClassNotEquals  (optional)
   * @param licenseClassSpecified  (optional)
   * @param licenseClassIn  (optional)
   * @param licenseClassNotIn  (optional)
   * @param yearsExperienceGreaterThan  (optional)
   * @param yearsExperienceLessThan  (optional)
   * @param yearsExperienceGreaterThanOrEqual  (optional)
   * @param yearsExperienceLessThanOrEqual  (optional)
   * @param yearsExperienceEquals  (optional)
   * @param yearsExperienceNotEquals  (optional)
   * @param yearsExperienceSpecified  (optional)
   * @param yearsExperienceIn  (optional)
   * @param yearsExperienceNotIn  (optional)
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
   * @param staffIdGreaterThan  (optional)
   * @param staffIdLessThan  (optional)
   * @param staffIdGreaterThanOrEqual  (optional)
   * @param staffIdLessThanOrEqual  (optional)
   * @param staffIdEquals  (optional)
   * @param staffIdNotEquals  (optional)
   * @param staffIdSpecified  (optional)
   * @param staffIdIn  (optional)
   * @param staffIdNotIn  (optional)
   * @param distinct  (optional)
   * @return List&lt;DriverDTO&gt;
   */
  @RequestLine("GET /api/drivers?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&licenseClass.contains={licenseClassContains}&licenseClass.doesNotContain={licenseClassDoesNotContain}&licenseClass.equals={licenseClassEquals}&licenseClass.notEquals={licenseClassNotEquals}&licenseClass.specified={licenseClassSpecified}&licenseClass.in={licenseClassIn}&licenseClass.notIn={licenseClassNotIn}&yearsExperience.greaterThan={yearsExperienceGreaterThan}&yearsExperience.lessThan={yearsExperienceLessThan}&yearsExperience.greaterThanOrEqual={yearsExperienceGreaterThanOrEqual}&yearsExperience.lessThanOrEqual={yearsExperienceLessThanOrEqual}&yearsExperience.equals={yearsExperienceEquals}&yearsExperience.notEquals={yearsExperienceNotEquals}&yearsExperience.specified={yearsExperienceSpecified}&yearsExperience.in={yearsExperienceIn}&yearsExperience.notIn={yearsExperienceNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&staffId.greaterThan={staffIdGreaterThan}&staffId.lessThan={staffIdLessThan}&staffId.greaterThanOrEqual={staffIdGreaterThanOrEqual}&staffId.lessThanOrEqual={staffIdLessThanOrEqual}&staffId.equals={staffIdEquals}&staffId.notEquals={staffIdNotEquals}&staffId.specified={staffIdSpecified}&staffId.in={staffIdIn}&staffId.notIn={staffIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  List<DriverDTO> getAllDrivers(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("licenseClassContains") @jakarta.annotation.Nullable String licenseClassContains, @Param("licenseClassDoesNotContain") @jakarta.annotation.Nullable String licenseClassDoesNotContain, @Param("licenseClassEquals") @jakarta.annotation.Nullable String licenseClassEquals, @Param("licenseClassNotEquals") @jakarta.annotation.Nullable String licenseClassNotEquals, @Param("licenseClassSpecified") @jakarta.annotation.Nullable Boolean licenseClassSpecified, @Param("licenseClassIn") @jakarta.annotation.Nullable List<String> licenseClassIn, @Param("licenseClassNotIn") @jakarta.annotation.Nullable List<String> licenseClassNotIn, @Param("yearsExperienceGreaterThan") @jakarta.annotation.Nullable Integer yearsExperienceGreaterThan, @Param("yearsExperienceLessThan") @jakarta.annotation.Nullable Integer yearsExperienceLessThan, @Param("yearsExperienceGreaterThanOrEqual") @jakarta.annotation.Nullable Integer yearsExperienceGreaterThanOrEqual, @Param("yearsExperienceLessThanOrEqual") @jakarta.annotation.Nullable Integer yearsExperienceLessThanOrEqual, @Param("yearsExperienceEquals") @jakarta.annotation.Nullable Integer yearsExperienceEquals, @Param("yearsExperienceNotEquals") @jakarta.annotation.Nullable Integer yearsExperienceNotEquals, @Param("yearsExperienceSpecified") @jakarta.annotation.Nullable Boolean yearsExperienceSpecified, @Param("yearsExperienceIn") @jakarta.annotation.Nullable List<Integer> yearsExperienceIn, @Param("yearsExperienceNotIn") @jakarta.annotation.Nullable List<Integer> yearsExperienceNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("staffIdGreaterThan") @jakarta.annotation.Nullable Long staffIdGreaterThan, @Param("staffIdLessThan") @jakarta.annotation.Nullable Long staffIdLessThan, @Param("staffIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long staffIdGreaterThanOrEqual, @Param("staffIdLessThanOrEqual") @jakarta.annotation.Nullable Long staffIdLessThanOrEqual, @Param("staffIdEquals") @jakarta.annotation.Nullable Long staffIdEquals, @Param("staffIdNotEquals") @jakarta.annotation.Nullable Long staffIdNotEquals, @Param("staffIdSpecified") @jakarta.annotation.Nullable Boolean staffIdSpecified, @Param("staffIdIn") @jakarta.annotation.Nullable List<Long> staffIdIn, @Param("staffIdNotIn") @jakarta.annotation.Nullable List<Long> staffIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>getAllDrivers</code> but it also returns the http response headers .
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
   * @param licenseClassContains  (optional)
   * @param licenseClassDoesNotContain  (optional)
   * @param licenseClassEquals  (optional)
   * @param licenseClassNotEquals  (optional)
   * @param licenseClassSpecified  (optional)
   * @param licenseClassIn  (optional)
   * @param licenseClassNotIn  (optional)
   * @param yearsExperienceGreaterThan  (optional)
   * @param yearsExperienceLessThan  (optional)
   * @param yearsExperienceGreaterThanOrEqual  (optional)
   * @param yearsExperienceLessThanOrEqual  (optional)
   * @param yearsExperienceEquals  (optional)
   * @param yearsExperienceNotEquals  (optional)
   * @param yearsExperienceSpecified  (optional)
   * @param yearsExperienceIn  (optional)
   * @param yearsExperienceNotIn  (optional)
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
   * @param staffIdGreaterThan  (optional)
   * @param staffIdLessThan  (optional)
   * @param staffIdGreaterThanOrEqual  (optional)
   * @param staffIdLessThanOrEqual  (optional)
   * @param staffIdEquals  (optional)
   * @param staffIdNotEquals  (optional)
   * @param staffIdSpecified  (optional)
   * @param staffIdIn  (optional)
   * @param staffIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/drivers?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&licenseClass.contains={licenseClassContains}&licenseClass.doesNotContain={licenseClassDoesNotContain}&licenseClass.equals={licenseClassEquals}&licenseClass.notEquals={licenseClassNotEquals}&licenseClass.specified={licenseClassSpecified}&licenseClass.in={licenseClassIn}&licenseClass.notIn={licenseClassNotIn}&yearsExperience.greaterThan={yearsExperienceGreaterThan}&yearsExperience.lessThan={yearsExperienceLessThan}&yearsExperience.greaterThanOrEqual={yearsExperienceGreaterThanOrEqual}&yearsExperience.lessThanOrEqual={yearsExperienceLessThanOrEqual}&yearsExperience.equals={yearsExperienceEquals}&yearsExperience.notEquals={yearsExperienceNotEquals}&yearsExperience.specified={yearsExperienceSpecified}&yearsExperience.in={yearsExperienceIn}&yearsExperience.notIn={yearsExperienceNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&staffId.greaterThan={staffIdGreaterThan}&staffId.lessThan={staffIdLessThan}&staffId.greaterThanOrEqual={staffIdGreaterThanOrEqual}&staffId.lessThanOrEqual={staffIdLessThanOrEqual}&staffId.equals={staffIdEquals}&staffId.notEquals={staffIdNotEquals}&staffId.specified={staffIdSpecified}&staffId.in={staffIdIn}&staffId.notIn={staffIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<DriverDTO>> getAllDriversWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("licenseClassContains") @jakarta.annotation.Nullable String licenseClassContains, @Param("licenseClassDoesNotContain") @jakarta.annotation.Nullable String licenseClassDoesNotContain, @Param("licenseClassEquals") @jakarta.annotation.Nullable String licenseClassEquals, @Param("licenseClassNotEquals") @jakarta.annotation.Nullable String licenseClassNotEquals, @Param("licenseClassSpecified") @jakarta.annotation.Nullable Boolean licenseClassSpecified, @Param("licenseClassIn") @jakarta.annotation.Nullable List<String> licenseClassIn, @Param("licenseClassNotIn") @jakarta.annotation.Nullable List<String> licenseClassNotIn, @Param("yearsExperienceGreaterThan") @jakarta.annotation.Nullable Integer yearsExperienceGreaterThan, @Param("yearsExperienceLessThan") @jakarta.annotation.Nullable Integer yearsExperienceLessThan, @Param("yearsExperienceGreaterThanOrEqual") @jakarta.annotation.Nullable Integer yearsExperienceGreaterThanOrEqual, @Param("yearsExperienceLessThanOrEqual") @jakarta.annotation.Nullable Integer yearsExperienceLessThanOrEqual, @Param("yearsExperienceEquals") @jakarta.annotation.Nullable Integer yearsExperienceEquals, @Param("yearsExperienceNotEquals") @jakarta.annotation.Nullable Integer yearsExperienceNotEquals, @Param("yearsExperienceSpecified") @jakarta.annotation.Nullable Boolean yearsExperienceSpecified, @Param("yearsExperienceIn") @jakarta.annotation.Nullable List<Integer> yearsExperienceIn, @Param("yearsExperienceNotIn") @jakarta.annotation.Nullable List<Integer> yearsExperienceNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("staffIdGreaterThan") @jakarta.annotation.Nullable Long staffIdGreaterThan, @Param("staffIdLessThan") @jakarta.annotation.Nullable Long staffIdLessThan, @Param("staffIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long staffIdGreaterThanOrEqual, @Param("staffIdLessThanOrEqual") @jakarta.annotation.Nullable Long staffIdLessThanOrEqual, @Param("staffIdEquals") @jakarta.annotation.Nullable Long staffIdEquals, @Param("staffIdNotEquals") @jakarta.annotation.Nullable Long staffIdNotEquals, @Param("staffIdSpecified") @jakarta.annotation.Nullable Boolean staffIdSpecified, @Param("staffIdIn") @jakarta.annotation.Nullable List<Long> staffIdIn, @Param("staffIdNotIn") @jakarta.annotation.Nullable List<Long> staffIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllDrivers</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllDriversQueryParams} class that allows for
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
   *   <li>licenseClassContains -  (optional)</li>
   *   <li>licenseClassDoesNotContain -  (optional)</li>
   *   <li>licenseClassEquals -  (optional)</li>
   *   <li>licenseClassNotEquals -  (optional)</li>
   *   <li>licenseClassSpecified -  (optional)</li>
   *   <li>licenseClassIn -  (optional)</li>
   *   <li>licenseClassNotIn -  (optional)</li>
   *   <li>yearsExperienceGreaterThan -  (optional)</li>
   *   <li>yearsExperienceLessThan -  (optional)</li>
   *   <li>yearsExperienceGreaterThanOrEqual -  (optional)</li>
   *   <li>yearsExperienceLessThanOrEqual -  (optional)</li>
   *   <li>yearsExperienceEquals -  (optional)</li>
   *   <li>yearsExperienceNotEquals -  (optional)</li>
   *   <li>yearsExperienceSpecified -  (optional)</li>
   *   <li>yearsExperienceIn -  (optional)</li>
   *   <li>yearsExperienceNotIn -  (optional)</li>
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
   *   <li>staffIdGreaterThan -  (optional)</li>
   *   <li>staffIdLessThan -  (optional)</li>
   *   <li>staffIdGreaterThanOrEqual -  (optional)</li>
   *   <li>staffIdLessThanOrEqual -  (optional)</li>
   *   <li>staffIdEquals -  (optional)</li>
   *   <li>staffIdNotEquals -  (optional)</li>
   *   <li>staffIdSpecified -  (optional)</li>
   *   <li>staffIdIn -  (optional)</li>
   *   <li>staffIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return List&lt;DriverDTO&gt;
   */
  @RequestLine("GET /api/drivers?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&licenseClass.contains={licenseClassContains}&licenseClass.doesNotContain={licenseClassDoesNotContain}&licenseClass.equals={licenseClassEquals}&licenseClass.notEquals={licenseClassNotEquals}&licenseClass.specified={licenseClassSpecified}&licenseClass.in={licenseClassIn}&licenseClass.notIn={licenseClassNotIn}&yearsExperience.greaterThan={yearsExperienceGreaterThan}&yearsExperience.lessThan={yearsExperienceLessThan}&yearsExperience.greaterThanOrEqual={yearsExperienceGreaterThanOrEqual}&yearsExperience.lessThanOrEqual={yearsExperienceLessThanOrEqual}&yearsExperience.equals={yearsExperienceEquals}&yearsExperience.notEquals={yearsExperienceNotEquals}&yearsExperience.specified={yearsExperienceSpecified}&yearsExperience.in={yearsExperienceIn}&yearsExperience.notIn={yearsExperienceNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&staffId.greaterThan={staffIdGreaterThan}&staffId.lessThan={staffIdLessThan}&staffId.greaterThanOrEqual={staffIdGreaterThanOrEqual}&staffId.lessThanOrEqual={staffIdLessThanOrEqual}&staffId.equals={staffIdEquals}&staffId.notEquals={staffIdNotEquals}&staffId.specified={staffIdSpecified}&staffId.in={staffIdIn}&staffId.notIn={staffIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  List<DriverDTO> getAllDrivers(@QueryMap(encoded=true) GetAllDriversQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllDrivers</code> that receives the query parameters as a map,
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
          *   <li>licenseClassContains -  (optional)</li>
          *   <li>licenseClassDoesNotContain -  (optional)</li>
          *   <li>licenseClassEquals -  (optional)</li>
          *   <li>licenseClassNotEquals -  (optional)</li>
          *   <li>licenseClassSpecified -  (optional)</li>
          *   <li>licenseClassIn -  (optional)</li>
          *   <li>licenseClassNotIn -  (optional)</li>
          *   <li>yearsExperienceGreaterThan -  (optional)</li>
          *   <li>yearsExperienceLessThan -  (optional)</li>
          *   <li>yearsExperienceGreaterThanOrEqual -  (optional)</li>
          *   <li>yearsExperienceLessThanOrEqual -  (optional)</li>
          *   <li>yearsExperienceEquals -  (optional)</li>
          *   <li>yearsExperienceNotEquals -  (optional)</li>
          *   <li>yearsExperienceSpecified -  (optional)</li>
          *   <li>yearsExperienceIn -  (optional)</li>
          *   <li>yearsExperienceNotIn -  (optional)</li>
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
          *   <li>staffIdGreaterThan -  (optional)</li>
          *   <li>staffIdLessThan -  (optional)</li>
          *   <li>staffIdGreaterThanOrEqual -  (optional)</li>
          *   <li>staffIdLessThanOrEqual -  (optional)</li>
          *   <li>staffIdEquals -  (optional)</li>
          *   <li>staffIdNotEquals -  (optional)</li>
          *   <li>staffIdSpecified -  (optional)</li>
          *   <li>staffIdIn -  (optional)</li>
          *   <li>staffIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return List&lt;DriverDTO&gt;
      */
      @RequestLine("GET /api/drivers?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&licenseClass.contains={licenseClassContains}&licenseClass.doesNotContain={licenseClassDoesNotContain}&licenseClass.equals={licenseClassEquals}&licenseClass.notEquals={licenseClassNotEquals}&licenseClass.specified={licenseClassSpecified}&licenseClass.in={licenseClassIn}&licenseClass.notIn={licenseClassNotIn}&yearsExperience.greaterThan={yearsExperienceGreaterThan}&yearsExperience.lessThan={yearsExperienceLessThan}&yearsExperience.greaterThanOrEqual={yearsExperienceGreaterThanOrEqual}&yearsExperience.lessThanOrEqual={yearsExperienceLessThanOrEqual}&yearsExperience.equals={yearsExperienceEquals}&yearsExperience.notEquals={yearsExperienceNotEquals}&yearsExperience.specified={yearsExperienceSpecified}&yearsExperience.in={yearsExperienceIn}&yearsExperience.notIn={yearsExperienceNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&staffId.greaterThan={staffIdGreaterThan}&staffId.lessThan={staffIdLessThan}&staffId.greaterThanOrEqual={staffIdGreaterThanOrEqual}&staffId.lessThanOrEqual={staffIdLessThanOrEqual}&staffId.equals={staffIdEquals}&staffId.notEquals={staffIdNotEquals}&staffId.specified={staffIdSpecified}&staffId.in={staffIdIn}&staffId.notIn={staffIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<DriverDTO>> getAllDriversWithHttpInfo(@QueryMap(encoded=true) GetAllDriversQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllDrivers</code> method in a fluent style.
   */
  public static class GetAllDriversQueryParams extends HashMap<String, Object> {
    public GetAllDriversQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDriversQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDriversQueryParams licenseClassContains(@jakarta.annotation.Nullable final String value) {
      put("licenseClass.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams licenseClassDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("licenseClass.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams licenseClassEquals(@jakarta.annotation.Nullable final String value) {
      put("licenseClass.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams licenseClassNotEquals(@jakarta.annotation.Nullable final String value) {
      put("licenseClass.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams licenseClassSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("licenseClass.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams licenseClassIn(@jakarta.annotation.Nullable final List<String> value) {
      put("licenseClass.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDriversQueryParams licenseClassNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("licenseClass.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDriversQueryParams yearsExperienceGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("yearsExperience.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams yearsExperienceLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("yearsExperience.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams yearsExperienceGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("yearsExperience.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams yearsExperienceLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("yearsExperience.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams yearsExperienceEquals(@jakarta.annotation.Nullable final Integer value) {
      put("yearsExperience.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams yearsExperienceNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("yearsExperience.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams yearsExperienceSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("yearsExperience.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams yearsExperienceIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("yearsExperience.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDriversQueryParams yearsExperienceNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("yearsExperience.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDriversQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDriversQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDriversQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDriversQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDriversQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDriversQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDriversQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDriversQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDriversQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDriversQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDriversQueryParams staffIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("staffId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams staffIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("staffId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams staffIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("staffId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams staffIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("staffId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams staffIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("staffId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams staffIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("staffId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams staffIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("staffId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDriversQueryParams staffIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("staffId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDriversQueryParams staffIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("staffId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDriversQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @return DriverDTO
   */
  @RequestLine("GET /api/drivers/{id}")
  @Headers({
    "Accept: */*",
  })
  DriverDTO getDriver(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>getDriver</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/drivers/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<DriverDTO> getDriverWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param id  (required)
   * @return SimpleDriverResponseDTO
   */
  @RequestLine("GET /api/drivers/simple/{id}")
  @Headers({
    "Accept: */*",
  })
  SimpleDriverResponseDTO getSimpleDriver(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>getSimpleDriver</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/drivers/simple/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<SimpleDriverResponseDTO> getSimpleDriverWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param id  (required)
   * @param driverDTO  (required)
   * @return DriverDTO
   */
  @RequestLine("PATCH /api/drivers/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  DriverDTO partialUpdateDriver(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull DriverDTO driverDTO);

  /**
   * 
   * Similar to <code>partialUpdateDriver</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param driverDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /api/drivers/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<DriverDTO> partialUpdateDriverWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull DriverDTO driverDTO);



  /**
   * 
   * 
   * @param id  (required)
   * @param driverDTO  (required)
   * @return DriverDTO
   */
  @RequestLine("PUT /api/drivers/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  DriverDTO updateDriver(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull DriverDTO driverDTO);

  /**
   * 
   * Similar to <code>updateDriver</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param driverDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/drivers/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<DriverDTO> updateDriverWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull DriverDTO driverDTO);



  /**
   * 
   * 
   * @param id  (required)
   * @param simpleDriverRequestDTO  (required)
   * @return SimpleDriverResponseDTO
   */
  @RequestLine("PUT /api/drivers/simple/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  SimpleDriverResponseDTO updateSimpleDriver(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull SimpleDriverRequestDTO simpleDriverRequestDTO);

  /**
   * 
   * Similar to <code>updateSimpleDriver</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param simpleDriverRequestDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/drivers/simple/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<SimpleDriverResponseDTO> updateSimpleDriverWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull SimpleDriverRequestDTO simpleDriverRequestDTO);


}
