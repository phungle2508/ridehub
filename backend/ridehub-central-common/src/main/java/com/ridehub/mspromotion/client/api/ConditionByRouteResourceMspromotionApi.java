package com.ridehub.mspromotion.client.api;

import com.ridehub.mspromotion.client.invoker.ApiClient;
import com.ridehub.mspromotion.client.invoker.EncodingUtils;
import com.ridehub.mspromotion.client.model.ApiResponse;

import com.ridehub.mspromotion.client.model.ConditionByRouteDTO;
import java.time.OffsetDateTime;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface ConditionByRouteResourceMspromotionApi extends ApiClient.Api {


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
  @RequestLine("GET /api/condition-by-routes/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&itemsId.greaterThan={itemsIdGreaterThan}&itemsId.lessThan={itemsIdLessThan}&itemsId.greaterThanOrEqual={itemsIdGreaterThanOrEqual}&itemsId.lessThanOrEqual={itemsIdLessThanOrEqual}&itemsId.equals={itemsIdEquals}&itemsId.notEquals={itemsIdNotEquals}&itemsId.specified={itemsIdSpecified}&itemsId.in={itemsIdIn}&itemsId.notIn={itemsIdNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  Long countConditionByRoutes(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("itemsIdGreaterThan") @jakarta.annotation.Nullable Long itemsIdGreaterThan, @Param("itemsIdLessThan") @jakarta.annotation.Nullable Long itemsIdLessThan, @Param("itemsIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long itemsIdGreaterThanOrEqual, @Param("itemsIdLessThanOrEqual") @jakarta.annotation.Nullable Long itemsIdLessThanOrEqual, @Param("itemsIdEquals") @jakarta.annotation.Nullable Long itemsIdEquals, @Param("itemsIdNotEquals") @jakarta.annotation.Nullable Long itemsIdNotEquals, @Param("itemsIdSpecified") @jakarta.annotation.Nullable Boolean itemsIdSpecified, @Param("itemsIdIn") @jakarta.annotation.Nullable List<Long> itemsIdIn, @Param("itemsIdNotIn") @jakarta.annotation.Nullable List<Long> itemsIdNotIn, @Param("promotionIdGreaterThan") @jakarta.annotation.Nullable Long promotionIdGreaterThan, @Param("promotionIdLessThan") @jakarta.annotation.Nullable Long promotionIdLessThan, @Param("promotionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long promotionIdGreaterThanOrEqual, @Param("promotionIdLessThanOrEqual") @jakarta.annotation.Nullable Long promotionIdLessThanOrEqual, @Param("promotionIdEquals") @jakarta.annotation.Nullable Long promotionIdEquals, @Param("promotionIdNotEquals") @jakarta.annotation.Nullable Long promotionIdNotEquals, @Param("promotionIdSpecified") @jakarta.annotation.Nullable Boolean promotionIdSpecified, @Param("promotionIdIn") @jakarta.annotation.Nullable List<Long> promotionIdIn, @Param("promotionIdNotIn") @jakarta.annotation.Nullable List<Long> promotionIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>countConditionByRoutes</code> but it also returns the http response headers .
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
  @RequestLine("GET /api/condition-by-routes/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&itemsId.greaterThan={itemsIdGreaterThan}&itemsId.lessThan={itemsIdLessThan}&itemsId.greaterThanOrEqual={itemsIdGreaterThanOrEqual}&itemsId.lessThanOrEqual={itemsIdLessThanOrEqual}&itemsId.equals={itemsIdEquals}&itemsId.notEquals={itemsIdNotEquals}&itemsId.specified={itemsIdSpecified}&itemsId.in={itemsIdIn}&itemsId.notIn={itemsIdNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Long> countConditionByRoutesWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("itemsIdGreaterThan") @jakarta.annotation.Nullable Long itemsIdGreaterThan, @Param("itemsIdLessThan") @jakarta.annotation.Nullable Long itemsIdLessThan, @Param("itemsIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long itemsIdGreaterThanOrEqual, @Param("itemsIdLessThanOrEqual") @jakarta.annotation.Nullable Long itemsIdLessThanOrEqual, @Param("itemsIdEquals") @jakarta.annotation.Nullable Long itemsIdEquals, @Param("itemsIdNotEquals") @jakarta.annotation.Nullable Long itemsIdNotEquals, @Param("itemsIdSpecified") @jakarta.annotation.Nullable Boolean itemsIdSpecified, @Param("itemsIdIn") @jakarta.annotation.Nullable List<Long> itemsIdIn, @Param("itemsIdNotIn") @jakarta.annotation.Nullable List<Long> itemsIdNotIn, @Param("promotionIdGreaterThan") @jakarta.annotation.Nullable Long promotionIdGreaterThan, @Param("promotionIdLessThan") @jakarta.annotation.Nullable Long promotionIdLessThan, @Param("promotionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long promotionIdGreaterThanOrEqual, @Param("promotionIdLessThanOrEqual") @jakarta.annotation.Nullable Long promotionIdLessThanOrEqual, @Param("promotionIdEquals") @jakarta.annotation.Nullable Long promotionIdEquals, @Param("promotionIdNotEquals") @jakarta.annotation.Nullable Long promotionIdNotEquals, @Param("promotionIdSpecified") @jakarta.annotation.Nullable Boolean promotionIdSpecified, @Param("promotionIdIn") @jakarta.annotation.Nullable List<Long> promotionIdIn, @Param("promotionIdNotIn") @jakarta.annotation.Nullable List<Long> promotionIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>countConditionByRoutes</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CountConditionByRoutesQueryParams} class that allows for
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
  @RequestLine("GET /api/condition-by-routes/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&itemsId.greaterThan={itemsIdGreaterThan}&itemsId.lessThan={itemsIdLessThan}&itemsId.greaterThanOrEqual={itemsIdGreaterThanOrEqual}&itemsId.lessThanOrEqual={itemsIdLessThanOrEqual}&itemsId.equals={itemsIdEquals}&itemsId.notEquals={itemsIdNotEquals}&itemsId.specified={itemsIdSpecified}&itemsId.in={itemsIdIn}&itemsId.notIn={itemsIdNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  Long countConditionByRoutes(@QueryMap(encoded=true) CountConditionByRoutesQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>countConditionByRoutes</code> that receives the query parameters as a map,
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
      @RequestLine("GET /api/condition-by-routes/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&itemsId.greaterThan={itemsIdGreaterThan}&itemsId.lessThan={itemsIdLessThan}&itemsId.greaterThanOrEqual={itemsIdGreaterThanOrEqual}&itemsId.lessThanOrEqual={itemsIdLessThanOrEqual}&itemsId.equals={itemsIdEquals}&itemsId.notEquals={itemsIdNotEquals}&itemsId.specified={itemsIdSpecified}&itemsId.in={itemsIdIn}&itemsId.notIn={itemsIdNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Long> countConditionByRoutesWithHttpInfo(@QueryMap(encoded=true) CountConditionByRoutesQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>countConditionByRoutes</code> method in a fluent style.
   */
  public static class CountConditionByRoutesQueryParams extends HashMap<String, Object> {
    public CountConditionByRoutesQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByRoutesQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByRoutesQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByRoutesQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByRoutesQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByRoutesQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByRoutesQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByRoutesQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByRoutesQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByRoutesQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByRoutesQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByRoutesQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByRoutesQueryParams itemsIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams itemsIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams itemsIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams itemsIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams itemsIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams itemsIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams itemsIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("itemsId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams itemsIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("itemsId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByRoutesQueryParams itemsIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("itemsId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByRoutesQueryParams promotionIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams promotionIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams promotionIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams promotionIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams promotionIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams promotionIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams promotionIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("promotionId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionByRoutesQueryParams promotionIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("promotionId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByRoutesQueryParams promotionIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("promotionId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionByRoutesQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param conditionByRouteDTO  (required)
   * @return ConditionByRouteDTO
   */
  @RequestLine("POST /api/condition-by-routes")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ConditionByRouteDTO createConditionByRoute(@jakarta.annotation.Nonnull ConditionByRouteDTO conditionByRouteDTO);

  /**
   * 
   * Similar to <code>createConditionByRoute</code> but it also returns the http response headers .
   * 
   * @param conditionByRouteDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/condition-by-routes")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<ConditionByRouteDTO> createConditionByRouteWithHttpInfo(@jakarta.annotation.Nonnull ConditionByRouteDTO conditionByRouteDTO);



  /**
   * 
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/condition-by-routes/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteConditionByRoute(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>deleteConditionByRoute</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/condition-by-routes/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteConditionByRouteWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



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
   * @return List&lt;ConditionByRouteDTO&gt;
   */
  @RequestLine("GET /api/condition-by-routes?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&itemsId.greaterThan={itemsIdGreaterThan}&itemsId.lessThan={itemsIdLessThan}&itemsId.greaterThanOrEqual={itemsIdGreaterThanOrEqual}&itemsId.lessThanOrEqual={itemsIdLessThanOrEqual}&itemsId.equals={itemsIdEquals}&itemsId.notEquals={itemsIdNotEquals}&itemsId.specified={itemsIdSpecified}&itemsId.in={itemsIdIn}&itemsId.notIn={itemsIdNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  List<ConditionByRouteDTO> getAllConditionByRoutes(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("itemsIdGreaterThan") @jakarta.annotation.Nullable Long itemsIdGreaterThan, @Param("itemsIdLessThan") @jakarta.annotation.Nullable Long itemsIdLessThan, @Param("itemsIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long itemsIdGreaterThanOrEqual, @Param("itemsIdLessThanOrEqual") @jakarta.annotation.Nullable Long itemsIdLessThanOrEqual, @Param("itemsIdEquals") @jakarta.annotation.Nullable Long itemsIdEquals, @Param("itemsIdNotEquals") @jakarta.annotation.Nullable Long itemsIdNotEquals, @Param("itemsIdSpecified") @jakarta.annotation.Nullable Boolean itemsIdSpecified, @Param("itemsIdIn") @jakarta.annotation.Nullable List<Long> itemsIdIn, @Param("itemsIdNotIn") @jakarta.annotation.Nullable List<Long> itemsIdNotIn, @Param("promotionIdGreaterThan") @jakarta.annotation.Nullable Long promotionIdGreaterThan, @Param("promotionIdLessThan") @jakarta.annotation.Nullable Long promotionIdLessThan, @Param("promotionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long promotionIdGreaterThanOrEqual, @Param("promotionIdLessThanOrEqual") @jakarta.annotation.Nullable Long promotionIdLessThanOrEqual, @Param("promotionIdEquals") @jakarta.annotation.Nullable Long promotionIdEquals, @Param("promotionIdNotEquals") @jakarta.annotation.Nullable Long promotionIdNotEquals, @Param("promotionIdSpecified") @jakarta.annotation.Nullable Boolean promotionIdSpecified, @Param("promotionIdIn") @jakarta.annotation.Nullable List<Long> promotionIdIn, @Param("promotionIdNotIn") @jakarta.annotation.Nullable List<Long> promotionIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>getAllConditionByRoutes</code> but it also returns the http response headers .
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
  @RequestLine("GET /api/condition-by-routes?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&itemsId.greaterThan={itemsIdGreaterThan}&itemsId.lessThan={itemsIdLessThan}&itemsId.greaterThanOrEqual={itemsIdGreaterThanOrEqual}&itemsId.lessThanOrEqual={itemsIdLessThanOrEqual}&itemsId.equals={itemsIdEquals}&itemsId.notEquals={itemsIdNotEquals}&itemsId.specified={itemsIdSpecified}&itemsId.in={itemsIdIn}&itemsId.notIn={itemsIdNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<ConditionByRouteDTO>> getAllConditionByRoutesWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("itemsIdGreaterThan") @jakarta.annotation.Nullable Long itemsIdGreaterThan, @Param("itemsIdLessThan") @jakarta.annotation.Nullable Long itemsIdLessThan, @Param("itemsIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long itemsIdGreaterThanOrEqual, @Param("itemsIdLessThanOrEqual") @jakarta.annotation.Nullable Long itemsIdLessThanOrEqual, @Param("itemsIdEquals") @jakarta.annotation.Nullable Long itemsIdEquals, @Param("itemsIdNotEquals") @jakarta.annotation.Nullable Long itemsIdNotEquals, @Param("itemsIdSpecified") @jakarta.annotation.Nullable Boolean itemsIdSpecified, @Param("itemsIdIn") @jakarta.annotation.Nullable List<Long> itemsIdIn, @Param("itemsIdNotIn") @jakarta.annotation.Nullable List<Long> itemsIdNotIn, @Param("promotionIdGreaterThan") @jakarta.annotation.Nullable Long promotionIdGreaterThan, @Param("promotionIdLessThan") @jakarta.annotation.Nullable Long promotionIdLessThan, @Param("promotionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long promotionIdGreaterThanOrEqual, @Param("promotionIdLessThanOrEqual") @jakarta.annotation.Nullable Long promotionIdLessThanOrEqual, @Param("promotionIdEquals") @jakarta.annotation.Nullable Long promotionIdEquals, @Param("promotionIdNotEquals") @jakarta.annotation.Nullable Long promotionIdNotEquals, @Param("promotionIdSpecified") @jakarta.annotation.Nullable Boolean promotionIdSpecified, @Param("promotionIdIn") @jakarta.annotation.Nullable List<Long> promotionIdIn, @Param("promotionIdNotIn") @jakarta.annotation.Nullable List<Long> promotionIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllConditionByRoutes</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllConditionByRoutesQueryParams} class that allows for
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
   * @return List&lt;ConditionByRouteDTO&gt;
   */
  @RequestLine("GET /api/condition-by-routes?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&itemsId.greaterThan={itemsIdGreaterThan}&itemsId.lessThan={itemsIdLessThan}&itemsId.greaterThanOrEqual={itemsIdGreaterThanOrEqual}&itemsId.lessThanOrEqual={itemsIdLessThanOrEqual}&itemsId.equals={itemsIdEquals}&itemsId.notEquals={itemsIdNotEquals}&itemsId.specified={itemsIdSpecified}&itemsId.in={itemsIdIn}&itemsId.notIn={itemsIdNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  List<ConditionByRouteDTO> getAllConditionByRoutes(@QueryMap(encoded=true) GetAllConditionByRoutesQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllConditionByRoutes</code> that receives the query parameters as a map,
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
          * @return List&lt;ConditionByRouteDTO&gt;
      */
      @RequestLine("GET /api/condition-by-routes?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&itemsId.greaterThan={itemsIdGreaterThan}&itemsId.lessThan={itemsIdLessThan}&itemsId.greaterThanOrEqual={itemsIdGreaterThanOrEqual}&itemsId.lessThanOrEqual={itemsIdLessThanOrEqual}&itemsId.equals={itemsIdEquals}&itemsId.notEquals={itemsIdNotEquals}&itemsId.specified={itemsIdSpecified}&itemsId.in={itemsIdIn}&itemsId.notIn={itemsIdNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<ConditionByRouteDTO>> getAllConditionByRoutesWithHttpInfo(@QueryMap(encoded=true) GetAllConditionByRoutesQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllConditionByRoutes</code> method in a fluent style.
   */
  public static class GetAllConditionByRoutesQueryParams extends HashMap<String, Object> {
    public GetAllConditionByRoutesQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByRoutesQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByRoutesQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByRoutesQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByRoutesQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByRoutesQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByRoutesQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByRoutesQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByRoutesQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByRoutesQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByRoutesQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByRoutesQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByRoutesQueryParams itemsIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams itemsIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams itemsIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams itemsIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams itemsIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams itemsIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("itemsId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams itemsIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("itemsId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams itemsIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("itemsId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByRoutesQueryParams itemsIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("itemsId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByRoutesQueryParams promotionIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams promotionIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams promotionIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams promotionIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams promotionIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams promotionIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams promotionIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("promotionId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionByRoutesQueryParams promotionIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("promotionId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByRoutesQueryParams promotionIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("promotionId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionByRoutesQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @return ConditionByRouteDTO
   */
  @RequestLine("GET /api/condition-by-routes/{id}")
  @Headers({
    "Accept: */*",
  })
  ConditionByRouteDTO getConditionByRoute(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>getConditionByRoute</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/condition-by-routes/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<ConditionByRouteDTO> getConditionByRouteWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param id  (required)
   * @param conditionByRouteDTO  (required)
   * @return ConditionByRouteDTO
   */
  @RequestLine("PATCH /api/condition-by-routes/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ConditionByRouteDTO partialUpdateConditionByRoute(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull ConditionByRouteDTO conditionByRouteDTO);

  /**
   * 
   * Similar to <code>partialUpdateConditionByRoute</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param conditionByRouteDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /api/condition-by-routes/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<ConditionByRouteDTO> partialUpdateConditionByRouteWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull ConditionByRouteDTO conditionByRouteDTO);



  /**
   * 
   * 
   * @param id  (required)
   * @param conditionByRouteDTO  (required)
   * @return ConditionByRouteDTO
   */
  @RequestLine("PUT /api/condition-by-routes/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ConditionByRouteDTO updateConditionByRoute(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull ConditionByRouteDTO conditionByRouteDTO);

  /**
   * 
   * Similar to <code>updateConditionByRoute</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param conditionByRouteDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/condition-by-routes/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<ConditionByRouteDTO> updateConditionByRouteWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull ConditionByRouteDTO conditionByRouteDTO);


}
