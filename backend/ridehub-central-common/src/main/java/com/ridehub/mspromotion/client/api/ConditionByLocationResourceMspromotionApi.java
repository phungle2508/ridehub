package com.ridehub.mspromotion.client.api;

import com.ridehub.mspromotion.client.invoker.ApiClient;
import com.ridehub.mspromotion.client.invoker.EncodingUtils;
import com.ridehub.mspromotion.client.model.ApiResponse;

import com.ridehub.mspromotion.client.model.ConditionByLocationDTO;
import java.time.OffsetDateTime;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface ConditionByLocationResourceMspromotionApi extends ApiClient.Api {


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
  @RequestLine("GET /api/condition-by-locations/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&itemsId.greaterThan={itemsIdGreaterThan}&itemsId.lessThan={itemsIdLessThan}&itemsId.greaterThanOrEqual={itemsIdGreaterThanOrEqual}&itemsId.lessThanOrEqual={itemsIdLessThanOrEqual}&itemsId.equals={itemsIdEquals}&itemsId.notEquals={itemsIdNotEquals}&itemsId.specified={itemsIdSpecified}&itemsId.in={itemsIdIn}&itemsId.notIn={itemsIdNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  Long countConditionByLocations(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("itemsIdGreaterThan") @jakarta.annotation.Nullable Long itemsIdGreaterThan, @Param("itemsIdLessThan") @jakarta.annotation.Nullable Long itemsIdLessThan, @Param("itemsIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long itemsIdGreaterThanOrEqual, @Param("itemsIdLessThanOrEqual") @jakarta.annotation.Nullable Long itemsIdLessThanOrEqual, @Param("itemsIdEquals") @jakarta.annotation.Nullable Long itemsIdEquals, @Param("itemsIdNotEquals") @jakarta.annotation.Nullable Long itemsIdNotEquals, @Param("itemsIdSpecified") @jakarta.annotation.Nullable Boolean itemsIdSpecified, @Param("itemsIdIn") @jakarta.annotation.Nullable List<Long> itemsIdIn, @Param("itemsIdNotIn") @jakarta.annotation.Nullable List<Long> itemsIdNotIn, @Param("promotionIdGreaterThan") @jakarta.annotation.Nullable Long promotionIdGreaterThan, @Param("promotionIdLessThan") @jakarta.annotation.Nullable Long promotionIdLessThan, @Param("promotionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long promotionIdGreaterThanOrEqual, @Param("promotionIdLessThanOrEqual") @jakarta.annotation.Nullable Long promotionIdLessThanOrEqual, @Param("promotionIdEquals") @jakarta.annotation.Nullable Long promotionIdEquals, @Param("promotionIdNotEquals") @jakarta.annotation.Nullable Long promotionIdNotEquals, @Param("promotionIdSpecified") @jakarta.annotation.Nullable Boolean promotionIdSpecified, @Param("promotionIdIn") @jakarta.annotation.Nullable List<Long> promotionIdIn, @Param("promotionIdNotIn") @jakarta.annotation.Nullable List<Long> promotionIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>countConditionByLocations</code> but it also returns the http response headers .
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
  @RequestLine("GET /api/condition-by-locations/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&itemsId.greaterThan={itemsIdGreaterThan}&itemsId.lessThan={itemsIdLessThan}&itemsId.greaterThanOrEqual={itemsIdGreaterThanOrEqual}&itemsId.lessThanOrEqual={itemsIdLessThanOrEqual}&itemsId.equals={itemsIdEquals}&itemsId.notEquals={itemsIdNotEquals}&itemsId.specified={itemsIdSpecified}&itemsId.in={itemsIdIn}&itemsId.notIn={itemsIdNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Long> countConditionByLocationsWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("itemsIdGreaterThan") @jakarta.annotation.Nullable Long itemsIdGreaterThan, @Param("itemsIdLessThan") @jakarta.annotation.Nullable Long itemsIdLessThan, @Param("itemsIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long itemsIdGreaterThanOrEqual, @Param("itemsIdLessThanOrEqual") @jakarta.annotation.Nullable Long itemsIdLessThanOrEqual, @Param("itemsIdEquals") @jakarta.annotation.Nullable Long itemsIdEquals, @Param("itemsIdNotEquals") @jakarta.annotation.Nullable Long itemsIdNotEquals, @Param("itemsIdSpecified") @jakarta.annotation.Nullable Boolean itemsIdSpecified, @Param("itemsIdIn") @jakarta.annotation.Nullable List<Long> itemsIdIn, @Param("itemsIdNotIn") @jakarta.annotation.Nullable List<Long> itemsIdNotIn, @Param("promotionIdGreaterThan") @jakarta.annotation.Nullable Long promotionIdGreaterThan, @Param("promotionIdLessThan") @jakarta.annotation.Nullable Long promotionIdLessThan, @Param("promotionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long promotionIdGreaterThanOrEqual, @Param("promotionIdLessThanOrEqual") @jakarta.annotation.Nullable Long promotionIdLessThanOrEqual, @Param("promotionIdEquals") @jakarta.annotation.Nullable Long promotionIdEquals, @Param("promotionIdNotEquals") @jakarta.annotation.Nullable Long promotionIdNotEquals, @Param("promotionIdSpecified") @jakarta.annotation.Nullable Boolean promotionIdSpecified, @Param("promotionIdIn") @jakarta.annotation.Nullable List<Long> promotionIdIn, @Param("promotionIdNotIn") @jakarta.annotation.Nullable List<Long> promotionIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>countConditionByLocations</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CountConditionByLocationsQueryParams} class that allows for
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
  @RequestLine("GET /api/condition-by-locations/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&itemsId.greaterThan={itemsIdGreaterThan}&itemsId.lessThan={itemsIdLessThan}&itemsId.greaterThanOrEqual={itemsIdGreaterThanOrEqual}&itemsId.lessThanOrEqual={itemsIdLessThanOrEqual}&itemsId.equals={itemsIdEquals}&itemsId.notEquals={itemsIdNotEquals}&itemsId.specified={itemsIdSpecified}&itemsId.in={itemsIdIn}&itemsId.notIn={itemsIdNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  Long countConditionByLocations(@QueryMap(encoded=true) CountConditionByLocationsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>countConditionByLocations</code> that receives the query parameters as a map,
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
      @RequestLine("GET /api/condition-by-locations/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&itemsId.greaterThan={itemsIdGreaterThan}&itemsId.lessThan={itemsIdLessThan}&itemsId.greaterThanOrEqual={itemsIdGreaterThanOrEqual}&itemsId.lessThanOrEqual={itemsIdLessThanOrEqual}&itemsId.equals={itemsIdEquals}&itemsId.notEquals={itemsIdNotEquals}&itemsId.specified={itemsIdSpecified}&itemsId.in={itemsIdIn}&itemsId.notIn={itemsIdNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Long> countConditionByLocationsWithHttpInfo(@QueryMap(encoded=true) CountConditionByLocationsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>countConditionByLocations</code> method in a fluent style.
   */
  public static class CountConditionByLocationsQueryParams extends HashMap<String, Object> {
    public CountConditionByLocationsQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByLocationsQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByLocationsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByLocationsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByLocationsQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByLocationsQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByLocationsQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByLocationsQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByLocationsQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByLocationsQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByLocationsQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByLocationsQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByLocationsQueryParams itemsIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams itemsIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams itemsIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams itemsIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams itemsIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams itemsIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams itemsIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("itemsId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams itemsIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("itemsId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByLocationsQueryParams itemsIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("itemsId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByLocationsQueryParams promotionIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams promotionIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams promotionIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams promotionIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams promotionIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams promotionIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams promotionIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("promotionId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByLocationsQueryParams promotionIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("promotionId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByLocationsQueryParams promotionIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("promotionId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByLocationsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param conditionByLocationDTO  (required)
   * @return ConditionByLocationDTO
   */
  @RequestLine("POST /api/condition-by-locations")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ConditionByLocationDTO createConditionByLocation(@jakarta.annotation.Nonnull ConditionByLocationDTO conditionByLocationDTO);

  /**
   * 
   * Similar to <code>createConditionByLocation</code> but it also returns the http response headers .
   * 
   * @param conditionByLocationDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/condition-by-locations")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<ConditionByLocationDTO> createConditionByLocationWithHttpInfo(@jakarta.annotation.Nonnull ConditionByLocationDTO conditionByLocationDTO);



  /**
   * 
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/condition-by-locations/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteConditionByLocation(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>deleteConditionByLocation</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/condition-by-locations/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteConditionByLocationWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



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
   * @return List&lt;ConditionByLocationDTO&gt;
   */
  @RequestLine("GET /api/condition-by-locations?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&itemsId.greaterThan={itemsIdGreaterThan}&itemsId.lessThan={itemsIdLessThan}&itemsId.greaterThanOrEqual={itemsIdGreaterThanOrEqual}&itemsId.lessThanOrEqual={itemsIdLessThanOrEqual}&itemsId.equals={itemsIdEquals}&itemsId.notEquals={itemsIdNotEquals}&itemsId.specified={itemsIdSpecified}&itemsId.in={itemsIdIn}&itemsId.notIn={itemsIdNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  List<ConditionByLocationDTO> getAllConditionByLocations(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("itemsIdGreaterThan") @jakarta.annotation.Nullable Long itemsIdGreaterThan, @Param("itemsIdLessThan") @jakarta.annotation.Nullable Long itemsIdLessThan, @Param("itemsIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long itemsIdGreaterThanOrEqual, @Param("itemsIdLessThanOrEqual") @jakarta.annotation.Nullable Long itemsIdLessThanOrEqual, @Param("itemsIdEquals") @jakarta.annotation.Nullable Long itemsIdEquals, @Param("itemsIdNotEquals") @jakarta.annotation.Nullable Long itemsIdNotEquals, @Param("itemsIdSpecified") @jakarta.annotation.Nullable Boolean itemsIdSpecified, @Param("itemsIdIn") @jakarta.annotation.Nullable List<Long> itemsIdIn, @Param("itemsIdNotIn") @jakarta.annotation.Nullable List<Long> itemsIdNotIn, @Param("promotionIdGreaterThan") @jakarta.annotation.Nullable Long promotionIdGreaterThan, @Param("promotionIdLessThan") @jakarta.annotation.Nullable Long promotionIdLessThan, @Param("promotionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long promotionIdGreaterThanOrEqual, @Param("promotionIdLessThanOrEqual") @jakarta.annotation.Nullable Long promotionIdLessThanOrEqual, @Param("promotionIdEquals") @jakarta.annotation.Nullable Long promotionIdEquals, @Param("promotionIdNotEquals") @jakarta.annotation.Nullable Long promotionIdNotEquals, @Param("promotionIdSpecified") @jakarta.annotation.Nullable Boolean promotionIdSpecified, @Param("promotionIdIn") @jakarta.annotation.Nullable List<Long> promotionIdIn, @Param("promotionIdNotIn") @jakarta.annotation.Nullable List<Long> promotionIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>getAllConditionByLocations</code> but it also returns the http response headers .
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
  @RequestLine("GET /api/condition-by-locations?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&itemsId.greaterThan={itemsIdGreaterThan}&itemsId.lessThan={itemsIdLessThan}&itemsId.greaterThanOrEqual={itemsIdGreaterThanOrEqual}&itemsId.lessThanOrEqual={itemsIdLessThanOrEqual}&itemsId.equals={itemsIdEquals}&itemsId.notEquals={itemsIdNotEquals}&itemsId.specified={itemsIdSpecified}&itemsId.in={itemsIdIn}&itemsId.notIn={itemsIdNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<ConditionByLocationDTO>> getAllConditionByLocationsWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("itemsIdGreaterThan") @jakarta.annotation.Nullable Long itemsIdGreaterThan, @Param("itemsIdLessThan") @jakarta.annotation.Nullable Long itemsIdLessThan, @Param("itemsIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long itemsIdGreaterThanOrEqual, @Param("itemsIdLessThanOrEqual") @jakarta.annotation.Nullable Long itemsIdLessThanOrEqual, @Param("itemsIdEquals") @jakarta.annotation.Nullable Long itemsIdEquals, @Param("itemsIdNotEquals") @jakarta.annotation.Nullable Long itemsIdNotEquals, @Param("itemsIdSpecified") @jakarta.annotation.Nullable Boolean itemsIdSpecified, @Param("itemsIdIn") @jakarta.annotation.Nullable List<Long> itemsIdIn, @Param("itemsIdNotIn") @jakarta.annotation.Nullable List<Long> itemsIdNotIn, @Param("promotionIdGreaterThan") @jakarta.annotation.Nullable Long promotionIdGreaterThan, @Param("promotionIdLessThan") @jakarta.annotation.Nullable Long promotionIdLessThan, @Param("promotionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long promotionIdGreaterThanOrEqual, @Param("promotionIdLessThanOrEqual") @jakarta.annotation.Nullable Long promotionIdLessThanOrEqual, @Param("promotionIdEquals") @jakarta.annotation.Nullable Long promotionIdEquals, @Param("promotionIdNotEquals") @jakarta.annotation.Nullable Long promotionIdNotEquals, @Param("promotionIdSpecified") @jakarta.annotation.Nullable Boolean promotionIdSpecified, @Param("promotionIdIn") @jakarta.annotation.Nullable List<Long> promotionIdIn, @Param("promotionIdNotIn") @jakarta.annotation.Nullable List<Long> promotionIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllConditionByLocations</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllConditionByLocationsQueryParams} class that allows for
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
   * @return List&lt;ConditionByLocationDTO&gt;
   */
  @RequestLine("GET /api/condition-by-locations?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&itemsId.greaterThan={itemsIdGreaterThan}&itemsId.lessThan={itemsIdLessThan}&itemsId.greaterThanOrEqual={itemsIdGreaterThanOrEqual}&itemsId.lessThanOrEqual={itemsIdLessThanOrEqual}&itemsId.equals={itemsIdEquals}&itemsId.notEquals={itemsIdNotEquals}&itemsId.specified={itemsIdSpecified}&itemsId.in={itemsIdIn}&itemsId.notIn={itemsIdNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  List<ConditionByLocationDTO> getAllConditionByLocations(@QueryMap(encoded=true) GetAllConditionByLocationsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllConditionByLocations</code> that receives the query parameters as a map,
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
          * @return List&lt;ConditionByLocationDTO&gt;
      */
      @RequestLine("GET /api/condition-by-locations?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&itemsId.greaterThan={itemsIdGreaterThan}&itemsId.lessThan={itemsIdLessThan}&itemsId.greaterThanOrEqual={itemsIdGreaterThanOrEqual}&itemsId.lessThanOrEqual={itemsIdLessThanOrEqual}&itemsId.equals={itemsIdEquals}&itemsId.notEquals={itemsIdNotEquals}&itemsId.specified={itemsIdSpecified}&itemsId.in={itemsIdIn}&itemsId.notIn={itemsIdNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<ConditionByLocationDTO>> getAllConditionByLocationsWithHttpInfo(@QueryMap(encoded=true) GetAllConditionByLocationsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllConditionByLocations</code> method in a fluent style.
   */
  public static class GetAllConditionByLocationsQueryParams extends HashMap<String, Object> {
    public GetAllConditionByLocationsQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByLocationsQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByLocationsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByLocationsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByLocationsQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByLocationsQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByLocationsQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByLocationsQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByLocationsQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByLocationsQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByLocationsQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByLocationsQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByLocationsQueryParams itemsIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams itemsIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams itemsIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams itemsIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams itemsIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams itemsIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams itemsIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("itemsId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams itemsIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("itemsId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByLocationsQueryParams itemsIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("itemsId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByLocationsQueryParams promotionIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams promotionIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams promotionIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams promotionIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams promotionIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams promotionIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams promotionIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("promotionId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByLocationsQueryParams promotionIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("promotionId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByLocationsQueryParams promotionIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("promotionId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByLocationsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @return ConditionByLocationDTO
   */
  @RequestLine("GET /api/condition-by-locations/{id}")
  @Headers({
    "Accept: */*",
  })
  ConditionByLocationDTO getConditionByLocation(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>getConditionByLocation</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/condition-by-locations/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<ConditionByLocationDTO> getConditionByLocationWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param id  (required)
   * @param conditionByLocationDTO  (required)
   * @return ConditionByLocationDTO
   */
  @RequestLine("PATCH /api/condition-by-locations/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ConditionByLocationDTO partialUpdateConditionByLocation(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull ConditionByLocationDTO conditionByLocationDTO);

  /**
   * 
   * Similar to <code>partialUpdateConditionByLocation</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param conditionByLocationDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /api/condition-by-locations/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<ConditionByLocationDTO> partialUpdateConditionByLocationWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull ConditionByLocationDTO conditionByLocationDTO);



  /**
   * 
   * 
   * @param id  (required)
   * @param conditionByLocationDTO  (required)
   * @return ConditionByLocationDTO
   */
  @RequestLine("PUT /api/condition-by-locations/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ConditionByLocationDTO updateConditionByLocation(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull ConditionByLocationDTO conditionByLocationDTO);

  /**
   * 
   * Similar to <code>updateConditionByLocation</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param conditionByLocationDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/condition-by-locations/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<ConditionByLocationDTO> updateConditionByLocationWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull ConditionByLocationDTO conditionByLocationDTO);


}
