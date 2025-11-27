package com.ridehub.msroute.client.api;

import com.ridehub.msroute.client.invoker.ApiClient;
import com.ridehub.msroute.client.invoker.EncodingUtils;
import com.ridehub.msroute.client.model.ApiResponse;

import java.math.BigDecimal;
import com.ridehub.msroute.client.model.FloorDTO;
import java.time.OffsetDateTime;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface FloorResourceMsrouteApi extends ApiClient.Api {


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
   * @param floorNoGreaterThan  (optional)
   * @param floorNoLessThan  (optional)
   * @param floorNoGreaterThanOrEqual  (optional)
   * @param floorNoLessThanOrEqual  (optional)
   * @param floorNoEquals  (optional)
   * @param floorNoNotEquals  (optional)
   * @param floorNoSpecified  (optional)
   * @param floorNoIn  (optional)
   * @param floorNoNotIn  (optional)
   * @param priceFactorFloorGreaterThan  (optional)
   * @param priceFactorFloorLessThan  (optional)
   * @param priceFactorFloorGreaterThanOrEqual  (optional)
   * @param priceFactorFloorLessThanOrEqual  (optional)
   * @param priceFactorFloorEquals  (optional)
   * @param priceFactorFloorNotEquals  (optional)
   * @param priceFactorFloorSpecified  (optional)
   * @param priceFactorFloorIn  (optional)
   * @param priceFactorFloorNotIn  (optional)
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
   * @param distinct  (optional)
   * @return Long
   */
  @RequestLine("GET /api/floors/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&floorNo.greaterThan={floorNoGreaterThan}&floorNo.lessThan={floorNoLessThan}&floorNo.greaterThanOrEqual={floorNoGreaterThanOrEqual}&floorNo.lessThanOrEqual={floorNoLessThanOrEqual}&floorNo.equals={floorNoEquals}&floorNo.notEquals={floorNoNotEquals}&floorNo.specified={floorNoSpecified}&floorNo.in={floorNoIn}&floorNo.notIn={floorNoNotIn}&priceFactorFloor.greaterThan={priceFactorFloorGreaterThan}&priceFactorFloor.lessThan={priceFactorFloorLessThan}&priceFactorFloor.greaterThanOrEqual={priceFactorFloorGreaterThanOrEqual}&priceFactorFloor.lessThanOrEqual={priceFactorFloorLessThanOrEqual}&priceFactorFloor.equals={priceFactorFloorEquals}&priceFactorFloor.notEquals={priceFactorFloorNotEquals}&priceFactorFloor.specified={priceFactorFloorSpecified}&priceFactorFloor.in={priceFactorFloorIn}&priceFactorFloor.notIn={priceFactorFloorNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&seatMapId.greaterThan={seatMapIdGreaterThan}&seatMapId.lessThan={seatMapIdLessThan}&seatMapId.greaterThanOrEqual={seatMapIdGreaterThanOrEqual}&seatMapId.lessThanOrEqual={seatMapIdLessThanOrEqual}&seatMapId.equals={seatMapIdEquals}&seatMapId.notEquals={seatMapIdNotEquals}&seatMapId.specified={seatMapIdSpecified}&seatMapId.in={seatMapIdIn}&seatMapId.notIn={seatMapIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  Long countFloors(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("floorNoGreaterThan") @jakarta.annotation.Nullable Integer floorNoGreaterThan, @Param("floorNoLessThan") @jakarta.annotation.Nullable Integer floorNoLessThan, @Param("floorNoGreaterThanOrEqual") @jakarta.annotation.Nullable Integer floorNoGreaterThanOrEqual, @Param("floorNoLessThanOrEqual") @jakarta.annotation.Nullable Integer floorNoLessThanOrEqual, @Param("floorNoEquals") @jakarta.annotation.Nullable Integer floorNoEquals, @Param("floorNoNotEquals") @jakarta.annotation.Nullable Integer floorNoNotEquals, @Param("floorNoSpecified") @jakarta.annotation.Nullable Boolean floorNoSpecified, @Param("floorNoIn") @jakarta.annotation.Nullable List<Integer> floorNoIn, @Param("floorNoNotIn") @jakarta.annotation.Nullable List<Integer> floorNoNotIn, @Param("priceFactorFloorGreaterThan") @jakarta.annotation.Nullable BigDecimal priceFactorFloorGreaterThan, @Param("priceFactorFloorLessThan") @jakarta.annotation.Nullable BigDecimal priceFactorFloorLessThan, @Param("priceFactorFloorGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal priceFactorFloorGreaterThanOrEqual, @Param("priceFactorFloorLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal priceFactorFloorLessThanOrEqual, @Param("priceFactorFloorEquals") @jakarta.annotation.Nullable BigDecimal priceFactorFloorEquals, @Param("priceFactorFloorNotEquals") @jakarta.annotation.Nullable BigDecimal priceFactorFloorNotEquals, @Param("priceFactorFloorSpecified") @jakarta.annotation.Nullable Boolean priceFactorFloorSpecified, @Param("priceFactorFloorIn") @jakarta.annotation.Nullable List<BigDecimal> priceFactorFloorIn, @Param("priceFactorFloorNotIn") @jakarta.annotation.Nullable List<BigDecimal> priceFactorFloorNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("seatMapIdGreaterThan") @jakarta.annotation.Nullable Long seatMapIdGreaterThan, @Param("seatMapIdLessThan") @jakarta.annotation.Nullable Long seatMapIdLessThan, @Param("seatMapIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long seatMapIdGreaterThanOrEqual, @Param("seatMapIdLessThanOrEqual") @jakarta.annotation.Nullable Long seatMapIdLessThanOrEqual, @Param("seatMapIdEquals") @jakarta.annotation.Nullable Long seatMapIdEquals, @Param("seatMapIdNotEquals") @jakarta.annotation.Nullable Long seatMapIdNotEquals, @Param("seatMapIdSpecified") @jakarta.annotation.Nullable Boolean seatMapIdSpecified, @Param("seatMapIdIn") @jakarta.annotation.Nullable List<Long> seatMapIdIn, @Param("seatMapIdNotIn") @jakarta.annotation.Nullable List<Long> seatMapIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>countFloors</code> but it also returns the http response headers .
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
   * @param floorNoGreaterThan  (optional)
   * @param floorNoLessThan  (optional)
   * @param floorNoGreaterThanOrEqual  (optional)
   * @param floorNoLessThanOrEqual  (optional)
   * @param floorNoEquals  (optional)
   * @param floorNoNotEquals  (optional)
   * @param floorNoSpecified  (optional)
   * @param floorNoIn  (optional)
   * @param floorNoNotIn  (optional)
   * @param priceFactorFloorGreaterThan  (optional)
   * @param priceFactorFloorLessThan  (optional)
   * @param priceFactorFloorGreaterThanOrEqual  (optional)
   * @param priceFactorFloorLessThanOrEqual  (optional)
   * @param priceFactorFloorEquals  (optional)
   * @param priceFactorFloorNotEquals  (optional)
   * @param priceFactorFloorSpecified  (optional)
   * @param priceFactorFloorIn  (optional)
   * @param priceFactorFloorNotIn  (optional)
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
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/floors/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&floorNo.greaterThan={floorNoGreaterThan}&floorNo.lessThan={floorNoLessThan}&floorNo.greaterThanOrEqual={floorNoGreaterThanOrEqual}&floorNo.lessThanOrEqual={floorNoLessThanOrEqual}&floorNo.equals={floorNoEquals}&floorNo.notEquals={floorNoNotEquals}&floorNo.specified={floorNoSpecified}&floorNo.in={floorNoIn}&floorNo.notIn={floorNoNotIn}&priceFactorFloor.greaterThan={priceFactorFloorGreaterThan}&priceFactorFloor.lessThan={priceFactorFloorLessThan}&priceFactorFloor.greaterThanOrEqual={priceFactorFloorGreaterThanOrEqual}&priceFactorFloor.lessThanOrEqual={priceFactorFloorLessThanOrEqual}&priceFactorFloor.equals={priceFactorFloorEquals}&priceFactorFloor.notEquals={priceFactorFloorNotEquals}&priceFactorFloor.specified={priceFactorFloorSpecified}&priceFactorFloor.in={priceFactorFloorIn}&priceFactorFloor.notIn={priceFactorFloorNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&seatMapId.greaterThan={seatMapIdGreaterThan}&seatMapId.lessThan={seatMapIdLessThan}&seatMapId.greaterThanOrEqual={seatMapIdGreaterThanOrEqual}&seatMapId.lessThanOrEqual={seatMapIdLessThanOrEqual}&seatMapId.equals={seatMapIdEquals}&seatMapId.notEquals={seatMapIdNotEquals}&seatMapId.specified={seatMapIdSpecified}&seatMapId.in={seatMapIdIn}&seatMapId.notIn={seatMapIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Long> countFloorsWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("floorNoGreaterThan") @jakarta.annotation.Nullable Integer floorNoGreaterThan, @Param("floorNoLessThan") @jakarta.annotation.Nullable Integer floorNoLessThan, @Param("floorNoGreaterThanOrEqual") @jakarta.annotation.Nullable Integer floorNoGreaterThanOrEqual, @Param("floorNoLessThanOrEqual") @jakarta.annotation.Nullable Integer floorNoLessThanOrEqual, @Param("floorNoEquals") @jakarta.annotation.Nullable Integer floorNoEquals, @Param("floorNoNotEquals") @jakarta.annotation.Nullable Integer floorNoNotEquals, @Param("floorNoSpecified") @jakarta.annotation.Nullable Boolean floorNoSpecified, @Param("floorNoIn") @jakarta.annotation.Nullable List<Integer> floorNoIn, @Param("floorNoNotIn") @jakarta.annotation.Nullable List<Integer> floorNoNotIn, @Param("priceFactorFloorGreaterThan") @jakarta.annotation.Nullable BigDecimal priceFactorFloorGreaterThan, @Param("priceFactorFloorLessThan") @jakarta.annotation.Nullable BigDecimal priceFactorFloorLessThan, @Param("priceFactorFloorGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal priceFactorFloorGreaterThanOrEqual, @Param("priceFactorFloorLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal priceFactorFloorLessThanOrEqual, @Param("priceFactorFloorEquals") @jakarta.annotation.Nullable BigDecimal priceFactorFloorEquals, @Param("priceFactorFloorNotEquals") @jakarta.annotation.Nullable BigDecimal priceFactorFloorNotEquals, @Param("priceFactorFloorSpecified") @jakarta.annotation.Nullable Boolean priceFactorFloorSpecified, @Param("priceFactorFloorIn") @jakarta.annotation.Nullable List<BigDecimal> priceFactorFloorIn, @Param("priceFactorFloorNotIn") @jakarta.annotation.Nullable List<BigDecimal> priceFactorFloorNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("seatMapIdGreaterThan") @jakarta.annotation.Nullable Long seatMapIdGreaterThan, @Param("seatMapIdLessThan") @jakarta.annotation.Nullable Long seatMapIdLessThan, @Param("seatMapIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long seatMapIdGreaterThanOrEqual, @Param("seatMapIdLessThanOrEqual") @jakarta.annotation.Nullable Long seatMapIdLessThanOrEqual, @Param("seatMapIdEquals") @jakarta.annotation.Nullable Long seatMapIdEquals, @Param("seatMapIdNotEquals") @jakarta.annotation.Nullable Long seatMapIdNotEquals, @Param("seatMapIdSpecified") @jakarta.annotation.Nullable Boolean seatMapIdSpecified, @Param("seatMapIdIn") @jakarta.annotation.Nullable List<Long> seatMapIdIn, @Param("seatMapIdNotIn") @jakarta.annotation.Nullable List<Long> seatMapIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>countFloors</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CountFloorsQueryParams} class that allows for
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
   *   <li>floorNoGreaterThan -  (optional)</li>
   *   <li>floorNoLessThan -  (optional)</li>
   *   <li>floorNoGreaterThanOrEqual -  (optional)</li>
   *   <li>floorNoLessThanOrEqual -  (optional)</li>
   *   <li>floorNoEquals -  (optional)</li>
   *   <li>floorNoNotEquals -  (optional)</li>
   *   <li>floorNoSpecified -  (optional)</li>
   *   <li>floorNoIn -  (optional)</li>
   *   <li>floorNoNotIn -  (optional)</li>
   *   <li>priceFactorFloorGreaterThan -  (optional)</li>
   *   <li>priceFactorFloorLessThan -  (optional)</li>
   *   <li>priceFactorFloorGreaterThanOrEqual -  (optional)</li>
   *   <li>priceFactorFloorLessThanOrEqual -  (optional)</li>
   *   <li>priceFactorFloorEquals -  (optional)</li>
   *   <li>priceFactorFloorNotEquals -  (optional)</li>
   *   <li>priceFactorFloorSpecified -  (optional)</li>
   *   <li>priceFactorFloorIn -  (optional)</li>
   *   <li>priceFactorFloorNotIn -  (optional)</li>
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
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return Long
   */
  @RequestLine("GET /api/floors/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&floorNo.greaterThan={floorNoGreaterThan}&floorNo.lessThan={floorNoLessThan}&floorNo.greaterThanOrEqual={floorNoGreaterThanOrEqual}&floorNo.lessThanOrEqual={floorNoLessThanOrEqual}&floorNo.equals={floorNoEquals}&floorNo.notEquals={floorNoNotEquals}&floorNo.specified={floorNoSpecified}&floorNo.in={floorNoIn}&floorNo.notIn={floorNoNotIn}&priceFactorFloor.greaterThan={priceFactorFloorGreaterThan}&priceFactorFloor.lessThan={priceFactorFloorLessThan}&priceFactorFloor.greaterThanOrEqual={priceFactorFloorGreaterThanOrEqual}&priceFactorFloor.lessThanOrEqual={priceFactorFloorLessThanOrEqual}&priceFactorFloor.equals={priceFactorFloorEquals}&priceFactorFloor.notEquals={priceFactorFloorNotEquals}&priceFactorFloor.specified={priceFactorFloorSpecified}&priceFactorFloor.in={priceFactorFloorIn}&priceFactorFloor.notIn={priceFactorFloorNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&seatMapId.greaterThan={seatMapIdGreaterThan}&seatMapId.lessThan={seatMapIdLessThan}&seatMapId.greaterThanOrEqual={seatMapIdGreaterThanOrEqual}&seatMapId.lessThanOrEqual={seatMapIdLessThanOrEqual}&seatMapId.equals={seatMapIdEquals}&seatMapId.notEquals={seatMapIdNotEquals}&seatMapId.specified={seatMapIdSpecified}&seatMapId.in={seatMapIdIn}&seatMapId.notIn={seatMapIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  Long countFloors(@QueryMap(encoded=true) CountFloorsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>countFloors</code> that receives the query parameters as a map,
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
          *   <li>floorNoGreaterThan -  (optional)</li>
          *   <li>floorNoLessThan -  (optional)</li>
          *   <li>floorNoGreaterThanOrEqual -  (optional)</li>
          *   <li>floorNoLessThanOrEqual -  (optional)</li>
          *   <li>floorNoEquals -  (optional)</li>
          *   <li>floorNoNotEquals -  (optional)</li>
          *   <li>floorNoSpecified -  (optional)</li>
          *   <li>floorNoIn -  (optional)</li>
          *   <li>floorNoNotIn -  (optional)</li>
          *   <li>priceFactorFloorGreaterThan -  (optional)</li>
          *   <li>priceFactorFloorLessThan -  (optional)</li>
          *   <li>priceFactorFloorGreaterThanOrEqual -  (optional)</li>
          *   <li>priceFactorFloorLessThanOrEqual -  (optional)</li>
          *   <li>priceFactorFloorEquals -  (optional)</li>
          *   <li>priceFactorFloorNotEquals -  (optional)</li>
          *   <li>priceFactorFloorSpecified -  (optional)</li>
          *   <li>priceFactorFloorIn -  (optional)</li>
          *   <li>priceFactorFloorNotIn -  (optional)</li>
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
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return Long
      */
      @RequestLine("GET /api/floors/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&floorNo.greaterThan={floorNoGreaterThan}&floorNo.lessThan={floorNoLessThan}&floorNo.greaterThanOrEqual={floorNoGreaterThanOrEqual}&floorNo.lessThanOrEqual={floorNoLessThanOrEqual}&floorNo.equals={floorNoEquals}&floorNo.notEquals={floorNoNotEquals}&floorNo.specified={floorNoSpecified}&floorNo.in={floorNoIn}&floorNo.notIn={floorNoNotIn}&priceFactorFloor.greaterThan={priceFactorFloorGreaterThan}&priceFactorFloor.lessThan={priceFactorFloorLessThan}&priceFactorFloor.greaterThanOrEqual={priceFactorFloorGreaterThanOrEqual}&priceFactorFloor.lessThanOrEqual={priceFactorFloorLessThanOrEqual}&priceFactorFloor.equals={priceFactorFloorEquals}&priceFactorFloor.notEquals={priceFactorFloorNotEquals}&priceFactorFloor.specified={priceFactorFloorSpecified}&priceFactorFloor.in={priceFactorFloorIn}&priceFactorFloor.notIn={priceFactorFloorNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&seatMapId.greaterThan={seatMapIdGreaterThan}&seatMapId.lessThan={seatMapIdLessThan}&seatMapId.greaterThanOrEqual={seatMapIdGreaterThanOrEqual}&seatMapId.lessThanOrEqual={seatMapIdLessThanOrEqual}&seatMapId.equals={seatMapIdEquals}&seatMapId.notEquals={seatMapIdNotEquals}&seatMapId.specified={seatMapIdSpecified}&seatMapId.in={seatMapIdIn}&seatMapId.notIn={seatMapIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Long> countFloorsWithHttpInfo(@QueryMap(encoded=true) CountFloorsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>countFloors</code> method in a fluent style.
   */
  public static class CountFloorsQueryParams extends HashMap<String, Object> {
    public CountFloorsQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFloorsQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFloorsQueryParams floorNoGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("floorNo.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams floorNoLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("floorNo.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams floorNoGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("floorNo.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams floorNoLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("floorNo.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams floorNoEquals(@jakarta.annotation.Nullable final Integer value) {
      put("floorNo.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams floorNoNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("floorNo.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams floorNoSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("floorNo.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams floorNoIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("floorNo.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFloorsQueryParams floorNoNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("floorNo.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFloorsQueryParams priceFactorFloorGreaterThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("priceFactorFloor.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams priceFactorFloorLessThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("priceFactorFloor.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams priceFactorFloorGreaterThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("priceFactorFloor.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams priceFactorFloorLessThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("priceFactorFloor.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams priceFactorFloorEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("priceFactorFloor.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams priceFactorFloorNotEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("priceFactorFloor.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams priceFactorFloorSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("priceFactorFloor.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams priceFactorFloorIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("priceFactorFloor.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFloorsQueryParams priceFactorFloorNotIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("priceFactorFloor.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFloorsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFloorsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFloorsQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFloorsQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFloorsQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFloorsQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFloorsQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFloorsQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFloorsQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFloorsQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFloorsQueryParams seatMapIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams seatMapIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams seatMapIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams seatMapIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams seatMapIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams seatMapIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams seatMapIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("seatMapId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFloorsQueryParams seatMapIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("seatMapId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFloorsQueryParams seatMapIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("seatMapId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFloorsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param floorDTO  (required)
   * @return FloorDTO
   */
  @RequestLine("POST /api/floors")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  FloorDTO createFloor(@jakarta.annotation.Nonnull FloorDTO floorDTO);

  /**
   * 
   * Similar to <code>createFloor</code> but it also returns the http response headers .
   * 
   * @param floorDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/floors")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<FloorDTO> createFloorWithHttpInfo(@jakarta.annotation.Nonnull FloorDTO floorDTO);



  /**
   * 
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/floors/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteFloor(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>deleteFloor</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/floors/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteFloorWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



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
   * @param floorNoGreaterThan  (optional)
   * @param floorNoLessThan  (optional)
   * @param floorNoGreaterThanOrEqual  (optional)
   * @param floorNoLessThanOrEqual  (optional)
   * @param floorNoEquals  (optional)
   * @param floorNoNotEquals  (optional)
   * @param floorNoSpecified  (optional)
   * @param floorNoIn  (optional)
   * @param floorNoNotIn  (optional)
   * @param priceFactorFloorGreaterThan  (optional)
   * @param priceFactorFloorLessThan  (optional)
   * @param priceFactorFloorGreaterThanOrEqual  (optional)
   * @param priceFactorFloorLessThanOrEqual  (optional)
   * @param priceFactorFloorEquals  (optional)
   * @param priceFactorFloorNotEquals  (optional)
   * @param priceFactorFloorSpecified  (optional)
   * @param priceFactorFloorIn  (optional)
   * @param priceFactorFloorNotIn  (optional)
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
   * @param distinct  (optional)
   * @return List&lt;FloorDTO&gt;
   */
  @RequestLine("GET /api/floors?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&floorNo.greaterThan={floorNoGreaterThan}&floorNo.lessThan={floorNoLessThan}&floorNo.greaterThanOrEqual={floorNoGreaterThanOrEqual}&floorNo.lessThanOrEqual={floorNoLessThanOrEqual}&floorNo.equals={floorNoEquals}&floorNo.notEquals={floorNoNotEquals}&floorNo.specified={floorNoSpecified}&floorNo.in={floorNoIn}&floorNo.notIn={floorNoNotIn}&priceFactorFloor.greaterThan={priceFactorFloorGreaterThan}&priceFactorFloor.lessThan={priceFactorFloorLessThan}&priceFactorFloor.greaterThanOrEqual={priceFactorFloorGreaterThanOrEqual}&priceFactorFloor.lessThanOrEqual={priceFactorFloorLessThanOrEqual}&priceFactorFloor.equals={priceFactorFloorEquals}&priceFactorFloor.notEquals={priceFactorFloorNotEquals}&priceFactorFloor.specified={priceFactorFloorSpecified}&priceFactorFloor.in={priceFactorFloorIn}&priceFactorFloor.notIn={priceFactorFloorNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&seatMapId.greaterThan={seatMapIdGreaterThan}&seatMapId.lessThan={seatMapIdLessThan}&seatMapId.greaterThanOrEqual={seatMapIdGreaterThanOrEqual}&seatMapId.lessThanOrEqual={seatMapIdLessThanOrEqual}&seatMapId.equals={seatMapIdEquals}&seatMapId.notEquals={seatMapIdNotEquals}&seatMapId.specified={seatMapIdSpecified}&seatMapId.in={seatMapIdIn}&seatMapId.notIn={seatMapIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  List<FloorDTO> getAllFloors(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("floorNoGreaterThan") @jakarta.annotation.Nullable Integer floorNoGreaterThan, @Param("floorNoLessThan") @jakarta.annotation.Nullable Integer floorNoLessThan, @Param("floorNoGreaterThanOrEqual") @jakarta.annotation.Nullable Integer floorNoGreaterThanOrEqual, @Param("floorNoLessThanOrEqual") @jakarta.annotation.Nullable Integer floorNoLessThanOrEqual, @Param("floorNoEquals") @jakarta.annotation.Nullable Integer floorNoEquals, @Param("floorNoNotEquals") @jakarta.annotation.Nullable Integer floorNoNotEquals, @Param("floorNoSpecified") @jakarta.annotation.Nullable Boolean floorNoSpecified, @Param("floorNoIn") @jakarta.annotation.Nullable List<Integer> floorNoIn, @Param("floorNoNotIn") @jakarta.annotation.Nullable List<Integer> floorNoNotIn, @Param("priceFactorFloorGreaterThan") @jakarta.annotation.Nullable BigDecimal priceFactorFloorGreaterThan, @Param("priceFactorFloorLessThan") @jakarta.annotation.Nullable BigDecimal priceFactorFloorLessThan, @Param("priceFactorFloorGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal priceFactorFloorGreaterThanOrEqual, @Param("priceFactorFloorLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal priceFactorFloorLessThanOrEqual, @Param("priceFactorFloorEquals") @jakarta.annotation.Nullable BigDecimal priceFactorFloorEquals, @Param("priceFactorFloorNotEquals") @jakarta.annotation.Nullable BigDecimal priceFactorFloorNotEquals, @Param("priceFactorFloorSpecified") @jakarta.annotation.Nullable Boolean priceFactorFloorSpecified, @Param("priceFactorFloorIn") @jakarta.annotation.Nullable List<BigDecimal> priceFactorFloorIn, @Param("priceFactorFloorNotIn") @jakarta.annotation.Nullable List<BigDecimal> priceFactorFloorNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("seatMapIdGreaterThan") @jakarta.annotation.Nullable Long seatMapIdGreaterThan, @Param("seatMapIdLessThan") @jakarta.annotation.Nullable Long seatMapIdLessThan, @Param("seatMapIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long seatMapIdGreaterThanOrEqual, @Param("seatMapIdLessThanOrEqual") @jakarta.annotation.Nullable Long seatMapIdLessThanOrEqual, @Param("seatMapIdEquals") @jakarta.annotation.Nullable Long seatMapIdEquals, @Param("seatMapIdNotEquals") @jakarta.annotation.Nullable Long seatMapIdNotEquals, @Param("seatMapIdSpecified") @jakarta.annotation.Nullable Boolean seatMapIdSpecified, @Param("seatMapIdIn") @jakarta.annotation.Nullable List<Long> seatMapIdIn, @Param("seatMapIdNotIn") @jakarta.annotation.Nullable List<Long> seatMapIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>getAllFloors</code> but it also returns the http response headers .
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
   * @param floorNoGreaterThan  (optional)
   * @param floorNoLessThan  (optional)
   * @param floorNoGreaterThanOrEqual  (optional)
   * @param floorNoLessThanOrEqual  (optional)
   * @param floorNoEquals  (optional)
   * @param floorNoNotEquals  (optional)
   * @param floorNoSpecified  (optional)
   * @param floorNoIn  (optional)
   * @param floorNoNotIn  (optional)
   * @param priceFactorFloorGreaterThan  (optional)
   * @param priceFactorFloorLessThan  (optional)
   * @param priceFactorFloorGreaterThanOrEqual  (optional)
   * @param priceFactorFloorLessThanOrEqual  (optional)
   * @param priceFactorFloorEquals  (optional)
   * @param priceFactorFloorNotEquals  (optional)
   * @param priceFactorFloorSpecified  (optional)
   * @param priceFactorFloorIn  (optional)
   * @param priceFactorFloorNotIn  (optional)
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
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/floors?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&floorNo.greaterThan={floorNoGreaterThan}&floorNo.lessThan={floorNoLessThan}&floorNo.greaterThanOrEqual={floorNoGreaterThanOrEqual}&floorNo.lessThanOrEqual={floorNoLessThanOrEqual}&floorNo.equals={floorNoEquals}&floorNo.notEquals={floorNoNotEquals}&floorNo.specified={floorNoSpecified}&floorNo.in={floorNoIn}&floorNo.notIn={floorNoNotIn}&priceFactorFloor.greaterThan={priceFactorFloorGreaterThan}&priceFactorFloor.lessThan={priceFactorFloorLessThan}&priceFactorFloor.greaterThanOrEqual={priceFactorFloorGreaterThanOrEqual}&priceFactorFloor.lessThanOrEqual={priceFactorFloorLessThanOrEqual}&priceFactorFloor.equals={priceFactorFloorEquals}&priceFactorFloor.notEquals={priceFactorFloorNotEquals}&priceFactorFloor.specified={priceFactorFloorSpecified}&priceFactorFloor.in={priceFactorFloorIn}&priceFactorFloor.notIn={priceFactorFloorNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&seatMapId.greaterThan={seatMapIdGreaterThan}&seatMapId.lessThan={seatMapIdLessThan}&seatMapId.greaterThanOrEqual={seatMapIdGreaterThanOrEqual}&seatMapId.lessThanOrEqual={seatMapIdLessThanOrEqual}&seatMapId.equals={seatMapIdEquals}&seatMapId.notEquals={seatMapIdNotEquals}&seatMapId.specified={seatMapIdSpecified}&seatMapId.in={seatMapIdIn}&seatMapId.notIn={seatMapIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<FloorDTO>> getAllFloorsWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("floorNoGreaterThan") @jakarta.annotation.Nullable Integer floorNoGreaterThan, @Param("floorNoLessThan") @jakarta.annotation.Nullable Integer floorNoLessThan, @Param("floorNoGreaterThanOrEqual") @jakarta.annotation.Nullable Integer floorNoGreaterThanOrEqual, @Param("floorNoLessThanOrEqual") @jakarta.annotation.Nullable Integer floorNoLessThanOrEqual, @Param("floorNoEquals") @jakarta.annotation.Nullable Integer floorNoEquals, @Param("floorNoNotEquals") @jakarta.annotation.Nullable Integer floorNoNotEquals, @Param("floorNoSpecified") @jakarta.annotation.Nullable Boolean floorNoSpecified, @Param("floorNoIn") @jakarta.annotation.Nullable List<Integer> floorNoIn, @Param("floorNoNotIn") @jakarta.annotation.Nullable List<Integer> floorNoNotIn, @Param("priceFactorFloorGreaterThan") @jakarta.annotation.Nullable BigDecimal priceFactorFloorGreaterThan, @Param("priceFactorFloorLessThan") @jakarta.annotation.Nullable BigDecimal priceFactorFloorLessThan, @Param("priceFactorFloorGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal priceFactorFloorGreaterThanOrEqual, @Param("priceFactorFloorLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal priceFactorFloorLessThanOrEqual, @Param("priceFactorFloorEquals") @jakarta.annotation.Nullable BigDecimal priceFactorFloorEquals, @Param("priceFactorFloorNotEquals") @jakarta.annotation.Nullable BigDecimal priceFactorFloorNotEquals, @Param("priceFactorFloorSpecified") @jakarta.annotation.Nullable Boolean priceFactorFloorSpecified, @Param("priceFactorFloorIn") @jakarta.annotation.Nullable List<BigDecimal> priceFactorFloorIn, @Param("priceFactorFloorNotIn") @jakarta.annotation.Nullable List<BigDecimal> priceFactorFloorNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("seatMapIdGreaterThan") @jakarta.annotation.Nullable Long seatMapIdGreaterThan, @Param("seatMapIdLessThan") @jakarta.annotation.Nullable Long seatMapIdLessThan, @Param("seatMapIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long seatMapIdGreaterThanOrEqual, @Param("seatMapIdLessThanOrEqual") @jakarta.annotation.Nullable Long seatMapIdLessThanOrEqual, @Param("seatMapIdEquals") @jakarta.annotation.Nullable Long seatMapIdEquals, @Param("seatMapIdNotEquals") @jakarta.annotation.Nullable Long seatMapIdNotEquals, @Param("seatMapIdSpecified") @jakarta.annotation.Nullable Boolean seatMapIdSpecified, @Param("seatMapIdIn") @jakarta.annotation.Nullable List<Long> seatMapIdIn, @Param("seatMapIdNotIn") @jakarta.annotation.Nullable List<Long> seatMapIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllFloors</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllFloorsQueryParams} class that allows for
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
   *   <li>floorNoGreaterThan -  (optional)</li>
   *   <li>floorNoLessThan -  (optional)</li>
   *   <li>floorNoGreaterThanOrEqual -  (optional)</li>
   *   <li>floorNoLessThanOrEqual -  (optional)</li>
   *   <li>floorNoEquals -  (optional)</li>
   *   <li>floorNoNotEquals -  (optional)</li>
   *   <li>floorNoSpecified -  (optional)</li>
   *   <li>floorNoIn -  (optional)</li>
   *   <li>floorNoNotIn -  (optional)</li>
   *   <li>priceFactorFloorGreaterThan -  (optional)</li>
   *   <li>priceFactorFloorLessThan -  (optional)</li>
   *   <li>priceFactorFloorGreaterThanOrEqual -  (optional)</li>
   *   <li>priceFactorFloorLessThanOrEqual -  (optional)</li>
   *   <li>priceFactorFloorEquals -  (optional)</li>
   *   <li>priceFactorFloorNotEquals -  (optional)</li>
   *   <li>priceFactorFloorSpecified -  (optional)</li>
   *   <li>priceFactorFloorIn -  (optional)</li>
   *   <li>priceFactorFloorNotIn -  (optional)</li>
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
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return List&lt;FloorDTO&gt;
   */
  @RequestLine("GET /api/floors?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&floorNo.greaterThan={floorNoGreaterThan}&floorNo.lessThan={floorNoLessThan}&floorNo.greaterThanOrEqual={floorNoGreaterThanOrEqual}&floorNo.lessThanOrEqual={floorNoLessThanOrEqual}&floorNo.equals={floorNoEquals}&floorNo.notEquals={floorNoNotEquals}&floorNo.specified={floorNoSpecified}&floorNo.in={floorNoIn}&floorNo.notIn={floorNoNotIn}&priceFactorFloor.greaterThan={priceFactorFloorGreaterThan}&priceFactorFloor.lessThan={priceFactorFloorLessThan}&priceFactorFloor.greaterThanOrEqual={priceFactorFloorGreaterThanOrEqual}&priceFactorFloor.lessThanOrEqual={priceFactorFloorLessThanOrEqual}&priceFactorFloor.equals={priceFactorFloorEquals}&priceFactorFloor.notEquals={priceFactorFloorNotEquals}&priceFactorFloor.specified={priceFactorFloorSpecified}&priceFactorFloor.in={priceFactorFloorIn}&priceFactorFloor.notIn={priceFactorFloorNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&seatMapId.greaterThan={seatMapIdGreaterThan}&seatMapId.lessThan={seatMapIdLessThan}&seatMapId.greaterThanOrEqual={seatMapIdGreaterThanOrEqual}&seatMapId.lessThanOrEqual={seatMapIdLessThanOrEqual}&seatMapId.equals={seatMapIdEquals}&seatMapId.notEquals={seatMapIdNotEquals}&seatMapId.specified={seatMapIdSpecified}&seatMapId.in={seatMapIdIn}&seatMapId.notIn={seatMapIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  List<FloorDTO> getAllFloors(@QueryMap(encoded=true) GetAllFloorsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllFloors</code> that receives the query parameters as a map,
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
          *   <li>floorNoGreaterThan -  (optional)</li>
          *   <li>floorNoLessThan -  (optional)</li>
          *   <li>floorNoGreaterThanOrEqual -  (optional)</li>
          *   <li>floorNoLessThanOrEqual -  (optional)</li>
          *   <li>floorNoEquals -  (optional)</li>
          *   <li>floorNoNotEquals -  (optional)</li>
          *   <li>floorNoSpecified -  (optional)</li>
          *   <li>floorNoIn -  (optional)</li>
          *   <li>floorNoNotIn -  (optional)</li>
          *   <li>priceFactorFloorGreaterThan -  (optional)</li>
          *   <li>priceFactorFloorLessThan -  (optional)</li>
          *   <li>priceFactorFloorGreaterThanOrEqual -  (optional)</li>
          *   <li>priceFactorFloorLessThanOrEqual -  (optional)</li>
          *   <li>priceFactorFloorEquals -  (optional)</li>
          *   <li>priceFactorFloorNotEquals -  (optional)</li>
          *   <li>priceFactorFloorSpecified -  (optional)</li>
          *   <li>priceFactorFloorIn -  (optional)</li>
          *   <li>priceFactorFloorNotIn -  (optional)</li>
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
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return List&lt;FloorDTO&gt;
      */
      @RequestLine("GET /api/floors?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&floorNo.greaterThan={floorNoGreaterThan}&floorNo.lessThan={floorNoLessThan}&floorNo.greaterThanOrEqual={floorNoGreaterThanOrEqual}&floorNo.lessThanOrEqual={floorNoLessThanOrEqual}&floorNo.equals={floorNoEquals}&floorNo.notEquals={floorNoNotEquals}&floorNo.specified={floorNoSpecified}&floorNo.in={floorNoIn}&floorNo.notIn={floorNoNotIn}&priceFactorFloor.greaterThan={priceFactorFloorGreaterThan}&priceFactorFloor.lessThan={priceFactorFloorLessThan}&priceFactorFloor.greaterThanOrEqual={priceFactorFloorGreaterThanOrEqual}&priceFactorFloor.lessThanOrEqual={priceFactorFloorLessThanOrEqual}&priceFactorFloor.equals={priceFactorFloorEquals}&priceFactorFloor.notEquals={priceFactorFloorNotEquals}&priceFactorFloor.specified={priceFactorFloorSpecified}&priceFactorFloor.in={priceFactorFloorIn}&priceFactorFloor.notIn={priceFactorFloorNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&seatMapId.greaterThan={seatMapIdGreaterThan}&seatMapId.lessThan={seatMapIdLessThan}&seatMapId.greaterThanOrEqual={seatMapIdGreaterThanOrEqual}&seatMapId.lessThanOrEqual={seatMapIdLessThanOrEqual}&seatMapId.equals={seatMapIdEquals}&seatMapId.notEquals={seatMapIdNotEquals}&seatMapId.specified={seatMapIdSpecified}&seatMapId.in={seatMapIdIn}&seatMapId.notIn={seatMapIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<FloorDTO>> getAllFloorsWithHttpInfo(@QueryMap(encoded=true) GetAllFloorsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllFloors</code> method in a fluent style.
   */
  public static class GetAllFloorsQueryParams extends HashMap<String, Object> {
    public GetAllFloorsQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFloorsQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFloorsQueryParams floorNoGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("floorNo.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams floorNoLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("floorNo.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams floorNoGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("floorNo.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams floorNoLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("floorNo.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams floorNoEquals(@jakarta.annotation.Nullable final Integer value) {
      put("floorNo.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams floorNoNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("floorNo.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams floorNoSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("floorNo.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams floorNoIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("floorNo.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFloorsQueryParams floorNoNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("floorNo.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFloorsQueryParams priceFactorFloorGreaterThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("priceFactorFloor.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams priceFactorFloorLessThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("priceFactorFloor.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams priceFactorFloorGreaterThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("priceFactorFloor.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams priceFactorFloorLessThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("priceFactorFloor.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams priceFactorFloorEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("priceFactorFloor.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams priceFactorFloorNotEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("priceFactorFloor.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams priceFactorFloorSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("priceFactorFloor.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams priceFactorFloorIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("priceFactorFloor.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFloorsQueryParams priceFactorFloorNotIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("priceFactorFloor.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFloorsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFloorsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFloorsQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFloorsQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFloorsQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFloorsQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFloorsQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFloorsQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFloorsQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFloorsQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFloorsQueryParams seatMapIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams seatMapIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams seatMapIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams seatMapIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams seatMapIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams seatMapIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams seatMapIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("seatMapId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFloorsQueryParams seatMapIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("seatMapId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFloorsQueryParams seatMapIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("seatMapId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFloorsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @return FloorDTO
   */
  @RequestLine("GET /api/floors/{id}")
  @Headers({
    "Accept: */*",
  })
  FloorDTO getFloor(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>getFloor</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/floors/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<FloorDTO> getFloorWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param id  (required)
   * @param floorDTO  (required)
   * @return FloorDTO
   */
  @RequestLine("PATCH /api/floors/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  FloorDTO partialUpdateFloor(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull FloorDTO floorDTO);

  /**
   * 
   * Similar to <code>partialUpdateFloor</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param floorDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /api/floors/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<FloorDTO> partialUpdateFloorWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull FloorDTO floorDTO);



  /**
   * 
   * 
   * @param id  (required)
   * @param floorDTO  (required)
   * @return FloorDTO
   */
  @RequestLine("PUT /api/floors/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  FloorDTO updateFloor(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull FloorDTO floorDTO);

  /**
   * 
   * Similar to <code>updateFloor</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param floorDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/floors/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<FloorDTO> updateFloorWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull FloorDTO floorDTO);


}
