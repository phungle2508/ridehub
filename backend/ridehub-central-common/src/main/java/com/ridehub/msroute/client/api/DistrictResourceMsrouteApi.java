package com.ridehub.msroute.client.api;

import com.ridehub.msroute.client.invoker.ApiClient;
import com.ridehub.msroute.client.invoker.EncodingUtils;
import com.ridehub.msroute.client.model.ApiResponse;

import com.ridehub.msroute.client.model.DistrictDTO;
import java.time.OffsetDateTime;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface DistrictResourceMsrouteApi extends ApiClient.Api {


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
   * @param districtCodeContains  (optional)
   * @param districtCodeDoesNotContain  (optional)
   * @param districtCodeEquals  (optional)
   * @param districtCodeNotEquals  (optional)
   * @param districtCodeSpecified  (optional)
   * @param districtCodeIn  (optional)
   * @param districtCodeNotIn  (optional)
   * @param nameContains  (optional)
   * @param nameDoesNotContain  (optional)
   * @param nameEquals  (optional)
   * @param nameNotEquals  (optional)
   * @param nameSpecified  (optional)
   * @param nameIn  (optional)
   * @param nameNotIn  (optional)
   * @param nameEnContains  (optional)
   * @param nameEnDoesNotContain  (optional)
   * @param nameEnEquals  (optional)
   * @param nameEnNotEquals  (optional)
   * @param nameEnSpecified  (optional)
   * @param nameEnIn  (optional)
   * @param nameEnNotIn  (optional)
   * @param fullNameContains  (optional)
   * @param fullNameDoesNotContain  (optional)
   * @param fullNameEquals  (optional)
   * @param fullNameNotEquals  (optional)
   * @param fullNameSpecified  (optional)
   * @param fullNameIn  (optional)
   * @param fullNameNotIn  (optional)
   * @param fullNameEnContains  (optional)
   * @param fullNameEnDoesNotContain  (optional)
   * @param fullNameEnEquals  (optional)
   * @param fullNameEnNotEquals  (optional)
   * @param fullNameEnSpecified  (optional)
   * @param fullNameEnIn  (optional)
   * @param fullNameEnNotIn  (optional)
   * @param codeNameContains  (optional)
   * @param codeNameDoesNotContain  (optional)
   * @param codeNameEquals  (optional)
   * @param codeNameNotEquals  (optional)
   * @param codeNameSpecified  (optional)
   * @param codeNameIn  (optional)
   * @param codeNameNotIn  (optional)
   * @param administrativeUnitIdGreaterThan  (optional)
   * @param administrativeUnitIdLessThan  (optional)
   * @param administrativeUnitIdGreaterThanOrEqual  (optional)
   * @param administrativeUnitIdLessThanOrEqual  (optional)
   * @param administrativeUnitIdEquals  (optional)
   * @param administrativeUnitIdNotEquals  (optional)
   * @param administrativeUnitIdSpecified  (optional)
   * @param administrativeUnitIdIn  (optional)
   * @param administrativeUnitIdNotIn  (optional)
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
   * @param wardsIdGreaterThan  (optional)
   * @param wardsIdLessThan  (optional)
   * @param wardsIdGreaterThanOrEqual  (optional)
   * @param wardsIdLessThanOrEqual  (optional)
   * @param wardsIdEquals  (optional)
   * @param wardsIdNotEquals  (optional)
   * @param wardsIdSpecified  (optional)
   * @param wardsIdIn  (optional)
   * @param wardsIdNotIn  (optional)
   * @param provinceIdGreaterThan  (optional)
   * @param provinceIdLessThan  (optional)
   * @param provinceIdGreaterThanOrEqual  (optional)
   * @param provinceIdLessThanOrEqual  (optional)
   * @param provinceIdEquals  (optional)
   * @param provinceIdNotEquals  (optional)
   * @param provinceIdSpecified  (optional)
   * @param provinceIdIn  (optional)
   * @param provinceIdNotIn  (optional)
   * @param distinct  (optional)
   * @return Long
   */
  @RequestLine("GET /api/districts/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&districtCode.contains={districtCodeContains}&districtCode.doesNotContain={districtCodeDoesNotContain}&districtCode.equals={districtCodeEquals}&districtCode.notEquals={districtCodeNotEquals}&districtCode.specified={districtCodeSpecified}&districtCode.in={districtCodeIn}&districtCode.notIn={districtCodeNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&nameEn.contains={nameEnContains}&nameEn.doesNotContain={nameEnDoesNotContain}&nameEn.equals={nameEnEquals}&nameEn.notEquals={nameEnNotEquals}&nameEn.specified={nameEnSpecified}&nameEn.in={nameEnIn}&nameEn.notIn={nameEnNotIn}&fullName.contains={fullNameContains}&fullName.doesNotContain={fullNameDoesNotContain}&fullName.equals={fullNameEquals}&fullName.notEquals={fullNameNotEquals}&fullName.specified={fullNameSpecified}&fullName.in={fullNameIn}&fullName.notIn={fullNameNotIn}&fullNameEn.contains={fullNameEnContains}&fullNameEn.doesNotContain={fullNameEnDoesNotContain}&fullNameEn.equals={fullNameEnEquals}&fullNameEn.notEquals={fullNameEnNotEquals}&fullNameEn.specified={fullNameEnSpecified}&fullNameEn.in={fullNameEnIn}&fullNameEn.notIn={fullNameEnNotIn}&codeName.contains={codeNameContains}&codeName.doesNotContain={codeNameDoesNotContain}&codeName.equals={codeNameEquals}&codeName.notEquals={codeNameNotEquals}&codeName.specified={codeNameSpecified}&codeName.in={codeNameIn}&codeName.notIn={codeNameNotIn}&administrativeUnitId.greaterThan={administrativeUnitIdGreaterThan}&administrativeUnitId.lessThan={administrativeUnitIdLessThan}&administrativeUnitId.greaterThanOrEqual={administrativeUnitIdGreaterThanOrEqual}&administrativeUnitId.lessThanOrEqual={administrativeUnitIdLessThanOrEqual}&administrativeUnitId.equals={administrativeUnitIdEquals}&administrativeUnitId.notEquals={administrativeUnitIdNotEquals}&administrativeUnitId.specified={administrativeUnitIdSpecified}&administrativeUnitId.in={administrativeUnitIdIn}&administrativeUnitId.notIn={administrativeUnitIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&wardsId.greaterThan={wardsIdGreaterThan}&wardsId.lessThan={wardsIdLessThan}&wardsId.greaterThanOrEqual={wardsIdGreaterThanOrEqual}&wardsId.lessThanOrEqual={wardsIdLessThanOrEqual}&wardsId.equals={wardsIdEquals}&wardsId.notEquals={wardsIdNotEquals}&wardsId.specified={wardsIdSpecified}&wardsId.in={wardsIdIn}&wardsId.notIn={wardsIdNotIn}&provinceId.greaterThan={provinceIdGreaterThan}&provinceId.lessThan={provinceIdLessThan}&provinceId.greaterThanOrEqual={provinceIdGreaterThanOrEqual}&provinceId.lessThanOrEqual={provinceIdLessThanOrEqual}&provinceId.equals={provinceIdEquals}&provinceId.notEquals={provinceIdNotEquals}&provinceId.specified={provinceIdSpecified}&provinceId.in={provinceIdIn}&provinceId.notIn={provinceIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  Long countDistricts(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("districtCodeContains") @jakarta.annotation.Nullable String districtCodeContains, @Param("districtCodeDoesNotContain") @jakarta.annotation.Nullable String districtCodeDoesNotContain, @Param("districtCodeEquals") @jakarta.annotation.Nullable String districtCodeEquals, @Param("districtCodeNotEquals") @jakarta.annotation.Nullable String districtCodeNotEquals, @Param("districtCodeSpecified") @jakarta.annotation.Nullable Boolean districtCodeSpecified, @Param("districtCodeIn") @jakarta.annotation.Nullable List<String> districtCodeIn, @Param("districtCodeNotIn") @jakarta.annotation.Nullable List<String> districtCodeNotIn, @Param("nameContains") @jakarta.annotation.Nullable String nameContains, @Param("nameDoesNotContain") @jakarta.annotation.Nullable String nameDoesNotContain, @Param("nameEquals") @jakarta.annotation.Nullable String nameEquals, @Param("nameNotEquals") @jakarta.annotation.Nullable String nameNotEquals, @Param("nameSpecified") @jakarta.annotation.Nullable Boolean nameSpecified, @Param("nameIn") @jakarta.annotation.Nullable List<String> nameIn, @Param("nameNotIn") @jakarta.annotation.Nullable List<String> nameNotIn, @Param("nameEnContains") @jakarta.annotation.Nullable String nameEnContains, @Param("nameEnDoesNotContain") @jakarta.annotation.Nullable String nameEnDoesNotContain, @Param("nameEnEquals") @jakarta.annotation.Nullable String nameEnEquals, @Param("nameEnNotEquals") @jakarta.annotation.Nullable String nameEnNotEquals, @Param("nameEnSpecified") @jakarta.annotation.Nullable Boolean nameEnSpecified, @Param("nameEnIn") @jakarta.annotation.Nullable List<String> nameEnIn, @Param("nameEnNotIn") @jakarta.annotation.Nullable List<String> nameEnNotIn, @Param("fullNameContains") @jakarta.annotation.Nullable String fullNameContains, @Param("fullNameDoesNotContain") @jakarta.annotation.Nullable String fullNameDoesNotContain, @Param("fullNameEquals") @jakarta.annotation.Nullable String fullNameEquals, @Param("fullNameNotEquals") @jakarta.annotation.Nullable String fullNameNotEquals, @Param("fullNameSpecified") @jakarta.annotation.Nullable Boolean fullNameSpecified, @Param("fullNameIn") @jakarta.annotation.Nullable List<String> fullNameIn, @Param("fullNameNotIn") @jakarta.annotation.Nullable List<String> fullNameNotIn, @Param("fullNameEnContains") @jakarta.annotation.Nullable String fullNameEnContains, @Param("fullNameEnDoesNotContain") @jakarta.annotation.Nullable String fullNameEnDoesNotContain, @Param("fullNameEnEquals") @jakarta.annotation.Nullable String fullNameEnEquals, @Param("fullNameEnNotEquals") @jakarta.annotation.Nullable String fullNameEnNotEquals, @Param("fullNameEnSpecified") @jakarta.annotation.Nullable Boolean fullNameEnSpecified, @Param("fullNameEnIn") @jakarta.annotation.Nullable List<String> fullNameEnIn, @Param("fullNameEnNotIn") @jakarta.annotation.Nullable List<String> fullNameEnNotIn, @Param("codeNameContains") @jakarta.annotation.Nullable String codeNameContains, @Param("codeNameDoesNotContain") @jakarta.annotation.Nullable String codeNameDoesNotContain, @Param("codeNameEquals") @jakarta.annotation.Nullable String codeNameEquals, @Param("codeNameNotEquals") @jakarta.annotation.Nullable String codeNameNotEquals, @Param("codeNameSpecified") @jakarta.annotation.Nullable Boolean codeNameSpecified, @Param("codeNameIn") @jakarta.annotation.Nullable List<String> codeNameIn, @Param("codeNameNotIn") @jakarta.annotation.Nullable List<String> codeNameNotIn, @Param("administrativeUnitIdGreaterThan") @jakarta.annotation.Nullable Integer administrativeUnitIdGreaterThan, @Param("administrativeUnitIdLessThan") @jakarta.annotation.Nullable Integer administrativeUnitIdLessThan, @Param("administrativeUnitIdGreaterThanOrEqual") @jakarta.annotation.Nullable Integer administrativeUnitIdGreaterThanOrEqual, @Param("administrativeUnitIdLessThanOrEqual") @jakarta.annotation.Nullable Integer administrativeUnitIdLessThanOrEqual, @Param("administrativeUnitIdEquals") @jakarta.annotation.Nullable Integer administrativeUnitIdEquals, @Param("administrativeUnitIdNotEquals") @jakarta.annotation.Nullable Integer administrativeUnitIdNotEquals, @Param("administrativeUnitIdSpecified") @jakarta.annotation.Nullable Boolean administrativeUnitIdSpecified, @Param("administrativeUnitIdIn") @jakarta.annotation.Nullable List<Integer> administrativeUnitIdIn, @Param("administrativeUnitIdNotIn") @jakarta.annotation.Nullable List<Integer> administrativeUnitIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("wardsIdGreaterThan") @jakarta.annotation.Nullable Long wardsIdGreaterThan, @Param("wardsIdLessThan") @jakarta.annotation.Nullable Long wardsIdLessThan, @Param("wardsIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long wardsIdGreaterThanOrEqual, @Param("wardsIdLessThanOrEqual") @jakarta.annotation.Nullable Long wardsIdLessThanOrEqual, @Param("wardsIdEquals") @jakarta.annotation.Nullable Long wardsIdEquals, @Param("wardsIdNotEquals") @jakarta.annotation.Nullable Long wardsIdNotEquals, @Param("wardsIdSpecified") @jakarta.annotation.Nullable Boolean wardsIdSpecified, @Param("wardsIdIn") @jakarta.annotation.Nullable List<Long> wardsIdIn, @Param("wardsIdNotIn") @jakarta.annotation.Nullable List<Long> wardsIdNotIn, @Param("provinceIdGreaterThan") @jakarta.annotation.Nullable Long provinceIdGreaterThan, @Param("provinceIdLessThan") @jakarta.annotation.Nullable Long provinceIdLessThan, @Param("provinceIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long provinceIdGreaterThanOrEqual, @Param("provinceIdLessThanOrEqual") @jakarta.annotation.Nullable Long provinceIdLessThanOrEqual, @Param("provinceIdEquals") @jakarta.annotation.Nullable Long provinceIdEquals, @Param("provinceIdNotEquals") @jakarta.annotation.Nullable Long provinceIdNotEquals, @Param("provinceIdSpecified") @jakarta.annotation.Nullable Boolean provinceIdSpecified, @Param("provinceIdIn") @jakarta.annotation.Nullable List<Long> provinceIdIn, @Param("provinceIdNotIn") @jakarta.annotation.Nullable List<Long> provinceIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>countDistricts</code> but it also returns the http response headers .
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
   * @param districtCodeContains  (optional)
   * @param districtCodeDoesNotContain  (optional)
   * @param districtCodeEquals  (optional)
   * @param districtCodeNotEquals  (optional)
   * @param districtCodeSpecified  (optional)
   * @param districtCodeIn  (optional)
   * @param districtCodeNotIn  (optional)
   * @param nameContains  (optional)
   * @param nameDoesNotContain  (optional)
   * @param nameEquals  (optional)
   * @param nameNotEquals  (optional)
   * @param nameSpecified  (optional)
   * @param nameIn  (optional)
   * @param nameNotIn  (optional)
   * @param nameEnContains  (optional)
   * @param nameEnDoesNotContain  (optional)
   * @param nameEnEquals  (optional)
   * @param nameEnNotEquals  (optional)
   * @param nameEnSpecified  (optional)
   * @param nameEnIn  (optional)
   * @param nameEnNotIn  (optional)
   * @param fullNameContains  (optional)
   * @param fullNameDoesNotContain  (optional)
   * @param fullNameEquals  (optional)
   * @param fullNameNotEquals  (optional)
   * @param fullNameSpecified  (optional)
   * @param fullNameIn  (optional)
   * @param fullNameNotIn  (optional)
   * @param fullNameEnContains  (optional)
   * @param fullNameEnDoesNotContain  (optional)
   * @param fullNameEnEquals  (optional)
   * @param fullNameEnNotEquals  (optional)
   * @param fullNameEnSpecified  (optional)
   * @param fullNameEnIn  (optional)
   * @param fullNameEnNotIn  (optional)
   * @param codeNameContains  (optional)
   * @param codeNameDoesNotContain  (optional)
   * @param codeNameEquals  (optional)
   * @param codeNameNotEquals  (optional)
   * @param codeNameSpecified  (optional)
   * @param codeNameIn  (optional)
   * @param codeNameNotIn  (optional)
   * @param administrativeUnitIdGreaterThan  (optional)
   * @param administrativeUnitIdLessThan  (optional)
   * @param administrativeUnitIdGreaterThanOrEqual  (optional)
   * @param administrativeUnitIdLessThanOrEqual  (optional)
   * @param administrativeUnitIdEquals  (optional)
   * @param administrativeUnitIdNotEquals  (optional)
   * @param administrativeUnitIdSpecified  (optional)
   * @param administrativeUnitIdIn  (optional)
   * @param administrativeUnitIdNotIn  (optional)
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
   * @param wardsIdGreaterThan  (optional)
   * @param wardsIdLessThan  (optional)
   * @param wardsIdGreaterThanOrEqual  (optional)
   * @param wardsIdLessThanOrEqual  (optional)
   * @param wardsIdEquals  (optional)
   * @param wardsIdNotEquals  (optional)
   * @param wardsIdSpecified  (optional)
   * @param wardsIdIn  (optional)
   * @param wardsIdNotIn  (optional)
   * @param provinceIdGreaterThan  (optional)
   * @param provinceIdLessThan  (optional)
   * @param provinceIdGreaterThanOrEqual  (optional)
   * @param provinceIdLessThanOrEqual  (optional)
   * @param provinceIdEquals  (optional)
   * @param provinceIdNotEquals  (optional)
   * @param provinceIdSpecified  (optional)
   * @param provinceIdIn  (optional)
   * @param provinceIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/districts/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&districtCode.contains={districtCodeContains}&districtCode.doesNotContain={districtCodeDoesNotContain}&districtCode.equals={districtCodeEquals}&districtCode.notEquals={districtCodeNotEquals}&districtCode.specified={districtCodeSpecified}&districtCode.in={districtCodeIn}&districtCode.notIn={districtCodeNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&nameEn.contains={nameEnContains}&nameEn.doesNotContain={nameEnDoesNotContain}&nameEn.equals={nameEnEquals}&nameEn.notEquals={nameEnNotEquals}&nameEn.specified={nameEnSpecified}&nameEn.in={nameEnIn}&nameEn.notIn={nameEnNotIn}&fullName.contains={fullNameContains}&fullName.doesNotContain={fullNameDoesNotContain}&fullName.equals={fullNameEquals}&fullName.notEquals={fullNameNotEquals}&fullName.specified={fullNameSpecified}&fullName.in={fullNameIn}&fullName.notIn={fullNameNotIn}&fullNameEn.contains={fullNameEnContains}&fullNameEn.doesNotContain={fullNameEnDoesNotContain}&fullNameEn.equals={fullNameEnEquals}&fullNameEn.notEquals={fullNameEnNotEquals}&fullNameEn.specified={fullNameEnSpecified}&fullNameEn.in={fullNameEnIn}&fullNameEn.notIn={fullNameEnNotIn}&codeName.contains={codeNameContains}&codeName.doesNotContain={codeNameDoesNotContain}&codeName.equals={codeNameEquals}&codeName.notEquals={codeNameNotEquals}&codeName.specified={codeNameSpecified}&codeName.in={codeNameIn}&codeName.notIn={codeNameNotIn}&administrativeUnitId.greaterThan={administrativeUnitIdGreaterThan}&administrativeUnitId.lessThan={administrativeUnitIdLessThan}&administrativeUnitId.greaterThanOrEqual={administrativeUnitIdGreaterThanOrEqual}&administrativeUnitId.lessThanOrEqual={administrativeUnitIdLessThanOrEqual}&administrativeUnitId.equals={administrativeUnitIdEquals}&administrativeUnitId.notEquals={administrativeUnitIdNotEquals}&administrativeUnitId.specified={administrativeUnitIdSpecified}&administrativeUnitId.in={administrativeUnitIdIn}&administrativeUnitId.notIn={administrativeUnitIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&wardsId.greaterThan={wardsIdGreaterThan}&wardsId.lessThan={wardsIdLessThan}&wardsId.greaterThanOrEqual={wardsIdGreaterThanOrEqual}&wardsId.lessThanOrEqual={wardsIdLessThanOrEqual}&wardsId.equals={wardsIdEquals}&wardsId.notEquals={wardsIdNotEquals}&wardsId.specified={wardsIdSpecified}&wardsId.in={wardsIdIn}&wardsId.notIn={wardsIdNotIn}&provinceId.greaterThan={provinceIdGreaterThan}&provinceId.lessThan={provinceIdLessThan}&provinceId.greaterThanOrEqual={provinceIdGreaterThanOrEqual}&provinceId.lessThanOrEqual={provinceIdLessThanOrEqual}&provinceId.equals={provinceIdEquals}&provinceId.notEquals={provinceIdNotEquals}&provinceId.specified={provinceIdSpecified}&provinceId.in={provinceIdIn}&provinceId.notIn={provinceIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Long> countDistrictsWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("districtCodeContains") @jakarta.annotation.Nullable String districtCodeContains, @Param("districtCodeDoesNotContain") @jakarta.annotation.Nullable String districtCodeDoesNotContain, @Param("districtCodeEquals") @jakarta.annotation.Nullable String districtCodeEquals, @Param("districtCodeNotEquals") @jakarta.annotation.Nullable String districtCodeNotEquals, @Param("districtCodeSpecified") @jakarta.annotation.Nullable Boolean districtCodeSpecified, @Param("districtCodeIn") @jakarta.annotation.Nullable List<String> districtCodeIn, @Param("districtCodeNotIn") @jakarta.annotation.Nullable List<String> districtCodeNotIn, @Param("nameContains") @jakarta.annotation.Nullable String nameContains, @Param("nameDoesNotContain") @jakarta.annotation.Nullable String nameDoesNotContain, @Param("nameEquals") @jakarta.annotation.Nullable String nameEquals, @Param("nameNotEquals") @jakarta.annotation.Nullable String nameNotEquals, @Param("nameSpecified") @jakarta.annotation.Nullable Boolean nameSpecified, @Param("nameIn") @jakarta.annotation.Nullable List<String> nameIn, @Param("nameNotIn") @jakarta.annotation.Nullable List<String> nameNotIn, @Param("nameEnContains") @jakarta.annotation.Nullable String nameEnContains, @Param("nameEnDoesNotContain") @jakarta.annotation.Nullable String nameEnDoesNotContain, @Param("nameEnEquals") @jakarta.annotation.Nullable String nameEnEquals, @Param("nameEnNotEquals") @jakarta.annotation.Nullable String nameEnNotEquals, @Param("nameEnSpecified") @jakarta.annotation.Nullable Boolean nameEnSpecified, @Param("nameEnIn") @jakarta.annotation.Nullable List<String> nameEnIn, @Param("nameEnNotIn") @jakarta.annotation.Nullable List<String> nameEnNotIn, @Param("fullNameContains") @jakarta.annotation.Nullable String fullNameContains, @Param("fullNameDoesNotContain") @jakarta.annotation.Nullable String fullNameDoesNotContain, @Param("fullNameEquals") @jakarta.annotation.Nullable String fullNameEquals, @Param("fullNameNotEquals") @jakarta.annotation.Nullable String fullNameNotEquals, @Param("fullNameSpecified") @jakarta.annotation.Nullable Boolean fullNameSpecified, @Param("fullNameIn") @jakarta.annotation.Nullable List<String> fullNameIn, @Param("fullNameNotIn") @jakarta.annotation.Nullable List<String> fullNameNotIn, @Param("fullNameEnContains") @jakarta.annotation.Nullable String fullNameEnContains, @Param("fullNameEnDoesNotContain") @jakarta.annotation.Nullable String fullNameEnDoesNotContain, @Param("fullNameEnEquals") @jakarta.annotation.Nullable String fullNameEnEquals, @Param("fullNameEnNotEquals") @jakarta.annotation.Nullable String fullNameEnNotEquals, @Param("fullNameEnSpecified") @jakarta.annotation.Nullable Boolean fullNameEnSpecified, @Param("fullNameEnIn") @jakarta.annotation.Nullable List<String> fullNameEnIn, @Param("fullNameEnNotIn") @jakarta.annotation.Nullable List<String> fullNameEnNotIn, @Param("codeNameContains") @jakarta.annotation.Nullable String codeNameContains, @Param("codeNameDoesNotContain") @jakarta.annotation.Nullable String codeNameDoesNotContain, @Param("codeNameEquals") @jakarta.annotation.Nullable String codeNameEquals, @Param("codeNameNotEquals") @jakarta.annotation.Nullable String codeNameNotEquals, @Param("codeNameSpecified") @jakarta.annotation.Nullable Boolean codeNameSpecified, @Param("codeNameIn") @jakarta.annotation.Nullable List<String> codeNameIn, @Param("codeNameNotIn") @jakarta.annotation.Nullable List<String> codeNameNotIn, @Param("administrativeUnitIdGreaterThan") @jakarta.annotation.Nullable Integer administrativeUnitIdGreaterThan, @Param("administrativeUnitIdLessThan") @jakarta.annotation.Nullable Integer administrativeUnitIdLessThan, @Param("administrativeUnitIdGreaterThanOrEqual") @jakarta.annotation.Nullable Integer administrativeUnitIdGreaterThanOrEqual, @Param("administrativeUnitIdLessThanOrEqual") @jakarta.annotation.Nullable Integer administrativeUnitIdLessThanOrEqual, @Param("administrativeUnitIdEquals") @jakarta.annotation.Nullable Integer administrativeUnitIdEquals, @Param("administrativeUnitIdNotEquals") @jakarta.annotation.Nullable Integer administrativeUnitIdNotEquals, @Param("administrativeUnitIdSpecified") @jakarta.annotation.Nullable Boolean administrativeUnitIdSpecified, @Param("administrativeUnitIdIn") @jakarta.annotation.Nullable List<Integer> administrativeUnitIdIn, @Param("administrativeUnitIdNotIn") @jakarta.annotation.Nullable List<Integer> administrativeUnitIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("wardsIdGreaterThan") @jakarta.annotation.Nullable Long wardsIdGreaterThan, @Param("wardsIdLessThan") @jakarta.annotation.Nullable Long wardsIdLessThan, @Param("wardsIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long wardsIdGreaterThanOrEqual, @Param("wardsIdLessThanOrEqual") @jakarta.annotation.Nullable Long wardsIdLessThanOrEqual, @Param("wardsIdEquals") @jakarta.annotation.Nullable Long wardsIdEquals, @Param("wardsIdNotEquals") @jakarta.annotation.Nullable Long wardsIdNotEquals, @Param("wardsIdSpecified") @jakarta.annotation.Nullable Boolean wardsIdSpecified, @Param("wardsIdIn") @jakarta.annotation.Nullable List<Long> wardsIdIn, @Param("wardsIdNotIn") @jakarta.annotation.Nullable List<Long> wardsIdNotIn, @Param("provinceIdGreaterThan") @jakarta.annotation.Nullable Long provinceIdGreaterThan, @Param("provinceIdLessThan") @jakarta.annotation.Nullable Long provinceIdLessThan, @Param("provinceIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long provinceIdGreaterThanOrEqual, @Param("provinceIdLessThanOrEqual") @jakarta.annotation.Nullable Long provinceIdLessThanOrEqual, @Param("provinceIdEquals") @jakarta.annotation.Nullable Long provinceIdEquals, @Param("provinceIdNotEquals") @jakarta.annotation.Nullable Long provinceIdNotEquals, @Param("provinceIdSpecified") @jakarta.annotation.Nullable Boolean provinceIdSpecified, @Param("provinceIdIn") @jakarta.annotation.Nullable List<Long> provinceIdIn, @Param("provinceIdNotIn") @jakarta.annotation.Nullable List<Long> provinceIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>countDistricts</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CountDistrictsQueryParams} class that allows for
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
   *   <li>districtCodeContains -  (optional)</li>
   *   <li>districtCodeDoesNotContain -  (optional)</li>
   *   <li>districtCodeEquals -  (optional)</li>
   *   <li>districtCodeNotEquals -  (optional)</li>
   *   <li>districtCodeSpecified -  (optional)</li>
   *   <li>districtCodeIn -  (optional)</li>
   *   <li>districtCodeNotIn -  (optional)</li>
   *   <li>nameContains -  (optional)</li>
   *   <li>nameDoesNotContain -  (optional)</li>
   *   <li>nameEquals -  (optional)</li>
   *   <li>nameNotEquals -  (optional)</li>
   *   <li>nameSpecified -  (optional)</li>
   *   <li>nameIn -  (optional)</li>
   *   <li>nameNotIn -  (optional)</li>
   *   <li>nameEnContains -  (optional)</li>
   *   <li>nameEnDoesNotContain -  (optional)</li>
   *   <li>nameEnEquals -  (optional)</li>
   *   <li>nameEnNotEquals -  (optional)</li>
   *   <li>nameEnSpecified -  (optional)</li>
   *   <li>nameEnIn -  (optional)</li>
   *   <li>nameEnNotIn -  (optional)</li>
   *   <li>fullNameContains -  (optional)</li>
   *   <li>fullNameDoesNotContain -  (optional)</li>
   *   <li>fullNameEquals -  (optional)</li>
   *   <li>fullNameNotEquals -  (optional)</li>
   *   <li>fullNameSpecified -  (optional)</li>
   *   <li>fullNameIn -  (optional)</li>
   *   <li>fullNameNotIn -  (optional)</li>
   *   <li>fullNameEnContains -  (optional)</li>
   *   <li>fullNameEnDoesNotContain -  (optional)</li>
   *   <li>fullNameEnEquals -  (optional)</li>
   *   <li>fullNameEnNotEquals -  (optional)</li>
   *   <li>fullNameEnSpecified -  (optional)</li>
   *   <li>fullNameEnIn -  (optional)</li>
   *   <li>fullNameEnNotIn -  (optional)</li>
   *   <li>codeNameContains -  (optional)</li>
   *   <li>codeNameDoesNotContain -  (optional)</li>
   *   <li>codeNameEquals -  (optional)</li>
   *   <li>codeNameNotEquals -  (optional)</li>
   *   <li>codeNameSpecified -  (optional)</li>
   *   <li>codeNameIn -  (optional)</li>
   *   <li>codeNameNotIn -  (optional)</li>
   *   <li>administrativeUnitIdGreaterThan -  (optional)</li>
   *   <li>administrativeUnitIdLessThan -  (optional)</li>
   *   <li>administrativeUnitIdGreaterThanOrEqual -  (optional)</li>
   *   <li>administrativeUnitIdLessThanOrEqual -  (optional)</li>
   *   <li>administrativeUnitIdEquals -  (optional)</li>
   *   <li>administrativeUnitIdNotEquals -  (optional)</li>
   *   <li>administrativeUnitIdSpecified -  (optional)</li>
   *   <li>administrativeUnitIdIn -  (optional)</li>
   *   <li>administrativeUnitIdNotIn -  (optional)</li>
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
   *   <li>wardsIdGreaterThan -  (optional)</li>
   *   <li>wardsIdLessThan -  (optional)</li>
   *   <li>wardsIdGreaterThanOrEqual -  (optional)</li>
   *   <li>wardsIdLessThanOrEqual -  (optional)</li>
   *   <li>wardsIdEquals -  (optional)</li>
   *   <li>wardsIdNotEquals -  (optional)</li>
   *   <li>wardsIdSpecified -  (optional)</li>
   *   <li>wardsIdIn -  (optional)</li>
   *   <li>wardsIdNotIn -  (optional)</li>
   *   <li>provinceIdGreaterThan -  (optional)</li>
   *   <li>provinceIdLessThan -  (optional)</li>
   *   <li>provinceIdGreaterThanOrEqual -  (optional)</li>
   *   <li>provinceIdLessThanOrEqual -  (optional)</li>
   *   <li>provinceIdEquals -  (optional)</li>
   *   <li>provinceIdNotEquals -  (optional)</li>
   *   <li>provinceIdSpecified -  (optional)</li>
   *   <li>provinceIdIn -  (optional)</li>
   *   <li>provinceIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return Long
   */
  @RequestLine("GET /api/districts/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&districtCode.contains={districtCodeContains}&districtCode.doesNotContain={districtCodeDoesNotContain}&districtCode.equals={districtCodeEquals}&districtCode.notEquals={districtCodeNotEquals}&districtCode.specified={districtCodeSpecified}&districtCode.in={districtCodeIn}&districtCode.notIn={districtCodeNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&nameEn.contains={nameEnContains}&nameEn.doesNotContain={nameEnDoesNotContain}&nameEn.equals={nameEnEquals}&nameEn.notEquals={nameEnNotEquals}&nameEn.specified={nameEnSpecified}&nameEn.in={nameEnIn}&nameEn.notIn={nameEnNotIn}&fullName.contains={fullNameContains}&fullName.doesNotContain={fullNameDoesNotContain}&fullName.equals={fullNameEquals}&fullName.notEquals={fullNameNotEquals}&fullName.specified={fullNameSpecified}&fullName.in={fullNameIn}&fullName.notIn={fullNameNotIn}&fullNameEn.contains={fullNameEnContains}&fullNameEn.doesNotContain={fullNameEnDoesNotContain}&fullNameEn.equals={fullNameEnEquals}&fullNameEn.notEquals={fullNameEnNotEquals}&fullNameEn.specified={fullNameEnSpecified}&fullNameEn.in={fullNameEnIn}&fullNameEn.notIn={fullNameEnNotIn}&codeName.contains={codeNameContains}&codeName.doesNotContain={codeNameDoesNotContain}&codeName.equals={codeNameEquals}&codeName.notEquals={codeNameNotEquals}&codeName.specified={codeNameSpecified}&codeName.in={codeNameIn}&codeName.notIn={codeNameNotIn}&administrativeUnitId.greaterThan={administrativeUnitIdGreaterThan}&administrativeUnitId.lessThan={administrativeUnitIdLessThan}&administrativeUnitId.greaterThanOrEqual={administrativeUnitIdGreaterThanOrEqual}&administrativeUnitId.lessThanOrEqual={administrativeUnitIdLessThanOrEqual}&administrativeUnitId.equals={administrativeUnitIdEquals}&administrativeUnitId.notEquals={administrativeUnitIdNotEquals}&administrativeUnitId.specified={administrativeUnitIdSpecified}&administrativeUnitId.in={administrativeUnitIdIn}&administrativeUnitId.notIn={administrativeUnitIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&wardsId.greaterThan={wardsIdGreaterThan}&wardsId.lessThan={wardsIdLessThan}&wardsId.greaterThanOrEqual={wardsIdGreaterThanOrEqual}&wardsId.lessThanOrEqual={wardsIdLessThanOrEqual}&wardsId.equals={wardsIdEquals}&wardsId.notEquals={wardsIdNotEquals}&wardsId.specified={wardsIdSpecified}&wardsId.in={wardsIdIn}&wardsId.notIn={wardsIdNotIn}&provinceId.greaterThan={provinceIdGreaterThan}&provinceId.lessThan={provinceIdLessThan}&provinceId.greaterThanOrEqual={provinceIdGreaterThanOrEqual}&provinceId.lessThanOrEqual={provinceIdLessThanOrEqual}&provinceId.equals={provinceIdEquals}&provinceId.notEquals={provinceIdNotEquals}&provinceId.specified={provinceIdSpecified}&provinceId.in={provinceIdIn}&provinceId.notIn={provinceIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  Long countDistricts(@QueryMap(encoded=true) CountDistrictsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>countDistricts</code> that receives the query parameters as a map,
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
          *   <li>districtCodeContains -  (optional)</li>
          *   <li>districtCodeDoesNotContain -  (optional)</li>
          *   <li>districtCodeEquals -  (optional)</li>
          *   <li>districtCodeNotEquals -  (optional)</li>
          *   <li>districtCodeSpecified -  (optional)</li>
          *   <li>districtCodeIn -  (optional)</li>
          *   <li>districtCodeNotIn -  (optional)</li>
          *   <li>nameContains -  (optional)</li>
          *   <li>nameDoesNotContain -  (optional)</li>
          *   <li>nameEquals -  (optional)</li>
          *   <li>nameNotEquals -  (optional)</li>
          *   <li>nameSpecified -  (optional)</li>
          *   <li>nameIn -  (optional)</li>
          *   <li>nameNotIn -  (optional)</li>
          *   <li>nameEnContains -  (optional)</li>
          *   <li>nameEnDoesNotContain -  (optional)</li>
          *   <li>nameEnEquals -  (optional)</li>
          *   <li>nameEnNotEquals -  (optional)</li>
          *   <li>nameEnSpecified -  (optional)</li>
          *   <li>nameEnIn -  (optional)</li>
          *   <li>nameEnNotIn -  (optional)</li>
          *   <li>fullNameContains -  (optional)</li>
          *   <li>fullNameDoesNotContain -  (optional)</li>
          *   <li>fullNameEquals -  (optional)</li>
          *   <li>fullNameNotEquals -  (optional)</li>
          *   <li>fullNameSpecified -  (optional)</li>
          *   <li>fullNameIn -  (optional)</li>
          *   <li>fullNameNotIn -  (optional)</li>
          *   <li>fullNameEnContains -  (optional)</li>
          *   <li>fullNameEnDoesNotContain -  (optional)</li>
          *   <li>fullNameEnEquals -  (optional)</li>
          *   <li>fullNameEnNotEquals -  (optional)</li>
          *   <li>fullNameEnSpecified -  (optional)</li>
          *   <li>fullNameEnIn -  (optional)</li>
          *   <li>fullNameEnNotIn -  (optional)</li>
          *   <li>codeNameContains -  (optional)</li>
          *   <li>codeNameDoesNotContain -  (optional)</li>
          *   <li>codeNameEquals -  (optional)</li>
          *   <li>codeNameNotEquals -  (optional)</li>
          *   <li>codeNameSpecified -  (optional)</li>
          *   <li>codeNameIn -  (optional)</li>
          *   <li>codeNameNotIn -  (optional)</li>
          *   <li>administrativeUnitIdGreaterThan -  (optional)</li>
          *   <li>administrativeUnitIdLessThan -  (optional)</li>
          *   <li>administrativeUnitIdGreaterThanOrEqual -  (optional)</li>
          *   <li>administrativeUnitIdLessThanOrEqual -  (optional)</li>
          *   <li>administrativeUnitIdEquals -  (optional)</li>
          *   <li>administrativeUnitIdNotEquals -  (optional)</li>
          *   <li>administrativeUnitIdSpecified -  (optional)</li>
          *   <li>administrativeUnitIdIn -  (optional)</li>
          *   <li>administrativeUnitIdNotIn -  (optional)</li>
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
          *   <li>wardsIdGreaterThan -  (optional)</li>
          *   <li>wardsIdLessThan -  (optional)</li>
          *   <li>wardsIdGreaterThanOrEqual -  (optional)</li>
          *   <li>wardsIdLessThanOrEqual -  (optional)</li>
          *   <li>wardsIdEquals -  (optional)</li>
          *   <li>wardsIdNotEquals -  (optional)</li>
          *   <li>wardsIdSpecified -  (optional)</li>
          *   <li>wardsIdIn -  (optional)</li>
          *   <li>wardsIdNotIn -  (optional)</li>
          *   <li>provinceIdGreaterThan -  (optional)</li>
          *   <li>provinceIdLessThan -  (optional)</li>
          *   <li>provinceIdGreaterThanOrEqual -  (optional)</li>
          *   <li>provinceIdLessThanOrEqual -  (optional)</li>
          *   <li>provinceIdEquals -  (optional)</li>
          *   <li>provinceIdNotEquals -  (optional)</li>
          *   <li>provinceIdSpecified -  (optional)</li>
          *   <li>provinceIdIn -  (optional)</li>
          *   <li>provinceIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return Long
      */
      @RequestLine("GET /api/districts/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&districtCode.contains={districtCodeContains}&districtCode.doesNotContain={districtCodeDoesNotContain}&districtCode.equals={districtCodeEquals}&districtCode.notEquals={districtCodeNotEquals}&districtCode.specified={districtCodeSpecified}&districtCode.in={districtCodeIn}&districtCode.notIn={districtCodeNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&nameEn.contains={nameEnContains}&nameEn.doesNotContain={nameEnDoesNotContain}&nameEn.equals={nameEnEquals}&nameEn.notEquals={nameEnNotEquals}&nameEn.specified={nameEnSpecified}&nameEn.in={nameEnIn}&nameEn.notIn={nameEnNotIn}&fullName.contains={fullNameContains}&fullName.doesNotContain={fullNameDoesNotContain}&fullName.equals={fullNameEquals}&fullName.notEquals={fullNameNotEquals}&fullName.specified={fullNameSpecified}&fullName.in={fullNameIn}&fullName.notIn={fullNameNotIn}&fullNameEn.contains={fullNameEnContains}&fullNameEn.doesNotContain={fullNameEnDoesNotContain}&fullNameEn.equals={fullNameEnEquals}&fullNameEn.notEquals={fullNameEnNotEquals}&fullNameEn.specified={fullNameEnSpecified}&fullNameEn.in={fullNameEnIn}&fullNameEn.notIn={fullNameEnNotIn}&codeName.contains={codeNameContains}&codeName.doesNotContain={codeNameDoesNotContain}&codeName.equals={codeNameEquals}&codeName.notEquals={codeNameNotEquals}&codeName.specified={codeNameSpecified}&codeName.in={codeNameIn}&codeName.notIn={codeNameNotIn}&administrativeUnitId.greaterThan={administrativeUnitIdGreaterThan}&administrativeUnitId.lessThan={administrativeUnitIdLessThan}&administrativeUnitId.greaterThanOrEqual={administrativeUnitIdGreaterThanOrEqual}&administrativeUnitId.lessThanOrEqual={administrativeUnitIdLessThanOrEqual}&administrativeUnitId.equals={administrativeUnitIdEquals}&administrativeUnitId.notEquals={administrativeUnitIdNotEquals}&administrativeUnitId.specified={administrativeUnitIdSpecified}&administrativeUnitId.in={administrativeUnitIdIn}&administrativeUnitId.notIn={administrativeUnitIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&wardsId.greaterThan={wardsIdGreaterThan}&wardsId.lessThan={wardsIdLessThan}&wardsId.greaterThanOrEqual={wardsIdGreaterThanOrEqual}&wardsId.lessThanOrEqual={wardsIdLessThanOrEqual}&wardsId.equals={wardsIdEquals}&wardsId.notEquals={wardsIdNotEquals}&wardsId.specified={wardsIdSpecified}&wardsId.in={wardsIdIn}&wardsId.notIn={wardsIdNotIn}&provinceId.greaterThan={provinceIdGreaterThan}&provinceId.lessThan={provinceIdLessThan}&provinceId.greaterThanOrEqual={provinceIdGreaterThanOrEqual}&provinceId.lessThanOrEqual={provinceIdLessThanOrEqual}&provinceId.equals={provinceIdEquals}&provinceId.notEquals={provinceIdNotEquals}&provinceId.specified={provinceIdSpecified}&provinceId.in={provinceIdIn}&provinceId.notIn={provinceIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Long> countDistrictsWithHttpInfo(@QueryMap(encoded=true) CountDistrictsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>countDistricts</code> method in a fluent style.
   */
  public static class CountDistrictsQueryParams extends HashMap<String, Object> {
    public CountDistrictsQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDistrictsQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDistrictsQueryParams districtCodeContains(@jakarta.annotation.Nullable final String value) {
      put("districtCode.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams districtCodeDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("districtCode.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams districtCodeEquals(@jakarta.annotation.Nullable final String value) {
      put("districtCode.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams districtCodeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("districtCode.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams districtCodeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("districtCode.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams districtCodeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("districtCode.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDistrictsQueryParams districtCodeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("districtCode.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDistrictsQueryParams nameContains(@jakarta.annotation.Nullable final String value) {
      put("name.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams nameDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("name.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams nameEquals(@jakarta.annotation.Nullable final String value) {
      put("name.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams nameNotEquals(@jakarta.annotation.Nullable final String value) {
      put("name.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams nameSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("name.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams nameIn(@jakarta.annotation.Nullable final List<String> value) {
      put("name.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDistrictsQueryParams nameNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("name.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDistrictsQueryParams nameEnContains(@jakarta.annotation.Nullable final String value) {
      put("nameEn.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams nameEnDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("nameEn.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams nameEnEquals(@jakarta.annotation.Nullable final String value) {
      put("nameEn.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams nameEnNotEquals(@jakarta.annotation.Nullable final String value) {
      put("nameEn.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams nameEnSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("nameEn.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams nameEnIn(@jakarta.annotation.Nullable final List<String> value) {
      put("nameEn.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDistrictsQueryParams nameEnNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("nameEn.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDistrictsQueryParams fullNameContains(@jakarta.annotation.Nullable final String value) {
      put("fullName.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams fullNameDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("fullName.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams fullNameEquals(@jakarta.annotation.Nullable final String value) {
      put("fullName.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams fullNameNotEquals(@jakarta.annotation.Nullable final String value) {
      put("fullName.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams fullNameSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("fullName.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams fullNameIn(@jakarta.annotation.Nullable final List<String> value) {
      put("fullName.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDistrictsQueryParams fullNameNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("fullName.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDistrictsQueryParams fullNameEnContains(@jakarta.annotation.Nullable final String value) {
      put("fullNameEn.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams fullNameEnDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("fullNameEn.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams fullNameEnEquals(@jakarta.annotation.Nullable final String value) {
      put("fullNameEn.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams fullNameEnNotEquals(@jakarta.annotation.Nullable final String value) {
      put("fullNameEn.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams fullNameEnSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("fullNameEn.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams fullNameEnIn(@jakarta.annotation.Nullable final List<String> value) {
      put("fullNameEn.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDistrictsQueryParams fullNameEnNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("fullNameEn.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDistrictsQueryParams codeNameContains(@jakarta.annotation.Nullable final String value) {
      put("codeName.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams codeNameDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("codeName.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams codeNameEquals(@jakarta.annotation.Nullable final String value) {
      put("codeName.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams codeNameNotEquals(@jakarta.annotation.Nullable final String value) {
      put("codeName.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams codeNameSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("codeName.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams codeNameIn(@jakarta.annotation.Nullable final List<String> value) {
      put("codeName.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDistrictsQueryParams codeNameNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("codeName.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDistrictsQueryParams administrativeUnitIdGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams administrativeUnitIdLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams administrativeUnitIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams administrativeUnitIdLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams administrativeUnitIdEquals(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams administrativeUnitIdNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams administrativeUnitIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("administrativeUnitId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams administrativeUnitIdIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("administrativeUnitId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDistrictsQueryParams administrativeUnitIdNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("administrativeUnitId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDistrictsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDistrictsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDistrictsQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDistrictsQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDistrictsQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDistrictsQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDistrictsQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDistrictsQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDistrictsQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDistrictsQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDistrictsQueryParams wardsIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("wardsId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams wardsIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("wardsId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams wardsIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("wardsId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams wardsIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("wardsId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams wardsIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("wardsId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams wardsIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("wardsId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams wardsIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("wardsId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams wardsIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("wardsId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDistrictsQueryParams wardsIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("wardsId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDistrictsQueryParams provinceIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("provinceId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams provinceIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("provinceId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams provinceIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("provinceId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams provinceIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("provinceId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams provinceIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("provinceId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams provinceIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("provinceId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams provinceIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("provinceId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountDistrictsQueryParams provinceIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("provinceId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDistrictsQueryParams provinceIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("provinceId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountDistrictsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param districtDTO  (required)
   * @return DistrictDTO
   */
  @RequestLine("POST /api/districts")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  DistrictDTO createDistrict(@jakarta.annotation.Nonnull DistrictDTO districtDTO);

  /**
   * 
   * Similar to <code>createDistrict</code> but it also returns the http response headers .
   * 
   * @param districtDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/districts")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<DistrictDTO> createDistrictWithHttpInfo(@jakarta.annotation.Nonnull DistrictDTO districtDTO);



  /**
   * 
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/districts/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteDistrict(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>deleteDistrict</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/districts/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteDistrictWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



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
   * @param districtCodeContains  (optional)
   * @param districtCodeDoesNotContain  (optional)
   * @param districtCodeEquals  (optional)
   * @param districtCodeNotEquals  (optional)
   * @param districtCodeSpecified  (optional)
   * @param districtCodeIn  (optional)
   * @param districtCodeNotIn  (optional)
   * @param nameContains  (optional)
   * @param nameDoesNotContain  (optional)
   * @param nameEquals  (optional)
   * @param nameNotEquals  (optional)
   * @param nameSpecified  (optional)
   * @param nameIn  (optional)
   * @param nameNotIn  (optional)
   * @param nameEnContains  (optional)
   * @param nameEnDoesNotContain  (optional)
   * @param nameEnEquals  (optional)
   * @param nameEnNotEquals  (optional)
   * @param nameEnSpecified  (optional)
   * @param nameEnIn  (optional)
   * @param nameEnNotIn  (optional)
   * @param fullNameContains  (optional)
   * @param fullNameDoesNotContain  (optional)
   * @param fullNameEquals  (optional)
   * @param fullNameNotEquals  (optional)
   * @param fullNameSpecified  (optional)
   * @param fullNameIn  (optional)
   * @param fullNameNotIn  (optional)
   * @param fullNameEnContains  (optional)
   * @param fullNameEnDoesNotContain  (optional)
   * @param fullNameEnEquals  (optional)
   * @param fullNameEnNotEquals  (optional)
   * @param fullNameEnSpecified  (optional)
   * @param fullNameEnIn  (optional)
   * @param fullNameEnNotIn  (optional)
   * @param codeNameContains  (optional)
   * @param codeNameDoesNotContain  (optional)
   * @param codeNameEquals  (optional)
   * @param codeNameNotEquals  (optional)
   * @param codeNameSpecified  (optional)
   * @param codeNameIn  (optional)
   * @param codeNameNotIn  (optional)
   * @param administrativeUnitIdGreaterThan  (optional)
   * @param administrativeUnitIdLessThan  (optional)
   * @param administrativeUnitIdGreaterThanOrEqual  (optional)
   * @param administrativeUnitIdLessThanOrEqual  (optional)
   * @param administrativeUnitIdEquals  (optional)
   * @param administrativeUnitIdNotEquals  (optional)
   * @param administrativeUnitIdSpecified  (optional)
   * @param administrativeUnitIdIn  (optional)
   * @param administrativeUnitIdNotIn  (optional)
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
   * @param wardsIdGreaterThan  (optional)
   * @param wardsIdLessThan  (optional)
   * @param wardsIdGreaterThanOrEqual  (optional)
   * @param wardsIdLessThanOrEqual  (optional)
   * @param wardsIdEquals  (optional)
   * @param wardsIdNotEquals  (optional)
   * @param wardsIdSpecified  (optional)
   * @param wardsIdIn  (optional)
   * @param wardsIdNotIn  (optional)
   * @param provinceIdGreaterThan  (optional)
   * @param provinceIdLessThan  (optional)
   * @param provinceIdGreaterThanOrEqual  (optional)
   * @param provinceIdLessThanOrEqual  (optional)
   * @param provinceIdEquals  (optional)
   * @param provinceIdNotEquals  (optional)
   * @param provinceIdSpecified  (optional)
   * @param provinceIdIn  (optional)
   * @param provinceIdNotIn  (optional)
   * @param distinct  (optional)
   * @return List&lt;DistrictDTO&gt;
   */
  @RequestLine("GET /api/districts?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&districtCode.contains={districtCodeContains}&districtCode.doesNotContain={districtCodeDoesNotContain}&districtCode.equals={districtCodeEquals}&districtCode.notEquals={districtCodeNotEquals}&districtCode.specified={districtCodeSpecified}&districtCode.in={districtCodeIn}&districtCode.notIn={districtCodeNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&nameEn.contains={nameEnContains}&nameEn.doesNotContain={nameEnDoesNotContain}&nameEn.equals={nameEnEquals}&nameEn.notEquals={nameEnNotEquals}&nameEn.specified={nameEnSpecified}&nameEn.in={nameEnIn}&nameEn.notIn={nameEnNotIn}&fullName.contains={fullNameContains}&fullName.doesNotContain={fullNameDoesNotContain}&fullName.equals={fullNameEquals}&fullName.notEquals={fullNameNotEquals}&fullName.specified={fullNameSpecified}&fullName.in={fullNameIn}&fullName.notIn={fullNameNotIn}&fullNameEn.contains={fullNameEnContains}&fullNameEn.doesNotContain={fullNameEnDoesNotContain}&fullNameEn.equals={fullNameEnEquals}&fullNameEn.notEquals={fullNameEnNotEquals}&fullNameEn.specified={fullNameEnSpecified}&fullNameEn.in={fullNameEnIn}&fullNameEn.notIn={fullNameEnNotIn}&codeName.contains={codeNameContains}&codeName.doesNotContain={codeNameDoesNotContain}&codeName.equals={codeNameEquals}&codeName.notEquals={codeNameNotEquals}&codeName.specified={codeNameSpecified}&codeName.in={codeNameIn}&codeName.notIn={codeNameNotIn}&administrativeUnitId.greaterThan={administrativeUnitIdGreaterThan}&administrativeUnitId.lessThan={administrativeUnitIdLessThan}&administrativeUnitId.greaterThanOrEqual={administrativeUnitIdGreaterThanOrEqual}&administrativeUnitId.lessThanOrEqual={administrativeUnitIdLessThanOrEqual}&administrativeUnitId.equals={administrativeUnitIdEquals}&administrativeUnitId.notEquals={administrativeUnitIdNotEquals}&administrativeUnitId.specified={administrativeUnitIdSpecified}&administrativeUnitId.in={administrativeUnitIdIn}&administrativeUnitId.notIn={administrativeUnitIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&wardsId.greaterThan={wardsIdGreaterThan}&wardsId.lessThan={wardsIdLessThan}&wardsId.greaterThanOrEqual={wardsIdGreaterThanOrEqual}&wardsId.lessThanOrEqual={wardsIdLessThanOrEqual}&wardsId.equals={wardsIdEquals}&wardsId.notEquals={wardsIdNotEquals}&wardsId.specified={wardsIdSpecified}&wardsId.in={wardsIdIn}&wardsId.notIn={wardsIdNotIn}&provinceId.greaterThan={provinceIdGreaterThan}&provinceId.lessThan={provinceIdLessThan}&provinceId.greaterThanOrEqual={provinceIdGreaterThanOrEqual}&provinceId.lessThanOrEqual={provinceIdLessThanOrEqual}&provinceId.equals={provinceIdEquals}&provinceId.notEquals={provinceIdNotEquals}&provinceId.specified={provinceIdSpecified}&provinceId.in={provinceIdIn}&provinceId.notIn={provinceIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  List<DistrictDTO> getAllDistricts(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("districtCodeContains") @jakarta.annotation.Nullable String districtCodeContains, @Param("districtCodeDoesNotContain") @jakarta.annotation.Nullable String districtCodeDoesNotContain, @Param("districtCodeEquals") @jakarta.annotation.Nullable String districtCodeEquals, @Param("districtCodeNotEquals") @jakarta.annotation.Nullable String districtCodeNotEquals, @Param("districtCodeSpecified") @jakarta.annotation.Nullable Boolean districtCodeSpecified, @Param("districtCodeIn") @jakarta.annotation.Nullable List<String> districtCodeIn, @Param("districtCodeNotIn") @jakarta.annotation.Nullable List<String> districtCodeNotIn, @Param("nameContains") @jakarta.annotation.Nullable String nameContains, @Param("nameDoesNotContain") @jakarta.annotation.Nullable String nameDoesNotContain, @Param("nameEquals") @jakarta.annotation.Nullable String nameEquals, @Param("nameNotEquals") @jakarta.annotation.Nullable String nameNotEquals, @Param("nameSpecified") @jakarta.annotation.Nullable Boolean nameSpecified, @Param("nameIn") @jakarta.annotation.Nullable List<String> nameIn, @Param("nameNotIn") @jakarta.annotation.Nullable List<String> nameNotIn, @Param("nameEnContains") @jakarta.annotation.Nullable String nameEnContains, @Param("nameEnDoesNotContain") @jakarta.annotation.Nullable String nameEnDoesNotContain, @Param("nameEnEquals") @jakarta.annotation.Nullable String nameEnEquals, @Param("nameEnNotEquals") @jakarta.annotation.Nullable String nameEnNotEquals, @Param("nameEnSpecified") @jakarta.annotation.Nullable Boolean nameEnSpecified, @Param("nameEnIn") @jakarta.annotation.Nullable List<String> nameEnIn, @Param("nameEnNotIn") @jakarta.annotation.Nullable List<String> nameEnNotIn, @Param("fullNameContains") @jakarta.annotation.Nullable String fullNameContains, @Param("fullNameDoesNotContain") @jakarta.annotation.Nullable String fullNameDoesNotContain, @Param("fullNameEquals") @jakarta.annotation.Nullable String fullNameEquals, @Param("fullNameNotEquals") @jakarta.annotation.Nullable String fullNameNotEquals, @Param("fullNameSpecified") @jakarta.annotation.Nullable Boolean fullNameSpecified, @Param("fullNameIn") @jakarta.annotation.Nullable List<String> fullNameIn, @Param("fullNameNotIn") @jakarta.annotation.Nullable List<String> fullNameNotIn, @Param("fullNameEnContains") @jakarta.annotation.Nullable String fullNameEnContains, @Param("fullNameEnDoesNotContain") @jakarta.annotation.Nullable String fullNameEnDoesNotContain, @Param("fullNameEnEquals") @jakarta.annotation.Nullable String fullNameEnEquals, @Param("fullNameEnNotEquals") @jakarta.annotation.Nullable String fullNameEnNotEquals, @Param("fullNameEnSpecified") @jakarta.annotation.Nullable Boolean fullNameEnSpecified, @Param("fullNameEnIn") @jakarta.annotation.Nullable List<String> fullNameEnIn, @Param("fullNameEnNotIn") @jakarta.annotation.Nullable List<String> fullNameEnNotIn, @Param("codeNameContains") @jakarta.annotation.Nullable String codeNameContains, @Param("codeNameDoesNotContain") @jakarta.annotation.Nullable String codeNameDoesNotContain, @Param("codeNameEquals") @jakarta.annotation.Nullable String codeNameEquals, @Param("codeNameNotEquals") @jakarta.annotation.Nullable String codeNameNotEquals, @Param("codeNameSpecified") @jakarta.annotation.Nullable Boolean codeNameSpecified, @Param("codeNameIn") @jakarta.annotation.Nullable List<String> codeNameIn, @Param("codeNameNotIn") @jakarta.annotation.Nullable List<String> codeNameNotIn, @Param("administrativeUnitIdGreaterThan") @jakarta.annotation.Nullable Integer administrativeUnitIdGreaterThan, @Param("administrativeUnitIdLessThan") @jakarta.annotation.Nullable Integer administrativeUnitIdLessThan, @Param("administrativeUnitIdGreaterThanOrEqual") @jakarta.annotation.Nullable Integer administrativeUnitIdGreaterThanOrEqual, @Param("administrativeUnitIdLessThanOrEqual") @jakarta.annotation.Nullable Integer administrativeUnitIdLessThanOrEqual, @Param("administrativeUnitIdEquals") @jakarta.annotation.Nullable Integer administrativeUnitIdEquals, @Param("administrativeUnitIdNotEquals") @jakarta.annotation.Nullable Integer administrativeUnitIdNotEquals, @Param("administrativeUnitIdSpecified") @jakarta.annotation.Nullable Boolean administrativeUnitIdSpecified, @Param("administrativeUnitIdIn") @jakarta.annotation.Nullable List<Integer> administrativeUnitIdIn, @Param("administrativeUnitIdNotIn") @jakarta.annotation.Nullable List<Integer> administrativeUnitIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("wardsIdGreaterThan") @jakarta.annotation.Nullable Long wardsIdGreaterThan, @Param("wardsIdLessThan") @jakarta.annotation.Nullable Long wardsIdLessThan, @Param("wardsIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long wardsIdGreaterThanOrEqual, @Param("wardsIdLessThanOrEqual") @jakarta.annotation.Nullable Long wardsIdLessThanOrEqual, @Param("wardsIdEquals") @jakarta.annotation.Nullable Long wardsIdEquals, @Param("wardsIdNotEquals") @jakarta.annotation.Nullable Long wardsIdNotEquals, @Param("wardsIdSpecified") @jakarta.annotation.Nullable Boolean wardsIdSpecified, @Param("wardsIdIn") @jakarta.annotation.Nullable List<Long> wardsIdIn, @Param("wardsIdNotIn") @jakarta.annotation.Nullable List<Long> wardsIdNotIn, @Param("provinceIdGreaterThan") @jakarta.annotation.Nullable Long provinceIdGreaterThan, @Param("provinceIdLessThan") @jakarta.annotation.Nullable Long provinceIdLessThan, @Param("provinceIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long provinceIdGreaterThanOrEqual, @Param("provinceIdLessThanOrEqual") @jakarta.annotation.Nullable Long provinceIdLessThanOrEqual, @Param("provinceIdEquals") @jakarta.annotation.Nullable Long provinceIdEquals, @Param("provinceIdNotEquals") @jakarta.annotation.Nullable Long provinceIdNotEquals, @Param("provinceIdSpecified") @jakarta.annotation.Nullable Boolean provinceIdSpecified, @Param("provinceIdIn") @jakarta.annotation.Nullable List<Long> provinceIdIn, @Param("provinceIdNotIn") @jakarta.annotation.Nullable List<Long> provinceIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>getAllDistricts</code> but it also returns the http response headers .
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
   * @param districtCodeContains  (optional)
   * @param districtCodeDoesNotContain  (optional)
   * @param districtCodeEquals  (optional)
   * @param districtCodeNotEquals  (optional)
   * @param districtCodeSpecified  (optional)
   * @param districtCodeIn  (optional)
   * @param districtCodeNotIn  (optional)
   * @param nameContains  (optional)
   * @param nameDoesNotContain  (optional)
   * @param nameEquals  (optional)
   * @param nameNotEquals  (optional)
   * @param nameSpecified  (optional)
   * @param nameIn  (optional)
   * @param nameNotIn  (optional)
   * @param nameEnContains  (optional)
   * @param nameEnDoesNotContain  (optional)
   * @param nameEnEquals  (optional)
   * @param nameEnNotEquals  (optional)
   * @param nameEnSpecified  (optional)
   * @param nameEnIn  (optional)
   * @param nameEnNotIn  (optional)
   * @param fullNameContains  (optional)
   * @param fullNameDoesNotContain  (optional)
   * @param fullNameEquals  (optional)
   * @param fullNameNotEquals  (optional)
   * @param fullNameSpecified  (optional)
   * @param fullNameIn  (optional)
   * @param fullNameNotIn  (optional)
   * @param fullNameEnContains  (optional)
   * @param fullNameEnDoesNotContain  (optional)
   * @param fullNameEnEquals  (optional)
   * @param fullNameEnNotEquals  (optional)
   * @param fullNameEnSpecified  (optional)
   * @param fullNameEnIn  (optional)
   * @param fullNameEnNotIn  (optional)
   * @param codeNameContains  (optional)
   * @param codeNameDoesNotContain  (optional)
   * @param codeNameEquals  (optional)
   * @param codeNameNotEquals  (optional)
   * @param codeNameSpecified  (optional)
   * @param codeNameIn  (optional)
   * @param codeNameNotIn  (optional)
   * @param administrativeUnitIdGreaterThan  (optional)
   * @param administrativeUnitIdLessThan  (optional)
   * @param administrativeUnitIdGreaterThanOrEqual  (optional)
   * @param administrativeUnitIdLessThanOrEqual  (optional)
   * @param administrativeUnitIdEquals  (optional)
   * @param administrativeUnitIdNotEquals  (optional)
   * @param administrativeUnitIdSpecified  (optional)
   * @param administrativeUnitIdIn  (optional)
   * @param administrativeUnitIdNotIn  (optional)
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
   * @param wardsIdGreaterThan  (optional)
   * @param wardsIdLessThan  (optional)
   * @param wardsIdGreaterThanOrEqual  (optional)
   * @param wardsIdLessThanOrEqual  (optional)
   * @param wardsIdEquals  (optional)
   * @param wardsIdNotEquals  (optional)
   * @param wardsIdSpecified  (optional)
   * @param wardsIdIn  (optional)
   * @param wardsIdNotIn  (optional)
   * @param provinceIdGreaterThan  (optional)
   * @param provinceIdLessThan  (optional)
   * @param provinceIdGreaterThanOrEqual  (optional)
   * @param provinceIdLessThanOrEqual  (optional)
   * @param provinceIdEquals  (optional)
   * @param provinceIdNotEquals  (optional)
   * @param provinceIdSpecified  (optional)
   * @param provinceIdIn  (optional)
   * @param provinceIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/districts?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&districtCode.contains={districtCodeContains}&districtCode.doesNotContain={districtCodeDoesNotContain}&districtCode.equals={districtCodeEquals}&districtCode.notEquals={districtCodeNotEquals}&districtCode.specified={districtCodeSpecified}&districtCode.in={districtCodeIn}&districtCode.notIn={districtCodeNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&nameEn.contains={nameEnContains}&nameEn.doesNotContain={nameEnDoesNotContain}&nameEn.equals={nameEnEquals}&nameEn.notEquals={nameEnNotEquals}&nameEn.specified={nameEnSpecified}&nameEn.in={nameEnIn}&nameEn.notIn={nameEnNotIn}&fullName.contains={fullNameContains}&fullName.doesNotContain={fullNameDoesNotContain}&fullName.equals={fullNameEquals}&fullName.notEquals={fullNameNotEquals}&fullName.specified={fullNameSpecified}&fullName.in={fullNameIn}&fullName.notIn={fullNameNotIn}&fullNameEn.contains={fullNameEnContains}&fullNameEn.doesNotContain={fullNameEnDoesNotContain}&fullNameEn.equals={fullNameEnEquals}&fullNameEn.notEquals={fullNameEnNotEquals}&fullNameEn.specified={fullNameEnSpecified}&fullNameEn.in={fullNameEnIn}&fullNameEn.notIn={fullNameEnNotIn}&codeName.contains={codeNameContains}&codeName.doesNotContain={codeNameDoesNotContain}&codeName.equals={codeNameEquals}&codeName.notEquals={codeNameNotEquals}&codeName.specified={codeNameSpecified}&codeName.in={codeNameIn}&codeName.notIn={codeNameNotIn}&administrativeUnitId.greaterThan={administrativeUnitIdGreaterThan}&administrativeUnitId.lessThan={administrativeUnitIdLessThan}&administrativeUnitId.greaterThanOrEqual={administrativeUnitIdGreaterThanOrEqual}&administrativeUnitId.lessThanOrEqual={administrativeUnitIdLessThanOrEqual}&administrativeUnitId.equals={administrativeUnitIdEquals}&administrativeUnitId.notEquals={administrativeUnitIdNotEquals}&administrativeUnitId.specified={administrativeUnitIdSpecified}&administrativeUnitId.in={administrativeUnitIdIn}&administrativeUnitId.notIn={administrativeUnitIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&wardsId.greaterThan={wardsIdGreaterThan}&wardsId.lessThan={wardsIdLessThan}&wardsId.greaterThanOrEqual={wardsIdGreaterThanOrEqual}&wardsId.lessThanOrEqual={wardsIdLessThanOrEqual}&wardsId.equals={wardsIdEquals}&wardsId.notEquals={wardsIdNotEquals}&wardsId.specified={wardsIdSpecified}&wardsId.in={wardsIdIn}&wardsId.notIn={wardsIdNotIn}&provinceId.greaterThan={provinceIdGreaterThan}&provinceId.lessThan={provinceIdLessThan}&provinceId.greaterThanOrEqual={provinceIdGreaterThanOrEqual}&provinceId.lessThanOrEqual={provinceIdLessThanOrEqual}&provinceId.equals={provinceIdEquals}&provinceId.notEquals={provinceIdNotEquals}&provinceId.specified={provinceIdSpecified}&provinceId.in={provinceIdIn}&provinceId.notIn={provinceIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<DistrictDTO>> getAllDistrictsWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("districtCodeContains") @jakarta.annotation.Nullable String districtCodeContains, @Param("districtCodeDoesNotContain") @jakarta.annotation.Nullable String districtCodeDoesNotContain, @Param("districtCodeEquals") @jakarta.annotation.Nullable String districtCodeEquals, @Param("districtCodeNotEquals") @jakarta.annotation.Nullable String districtCodeNotEquals, @Param("districtCodeSpecified") @jakarta.annotation.Nullable Boolean districtCodeSpecified, @Param("districtCodeIn") @jakarta.annotation.Nullable List<String> districtCodeIn, @Param("districtCodeNotIn") @jakarta.annotation.Nullable List<String> districtCodeNotIn, @Param("nameContains") @jakarta.annotation.Nullable String nameContains, @Param("nameDoesNotContain") @jakarta.annotation.Nullable String nameDoesNotContain, @Param("nameEquals") @jakarta.annotation.Nullable String nameEquals, @Param("nameNotEquals") @jakarta.annotation.Nullable String nameNotEquals, @Param("nameSpecified") @jakarta.annotation.Nullable Boolean nameSpecified, @Param("nameIn") @jakarta.annotation.Nullable List<String> nameIn, @Param("nameNotIn") @jakarta.annotation.Nullable List<String> nameNotIn, @Param("nameEnContains") @jakarta.annotation.Nullable String nameEnContains, @Param("nameEnDoesNotContain") @jakarta.annotation.Nullable String nameEnDoesNotContain, @Param("nameEnEquals") @jakarta.annotation.Nullable String nameEnEquals, @Param("nameEnNotEquals") @jakarta.annotation.Nullable String nameEnNotEquals, @Param("nameEnSpecified") @jakarta.annotation.Nullable Boolean nameEnSpecified, @Param("nameEnIn") @jakarta.annotation.Nullable List<String> nameEnIn, @Param("nameEnNotIn") @jakarta.annotation.Nullable List<String> nameEnNotIn, @Param("fullNameContains") @jakarta.annotation.Nullable String fullNameContains, @Param("fullNameDoesNotContain") @jakarta.annotation.Nullable String fullNameDoesNotContain, @Param("fullNameEquals") @jakarta.annotation.Nullable String fullNameEquals, @Param("fullNameNotEquals") @jakarta.annotation.Nullable String fullNameNotEquals, @Param("fullNameSpecified") @jakarta.annotation.Nullable Boolean fullNameSpecified, @Param("fullNameIn") @jakarta.annotation.Nullable List<String> fullNameIn, @Param("fullNameNotIn") @jakarta.annotation.Nullable List<String> fullNameNotIn, @Param("fullNameEnContains") @jakarta.annotation.Nullable String fullNameEnContains, @Param("fullNameEnDoesNotContain") @jakarta.annotation.Nullable String fullNameEnDoesNotContain, @Param("fullNameEnEquals") @jakarta.annotation.Nullable String fullNameEnEquals, @Param("fullNameEnNotEquals") @jakarta.annotation.Nullable String fullNameEnNotEquals, @Param("fullNameEnSpecified") @jakarta.annotation.Nullable Boolean fullNameEnSpecified, @Param("fullNameEnIn") @jakarta.annotation.Nullable List<String> fullNameEnIn, @Param("fullNameEnNotIn") @jakarta.annotation.Nullable List<String> fullNameEnNotIn, @Param("codeNameContains") @jakarta.annotation.Nullable String codeNameContains, @Param("codeNameDoesNotContain") @jakarta.annotation.Nullable String codeNameDoesNotContain, @Param("codeNameEquals") @jakarta.annotation.Nullable String codeNameEquals, @Param("codeNameNotEquals") @jakarta.annotation.Nullable String codeNameNotEquals, @Param("codeNameSpecified") @jakarta.annotation.Nullable Boolean codeNameSpecified, @Param("codeNameIn") @jakarta.annotation.Nullable List<String> codeNameIn, @Param("codeNameNotIn") @jakarta.annotation.Nullable List<String> codeNameNotIn, @Param("administrativeUnitIdGreaterThan") @jakarta.annotation.Nullable Integer administrativeUnitIdGreaterThan, @Param("administrativeUnitIdLessThan") @jakarta.annotation.Nullable Integer administrativeUnitIdLessThan, @Param("administrativeUnitIdGreaterThanOrEqual") @jakarta.annotation.Nullable Integer administrativeUnitIdGreaterThanOrEqual, @Param("administrativeUnitIdLessThanOrEqual") @jakarta.annotation.Nullable Integer administrativeUnitIdLessThanOrEqual, @Param("administrativeUnitIdEquals") @jakarta.annotation.Nullable Integer administrativeUnitIdEquals, @Param("administrativeUnitIdNotEquals") @jakarta.annotation.Nullable Integer administrativeUnitIdNotEquals, @Param("administrativeUnitIdSpecified") @jakarta.annotation.Nullable Boolean administrativeUnitIdSpecified, @Param("administrativeUnitIdIn") @jakarta.annotation.Nullable List<Integer> administrativeUnitIdIn, @Param("administrativeUnitIdNotIn") @jakarta.annotation.Nullable List<Integer> administrativeUnitIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("wardsIdGreaterThan") @jakarta.annotation.Nullable Long wardsIdGreaterThan, @Param("wardsIdLessThan") @jakarta.annotation.Nullable Long wardsIdLessThan, @Param("wardsIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long wardsIdGreaterThanOrEqual, @Param("wardsIdLessThanOrEqual") @jakarta.annotation.Nullable Long wardsIdLessThanOrEqual, @Param("wardsIdEquals") @jakarta.annotation.Nullable Long wardsIdEquals, @Param("wardsIdNotEquals") @jakarta.annotation.Nullable Long wardsIdNotEquals, @Param("wardsIdSpecified") @jakarta.annotation.Nullable Boolean wardsIdSpecified, @Param("wardsIdIn") @jakarta.annotation.Nullable List<Long> wardsIdIn, @Param("wardsIdNotIn") @jakarta.annotation.Nullable List<Long> wardsIdNotIn, @Param("provinceIdGreaterThan") @jakarta.annotation.Nullable Long provinceIdGreaterThan, @Param("provinceIdLessThan") @jakarta.annotation.Nullable Long provinceIdLessThan, @Param("provinceIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long provinceIdGreaterThanOrEqual, @Param("provinceIdLessThanOrEqual") @jakarta.annotation.Nullable Long provinceIdLessThanOrEqual, @Param("provinceIdEquals") @jakarta.annotation.Nullable Long provinceIdEquals, @Param("provinceIdNotEquals") @jakarta.annotation.Nullable Long provinceIdNotEquals, @Param("provinceIdSpecified") @jakarta.annotation.Nullable Boolean provinceIdSpecified, @Param("provinceIdIn") @jakarta.annotation.Nullable List<Long> provinceIdIn, @Param("provinceIdNotIn") @jakarta.annotation.Nullable List<Long> provinceIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllDistricts</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllDistrictsQueryParams} class that allows for
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
   *   <li>districtCodeContains -  (optional)</li>
   *   <li>districtCodeDoesNotContain -  (optional)</li>
   *   <li>districtCodeEquals -  (optional)</li>
   *   <li>districtCodeNotEquals -  (optional)</li>
   *   <li>districtCodeSpecified -  (optional)</li>
   *   <li>districtCodeIn -  (optional)</li>
   *   <li>districtCodeNotIn -  (optional)</li>
   *   <li>nameContains -  (optional)</li>
   *   <li>nameDoesNotContain -  (optional)</li>
   *   <li>nameEquals -  (optional)</li>
   *   <li>nameNotEquals -  (optional)</li>
   *   <li>nameSpecified -  (optional)</li>
   *   <li>nameIn -  (optional)</li>
   *   <li>nameNotIn -  (optional)</li>
   *   <li>nameEnContains -  (optional)</li>
   *   <li>nameEnDoesNotContain -  (optional)</li>
   *   <li>nameEnEquals -  (optional)</li>
   *   <li>nameEnNotEquals -  (optional)</li>
   *   <li>nameEnSpecified -  (optional)</li>
   *   <li>nameEnIn -  (optional)</li>
   *   <li>nameEnNotIn -  (optional)</li>
   *   <li>fullNameContains -  (optional)</li>
   *   <li>fullNameDoesNotContain -  (optional)</li>
   *   <li>fullNameEquals -  (optional)</li>
   *   <li>fullNameNotEquals -  (optional)</li>
   *   <li>fullNameSpecified -  (optional)</li>
   *   <li>fullNameIn -  (optional)</li>
   *   <li>fullNameNotIn -  (optional)</li>
   *   <li>fullNameEnContains -  (optional)</li>
   *   <li>fullNameEnDoesNotContain -  (optional)</li>
   *   <li>fullNameEnEquals -  (optional)</li>
   *   <li>fullNameEnNotEquals -  (optional)</li>
   *   <li>fullNameEnSpecified -  (optional)</li>
   *   <li>fullNameEnIn -  (optional)</li>
   *   <li>fullNameEnNotIn -  (optional)</li>
   *   <li>codeNameContains -  (optional)</li>
   *   <li>codeNameDoesNotContain -  (optional)</li>
   *   <li>codeNameEquals -  (optional)</li>
   *   <li>codeNameNotEquals -  (optional)</li>
   *   <li>codeNameSpecified -  (optional)</li>
   *   <li>codeNameIn -  (optional)</li>
   *   <li>codeNameNotIn -  (optional)</li>
   *   <li>administrativeUnitIdGreaterThan -  (optional)</li>
   *   <li>administrativeUnitIdLessThan -  (optional)</li>
   *   <li>administrativeUnitIdGreaterThanOrEqual -  (optional)</li>
   *   <li>administrativeUnitIdLessThanOrEqual -  (optional)</li>
   *   <li>administrativeUnitIdEquals -  (optional)</li>
   *   <li>administrativeUnitIdNotEquals -  (optional)</li>
   *   <li>administrativeUnitIdSpecified -  (optional)</li>
   *   <li>administrativeUnitIdIn -  (optional)</li>
   *   <li>administrativeUnitIdNotIn -  (optional)</li>
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
   *   <li>wardsIdGreaterThan -  (optional)</li>
   *   <li>wardsIdLessThan -  (optional)</li>
   *   <li>wardsIdGreaterThanOrEqual -  (optional)</li>
   *   <li>wardsIdLessThanOrEqual -  (optional)</li>
   *   <li>wardsIdEquals -  (optional)</li>
   *   <li>wardsIdNotEquals -  (optional)</li>
   *   <li>wardsIdSpecified -  (optional)</li>
   *   <li>wardsIdIn -  (optional)</li>
   *   <li>wardsIdNotIn -  (optional)</li>
   *   <li>provinceIdGreaterThan -  (optional)</li>
   *   <li>provinceIdLessThan -  (optional)</li>
   *   <li>provinceIdGreaterThanOrEqual -  (optional)</li>
   *   <li>provinceIdLessThanOrEqual -  (optional)</li>
   *   <li>provinceIdEquals -  (optional)</li>
   *   <li>provinceIdNotEquals -  (optional)</li>
   *   <li>provinceIdSpecified -  (optional)</li>
   *   <li>provinceIdIn -  (optional)</li>
   *   <li>provinceIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return List&lt;DistrictDTO&gt;
   */
  @RequestLine("GET /api/districts?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&districtCode.contains={districtCodeContains}&districtCode.doesNotContain={districtCodeDoesNotContain}&districtCode.equals={districtCodeEquals}&districtCode.notEquals={districtCodeNotEquals}&districtCode.specified={districtCodeSpecified}&districtCode.in={districtCodeIn}&districtCode.notIn={districtCodeNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&nameEn.contains={nameEnContains}&nameEn.doesNotContain={nameEnDoesNotContain}&nameEn.equals={nameEnEquals}&nameEn.notEquals={nameEnNotEquals}&nameEn.specified={nameEnSpecified}&nameEn.in={nameEnIn}&nameEn.notIn={nameEnNotIn}&fullName.contains={fullNameContains}&fullName.doesNotContain={fullNameDoesNotContain}&fullName.equals={fullNameEquals}&fullName.notEquals={fullNameNotEquals}&fullName.specified={fullNameSpecified}&fullName.in={fullNameIn}&fullName.notIn={fullNameNotIn}&fullNameEn.contains={fullNameEnContains}&fullNameEn.doesNotContain={fullNameEnDoesNotContain}&fullNameEn.equals={fullNameEnEquals}&fullNameEn.notEquals={fullNameEnNotEquals}&fullNameEn.specified={fullNameEnSpecified}&fullNameEn.in={fullNameEnIn}&fullNameEn.notIn={fullNameEnNotIn}&codeName.contains={codeNameContains}&codeName.doesNotContain={codeNameDoesNotContain}&codeName.equals={codeNameEquals}&codeName.notEquals={codeNameNotEquals}&codeName.specified={codeNameSpecified}&codeName.in={codeNameIn}&codeName.notIn={codeNameNotIn}&administrativeUnitId.greaterThan={administrativeUnitIdGreaterThan}&administrativeUnitId.lessThan={administrativeUnitIdLessThan}&administrativeUnitId.greaterThanOrEqual={administrativeUnitIdGreaterThanOrEqual}&administrativeUnitId.lessThanOrEqual={administrativeUnitIdLessThanOrEqual}&administrativeUnitId.equals={administrativeUnitIdEquals}&administrativeUnitId.notEquals={administrativeUnitIdNotEquals}&administrativeUnitId.specified={administrativeUnitIdSpecified}&administrativeUnitId.in={administrativeUnitIdIn}&administrativeUnitId.notIn={administrativeUnitIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&wardsId.greaterThan={wardsIdGreaterThan}&wardsId.lessThan={wardsIdLessThan}&wardsId.greaterThanOrEqual={wardsIdGreaterThanOrEqual}&wardsId.lessThanOrEqual={wardsIdLessThanOrEqual}&wardsId.equals={wardsIdEquals}&wardsId.notEquals={wardsIdNotEquals}&wardsId.specified={wardsIdSpecified}&wardsId.in={wardsIdIn}&wardsId.notIn={wardsIdNotIn}&provinceId.greaterThan={provinceIdGreaterThan}&provinceId.lessThan={provinceIdLessThan}&provinceId.greaterThanOrEqual={provinceIdGreaterThanOrEqual}&provinceId.lessThanOrEqual={provinceIdLessThanOrEqual}&provinceId.equals={provinceIdEquals}&provinceId.notEquals={provinceIdNotEquals}&provinceId.specified={provinceIdSpecified}&provinceId.in={provinceIdIn}&provinceId.notIn={provinceIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  List<DistrictDTO> getAllDistricts(@QueryMap(encoded=true) GetAllDistrictsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllDistricts</code> that receives the query parameters as a map,
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
          *   <li>districtCodeContains -  (optional)</li>
          *   <li>districtCodeDoesNotContain -  (optional)</li>
          *   <li>districtCodeEquals -  (optional)</li>
          *   <li>districtCodeNotEquals -  (optional)</li>
          *   <li>districtCodeSpecified -  (optional)</li>
          *   <li>districtCodeIn -  (optional)</li>
          *   <li>districtCodeNotIn -  (optional)</li>
          *   <li>nameContains -  (optional)</li>
          *   <li>nameDoesNotContain -  (optional)</li>
          *   <li>nameEquals -  (optional)</li>
          *   <li>nameNotEquals -  (optional)</li>
          *   <li>nameSpecified -  (optional)</li>
          *   <li>nameIn -  (optional)</li>
          *   <li>nameNotIn -  (optional)</li>
          *   <li>nameEnContains -  (optional)</li>
          *   <li>nameEnDoesNotContain -  (optional)</li>
          *   <li>nameEnEquals -  (optional)</li>
          *   <li>nameEnNotEquals -  (optional)</li>
          *   <li>nameEnSpecified -  (optional)</li>
          *   <li>nameEnIn -  (optional)</li>
          *   <li>nameEnNotIn -  (optional)</li>
          *   <li>fullNameContains -  (optional)</li>
          *   <li>fullNameDoesNotContain -  (optional)</li>
          *   <li>fullNameEquals -  (optional)</li>
          *   <li>fullNameNotEquals -  (optional)</li>
          *   <li>fullNameSpecified -  (optional)</li>
          *   <li>fullNameIn -  (optional)</li>
          *   <li>fullNameNotIn -  (optional)</li>
          *   <li>fullNameEnContains -  (optional)</li>
          *   <li>fullNameEnDoesNotContain -  (optional)</li>
          *   <li>fullNameEnEquals -  (optional)</li>
          *   <li>fullNameEnNotEquals -  (optional)</li>
          *   <li>fullNameEnSpecified -  (optional)</li>
          *   <li>fullNameEnIn -  (optional)</li>
          *   <li>fullNameEnNotIn -  (optional)</li>
          *   <li>codeNameContains -  (optional)</li>
          *   <li>codeNameDoesNotContain -  (optional)</li>
          *   <li>codeNameEquals -  (optional)</li>
          *   <li>codeNameNotEquals -  (optional)</li>
          *   <li>codeNameSpecified -  (optional)</li>
          *   <li>codeNameIn -  (optional)</li>
          *   <li>codeNameNotIn -  (optional)</li>
          *   <li>administrativeUnitIdGreaterThan -  (optional)</li>
          *   <li>administrativeUnitIdLessThan -  (optional)</li>
          *   <li>administrativeUnitIdGreaterThanOrEqual -  (optional)</li>
          *   <li>administrativeUnitIdLessThanOrEqual -  (optional)</li>
          *   <li>administrativeUnitIdEquals -  (optional)</li>
          *   <li>administrativeUnitIdNotEquals -  (optional)</li>
          *   <li>administrativeUnitIdSpecified -  (optional)</li>
          *   <li>administrativeUnitIdIn -  (optional)</li>
          *   <li>administrativeUnitIdNotIn -  (optional)</li>
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
          *   <li>wardsIdGreaterThan -  (optional)</li>
          *   <li>wardsIdLessThan -  (optional)</li>
          *   <li>wardsIdGreaterThanOrEqual -  (optional)</li>
          *   <li>wardsIdLessThanOrEqual -  (optional)</li>
          *   <li>wardsIdEquals -  (optional)</li>
          *   <li>wardsIdNotEquals -  (optional)</li>
          *   <li>wardsIdSpecified -  (optional)</li>
          *   <li>wardsIdIn -  (optional)</li>
          *   <li>wardsIdNotIn -  (optional)</li>
          *   <li>provinceIdGreaterThan -  (optional)</li>
          *   <li>provinceIdLessThan -  (optional)</li>
          *   <li>provinceIdGreaterThanOrEqual -  (optional)</li>
          *   <li>provinceIdLessThanOrEqual -  (optional)</li>
          *   <li>provinceIdEquals -  (optional)</li>
          *   <li>provinceIdNotEquals -  (optional)</li>
          *   <li>provinceIdSpecified -  (optional)</li>
          *   <li>provinceIdIn -  (optional)</li>
          *   <li>provinceIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return List&lt;DistrictDTO&gt;
      */
      @RequestLine("GET /api/districts?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&districtCode.contains={districtCodeContains}&districtCode.doesNotContain={districtCodeDoesNotContain}&districtCode.equals={districtCodeEquals}&districtCode.notEquals={districtCodeNotEquals}&districtCode.specified={districtCodeSpecified}&districtCode.in={districtCodeIn}&districtCode.notIn={districtCodeNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&nameEn.contains={nameEnContains}&nameEn.doesNotContain={nameEnDoesNotContain}&nameEn.equals={nameEnEquals}&nameEn.notEquals={nameEnNotEquals}&nameEn.specified={nameEnSpecified}&nameEn.in={nameEnIn}&nameEn.notIn={nameEnNotIn}&fullName.contains={fullNameContains}&fullName.doesNotContain={fullNameDoesNotContain}&fullName.equals={fullNameEquals}&fullName.notEquals={fullNameNotEquals}&fullName.specified={fullNameSpecified}&fullName.in={fullNameIn}&fullName.notIn={fullNameNotIn}&fullNameEn.contains={fullNameEnContains}&fullNameEn.doesNotContain={fullNameEnDoesNotContain}&fullNameEn.equals={fullNameEnEquals}&fullNameEn.notEquals={fullNameEnNotEquals}&fullNameEn.specified={fullNameEnSpecified}&fullNameEn.in={fullNameEnIn}&fullNameEn.notIn={fullNameEnNotIn}&codeName.contains={codeNameContains}&codeName.doesNotContain={codeNameDoesNotContain}&codeName.equals={codeNameEquals}&codeName.notEquals={codeNameNotEquals}&codeName.specified={codeNameSpecified}&codeName.in={codeNameIn}&codeName.notIn={codeNameNotIn}&administrativeUnitId.greaterThan={administrativeUnitIdGreaterThan}&administrativeUnitId.lessThan={administrativeUnitIdLessThan}&administrativeUnitId.greaterThanOrEqual={administrativeUnitIdGreaterThanOrEqual}&administrativeUnitId.lessThanOrEqual={administrativeUnitIdLessThanOrEqual}&administrativeUnitId.equals={administrativeUnitIdEquals}&administrativeUnitId.notEquals={administrativeUnitIdNotEquals}&administrativeUnitId.specified={administrativeUnitIdSpecified}&administrativeUnitId.in={administrativeUnitIdIn}&administrativeUnitId.notIn={administrativeUnitIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&wardsId.greaterThan={wardsIdGreaterThan}&wardsId.lessThan={wardsIdLessThan}&wardsId.greaterThanOrEqual={wardsIdGreaterThanOrEqual}&wardsId.lessThanOrEqual={wardsIdLessThanOrEqual}&wardsId.equals={wardsIdEquals}&wardsId.notEquals={wardsIdNotEquals}&wardsId.specified={wardsIdSpecified}&wardsId.in={wardsIdIn}&wardsId.notIn={wardsIdNotIn}&provinceId.greaterThan={provinceIdGreaterThan}&provinceId.lessThan={provinceIdLessThan}&provinceId.greaterThanOrEqual={provinceIdGreaterThanOrEqual}&provinceId.lessThanOrEqual={provinceIdLessThanOrEqual}&provinceId.equals={provinceIdEquals}&provinceId.notEquals={provinceIdNotEquals}&provinceId.specified={provinceIdSpecified}&provinceId.in={provinceIdIn}&provinceId.notIn={provinceIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<DistrictDTO>> getAllDistrictsWithHttpInfo(@QueryMap(encoded=true) GetAllDistrictsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllDistricts</code> method in a fluent style.
   */
  public static class GetAllDistrictsQueryParams extends HashMap<String, Object> {
    public GetAllDistrictsQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDistrictsQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDistrictsQueryParams districtCodeContains(@jakarta.annotation.Nullable final String value) {
      put("districtCode.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams districtCodeDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("districtCode.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams districtCodeEquals(@jakarta.annotation.Nullable final String value) {
      put("districtCode.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams districtCodeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("districtCode.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams districtCodeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("districtCode.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams districtCodeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("districtCode.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDistrictsQueryParams districtCodeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("districtCode.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDistrictsQueryParams nameContains(@jakarta.annotation.Nullable final String value) {
      put("name.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams nameDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("name.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams nameEquals(@jakarta.annotation.Nullable final String value) {
      put("name.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams nameNotEquals(@jakarta.annotation.Nullable final String value) {
      put("name.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams nameSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("name.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams nameIn(@jakarta.annotation.Nullable final List<String> value) {
      put("name.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDistrictsQueryParams nameNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("name.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDistrictsQueryParams nameEnContains(@jakarta.annotation.Nullable final String value) {
      put("nameEn.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams nameEnDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("nameEn.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams nameEnEquals(@jakarta.annotation.Nullable final String value) {
      put("nameEn.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams nameEnNotEquals(@jakarta.annotation.Nullable final String value) {
      put("nameEn.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams nameEnSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("nameEn.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams nameEnIn(@jakarta.annotation.Nullable final List<String> value) {
      put("nameEn.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDistrictsQueryParams nameEnNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("nameEn.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDistrictsQueryParams fullNameContains(@jakarta.annotation.Nullable final String value) {
      put("fullName.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams fullNameDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("fullName.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams fullNameEquals(@jakarta.annotation.Nullable final String value) {
      put("fullName.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams fullNameNotEquals(@jakarta.annotation.Nullable final String value) {
      put("fullName.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams fullNameSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("fullName.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams fullNameIn(@jakarta.annotation.Nullable final List<String> value) {
      put("fullName.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDistrictsQueryParams fullNameNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("fullName.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDistrictsQueryParams fullNameEnContains(@jakarta.annotation.Nullable final String value) {
      put("fullNameEn.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams fullNameEnDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("fullNameEn.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams fullNameEnEquals(@jakarta.annotation.Nullable final String value) {
      put("fullNameEn.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams fullNameEnNotEquals(@jakarta.annotation.Nullable final String value) {
      put("fullNameEn.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams fullNameEnSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("fullNameEn.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams fullNameEnIn(@jakarta.annotation.Nullable final List<String> value) {
      put("fullNameEn.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDistrictsQueryParams fullNameEnNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("fullNameEn.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDistrictsQueryParams codeNameContains(@jakarta.annotation.Nullable final String value) {
      put("codeName.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams codeNameDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("codeName.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams codeNameEquals(@jakarta.annotation.Nullable final String value) {
      put("codeName.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams codeNameNotEquals(@jakarta.annotation.Nullable final String value) {
      put("codeName.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams codeNameSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("codeName.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams codeNameIn(@jakarta.annotation.Nullable final List<String> value) {
      put("codeName.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDistrictsQueryParams codeNameNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("codeName.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDistrictsQueryParams administrativeUnitIdGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams administrativeUnitIdLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams administrativeUnitIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams administrativeUnitIdLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams administrativeUnitIdEquals(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams administrativeUnitIdNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams administrativeUnitIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("administrativeUnitId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams administrativeUnitIdIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("administrativeUnitId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDistrictsQueryParams administrativeUnitIdNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("administrativeUnitId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDistrictsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDistrictsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDistrictsQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDistrictsQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDistrictsQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDistrictsQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDistrictsQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDistrictsQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDistrictsQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDistrictsQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDistrictsQueryParams wardsIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("wardsId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams wardsIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("wardsId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams wardsIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("wardsId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams wardsIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("wardsId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams wardsIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("wardsId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams wardsIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("wardsId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams wardsIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("wardsId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams wardsIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("wardsId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDistrictsQueryParams wardsIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("wardsId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDistrictsQueryParams provinceIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("provinceId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams provinceIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("provinceId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams provinceIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("provinceId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams provinceIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("provinceId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams provinceIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("provinceId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams provinceIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("provinceId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams provinceIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("provinceId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllDistrictsQueryParams provinceIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("provinceId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDistrictsQueryParams provinceIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("provinceId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllDistrictsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @return DistrictDTO
   */
  @RequestLine("GET /api/districts/{id}")
  @Headers({
    "Accept: */*",
  })
  DistrictDTO getDistrict(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>getDistrict</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/districts/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<DistrictDTO> getDistrictWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param id  (required)
   * @param districtDTO  (required)
   * @return DistrictDTO
   */
  @RequestLine("PATCH /api/districts/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  DistrictDTO partialUpdateDistrict(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull DistrictDTO districtDTO);

  /**
   * 
   * Similar to <code>partialUpdateDistrict</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param districtDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /api/districts/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<DistrictDTO> partialUpdateDistrictWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull DistrictDTO districtDTO);



  /**
   * 
   * 
   * @param id  (required)
   * @param districtDTO  (required)
   * @return DistrictDTO
   */
  @RequestLine("PUT /api/districts/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  DistrictDTO updateDistrict(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull DistrictDTO districtDTO);

  /**
   * 
   * Similar to <code>updateDistrict</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param districtDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/districts/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<DistrictDTO> updateDistrictWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull DistrictDTO districtDTO);


}
