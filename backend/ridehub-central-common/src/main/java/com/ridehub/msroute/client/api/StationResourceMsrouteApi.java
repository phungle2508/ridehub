package com.ridehub.msroute.client.api;

import com.ridehub.msroute.client.invoker.ApiClient;
import com.ridehub.msroute.client.invoker.EncodingUtils;
import com.ridehub.msroute.client.model.ApiResponse;

import java.time.OffsetDateTime;
import com.ridehub.msroute.client.model.StationDTO;
import com.ridehub.msroute.client.model.StationWithRoutesVM;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface StationResourceMsrouteApi extends ApiClient.Api {


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
   * @param phoneNumberContains  (optional)
   * @param phoneNumberDoesNotContain  (optional)
   * @param phoneNumberEquals  (optional)
   * @param phoneNumberNotEquals  (optional)
   * @param phoneNumberSpecified  (optional)
   * @param phoneNumberIn  (optional)
   * @param phoneNumberNotIn  (optional)
   * @param descriptionContains  (optional)
   * @param descriptionDoesNotContain  (optional)
   * @param descriptionEquals  (optional)
   * @param descriptionNotEquals  (optional)
   * @param descriptionSpecified  (optional)
   * @param descriptionIn  (optional)
   * @param descriptionNotIn  (optional)
   * @param activeEquals  (optional)
   * @param activeNotEquals  (optional)
   * @param activeSpecified  (optional)
   * @param activeIn  (optional)
   * @param activeNotIn  (optional)
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
   * @param addressIdGreaterThan  (optional)
   * @param addressIdLessThan  (optional)
   * @param addressIdGreaterThanOrEqual  (optional)
   * @param addressIdLessThanOrEqual  (optional)
   * @param addressIdEquals  (optional)
   * @param addressIdNotEquals  (optional)
   * @param addressIdSpecified  (optional)
   * @param addressIdIn  (optional)
   * @param addressIdNotIn  (optional)
   * @param stationImgIdGreaterThan  (optional)
   * @param stationImgIdLessThan  (optional)
   * @param stationImgIdGreaterThanOrEqual  (optional)
   * @param stationImgIdLessThanOrEqual  (optional)
   * @param stationImgIdEquals  (optional)
   * @param stationImgIdNotEquals  (optional)
   * @param stationImgIdSpecified  (optional)
   * @param stationImgIdIn  (optional)
   * @param stationImgIdNotIn  (optional)
   * @param provinceCodeContains  (optional)
   * @param provinceCodeDoesNotContain  (optional)
   * @param provinceCodeEquals  (optional)
   * @param provinceCodeNotEquals  (optional)
   * @param provinceCodeSpecified  (optional)
   * @param provinceCodeIn  (optional)
   * @param provinceCodeNotIn  (optional)
   * @param districtCodeContains  (optional)
   * @param districtCodeDoesNotContain  (optional)
   * @param districtCodeEquals  (optional)
   * @param districtCodeNotEquals  (optional)
   * @param districtCodeSpecified  (optional)
   * @param districtCodeIn  (optional)
   * @param districtCodeNotIn  (optional)
   * @param distinct  (optional)
   * @return Long
   */
  @RequestLine("GET /api/stations/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&phoneNumber.contains={phoneNumberContains}&phoneNumber.doesNotContain={phoneNumberDoesNotContain}&phoneNumber.equals={phoneNumberEquals}&phoneNumber.notEquals={phoneNumberNotEquals}&phoneNumber.specified={phoneNumberSpecified}&phoneNumber.in={phoneNumberIn}&phoneNumber.notIn={phoneNumberNotIn}&description.contains={descriptionContains}&description.doesNotContain={descriptionDoesNotContain}&description.equals={descriptionEquals}&description.notEquals={descriptionNotEquals}&description.specified={descriptionSpecified}&description.in={descriptionIn}&description.notIn={descriptionNotIn}&active.equals={activeEquals}&active.notEquals={activeNotEquals}&active.specified={activeSpecified}&active.in={activeIn}&active.notIn={activeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&addressId.greaterThan={addressIdGreaterThan}&addressId.lessThan={addressIdLessThan}&addressId.greaterThanOrEqual={addressIdGreaterThanOrEqual}&addressId.lessThanOrEqual={addressIdLessThanOrEqual}&addressId.equals={addressIdEquals}&addressId.notEquals={addressIdNotEquals}&addressId.specified={addressIdSpecified}&addressId.in={addressIdIn}&addressId.notIn={addressIdNotIn}&stationImgId.greaterThan={stationImgIdGreaterThan}&stationImgId.lessThan={stationImgIdLessThan}&stationImgId.greaterThanOrEqual={stationImgIdGreaterThanOrEqual}&stationImgId.lessThanOrEqual={stationImgIdLessThanOrEqual}&stationImgId.equals={stationImgIdEquals}&stationImgId.notEquals={stationImgIdNotEquals}&stationImgId.specified={stationImgIdSpecified}&stationImgId.in={stationImgIdIn}&stationImgId.notIn={stationImgIdNotIn}&provinceCode.contains={provinceCodeContains}&provinceCode.doesNotContain={provinceCodeDoesNotContain}&provinceCode.equals={provinceCodeEquals}&provinceCode.notEquals={provinceCodeNotEquals}&provinceCode.specified={provinceCodeSpecified}&provinceCode.in={provinceCodeIn}&provinceCode.notIn={provinceCodeNotIn}&districtCode.contains={districtCodeContains}&districtCode.doesNotContain={districtCodeDoesNotContain}&districtCode.equals={districtCodeEquals}&districtCode.notEquals={districtCodeNotEquals}&districtCode.specified={districtCodeSpecified}&districtCode.in={districtCodeIn}&districtCode.notIn={districtCodeNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  Long countStations(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("nameContains") @jakarta.annotation.Nullable String nameContains, @Param("nameDoesNotContain") @jakarta.annotation.Nullable String nameDoesNotContain, @Param("nameEquals") @jakarta.annotation.Nullable String nameEquals, @Param("nameNotEquals") @jakarta.annotation.Nullable String nameNotEquals, @Param("nameSpecified") @jakarta.annotation.Nullable Boolean nameSpecified, @Param("nameIn") @jakarta.annotation.Nullable List<String> nameIn, @Param("nameNotIn") @jakarta.annotation.Nullable List<String> nameNotIn, @Param("phoneNumberContains") @jakarta.annotation.Nullable String phoneNumberContains, @Param("phoneNumberDoesNotContain") @jakarta.annotation.Nullable String phoneNumberDoesNotContain, @Param("phoneNumberEquals") @jakarta.annotation.Nullable String phoneNumberEquals, @Param("phoneNumberNotEquals") @jakarta.annotation.Nullable String phoneNumberNotEquals, @Param("phoneNumberSpecified") @jakarta.annotation.Nullable Boolean phoneNumberSpecified, @Param("phoneNumberIn") @jakarta.annotation.Nullable List<String> phoneNumberIn, @Param("phoneNumberNotIn") @jakarta.annotation.Nullable List<String> phoneNumberNotIn, @Param("descriptionContains") @jakarta.annotation.Nullable String descriptionContains, @Param("descriptionDoesNotContain") @jakarta.annotation.Nullable String descriptionDoesNotContain, @Param("descriptionEquals") @jakarta.annotation.Nullable String descriptionEquals, @Param("descriptionNotEquals") @jakarta.annotation.Nullable String descriptionNotEquals, @Param("descriptionSpecified") @jakarta.annotation.Nullable Boolean descriptionSpecified, @Param("descriptionIn") @jakarta.annotation.Nullable List<String> descriptionIn, @Param("descriptionNotIn") @jakarta.annotation.Nullable List<String> descriptionNotIn, @Param("activeEquals") @jakarta.annotation.Nullable Boolean activeEquals, @Param("activeNotEquals") @jakarta.annotation.Nullable Boolean activeNotEquals, @Param("activeSpecified") @jakarta.annotation.Nullable Boolean activeSpecified, @Param("activeIn") @jakarta.annotation.Nullable List<Boolean> activeIn, @Param("activeNotIn") @jakarta.annotation.Nullable List<Boolean> activeNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("addressIdGreaterThan") @jakarta.annotation.Nullable Long addressIdGreaterThan, @Param("addressIdLessThan") @jakarta.annotation.Nullable Long addressIdLessThan, @Param("addressIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long addressIdGreaterThanOrEqual, @Param("addressIdLessThanOrEqual") @jakarta.annotation.Nullable Long addressIdLessThanOrEqual, @Param("addressIdEquals") @jakarta.annotation.Nullable Long addressIdEquals, @Param("addressIdNotEquals") @jakarta.annotation.Nullable Long addressIdNotEquals, @Param("addressIdSpecified") @jakarta.annotation.Nullable Boolean addressIdSpecified, @Param("addressIdIn") @jakarta.annotation.Nullable List<Long> addressIdIn, @Param("addressIdNotIn") @jakarta.annotation.Nullable List<Long> addressIdNotIn, @Param("stationImgIdGreaterThan") @jakarta.annotation.Nullable Long stationImgIdGreaterThan, @Param("stationImgIdLessThan") @jakarta.annotation.Nullable Long stationImgIdLessThan, @Param("stationImgIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long stationImgIdGreaterThanOrEqual, @Param("stationImgIdLessThanOrEqual") @jakarta.annotation.Nullable Long stationImgIdLessThanOrEqual, @Param("stationImgIdEquals") @jakarta.annotation.Nullable Long stationImgIdEquals, @Param("stationImgIdNotEquals") @jakarta.annotation.Nullable Long stationImgIdNotEquals, @Param("stationImgIdSpecified") @jakarta.annotation.Nullable Boolean stationImgIdSpecified, @Param("stationImgIdIn") @jakarta.annotation.Nullable List<Long> stationImgIdIn, @Param("stationImgIdNotIn") @jakarta.annotation.Nullable List<Long> stationImgIdNotIn, @Param("provinceCodeContains") @jakarta.annotation.Nullable String provinceCodeContains, @Param("provinceCodeDoesNotContain") @jakarta.annotation.Nullable String provinceCodeDoesNotContain, @Param("provinceCodeEquals") @jakarta.annotation.Nullable String provinceCodeEquals, @Param("provinceCodeNotEquals") @jakarta.annotation.Nullable String provinceCodeNotEquals, @Param("provinceCodeSpecified") @jakarta.annotation.Nullable Boolean provinceCodeSpecified, @Param("provinceCodeIn") @jakarta.annotation.Nullable List<String> provinceCodeIn, @Param("provinceCodeNotIn") @jakarta.annotation.Nullable List<String> provinceCodeNotIn, @Param("districtCodeContains") @jakarta.annotation.Nullable String districtCodeContains, @Param("districtCodeDoesNotContain") @jakarta.annotation.Nullable String districtCodeDoesNotContain, @Param("districtCodeEquals") @jakarta.annotation.Nullable String districtCodeEquals, @Param("districtCodeNotEquals") @jakarta.annotation.Nullable String districtCodeNotEquals, @Param("districtCodeSpecified") @jakarta.annotation.Nullable Boolean districtCodeSpecified, @Param("districtCodeIn") @jakarta.annotation.Nullable List<String> districtCodeIn, @Param("districtCodeNotIn") @jakarta.annotation.Nullable List<String> districtCodeNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>countStations</code> but it also returns the http response headers .
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
   * @param phoneNumberContains  (optional)
   * @param phoneNumberDoesNotContain  (optional)
   * @param phoneNumberEquals  (optional)
   * @param phoneNumberNotEquals  (optional)
   * @param phoneNumberSpecified  (optional)
   * @param phoneNumberIn  (optional)
   * @param phoneNumberNotIn  (optional)
   * @param descriptionContains  (optional)
   * @param descriptionDoesNotContain  (optional)
   * @param descriptionEquals  (optional)
   * @param descriptionNotEquals  (optional)
   * @param descriptionSpecified  (optional)
   * @param descriptionIn  (optional)
   * @param descriptionNotIn  (optional)
   * @param activeEquals  (optional)
   * @param activeNotEquals  (optional)
   * @param activeSpecified  (optional)
   * @param activeIn  (optional)
   * @param activeNotIn  (optional)
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
   * @param addressIdGreaterThan  (optional)
   * @param addressIdLessThan  (optional)
   * @param addressIdGreaterThanOrEqual  (optional)
   * @param addressIdLessThanOrEqual  (optional)
   * @param addressIdEquals  (optional)
   * @param addressIdNotEquals  (optional)
   * @param addressIdSpecified  (optional)
   * @param addressIdIn  (optional)
   * @param addressIdNotIn  (optional)
   * @param stationImgIdGreaterThan  (optional)
   * @param stationImgIdLessThan  (optional)
   * @param stationImgIdGreaterThanOrEqual  (optional)
   * @param stationImgIdLessThanOrEqual  (optional)
   * @param stationImgIdEquals  (optional)
   * @param stationImgIdNotEquals  (optional)
   * @param stationImgIdSpecified  (optional)
   * @param stationImgIdIn  (optional)
   * @param stationImgIdNotIn  (optional)
   * @param provinceCodeContains  (optional)
   * @param provinceCodeDoesNotContain  (optional)
   * @param provinceCodeEquals  (optional)
   * @param provinceCodeNotEquals  (optional)
   * @param provinceCodeSpecified  (optional)
   * @param provinceCodeIn  (optional)
   * @param provinceCodeNotIn  (optional)
   * @param districtCodeContains  (optional)
   * @param districtCodeDoesNotContain  (optional)
   * @param districtCodeEquals  (optional)
   * @param districtCodeNotEquals  (optional)
   * @param districtCodeSpecified  (optional)
   * @param districtCodeIn  (optional)
   * @param districtCodeNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/stations/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&phoneNumber.contains={phoneNumberContains}&phoneNumber.doesNotContain={phoneNumberDoesNotContain}&phoneNumber.equals={phoneNumberEquals}&phoneNumber.notEquals={phoneNumberNotEquals}&phoneNumber.specified={phoneNumberSpecified}&phoneNumber.in={phoneNumberIn}&phoneNumber.notIn={phoneNumberNotIn}&description.contains={descriptionContains}&description.doesNotContain={descriptionDoesNotContain}&description.equals={descriptionEquals}&description.notEquals={descriptionNotEquals}&description.specified={descriptionSpecified}&description.in={descriptionIn}&description.notIn={descriptionNotIn}&active.equals={activeEquals}&active.notEquals={activeNotEquals}&active.specified={activeSpecified}&active.in={activeIn}&active.notIn={activeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&addressId.greaterThan={addressIdGreaterThan}&addressId.lessThan={addressIdLessThan}&addressId.greaterThanOrEqual={addressIdGreaterThanOrEqual}&addressId.lessThanOrEqual={addressIdLessThanOrEqual}&addressId.equals={addressIdEquals}&addressId.notEquals={addressIdNotEquals}&addressId.specified={addressIdSpecified}&addressId.in={addressIdIn}&addressId.notIn={addressIdNotIn}&stationImgId.greaterThan={stationImgIdGreaterThan}&stationImgId.lessThan={stationImgIdLessThan}&stationImgId.greaterThanOrEqual={stationImgIdGreaterThanOrEqual}&stationImgId.lessThanOrEqual={stationImgIdLessThanOrEqual}&stationImgId.equals={stationImgIdEquals}&stationImgId.notEquals={stationImgIdNotEquals}&stationImgId.specified={stationImgIdSpecified}&stationImgId.in={stationImgIdIn}&stationImgId.notIn={stationImgIdNotIn}&provinceCode.contains={provinceCodeContains}&provinceCode.doesNotContain={provinceCodeDoesNotContain}&provinceCode.equals={provinceCodeEquals}&provinceCode.notEquals={provinceCodeNotEquals}&provinceCode.specified={provinceCodeSpecified}&provinceCode.in={provinceCodeIn}&provinceCode.notIn={provinceCodeNotIn}&districtCode.contains={districtCodeContains}&districtCode.doesNotContain={districtCodeDoesNotContain}&districtCode.equals={districtCodeEquals}&districtCode.notEquals={districtCodeNotEquals}&districtCode.specified={districtCodeSpecified}&districtCode.in={districtCodeIn}&districtCode.notIn={districtCodeNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Long> countStationsWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("nameContains") @jakarta.annotation.Nullable String nameContains, @Param("nameDoesNotContain") @jakarta.annotation.Nullable String nameDoesNotContain, @Param("nameEquals") @jakarta.annotation.Nullable String nameEquals, @Param("nameNotEquals") @jakarta.annotation.Nullable String nameNotEquals, @Param("nameSpecified") @jakarta.annotation.Nullable Boolean nameSpecified, @Param("nameIn") @jakarta.annotation.Nullable List<String> nameIn, @Param("nameNotIn") @jakarta.annotation.Nullable List<String> nameNotIn, @Param("phoneNumberContains") @jakarta.annotation.Nullable String phoneNumberContains, @Param("phoneNumberDoesNotContain") @jakarta.annotation.Nullable String phoneNumberDoesNotContain, @Param("phoneNumberEquals") @jakarta.annotation.Nullable String phoneNumberEquals, @Param("phoneNumberNotEquals") @jakarta.annotation.Nullable String phoneNumberNotEquals, @Param("phoneNumberSpecified") @jakarta.annotation.Nullable Boolean phoneNumberSpecified, @Param("phoneNumberIn") @jakarta.annotation.Nullable List<String> phoneNumberIn, @Param("phoneNumberNotIn") @jakarta.annotation.Nullable List<String> phoneNumberNotIn, @Param("descriptionContains") @jakarta.annotation.Nullable String descriptionContains, @Param("descriptionDoesNotContain") @jakarta.annotation.Nullable String descriptionDoesNotContain, @Param("descriptionEquals") @jakarta.annotation.Nullable String descriptionEquals, @Param("descriptionNotEquals") @jakarta.annotation.Nullable String descriptionNotEquals, @Param("descriptionSpecified") @jakarta.annotation.Nullable Boolean descriptionSpecified, @Param("descriptionIn") @jakarta.annotation.Nullable List<String> descriptionIn, @Param("descriptionNotIn") @jakarta.annotation.Nullable List<String> descriptionNotIn, @Param("activeEquals") @jakarta.annotation.Nullable Boolean activeEquals, @Param("activeNotEquals") @jakarta.annotation.Nullable Boolean activeNotEquals, @Param("activeSpecified") @jakarta.annotation.Nullable Boolean activeSpecified, @Param("activeIn") @jakarta.annotation.Nullable List<Boolean> activeIn, @Param("activeNotIn") @jakarta.annotation.Nullable List<Boolean> activeNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("addressIdGreaterThan") @jakarta.annotation.Nullable Long addressIdGreaterThan, @Param("addressIdLessThan") @jakarta.annotation.Nullable Long addressIdLessThan, @Param("addressIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long addressIdGreaterThanOrEqual, @Param("addressIdLessThanOrEqual") @jakarta.annotation.Nullable Long addressIdLessThanOrEqual, @Param("addressIdEquals") @jakarta.annotation.Nullable Long addressIdEquals, @Param("addressIdNotEquals") @jakarta.annotation.Nullable Long addressIdNotEquals, @Param("addressIdSpecified") @jakarta.annotation.Nullable Boolean addressIdSpecified, @Param("addressIdIn") @jakarta.annotation.Nullable List<Long> addressIdIn, @Param("addressIdNotIn") @jakarta.annotation.Nullable List<Long> addressIdNotIn, @Param("stationImgIdGreaterThan") @jakarta.annotation.Nullable Long stationImgIdGreaterThan, @Param("stationImgIdLessThan") @jakarta.annotation.Nullable Long stationImgIdLessThan, @Param("stationImgIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long stationImgIdGreaterThanOrEqual, @Param("stationImgIdLessThanOrEqual") @jakarta.annotation.Nullable Long stationImgIdLessThanOrEqual, @Param("stationImgIdEquals") @jakarta.annotation.Nullable Long stationImgIdEquals, @Param("stationImgIdNotEquals") @jakarta.annotation.Nullable Long stationImgIdNotEquals, @Param("stationImgIdSpecified") @jakarta.annotation.Nullable Boolean stationImgIdSpecified, @Param("stationImgIdIn") @jakarta.annotation.Nullable List<Long> stationImgIdIn, @Param("stationImgIdNotIn") @jakarta.annotation.Nullable List<Long> stationImgIdNotIn, @Param("provinceCodeContains") @jakarta.annotation.Nullable String provinceCodeContains, @Param("provinceCodeDoesNotContain") @jakarta.annotation.Nullable String provinceCodeDoesNotContain, @Param("provinceCodeEquals") @jakarta.annotation.Nullable String provinceCodeEquals, @Param("provinceCodeNotEquals") @jakarta.annotation.Nullable String provinceCodeNotEquals, @Param("provinceCodeSpecified") @jakarta.annotation.Nullable Boolean provinceCodeSpecified, @Param("provinceCodeIn") @jakarta.annotation.Nullable List<String> provinceCodeIn, @Param("provinceCodeNotIn") @jakarta.annotation.Nullable List<String> provinceCodeNotIn, @Param("districtCodeContains") @jakarta.annotation.Nullable String districtCodeContains, @Param("districtCodeDoesNotContain") @jakarta.annotation.Nullable String districtCodeDoesNotContain, @Param("districtCodeEquals") @jakarta.annotation.Nullable String districtCodeEquals, @Param("districtCodeNotEquals") @jakarta.annotation.Nullable String districtCodeNotEquals, @Param("districtCodeSpecified") @jakarta.annotation.Nullable Boolean districtCodeSpecified, @Param("districtCodeIn") @jakarta.annotation.Nullable List<String> districtCodeIn, @Param("districtCodeNotIn") @jakarta.annotation.Nullable List<String> districtCodeNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>countStations</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CountStationsQueryParams} class that allows for
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
   *   <li>phoneNumberContains -  (optional)</li>
   *   <li>phoneNumberDoesNotContain -  (optional)</li>
   *   <li>phoneNumberEquals -  (optional)</li>
   *   <li>phoneNumberNotEquals -  (optional)</li>
   *   <li>phoneNumberSpecified -  (optional)</li>
   *   <li>phoneNumberIn -  (optional)</li>
   *   <li>phoneNumberNotIn -  (optional)</li>
   *   <li>descriptionContains -  (optional)</li>
   *   <li>descriptionDoesNotContain -  (optional)</li>
   *   <li>descriptionEquals -  (optional)</li>
   *   <li>descriptionNotEquals -  (optional)</li>
   *   <li>descriptionSpecified -  (optional)</li>
   *   <li>descriptionIn -  (optional)</li>
   *   <li>descriptionNotIn -  (optional)</li>
   *   <li>activeEquals -  (optional)</li>
   *   <li>activeNotEquals -  (optional)</li>
   *   <li>activeSpecified -  (optional)</li>
   *   <li>activeIn -  (optional)</li>
   *   <li>activeNotIn -  (optional)</li>
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
   *   <li>addressIdGreaterThan -  (optional)</li>
   *   <li>addressIdLessThan -  (optional)</li>
   *   <li>addressIdGreaterThanOrEqual -  (optional)</li>
   *   <li>addressIdLessThanOrEqual -  (optional)</li>
   *   <li>addressIdEquals -  (optional)</li>
   *   <li>addressIdNotEquals -  (optional)</li>
   *   <li>addressIdSpecified -  (optional)</li>
   *   <li>addressIdIn -  (optional)</li>
   *   <li>addressIdNotIn -  (optional)</li>
   *   <li>stationImgIdGreaterThan -  (optional)</li>
   *   <li>stationImgIdLessThan -  (optional)</li>
   *   <li>stationImgIdGreaterThanOrEqual -  (optional)</li>
   *   <li>stationImgIdLessThanOrEqual -  (optional)</li>
   *   <li>stationImgIdEquals -  (optional)</li>
   *   <li>stationImgIdNotEquals -  (optional)</li>
   *   <li>stationImgIdSpecified -  (optional)</li>
   *   <li>stationImgIdIn -  (optional)</li>
   *   <li>stationImgIdNotIn -  (optional)</li>
   *   <li>provinceCodeContains -  (optional)</li>
   *   <li>provinceCodeDoesNotContain -  (optional)</li>
   *   <li>provinceCodeEquals -  (optional)</li>
   *   <li>provinceCodeNotEquals -  (optional)</li>
   *   <li>provinceCodeSpecified -  (optional)</li>
   *   <li>provinceCodeIn -  (optional)</li>
   *   <li>provinceCodeNotIn -  (optional)</li>
   *   <li>districtCodeContains -  (optional)</li>
   *   <li>districtCodeDoesNotContain -  (optional)</li>
   *   <li>districtCodeEquals -  (optional)</li>
   *   <li>districtCodeNotEquals -  (optional)</li>
   *   <li>districtCodeSpecified -  (optional)</li>
   *   <li>districtCodeIn -  (optional)</li>
   *   <li>districtCodeNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return Long
   */
  @RequestLine("GET /api/stations/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&phoneNumber.contains={phoneNumberContains}&phoneNumber.doesNotContain={phoneNumberDoesNotContain}&phoneNumber.equals={phoneNumberEquals}&phoneNumber.notEquals={phoneNumberNotEquals}&phoneNumber.specified={phoneNumberSpecified}&phoneNumber.in={phoneNumberIn}&phoneNumber.notIn={phoneNumberNotIn}&description.contains={descriptionContains}&description.doesNotContain={descriptionDoesNotContain}&description.equals={descriptionEquals}&description.notEquals={descriptionNotEquals}&description.specified={descriptionSpecified}&description.in={descriptionIn}&description.notIn={descriptionNotIn}&active.equals={activeEquals}&active.notEquals={activeNotEquals}&active.specified={activeSpecified}&active.in={activeIn}&active.notIn={activeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&addressId.greaterThan={addressIdGreaterThan}&addressId.lessThan={addressIdLessThan}&addressId.greaterThanOrEqual={addressIdGreaterThanOrEqual}&addressId.lessThanOrEqual={addressIdLessThanOrEqual}&addressId.equals={addressIdEquals}&addressId.notEquals={addressIdNotEquals}&addressId.specified={addressIdSpecified}&addressId.in={addressIdIn}&addressId.notIn={addressIdNotIn}&stationImgId.greaterThan={stationImgIdGreaterThan}&stationImgId.lessThan={stationImgIdLessThan}&stationImgId.greaterThanOrEqual={stationImgIdGreaterThanOrEqual}&stationImgId.lessThanOrEqual={stationImgIdLessThanOrEqual}&stationImgId.equals={stationImgIdEquals}&stationImgId.notEquals={stationImgIdNotEquals}&stationImgId.specified={stationImgIdSpecified}&stationImgId.in={stationImgIdIn}&stationImgId.notIn={stationImgIdNotIn}&provinceCode.contains={provinceCodeContains}&provinceCode.doesNotContain={provinceCodeDoesNotContain}&provinceCode.equals={provinceCodeEquals}&provinceCode.notEquals={provinceCodeNotEquals}&provinceCode.specified={provinceCodeSpecified}&provinceCode.in={provinceCodeIn}&provinceCode.notIn={provinceCodeNotIn}&districtCode.contains={districtCodeContains}&districtCode.doesNotContain={districtCodeDoesNotContain}&districtCode.equals={districtCodeEquals}&districtCode.notEquals={districtCodeNotEquals}&districtCode.specified={districtCodeSpecified}&districtCode.in={districtCodeIn}&districtCode.notIn={districtCodeNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  Long countStations(@QueryMap(encoded=true) CountStationsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>countStations</code> that receives the query parameters as a map,
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
          *   <li>phoneNumberContains -  (optional)</li>
          *   <li>phoneNumberDoesNotContain -  (optional)</li>
          *   <li>phoneNumberEquals -  (optional)</li>
          *   <li>phoneNumberNotEquals -  (optional)</li>
          *   <li>phoneNumberSpecified -  (optional)</li>
          *   <li>phoneNumberIn -  (optional)</li>
          *   <li>phoneNumberNotIn -  (optional)</li>
          *   <li>descriptionContains -  (optional)</li>
          *   <li>descriptionDoesNotContain -  (optional)</li>
          *   <li>descriptionEquals -  (optional)</li>
          *   <li>descriptionNotEquals -  (optional)</li>
          *   <li>descriptionSpecified -  (optional)</li>
          *   <li>descriptionIn -  (optional)</li>
          *   <li>descriptionNotIn -  (optional)</li>
          *   <li>activeEquals -  (optional)</li>
          *   <li>activeNotEquals -  (optional)</li>
          *   <li>activeSpecified -  (optional)</li>
          *   <li>activeIn -  (optional)</li>
          *   <li>activeNotIn -  (optional)</li>
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
          *   <li>addressIdGreaterThan -  (optional)</li>
          *   <li>addressIdLessThan -  (optional)</li>
          *   <li>addressIdGreaterThanOrEqual -  (optional)</li>
          *   <li>addressIdLessThanOrEqual -  (optional)</li>
          *   <li>addressIdEquals -  (optional)</li>
          *   <li>addressIdNotEquals -  (optional)</li>
          *   <li>addressIdSpecified -  (optional)</li>
          *   <li>addressIdIn -  (optional)</li>
          *   <li>addressIdNotIn -  (optional)</li>
          *   <li>stationImgIdGreaterThan -  (optional)</li>
          *   <li>stationImgIdLessThan -  (optional)</li>
          *   <li>stationImgIdGreaterThanOrEqual -  (optional)</li>
          *   <li>stationImgIdLessThanOrEqual -  (optional)</li>
          *   <li>stationImgIdEquals -  (optional)</li>
          *   <li>stationImgIdNotEquals -  (optional)</li>
          *   <li>stationImgIdSpecified -  (optional)</li>
          *   <li>stationImgIdIn -  (optional)</li>
          *   <li>stationImgIdNotIn -  (optional)</li>
          *   <li>provinceCodeContains -  (optional)</li>
          *   <li>provinceCodeDoesNotContain -  (optional)</li>
          *   <li>provinceCodeEquals -  (optional)</li>
          *   <li>provinceCodeNotEquals -  (optional)</li>
          *   <li>provinceCodeSpecified -  (optional)</li>
          *   <li>provinceCodeIn -  (optional)</li>
          *   <li>provinceCodeNotIn -  (optional)</li>
          *   <li>districtCodeContains -  (optional)</li>
          *   <li>districtCodeDoesNotContain -  (optional)</li>
          *   <li>districtCodeEquals -  (optional)</li>
          *   <li>districtCodeNotEquals -  (optional)</li>
          *   <li>districtCodeSpecified -  (optional)</li>
          *   <li>districtCodeIn -  (optional)</li>
          *   <li>districtCodeNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return Long
      */
      @RequestLine("GET /api/stations/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&phoneNumber.contains={phoneNumberContains}&phoneNumber.doesNotContain={phoneNumberDoesNotContain}&phoneNumber.equals={phoneNumberEquals}&phoneNumber.notEquals={phoneNumberNotEquals}&phoneNumber.specified={phoneNumberSpecified}&phoneNumber.in={phoneNumberIn}&phoneNumber.notIn={phoneNumberNotIn}&description.contains={descriptionContains}&description.doesNotContain={descriptionDoesNotContain}&description.equals={descriptionEquals}&description.notEquals={descriptionNotEquals}&description.specified={descriptionSpecified}&description.in={descriptionIn}&description.notIn={descriptionNotIn}&active.equals={activeEquals}&active.notEquals={activeNotEquals}&active.specified={activeSpecified}&active.in={activeIn}&active.notIn={activeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&addressId.greaterThan={addressIdGreaterThan}&addressId.lessThan={addressIdLessThan}&addressId.greaterThanOrEqual={addressIdGreaterThanOrEqual}&addressId.lessThanOrEqual={addressIdLessThanOrEqual}&addressId.equals={addressIdEquals}&addressId.notEquals={addressIdNotEquals}&addressId.specified={addressIdSpecified}&addressId.in={addressIdIn}&addressId.notIn={addressIdNotIn}&stationImgId.greaterThan={stationImgIdGreaterThan}&stationImgId.lessThan={stationImgIdLessThan}&stationImgId.greaterThanOrEqual={stationImgIdGreaterThanOrEqual}&stationImgId.lessThanOrEqual={stationImgIdLessThanOrEqual}&stationImgId.equals={stationImgIdEquals}&stationImgId.notEquals={stationImgIdNotEquals}&stationImgId.specified={stationImgIdSpecified}&stationImgId.in={stationImgIdIn}&stationImgId.notIn={stationImgIdNotIn}&provinceCode.contains={provinceCodeContains}&provinceCode.doesNotContain={provinceCodeDoesNotContain}&provinceCode.equals={provinceCodeEquals}&provinceCode.notEquals={provinceCodeNotEquals}&provinceCode.specified={provinceCodeSpecified}&provinceCode.in={provinceCodeIn}&provinceCode.notIn={provinceCodeNotIn}&districtCode.contains={districtCodeContains}&districtCode.doesNotContain={districtCodeDoesNotContain}&districtCode.equals={districtCodeEquals}&districtCode.notEquals={districtCodeNotEquals}&districtCode.specified={districtCodeSpecified}&districtCode.in={districtCodeIn}&districtCode.notIn={districtCodeNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Long> countStationsWithHttpInfo(@QueryMap(encoded=true) CountStationsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>countStations</code> method in a fluent style.
   */
  public static class CountStationsQueryParams extends HashMap<String, Object> {
    public CountStationsQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStationsQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStationsQueryParams nameContains(@jakarta.annotation.Nullable final String value) {
      put("name.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams nameDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("name.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams nameEquals(@jakarta.annotation.Nullable final String value) {
      put("name.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams nameNotEquals(@jakarta.annotation.Nullable final String value) {
      put("name.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams nameSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("name.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams nameIn(@jakarta.annotation.Nullable final List<String> value) {
      put("name.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStationsQueryParams nameNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("name.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStationsQueryParams phoneNumberContains(@jakarta.annotation.Nullable final String value) {
      put("phoneNumber.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams phoneNumberDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("phoneNumber.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams phoneNumberEquals(@jakarta.annotation.Nullable final String value) {
      put("phoneNumber.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams phoneNumberNotEquals(@jakarta.annotation.Nullable final String value) {
      put("phoneNumber.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams phoneNumberSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("phoneNumber.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams phoneNumberIn(@jakarta.annotation.Nullable final List<String> value) {
      put("phoneNumber.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStationsQueryParams phoneNumberNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("phoneNumber.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStationsQueryParams descriptionContains(@jakarta.annotation.Nullable final String value) {
      put("description.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams descriptionDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("description.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams descriptionEquals(@jakarta.annotation.Nullable final String value) {
      put("description.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams descriptionNotEquals(@jakarta.annotation.Nullable final String value) {
      put("description.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams descriptionSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("description.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams descriptionIn(@jakarta.annotation.Nullable final List<String> value) {
      put("description.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStationsQueryParams descriptionNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("description.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStationsQueryParams activeEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("active.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams activeNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("active.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams activeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("active.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams activeIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("active.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStationsQueryParams activeNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("active.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStationsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStationsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStationsQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStationsQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStationsQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStationsQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStationsQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStationsQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStationsQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStationsQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStationsQueryParams addressIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("addressId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams addressIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("addressId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams addressIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("addressId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams addressIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("addressId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams addressIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("addressId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams addressIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("addressId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams addressIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("addressId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams addressIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("addressId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStationsQueryParams addressIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("addressId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStationsQueryParams stationImgIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("stationImgId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams stationImgIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("stationImgId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams stationImgIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("stationImgId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams stationImgIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("stationImgId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams stationImgIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("stationImgId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams stationImgIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("stationImgId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams stationImgIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("stationImgId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams stationImgIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("stationImgId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStationsQueryParams stationImgIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("stationImgId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStationsQueryParams provinceCodeContains(@jakarta.annotation.Nullable final String value) {
      put("provinceCode.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams provinceCodeDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("provinceCode.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams provinceCodeEquals(@jakarta.annotation.Nullable final String value) {
      put("provinceCode.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams provinceCodeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("provinceCode.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams provinceCodeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("provinceCode.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams provinceCodeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("provinceCode.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStationsQueryParams provinceCodeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("provinceCode.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStationsQueryParams districtCodeContains(@jakarta.annotation.Nullable final String value) {
      put("districtCode.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams districtCodeDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("districtCode.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams districtCodeEquals(@jakarta.annotation.Nullable final String value) {
      put("districtCode.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams districtCodeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("districtCode.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams districtCodeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("districtCode.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountStationsQueryParams districtCodeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("districtCode.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStationsQueryParams districtCodeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("districtCode.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountStationsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param stationDTO  (required)
   * @return StationDTO
   */
  @RequestLine("POST /api/stations")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  StationDTO createStation(@jakarta.annotation.Nonnull StationDTO stationDTO);

  /**
   * 
   * Similar to <code>createStation</code> but it also returns the http response headers .
   * 
   * @param stationDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/stations")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<StationDTO> createStationWithHttpInfo(@jakarta.annotation.Nonnull StationDTO stationDTO);



  /**
   * 
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/stations/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteStation(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>deleteStation</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/stations/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteStationWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



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
   * @param phoneNumberContains  (optional)
   * @param phoneNumberDoesNotContain  (optional)
   * @param phoneNumberEquals  (optional)
   * @param phoneNumberNotEquals  (optional)
   * @param phoneNumberSpecified  (optional)
   * @param phoneNumberIn  (optional)
   * @param phoneNumberNotIn  (optional)
   * @param descriptionContains  (optional)
   * @param descriptionDoesNotContain  (optional)
   * @param descriptionEquals  (optional)
   * @param descriptionNotEquals  (optional)
   * @param descriptionSpecified  (optional)
   * @param descriptionIn  (optional)
   * @param descriptionNotIn  (optional)
   * @param activeEquals  (optional)
   * @param activeNotEquals  (optional)
   * @param activeSpecified  (optional)
   * @param activeIn  (optional)
   * @param activeNotIn  (optional)
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
   * @param addressIdGreaterThan  (optional)
   * @param addressIdLessThan  (optional)
   * @param addressIdGreaterThanOrEqual  (optional)
   * @param addressIdLessThanOrEqual  (optional)
   * @param addressIdEquals  (optional)
   * @param addressIdNotEquals  (optional)
   * @param addressIdSpecified  (optional)
   * @param addressIdIn  (optional)
   * @param addressIdNotIn  (optional)
   * @param stationImgIdGreaterThan  (optional)
   * @param stationImgIdLessThan  (optional)
   * @param stationImgIdGreaterThanOrEqual  (optional)
   * @param stationImgIdLessThanOrEqual  (optional)
   * @param stationImgIdEquals  (optional)
   * @param stationImgIdNotEquals  (optional)
   * @param stationImgIdSpecified  (optional)
   * @param stationImgIdIn  (optional)
   * @param stationImgIdNotIn  (optional)
   * @param provinceCodeContains  (optional)
   * @param provinceCodeDoesNotContain  (optional)
   * @param provinceCodeEquals  (optional)
   * @param provinceCodeNotEquals  (optional)
   * @param provinceCodeSpecified  (optional)
   * @param provinceCodeIn  (optional)
   * @param provinceCodeNotIn  (optional)
   * @param districtCodeContains  (optional)
   * @param districtCodeDoesNotContain  (optional)
   * @param districtCodeEquals  (optional)
   * @param districtCodeNotEquals  (optional)
   * @param districtCodeSpecified  (optional)
   * @param districtCodeIn  (optional)
   * @param districtCodeNotIn  (optional)
   * @param distinct  (optional)
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return List&lt;StationDTO&gt;
   */
  @RequestLine("GET /api/stations?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&phoneNumber.contains={phoneNumberContains}&phoneNumber.doesNotContain={phoneNumberDoesNotContain}&phoneNumber.equals={phoneNumberEquals}&phoneNumber.notEquals={phoneNumberNotEquals}&phoneNumber.specified={phoneNumberSpecified}&phoneNumber.in={phoneNumberIn}&phoneNumber.notIn={phoneNumberNotIn}&description.contains={descriptionContains}&description.doesNotContain={descriptionDoesNotContain}&description.equals={descriptionEquals}&description.notEquals={descriptionNotEquals}&description.specified={descriptionSpecified}&description.in={descriptionIn}&description.notIn={descriptionNotIn}&active.equals={activeEquals}&active.notEquals={activeNotEquals}&active.specified={activeSpecified}&active.in={activeIn}&active.notIn={activeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&addressId.greaterThan={addressIdGreaterThan}&addressId.lessThan={addressIdLessThan}&addressId.greaterThanOrEqual={addressIdGreaterThanOrEqual}&addressId.lessThanOrEqual={addressIdLessThanOrEqual}&addressId.equals={addressIdEquals}&addressId.notEquals={addressIdNotEquals}&addressId.specified={addressIdSpecified}&addressId.in={addressIdIn}&addressId.notIn={addressIdNotIn}&stationImgId.greaterThan={stationImgIdGreaterThan}&stationImgId.lessThan={stationImgIdLessThan}&stationImgId.greaterThanOrEqual={stationImgIdGreaterThanOrEqual}&stationImgId.lessThanOrEqual={stationImgIdLessThanOrEqual}&stationImgId.equals={stationImgIdEquals}&stationImgId.notEquals={stationImgIdNotEquals}&stationImgId.specified={stationImgIdSpecified}&stationImgId.in={stationImgIdIn}&stationImgId.notIn={stationImgIdNotIn}&provinceCode.contains={provinceCodeContains}&provinceCode.doesNotContain={provinceCodeDoesNotContain}&provinceCode.equals={provinceCodeEquals}&provinceCode.notEquals={provinceCodeNotEquals}&provinceCode.specified={provinceCodeSpecified}&provinceCode.in={provinceCodeIn}&provinceCode.notIn={provinceCodeNotIn}&districtCode.contains={districtCodeContains}&districtCode.doesNotContain={districtCodeDoesNotContain}&districtCode.equals={districtCodeEquals}&districtCode.notEquals={districtCodeNotEquals}&districtCode.specified={districtCodeSpecified}&districtCode.in={districtCodeIn}&districtCode.notIn={districtCodeNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",
  })
  List<StationDTO> getAllStations(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("nameContains") @jakarta.annotation.Nullable String nameContains, @Param("nameDoesNotContain") @jakarta.annotation.Nullable String nameDoesNotContain, @Param("nameEquals") @jakarta.annotation.Nullable String nameEquals, @Param("nameNotEquals") @jakarta.annotation.Nullable String nameNotEquals, @Param("nameSpecified") @jakarta.annotation.Nullable Boolean nameSpecified, @Param("nameIn") @jakarta.annotation.Nullable List<String> nameIn, @Param("nameNotIn") @jakarta.annotation.Nullable List<String> nameNotIn, @Param("phoneNumberContains") @jakarta.annotation.Nullable String phoneNumberContains, @Param("phoneNumberDoesNotContain") @jakarta.annotation.Nullable String phoneNumberDoesNotContain, @Param("phoneNumberEquals") @jakarta.annotation.Nullable String phoneNumberEquals, @Param("phoneNumberNotEquals") @jakarta.annotation.Nullable String phoneNumberNotEquals, @Param("phoneNumberSpecified") @jakarta.annotation.Nullable Boolean phoneNumberSpecified, @Param("phoneNumberIn") @jakarta.annotation.Nullable List<String> phoneNumberIn, @Param("phoneNumberNotIn") @jakarta.annotation.Nullable List<String> phoneNumberNotIn, @Param("descriptionContains") @jakarta.annotation.Nullable String descriptionContains, @Param("descriptionDoesNotContain") @jakarta.annotation.Nullable String descriptionDoesNotContain, @Param("descriptionEquals") @jakarta.annotation.Nullable String descriptionEquals, @Param("descriptionNotEquals") @jakarta.annotation.Nullable String descriptionNotEquals, @Param("descriptionSpecified") @jakarta.annotation.Nullable Boolean descriptionSpecified, @Param("descriptionIn") @jakarta.annotation.Nullable List<String> descriptionIn, @Param("descriptionNotIn") @jakarta.annotation.Nullable List<String> descriptionNotIn, @Param("activeEquals") @jakarta.annotation.Nullable Boolean activeEquals, @Param("activeNotEquals") @jakarta.annotation.Nullable Boolean activeNotEquals, @Param("activeSpecified") @jakarta.annotation.Nullable Boolean activeSpecified, @Param("activeIn") @jakarta.annotation.Nullable List<Boolean> activeIn, @Param("activeNotIn") @jakarta.annotation.Nullable List<Boolean> activeNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("addressIdGreaterThan") @jakarta.annotation.Nullable Long addressIdGreaterThan, @Param("addressIdLessThan") @jakarta.annotation.Nullable Long addressIdLessThan, @Param("addressIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long addressIdGreaterThanOrEqual, @Param("addressIdLessThanOrEqual") @jakarta.annotation.Nullable Long addressIdLessThanOrEqual, @Param("addressIdEquals") @jakarta.annotation.Nullable Long addressIdEquals, @Param("addressIdNotEquals") @jakarta.annotation.Nullable Long addressIdNotEquals, @Param("addressIdSpecified") @jakarta.annotation.Nullable Boolean addressIdSpecified, @Param("addressIdIn") @jakarta.annotation.Nullable List<Long> addressIdIn, @Param("addressIdNotIn") @jakarta.annotation.Nullable List<Long> addressIdNotIn, @Param("stationImgIdGreaterThan") @jakarta.annotation.Nullable Long stationImgIdGreaterThan, @Param("stationImgIdLessThan") @jakarta.annotation.Nullable Long stationImgIdLessThan, @Param("stationImgIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long stationImgIdGreaterThanOrEqual, @Param("stationImgIdLessThanOrEqual") @jakarta.annotation.Nullable Long stationImgIdLessThanOrEqual, @Param("stationImgIdEquals") @jakarta.annotation.Nullable Long stationImgIdEquals, @Param("stationImgIdNotEquals") @jakarta.annotation.Nullable Long stationImgIdNotEquals, @Param("stationImgIdSpecified") @jakarta.annotation.Nullable Boolean stationImgIdSpecified, @Param("stationImgIdIn") @jakarta.annotation.Nullable List<Long> stationImgIdIn, @Param("stationImgIdNotIn") @jakarta.annotation.Nullable List<Long> stationImgIdNotIn, @Param("provinceCodeContains") @jakarta.annotation.Nullable String provinceCodeContains, @Param("provinceCodeDoesNotContain") @jakarta.annotation.Nullable String provinceCodeDoesNotContain, @Param("provinceCodeEquals") @jakarta.annotation.Nullable String provinceCodeEquals, @Param("provinceCodeNotEquals") @jakarta.annotation.Nullable String provinceCodeNotEquals, @Param("provinceCodeSpecified") @jakarta.annotation.Nullable Boolean provinceCodeSpecified, @Param("provinceCodeIn") @jakarta.annotation.Nullable List<String> provinceCodeIn, @Param("provinceCodeNotIn") @jakarta.annotation.Nullable List<String> provinceCodeNotIn, @Param("districtCodeContains") @jakarta.annotation.Nullable String districtCodeContains, @Param("districtCodeDoesNotContain") @jakarta.annotation.Nullable String districtCodeDoesNotContain, @Param("districtCodeEquals") @jakarta.annotation.Nullable String districtCodeEquals, @Param("districtCodeNotEquals") @jakarta.annotation.Nullable String districtCodeNotEquals, @Param("districtCodeSpecified") @jakarta.annotation.Nullable Boolean districtCodeSpecified, @Param("districtCodeIn") @jakarta.annotation.Nullable List<String> districtCodeIn, @Param("districtCodeNotIn") @jakarta.annotation.Nullable List<String> districtCodeNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct, @Param("page") @jakarta.annotation.Nullable Integer page, @Param("size") @jakarta.annotation.Nullable Integer size, @Param("sort") @jakarta.annotation.Nullable List<String> sort);

  /**
   * 
   * Similar to <code>getAllStations</code> but it also returns the http response headers .
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
   * @param phoneNumberContains  (optional)
   * @param phoneNumberDoesNotContain  (optional)
   * @param phoneNumberEquals  (optional)
   * @param phoneNumberNotEquals  (optional)
   * @param phoneNumberSpecified  (optional)
   * @param phoneNumberIn  (optional)
   * @param phoneNumberNotIn  (optional)
   * @param descriptionContains  (optional)
   * @param descriptionDoesNotContain  (optional)
   * @param descriptionEquals  (optional)
   * @param descriptionNotEquals  (optional)
   * @param descriptionSpecified  (optional)
   * @param descriptionIn  (optional)
   * @param descriptionNotIn  (optional)
   * @param activeEquals  (optional)
   * @param activeNotEquals  (optional)
   * @param activeSpecified  (optional)
   * @param activeIn  (optional)
   * @param activeNotIn  (optional)
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
   * @param addressIdGreaterThan  (optional)
   * @param addressIdLessThan  (optional)
   * @param addressIdGreaterThanOrEqual  (optional)
   * @param addressIdLessThanOrEqual  (optional)
   * @param addressIdEquals  (optional)
   * @param addressIdNotEquals  (optional)
   * @param addressIdSpecified  (optional)
   * @param addressIdIn  (optional)
   * @param addressIdNotIn  (optional)
   * @param stationImgIdGreaterThan  (optional)
   * @param stationImgIdLessThan  (optional)
   * @param stationImgIdGreaterThanOrEqual  (optional)
   * @param stationImgIdLessThanOrEqual  (optional)
   * @param stationImgIdEquals  (optional)
   * @param stationImgIdNotEquals  (optional)
   * @param stationImgIdSpecified  (optional)
   * @param stationImgIdIn  (optional)
   * @param stationImgIdNotIn  (optional)
   * @param provinceCodeContains  (optional)
   * @param provinceCodeDoesNotContain  (optional)
   * @param provinceCodeEquals  (optional)
   * @param provinceCodeNotEquals  (optional)
   * @param provinceCodeSpecified  (optional)
   * @param provinceCodeIn  (optional)
   * @param provinceCodeNotIn  (optional)
   * @param districtCodeContains  (optional)
   * @param districtCodeDoesNotContain  (optional)
   * @param districtCodeEquals  (optional)
   * @param districtCodeNotEquals  (optional)
   * @param districtCodeSpecified  (optional)
   * @param districtCodeIn  (optional)
   * @param districtCodeNotIn  (optional)
   * @param distinct  (optional)
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/stations?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&phoneNumber.contains={phoneNumberContains}&phoneNumber.doesNotContain={phoneNumberDoesNotContain}&phoneNumber.equals={phoneNumberEquals}&phoneNumber.notEquals={phoneNumberNotEquals}&phoneNumber.specified={phoneNumberSpecified}&phoneNumber.in={phoneNumberIn}&phoneNumber.notIn={phoneNumberNotIn}&description.contains={descriptionContains}&description.doesNotContain={descriptionDoesNotContain}&description.equals={descriptionEquals}&description.notEquals={descriptionNotEquals}&description.specified={descriptionSpecified}&description.in={descriptionIn}&description.notIn={descriptionNotIn}&active.equals={activeEquals}&active.notEquals={activeNotEquals}&active.specified={activeSpecified}&active.in={activeIn}&active.notIn={activeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&addressId.greaterThan={addressIdGreaterThan}&addressId.lessThan={addressIdLessThan}&addressId.greaterThanOrEqual={addressIdGreaterThanOrEqual}&addressId.lessThanOrEqual={addressIdLessThanOrEqual}&addressId.equals={addressIdEquals}&addressId.notEquals={addressIdNotEquals}&addressId.specified={addressIdSpecified}&addressId.in={addressIdIn}&addressId.notIn={addressIdNotIn}&stationImgId.greaterThan={stationImgIdGreaterThan}&stationImgId.lessThan={stationImgIdLessThan}&stationImgId.greaterThanOrEqual={stationImgIdGreaterThanOrEqual}&stationImgId.lessThanOrEqual={stationImgIdLessThanOrEqual}&stationImgId.equals={stationImgIdEquals}&stationImgId.notEquals={stationImgIdNotEquals}&stationImgId.specified={stationImgIdSpecified}&stationImgId.in={stationImgIdIn}&stationImgId.notIn={stationImgIdNotIn}&provinceCode.contains={provinceCodeContains}&provinceCode.doesNotContain={provinceCodeDoesNotContain}&provinceCode.equals={provinceCodeEquals}&provinceCode.notEquals={provinceCodeNotEquals}&provinceCode.specified={provinceCodeSpecified}&provinceCode.in={provinceCodeIn}&provinceCode.notIn={provinceCodeNotIn}&districtCode.contains={districtCodeContains}&districtCode.doesNotContain={districtCodeDoesNotContain}&districtCode.equals={districtCodeEquals}&districtCode.notEquals={districtCodeNotEquals}&districtCode.specified={districtCodeSpecified}&districtCode.in={districtCodeIn}&districtCode.notIn={districtCodeNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<StationDTO>> getAllStationsWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("nameContains") @jakarta.annotation.Nullable String nameContains, @Param("nameDoesNotContain") @jakarta.annotation.Nullable String nameDoesNotContain, @Param("nameEquals") @jakarta.annotation.Nullable String nameEquals, @Param("nameNotEquals") @jakarta.annotation.Nullable String nameNotEquals, @Param("nameSpecified") @jakarta.annotation.Nullable Boolean nameSpecified, @Param("nameIn") @jakarta.annotation.Nullable List<String> nameIn, @Param("nameNotIn") @jakarta.annotation.Nullable List<String> nameNotIn, @Param("phoneNumberContains") @jakarta.annotation.Nullable String phoneNumberContains, @Param("phoneNumberDoesNotContain") @jakarta.annotation.Nullable String phoneNumberDoesNotContain, @Param("phoneNumberEquals") @jakarta.annotation.Nullable String phoneNumberEquals, @Param("phoneNumberNotEquals") @jakarta.annotation.Nullable String phoneNumberNotEquals, @Param("phoneNumberSpecified") @jakarta.annotation.Nullable Boolean phoneNumberSpecified, @Param("phoneNumberIn") @jakarta.annotation.Nullable List<String> phoneNumberIn, @Param("phoneNumberNotIn") @jakarta.annotation.Nullable List<String> phoneNumberNotIn, @Param("descriptionContains") @jakarta.annotation.Nullable String descriptionContains, @Param("descriptionDoesNotContain") @jakarta.annotation.Nullable String descriptionDoesNotContain, @Param("descriptionEquals") @jakarta.annotation.Nullable String descriptionEquals, @Param("descriptionNotEquals") @jakarta.annotation.Nullable String descriptionNotEquals, @Param("descriptionSpecified") @jakarta.annotation.Nullable Boolean descriptionSpecified, @Param("descriptionIn") @jakarta.annotation.Nullable List<String> descriptionIn, @Param("descriptionNotIn") @jakarta.annotation.Nullable List<String> descriptionNotIn, @Param("activeEquals") @jakarta.annotation.Nullable Boolean activeEquals, @Param("activeNotEquals") @jakarta.annotation.Nullable Boolean activeNotEquals, @Param("activeSpecified") @jakarta.annotation.Nullable Boolean activeSpecified, @Param("activeIn") @jakarta.annotation.Nullable List<Boolean> activeIn, @Param("activeNotIn") @jakarta.annotation.Nullable List<Boolean> activeNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("addressIdGreaterThan") @jakarta.annotation.Nullable Long addressIdGreaterThan, @Param("addressIdLessThan") @jakarta.annotation.Nullable Long addressIdLessThan, @Param("addressIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long addressIdGreaterThanOrEqual, @Param("addressIdLessThanOrEqual") @jakarta.annotation.Nullable Long addressIdLessThanOrEqual, @Param("addressIdEquals") @jakarta.annotation.Nullable Long addressIdEquals, @Param("addressIdNotEquals") @jakarta.annotation.Nullable Long addressIdNotEquals, @Param("addressIdSpecified") @jakarta.annotation.Nullable Boolean addressIdSpecified, @Param("addressIdIn") @jakarta.annotation.Nullable List<Long> addressIdIn, @Param("addressIdNotIn") @jakarta.annotation.Nullable List<Long> addressIdNotIn, @Param("stationImgIdGreaterThan") @jakarta.annotation.Nullable Long stationImgIdGreaterThan, @Param("stationImgIdLessThan") @jakarta.annotation.Nullable Long stationImgIdLessThan, @Param("stationImgIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long stationImgIdGreaterThanOrEqual, @Param("stationImgIdLessThanOrEqual") @jakarta.annotation.Nullable Long stationImgIdLessThanOrEqual, @Param("stationImgIdEquals") @jakarta.annotation.Nullable Long stationImgIdEquals, @Param("stationImgIdNotEquals") @jakarta.annotation.Nullable Long stationImgIdNotEquals, @Param("stationImgIdSpecified") @jakarta.annotation.Nullable Boolean stationImgIdSpecified, @Param("stationImgIdIn") @jakarta.annotation.Nullable List<Long> stationImgIdIn, @Param("stationImgIdNotIn") @jakarta.annotation.Nullable List<Long> stationImgIdNotIn, @Param("provinceCodeContains") @jakarta.annotation.Nullable String provinceCodeContains, @Param("provinceCodeDoesNotContain") @jakarta.annotation.Nullable String provinceCodeDoesNotContain, @Param("provinceCodeEquals") @jakarta.annotation.Nullable String provinceCodeEquals, @Param("provinceCodeNotEquals") @jakarta.annotation.Nullable String provinceCodeNotEquals, @Param("provinceCodeSpecified") @jakarta.annotation.Nullable Boolean provinceCodeSpecified, @Param("provinceCodeIn") @jakarta.annotation.Nullable List<String> provinceCodeIn, @Param("provinceCodeNotIn") @jakarta.annotation.Nullable List<String> provinceCodeNotIn, @Param("districtCodeContains") @jakarta.annotation.Nullable String districtCodeContains, @Param("districtCodeDoesNotContain") @jakarta.annotation.Nullable String districtCodeDoesNotContain, @Param("districtCodeEquals") @jakarta.annotation.Nullable String districtCodeEquals, @Param("districtCodeNotEquals") @jakarta.annotation.Nullable String districtCodeNotEquals, @Param("districtCodeSpecified") @jakarta.annotation.Nullable Boolean districtCodeSpecified, @Param("districtCodeIn") @jakarta.annotation.Nullable List<String> districtCodeIn, @Param("districtCodeNotIn") @jakarta.annotation.Nullable List<String> districtCodeNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct, @Param("page") @jakarta.annotation.Nullable Integer page, @Param("size") @jakarta.annotation.Nullable Integer size, @Param("sort") @jakarta.annotation.Nullable List<String> sort);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllStations</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllStationsQueryParams} class that allows for
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
   *   <li>phoneNumberContains -  (optional)</li>
   *   <li>phoneNumberDoesNotContain -  (optional)</li>
   *   <li>phoneNumberEquals -  (optional)</li>
   *   <li>phoneNumberNotEquals -  (optional)</li>
   *   <li>phoneNumberSpecified -  (optional)</li>
   *   <li>phoneNumberIn -  (optional)</li>
   *   <li>phoneNumberNotIn -  (optional)</li>
   *   <li>descriptionContains -  (optional)</li>
   *   <li>descriptionDoesNotContain -  (optional)</li>
   *   <li>descriptionEquals -  (optional)</li>
   *   <li>descriptionNotEquals -  (optional)</li>
   *   <li>descriptionSpecified -  (optional)</li>
   *   <li>descriptionIn -  (optional)</li>
   *   <li>descriptionNotIn -  (optional)</li>
   *   <li>activeEquals -  (optional)</li>
   *   <li>activeNotEquals -  (optional)</li>
   *   <li>activeSpecified -  (optional)</li>
   *   <li>activeIn -  (optional)</li>
   *   <li>activeNotIn -  (optional)</li>
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
   *   <li>addressIdGreaterThan -  (optional)</li>
   *   <li>addressIdLessThan -  (optional)</li>
   *   <li>addressIdGreaterThanOrEqual -  (optional)</li>
   *   <li>addressIdLessThanOrEqual -  (optional)</li>
   *   <li>addressIdEquals -  (optional)</li>
   *   <li>addressIdNotEquals -  (optional)</li>
   *   <li>addressIdSpecified -  (optional)</li>
   *   <li>addressIdIn -  (optional)</li>
   *   <li>addressIdNotIn -  (optional)</li>
   *   <li>stationImgIdGreaterThan -  (optional)</li>
   *   <li>stationImgIdLessThan -  (optional)</li>
   *   <li>stationImgIdGreaterThanOrEqual -  (optional)</li>
   *   <li>stationImgIdLessThanOrEqual -  (optional)</li>
   *   <li>stationImgIdEquals -  (optional)</li>
   *   <li>stationImgIdNotEquals -  (optional)</li>
   *   <li>stationImgIdSpecified -  (optional)</li>
   *   <li>stationImgIdIn -  (optional)</li>
   *   <li>stationImgIdNotIn -  (optional)</li>
   *   <li>provinceCodeContains -  (optional)</li>
   *   <li>provinceCodeDoesNotContain -  (optional)</li>
   *   <li>provinceCodeEquals -  (optional)</li>
   *   <li>provinceCodeNotEquals -  (optional)</li>
   *   <li>provinceCodeSpecified -  (optional)</li>
   *   <li>provinceCodeIn -  (optional)</li>
   *   <li>provinceCodeNotIn -  (optional)</li>
   *   <li>districtCodeContains -  (optional)</li>
   *   <li>districtCodeDoesNotContain -  (optional)</li>
   *   <li>districtCodeEquals -  (optional)</li>
   *   <li>districtCodeNotEquals -  (optional)</li>
   *   <li>districtCodeSpecified -  (optional)</li>
   *   <li>districtCodeIn -  (optional)</li>
   *   <li>districtCodeNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   <li>page - Zero-based page index (0..N) (optional, default to 0)</li>
   *   <li>size - The size of the page to be returned (optional, default to 20)</li>
   *   <li>sort - Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)</li>
   *   </ul>
   * @return List&lt;StationDTO&gt;
   */
  @RequestLine("GET /api/stations?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&phoneNumber.contains={phoneNumberContains}&phoneNumber.doesNotContain={phoneNumberDoesNotContain}&phoneNumber.equals={phoneNumberEquals}&phoneNumber.notEquals={phoneNumberNotEquals}&phoneNumber.specified={phoneNumberSpecified}&phoneNumber.in={phoneNumberIn}&phoneNumber.notIn={phoneNumberNotIn}&description.contains={descriptionContains}&description.doesNotContain={descriptionDoesNotContain}&description.equals={descriptionEquals}&description.notEquals={descriptionNotEquals}&description.specified={descriptionSpecified}&description.in={descriptionIn}&description.notIn={descriptionNotIn}&active.equals={activeEquals}&active.notEquals={activeNotEquals}&active.specified={activeSpecified}&active.in={activeIn}&active.notIn={activeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&addressId.greaterThan={addressIdGreaterThan}&addressId.lessThan={addressIdLessThan}&addressId.greaterThanOrEqual={addressIdGreaterThanOrEqual}&addressId.lessThanOrEqual={addressIdLessThanOrEqual}&addressId.equals={addressIdEquals}&addressId.notEquals={addressIdNotEquals}&addressId.specified={addressIdSpecified}&addressId.in={addressIdIn}&addressId.notIn={addressIdNotIn}&stationImgId.greaterThan={stationImgIdGreaterThan}&stationImgId.lessThan={stationImgIdLessThan}&stationImgId.greaterThanOrEqual={stationImgIdGreaterThanOrEqual}&stationImgId.lessThanOrEqual={stationImgIdLessThanOrEqual}&stationImgId.equals={stationImgIdEquals}&stationImgId.notEquals={stationImgIdNotEquals}&stationImgId.specified={stationImgIdSpecified}&stationImgId.in={stationImgIdIn}&stationImgId.notIn={stationImgIdNotIn}&provinceCode.contains={provinceCodeContains}&provinceCode.doesNotContain={provinceCodeDoesNotContain}&provinceCode.equals={provinceCodeEquals}&provinceCode.notEquals={provinceCodeNotEquals}&provinceCode.specified={provinceCodeSpecified}&provinceCode.in={provinceCodeIn}&provinceCode.notIn={provinceCodeNotIn}&districtCode.contains={districtCodeContains}&districtCode.doesNotContain={districtCodeDoesNotContain}&districtCode.equals={districtCodeEquals}&districtCode.notEquals={districtCodeNotEquals}&districtCode.specified={districtCodeSpecified}&districtCode.in={districtCodeIn}&districtCode.notIn={districtCodeNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
  @Headers({
  "Accept: */*",
  })
  List<StationDTO> getAllStations(@QueryMap(encoded=true) GetAllStationsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllStations</code> that receives the query parameters as a map,
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
          *   <li>phoneNumberContains -  (optional)</li>
          *   <li>phoneNumberDoesNotContain -  (optional)</li>
          *   <li>phoneNumberEquals -  (optional)</li>
          *   <li>phoneNumberNotEquals -  (optional)</li>
          *   <li>phoneNumberSpecified -  (optional)</li>
          *   <li>phoneNumberIn -  (optional)</li>
          *   <li>phoneNumberNotIn -  (optional)</li>
          *   <li>descriptionContains -  (optional)</li>
          *   <li>descriptionDoesNotContain -  (optional)</li>
          *   <li>descriptionEquals -  (optional)</li>
          *   <li>descriptionNotEquals -  (optional)</li>
          *   <li>descriptionSpecified -  (optional)</li>
          *   <li>descriptionIn -  (optional)</li>
          *   <li>descriptionNotIn -  (optional)</li>
          *   <li>activeEquals -  (optional)</li>
          *   <li>activeNotEquals -  (optional)</li>
          *   <li>activeSpecified -  (optional)</li>
          *   <li>activeIn -  (optional)</li>
          *   <li>activeNotIn -  (optional)</li>
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
          *   <li>addressIdGreaterThan -  (optional)</li>
          *   <li>addressIdLessThan -  (optional)</li>
          *   <li>addressIdGreaterThanOrEqual -  (optional)</li>
          *   <li>addressIdLessThanOrEqual -  (optional)</li>
          *   <li>addressIdEquals -  (optional)</li>
          *   <li>addressIdNotEquals -  (optional)</li>
          *   <li>addressIdSpecified -  (optional)</li>
          *   <li>addressIdIn -  (optional)</li>
          *   <li>addressIdNotIn -  (optional)</li>
          *   <li>stationImgIdGreaterThan -  (optional)</li>
          *   <li>stationImgIdLessThan -  (optional)</li>
          *   <li>stationImgIdGreaterThanOrEqual -  (optional)</li>
          *   <li>stationImgIdLessThanOrEqual -  (optional)</li>
          *   <li>stationImgIdEquals -  (optional)</li>
          *   <li>stationImgIdNotEquals -  (optional)</li>
          *   <li>stationImgIdSpecified -  (optional)</li>
          *   <li>stationImgIdIn -  (optional)</li>
          *   <li>stationImgIdNotIn -  (optional)</li>
          *   <li>provinceCodeContains -  (optional)</li>
          *   <li>provinceCodeDoesNotContain -  (optional)</li>
          *   <li>provinceCodeEquals -  (optional)</li>
          *   <li>provinceCodeNotEquals -  (optional)</li>
          *   <li>provinceCodeSpecified -  (optional)</li>
          *   <li>provinceCodeIn -  (optional)</li>
          *   <li>provinceCodeNotIn -  (optional)</li>
          *   <li>districtCodeContains -  (optional)</li>
          *   <li>districtCodeDoesNotContain -  (optional)</li>
          *   <li>districtCodeEquals -  (optional)</li>
          *   <li>districtCodeNotEquals -  (optional)</li>
          *   <li>districtCodeSpecified -  (optional)</li>
          *   <li>districtCodeIn -  (optional)</li>
          *   <li>districtCodeNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
          *   <li>page - Zero-based page index (0..N) (optional, default to 0)</li>
          *   <li>size - The size of the page to be returned (optional, default to 20)</li>
          *   <li>sort - Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)</li>
      *   </ul>
          * @return List&lt;StationDTO&gt;
      */
      @RequestLine("GET /api/stations?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&phoneNumber.contains={phoneNumberContains}&phoneNumber.doesNotContain={phoneNumberDoesNotContain}&phoneNumber.equals={phoneNumberEquals}&phoneNumber.notEquals={phoneNumberNotEquals}&phoneNumber.specified={phoneNumberSpecified}&phoneNumber.in={phoneNumberIn}&phoneNumber.notIn={phoneNumberNotIn}&description.contains={descriptionContains}&description.doesNotContain={descriptionDoesNotContain}&description.equals={descriptionEquals}&description.notEquals={descriptionNotEquals}&description.specified={descriptionSpecified}&description.in={descriptionIn}&description.notIn={descriptionNotIn}&active.equals={activeEquals}&active.notEquals={activeNotEquals}&active.specified={activeSpecified}&active.in={activeIn}&active.notIn={activeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&addressId.greaterThan={addressIdGreaterThan}&addressId.lessThan={addressIdLessThan}&addressId.greaterThanOrEqual={addressIdGreaterThanOrEqual}&addressId.lessThanOrEqual={addressIdLessThanOrEqual}&addressId.equals={addressIdEquals}&addressId.notEquals={addressIdNotEquals}&addressId.specified={addressIdSpecified}&addressId.in={addressIdIn}&addressId.notIn={addressIdNotIn}&stationImgId.greaterThan={stationImgIdGreaterThan}&stationImgId.lessThan={stationImgIdLessThan}&stationImgId.greaterThanOrEqual={stationImgIdGreaterThanOrEqual}&stationImgId.lessThanOrEqual={stationImgIdLessThanOrEqual}&stationImgId.equals={stationImgIdEquals}&stationImgId.notEquals={stationImgIdNotEquals}&stationImgId.specified={stationImgIdSpecified}&stationImgId.in={stationImgIdIn}&stationImgId.notIn={stationImgIdNotIn}&provinceCode.contains={provinceCodeContains}&provinceCode.doesNotContain={provinceCodeDoesNotContain}&provinceCode.equals={provinceCodeEquals}&provinceCode.notEquals={provinceCodeNotEquals}&provinceCode.specified={provinceCodeSpecified}&provinceCode.in={provinceCodeIn}&provinceCode.notIn={provinceCodeNotIn}&districtCode.contains={districtCodeContains}&districtCode.doesNotContain={districtCodeDoesNotContain}&districtCode.equals={districtCodeEquals}&districtCode.notEquals={districtCodeNotEquals}&districtCode.specified={districtCodeSpecified}&districtCode.in={districtCodeIn}&districtCode.notIn={districtCodeNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<StationDTO>> getAllStationsWithHttpInfo(@QueryMap(encoded=true) GetAllStationsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllStations</code> method in a fluent style.
   */
  public static class GetAllStationsQueryParams extends HashMap<String, Object> {
    public GetAllStationsQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStationsQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStationsQueryParams nameContains(@jakarta.annotation.Nullable final String value) {
      put("name.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams nameDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("name.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams nameEquals(@jakarta.annotation.Nullable final String value) {
      put("name.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams nameNotEquals(@jakarta.annotation.Nullable final String value) {
      put("name.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams nameSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("name.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams nameIn(@jakarta.annotation.Nullable final List<String> value) {
      put("name.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStationsQueryParams nameNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("name.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStationsQueryParams phoneNumberContains(@jakarta.annotation.Nullable final String value) {
      put("phoneNumber.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams phoneNumberDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("phoneNumber.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams phoneNumberEquals(@jakarta.annotation.Nullable final String value) {
      put("phoneNumber.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams phoneNumberNotEquals(@jakarta.annotation.Nullable final String value) {
      put("phoneNumber.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams phoneNumberSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("phoneNumber.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams phoneNumberIn(@jakarta.annotation.Nullable final List<String> value) {
      put("phoneNumber.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStationsQueryParams phoneNumberNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("phoneNumber.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStationsQueryParams descriptionContains(@jakarta.annotation.Nullable final String value) {
      put("description.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams descriptionDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("description.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams descriptionEquals(@jakarta.annotation.Nullable final String value) {
      put("description.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams descriptionNotEquals(@jakarta.annotation.Nullable final String value) {
      put("description.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams descriptionSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("description.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams descriptionIn(@jakarta.annotation.Nullable final List<String> value) {
      put("description.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStationsQueryParams descriptionNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("description.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStationsQueryParams activeEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("active.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams activeNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("active.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams activeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("active.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams activeIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("active.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStationsQueryParams activeNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("active.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStationsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStationsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStationsQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStationsQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStationsQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStationsQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStationsQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStationsQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStationsQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStationsQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStationsQueryParams addressIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("addressId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams addressIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("addressId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams addressIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("addressId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams addressIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("addressId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams addressIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("addressId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams addressIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("addressId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams addressIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("addressId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams addressIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("addressId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStationsQueryParams addressIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("addressId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStationsQueryParams stationImgIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("stationImgId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams stationImgIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("stationImgId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams stationImgIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("stationImgId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams stationImgIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("stationImgId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams stationImgIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("stationImgId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams stationImgIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("stationImgId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams stationImgIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("stationImgId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams stationImgIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("stationImgId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStationsQueryParams stationImgIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("stationImgId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStationsQueryParams provinceCodeContains(@jakarta.annotation.Nullable final String value) {
      put("provinceCode.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams provinceCodeDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("provinceCode.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams provinceCodeEquals(@jakarta.annotation.Nullable final String value) {
      put("provinceCode.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams provinceCodeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("provinceCode.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams provinceCodeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("provinceCode.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams provinceCodeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("provinceCode.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStationsQueryParams provinceCodeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("provinceCode.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStationsQueryParams districtCodeContains(@jakarta.annotation.Nullable final String value) {
      put("districtCode.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams districtCodeDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("districtCode.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams districtCodeEquals(@jakarta.annotation.Nullable final String value) {
      put("districtCode.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams districtCodeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("districtCode.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams districtCodeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("districtCode.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams districtCodeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("districtCode.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStationsQueryParams districtCodeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("districtCode.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllStationsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams page(@jakarta.annotation.Nullable final Integer value) {
      put("page", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams size(@jakarta.annotation.Nullable final Integer value) {
      put("size", EncodingUtils.encode(value));
      return this;
    }
    public GetAllStationsQueryParams sort(@jakarta.annotation.Nullable final List<String> value) {
      put("sort", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @return StationDTO
   */
  @RequestLine("GET /api/stations/{id}")
  @Headers({
    "Accept: */*",
  })
  StationDTO getStation(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>getStation</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/stations/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<StationDTO> getStationWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return List&lt;StationWithRoutesVM&gt;
   */
  @RequestLine("GET /api/stations/with-routes?page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",
  })
  List<StationWithRoutesVM> getStationsWithRoutes(@Param("page") @jakarta.annotation.Nullable Integer page, @Param("size") @jakarta.annotation.Nullable Integer size, @Param("sort") @jakarta.annotation.Nullable List<String> sort);

  /**
   * 
   * Similar to <code>getStationsWithRoutes</code> but it also returns the http response headers .
   * 
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/stations/with-routes?page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<StationWithRoutesVM>> getStationsWithRoutesWithHttpInfo(@Param("page") @jakarta.annotation.Nullable Integer page, @Param("size") @jakarta.annotation.Nullable Integer size, @Param("sort") @jakarta.annotation.Nullable List<String> sort);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getStationsWithRoutes</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetStationsWithRoutesQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>page - Zero-based page index (0..N) (optional, default to 0)</li>
   *   <li>size - The size of the page to be returned (optional, default to 20)</li>
   *   <li>sort - Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)</li>
   *   </ul>
   * @return List&lt;StationWithRoutesVM&gt;
   */
  @RequestLine("GET /api/stations/with-routes?page={page}&size={size}&sort={sort}")
  @Headers({
  "Accept: */*",
  })
  List<StationWithRoutesVM> getStationsWithRoutes(@QueryMap(encoded=true) GetStationsWithRoutesQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getStationsWithRoutes</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>page - Zero-based page index (0..N) (optional, default to 0)</li>
          *   <li>size - The size of the page to be returned (optional, default to 20)</li>
          *   <li>sort - Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)</li>
      *   </ul>
          * @return List&lt;StationWithRoutesVM&gt;
      */
      @RequestLine("GET /api/stations/with-routes?page={page}&size={size}&sort={sort}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<StationWithRoutesVM>> getStationsWithRoutesWithHttpInfo(@QueryMap(encoded=true) GetStationsWithRoutesQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getStationsWithRoutes</code> method in a fluent style.
   */
  public static class GetStationsWithRoutesQueryParams extends HashMap<String, Object> {
    public GetStationsWithRoutesQueryParams page(@jakarta.annotation.Nullable final Integer value) {
      put("page", EncodingUtils.encode(value));
      return this;
    }
    public GetStationsWithRoutesQueryParams size(@jakarta.annotation.Nullable final Integer value) {
      put("size", EncodingUtils.encode(value));
      return this;
    }
    public GetStationsWithRoutesQueryParams sort(@jakarta.annotation.Nullable final List<String> value) {
      put("sort", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return StationWithRoutesVM
   */
  @RequestLine("GET /api/stations/{id}/with-routes?page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",
  })
  StationWithRoutesVM getStationsWithRoutesAndId(@Param("id") @jakarta.annotation.Nonnull Long id, @Param("page") @jakarta.annotation.Nullable Integer page, @Param("size") @jakarta.annotation.Nullable Integer size, @Param("sort") @jakarta.annotation.Nullable List<String> sort);

  /**
   * 
   * Similar to <code>getStationsWithRoutesAndId</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/stations/{id}/with-routes?page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<StationWithRoutesVM> getStationsWithRoutesAndIdWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @Param("page") @jakarta.annotation.Nullable Integer page, @Param("size") @jakarta.annotation.Nullable Integer size, @Param("sort") @jakarta.annotation.Nullable List<String> sort);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getStationsWithRoutesAndId</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetStationsWithRoutesAndIdQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param id  (required)
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>page - Zero-based page index (0..N) (optional, default to 0)</li>
   *   <li>size - The size of the page to be returned (optional, default to 20)</li>
   *   <li>sort - Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)</li>
   *   </ul>
   * @return StationWithRoutesVM
   */
  @RequestLine("GET /api/stations/{id}/with-routes?page={page}&size={size}&sort={sort}")
  @Headers({
  "Accept: */*",
  })
  StationWithRoutesVM getStationsWithRoutesAndId(@Param("id") @jakarta.annotation.Nonnull Long id, @QueryMap(encoded=true) GetStationsWithRoutesAndIdQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getStationsWithRoutesAndId</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
              * @param id  (required)
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>page - Zero-based page index (0..N) (optional, default to 0)</li>
          *   <li>size - The size of the page to be returned (optional, default to 20)</li>
          *   <li>sort - Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)</li>
      *   </ul>
          * @return StationWithRoutesVM
      */
      @RequestLine("GET /api/stations/{id}/with-routes?page={page}&size={size}&sort={sort}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<StationWithRoutesVM> getStationsWithRoutesAndIdWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @QueryMap(encoded=true) GetStationsWithRoutesAndIdQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getStationsWithRoutesAndId</code> method in a fluent style.
   */
  public static class GetStationsWithRoutesAndIdQueryParams extends HashMap<String, Object> {
    public GetStationsWithRoutesAndIdQueryParams page(@jakarta.annotation.Nullable final Integer value) {
      put("page", EncodingUtils.encode(value));
      return this;
    }
    public GetStationsWithRoutesAndIdQueryParams size(@jakarta.annotation.Nullable final Integer value) {
      put("size", EncodingUtils.encode(value));
      return this;
    }
    public GetStationsWithRoutesAndIdQueryParams sort(@jakarta.annotation.Nullable final List<String> value) {
      put("sort", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @param stationDTO  (required)
   * @return StationDTO
   */
  @RequestLine("PATCH /api/stations/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  StationDTO partialUpdateStation(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull StationDTO stationDTO);

  /**
   * 
   * Similar to <code>partialUpdateStation</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param stationDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /api/stations/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<StationDTO> partialUpdateStationWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull StationDTO stationDTO);



  /**
   * 
   * 
   * @param query  (required)
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return List&lt;StationDTO&gt;
   */
  @RequestLine("GET /api/stations/_search?query={query}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",
  })
  List<StationDTO> searchStations(@Param("query") @jakarta.annotation.Nonnull String query, @Param("page") @jakarta.annotation.Nullable Integer page, @Param("size") @jakarta.annotation.Nullable Integer size, @Param("sort") @jakarta.annotation.Nullable List<String> sort);

  /**
   * 
   * Similar to <code>searchStations</code> but it also returns the http response headers .
   * 
   * @param query  (required)
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/stations/_search?query={query}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<StationDTO>> searchStationsWithHttpInfo(@Param("query") @jakarta.annotation.Nonnull String query, @Param("page") @jakarta.annotation.Nullable Integer page, @Param("size") @jakarta.annotation.Nullable Integer size, @Param("sort") @jakarta.annotation.Nullable List<String> sort);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>searchStations</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link SearchStationsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>query -  (required)</li>
   *   <li>page - Zero-based page index (0..N) (optional, default to 0)</li>
   *   <li>size - The size of the page to be returned (optional, default to 20)</li>
   *   <li>sort - Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)</li>
   *   </ul>
   * @return List&lt;StationDTO&gt;
   */
  @RequestLine("GET /api/stations/_search?query={query}&page={page}&size={size}&sort={sort}")
  @Headers({
  "Accept: */*",
  })
  List<StationDTO> searchStations(@QueryMap(encoded=true) SearchStationsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>searchStations</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>query -  (required)</li>
          *   <li>page - Zero-based page index (0..N) (optional, default to 0)</li>
          *   <li>size - The size of the page to be returned (optional, default to 20)</li>
          *   <li>sort - Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)</li>
      *   </ul>
          * @return List&lt;StationDTO&gt;
      */
      @RequestLine("GET /api/stations/_search?query={query}&page={page}&size={size}&sort={sort}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<StationDTO>> searchStationsWithHttpInfo(@QueryMap(encoded=true) SearchStationsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>searchStations</code> method in a fluent style.
   */
  public static class SearchStationsQueryParams extends HashMap<String, Object> {
    public SearchStationsQueryParams query(@jakarta.annotation.Nonnull final String value) {
      put("query", EncodingUtils.encode(value));
      return this;
    }
    public SearchStationsQueryParams page(@jakarta.annotation.Nullable final Integer value) {
      put("page", EncodingUtils.encode(value));
      return this;
    }
    public SearchStationsQueryParams size(@jakarta.annotation.Nullable final Integer value) {
      put("size", EncodingUtils.encode(value));
      return this;
    }
    public SearchStationsQueryParams sort(@jakarta.annotation.Nullable final List<String> value) {
      put("sort", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @param stationDTO  (required)
   * @return StationDTO
   */
  @RequestLine("PUT /api/stations/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  StationDTO updateStation(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull StationDTO stationDTO);

  /**
   * 
   * Similar to <code>updateStation</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param stationDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/stations/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<StationDTO> updateStationWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull StationDTO stationDTO);


}
