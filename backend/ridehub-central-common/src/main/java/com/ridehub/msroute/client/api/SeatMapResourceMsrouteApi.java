package com.ridehub.msroute.client.api;

import com.ridehub.msroute.client.invoker.ApiClient;
import com.ridehub.msroute.client.invoker.EncodingUtils;
import com.ridehub.msroute.client.model.ApiResponse;

import java.time.OffsetDateTime;
import com.ridehub.msroute.client.model.SeatMapDTO;
import com.ridehub.msroute.client.model.SeatMapDetailVM;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface SeatMapResourceMsrouteApi extends ApiClient.Api {


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
   * @param seatMapImgIdGreaterThan  (optional)
   * @param seatMapImgIdLessThan  (optional)
   * @param seatMapImgIdGreaterThanOrEqual  (optional)
   * @param seatMapImgIdLessThanOrEqual  (optional)
   * @param seatMapImgIdEquals  (optional)
   * @param seatMapImgIdNotEquals  (optional)
   * @param seatMapImgIdSpecified  (optional)
   * @param seatMapImgIdIn  (optional)
   * @param seatMapImgIdNotIn  (optional)
   * @param vehicleIdGreaterThan  (optional)
   * @param vehicleIdLessThan  (optional)
   * @param vehicleIdGreaterThanOrEqual  (optional)
   * @param vehicleIdLessThanOrEqual  (optional)
   * @param vehicleIdEquals  (optional)
   * @param vehicleIdNotEquals  (optional)
   * @param vehicleIdSpecified  (optional)
   * @param vehicleIdIn  (optional)
   * @param vehicleIdNotIn  (optional)
   * @param distinct  (optional)
   * @return Long
   */
  @RequestLine("GET /api/seat-maps/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&seatMapImgId.greaterThan={seatMapImgIdGreaterThan}&seatMapImgId.lessThan={seatMapImgIdLessThan}&seatMapImgId.greaterThanOrEqual={seatMapImgIdGreaterThanOrEqual}&seatMapImgId.lessThanOrEqual={seatMapImgIdLessThanOrEqual}&seatMapImgId.equals={seatMapImgIdEquals}&seatMapImgId.notEquals={seatMapImgIdNotEquals}&seatMapImgId.specified={seatMapImgIdSpecified}&seatMapImgId.in={seatMapImgIdIn}&seatMapImgId.notIn={seatMapImgIdNotIn}&vehicleId.greaterThan={vehicleIdGreaterThan}&vehicleId.lessThan={vehicleIdLessThan}&vehicleId.greaterThanOrEqual={vehicleIdGreaterThanOrEqual}&vehicleId.lessThanOrEqual={vehicleIdLessThanOrEqual}&vehicleId.equals={vehicleIdEquals}&vehicleId.notEquals={vehicleIdNotEquals}&vehicleId.specified={vehicleIdSpecified}&vehicleId.in={vehicleIdIn}&vehicleId.notIn={vehicleIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  Long countSeatMaps(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("nameContains") @jakarta.annotation.Nullable String nameContains, @Param("nameDoesNotContain") @jakarta.annotation.Nullable String nameDoesNotContain, @Param("nameEquals") @jakarta.annotation.Nullable String nameEquals, @Param("nameNotEquals") @jakarta.annotation.Nullable String nameNotEquals, @Param("nameSpecified") @jakarta.annotation.Nullable Boolean nameSpecified, @Param("nameIn") @jakarta.annotation.Nullable List<String> nameIn, @Param("nameNotIn") @jakarta.annotation.Nullable List<String> nameNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("seatMapImgIdGreaterThan") @jakarta.annotation.Nullable Long seatMapImgIdGreaterThan, @Param("seatMapImgIdLessThan") @jakarta.annotation.Nullable Long seatMapImgIdLessThan, @Param("seatMapImgIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long seatMapImgIdGreaterThanOrEqual, @Param("seatMapImgIdLessThanOrEqual") @jakarta.annotation.Nullable Long seatMapImgIdLessThanOrEqual, @Param("seatMapImgIdEquals") @jakarta.annotation.Nullable Long seatMapImgIdEquals, @Param("seatMapImgIdNotEquals") @jakarta.annotation.Nullable Long seatMapImgIdNotEquals, @Param("seatMapImgIdSpecified") @jakarta.annotation.Nullable Boolean seatMapImgIdSpecified, @Param("seatMapImgIdIn") @jakarta.annotation.Nullable List<Long> seatMapImgIdIn, @Param("seatMapImgIdNotIn") @jakarta.annotation.Nullable List<Long> seatMapImgIdNotIn, @Param("vehicleIdGreaterThan") @jakarta.annotation.Nullable Long vehicleIdGreaterThan, @Param("vehicleIdLessThan") @jakarta.annotation.Nullable Long vehicleIdLessThan, @Param("vehicleIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long vehicleIdGreaterThanOrEqual, @Param("vehicleIdLessThanOrEqual") @jakarta.annotation.Nullable Long vehicleIdLessThanOrEqual, @Param("vehicleIdEquals") @jakarta.annotation.Nullable Long vehicleIdEquals, @Param("vehicleIdNotEquals") @jakarta.annotation.Nullable Long vehicleIdNotEquals, @Param("vehicleIdSpecified") @jakarta.annotation.Nullable Boolean vehicleIdSpecified, @Param("vehicleIdIn") @jakarta.annotation.Nullable List<Long> vehicleIdIn, @Param("vehicleIdNotIn") @jakarta.annotation.Nullable List<Long> vehicleIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>countSeatMaps</code> but it also returns the http response headers .
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
   * @param seatMapImgIdGreaterThan  (optional)
   * @param seatMapImgIdLessThan  (optional)
   * @param seatMapImgIdGreaterThanOrEqual  (optional)
   * @param seatMapImgIdLessThanOrEqual  (optional)
   * @param seatMapImgIdEquals  (optional)
   * @param seatMapImgIdNotEquals  (optional)
   * @param seatMapImgIdSpecified  (optional)
   * @param seatMapImgIdIn  (optional)
   * @param seatMapImgIdNotIn  (optional)
   * @param vehicleIdGreaterThan  (optional)
   * @param vehicleIdLessThan  (optional)
   * @param vehicleIdGreaterThanOrEqual  (optional)
   * @param vehicleIdLessThanOrEqual  (optional)
   * @param vehicleIdEquals  (optional)
   * @param vehicleIdNotEquals  (optional)
   * @param vehicleIdSpecified  (optional)
   * @param vehicleIdIn  (optional)
   * @param vehicleIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/seat-maps/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&seatMapImgId.greaterThan={seatMapImgIdGreaterThan}&seatMapImgId.lessThan={seatMapImgIdLessThan}&seatMapImgId.greaterThanOrEqual={seatMapImgIdGreaterThanOrEqual}&seatMapImgId.lessThanOrEqual={seatMapImgIdLessThanOrEqual}&seatMapImgId.equals={seatMapImgIdEquals}&seatMapImgId.notEquals={seatMapImgIdNotEquals}&seatMapImgId.specified={seatMapImgIdSpecified}&seatMapImgId.in={seatMapImgIdIn}&seatMapImgId.notIn={seatMapImgIdNotIn}&vehicleId.greaterThan={vehicleIdGreaterThan}&vehicleId.lessThan={vehicleIdLessThan}&vehicleId.greaterThanOrEqual={vehicleIdGreaterThanOrEqual}&vehicleId.lessThanOrEqual={vehicleIdLessThanOrEqual}&vehicleId.equals={vehicleIdEquals}&vehicleId.notEquals={vehicleIdNotEquals}&vehicleId.specified={vehicleIdSpecified}&vehicleId.in={vehicleIdIn}&vehicleId.notIn={vehicleIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Long> countSeatMapsWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("nameContains") @jakarta.annotation.Nullable String nameContains, @Param("nameDoesNotContain") @jakarta.annotation.Nullable String nameDoesNotContain, @Param("nameEquals") @jakarta.annotation.Nullable String nameEquals, @Param("nameNotEquals") @jakarta.annotation.Nullable String nameNotEquals, @Param("nameSpecified") @jakarta.annotation.Nullable Boolean nameSpecified, @Param("nameIn") @jakarta.annotation.Nullable List<String> nameIn, @Param("nameNotIn") @jakarta.annotation.Nullable List<String> nameNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("seatMapImgIdGreaterThan") @jakarta.annotation.Nullable Long seatMapImgIdGreaterThan, @Param("seatMapImgIdLessThan") @jakarta.annotation.Nullable Long seatMapImgIdLessThan, @Param("seatMapImgIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long seatMapImgIdGreaterThanOrEqual, @Param("seatMapImgIdLessThanOrEqual") @jakarta.annotation.Nullable Long seatMapImgIdLessThanOrEqual, @Param("seatMapImgIdEquals") @jakarta.annotation.Nullable Long seatMapImgIdEquals, @Param("seatMapImgIdNotEquals") @jakarta.annotation.Nullable Long seatMapImgIdNotEquals, @Param("seatMapImgIdSpecified") @jakarta.annotation.Nullable Boolean seatMapImgIdSpecified, @Param("seatMapImgIdIn") @jakarta.annotation.Nullable List<Long> seatMapImgIdIn, @Param("seatMapImgIdNotIn") @jakarta.annotation.Nullable List<Long> seatMapImgIdNotIn, @Param("vehicleIdGreaterThan") @jakarta.annotation.Nullable Long vehicleIdGreaterThan, @Param("vehicleIdLessThan") @jakarta.annotation.Nullable Long vehicleIdLessThan, @Param("vehicleIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long vehicleIdGreaterThanOrEqual, @Param("vehicleIdLessThanOrEqual") @jakarta.annotation.Nullable Long vehicleIdLessThanOrEqual, @Param("vehicleIdEquals") @jakarta.annotation.Nullable Long vehicleIdEquals, @Param("vehicleIdNotEquals") @jakarta.annotation.Nullable Long vehicleIdNotEquals, @Param("vehicleIdSpecified") @jakarta.annotation.Nullable Boolean vehicleIdSpecified, @Param("vehicleIdIn") @jakarta.annotation.Nullable List<Long> vehicleIdIn, @Param("vehicleIdNotIn") @jakarta.annotation.Nullable List<Long> vehicleIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>countSeatMaps</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CountSeatMapsQueryParams} class that allows for
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
   *   <li>seatMapImgIdGreaterThan -  (optional)</li>
   *   <li>seatMapImgIdLessThan -  (optional)</li>
   *   <li>seatMapImgIdGreaterThanOrEqual -  (optional)</li>
   *   <li>seatMapImgIdLessThanOrEqual -  (optional)</li>
   *   <li>seatMapImgIdEquals -  (optional)</li>
   *   <li>seatMapImgIdNotEquals -  (optional)</li>
   *   <li>seatMapImgIdSpecified -  (optional)</li>
   *   <li>seatMapImgIdIn -  (optional)</li>
   *   <li>seatMapImgIdNotIn -  (optional)</li>
   *   <li>vehicleIdGreaterThan -  (optional)</li>
   *   <li>vehicleIdLessThan -  (optional)</li>
   *   <li>vehicleIdGreaterThanOrEqual -  (optional)</li>
   *   <li>vehicleIdLessThanOrEqual -  (optional)</li>
   *   <li>vehicleIdEquals -  (optional)</li>
   *   <li>vehicleIdNotEquals -  (optional)</li>
   *   <li>vehicleIdSpecified -  (optional)</li>
   *   <li>vehicleIdIn -  (optional)</li>
   *   <li>vehicleIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return Long
   */
  @RequestLine("GET /api/seat-maps/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&seatMapImgId.greaterThan={seatMapImgIdGreaterThan}&seatMapImgId.lessThan={seatMapImgIdLessThan}&seatMapImgId.greaterThanOrEqual={seatMapImgIdGreaterThanOrEqual}&seatMapImgId.lessThanOrEqual={seatMapImgIdLessThanOrEqual}&seatMapImgId.equals={seatMapImgIdEquals}&seatMapImgId.notEquals={seatMapImgIdNotEquals}&seatMapImgId.specified={seatMapImgIdSpecified}&seatMapImgId.in={seatMapImgIdIn}&seatMapImgId.notIn={seatMapImgIdNotIn}&vehicleId.greaterThan={vehicleIdGreaterThan}&vehicleId.lessThan={vehicleIdLessThan}&vehicleId.greaterThanOrEqual={vehicleIdGreaterThanOrEqual}&vehicleId.lessThanOrEqual={vehicleIdLessThanOrEqual}&vehicleId.equals={vehicleIdEquals}&vehicleId.notEquals={vehicleIdNotEquals}&vehicleId.specified={vehicleIdSpecified}&vehicleId.in={vehicleIdIn}&vehicleId.notIn={vehicleIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  Long countSeatMaps(@QueryMap(encoded=true) CountSeatMapsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>countSeatMaps</code> that receives the query parameters as a map,
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
          *   <li>seatMapImgIdGreaterThan -  (optional)</li>
          *   <li>seatMapImgIdLessThan -  (optional)</li>
          *   <li>seatMapImgIdGreaterThanOrEqual -  (optional)</li>
          *   <li>seatMapImgIdLessThanOrEqual -  (optional)</li>
          *   <li>seatMapImgIdEquals -  (optional)</li>
          *   <li>seatMapImgIdNotEquals -  (optional)</li>
          *   <li>seatMapImgIdSpecified -  (optional)</li>
          *   <li>seatMapImgIdIn -  (optional)</li>
          *   <li>seatMapImgIdNotIn -  (optional)</li>
          *   <li>vehicleIdGreaterThan -  (optional)</li>
          *   <li>vehicleIdLessThan -  (optional)</li>
          *   <li>vehicleIdGreaterThanOrEqual -  (optional)</li>
          *   <li>vehicleIdLessThanOrEqual -  (optional)</li>
          *   <li>vehicleIdEquals -  (optional)</li>
          *   <li>vehicleIdNotEquals -  (optional)</li>
          *   <li>vehicleIdSpecified -  (optional)</li>
          *   <li>vehicleIdIn -  (optional)</li>
          *   <li>vehicleIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return Long
      */
      @RequestLine("GET /api/seat-maps/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&seatMapImgId.greaterThan={seatMapImgIdGreaterThan}&seatMapImgId.lessThan={seatMapImgIdLessThan}&seatMapImgId.greaterThanOrEqual={seatMapImgIdGreaterThanOrEqual}&seatMapImgId.lessThanOrEqual={seatMapImgIdLessThanOrEqual}&seatMapImgId.equals={seatMapImgIdEquals}&seatMapImgId.notEquals={seatMapImgIdNotEquals}&seatMapImgId.specified={seatMapImgIdSpecified}&seatMapImgId.in={seatMapImgIdIn}&seatMapImgId.notIn={seatMapImgIdNotIn}&vehicleId.greaterThan={vehicleIdGreaterThan}&vehicleId.lessThan={vehicleIdLessThan}&vehicleId.greaterThanOrEqual={vehicleIdGreaterThanOrEqual}&vehicleId.lessThanOrEqual={vehicleIdLessThanOrEqual}&vehicleId.equals={vehicleIdEquals}&vehicleId.notEquals={vehicleIdNotEquals}&vehicleId.specified={vehicleIdSpecified}&vehicleId.in={vehicleIdIn}&vehicleId.notIn={vehicleIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Long> countSeatMapsWithHttpInfo(@QueryMap(encoded=true) CountSeatMapsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>countSeatMaps</code> method in a fluent style.
   */
  public static class CountSeatMapsQueryParams extends HashMap<String, Object> {
    public CountSeatMapsQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatMapsQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatMapsQueryParams nameContains(@jakarta.annotation.Nullable final String value) {
      put("name.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams nameDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("name.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams nameEquals(@jakarta.annotation.Nullable final String value) {
      put("name.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams nameNotEquals(@jakarta.annotation.Nullable final String value) {
      put("name.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams nameSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("name.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams nameIn(@jakarta.annotation.Nullable final List<String> value) {
      put("name.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatMapsQueryParams nameNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("name.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatMapsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatMapsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatMapsQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatMapsQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatMapsQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatMapsQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatMapsQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatMapsQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatMapsQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatMapsQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatMapsQueryParams seatMapImgIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("seatMapImgId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams seatMapImgIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("seatMapImgId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams seatMapImgIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("seatMapImgId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams seatMapImgIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("seatMapImgId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams seatMapImgIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("seatMapImgId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams seatMapImgIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("seatMapImgId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams seatMapImgIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("seatMapImgId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams seatMapImgIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("seatMapImgId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatMapsQueryParams seatMapImgIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("seatMapImgId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatMapsQueryParams vehicleIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("vehicleId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams vehicleIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("vehicleId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams vehicleIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("vehicleId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams vehicleIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("vehicleId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams vehicleIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("vehicleId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams vehicleIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("vehicleId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams vehicleIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("vehicleId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatMapsQueryParams vehicleIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("vehicleId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatMapsQueryParams vehicleIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("vehicleId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatMapsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param seatMapDTO  (required)
   * @return SeatMapDTO
   */
  @RequestLine("POST /api/seat-maps")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  SeatMapDTO createSeatMap(@jakarta.annotation.Nonnull SeatMapDTO seatMapDTO);

  /**
   * 
   * Similar to <code>createSeatMap</code> but it also returns the http response headers .
   * 
   * @param seatMapDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/seat-maps")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<SeatMapDTO> createSeatMapWithHttpInfo(@jakarta.annotation.Nonnull SeatMapDTO seatMapDTO);



  /**
   * 
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/seat-maps/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteSeatMap(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>deleteSeatMap</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/seat-maps/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteSeatMapWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



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
   * @param seatMapImgIdGreaterThan  (optional)
   * @param seatMapImgIdLessThan  (optional)
   * @param seatMapImgIdGreaterThanOrEqual  (optional)
   * @param seatMapImgIdLessThanOrEqual  (optional)
   * @param seatMapImgIdEquals  (optional)
   * @param seatMapImgIdNotEquals  (optional)
   * @param seatMapImgIdSpecified  (optional)
   * @param seatMapImgIdIn  (optional)
   * @param seatMapImgIdNotIn  (optional)
   * @param vehicleIdGreaterThan  (optional)
   * @param vehicleIdLessThan  (optional)
   * @param vehicleIdGreaterThanOrEqual  (optional)
   * @param vehicleIdLessThanOrEqual  (optional)
   * @param vehicleIdEquals  (optional)
   * @param vehicleIdNotEquals  (optional)
   * @param vehicleIdSpecified  (optional)
   * @param vehicleIdIn  (optional)
   * @param vehicleIdNotIn  (optional)
   * @param distinct  (optional)
   * @return List&lt;SeatMapDTO&gt;
   */
  @RequestLine("GET /api/seat-maps?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&seatMapImgId.greaterThan={seatMapImgIdGreaterThan}&seatMapImgId.lessThan={seatMapImgIdLessThan}&seatMapImgId.greaterThanOrEqual={seatMapImgIdGreaterThanOrEqual}&seatMapImgId.lessThanOrEqual={seatMapImgIdLessThanOrEqual}&seatMapImgId.equals={seatMapImgIdEquals}&seatMapImgId.notEquals={seatMapImgIdNotEquals}&seatMapImgId.specified={seatMapImgIdSpecified}&seatMapImgId.in={seatMapImgIdIn}&seatMapImgId.notIn={seatMapImgIdNotIn}&vehicleId.greaterThan={vehicleIdGreaterThan}&vehicleId.lessThan={vehicleIdLessThan}&vehicleId.greaterThanOrEqual={vehicleIdGreaterThanOrEqual}&vehicleId.lessThanOrEqual={vehicleIdLessThanOrEqual}&vehicleId.equals={vehicleIdEquals}&vehicleId.notEquals={vehicleIdNotEquals}&vehicleId.specified={vehicleIdSpecified}&vehicleId.in={vehicleIdIn}&vehicleId.notIn={vehicleIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  List<SeatMapDTO> getAllSeatMaps(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("nameContains") @jakarta.annotation.Nullable String nameContains, @Param("nameDoesNotContain") @jakarta.annotation.Nullable String nameDoesNotContain, @Param("nameEquals") @jakarta.annotation.Nullable String nameEquals, @Param("nameNotEquals") @jakarta.annotation.Nullable String nameNotEquals, @Param("nameSpecified") @jakarta.annotation.Nullable Boolean nameSpecified, @Param("nameIn") @jakarta.annotation.Nullable List<String> nameIn, @Param("nameNotIn") @jakarta.annotation.Nullable List<String> nameNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("seatMapImgIdGreaterThan") @jakarta.annotation.Nullable Long seatMapImgIdGreaterThan, @Param("seatMapImgIdLessThan") @jakarta.annotation.Nullable Long seatMapImgIdLessThan, @Param("seatMapImgIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long seatMapImgIdGreaterThanOrEqual, @Param("seatMapImgIdLessThanOrEqual") @jakarta.annotation.Nullable Long seatMapImgIdLessThanOrEqual, @Param("seatMapImgIdEquals") @jakarta.annotation.Nullable Long seatMapImgIdEquals, @Param("seatMapImgIdNotEquals") @jakarta.annotation.Nullable Long seatMapImgIdNotEquals, @Param("seatMapImgIdSpecified") @jakarta.annotation.Nullable Boolean seatMapImgIdSpecified, @Param("seatMapImgIdIn") @jakarta.annotation.Nullable List<Long> seatMapImgIdIn, @Param("seatMapImgIdNotIn") @jakarta.annotation.Nullable List<Long> seatMapImgIdNotIn, @Param("vehicleIdGreaterThan") @jakarta.annotation.Nullable Long vehicleIdGreaterThan, @Param("vehicleIdLessThan") @jakarta.annotation.Nullable Long vehicleIdLessThan, @Param("vehicleIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long vehicleIdGreaterThanOrEqual, @Param("vehicleIdLessThanOrEqual") @jakarta.annotation.Nullable Long vehicleIdLessThanOrEqual, @Param("vehicleIdEquals") @jakarta.annotation.Nullable Long vehicleIdEquals, @Param("vehicleIdNotEquals") @jakarta.annotation.Nullable Long vehicleIdNotEquals, @Param("vehicleIdSpecified") @jakarta.annotation.Nullable Boolean vehicleIdSpecified, @Param("vehicleIdIn") @jakarta.annotation.Nullable List<Long> vehicleIdIn, @Param("vehicleIdNotIn") @jakarta.annotation.Nullable List<Long> vehicleIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>getAllSeatMaps</code> but it also returns the http response headers .
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
   * @param seatMapImgIdGreaterThan  (optional)
   * @param seatMapImgIdLessThan  (optional)
   * @param seatMapImgIdGreaterThanOrEqual  (optional)
   * @param seatMapImgIdLessThanOrEqual  (optional)
   * @param seatMapImgIdEquals  (optional)
   * @param seatMapImgIdNotEquals  (optional)
   * @param seatMapImgIdSpecified  (optional)
   * @param seatMapImgIdIn  (optional)
   * @param seatMapImgIdNotIn  (optional)
   * @param vehicleIdGreaterThan  (optional)
   * @param vehicleIdLessThan  (optional)
   * @param vehicleIdGreaterThanOrEqual  (optional)
   * @param vehicleIdLessThanOrEqual  (optional)
   * @param vehicleIdEquals  (optional)
   * @param vehicleIdNotEquals  (optional)
   * @param vehicleIdSpecified  (optional)
   * @param vehicleIdIn  (optional)
   * @param vehicleIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/seat-maps?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&seatMapImgId.greaterThan={seatMapImgIdGreaterThan}&seatMapImgId.lessThan={seatMapImgIdLessThan}&seatMapImgId.greaterThanOrEqual={seatMapImgIdGreaterThanOrEqual}&seatMapImgId.lessThanOrEqual={seatMapImgIdLessThanOrEqual}&seatMapImgId.equals={seatMapImgIdEquals}&seatMapImgId.notEquals={seatMapImgIdNotEquals}&seatMapImgId.specified={seatMapImgIdSpecified}&seatMapImgId.in={seatMapImgIdIn}&seatMapImgId.notIn={seatMapImgIdNotIn}&vehicleId.greaterThan={vehicleIdGreaterThan}&vehicleId.lessThan={vehicleIdLessThan}&vehicleId.greaterThanOrEqual={vehicleIdGreaterThanOrEqual}&vehicleId.lessThanOrEqual={vehicleIdLessThanOrEqual}&vehicleId.equals={vehicleIdEquals}&vehicleId.notEquals={vehicleIdNotEquals}&vehicleId.specified={vehicleIdSpecified}&vehicleId.in={vehicleIdIn}&vehicleId.notIn={vehicleIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<SeatMapDTO>> getAllSeatMapsWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("nameContains") @jakarta.annotation.Nullable String nameContains, @Param("nameDoesNotContain") @jakarta.annotation.Nullable String nameDoesNotContain, @Param("nameEquals") @jakarta.annotation.Nullable String nameEquals, @Param("nameNotEquals") @jakarta.annotation.Nullable String nameNotEquals, @Param("nameSpecified") @jakarta.annotation.Nullable Boolean nameSpecified, @Param("nameIn") @jakarta.annotation.Nullable List<String> nameIn, @Param("nameNotIn") @jakarta.annotation.Nullable List<String> nameNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("seatMapImgIdGreaterThan") @jakarta.annotation.Nullable Long seatMapImgIdGreaterThan, @Param("seatMapImgIdLessThan") @jakarta.annotation.Nullable Long seatMapImgIdLessThan, @Param("seatMapImgIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long seatMapImgIdGreaterThanOrEqual, @Param("seatMapImgIdLessThanOrEqual") @jakarta.annotation.Nullable Long seatMapImgIdLessThanOrEqual, @Param("seatMapImgIdEquals") @jakarta.annotation.Nullable Long seatMapImgIdEquals, @Param("seatMapImgIdNotEquals") @jakarta.annotation.Nullable Long seatMapImgIdNotEquals, @Param("seatMapImgIdSpecified") @jakarta.annotation.Nullable Boolean seatMapImgIdSpecified, @Param("seatMapImgIdIn") @jakarta.annotation.Nullable List<Long> seatMapImgIdIn, @Param("seatMapImgIdNotIn") @jakarta.annotation.Nullable List<Long> seatMapImgIdNotIn, @Param("vehicleIdGreaterThan") @jakarta.annotation.Nullable Long vehicleIdGreaterThan, @Param("vehicleIdLessThan") @jakarta.annotation.Nullable Long vehicleIdLessThan, @Param("vehicleIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long vehicleIdGreaterThanOrEqual, @Param("vehicleIdLessThanOrEqual") @jakarta.annotation.Nullable Long vehicleIdLessThanOrEqual, @Param("vehicleIdEquals") @jakarta.annotation.Nullable Long vehicleIdEquals, @Param("vehicleIdNotEquals") @jakarta.annotation.Nullable Long vehicleIdNotEquals, @Param("vehicleIdSpecified") @jakarta.annotation.Nullable Boolean vehicleIdSpecified, @Param("vehicleIdIn") @jakarta.annotation.Nullable List<Long> vehicleIdIn, @Param("vehicleIdNotIn") @jakarta.annotation.Nullable List<Long> vehicleIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllSeatMaps</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllSeatMapsQueryParams} class that allows for
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
   *   <li>seatMapImgIdGreaterThan -  (optional)</li>
   *   <li>seatMapImgIdLessThan -  (optional)</li>
   *   <li>seatMapImgIdGreaterThanOrEqual -  (optional)</li>
   *   <li>seatMapImgIdLessThanOrEqual -  (optional)</li>
   *   <li>seatMapImgIdEquals -  (optional)</li>
   *   <li>seatMapImgIdNotEquals -  (optional)</li>
   *   <li>seatMapImgIdSpecified -  (optional)</li>
   *   <li>seatMapImgIdIn -  (optional)</li>
   *   <li>seatMapImgIdNotIn -  (optional)</li>
   *   <li>vehicleIdGreaterThan -  (optional)</li>
   *   <li>vehicleIdLessThan -  (optional)</li>
   *   <li>vehicleIdGreaterThanOrEqual -  (optional)</li>
   *   <li>vehicleIdLessThanOrEqual -  (optional)</li>
   *   <li>vehicleIdEquals -  (optional)</li>
   *   <li>vehicleIdNotEquals -  (optional)</li>
   *   <li>vehicleIdSpecified -  (optional)</li>
   *   <li>vehicleIdIn -  (optional)</li>
   *   <li>vehicleIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return List&lt;SeatMapDTO&gt;
   */
  @RequestLine("GET /api/seat-maps?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&seatMapImgId.greaterThan={seatMapImgIdGreaterThan}&seatMapImgId.lessThan={seatMapImgIdLessThan}&seatMapImgId.greaterThanOrEqual={seatMapImgIdGreaterThanOrEqual}&seatMapImgId.lessThanOrEqual={seatMapImgIdLessThanOrEqual}&seatMapImgId.equals={seatMapImgIdEquals}&seatMapImgId.notEquals={seatMapImgIdNotEquals}&seatMapImgId.specified={seatMapImgIdSpecified}&seatMapImgId.in={seatMapImgIdIn}&seatMapImgId.notIn={seatMapImgIdNotIn}&vehicleId.greaterThan={vehicleIdGreaterThan}&vehicleId.lessThan={vehicleIdLessThan}&vehicleId.greaterThanOrEqual={vehicleIdGreaterThanOrEqual}&vehicleId.lessThanOrEqual={vehicleIdLessThanOrEqual}&vehicleId.equals={vehicleIdEquals}&vehicleId.notEquals={vehicleIdNotEquals}&vehicleId.specified={vehicleIdSpecified}&vehicleId.in={vehicleIdIn}&vehicleId.notIn={vehicleIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  List<SeatMapDTO> getAllSeatMaps(@QueryMap(encoded=true) GetAllSeatMapsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllSeatMaps</code> that receives the query parameters as a map,
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
          *   <li>seatMapImgIdGreaterThan -  (optional)</li>
          *   <li>seatMapImgIdLessThan -  (optional)</li>
          *   <li>seatMapImgIdGreaterThanOrEqual -  (optional)</li>
          *   <li>seatMapImgIdLessThanOrEqual -  (optional)</li>
          *   <li>seatMapImgIdEquals -  (optional)</li>
          *   <li>seatMapImgIdNotEquals -  (optional)</li>
          *   <li>seatMapImgIdSpecified -  (optional)</li>
          *   <li>seatMapImgIdIn -  (optional)</li>
          *   <li>seatMapImgIdNotIn -  (optional)</li>
          *   <li>vehicleIdGreaterThan -  (optional)</li>
          *   <li>vehicleIdLessThan -  (optional)</li>
          *   <li>vehicleIdGreaterThanOrEqual -  (optional)</li>
          *   <li>vehicleIdLessThanOrEqual -  (optional)</li>
          *   <li>vehicleIdEquals -  (optional)</li>
          *   <li>vehicleIdNotEquals -  (optional)</li>
          *   <li>vehicleIdSpecified -  (optional)</li>
          *   <li>vehicleIdIn -  (optional)</li>
          *   <li>vehicleIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return List&lt;SeatMapDTO&gt;
      */
      @RequestLine("GET /api/seat-maps?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&name.contains={nameContains}&name.doesNotContain={nameDoesNotContain}&name.equals={nameEquals}&name.notEquals={nameNotEquals}&name.specified={nameSpecified}&name.in={nameIn}&name.notIn={nameNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&seatMapImgId.greaterThan={seatMapImgIdGreaterThan}&seatMapImgId.lessThan={seatMapImgIdLessThan}&seatMapImgId.greaterThanOrEqual={seatMapImgIdGreaterThanOrEqual}&seatMapImgId.lessThanOrEqual={seatMapImgIdLessThanOrEqual}&seatMapImgId.equals={seatMapImgIdEquals}&seatMapImgId.notEquals={seatMapImgIdNotEquals}&seatMapImgId.specified={seatMapImgIdSpecified}&seatMapImgId.in={seatMapImgIdIn}&seatMapImgId.notIn={seatMapImgIdNotIn}&vehicleId.greaterThan={vehicleIdGreaterThan}&vehicleId.lessThan={vehicleIdLessThan}&vehicleId.greaterThanOrEqual={vehicleIdGreaterThanOrEqual}&vehicleId.lessThanOrEqual={vehicleIdLessThanOrEqual}&vehicleId.equals={vehicleIdEquals}&vehicleId.notEquals={vehicleIdNotEquals}&vehicleId.specified={vehicleIdSpecified}&vehicleId.in={vehicleIdIn}&vehicleId.notIn={vehicleIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<SeatMapDTO>> getAllSeatMapsWithHttpInfo(@QueryMap(encoded=true) GetAllSeatMapsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllSeatMaps</code> method in a fluent style.
   */
  public static class GetAllSeatMapsQueryParams extends HashMap<String, Object> {
    public GetAllSeatMapsQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatMapsQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatMapsQueryParams nameContains(@jakarta.annotation.Nullable final String value) {
      put("name.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams nameDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("name.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams nameEquals(@jakarta.annotation.Nullable final String value) {
      put("name.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams nameNotEquals(@jakarta.annotation.Nullable final String value) {
      put("name.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams nameSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("name.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams nameIn(@jakarta.annotation.Nullable final List<String> value) {
      put("name.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatMapsQueryParams nameNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("name.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatMapsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatMapsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatMapsQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatMapsQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatMapsQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatMapsQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatMapsQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatMapsQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatMapsQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatMapsQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatMapsQueryParams seatMapImgIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("seatMapImgId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams seatMapImgIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("seatMapImgId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams seatMapImgIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("seatMapImgId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams seatMapImgIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("seatMapImgId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams seatMapImgIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("seatMapImgId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams seatMapImgIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("seatMapImgId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams seatMapImgIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("seatMapImgId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams seatMapImgIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("seatMapImgId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatMapsQueryParams seatMapImgIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("seatMapImgId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatMapsQueryParams vehicleIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("vehicleId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams vehicleIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("vehicleId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams vehicleIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("vehicleId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams vehicleIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("vehicleId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams vehicleIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("vehicleId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams vehicleIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("vehicleId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams vehicleIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("vehicleId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatMapsQueryParams vehicleIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("vehicleId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatMapsQueryParams vehicleIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("vehicleId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatMapsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @return SeatMapDTO
   */
  @RequestLine("GET /api/seat-maps/{id}")
  @Headers({
    "Accept: */*",
  })
  SeatMapDTO getSeatMap(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>getSeatMap</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/seat-maps/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<SeatMapDTO> getSeatMapWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param id  (required)
   * @return SeatMapDetailVM
   */
  @RequestLine("GET /api/seat-maps/{id}/detail")
  @Headers({
    "Accept: */*",
  })
  SeatMapDetailVM getSeatMapDetail(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>getSeatMapDetail</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/seat-maps/{id}/detail")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<SeatMapDetailVM> getSeatMapDetailWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param id  (required)
   * @param seatMapDTO  (required)
   * @return SeatMapDTO
   */
  @RequestLine("PATCH /api/seat-maps/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  SeatMapDTO partialUpdateSeatMap(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull SeatMapDTO seatMapDTO);

  /**
   * 
   * Similar to <code>partialUpdateSeatMap</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param seatMapDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /api/seat-maps/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<SeatMapDTO> partialUpdateSeatMapWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull SeatMapDTO seatMapDTO);



  /**
   * 
   * 
   * @param id  (required)
   * @param seatMapDTO  (required)
   * @return SeatMapDTO
   */
  @RequestLine("PUT /api/seat-maps/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  SeatMapDTO updateSeatMap(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull SeatMapDTO seatMapDTO);

  /**
   * 
   * Similar to <code>updateSeatMap</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param seatMapDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/seat-maps/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<SeatMapDTO> updateSeatMapWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull SeatMapDTO seatMapDTO);


}
