package com.ridehub.msroute.client.api;

import com.ridehub.msroute.client.invoker.ApiClient;
import com.ridehub.msroute.client.invoker.EncodingUtils;
import com.ridehub.msroute.client.model.ApiResponse;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import com.ridehub.msroute.client.model.SeatDTO;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface SeatResourceMsrouteApi extends ApiClient.Api {


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
   * @param seatNoContains  (optional)
   * @param seatNoDoesNotContain  (optional)
   * @param seatNoEquals  (optional)
   * @param seatNoNotEquals  (optional)
   * @param seatNoSpecified  (optional)
   * @param seatNoIn  (optional)
   * @param seatNoNotIn  (optional)
   * @param rowNoGreaterThan  (optional)
   * @param rowNoLessThan  (optional)
   * @param rowNoGreaterThanOrEqual  (optional)
   * @param rowNoLessThanOrEqual  (optional)
   * @param rowNoEquals  (optional)
   * @param rowNoNotEquals  (optional)
   * @param rowNoSpecified  (optional)
   * @param rowNoIn  (optional)
   * @param rowNoNotIn  (optional)
   * @param colNoGreaterThan  (optional)
   * @param colNoLessThan  (optional)
   * @param colNoGreaterThanOrEqual  (optional)
   * @param colNoLessThanOrEqual  (optional)
   * @param colNoEquals  (optional)
   * @param colNoNotEquals  (optional)
   * @param colNoSpecified  (optional)
   * @param colNoIn  (optional)
   * @param colNoNotIn  (optional)
   * @param priceFactorGreaterThan  (optional)
   * @param priceFactorLessThan  (optional)
   * @param priceFactorGreaterThanOrEqual  (optional)
   * @param priceFactorLessThanOrEqual  (optional)
   * @param priceFactorEquals  (optional)
   * @param priceFactorNotEquals  (optional)
   * @param priceFactorSpecified  (optional)
   * @param priceFactorIn  (optional)
   * @param priceFactorNotIn  (optional)
   * @param typeEquals  (optional)
   * @param typeNotEquals  (optional)
   * @param typeSpecified  (optional)
   * @param typeIn  (optional)
   * @param typeNotIn  (optional)
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
   * @param floorIdGreaterThan  (optional)
   * @param floorIdLessThan  (optional)
   * @param floorIdGreaterThanOrEqual  (optional)
   * @param floorIdLessThanOrEqual  (optional)
   * @param floorIdEquals  (optional)
   * @param floorIdNotEquals  (optional)
   * @param floorIdSpecified  (optional)
   * @param floorIdIn  (optional)
   * @param floorIdNotIn  (optional)
   * @param distinct  (optional)
   * @return Long
   */
  @RequestLine("GET /api/seats/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&seatNo.contains={seatNoContains}&seatNo.doesNotContain={seatNoDoesNotContain}&seatNo.equals={seatNoEquals}&seatNo.notEquals={seatNoNotEquals}&seatNo.specified={seatNoSpecified}&seatNo.in={seatNoIn}&seatNo.notIn={seatNoNotIn}&rowNo.greaterThan={rowNoGreaterThan}&rowNo.lessThan={rowNoLessThan}&rowNo.greaterThanOrEqual={rowNoGreaterThanOrEqual}&rowNo.lessThanOrEqual={rowNoLessThanOrEqual}&rowNo.equals={rowNoEquals}&rowNo.notEquals={rowNoNotEquals}&rowNo.specified={rowNoSpecified}&rowNo.in={rowNoIn}&rowNo.notIn={rowNoNotIn}&colNo.greaterThan={colNoGreaterThan}&colNo.lessThan={colNoLessThan}&colNo.greaterThanOrEqual={colNoGreaterThanOrEqual}&colNo.lessThanOrEqual={colNoLessThanOrEqual}&colNo.equals={colNoEquals}&colNo.notEquals={colNoNotEquals}&colNo.specified={colNoSpecified}&colNo.in={colNoIn}&colNo.notIn={colNoNotIn}&priceFactor.greaterThan={priceFactorGreaterThan}&priceFactor.lessThan={priceFactorLessThan}&priceFactor.greaterThanOrEqual={priceFactorGreaterThanOrEqual}&priceFactor.lessThanOrEqual={priceFactorLessThanOrEqual}&priceFactor.equals={priceFactorEquals}&priceFactor.notEquals={priceFactorNotEquals}&priceFactor.specified={priceFactorSpecified}&priceFactor.in={priceFactorIn}&priceFactor.notIn={priceFactorNotIn}&type.equals={typeEquals}&type.notEquals={typeNotEquals}&type.specified={typeSpecified}&type.in={typeIn}&type.notIn={typeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&floorId.greaterThan={floorIdGreaterThan}&floorId.lessThan={floorIdLessThan}&floorId.greaterThanOrEqual={floorIdGreaterThanOrEqual}&floorId.lessThanOrEqual={floorIdLessThanOrEqual}&floorId.equals={floorIdEquals}&floorId.notEquals={floorIdNotEquals}&floorId.specified={floorIdSpecified}&floorId.in={floorIdIn}&floorId.notIn={floorIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  Long countSeats(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("seatNoContains") @jakarta.annotation.Nullable String seatNoContains, @Param("seatNoDoesNotContain") @jakarta.annotation.Nullable String seatNoDoesNotContain, @Param("seatNoEquals") @jakarta.annotation.Nullable String seatNoEquals, @Param("seatNoNotEquals") @jakarta.annotation.Nullable String seatNoNotEquals, @Param("seatNoSpecified") @jakarta.annotation.Nullable Boolean seatNoSpecified, @Param("seatNoIn") @jakarta.annotation.Nullable List<String> seatNoIn, @Param("seatNoNotIn") @jakarta.annotation.Nullable List<String> seatNoNotIn, @Param("rowNoGreaterThan") @jakarta.annotation.Nullable Integer rowNoGreaterThan, @Param("rowNoLessThan") @jakarta.annotation.Nullable Integer rowNoLessThan, @Param("rowNoGreaterThanOrEqual") @jakarta.annotation.Nullable Integer rowNoGreaterThanOrEqual, @Param("rowNoLessThanOrEqual") @jakarta.annotation.Nullable Integer rowNoLessThanOrEqual, @Param("rowNoEquals") @jakarta.annotation.Nullable Integer rowNoEquals, @Param("rowNoNotEquals") @jakarta.annotation.Nullable Integer rowNoNotEquals, @Param("rowNoSpecified") @jakarta.annotation.Nullable Boolean rowNoSpecified, @Param("rowNoIn") @jakarta.annotation.Nullable List<Integer> rowNoIn, @Param("rowNoNotIn") @jakarta.annotation.Nullable List<Integer> rowNoNotIn, @Param("colNoGreaterThan") @jakarta.annotation.Nullable Integer colNoGreaterThan, @Param("colNoLessThan") @jakarta.annotation.Nullable Integer colNoLessThan, @Param("colNoGreaterThanOrEqual") @jakarta.annotation.Nullable Integer colNoGreaterThanOrEqual, @Param("colNoLessThanOrEqual") @jakarta.annotation.Nullable Integer colNoLessThanOrEqual, @Param("colNoEquals") @jakarta.annotation.Nullable Integer colNoEquals, @Param("colNoNotEquals") @jakarta.annotation.Nullable Integer colNoNotEquals, @Param("colNoSpecified") @jakarta.annotation.Nullable Boolean colNoSpecified, @Param("colNoIn") @jakarta.annotation.Nullable List<Integer> colNoIn, @Param("colNoNotIn") @jakarta.annotation.Nullable List<Integer> colNoNotIn, @Param("priceFactorGreaterThan") @jakarta.annotation.Nullable BigDecimal priceFactorGreaterThan, @Param("priceFactorLessThan") @jakarta.annotation.Nullable BigDecimal priceFactorLessThan, @Param("priceFactorGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal priceFactorGreaterThanOrEqual, @Param("priceFactorLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal priceFactorLessThanOrEqual, @Param("priceFactorEquals") @jakarta.annotation.Nullable BigDecimal priceFactorEquals, @Param("priceFactorNotEquals") @jakarta.annotation.Nullable BigDecimal priceFactorNotEquals, @Param("priceFactorSpecified") @jakarta.annotation.Nullable Boolean priceFactorSpecified, @Param("priceFactorIn") @jakarta.annotation.Nullable List<BigDecimal> priceFactorIn, @Param("priceFactorNotIn") @jakarta.annotation.Nullable List<BigDecimal> priceFactorNotIn, @Param("typeEquals") @jakarta.annotation.Nullable String typeEquals, @Param("typeNotEquals") @jakarta.annotation.Nullable String typeNotEquals, @Param("typeSpecified") @jakarta.annotation.Nullable Boolean typeSpecified, @Param("typeIn") @jakarta.annotation.Nullable List<String> typeIn, @Param("typeNotIn") @jakarta.annotation.Nullable List<String> typeNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("floorIdGreaterThan") @jakarta.annotation.Nullable Long floorIdGreaterThan, @Param("floorIdLessThan") @jakarta.annotation.Nullable Long floorIdLessThan, @Param("floorIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long floorIdGreaterThanOrEqual, @Param("floorIdLessThanOrEqual") @jakarta.annotation.Nullable Long floorIdLessThanOrEqual, @Param("floorIdEquals") @jakarta.annotation.Nullable Long floorIdEquals, @Param("floorIdNotEquals") @jakarta.annotation.Nullable Long floorIdNotEquals, @Param("floorIdSpecified") @jakarta.annotation.Nullable Boolean floorIdSpecified, @Param("floorIdIn") @jakarta.annotation.Nullable List<Long> floorIdIn, @Param("floorIdNotIn") @jakarta.annotation.Nullable List<Long> floorIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>countSeats</code> but it also returns the http response headers .
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
   * @param seatNoContains  (optional)
   * @param seatNoDoesNotContain  (optional)
   * @param seatNoEquals  (optional)
   * @param seatNoNotEquals  (optional)
   * @param seatNoSpecified  (optional)
   * @param seatNoIn  (optional)
   * @param seatNoNotIn  (optional)
   * @param rowNoGreaterThan  (optional)
   * @param rowNoLessThan  (optional)
   * @param rowNoGreaterThanOrEqual  (optional)
   * @param rowNoLessThanOrEqual  (optional)
   * @param rowNoEquals  (optional)
   * @param rowNoNotEquals  (optional)
   * @param rowNoSpecified  (optional)
   * @param rowNoIn  (optional)
   * @param rowNoNotIn  (optional)
   * @param colNoGreaterThan  (optional)
   * @param colNoLessThan  (optional)
   * @param colNoGreaterThanOrEqual  (optional)
   * @param colNoLessThanOrEqual  (optional)
   * @param colNoEquals  (optional)
   * @param colNoNotEquals  (optional)
   * @param colNoSpecified  (optional)
   * @param colNoIn  (optional)
   * @param colNoNotIn  (optional)
   * @param priceFactorGreaterThan  (optional)
   * @param priceFactorLessThan  (optional)
   * @param priceFactorGreaterThanOrEqual  (optional)
   * @param priceFactorLessThanOrEqual  (optional)
   * @param priceFactorEquals  (optional)
   * @param priceFactorNotEquals  (optional)
   * @param priceFactorSpecified  (optional)
   * @param priceFactorIn  (optional)
   * @param priceFactorNotIn  (optional)
   * @param typeEquals  (optional)
   * @param typeNotEquals  (optional)
   * @param typeSpecified  (optional)
   * @param typeIn  (optional)
   * @param typeNotIn  (optional)
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
   * @param floorIdGreaterThan  (optional)
   * @param floorIdLessThan  (optional)
   * @param floorIdGreaterThanOrEqual  (optional)
   * @param floorIdLessThanOrEqual  (optional)
   * @param floorIdEquals  (optional)
   * @param floorIdNotEquals  (optional)
   * @param floorIdSpecified  (optional)
   * @param floorIdIn  (optional)
   * @param floorIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/seats/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&seatNo.contains={seatNoContains}&seatNo.doesNotContain={seatNoDoesNotContain}&seatNo.equals={seatNoEquals}&seatNo.notEquals={seatNoNotEquals}&seatNo.specified={seatNoSpecified}&seatNo.in={seatNoIn}&seatNo.notIn={seatNoNotIn}&rowNo.greaterThan={rowNoGreaterThan}&rowNo.lessThan={rowNoLessThan}&rowNo.greaterThanOrEqual={rowNoGreaterThanOrEqual}&rowNo.lessThanOrEqual={rowNoLessThanOrEqual}&rowNo.equals={rowNoEquals}&rowNo.notEquals={rowNoNotEquals}&rowNo.specified={rowNoSpecified}&rowNo.in={rowNoIn}&rowNo.notIn={rowNoNotIn}&colNo.greaterThan={colNoGreaterThan}&colNo.lessThan={colNoLessThan}&colNo.greaterThanOrEqual={colNoGreaterThanOrEqual}&colNo.lessThanOrEqual={colNoLessThanOrEqual}&colNo.equals={colNoEquals}&colNo.notEquals={colNoNotEquals}&colNo.specified={colNoSpecified}&colNo.in={colNoIn}&colNo.notIn={colNoNotIn}&priceFactor.greaterThan={priceFactorGreaterThan}&priceFactor.lessThan={priceFactorLessThan}&priceFactor.greaterThanOrEqual={priceFactorGreaterThanOrEqual}&priceFactor.lessThanOrEqual={priceFactorLessThanOrEqual}&priceFactor.equals={priceFactorEquals}&priceFactor.notEquals={priceFactorNotEquals}&priceFactor.specified={priceFactorSpecified}&priceFactor.in={priceFactorIn}&priceFactor.notIn={priceFactorNotIn}&type.equals={typeEquals}&type.notEquals={typeNotEquals}&type.specified={typeSpecified}&type.in={typeIn}&type.notIn={typeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&floorId.greaterThan={floorIdGreaterThan}&floorId.lessThan={floorIdLessThan}&floorId.greaterThanOrEqual={floorIdGreaterThanOrEqual}&floorId.lessThanOrEqual={floorIdLessThanOrEqual}&floorId.equals={floorIdEquals}&floorId.notEquals={floorIdNotEquals}&floorId.specified={floorIdSpecified}&floorId.in={floorIdIn}&floorId.notIn={floorIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Long> countSeatsWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("seatNoContains") @jakarta.annotation.Nullable String seatNoContains, @Param("seatNoDoesNotContain") @jakarta.annotation.Nullable String seatNoDoesNotContain, @Param("seatNoEquals") @jakarta.annotation.Nullable String seatNoEquals, @Param("seatNoNotEquals") @jakarta.annotation.Nullable String seatNoNotEquals, @Param("seatNoSpecified") @jakarta.annotation.Nullable Boolean seatNoSpecified, @Param("seatNoIn") @jakarta.annotation.Nullable List<String> seatNoIn, @Param("seatNoNotIn") @jakarta.annotation.Nullable List<String> seatNoNotIn, @Param("rowNoGreaterThan") @jakarta.annotation.Nullable Integer rowNoGreaterThan, @Param("rowNoLessThan") @jakarta.annotation.Nullable Integer rowNoLessThan, @Param("rowNoGreaterThanOrEqual") @jakarta.annotation.Nullable Integer rowNoGreaterThanOrEqual, @Param("rowNoLessThanOrEqual") @jakarta.annotation.Nullable Integer rowNoLessThanOrEqual, @Param("rowNoEquals") @jakarta.annotation.Nullable Integer rowNoEquals, @Param("rowNoNotEquals") @jakarta.annotation.Nullable Integer rowNoNotEquals, @Param("rowNoSpecified") @jakarta.annotation.Nullable Boolean rowNoSpecified, @Param("rowNoIn") @jakarta.annotation.Nullable List<Integer> rowNoIn, @Param("rowNoNotIn") @jakarta.annotation.Nullable List<Integer> rowNoNotIn, @Param("colNoGreaterThan") @jakarta.annotation.Nullable Integer colNoGreaterThan, @Param("colNoLessThan") @jakarta.annotation.Nullable Integer colNoLessThan, @Param("colNoGreaterThanOrEqual") @jakarta.annotation.Nullable Integer colNoGreaterThanOrEqual, @Param("colNoLessThanOrEqual") @jakarta.annotation.Nullable Integer colNoLessThanOrEqual, @Param("colNoEquals") @jakarta.annotation.Nullable Integer colNoEquals, @Param("colNoNotEquals") @jakarta.annotation.Nullable Integer colNoNotEquals, @Param("colNoSpecified") @jakarta.annotation.Nullable Boolean colNoSpecified, @Param("colNoIn") @jakarta.annotation.Nullable List<Integer> colNoIn, @Param("colNoNotIn") @jakarta.annotation.Nullable List<Integer> colNoNotIn, @Param("priceFactorGreaterThan") @jakarta.annotation.Nullable BigDecimal priceFactorGreaterThan, @Param("priceFactorLessThan") @jakarta.annotation.Nullable BigDecimal priceFactorLessThan, @Param("priceFactorGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal priceFactorGreaterThanOrEqual, @Param("priceFactorLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal priceFactorLessThanOrEqual, @Param("priceFactorEquals") @jakarta.annotation.Nullable BigDecimal priceFactorEquals, @Param("priceFactorNotEquals") @jakarta.annotation.Nullable BigDecimal priceFactorNotEquals, @Param("priceFactorSpecified") @jakarta.annotation.Nullable Boolean priceFactorSpecified, @Param("priceFactorIn") @jakarta.annotation.Nullable List<BigDecimal> priceFactorIn, @Param("priceFactorNotIn") @jakarta.annotation.Nullable List<BigDecimal> priceFactorNotIn, @Param("typeEquals") @jakarta.annotation.Nullable String typeEquals, @Param("typeNotEquals") @jakarta.annotation.Nullable String typeNotEquals, @Param("typeSpecified") @jakarta.annotation.Nullable Boolean typeSpecified, @Param("typeIn") @jakarta.annotation.Nullable List<String> typeIn, @Param("typeNotIn") @jakarta.annotation.Nullable List<String> typeNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("floorIdGreaterThan") @jakarta.annotation.Nullable Long floorIdGreaterThan, @Param("floorIdLessThan") @jakarta.annotation.Nullable Long floorIdLessThan, @Param("floorIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long floorIdGreaterThanOrEqual, @Param("floorIdLessThanOrEqual") @jakarta.annotation.Nullable Long floorIdLessThanOrEqual, @Param("floorIdEquals") @jakarta.annotation.Nullable Long floorIdEquals, @Param("floorIdNotEquals") @jakarta.annotation.Nullable Long floorIdNotEquals, @Param("floorIdSpecified") @jakarta.annotation.Nullable Boolean floorIdSpecified, @Param("floorIdIn") @jakarta.annotation.Nullable List<Long> floorIdIn, @Param("floorIdNotIn") @jakarta.annotation.Nullable List<Long> floorIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>countSeats</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CountSeatsQueryParams} class that allows for
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
   *   <li>seatNoContains -  (optional)</li>
   *   <li>seatNoDoesNotContain -  (optional)</li>
   *   <li>seatNoEquals -  (optional)</li>
   *   <li>seatNoNotEquals -  (optional)</li>
   *   <li>seatNoSpecified -  (optional)</li>
   *   <li>seatNoIn -  (optional)</li>
   *   <li>seatNoNotIn -  (optional)</li>
   *   <li>rowNoGreaterThan -  (optional)</li>
   *   <li>rowNoLessThan -  (optional)</li>
   *   <li>rowNoGreaterThanOrEqual -  (optional)</li>
   *   <li>rowNoLessThanOrEqual -  (optional)</li>
   *   <li>rowNoEquals -  (optional)</li>
   *   <li>rowNoNotEquals -  (optional)</li>
   *   <li>rowNoSpecified -  (optional)</li>
   *   <li>rowNoIn -  (optional)</li>
   *   <li>rowNoNotIn -  (optional)</li>
   *   <li>colNoGreaterThan -  (optional)</li>
   *   <li>colNoLessThan -  (optional)</li>
   *   <li>colNoGreaterThanOrEqual -  (optional)</li>
   *   <li>colNoLessThanOrEqual -  (optional)</li>
   *   <li>colNoEquals -  (optional)</li>
   *   <li>colNoNotEquals -  (optional)</li>
   *   <li>colNoSpecified -  (optional)</li>
   *   <li>colNoIn -  (optional)</li>
   *   <li>colNoNotIn -  (optional)</li>
   *   <li>priceFactorGreaterThan -  (optional)</li>
   *   <li>priceFactorLessThan -  (optional)</li>
   *   <li>priceFactorGreaterThanOrEqual -  (optional)</li>
   *   <li>priceFactorLessThanOrEqual -  (optional)</li>
   *   <li>priceFactorEquals -  (optional)</li>
   *   <li>priceFactorNotEquals -  (optional)</li>
   *   <li>priceFactorSpecified -  (optional)</li>
   *   <li>priceFactorIn -  (optional)</li>
   *   <li>priceFactorNotIn -  (optional)</li>
   *   <li>typeEquals -  (optional)</li>
   *   <li>typeNotEquals -  (optional)</li>
   *   <li>typeSpecified -  (optional)</li>
   *   <li>typeIn -  (optional)</li>
   *   <li>typeNotIn -  (optional)</li>
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
   *   <li>floorIdGreaterThan -  (optional)</li>
   *   <li>floorIdLessThan -  (optional)</li>
   *   <li>floorIdGreaterThanOrEqual -  (optional)</li>
   *   <li>floorIdLessThanOrEqual -  (optional)</li>
   *   <li>floorIdEquals -  (optional)</li>
   *   <li>floorIdNotEquals -  (optional)</li>
   *   <li>floorIdSpecified -  (optional)</li>
   *   <li>floorIdIn -  (optional)</li>
   *   <li>floorIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return Long
   */
  @RequestLine("GET /api/seats/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&seatNo.contains={seatNoContains}&seatNo.doesNotContain={seatNoDoesNotContain}&seatNo.equals={seatNoEquals}&seatNo.notEquals={seatNoNotEquals}&seatNo.specified={seatNoSpecified}&seatNo.in={seatNoIn}&seatNo.notIn={seatNoNotIn}&rowNo.greaterThan={rowNoGreaterThan}&rowNo.lessThan={rowNoLessThan}&rowNo.greaterThanOrEqual={rowNoGreaterThanOrEqual}&rowNo.lessThanOrEqual={rowNoLessThanOrEqual}&rowNo.equals={rowNoEquals}&rowNo.notEquals={rowNoNotEquals}&rowNo.specified={rowNoSpecified}&rowNo.in={rowNoIn}&rowNo.notIn={rowNoNotIn}&colNo.greaterThan={colNoGreaterThan}&colNo.lessThan={colNoLessThan}&colNo.greaterThanOrEqual={colNoGreaterThanOrEqual}&colNo.lessThanOrEqual={colNoLessThanOrEqual}&colNo.equals={colNoEquals}&colNo.notEquals={colNoNotEquals}&colNo.specified={colNoSpecified}&colNo.in={colNoIn}&colNo.notIn={colNoNotIn}&priceFactor.greaterThan={priceFactorGreaterThan}&priceFactor.lessThan={priceFactorLessThan}&priceFactor.greaterThanOrEqual={priceFactorGreaterThanOrEqual}&priceFactor.lessThanOrEqual={priceFactorLessThanOrEqual}&priceFactor.equals={priceFactorEquals}&priceFactor.notEquals={priceFactorNotEquals}&priceFactor.specified={priceFactorSpecified}&priceFactor.in={priceFactorIn}&priceFactor.notIn={priceFactorNotIn}&type.equals={typeEquals}&type.notEquals={typeNotEquals}&type.specified={typeSpecified}&type.in={typeIn}&type.notIn={typeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&floorId.greaterThan={floorIdGreaterThan}&floorId.lessThan={floorIdLessThan}&floorId.greaterThanOrEqual={floorIdGreaterThanOrEqual}&floorId.lessThanOrEqual={floorIdLessThanOrEqual}&floorId.equals={floorIdEquals}&floorId.notEquals={floorIdNotEquals}&floorId.specified={floorIdSpecified}&floorId.in={floorIdIn}&floorId.notIn={floorIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  Long countSeats(@QueryMap(encoded=true) CountSeatsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>countSeats</code> that receives the query parameters as a map,
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
          *   <li>seatNoContains -  (optional)</li>
          *   <li>seatNoDoesNotContain -  (optional)</li>
          *   <li>seatNoEquals -  (optional)</li>
          *   <li>seatNoNotEquals -  (optional)</li>
          *   <li>seatNoSpecified -  (optional)</li>
          *   <li>seatNoIn -  (optional)</li>
          *   <li>seatNoNotIn -  (optional)</li>
          *   <li>rowNoGreaterThan -  (optional)</li>
          *   <li>rowNoLessThan -  (optional)</li>
          *   <li>rowNoGreaterThanOrEqual -  (optional)</li>
          *   <li>rowNoLessThanOrEqual -  (optional)</li>
          *   <li>rowNoEquals -  (optional)</li>
          *   <li>rowNoNotEquals -  (optional)</li>
          *   <li>rowNoSpecified -  (optional)</li>
          *   <li>rowNoIn -  (optional)</li>
          *   <li>rowNoNotIn -  (optional)</li>
          *   <li>colNoGreaterThan -  (optional)</li>
          *   <li>colNoLessThan -  (optional)</li>
          *   <li>colNoGreaterThanOrEqual -  (optional)</li>
          *   <li>colNoLessThanOrEqual -  (optional)</li>
          *   <li>colNoEquals -  (optional)</li>
          *   <li>colNoNotEquals -  (optional)</li>
          *   <li>colNoSpecified -  (optional)</li>
          *   <li>colNoIn -  (optional)</li>
          *   <li>colNoNotIn -  (optional)</li>
          *   <li>priceFactorGreaterThan -  (optional)</li>
          *   <li>priceFactorLessThan -  (optional)</li>
          *   <li>priceFactorGreaterThanOrEqual -  (optional)</li>
          *   <li>priceFactorLessThanOrEqual -  (optional)</li>
          *   <li>priceFactorEquals -  (optional)</li>
          *   <li>priceFactorNotEquals -  (optional)</li>
          *   <li>priceFactorSpecified -  (optional)</li>
          *   <li>priceFactorIn -  (optional)</li>
          *   <li>priceFactorNotIn -  (optional)</li>
          *   <li>typeEquals -  (optional)</li>
          *   <li>typeNotEquals -  (optional)</li>
          *   <li>typeSpecified -  (optional)</li>
          *   <li>typeIn -  (optional)</li>
          *   <li>typeNotIn -  (optional)</li>
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
          *   <li>floorIdGreaterThan -  (optional)</li>
          *   <li>floorIdLessThan -  (optional)</li>
          *   <li>floorIdGreaterThanOrEqual -  (optional)</li>
          *   <li>floorIdLessThanOrEqual -  (optional)</li>
          *   <li>floorIdEquals -  (optional)</li>
          *   <li>floorIdNotEquals -  (optional)</li>
          *   <li>floorIdSpecified -  (optional)</li>
          *   <li>floorIdIn -  (optional)</li>
          *   <li>floorIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return Long
      */
      @RequestLine("GET /api/seats/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&seatNo.contains={seatNoContains}&seatNo.doesNotContain={seatNoDoesNotContain}&seatNo.equals={seatNoEquals}&seatNo.notEquals={seatNoNotEquals}&seatNo.specified={seatNoSpecified}&seatNo.in={seatNoIn}&seatNo.notIn={seatNoNotIn}&rowNo.greaterThan={rowNoGreaterThan}&rowNo.lessThan={rowNoLessThan}&rowNo.greaterThanOrEqual={rowNoGreaterThanOrEqual}&rowNo.lessThanOrEqual={rowNoLessThanOrEqual}&rowNo.equals={rowNoEquals}&rowNo.notEquals={rowNoNotEquals}&rowNo.specified={rowNoSpecified}&rowNo.in={rowNoIn}&rowNo.notIn={rowNoNotIn}&colNo.greaterThan={colNoGreaterThan}&colNo.lessThan={colNoLessThan}&colNo.greaterThanOrEqual={colNoGreaterThanOrEqual}&colNo.lessThanOrEqual={colNoLessThanOrEqual}&colNo.equals={colNoEquals}&colNo.notEquals={colNoNotEquals}&colNo.specified={colNoSpecified}&colNo.in={colNoIn}&colNo.notIn={colNoNotIn}&priceFactor.greaterThan={priceFactorGreaterThan}&priceFactor.lessThan={priceFactorLessThan}&priceFactor.greaterThanOrEqual={priceFactorGreaterThanOrEqual}&priceFactor.lessThanOrEqual={priceFactorLessThanOrEqual}&priceFactor.equals={priceFactorEquals}&priceFactor.notEquals={priceFactorNotEquals}&priceFactor.specified={priceFactorSpecified}&priceFactor.in={priceFactorIn}&priceFactor.notIn={priceFactorNotIn}&type.equals={typeEquals}&type.notEquals={typeNotEquals}&type.specified={typeSpecified}&type.in={typeIn}&type.notIn={typeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&floorId.greaterThan={floorIdGreaterThan}&floorId.lessThan={floorIdLessThan}&floorId.greaterThanOrEqual={floorIdGreaterThanOrEqual}&floorId.lessThanOrEqual={floorIdLessThanOrEqual}&floorId.equals={floorIdEquals}&floorId.notEquals={floorIdNotEquals}&floorId.specified={floorIdSpecified}&floorId.in={floorIdIn}&floorId.notIn={floorIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Long> countSeatsWithHttpInfo(@QueryMap(encoded=true) CountSeatsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>countSeats</code> method in a fluent style.
   */
  public static class CountSeatsQueryParams extends HashMap<String, Object> {
    public CountSeatsQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatsQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatsQueryParams seatNoContains(@jakarta.annotation.Nullable final String value) {
      put("seatNo.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams seatNoDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("seatNo.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams seatNoEquals(@jakarta.annotation.Nullable final String value) {
      put("seatNo.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams seatNoNotEquals(@jakarta.annotation.Nullable final String value) {
      put("seatNo.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams seatNoSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("seatNo.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams seatNoIn(@jakarta.annotation.Nullable final List<String> value) {
      put("seatNo.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatsQueryParams seatNoNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("seatNo.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatsQueryParams rowNoGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("rowNo.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams rowNoLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("rowNo.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams rowNoGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("rowNo.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams rowNoLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("rowNo.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams rowNoEquals(@jakarta.annotation.Nullable final Integer value) {
      put("rowNo.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams rowNoNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("rowNo.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams rowNoSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("rowNo.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams rowNoIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("rowNo.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatsQueryParams rowNoNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("rowNo.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatsQueryParams colNoGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("colNo.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams colNoLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("colNo.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams colNoGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("colNo.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams colNoLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("colNo.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams colNoEquals(@jakarta.annotation.Nullable final Integer value) {
      put("colNo.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams colNoNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("colNo.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams colNoSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("colNo.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams colNoIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("colNo.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatsQueryParams colNoNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("colNo.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatsQueryParams priceFactorGreaterThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("priceFactor.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams priceFactorLessThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("priceFactor.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams priceFactorGreaterThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("priceFactor.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams priceFactorLessThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("priceFactor.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams priceFactorEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("priceFactor.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams priceFactorNotEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("priceFactor.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams priceFactorSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("priceFactor.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams priceFactorIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("priceFactor.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatsQueryParams priceFactorNotIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("priceFactor.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatsQueryParams typeEquals(@jakarta.annotation.Nullable final String value) {
      put("type.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams typeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("type.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams typeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("type.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams typeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("type.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatsQueryParams typeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("type.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatsQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatsQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatsQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatsQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatsQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatsQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatsQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatsQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatsQueryParams floorIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("floorId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams floorIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("floorId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams floorIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("floorId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams floorIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("floorId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams floorIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("floorId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams floorIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("floorId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams floorIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("floorId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatsQueryParams floorIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("floorId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatsQueryParams floorIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("floorId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param seatDTO  (required)
   * @return SeatDTO
   */
  @RequestLine("POST /api/seats")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  SeatDTO createSeat(@jakarta.annotation.Nonnull SeatDTO seatDTO);

  /**
   * 
   * Similar to <code>createSeat</code> but it also returns the http response headers .
   * 
   * @param seatDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/seats")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<SeatDTO> createSeatWithHttpInfo(@jakarta.annotation.Nonnull SeatDTO seatDTO);



  /**
   * 
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/seats/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteSeat(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>deleteSeat</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/seats/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteSeatWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



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
   * @param seatNoContains  (optional)
   * @param seatNoDoesNotContain  (optional)
   * @param seatNoEquals  (optional)
   * @param seatNoNotEquals  (optional)
   * @param seatNoSpecified  (optional)
   * @param seatNoIn  (optional)
   * @param seatNoNotIn  (optional)
   * @param rowNoGreaterThan  (optional)
   * @param rowNoLessThan  (optional)
   * @param rowNoGreaterThanOrEqual  (optional)
   * @param rowNoLessThanOrEqual  (optional)
   * @param rowNoEquals  (optional)
   * @param rowNoNotEquals  (optional)
   * @param rowNoSpecified  (optional)
   * @param rowNoIn  (optional)
   * @param rowNoNotIn  (optional)
   * @param colNoGreaterThan  (optional)
   * @param colNoLessThan  (optional)
   * @param colNoGreaterThanOrEqual  (optional)
   * @param colNoLessThanOrEqual  (optional)
   * @param colNoEquals  (optional)
   * @param colNoNotEquals  (optional)
   * @param colNoSpecified  (optional)
   * @param colNoIn  (optional)
   * @param colNoNotIn  (optional)
   * @param priceFactorGreaterThan  (optional)
   * @param priceFactorLessThan  (optional)
   * @param priceFactorGreaterThanOrEqual  (optional)
   * @param priceFactorLessThanOrEqual  (optional)
   * @param priceFactorEquals  (optional)
   * @param priceFactorNotEquals  (optional)
   * @param priceFactorSpecified  (optional)
   * @param priceFactorIn  (optional)
   * @param priceFactorNotIn  (optional)
   * @param typeEquals  (optional)
   * @param typeNotEquals  (optional)
   * @param typeSpecified  (optional)
   * @param typeIn  (optional)
   * @param typeNotIn  (optional)
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
   * @param floorIdGreaterThan  (optional)
   * @param floorIdLessThan  (optional)
   * @param floorIdGreaterThanOrEqual  (optional)
   * @param floorIdLessThanOrEqual  (optional)
   * @param floorIdEquals  (optional)
   * @param floorIdNotEquals  (optional)
   * @param floorIdSpecified  (optional)
   * @param floorIdIn  (optional)
   * @param floorIdNotIn  (optional)
   * @param distinct  (optional)
   * @return List&lt;SeatDTO&gt;
   */
  @RequestLine("GET /api/seats?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&seatNo.contains={seatNoContains}&seatNo.doesNotContain={seatNoDoesNotContain}&seatNo.equals={seatNoEquals}&seatNo.notEquals={seatNoNotEquals}&seatNo.specified={seatNoSpecified}&seatNo.in={seatNoIn}&seatNo.notIn={seatNoNotIn}&rowNo.greaterThan={rowNoGreaterThan}&rowNo.lessThan={rowNoLessThan}&rowNo.greaterThanOrEqual={rowNoGreaterThanOrEqual}&rowNo.lessThanOrEqual={rowNoLessThanOrEqual}&rowNo.equals={rowNoEquals}&rowNo.notEquals={rowNoNotEquals}&rowNo.specified={rowNoSpecified}&rowNo.in={rowNoIn}&rowNo.notIn={rowNoNotIn}&colNo.greaterThan={colNoGreaterThan}&colNo.lessThan={colNoLessThan}&colNo.greaterThanOrEqual={colNoGreaterThanOrEqual}&colNo.lessThanOrEqual={colNoLessThanOrEqual}&colNo.equals={colNoEquals}&colNo.notEquals={colNoNotEquals}&colNo.specified={colNoSpecified}&colNo.in={colNoIn}&colNo.notIn={colNoNotIn}&priceFactor.greaterThan={priceFactorGreaterThan}&priceFactor.lessThan={priceFactorLessThan}&priceFactor.greaterThanOrEqual={priceFactorGreaterThanOrEqual}&priceFactor.lessThanOrEqual={priceFactorLessThanOrEqual}&priceFactor.equals={priceFactorEquals}&priceFactor.notEquals={priceFactorNotEquals}&priceFactor.specified={priceFactorSpecified}&priceFactor.in={priceFactorIn}&priceFactor.notIn={priceFactorNotIn}&type.equals={typeEquals}&type.notEquals={typeNotEquals}&type.specified={typeSpecified}&type.in={typeIn}&type.notIn={typeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&floorId.greaterThan={floorIdGreaterThan}&floorId.lessThan={floorIdLessThan}&floorId.greaterThanOrEqual={floorIdGreaterThanOrEqual}&floorId.lessThanOrEqual={floorIdLessThanOrEqual}&floorId.equals={floorIdEquals}&floorId.notEquals={floorIdNotEquals}&floorId.specified={floorIdSpecified}&floorId.in={floorIdIn}&floorId.notIn={floorIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  List<SeatDTO> getAllSeats(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("seatNoContains") @jakarta.annotation.Nullable String seatNoContains, @Param("seatNoDoesNotContain") @jakarta.annotation.Nullable String seatNoDoesNotContain, @Param("seatNoEquals") @jakarta.annotation.Nullable String seatNoEquals, @Param("seatNoNotEquals") @jakarta.annotation.Nullable String seatNoNotEquals, @Param("seatNoSpecified") @jakarta.annotation.Nullable Boolean seatNoSpecified, @Param("seatNoIn") @jakarta.annotation.Nullable List<String> seatNoIn, @Param("seatNoNotIn") @jakarta.annotation.Nullable List<String> seatNoNotIn, @Param("rowNoGreaterThan") @jakarta.annotation.Nullable Integer rowNoGreaterThan, @Param("rowNoLessThan") @jakarta.annotation.Nullable Integer rowNoLessThan, @Param("rowNoGreaterThanOrEqual") @jakarta.annotation.Nullable Integer rowNoGreaterThanOrEqual, @Param("rowNoLessThanOrEqual") @jakarta.annotation.Nullable Integer rowNoLessThanOrEqual, @Param("rowNoEquals") @jakarta.annotation.Nullable Integer rowNoEquals, @Param("rowNoNotEquals") @jakarta.annotation.Nullable Integer rowNoNotEquals, @Param("rowNoSpecified") @jakarta.annotation.Nullable Boolean rowNoSpecified, @Param("rowNoIn") @jakarta.annotation.Nullable List<Integer> rowNoIn, @Param("rowNoNotIn") @jakarta.annotation.Nullable List<Integer> rowNoNotIn, @Param("colNoGreaterThan") @jakarta.annotation.Nullable Integer colNoGreaterThan, @Param("colNoLessThan") @jakarta.annotation.Nullable Integer colNoLessThan, @Param("colNoGreaterThanOrEqual") @jakarta.annotation.Nullable Integer colNoGreaterThanOrEqual, @Param("colNoLessThanOrEqual") @jakarta.annotation.Nullable Integer colNoLessThanOrEqual, @Param("colNoEquals") @jakarta.annotation.Nullable Integer colNoEquals, @Param("colNoNotEquals") @jakarta.annotation.Nullable Integer colNoNotEquals, @Param("colNoSpecified") @jakarta.annotation.Nullable Boolean colNoSpecified, @Param("colNoIn") @jakarta.annotation.Nullable List<Integer> colNoIn, @Param("colNoNotIn") @jakarta.annotation.Nullable List<Integer> colNoNotIn, @Param("priceFactorGreaterThan") @jakarta.annotation.Nullable BigDecimal priceFactorGreaterThan, @Param("priceFactorLessThan") @jakarta.annotation.Nullable BigDecimal priceFactorLessThan, @Param("priceFactorGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal priceFactorGreaterThanOrEqual, @Param("priceFactorLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal priceFactorLessThanOrEqual, @Param("priceFactorEquals") @jakarta.annotation.Nullable BigDecimal priceFactorEquals, @Param("priceFactorNotEquals") @jakarta.annotation.Nullable BigDecimal priceFactorNotEquals, @Param("priceFactorSpecified") @jakarta.annotation.Nullable Boolean priceFactorSpecified, @Param("priceFactorIn") @jakarta.annotation.Nullable List<BigDecimal> priceFactorIn, @Param("priceFactorNotIn") @jakarta.annotation.Nullable List<BigDecimal> priceFactorNotIn, @Param("typeEquals") @jakarta.annotation.Nullable String typeEquals, @Param("typeNotEquals") @jakarta.annotation.Nullable String typeNotEquals, @Param("typeSpecified") @jakarta.annotation.Nullable Boolean typeSpecified, @Param("typeIn") @jakarta.annotation.Nullable List<String> typeIn, @Param("typeNotIn") @jakarta.annotation.Nullable List<String> typeNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("floorIdGreaterThan") @jakarta.annotation.Nullable Long floorIdGreaterThan, @Param("floorIdLessThan") @jakarta.annotation.Nullable Long floorIdLessThan, @Param("floorIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long floorIdGreaterThanOrEqual, @Param("floorIdLessThanOrEqual") @jakarta.annotation.Nullable Long floorIdLessThanOrEqual, @Param("floorIdEquals") @jakarta.annotation.Nullable Long floorIdEquals, @Param("floorIdNotEquals") @jakarta.annotation.Nullable Long floorIdNotEquals, @Param("floorIdSpecified") @jakarta.annotation.Nullable Boolean floorIdSpecified, @Param("floorIdIn") @jakarta.annotation.Nullable List<Long> floorIdIn, @Param("floorIdNotIn") @jakarta.annotation.Nullable List<Long> floorIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>getAllSeats</code> but it also returns the http response headers .
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
   * @param seatNoContains  (optional)
   * @param seatNoDoesNotContain  (optional)
   * @param seatNoEquals  (optional)
   * @param seatNoNotEquals  (optional)
   * @param seatNoSpecified  (optional)
   * @param seatNoIn  (optional)
   * @param seatNoNotIn  (optional)
   * @param rowNoGreaterThan  (optional)
   * @param rowNoLessThan  (optional)
   * @param rowNoGreaterThanOrEqual  (optional)
   * @param rowNoLessThanOrEqual  (optional)
   * @param rowNoEquals  (optional)
   * @param rowNoNotEquals  (optional)
   * @param rowNoSpecified  (optional)
   * @param rowNoIn  (optional)
   * @param rowNoNotIn  (optional)
   * @param colNoGreaterThan  (optional)
   * @param colNoLessThan  (optional)
   * @param colNoGreaterThanOrEqual  (optional)
   * @param colNoLessThanOrEqual  (optional)
   * @param colNoEquals  (optional)
   * @param colNoNotEquals  (optional)
   * @param colNoSpecified  (optional)
   * @param colNoIn  (optional)
   * @param colNoNotIn  (optional)
   * @param priceFactorGreaterThan  (optional)
   * @param priceFactorLessThan  (optional)
   * @param priceFactorGreaterThanOrEqual  (optional)
   * @param priceFactorLessThanOrEqual  (optional)
   * @param priceFactorEquals  (optional)
   * @param priceFactorNotEquals  (optional)
   * @param priceFactorSpecified  (optional)
   * @param priceFactorIn  (optional)
   * @param priceFactorNotIn  (optional)
   * @param typeEquals  (optional)
   * @param typeNotEquals  (optional)
   * @param typeSpecified  (optional)
   * @param typeIn  (optional)
   * @param typeNotIn  (optional)
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
   * @param floorIdGreaterThan  (optional)
   * @param floorIdLessThan  (optional)
   * @param floorIdGreaterThanOrEqual  (optional)
   * @param floorIdLessThanOrEqual  (optional)
   * @param floorIdEquals  (optional)
   * @param floorIdNotEquals  (optional)
   * @param floorIdSpecified  (optional)
   * @param floorIdIn  (optional)
   * @param floorIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/seats?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&seatNo.contains={seatNoContains}&seatNo.doesNotContain={seatNoDoesNotContain}&seatNo.equals={seatNoEquals}&seatNo.notEquals={seatNoNotEquals}&seatNo.specified={seatNoSpecified}&seatNo.in={seatNoIn}&seatNo.notIn={seatNoNotIn}&rowNo.greaterThan={rowNoGreaterThan}&rowNo.lessThan={rowNoLessThan}&rowNo.greaterThanOrEqual={rowNoGreaterThanOrEqual}&rowNo.lessThanOrEqual={rowNoLessThanOrEqual}&rowNo.equals={rowNoEquals}&rowNo.notEquals={rowNoNotEquals}&rowNo.specified={rowNoSpecified}&rowNo.in={rowNoIn}&rowNo.notIn={rowNoNotIn}&colNo.greaterThan={colNoGreaterThan}&colNo.lessThan={colNoLessThan}&colNo.greaterThanOrEqual={colNoGreaterThanOrEqual}&colNo.lessThanOrEqual={colNoLessThanOrEqual}&colNo.equals={colNoEquals}&colNo.notEquals={colNoNotEquals}&colNo.specified={colNoSpecified}&colNo.in={colNoIn}&colNo.notIn={colNoNotIn}&priceFactor.greaterThan={priceFactorGreaterThan}&priceFactor.lessThan={priceFactorLessThan}&priceFactor.greaterThanOrEqual={priceFactorGreaterThanOrEqual}&priceFactor.lessThanOrEqual={priceFactorLessThanOrEqual}&priceFactor.equals={priceFactorEquals}&priceFactor.notEquals={priceFactorNotEquals}&priceFactor.specified={priceFactorSpecified}&priceFactor.in={priceFactorIn}&priceFactor.notIn={priceFactorNotIn}&type.equals={typeEquals}&type.notEquals={typeNotEquals}&type.specified={typeSpecified}&type.in={typeIn}&type.notIn={typeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&floorId.greaterThan={floorIdGreaterThan}&floorId.lessThan={floorIdLessThan}&floorId.greaterThanOrEqual={floorIdGreaterThanOrEqual}&floorId.lessThanOrEqual={floorIdLessThanOrEqual}&floorId.equals={floorIdEquals}&floorId.notEquals={floorIdNotEquals}&floorId.specified={floorIdSpecified}&floorId.in={floorIdIn}&floorId.notIn={floorIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<SeatDTO>> getAllSeatsWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("seatNoContains") @jakarta.annotation.Nullable String seatNoContains, @Param("seatNoDoesNotContain") @jakarta.annotation.Nullable String seatNoDoesNotContain, @Param("seatNoEquals") @jakarta.annotation.Nullable String seatNoEquals, @Param("seatNoNotEquals") @jakarta.annotation.Nullable String seatNoNotEquals, @Param("seatNoSpecified") @jakarta.annotation.Nullable Boolean seatNoSpecified, @Param("seatNoIn") @jakarta.annotation.Nullable List<String> seatNoIn, @Param("seatNoNotIn") @jakarta.annotation.Nullable List<String> seatNoNotIn, @Param("rowNoGreaterThan") @jakarta.annotation.Nullable Integer rowNoGreaterThan, @Param("rowNoLessThan") @jakarta.annotation.Nullable Integer rowNoLessThan, @Param("rowNoGreaterThanOrEqual") @jakarta.annotation.Nullable Integer rowNoGreaterThanOrEqual, @Param("rowNoLessThanOrEqual") @jakarta.annotation.Nullable Integer rowNoLessThanOrEqual, @Param("rowNoEquals") @jakarta.annotation.Nullable Integer rowNoEquals, @Param("rowNoNotEquals") @jakarta.annotation.Nullable Integer rowNoNotEquals, @Param("rowNoSpecified") @jakarta.annotation.Nullable Boolean rowNoSpecified, @Param("rowNoIn") @jakarta.annotation.Nullable List<Integer> rowNoIn, @Param("rowNoNotIn") @jakarta.annotation.Nullable List<Integer> rowNoNotIn, @Param("colNoGreaterThan") @jakarta.annotation.Nullable Integer colNoGreaterThan, @Param("colNoLessThan") @jakarta.annotation.Nullable Integer colNoLessThan, @Param("colNoGreaterThanOrEqual") @jakarta.annotation.Nullable Integer colNoGreaterThanOrEqual, @Param("colNoLessThanOrEqual") @jakarta.annotation.Nullable Integer colNoLessThanOrEqual, @Param("colNoEquals") @jakarta.annotation.Nullable Integer colNoEquals, @Param("colNoNotEquals") @jakarta.annotation.Nullable Integer colNoNotEquals, @Param("colNoSpecified") @jakarta.annotation.Nullable Boolean colNoSpecified, @Param("colNoIn") @jakarta.annotation.Nullable List<Integer> colNoIn, @Param("colNoNotIn") @jakarta.annotation.Nullable List<Integer> colNoNotIn, @Param("priceFactorGreaterThan") @jakarta.annotation.Nullable BigDecimal priceFactorGreaterThan, @Param("priceFactorLessThan") @jakarta.annotation.Nullable BigDecimal priceFactorLessThan, @Param("priceFactorGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal priceFactorGreaterThanOrEqual, @Param("priceFactorLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal priceFactorLessThanOrEqual, @Param("priceFactorEquals") @jakarta.annotation.Nullable BigDecimal priceFactorEquals, @Param("priceFactorNotEquals") @jakarta.annotation.Nullable BigDecimal priceFactorNotEquals, @Param("priceFactorSpecified") @jakarta.annotation.Nullable Boolean priceFactorSpecified, @Param("priceFactorIn") @jakarta.annotation.Nullable List<BigDecimal> priceFactorIn, @Param("priceFactorNotIn") @jakarta.annotation.Nullable List<BigDecimal> priceFactorNotIn, @Param("typeEquals") @jakarta.annotation.Nullable String typeEquals, @Param("typeNotEquals") @jakarta.annotation.Nullable String typeNotEquals, @Param("typeSpecified") @jakarta.annotation.Nullable Boolean typeSpecified, @Param("typeIn") @jakarta.annotation.Nullable List<String> typeIn, @Param("typeNotIn") @jakarta.annotation.Nullable List<String> typeNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("floorIdGreaterThan") @jakarta.annotation.Nullable Long floorIdGreaterThan, @Param("floorIdLessThan") @jakarta.annotation.Nullable Long floorIdLessThan, @Param("floorIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long floorIdGreaterThanOrEqual, @Param("floorIdLessThanOrEqual") @jakarta.annotation.Nullable Long floorIdLessThanOrEqual, @Param("floorIdEquals") @jakarta.annotation.Nullable Long floorIdEquals, @Param("floorIdNotEquals") @jakarta.annotation.Nullable Long floorIdNotEquals, @Param("floorIdSpecified") @jakarta.annotation.Nullable Boolean floorIdSpecified, @Param("floorIdIn") @jakarta.annotation.Nullable List<Long> floorIdIn, @Param("floorIdNotIn") @jakarta.annotation.Nullable List<Long> floorIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllSeats</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllSeatsQueryParams} class that allows for
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
   *   <li>seatNoContains -  (optional)</li>
   *   <li>seatNoDoesNotContain -  (optional)</li>
   *   <li>seatNoEquals -  (optional)</li>
   *   <li>seatNoNotEquals -  (optional)</li>
   *   <li>seatNoSpecified -  (optional)</li>
   *   <li>seatNoIn -  (optional)</li>
   *   <li>seatNoNotIn -  (optional)</li>
   *   <li>rowNoGreaterThan -  (optional)</li>
   *   <li>rowNoLessThan -  (optional)</li>
   *   <li>rowNoGreaterThanOrEqual -  (optional)</li>
   *   <li>rowNoLessThanOrEqual -  (optional)</li>
   *   <li>rowNoEquals -  (optional)</li>
   *   <li>rowNoNotEquals -  (optional)</li>
   *   <li>rowNoSpecified -  (optional)</li>
   *   <li>rowNoIn -  (optional)</li>
   *   <li>rowNoNotIn -  (optional)</li>
   *   <li>colNoGreaterThan -  (optional)</li>
   *   <li>colNoLessThan -  (optional)</li>
   *   <li>colNoGreaterThanOrEqual -  (optional)</li>
   *   <li>colNoLessThanOrEqual -  (optional)</li>
   *   <li>colNoEquals -  (optional)</li>
   *   <li>colNoNotEquals -  (optional)</li>
   *   <li>colNoSpecified -  (optional)</li>
   *   <li>colNoIn -  (optional)</li>
   *   <li>colNoNotIn -  (optional)</li>
   *   <li>priceFactorGreaterThan -  (optional)</li>
   *   <li>priceFactorLessThan -  (optional)</li>
   *   <li>priceFactorGreaterThanOrEqual -  (optional)</li>
   *   <li>priceFactorLessThanOrEqual -  (optional)</li>
   *   <li>priceFactorEquals -  (optional)</li>
   *   <li>priceFactorNotEquals -  (optional)</li>
   *   <li>priceFactorSpecified -  (optional)</li>
   *   <li>priceFactorIn -  (optional)</li>
   *   <li>priceFactorNotIn -  (optional)</li>
   *   <li>typeEquals -  (optional)</li>
   *   <li>typeNotEquals -  (optional)</li>
   *   <li>typeSpecified -  (optional)</li>
   *   <li>typeIn -  (optional)</li>
   *   <li>typeNotIn -  (optional)</li>
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
   *   <li>floorIdGreaterThan -  (optional)</li>
   *   <li>floorIdLessThan -  (optional)</li>
   *   <li>floorIdGreaterThanOrEqual -  (optional)</li>
   *   <li>floorIdLessThanOrEqual -  (optional)</li>
   *   <li>floorIdEquals -  (optional)</li>
   *   <li>floorIdNotEquals -  (optional)</li>
   *   <li>floorIdSpecified -  (optional)</li>
   *   <li>floorIdIn -  (optional)</li>
   *   <li>floorIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return List&lt;SeatDTO&gt;
   */
  @RequestLine("GET /api/seats?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&seatNo.contains={seatNoContains}&seatNo.doesNotContain={seatNoDoesNotContain}&seatNo.equals={seatNoEquals}&seatNo.notEquals={seatNoNotEquals}&seatNo.specified={seatNoSpecified}&seatNo.in={seatNoIn}&seatNo.notIn={seatNoNotIn}&rowNo.greaterThan={rowNoGreaterThan}&rowNo.lessThan={rowNoLessThan}&rowNo.greaterThanOrEqual={rowNoGreaterThanOrEqual}&rowNo.lessThanOrEqual={rowNoLessThanOrEqual}&rowNo.equals={rowNoEquals}&rowNo.notEquals={rowNoNotEquals}&rowNo.specified={rowNoSpecified}&rowNo.in={rowNoIn}&rowNo.notIn={rowNoNotIn}&colNo.greaterThan={colNoGreaterThan}&colNo.lessThan={colNoLessThan}&colNo.greaterThanOrEqual={colNoGreaterThanOrEqual}&colNo.lessThanOrEqual={colNoLessThanOrEqual}&colNo.equals={colNoEquals}&colNo.notEquals={colNoNotEquals}&colNo.specified={colNoSpecified}&colNo.in={colNoIn}&colNo.notIn={colNoNotIn}&priceFactor.greaterThan={priceFactorGreaterThan}&priceFactor.lessThan={priceFactorLessThan}&priceFactor.greaterThanOrEqual={priceFactorGreaterThanOrEqual}&priceFactor.lessThanOrEqual={priceFactorLessThanOrEqual}&priceFactor.equals={priceFactorEquals}&priceFactor.notEquals={priceFactorNotEquals}&priceFactor.specified={priceFactorSpecified}&priceFactor.in={priceFactorIn}&priceFactor.notIn={priceFactorNotIn}&type.equals={typeEquals}&type.notEquals={typeNotEquals}&type.specified={typeSpecified}&type.in={typeIn}&type.notIn={typeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&floorId.greaterThan={floorIdGreaterThan}&floorId.lessThan={floorIdLessThan}&floorId.greaterThanOrEqual={floorIdGreaterThanOrEqual}&floorId.lessThanOrEqual={floorIdLessThanOrEqual}&floorId.equals={floorIdEquals}&floorId.notEquals={floorIdNotEquals}&floorId.specified={floorIdSpecified}&floorId.in={floorIdIn}&floorId.notIn={floorIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  List<SeatDTO> getAllSeats(@QueryMap(encoded=true) GetAllSeatsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllSeats</code> that receives the query parameters as a map,
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
          *   <li>seatNoContains -  (optional)</li>
          *   <li>seatNoDoesNotContain -  (optional)</li>
          *   <li>seatNoEquals -  (optional)</li>
          *   <li>seatNoNotEquals -  (optional)</li>
          *   <li>seatNoSpecified -  (optional)</li>
          *   <li>seatNoIn -  (optional)</li>
          *   <li>seatNoNotIn -  (optional)</li>
          *   <li>rowNoGreaterThan -  (optional)</li>
          *   <li>rowNoLessThan -  (optional)</li>
          *   <li>rowNoGreaterThanOrEqual -  (optional)</li>
          *   <li>rowNoLessThanOrEqual -  (optional)</li>
          *   <li>rowNoEquals -  (optional)</li>
          *   <li>rowNoNotEquals -  (optional)</li>
          *   <li>rowNoSpecified -  (optional)</li>
          *   <li>rowNoIn -  (optional)</li>
          *   <li>rowNoNotIn -  (optional)</li>
          *   <li>colNoGreaterThan -  (optional)</li>
          *   <li>colNoLessThan -  (optional)</li>
          *   <li>colNoGreaterThanOrEqual -  (optional)</li>
          *   <li>colNoLessThanOrEqual -  (optional)</li>
          *   <li>colNoEquals -  (optional)</li>
          *   <li>colNoNotEquals -  (optional)</li>
          *   <li>colNoSpecified -  (optional)</li>
          *   <li>colNoIn -  (optional)</li>
          *   <li>colNoNotIn -  (optional)</li>
          *   <li>priceFactorGreaterThan -  (optional)</li>
          *   <li>priceFactorLessThan -  (optional)</li>
          *   <li>priceFactorGreaterThanOrEqual -  (optional)</li>
          *   <li>priceFactorLessThanOrEqual -  (optional)</li>
          *   <li>priceFactorEquals -  (optional)</li>
          *   <li>priceFactorNotEquals -  (optional)</li>
          *   <li>priceFactorSpecified -  (optional)</li>
          *   <li>priceFactorIn -  (optional)</li>
          *   <li>priceFactorNotIn -  (optional)</li>
          *   <li>typeEquals -  (optional)</li>
          *   <li>typeNotEquals -  (optional)</li>
          *   <li>typeSpecified -  (optional)</li>
          *   <li>typeIn -  (optional)</li>
          *   <li>typeNotIn -  (optional)</li>
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
          *   <li>floorIdGreaterThan -  (optional)</li>
          *   <li>floorIdLessThan -  (optional)</li>
          *   <li>floorIdGreaterThanOrEqual -  (optional)</li>
          *   <li>floorIdLessThanOrEqual -  (optional)</li>
          *   <li>floorIdEquals -  (optional)</li>
          *   <li>floorIdNotEquals -  (optional)</li>
          *   <li>floorIdSpecified -  (optional)</li>
          *   <li>floorIdIn -  (optional)</li>
          *   <li>floorIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return List&lt;SeatDTO&gt;
      */
      @RequestLine("GET /api/seats?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&seatNo.contains={seatNoContains}&seatNo.doesNotContain={seatNoDoesNotContain}&seatNo.equals={seatNoEquals}&seatNo.notEquals={seatNoNotEquals}&seatNo.specified={seatNoSpecified}&seatNo.in={seatNoIn}&seatNo.notIn={seatNoNotIn}&rowNo.greaterThan={rowNoGreaterThan}&rowNo.lessThan={rowNoLessThan}&rowNo.greaterThanOrEqual={rowNoGreaterThanOrEqual}&rowNo.lessThanOrEqual={rowNoLessThanOrEqual}&rowNo.equals={rowNoEquals}&rowNo.notEquals={rowNoNotEquals}&rowNo.specified={rowNoSpecified}&rowNo.in={rowNoIn}&rowNo.notIn={rowNoNotIn}&colNo.greaterThan={colNoGreaterThan}&colNo.lessThan={colNoLessThan}&colNo.greaterThanOrEqual={colNoGreaterThanOrEqual}&colNo.lessThanOrEqual={colNoLessThanOrEqual}&colNo.equals={colNoEquals}&colNo.notEquals={colNoNotEquals}&colNo.specified={colNoSpecified}&colNo.in={colNoIn}&colNo.notIn={colNoNotIn}&priceFactor.greaterThan={priceFactorGreaterThan}&priceFactor.lessThan={priceFactorLessThan}&priceFactor.greaterThanOrEqual={priceFactorGreaterThanOrEqual}&priceFactor.lessThanOrEqual={priceFactorLessThanOrEqual}&priceFactor.equals={priceFactorEquals}&priceFactor.notEquals={priceFactorNotEquals}&priceFactor.specified={priceFactorSpecified}&priceFactor.in={priceFactorIn}&priceFactor.notIn={priceFactorNotIn}&type.equals={typeEquals}&type.notEquals={typeNotEquals}&type.specified={typeSpecified}&type.in={typeIn}&type.notIn={typeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&floorId.greaterThan={floorIdGreaterThan}&floorId.lessThan={floorIdLessThan}&floorId.greaterThanOrEqual={floorIdGreaterThanOrEqual}&floorId.lessThanOrEqual={floorIdLessThanOrEqual}&floorId.equals={floorIdEquals}&floorId.notEquals={floorIdNotEquals}&floorId.specified={floorIdSpecified}&floorId.in={floorIdIn}&floorId.notIn={floorIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<SeatDTO>> getAllSeatsWithHttpInfo(@QueryMap(encoded=true) GetAllSeatsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllSeats</code> method in a fluent style.
   */
  public static class GetAllSeatsQueryParams extends HashMap<String, Object> {
    public GetAllSeatsQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatsQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatsQueryParams seatNoContains(@jakarta.annotation.Nullable final String value) {
      put("seatNo.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams seatNoDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("seatNo.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams seatNoEquals(@jakarta.annotation.Nullable final String value) {
      put("seatNo.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams seatNoNotEquals(@jakarta.annotation.Nullable final String value) {
      put("seatNo.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams seatNoSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("seatNo.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams seatNoIn(@jakarta.annotation.Nullable final List<String> value) {
      put("seatNo.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatsQueryParams seatNoNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("seatNo.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatsQueryParams rowNoGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("rowNo.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams rowNoLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("rowNo.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams rowNoGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("rowNo.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams rowNoLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("rowNo.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams rowNoEquals(@jakarta.annotation.Nullable final Integer value) {
      put("rowNo.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams rowNoNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("rowNo.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams rowNoSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("rowNo.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams rowNoIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("rowNo.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatsQueryParams rowNoNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("rowNo.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatsQueryParams colNoGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("colNo.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams colNoLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("colNo.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams colNoGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("colNo.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams colNoLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("colNo.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams colNoEquals(@jakarta.annotation.Nullable final Integer value) {
      put("colNo.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams colNoNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("colNo.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams colNoSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("colNo.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams colNoIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("colNo.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatsQueryParams colNoNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("colNo.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatsQueryParams priceFactorGreaterThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("priceFactor.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams priceFactorLessThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("priceFactor.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams priceFactorGreaterThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("priceFactor.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams priceFactorLessThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("priceFactor.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams priceFactorEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("priceFactor.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams priceFactorNotEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("priceFactor.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams priceFactorSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("priceFactor.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams priceFactorIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("priceFactor.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatsQueryParams priceFactorNotIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("priceFactor.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatsQueryParams typeEquals(@jakarta.annotation.Nullable final String value) {
      put("type.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams typeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("type.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams typeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("type.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams typeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("type.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatsQueryParams typeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("type.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatsQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatsQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatsQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatsQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatsQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatsQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatsQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatsQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatsQueryParams floorIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("floorId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams floorIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("floorId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams floorIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("floorId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams floorIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("floorId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams floorIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("floorId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams floorIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("floorId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams floorIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("floorId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatsQueryParams floorIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("floorId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatsQueryParams floorIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("floorId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @return SeatDTO
   */
  @RequestLine("GET /api/seats/{id}")
  @Headers({
    "Accept: */*",
  })
  SeatDTO getSeat(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>getSeat</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/seats/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<SeatDTO> getSeatWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param id  (required)
   * @param seatDTO  (required)
   * @return SeatDTO
   */
  @RequestLine("PATCH /api/seats/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  SeatDTO partialUpdateSeat(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull SeatDTO seatDTO);

  /**
   * 
   * Similar to <code>partialUpdateSeat</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param seatDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /api/seats/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<SeatDTO> partialUpdateSeatWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull SeatDTO seatDTO);



  /**
   * 
   * 
   * @param id  (required)
   * @param seatDTO  (required)
   * @return SeatDTO
   */
  @RequestLine("PUT /api/seats/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  SeatDTO updateSeat(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull SeatDTO seatDTO);

  /**
   * 
   * Similar to <code>updateSeat</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param seatDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/seats/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<SeatDTO> updateSeatWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull SeatDTO seatDTO);


}
