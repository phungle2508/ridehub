package com.ridehub.mspromotion.client.api;

import com.ridehub.mspromotion.client.invoker.ApiClient;
import com.ridehub.mspromotion.client.invoker.EncodingUtils;
import com.ridehub.mspromotion.client.model.ApiResponse;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import com.ridehub.mspromotion.client.model.PercentOffTotalDTO;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface PercentOffTotalResourceMspromotionApi extends ApiClient.Api {


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
   * @param percentGreaterThan  (optional)
   * @param percentLessThan  (optional)
   * @param percentGreaterThanOrEqual  (optional)
   * @param percentLessThanOrEqual  (optional)
   * @param percentEquals  (optional)
   * @param percentNotEquals  (optional)
   * @param percentSpecified  (optional)
   * @param percentIn  (optional)
   * @param percentNotIn  (optional)
   * @param maxOffGreaterThan  (optional)
   * @param maxOffLessThan  (optional)
   * @param maxOffGreaterThanOrEqual  (optional)
   * @param maxOffLessThanOrEqual  (optional)
   * @param maxOffEquals  (optional)
   * @param maxOffNotEquals  (optional)
   * @param maxOffSpecified  (optional)
   * @param maxOffIn  (optional)
   * @param maxOffNotIn  (optional)
   * @param minPriceGreaterThan  (optional)
   * @param minPriceLessThan  (optional)
   * @param minPriceGreaterThanOrEqual  (optional)
   * @param minPriceLessThanOrEqual  (optional)
   * @param minPriceEquals  (optional)
   * @param minPriceNotEquals  (optional)
   * @param minPriceSpecified  (optional)
   * @param minPriceIn  (optional)
   * @param minPriceNotIn  (optional)
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
   * @param promotionIdGreaterThan  (optional)
   * @param promotionIdLessThan  (optional)
   * @param promotionIdGreaterThanOrEqual  (optional)
   * @param promotionIdLessThanOrEqual  (optional)
   * @param promotionIdEquals  (optional)
   * @param promotionIdNotEquals  (optional)
   * @param promotionIdSpecified  (optional)
   * @param promotionIdIn  (optional)
   * @param promotionIdNotIn  (optional)
   * @param distinct  (optional)
   * @return Long
   */
  @RequestLine("GET /api/percent-off-totals/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&percent.greaterThan={percentGreaterThan}&percent.lessThan={percentLessThan}&percent.greaterThanOrEqual={percentGreaterThanOrEqual}&percent.lessThanOrEqual={percentLessThanOrEqual}&percent.equals={percentEquals}&percent.notEquals={percentNotEquals}&percent.specified={percentSpecified}&percent.in={percentIn}&percent.notIn={percentNotIn}&maxOff.greaterThan={maxOffGreaterThan}&maxOff.lessThan={maxOffLessThan}&maxOff.greaterThanOrEqual={maxOffGreaterThanOrEqual}&maxOff.lessThanOrEqual={maxOffLessThanOrEqual}&maxOff.equals={maxOffEquals}&maxOff.notEquals={maxOffNotEquals}&maxOff.specified={maxOffSpecified}&maxOff.in={maxOffIn}&maxOff.notIn={maxOffNotIn}&minPrice.greaterThan={minPriceGreaterThan}&minPrice.lessThan={minPriceLessThan}&minPrice.greaterThanOrEqual={minPriceGreaterThanOrEqual}&minPrice.lessThanOrEqual={minPriceLessThanOrEqual}&minPrice.equals={minPriceEquals}&minPrice.notEquals={minPriceNotEquals}&minPrice.specified={minPriceSpecified}&minPrice.in={minPriceIn}&minPrice.notIn={minPriceNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  Long countPercentOffTotals(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("percentGreaterThan") @jakarta.annotation.Nullable Integer percentGreaterThan, @Param("percentLessThan") @jakarta.annotation.Nullable Integer percentLessThan, @Param("percentGreaterThanOrEqual") @jakarta.annotation.Nullable Integer percentGreaterThanOrEqual, @Param("percentLessThanOrEqual") @jakarta.annotation.Nullable Integer percentLessThanOrEqual, @Param("percentEquals") @jakarta.annotation.Nullable Integer percentEquals, @Param("percentNotEquals") @jakarta.annotation.Nullable Integer percentNotEquals, @Param("percentSpecified") @jakarta.annotation.Nullable Boolean percentSpecified, @Param("percentIn") @jakarta.annotation.Nullable List<Integer> percentIn, @Param("percentNotIn") @jakarta.annotation.Nullable List<Integer> percentNotIn, @Param("maxOffGreaterThan") @jakarta.annotation.Nullable BigDecimal maxOffGreaterThan, @Param("maxOffLessThan") @jakarta.annotation.Nullable BigDecimal maxOffLessThan, @Param("maxOffGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal maxOffGreaterThanOrEqual, @Param("maxOffLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal maxOffLessThanOrEqual, @Param("maxOffEquals") @jakarta.annotation.Nullable BigDecimal maxOffEquals, @Param("maxOffNotEquals") @jakarta.annotation.Nullable BigDecimal maxOffNotEquals, @Param("maxOffSpecified") @jakarta.annotation.Nullable Boolean maxOffSpecified, @Param("maxOffIn") @jakarta.annotation.Nullable List<BigDecimal> maxOffIn, @Param("maxOffNotIn") @jakarta.annotation.Nullable List<BigDecimal> maxOffNotIn, @Param("minPriceGreaterThan") @jakarta.annotation.Nullable BigDecimal minPriceGreaterThan, @Param("minPriceLessThan") @jakarta.annotation.Nullable BigDecimal minPriceLessThan, @Param("minPriceGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal minPriceGreaterThanOrEqual, @Param("minPriceLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal minPriceLessThanOrEqual, @Param("minPriceEquals") @jakarta.annotation.Nullable BigDecimal minPriceEquals, @Param("minPriceNotEquals") @jakarta.annotation.Nullable BigDecimal minPriceNotEquals, @Param("minPriceSpecified") @jakarta.annotation.Nullable Boolean minPriceSpecified, @Param("minPriceIn") @jakarta.annotation.Nullable List<BigDecimal> minPriceIn, @Param("minPriceNotIn") @jakarta.annotation.Nullable List<BigDecimal> minPriceNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("promotionIdGreaterThan") @jakarta.annotation.Nullable Long promotionIdGreaterThan, @Param("promotionIdLessThan") @jakarta.annotation.Nullable Long promotionIdLessThan, @Param("promotionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long promotionIdGreaterThanOrEqual, @Param("promotionIdLessThanOrEqual") @jakarta.annotation.Nullable Long promotionIdLessThanOrEqual, @Param("promotionIdEquals") @jakarta.annotation.Nullable Long promotionIdEquals, @Param("promotionIdNotEquals") @jakarta.annotation.Nullable Long promotionIdNotEquals, @Param("promotionIdSpecified") @jakarta.annotation.Nullable Boolean promotionIdSpecified, @Param("promotionIdIn") @jakarta.annotation.Nullable List<Long> promotionIdIn, @Param("promotionIdNotIn") @jakarta.annotation.Nullable List<Long> promotionIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>countPercentOffTotals</code> but it also returns the http response headers .
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
   * @param percentGreaterThan  (optional)
   * @param percentLessThan  (optional)
   * @param percentGreaterThanOrEqual  (optional)
   * @param percentLessThanOrEqual  (optional)
   * @param percentEquals  (optional)
   * @param percentNotEquals  (optional)
   * @param percentSpecified  (optional)
   * @param percentIn  (optional)
   * @param percentNotIn  (optional)
   * @param maxOffGreaterThan  (optional)
   * @param maxOffLessThan  (optional)
   * @param maxOffGreaterThanOrEqual  (optional)
   * @param maxOffLessThanOrEqual  (optional)
   * @param maxOffEquals  (optional)
   * @param maxOffNotEquals  (optional)
   * @param maxOffSpecified  (optional)
   * @param maxOffIn  (optional)
   * @param maxOffNotIn  (optional)
   * @param minPriceGreaterThan  (optional)
   * @param minPriceLessThan  (optional)
   * @param minPriceGreaterThanOrEqual  (optional)
   * @param minPriceLessThanOrEqual  (optional)
   * @param minPriceEquals  (optional)
   * @param minPriceNotEquals  (optional)
   * @param minPriceSpecified  (optional)
   * @param minPriceIn  (optional)
   * @param minPriceNotIn  (optional)
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
   * @param promotionIdGreaterThan  (optional)
   * @param promotionIdLessThan  (optional)
   * @param promotionIdGreaterThanOrEqual  (optional)
   * @param promotionIdLessThanOrEqual  (optional)
   * @param promotionIdEquals  (optional)
   * @param promotionIdNotEquals  (optional)
   * @param promotionIdSpecified  (optional)
   * @param promotionIdIn  (optional)
   * @param promotionIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/percent-off-totals/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&percent.greaterThan={percentGreaterThan}&percent.lessThan={percentLessThan}&percent.greaterThanOrEqual={percentGreaterThanOrEqual}&percent.lessThanOrEqual={percentLessThanOrEqual}&percent.equals={percentEquals}&percent.notEquals={percentNotEquals}&percent.specified={percentSpecified}&percent.in={percentIn}&percent.notIn={percentNotIn}&maxOff.greaterThan={maxOffGreaterThan}&maxOff.lessThan={maxOffLessThan}&maxOff.greaterThanOrEqual={maxOffGreaterThanOrEqual}&maxOff.lessThanOrEqual={maxOffLessThanOrEqual}&maxOff.equals={maxOffEquals}&maxOff.notEquals={maxOffNotEquals}&maxOff.specified={maxOffSpecified}&maxOff.in={maxOffIn}&maxOff.notIn={maxOffNotIn}&minPrice.greaterThan={minPriceGreaterThan}&minPrice.lessThan={minPriceLessThan}&minPrice.greaterThanOrEqual={minPriceGreaterThanOrEqual}&minPrice.lessThanOrEqual={minPriceLessThanOrEqual}&minPrice.equals={minPriceEquals}&minPrice.notEquals={minPriceNotEquals}&minPrice.specified={minPriceSpecified}&minPrice.in={minPriceIn}&minPrice.notIn={minPriceNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Long> countPercentOffTotalsWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("percentGreaterThan") @jakarta.annotation.Nullable Integer percentGreaterThan, @Param("percentLessThan") @jakarta.annotation.Nullable Integer percentLessThan, @Param("percentGreaterThanOrEqual") @jakarta.annotation.Nullable Integer percentGreaterThanOrEqual, @Param("percentLessThanOrEqual") @jakarta.annotation.Nullable Integer percentLessThanOrEqual, @Param("percentEquals") @jakarta.annotation.Nullable Integer percentEquals, @Param("percentNotEquals") @jakarta.annotation.Nullable Integer percentNotEquals, @Param("percentSpecified") @jakarta.annotation.Nullable Boolean percentSpecified, @Param("percentIn") @jakarta.annotation.Nullable List<Integer> percentIn, @Param("percentNotIn") @jakarta.annotation.Nullable List<Integer> percentNotIn, @Param("maxOffGreaterThan") @jakarta.annotation.Nullable BigDecimal maxOffGreaterThan, @Param("maxOffLessThan") @jakarta.annotation.Nullable BigDecimal maxOffLessThan, @Param("maxOffGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal maxOffGreaterThanOrEqual, @Param("maxOffLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal maxOffLessThanOrEqual, @Param("maxOffEquals") @jakarta.annotation.Nullable BigDecimal maxOffEquals, @Param("maxOffNotEquals") @jakarta.annotation.Nullable BigDecimal maxOffNotEquals, @Param("maxOffSpecified") @jakarta.annotation.Nullable Boolean maxOffSpecified, @Param("maxOffIn") @jakarta.annotation.Nullable List<BigDecimal> maxOffIn, @Param("maxOffNotIn") @jakarta.annotation.Nullable List<BigDecimal> maxOffNotIn, @Param("minPriceGreaterThan") @jakarta.annotation.Nullable BigDecimal minPriceGreaterThan, @Param("minPriceLessThan") @jakarta.annotation.Nullable BigDecimal minPriceLessThan, @Param("minPriceGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal minPriceGreaterThanOrEqual, @Param("minPriceLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal minPriceLessThanOrEqual, @Param("minPriceEquals") @jakarta.annotation.Nullable BigDecimal minPriceEquals, @Param("minPriceNotEquals") @jakarta.annotation.Nullable BigDecimal minPriceNotEquals, @Param("minPriceSpecified") @jakarta.annotation.Nullable Boolean minPriceSpecified, @Param("minPriceIn") @jakarta.annotation.Nullable List<BigDecimal> minPriceIn, @Param("minPriceNotIn") @jakarta.annotation.Nullable List<BigDecimal> minPriceNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("promotionIdGreaterThan") @jakarta.annotation.Nullable Long promotionIdGreaterThan, @Param("promotionIdLessThan") @jakarta.annotation.Nullable Long promotionIdLessThan, @Param("promotionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long promotionIdGreaterThanOrEqual, @Param("promotionIdLessThanOrEqual") @jakarta.annotation.Nullable Long promotionIdLessThanOrEqual, @Param("promotionIdEquals") @jakarta.annotation.Nullable Long promotionIdEquals, @Param("promotionIdNotEquals") @jakarta.annotation.Nullable Long promotionIdNotEquals, @Param("promotionIdSpecified") @jakarta.annotation.Nullable Boolean promotionIdSpecified, @Param("promotionIdIn") @jakarta.annotation.Nullable List<Long> promotionIdIn, @Param("promotionIdNotIn") @jakarta.annotation.Nullable List<Long> promotionIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>countPercentOffTotals</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CountPercentOffTotalsQueryParams} class that allows for
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
   *   <li>percentGreaterThan -  (optional)</li>
   *   <li>percentLessThan -  (optional)</li>
   *   <li>percentGreaterThanOrEqual -  (optional)</li>
   *   <li>percentLessThanOrEqual -  (optional)</li>
   *   <li>percentEquals -  (optional)</li>
   *   <li>percentNotEquals -  (optional)</li>
   *   <li>percentSpecified -  (optional)</li>
   *   <li>percentIn -  (optional)</li>
   *   <li>percentNotIn -  (optional)</li>
   *   <li>maxOffGreaterThan -  (optional)</li>
   *   <li>maxOffLessThan -  (optional)</li>
   *   <li>maxOffGreaterThanOrEqual -  (optional)</li>
   *   <li>maxOffLessThanOrEqual -  (optional)</li>
   *   <li>maxOffEquals -  (optional)</li>
   *   <li>maxOffNotEquals -  (optional)</li>
   *   <li>maxOffSpecified -  (optional)</li>
   *   <li>maxOffIn -  (optional)</li>
   *   <li>maxOffNotIn -  (optional)</li>
   *   <li>minPriceGreaterThan -  (optional)</li>
   *   <li>minPriceLessThan -  (optional)</li>
   *   <li>minPriceGreaterThanOrEqual -  (optional)</li>
   *   <li>minPriceLessThanOrEqual -  (optional)</li>
   *   <li>minPriceEquals -  (optional)</li>
   *   <li>minPriceNotEquals -  (optional)</li>
   *   <li>minPriceSpecified -  (optional)</li>
   *   <li>minPriceIn -  (optional)</li>
   *   <li>minPriceNotIn -  (optional)</li>
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
   *   <li>promotionIdGreaterThan -  (optional)</li>
   *   <li>promotionIdLessThan -  (optional)</li>
   *   <li>promotionIdGreaterThanOrEqual -  (optional)</li>
   *   <li>promotionIdLessThanOrEqual -  (optional)</li>
   *   <li>promotionIdEquals -  (optional)</li>
   *   <li>promotionIdNotEquals -  (optional)</li>
   *   <li>promotionIdSpecified -  (optional)</li>
   *   <li>promotionIdIn -  (optional)</li>
   *   <li>promotionIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return Long
   */
  @RequestLine("GET /api/percent-off-totals/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&percent.greaterThan={percentGreaterThan}&percent.lessThan={percentLessThan}&percent.greaterThanOrEqual={percentGreaterThanOrEqual}&percent.lessThanOrEqual={percentLessThanOrEqual}&percent.equals={percentEquals}&percent.notEquals={percentNotEquals}&percent.specified={percentSpecified}&percent.in={percentIn}&percent.notIn={percentNotIn}&maxOff.greaterThan={maxOffGreaterThan}&maxOff.lessThan={maxOffLessThan}&maxOff.greaterThanOrEqual={maxOffGreaterThanOrEqual}&maxOff.lessThanOrEqual={maxOffLessThanOrEqual}&maxOff.equals={maxOffEquals}&maxOff.notEquals={maxOffNotEquals}&maxOff.specified={maxOffSpecified}&maxOff.in={maxOffIn}&maxOff.notIn={maxOffNotIn}&minPrice.greaterThan={minPriceGreaterThan}&minPrice.lessThan={minPriceLessThan}&minPrice.greaterThanOrEqual={minPriceGreaterThanOrEqual}&minPrice.lessThanOrEqual={minPriceLessThanOrEqual}&minPrice.equals={minPriceEquals}&minPrice.notEquals={minPriceNotEquals}&minPrice.specified={minPriceSpecified}&minPrice.in={minPriceIn}&minPrice.notIn={minPriceNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  Long countPercentOffTotals(@QueryMap(encoded=true) CountPercentOffTotalsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>countPercentOffTotals</code> that receives the query parameters as a map,
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
          *   <li>percentGreaterThan -  (optional)</li>
          *   <li>percentLessThan -  (optional)</li>
          *   <li>percentGreaterThanOrEqual -  (optional)</li>
          *   <li>percentLessThanOrEqual -  (optional)</li>
          *   <li>percentEquals -  (optional)</li>
          *   <li>percentNotEquals -  (optional)</li>
          *   <li>percentSpecified -  (optional)</li>
          *   <li>percentIn -  (optional)</li>
          *   <li>percentNotIn -  (optional)</li>
          *   <li>maxOffGreaterThan -  (optional)</li>
          *   <li>maxOffLessThan -  (optional)</li>
          *   <li>maxOffGreaterThanOrEqual -  (optional)</li>
          *   <li>maxOffLessThanOrEqual -  (optional)</li>
          *   <li>maxOffEquals -  (optional)</li>
          *   <li>maxOffNotEquals -  (optional)</li>
          *   <li>maxOffSpecified -  (optional)</li>
          *   <li>maxOffIn -  (optional)</li>
          *   <li>maxOffNotIn -  (optional)</li>
          *   <li>minPriceGreaterThan -  (optional)</li>
          *   <li>minPriceLessThan -  (optional)</li>
          *   <li>minPriceGreaterThanOrEqual -  (optional)</li>
          *   <li>minPriceLessThanOrEqual -  (optional)</li>
          *   <li>minPriceEquals -  (optional)</li>
          *   <li>minPriceNotEquals -  (optional)</li>
          *   <li>minPriceSpecified -  (optional)</li>
          *   <li>minPriceIn -  (optional)</li>
          *   <li>minPriceNotIn -  (optional)</li>
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
          *   <li>promotionIdGreaterThan -  (optional)</li>
          *   <li>promotionIdLessThan -  (optional)</li>
          *   <li>promotionIdGreaterThanOrEqual -  (optional)</li>
          *   <li>promotionIdLessThanOrEqual -  (optional)</li>
          *   <li>promotionIdEquals -  (optional)</li>
          *   <li>promotionIdNotEquals -  (optional)</li>
          *   <li>promotionIdSpecified -  (optional)</li>
          *   <li>promotionIdIn -  (optional)</li>
          *   <li>promotionIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return Long
      */
      @RequestLine("GET /api/percent-off-totals/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&percent.greaterThan={percentGreaterThan}&percent.lessThan={percentLessThan}&percent.greaterThanOrEqual={percentGreaterThanOrEqual}&percent.lessThanOrEqual={percentLessThanOrEqual}&percent.equals={percentEquals}&percent.notEquals={percentNotEquals}&percent.specified={percentSpecified}&percent.in={percentIn}&percent.notIn={percentNotIn}&maxOff.greaterThan={maxOffGreaterThan}&maxOff.lessThan={maxOffLessThan}&maxOff.greaterThanOrEqual={maxOffGreaterThanOrEqual}&maxOff.lessThanOrEqual={maxOffLessThanOrEqual}&maxOff.equals={maxOffEquals}&maxOff.notEquals={maxOffNotEquals}&maxOff.specified={maxOffSpecified}&maxOff.in={maxOffIn}&maxOff.notIn={maxOffNotIn}&minPrice.greaterThan={minPriceGreaterThan}&minPrice.lessThan={minPriceLessThan}&minPrice.greaterThanOrEqual={minPriceGreaterThanOrEqual}&minPrice.lessThanOrEqual={minPriceLessThanOrEqual}&minPrice.equals={minPriceEquals}&minPrice.notEquals={minPriceNotEquals}&minPrice.specified={minPriceSpecified}&minPrice.in={minPriceIn}&minPrice.notIn={minPriceNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Long> countPercentOffTotalsWithHttpInfo(@QueryMap(encoded=true) CountPercentOffTotalsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>countPercentOffTotals</code> method in a fluent style.
   */
  public static class CountPercentOffTotalsQueryParams extends HashMap<String, Object> {
    public CountPercentOffTotalsQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPercentOffTotalsQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPercentOffTotalsQueryParams percentGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("percent.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams percentLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("percent.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams percentGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("percent.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams percentLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("percent.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams percentEquals(@jakarta.annotation.Nullable final Integer value) {
      put("percent.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams percentNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("percent.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams percentSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("percent.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams percentIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("percent.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPercentOffTotalsQueryParams percentNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("percent.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPercentOffTotalsQueryParams maxOffGreaterThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("maxOff.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams maxOffLessThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("maxOff.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams maxOffGreaterThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("maxOff.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams maxOffLessThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("maxOff.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams maxOffEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("maxOff.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams maxOffNotEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("maxOff.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams maxOffSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("maxOff.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams maxOffIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("maxOff.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPercentOffTotalsQueryParams maxOffNotIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("maxOff.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPercentOffTotalsQueryParams minPriceGreaterThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("minPrice.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams minPriceLessThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("minPrice.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams minPriceGreaterThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("minPrice.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams minPriceLessThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("minPrice.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams minPriceEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("minPrice.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams minPriceNotEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("minPrice.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams minPriceSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("minPrice.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams minPriceIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("minPrice.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPercentOffTotalsQueryParams minPriceNotIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("minPrice.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPercentOffTotalsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPercentOffTotalsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPercentOffTotalsQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPercentOffTotalsQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPercentOffTotalsQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPercentOffTotalsQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPercentOffTotalsQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPercentOffTotalsQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPercentOffTotalsQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPercentOffTotalsQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPercentOffTotalsQueryParams promotionIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams promotionIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams promotionIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams promotionIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams promotionIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams promotionIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams promotionIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("promotionId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPercentOffTotalsQueryParams promotionIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("promotionId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPercentOffTotalsQueryParams promotionIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("promotionId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPercentOffTotalsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param percentOffTotalDTO  (required)
   * @return PercentOffTotalDTO
   */
  @RequestLine("POST /api/percent-off-totals")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  PercentOffTotalDTO createPercentOffTotal(@jakarta.annotation.Nonnull PercentOffTotalDTO percentOffTotalDTO);

  /**
   * 
   * Similar to <code>createPercentOffTotal</code> but it also returns the http response headers .
   * 
   * @param percentOffTotalDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/percent-off-totals")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<PercentOffTotalDTO> createPercentOffTotalWithHttpInfo(@jakarta.annotation.Nonnull PercentOffTotalDTO percentOffTotalDTO);



  /**
   * 
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/percent-off-totals/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deletePercentOffTotal(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>deletePercentOffTotal</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/percent-off-totals/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deletePercentOffTotalWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



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
   * @param percentGreaterThan  (optional)
   * @param percentLessThan  (optional)
   * @param percentGreaterThanOrEqual  (optional)
   * @param percentLessThanOrEqual  (optional)
   * @param percentEquals  (optional)
   * @param percentNotEquals  (optional)
   * @param percentSpecified  (optional)
   * @param percentIn  (optional)
   * @param percentNotIn  (optional)
   * @param maxOffGreaterThan  (optional)
   * @param maxOffLessThan  (optional)
   * @param maxOffGreaterThanOrEqual  (optional)
   * @param maxOffLessThanOrEqual  (optional)
   * @param maxOffEquals  (optional)
   * @param maxOffNotEquals  (optional)
   * @param maxOffSpecified  (optional)
   * @param maxOffIn  (optional)
   * @param maxOffNotIn  (optional)
   * @param minPriceGreaterThan  (optional)
   * @param minPriceLessThan  (optional)
   * @param minPriceGreaterThanOrEqual  (optional)
   * @param minPriceLessThanOrEqual  (optional)
   * @param minPriceEquals  (optional)
   * @param minPriceNotEquals  (optional)
   * @param minPriceSpecified  (optional)
   * @param minPriceIn  (optional)
   * @param minPriceNotIn  (optional)
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
   * @param promotionIdGreaterThan  (optional)
   * @param promotionIdLessThan  (optional)
   * @param promotionIdGreaterThanOrEqual  (optional)
   * @param promotionIdLessThanOrEqual  (optional)
   * @param promotionIdEquals  (optional)
   * @param promotionIdNotEquals  (optional)
   * @param promotionIdSpecified  (optional)
   * @param promotionIdIn  (optional)
   * @param promotionIdNotIn  (optional)
   * @param distinct  (optional)
   * @return List&lt;PercentOffTotalDTO&gt;
   */
  @RequestLine("GET /api/percent-off-totals?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&percent.greaterThan={percentGreaterThan}&percent.lessThan={percentLessThan}&percent.greaterThanOrEqual={percentGreaterThanOrEqual}&percent.lessThanOrEqual={percentLessThanOrEqual}&percent.equals={percentEquals}&percent.notEquals={percentNotEquals}&percent.specified={percentSpecified}&percent.in={percentIn}&percent.notIn={percentNotIn}&maxOff.greaterThan={maxOffGreaterThan}&maxOff.lessThan={maxOffLessThan}&maxOff.greaterThanOrEqual={maxOffGreaterThanOrEqual}&maxOff.lessThanOrEqual={maxOffLessThanOrEqual}&maxOff.equals={maxOffEquals}&maxOff.notEquals={maxOffNotEquals}&maxOff.specified={maxOffSpecified}&maxOff.in={maxOffIn}&maxOff.notIn={maxOffNotIn}&minPrice.greaterThan={minPriceGreaterThan}&minPrice.lessThan={minPriceLessThan}&minPrice.greaterThanOrEqual={minPriceGreaterThanOrEqual}&minPrice.lessThanOrEqual={minPriceLessThanOrEqual}&minPrice.equals={minPriceEquals}&minPrice.notEquals={minPriceNotEquals}&minPrice.specified={minPriceSpecified}&minPrice.in={minPriceIn}&minPrice.notIn={minPriceNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  List<PercentOffTotalDTO> getAllPercentOffTotals(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("percentGreaterThan") @jakarta.annotation.Nullable Integer percentGreaterThan, @Param("percentLessThan") @jakarta.annotation.Nullable Integer percentLessThan, @Param("percentGreaterThanOrEqual") @jakarta.annotation.Nullable Integer percentGreaterThanOrEqual, @Param("percentLessThanOrEqual") @jakarta.annotation.Nullable Integer percentLessThanOrEqual, @Param("percentEquals") @jakarta.annotation.Nullable Integer percentEquals, @Param("percentNotEquals") @jakarta.annotation.Nullable Integer percentNotEquals, @Param("percentSpecified") @jakarta.annotation.Nullable Boolean percentSpecified, @Param("percentIn") @jakarta.annotation.Nullable List<Integer> percentIn, @Param("percentNotIn") @jakarta.annotation.Nullable List<Integer> percentNotIn, @Param("maxOffGreaterThan") @jakarta.annotation.Nullable BigDecimal maxOffGreaterThan, @Param("maxOffLessThan") @jakarta.annotation.Nullable BigDecimal maxOffLessThan, @Param("maxOffGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal maxOffGreaterThanOrEqual, @Param("maxOffLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal maxOffLessThanOrEqual, @Param("maxOffEquals") @jakarta.annotation.Nullable BigDecimal maxOffEquals, @Param("maxOffNotEquals") @jakarta.annotation.Nullable BigDecimal maxOffNotEquals, @Param("maxOffSpecified") @jakarta.annotation.Nullable Boolean maxOffSpecified, @Param("maxOffIn") @jakarta.annotation.Nullable List<BigDecimal> maxOffIn, @Param("maxOffNotIn") @jakarta.annotation.Nullable List<BigDecimal> maxOffNotIn, @Param("minPriceGreaterThan") @jakarta.annotation.Nullable BigDecimal minPriceGreaterThan, @Param("minPriceLessThan") @jakarta.annotation.Nullable BigDecimal minPriceLessThan, @Param("minPriceGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal minPriceGreaterThanOrEqual, @Param("minPriceLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal minPriceLessThanOrEqual, @Param("minPriceEquals") @jakarta.annotation.Nullable BigDecimal minPriceEquals, @Param("minPriceNotEquals") @jakarta.annotation.Nullable BigDecimal minPriceNotEquals, @Param("minPriceSpecified") @jakarta.annotation.Nullable Boolean minPriceSpecified, @Param("minPriceIn") @jakarta.annotation.Nullable List<BigDecimal> minPriceIn, @Param("minPriceNotIn") @jakarta.annotation.Nullable List<BigDecimal> minPriceNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("promotionIdGreaterThan") @jakarta.annotation.Nullable Long promotionIdGreaterThan, @Param("promotionIdLessThan") @jakarta.annotation.Nullable Long promotionIdLessThan, @Param("promotionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long promotionIdGreaterThanOrEqual, @Param("promotionIdLessThanOrEqual") @jakarta.annotation.Nullable Long promotionIdLessThanOrEqual, @Param("promotionIdEquals") @jakarta.annotation.Nullable Long promotionIdEquals, @Param("promotionIdNotEquals") @jakarta.annotation.Nullable Long promotionIdNotEquals, @Param("promotionIdSpecified") @jakarta.annotation.Nullable Boolean promotionIdSpecified, @Param("promotionIdIn") @jakarta.annotation.Nullable List<Long> promotionIdIn, @Param("promotionIdNotIn") @jakarta.annotation.Nullable List<Long> promotionIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>getAllPercentOffTotals</code> but it also returns the http response headers .
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
   * @param percentGreaterThan  (optional)
   * @param percentLessThan  (optional)
   * @param percentGreaterThanOrEqual  (optional)
   * @param percentLessThanOrEqual  (optional)
   * @param percentEquals  (optional)
   * @param percentNotEquals  (optional)
   * @param percentSpecified  (optional)
   * @param percentIn  (optional)
   * @param percentNotIn  (optional)
   * @param maxOffGreaterThan  (optional)
   * @param maxOffLessThan  (optional)
   * @param maxOffGreaterThanOrEqual  (optional)
   * @param maxOffLessThanOrEqual  (optional)
   * @param maxOffEquals  (optional)
   * @param maxOffNotEquals  (optional)
   * @param maxOffSpecified  (optional)
   * @param maxOffIn  (optional)
   * @param maxOffNotIn  (optional)
   * @param minPriceGreaterThan  (optional)
   * @param minPriceLessThan  (optional)
   * @param minPriceGreaterThanOrEqual  (optional)
   * @param minPriceLessThanOrEqual  (optional)
   * @param minPriceEquals  (optional)
   * @param minPriceNotEquals  (optional)
   * @param minPriceSpecified  (optional)
   * @param minPriceIn  (optional)
   * @param minPriceNotIn  (optional)
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
   * @param promotionIdGreaterThan  (optional)
   * @param promotionIdLessThan  (optional)
   * @param promotionIdGreaterThanOrEqual  (optional)
   * @param promotionIdLessThanOrEqual  (optional)
   * @param promotionIdEquals  (optional)
   * @param promotionIdNotEquals  (optional)
   * @param promotionIdSpecified  (optional)
   * @param promotionIdIn  (optional)
   * @param promotionIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/percent-off-totals?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&percent.greaterThan={percentGreaterThan}&percent.lessThan={percentLessThan}&percent.greaterThanOrEqual={percentGreaterThanOrEqual}&percent.lessThanOrEqual={percentLessThanOrEqual}&percent.equals={percentEquals}&percent.notEquals={percentNotEquals}&percent.specified={percentSpecified}&percent.in={percentIn}&percent.notIn={percentNotIn}&maxOff.greaterThan={maxOffGreaterThan}&maxOff.lessThan={maxOffLessThan}&maxOff.greaterThanOrEqual={maxOffGreaterThanOrEqual}&maxOff.lessThanOrEqual={maxOffLessThanOrEqual}&maxOff.equals={maxOffEquals}&maxOff.notEquals={maxOffNotEquals}&maxOff.specified={maxOffSpecified}&maxOff.in={maxOffIn}&maxOff.notIn={maxOffNotIn}&minPrice.greaterThan={minPriceGreaterThan}&minPrice.lessThan={minPriceLessThan}&minPrice.greaterThanOrEqual={minPriceGreaterThanOrEqual}&minPrice.lessThanOrEqual={minPriceLessThanOrEqual}&minPrice.equals={minPriceEquals}&minPrice.notEquals={minPriceNotEquals}&minPrice.specified={minPriceSpecified}&minPrice.in={minPriceIn}&minPrice.notIn={minPriceNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<PercentOffTotalDTO>> getAllPercentOffTotalsWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("percentGreaterThan") @jakarta.annotation.Nullable Integer percentGreaterThan, @Param("percentLessThan") @jakarta.annotation.Nullable Integer percentLessThan, @Param("percentGreaterThanOrEqual") @jakarta.annotation.Nullable Integer percentGreaterThanOrEqual, @Param("percentLessThanOrEqual") @jakarta.annotation.Nullable Integer percentLessThanOrEqual, @Param("percentEquals") @jakarta.annotation.Nullable Integer percentEquals, @Param("percentNotEquals") @jakarta.annotation.Nullable Integer percentNotEquals, @Param("percentSpecified") @jakarta.annotation.Nullable Boolean percentSpecified, @Param("percentIn") @jakarta.annotation.Nullable List<Integer> percentIn, @Param("percentNotIn") @jakarta.annotation.Nullable List<Integer> percentNotIn, @Param("maxOffGreaterThan") @jakarta.annotation.Nullable BigDecimal maxOffGreaterThan, @Param("maxOffLessThan") @jakarta.annotation.Nullable BigDecimal maxOffLessThan, @Param("maxOffGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal maxOffGreaterThanOrEqual, @Param("maxOffLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal maxOffLessThanOrEqual, @Param("maxOffEquals") @jakarta.annotation.Nullable BigDecimal maxOffEquals, @Param("maxOffNotEquals") @jakarta.annotation.Nullable BigDecimal maxOffNotEquals, @Param("maxOffSpecified") @jakarta.annotation.Nullable Boolean maxOffSpecified, @Param("maxOffIn") @jakarta.annotation.Nullable List<BigDecimal> maxOffIn, @Param("maxOffNotIn") @jakarta.annotation.Nullable List<BigDecimal> maxOffNotIn, @Param("minPriceGreaterThan") @jakarta.annotation.Nullable BigDecimal minPriceGreaterThan, @Param("minPriceLessThan") @jakarta.annotation.Nullable BigDecimal minPriceLessThan, @Param("minPriceGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal minPriceGreaterThanOrEqual, @Param("minPriceLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal minPriceLessThanOrEqual, @Param("minPriceEquals") @jakarta.annotation.Nullable BigDecimal minPriceEquals, @Param("minPriceNotEquals") @jakarta.annotation.Nullable BigDecimal minPriceNotEquals, @Param("minPriceSpecified") @jakarta.annotation.Nullable Boolean minPriceSpecified, @Param("minPriceIn") @jakarta.annotation.Nullable List<BigDecimal> minPriceIn, @Param("minPriceNotIn") @jakarta.annotation.Nullable List<BigDecimal> minPriceNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("promotionIdGreaterThan") @jakarta.annotation.Nullable Long promotionIdGreaterThan, @Param("promotionIdLessThan") @jakarta.annotation.Nullable Long promotionIdLessThan, @Param("promotionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long promotionIdGreaterThanOrEqual, @Param("promotionIdLessThanOrEqual") @jakarta.annotation.Nullable Long promotionIdLessThanOrEqual, @Param("promotionIdEquals") @jakarta.annotation.Nullable Long promotionIdEquals, @Param("promotionIdNotEquals") @jakarta.annotation.Nullable Long promotionIdNotEquals, @Param("promotionIdSpecified") @jakarta.annotation.Nullable Boolean promotionIdSpecified, @Param("promotionIdIn") @jakarta.annotation.Nullable List<Long> promotionIdIn, @Param("promotionIdNotIn") @jakarta.annotation.Nullable List<Long> promotionIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllPercentOffTotals</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllPercentOffTotalsQueryParams} class that allows for
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
   *   <li>percentGreaterThan -  (optional)</li>
   *   <li>percentLessThan -  (optional)</li>
   *   <li>percentGreaterThanOrEqual -  (optional)</li>
   *   <li>percentLessThanOrEqual -  (optional)</li>
   *   <li>percentEquals -  (optional)</li>
   *   <li>percentNotEquals -  (optional)</li>
   *   <li>percentSpecified -  (optional)</li>
   *   <li>percentIn -  (optional)</li>
   *   <li>percentNotIn -  (optional)</li>
   *   <li>maxOffGreaterThan -  (optional)</li>
   *   <li>maxOffLessThan -  (optional)</li>
   *   <li>maxOffGreaterThanOrEqual -  (optional)</li>
   *   <li>maxOffLessThanOrEqual -  (optional)</li>
   *   <li>maxOffEquals -  (optional)</li>
   *   <li>maxOffNotEquals -  (optional)</li>
   *   <li>maxOffSpecified -  (optional)</li>
   *   <li>maxOffIn -  (optional)</li>
   *   <li>maxOffNotIn -  (optional)</li>
   *   <li>minPriceGreaterThan -  (optional)</li>
   *   <li>minPriceLessThan -  (optional)</li>
   *   <li>minPriceGreaterThanOrEqual -  (optional)</li>
   *   <li>minPriceLessThanOrEqual -  (optional)</li>
   *   <li>minPriceEquals -  (optional)</li>
   *   <li>minPriceNotEquals -  (optional)</li>
   *   <li>minPriceSpecified -  (optional)</li>
   *   <li>minPriceIn -  (optional)</li>
   *   <li>minPriceNotIn -  (optional)</li>
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
   *   <li>promotionIdGreaterThan -  (optional)</li>
   *   <li>promotionIdLessThan -  (optional)</li>
   *   <li>promotionIdGreaterThanOrEqual -  (optional)</li>
   *   <li>promotionIdLessThanOrEqual -  (optional)</li>
   *   <li>promotionIdEquals -  (optional)</li>
   *   <li>promotionIdNotEquals -  (optional)</li>
   *   <li>promotionIdSpecified -  (optional)</li>
   *   <li>promotionIdIn -  (optional)</li>
   *   <li>promotionIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return List&lt;PercentOffTotalDTO&gt;
   */
  @RequestLine("GET /api/percent-off-totals?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&percent.greaterThan={percentGreaterThan}&percent.lessThan={percentLessThan}&percent.greaterThanOrEqual={percentGreaterThanOrEqual}&percent.lessThanOrEqual={percentLessThanOrEqual}&percent.equals={percentEquals}&percent.notEquals={percentNotEquals}&percent.specified={percentSpecified}&percent.in={percentIn}&percent.notIn={percentNotIn}&maxOff.greaterThan={maxOffGreaterThan}&maxOff.lessThan={maxOffLessThan}&maxOff.greaterThanOrEqual={maxOffGreaterThanOrEqual}&maxOff.lessThanOrEqual={maxOffLessThanOrEqual}&maxOff.equals={maxOffEquals}&maxOff.notEquals={maxOffNotEquals}&maxOff.specified={maxOffSpecified}&maxOff.in={maxOffIn}&maxOff.notIn={maxOffNotIn}&minPrice.greaterThan={minPriceGreaterThan}&minPrice.lessThan={minPriceLessThan}&minPrice.greaterThanOrEqual={minPriceGreaterThanOrEqual}&minPrice.lessThanOrEqual={minPriceLessThanOrEqual}&minPrice.equals={minPriceEquals}&minPrice.notEquals={minPriceNotEquals}&minPrice.specified={minPriceSpecified}&minPrice.in={minPriceIn}&minPrice.notIn={minPriceNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  List<PercentOffTotalDTO> getAllPercentOffTotals(@QueryMap(encoded=true) GetAllPercentOffTotalsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllPercentOffTotals</code> that receives the query parameters as a map,
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
          *   <li>percentGreaterThan -  (optional)</li>
          *   <li>percentLessThan -  (optional)</li>
          *   <li>percentGreaterThanOrEqual -  (optional)</li>
          *   <li>percentLessThanOrEqual -  (optional)</li>
          *   <li>percentEquals -  (optional)</li>
          *   <li>percentNotEquals -  (optional)</li>
          *   <li>percentSpecified -  (optional)</li>
          *   <li>percentIn -  (optional)</li>
          *   <li>percentNotIn -  (optional)</li>
          *   <li>maxOffGreaterThan -  (optional)</li>
          *   <li>maxOffLessThan -  (optional)</li>
          *   <li>maxOffGreaterThanOrEqual -  (optional)</li>
          *   <li>maxOffLessThanOrEqual -  (optional)</li>
          *   <li>maxOffEquals -  (optional)</li>
          *   <li>maxOffNotEquals -  (optional)</li>
          *   <li>maxOffSpecified -  (optional)</li>
          *   <li>maxOffIn -  (optional)</li>
          *   <li>maxOffNotIn -  (optional)</li>
          *   <li>minPriceGreaterThan -  (optional)</li>
          *   <li>minPriceLessThan -  (optional)</li>
          *   <li>minPriceGreaterThanOrEqual -  (optional)</li>
          *   <li>minPriceLessThanOrEqual -  (optional)</li>
          *   <li>minPriceEquals -  (optional)</li>
          *   <li>minPriceNotEquals -  (optional)</li>
          *   <li>minPriceSpecified -  (optional)</li>
          *   <li>minPriceIn -  (optional)</li>
          *   <li>minPriceNotIn -  (optional)</li>
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
          *   <li>promotionIdGreaterThan -  (optional)</li>
          *   <li>promotionIdLessThan -  (optional)</li>
          *   <li>promotionIdGreaterThanOrEqual -  (optional)</li>
          *   <li>promotionIdLessThanOrEqual -  (optional)</li>
          *   <li>promotionIdEquals -  (optional)</li>
          *   <li>promotionIdNotEquals -  (optional)</li>
          *   <li>promotionIdSpecified -  (optional)</li>
          *   <li>promotionIdIn -  (optional)</li>
          *   <li>promotionIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return List&lt;PercentOffTotalDTO&gt;
      */
      @RequestLine("GET /api/percent-off-totals?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&percent.greaterThan={percentGreaterThan}&percent.lessThan={percentLessThan}&percent.greaterThanOrEqual={percentGreaterThanOrEqual}&percent.lessThanOrEqual={percentLessThanOrEqual}&percent.equals={percentEquals}&percent.notEquals={percentNotEquals}&percent.specified={percentSpecified}&percent.in={percentIn}&percent.notIn={percentNotIn}&maxOff.greaterThan={maxOffGreaterThan}&maxOff.lessThan={maxOffLessThan}&maxOff.greaterThanOrEqual={maxOffGreaterThanOrEqual}&maxOff.lessThanOrEqual={maxOffLessThanOrEqual}&maxOff.equals={maxOffEquals}&maxOff.notEquals={maxOffNotEquals}&maxOff.specified={maxOffSpecified}&maxOff.in={maxOffIn}&maxOff.notIn={maxOffNotIn}&minPrice.greaterThan={minPriceGreaterThan}&minPrice.lessThan={minPriceLessThan}&minPrice.greaterThanOrEqual={minPriceGreaterThanOrEqual}&minPrice.lessThanOrEqual={minPriceLessThanOrEqual}&minPrice.equals={minPriceEquals}&minPrice.notEquals={minPriceNotEquals}&minPrice.specified={minPriceSpecified}&minPrice.in={minPriceIn}&minPrice.notIn={minPriceNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<PercentOffTotalDTO>> getAllPercentOffTotalsWithHttpInfo(@QueryMap(encoded=true) GetAllPercentOffTotalsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllPercentOffTotals</code> method in a fluent style.
   */
  public static class GetAllPercentOffTotalsQueryParams extends HashMap<String, Object> {
    public GetAllPercentOffTotalsQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams percentGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("percent.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams percentLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("percent.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams percentGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("percent.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams percentLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("percent.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams percentEquals(@jakarta.annotation.Nullable final Integer value) {
      put("percent.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams percentNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("percent.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams percentSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("percent.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams percentIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("percent.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams percentNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("percent.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams maxOffGreaterThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("maxOff.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams maxOffLessThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("maxOff.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams maxOffGreaterThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("maxOff.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams maxOffLessThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("maxOff.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams maxOffEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("maxOff.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams maxOffNotEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("maxOff.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams maxOffSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("maxOff.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams maxOffIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("maxOff.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams maxOffNotIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("maxOff.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams minPriceGreaterThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("minPrice.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams minPriceLessThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("minPrice.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams minPriceGreaterThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("minPrice.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams minPriceLessThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("minPrice.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams minPriceEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("minPrice.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams minPriceNotEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("minPrice.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams minPriceSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("minPrice.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams minPriceIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("minPrice.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams minPriceNotIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("minPrice.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams promotionIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams promotionIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams promotionIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams promotionIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams promotionIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams promotionIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams promotionIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("promotionId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams promotionIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("promotionId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams promotionIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("promotionId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPercentOffTotalsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @return PercentOffTotalDTO
   */
  @RequestLine("GET /api/percent-off-totals/{id}")
  @Headers({
    "Accept: */*",
  })
  PercentOffTotalDTO getPercentOffTotal(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>getPercentOffTotal</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/percent-off-totals/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<PercentOffTotalDTO> getPercentOffTotalWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param id  (required)
   * @param percentOffTotalDTO  (required)
   * @return PercentOffTotalDTO
   */
  @RequestLine("PATCH /api/percent-off-totals/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  PercentOffTotalDTO partialUpdatePercentOffTotal(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull PercentOffTotalDTO percentOffTotalDTO);

  /**
   * 
   * Similar to <code>partialUpdatePercentOffTotal</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param percentOffTotalDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /api/percent-off-totals/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<PercentOffTotalDTO> partialUpdatePercentOffTotalWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull PercentOffTotalDTO percentOffTotalDTO);



  /**
   * 
   * 
   * @param id  (required)
   * @param percentOffTotalDTO  (required)
   * @return PercentOffTotalDTO
   */
  @RequestLine("PUT /api/percent-off-totals/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  PercentOffTotalDTO updatePercentOffTotal(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull PercentOffTotalDTO percentOffTotalDTO);

  /**
   * 
   * Similar to <code>updatePercentOffTotal</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param percentOffTotalDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/percent-off-totals/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<PercentOffTotalDTO> updatePercentOffTotalWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull PercentOffTotalDTO percentOffTotalDTO);


}
