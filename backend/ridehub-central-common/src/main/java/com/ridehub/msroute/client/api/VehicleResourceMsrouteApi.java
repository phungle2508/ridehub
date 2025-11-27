package com.ridehub.msroute.client.api;

import com.ridehub.msroute.client.invoker.ApiClient;
import com.ridehub.msroute.client.invoker.EncodingUtils;
import com.ridehub.msroute.client.model.ApiResponse;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;
import com.ridehub.msroute.client.model.VehicleDTO;
import com.ridehub.msroute.client.model.VehicleDetailVM;
import com.ridehub.msroute.client.model.VehicleWithSeatCountVM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface VehicleResourceMsrouteApi extends ApiClient.Api {


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
   * @param typeEquals  (optional)
   * @param typeNotEquals  (optional)
   * @param typeSpecified  (optional)
   * @param typeIn  (optional)
   * @param typeNotIn  (optional)
   * @param typeFactorGreaterThan  (optional)
   * @param typeFactorLessThan  (optional)
   * @param typeFactorGreaterThanOrEqual  (optional)
   * @param typeFactorLessThanOrEqual  (optional)
   * @param typeFactorEquals  (optional)
   * @param typeFactorNotEquals  (optional)
   * @param typeFactorSpecified  (optional)
   * @param typeFactorIn  (optional)
   * @param typeFactorNotIn  (optional)
   * @param plateNumberContains  (optional)
   * @param plateNumberDoesNotContain  (optional)
   * @param plateNumberEquals  (optional)
   * @param plateNumberNotEquals  (optional)
   * @param plateNumberSpecified  (optional)
   * @param plateNumberIn  (optional)
   * @param plateNumberNotIn  (optional)
   * @param brandContains  (optional)
   * @param brandDoesNotContain  (optional)
   * @param brandEquals  (optional)
   * @param brandNotEquals  (optional)
   * @param brandSpecified  (optional)
   * @param brandIn  (optional)
   * @param brandNotIn  (optional)
   * @param descriptionContains  (optional)
   * @param descriptionDoesNotContain  (optional)
   * @param descriptionEquals  (optional)
   * @param descriptionNotEquals  (optional)
   * @param descriptionSpecified  (optional)
   * @param descriptionIn  (optional)
   * @param descriptionNotIn  (optional)
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
   * @param seatMapIdGreaterThan  (optional)
   * @param seatMapIdLessThan  (optional)
   * @param seatMapIdGreaterThanOrEqual  (optional)
   * @param seatMapIdLessThanOrEqual  (optional)
   * @param seatMapIdEquals  (optional)
   * @param seatMapIdNotEquals  (optional)
   * @param seatMapIdSpecified  (optional)
   * @param seatMapIdIn  (optional)
   * @param seatMapIdNotIn  (optional)
   * @param vehicleImgIdGreaterThan  (optional)
   * @param vehicleImgIdLessThan  (optional)
   * @param vehicleImgIdGreaterThanOrEqual  (optional)
   * @param vehicleImgIdLessThanOrEqual  (optional)
   * @param vehicleImgIdEquals  (optional)
   * @param vehicleImgIdNotEquals  (optional)
   * @param vehicleImgIdSpecified  (optional)
   * @param vehicleImgIdIn  (optional)
   * @param vehicleImgIdNotIn  (optional)
   * @param distinct  (optional)
   * @return Long
   */
  @RequestLine("GET /api/vehicles/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&type.equals={typeEquals}&type.notEquals={typeNotEquals}&type.specified={typeSpecified}&type.in={typeIn}&type.notIn={typeNotIn}&typeFactor.greaterThan={typeFactorGreaterThan}&typeFactor.lessThan={typeFactorLessThan}&typeFactor.greaterThanOrEqual={typeFactorGreaterThanOrEqual}&typeFactor.lessThanOrEqual={typeFactorLessThanOrEqual}&typeFactor.equals={typeFactorEquals}&typeFactor.notEquals={typeFactorNotEquals}&typeFactor.specified={typeFactorSpecified}&typeFactor.in={typeFactorIn}&typeFactor.notIn={typeFactorNotIn}&plateNumber.contains={plateNumberContains}&plateNumber.doesNotContain={plateNumberDoesNotContain}&plateNumber.equals={plateNumberEquals}&plateNumber.notEquals={plateNumberNotEquals}&plateNumber.specified={plateNumberSpecified}&plateNumber.in={plateNumberIn}&plateNumber.notIn={plateNumberNotIn}&brand.contains={brandContains}&brand.doesNotContain={brandDoesNotContain}&brand.equals={brandEquals}&brand.notEquals={brandNotEquals}&brand.specified={brandSpecified}&brand.in={brandIn}&brand.notIn={brandNotIn}&description.contains={descriptionContains}&description.doesNotContain={descriptionDoesNotContain}&description.equals={descriptionEquals}&description.notEquals={descriptionNotEquals}&description.specified={descriptionSpecified}&description.in={descriptionIn}&description.notIn={descriptionNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&seatMapId.greaterThan={seatMapIdGreaterThan}&seatMapId.lessThan={seatMapIdLessThan}&seatMapId.greaterThanOrEqual={seatMapIdGreaterThanOrEqual}&seatMapId.lessThanOrEqual={seatMapIdLessThanOrEqual}&seatMapId.equals={seatMapIdEquals}&seatMapId.notEquals={seatMapIdNotEquals}&seatMapId.specified={seatMapIdSpecified}&seatMapId.in={seatMapIdIn}&seatMapId.notIn={seatMapIdNotIn}&vehicleImgId.greaterThan={vehicleImgIdGreaterThan}&vehicleImgId.lessThan={vehicleImgIdLessThan}&vehicleImgId.greaterThanOrEqual={vehicleImgIdGreaterThanOrEqual}&vehicleImgId.lessThanOrEqual={vehicleImgIdLessThanOrEqual}&vehicleImgId.equals={vehicleImgIdEquals}&vehicleImgId.notEquals={vehicleImgIdNotEquals}&vehicleImgId.specified={vehicleImgIdSpecified}&vehicleImgId.in={vehicleImgIdIn}&vehicleImgId.notIn={vehicleImgIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  Long countVehicles(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("typeEquals") @jakarta.annotation.Nullable String typeEquals, @Param("typeNotEquals") @jakarta.annotation.Nullable String typeNotEquals, @Param("typeSpecified") @jakarta.annotation.Nullable Boolean typeSpecified, @Param("typeIn") @jakarta.annotation.Nullable List<String> typeIn, @Param("typeNotIn") @jakarta.annotation.Nullable List<String> typeNotIn, @Param("typeFactorGreaterThan") @jakarta.annotation.Nullable BigDecimal typeFactorGreaterThan, @Param("typeFactorLessThan") @jakarta.annotation.Nullable BigDecimal typeFactorLessThan, @Param("typeFactorGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal typeFactorGreaterThanOrEqual, @Param("typeFactorLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal typeFactorLessThanOrEqual, @Param("typeFactorEquals") @jakarta.annotation.Nullable BigDecimal typeFactorEquals, @Param("typeFactorNotEquals") @jakarta.annotation.Nullable BigDecimal typeFactorNotEquals, @Param("typeFactorSpecified") @jakarta.annotation.Nullable Boolean typeFactorSpecified, @Param("typeFactorIn") @jakarta.annotation.Nullable List<BigDecimal> typeFactorIn, @Param("typeFactorNotIn") @jakarta.annotation.Nullable List<BigDecimal> typeFactorNotIn, @Param("plateNumberContains") @jakarta.annotation.Nullable String plateNumberContains, @Param("plateNumberDoesNotContain") @jakarta.annotation.Nullable String plateNumberDoesNotContain, @Param("plateNumberEquals") @jakarta.annotation.Nullable String plateNumberEquals, @Param("plateNumberNotEquals") @jakarta.annotation.Nullable String plateNumberNotEquals, @Param("plateNumberSpecified") @jakarta.annotation.Nullable Boolean plateNumberSpecified, @Param("plateNumberIn") @jakarta.annotation.Nullable List<String> plateNumberIn, @Param("plateNumberNotIn") @jakarta.annotation.Nullable List<String> plateNumberNotIn, @Param("brandContains") @jakarta.annotation.Nullable String brandContains, @Param("brandDoesNotContain") @jakarta.annotation.Nullable String brandDoesNotContain, @Param("brandEquals") @jakarta.annotation.Nullable String brandEquals, @Param("brandNotEquals") @jakarta.annotation.Nullable String brandNotEquals, @Param("brandSpecified") @jakarta.annotation.Nullable Boolean brandSpecified, @Param("brandIn") @jakarta.annotation.Nullable List<String> brandIn, @Param("brandNotIn") @jakarta.annotation.Nullable List<String> brandNotIn, @Param("descriptionContains") @jakarta.annotation.Nullable String descriptionContains, @Param("descriptionDoesNotContain") @jakarta.annotation.Nullable String descriptionDoesNotContain, @Param("descriptionEquals") @jakarta.annotation.Nullable String descriptionEquals, @Param("descriptionNotEquals") @jakarta.annotation.Nullable String descriptionNotEquals, @Param("descriptionSpecified") @jakarta.annotation.Nullable Boolean descriptionSpecified, @Param("descriptionIn") @jakarta.annotation.Nullable List<String> descriptionIn, @Param("descriptionNotIn") @jakarta.annotation.Nullable List<String> descriptionNotIn, @Param("statusEquals") @jakarta.annotation.Nullable String statusEquals, @Param("statusNotEquals") @jakarta.annotation.Nullable String statusNotEquals, @Param("statusSpecified") @jakarta.annotation.Nullable Boolean statusSpecified, @Param("statusIn") @jakarta.annotation.Nullable List<String> statusIn, @Param("statusNotIn") @jakarta.annotation.Nullable List<String> statusNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("seatMapIdGreaterThan") @jakarta.annotation.Nullable Long seatMapIdGreaterThan, @Param("seatMapIdLessThan") @jakarta.annotation.Nullable Long seatMapIdLessThan, @Param("seatMapIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long seatMapIdGreaterThanOrEqual, @Param("seatMapIdLessThanOrEqual") @jakarta.annotation.Nullable Long seatMapIdLessThanOrEqual, @Param("seatMapIdEquals") @jakarta.annotation.Nullable Long seatMapIdEquals, @Param("seatMapIdNotEquals") @jakarta.annotation.Nullable Long seatMapIdNotEquals, @Param("seatMapIdSpecified") @jakarta.annotation.Nullable Boolean seatMapIdSpecified, @Param("seatMapIdIn") @jakarta.annotation.Nullable List<Long> seatMapIdIn, @Param("seatMapIdNotIn") @jakarta.annotation.Nullable List<Long> seatMapIdNotIn, @Param("vehicleImgIdGreaterThan") @jakarta.annotation.Nullable Long vehicleImgIdGreaterThan, @Param("vehicleImgIdLessThan") @jakarta.annotation.Nullable Long vehicleImgIdLessThan, @Param("vehicleImgIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long vehicleImgIdGreaterThanOrEqual, @Param("vehicleImgIdLessThanOrEqual") @jakarta.annotation.Nullable Long vehicleImgIdLessThanOrEqual, @Param("vehicleImgIdEquals") @jakarta.annotation.Nullable Long vehicleImgIdEquals, @Param("vehicleImgIdNotEquals") @jakarta.annotation.Nullable Long vehicleImgIdNotEquals, @Param("vehicleImgIdSpecified") @jakarta.annotation.Nullable Boolean vehicleImgIdSpecified, @Param("vehicleImgIdIn") @jakarta.annotation.Nullable List<Long> vehicleImgIdIn, @Param("vehicleImgIdNotIn") @jakarta.annotation.Nullable List<Long> vehicleImgIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>countVehicles</code> but it also returns the http response headers .
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
   * @param typeEquals  (optional)
   * @param typeNotEquals  (optional)
   * @param typeSpecified  (optional)
   * @param typeIn  (optional)
   * @param typeNotIn  (optional)
   * @param typeFactorGreaterThan  (optional)
   * @param typeFactorLessThan  (optional)
   * @param typeFactorGreaterThanOrEqual  (optional)
   * @param typeFactorLessThanOrEqual  (optional)
   * @param typeFactorEquals  (optional)
   * @param typeFactorNotEquals  (optional)
   * @param typeFactorSpecified  (optional)
   * @param typeFactorIn  (optional)
   * @param typeFactorNotIn  (optional)
   * @param plateNumberContains  (optional)
   * @param plateNumberDoesNotContain  (optional)
   * @param plateNumberEquals  (optional)
   * @param plateNumberNotEquals  (optional)
   * @param plateNumberSpecified  (optional)
   * @param plateNumberIn  (optional)
   * @param plateNumberNotIn  (optional)
   * @param brandContains  (optional)
   * @param brandDoesNotContain  (optional)
   * @param brandEquals  (optional)
   * @param brandNotEquals  (optional)
   * @param brandSpecified  (optional)
   * @param brandIn  (optional)
   * @param brandNotIn  (optional)
   * @param descriptionContains  (optional)
   * @param descriptionDoesNotContain  (optional)
   * @param descriptionEquals  (optional)
   * @param descriptionNotEquals  (optional)
   * @param descriptionSpecified  (optional)
   * @param descriptionIn  (optional)
   * @param descriptionNotIn  (optional)
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
   * @param seatMapIdGreaterThan  (optional)
   * @param seatMapIdLessThan  (optional)
   * @param seatMapIdGreaterThanOrEqual  (optional)
   * @param seatMapIdLessThanOrEqual  (optional)
   * @param seatMapIdEquals  (optional)
   * @param seatMapIdNotEquals  (optional)
   * @param seatMapIdSpecified  (optional)
   * @param seatMapIdIn  (optional)
   * @param seatMapIdNotIn  (optional)
   * @param vehicleImgIdGreaterThan  (optional)
   * @param vehicleImgIdLessThan  (optional)
   * @param vehicleImgIdGreaterThanOrEqual  (optional)
   * @param vehicleImgIdLessThanOrEqual  (optional)
   * @param vehicleImgIdEquals  (optional)
   * @param vehicleImgIdNotEquals  (optional)
   * @param vehicleImgIdSpecified  (optional)
   * @param vehicleImgIdIn  (optional)
   * @param vehicleImgIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/vehicles/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&type.equals={typeEquals}&type.notEquals={typeNotEquals}&type.specified={typeSpecified}&type.in={typeIn}&type.notIn={typeNotIn}&typeFactor.greaterThan={typeFactorGreaterThan}&typeFactor.lessThan={typeFactorLessThan}&typeFactor.greaterThanOrEqual={typeFactorGreaterThanOrEqual}&typeFactor.lessThanOrEqual={typeFactorLessThanOrEqual}&typeFactor.equals={typeFactorEquals}&typeFactor.notEquals={typeFactorNotEquals}&typeFactor.specified={typeFactorSpecified}&typeFactor.in={typeFactorIn}&typeFactor.notIn={typeFactorNotIn}&plateNumber.contains={plateNumberContains}&plateNumber.doesNotContain={plateNumberDoesNotContain}&plateNumber.equals={plateNumberEquals}&plateNumber.notEquals={plateNumberNotEquals}&plateNumber.specified={plateNumberSpecified}&plateNumber.in={plateNumberIn}&plateNumber.notIn={plateNumberNotIn}&brand.contains={brandContains}&brand.doesNotContain={brandDoesNotContain}&brand.equals={brandEquals}&brand.notEquals={brandNotEquals}&brand.specified={brandSpecified}&brand.in={brandIn}&brand.notIn={brandNotIn}&description.contains={descriptionContains}&description.doesNotContain={descriptionDoesNotContain}&description.equals={descriptionEquals}&description.notEquals={descriptionNotEquals}&description.specified={descriptionSpecified}&description.in={descriptionIn}&description.notIn={descriptionNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&seatMapId.greaterThan={seatMapIdGreaterThan}&seatMapId.lessThan={seatMapIdLessThan}&seatMapId.greaterThanOrEqual={seatMapIdGreaterThanOrEqual}&seatMapId.lessThanOrEqual={seatMapIdLessThanOrEqual}&seatMapId.equals={seatMapIdEquals}&seatMapId.notEquals={seatMapIdNotEquals}&seatMapId.specified={seatMapIdSpecified}&seatMapId.in={seatMapIdIn}&seatMapId.notIn={seatMapIdNotIn}&vehicleImgId.greaterThan={vehicleImgIdGreaterThan}&vehicleImgId.lessThan={vehicleImgIdLessThan}&vehicleImgId.greaterThanOrEqual={vehicleImgIdGreaterThanOrEqual}&vehicleImgId.lessThanOrEqual={vehicleImgIdLessThanOrEqual}&vehicleImgId.equals={vehicleImgIdEquals}&vehicleImgId.notEquals={vehicleImgIdNotEquals}&vehicleImgId.specified={vehicleImgIdSpecified}&vehicleImgId.in={vehicleImgIdIn}&vehicleImgId.notIn={vehicleImgIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Long> countVehiclesWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("typeEquals") @jakarta.annotation.Nullable String typeEquals, @Param("typeNotEquals") @jakarta.annotation.Nullable String typeNotEquals, @Param("typeSpecified") @jakarta.annotation.Nullable Boolean typeSpecified, @Param("typeIn") @jakarta.annotation.Nullable List<String> typeIn, @Param("typeNotIn") @jakarta.annotation.Nullable List<String> typeNotIn, @Param("typeFactorGreaterThan") @jakarta.annotation.Nullable BigDecimal typeFactorGreaterThan, @Param("typeFactorLessThan") @jakarta.annotation.Nullable BigDecimal typeFactorLessThan, @Param("typeFactorGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal typeFactorGreaterThanOrEqual, @Param("typeFactorLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal typeFactorLessThanOrEqual, @Param("typeFactorEquals") @jakarta.annotation.Nullable BigDecimal typeFactorEquals, @Param("typeFactorNotEquals") @jakarta.annotation.Nullable BigDecimal typeFactorNotEquals, @Param("typeFactorSpecified") @jakarta.annotation.Nullable Boolean typeFactorSpecified, @Param("typeFactorIn") @jakarta.annotation.Nullable List<BigDecimal> typeFactorIn, @Param("typeFactorNotIn") @jakarta.annotation.Nullable List<BigDecimal> typeFactorNotIn, @Param("plateNumberContains") @jakarta.annotation.Nullable String plateNumberContains, @Param("plateNumberDoesNotContain") @jakarta.annotation.Nullable String plateNumberDoesNotContain, @Param("plateNumberEquals") @jakarta.annotation.Nullable String plateNumberEquals, @Param("plateNumberNotEquals") @jakarta.annotation.Nullable String plateNumberNotEquals, @Param("plateNumberSpecified") @jakarta.annotation.Nullable Boolean plateNumberSpecified, @Param("plateNumberIn") @jakarta.annotation.Nullable List<String> plateNumberIn, @Param("plateNumberNotIn") @jakarta.annotation.Nullable List<String> plateNumberNotIn, @Param("brandContains") @jakarta.annotation.Nullable String brandContains, @Param("brandDoesNotContain") @jakarta.annotation.Nullable String brandDoesNotContain, @Param("brandEquals") @jakarta.annotation.Nullable String brandEquals, @Param("brandNotEquals") @jakarta.annotation.Nullable String brandNotEquals, @Param("brandSpecified") @jakarta.annotation.Nullable Boolean brandSpecified, @Param("brandIn") @jakarta.annotation.Nullable List<String> brandIn, @Param("brandNotIn") @jakarta.annotation.Nullable List<String> brandNotIn, @Param("descriptionContains") @jakarta.annotation.Nullable String descriptionContains, @Param("descriptionDoesNotContain") @jakarta.annotation.Nullable String descriptionDoesNotContain, @Param("descriptionEquals") @jakarta.annotation.Nullable String descriptionEquals, @Param("descriptionNotEquals") @jakarta.annotation.Nullable String descriptionNotEquals, @Param("descriptionSpecified") @jakarta.annotation.Nullable Boolean descriptionSpecified, @Param("descriptionIn") @jakarta.annotation.Nullable List<String> descriptionIn, @Param("descriptionNotIn") @jakarta.annotation.Nullable List<String> descriptionNotIn, @Param("statusEquals") @jakarta.annotation.Nullable String statusEquals, @Param("statusNotEquals") @jakarta.annotation.Nullable String statusNotEquals, @Param("statusSpecified") @jakarta.annotation.Nullable Boolean statusSpecified, @Param("statusIn") @jakarta.annotation.Nullable List<String> statusIn, @Param("statusNotIn") @jakarta.annotation.Nullable List<String> statusNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("seatMapIdGreaterThan") @jakarta.annotation.Nullable Long seatMapIdGreaterThan, @Param("seatMapIdLessThan") @jakarta.annotation.Nullable Long seatMapIdLessThan, @Param("seatMapIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long seatMapIdGreaterThanOrEqual, @Param("seatMapIdLessThanOrEqual") @jakarta.annotation.Nullable Long seatMapIdLessThanOrEqual, @Param("seatMapIdEquals") @jakarta.annotation.Nullable Long seatMapIdEquals, @Param("seatMapIdNotEquals") @jakarta.annotation.Nullable Long seatMapIdNotEquals, @Param("seatMapIdSpecified") @jakarta.annotation.Nullable Boolean seatMapIdSpecified, @Param("seatMapIdIn") @jakarta.annotation.Nullable List<Long> seatMapIdIn, @Param("seatMapIdNotIn") @jakarta.annotation.Nullable List<Long> seatMapIdNotIn, @Param("vehicleImgIdGreaterThan") @jakarta.annotation.Nullable Long vehicleImgIdGreaterThan, @Param("vehicleImgIdLessThan") @jakarta.annotation.Nullable Long vehicleImgIdLessThan, @Param("vehicleImgIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long vehicleImgIdGreaterThanOrEqual, @Param("vehicleImgIdLessThanOrEqual") @jakarta.annotation.Nullable Long vehicleImgIdLessThanOrEqual, @Param("vehicleImgIdEquals") @jakarta.annotation.Nullable Long vehicleImgIdEquals, @Param("vehicleImgIdNotEquals") @jakarta.annotation.Nullable Long vehicleImgIdNotEquals, @Param("vehicleImgIdSpecified") @jakarta.annotation.Nullable Boolean vehicleImgIdSpecified, @Param("vehicleImgIdIn") @jakarta.annotation.Nullable List<Long> vehicleImgIdIn, @Param("vehicleImgIdNotIn") @jakarta.annotation.Nullable List<Long> vehicleImgIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>countVehicles</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CountVehiclesQueryParams} class that allows for
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
   *   <li>typeEquals -  (optional)</li>
   *   <li>typeNotEquals -  (optional)</li>
   *   <li>typeSpecified -  (optional)</li>
   *   <li>typeIn -  (optional)</li>
   *   <li>typeNotIn -  (optional)</li>
   *   <li>typeFactorGreaterThan -  (optional)</li>
   *   <li>typeFactorLessThan -  (optional)</li>
   *   <li>typeFactorGreaterThanOrEqual -  (optional)</li>
   *   <li>typeFactorLessThanOrEqual -  (optional)</li>
   *   <li>typeFactorEquals -  (optional)</li>
   *   <li>typeFactorNotEquals -  (optional)</li>
   *   <li>typeFactorSpecified -  (optional)</li>
   *   <li>typeFactorIn -  (optional)</li>
   *   <li>typeFactorNotIn -  (optional)</li>
   *   <li>plateNumberContains -  (optional)</li>
   *   <li>plateNumberDoesNotContain -  (optional)</li>
   *   <li>plateNumberEquals -  (optional)</li>
   *   <li>plateNumberNotEquals -  (optional)</li>
   *   <li>plateNumberSpecified -  (optional)</li>
   *   <li>plateNumberIn -  (optional)</li>
   *   <li>plateNumberNotIn -  (optional)</li>
   *   <li>brandContains -  (optional)</li>
   *   <li>brandDoesNotContain -  (optional)</li>
   *   <li>brandEquals -  (optional)</li>
   *   <li>brandNotEquals -  (optional)</li>
   *   <li>brandSpecified -  (optional)</li>
   *   <li>brandIn -  (optional)</li>
   *   <li>brandNotIn -  (optional)</li>
   *   <li>descriptionContains -  (optional)</li>
   *   <li>descriptionDoesNotContain -  (optional)</li>
   *   <li>descriptionEquals -  (optional)</li>
   *   <li>descriptionNotEquals -  (optional)</li>
   *   <li>descriptionSpecified -  (optional)</li>
   *   <li>descriptionIn -  (optional)</li>
   *   <li>descriptionNotIn -  (optional)</li>
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
   *   <li>seatMapIdGreaterThan -  (optional)</li>
   *   <li>seatMapIdLessThan -  (optional)</li>
   *   <li>seatMapIdGreaterThanOrEqual -  (optional)</li>
   *   <li>seatMapIdLessThanOrEqual -  (optional)</li>
   *   <li>seatMapIdEquals -  (optional)</li>
   *   <li>seatMapIdNotEquals -  (optional)</li>
   *   <li>seatMapIdSpecified -  (optional)</li>
   *   <li>seatMapIdIn -  (optional)</li>
   *   <li>seatMapIdNotIn -  (optional)</li>
   *   <li>vehicleImgIdGreaterThan -  (optional)</li>
   *   <li>vehicleImgIdLessThan -  (optional)</li>
   *   <li>vehicleImgIdGreaterThanOrEqual -  (optional)</li>
   *   <li>vehicleImgIdLessThanOrEqual -  (optional)</li>
   *   <li>vehicleImgIdEquals -  (optional)</li>
   *   <li>vehicleImgIdNotEquals -  (optional)</li>
   *   <li>vehicleImgIdSpecified -  (optional)</li>
   *   <li>vehicleImgIdIn -  (optional)</li>
   *   <li>vehicleImgIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return Long
   */
  @RequestLine("GET /api/vehicles/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&type.equals={typeEquals}&type.notEquals={typeNotEquals}&type.specified={typeSpecified}&type.in={typeIn}&type.notIn={typeNotIn}&typeFactor.greaterThan={typeFactorGreaterThan}&typeFactor.lessThan={typeFactorLessThan}&typeFactor.greaterThanOrEqual={typeFactorGreaterThanOrEqual}&typeFactor.lessThanOrEqual={typeFactorLessThanOrEqual}&typeFactor.equals={typeFactorEquals}&typeFactor.notEquals={typeFactorNotEquals}&typeFactor.specified={typeFactorSpecified}&typeFactor.in={typeFactorIn}&typeFactor.notIn={typeFactorNotIn}&plateNumber.contains={plateNumberContains}&plateNumber.doesNotContain={plateNumberDoesNotContain}&plateNumber.equals={plateNumberEquals}&plateNumber.notEquals={plateNumberNotEquals}&plateNumber.specified={plateNumberSpecified}&plateNumber.in={plateNumberIn}&plateNumber.notIn={plateNumberNotIn}&brand.contains={brandContains}&brand.doesNotContain={brandDoesNotContain}&brand.equals={brandEquals}&brand.notEquals={brandNotEquals}&brand.specified={brandSpecified}&brand.in={brandIn}&brand.notIn={brandNotIn}&description.contains={descriptionContains}&description.doesNotContain={descriptionDoesNotContain}&description.equals={descriptionEquals}&description.notEquals={descriptionNotEquals}&description.specified={descriptionSpecified}&description.in={descriptionIn}&description.notIn={descriptionNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&seatMapId.greaterThan={seatMapIdGreaterThan}&seatMapId.lessThan={seatMapIdLessThan}&seatMapId.greaterThanOrEqual={seatMapIdGreaterThanOrEqual}&seatMapId.lessThanOrEqual={seatMapIdLessThanOrEqual}&seatMapId.equals={seatMapIdEquals}&seatMapId.notEquals={seatMapIdNotEquals}&seatMapId.specified={seatMapIdSpecified}&seatMapId.in={seatMapIdIn}&seatMapId.notIn={seatMapIdNotIn}&vehicleImgId.greaterThan={vehicleImgIdGreaterThan}&vehicleImgId.lessThan={vehicleImgIdLessThan}&vehicleImgId.greaterThanOrEqual={vehicleImgIdGreaterThanOrEqual}&vehicleImgId.lessThanOrEqual={vehicleImgIdLessThanOrEqual}&vehicleImgId.equals={vehicleImgIdEquals}&vehicleImgId.notEquals={vehicleImgIdNotEquals}&vehicleImgId.specified={vehicleImgIdSpecified}&vehicleImgId.in={vehicleImgIdIn}&vehicleImgId.notIn={vehicleImgIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  Long countVehicles(@QueryMap(encoded=true) CountVehiclesQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>countVehicles</code> that receives the query parameters as a map,
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
          *   <li>typeEquals -  (optional)</li>
          *   <li>typeNotEquals -  (optional)</li>
          *   <li>typeSpecified -  (optional)</li>
          *   <li>typeIn -  (optional)</li>
          *   <li>typeNotIn -  (optional)</li>
          *   <li>typeFactorGreaterThan -  (optional)</li>
          *   <li>typeFactorLessThan -  (optional)</li>
          *   <li>typeFactorGreaterThanOrEqual -  (optional)</li>
          *   <li>typeFactorLessThanOrEqual -  (optional)</li>
          *   <li>typeFactorEquals -  (optional)</li>
          *   <li>typeFactorNotEquals -  (optional)</li>
          *   <li>typeFactorSpecified -  (optional)</li>
          *   <li>typeFactorIn -  (optional)</li>
          *   <li>typeFactorNotIn -  (optional)</li>
          *   <li>plateNumberContains -  (optional)</li>
          *   <li>plateNumberDoesNotContain -  (optional)</li>
          *   <li>plateNumberEquals -  (optional)</li>
          *   <li>plateNumberNotEquals -  (optional)</li>
          *   <li>plateNumberSpecified -  (optional)</li>
          *   <li>plateNumberIn -  (optional)</li>
          *   <li>plateNumberNotIn -  (optional)</li>
          *   <li>brandContains -  (optional)</li>
          *   <li>brandDoesNotContain -  (optional)</li>
          *   <li>brandEquals -  (optional)</li>
          *   <li>brandNotEquals -  (optional)</li>
          *   <li>brandSpecified -  (optional)</li>
          *   <li>brandIn -  (optional)</li>
          *   <li>brandNotIn -  (optional)</li>
          *   <li>descriptionContains -  (optional)</li>
          *   <li>descriptionDoesNotContain -  (optional)</li>
          *   <li>descriptionEquals -  (optional)</li>
          *   <li>descriptionNotEquals -  (optional)</li>
          *   <li>descriptionSpecified -  (optional)</li>
          *   <li>descriptionIn -  (optional)</li>
          *   <li>descriptionNotIn -  (optional)</li>
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
          *   <li>seatMapIdGreaterThan -  (optional)</li>
          *   <li>seatMapIdLessThan -  (optional)</li>
          *   <li>seatMapIdGreaterThanOrEqual -  (optional)</li>
          *   <li>seatMapIdLessThanOrEqual -  (optional)</li>
          *   <li>seatMapIdEquals -  (optional)</li>
          *   <li>seatMapIdNotEquals -  (optional)</li>
          *   <li>seatMapIdSpecified -  (optional)</li>
          *   <li>seatMapIdIn -  (optional)</li>
          *   <li>seatMapIdNotIn -  (optional)</li>
          *   <li>vehicleImgIdGreaterThan -  (optional)</li>
          *   <li>vehicleImgIdLessThan -  (optional)</li>
          *   <li>vehicleImgIdGreaterThanOrEqual -  (optional)</li>
          *   <li>vehicleImgIdLessThanOrEqual -  (optional)</li>
          *   <li>vehicleImgIdEquals -  (optional)</li>
          *   <li>vehicleImgIdNotEquals -  (optional)</li>
          *   <li>vehicleImgIdSpecified -  (optional)</li>
          *   <li>vehicleImgIdIn -  (optional)</li>
          *   <li>vehicleImgIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return Long
      */
      @RequestLine("GET /api/vehicles/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&type.equals={typeEquals}&type.notEquals={typeNotEquals}&type.specified={typeSpecified}&type.in={typeIn}&type.notIn={typeNotIn}&typeFactor.greaterThan={typeFactorGreaterThan}&typeFactor.lessThan={typeFactorLessThan}&typeFactor.greaterThanOrEqual={typeFactorGreaterThanOrEqual}&typeFactor.lessThanOrEqual={typeFactorLessThanOrEqual}&typeFactor.equals={typeFactorEquals}&typeFactor.notEquals={typeFactorNotEquals}&typeFactor.specified={typeFactorSpecified}&typeFactor.in={typeFactorIn}&typeFactor.notIn={typeFactorNotIn}&plateNumber.contains={plateNumberContains}&plateNumber.doesNotContain={plateNumberDoesNotContain}&plateNumber.equals={plateNumberEquals}&plateNumber.notEquals={plateNumberNotEquals}&plateNumber.specified={plateNumberSpecified}&plateNumber.in={plateNumberIn}&plateNumber.notIn={plateNumberNotIn}&brand.contains={brandContains}&brand.doesNotContain={brandDoesNotContain}&brand.equals={brandEquals}&brand.notEquals={brandNotEquals}&brand.specified={brandSpecified}&brand.in={brandIn}&brand.notIn={brandNotIn}&description.contains={descriptionContains}&description.doesNotContain={descriptionDoesNotContain}&description.equals={descriptionEquals}&description.notEquals={descriptionNotEquals}&description.specified={descriptionSpecified}&description.in={descriptionIn}&description.notIn={descriptionNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&seatMapId.greaterThan={seatMapIdGreaterThan}&seatMapId.lessThan={seatMapIdLessThan}&seatMapId.greaterThanOrEqual={seatMapIdGreaterThanOrEqual}&seatMapId.lessThanOrEqual={seatMapIdLessThanOrEqual}&seatMapId.equals={seatMapIdEquals}&seatMapId.notEquals={seatMapIdNotEquals}&seatMapId.specified={seatMapIdSpecified}&seatMapId.in={seatMapIdIn}&seatMapId.notIn={seatMapIdNotIn}&vehicleImgId.greaterThan={vehicleImgIdGreaterThan}&vehicleImgId.lessThan={vehicleImgIdLessThan}&vehicleImgId.greaterThanOrEqual={vehicleImgIdGreaterThanOrEqual}&vehicleImgId.lessThanOrEqual={vehicleImgIdLessThanOrEqual}&vehicleImgId.equals={vehicleImgIdEquals}&vehicleImgId.notEquals={vehicleImgIdNotEquals}&vehicleImgId.specified={vehicleImgIdSpecified}&vehicleImgId.in={vehicleImgIdIn}&vehicleImgId.notIn={vehicleImgIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Long> countVehiclesWithHttpInfo(@QueryMap(encoded=true) CountVehiclesQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>countVehicles</code> method in a fluent style.
   */
  public static class CountVehiclesQueryParams extends HashMap<String, Object> {
    public CountVehiclesQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountVehiclesQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountVehiclesQueryParams typeEquals(@jakarta.annotation.Nullable final String value) {
      put("type.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams typeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("type.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams typeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("type.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams typeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("type.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountVehiclesQueryParams typeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("type.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountVehiclesQueryParams typeFactorGreaterThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("typeFactor.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams typeFactorLessThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("typeFactor.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams typeFactorGreaterThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("typeFactor.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams typeFactorLessThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("typeFactor.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams typeFactorEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("typeFactor.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams typeFactorNotEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("typeFactor.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams typeFactorSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("typeFactor.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams typeFactorIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("typeFactor.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountVehiclesQueryParams typeFactorNotIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("typeFactor.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountVehiclesQueryParams plateNumberContains(@jakarta.annotation.Nullable final String value) {
      put("plateNumber.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams plateNumberDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("plateNumber.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams plateNumberEquals(@jakarta.annotation.Nullable final String value) {
      put("plateNumber.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams plateNumberNotEquals(@jakarta.annotation.Nullable final String value) {
      put("plateNumber.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams plateNumberSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("plateNumber.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams plateNumberIn(@jakarta.annotation.Nullable final List<String> value) {
      put("plateNumber.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountVehiclesQueryParams plateNumberNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("plateNumber.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountVehiclesQueryParams brandContains(@jakarta.annotation.Nullable final String value) {
      put("brand.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams brandDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("brand.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams brandEquals(@jakarta.annotation.Nullable final String value) {
      put("brand.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams brandNotEquals(@jakarta.annotation.Nullable final String value) {
      put("brand.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams brandSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("brand.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams brandIn(@jakarta.annotation.Nullable final List<String> value) {
      put("brand.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountVehiclesQueryParams brandNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("brand.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountVehiclesQueryParams descriptionContains(@jakarta.annotation.Nullable final String value) {
      put("description.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams descriptionDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("description.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams descriptionEquals(@jakarta.annotation.Nullable final String value) {
      put("description.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams descriptionNotEquals(@jakarta.annotation.Nullable final String value) {
      put("description.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams descriptionSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("description.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams descriptionIn(@jakarta.annotation.Nullable final List<String> value) {
      put("description.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountVehiclesQueryParams descriptionNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("description.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountVehiclesQueryParams statusEquals(@jakarta.annotation.Nullable final String value) {
      put("status.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams statusNotEquals(@jakarta.annotation.Nullable final String value) {
      put("status.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams statusSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("status.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams statusIn(@jakarta.annotation.Nullable final List<String> value) {
      put("status.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountVehiclesQueryParams statusNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("status.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountVehiclesQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountVehiclesQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountVehiclesQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountVehiclesQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountVehiclesQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountVehiclesQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountVehiclesQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountVehiclesQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountVehiclesQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountVehiclesQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountVehiclesQueryParams seatMapIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams seatMapIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams seatMapIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams seatMapIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams seatMapIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams seatMapIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams seatMapIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("seatMapId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams seatMapIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("seatMapId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountVehiclesQueryParams seatMapIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("seatMapId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountVehiclesQueryParams vehicleImgIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("vehicleImgId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams vehicleImgIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("vehicleImgId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams vehicleImgIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("vehicleImgId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams vehicleImgIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("vehicleImgId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams vehicleImgIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("vehicleImgId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams vehicleImgIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("vehicleImgId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams vehicleImgIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("vehicleImgId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountVehiclesQueryParams vehicleImgIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("vehicleImgId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountVehiclesQueryParams vehicleImgIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("vehicleImgId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountVehiclesQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param vehicleDTO  (required)
   * @return VehicleDTO
   */
  @RequestLine("POST /api/vehicles")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  VehicleDTO createVehicle(@jakarta.annotation.Nonnull VehicleDTO vehicleDTO);

  /**
   * 
   * Similar to <code>createVehicle</code> but it also returns the http response headers .
   * 
   * @param vehicleDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/vehicles")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<VehicleDTO> createVehicleWithHttpInfo(@jakarta.annotation.Nonnull VehicleDTO vehicleDTO);



  /**
   * 
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/vehicles/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteVehicle(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>deleteVehicle</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/vehicles/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteVehicleWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



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
   * @param typeEquals  (optional)
   * @param typeNotEquals  (optional)
   * @param typeSpecified  (optional)
   * @param typeIn  (optional)
   * @param typeNotIn  (optional)
   * @param typeFactorGreaterThan  (optional)
   * @param typeFactorLessThan  (optional)
   * @param typeFactorGreaterThanOrEqual  (optional)
   * @param typeFactorLessThanOrEqual  (optional)
   * @param typeFactorEquals  (optional)
   * @param typeFactorNotEquals  (optional)
   * @param typeFactorSpecified  (optional)
   * @param typeFactorIn  (optional)
   * @param typeFactorNotIn  (optional)
   * @param plateNumberContains  (optional)
   * @param plateNumberDoesNotContain  (optional)
   * @param plateNumberEquals  (optional)
   * @param plateNumberNotEquals  (optional)
   * @param plateNumberSpecified  (optional)
   * @param plateNumberIn  (optional)
   * @param plateNumberNotIn  (optional)
   * @param brandContains  (optional)
   * @param brandDoesNotContain  (optional)
   * @param brandEquals  (optional)
   * @param brandNotEquals  (optional)
   * @param brandSpecified  (optional)
   * @param brandIn  (optional)
   * @param brandNotIn  (optional)
   * @param descriptionContains  (optional)
   * @param descriptionDoesNotContain  (optional)
   * @param descriptionEquals  (optional)
   * @param descriptionNotEquals  (optional)
   * @param descriptionSpecified  (optional)
   * @param descriptionIn  (optional)
   * @param descriptionNotIn  (optional)
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
   * @param seatMapIdGreaterThan  (optional)
   * @param seatMapIdLessThan  (optional)
   * @param seatMapIdGreaterThanOrEqual  (optional)
   * @param seatMapIdLessThanOrEqual  (optional)
   * @param seatMapIdEquals  (optional)
   * @param seatMapIdNotEquals  (optional)
   * @param seatMapIdSpecified  (optional)
   * @param seatMapIdIn  (optional)
   * @param seatMapIdNotIn  (optional)
   * @param vehicleImgIdGreaterThan  (optional)
   * @param vehicleImgIdLessThan  (optional)
   * @param vehicleImgIdGreaterThanOrEqual  (optional)
   * @param vehicleImgIdLessThanOrEqual  (optional)
   * @param vehicleImgIdEquals  (optional)
   * @param vehicleImgIdNotEquals  (optional)
   * @param vehicleImgIdSpecified  (optional)
   * @param vehicleImgIdIn  (optional)
   * @param vehicleImgIdNotIn  (optional)
   * @param distinct  (optional)
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return List&lt;VehicleDTO&gt;
   */
  @RequestLine("GET /api/vehicles?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&type.equals={typeEquals}&type.notEquals={typeNotEquals}&type.specified={typeSpecified}&type.in={typeIn}&type.notIn={typeNotIn}&typeFactor.greaterThan={typeFactorGreaterThan}&typeFactor.lessThan={typeFactorLessThan}&typeFactor.greaterThanOrEqual={typeFactorGreaterThanOrEqual}&typeFactor.lessThanOrEqual={typeFactorLessThanOrEqual}&typeFactor.equals={typeFactorEquals}&typeFactor.notEquals={typeFactorNotEquals}&typeFactor.specified={typeFactorSpecified}&typeFactor.in={typeFactorIn}&typeFactor.notIn={typeFactorNotIn}&plateNumber.contains={plateNumberContains}&plateNumber.doesNotContain={plateNumberDoesNotContain}&plateNumber.equals={plateNumberEquals}&plateNumber.notEquals={plateNumberNotEquals}&plateNumber.specified={plateNumberSpecified}&plateNumber.in={plateNumberIn}&plateNumber.notIn={plateNumberNotIn}&brand.contains={brandContains}&brand.doesNotContain={brandDoesNotContain}&brand.equals={brandEquals}&brand.notEquals={brandNotEquals}&brand.specified={brandSpecified}&brand.in={brandIn}&brand.notIn={brandNotIn}&description.contains={descriptionContains}&description.doesNotContain={descriptionDoesNotContain}&description.equals={descriptionEquals}&description.notEquals={descriptionNotEquals}&description.specified={descriptionSpecified}&description.in={descriptionIn}&description.notIn={descriptionNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&seatMapId.greaterThan={seatMapIdGreaterThan}&seatMapId.lessThan={seatMapIdLessThan}&seatMapId.greaterThanOrEqual={seatMapIdGreaterThanOrEqual}&seatMapId.lessThanOrEqual={seatMapIdLessThanOrEqual}&seatMapId.equals={seatMapIdEquals}&seatMapId.notEquals={seatMapIdNotEquals}&seatMapId.specified={seatMapIdSpecified}&seatMapId.in={seatMapIdIn}&seatMapId.notIn={seatMapIdNotIn}&vehicleImgId.greaterThan={vehicleImgIdGreaterThan}&vehicleImgId.lessThan={vehicleImgIdLessThan}&vehicleImgId.greaterThanOrEqual={vehicleImgIdGreaterThanOrEqual}&vehicleImgId.lessThanOrEqual={vehicleImgIdLessThanOrEqual}&vehicleImgId.equals={vehicleImgIdEquals}&vehicleImgId.notEquals={vehicleImgIdNotEquals}&vehicleImgId.specified={vehicleImgIdSpecified}&vehicleImgId.in={vehicleImgIdIn}&vehicleImgId.notIn={vehicleImgIdNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",
  })
  List<VehicleDTO> getAllVehicles(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("typeEquals") @jakarta.annotation.Nullable String typeEquals, @Param("typeNotEquals") @jakarta.annotation.Nullable String typeNotEquals, @Param("typeSpecified") @jakarta.annotation.Nullable Boolean typeSpecified, @Param("typeIn") @jakarta.annotation.Nullable List<String> typeIn, @Param("typeNotIn") @jakarta.annotation.Nullable List<String> typeNotIn, @Param("typeFactorGreaterThan") @jakarta.annotation.Nullable BigDecimal typeFactorGreaterThan, @Param("typeFactorLessThan") @jakarta.annotation.Nullable BigDecimal typeFactorLessThan, @Param("typeFactorGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal typeFactorGreaterThanOrEqual, @Param("typeFactorLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal typeFactorLessThanOrEqual, @Param("typeFactorEquals") @jakarta.annotation.Nullable BigDecimal typeFactorEquals, @Param("typeFactorNotEquals") @jakarta.annotation.Nullable BigDecimal typeFactorNotEquals, @Param("typeFactorSpecified") @jakarta.annotation.Nullable Boolean typeFactorSpecified, @Param("typeFactorIn") @jakarta.annotation.Nullable List<BigDecimal> typeFactorIn, @Param("typeFactorNotIn") @jakarta.annotation.Nullable List<BigDecimal> typeFactorNotIn, @Param("plateNumberContains") @jakarta.annotation.Nullable String plateNumberContains, @Param("plateNumberDoesNotContain") @jakarta.annotation.Nullable String plateNumberDoesNotContain, @Param("plateNumberEquals") @jakarta.annotation.Nullable String plateNumberEquals, @Param("plateNumberNotEquals") @jakarta.annotation.Nullable String plateNumberNotEquals, @Param("plateNumberSpecified") @jakarta.annotation.Nullable Boolean plateNumberSpecified, @Param("plateNumberIn") @jakarta.annotation.Nullable List<String> plateNumberIn, @Param("plateNumberNotIn") @jakarta.annotation.Nullable List<String> plateNumberNotIn, @Param("brandContains") @jakarta.annotation.Nullable String brandContains, @Param("brandDoesNotContain") @jakarta.annotation.Nullable String brandDoesNotContain, @Param("brandEquals") @jakarta.annotation.Nullable String brandEquals, @Param("brandNotEquals") @jakarta.annotation.Nullable String brandNotEquals, @Param("brandSpecified") @jakarta.annotation.Nullable Boolean brandSpecified, @Param("brandIn") @jakarta.annotation.Nullable List<String> brandIn, @Param("brandNotIn") @jakarta.annotation.Nullable List<String> brandNotIn, @Param("descriptionContains") @jakarta.annotation.Nullable String descriptionContains, @Param("descriptionDoesNotContain") @jakarta.annotation.Nullable String descriptionDoesNotContain, @Param("descriptionEquals") @jakarta.annotation.Nullable String descriptionEquals, @Param("descriptionNotEquals") @jakarta.annotation.Nullable String descriptionNotEquals, @Param("descriptionSpecified") @jakarta.annotation.Nullable Boolean descriptionSpecified, @Param("descriptionIn") @jakarta.annotation.Nullable List<String> descriptionIn, @Param("descriptionNotIn") @jakarta.annotation.Nullable List<String> descriptionNotIn, @Param("statusEquals") @jakarta.annotation.Nullable String statusEquals, @Param("statusNotEquals") @jakarta.annotation.Nullable String statusNotEquals, @Param("statusSpecified") @jakarta.annotation.Nullable Boolean statusSpecified, @Param("statusIn") @jakarta.annotation.Nullable List<String> statusIn, @Param("statusNotIn") @jakarta.annotation.Nullable List<String> statusNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("seatMapIdGreaterThan") @jakarta.annotation.Nullable Long seatMapIdGreaterThan, @Param("seatMapIdLessThan") @jakarta.annotation.Nullable Long seatMapIdLessThan, @Param("seatMapIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long seatMapIdGreaterThanOrEqual, @Param("seatMapIdLessThanOrEqual") @jakarta.annotation.Nullable Long seatMapIdLessThanOrEqual, @Param("seatMapIdEquals") @jakarta.annotation.Nullable Long seatMapIdEquals, @Param("seatMapIdNotEquals") @jakarta.annotation.Nullable Long seatMapIdNotEquals, @Param("seatMapIdSpecified") @jakarta.annotation.Nullable Boolean seatMapIdSpecified, @Param("seatMapIdIn") @jakarta.annotation.Nullable List<Long> seatMapIdIn, @Param("seatMapIdNotIn") @jakarta.annotation.Nullable List<Long> seatMapIdNotIn, @Param("vehicleImgIdGreaterThan") @jakarta.annotation.Nullable Long vehicleImgIdGreaterThan, @Param("vehicleImgIdLessThan") @jakarta.annotation.Nullable Long vehicleImgIdLessThan, @Param("vehicleImgIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long vehicleImgIdGreaterThanOrEqual, @Param("vehicleImgIdLessThanOrEqual") @jakarta.annotation.Nullable Long vehicleImgIdLessThanOrEqual, @Param("vehicleImgIdEquals") @jakarta.annotation.Nullable Long vehicleImgIdEquals, @Param("vehicleImgIdNotEquals") @jakarta.annotation.Nullable Long vehicleImgIdNotEquals, @Param("vehicleImgIdSpecified") @jakarta.annotation.Nullable Boolean vehicleImgIdSpecified, @Param("vehicleImgIdIn") @jakarta.annotation.Nullable List<Long> vehicleImgIdIn, @Param("vehicleImgIdNotIn") @jakarta.annotation.Nullable List<Long> vehicleImgIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct, @Param("page") @jakarta.annotation.Nullable Integer page, @Param("size") @jakarta.annotation.Nullable Integer size, @Param("sort") @jakarta.annotation.Nullable List<String> sort);

  /**
   * 
   * Similar to <code>getAllVehicles</code> but it also returns the http response headers .
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
   * @param typeEquals  (optional)
   * @param typeNotEquals  (optional)
   * @param typeSpecified  (optional)
   * @param typeIn  (optional)
   * @param typeNotIn  (optional)
   * @param typeFactorGreaterThan  (optional)
   * @param typeFactorLessThan  (optional)
   * @param typeFactorGreaterThanOrEqual  (optional)
   * @param typeFactorLessThanOrEqual  (optional)
   * @param typeFactorEquals  (optional)
   * @param typeFactorNotEquals  (optional)
   * @param typeFactorSpecified  (optional)
   * @param typeFactorIn  (optional)
   * @param typeFactorNotIn  (optional)
   * @param plateNumberContains  (optional)
   * @param plateNumberDoesNotContain  (optional)
   * @param plateNumberEquals  (optional)
   * @param plateNumberNotEquals  (optional)
   * @param plateNumberSpecified  (optional)
   * @param plateNumberIn  (optional)
   * @param plateNumberNotIn  (optional)
   * @param brandContains  (optional)
   * @param brandDoesNotContain  (optional)
   * @param brandEquals  (optional)
   * @param brandNotEquals  (optional)
   * @param brandSpecified  (optional)
   * @param brandIn  (optional)
   * @param brandNotIn  (optional)
   * @param descriptionContains  (optional)
   * @param descriptionDoesNotContain  (optional)
   * @param descriptionEquals  (optional)
   * @param descriptionNotEquals  (optional)
   * @param descriptionSpecified  (optional)
   * @param descriptionIn  (optional)
   * @param descriptionNotIn  (optional)
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
   * @param seatMapIdGreaterThan  (optional)
   * @param seatMapIdLessThan  (optional)
   * @param seatMapIdGreaterThanOrEqual  (optional)
   * @param seatMapIdLessThanOrEqual  (optional)
   * @param seatMapIdEquals  (optional)
   * @param seatMapIdNotEquals  (optional)
   * @param seatMapIdSpecified  (optional)
   * @param seatMapIdIn  (optional)
   * @param seatMapIdNotIn  (optional)
   * @param vehicleImgIdGreaterThan  (optional)
   * @param vehicleImgIdLessThan  (optional)
   * @param vehicleImgIdGreaterThanOrEqual  (optional)
   * @param vehicleImgIdLessThanOrEqual  (optional)
   * @param vehicleImgIdEquals  (optional)
   * @param vehicleImgIdNotEquals  (optional)
   * @param vehicleImgIdSpecified  (optional)
   * @param vehicleImgIdIn  (optional)
   * @param vehicleImgIdNotIn  (optional)
   * @param distinct  (optional)
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/vehicles?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&type.equals={typeEquals}&type.notEquals={typeNotEquals}&type.specified={typeSpecified}&type.in={typeIn}&type.notIn={typeNotIn}&typeFactor.greaterThan={typeFactorGreaterThan}&typeFactor.lessThan={typeFactorLessThan}&typeFactor.greaterThanOrEqual={typeFactorGreaterThanOrEqual}&typeFactor.lessThanOrEqual={typeFactorLessThanOrEqual}&typeFactor.equals={typeFactorEquals}&typeFactor.notEquals={typeFactorNotEquals}&typeFactor.specified={typeFactorSpecified}&typeFactor.in={typeFactorIn}&typeFactor.notIn={typeFactorNotIn}&plateNumber.contains={plateNumberContains}&plateNumber.doesNotContain={plateNumberDoesNotContain}&plateNumber.equals={plateNumberEquals}&plateNumber.notEquals={plateNumberNotEquals}&plateNumber.specified={plateNumberSpecified}&plateNumber.in={plateNumberIn}&plateNumber.notIn={plateNumberNotIn}&brand.contains={brandContains}&brand.doesNotContain={brandDoesNotContain}&brand.equals={brandEquals}&brand.notEquals={brandNotEquals}&brand.specified={brandSpecified}&brand.in={brandIn}&brand.notIn={brandNotIn}&description.contains={descriptionContains}&description.doesNotContain={descriptionDoesNotContain}&description.equals={descriptionEquals}&description.notEquals={descriptionNotEquals}&description.specified={descriptionSpecified}&description.in={descriptionIn}&description.notIn={descriptionNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&seatMapId.greaterThan={seatMapIdGreaterThan}&seatMapId.lessThan={seatMapIdLessThan}&seatMapId.greaterThanOrEqual={seatMapIdGreaterThanOrEqual}&seatMapId.lessThanOrEqual={seatMapIdLessThanOrEqual}&seatMapId.equals={seatMapIdEquals}&seatMapId.notEquals={seatMapIdNotEquals}&seatMapId.specified={seatMapIdSpecified}&seatMapId.in={seatMapIdIn}&seatMapId.notIn={seatMapIdNotIn}&vehicleImgId.greaterThan={vehicleImgIdGreaterThan}&vehicleImgId.lessThan={vehicleImgIdLessThan}&vehicleImgId.greaterThanOrEqual={vehicleImgIdGreaterThanOrEqual}&vehicleImgId.lessThanOrEqual={vehicleImgIdLessThanOrEqual}&vehicleImgId.equals={vehicleImgIdEquals}&vehicleImgId.notEquals={vehicleImgIdNotEquals}&vehicleImgId.specified={vehicleImgIdSpecified}&vehicleImgId.in={vehicleImgIdIn}&vehicleImgId.notIn={vehicleImgIdNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<VehicleDTO>> getAllVehiclesWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("typeEquals") @jakarta.annotation.Nullable String typeEquals, @Param("typeNotEquals") @jakarta.annotation.Nullable String typeNotEquals, @Param("typeSpecified") @jakarta.annotation.Nullable Boolean typeSpecified, @Param("typeIn") @jakarta.annotation.Nullable List<String> typeIn, @Param("typeNotIn") @jakarta.annotation.Nullable List<String> typeNotIn, @Param("typeFactorGreaterThan") @jakarta.annotation.Nullable BigDecimal typeFactorGreaterThan, @Param("typeFactorLessThan") @jakarta.annotation.Nullable BigDecimal typeFactorLessThan, @Param("typeFactorGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal typeFactorGreaterThanOrEqual, @Param("typeFactorLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal typeFactorLessThanOrEqual, @Param("typeFactorEquals") @jakarta.annotation.Nullable BigDecimal typeFactorEquals, @Param("typeFactorNotEquals") @jakarta.annotation.Nullable BigDecimal typeFactorNotEquals, @Param("typeFactorSpecified") @jakarta.annotation.Nullable Boolean typeFactorSpecified, @Param("typeFactorIn") @jakarta.annotation.Nullable List<BigDecimal> typeFactorIn, @Param("typeFactorNotIn") @jakarta.annotation.Nullable List<BigDecimal> typeFactorNotIn, @Param("plateNumberContains") @jakarta.annotation.Nullable String plateNumberContains, @Param("plateNumberDoesNotContain") @jakarta.annotation.Nullable String plateNumberDoesNotContain, @Param("plateNumberEquals") @jakarta.annotation.Nullable String plateNumberEquals, @Param("plateNumberNotEquals") @jakarta.annotation.Nullable String plateNumberNotEquals, @Param("plateNumberSpecified") @jakarta.annotation.Nullable Boolean plateNumberSpecified, @Param("plateNumberIn") @jakarta.annotation.Nullable List<String> plateNumberIn, @Param("plateNumberNotIn") @jakarta.annotation.Nullable List<String> plateNumberNotIn, @Param("brandContains") @jakarta.annotation.Nullable String brandContains, @Param("brandDoesNotContain") @jakarta.annotation.Nullable String brandDoesNotContain, @Param("brandEquals") @jakarta.annotation.Nullable String brandEquals, @Param("brandNotEquals") @jakarta.annotation.Nullable String brandNotEquals, @Param("brandSpecified") @jakarta.annotation.Nullable Boolean brandSpecified, @Param("brandIn") @jakarta.annotation.Nullable List<String> brandIn, @Param("brandNotIn") @jakarta.annotation.Nullable List<String> brandNotIn, @Param("descriptionContains") @jakarta.annotation.Nullable String descriptionContains, @Param("descriptionDoesNotContain") @jakarta.annotation.Nullable String descriptionDoesNotContain, @Param("descriptionEquals") @jakarta.annotation.Nullable String descriptionEquals, @Param("descriptionNotEquals") @jakarta.annotation.Nullable String descriptionNotEquals, @Param("descriptionSpecified") @jakarta.annotation.Nullable Boolean descriptionSpecified, @Param("descriptionIn") @jakarta.annotation.Nullable List<String> descriptionIn, @Param("descriptionNotIn") @jakarta.annotation.Nullable List<String> descriptionNotIn, @Param("statusEquals") @jakarta.annotation.Nullable String statusEquals, @Param("statusNotEquals") @jakarta.annotation.Nullable String statusNotEquals, @Param("statusSpecified") @jakarta.annotation.Nullable Boolean statusSpecified, @Param("statusIn") @jakarta.annotation.Nullable List<String> statusIn, @Param("statusNotIn") @jakarta.annotation.Nullable List<String> statusNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("seatMapIdGreaterThan") @jakarta.annotation.Nullable Long seatMapIdGreaterThan, @Param("seatMapIdLessThan") @jakarta.annotation.Nullable Long seatMapIdLessThan, @Param("seatMapIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long seatMapIdGreaterThanOrEqual, @Param("seatMapIdLessThanOrEqual") @jakarta.annotation.Nullable Long seatMapIdLessThanOrEqual, @Param("seatMapIdEquals") @jakarta.annotation.Nullable Long seatMapIdEquals, @Param("seatMapIdNotEquals") @jakarta.annotation.Nullable Long seatMapIdNotEquals, @Param("seatMapIdSpecified") @jakarta.annotation.Nullable Boolean seatMapIdSpecified, @Param("seatMapIdIn") @jakarta.annotation.Nullable List<Long> seatMapIdIn, @Param("seatMapIdNotIn") @jakarta.annotation.Nullable List<Long> seatMapIdNotIn, @Param("vehicleImgIdGreaterThan") @jakarta.annotation.Nullable Long vehicleImgIdGreaterThan, @Param("vehicleImgIdLessThan") @jakarta.annotation.Nullable Long vehicleImgIdLessThan, @Param("vehicleImgIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long vehicleImgIdGreaterThanOrEqual, @Param("vehicleImgIdLessThanOrEqual") @jakarta.annotation.Nullable Long vehicleImgIdLessThanOrEqual, @Param("vehicleImgIdEquals") @jakarta.annotation.Nullable Long vehicleImgIdEquals, @Param("vehicleImgIdNotEquals") @jakarta.annotation.Nullable Long vehicleImgIdNotEquals, @Param("vehicleImgIdSpecified") @jakarta.annotation.Nullable Boolean vehicleImgIdSpecified, @Param("vehicleImgIdIn") @jakarta.annotation.Nullable List<Long> vehicleImgIdIn, @Param("vehicleImgIdNotIn") @jakarta.annotation.Nullable List<Long> vehicleImgIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct, @Param("page") @jakarta.annotation.Nullable Integer page, @Param("size") @jakarta.annotation.Nullable Integer size, @Param("sort") @jakarta.annotation.Nullable List<String> sort);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllVehicles</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllVehiclesQueryParams} class that allows for
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
   *   <li>typeEquals -  (optional)</li>
   *   <li>typeNotEquals -  (optional)</li>
   *   <li>typeSpecified -  (optional)</li>
   *   <li>typeIn -  (optional)</li>
   *   <li>typeNotIn -  (optional)</li>
   *   <li>typeFactorGreaterThan -  (optional)</li>
   *   <li>typeFactorLessThan -  (optional)</li>
   *   <li>typeFactorGreaterThanOrEqual -  (optional)</li>
   *   <li>typeFactorLessThanOrEqual -  (optional)</li>
   *   <li>typeFactorEquals -  (optional)</li>
   *   <li>typeFactorNotEquals -  (optional)</li>
   *   <li>typeFactorSpecified -  (optional)</li>
   *   <li>typeFactorIn -  (optional)</li>
   *   <li>typeFactorNotIn -  (optional)</li>
   *   <li>plateNumberContains -  (optional)</li>
   *   <li>plateNumberDoesNotContain -  (optional)</li>
   *   <li>plateNumberEquals -  (optional)</li>
   *   <li>plateNumberNotEquals -  (optional)</li>
   *   <li>plateNumberSpecified -  (optional)</li>
   *   <li>plateNumberIn -  (optional)</li>
   *   <li>plateNumberNotIn -  (optional)</li>
   *   <li>brandContains -  (optional)</li>
   *   <li>brandDoesNotContain -  (optional)</li>
   *   <li>brandEquals -  (optional)</li>
   *   <li>brandNotEquals -  (optional)</li>
   *   <li>brandSpecified -  (optional)</li>
   *   <li>brandIn -  (optional)</li>
   *   <li>brandNotIn -  (optional)</li>
   *   <li>descriptionContains -  (optional)</li>
   *   <li>descriptionDoesNotContain -  (optional)</li>
   *   <li>descriptionEquals -  (optional)</li>
   *   <li>descriptionNotEquals -  (optional)</li>
   *   <li>descriptionSpecified -  (optional)</li>
   *   <li>descriptionIn -  (optional)</li>
   *   <li>descriptionNotIn -  (optional)</li>
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
   *   <li>seatMapIdGreaterThan -  (optional)</li>
   *   <li>seatMapIdLessThan -  (optional)</li>
   *   <li>seatMapIdGreaterThanOrEqual -  (optional)</li>
   *   <li>seatMapIdLessThanOrEqual -  (optional)</li>
   *   <li>seatMapIdEquals -  (optional)</li>
   *   <li>seatMapIdNotEquals -  (optional)</li>
   *   <li>seatMapIdSpecified -  (optional)</li>
   *   <li>seatMapIdIn -  (optional)</li>
   *   <li>seatMapIdNotIn -  (optional)</li>
   *   <li>vehicleImgIdGreaterThan -  (optional)</li>
   *   <li>vehicleImgIdLessThan -  (optional)</li>
   *   <li>vehicleImgIdGreaterThanOrEqual -  (optional)</li>
   *   <li>vehicleImgIdLessThanOrEqual -  (optional)</li>
   *   <li>vehicleImgIdEquals -  (optional)</li>
   *   <li>vehicleImgIdNotEquals -  (optional)</li>
   *   <li>vehicleImgIdSpecified -  (optional)</li>
   *   <li>vehicleImgIdIn -  (optional)</li>
   *   <li>vehicleImgIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   <li>page - Zero-based page index (0..N) (optional, default to 0)</li>
   *   <li>size - The size of the page to be returned (optional, default to 20)</li>
   *   <li>sort - Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)</li>
   *   </ul>
   * @return List&lt;VehicleDTO&gt;
   */
  @RequestLine("GET /api/vehicles?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&type.equals={typeEquals}&type.notEquals={typeNotEquals}&type.specified={typeSpecified}&type.in={typeIn}&type.notIn={typeNotIn}&typeFactor.greaterThan={typeFactorGreaterThan}&typeFactor.lessThan={typeFactorLessThan}&typeFactor.greaterThanOrEqual={typeFactorGreaterThanOrEqual}&typeFactor.lessThanOrEqual={typeFactorLessThanOrEqual}&typeFactor.equals={typeFactorEquals}&typeFactor.notEquals={typeFactorNotEquals}&typeFactor.specified={typeFactorSpecified}&typeFactor.in={typeFactorIn}&typeFactor.notIn={typeFactorNotIn}&plateNumber.contains={plateNumberContains}&plateNumber.doesNotContain={plateNumberDoesNotContain}&plateNumber.equals={plateNumberEquals}&plateNumber.notEquals={plateNumberNotEquals}&plateNumber.specified={plateNumberSpecified}&plateNumber.in={plateNumberIn}&plateNumber.notIn={plateNumberNotIn}&brand.contains={brandContains}&brand.doesNotContain={brandDoesNotContain}&brand.equals={brandEquals}&brand.notEquals={brandNotEquals}&brand.specified={brandSpecified}&brand.in={brandIn}&brand.notIn={brandNotIn}&description.contains={descriptionContains}&description.doesNotContain={descriptionDoesNotContain}&description.equals={descriptionEquals}&description.notEquals={descriptionNotEquals}&description.specified={descriptionSpecified}&description.in={descriptionIn}&description.notIn={descriptionNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&seatMapId.greaterThan={seatMapIdGreaterThan}&seatMapId.lessThan={seatMapIdLessThan}&seatMapId.greaterThanOrEqual={seatMapIdGreaterThanOrEqual}&seatMapId.lessThanOrEqual={seatMapIdLessThanOrEqual}&seatMapId.equals={seatMapIdEquals}&seatMapId.notEquals={seatMapIdNotEquals}&seatMapId.specified={seatMapIdSpecified}&seatMapId.in={seatMapIdIn}&seatMapId.notIn={seatMapIdNotIn}&vehicleImgId.greaterThan={vehicleImgIdGreaterThan}&vehicleImgId.lessThan={vehicleImgIdLessThan}&vehicleImgId.greaterThanOrEqual={vehicleImgIdGreaterThanOrEqual}&vehicleImgId.lessThanOrEqual={vehicleImgIdLessThanOrEqual}&vehicleImgId.equals={vehicleImgIdEquals}&vehicleImgId.notEquals={vehicleImgIdNotEquals}&vehicleImgId.specified={vehicleImgIdSpecified}&vehicleImgId.in={vehicleImgIdIn}&vehicleImgId.notIn={vehicleImgIdNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
  @Headers({
  "Accept: */*",
  })
  List<VehicleDTO> getAllVehicles(@QueryMap(encoded=true) GetAllVehiclesQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllVehicles</code> that receives the query parameters as a map,
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
          *   <li>typeEquals -  (optional)</li>
          *   <li>typeNotEquals -  (optional)</li>
          *   <li>typeSpecified -  (optional)</li>
          *   <li>typeIn -  (optional)</li>
          *   <li>typeNotIn -  (optional)</li>
          *   <li>typeFactorGreaterThan -  (optional)</li>
          *   <li>typeFactorLessThan -  (optional)</li>
          *   <li>typeFactorGreaterThanOrEqual -  (optional)</li>
          *   <li>typeFactorLessThanOrEqual -  (optional)</li>
          *   <li>typeFactorEquals -  (optional)</li>
          *   <li>typeFactorNotEquals -  (optional)</li>
          *   <li>typeFactorSpecified -  (optional)</li>
          *   <li>typeFactorIn -  (optional)</li>
          *   <li>typeFactorNotIn -  (optional)</li>
          *   <li>plateNumberContains -  (optional)</li>
          *   <li>plateNumberDoesNotContain -  (optional)</li>
          *   <li>plateNumberEquals -  (optional)</li>
          *   <li>plateNumberNotEquals -  (optional)</li>
          *   <li>plateNumberSpecified -  (optional)</li>
          *   <li>plateNumberIn -  (optional)</li>
          *   <li>plateNumberNotIn -  (optional)</li>
          *   <li>brandContains -  (optional)</li>
          *   <li>brandDoesNotContain -  (optional)</li>
          *   <li>brandEquals -  (optional)</li>
          *   <li>brandNotEquals -  (optional)</li>
          *   <li>brandSpecified -  (optional)</li>
          *   <li>brandIn -  (optional)</li>
          *   <li>brandNotIn -  (optional)</li>
          *   <li>descriptionContains -  (optional)</li>
          *   <li>descriptionDoesNotContain -  (optional)</li>
          *   <li>descriptionEquals -  (optional)</li>
          *   <li>descriptionNotEquals -  (optional)</li>
          *   <li>descriptionSpecified -  (optional)</li>
          *   <li>descriptionIn -  (optional)</li>
          *   <li>descriptionNotIn -  (optional)</li>
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
          *   <li>seatMapIdGreaterThan -  (optional)</li>
          *   <li>seatMapIdLessThan -  (optional)</li>
          *   <li>seatMapIdGreaterThanOrEqual -  (optional)</li>
          *   <li>seatMapIdLessThanOrEqual -  (optional)</li>
          *   <li>seatMapIdEquals -  (optional)</li>
          *   <li>seatMapIdNotEquals -  (optional)</li>
          *   <li>seatMapIdSpecified -  (optional)</li>
          *   <li>seatMapIdIn -  (optional)</li>
          *   <li>seatMapIdNotIn -  (optional)</li>
          *   <li>vehicleImgIdGreaterThan -  (optional)</li>
          *   <li>vehicleImgIdLessThan -  (optional)</li>
          *   <li>vehicleImgIdGreaterThanOrEqual -  (optional)</li>
          *   <li>vehicleImgIdLessThanOrEqual -  (optional)</li>
          *   <li>vehicleImgIdEquals -  (optional)</li>
          *   <li>vehicleImgIdNotEquals -  (optional)</li>
          *   <li>vehicleImgIdSpecified -  (optional)</li>
          *   <li>vehicleImgIdIn -  (optional)</li>
          *   <li>vehicleImgIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
          *   <li>page - Zero-based page index (0..N) (optional, default to 0)</li>
          *   <li>size - The size of the page to be returned (optional, default to 20)</li>
          *   <li>sort - Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)</li>
      *   </ul>
          * @return List&lt;VehicleDTO&gt;
      */
      @RequestLine("GET /api/vehicles?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&type.equals={typeEquals}&type.notEquals={typeNotEquals}&type.specified={typeSpecified}&type.in={typeIn}&type.notIn={typeNotIn}&typeFactor.greaterThan={typeFactorGreaterThan}&typeFactor.lessThan={typeFactorLessThan}&typeFactor.greaterThanOrEqual={typeFactorGreaterThanOrEqual}&typeFactor.lessThanOrEqual={typeFactorLessThanOrEqual}&typeFactor.equals={typeFactorEquals}&typeFactor.notEquals={typeFactorNotEquals}&typeFactor.specified={typeFactorSpecified}&typeFactor.in={typeFactorIn}&typeFactor.notIn={typeFactorNotIn}&plateNumber.contains={plateNumberContains}&plateNumber.doesNotContain={plateNumberDoesNotContain}&plateNumber.equals={plateNumberEquals}&plateNumber.notEquals={plateNumberNotEquals}&plateNumber.specified={plateNumberSpecified}&plateNumber.in={plateNumberIn}&plateNumber.notIn={plateNumberNotIn}&brand.contains={brandContains}&brand.doesNotContain={brandDoesNotContain}&brand.equals={brandEquals}&brand.notEquals={brandNotEquals}&brand.specified={brandSpecified}&brand.in={brandIn}&brand.notIn={brandNotIn}&description.contains={descriptionContains}&description.doesNotContain={descriptionDoesNotContain}&description.equals={descriptionEquals}&description.notEquals={descriptionNotEquals}&description.specified={descriptionSpecified}&description.in={descriptionIn}&description.notIn={descriptionNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&seatMapId.greaterThan={seatMapIdGreaterThan}&seatMapId.lessThan={seatMapIdLessThan}&seatMapId.greaterThanOrEqual={seatMapIdGreaterThanOrEqual}&seatMapId.lessThanOrEqual={seatMapIdLessThanOrEqual}&seatMapId.equals={seatMapIdEquals}&seatMapId.notEquals={seatMapIdNotEquals}&seatMapId.specified={seatMapIdSpecified}&seatMapId.in={seatMapIdIn}&seatMapId.notIn={seatMapIdNotIn}&vehicleImgId.greaterThan={vehicleImgIdGreaterThan}&vehicleImgId.lessThan={vehicleImgIdLessThan}&vehicleImgId.greaterThanOrEqual={vehicleImgIdGreaterThanOrEqual}&vehicleImgId.lessThanOrEqual={vehicleImgIdLessThanOrEqual}&vehicleImgId.equals={vehicleImgIdEquals}&vehicleImgId.notEquals={vehicleImgIdNotEquals}&vehicleImgId.specified={vehicleImgIdSpecified}&vehicleImgId.in={vehicleImgIdIn}&vehicleImgId.notIn={vehicleImgIdNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<VehicleDTO>> getAllVehiclesWithHttpInfo(@QueryMap(encoded=true) GetAllVehiclesQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllVehicles</code> method in a fluent style.
   */
  public static class GetAllVehiclesQueryParams extends HashMap<String, Object> {
    public GetAllVehiclesQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesQueryParams typeEquals(@jakarta.annotation.Nullable final String value) {
      put("type.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams typeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("type.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams typeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("type.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams typeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("type.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesQueryParams typeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("type.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesQueryParams typeFactorGreaterThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("typeFactor.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams typeFactorLessThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("typeFactor.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams typeFactorGreaterThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("typeFactor.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams typeFactorLessThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("typeFactor.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams typeFactorEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("typeFactor.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams typeFactorNotEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("typeFactor.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams typeFactorSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("typeFactor.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams typeFactorIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("typeFactor.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesQueryParams typeFactorNotIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("typeFactor.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesQueryParams plateNumberContains(@jakarta.annotation.Nullable final String value) {
      put("plateNumber.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams plateNumberDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("plateNumber.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams plateNumberEquals(@jakarta.annotation.Nullable final String value) {
      put("plateNumber.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams plateNumberNotEquals(@jakarta.annotation.Nullable final String value) {
      put("plateNumber.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams plateNumberSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("plateNumber.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams plateNumberIn(@jakarta.annotation.Nullable final List<String> value) {
      put("plateNumber.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesQueryParams plateNumberNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("plateNumber.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesQueryParams brandContains(@jakarta.annotation.Nullable final String value) {
      put("brand.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams brandDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("brand.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams brandEquals(@jakarta.annotation.Nullable final String value) {
      put("brand.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams brandNotEquals(@jakarta.annotation.Nullable final String value) {
      put("brand.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams brandSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("brand.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams brandIn(@jakarta.annotation.Nullable final List<String> value) {
      put("brand.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesQueryParams brandNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("brand.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesQueryParams descriptionContains(@jakarta.annotation.Nullable final String value) {
      put("description.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams descriptionDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("description.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams descriptionEquals(@jakarta.annotation.Nullable final String value) {
      put("description.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams descriptionNotEquals(@jakarta.annotation.Nullable final String value) {
      put("description.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams descriptionSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("description.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams descriptionIn(@jakarta.annotation.Nullable final List<String> value) {
      put("description.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesQueryParams descriptionNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("description.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesQueryParams statusEquals(@jakarta.annotation.Nullable final String value) {
      put("status.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams statusNotEquals(@jakarta.annotation.Nullable final String value) {
      put("status.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams statusSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("status.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams statusIn(@jakarta.annotation.Nullable final List<String> value) {
      put("status.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesQueryParams statusNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("status.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesQueryParams seatMapIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams seatMapIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams seatMapIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams seatMapIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams seatMapIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams seatMapIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams seatMapIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("seatMapId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams seatMapIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("seatMapId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesQueryParams seatMapIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("seatMapId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesQueryParams vehicleImgIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("vehicleImgId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams vehicleImgIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("vehicleImgId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams vehicleImgIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("vehicleImgId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams vehicleImgIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("vehicleImgId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams vehicleImgIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("vehicleImgId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams vehicleImgIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("vehicleImgId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams vehicleImgIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("vehicleImgId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams vehicleImgIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("vehicleImgId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesQueryParams vehicleImgIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("vehicleImgId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams page(@jakarta.annotation.Nullable final Integer value) {
      put("page", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams size(@jakarta.annotation.Nullable final Integer value) {
      put("size", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesQueryParams sort(@jakarta.annotation.Nullable final List<String> value) {
      put("sort", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
  }

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
   * @param typeEquals  (optional)
   * @param typeNotEquals  (optional)
   * @param typeSpecified  (optional)
   * @param typeIn  (optional)
   * @param typeNotIn  (optional)
   * @param typeFactorGreaterThan  (optional)
   * @param typeFactorLessThan  (optional)
   * @param typeFactorGreaterThanOrEqual  (optional)
   * @param typeFactorLessThanOrEqual  (optional)
   * @param typeFactorEquals  (optional)
   * @param typeFactorNotEquals  (optional)
   * @param typeFactorSpecified  (optional)
   * @param typeFactorIn  (optional)
   * @param typeFactorNotIn  (optional)
   * @param plateNumberContains  (optional)
   * @param plateNumberDoesNotContain  (optional)
   * @param plateNumberEquals  (optional)
   * @param plateNumberNotEquals  (optional)
   * @param plateNumberSpecified  (optional)
   * @param plateNumberIn  (optional)
   * @param plateNumberNotIn  (optional)
   * @param brandContains  (optional)
   * @param brandDoesNotContain  (optional)
   * @param brandEquals  (optional)
   * @param brandNotEquals  (optional)
   * @param brandSpecified  (optional)
   * @param brandIn  (optional)
   * @param brandNotIn  (optional)
   * @param descriptionContains  (optional)
   * @param descriptionDoesNotContain  (optional)
   * @param descriptionEquals  (optional)
   * @param descriptionNotEquals  (optional)
   * @param descriptionSpecified  (optional)
   * @param descriptionIn  (optional)
   * @param descriptionNotIn  (optional)
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
   * @param seatMapIdGreaterThan  (optional)
   * @param seatMapIdLessThan  (optional)
   * @param seatMapIdGreaterThanOrEqual  (optional)
   * @param seatMapIdLessThanOrEqual  (optional)
   * @param seatMapIdEquals  (optional)
   * @param seatMapIdNotEquals  (optional)
   * @param seatMapIdSpecified  (optional)
   * @param seatMapIdIn  (optional)
   * @param seatMapIdNotIn  (optional)
   * @param vehicleImgIdGreaterThan  (optional)
   * @param vehicleImgIdLessThan  (optional)
   * @param vehicleImgIdGreaterThanOrEqual  (optional)
   * @param vehicleImgIdLessThanOrEqual  (optional)
   * @param vehicleImgIdEquals  (optional)
   * @param vehicleImgIdNotEquals  (optional)
   * @param vehicleImgIdSpecified  (optional)
   * @param vehicleImgIdIn  (optional)
   * @param vehicleImgIdNotIn  (optional)
   * @param distinct  (optional)
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return List&lt;VehicleWithSeatCountVM&gt;
   */
  @RequestLine("GET /api/vehicles/with-seats-count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&type.equals={typeEquals}&type.notEquals={typeNotEquals}&type.specified={typeSpecified}&type.in={typeIn}&type.notIn={typeNotIn}&typeFactor.greaterThan={typeFactorGreaterThan}&typeFactor.lessThan={typeFactorLessThan}&typeFactor.greaterThanOrEqual={typeFactorGreaterThanOrEqual}&typeFactor.lessThanOrEqual={typeFactorLessThanOrEqual}&typeFactor.equals={typeFactorEquals}&typeFactor.notEquals={typeFactorNotEquals}&typeFactor.specified={typeFactorSpecified}&typeFactor.in={typeFactorIn}&typeFactor.notIn={typeFactorNotIn}&plateNumber.contains={plateNumberContains}&plateNumber.doesNotContain={plateNumberDoesNotContain}&plateNumber.equals={plateNumberEquals}&plateNumber.notEquals={plateNumberNotEquals}&plateNumber.specified={plateNumberSpecified}&plateNumber.in={plateNumberIn}&plateNumber.notIn={plateNumberNotIn}&brand.contains={brandContains}&brand.doesNotContain={brandDoesNotContain}&brand.equals={brandEquals}&brand.notEquals={brandNotEquals}&brand.specified={brandSpecified}&brand.in={brandIn}&brand.notIn={brandNotIn}&description.contains={descriptionContains}&description.doesNotContain={descriptionDoesNotContain}&description.equals={descriptionEquals}&description.notEquals={descriptionNotEquals}&description.specified={descriptionSpecified}&description.in={descriptionIn}&description.notIn={descriptionNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&seatMapId.greaterThan={seatMapIdGreaterThan}&seatMapId.lessThan={seatMapIdLessThan}&seatMapId.greaterThanOrEqual={seatMapIdGreaterThanOrEqual}&seatMapId.lessThanOrEqual={seatMapIdLessThanOrEqual}&seatMapId.equals={seatMapIdEquals}&seatMapId.notEquals={seatMapIdNotEquals}&seatMapId.specified={seatMapIdSpecified}&seatMapId.in={seatMapIdIn}&seatMapId.notIn={seatMapIdNotIn}&vehicleImgId.greaterThan={vehicleImgIdGreaterThan}&vehicleImgId.lessThan={vehicleImgIdLessThan}&vehicleImgId.greaterThanOrEqual={vehicleImgIdGreaterThanOrEqual}&vehicleImgId.lessThanOrEqual={vehicleImgIdLessThanOrEqual}&vehicleImgId.equals={vehicleImgIdEquals}&vehicleImgId.notEquals={vehicleImgIdNotEquals}&vehicleImgId.specified={vehicleImgIdSpecified}&vehicleImgId.in={vehicleImgIdIn}&vehicleImgId.notIn={vehicleImgIdNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",
  })
  List<VehicleWithSeatCountVM> getAllVehiclesWithSeatsCount(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("typeEquals") @jakarta.annotation.Nullable String typeEquals, @Param("typeNotEquals") @jakarta.annotation.Nullable String typeNotEquals, @Param("typeSpecified") @jakarta.annotation.Nullable Boolean typeSpecified, @Param("typeIn") @jakarta.annotation.Nullable List<String> typeIn, @Param("typeNotIn") @jakarta.annotation.Nullable List<String> typeNotIn, @Param("typeFactorGreaterThan") @jakarta.annotation.Nullable BigDecimal typeFactorGreaterThan, @Param("typeFactorLessThan") @jakarta.annotation.Nullable BigDecimal typeFactorLessThan, @Param("typeFactorGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal typeFactorGreaterThanOrEqual, @Param("typeFactorLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal typeFactorLessThanOrEqual, @Param("typeFactorEquals") @jakarta.annotation.Nullable BigDecimal typeFactorEquals, @Param("typeFactorNotEquals") @jakarta.annotation.Nullable BigDecimal typeFactorNotEquals, @Param("typeFactorSpecified") @jakarta.annotation.Nullable Boolean typeFactorSpecified, @Param("typeFactorIn") @jakarta.annotation.Nullable List<BigDecimal> typeFactorIn, @Param("typeFactorNotIn") @jakarta.annotation.Nullable List<BigDecimal> typeFactorNotIn, @Param("plateNumberContains") @jakarta.annotation.Nullable String plateNumberContains, @Param("plateNumberDoesNotContain") @jakarta.annotation.Nullable String plateNumberDoesNotContain, @Param("plateNumberEquals") @jakarta.annotation.Nullable String plateNumberEquals, @Param("plateNumberNotEquals") @jakarta.annotation.Nullable String plateNumberNotEquals, @Param("plateNumberSpecified") @jakarta.annotation.Nullable Boolean plateNumberSpecified, @Param("plateNumberIn") @jakarta.annotation.Nullable List<String> plateNumberIn, @Param("plateNumberNotIn") @jakarta.annotation.Nullable List<String> plateNumberNotIn, @Param("brandContains") @jakarta.annotation.Nullable String brandContains, @Param("brandDoesNotContain") @jakarta.annotation.Nullable String brandDoesNotContain, @Param("brandEquals") @jakarta.annotation.Nullable String brandEquals, @Param("brandNotEquals") @jakarta.annotation.Nullable String brandNotEquals, @Param("brandSpecified") @jakarta.annotation.Nullable Boolean brandSpecified, @Param("brandIn") @jakarta.annotation.Nullable List<String> brandIn, @Param("brandNotIn") @jakarta.annotation.Nullable List<String> brandNotIn, @Param("descriptionContains") @jakarta.annotation.Nullable String descriptionContains, @Param("descriptionDoesNotContain") @jakarta.annotation.Nullable String descriptionDoesNotContain, @Param("descriptionEquals") @jakarta.annotation.Nullable String descriptionEquals, @Param("descriptionNotEquals") @jakarta.annotation.Nullable String descriptionNotEquals, @Param("descriptionSpecified") @jakarta.annotation.Nullable Boolean descriptionSpecified, @Param("descriptionIn") @jakarta.annotation.Nullable List<String> descriptionIn, @Param("descriptionNotIn") @jakarta.annotation.Nullable List<String> descriptionNotIn, @Param("statusEquals") @jakarta.annotation.Nullable String statusEquals, @Param("statusNotEquals") @jakarta.annotation.Nullable String statusNotEquals, @Param("statusSpecified") @jakarta.annotation.Nullable Boolean statusSpecified, @Param("statusIn") @jakarta.annotation.Nullable List<String> statusIn, @Param("statusNotIn") @jakarta.annotation.Nullable List<String> statusNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("seatMapIdGreaterThan") @jakarta.annotation.Nullable Long seatMapIdGreaterThan, @Param("seatMapIdLessThan") @jakarta.annotation.Nullable Long seatMapIdLessThan, @Param("seatMapIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long seatMapIdGreaterThanOrEqual, @Param("seatMapIdLessThanOrEqual") @jakarta.annotation.Nullable Long seatMapIdLessThanOrEqual, @Param("seatMapIdEquals") @jakarta.annotation.Nullable Long seatMapIdEquals, @Param("seatMapIdNotEquals") @jakarta.annotation.Nullable Long seatMapIdNotEquals, @Param("seatMapIdSpecified") @jakarta.annotation.Nullable Boolean seatMapIdSpecified, @Param("seatMapIdIn") @jakarta.annotation.Nullable List<Long> seatMapIdIn, @Param("seatMapIdNotIn") @jakarta.annotation.Nullable List<Long> seatMapIdNotIn, @Param("vehicleImgIdGreaterThan") @jakarta.annotation.Nullable Long vehicleImgIdGreaterThan, @Param("vehicleImgIdLessThan") @jakarta.annotation.Nullable Long vehicleImgIdLessThan, @Param("vehicleImgIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long vehicleImgIdGreaterThanOrEqual, @Param("vehicleImgIdLessThanOrEqual") @jakarta.annotation.Nullable Long vehicleImgIdLessThanOrEqual, @Param("vehicleImgIdEquals") @jakarta.annotation.Nullable Long vehicleImgIdEquals, @Param("vehicleImgIdNotEquals") @jakarta.annotation.Nullable Long vehicleImgIdNotEquals, @Param("vehicleImgIdSpecified") @jakarta.annotation.Nullable Boolean vehicleImgIdSpecified, @Param("vehicleImgIdIn") @jakarta.annotation.Nullable List<Long> vehicleImgIdIn, @Param("vehicleImgIdNotIn") @jakarta.annotation.Nullable List<Long> vehicleImgIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct, @Param("page") @jakarta.annotation.Nullable Integer page, @Param("size") @jakarta.annotation.Nullable Integer size, @Param("sort") @jakarta.annotation.Nullable List<String> sort);

  /**
   * 
   * Similar to <code>getAllVehiclesWithSeatsCount</code> but it also returns the http response headers .
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
   * @param typeEquals  (optional)
   * @param typeNotEquals  (optional)
   * @param typeSpecified  (optional)
   * @param typeIn  (optional)
   * @param typeNotIn  (optional)
   * @param typeFactorGreaterThan  (optional)
   * @param typeFactorLessThan  (optional)
   * @param typeFactorGreaterThanOrEqual  (optional)
   * @param typeFactorLessThanOrEqual  (optional)
   * @param typeFactorEquals  (optional)
   * @param typeFactorNotEquals  (optional)
   * @param typeFactorSpecified  (optional)
   * @param typeFactorIn  (optional)
   * @param typeFactorNotIn  (optional)
   * @param plateNumberContains  (optional)
   * @param plateNumberDoesNotContain  (optional)
   * @param plateNumberEquals  (optional)
   * @param plateNumberNotEquals  (optional)
   * @param plateNumberSpecified  (optional)
   * @param plateNumberIn  (optional)
   * @param plateNumberNotIn  (optional)
   * @param brandContains  (optional)
   * @param brandDoesNotContain  (optional)
   * @param brandEquals  (optional)
   * @param brandNotEquals  (optional)
   * @param brandSpecified  (optional)
   * @param brandIn  (optional)
   * @param brandNotIn  (optional)
   * @param descriptionContains  (optional)
   * @param descriptionDoesNotContain  (optional)
   * @param descriptionEquals  (optional)
   * @param descriptionNotEquals  (optional)
   * @param descriptionSpecified  (optional)
   * @param descriptionIn  (optional)
   * @param descriptionNotIn  (optional)
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
   * @param seatMapIdGreaterThan  (optional)
   * @param seatMapIdLessThan  (optional)
   * @param seatMapIdGreaterThanOrEqual  (optional)
   * @param seatMapIdLessThanOrEqual  (optional)
   * @param seatMapIdEquals  (optional)
   * @param seatMapIdNotEquals  (optional)
   * @param seatMapIdSpecified  (optional)
   * @param seatMapIdIn  (optional)
   * @param seatMapIdNotIn  (optional)
   * @param vehicleImgIdGreaterThan  (optional)
   * @param vehicleImgIdLessThan  (optional)
   * @param vehicleImgIdGreaterThanOrEqual  (optional)
   * @param vehicleImgIdLessThanOrEqual  (optional)
   * @param vehicleImgIdEquals  (optional)
   * @param vehicleImgIdNotEquals  (optional)
   * @param vehicleImgIdSpecified  (optional)
   * @param vehicleImgIdIn  (optional)
   * @param vehicleImgIdNotIn  (optional)
   * @param distinct  (optional)
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/vehicles/with-seats-count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&type.equals={typeEquals}&type.notEquals={typeNotEquals}&type.specified={typeSpecified}&type.in={typeIn}&type.notIn={typeNotIn}&typeFactor.greaterThan={typeFactorGreaterThan}&typeFactor.lessThan={typeFactorLessThan}&typeFactor.greaterThanOrEqual={typeFactorGreaterThanOrEqual}&typeFactor.lessThanOrEqual={typeFactorLessThanOrEqual}&typeFactor.equals={typeFactorEquals}&typeFactor.notEquals={typeFactorNotEquals}&typeFactor.specified={typeFactorSpecified}&typeFactor.in={typeFactorIn}&typeFactor.notIn={typeFactorNotIn}&plateNumber.contains={plateNumberContains}&plateNumber.doesNotContain={plateNumberDoesNotContain}&plateNumber.equals={plateNumberEquals}&plateNumber.notEquals={plateNumberNotEquals}&plateNumber.specified={plateNumberSpecified}&plateNumber.in={plateNumberIn}&plateNumber.notIn={plateNumberNotIn}&brand.contains={brandContains}&brand.doesNotContain={brandDoesNotContain}&brand.equals={brandEquals}&brand.notEquals={brandNotEquals}&brand.specified={brandSpecified}&brand.in={brandIn}&brand.notIn={brandNotIn}&description.contains={descriptionContains}&description.doesNotContain={descriptionDoesNotContain}&description.equals={descriptionEquals}&description.notEquals={descriptionNotEquals}&description.specified={descriptionSpecified}&description.in={descriptionIn}&description.notIn={descriptionNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&seatMapId.greaterThan={seatMapIdGreaterThan}&seatMapId.lessThan={seatMapIdLessThan}&seatMapId.greaterThanOrEqual={seatMapIdGreaterThanOrEqual}&seatMapId.lessThanOrEqual={seatMapIdLessThanOrEqual}&seatMapId.equals={seatMapIdEquals}&seatMapId.notEquals={seatMapIdNotEquals}&seatMapId.specified={seatMapIdSpecified}&seatMapId.in={seatMapIdIn}&seatMapId.notIn={seatMapIdNotIn}&vehicleImgId.greaterThan={vehicleImgIdGreaterThan}&vehicleImgId.lessThan={vehicleImgIdLessThan}&vehicleImgId.greaterThanOrEqual={vehicleImgIdGreaterThanOrEqual}&vehicleImgId.lessThanOrEqual={vehicleImgIdLessThanOrEqual}&vehicleImgId.equals={vehicleImgIdEquals}&vehicleImgId.notEquals={vehicleImgIdNotEquals}&vehicleImgId.specified={vehicleImgIdSpecified}&vehicleImgId.in={vehicleImgIdIn}&vehicleImgId.notIn={vehicleImgIdNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<VehicleWithSeatCountVM>> getAllVehiclesWithSeatsCountWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("typeEquals") @jakarta.annotation.Nullable String typeEquals, @Param("typeNotEquals") @jakarta.annotation.Nullable String typeNotEquals, @Param("typeSpecified") @jakarta.annotation.Nullable Boolean typeSpecified, @Param("typeIn") @jakarta.annotation.Nullable List<String> typeIn, @Param("typeNotIn") @jakarta.annotation.Nullable List<String> typeNotIn, @Param("typeFactorGreaterThan") @jakarta.annotation.Nullable BigDecimal typeFactorGreaterThan, @Param("typeFactorLessThan") @jakarta.annotation.Nullable BigDecimal typeFactorLessThan, @Param("typeFactorGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal typeFactorGreaterThanOrEqual, @Param("typeFactorLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal typeFactorLessThanOrEqual, @Param("typeFactorEquals") @jakarta.annotation.Nullable BigDecimal typeFactorEquals, @Param("typeFactorNotEquals") @jakarta.annotation.Nullable BigDecimal typeFactorNotEquals, @Param("typeFactorSpecified") @jakarta.annotation.Nullable Boolean typeFactorSpecified, @Param("typeFactorIn") @jakarta.annotation.Nullable List<BigDecimal> typeFactorIn, @Param("typeFactorNotIn") @jakarta.annotation.Nullable List<BigDecimal> typeFactorNotIn, @Param("plateNumberContains") @jakarta.annotation.Nullable String plateNumberContains, @Param("plateNumberDoesNotContain") @jakarta.annotation.Nullable String plateNumberDoesNotContain, @Param("plateNumberEquals") @jakarta.annotation.Nullable String plateNumberEquals, @Param("plateNumberNotEquals") @jakarta.annotation.Nullable String plateNumberNotEquals, @Param("plateNumberSpecified") @jakarta.annotation.Nullable Boolean plateNumberSpecified, @Param("plateNumberIn") @jakarta.annotation.Nullable List<String> plateNumberIn, @Param("plateNumberNotIn") @jakarta.annotation.Nullable List<String> plateNumberNotIn, @Param("brandContains") @jakarta.annotation.Nullable String brandContains, @Param("brandDoesNotContain") @jakarta.annotation.Nullable String brandDoesNotContain, @Param("brandEquals") @jakarta.annotation.Nullable String brandEquals, @Param("brandNotEquals") @jakarta.annotation.Nullable String brandNotEquals, @Param("brandSpecified") @jakarta.annotation.Nullable Boolean brandSpecified, @Param("brandIn") @jakarta.annotation.Nullable List<String> brandIn, @Param("brandNotIn") @jakarta.annotation.Nullable List<String> brandNotIn, @Param("descriptionContains") @jakarta.annotation.Nullable String descriptionContains, @Param("descriptionDoesNotContain") @jakarta.annotation.Nullable String descriptionDoesNotContain, @Param("descriptionEquals") @jakarta.annotation.Nullable String descriptionEquals, @Param("descriptionNotEquals") @jakarta.annotation.Nullable String descriptionNotEquals, @Param("descriptionSpecified") @jakarta.annotation.Nullable Boolean descriptionSpecified, @Param("descriptionIn") @jakarta.annotation.Nullable List<String> descriptionIn, @Param("descriptionNotIn") @jakarta.annotation.Nullable List<String> descriptionNotIn, @Param("statusEquals") @jakarta.annotation.Nullable String statusEquals, @Param("statusNotEquals") @jakarta.annotation.Nullable String statusNotEquals, @Param("statusSpecified") @jakarta.annotation.Nullable Boolean statusSpecified, @Param("statusIn") @jakarta.annotation.Nullable List<String> statusIn, @Param("statusNotIn") @jakarta.annotation.Nullable List<String> statusNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("seatMapIdGreaterThan") @jakarta.annotation.Nullable Long seatMapIdGreaterThan, @Param("seatMapIdLessThan") @jakarta.annotation.Nullable Long seatMapIdLessThan, @Param("seatMapIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long seatMapIdGreaterThanOrEqual, @Param("seatMapIdLessThanOrEqual") @jakarta.annotation.Nullable Long seatMapIdLessThanOrEqual, @Param("seatMapIdEquals") @jakarta.annotation.Nullable Long seatMapIdEquals, @Param("seatMapIdNotEquals") @jakarta.annotation.Nullable Long seatMapIdNotEquals, @Param("seatMapIdSpecified") @jakarta.annotation.Nullable Boolean seatMapIdSpecified, @Param("seatMapIdIn") @jakarta.annotation.Nullable List<Long> seatMapIdIn, @Param("seatMapIdNotIn") @jakarta.annotation.Nullable List<Long> seatMapIdNotIn, @Param("vehicleImgIdGreaterThan") @jakarta.annotation.Nullable Long vehicleImgIdGreaterThan, @Param("vehicleImgIdLessThan") @jakarta.annotation.Nullable Long vehicleImgIdLessThan, @Param("vehicleImgIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long vehicleImgIdGreaterThanOrEqual, @Param("vehicleImgIdLessThanOrEqual") @jakarta.annotation.Nullable Long vehicleImgIdLessThanOrEqual, @Param("vehicleImgIdEquals") @jakarta.annotation.Nullable Long vehicleImgIdEquals, @Param("vehicleImgIdNotEquals") @jakarta.annotation.Nullable Long vehicleImgIdNotEquals, @Param("vehicleImgIdSpecified") @jakarta.annotation.Nullable Boolean vehicleImgIdSpecified, @Param("vehicleImgIdIn") @jakarta.annotation.Nullable List<Long> vehicleImgIdIn, @Param("vehicleImgIdNotIn") @jakarta.annotation.Nullable List<Long> vehicleImgIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct, @Param("page") @jakarta.annotation.Nullable Integer page, @Param("size") @jakarta.annotation.Nullable Integer size, @Param("sort") @jakarta.annotation.Nullable List<String> sort);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllVehiclesWithSeatsCount</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllVehiclesWithSeatsCountQueryParams} class that allows for
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
   *   <li>typeEquals -  (optional)</li>
   *   <li>typeNotEquals -  (optional)</li>
   *   <li>typeSpecified -  (optional)</li>
   *   <li>typeIn -  (optional)</li>
   *   <li>typeNotIn -  (optional)</li>
   *   <li>typeFactorGreaterThan -  (optional)</li>
   *   <li>typeFactorLessThan -  (optional)</li>
   *   <li>typeFactorGreaterThanOrEqual -  (optional)</li>
   *   <li>typeFactorLessThanOrEqual -  (optional)</li>
   *   <li>typeFactorEquals -  (optional)</li>
   *   <li>typeFactorNotEquals -  (optional)</li>
   *   <li>typeFactorSpecified -  (optional)</li>
   *   <li>typeFactorIn -  (optional)</li>
   *   <li>typeFactorNotIn -  (optional)</li>
   *   <li>plateNumberContains -  (optional)</li>
   *   <li>plateNumberDoesNotContain -  (optional)</li>
   *   <li>plateNumberEquals -  (optional)</li>
   *   <li>plateNumberNotEquals -  (optional)</li>
   *   <li>plateNumberSpecified -  (optional)</li>
   *   <li>plateNumberIn -  (optional)</li>
   *   <li>plateNumberNotIn -  (optional)</li>
   *   <li>brandContains -  (optional)</li>
   *   <li>brandDoesNotContain -  (optional)</li>
   *   <li>brandEquals -  (optional)</li>
   *   <li>brandNotEquals -  (optional)</li>
   *   <li>brandSpecified -  (optional)</li>
   *   <li>brandIn -  (optional)</li>
   *   <li>brandNotIn -  (optional)</li>
   *   <li>descriptionContains -  (optional)</li>
   *   <li>descriptionDoesNotContain -  (optional)</li>
   *   <li>descriptionEquals -  (optional)</li>
   *   <li>descriptionNotEquals -  (optional)</li>
   *   <li>descriptionSpecified -  (optional)</li>
   *   <li>descriptionIn -  (optional)</li>
   *   <li>descriptionNotIn -  (optional)</li>
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
   *   <li>seatMapIdGreaterThan -  (optional)</li>
   *   <li>seatMapIdLessThan -  (optional)</li>
   *   <li>seatMapIdGreaterThanOrEqual -  (optional)</li>
   *   <li>seatMapIdLessThanOrEqual -  (optional)</li>
   *   <li>seatMapIdEquals -  (optional)</li>
   *   <li>seatMapIdNotEquals -  (optional)</li>
   *   <li>seatMapIdSpecified -  (optional)</li>
   *   <li>seatMapIdIn -  (optional)</li>
   *   <li>seatMapIdNotIn -  (optional)</li>
   *   <li>vehicleImgIdGreaterThan -  (optional)</li>
   *   <li>vehicleImgIdLessThan -  (optional)</li>
   *   <li>vehicleImgIdGreaterThanOrEqual -  (optional)</li>
   *   <li>vehicleImgIdLessThanOrEqual -  (optional)</li>
   *   <li>vehicleImgIdEquals -  (optional)</li>
   *   <li>vehicleImgIdNotEquals -  (optional)</li>
   *   <li>vehicleImgIdSpecified -  (optional)</li>
   *   <li>vehicleImgIdIn -  (optional)</li>
   *   <li>vehicleImgIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   <li>page - Zero-based page index (0..N) (optional, default to 0)</li>
   *   <li>size - The size of the page to be returned (optional, default to 20)</li>
   *   <li>sort - Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)</li>
   *   </ul>
   * @return List&lt;VehicleWithSeatCountVM&gt;
   */
  @RequestLine("GET /api/vehicles/with-seats-count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&type.equals={typeEquals}&type.notEquals={typeNotEquals}&type.specified={typeSpecified}&type.in={typeIn}&type.notIn={typeNotIn}&typeFactor.greaterThan={typeFactorGreaterThan}&typeFactor.lessThan={typeFactorLessThan}&typeFactor.greaterThanOrEqual={typeFactorGreaterThanOrEqual}&typeFactor.lessThanOrEqual={typeFactorLessThanOrEqual}&typeFactor.equals={typeFactorEquals}&typeFactor.notEquals={typeFactorNotEquals}&typeFactor.specified={typeFactorSpecified}&typeFactor.in={typeFactorIn}&typeFactor.notIn={typeFactorNotIn}&plateNumber.contains={plateNumberContains}&plateNumber.doesNotContain={plateNumberDoesNotContain}&plateNumber.equals={plateNumberEquals}&plateNumber.notEquals={plateNumberNotEquals}&plateNumber.specified={plateNumberSpecified}&plateNumber.in={plateNumberIn}&plateNumber.notIn={plateNumberNotIn}&brand.contains={brandContains}&brand.doesNotContain={brandDoesNotContain}&brand.equals={brandEquals}&brand.notEquals={brandNotEquals}&brand.specified={brandSpecified}&brand.in={brandIn}&brand.notIn={brandNotIn}&description.contains={descriptionContains}&description.doesNotContain={descriptionDoesNotContain}&description.equals={descriptionEquals}&description.notEquals={descriptionNotEquals}&description.specified={descriptionSpecified}&description.in={descriptionIn}&description.notIn={descriptionNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&seatMapId.greaterThan={seatMapIdGreaterThan}&seatMapId.lessThan={seatMapIdLessThan}&seatMapId.greaterThanOrEqual={seatMapIdGreaterThanOrEqual}&seatMapId.lessThanOrEqual={seatMapIdLessThanOrEqual}&seatMapId.equals={seatMapIdEquals}&seatMapId.notEquals={seatMapIdNotEquals}&seatMapId.specified={seatMapIdSpecified}&seatMapId.in={seatMapIdIn}&seatMapId.notIn={seatMapIdNotIn}&vehicleImgId.greaterThan={vehicleImgIdGreaterThan}&vehicleImgId.lessThan={vehicleImgIdLessThan}&vehicleImgId.greaterThanOrEqual={vehicleImgIdGreaterThanOrEqual}&vehicleImgId.lessThanOrEqual={vehicleImgIdLessThanOrEqual}&vehicleImgId.equals={vehicleImgIdEquals}&vehicleImgId.notEquals={vehicleImgIdNotEquals}&vehicleImgId.specified={vehicleImgIdSpecified}&vehicleImgId.in={vehicleImgIdIn}&vehicleImgId.notIn={vehicleImgIdNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
  @Headers({
  "Accept: */*",
  })
  List<VehicleWithSeatCountVM> getAllVehiclesWithSeatsCount(@QueryMap(encoded=true) GetAllVehiclesWithSeatsCountQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllVehiclesWithSeatsCount</code> that receives the query parameters as a map,
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
          *   <li>typeEquals -  (optional)</li>
          *   <li>typeNotEquals -  (optional)</li>
          *   <li>typeSpecified -  (optional)</li>
          *   <li>typeIn -  (optional)</li>
          *   <li>typeNotIn -  (optional)</li>
          *   <li>typeFactorGreaterThan -  (optional)</li>
          *   <li>typeFactorLessThan -  (optional)</li>
          *   <li>typeFactorGreaterThanOrEqual -  (optional)</li>
          *   <li>typeFactorLessThanOrEqual -  (optional)</li>
          *   <li>typeFactorEquals -  (optional)</li>
          *   <li>typeFactorNotEquals -  (optional)</li>
          *   <li>typeFactorSpecified -  (optional)</li>
          *   <li>typeFactorIn -  (optional)</li>
          *   <li>typeFactorNotIn -  (optional)</li>
          *   <li>plateNumberContains -  (optional)</li>
          *   <li>plateNumberDoesNotContain -  (optional)</li>
          *   <li>plateNumberEquals -  (optional)</li>
          *   <li>plateNumberNotEquals -  (optional)</li>
          *   <li>plateNumberSpecified -  (optional)</li>
          *   <li>plateNumberIn -  (optional)</li>
          *   <li>plateNumberNotIn -  (optional)</li>
          *   <li>brandContains -  (optional)</li>
          *   <li>brandDoesNotContain -  (optional)</li>
          *   <li>brandEquals -  (optional)</li>
          *   <li>brandNotEquals -  (optional)</li>
          *   <li>brandSpecified -  (optional)</li>
          *   <li>brandIn -  (optional)</li>
          *   <li>brandNotIn -  (optional)</li>
          *   <li>descriptionContains -  (optional)</li>
          *   <li>descriptionDoesNotContain -  (optional)</li>
          *   <li>descriptionEquals -  (optional)</li>
          *   <li>descriptionNotEquals -  (optional)</li>
          *   <li>descriptionSpecified -  (optional)</li>
          *   <li>descriptionIn -  (optional)</li>
          *   <li>descriptionNotIn -  (optional)</li>
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
          *   <li>seatMapIdGreaterThan -  (optional)</li>
          *   <li>seatMapIdLessThan -  (optional)</li>
          *   <li>seatMapIdGreaterThanOrEqual -  (optional)</li>
          *   <li>seatMapIdLessThanOrEqual -  (optional)</li>
          *   <li>seatMapIdEquals -  (optional)</li>
          *   <li>seatMapIdNotEquals -  (optional)</li>
          *   <li>seatMapIdSpecified -  (optional)</li>
          *   <li>seatMapIdIn -  (optional)</li>
          *   <li>seatMapIdNotIn -  (optional)</li>
          *   <li>vehicleImgIdGreaterThan -  (optional)</li>
          *   <li>vehicleImgIdLessThan -  (optional)</li>
          *   <li>vehicleImgIdGreaterThanOrEqual -  (optional)</li>
          *   <li>vehicleImgIdLessThanOrEqual -  (optional)</li>
          *   <li>vehicleImgIdEquals -  (optional)</li>
          *   <li>vehicleImgIdNotEquals -  (optional)</li>
          *   <li>vehicleImgIdSpecified -  (optional)</li>
          *   <li>vehicleImgIdIn -  (optional)</li>
          *   <li>vehicleImgIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
          *   <li>page - Zero-based page index (0..N) (optional, default to 0)</li>
          *   <li>size - The size of the page to be returned (optional, default to 20)</li>
          *   <li>sort - Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)</li>
      *   </ul>
          * @return List&lt;VehicleWithSeatCountVM&gt;
      */
      @RequestLine("GET /api/vehicles/with-seats-count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&type.equals={typeEquals}&type.notEquals={typeNotEquals}&type.specified={typeSpecified}&type.in={typeIn}&type.notIn={typeNotIn}&typeFactor.greaterThan={typeFactorGreaterThan}&typeFactor.lessThan={typeFactorLessThan}&typeFactor.greaterThanOrEqual={typeFactorGreaterThanOrEqual}&typeFactor.lessThanOrEqual={typeFactorLessThanOrEqual}&typeFactor.equals={typeFactorEquals}&typeFactor.notEquals={typeFactorNotEquals}&typeFactor.specified={typeFactorSpecified}&typeFactor.in={typeFactorIn}&typeFactor.notIn={typeFactorNotIn}&plateNumber.contains={plateNumberContains}&plateNumber.doesNotContain={plateNumberDoesNotContain}&plateNumber.equals={plateNumberEquals}&plateNumber.notEquals={plateNumberNotEquals}&plateNumber.specified={plateNumberSpecified}&plateNumber.in={plateNumberIn}&plateNumber.notIn={plateNumberNotIn}&brand.contains={brandContains}&brand.doesNotContain={brandDoesNotContain}&brand.equals={brandEquals}&brand.notEquals={brandNotEquals}&brand.specified={brandSpecified}&brand.in={brandIn}&brand.notIn={brandNotIn}&description.contains={descriptionContains}&description.doesNotContain={descriptionDoesNotContain}&description.equals={descriptionEquals}&description.notEquals={descriptionNotEquals}&description.specified={descriptionSpecified}&description.in={descriptionIn}&description.notIn={descriptionNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&seatMapId.greaterThan={seatMapIdGreaterThan}&seatMapId.lessThan={seatMapIdLessThan}&seatMapId.greaterThanOrEqual={seatMapIdGreaterThanOrEqual}&seatMapId.lessThanOrEqual={seatMapIdLessThanOrEqual}&seatMapId.equals={seatMapIdEquals}&seatMapId.notEquals={seatMapIdNotEquals}&seatMapId.specified={seatMapIdSpecified}&seatMapId.in={seatMapIdIn}&seatMapId.notIn={seatMapIdNotIn}&vehicleImgId.greaterThan={vehicleImgIdGreaterThan}&vehicleImgId.lessThan={vehicleImgIdLessThan}&vehicleImgId.greaterThanOrEqual={vehicleImgIdGreaterThanOrEqual}&vehicleImgId.lessThanOrEqual={vehicleImgIdLessThanOrEqual}&vehicleImgId.equals={vehicleImgIdEquals}&vehicleImgId.notEquals={vehicleImgIdNotEquals}&vehicleImgId.specified={vehicleImgIdSpecified}&vehicleImgId.in={vehicleImgIdIn}&vehicleImgId.notIn={vehicleImgIdNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<VehicleWithSeatCountVM>> getAllVehiclesWithSeatsCountWithHttpInfo(@QueryMap(encoded=true) GetAllVehiclesWithSeatsCountQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllVehiclesWithSeatsCount</code> method in a fluent style.
   */
  public static class GetAllVehiclesWithSeatsCountQueryParams extends HashMap<String, Object> {
    public GetAllVehiclesWithSeatsCountQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams typeEquals(@jakarta.annotation.Nullable final String value) {
      put("type.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams typeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("type.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams typeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("type.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams typeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("type.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams typeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("type.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams typeFactorGreaterThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("typeFactor.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams typeFactorLessThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("typeFactor.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams typeFactorGreaterThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("typeFactor.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams typeFactorLessThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("typeFactor.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams typeFactorEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("typeFactor.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams typeFactorNotEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("typeFactor.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams typeFactorSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("typeFactor.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams typeFactorIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("typeFactor.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams typeFactorNotIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("typeFactor.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams plateNumberContains(@jakarta.annotation.Nullable final String value) {
      put("plateNumber.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams plateNumberDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("plateNumber.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams plateNumberEquals(@jakarta.annotation.Nullable final String value) {
      put("plateNumber.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams plateNumberNotEquals(@jakarta.annotation.Nullable final String value) {
      put("plateNumber.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams plateNumberSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("plateNumber.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams plateNumberIn(@jakarta.annotation.Nullable final List<String> value) {
      put("plateNumber.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams plateNumberNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("plateNumber.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams brandContains(@jakarta.annotation.Nullable final String value) {
      put("brand.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams brandDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("brand.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams brandEquals(@jakarta.annotation.Nullable final String value) {
      put("brand.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams brandNotEquals(@jakarta.annotation.Nullable final String value) {
      put("brand.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams brandSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("brand.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams brandIn(@jakarta.annotation.Nullable final List<String> value) {
      put("brand.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams brandNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("brand.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams descriptionContains(@jakarta.annotation.Nullable final String value) {
      put("description.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams descriptionDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("description.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams descriptionEquals(@jakarta.annotation.Nullable final String value) {
      put("description.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams descriptionNotEquals(@jakarta.annotation.Nullable final String value) {
      put("description.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams descriptionSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("description.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams descriptionIn(@jakarta.annotation.Nullable final List<String> value) {
      put("description.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams descriptionNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("description.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams statusEquals(@jakarta.annotation.Nullable final String value) {
      put("status.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams statusNotEquals(@jakarta.annotation.Nullable final String value) {
      put("status.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams statusSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("status.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams statusIn(@jakarta.annotation.Nullable final List<String> value) {
      put("status.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams statusNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("status.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams seatMapIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams seatMapIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams seatMapIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams seatMapIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams seatMapIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams seatMapIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams seatMapIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("seatMapId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams seatMapIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("seatMapId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams seatMapIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("seatMapId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams vehicleImgIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("vehicleImgId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams vehicleImgIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("vehicleImgId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams vehicleImgIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("vehicleImgId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams vehicleImgIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("vehicleImgId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams vehicleImgIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("vehicleImgId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams vehicleImgIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("vehicleImgId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams vehicleImgIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("vehicleImgId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams vehicleImgIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("vehicleImgId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams vehicleImgIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("vehicleImgId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams page(@jakarta.annotation.Nullable final Integer value) {
      put("page", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams size(@jakarta.annotation.Nullable final Integer value) {
      put("size", EncodingUtils.encode(value));
      return this;
    }
    public GetAllVehiclesWithSeatsCountQueryParams sort(@jakarta.annotation.Nullable final List<String> value) {
      put("sort", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @return VehicleDTO
   */
  @RequestLine("GET /api/vehicles/{id}")
  @Headers({
    "Accept: */*",
  })
  VehicleDTO getVehicle(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>getVehicle</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/vehicles/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<VehicleDTO> getVehicleWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param id  (required)
   * @return VehicleDetailVM
   */
  @RequestLine("GET /api/vehicles/{id}/detail")
  @Headers({
    "Accept: */*",
  })
  VehicleDetailVM getVehicleDetail(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>getVehicleDetail</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/vehicles/{id}/detail")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<VehicleDetailVM> getVehicleDetailWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param id  (required)
   * @param vehicleDTO  (required)
   * @return VehicleDTO
   */
  @RequestLine("PATCH /api/vehicles/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  VehicleDTO partialUpdateVehicle(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull VehicleDTO vehicleDTO);

  /**
   * 
   * Similar to <code>partialUpdateVehicle</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param vehicleDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /api/vehicles/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<VehicleDTO> partialUpdateVehicleWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull VehicleDTO vehicleDTO);



  /**
   * 
   * 
   * @param id  (required)
   * @param vehicleDTO  (required)
   * @return VehicleDTO
   */
  @RequestLine("PUT /api/vehicles/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  VehicleDTO updateVehicle(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull VehicleDTO vehicleDTO);

  /**
   * 
   * Similar to <code>updateVehicle</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param vehicleDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/vehicles/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<VehicleDTO> updateVehicleWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull VehicleDTO vehicleDTO);


}
