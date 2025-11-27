package com.ridehub.msroute.client.api;

import com.ridehub.msroute.client.invoker.ApiClient;
import com.ridehub.msroute.client.invoker.EncodingUtils;
import com.ridehub.msroute.client.model.ApiResponse;

import java.time.OffsetDateTime;
import com.ridehub.msroute.client.model.ProvinceDTO;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface ProvinceResourceMsrouteApi extends ApiClient.Api {


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
   * @param provinceCodeContains  (optional)
   * @param provinceCodeDoesNotContain  (optional)
   * @param provinceCodeEquals  (optional)
   * @param provinceCodeNotEquals  (optional)
   * @param provinceCodeSpecified  (optional)
   * @param provinceCodeIn  (optional)
   * @param provinceCodeNotIn  (optional)
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
   * @param administrativeRegionIdGreaterThan  (optional)
   * @param administrativeRegionIdLessThan  (optional)
   * @param administrativeRegionIdGreaterThanOrEqual  (optional)
   * @param administrativeRegionIdLessThanOrEqual  (optional)
   * @param administrativeRegionIdEquals  (optional)
   * @param administrativeRegionIdNotEquals  (optional)
   * @param administrativeRegionIdSpecified  (optional)
   * @param administrativeRegionIdIn  (optional)
   * @param administrativeRegionIdNotIn  (optional)
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
   * @param districtsIdGreaterThan  (optional)
   * @param districtsIdLessThan  (optional)
   * @param districtsIdGreaterThanOrEqual  (optional)
   * @param districtsIdLessThanOrEqual  (optional)
   * @param districtsIdEquals  (optional)
   * @param districtsIdNotEquals  (optional)
   * @param districtsIdSpecified  (optional)
   * @param districtsIdIn  (optional)
   * @param districtsIdNotIn  (optional)
   * @param distinct  (optional)
   * @return Long
   */
  @RequestLine("GET /api/provinces/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&provinceCode.contains={provinceCodeContains}&provinceCode.doesNotContain={provinceCodeDoesNotContain}&provinceCode.equals={provinceCodeEquals}&provinceCode.notEquals={provinceCodeNotEquals}&provinceCode.specified={provinceCodeSpecified}&provinceCode.in={provinceCodeIn}&provinceCode.notIn={provinceCodeNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&nameEn.contains={nameEnContains}&nameEn.doesNotContain={nameEnDoesNotContain}&nameEn.equals={nameEnEquals}&nameEn.notEquals={nameEnNotEquals}&nameEn.specified={nameEnSpecified}&nameEn.in={nameEnIn}&nameEn.notIn={nameEnNotIn}&fullName.contains={fullNameContains}&fullName.doesNotContain={fullNameDoesNotContain}&fullName.equals={fullNameEquals}&fullName.notEquals={fullNameNotEquals}&fullName.specified={fullNameSpecified}&fullName.in={fullNameIn}&fullName.notIn={fullNameNotIn}&fullNameEn.contains={fullNameEnContains}&fullNameEn.doesNotContain={fullNameEnDoesNotContain}&fullNameEn.equals={fullNameEnEquals}&fullNameEn.notEquals={fullNameEnNotEquals}&fullNameEn.specified={fullNameEnSpecified}&fullNameEn.in={fullNameEnIn}&fullNameEn.notIn={fullNameEnNotIn}&codeName.contains={codeNameContains}&codeName.doesNotContain={codeNameDoesNotContain}&codeName.equals={codeNameEquals}&codeName.notEquals={codeNameNotEquals}&codeName.specified={codeNameSpecified}&codeName.in={codeNameIn}&codeName.notIn={codeNameNotIn}&administrativeUnitId.greaterThan={administrativeUnitIdGreaterThan}&administrativeUnitId.lessThan={administrativeUnitIdLessThan}&administrativeUnitId.greaterThanOrEqual={administrativeUnitIdGreaterThanOrEqual}&administrativeUnitId.lessThanOrEqual={administrativeUnitIdLessThanOrEqual}&administrativeUnitId.equals={administrativeUnitIdEquals}&administrativeUnitId.notEquals={administrativeUnitIdNotEquals}&administrativeUnitId.specified={administrativeUnitIdSpecified}&administrativeUnitId.in={administrativeUnitIdIn}&administrativeUnitId.notIn={administrativeUnitIdNotIn}&administrativeRegionId.greaterThan={administrativeRegionIdGreaterThan}&administrativeRegionId.lessThan={administrativeRegionIdLessThan}&administrativeRegionId.greaterThanOrEqual={administrativeRegionIdGreaterThanOrEqual}&administrativeRegionId.lessThanOrEqual={administrativeRegionIdLessThanOrEqual}&administrativeRegionId.equals={administrativeRegionIdEquals}&administrativeRegionId.notEquals={administrativeRegionIdNotEquals}&administrativeRegionId.specified={administrativeRegionIdSpecified}&administrativeRegionId.in={administrativeRegionIdIn}&administrativeRegionId.notIn={administrativeRegionIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&districtsId.greaterThan={districtsIdGreaterThan}&districtsId.lessThan={districtsIdLessThan}&districtsId.greaterThanOrEqual={districtsIdGreaterThanOrEqual}&districtsId.lessThanOrEqual={districtsIdLessThanOrEqual}&districtsId.equals={districtsIdEquals}&districtsId.notEquals={districtsIdNotEquals}&districtsId.specified={districtsIdSpecified}&districtsId.in={districtsIdIn}&districtsId.notIn={districtsIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  Long countProvinces(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("provinceCodeContains") @jakarta.annotation.Nullable String provinceCodeContains, @Param("provinceCodeDoesNotContain") @jakarta.annotation.Nullable String provinceCodeDoesNotContain, @Param("provinceCodeEquals") @jakarta.annotation.Nullable String provinceCodeEquals, @Param("provinceCodeNotEquals") @jakarta.annotation.Nullable String provinceCodeNotEquals, @Param("provinceCodeSpecified") @jakarta.annotation.Nullable Boolean provinceCodeSpecified, @Param("provinceCodeIn") @jakarta.annotation.Nullable List<String> provinceCodeIn, @Param("provinceCodeNotIn") @jakarta.annotation.Nullable List<String> provinceCodeNotIn, @Param("nameContains") @jakarta.annotation.Nullable String nameContains, @Param("nameDoesNotContain") @jakarta.annotation.Nullable String nameDoesNotContain, @Param("nameEquals") @jakarta.annotation.Nullable String nameEquals, @Param("nameNotEquals") @jakarta.annotation.Nullable String nameNotEquals, @Param("nameSpecified") @jakarta.annotation.Nullable Boolean nameSpecified, @Param("nameIn") @jakarta.annotation.Nullable List<String> nameIn, @Param("nameNotIn") @jakarta.annotation.Nullable List<String> nameNotIn, @Param("nameEnContains") @jakarta.annotation.Nullable String nameEnContains, @Param("nameEnDoesNotContain") @jakarta.annotation.Nullable String nameEnDoesNotContain, @Param("nameEnEquals") @jakarta.annotation.Nullable String nameEnEquals, @Param("nameEnNotEquals") @jakarta.annotation.Nullable String nameEnNotEquals, @Param("nameEnSpecified") @jakarta.annotation.Nullable Boolean nameEnSpecified, @Param("nameEnIn") @jakarta.annotation.Nullable List<String> nameEnIn, @Param("nameEnNotIn") @jakarta.annotation.Nullable List<String> nameEnNotIn, @Param("fullNameContains") @jakarta.annotation.Nullable String fullNameContains, @Param("fullNameDoesNotContain") @jakarta.annotation.Nullable String fullNameDoesNotContain, @Param("fullNameEquals") @jakarta.annotation.Nullable String fullNameEquals, @Param("fullNameNotEquals") @jakarta.annotation.Nullable String fullNameNotEquals, @Param("fullNameSpecified") @jakarta.annotation.Nullable Boolean fullNameSpecified, @Param("fullNameIn") @jakarta.annotation.Nullable List<String> fullNameIn, @Param("fullNameNotIn") @jakarta.annotation.Nullable List<String> fullNameNotIn, @Param("fullNameEnContains") @jakarta.annotation.Nullable String fullNameEnContains, @Param("fullNameEnDoesNotContain") @jakarta.annotation.Nullable String fullNameEnDoesNotContain, @Param("fullNameEnEquals") @jakarta.annotation.Nullable String fullNameEnEquals, @Param("fullNameEnNotEquals") @jakarta.annotation.Nullable String fullNameEnNotEquals, @Param("fullNameEnSpecified") @jakarta.annotation.Nullable Boolean fullNameEnSpecified, @Param("fullNameEnIn") @jakarta.annotation.Nullable List<String> fullNameEnIn, @Param("fullNameEnNotIn") @jakarta.annotation.Nullable List<String> fullNameEnNotIn, @Param("codeNameContains") @jakarta.annotation.Nullable String codeNameContains, @Param("codeNameDoesNotContain") @jakarta.annotation.Nullable String codeNameDoesNotContain, @Param("codeNameEquals") @jakarta.annotation.Nullable String codeNameEquals, @Param("codeNameNotEquals") @jakarta.annotation.Nullable String codeNameNotEquals, @Param("codeNameSpecified") @jakarta.annotation.Nullable Boolean codeNameSpecified, @Param("codeNameIn") @jakarta.annotation.Nullable List<String> codeNameIn, @Param("codeNameNotIn") @jakarta.annotation.Nullable List<String> codeNameNotIn, @Param("administrativeUnitIdGreaterThan") @jakarta.annotation.Nullable Integer administrativeUnitIdGreaterThan, @Param("administrativeUnitIdLessThan") @jakarta.annotation.Nullable Integer administrativeUnitIdLessThan, @Param("administrativeUnitIdGreaterThanOrEqual") @jakarta.annotation.Nullable Integer administrativeUnitIdGreaterThanOrEqual, @Param("administrativeUnitIdLessThanOrEqual") @jakarta.annotation.Nullable Integer administrativeUnitIdLessThanOrEqual, @Param("administrativeUnitIdEquals") @jakarta.annotation.Nullable Integer administrativeUnitIdEquals, @Param("administrativeUnitIdNotEquals") @jakarta.annotation.Nullable Integer administrativeUnitIdNotEquals, @Param("administrativeUnitIdSpecified") @jakarta.annotation.Nullable Boolean administrativeUnitIdSpecified, @Param("administrativeUnitIdIn") @jakarta.annotation.Nullable List<Integer> administrativeUnitIdIn, @Param("administrativeUnitIdNotIn") @jakarta.annotation.Nullable List<Integer> administrativeUnitIdNotIn, @Param("administrativeRegionIdGreaterThan") @jakarta.annotation.Nullable Integer administrativeRegionIdGreaterThan, @Param("administrativeRegionIdLessThan") @jakarta.annotation.Nullable Integer administrativeRegionIdLessThan, @Param("administrativeRegionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Integer administrativeRegionIdGreaterThanOrEqual, @Param("administrativeRegionIdLessThanOrEqual") @jakarta.annotation.Nullable Integer administrativeRegionIdLessThanOrEqual, @Param("administrativeRegionIdEquals") @jakarta.annotation.Nullable Integer administrativeRegionIdEquals, @Param("administrativeRegionIdNotEquals") @jakarta.annotation.Nullable Integer administrativeRegionIdNotEquals, @Param("administrativeRegionIdSpecified") @jakarta.annotation.Nullable Boolean administrativeRegionIdSpecified, @Param("administrativeRegionIdIn") @jakarta.annotation.Nullable List<Integer> administrativeRegionIdIn, @Param("administrativeRegionIdNotIn") @jakarta.annotation.Nullable List<Integer> administrativeRegionIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("districtsIdGreaterThan") @jakarta.annotation.Nullable Long districtsIdGreaterThan, @Param("districtsIdLessThan") @jakarta.annotation.Nullable Long districtsIdLessThan, @Param("districtsIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long districtsIdGreaterThanOrEqual, @Param("districtsIdLessThanOrEqual") @jakarta.annotation.Nullable Long districtsIdLessThanOrEqual, @Param("districtsIdEquals") @jakarta.annotation.Nullable Long districtsIdEquals, @Param("districtsIdNotEquals") @jakarta.annotation.Nullable Long districtsIdNotEquals, @Param("districtsIdSpecified") @jakarta.annotation.Nullable Boolean districtsIdSpecified, @Param("districtsIdIn") @jakarta.annotation.Nullable List<Long> districtsIdIn, @Param("districtsIdNotIn") @jakarta.annotation.Nullable List<Long> districtsIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>countProvinces</code> but it also returns the http response headers .
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
   * @param provinceCodeContains  (optional)
   * @param provinceCodeDoesNotContain  (optional)
   * @param provinceCodeEquals  (optional)
   * @param provinceCodeNotEquals  (optional)
   * @param provinceCodeSpecified  (optional)
   * @param provinceCodeIn  (optional)
   * @param provinceCodeNotIn  (optional)
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
   * @param administrativeRegionIdGreaterThan  (optional)
   * @param administrativeRegionIdLessThan  (optional)
   * @param administrativeRegionIdGreaterThanOrEqual  (optional)
   * @param administrativeRegionIdLessThanOrEqual  (optional)
   * @param administrativeRegionIdEquals  (optional)
   * @param administrativeRegionIdNotEquals  (optional)
   * @param administrativeRegionIdSpecified  (optional)
   * @param administrativeRegionIdIn  (optional)
   * @param administrativeRegionIdNotIn  (optional)
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
   * @param districtsIdGreaterThan  (optional)
   * @param districtsIdLessThan  (optional)
   * @param districtsIdGreaterThanOrEqual  (optional)
   * @param districtsIdLessThanOrEqual  (optional)
   * @param districtsIdEquals  (optional)
   * @param districtsIdNotEquals  (optional)
   * @param districtsIdSpecified  (optional)
   * @param districtsIdIn  (optional)
   * @param districtsIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/provinces/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&provinceCode.contains={provinceCodeContains}&provinceCode.doesNotContain={provinceCodeDoesNotContain}&provinceCode.equals={provinceCodeEquals}&provinceCode.notEquals={provinceCodeNotEquals}&provinceCode.specified={provinceCodeSpecified}&provinceCode.in={provinceCodeIn}&provinceCode.notIn={provinceCodeNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&nameEn.contains={nameEnContains}&nameEn.doesNotContain={nameEnDoesNotContain}&nameEn.equals={nameEnEquals}&nameEn.notEquals={nameEnNotEquals}&nameEn.specified={nameEnSpecified}&nameEn.in={nameEnIn}&nameEn.notIn={nameEnNotIn}&fullName.contains={fullNameContains}&fullName.doesNotContain={fullNameDoesNotContain}&fullName.equals={fullNameEquals}&fullName.notEquals={fullNameNotEquals}&fullName.specified={fullNameSpecified}&fullName.in={fullNameIn}&fullName.notIn={fullNameNotIn}&fullNameEn.contains={fullNameEnContains}&fullNameEn.doesNotContain={fullNameEnDoesNotContain}&fullNameEn.equals={fullNameEnEquals}&fullNameEn.notEquals={fullNameEnNotEquals}&fullNameEn.specified={fullNameEnSpecified}&fullNameEn.in={fullNameEnIn}&fullNameEn.notIn={fullNameEnNotIn}&codeName.contains={codeNameContains}&codeName.doesNotContain={codeNameDoesNotContain}&codeName.equals={codeNameEquals}&codeName.notEquals={codeNameNotEquals}&codeName.specified={codeNameSpecified}&codeName.in={codeNameIn}&codeName.notIn={codeNameNotIn}&administrativeUnitId.greaterThan={administrativeUnitIdGreaterThan}&administrativeUnitId.lessThan={administrativeUnitIdLessThan}&administrativeUnitId.greaterThanOrEqual={administrativeUnitIdGreaterThanOrEqual}&administrativeUnitId.lessThanOrEqual={administrativeUnitIdLessThanOrEqual}&administrativeUnitId.equals={administrativeUnitIdEquals}&administrativeUnitId.notEquals={administrativeUnitIdNotEquals}&administrativeUnitId.specified={administrativeUnitIdSpecified}&administrativeUnitId.in={administrativeUnitIdIn}&administrativeUnitId.notIn={administrativeUnitIdNotIn}&administrativeRegionId.greaterThan={administrativeRegionIdGreaterThan}&administrativeRegionId.lessThan={administrativeRegionIdLessThan}&administrativeRegionId.greaterThanOrEqual={administrativeRegionIdGreaterThanOrEqual}&administrativeRegionId.lessThanOrEqual={administrativeRegionIdLessThanOrEqual}&administrativeRegionId.equals={administrativeRegionIdEquals}&administrativeRegionId.notEquals={administrativeRegionIdNotEquals}&administrativeRegionId.specified={administrativeRegionIdSpecified}&administrativeRegionId.in={administrativeRegionIdIn}&administrativeRegionId.notIn={administrativeRegionIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&districtsId.greaterThan={districtsIdGreaterThan}&districtsId.lessThan={districtsIdLessThan}&districtsId.greaterThanOrEqual={districtsIdGreaterThanOrEqual}&districtsId.lessThanOrEqual={districtsIdLessThanOrEqual}&districtsId.equals={districtsIdEquals}&districtsId.notEquals={districtsIdNotEquals}&districtsId.specified={districtsIdSpecified}&districtsId.in={districtsIdIn}&districtsId.notIn={districtsIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Long> countProvincesWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("provinceCodeContains") @jakarta.annotation.Nullable String provinceCodeContains, @Param("provinceCodeDoesNotContain") @jakarta.annotation.Nullable String provinceCodeDoesNotContain, @Param("provinceCodeEquals") @jakarta.annotation.Nullable String provinceCodeEquals, @Param("provinceCodeNotEquals") @jakarta.annotation.Nullable String provinceCodeNotEquals, @Param("provinceCodeSpecified") @jakarta.annotation.Nullable Boolean provinceCodeSpecified, @Param("provinceCodeIn") @jakarta.annotation.Nullable List<String> provinceCodeIn, @Param("provinceCodeNotIn") @jakarta.annotation.Nullable List<String> provinceCodeNotIn, @Param("nameContains") @jakarta.annotation.Nullable String nameContains, @Param("nameDoesNotContain") @jakarta.annotation.Nullable String nameDoesNotContain, @Param("nameEquals") @jakarta.annotation.Nullable String nameEquals, @Param("nameNotEquals") @jakarta.annotation.Nullable String nameNotEquals, @Param("nameSpecified") @jakarta.annotation.Nullable Boolean nameSpecified, @Param("nameIn") @jakarta.annotation.Nullable List<String> nameIn, @Param("nameNotIn") @jakarta.annotation.Nullable List<String> nameNotIn, @Param("nameEnContains") @jakarta.annotation.Nullable String nameEnContains, @Param("nameEnDoesNotContain") @jakarta.annotation.Nullable String nameEnDoesNotContain, @Param("nameEnEquals") @jakarta.annotation.Nullable String nameEnEquals, @Param("nameEnNotEquals") @jakarta.annotation.Nullable String nameEnNotEquals, @Param("nameEnSpecified") @jakarta.annotation.Nullable Boolean nameEnSpecified, @Param("nameEnIn") @jakarta.annotation.Nullable List<String> nameEnIn, @Param("nameEnNotIn") @jakarta.annotation.Nullable List<String> nameEnNotIn, @Param("fullNameContains") @jakarta.annotation.Nullable String fullNameContains, @Param("fullNameDoesNotContain") @jakarta.annotation.Nullable String fullNameDoesNotContain, @Param("fullNameEquals") @jakarta.annotation.Nullable String fullNameEquals, @Param("fullNameNotEquals") @jakarta.annotation.Nullable String fullNameNotEquals, @Param("fullNameSpecified") @jakarta.annotation.Nullable Boolean fullNameSpecified, @Param("fullNameIn") @jakarta.annotation.Nullable List<String> fullNameIn, @Param("fullNameNotIn") @jakarta.annotation.Nullable List<String> fullNameNotIn, @Param("fullNameEnContains") @jakarta.annotation.Nullable String fullNameEnContains, @Param("fullNameEnDoesNotContain") @jakarta.annotation.Nullable String fullNameEnDoesNotContain, @Param("fullNameEnEquals") @jakarta.annotation.Nullable String fullNameEnEquals, @Param("fullNameEnNotEquals") @jakarta.annotation.Nullable String fullNameEnNotEquals, @Param("fullNameEnSpecified") @jakarta.annotation.Nullable Boolean fullNameEnSpecified, @Param("fullNameEnIn") @jakarta.annotation.Nullable List<String> fullNameEnIn, @Param("fullNameEnNotIn") @jakarta.annotation.Nullable List<String> fullNameEnNotIn, @Param("codeNameContains") @jakarta.annotation.Nullable String codeNameContains, @Param("codeNameDoesNotContain") @jakarta.annotation.Nullable String codeNameDoesNotContain, @Param("codeNameEquals") @jakarta.annotation.Nullable String codeNameEquals, @Param("codeNameNotEquals") @jakarta.annotation.Nullable String codeNameNotEquals, @Param("codeNameSpecified") @jakarta.annotation.Nullable Boolean codeNameSpecified, @Param("codeNameIn") @jakarta.annotation.Nullable List<String> codeNameIn, @Param("codeNameNotIn") @jakarta.annotation.Nullable List<String> codeNameNotIn, @Param("administrativeUnitIdGreaterThan") @jakarta.annotation.Nullable Integer administrativeUnitIdGreaterThan, @Param("administrativeUnitIdLessThan") @jakarta.annotation.Nullable Integer administrativeUnitIdLessThan, @Param("administrativeUnitIdGreaterThanOrEqual") @jakarta.annotation.Nullable Integer administrativeUnitIdGreaterThanOrEqual, @Param("administrativeUnitIdLessThanOrEqual") @jakarta.annotation.Nullable Integer administrativeUnitIdLessThanOrEqual, @Param("administrativeUnitIdEquals") @jakarta.annotation.Nullable Integer administrativeUnitIdEquals, @Param("administrativeUnitIdNotEquals") @jakarta.annotation.Nullable Integer administrativeUnitIdNotEquals, @Param("administrativeUnitIdSpecified") @jakarta.annotation.Nullable Boolean administrativeUnitIdSpecified, @Param("administrativeUnitIdIn") @jakarta.annotation.Nullable List<Integer> administrativeUnitIdIn, @Param("administrativeUnitIdNotIn") @jakarta.annotation.Nullable List<Integer> administrativeUnitIdNotIn, @Param("administrativeRegionIdGreaterThan") @jakarta.annotation.Nullable Integer administrativeRegionIdGreaterThan, @Param("administrativeRegionIdLessThan") @jakarta.annotation.Nullable Integer administrativeRegionIdLessThan, @Param("administrativeRegionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Integer administrativeRegionIdGreaterThanOrEqual, @Param("administrativeRegionIdLessThanOrEqual") @jakarta.annotation.Nullable Integer administrativeRegionIdLessThanOrEqual, @Param("administrativeRegionIdEquals") @jakarta.annotation.Nullable Integer administrativeRegionIdEquals, @Param("administrativeRegionIdNotEquals") @jakarta.annotation.Nullable Integer administrativeRegionIdNotEquals, @Param("administrativeRegionIdSpecified") @jakarta.annotation.Nullable Boolean administrativeRegionIdSpecified, @Param("administrativeRegionIdIn") @jakarta.annotation.Nullable List<Integer> administrativeRegionIdIn, @Param("administrativeRegionIdNotIn") @jakarta.annotation.Nullable List<Integer> administrativeRegionIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("districtsIdGreaterThan") @jakarta.annotation.Nullable Long districtsIdGreaterThan, @Param("districtsIdLessThan") @jakarta.annotation.Nullable Long districtsIdLessThan, @Param("districtsIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long districtsIdGreaterThanOrEqual, @Param("districtsIdLessThanOrEqual") @jakarta.annotation.Nullable Long districtsIdLessThanOrEqual, @Param("districtsIdEquals") @jakarta.annotation.Nullable Long districtsIdEquals, @Param("districtsIdNotEquals") @jakarta.annotation.Nullable Long districtsIdNotEquals, @Param("districtsIdSpecified") @jakarta.annotation.Nullable Boolean districtsIdSpecified, @Param("districtsIdIn") @jakarta.annotation.Nullable List<Long> districtsIdIn, @Param("districtsIdNotIn") @jakarta.annotation.Nullable List<Long> districtsIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>countProvinces</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CountProvincesQueryParams} class that allows for
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
   *   <li>provinceCodeContains -  (optional)</li>
   *   <li>provinceCodeDoesNotContain -  (optional)</li>
   *   <li>provinceCodeEquals -  (optional)</li>
   *   <li>provinceCodeNotEquals -  (optional)</li>
   *   <li>provinceCodeSpecified -  (optional)</li>
   *   <li>provinceCodeIn -  (optional)</li>
   *   <li>provinceCodeNotIn -  (optional)</li>
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
   *   <li>administrativeRegionIdGreaterThan -  (optional)</li>
   *   <li>administrativeRegionIdLessThan -  (optional)</li>
   *   <li>administrativeRegionIdGreaterThanOrEqual -  (optional)</li>
   *   <li>administrativeRegionIdLessThanOrEqual -  (optional)</li>
   *   <li>administrativeRegionIdEquals -  (optional)</li>
   *   <li>administrativeRegionIdNotEquals -  (optional)</li>
   *   <li>administrativeRegionIdSpecified -  (optional)</li>
   *   <li>administrativeRegionIdIn -  (optional)</li>
   *   <li>administrativeRegionIdNotIn -  (optional)</li>
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
   *   <li>districtsIdGreaterThan -  (optional)</li>
   *   <li>districtsIdLessThan -  (optional)</li>
   *   <li>districtsIdGreaterThanOrEqual -  (optional)</li>
   *   <li>districtsIdLessThanOrEqual -  (optional)</li>
   *   <li>districtsIdEquals -  (optional)</li>
   *   <li>districtsIdNotEquals -  (optional)</li>
   *   <li>districtsIdSpecified -  (optional)</li>
   *   <li>districtsIdIn -  (optional)</li>
   *   <li>districtsIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return Long
   */
  @RequestLine("GET /api/provinces/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&provinceCode.contains={provinceCodeContains}&provinceCode.doesNotContain={provinceCodeDoesNotContain}&provinceCode.equals={provinceCodeEquals}&provinceCode.notEquals={provinceCodeNotEquals}&provinceCode.specified={provinceCodeSpecified}&provinceCode.in={provinceCodeIn}&provinceCode.notIn={provinceCodeNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&nameEn.contains={nameEnContains}&nameEn.doesNotContain={nameEnDoesNotContain}&nameEn.equals={nameEnEquals}&nameEn.notEquals={nameEnNotEquals}&nameEn.specified={nameEnSpecified}&nameEn.in={nameEnIn}&nameEn.notIn={nameEnNotIn}&fullName.contains={fullNameContains}&fullName.doesNotContain={fullNameDoesNotContain}&fullName.equals={fullNameEquals}&fullName.notEquals={fullNameNotEquals}&fullName.specified={fullNameSpecified}&fullName.in={fullNameIn}&fullName.notIn={fullNameNotIn}&fullNameEn.contains={fullNameEnContains}&fullNameEn.doesNotContain={fullNameEnDoesNotContain}&fullNameEn.equals={fullNameEnEquals}&fullNameEn.notEquals={fullNameEnNotEquals}&fullNameEn.specified={fullNameEnSpecified}&fullNameEn.in={fullNameEnIn}&fullNameEn.notIn={fullNameEnNotIn}&codeName.contains={codeNameContains}&codeName.doesNotContain={codeNameDoesNotContain}&codeName.equals={codeNameEquals}&codeName.notEquals={codeNameNotEquals}&codeName.specified={codeNameSpecified}&codeName.in={codeNameIn}&codeName.notIn={codeNameNotIn}&administrativeUnitId.greaterThan={administrativeUnitIdGreaterThan}&administrativeUnitId.lessThan={administrativeUnitIdLessThan}&administrativeUnitId.greaterThanOrEqual={administrativeUnitIdGreaterThanOrEqual}&administrativeUnitId.lessThanOrEqual={administrativeUnitIdLessThanOrEqual}&administrativeUnitId.equals={administrativeUnitIdEquals}&administrativeUnitId.notEquals={administrativeUnitIdNotEquals}&administrativeUnitId.specified={administrativeUnitIdSpecified}&administrativeUnitId.in={administrativeUnitIdIn}&administrativeUnitId.notIn={administrativeUnitIdNotIn}&administrativeRegionId.greaterThan={administrativeRegionIdGreaterThan}&administrativeRegionId.lessThan={administrativeRegionIdLessThan}&administrativeRegionId.greaterThanOrEqual={administrativeRegionIdGreaterThanOrEqual}&administrativeRegionId.lessThanOrEqual={administrativeRegionIdLessThanOrEqual}&administrativeRegionId.equals={administrativeRegionIdEquals}&administrativeRegionId.notEquals={administrativeRegionIdNotEquals}&administrativeRegionId.specified={administrativeRegionIdSpecified}&administrativeRegionId.in={administrativeRegionIdIn}&administrativeRegionId.notIn={administrativeRegionIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&districtsId.greaterThan={districtsIdGreaterThan}&districtsId.lessThan={districtsIdLessThan}&districtsId.greaterThanOrEqual={districtsIdGreaterThanOrEqual}&districtsId.lessThanOrEqual={districtsIdLessThanOrEqual}&districtsId.equals={districtsIdEquals}&districtsId.notEquals={districtsIdNotEquals}&districtsId.specified={districtsIdSpecified}&districtsId.in={districtsIdIn}&districtsId.notIn={districtsIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  Long countProvinces(@QueryMap(encoded=true) CountProvincesQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>countProvinces</code> that receives the query parameters as a map,
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
          *   <li>provinceCodeContains -  (optional)</li>
          *   <li>provinceCodeDoesNotContain -  (optional)</li>
          *   <li>provinceCodeEquals -  (optional)</li>
          *   <li>provinceCodeNotEquals -  (optional)</li>
          *   <li>provinceCodeSpecified -  (optional)</li>
          *   <li>provinceCodeIn -  (optional)</li>
          *   <li>provinceCodeNotIn -  (optional)</li>
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
          *   <li>administrativeRegionIdGreaterThan -  (optional)</li>
          *   <li>administrativeRegionIdLessThan -  (optional)</li>
          *   <li>administrativeRegionIdGreaterThanOrEqual -  (optional)</li>
          *   <li>administrativeRegionIdLessThanOrEqual -  (optional)</li>
          *   <li>administrativeRegionIdEquals -  (optional)</li>
          *   <li>administrativeRegionIdNotEquals -  (optional)</li>
          *   <li>administrativeRegionIdSpecified -  (optional)</li>
          *   <li>administrativeRegionIdIn -  (optional)</li>
          *   <li>administrativeRegionIdNotIn -  (optional)</li>
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
          *   <li>districtsIdGreaterThan -  (optional)</li>
          *   <li>districtsIdLessThan -  (optional)</li>
          *   <li>districtsIdGreaterThanOrEqual -  (optional)</li>
          *   <li>districtsIdLessThanOrEqual -  (optional)</li>
          *   <li>districtsIdEquals -  (optional)</li>
          *   <li>districtsIdNotEquals -  (optional)</li>
          *   <li>districtsIdSpecified -  (optional)</li>
          *   <li>districtsIdIn -  (optional)</li>
          *   <li>districtsIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return Long
      */
      @RequestLine("GET /api/provinces/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&provinceCode.contains={provinceCodeContains}&provinceCode.doesNotContain={provinceCodeDoesNotContain}&provinceCode.equals={provinceCodeEquals}&provinceCode.notEquals={provinceCodeNotEquals}&provinceCode.specified={provinceCodeSpecified}&provinceCode.in={provinceCodeIn}&provinceCode.notIn={provinceCodeNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&nameEn.contains={nameEnContains}&nameEn.doesNotContain={nameEnDoesNotContain}&nameEn.equals={nameEnEquals}&nameEn.notEquals={nameEnNotEquals}&nameEn.specified={nameEnSpecified}&nameEn.in={nameEnIn}&nameEn.notIn={nameEnNotIn}&fullName.contains={fullNameContains}&fullName.doesNotContain={fullNameDoesNotContain}&fullName.equals={fullNameEquals}&fullName.notEquals={fullNameNotEquals}&fullName.specified={fullNameSpecified}&fullName.in={fullNameIn}&fullName.notIn={fullNameNotIn}&fullNameEn.contains={fullNameEnContains}&fullNameEn.doesNotContain={fullNameEnDoesNotContain}&fullNameEn.equals={fullNameEnEquals}&fullNameEn.notEquals={fullNameEnNotEquals}&fullNameEn.specified={fullNameEnSpecified}&fullNameEn.in={fullNameEnIn}&fullNameEn.notIn={fullNameEnNotIn}&codeName.contains={codeNameContains}&codeName.doesNotContain={codeNameDoesNotContain}&codeName.equals={codeNameEquals}&codeName.notEquals={codeNameNotEquals}&codeName.specified={codeNameSpecified}&codeName.in={codeNameIn}&codeName.notIn={codeNameNotIn}&administrativeUnitId.greaterThan={administrativeUnitIdGreaterThan}&administrativeUnitId.lessThan={administrativeUnitIdLessThan}&administrativeUnitId.greaterThanOrEqual={administrativeUnitIdGreaterThanOrEqual}&administrativeUnitId.lessThanOrEqual={administrativeUnitIdLessThanOrEqual}&administrativeUnitId.equals={administrativeUnitIdEquals}&administrativeUnitId.notEquals={administrativeUnitIdNotEquals}&administrativeUnitId.specified={administrativeUnitIdSpecified}&administrativeUnitId.in={administrativeUnitIdIn}&administrativeUnitId.notIn={administrativeUnitIdNotIn}&administrativeRegionId.greaterThan={administrativeRegionIdGreaterThan}&administrativeRegionId.lessThan={administrativeRegionIdLessThan}&administrativeRegionId.greaterThanOrEqual={administrativeRegionIdGreaterThanOrEqual}&administrativeRegionId.lessThanOrEqual={administrativeRegionIdLessThanOrEqual}&administrativeRegionId.equals={administrativeRegionIdEquals}&administrativeRegionId.notEquals={administrativeRegionIdNotEquals}&administrativeRegionId.specified={administrativeRegionIdSpecified}&administrativeRegionId.in={administrativeRegionIdIn}&administrativeRegionId.notIn={administrativeRegionIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&districtsId.greaterThan={districtsIdGreaterThan}&districtsId.lessThan={districtsIdLessThan}&districtsId.greaterThanOrEqual={districtsIdGreaterThanOrEqual}&districtsId.lessThanOrEqual={districtsIdLessThanOrEqual}&districtsId.equals={districtsIdEquals}&districtsId.notEquals={districtsIdNotEquals}&districtsId.specified={districtsIdSpecified}&districtsId.in={districtsIdIn}&districtsId.notIn={districtsIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Long> countProvincesWithHttpInfo(@QueryMap(encoded=true) CountProvincesQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>countProvinces</code> method in a fluent style.
   */
  public static class CountProvincesQueryParams extends HashMap<String, Object> {
    public CountProvincesQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProvincesQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProvincesQueryParams provinceCodeContains(@jakarta.annotation.Nullable final String value) {
      put("provinceCode.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams provinceCodeDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("provinceCode.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams provinceCodeEquals(@jakarta.annotation.Nullable final String value) {
      put("provinceCode.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams provinceCodeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("provinceCode.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams provinceCodeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("provinceCode.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams provinceCodeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("provinceCode.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProvincesQueryParams provinceCodeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("provinceCode.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProvincesQueryParams nameContains(@jakarta.annotation.Nullable final String value) {
      put("name.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams nameDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("name.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams nameEquals(@jakarta.annotation.Nullable final String value) {
      put("name.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams nameNotEquals(@jakarta.annotation.Nullable final String value) {
      put("name.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams nameSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("name.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams nameIn(@jakarta.annotation.Nullable final List<String> value) {
      put("name.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProvincesQueryParams nameNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("name.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProvincesQueryParams nameEnContains(@jakarta.annotation.Nullable final String value) {
      put("nameEn.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams nameEnDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("nameEn.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams nameEnEquals(@jakarta.annotation.Nullable final String value) {
      put("nameEn.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams nameEnNotEquals(@jakarta.annotation.Nullable final String value) {
      put("nameEn.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams nameEnSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("nameEn.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams nameEnIn(@jakarta.annotation.Nullable final List<String> value) {
      put("nameEn.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProvincesQueryParams nameEnNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("nameEn.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProvincesQueryParams fullNameContains(@jakarta.annotation.Nullable final String value) {
      put("fullName.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams fullNameDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("fullName.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams fullNameEquals(@jakarta.annotation.Nullable final String value) {
      put("fullName.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams fullNameNotEquals(@jakarta.annotation.Nullable final String value) {
      put("fullName.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams fullNameSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("fullName.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams fullNameIn(@jakarta.annotation.Nullable final List<String> value) {
      put("fullName.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProvincesQueryParams fullNameNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("fullName.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProvincesQueryParams fullNameEnContains(@jakarta.annotation.Nullable final String value) {
      put("fullNameEn.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams fullNameEnDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("fullNameEn.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams fullNameEnEquals(@jakarta.annotation.Nullable final String value) {
      put("fullNameEn.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams fullNameEnNotEquals(@jakarta.annotation.Nullable final String value) {
      put("fullNameEn.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams fullNameEnSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("fullNameEn.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams fullNameEnIn(@jakarta.annotation.Nullable final List<String> value) {
      put("fullNameEn.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProvincesQueryParams fullNameEnNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("fullNameEn.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProvincesQueryParams codeNameContains(@jakarta.annotation.Nullable final String value) {
      put("codeName.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams codeNameDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("codeName.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams codeNameEquals(@jakarta.annotation.Nullable final String value) {
      put("codeName.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams codeNameNotEquals(@jakarta.annotation.Nullable final String value) {
      put("codeName.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams codeNameSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("codeName.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams codeNameIn(@jakarta.annotation.Nullable final List<String> value) {
      put("codeName.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProvincesQueryParams codeNameNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("codeName.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProvincesQueryParams administrativeUnitIdGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams administrativeUnitIdLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams administrativeUnitIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams administrativeUnitIdLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams administrativeUnitIdEquals(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams administrativeUnitIdNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams administrativeUnitIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("administrativeUnitId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams administrativeUnitIdIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("administrativeUnitId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProvincesQueryParams administrativeUnitIdNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("administrativeUnitId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProvincesQueryParams administrativeRegionIdGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeRegionId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams administrativeRegionIdLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeRegionId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams administrativeRegionIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeRegionId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams administrativeRegionIdLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeRegionId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams administrativeRegionIdEquals(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeRegionId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams administrativeRegionIdNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeRegionId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams administrativeRegionIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("administrativeRegionId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams administrativeRegionIdIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("administrativeRegionId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProvincesQueryParams administrativeRegionIdNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("administrativeRegionId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProvincesQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProvincesQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProvincesQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProvincesQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProvincesQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProvincesQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProvincesQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProvincesQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProvincesQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProvincesQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProvincesQueryParams districtsIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("districtsId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams districtsIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("districtsId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams districtsIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("districtsId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams districtsIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("districtsId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams districtsIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("districtsId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams districtsIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("districtsId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams districtsIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("districtsId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountProvincesQueryParams districtsIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("districtsId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProvincesQueryParams districtsIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("districtsId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountProvincesQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param provinceDTO  (required)
   * @return ProvinceDTO
   */
  @RequestLine("POST /api/provinces")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ProvinceDTO createProvince(@jakarta.annotation.Nonnull ProvinceDTO provinceDTO);

  /**
   * 
   * Similar to <code>createProvince</code> but it also returns the http response headers .
   * 
   * @param provinceDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/provinces")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<ProvinceDTO> createProvinceWithHttpInfo(@jakarta.annotation.Nonnull ProvinceDTO provinceDTO);



  /**
   * 
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/provinces/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteProvince(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>deleteProvince</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/provinces/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteProvinceWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



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
   * @param provinceCodeContains  (optional)
   * @param provinceCodeDoesNotContain  (optional)
   * @param provinceCodeEquals  (optional)
   * @param provinceCodeNotEquals  (optional)
   * @param provinceCodeSpecified  (optional)
   * @param provinceCodeIn  (optional)
   * @param provinceCodeNotIn  (optional)
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
   * @param administrativeRegionIdGreaterThan  (optional)
   * @param administrativeRegionIdLessThan  (optional)
   * @param administrativeRegionIdGreaterThanOrEqual  (optional)
   * @param administrativeRegionIdLessThanOrEqual  (optional)
   * @param administrativeRegionIdEquals  (optional)
   * @param administrativeRegionIdNotEquals  (optional)
   * @param administrativeRegionIdSpecified  (optional)
   * @param administrativeRegionIdIn  (optional)
   * @param administrativeRegionIdNotIn  (optional)
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
   * @param districtsIdGreaterThan  (optional)
   * @param districtsIdLessThan  (optional)
   * @param districtsIdGreaterThanOrEqual  (optional)
   * @param districtsIdLessThanOrEqual  (optional)
   * @param districtsIdEquals  (optional)
   * @param districtsIdNotEquals  (optional)
   * @param districtsIdSpecified  (optional)
   * @param districtsIdIn  (optional)
   * @param districtsIdNotIn  (optional)
   * @param distinct  (optional)
   * @return List&lt;ProvinceDTO&gt;
   */
  @RequestLine("GET /api/provinces?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&provinceCode.contains={provinceCodeContains}&provinceCode.doesNotContain={provinceCodeDoesNotContain}&provinceCode.equals={provinceCodeEquals}&provinceCode.notEquals={provinceCodeNotEquals}&provinceCode.specified={provinceCodeSpecified}&provinceCode.in={provinceCodeIn}&provinceCode.notIn={provinceCodeNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&nameEn.contains={nameEnContains}&nameEn.doesNotContain={nameEnDoesNotContain}&nameEn.equals={nameEnEquals}&nameEn.notEquals={nameEnNotEquals}&nameEn.specified={nameEnSpecified}&nameEn.in={nameEnIn}&nameEn.notIn={nameEnNotIn}&fullName.contains={fullNameContains}&fullName.doesNotContain={fullNameDoesNotContain}&fullName.equals={fullNameEquals}&fullName.notEquals={fullNameNotEquals}&fullName.specified={fullNameSpecified}&fullName.in={fullNameIn}&fullName.notIn={fullNameNotIn}&fullNameEn.contains={fullNameEnContains}&fullNameEn.doesNotContain={fullNameEnDoesNotContain}&fullNameEn.equals={fullNameEnEquals}&fullNameEn.notEquals={fullNameEnNotEquals}&fullNameEn.specified={fullNameEnSpecified}&fullNameEn.in={fullNameEnIn}&fullNameEn.notIn={fullNameEnNotIn}&codeName.contains={codeNameContains}&codeName.doesNotContain={codeNameDoesNotContain}&codeName.equals={codeNameEquals}&codeName.notEquals={codeNameNotEquals}&codeName.specified={codeNameSpecified}&codeName.in={codeNameIn}&codeName.notIn={codeNameNotIn}&administrativeUnitId.greaterThan={administrativeUnitIdGreaterThan}&administrativeUnitId.lessThan={administrativeUnitIdLessThan}&administrativeUnitId.greaterThanOrEqual={administrativeUnitIdGreaterThanOrEqual}&administrativeUnitId.lessThanOrEqual={administrativeUnitIdLessThanOrEqual}&administrativeUnitId.equals={administrativeUnitIdEquals}&administrativeUnitId.notEquals={administrativeUnitIdNotEquals}&administrativeUnitId.specified={administrativeUnitIdSpecified}&administrativeUnitId.in={administrativeUnitIdIn}&administrativeUnitId.notIn={administrativeUnitIdNotIn}&administrativeRegionId.greaterThan={administrativeRegionIdGreaterThan}&administrativeRegionId.lessThan={administrativeRegionIdLessThan}&administrativeRegionId.greaterThanOrEqual={administrativeRegionIdGreaterThanOrEqual}&administrativeRegionId.lessThanOrEqual={administrativeRegionIdLessThanOrEqual}&administrativeRegionId.equals={administrativeRegionIdEquals}&administrativeRegionId.notEquals={administrativeRegionIdNotEquals}&administrativeRegionId.specified={administrativeRegionIdSpecified}&administrativeRegionId.in={administrativeRegionIdIn}&administrativeRegionId.notIn={administrativeRegionIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&districtsId.greaterThan={districtsIdGreaterThan}&districtsId.lessThan={districtsIdLessThan}&districtsId.greaterThanOrEqual={districtsIdGreaterThanOrEqual}&districtsId.lessThanOrEqual={districtsIdLessThanOrEqual}&districtsId.equals={districtsIdEquals}&districtsId.notEquals={districtsIdNotEquals}&districtsId.specified={districtsIdSpecified}&districtsId.in={districtsIdIn}&districtsId.notIn={districtsIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  List<ProvinceDTO> getAllProvinces(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("provinceCodeContains") @jakarta.annotation.Nullable String provinceCodeContains, @Param("provinceCodeDoesNotContain") @jakarta.annotation.Nullable String provinceCodeDoesNotContain, @Param("provinceCodeEquals") @jakarta.annotation.Nullable String provinceCodeEquals, @Param("provinceCodeNotEquals") @jakarta.annotation.Nullable String provinceCodeNotEquals, @Param("provinceCodeSpecified") @jakarta.annotation.Nullable Boolean provinceCodeSpecified, @Param("provinceCodeIn") @jakarta.annotation.Nullable List<String> provinceCodeIn, @Param("provinceCodeNotIn") @jakarta.annotation.Nullable List<String> provinceCodeNotIn, @Param("nameContains") @jakarta.annotation.Nullable String nameContains, @Param("nameDoesNotContain") @jakarta.annotation.Nullable String nameDoesNotContain, @Param("nameEquals") @jakarta.annotation.Nullable String nameEquals, @Param("nameNotEquals") @jakarta.annotation.Nullable String nameNotEquals, @Param("nameSpecified") @jakarta.annotation.Nullable Boolean nameSpecified, @Param("nameIn") @jakarta.annotation.Nullable List<String> nameIn, @Param("nameNotIn") @jakarta.annotation.Nullable List<String> nameNotIn, @Param("nameEnContains") @jakarta.annotation.Nullable String nameEnContains, @Param("nameEnDoesNotContain") @jakarta.annotation.Nullable String nameEnDoesNotContain, @Param("nameEnEquals") @jakarta.annotation.Nullable String nameEnEquals, @Param("nameEnNotEquals") @jakarta.annotation.Nullable String nameEnNotEquals, @Param("nameEnSpecified") @jakarta.annotation.Nullable Boolean nameEnSpecified, @Param("nameEnIn") @jakarta.annotation.Nullable List<String> nameEnIn, @Param("nameEnNotIn") @jakarta.annotation.Nullable List<String> nameEnNotIn, @Param("fullNameContains") @jakarta.annotation.Nullable String fullNameContains, @Param("fullNameDoesNotContain") @jakarta.annotation.Nullable String fullNameDoesNotContain, @Param("fullNameEquals") @jakarta.annotation.Nullable String fullNameEquals, @Param("fullNameNotEquals") @jakarta.annotation.Nullable String fullNameNotEquals, @Param("fullNameSpecified") @jakarta.annotation.Nullable Boolean fullNameSpecified, @Param("fullNameIn") @jakarta.annotation.Nullable List<String> fullNameIn, @Param("fullNameNotIn") @jakarta.annotation.Nullable List<String> fullNameNotIn, @Param("fullNameEnContains") @jakarta.annotation.Nullable String fullNameEnContains, @Param("fullNameEnDoesNotContain") @jakarta.annotation.Nullable String fullNameEnDoesNotContain, @Param("fullNameEnEquals") @jakarta.annotation.Nullable String fullNameEnEquals, @Param("fullNameEnNotEquals") @jakarta.annotation.Nullable String fullNameEnNotEquals, @Param("fullNameEnSpecified") @jakarta.annotation.Nullable Boolean fullNameEnSpecified, @Param("fullNameEnIn") @jakarta.annotation.Nullable List<String> fullNameEnIn, @Param("fullNameEnNotIn") @jakarta.annotation.Nullable List<String> fullNameEnNotIn, @Param("codeNameContains") @jakarta.annotation.Nullable String codeNameContains, @Param("codeNameDoesNotContain") @jakarta.annotation.Nullable String codeNameDoesNotContain, @Param("codeNameEquals") @jakarta.annotation.Nullable String codeNameEquals, @Param("codeNameNotEquals") @jakarta.annotation.Nullable String codeNameNotEquals, @Param("codeNameSpecified") @jakarta.annotation.Nullable Boolean codeNameSpecified, @Param("codeNameIn") @jakarta.annotation.Nullable List<String> codeNameIn, @Param("codeNameNotIn") @jakarta.annotation.Nullable List<String> codeNameNotIn, @Param("administrativeUnitIdGreaterThan") @jakarta.annotation.Nullable Integer administrativeUnitIdGreaterThan, @Param("administrativeUnitIdLessThan") @jakarta.annotation.Nullable Integer administrativeUnitIdLessThan, @Param("administrativeUnitIdGreaterThanOrEqual") @jakarta.annotation.Nullable Integer administrativeUnitIdGreaterThanOrEqual, @Param("administrativeUnitIdLessThanOrEqual") @jakarta.annotation.Nullable Integer administrativeUnitIdLessThanOrEqual, @Param("administrativeUnitIdEquals") @jakarta.annotation.Nullable Integer administrativeUnitIdEquals, @Param("administrativeUnitIdNotEquals") @jakarta.annotation.Nullable Integer administrativeUnitIdNotEquals, @Param("administrativeUnitIdSpecified") @jakarta.annotation.Nullable Boolean administrativeUnitIdSpecified, @Param("administrativeUnitIdIn") @jakarta.annotation.Nullable List<Integer> administrativeUnitIdIn, @Param("administrativeUnitIdNotIn") @jakarta.annotation.Nullable List<Integer> administrativeUnitIdNotIn, @Param("administrativeRegionIdGreaterThan") @jakarta.annotation.Nullable Integer administrativeRegionIdGreaterThan, @Param("administrativeRegionIdLessThan") @jakarta.annotation.Nullable Integer administrativeRegionIdLessThan, @Param("administrativeRegionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Integer administrativeRegionIdGreaterThanOrEqual, @Param("administrativeRegionIdLessThanOrEqual") @jakarta.annotation.Nullable Integer administrativeRegionIdLessThanOrEqual, @Param("administrativeRegionIdEquals") @jakarta.annotation.Nullable Integer administrativeRegionIdEquals, @Param("administrativeRegionIdNotEquals") @jakarta.annotation.Nullable Integer administrativeRegionIdNotEquals, @Param("administrativeRegionIdSpecified") @jakarta.annotation.Nullable Boolean administrativeRegionIdSpecified, @Param("administrativeRegionIdIn") @jakarta.annotation.Nullable List<Integer> administrativeRegionIdIn, @Param("administrativeRegionIdNotIn") @jakarta.annotation.Nullable List<Integer> administrativeRegionIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("districtsIdGreaterThan") @jakarta.annotation.Nullable Long districtsIdGreaterThan, @Param("districtsIdLessThan") @jakarta.annotation.Nullable Long districtsIdLessThan, @Param("districtsIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long districtsIdGreaterThanOrEqual, @Param("districtsIdLessThanOrEqual") @jakarta.annotation.Nullable Long districtsIdLessThanOrEqual, @Param("districtsIdEquals") @jakarta.annotation.Nullable Long districtsIdEquals, @Param("districtsIdNotEquals") @jakarta.annotation.Nullable Long districtsIdNotEquals, @Param("districtsIdSpecified") @jakarta.annotation.Nullable Boolean districtsIdSpecified, @Param("districtsIdIn") @jakarta.annotation.Nullable List<Long> districtsIdIn, @Param("districtsIdNotIn") @jakarta.annotation.Nullable List<Long> districtsIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>getAllProvinces</code> but it also returns the http response headers .
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
   * @param provinceCodeContains  (optional)
   * @param provinceCodeDoesNotContain  (optional)
   * @param provinceCodeEquals  (optional)
   * @param provinceCodeNotEquals  (optional)
   * @param provinceCodeSpecified  (optional)
   * @param provinceCodeIn  (optional)
   * @param provinceCodeNotIn  (optional)
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
   * @param administrativeRegionIdGreaterThan  (optional)
   * @param administrativeRegionIdLessThan  (optional)
   * @param administrativeRegionIdGreaterThanOrEqual  (optional)
   * @param administrativeRegionIdLessThanOrEqual  (optional)
   * @param administrativeRegionIdEquals  (optional)
   * @param administrativeRegionIdNotEquals  (optional)
   * @param administrativeRegionIdSpecified  (optional)
   * @param administrativeRegionIdIn  (optional)
   * @param administrativeRegionIdNotIn  (optional)
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
   * @param districtsIdGreaterThan  (optional)
   * @param districtsIdLessThan  (optional)
   * @param districtsIdGreaterThanOrEqual  (optional)
   * @param districtsIdLessThanOrEqual  (optional)
   * @param districtsIdEquals  (optional)
   * @param districtsIdNotEquals  (optional)
   * @param districtsIdSpecified  (optional)
   * @param districtsIdIn  (optional)
   * @param districtsIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/provinces?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&provinceCode.contains={provinceCodeContains}&provinceCode.doesNotContain={provinceCodeDoesNotContain}&provinceCode.equals={provinceCodeEquals}&provinceCode.notEquals={provinceCodeNotEquals}&provinceCode.specified={provinceCodeSpecified}&provinceCode.in={provinceCodeIn}&provinceCode.notIn={provinceCodeNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&nameEn.contains={nameEnContains}&nameEn.doesNotContain={nameEnDoesNotContain}&nameEn.equals={nameEnEquals}&nameEn.notEquals={nameEnNotEquals}&nameEn.specified={nameEnSpecified}&nameEn.in={nameEnIn}&nameEn.notIn={nameEnNotIn}&fullName.contains={fullNameContains}&fullName.doesNotContain={fullNameDoesNotContain}&fullName.equals={fullNameEquals}&fullName.notEquals={fullNameNotEquals}&fullName.specified={fullNameSpecified}&fullName.in={fullNameIn}&fullName.notIn={fullNameNotIn}&fullNameEn.contains={fullNameEnContains}&fullNameEn.doesNotContain={fullNameEnDoesNotContain}&fullNameEn.equals={fullNameEnEquals}&fullNameEn.notEquals={fullNameEnNotEquals}&fullNameEn.specified={fullNameEnSpecified}&fullNameEn.in={fullNameEnIn}&fullNameEn.notIn={fullNameEnNotIn}&codeName.contains={codeNameContains}&codeName.doesNotContain={codeNameDoesNotContain}&codeName.equals={codeNameEquals}&codeName.notEquals={codeNameNotEquals}&codeName.specified={codeNameSpecified}&codeName.in={codeNameIn}&codeName.notIn={codeNameNotIn}&administrativeUnitId.greaterThan={administrativeUnitIdGreaterThan}&administrativeUnitId.lessThan={administrativeUnitIdLessThan}&administrativeUnitId.greaterThanOrEqual={administrativeUnitIdGreaterThanOrEqual}&administrativeUnitId.lessThanOrEqual={administrativeUnitIdLessThanOrEqual}&administrativeUnitId.equals={administrativeUnitIdEquals}&administrativeUnitId.notEquals={administrativeUnitIdNotEquals}&administrativeUnitId.specified={administrativeUnitIdSpecified}&administrativeUnitId.in={administrativeUnitIdIn}&administrativeUnitId.notIn={administrativeUnitIdNotIn}&administrativeRegionId.greaterThan={administrativeRegionIdGreaterThan}&administrativeRegionId.lessThan={administrativeRegionIdLessThan}&administrativeRegionId.greaterThanOrEqual={administrativeRegionIdGreaterThanOrEqual}&administrativeRegionId.lessThanOrEqual={administrativeRegionIdLessThanOrEqual}&administrativeRegionId.equals={administrativeRegionIdEquals}&administrativeRegionId.notEquals={administrativeRegionIdNotEquals}&administrativeRegionId.specified={administrativeRegionIdSpecified}&administrativeRegionId.in={administrativeRegionIdIn}&administrativeRegionId.notIn={administrativeRegionIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&districtsId.greaterThan={districtsIdGreaterThan}&districtsId.lessThan={districtsIdLessThan}&districtsId.greaterThanOrEqual={districtsIdGreaterThanOrEqual}&districtsId.lessThanOrEqual={districtsIdLessThanOrEqual}&districtsId.equals={districtsIdEquals}&districtsId.notEquals={districtsIdNotEquals}&districtsId.specified={districtsIdSpecified}&districtsId.in={districtsIdIn}&districtsId.notIn={districtsIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<ProvinceDTO>> getAllProvincesWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("provinceCodeContains") @jakarta.annotation.Nullable String provinceCodeContains, @Param("provinceCodeDoesNotContain") @jakarta.annotation.Nullable String provinceCodeDoesNotContain, @Param("provinceCodeEquals") @jakarta.annotation.Nullable String provinceCodeEquals, @Param("provinceCodeNotEquals") @jakarta.annotation.Nullable String provinceCodeNotEquals, @Param("provinceCodeSpecified") @jakarta.annotation.Nullable Boolean provinceCodeSpecified, @Param("provinceCodeIn") @jakarta.annotation.Nullable List<String> provinceCodeIn, @Param("provinceCodeNotIn") @jakarta.annotation.Nullable List<String> provinceCodeNotIn, @Param("nameContains") @jakarta.annotation.Nullable String nameContains, @Param("nameDoesNotContain") @jakarta.annotation.Nullable String nameDoesNotContain, @Param("nameEquals") @jakarta.annotation.Nullable String nameEquals, @Param("nameNotEquals") @jakarta.annotation.Nullable String nameNotEquals, @Param("nameSpecified") @jakarta.annotation.Nullable Boolean nameSpecified, @Param("nameIn") @jakarta.annotation.Nullable List<String> nameIn, @Param("nameNotIn") @jakarta.annotation.Nullable List<String> nameNotIn, @Param("nameEnContains") @jakarta.annotation.Nullable String nameEnContains, @Param("nameEnDoesNotContain") @jakarta.annotation.Nullable String nameEnDoesNotContain, @Param("nameEnEquals") @jakarta.annotation.Nullable String nameEnEquals, @Param("nameEnNotEquals") @jakarta.annotation.Nullable String nameEnNotEquals, @Param("nameEnSpecified") @jakarta.annotation.Nullable Boolean nameEnSpecified, @Param("nameEnIn") @jakarta.annotation.Nullable List<String> nameEnIn, @Param("nameEnNotIn") @jakarta.annotation.Nullable List<String> nameEnNotIn, @Param("fullNameContains") @jakarta.annotation.Nullable String fullNameContains, @Param("fullNameDoesNotContain") @jakarta.annotation.Nullable String fullNameDoesNotContain, @Param("fullNameEquals") @jakarta.annotation.Nullable String fullNameEquals, @Param("fullNameNotEquals") @jakarta.annotation.Nullable String fullNameNotEquals, @Param("fullNameSpecified") @jakarta.annotation.Nullable Boolean fullNameSpecified, @Param("fullNameIn") @jakarta.annotation.Nullable List<String> fullNameIn, @Param("fullNameNotIn") @jakarta.annotation.Nullable List<String> fullNameNotIn, @Param("fullNameEnContains") @jakarta.annotation.Nullable String fullNameEnContains, @Param("fullNameEnDoesNotContain") @jakarta.annotation.Nullable String fullNameEnDoesNotContain, @Param("fullNameEnEquals") @jakarta.annotation.Nullable String fullNameEnEquals, @Param("fullNameEnNotEquals") @jakarta.annotation.Nullable String fullNameEnNotEquals, @Param("fullNameEnSpecified") @jakarta.annotation.Nullable Boolean fullNameEnSpecified, @Param("fullNameEnIn") @jakarta.annotation.Nullable List<String> fullNameEnIn, @Param("fullNameEnNotIn") @jakarta.annotation.Nullable List<String> fullNameEnNotIn, @Param("codeNameContains") @jakarta.annotation.Nullable String codeNameContains, @Param("codeNameDoesNotContain") @jakarta.annotation.Nullable String codeNameDoesNotContain, @Param("codeNameEquals") @jakarta.annotation.Nullable String codeNameEquals, @Param("codeNameNotEquals") @jakarta.annotation.Nullable String codeNameNotEquals, @Param("codeNameSpecified") @jakarta.annotation.Nullable Boolean codeNameSpecified, @Param("codeNameIn") @jakarta.annotation.Nullable List<String> codeNameIn, @Param("codeNameNotIn") @jakarta.annotation.Nullable List<String> codeNameNotIn, @Param("administrativeUnitIdGreaterThan") @jakarta.annotation.Nullable Integer administrativeUnitIdGreaterThan, @Param("administrativeUnitIdLessThan") @jakarta.annotation.Nullable Integer administrativeUnitIdLessThan, @Param("administrativeUnitIdGreaterThanOrEqual") @jakarta.annotation.Nullable Integer administrativeUnitIdGreaterThanOrEqual, @Param("administrativeUnitIdLessThanOrEqual") @jakarta.annotation.Nullable Integer administrativeUnitIdLessThanOrEqual, @Param("administrativeUnitIdEquals") @jakarta.annotation.Nullable Integer administrativeUnitIdEquals, @Param("administrativeUnitIdNotEquals") @jakarta.annotation.Nullable Integer administrativeUnitIdNotEquals, @Param("administrativeUnitIdSpecified") @jakarta.annotation.Nullable Boolean administrativeUnitIdSpecified, @Param("administrativeUnitIdIn") @jakarta.annotation.Nullable List<Integer> administrativeUnitIdIn, @Param("administrativeUnitIdNotIn") @jakarta.annotation.Nullable List<Integer> administrativeUnitIdNotIn, @Param("administrativeRegionIdGreaterThan") @jakarta.annotation.Nullable Integer administrativeRegionIdGreaterThan, @Param("administrativeRegionIdLessThan") @jakarta.annotation.Nullable Integer administrativeRegionIdLessThan, @Param("administrativeRegionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Integer administrativeRegionIdGreaterThanOrEqual, @Param("administrativeRegionIdLessThanOrEqual") @jakarta.annotation.Nullable Integer administrativeRegionIdLessThanOrEqual, @Param("administrativeRegionIdEquals") @jakarta.annotation.Nullable Integer administrativeRegionIdEquals, @Param("administrativeRegionIdNotEquals") @jakarta.annotation.Nullable Integer administrativeRegionIdNotEquals, @Param("administrativeRegionIdSpecified") @jakarta.annotation.Nullable Boolean administrativeRegionIdSpecified, @Param("administrativeRegionIdIn") @jakarta.annotation.Nullable List<Integer> administrativeRegionIdIn, @Param("administrativeRegionIdNotIn") @jakarta.annotation.Nullable List<Integer> administrativeRegionIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("districtsIdGreaterThan") @jakarta.annotation.Nullable Long districtsIdGreaterThan, @Param("districtsIdLessThan") @jakarta.annotation.Nullable Long districtsIdLessThan, @Param("districtsIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long districtsIdGreaterThanOrEqual, @Param("districtsIdLessThanOrEqual") @jakarta.annotation.Nullable Long districtsIdLessThanOrEqual, @Param("districtsIdEquals") @jakarta.annotation.Nullable Long districtsIdEquals, @Param("districtsIdNotEquals") @jakarta.annotation.Nullable Long districtsIdNotEquals, @Param("districtsIdSpecified") @jakarta.annotation.Nullable Boolean districtsIdSpecified, @Param("districtsIdIn") @jakarta.annotation.Nullable List<Long> districtsIdIn, @Param("districtsIdNotIn") @jakarta.annotation.Nullable List<Long> districtsIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllProvinces</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllProvincesQueryParams} class that allows for
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
   *   <li>provinceCodeContains -  (optional)</li>
   *   <li>provinceCodeDoesNotContain -  (optional)</li>
   *   <li>provinceCodeEquals -  (optional)</li>
   *   <li>provinceCodeNotEquals -  (optional)</li>
   *   <li>provinceCodeSpecified -  (optional)</li>
   *   <li>provinceCodeIn -  (optional)</li>
   *   <li>provinceCodeNotIn -  (optional)</li>
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
   *   <li>administrativeRegionIdGreaterThan -  (optional)</li>
   *   <li>administrativeRegionIdLessThan -  (optional)</li>
   *   <li>administrativeRegionIdGreaterThanOrEqual -  (optional)</li>
   *   <li>administrativeRegionIdLessThanOrEqual -  (optional)</li>
   *   <li>administrativeRegionIdEquals -  (optional)</li>
   *   <li>administrativeRegionIdNotEquals -  (optional)</li>
   *   <li>administrativeRegionIdSpecified -  (optional)</li>
   *   <li>administrativeRegionIdIn -  (optional)</li>
   *   <li>administrativeRegionIdNotIn -  (optional)</li>
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
   *   <li>districtsIdGreaterThan -  (optional)</li>
   *   <li>districtsIdLessThan -  (optional)</li>
   *   <li>districtsIdGreaterThanOrEqual -  (optional)</li>
   *   <li>districtsIdLessThanOrEqual -  (optional)</li>
   *   <li>districtsIdEquals -  (optional)</li>
   *   <li>districtsIdNotEquals -  (optional)</li>
   *   <li>districtsIdSpecified -  (optional)</li>
   *   <li>districtsIdIn -  (optional)</li>
   *   <li>districtsIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return List&lt;ProvinceDTO&gt;
   */
  @RequestLine("GET /api/provinces?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&provinceCode.contains={provinceCodeContains}&provinceCode.doesNotContain={provinceCodeDoesNotContain}&provinceCode.equals={provinceCodeEquals}&provinceCode.notEquals={provinceCodeNotEquals}&provinceCode.specified={provinceCodeSpecified}&provinceCode.in={provinceCodeIn}&provinceCode.notIn={provinceCodeNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&nameEn.contains={nameEnContains}&nameEn.doesNotContain={nameEnDoesNotContain}&nameEn.equals={nameEnEquals}&nameEn.notEquals={nameEnNotEquals}&nameEn.specified={nameEnSpecified}&nameEn.in={nameEnIn}&nameEn.notIn={nameEnNotIn}&fullName.contains={fullNameContains}&fullName.doesNotContain={fullNameDoesNotContain}&fullName.equals={fullNameEquals}&fullName.notEquals={fullNameNotEquals}&fullName.specified={fullNameSpecified}&fullName.in={fullNameIn}&fullName.notIn={fullNameNotIn}&fullNameEn.contains={fullNameEnContains}&fullNameEn.doesNotContain={fullNameEnDoesNotContain}&fullNameEn.equals={fullNameEnEquals}&fullNameEn.notEquals={fullNameEnNotEquals}&fullNameEn.specified={fullNameEnSpecified}&fullNameEn.in={fullNameEnIn}&fullNameEn.notIn={fullNameEnNotIn}&codeName.contains={codeNameContains}&codeName.doesNotContain={codeNameDoesNotContain}&codeName.equals={codeNameEquals}&codeName.notEquals={codeNameNotEquals}&codeName.specified={codeNameSpecified}&codeName.in={codeNameIn}&codeName.notIn={codeNameNotIn}&administrativeUnitId.greaterThan={administrativeUnitIdGreaterThan}&administrativeUnitId.lessThan={administrativeUnitIdLessThan}&administrativeUnitId.greaterThanOrEqual={administrativeUnitIdGreaterThanOrEqual}&administrativeUnitId.lessThanOrEqual={administrativeUnitIdLessThanOrEqual}&administrativeUnitId.equals={administrativeUnitIdEquals}&administrativeUnitId.notEquals={administrativeUnitIdNotEquals}&administrativeUnitId.specified={administrativeUnitIdSpecified}&administrativeUnitId.in={administrativeUnitIdIn}&administrativeUnitId.notIn={administrativeUnitIdNotIn}&administrativeRegionId.greaterThan={administrativeRegionIdGreaterThan}&administrativeRegionId.lessThan={administrativeRegionIdLessThan}&administrativeRegionId.greaterThanOrEqual={administrativeRegionIdGreaterThanOrEqual}&administrativeRegionId.lessThanOrEqual={administrativeRegionIdLessThanOrEqual}&administrativeRegionId.equals={administrativeRegionIdEquals}&administrativeRegionId.notEquals={administrativeRegionIdNotEquals}&administrativeRegionId.specified={administrativeRegionIdSpecified}&administrativeRegionId.in={administrativeRegionIdIn}&administrativeRegionId.notIn={administrativeRegionIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&districtsId.greaterThan={districtsIdGreaterThan}&districtsId.lessThan={districtsIdLessThan}&districtsId.greaterThanOrEqual={districtsIdGreaterThanOrEqual}&districtsId.lessThanOrEqual={districtsIdLessThanOrEqual}&districtsId.equals={districtsIdEquals}&districtsId.notEquals={districtsIdNotEquals}&districtsId.specified={districtsIdSpecified}&districtsId.in={districtsIdIn}&districtsId.notIn={districtsIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  List<ProvinceDTO> getAllProvinces(@QueryMap(encoded=true) GetAllProvincesQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllProvinces</code> that receives the query parameters as a map,
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
          *   <li>provinceCodeContains -  (optional)</li>
          *   <li>provinceCodeDoesNotContain -  (optional)</li>
          *   <li>provinceCodeEquals -  (optional)</li>
          *   <li>provinceCodeNotEquals -  (optional)</li>
          *   <li>provinceCodeSpecified -  (optional)</li>
          *   <li>provinceCodeIn -  (optional)</li>
          *   <li>provinceCodeNotIn -  (optional)</li>
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
          *   <li>administrativeRegionIdGreaterThan -  (optional)</li>
          *   <li>administrativeRegionIdLessThan -  (optional)</li>
          *   <li>administrativeRegionIdGreaterThanOrEqual -  (optional)</li>
          *   <li>administrativeRegionIdLessThanOrEqual -  (optional)</li>
          *   <li>administrativeRegionIdEquals -  (optional)</li>
          *   <li>administrativeRegionIdNotEquals -  (optional)</li>
          *   <li>administrativeRegionIdSpecified -  (optional)</li>
          *   <li>administrativeRegionIdIn -  (optional)</li>
          *   <li>administrativeRegionIdNotIn -  (optional)</li>
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
          *   <li>districtsIdGreaterThan -  (optional)</li>
          *   <li>districtsIdLessThan -  (optional)</li>
          *   <li>districtsIdGreaterThanOrEqual -  (optional)</li>
          *   <li>districtsIdLessThanOrEqual -  (optional)</li>
          *   <li>districtsIdEquals -  (optional)</li>
          *   <li>districtsIdNotEquals -  (optional)</li>
          *   <li>districtsIdSpecified -  (optional)</li>
          *   <li>districtsIdIn -  (optional)</li>
          *   <li>districtsIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return List&lt;ProvinceDTO&gt;
      */
      @RequestLine("GET /api/provinces?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&provinceCode.contains={provinceCodeContains}&provinceCode.doesNotContain={provinceCodeDoesNotContain}&provinceCode.equals={provinceCodeEquals}&provinceCode.notEquals={provinceCodeNotEquals}&provinceCode.specified={provinceCodeSpecified}&provinceCode.in={provinceCodeIn}&provinceCode.notIn={provinceCodeNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&nameEn.contains={nameEnContains}&nameEn.doesNotContain={nameEnDoesNotContain}&nameEn.equals={nameEnEquals}&nameEn.notEquals={nameEnNotEquals}&nameEn.specified={nameEnSpecified}&nameEn.in={nameEnIn}&nameEn.notIn={nameEnNotIn}&fullName.contains={fullNameContains}&fullName.doesNotContain={fullNameDoesNotContain}&fullName.equals={fullNameEquals}&fullName.notEquals={fullNameNotEquals}&fullName.specified={fullNameSpecified}&fullName.in={fullNameIn}&fullName.notIn={fullNameNotIn}&fullNameEn.contains={fullNameEnContains}&fullNameEn.doesNotContain={fullNameEnDoesNotContain}&fullNameEn.equals={fullNameEnEquals}&fullNameEn.notEquals={fullNameEnNotEquals}&fullNameEn.specified={fullNameEnSpecified}&fullNameEn.in={fullNameEnIn}&fullNameEn.notIn={fullNameEnNotIn}&codeName.contains={codeNameContains}&codeName.doesNotContain={codeNameDoesNotContain}&codeName.equals={codeNameEquals}&codeName.notEquals={codeNameNotEquals}&codeName.specified={codeNameSpecified}&codeName.in={codeNameIn}&codeName.notIn={codeNameNotIn}&administrativeUnitId.greaterThan={administrativeUnitIdGreaterThan}&administrativeUnitId.lessThan={administrativeUnitIdLessThan}&administrativeUnitId.greaterThanOrEqual={administrativeUnitIdGreaterThanOrEqual}&administrativeUnitId.lessThanOrEqual={administrativeUnitIdLessThanOrEqual}&administrativeUnitId.equals={administrativeUnitIdEquals}&administrativeUnitId.notEquals={administrativeUnitIdNotEquals}&administrativeUnitId.specified={administrativeUnitIdSpecified}&administrativeUnitId.in={administrativeUnitIdIn}&administrativeUnitId.notIn={administrativeUnitIdNotIn}&administrativeRegionId.greaterThan={administrativeRegionIdGreaterThan}&administrativeRegionId.lessThan={administrativeRegionIdLessThan}&administrativeRegionId.greaterThanOrEqual={administrativeRegionIdGreaterThanOrEqual}&administrativeRegionId.lessThanOrEqual={administrativeRegionIdLessThanOrEqual}&administrativeRegionId.equals={administrativeRegionIdEquals}&administrativeRegionId.notEquals={administrativeRegionIdNotEquals}&administrativeRegionId.specified={administrativeRegionIdSpecified}&administrativeRegionId.in={administrativeRegionIdIn}&administrativeRegionId.notIn={administrativeRegionIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&districtsId.greaterThan={districtsIdGreaterThan}&districtsId.lessThan={districtsIdLessThan}&districtsId.greaterThanOrEqual={districtsIdGreaterThanOrEqual}&districtsId.lessThanOrEqual={districtsIdLessThanOrEqual}&districtsId.equals={districtsIdEquals}&districtsId.notEquals={districtsIdNotEquals}&districtsId.specified={districtsIdSpecified}&districtsId.in={districtsIdIn}&districtsId.notIn={districtsIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<ProvinceDTO>> getAllProvincesWithHttpInfo(@QueryMap(encoded=true) GetAllProvincesQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllProvinces</code> method in a fluent style.
   */
  public static class GetAllProvincesQueryParams extends HashMap<String, Object> {
    public GetAllProvincesQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProvincesQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProvincesQueryParams provinceCodeContains(@jakarta.annotation.Nullable final String value) {
      put("provinceCode.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams provinceCodeDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("provinceCode.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams provinceCodeEquals(@jakarta.annotation.Nullable final String value) {
      put("provinceCode.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams provinceCodeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("provinceCode.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams provinceCodeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("provinceCode.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams provinceCodeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("provinceCode.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProvincesQueryParams provinceCodeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("provinceCode.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProvincesQueryParams nameContains(@jakarta.annotation.Nullable final String value) {
      put("name.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams nameDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("name.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams nameEquals(@jakarta.annotation.Nullable final String value) {
      put("name.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams nameNotEquals(@jakarta.annotation.Nullable final String value) {
      put("name.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams nameSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("name.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams nameIn(@jakarta.annotation.Nullable final List<String> value) {
      put("name.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProvincesQueryParams nameNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("name.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProvincesQueryParams nameEnContains(@jakarta.annotation.Nullable final String value) {
      put("nameEn.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams nameEnDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("nameEn.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams nameEnEquals(@jakarta.annotation.Nullable final String value) {
      put("nameEn.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams nameEnNotEquals(@jakarta.annotation.Nullable final String value) {
      put("nameEn.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams nameEnSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("nameEn.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams nameEnIn(@jakarta.annotation.Nullable final List<String> value) {
      put("nameEn.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProvincesQueryParams nameEnNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("nameEn.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProvincesQueryParams fullNameContains(@jakarta.annotation.Nullable final String value) {
      put("fullName.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams fullNameDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("fullName.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams fullNameEquals(@jakarta.annotation.Nullable final String value) {
      put("fullName.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams fullNameNotEquals(@jakarta.annotation.Nullable final String value) {
      put("fullName.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams fullNameSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("fullName.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams fullNameIn(@jakarta.annotation.Nullable final List<String> value) {
      put("fullName.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProvincesQueryParams fullNameNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("fullName.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProvincesQueryParams fullNameEnContains(@jakarta.annotation.Nullable final String value) {
      put("fullNameEn.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams fullNameEnDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("fullNameEn.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams fullNameEnEquals(@jakarta.annotation.Nullable final String value) {
      put("fullNameEn.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams fullNameEnNotEquals(@jakarta.annotation.Nullable final String value) {
      put("fullNameEn.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams fullNameEnSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("fullNameEn.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams fullNameEnIn(@jakarta.annotation.Nullable final List<String> value) {
      put("fullNameEn.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProvincesQueryParams fullNameEnNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("fullNameEn.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProvincesQueryParams codeNameContains(@jakarta.annotation.Nullable final String value) {
      put("codeName.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams codeNameDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("codeName.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams codeNameEquals(@jakarta.annotation.Nullable final String value) {
      put("codeName.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams codeNameNotEquals(@jakarta.annotation.Nullable final String value) {
      put("codeName.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams codeNameSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("codeName.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams codeNameIn(@jakarta.annotation.Nullable final List<String> value) {
      put("codeName.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProvincesQueryParams codeNameNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("codeName.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProvincesQueryParams administrativeUnitIdGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams administrativeUnitIdLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams administrativeUnitIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams administrativeUnitIdLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams administrativeUnitIdEquals(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams administrativeUnitIdNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams administrativeUnitIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("administrativeUnitId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams administrativeUnitIdIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("administrativeUnitId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProvincesQueryParams administrativeUnitIdNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("administrativeUnitId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProvincesQueryParams administrativeRegionIdGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeRegionId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams administrativeRegionIdLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeRegionId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams administrativeRegionIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeRegionId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams administrativeRegionIdLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeRegionId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams administrativeRegionIdEquals(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeRegionId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams administrativeRegionIdNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeRegionId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams administrativeRegionIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("administrativeRegionId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams administrativeRegionIdIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("administrativeRegionId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProvincesQueryParams administrativeRegionIdNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("administrativeRegionId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProvincesQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProvincesQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProvincesQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProvincesQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProvincesQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProvincesQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProvincesQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProvincesQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProvincesQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProvincesQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProvincesQueryParams districtsIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("districtsId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams districtsIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("districtsId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams districtsIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("districtsId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams districtsIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("districtsId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams districtsIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("districtsId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams districtsIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("districtsId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams districtsIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("districtsId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllProvincesQueryParams districtsIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("districtsId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProvincesQueryParams districtsIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("districtsId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllProvincesQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @return ProvinceDTO
   */
  @RequestLine("GET /api/provinces/{id}")
  @Headers({
    "Accept: */*",
  })
  ProvinceDTO getProvince(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>getProvince</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/provinces/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<ProvinceDTO> getProvinceWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param id  (required)
   * @param provinceDTO  (required)
   * @return ProvinceDTO
   */
  @RequestLine("PATCH /api/provinces/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ProvinceDTO partialUpdateProvince(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull ProvinceDTO provinceDTO);

  /**
   * 
   * Similar to <code>partialUpdateProvince</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param provinceDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /api/provinces/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<ProvinceDTO> partialUpdateProvinceWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull ProvinceDTO provinceDTO);



  /**
   * 
   * 
   * @param id  (required)
   * @param provinceDTO  (required)
   * @return ProvinceDTO
   */
  @RequestLine("PUT /api/provinces/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ProvinceDTO updateProvince(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull ProvinceDTO provinceDTO);

  /**
   * 
   * Similar to <code>updateProvince</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param provinceDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/provinces/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<ProvinceDTO> updateProvinceWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull ProvinceDTO provinceDTO);


}
