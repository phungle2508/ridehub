package com.ridehub.msroute.client.api;

import com.ridehub.msroute.client.invoker.ApiClient;
import com.ridehub.msroute.client.invoker.EncodingUtils;
import com.ridehub.msroute.client.model.ApiResponse;

import java.time.OffsetDateTime;
import java.util.UUID;
import com.ridehub.msroute.client.model.WardDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface WardResourceMsrouteApi extends ApiClient.Api {


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
   * @param wardCodeContains  (optional)
   * @param wardCodeDoesNotContain  (optional)
   * @param wardCodeEquals  (optional)
   * @param wardCodeNotEquals  (optional)
   * @param wardCodeSpecified  (optional)
   * @param wardCodeIn  (optional)
   * @param wardCodeNotIn  (optional)
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
   * @param addressesIdGreaterThan  (optional)
   * @param addressesIdLessThan  (optional)
   * @param addressesIdGreaterThanOrEqual  (optional)
   * @param addressesIdLessThanOrEqual  (optional)
   * @param addressesIdEquals  (optional)
   * @param addressesIdNotEquals  (optional)
   * @param addressesIdSpecified  (optional)
   * @param addressesIdIn  (optional)
   * @param addressesIdNotIn  (optional)
   * @param districtIdGreaterThan  (optional)
   * @param districtIdLessThan  (optional)
   * @param districtIdGreaterThanOrEqual  (optional)
   * @param districtIdLessThanOrEqual  (optional)
   * @param districtIdEquals  (optional)
   * @param districtIdNotEquals  (optional)
   * @param districtIdSpecified  (optional)
   * @param districtIdIn  (optional)
   * @param districtIdNotIn  (optional)
   * @param distinct  (optional)
   * @return Long
   */
  @RequestLine("GET /api/wards/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&wardCode.contains={wardCodeContains}&wardCode.doesNotContain={wardCodeDoesNotContain}&wardCode.equals={wardCodeEquals}&wardCode.notEquals={wardCodeNotEquals}&wardCode.specified={wardCodeSpecified}&wardCode.in={wardCodeIn}&wardCode.notIn={wardCodeNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&nameEn.contains={nameEnContains}&nameEn.doesNotContain={nameEnDoesNotContain}&nameEn.equals={nameEnEquals}&nameEn.notEquals={nameEnNotEquals}&nameEn.specified={nameEnSpecified}&nameEn.in={nameEnIn}&nameEn.notIn={nameEnNotIn}&fullName.contains={fullNameContains}&fullName.doesNotContain={fullNameDoesNotContain}&fullName.equals={fullNameEquals}&fullName.notEquals={fullNameNotEquals}&fullName.specified={fullNameSpecified}&fullName.in={fullNameIn}&fullName.notIn={fullNameNotIn}&fullNameEn.contains={fullNameEnContains}&fullNameEn.doesNotContain={fullNameEnDoesNotContain}&fullNameEn.equals={fullNameEnEquals}&fullNameEn.notEquals={fullNameEnNotEquals}&fullNameEn.specified={fullNameEnSpecified}&fullNameEn.in={fullNameEnIn}&fullNameEn.notIn={fullNameEnNotIn}&codeName.contains={codeNameContains}&codeName.doesNotContain={codeNameDoesNotContain}&codeName.equals={codeNameEquals}&codeName.notEquals={codeNameNotEquals}&codeName.specified={codeNameSpecified}&codeName.in={codeNameIn}&codeName.notIn={codeNameNotIn}&administrativeUnitId.greaterThan={administrativeUnitIdGreaterThan}&administrativeUnitId.lessThan={administrativeUnitIdLessThan}&administrativeUnitId.greaterThanOrEqual={administrativeUnitIdGreaterThanOrEqual}&administrativeUnitId.lessThanOrEqual={administrativeUnitIdLessThanOrEqual}&administrativeUnitId.equals={administrativeUnitIdEquals}&administrativeUnitId.notEquals={administrativeUnitIdNotEquals}&administrativeUnitId.specified={administrativeUnitIdSpecified}&administrativeUnitId.in={administrativeUnitIdIn}&administrativeUnitId.notIn={administrativeUnitIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&addressesId.greaterThan={addressesIdGreaterThan}&addressesId.lessThan={addressesIdLessThan}&addressesId.greaterThanOrEqual={addressesIdGreaterThanOrEqual}&addressesId.lessThanOrEqual={addressesIdLessThanOrEqual}&addressesId.equals={addressesIdEquals}&addressesId.notEquals={addressesIdNotEquals}&addressesId.specified={addressesIdSpecified}&addressesId.in={addressesIdIn}&addressesId.notIn={addressesIdNotIn}&districtId.greaterThan={districtIdGreaterThan}&districtId.lessThan={districtIdLessThan}&districtId.greaterThanOrEqual={districtIdGreaterThanOrEqual}&districtId.lessThanOrEqual={districtIdLessThanOrEqual}&districtId.equals={districtIdEquals}&districtId.notEquals={districtIdNotEquals}&districtId.specified={districtIdSpecified}&districtId.in={districtIdIn}&districtId.notIn={districtIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  Long countWards(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("wardCodeContains") @jakarta.annotation.Nullable String wardCodeContains, @Param("wardCodeDoesNotContain") @jakarta.annotation.Nullable String wardCodeDoesNotContain, @Param("wardCodeEquals") @jakarta.annotation.Nullable String wardCodeEquals, @Param("wardCodeNotEquals") @jakarta.annotation.Nullable String wardCodeNotEquals, @Param("wardCodeSpecified") @jakarta.annotation.Nullable Boolean wardCodeSpecified, @Param("wardCodeIn") @jakarta.annotation.Nullable List<String> wardCodeIn, @Param("wardCodeNotIn") @jakarta.annotation.Nullable List<String> wardCodeNotIn, @Param("nameContains") @jakarta.annotation.Nullable String nameContains, @Param("nameDoesNotContain") @jakarta.annotation.Nullable String nameDoesNotContain, @Param("nameEquals") @jakarta.annotation.Nullable String nameEquals, @Param("nameNotEquals") @jakarta.annotation.Nullable String nameNotEquals, @Param("nameSpecified") @jakarta.annotation.Nullable Boolean nameSpecified, @Param("nameIn") @jakarta.annotation.Nullable List<String> nameIn, @Param("nameNotIn") @jakarta.annotation.Nullable List<String> nameNotIn, @Param("nameEnContains") @jakarta.annotation.Nullable String nameEnContains, @Param("nameEnDoesNotContain") @jakarta.annotation.Nullable String nameEnDoesNotContain, @Param("nameEnEquals") @jakarta.annotation.Nullable String nameEnEquals, @Param("nameEnNotEquals") @jakarta.annotation.Nullable String nameEnNotEquals, @Param("nameEnSpecified") @jakarta.annotation.Nullable Boolean nameEnSpecified, @Param("nameEnIn") @jakarta.annotation.Nullable List<String> nameEnIn, @Param("nameEnNotIn") @jakarta.annotation.Nullable List<String> nameEnNotIn, @Param("fullNameContains") @jakarta.annotation.Nullable String fullNameContains, @Param("fullNameDoesNotContain") @jakarta.annotation.Nullable String fullNameDoesNotContain, @Param("fullNameEquals") @jakarta.annotation.Nullable String fullNameEquals, @Param("fullNameNotEquals") @jakarta.annotation.Nullable String fullNameNotEquals, @Param("fullNameSpecified") @jakarta.annotation.Nullable Boolean fullNameSpecified, @Param("fullNameIn") @jakarta.annotation.Nullable List<String> fullNameIn, @Param("fullNameNotIn") @jakarta.annotation.Nullable List<String> fullNameNotIn, @Param("fullNameEnContains") @jakarta.annotation.Nullable String fullNameEnContains, @Param("fullNameEnDoesNotContain") @jakarta.annotation.Nullable String fullNameEnDoesNotContain, @Param("fullNameEnEquals") @jakarta.annotation.Nullable String fullNameEnEquals, @Param("fullNameEnNotEquals") @jakarta.annotation.Nullable String fullNameEnNotEquals, @Param("fullNameEnSpecified") @jakarta.annotation.Nullable Boolean fullNameEnSpecified, @Param("fullNameEnIn") @jakarta.annotation.Nullable List<String> fullNameEnIn, @Param("fullNameEnNotIn") @jakarta.annotation.Nullable List<String> fullNameEnNotIn, @Param("codeNameContains") @jakarta.annotation.Nullable String codeNameContains, @Param("codeNameDoesNotContain") @jakarta.annotation.Nullable String codeNameDoesNotContain, @Param("codeNameEquals") @jakarta.annotation.Nullable String codeNameEquals, @Param("codeNameNotEquals") @jakarta.annotation.Nullable String codeNameNotEquals, @Param("codeNameSpecified") @jakarta.annotation.Nullable Boolean codeNameSpecified, @Param("codeNameIn") @jakarta.annotation.Nullable List<String> codeNameIn, @Param("codeNameNotIn") @jakarta.annotation.Nullable List<String> codeNameNotIn, @Param("administrativeUnitIdGreaterThan") @jakarta.annotation.Nullable Integer administrativeUnitIdGreaterThan, @Param("administrativeUnitIdLessThan") @jakarta.annotation.Nullable Integer administrativeUnitIdLessThan, @Param("administrativeUnitIdGreaterThanOrEqual") @jakarta.annotation.Nullable Integer administrativeUnitIdGreaterThanOrEqual, @Param("administrativeUnitIdLessThanOrEqual") @jakarta.annotation.Nullable Integer administrativeUnitIdLessThanOrEqual, @Param("administrativeUnitIdEquals") @jakarta.annotation.Nullable Integer administrativeUnitIdEquals, @Param("administrativeUnitIdNotEquals") @jakarta.annotation.Nullable Integer administrativeUnitIdNotEquals, @Param("administrativeUnitIdSpecified") @jakarta.annotation.Nullable Boolean administrativeUnitIdSpecified, @Param("administrativeUnitIdIn") @jakarta.annotation.Nullable List<Integer> administrativeUnitIdIn, @Param("administrativeUnitIdNotIn") @jakarta.annotation.Nullable List<Integer> administrativeUnitIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("addressesIdGreaterThan") @jakarta.annotation.Nullable Long addressesIdGreaterThan, @Param("addressesIdLessThan") @jakarta.annotation.Nullable Long addressesIdLessThan, @Param("addressesIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long addressesIdGreaterThanOrEqual, @Param("addressesIdLessThanOrEqual") @jakarta.annotation.Nullable Long addressesIdLessThanOrEqual, @Param("addressesIdEquals") @jakarta.annotation.Nullable Long addressesIdEquals, @Param("addressesIdNotEquals") @jakarta.annotation.Nullable Long addressesIdNotEquals, @Param("addressesIdSpecified") @jakarta.annotation.Nullable Boolean addressesIdSpecified, @Param("addressesIdIn") @jakarta.annotation.Nullable List<Long> addressesIdIn, @Param("addressesIdNotIn") @jakarta.annotation.Nullable List<Long> addressesIdNotIn, @Param("districtIdGreaterThan") @jakarta.annotation.Nullable Long districtIdGreaterThan, @Param("districtIdLessThan") @jakarta.annotation.Nullable Long districtIdLessThan, @Param("districtIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long districtIdGreaterThanOrEqual, @Param("districtIdLessThanOrEqual") @jakarta.annotation.Nullable Long districtIdLessThanOrEqual, @Param("districtIdEquals") @jakarta.annotation.Nullable Long districtIdEquals, @Param("districtIdNotEquals") @jakarta.annotation.Nullable Long districtIdNotEquals, @Param("districtIdSpecified") @jakarta.annotation.Nullable Boolean districtIdSpecified, @Param("districtIdIn") @jakarta.annotation.Nullable List<Long> districtIdIn, @Param("districtIdNotIn") @jakarta.annotation.Nullable List<Long> districtIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>countWards</code> but it also returns the http response headers .
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
   * @param wardCodeContains  (optional)
   * @param wardCodeDoesNotContain  (optional)
   * @param wardCodeEquals  (optional)
   * @param wardCodeNotEquals  (optional)
   * @param wardCodeSpecified  (optional)
   * @param wardCodeIn  (optional)
   * @param wardCodeNotIn  (optional)
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
   * @param addressesIdGreaterThan  (optional)
   * @param addressesIdLessThan  (optional)
   * @param addressesIdGreaterThanOrEqual  (optional)
   * @param addressesIdLessThanOrEqual  (optional)
   * @param addressesIdEquals  (optional)
   * @param addressesIdNotEquals  (optional)
   * @param addressesIdSpecified  (optional)
   * @param addressesIdIn  (optional)
   * @param addressesIdNotIn  (optional)
   * @param districtIdGreaterThan  (optional)
   * @param districtIdLessThan  (optional)
   * @param districtIdGreaterThanOrEqual  (optional)
   * @param districtIdLessThanOrEqual  (optional)
   * @param districtIdEquals  (optional)
   * @param districtIdNotEquals  (optional)
   * @param districtIdSpecified  (optional)
   * @param districtIdIn  (optional)
   * @param districtIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/wards/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&wardCode.contains={wardCodeContains}&wardCode.doesNotContain={wardCodeDoesNotContain}&wardCode.equals={wardCodeEquals}&wardCode.notEquals={wardCodeNotEquals}&wardCode.specified={wardCodeSpecified}&wardCode.in={wardCodeIn}&wardCode.notIn={wardCodeNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&nameEn.contains={nameEnContains}&nameEn.doesNotContain={nameEnDoesNotContain}&nameEn.equals={nameEnEquals}&nameEn.notEquals={nameEnNotEquals}&nameEn.specified={nameEnSpecified}&nameEn.in={nameEnIn}&nameEn.notIn={nameEnNotIn}&fullName.contains={fullNameContains}&fullName.doesNotContain={fullNameDoesNotContain}&fullName.equals={fullNameEquals}&fullName.notEquals={fullNameNotEquals}&fullName.specified={fullNameSpecified}&fullName.in={fullNameIn}&fullName.notIn={fullNameNotIn}&fullNameEn.contains={fullNameEnContains}&fullNameEn.doesNotContain={fullNameEnDoesNotContain}&fullNameEn.equals={fullNameEnEquals}&fullNameEn.notEquals={fullNameEnNotEquals}&fullNameEn.specified={fullNameEnSpecified}&fullNameEn.in={fullNameEnIn}&fullNameEn.notIn={fullNameEnNotIn}&codeName.contains={codeNameContains}&codeName.doesNotContain={codeNameDoesNotContain}&codeName.equals={codeNameEquals}&codeName.notEquals={codeNameNotEquals}&codeName.specified={codeNameSpecified}&codeName.in={codeNameIn}&codeName.notIn={codeNameNotIn}&administrativeUnitId.greaterThan={administrativeUnitIdGreaterThan}&administrativeUnitId.lessThan={administrativeUnitIdLessThan}&administrativeUnitId.greaterThanOrEqual={administrativeUnitIdGreaterThanOrEqual}&administrativeUnitId.lessThanOrEqual={administrativeUnitIdLessThanOrEqual}&administrativeUnitId.equals={administrativeUnitIdEquals}&administrativeUnitId.notEquals={administrativeUnitIdNotEquals}&administrativeUnitId.specified={administrativeUnitIdSpecified}&administrativeUnitId.in={administrativeUnitIdIn}&administrativeUnitId.notIn={administrativeUnitIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&addressesId.greaterThan={addressesIdGreaterThan}&addressesId.lessThan={addressesIdLessThan}&addressesId.greaterThanOrEqual={addressesIdGreaterThanOrEqual}&addressesId.lessThanOrEqual={addressesIdLessThanOrEqual}&addressesId.equals={addressesIdEquals}&addressesId.notEquals={addressesIdNotEquals}&addressesId.specified={addressesIdSpecified}&addressesId.in={addressesIdIn}&addressesId.notIn={addressesIdNotIn}&districtId.greaterThan={districtIdGreaterThan}&districtId.lessThan={districtIdLessThan}&districtId.greaterThanOrEqual={districtIdGreaterThanOrEqual}&districtId.lessThanOrEqual={districtIdLessThanOrEqual}&districtId.equals={districtIdEquals}&districtId.notEquals={districtIdNotEquals}&districtId.specified={districtIdSpecified}&districtId.in={districtIdIn}&districtId.notIn={districtIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Long> countWardsWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("wardCodeContains") @jakarta.annotation.Nullable String wardCodeContains, @Param("wardCodeDoesNotContain") @jakarta.annotation.Nullable String wardCodeDoesNotContain, @Param("wardCodeEquals") @jakarta.annotation.Nullable String wardCodeEquals, @Param("wardCodeNotEquals") @jakarta.annotation.Nullable String wardCodeNotEquals, @Param("wardCodeSpecified") @jakarta.annotation.Nullable Boolean wardCodeSpecified, @Param("wardCodeIn") @jakarta.annotation.Nullable List<String> wardCodeIn, @Param("wardCodeNotIn") @jakarta.annotation.Nullable List<String> wardCodeNotIn, @Param("nameContains") @jakarta.annotation.Nullable String nameContains, @Param("nameDoesNotContain") @jakarta.annotation.Nullable String nameDoesNotContain, @Param("nameEquals") @jakarta.annotation.Nullable String nameEquals, @Param("nameNotEquals") @jakarta.annotation.Nullable String nameNotEquals, @Param("nameSpecified") @jakarta.annotation.Nullable Boolean nameSpecified, @Param("nameIn") @jakarta.annotation.Nullable List<String> nameIn, @Param("nameNotIn") @jakarta.annotation.Nullable List<String> nameNotIn, @Param("nameEnContains") @jakarta.annotation.Nullable String nameEnContains, @Param("nameEnDoesNotContain") @jakarta.annotation.Nullable String nameEnDoesNotContain, @Param("nameEnEquals") @jakarta.annotation.Nullable String nameEnEquals, @Param("nameEnNotEquals") @jakarta.annotation.Nullable String nameEnNotEquals, @Param("nameEnSpecified") @jakarta.annotation.Nullable Boolean nameEnSpecified, @Param("nameEnIn") @jakarta.annotation.Nullable List<String> nameEnIn, @Param("nameEnNotIn") @jakarta.annotation.Nullable List<String> nameEnNotIn, @Param("fullNameContains") @jakarta.annotation.Nullable String fullNameContains, @Param("fullNameDoesNotContain") @jakarta.annotation.Nullable String fullNameDoesNotContain, @Param("fullNameEquals") @jakarta.annotation.Nullable String fullNameEquals, @Param("fullNameNotEquals") @jakarta.annotation.Nullable String fullNameNotEquals, @Param("fullNameSpecified") @jakarta.annotation.Nullable Boolean fullNameSpecified, @Param("fullNameIn") @jakarta.annotation.Nullable List<String> fullNameIn, @Param("fullNameNotIn") @jakarta.annotation.Nullable List<String> fullNameNotIn, @Param("fullNameEnContains") @jakarta.annotation.Nullable String fullNameEnContains, @Param("fullNameEnDoesNotContain") @jakarta.annotation.Nullable String fullNameEnDoesNotContain, @Param("fullNameEnEquals") @jakarta.annotation.Nullable String fullNameEnEquals, @Param("fullNameEnNotEquals") @jakarta.annotation.Nullable String fullNameEnNotEquals, @Param("fullNameEnSpecified") @jakarta.annotation.Nullable Boolean fullNameEnSpecified, @Param("fullNameEnIn") @jakarta.annotation.Nullable List<String> fullNameEnIn, @Param("fullNameEnNotIn") @jakarta.annotation.Nullable List<String> fullNameEnNotIn, @Param("codeNameContains") @jakarta.annotation.Nullable String codeNameContains, @Param("codeNameDoesNotContain") @jakarta.annotation.Nullable String codeNameDoesNotContain, @Param("codeNameEquals") @jakarta.annotation.Nullable String codeNameEquals, @Param("codeNameNotEquals") @jakarta.annotation.Nullable String codeNameNotEquals, @Param("codeNameSpecified") @jakarta.annotation.Nullable Boolean codeNameSpecified, @Param("codeNameIn") @jakarta.annotation.Nullable List<String> codeNameIn, @Param("codeNameNotIn") @jakarta.annotation.Nullable List<String> codeNameNotIn, @Param("administrativeUnitIdGreaterThan") @jakarta.annotation.Nullable Integer administrativeUnitIdGreaterThan, @Param("administrativeUnitIdLessThan") @jakarta.annotation.Nullable Integer administrativeUnitIdLessThan, @Param("administrativeUnitIdGreaterThanOrEqual") @jakarta.annotation.Nullable Integer administrativeUnitIdGreaterThanOrEqual, @Param("administrativeUnitIdLessThanOrEqual") @jakarta.annotation.Nullable Integer administrativeUnitIdLessThanOrEqual, @Param("administrativeUnitIdEquals") @jakarta.annotation.Nullable Integer administrativeUnitIdEquals, @Param("administrativeUnitIdNotEquals") @jakarta.annotation.Nullable Integer administrativeUnitIdNotEquals, @Param("administrativeUnitIdSpecified") @jakarta.annotation.Nullable Boolean administrativeUnitIdSpecified, @Param("administrativeUnitIdIn") @jakarta.annotation.Nullable List<Integer> administrativeUnitIdIn, @Param("administrativeUnitIdNotIn") @jakarta.annotation.Nullable List<Integer> administrativeUnitIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("addressesIdGreaterThan") @jakarta.annotation.Nullable Long addressesIdGreaterThan, @Param("addressesIdLessThan") @jakarta.annotation.Nullable Long addressesIdLessThan, @Param("addressesIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long addressesIdGreaterThanOrEqual, @Param("addressesIdLessThanOrEqual") @jakarta.annotation.Nullable Long addressesIdLessThanOrEqual, @Param("addressesIdEquals") @jakarta.annotation.Nullable Long addressesIdEquals, @Param("addressesIdNotEquals") @jakarta.annotation.Nullable Long addressesIdNotEquals, @Param("addressesIdSpecified") @jakarta.annotation.Nullable Boolean addressesIdSpecified, @Param("addressesIdIn") @jakarta.annotation.Nullable List<Long> addressesIdIn, @Param("addressesIdNotIn") @jakarta.annotation.Nullable List<Long> addressesIdNotIn, @Param("districtIdGreaterThan") @jakarta.annotation.Nullable Long districtIdGreaterThan, @Param("districtIdLessThan") @jakarta.annotation.Nullable Long districtIdLessThan, @Param("districtIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long districtIdGreaterThanOrEqual, @Param("districtIdLessThanOrEqual") @jakarta.annotation.Nullable Long districtIdLessThanOrEqual, @Param("districtIdEquals") @jakarta.annotation.Nullable Long districtIdEquals, @Param("districtIdNotEquals") @jakarta.annotation.Nullable Long districtIdNotEquals, @Param("districtIdSpecified") @jakarta.annotation.Nullable Boolean districtIdSpecified, @Param("districtIdIn") @jakarta.annotation.Nullable List<Long> districtIdIn, @Param("districtIdNotIn") @jakarta.annotation.Nullable List<Long> districtIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>countWards</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CountWardsQueryParams} class that allows for
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
   *   <li>wardCodeContains -  (optional)</li>
   *   <li>wardCodeDoesNotContain -  (optional)</li>
   *   <li>wardCodeEquals -  (optional)</li>
   *   <li>wardCodeNotEquals -  (optional)</li>
   *   <li>wardCodeSpecified -  (optional)</li>
   *   <li>wardCodeIn -  (optional)</li>
   *   <li>wardCodeNotIn -  (optional)</li>
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
   *   <li>addressesIdGreaterThan -  (optional)</li>
   *   <li>addressesIdLessThan -  (optional)</li>
   *   <li>addressesIdGreaterThanOrEqual -  (optional)</li>
   *   <li>addressesIdLessThanOrEqual -  (optional)</li>
   *   <li>addressesIdEquals -  (optional)</li>
   *   <li>addressesIdNotEquals -  (optional)</li>
   *   <li>addressesIdSpecified -  (optional)</li>
   *   <li>addressesIdIn -  (optional)</li>
   *   <li>addressesIdNotIn -  (optional)</li>
   *   <li>districtIdGreaterThan -  (optional)</li>
   *   <li>districtIdLessThan -  (optional)</li>
   *   <li>districtIdGreaterThanOrEqual -  (optional)</li>
   *   <li>districtIdLessThanOrEqual -  (optional)</li>
   *   <li>districtIdEquals -  (optional)</li>
   *   <li>districtIdNotEquals -  (optional)</li>
   *   <li>districtIdSpecified -  (optional)</li>
   *   <li>districtIdIn -  (optional)</li>
   *   <li>districtIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return Long
   */
  @RequestLine("GET /api/wards/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&wardCode.contains={wardCodeContains}&wardCode.doesNotContain={wardCodeDoesNotContain}&wardCode.equals={wardCodeEquals}&wardCode.notEquals={wardCodeNotEquals}&wardCode.specified={wardCodeSpecified}&wardCode.in={wardCodeIn}&wardCode.notIn={wardCodeNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&nameEn.contains={nameEnContains}&nameEn.doesNotContain={nameEnDoesNotContain}&nameEn.equals={nameEnEquals}&nameEn.notEquals={nameEnNotEquals}&nameEn.specified={nameEnSpecified}&nameEn.in={nameEnIn}&nameEn.notIn={nameEnNotIn}&fullName.contains={fullNameContains}&fullName.doesNotContain={fullNameDoesNotContain}&fullName.equals={fullNameEquals}&fullName.notEquals={fullNameNotEquals}&fullName.specified={fullNameSpecified}&fullName.in={fullNameIn}&fullName.notIn={fullNameNotIn}&fullNameEn.contains={fullNameEnContains}&fullNameEn.doesNotContain={fullNameEnDoesNotContain}&fullNameEn.equals={fullNameEnEquals}&fullNameEn.notEquals={fullNameEnNotEquals}&fullNameEn.specified={fullNameEnSpecified}&fullNameEn.in={fullNameEnIn}&fullNameEn.notIn={fullNameEnNotIn}&codeName.contains={codeNameContains}&codeName.doesNotContain={codeNameDoesNotContain}&codeName.equals={codeNameEquals}&codeName.notEquals={codeNameNotEquals}&codeName.specified={codeNameSpecified}&codeName.in={codeNameIn}&codeName.notIn={codeNameNotIn}&administrativeUnitId.greaterThan={administrativeUnitIdGreaterThan}&administrativeUnitId.lessThan={administrativeUnitIdLessThan}&administrativeUnitId.greaterThanOrEqual={administrativeUnitIdGreaterThanOrEqual}&administrativeUnitId.lessThanOrEqual={administrativeUnitIdLessThanOrEqual}&administrativeUnitId.equals={administrativeUnitIdEquals}&administrativeUnitId.notEquals={administrativeUnitIdNotEquals}&administrativeUnitId.specified={administrativeUnitIdSpecified}&administrativeUnitId.in={administrativeUnitIdIn}&administrativeUnitId.notIn={administrativeUnitIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&addressesId.greaterThan={addressesIdGreaterThan}&addressesId.lessThan={addressesIdLessThan}&addressesId.greaterThanOrEqual={addressesIdGreaterThanOrEqual}&addressesId.lessThanOrEqual={addressesIdLessThanOrEqual}&addressesId.equals={addressesIdEquals}&addressesId.notEquals={addressesIdNotEquals}&addressesId.specified={addressesIdSpecified}&addressesId.in={addressesIdIn}&addressesId.notIn={addressesIdNotIn}&districtId.greaterThan={districtIdGreaterThan}&districtId.lessThan={districtIdLessThan}&districtId.greaterThanOrEqual={districtIdGreaterThanOrEqual}&districtId.lessThanOrEqual={districtIdLessThanOrEqual}&districtId.equals={districtIdEquals}&districtId.notEquals={districtIdNotEquals}&districtId.specified={districtIdSpecified}&districtId.in={districtIdIn}&districtId.notIn={districtIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  Long countWards(@QueryMap(encoded=true) CountWardsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>countWards</code> that receives the query parameters as a map,
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
          *   <li>wardCodeContains -  (optional)</li>
          *   <li>wardCodeDoesNotContain -  (optional)</li>
          *   <li>wardCodeEquals -  (optional)</li>
          *   <li>wardCodeNotEquals -  (optional)</li>
          *   <li>wardCodeSpecified -  (optional)</li>
          *   <li>wardCodeIn -  (optional)</li>
          *   <li>wardCodeNotIn -  (optional)</li>
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
          *   <li>addressesIdGreaterThan -  (optional)</li>
          *   <li>addressesIdLessThan -  (optional)</li>
          *   <li>addressesIdGreaterThanOrEqual -  (optional)</li>
          *   <li>addressesIdLessThanOrEqual -  (optional)</li>
          *   <li>addressesIdEquals -  (optional)</li>
          *   <li>addressesIdNotEquals -  (optional)</li>
          *   <li>addressesIdSpecified -  (optional)</li>
          *   <li>addressesIdIn -  (optional)</li>
          *   <li>addressesIdNotIn -  (optional)</li>
          *   <li>districtIdGreaterThan -  (optional)</li>
          *   <li>districtIdLessThan -  (optional)</li>
          *   <li>districtIdGreaterThanOrEqual -  (optional)</li>
          *   <li>districtIdLessThanOrEqual -  (optional)</li>
          *   <li>districtIdEquals -  (optional)</li>
          *   <li>districtIdNotEquals -  (optional)</li>
          *   <li>districtIdSpecified -  (optional)</li>
          *   <li>districtIdIn -  (optional)</li>
          *   <li>districtIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return Long
      */
      @RequestLine("GET /api/wards/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&wardCode.contains={wardCodeContains}&wardCode.doesNotContain={wardCodeDoesNotContain}&wardCode.equals={wardCodeEquals}&wardCode.notEquals={wardCodeNotEquals}&wardCode.specified={wardCodeSpecified}&wardCode.in={wardCodeIn}&wardCode.notIn={wardCodeNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&nameEn.contains={nameEnContains}&nameEn.doesNotContain={nameEnDoesNotContain}&nameEn.equals={nameEnEquals}&nameEn.notEquals={nameEnNotEquals}&nameEn.specified={nameEnSpecified}&nameEn.in={nameEnIn}&nameEn.notIn={nameEnNotIn}&fullName.contains={fullNameContains}&fullName.doesNotContain={fullNameDoesNotContain}&fullName.equals={fullNameEquals}&fullName.notEquals={fullNameNotEquals}&fullName.specified={fullNameSpecified}&fullName.in={fullNameIn}&fullName.notIn={fullNameNotIn}&fullNameEn.contains={fullNameEnContains}&fullNameEn.doesNotContain={fullNameEnDoesNotContain}&fullNameEn.equals={fullNameEnEquals}&fullNameEn.notEquals={fullNameEnNotEquals}&fullNameEn.specified={fullNameEnSpecified}&fullNameEn.in={fullNameEnIn}&fullNameEn.notIn={fullNameEnNotIn}&codeName.contains={codeNameContains}&codeName.doesNotContain={codeNameDoesNotContain}&codeName.equals={codeNameEquals}&codeName.notEquals={codeNameNotEquals}&codeName.specified={codeNameSpecified}&codeName.in={codeNameIn}&codeName.notIn={codeNameNotIn}&administrativeUnitId.greaterThan={administrativeUnitIdGreaterThan}&administrativeUnitId.lessThan={administrativeUnitIdLessThan}&administrativeUnitId.greaterThanOrEqual={administrativeUnitIdGreaterThanOrEqual}&administrativeUnitId.lessThanOrEqual={administrativeUnitIdLessThanOrEqual}&administrativeUnitId.equals={administrativeUnitIdEquals}&administrativeUnitId.notEquals={administrativeUnitIdNotEquals}&administrativeUnitId.specified={administrativeUnitIdSpecified}&administrativeUnitId.in={administrativeUnitIdIn}&administrativeUnitId.notIn={administrativeUnitIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&addressesId.greaterThan={addressesIdGreaterThan}&addressesId.lessThan={addressesIdLessThan}&addressesId.greaterThanOrEqual={addressesIdGreaterThanOrEqual}&addressesId.lessThanOrEqual={addressesIdLessThanOrEqual}&addressesId.equals={addressesIdEquals}&addressesId.notEquals={addressesIdNotEquals}&addressesId.specified={addressesIdSpecified}&addressesId.in={addressesIdIn}&addressesId.notIn={addressesIdNotIn}&districtId.greaterThan={districtIdGreaterThan}&districtId.lessThan={districtIdLessThan}&districtId.greaterThanOrEqual={districtIdGreaterThanOrEqual}&districtId.lessThanOrEqual={districtIdLessThanOrEqual}&districtId.equals={districtIdEquals}&districtId.notEquals={districtIdNotEquals}&districtId.specified={districtIdSpecified}&districtId.in={districtIdIn}&districtId.notIn={districtIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Long> countWardsWithHttpInfo(@QueryMap(encoded=true) CountWardsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>countWards</code> method in a fluent style.
   */
  public static class CountWardsQueryParams extends HashMap<String, Object> {
    public CountWardsQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountWardsQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountWardsQueryParams wardCodeContains(@jakarta.annotation.Nullable final String value) {
      put("wardCode.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams wardCodeDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("wardCode.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams wardCodeEquals(@jakarta.annotation.Nullable final String value) {
      put("wardCode.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams wardCodeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("wardCode.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams wardCodeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("wardCode.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams wardCodeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("wardCode.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountWardsQueryParams wardCodeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("wardCode.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountWardsQueryParams nameContains(@jakarta.annotation.Nullable final String value) {
      put("name.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams nameDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("name.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams nameEquals(@jakarta.annotation.Nullable final String value) {
      put("name.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams nameNotEquals(@jakarta.annotation.Nullable final String value) {
      put("name.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams nameSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("name.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams nameIn(@jakarta.annotation.Nullable final List<String> value) {
      put("name.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountWardsQueryParams nameNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("name.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountWardsQueryParams nameEnContains(@jakarta.annotation.Nullable final String value) {
      put("nameEn.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams nameEnDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("nameEn.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams nameEnEquals(@jakarta.annotation.Nullable final String value) {
      put("nameEn.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams nameEnNotEquals(@jakarta.annotation.Nullable final String value) {
      put("nameEn.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams nameEnSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("nameEn.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams nameEnIn(@jakarta.annotation.Nullable final List<String> value) {
      put("nameEn.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountWardsQueryParams nameEnNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("nameEn.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountWardsQueryParams fullNameContains(@jakarta.annotation.Nullable final String value) {
      put("fullName.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams fullNameDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("fullName.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams fullNameEquals(@jakarta.annotation.Nullable final String value) {
      put("fullName.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams fullNameNotEquals(@jakarta.annotation.Nullable final String value) {
      put("fullName.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams fullNameSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("fullName.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams fullNameIn(@jakarta.annotation.Nullable final List<String> value) {
      put("fullName.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountWardsQueryParams fullNameNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("fullName.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountWardsQueryParams fullNameEnContains(@jakarta.annotation.Nullable final String value) {
      put("fullNameEn.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams fullNameEnDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("fullNameEn.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams fullNameEnEquals(@jakarta.annotation.Nullable final String value) {
      put("fullNameEn.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams fullNameEnNotEquals(@jakarta.annotation.Nullable final String value) {
      put("fullNameEn.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams fullNameEnSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("fullNameEn.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams fullNameEnIn(@jakarta.annotation.Nullable final List<String> value) {
      put("fullNameEn.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountWardsQueryParams fullNameEnNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("fullNameEn.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountWardsQueryParams codeNameContains(@jakarta.annotation.Nullable final String value) {
      put("codeName.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams codeNameDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("codeName.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams codeNameEquals(@jakarta.annotation.Nullable final String value) {
      put("codeName.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams codeNameNotEquals(@jakarta.annotation.Nullable final String value) {
      put("codeName.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams codeNameSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("codeName.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams codeNameIn(@jakarta.annotation.Nullable final List<String> value) {
      put("codeName.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountWardsQueryParams codeNameNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("codeName.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountWardsQueryParams administrativeUnitIdGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams administrativeUnitIdLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams administrativeUnitIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams administrativeUnitIdLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams administrativeUnitIdEquals(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams administrativeUnitIdNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams administrativeUnitIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("administrativeUnitId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams administrativeUnitIdIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("administrativeUnitId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountWardsQueryParams administrativeUnitIdNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("administrativeUnitId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountWardsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountWardsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountWardsQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountWardsQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountWardsQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountWardsQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountWardsQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountWardsQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountWardsQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountWardsQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountWardsQueryParams addressesIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("addressesId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams addressesIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("addressesId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams addressesIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("addressesId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams addressesIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("addressesId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams addressesIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("addressesId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams addressesIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("addressesId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams addressesIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("addressesId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams addressesIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("addressesId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountWardsQueryParams addressesIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("addressesId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountWardsQueryParams districtIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("districtId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams districtIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("districtId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams districtIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("districtId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams districtIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("districtId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams districtIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("districtId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams districtIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("districtId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams districtIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("districtId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountWardsQueryParams districtIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("districtId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountWardsQueryParams districtIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("districtId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountWardsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param wardDTO  (required)
   * @return WardDTO
   */
  @RequestLine("POST /api/wards")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  WardDTO createWard(@jakarta.annotation.Nonnull WardDTO wardDTO);

  /**
   * 
   * Similar to <code>createWard</code> but it also returns the http response headers .
   * 
   * @param wardDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/wards")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<WardDTO> createWardWithHttpInfo(@jakarta.annotation.Nonnull WardDTO wardDTO);



  /**
   * 
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/wards/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteWard(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>deleteWard</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/wards/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteWardWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



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
   * @param wardCodeContains  (optional)
   * @param wardCodeDoesNotContain  (optional)
   * @param wardCodeEquals  (optional)
   * @param wardCodeNotEquals  (optional)
   * @param wardCodeSpecified  (optional)
   * @param wardCodeIn  (optional)
   * @param wardCodeNotIn  (optional)
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
   * @param addressesIdGreaterThan  (optional)
   * @param addressesIdLessThan  (optional)
   * @param addressesIdGreaterThanOrEqual  (optional)
   * @param addressesIdLessThanOrEqual  (optional)
   * @param addressesIdEquals  (optional)
   * @param addressesIdNotEquals  (optional)
   * @param addressesIdSpecified  (optional)
   * @param addressesIdIn  (optional)
   * @param addressesIdNotIn  (optional)
   * @param districtIdGreaterThan  (optional)
   * @param districtIdLessThan  (optional)
   * @param districtIdGreaterThanOrEqual  (optional)
   * @param districtIdLessThanOrEqual  (optional)
   * @param districtIdEquals  (optional)
   * @param districtIdNotEquals  (optional)
   * @param districtIdSpecified  (optional)
   * @param districtIdIn  (optional)
   * @param districtIdNotIn  (optional)
   * @param distinct  (optional)
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return List&lt;WardDTO&gt;
   */
  @RequestLine("GET /api/wards?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&wardCode.contains={wardCodeContains}&wardCode.doesNotContain={wardCodeDoesNotContain}&wardCode.equals={wardCodeEquals}&wardCode.notEquals={wardCodeNotEquals}&wardCode.specified={wardCodeSpecified}&wardCode.in={wardCodeIn}&wardCode.notIn={wardCodeNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&nameEn.contains={nameEnContains}&nameEn.doesNotContain={nameEnDoesNotContain}&nameEn.equals={nameEnEquals}&nameEn.notEquals={nameEnNotEquals}&nameEn.specified={nameEnSpecified}&nameEn.in={nameEnIn}&nameEn.notIn={nameEnNotIn}&fullName.contains={fullNameContains}&fullName.doesNotContain={fullNameDoesNotContain}&fullName.equals={fullNameEquals}&fullName.notEquals={fullNameNotEquals}&fullName.specified={fullNameSpecified}&fullName.in={fullNameIn}&fullName.notIn={fullNameNotIn}&fullNameEn.contains={fullNameEnContains}&fullNameEn.doesNotContain={fullNameEnDoesNotContain}&fullNameEn.equals={fullNameEnEquals}&fullNameEn.notEquals={fullNameEnNotEquals}&fullNameEn.specified={fullNameEnSpecified}&fullNameEn.in={fullNameEnIn}&fullNameEn.notIn={fullNameEnNotIn}&codeName.contains={codeNameContains}&codeName.doesNotContain={codeNameDoesNotContain}&codeName.equals={codeNameEquals}&codeName.notEquals={codeNameNotEquals}&codeName.specified={codeNameSpecified}&codeName.in={codeNameIn}&codeName.notIn={codeNameNotIn}&administrativeUnitId.greaterThan={administrativeUnitIdGreaterThan}&administrativeUnitId.lessThan={administrativeUnitIdLessThan}&administrativeUnitId.greaterThanOrEqual={administrativeUnitIdGreaterThanOrEqual}&administrativeUnitId.lessThanOrEqual={administrativeUnitIdLessThanOrEqual}&administrativeUnitId.equals={administrativeUnitIdEquals}&administrativeUnitId.notEquals={administrativeUnitIdNotEquals}&administrativeUnitId.specified={administrativeUnitIdSpecified}&administrativeUnitId.in={administrativeUnitIdIn}&administrativeUnitId.notIn={administrativeUnitIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&addressesId.greaterThan={addressesIdGreaterThan}&addressesId.lessThan={addressesIdLessThan}&addressesId.greaterThanOrEqual={addressesIdGreaterThanOrEqual}&addressesId.lessThanOrEqual={addressesIdLessThanOrEqual}&addressesId.equals={addressesIdEquals}&addressesId.notEquals={addressesIdNotEquals}&addressesId.specified={addressesIdSpecified}&addressesId.in={addressesIdIn}&addressesId.notIn={addressesIdNotIn}&districtId.greaterThan={districtIdGreaterThan}&districtId.lessThan={districtIdLessThan}&districtId.greaterThanOrEqual={districtIdGreaterThanOrEqual}&districtId.lessThanOrEqual={districtIdLessThanOrEqual}&districtId.equals={districtIdEquals}&districtId.notEquals={districtIdNotEquals}&districtId.specified={districtIdSpecified}&districtId.in={districtIdIn}&districtId.notIn={districtIdNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",
  })
  List<WardDTO> getAllWards(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("wardCodeContains") @jakarta.annotation.Nullable String wardCodeContains, @Param("wardCodeDoesNotContain") @jakarta.annotation.Nullable String wardCodeDoesNotContain, @Param("wardCodeEquals") @jakarta.annotation.Nullable String wardCodeEquals, @Param("wardCodeNotEquals") @jakarta.annotation.Nullable String wardCodeNotEquals, @Param("wardCodeSpecified") @jakarta.annotation.Nullable Boolean wardCodeSpecified, @Param("wardCodeIn") @jakarta.annotation.Nullable List<String> wardCodeIn, @Param("wardCodeNotIn") @jakarta.annotation.Nullable List<String> wardCodeNotIn, @Param("nameContains") @jakarta.annotation.Nullable String nameContains, @Param("nameDoesNotContain") @jakarta.annotation.Nullable String nameDoesNotContain, @Param("nameEquals") @jakarta.annotation.Nullable String nameEquals, @Param("nameNotEquals") @jakarta.annotation.Nullable String nameNotEquals, @Param("nameSpecified") @jakarta.annotation.Nullable Boolean nameSpecified, @Param("nameIn") @jakarta.annotation.Nullable List<String> nameIn, @Param("nameNotIn") @jakarta.annotation.Nullable List<String> nameNotIn, @Param("nameEnContains") @jakarta.annotation.Nullable String nameEnContains, @Param("nameEnDoesNotContain") @jakarta.annotation.Nullable String nameEnDoesNotContain, @Param("nameEnEquals") @jakarta.annotation.Nullable String nameEnEquals, @Param("nameEnNotEquals") @jakarta.annotation.Nullable String nameEnNotEquals, @Param("nameEnSpecified") @jakarta.annotation.Nullable Boolean nameEnSpecified, @Param("nameEnIn") @jakarta.annotation.Nullable List<String> nameEnIn, @Param("nameEnNotIn") @jakarta.annotation.Nullable List<String> nameEnNotIn, @Param("fullNameContains") @jakarta.annotation.Nullable String fullNameContains, @Param("fullNameDoesNotContain") @jakarta.annotation.Nullable String fullNameDoesNotContain, @Param("fullNameEquals") @jakarta.annotation.Nullable String fullNameEquals, @Param("fullNameNotEquals") @jakarta.annotation.Nullable String fullNameNotEquals, @Param("fullNameSpecified") @jakarta.annotation.Nullable Boolean fullNameSpecified, @Param("fullNameIn") @jakarta.annotation.Nullable List<String> fullNameIn, @Param("fullNameNotIn") @jakarta.annotation.Nullable List<String> fullNameNotIn, @Param("fullNameEnContains") @jakarta.annotation.Nullable String fullNameEnContains, @Param("fullNameEnDoesNotContain") @jakarta.annotation.Nullable String fullNameEnDoesNotContain, @Param("fullNameEnEquals") @jakarta.annotation.Nullable String fullNameEnEquals, @Param("fullNameEnNotEquals") @jakarta.annotation.Nullable String fullNameEnNotEquals, @Param("fullNameEnSpecified") @jakarta.annotation.Nullable Boolean fullNameEnSpecified, @Param("fullNameEnIn") @jakarta.annotation.Nullable List<String> fullNameEnIn, @Param("fullNameEnNotIn") @jakarta.annotation.Nullable List<String> fullNameEnNotIn, @Param("codeNameContains") @jakarta.annotation.Nullable String codeNameContains, @Param("codeNameDoesNotContain") @jakarta.annotation.Nullable String codeNameDoesNotContain, @Param("codeNameEquals") @jakarta.annotation.Nullable String codeNameEquals, @Param("codeNameNotEquals") @jakarta.annotation.Nullable String codeNameNotEquals, @Param("codeNameSpecified") @jakarta.annotation.Nullable Boolean codeNameSpecified, @Param("codeNameIn") @jakarta.annotation.Nullable List<String> codeNameIn, @Param("codeNameNotIn") @jakarta.annotation.Nullable List<String> codeNameNotIn, @Param("administrativeUnitIdGreaterThan") @jakarta.annotation.Nullable Integer administrativeUnitIdGreaterThan, @Param("administrativeUnitIdLessThan") @jakarta.annotation.Nullable Integer administrativeUnitIdLessThan, @Param("administrativeUnitIdGreaterThanOrEqual") @jakarta.annotation.Nullable Integer administrativeUnitIdGreaterThanOrEqual, @Param("administrativeUnitIdLessThanOrEqual") @jakarta.annotation.Nullable Integer administrativeUnitIdLessThanOrEqual, @Param("administrativeUnitIdEquals") @jakarta.annotation.Nullable Integer administrativeUnitIdEquals, @Param("administrativeUnitIdNotEquals") @jakarta.annotation.Nullable Integer administrativeUnitIdNotEquals, @Param("administrativeUnitIdSpecified") @jakarta.annotation.Nullable Boolean administrativeUnitIdSpecified, @Param("administrativeUnitIdIn") @jakarta.annotation.Nullable List<Integer> administrativeUnitIdIn, @Param("administrativeUnitIdNotIn") @jakarta.annotation.Nullable List<Integer> administrativeUnitIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("addressesIdGreaterThan") @jakarta.annotation.Nullable Long addressesIdGreaterThan, @Param("addressesIdLessThan") @jakarta.annotation.Nullable Long addressesIdLessThan, @Param("addressesIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long addressesIdGreaterThanOrEqual, @Param("addressesIdLessThanOrEqual") @jakarta.annotation.Nullable Long addressesIdLessThanOrEqual, @Param("addressesIdEquals") @jakarta.annotation.Nullable Long addressesIdEquals, @Param("addressesIdNotEquals") @jakarta.annotation.Nullable Long addressesIdNotEquals, @Param("addressesIdSpecified") @jakarta.annotation.Nullable Boolean addressesIdSpecified, @Param("addressesIdIn") @jakarta.annotation.Nullable List<Long> addressesIdIn, @Param("addressesIdNotIn") @jakarta.annotation.Nullable List<Long> addressesIdNotIn, @Param("districtIdGreaterThan") @jakarta.annotation.Nullable Long districtIdGreaterThan, @Param("districtIdLessThan") @jakarta.annotation.Nullable Long districtIdLessThan, @Param("districtIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long districtIdGreaterThanOrEqual, @Param("districtIdLessThanOrEqual") @jakarta.annotation.Nullable Long districtIdLessThanOrEqual, @Param("districtIdEquals") @jakarta.annotation.Nullable Long districtIdEquals, @Param("districtIdNotEquals") @jakarta.annotation.Nullable Long districtIdNotEquals, @Param("districtIdSpecified") @jakarta.annotation.Nullable Boolean districtIdSpecified, @Param("districtIdIn") @jakarta.annotation.Nullable List<Long> districtIdIn, @Param("districtIdNotIn") @jakarta.annotation.Nullable List<Long> districtIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct, @Param("page") @jakarta.annotation.Nullable Integer page, @Param("size") @jakarta.annotation.Nullable Integer size, @Param("sort") @jakarta.annotation.Nullable List<String> sort);

  /**
   * 
   * Similar to <code>getAllWards</code> but it also returns the http response headers .
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
   * @param wardCodeContains  (optional)
   * @param wardCodeDoesNotContain  (optional)
   * @param wardCodeEquals  (optional)
   * @param wardCodeNotEquals  (optional)
   * @param wardCodeSpecified  (optional)
   * @param wardCodeIn  (optional)
   * @param wardCodeNotIn  (optional)
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
   * @param addressesIdGreaterThan  (optional)
   * @param addressesIdLessThan  (optional)
   * @param addressesIdGreaterThanOrEqual  (optional)
   * @param addressesIdLessThanOrEqual  (optional)
   * @param addressesIdEquals  (optional)
   * @param addressesIdNotEquals  (optional)
   * @param addressesIdSpecified  (optional)
   * @param addressesIdIn  (optional)
   * @param addressesIdNotIn  (optional)
   * @param districtIdGreaterThan  (optional)
   * @param districtIdLessThan  (optional)
   * @param districtIdGreaterThanOrEqual  (optional)
   * @param districtIdLessThanOrEqual  (optional)
   * @param districtIdEquals  (optional)
   * @param districtIdNotEquals  (optional)
   * @param districtIdSpecified  (optional)
   * @param districtIdIn  (optional)
   * @param districtIdNotIn  (optional)
   * @param distinct  (optional)
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/wards?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&wardCode.contains={wardCodeContains}&wardCode.doesNotContain={wardCodeDoesNotContain}&wardCode.equals={wardCodeEquals}&wardCode.notEquals={wardCodeNotEquals}&wardCode.specified={wardCodeSpecified}&wardCode.in={wardCodeIn}&wardCode.notIn={wardCodeNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&nameEn.contains={nameEnContains}&nameEn.doesNotContain={nameEnDoesNotContain}&nameEn.equals={nameEnEquals}&nameEn.notEquals={nameEnNotEquals}&nameEn.specified={nameEnSpecified}&nameEn.in={nameEnIn}&nameEn.notIn={nameEnNotIn}&fullName.contains={fullNameContains}&fullName.doesNotContain={fullNameDoesNotContain}&fullName.equals={fullNameEquals}&fullName.notEquals={fullNameNotEquals}&fullName.specified={fullNameSpecified}&fullName.in={fullNameIn}&fullName.notIn={fullNameNotIn}&fullNameEn.contains={fullNameEnContains}&fullNameEn.doesNotContain={fullNameEnDoesNotContain}&fullNameEn.equals={fullNameEnEquals}&fullNameEn.notEquals={fullNameEnNotEquals}&fullNameEn.specified={fullNameEnSpecified}&fullNameEn.in={fullNameEnIn}&fullNameEn.notIn={fullNameEnNotIn}&codeName.contains={codeNameContains}&codeName.doesNotContain={codeNameDoesNotContain}&codeName.equals={codeNameEquals}&codeName.notEquals={codeNameNotEquals}&codeName.specified={codeNameSpecified}&codeName.in={codeNameIn}&codeName.notIn={codeNameNotIn}&administrativeUnitId.greaterThan={administrativeUnitIdGreaterThan}&administrativeUnitId.lessThan={administrativeUnitIdLessThan}&administrativeUnitId.greaterThanOrEqual={administrativeUnitIdGreaterThanOrEqual}&administrativeUnitId.lessThanOrEqual={administrativeUnitIdLessThanOrEqual}&administrativeUnitId.equals={administrativeUnitIdEquals}&administrativeUnitId.notEquals={administrativeUnitIdNotEquals}&administrativeUnitId.specified={administrativeUnitIdSpecified}&administrativeUnitId.in={administrativeUnitIdIn}&administrativeUnitId.notIn={administrativeUnitIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&addressesId.greaterThan={addressesIdGreaterThan}&addressesId.lessThan={addressesIdLessThan}&addressesId.greaterThanOrEqual={addressesIdGreaterThanOrEqual}&addressesId.lessThanOrEqual={addressesIdLessThanOrEqual}&addressesId.equals={addressesIdEquals}&addressesId.notEquals={addressesIdNotEquals}&addressesId.specified={addressesIdSpecified}&addressesId.in={addressesIdIn}&addressesId.notIn={addressesIdNotIn}&districtId.greaterThan={districtIdGreaterThan}&districtId.lessThan={districtIdLessThan}&districtId.greaterThanOrEqual={districtIdGreaterThanOrEqual}&districtId.lessThanOrEqual={districtIdLessThanOrEqual}&districtId.equals={districtIdEquals}&districtId.notEquals={districtIdNotEquals}&districtId.specified={districtIdSpecified}&districtId.in={districtIdIn}&districtId.notIn={districtIdNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<WardDTO>> getAllWardsWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("wardCodeContains") @jakarta.annotation.Nullable String wardCodeContains, @Param("wardCodeDoesNotContain") @jakarta.annotation.Nullable String wardCodeDoesNotContain, @Param("wardCodeEquals") @jakarta.annotation.Nullable String wardCodeEquals, @Param("wardCodeNotEquals") @jakarta.annotation.Nullable String wardCodeNotEquals, @Param("wardCodeSpecified") @jakarta.annotation.Nullable Boolean wardCodeSpecified, @Param("wardCodeIn") @jakarta.annotation.Nullable List<String> wardCodeIn, @Param("wardCodeNotIn") @jakarta.annotation.Nullable List<String> wardCodeNotIn, @Param("nameContains") @jakarta.annotation.Nullable String nameContains, @Param("nameDoesNotContain") @jakarta.annotation.Nullable String nameDoesNotContain, @Param("nameEquals") @jakarta.annotation.Nullable String nameEquals, @Param("nameNotEquals") @jakarta.annotation.Nullable String nameNotEquals, @Param("nameSpecified") @jakarta.annotation.Nullable Boolean nameSpecified, @Param("nameIn") @jakarta.annotation.Nullable List<String> nameIn, @Param("nameNotIn") @jakarta.annotation.Nullable List<String> nameNotIn, @Param("nameEnContains") @jakarta.annotation.Nullable String nameEnContains, @Param("nameEnDoesNotContain") @jakarta.annotation.Nullable String nameEnDoesNotContain, @Param("nameEnEquals") @jakarta.annotation.Nullable String nameEnEquals, @Param("nameEnNotEquals") @jakarta.annotation.Nullable String nameEnNotEquals, @Param("nameEnSpecified") @jakarta.annotation.Nullable Boolean nameEnSpecified, @Param("nameEnIn") @jakarta.annotation.Nullable List<String> nameEnIn, @Param("nameEnNotIn") @jakarta.annotation.Nullable List<String> nameEnNotIn, @Param("fullNameContains") @jakarta.annotation.Nullable String fullNameContains, @Param("fullNameDoesNotContain") @jakarta.annotation.Nullable String fullNameDoesNotContain, @Param("fullNameEquals") @jakarta.annotation.Nullable String fullNameEquals, @Param("fullNameNotEquals") @jakarta.annotation.Nullable String fullNameNotEquals, @Param("fullNameSpecified") @jakarta.annotation.Nullable Boolean fullNameSpecified, @Param("fullNameIn") @jakarta.annotation.Nullable List<String> fullNameIn, @Param("fullNameNotIn") @jakarta.annotation.Nullable List<String> fullNameNotIn, @Param("fullNameEnContains") @jakarta.annotation.Nullable String fullNameEnContains, @Param("fullNameEnDoesNotContain") @jakarta.annotation.Nullable String fullNameEnDoesNotContain, @Param("fullNameEnEquals") @jakarta.annotation.Nullable String fullNameEnEquals, @Param("fullNameEnNotEquals") @jakarta.annotation.Nullable String fullNameEnNotEquals, @Param("fullNameEnSpecified") @jakarta.annotation.Nullable Boolean fullNameEnSpecified, @Param("fullNameEnIn") @jakarta.annotation.Nullable List<String> fullNameEnIn, @Param("fullNameEnNotIn") @jakarta.annotation.Nullable List<String> fullNameEnNotIn, @Param("codeNameContains") @jakarta.annotation.Nullable String codeNameContains, @Param("codeNameDoesNotContain") @jakarta.annotation.Nullable String codeNameDoesNotContain, @Param("codeNameEquals") @jakarta.annotation.Nullable String codeNameEquals, @Param("codeNameNotEquals") @jakarta.annotation.Nullable String codeNameNotEquals, @Param("codeNameSpecified") @jakarta.annotation.Nullable Boolean codeNameSpecified, @Param("codeNameIn") @jakarta.annotation.Nullable List<String> codeNameIn, @Param("codeNameNotIn") @jakarta.annotation.Nullable List<String> codeNameNotIn, @Param("administrativeUnitIdGreaterThan") @jakarta.annotation.Nullable Integer administrativeUnitIdGreaterThan, @Param("administrativeUnitIdLessThan") @jakarta.annotation.Nullable Integer administrativeUnitIdLessThan, @Param("administrativeUnitIdGreaterThanOrEqual") @jakarta.annotation.Nullable Integer administrativeUnitIdGreaterThanOrEqual, @Param("administrativeUnitIdLessThanOrEqual") @jakarta.annotation.Nullable Integer administrativeUnitIdLessThanOrEqual, @Param("administrativeUnitIdEquals") @jakarta.annotation.Nullable Integer administrativeUnitIdEquals, @Param("administrativeUnitIdNotEquals") @jakarta.annotation.Nullable Integer administrativeUnitIdNotEquals, @Param("administrativeUnitIdSpecified") @jakarta.annotation.Nullable Boolean administrativeUnitIdSpecified, @Param("administrativeUnitIdIn") @jakarta.annotation.Nullable List<Integer> administrativeUnitIdIn, @Param("administrativeUnitIdNotIn") @jakarta.annotation.Nullable List<Integer> administrativeUnitIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("addressesIdGreaterThan") @jakarta.annotation.Nullable Long addressesIdGreaterThan, @Param("addressesIdLessThan") @jakarta.annotation.Nullable Long addressesIdLessThan, @Param("addressesIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long addressesIdGreaterThanOrEqual, @Param("addressesIdLessThanOrEqual") @jakarta.annotation.Nullable Long addressesIdLessThanOrEqual, @Param("addressesIdEquals") @jakarta.annotation.Nullable Long addressesIdEquals, @Param("addressesIdNotEquals") @jakarta.annotation.Nullable Long addressesIdNotEquals, @Param("addressesIdSpecified") @jakarta.annotation.Nullable Boolean addressesIdSpecified, @Param("addressesIdIn") @jakarta.annotation.Nullable List<Long> addressesIdIn, @Param("addressesIdNotIn") @jakarta.annotation.Nullable List<Long> addressesIdNotIn, @Param("districtIdGreaterThan") @jakarta.annotation.Nullable Long districtIdGreaterThan, @Param("districtIdLessThan") @jakarta.annotation.Nullable Long districtIdLessThan, @Param("districtIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long districtIdGreaterThanOrEqual, @Param("districtIdLessThanOrEqual") @jakarta.annotation.Nullable Long districtIdLessThanOrEqual, @Param("districtIdEquals") @jakarta.annotation.Nullable Long districtIdEquals, @Param("districtIdNotEquals") @jakarta.annotation.Nullable Long districtIdNotEquals, @Param("districtIdSpecified") @jakarta.annotation.Nullable Boolean districtIdSpecified, @Param("districtIdIn") @jakarta.annotation.Nullable List<Long> districtIdIn, @Param("districtIdNotIn") @jakarta.annotation.Nullable List<Long> districtIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct, @Param("page") @jakarta.annotation.Nullable Integer page, @Param("size") @jakarta.annotation.Nullable Integer size, @Param("sort") @jakarta.annotation.Nullable List<String> sort);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllWards</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllWardsQueryParams} class that allows for
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
   *   <li>wardCodeContains -  (optional)</li>
   *   <li>wardCodeDoesNotContain -  (optional)</li>
   *   <li>wardCodeEquals -  (optional)</li>
   *   <li>wardCodeNotEquals -  (optional)</li>
   *   <li>wardCodeSpecified -  (optional)</li>
   *   <li>wardCodeIn -  (optional)</li>
   *   <li>wardCodeNotIn -  (optional)</li>
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
   *   <li>addressesIdGreaterThan -  (optional)</li>
   *   <li>addressesIdLessThan -  (optional)</li>
   *   <li>addressesIdGreaterThanOrEqual -  (optional)</li>
   *   <li>addressesIdLessThanOrEqual -  (optional)</li>
   *   <li>addressesIdEquals -  (optional)</li>
   *   <li>addressesIdNotEquals -  (optional)</li>
   *   <li>addressesIdSpecified -  (optional)</li>
   *   <li>addressesIdIn -  (optional)</li>
   *   <li>addressesIdNotIn -  (optional)</li>
   *   <li>districtIdGreaterThan -  (optional)</li>
   *   <li>districtIdLessThan -  (optional)</li>
   *   <li>districtIdGreaterThanOrEqual -  (optional)</li>
   *   <li>districtIdLessThanOrEqual -  (optional)</li>
   *   <li>districtIdEquals -  (optional)</li>
   *   <li>districtIdNotEquals -  (optional)</li>
   *   <li>districtIdSpecified -  (optional)</li>
   *   <li>districtIdIn -  (optional)</li>
   *   <li>districtIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   <li>page - Zero-based page index (0..N) (optional, default to 0)</li>
   *   <li>size - The size of the page to be returned (optional, default to 20)</li>
   *   <li>sort - Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)</li>
   *   </ul>
   * @return List&lt;WardDTO&gt;
   */
  @RequestLine("GET /api/wards?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&wardCode.contains={wardCodeContains}&wardCode.doesNotContain={wardCodeDoesNotContain}&wardCode.equals={wardCodeEquals}&wardCode.notEquals={wardCodeNotEquals}&wardCode.specified={wardCodeSpecified}&wardCode.in={wardCodeIn}&wardCode.notIn={wardCodeNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&nameEn.contains={nameEnContains}&nameEn.doesNotContain={nameEnDoesNotContain}&nameEn.equals={nameEnEquals}&nameEn.notEquals={nameEnNotEquals}&nameEn.specified={nameEnSpecified}&nameEn.in={nameEnIn}&nameEn.notIn={nameEnNotIn}&fullName.contains={fullNameContains}&fullName.doesNotContain={fullNameDoesNotContain}&fullName.equals={fullNameEquals}&fullName.notEquals={fullNameNotEquals}&fullName.specified={fullNameSpecified}&fullName.in={fullNameIn}&fullName.notIn={fullNameNotIn}&fullNameEn.contains={fullNameEnContains}&fullNameEn.doesNotContain={fullNameEnDoesNotContain}&fullNameEn.equals={fullNameEnEquals}&fullNameEn.notEquals={fullNameEnNotEquals}&fullNameEn.specified={fullNameEnSpecified}&fullNameEn.in={fullNameEnIn}&fullNameEn.notIn={fullNameEnNotIn}&codeName.contains={codeNameContains}&codeName.doesNotContain={codeNameDoesNotContain}&codeName.equals={codeNameEquals}&codeName.notEquals={codeNameNotEquals}&codeName.specified={codeNameSpecified}&codeName.in={codeNameIn}&codeName.notIn={codeNameNotIn}&administrativeUnitId.greaterThan={administrativeUnitIdGreaterThan}&administrativeUnitId.lessThan={administrativeUnitIdLessThan}&administrativeUnitId.greaterThanOrEqual={administrativeUnitIdGreaterThanOrEqual}&administrativeUnitId.lessThanOrEqual={administrativeUnitIdLessThanOrEqual}&administrativeUnitId.equals={administrativeUnitIdEquals}&administrativeUnitId.notEquals={administrativeUnitIdNotEquals}&administrativeUnitId.specified={administrativeUnitIdSpecified}&administrativeUnitId.in={administrativeUnitIdIn}&administrativeUnitId.notIn={administrativeUnitIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&addressesId.greaterThan={addressesIdGreaterThan}&addressesId.lessThan={addressesIdLessThan}&addressesId.greaterThanOrEqual={addressesIdGreaterThanOrEqual}&addressesId.lessThanOrEqual={addressesIdLessThanOrEqual}&addressesId.equals={addressesIdEquals}&addressesId.notEquals={addressesIdNotEquals}&addressesId.specified={addressesIdSpecified}&addressesId.in={addressesIdIn}&addressesId.notIn={addressesIdNotIn}&districtId.greaterThan={districtIdGreaterThan}&districtId.lessThan={districtIdLessThan}&districtId.greaterThanOrEqual={districtIdGreaterThanOrEqual}&districtId.lessThanOrEqual={districtIdLessThanOrEqual}&districtId.equals={districtIdEquals}&districtId.notEquals={districtIdNotEquals}&districtId.specified={districtIdSpecified}&districtId.in={districtIdIn}&districtId.notIn={districtIdNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
  @Headers({
  "Accept: */*",
  })
  List<WardDTO> getAllWards(@QueryMap(encoded=true) GetAllWardsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllWards</code> that receives the query parameters as a map,
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
          *   <li>wardCodeContains -  (optional)</li>
          *   <li>wardCodeDoesNotContain -  (optional)</li>
          *   <li>wardCodeEquals -  (optional)</li>
          *   <li>wardCodeNotEquals -  (optional)</li>
          *   <li>wardCodeSpecified -  (optional)</li>
          *   <li>wardCodeIn -  (optional)</li>
          *   <li>wardCodeNotIn -  (optional)</li>
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
          *   <li>addressesIdGreaterThan -  (optional)</li>
          *   <li>addressesIdLessThan -  (optional)</li>
          *   <li>addressesIdGreaterThanOrEqual -  (optional)</li>
          *   <li>addressesIdLessThanOrEqual -  (optional)</li>
          *   <li>addressesIdEquals -  (optional)</li>
          *   <li>addressesIdNotEquals -  (optional)</li>
          *   <li>addressesIdSpecified -  (optional)</li>
          *   <li>addressesIdIn -  (optional)</li>
          *   <li>addressesIdNotIn -  (optional)</li>
          *   <li>districtIdGreaterThan -  (optional)</li>
          *   <li>districtIdLessThan -  (optional)</li>
          *   <li>districtIdGreaterThanOrEqual -  (optional)</li>
          *   <li>districtIdLessThanOrEqual -  (optional)</li>
          *   <li>districtIdEquals -  (optional)</li>
          *   <li>districtIdNotEquals -  (optional)</li>
          *   <li>districtIdSpecified -  (optional)</li>
          *   <li>districtIdIn -  (optional)</li>
          *   <li>districtIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
          *   <li>page - Zero-based page index (0..N) (optional, default to 0)</li>
          *   <li>size - The size of the page to be returned (optional, default to 20)</li>
          *   <li>sort - Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)</li>
      *   </ul>
          * @return List&lt;WardDTO&gt;
      */
      @RequestLine("GET /api/wards?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&wardCode.contains={wardCodeContains}&wardCode.doesNotContain={wardCodeDoesNotContain}&wardCode.equals={wardCodeEquals}&wardCode.notEquals={wardCodeNotEquals}&wardCode.specified={wardCodeSpecified}&wardCode.in={wardCodeIn}&wardCode.notIn={wardCodeNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&nameEn.contains={nameEnContains}&nameEn.doesNotContain={nameEnDoesNotContain}&nameEn.equals={nameEnEquals}&nameEn.notEquals={nameEnNotEquals}&nameEn.specified={nameEnSpecified}&nameEn.in={nameEnIn}&nameEn.notIn={nameEnNotIn}&fullName.contains={fullNameContains}&fullName.doesNotContain={fullNameDoesNotContain}&fullName.equals={fullNameEquals}&fullName.notEquals={fullNameNotEquals}&fullName.specified={fullNameSpecified}&fullName.in={fullNameIn}&fullName.notIn={fullNameNotIn}&fullNameEn.contains={fullNameEnContains}&fullNameEn.doesNotContain={fullNameEnDoesNotContain}&fullNameEn.equals={fullNameEnEquals}&fullNameEn.notEquals={fullNameEnNotEquals}&fullNameEn.specified={fullNameEnSpecified}&fullNameEn.in={fullNameEnIn}&fullNameEn.notIn={fullNameEnNotIn}&codeName.contains={codeNameContains}&codeName.doesNotContain={codeNameDoesNotContain}&codeName.equals={codeNameEquals}&codeName.notEquals={codeNameNotEquals}&codeName.specified={codeNameSpecified}&codeName.in={codeNameIn}&codeName.notIn={codeNameNotIn}&administrativeUnitId.greaterThan={administrativeUnitIdGreaterThan}&administrativeUnitId.lessThan={administrativeUnitIdLessThan}&administrativeUnitId.greaterThanOrEqual={administrativeUnitIdGreaterThanOrEqual}&administrativeUnitId.lessThanOrEqual={administrativeUnitIdLessThanOrEqual}&administrativeUnitId.equals={administrativeUnitIdEquals}&administrativeUnitId.notEquals={administrativeUnitIdNotEquals}&administrativeUnitId.specified={administrativeUnitIdSpecified}&administrativeUnitId.in={administrativeUnitIdIn}&administrativeUnitId.notIn={administrativeUnitIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&addressesId.greaterThan={addressesIdGreaterThan}&addressesId.lessThan={addressesIdLessThan}&addressesId.greaterThanOrEqual={addressesIdGreaterThanOrEqual}&addressesId.lessThanOrEqual={addressesIdLessThanOrEqual}&addressesId.equals={addressesIdEquals}&addressesId.notEquals={addressesIdNotEquals}&addressesId.specified={addressesIdSpecified}&addressesId.in={addressesIdIn}&addressesId.notIn={addressesIdNotIn}&districtId.greaterThan={districtIdGreaterThan}&districtId.lessThan={districtIdLessThan}&districtId.greaterThanOrEqual={districtIdGreaterThanOrEqual}&districtId.lessThanOrEqual={districtIdLessThanOrEqual}&districtId.equals={districtIdEquals}&districtId.notEquals={districtIdNotEquals}&districtId.specified={districtIdSpecified}&districtId.in={districtIdIn}&districtId.notIn={districtIdNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<WardDTO>> getAllWardsWithHttpInfo(@QueryMap(encoded=true) GetAllWardsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllWards</code> method in a fluent style.
   */
  public static class GetAllWardsQueryParams extends HashMap<String, Object> {
    public GetAllWardsQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllWardsQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllWardsQueryParams wardCodeContains(@jakarta.annotation.Nullable final String value) {
      put("wardCode.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams wardCodeDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("wardCode.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams wardCodeEquals(@jakarta.annotation.Nullable final String value) {
      put("wardCode.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams wardCodeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("wardCode.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams wardCodeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("wardCode.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams wardCodeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("wardCode.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllWardsQueryParams wardCodeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("wardCode.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllWardsQueryParams nameContains(@jakarta.annotation.Nullable final String value) {
      put("name.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams nameDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("name.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams nameEquals(@jakarta.annotation.Nullable final String value) {
      put("name.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams nameNotEquals(@jakarta.annotation.Nullable final String value) {
      put("name.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams nameSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("name.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams nameIn(@jakarta.annotation.Nullable final List<String> value) {
      put("name.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllWardsQueryParams nameNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("name.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllWardsQueryParams nameEnContains(@jakarta.annotation.Nullable final String value) {
      put("nameEn.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams nameEnDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("nameEn.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams nameEnEquals(@jakarta.annotation.Nullable final String value) {
      put("nameEn.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams nameEnNotEquals(@jakarta.annotation.Nullable final String value) {
      put("nameEn.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams nameEnSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("nameEn.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams nameEnIn(@jakarta.annotation.Nullable final List<String> value) {
      put("nameEn.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllWardsQueryParams nameEnNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("nameEn.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllWardsQueryParams fullNameContains(@jakarta.annotation.Nullable final String value) {
      put("fullName.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams fullNameDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("fullName.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams fullNameEquals(@jakarta.annotation.Nullable final String value) {
      put("fullName.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams fullNameNotEquals(@jakarta.annotation.Nullable final String value) {
      put("fullName.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams fullNameSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("fullName.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams fullNameIn(@jakarta.annotation.Nullable final List<String> value) {
      put("fullName.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllWardsQueryParams fullNameNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("fullName.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllWardsQueryParams fullNameEnContains(@jakarta.annotation.Nullable final String value) {
      put("fullNameEn.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams fullNameEnDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("fullNameEn.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams fullNameEnEquals(@jakarta.annotation.Nullable final String value) {
      put("fullNameEn.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams fullNameEnNotEquals(@jakarta.annotation.Nullable final String value) {
      put("fullNameEn.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams fullNameEnSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("fullNameEn.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams fullNameEnIn(@jakarta.annotation.Nullable final List<String> value) {
      put("fullNameEn.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllWardsQueryParams fullNameEnNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("fullNameEn.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllWardsQueryParams codeNameContains(@jakarta.annotation.Nullable final String value) {
      put("codeName.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams codeNameDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("codeName.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams codeNameEquals(@jakarta.annotation.Nullable final String value) {
      put("codeName.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams codeNameNotEquals(@jakarta.annotation.Nullable final String value) {
      put("codeName.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams codeNameSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("codeName.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams codeNameIn(@jakarta.annotation.Nullable final List<String> value) {
      put("codeName.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllWardsQueryParams codeNameNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("codeName.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllWardsQueryParams administrativeUnitIdGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams administrativeUnitIdLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams administrativeUnitIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams administrativeUnitIdLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams administrativeUnitIdEquals(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams administrativeUnitIdNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("administrativeUnitId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams administrativeUnitIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("administrativeUnitId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams administrativeUnitIdIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("administrativeUnitId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllWardsQueryParams administrativeUnitIdNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("administrativeUnitId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllWardsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllWardsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllWardsQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllWardsQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllWardsQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllWardsQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllWardsQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllWardsQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllWardsQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllWardsQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllWardsQueryParams addressesIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("addressesId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams addressesIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("addressesId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams addressesIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("addressesId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams addressesIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("addressesId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams addressesIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("addressesId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams addressesIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("addressesId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams addressesIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("addressesId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams addressesIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("addressesId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllWardsQueryParams addressesIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("addressesId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllWardsQueryParams districtIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("districtId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams districtIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("districtId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams districtIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("districtId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams districtIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("districtId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams districtIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("districtId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams districtIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("districtId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams districtIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("districtId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams districtIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("districtId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllWardsQueryParams districtIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("districtId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllWardsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams page(@jakarta.annotation.Nullable final Integer value) {
      put("page", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams size(@jakarta.annotation.Nullable final Integer value) {
      put("size", EncodingUtils.encode(value));
      return this;
    }
    public GetAllWardsQueryParams sort(@jakarta.annotation.Nullable final List<String> value) {
      put("sort", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @return WardDTO
   */
  @RequestLine("GET /api/wards/{id}")
  @Headers({
    "Accept: */*",
  })
  WardDTO getWard(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>getWard</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/wards/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<WardDTO> getWardWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param id  (required)
   * @param wardDTO  (required)
   * @return WardDTO
   */
  @RequestLine("PATCH /api/wards/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  WardDTO partialUpdateWard(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull WardDTO wardDTO);

  /**
   * 
   * Similar to <code>partialUpdateWard</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param wardDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /api/wards/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<WardDTO> partialUpdateWardWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull WardDTO wardDTO);



  /**
   * 
   * 
   * @param id  (required)
   * @param wardDTO  (required)
   * @return WardDTO
   */
  @RequestLine("PUT /api/wards/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  WardDTO updateWard(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull WardDTO wardDTO);

  /**
   * 
   * Similar to <code>updateWard</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param wardDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/wards/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<WardDTO> updateWardWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull WardDTO wardDTO);


}
