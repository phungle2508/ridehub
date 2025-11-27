package com.ridehub.mspromotion.client.api;

import com.ridehub.mspromotion.client.invoker.ApiClient;
import com.ridehub.mspromotion.client.invoker.EncodingUtils;
import com.ridehub.mspromotion.client.model.ApiResponse;

import com.ridehub.mspromotion.client.model.ConditionByDateDTO;
import java.time.OffsetDateTime;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface ConditionByDateResourceMspromotionApi extends ApiClient.Api {


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
   * @param itemsIdGreaterThan  (optional)
   * @param itemsIdLessThan  (optional)
   * @param itemsIdGreaterThanOrEqual  (optional)
   * @param itemsIdLessThanOrEqual  (optional)
   * @param itemsIdEquals  (optional)
   * @param itemsIdNotEquals  (optional)
   * @param itemsIdSpecified  (optional)
   * @param itemsIdIn  (optional)
   * @param itemsIdNotIn  (optional)
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
  @RequestLine("GET /api/condition-by-dates/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&itemsId.greaterThan={itemsIdGreaterThan}&itemsId.lessThan={itemsIdLessThan}&itemsId.greaterThanOrEqual={itemsIdGreaterThanOrEqual}&itemsId.lessThanOrEqual={itemsIdLessThanOrEqual}&itemsId.equals={itemsIdEquals}&itemsId.notEquals={itemsIdNotEquals}&itemsId.specified={itemsIdSpecified}&itemsId.in={itemsIdIn}&itemsId.notIn={itemsIdNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  Long countConditionByDates(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("itemsIdGreaterThan") @jakarta.annotation.Nullable Long itemsIdGreaterThan, @Param("itemsIdLessThan") @jakarta.annotation.Nullable Long itemsIdLessThan, @Param("itemsIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long itemsIdGreaterThanOrEqual, @Param("itemsIdLessThanOrEqual") @jakarta.annotation.Nullable Long itemsIdLessThanOrEqual, @Param("itemsIdEquals") @jakarta.annotation.Nullable Long itemsIdEquals, @Param("itemsIdNotEquals") @jakarta.annotation.Nullable Long itemsIdNotEquals, @Param("itemsIdSpecified") @jakarta.annotation.Nullable Boolean itemsIdSpecified, @Param("itemsIdIn") @jakarta.annotation.Nullable List<Long> itemsIdIn, @Param("itemsIdNotIn") @jakarta.annotation.Nullable List<Long> itemsIdNotIn, @Param("promotionIdGreaterThan") @jakarta.annotation.Nullable Long promotionIdGreaterThan, @Param("promotionIdLessThan") @jakarta.annotation.Nullable Long promotionIdLessThan, @Param("promotionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long promotionIdGreaterThanOrEqual, @Param("promotionIdLessThanOrEqual") @jakarta.annotation.Nullable Long promotionIdLessThanOrEqual, @Param("promotionIdEquals") @jakarta.annotation.Nullable Long promotionIdEquals, @Param("promotionIdNotEquals") @jakarta.annotation.Nullable Long promotionIdNotEquals, @Param("promotionIdSpecified") @jakarta.annotation.Nullable Boolean promotionIdSpecified, @Param("promotionIdIn") @jakarta.annotation.Nullable List<Long> promotionIdIn, @Param("promotionIdNotIn") @jakarta.annotation.Nullable List<Long> promotionIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>countConditionByDates</code> but it also returns the http response headers .
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
   * @param itemsIdGreaterThan  (optional)
   * @param itemsIdLessThan  (optional)
   * @param itemsIdGreaterThanOrEqual  (optional)
   * @param itemsIdLessThanOrEqual  (optional)
   * @param itemsIdEquals  (optional)
   * @param itemsIdNotEquals  (optional)
   * @param itemsIdSpecified  (optional)
   * @param itemsIdIn  (optional)
   * @param itemsIdNotIn  (optional)
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
  @RequestLine("GET /api/condition-by-dates/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&itemsId.greaterThan={itemsIdGreaterThan}&itemsId.lessThan={itemsIdLessThan}&itemsId.greaterThanOrEqual={itemsIdGreaterThanOrEqual}&itemsId.lessThanOrEqual={itemsIdLessThanOrEqual}&itemsId.equals={itemsIdEquals}&itemsId.notEquals={itemsIdNotEquals}&itemsId.specified={itemsIdSpecified}&itemsId.in={itemsIdIn}&itemsId.notIn={itemsIdNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Long> countConditionByDatesWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("itemsIdGreaterThan") @jakarta.annotation.Nullable Long itemsIdGreaterThan, @Param("itemsIdLessThan") @jakarta.annotation.Nullable Long itemsIdLessThan, @Param("itemsIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long itemsIdGreaterThanOrEqual, @Param("itemsIdLessThanOrEqual") @jakarta.annotation.Nullable Long itemsIdLessThanOrEqual, @Param("itemsIdEquals") @jakarta.annotation.Nullable Long itemsIdEquals, @Param("itemsIdNotEquals") @jakarta.annotation.Nullable Long itemsIdNotEquals, @Param("itemsIdSpecified") @jakarta.annotation.Nullable Boolean itemsIdSpecified, @Param("itemsIdIn") @jakarta.annotation.Nullable List<Long> itemsIdIn, @Param("itemsIdNotIn") @jakarta.annotation.Nullable List<Long> itemsIdNotIn, @Param("promotionIdGreaterThan") @jakarta.annotation.Nullable Long promotionIdGreaterThan, @Param("promotionIdLessThan") @jakarta.annotation.Nullable Long promotionIdLessThan, @Param("promotionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long promotionIdGreaterThanOrEqual, @Param("promotionIdLessThanOrEqual") @jakarta.annotation.Nullable Long promotionIdLessThanOrEqual, @Param("promotionIdEquals") @jakarta.annotation.Nullable Long promotionIdEquals, @Param("promotionIdNotEquals") @jakarta.annotation.Nullable Long promotionIdNotEquals, @Param("promotionIdSpecified") @jakarta.annotation.Nullable Boolean promotionIdSpecified, @Param("promotionIdIn") @jakarta.annotation.Nullable List<Long> promotionIdIn, @Param("promotionIdNotIn") @jakarta.annotation.Nullable List<Long> promotionIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>countConditionByDates</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CountConditionByDatesQueryParams} class that allows for
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
   *   <li>itemsIdGreaterThan -  (optional)</li>
   *   <li>itemsIdLessThan -  (optional)</li>
   *   <li>itemsIdGreaterThanOrEqual -  (optional)</li>
   *   <li>itemsIdLessThanOrEqual -  (optional)</li>
   *   <li>itemsIdEquals -  (optional)</li>
   *   <li>itemsIdNotEquals -  (optional)</li>
   *   <li>itemsIdSpecified -  (optional)</li>
   *   <li>itemsIdIn -  (optional)</li>
   *   <li>itemsIdNotIn -  (optional)</li>
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
  @RequestLine("GET /api/condition-by-dates/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&itemsId.greaterThan={itemsIdGreaterThan}&itemsId.lessThan={itemsIdLessThan}&itemsId.greaterThanOrEqual={itemsIdGreaterThanOrEqual}&itemsId.lessThanOrEqual={itemsIdLessThanOrEqual}&itemsId.equals={itemsIdEquals}&itemsId.notEquals={itemsIdNotEquals}&itemsId.specified={itemsIdSpecified}&itemsId.in={itemsIdIn}&itemsId.notIn={itemsIdNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  Long countConditionByDates(@QueryMap(encoded=true) CountConditionByDatesQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>countConditionByDates</code> that receives the query parameters as a map,
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
          *   <li>itemsIdGreaterThan -  (optional)</li>
          *   <li>itemsIdLessThan -  (optional)</li>
          *   <li>itemsIdGreaterThanOrEqual -  (optional)</li>
          *   <li>itemsIdLessThanOrEqual -  (optional)</li>
          *   <li>itemsIdEquals -  (optional)</li>
          *   <li>itemsIdNotEquals -  (optional)</li>
          *   <li>itemsIdSpecified -  (optional)</li>
          *   <li>itemsIdIn -  (optional)</li>
          *   <li>itemsIdNotIn -  (optional)</li>
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
      @RequestLine("GET /api/condition-by-dates/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&itemsId.greaterThan={itemsIdGreaterThan}&itemsId.lessThan={itemsIdLessThan}&itemsId.greaterThanOrEqual={itemsIdGreaterThanOrEqual}&itemsId.lessThanOrEqual={itemsIdLessThanOrEqual}&itemsId.equals={itemsIdEquals}&itemsId.notEquals={itemsIdNotEquals}&itemsId.specified={itemsIdSpecified}&itemsId.in={itemsIdIn}&itemsId.notIn={itemsIdNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Long> countConditionByDatesWithHttpInfo(@QueryMap(encoded=true) CountConditionByDatesQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>countConditionByDates</code> method in a fluent style.
   */
  public static class CountConditionByDatesQueryParams extends HashMap<String, Object> {
    public CountConditionByDatesQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByDatesQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByDatesQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByDatesQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByDatesQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByDatesQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByDatesQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByDatesQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByDatesQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByDatesQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByDatesQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByDatesQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByDatesQueryParams itemsIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams itemsIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams itemsIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams itemsIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams itemsIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams itemsIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams itemsIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("itemsId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams itemsIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("itemsId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByDatesQueryParams itemsIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("itemsId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByDatesQueryParams promotionIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams promotionIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams promotionIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams promotionIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams promotionIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams promotionIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams promotionIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("promotionId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByDatesQueryParams promotionIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("promotionId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByDatesQueryParams promotionIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("promotionId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByDatesQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param conditionByDateDTO  (required)
   * @return ConditionByDateDTO
   */
  @RequestLine("POST /api/condition-by-dates")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ConditionByDateDTO createConditionByDate(@jakarta.annotation.Nonnull ConditionByDateDTO conditionByDateDTO);

  /**
   * 
   * Similar to <code>createConditionByDate</code> but it also returns the http response headers .
   * 
   * @param conditionByDateDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/condition-by-dates")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<ConditionByDateDTO> createConditionByDateWithHttpInfo(@jakarta.annotation.Nonnull ConditionByDateDTO conditionByDateDTO);



  /**
   * 
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/condition-by-dates/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteConditionByDate(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>deleteConditionByDate</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/condition-by-dates/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteConditionByDateWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



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
   * @param itemsIdGreaterThan  (optional)
   * @param itemsIdLessThan  (optional)
   * @param itemsIdGreaterThanOrEqual  (optional)
   * @param itemsIdLessThanOrEqual  (optional)
   * @param itemsIdEquals  (optional)
   * @param itemsIdNotEquals  (optional)
   * @param itemsIdSpecified  (optional)
   * @param itemsIdIn  (optional)
   * @param itemsIdNotIn  (optional)
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
   * @return List&lt;ConditionByDateDTO&gt;
   */
  @RequestLine("GET /api/condition-by-dates?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&itemsId.greaterThan={itemsIdGreaterThan}&itemsId.lessThan={itemsIdLessThan}&itemsId.greaterThanOrEqual={itemsIdGreaterThanOrEqual}&itemsId.lessThanOrEqual={itemsIdLessThanOrEqual}&itemsId.equals={itemsIdEquals}&itemsId.notEquals={itemsIdNotEquals}&itemsId.specified={itemsIdSpecified}&itemsId.in={itemsIdIn}&itemsId.notIn={itemsIdNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  List<ConditionByDateDTO> getAllConditionByDates(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("itemsIdGreaterThan") @jakarta.annotation.Nullable Long itemsIdGreaterThan, @Param("itemsIdLessThan") @jakarta.annotation.Nullable Long itemsIdLessThan, @Param("itemsIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long itemsIdGreaterThanOrEqual, @Param("itemsIdLessThanOrEqual") @jakarta.annotation.Nullable Long itemsIdLessThanOrEqual, @Param("itemsIdEquals") @jakarta.annotation.Nullable Long itemsIdEquals, @Param("itemsIdNotEquals") @jakarta.annotation.Nullable Long itemsIdNotEquals, @Param("itemsIdSpecified") @jakarta.annotation.Nullable Boolean itemsIdSpecified, @Param("itemsIdIn") @jakarta.annotation.Nullable List<Long> itemsIdIn, @Param("itemsIdNotIn") @jakarta.annotation.Nullable List<Long> itemsIdNotIn, @Param("promotionIdGreaterThan") @jakarta.annotation.Nullable Long promotionIdGreaterThan, @Param("promotionIdLessThan") @jakarta.annotation.Nullable Long promotionIdLessThan, @Param("promotionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long promotionIdGreaterThanOrEqual, @Param("promotionIdLessThanOrEqual") @jakarta.annotation.Nullable Long promotionIdLessThanOrEqual, @Param("promotionIdEquals") @jakarta.annotation.Nullable Long promotionIdEquals, @Param("promotionIdNotEquals") @jakarta.annotation.Nullable Long promotionIdNotEquals, @Param("promotionIdSpecified") @jakarta.annotation.Nullable Boolean promotionIdSpecified, @Param("promotionIdIn") @jakarta.annotation.Nullable List<Long> promotionIdIn, @Param("promotionIdNotIn") @jakarta.annotation.Nullable List<Long> promotionIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>getAllConditionByDates</code> but it also returns the http response headers .
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
   * @param itemsIdGreaterThan  (optional)
   * @param itemsIdLessThan  (optional)
   * @param itemsIdGreaterThanOrEqual  (optional)
   * @param itemsIdLessThanOrEqual  (optional)
   * @param itemsIdEquals  (optional)
   * @param itemsIdNotEquals  (optional)
   * @param itemsIdSpecified  (optional)
   * @param itemsIdIn  (optional)
   * @param itemsIdNotIn  (optional)
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
  @RequestLine("GET /api/condition-by-dates?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&itemsId.greaterThan={itemsIdGreaterThan}&itemsId.lessThan={itemsIdLessThan}&itemsId.greaterThanOrEqual={itemsIdGreaterThanOrEqual}&itemsId.lessThanOrEqual={itemsIdLessThanOrEqual}&itemsId.equals={itemsIdEquals}&itemsId.notEquals={itemsIdNotEquals}&itemsId.specified={itemsIdSpecified}&itemsId.in={itemsIdIn}&itemsId.notIn={itemsIdNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<ConditionByDateDTO>> getAllConditionByDatesWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("itemsIdGreaterThan") @jakarta.annotation.Nullable Long itemsIdGreaterThan, @Param("itemsIdLessThan") @jakarta.annotation.Nullable Long itemsIdLessThan, @Param("itemsIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long itemsIdGreaterThanOrEqual, @Param("itemsIdLessThanOrEqual") @jakarta.annotation.Nullable Long itemsIdLessThanOrEqual, @Param("itemsIdEquals") @jakarta.annotation.Nullable Long itemsIdEquals, @Param("itemsIdNotEquals") @jakarta.annotation.Nullable Long itemsIdNotEquals, @Param("itemsIdSpecified") @jakarta.annotation.Nullable Boolean itemsIdSpecified, @Param("itemsIdIn") @jakarta.annotation.Nullable List<Long> itemsIdIn, @Param("itemsIdNotIn") @jakarta.annotation.Nullable List<Long> itemsIdNotIn, @Param("promotionIdGreaterThan") @jakarta.annotation.Nullable Long promotionIdGreaterThan, @Param("promotionIdLessThan") @jakarta.annotation.Nullable Long promotionIdLessThan, @Param("promotionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long promotionIdGreaterThanOrEqual, @Param("promotionIdLessThanOrEqual") @jakarta.annotation.Nullable Long promotionIdLessThanOrEqual, @Param("promotionIdEquals") @jakarta.annotation.Nullable Long promotionIdEquals, @Param("promotionIdNotEquals") @jakarta.annotation.Nullable Long promotionIdNotEquals, @Param("promotionIdSpecified") @jakarta.annotation.Nullable Boolean promotionIdSpecified, @Param("promotionIdIn") @jakarta.annotation.Nullable List<Long> promotionIdIn, @Param("promotionIdNotIn") @jakarta.annotation.Nullable List<Long> promotionIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllConditionByDates</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllConditionByDatesQueryParams} class that allows for
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
   *   <li>itemsIdGreaterThan -  (optional)</li>
   *   <li>itemsIdLessThan -  (optional)</li>
   *   <li>itemsIdGreaterThanOrEqual -  (optional)</li>
   *   <li>itemsIdLessThanOrEqual -  (optional)</li>
   *   <li>itemsIdEquals -  (optional)</li>
   *   <li>itemsIdNotEquals -  (optional)</li>
   *   <li>itemsIdSpecified -  (optional)</li>
   *   <li>itemsIdIn -  (optional)</li>
   *   <li>itemsIdNotIn -  (optional)</li>
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
   * @return List&lt;ConditionByDateDTO&gt;
   */
  @RequestLine("GET /api/condition-by-dates?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&itemsId.greaterThan={itemsIdGreaterThan}&itemsId.lessThan={itemsIdLessThan}&itemsId.greaterThanOrEqual={itemsIdGreaterThanOrEqual}&itemsId.lessThanOrEqual={itemsIdLessThanOrEqual}&itemsId.equals={itemsIdEquals}&itemsId.notEquals={itemsIdNotEquals}&itemsId.specified={itemsIdSpecified}&itemsId.in={itemsIdIn}&itemsId.notIn={itemsIdNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  List<ConditionByDateDTO> getAllConditionByDates(@QueryMap(encoded=true) GetAllConditionByDatesQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllConditionByDates</code> that receives the query parameters as a map,
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
          *   <li>itemsIdGreaterThan -  (optional)</li>
          *   <li>itemsIdLessThan -  (optional)</li>
          *   <li>itemsIdGreaterThanOrEqual -  (optional)</li>
          *   <li>itemsIdLessThanOrEqual -  (optional)</li>
          *   <li>itemsIdEquals -  (optional)</li>
          *   <li>itemsIdNotEquals -  (optional)</li>
          *   <li>itemsIdSpecified -  (optional)</li>
          *   <li>itemsIdIn -  (optional)</li>
          *   <li>itemsIdNotIn -  (optional)</li>
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
          * @return List&lt;ConditionByDateDTO&gt;
      */
      @RequestLine("GET /api/condition-by-dates?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&itemsId.greaterThan={itemsIdGreaterThan}&itemsId.lessThan={itemsIdLessThan}&itemsId.greaterThanOrEqual={itemsIdGreaterThanOrEqual}&itemsId.lessThanOrEqual={itemsIdLessThanOrEqual}&itemsId.equals={itemsIdEquals}&itemsId.notEquals={itemsIdNotEquals}&itemsId.specified={itemsIdSpecified}&itemsId.in={itemsIdIn}&itemsId.notIn={itemsIdNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<ConditionByDateDTO>> getAllConditionByDatesWithHttpInfo(@QueryMap(encoded=true) GetAllConditionByDatesQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllConditionByDates</code> method in a fluent style.
   */
  public static class GetAllConditionByDatesQueryParams extends HashMap<String, Object> {
    public GetAllConditionByDatesQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByDatesQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByDatesQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByDatesQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByDatesQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByDatesQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByDatesQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByDatesQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByDatesQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByDatesQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByDatesQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByDatesQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByDatesQueryParams itemsIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams itemsIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams itemsIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams itemsIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams itemsIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams itemsIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams itemsIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("itemsId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams itemsIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("itemsId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByDatesQueryParams itemsIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("itemsId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByDatesQueryParams promotionIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams promotionIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams promotionIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams promotionIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams promotionIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams promotionIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams promotionIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("promotionId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByDatesQueryParams promotionIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("promotionId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByDatesQueryParams promotionIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("promotionId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByDatesQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @return ConditionByDateDTO
   */
  @RequestLine("GET /api/condition-by-dates/{id}")
  @Headers({
    "Accept: */*",
  })
  ConditionByDateDTO getConditionByDate(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>getConditionByDate</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/condition-by-dates/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<ConditionByDateDTO> getConditionByDateWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param id  (required)
   * @param conditionByDateDTO  (required)
   * @return ConditionByDateDTO
   */
  @RequestLine("PATCH /api/condition-by-dates/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ConditionByDateDTO partialUpdateConditionByDate(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull ConditionByDateDTO conditionByDateDTO);

  /**
   * 
   * Similar to <code>partialUpdateConditionByDate</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param conditionByDateDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /api/condition-by-dates/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<ConditionByDateDTO> partialUpdateConditionByDateWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull ConditionByDateDTO conditionByDateDTO);



  /**
   * 
   * 
   * @param id  (required)
   * @param conditionByDateDTO  (required)
   * @return ConditionByDateDTO
   */
  @RequestLine("PUT /api/condition-by-dates/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ConditionByDateDTO updateConditionByDate(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull ConditionByDateDTO conditionByDateDTO);

  /**
   * 
   * Similar to <code>updateConditionByDate</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param conditionByDateDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/condition-by-dates/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<ConditionByDateDTO> updateConditionByDateWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull ConditionByDateDTO conditionByDateDTO);


}
