package com.ridehub.mspromotion.client.api;

import com.ridehub.mspromotion.client.invoker.ApiClient;
import com.ridehub.mspromotion.client.invoker.EncodingUtils;
import com.ridehub.mspromotion.client.model.ApiResponse;

import com.ridehub.mspromotion.client.model.ConditionLocationItemDTO;
import java.time.OffsetDateTime;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface ConditionLocationItemResourceMspromotionApi extends ApiClient.Api {


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
   * @param provinceIdGreaterThan  (optional)
   * @param provinceIdLessThan  (optional)
   * @param provinceIdGreaterThanOrEqual  (optional)
   * @param provinceIdLessThanOrEqual  (optional)
   * @param provinceIdEquals  (optional)
   * @param provinceIdNotEquals  (optional)
   * @param provinceIdSpecified  (optional)
   * @param provinceIdIn  (optional)
   * @param provinceIdNotIn  (optional)
   * @param districtIdGreaterThan  (optional)
   * @param districtIdLessThan  (optional)
   * @param districtIdGreaterThanOrEqual  (optional)
   * @param districtIdLessThanOrEqual  (optional)
   * @param districtIdEquals  (optional)
   * @param districtIdNotEquals  (optional)
   * @param districtIdSpecified  (optional)
   * @param districtIdIn  (optional)
   * @param districtIdNotIn  (optional)
   * @param wardIdGreaterThan  (optional)
   * @param wardIdLessThan  (optional)
   * @param wardIdGreaterThanOrEqual  (optional)
   * @param wardIdLessThanOrEqual  (optional)
   * @param wardIdEquals  (optional)
   * @param wardIdNotEquals  (optional)
   * @param wardIdSpecified  (optional)
   * @param wardIdIn  (optional)
   * @param wardIdNotIn  (optional)
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
   * @param conditionIdGreaterThan  (optional)
   * @param conditionIdLessThan  (optional)
   * @param conditionIdGreaterThanOrEqual  (optional)
   * @param conditionIdLessThanOrEqual  (optional)
   * @param conditionIdEquals  (optional)
   * @param conditionIdNotEquals  (optional)
   * @param conditionIdSpecified  (optional)
   * @param conditionIdIn  (optional)
   * @param conditionIdNotIn  (optional)
   * @param distinct  (optional)
   * @return Long
   */
  @RequestLine("GET /api/condition-location-items/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&provinceId.greaterThan={provinceIdGreaterThan}&provinceId.lessThan={provinceIdLessThan}&provinceId.greaterThanOrEqual={provinceIdGreaterThanOrEqual}&provinceId.lessThanOrEqual={provinceIdLessThanOrEqual}&provinceId.equals={provinceIdEquals}&provinceId.notEquals={provinceIdNotEquals}&provinceId.specified={provinceIdSpecified}&provinceId.in={provinceIdIn}&provinceId.notIn={provinceIdNotIn}&districtId.greaterThan={districtIdGreaterThan}&districtId.lessThan={districtIdLessThan}&districtId.greaterThanOrEqual={districtIdGreaterThanOrEqual}&districtId.lessThanOrEqual={districtIdLessThanOrEqual}&districtId.equals={districtIdEquals}&districtId.notEquals={districtIdNotEquals}&districtId.specified={districtIdSpecified}&districtId.in={districtIdIn}&districtId.notIn={districtIdNotIn}&wardId.greaterThan={wardIdGreaterThan}&wardId.lessThan={wardIdLessThan}&wardId.greaterThanOrEqual={wardIdGreaterThanOrEqual}&wardId.lessThanOrEqual={wardIdLessThanOrEqual}&wardId.equals={wardIdEquals}&wardId.notEquals={wardIdNotEquals}&wardId.specified={wardIdSpecified}&wardId.in={wardIdIn}&wardId.notIn={wardIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&conditionId.greaterThan={conditionIdGreaterThan}&conditionId.lessThan={conditionIdLessThan}&conditionId.greaterThanOrEqual={conditionIdGreaterThanOrEqual}&conditionId.lessThanOrEqual={conditionIdLessThanOrEqual}&conditionId.equals={conditionIdEquals}&conditionId.notEquals={conditionIdNotEquals}&conditionId.specified={conditionIdSpecified}&conditionId.in={conditionIdIn}&conditionId.notIn={conditionIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  Long countConditionLocationItems(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("provinceIdGreaterThan") @jakarta.annotation.Nullable Long provinceIdGreaterThan, @Param("provinceIdLessThan") @jakarta.annotation.Nullable Long provinceIdLessThan, @Param("provinceIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long provinceIdGreaterThanOrEqual, @Param("provinceIdLessThanOrEqual") @jakarta.annotation.Nullable Long provinceIdLessThanOrEqual, @Param("provinceIdEquals") @jakarta.annotation.Nullable Long provinceIdEquals, @Param("provinceIdNotEquals") @jakarta.annotation.Nullable Long provinceIdNotEquals, @Param("provinceIdSpecified") @jakarta.annotation.Nullable Boolean provinceIdSpecified, @Param("provinceIdIn") @jakarta.annotation.Nullable List<Long> provinceIdIn, @Param("provinceIdNotIn") @jakarta.annotation.Nullable List<Long> provinceIdNotIn, @Param("districtIdGreaterThan") @jakarta.annotation.Nullable Long districtIdGreaterThan, @Param("districtIdLessThan") @jakarta.annotation.Nullable Long districtIdLessThan, @Param("districtIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long districtIdGreaterThanOrEqual, @Param("districtIdLessThanOrEqual") @jakarta.annotation.Nullable Long districtIdLessThanOrEqual, @Param("districtIdEquals") @jakarta.annotation.Nullable Long districtIdEquals, @Param("districtIdNotEquals") @jakarta.annotation.Nullable Long districtIdNotEquals, @Param("districtIdSpecified") @jakarta.annotation.Nullable Boolean districtIdSpecified, @Param("districtIdIn") @jakarta.annotation.Nullable List<Long> districtIdIn, @Param("districtIdNotIn") @jakarta.annotation.Nullable List<Long> districtIdNotIn, @Param("wardIdGreaterThan") @jakarta.annotation.Nullable Long wardIdGreaterThan, @Param("wardIdLessThan") @jakarta.annotation.Nullable Long wardIdLessThan, @Param("wardIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long wardIdGreaterThanOrEqual, @Param("wardIdLessThanOrEqual") @jakarta.annotation.Nullable Long wardIdLessThanOrEqual, @Param("wardIdEquals") @jakarta.annotation.Nullable Long wardIdEquals, @Param("wardIdNotEquals") @jakarta.annotation.Nullable Long wardIdNotEquals, @Param("wardIdSpecified") @jakarta.annotation.Nullable Boolean wardIdSpecified, @Param("wardIdIn") @jakarta.annotation.Nullable List<Long> wardIdIn, @Param("wardIdNotIn") @jakarta.annotation.Nullable List<Long> wardIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("conditionIdGreaterThan") @jakarta.annotation.Nullable Long conditionIdGreaterThan, @Param("conditionIdLessThan") @jakarta.annotation.Nullable Long conditionIdLessThan, @Param("conditionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long conditionIdGreaterThanOrEqual, @Param("conditionIdLessThanOrEqual") @jakarta.annotation.Nullable Long conditionIdLessThanOrEqual, @Param("conditionIdEquals") @jakarta.annotation.Nullable Long conditionIdEquals, @Param("conditionIdNotEquals") @jakarta.annotation.Nullable Long conditionIdNotEquals, @Param("conditionIdSpecified") @jakarta.annotation.Nullable Boolean conditionIdSpecified, @Param("conditionIdIn") @jakarta.annotation.Nullable List<Long> conditionIdIn, @Param("conditionIdNotIn") @jakarta.annotation.Nullable List<Long> conditionIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>countConditionLocationItems</code> but it also returns the http response headers .
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
   * @param provinceIdGreaterThan  (optional)
   * @param provinceIdLessThan  (optional)
   * @param provinceIdGreaterThanOrEqual  (optional)
   * @param provinceIdLessThanOrEqual  (optional)
   * @param provinceIdEquals  (optional)
   * @param provinceIdNotEquals  (optional)
   * @param provinceIdSpecified  (optional)
   * @param provinceIdIn  (optional)
   * @param provinceIdNotIn  (optional)
   * @param districtIdGreaterThan  (optional)
   * @param districtIdLessThan  (optional)
   * @param districtIdGreaterThanOrEqual  (optional)
   * @param districtIdLessThanOrEqual  (optional)
   * @param districtIdEquals  (optional)
   * @param districtIdNotEquals  (optional)
   * @param districtIdSpecified  (optional)
   * @param districtIdIn  (optional)
   * @param districtIdNotIn  (optional)
   * @param wardIdGreaterThan  (optional)
   * @param wardIdLessThan  (optional)
   * @param wardIdGreaterThanOrEqual  (optional)
   * @param wardIdLessThanOrEqual  (optional)
   * @param wardIdEquals  (optional)
   * @param wardIdNotEquals  (optional)
   * @param wardIdSpecified  (optional)
   * @param wardIdIn  (optional)
   * @param wardIdNotIn  (optional)
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
   * @param conditionIdGreaterThan  (optional)
   * @param conditionIdLessThan  (optional)
   * @param conditionIdGreaterThanOrEqual  (optional)
   * @param conditionIdLessThanOrEqual  (optional)
   * @param conditionIdEquals  (optional)
   * @param conditionIdNotEquals  (optional)
   * @param conditionIdSpecified  (optional)
   * @param conditionIdIn  (optional)
   * @param conditionIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/condition-location-items/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&provinceId.greaterThan={provinceIdGreaterThan}&provinceId.lessThan={provinceIdLessThan}&provinceId.greaterThanOrEqual={provinceIdGreaterThanOrEqual}&provinceId.lessThanOrEqual={provinceIdLessThanOrEqual}&provinceId.equals={provinceIdEquals}&provinceId.notEquals={provinceIdNotEquals}&provinceId.specified={provinceIdSpecified}&provinceId.in={provinceIdIn}&provinceId.notIn={provinceIdNotIn}&districtId.greaterThan={districtIdGreaterThan}&districtId.lessThan={districtIdLessThan}&districtId.greaterThanOrEqual={districtIdGreaterThanOrEqual}&districtId.lessThanOrEqual={districtIdLessThanOrEqual}&districtId.equals={districtIdEquals}&districtId.notEquals={districtIdNotEquals}&districtId.specified={districtIdSpecified}&districtId.in={districtIdIn}&districtId.notIn={districtIdNotIn}&wardId.greaterThan={wardIdGreaterThan}&wardId.lessThan={wardIdLessThan}&wardId.greaterThanOrEqual={wardIdGreaterThanOrEqual}&wardId.lessThanOrEqual={wardIdLessThanOrEqual}&wardId.equals={wardIdEquals}&wardId.notEquals={wardIdNotEquals}&wardId.specified={wardIdSpecified}&wardId.in={wardIdIn}&wardId.notIn={wardIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&conditionId.greaterThan={conditionIdGreaterThan}&conditionId.lessThan={conditionIdLessThan}&conditionId.greaterThanOrEqual={conditionIdGreaterThanOrEqual}&conditionId.lessThanOrEqual={conditionIdLessThanOrEqual}&conditionId.equals={conditionIdEquals}&conditionId.notEquals={conditionIdNotEquals}&conditionId.specified={conditionIdSpecified}&conditionId.in={conditionIdIn}&conditionId.notIn={conditionIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Long> countConditionLocationItemsWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("provinceIdGreaterThan") @jakarta.annotation.Nullable Long provinceIdGreaterThan, @Param("provinceIdLessThan") @jakarta.annotation.Nullable Long provinceIdLessThan, @Param("provinceIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long provinceIdGreaterThanOrEqual, @Param("provinceIdLessThanOrEqual") @jakarta.annotation.Nullable Long provinceIdLessThanOrEqual, @Param("provinceIdEquals") @jakarta.annotation.Nullable Long provinceIdEquals, @Param("provinceIdNotEquals") @jakarta.annotation.Nullable Long provinceIdNotEquals, @Param("provinceIdSpecified") @jakarta.annotation.Nullable Boolean provinceIdSpecified, @Param("provinceIdIn") @jakarta.annotation.Nullable List<Long> provinceIdIn, @Param("provinceIdNotIn") @jakarta.annotation.Nullable List<Long> provinceIdNotIn, @Param("districtIdGreaterThan") @jakarta.annotation.Nullable Long districtIdGreaterThan, @Param("districtIdLessThan") @jakarta.annotation.Nullable Long districtIdLessThan, @Param("districtIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long districtIdGreaterThanOrEqual, @Param("districtIdLessThanOrEqual") @jakarta.annotation.Nullable Long districtIdLessThanOrEqual, @Param("districtIdEquals") @jakarta.annotation.Nullable Long districtIdEquals, @Param("districtIdNotEquals") @jakarta.annotation.Nullable Long districtIdNotEquals, @Param("districtIdSpecified") @jakarta.annotation.Nullable Boolean districtIdSpecified, @Param("districtIdIn") @jakarta.annotation.Nullable List<Long> districtIdIn, @Param("districtIdNotIn") @jakarta.annotation.Nullable List<Long> districtIdNotIn, @Param("wardIdGreaterThan") @jakarta.annotation.Nullable Long wardIdGreaterThan, @Param("wardIdLessThan") @jakarta.annotation.Nullable Long wardIdLessThan, @Param("wardIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long wardIdGreaterThanOrEqual, @Param("wardIdLessThanOrEqual") @jakarta.annotation.Nullable Long wardIdLessThanOrEqual, @Param("wardIdEquals") @jakarta.annotation.Nullable Long wardIdEquals, @Param("wardIdNotEquals") @jakarta.annotation.Nullable Long wardIdNotEquals, @Param("wardIdSpecified") @jakarta.annotation.Nullable Boolean wardIdSpecified, @Param("wardIdIn") @jakarta.annotation.Nullable List<Long> wardIdIn, @Param("wardIdNotIn") @jakarta.annotation.Nullable List<Long> wardIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("conditionIdGreaterThan") @jakarta.annotation.Nullable Long conditionIdGreaterThan, @Param("conditionIdLessThan") @jakarta.annotation.Nullable Long conditionIdLessThan, @Param("conditionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long conditionIdGreaterThanOrEqual, @Param("conditionIdLessThanOrEqual") @jakarta.annotation.Nullable Long conditionIdLessThanOrEqual, @Param("conditionIdEquals") @jakarta.annotation.Nullable Long conditionIdEquals, @Param("conditionIdNotEquals") @jakarta.annotation.Nullable Long conditionIdNotEquals, @Param("conditionIdSpecified") @jakarta.annotation.Nullable Boolean conditionIdSpecified, @Param("conditionIdIn") @jakarta.annotation.Nullable List<Long> conditionIdIn, @Param("conditionIdNotIn") @jakarta.annotation.Nullable List<Long> conditionIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>countConditionLocationItems</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CountConditionLocationItemsQueryParams} class that allows for
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
   *   <li>provinceIdGreaterThan -  (optional)</li>
   *   <li>provinceIdLessThan -  (optional)</li>
   *   <li>provinceIdGreaterThanOrEqual -  (optional)</li>
   *   <li>provinceIdLessThanOrEqual -  (optional)</li>
   *   <li>provinceIdEquals -  (optional)</li>
   *   <li>provinceIdNotEquals -  (optional)</li>
   *   <li>provinceIdSpecified -  (optional)</li>
   *   <li>provinceIdIn -  (optional)</li>
   *   <li>provinceIdNotIn -  (optional)</li>
   *   <li>districtIdGreaterThan -  (optional)</li>
   *   <li>districtIdLessThan -  (optional)</li>
   *   <li>districtIdGreaterThanOrEqual -  (optional)</li>
   *   <li>districtIdLessThanOrEqual -  (optional)</li>
   *   <li>districtIdEquals -  (optional)</li>
   *   <li>districtIdNotEquals -  (optional)</li>
   *   <li>districtIdSpecified -  (optional)</li>
   *   <li>districtIdIn -  (optional)</li>
   *   <li>districtIdNotIn -  (optional)</li>
   *   <li>wardIdGreaterThan -  (optional)</li>
   *   <li>wardIdLessThan -  (optional)</li>
   *   <li>wardIdGreaterThanOrEqual -  (optional)</li>
   *   <li>wardIdLessThanOrEqual -  (optional)</li>
   *   <li>wardIdEquals -  (optional)</li>
   *   <li>wardIdNotEquals -  (optional)</li>
   *   <li>wardIdSpecified -  (optional)</li>
   *   <li>wardIdIn -  (optional)</li>
   *   <li>wardIdNotIn -  (optional)</li>
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
   *   <li>conditionIdGreaterThan -  (optional)</li>
   *   <li>conditionIdLessThan -  (optional)</li>
   *   <li>conditionIdGreaterThanOrEqual -  (optional)</li>
   *   <li>conditionIdLessThanOrEqual -  (optional)</li>
   *   <li>conditionIdEquals -  (optional)</li>
   *   <li>conditionIdNotEquals -  (optional)</li>
   *   <li>conditionIdSpecified -  (optional)</li>
   *   <li>conditionIdIn -  (optional)</li>
   *   <li>conditionIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return Long
   */
  @RequestLine("GET /api/condition-location-items/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&provinceId.greaterThan={provinceIdGreaterThan}&provinceId.lessThan={provinceIdLessThan}&provinceId.greaterThanOrEqual={provinceIdGreaterThanOrEqual}&provinceId.lessThanOrEqual={provinceIdLessThanOrEqual}&provinceId.equals={provinceIdEquals}&provinceId.notEquals={provinceIdNotEquals}&provinceId.specified={provinceIdSpecified}&provinceId.in={provinceIdIn}&provinceId.notIn={provinceIdNotIn}&districtId.greaterThan={districtIdGreaterThan}&districtId.lessThan={districtIdLessThan}&districtId.greaterThanOrEqual={districtIdGreaterThanOrEqual}&districtId.lessThanOrEqual={districtIdLessThanOrEqual}&districtId.equals={districtIdEquals}&districtId.notEquals={districtIdNotEquals}&districtId.specified={districtIdSpecified}&districtId.in={districtIdIn}&districtId.notIn={districtIdNotIn}&wardId.greaterThan={wardIdGreaterThan}&wardId.lessThan={wardIdLessThan}&wardId.greaterThanOrEqual={wardIdGreaterThanOrEqual}&wardId.lessThanOrEqual={wardIdLessThanOrEqual}&wardId.equals={wardIdEquals}&wardId.notEquals={wardIdNotEquals}&wardId.specified={wardIdSpecified}&wardId.in={wardIdIn}&wardId.notIn={wardIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&conditionId.greaterThan={conditionIdGreaterThan}&conditionId.lessThan={conditionIdLessThan}&conditionId.greaterThanOrEqual={conditionIdGreaterThanOrEqual}&conditionId.lessThanOrEqual={conditionIdLessThanOrEqual}&conditionId.equals={conditionIdEquals}&conditionId.notEquals={conditionIdNotEquals}&conditionId.specified={conditionIdSpecified}&conditionId.in={conditionIdIn}&conditionId.notIn={conditionIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  Long countConditionLocationItems(@QueryMap(encoded=true) CountConditionLocationItemsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>countConditionLocationItems</code> that receives the query parameters as a map,
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
          *   <li>provinceIdGreaterThan -  (optional)</li>
          *   <li>provinceIdLessThan -  (optional)</li>
          *   <li>provinceIdGreaterThanOrEqual -  (optional)</li>
          *   <li>provinceIdLessThanOrEqual -  (optional)</li>
          *   <li>provinceIdEquals -  (optional)</li>
          *   <li>provinceIdNotEquals -  (optional)</li>
          *   <li>provinceIdSpecified -  (optional)</li>
          *   <li>provinceIdIn -  (optional)</li>
          *   <li>provinceIdNotIn -  (optional)</li>
          *   <li>districtIdGreaterThan -  (optional)</li>
          *   <li>districtIdLessThan -  (optional)</li>
          *   <li>districtIdGreaterThanOrEqual -  (optional)</li>
          *   <li>districtIdLessThanOrEqual -  (optional)</li>
          *   <li>districtIdEquals -  (optional)</li>
          *   <li>districtIdNotEquals -  (optional)</li>
          *   <li>districtIdSpecified -  (optional)</li>
          *   <li>districtIdIn -  (optional)</li>
          *   <li>districtIdNotIn -  (optional)</li>
          *   <li>wardIdGreaterThan -  (optional)</li>
          *   <li>wardIdLessThan -  (optional)</li>
          *   <li>wardIdGreaterThanOrEqual -  (optional)</li>
          *   <li>wardIdLessThanOrEqual -  (optional)</li>
          *   <li>wardIdEquals -  (optional)</li>
          *   <li>wardIdNotEquals -  (optional)</li>
          *   <li>wardIdSpecified -  (optional)</li>
          *   <li>wardIdIn -  (optional)</li>
          *   <li>wardIdNotIn -  (optional)</li>
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
          *   <li>conditionIdGreaterThan -  (optional)</li>
          *   <li>conditionIdLessThan -  (optional)</li>
          *   <li>conditionIdGreaterThanOrEqual -  (optional)</li>
          *   <li>conditionIdLessThanOrEqual -  (optional)</li>
          *   <li>conditionIdEquals -  (optional)</li>
          *   <li>conditionIdNotEquals -  (optional)</li>
          *   <li>conditionIdSpecified -  (optional)</li>
          *   <li>conditionIdIn -  (optional)</li>
          *   <li>conditionIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return Long
      */
      @RequestLine("GET /api/condition-location-items/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&provinceId.greaterThan={provinceIdGreaterThan}&provinceId.lessThan={provinceIdLessThan}&provinceId.greaterThanOrEqual={provinceIdGreaterThanOrEqual}&provinceId.lessThanOrEqual={provinceIdLessThanOrEqual}&provinceId.equals={provinceIdEquals}&provinceId.notEquals={provinceIdNotEquals}&provinceId.specified={provinceIdSpecified}&provinceId.in={provinceIdIn}&provinceId.notIn={provinceIdNotIn}&districtId.greaterThan={districtIdGreaterThan}&districtId.lessThan={districtIdLessThan}&districtId.greaterThanOrEqual={districtIdGreaterThanOrEqual}&districtId.lessThanOrEqual={districtIdLessThanOrEqual}&districtId.equals={districtIdEquals}&districtId.notEquals={districtIdNotEquals}&districtId.specified={districtIdSpecified}&districtId.in={districtIdIn}&districtId.notIn={districtIdNotIn}&wardId.greaterThan={wardIdGreaterThan}&wardId.lessThan={wardIdLessThan}&wardId.greaterThanOrEqual={wardIdGreaterThanOrEqual}&wardId.lessThanOrEqual={wardIdLessThanOrEqual}&wardId.equals={wardIdEquals}&wardId.notEquals={wardIdNotEquals}&wardId.specified={wardIdSpecified}&wardId.in={wardIdIn}&wardId.notIn={wardIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&conditionId.greaterThan={conditionIdGreaterThan}&conditionId.lessThan={conditionIdLessThan}&conditionId.greaterThanOrEqual={conditionIdGreaterThanOrEqual}&conditionId.lessThanOrEqual={conditionIdLessThanOrEqual}&conditionId.equals={conditionIdEquals}&conditionId.notEquals={conditionIdNotEquals}&conditionId.specified={conditionIdSpecified}&conditionId.in={conditionIdIn}&conditionId.notIn={conditionIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Long> countConditionLocationItemsWithHttpInfo(@QueryMap(encoded=true) CountConditionLocationItemsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>countConditionLocationItems</code> method in a fluent style.
   */
  public static class CountConditionLocationItemsQueryParams extends HashMap<String, Object> {
    public CountConditionLocationItemsQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionLocationItemsQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionLocationItemsQueryParams provinceIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("provinceId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams provinceIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("provinceId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams provinceIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("provinceId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams provinceIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("provinceId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams provinceIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("provinceId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams provinceIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("provinceId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams provinceIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("provinceId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams provinceIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("provinceId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionLocationItemsQueryParams provinceIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("provinceId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionLocationItemsQueryParams districtIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("districtId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams districtIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("districtId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams districtIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("districtId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams districtIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("districtId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams districtIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("districtId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams districtIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("districtId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams districtIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("districtId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams districtIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("districtId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionLocationItemsQueryParams districtIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("districtId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionLocationItemsQueryParams wardIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("wardId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams wardIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("wardId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams wardIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("wardId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams wardIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("wardId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams wardIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("wardId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams wardIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("wardId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams wardIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("wardId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams wardIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("wardId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionLocationItemsQueryParams wardIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("wardId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionLocationItemsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionLocationItemsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionLocationItemsQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionLocationItemsQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionLocationItemsQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionLocationItemsQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionLocationItemsQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionLocationItemsQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionLocationItemsQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionLocationItemsQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionLocationItemsQueryParams conditionIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("conditionId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams conditionIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("conditionId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams conditionIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("conditionId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams conditionIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("conditionId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams conditionIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("conditionId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams conditionIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("conditionId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams conditionIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("conditionId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionLocationItemsQueryParams conditionIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("conditionId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionLocationItemsQueryParams conditionIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("conditionId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionLocationItemsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param conditionLocationItemDTO  (required)
   * @return ConditionLocationItemDTO
   */
  @RequestLine("POST /api/condition-location-items")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ConditionLocationItemDTO createConditionLocationItem(@jakarta.annotation.Nonnull ConditionLocationItemDTO conditionLocationItemDTO);

  /**
   * 
   * Similar to <code>createConditionLocationItem</code> but it also returns the http response headers .
   * 
   * @param conditionLocationItemDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/condition-location-items")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<ConditionLocationItemDTO> createConditionLocationItemWithHttpInfo(@jakarta.annotation.Nonnull ConditionLocationItemDTO conditionLocationItemDTO);



  /**
   * 
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/condition-location-items/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteConditionLocationItem(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>deleteConditionLocationItem</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/condition-location-items/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteConditionLocationItemWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



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
   * @param provinceIdGreaterThan  (optional)
   * @param provinceIdLessThan  (optional)
   * @param provinceIdGreaterThanOrEqual  (optional)
   * @param provinceIdLessThanOrEqual  (optional)
   * @param provinceIdEquals  (optional)
   * @param provinceIdNotEquals  (optional)
   * @param provinceIdSpecified  (optional)
   * @param provinceIdIn  (optional)
   * @param provinceIdNotIn  (optional)
   * @param districtIdGreaterThan  (optional)
   * @param districtIdLessThan  (optional)
   * @param districtIdGreaterThanOrEqual  (optional)
   * @param districtIdLessThanOrEqual  (optional)
   * @param districtIdEquals  (optional)
   * @param districtIdNotEquals  (optional)
   * @param districtIdSpecified  (optional)
   * @param districtIdIn  (optional)
   * @param districtIdNotIn  (optional)
   * @param wardIdGreaterThan  (optional)
   * @param wardIdLessThan  (optional)
   * @param wardIdGreaterThanOrEqual  (optional)
   * @param wardIdLessThanOrEqual  (optional)
   * @param wardIdEquals  (optional)
   * @param wardIdNotEquals  (optional)
   * @param wardIdSpecified  (optional)
   * @param wardIdIn  (optional)
   * @param wardIdNotIn  (optional)
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
   * @param conditionIdGreaterThan  (optional)
   * @param conditionIdLessThan  (optional)
   * @param conditionIdGreaterThanOrEqual  (optional)
   * @param conditionIdLessThanOrEqual  (optional)
   * @param conditionIdEquals  (optional)
   * @param conditionIdNotEquals  (optional)
   * @param conditionIdSpecified  (optional)
   * @param conditionIdIn  (optional)
   * @param conditionIdNotIn  (optional)
   * @param distinct  (optional)
   * @return List&lt;ConditionLocationItemDTO&gt;
   */
  @RequestLine("GET /api/condition-location-items?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&provinceId.greaterThan={provinceIdGreaterThan}&provinceId.lessThan={provinceIdLessThan}&provinceId.greaterThanOrEqual={provinceIdGreaterThanOrEqual}&provinceId.lessThanOrEqual={provinceIdLessThanOrEqual}&provinceId.equals={provinceIdEquals}&provinceId.notEquals={provinceIdNotEquals}&provinceId.specified={provinceIdSpecified}&provinceId.in={provinceIdIn}&provinceId.notIn={provinceIdNotIn}&districtId.greaterThan={districtIdGreaterThan}&districtId.lessThan={districtIdLessThan}&districtId.greaterThanOrEqual={districtIdGreaterThanOrEqual}&districtId.lessThanOrEqual={districtIdLessThanOrEqual}&districtId.equals={districtIdEquals}&districtId.notEquals={districtIdNotEquals}&districtId.specified={districtIdSpecified}&districtId.in={districtIdIn}&districtId.notIn={districtIdNotIn}&wardId.greaterThan={wardIdGreaterThan}&wardId.lessThan={wardIdLessThan}&wardId.greaterThanOrEqual={wardIdGreaterThanOrEqual}&wardId.lessThanOrEqual={wardIdLessThanOrEqual}&wardId.equals={wardIdEquals}&wardId.notEquals={wardIdNotEquals}&wardId.specified={wardIdSpecified}&wardId.in={wardIdIn}&wardId.notIn={wardIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&conditionId.greaterThan={conditionIdGreaterThan}&conditionId.lessThan={conditionIdLessThan}&conditionId.greaterThanOrEqual={conditionIdGreaterThanOrEqual}&conditionId.lessThanOrEqual={conditionIdLessThanOrEqual}&conditionId.equals={conditionIdEquals}&conditionId.notEquals={conditionIdNotEquals}&conditionId.specified={conditionIdSpecified}&conditionId.in={conditionIdIn}&conditionId.notIn={conditionIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  List<ConditionLocationItemDTO> getAllConditionLocationItems(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("provinceIdGreaterThan") @jakarta.annotation.Nullable Long provinceIdGreaterThan, @Param("provinceIdLessThan") @jakarta.annotation.Nullable Long provinceIdLessThan, @Param("provinceIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long provinceIdGreaterThanOrEqual, @Param("provinceIdLessThanOrEqual") @jakarta.annotation.Nullable Long provinceIdLessThanOrEqual, @Param("provinceIdEquals") @jakarta.annotation.Nullable Long provinceIdEquals, @Param("provinceIdNotEquals") @jakarta.annotation.Nullable Long provinceIdNotEquals, @Param("provinceIdSpecified") @jakarta.annotation.Nullable Boolean provinceIdSpecified, @Param("provinceIdIn") @jakarta.annotation.Nullable List<Long> provinceIdIn, @Param("provinceIdNotIn") @jakarta.annotation.Nullable List<Long> provinceIdNotIn, @Param("districtIdGreaterThan") @jakarta.annotation.Nullable Long districtIdGreaterThan, @Param("districtIdLessThan") @jakarta.annotation.Nullable Long districtIdLessThan, @Param("districtIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long districtIdGreaterThanOrEqual, @Param("districtIdLessThanOrEqual") @jakarta.annotation.Nullable Long districtIdLessThanOrEqual, @Param("districtIdEquals") @jakarta.annotation.Nullable Long districtIdEquals, @Param("districtIdNotEquals") @jakarta.annotation.Nullable Long districtIdNotEquals, @Param("districtIdSpecified") @jakarta.annotation.Nullable Boolean districtIdSpecified, @Param("districtIdIn") @jakarta.annotation.Nullable List<Long> districtIdIn, @Param("districtIdNotIn") @jakarta.annotation.Nullable List<Long> districtIdNotIn, @Param("wardIdGreaterThan") @jakarta.annotation.Nullable Long wardIdGreaterThan, @Param("wardIdLessThan") @jakarta.annotation.Nullable Long wardIdLessThan, @Param("wardIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long wardIdGreaterThanOrEqual, @Param("wardIdLessThanOrEqual") @jakarta.annotation.Nullable Long wardIdLessThanOrEqual, @Param("wardIdEquals") @jakarta.annotation.Nullable Long wardIdEquals, @Param("wardIdNotEquals") @jakarta.annotation.Nullable Long wardIdNotEquals, @Param("wardIdSpecified") @jakarta.annotation.Nullable Boolean wardIdSpecified, @Param("wardIdIn") @jakarta.annotation.Nullable List<Long> wardIdIn, @Param("wardIdNotIn") @jakarta.annotation.Nullable List<Long> wardIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("conditionIdGreaterThan") @jakarta.annotation.Nullable Long conditionIdGreaterThan, @Param("conditionIdLessThan") @jakarta.annotation.Nullable Long conditionIdLessThan, @Param("conditionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long conditionIdGreaterThanOrEqual, @Param("conditionIdLessThanOrEqual") @jakarta.annotation.Nullable Long conditionIdLessThanOrEqual, @Param("conditionIdEquals") @jakarta.annotation.Nullable Long conditionIdEquals, @Param("conditionIdNotEquals") @jakarta.annotation.Nullable Long conditionIdNotEquals, @Param("conditionIdSpecified") @jakarta.annotation.Nullable Boolean conditionIdSpecified, @Param("conditionIdIn") @jakarta.annotation.Nullable List<Long> conditionIdIn, @Param("conditionIdNotIn") @jakarta.annotation.Nullable List<Long> conditionIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>getAllConditionLocationItems</code> but it also returns the http response headers .
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
   * @param provinceIdGreaterThan  (optional)
   * @param provinceIdLessThan  (optional)
   * @param provinceIdGreaterThanOrEqual  (optional)
   * @param provinceIdLessThanOrEqual  (optional)
   * @param provinceIdEquals  (optional)
   * @param provinceIdNotEquals  (optional)
   * @param provinceIdSpecified  (optional)
   * @param provinceIdIn  (optional)
   * @param provinceIdNotIn  (optional)
   * @param districtIdGreaterThan  (optional)
   * @param districtIdLessThan  (optional)
   * @param districtIdGreaterThanOrEqual  (optional)
   * @param districtIdLessThanOrEqual  (optional)
   * @param districtIdEquals  (optional)
   * @param districtIdNotEquals  (optional)
   * @param districtIdSpecified  (optional)
   * @param districtIdIn  (optional)
   * @param districtIdNotIn  (optional)
   * @param wardIdGreaterThan  (optional)
   * @param wardIdLessThan  (optional)
   * @param wardIdGreaterThanOrEqual  (optional)
   * @param wardIdLessThanOrEqual  (optional)
   * @param wardIdEquals  (optional)
   * @param wardIdNotEquals  (optional)
   * @param wardIdSpecified  (optional)
   * @param wardIdIn  (optional)
   * @param wardIdNotIn  (optional)
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
   * @param conditionIdGreaterThan  (optional)
   * @param conditionIdLessThan  (optional)
   * @param conditionIdGreaterThanOrEqual  (optional)
   * @param conditionIdLessThanOrEqual  (optional)
   * @param conditionIdEquals  (optional)
   * @param conditionIdNotEquals  (optional)
   * @param conditionIdSpecified  (optional)
   * @param conditionIdIn  (optional)
   * @param conditionIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/condition-location-items?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&provinceId.greaterThan={provinceIdGreaterThan}&provinceId.lessThan={provinceIdLessThan}&provinceId.greaterThanOrEqual={provinceIdGreaterThanOrEqual}&provinceId.lessThanOrEqual={provinceIdLessThanOrEqual}&provinceId.equals={provinceIdEquals}&provinceId.notEquals={provinceIdNotEquals}&provinceId.specified={provinceIdSpecified}&provinceId.in={provinceIdIn}&provinceId.notIn={provinceIdNotIn}&districtId.greaterThan={districtIdGreaterThan}&districtId.lessThan={districtIdLessThan}&districtId.greaterThanOrEqual={districtIdGreaterThanOrEqual}&districtId.lessThanOrEqual={districtIdLessThanOrEqual}&districtId.equals={districtIdEquals}&districtId.notEquals={districtIdNotEquals}&districtId.specified={districtIdSpecified}&districtId.in={districtIdIn}&districtId.notIn={districtIdNotIn}&wardId.greaterThan={wardIdGreaterThan}&wardId.lessThan={wardIdLessThan}&wardId.greaterThanOrEqual={wardIdGreaterThanOrEqual}&wardId.lessThanOrEqual={wardIdLessThanOrEqual}&wardId.equals={wardIdEquals}&wardId.notEquals={wardIdNotEquals}&wardId.specified={wardIdSpecified}&wardId.in={wardIdIn}&wardId.notIn={wardIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&conditionId.greaterThan={conditionIdGreaterThan}&conditionId.lessThan={conditionIdLessThan}&conditionId.greaterThanOrEqual={conditionIdGreaterThanOrEqual}&conditionId.lessThanOrEqual={conditionIdLessThanOrEqual}&conditionId.equals={conditionIdEquals}&conditionId.notEquals={conditionIdNotEquals}&conditionId.specified={conditionIdSpecified}&conditionId.in={conditionIdIn}&conditionId.notIn={conditionIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<ConditionLocationItemDTO>> getAllConditionLocationItemsWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("provinceIdGreaterThan") @jakarta.annotation.Nullable Long provinceIdGreaterThan, @Param("provinceIdLessThan") @jakarta.annotation.Nullable Long provinceIdLessThan, @Param("provinceIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long provinceIdGreaterThanOrEqual, @Param("provinceIdLessThanOrEqual") @jakarta.annotation.Nullable Long provinceIdLessThanOrEqual, @Param("provinceIdEquals") @jakarta.annotation.Nullable Long provinceIdEquals, @Param("provinceIdNotEquals") @jakarta.annotation.Nullable Long provinceIdNotEquals, @Param("provinceIdSpecified") @jakarta.annotation.Nullable Boolean provinceIdSpecified, @Param("provinceIdIn") @jakarta.annotation.Nullable List<Long> provinceIdIn, @Param("provinceIdNotIn") @jakarta.annotation.Nullable List<Long> provinceIdNotIn, @Param("districtIdGreaterThan") @jakarta.annotation.Nullable Long districtIdGreaterThan, @Param("districtIdLessThan") @jakarta.annotation.Nullable Long districtIdLessThan, @Param("districtIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long districtIdGreaterThanOrEqual, @Param("districtIdLessThanOrEqual") @jakarta.annotation.Nullable Long districtIdLessThanOrEqual, @Param("districtIdEquals") @jakarta.annotation.Nullable Long districtIdEquals, @Param("districtIdNotEquals") @jakarta.annotation.Nullable Long districtIdNotEquals, @Param("districtIdSpecified") @jakarta.annotation.Nullable Boolean districtIdSpecified, @Param("districtIdIn") @jakarta.annotation.Nullable List<Long> districtIdIn, @Param("districtIdNotIn") @jakarta.annotation.Nullable List<Long> districtIdNotIn, @Param("wardIdGreaterThan") @jakarta.annotation.Nullable Long wardIdGreaterThan, @Param("wardIdLessThan") @jakarta.annotation.Nullable Long wardIdLessThan, @Param("wardIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long wardIdGreaterThanOrEqual, @Param("wardIdLessThanOrEqual") @jakarta.annotation.Nullable Long wardIdLessThanOrEqual, @Param("wardIdEquals") @jakarta.annotation.Nullable Long wardIdEquals, @Param("wardIdNotEquals") @jakarta.annotation.Nullable Long wardIdNotEquals, @Param("wardIdSpecified") @jakarta.annotation.Nullable Boolean wardIdSpecified, @Param("wardIdIn") @jakarta.annotation.Nullable List<Long> wardIdIn, @Param("wardIdNotIn") @jakarta.annotation.Nullable List<Long> wardIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("conditionIdGreaterThan") @jakarta.annotation.Nullable Long conditionIdGreaterThan, @Param("conditionIdLessThan") @jakarta.annotation.Nullable Long conditionIdLessThan, @Param("conditionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long conditionIdGreaterThanOrEqual, @Param("conditionIdLessThanOrEqual") @jakarta.annotation.Nullable Long conditionIdLessThanOrEqual, @Param("conditionIdEquals") @jakarta.annotation.Nullable Long conditionIdEquals, @Param("conditionIdNotEquals") @jakarta.annotation.Nullable Long conditionIdNotEquals, @Param("conditionIdSpecified") @jakarta.annotation.Nullable Boolean conditionIdSpecified, @Param("conditionIdIn") @jakarta.annotation.Nullable List<Long> conditionIdIn, @Param("conditionIdNotIn") @jakarta.annotation.Nullable List<Long> conditionIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllConditionLocationItems</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllConditionLocationItemsQueryParams} class that allows for
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
   *   <li>provinceIdGreaterThan -  (optional)</li>
   *   <li>provinceIdLessThan -  (optional)</li>
   *   <li>provinceIdGreaterThanOrEqual -  (optional)</li>
   *   <li>provinceIdLessThanOrEqual -  (optional)</li>
   *   <li>provinceIdEquals -  (optional)</li>
   *   <li>provinceIdNotEquals -  (optional)</li>
   *   <li>provinceIdSpecified -  (optional)</li>
   *   <li>provinceIdIn -  (optional)</li>
   *   <li>provinceIdNotIn -  (optional)</li>
   *   <li>districtIdGreaterThan -  (optional)</li>
   *   <li>districtIdLessThan -  (optional)</li>
   *   <li>districtIdGreaterThanOrEqual -  (optional)</li>
   *   <li>districtIdLessThanOrEqual -  (optional)</li>
   *   <li>districtIdEquals -  (optional)</li>
   *   <li>districtIdNotEquals -  (optional)</li>
   *   <li>districtIdSpecified -  (optional)</li>
   *   <li>districtIdIn -  (optional)</li>
   *   <li>districtIdNotIn -  (optional)</li>
   *   <li>wardIdGreaterThan -  (optional)</li>
   *   <li>wardIdLessThan -  (optional)</li>
   *   <li>wardIdGreaterThanOrEqual -  (optional)</li>
   *   <li>wardIdLessThanOrEqual -  (optional)</li>
   *   <li>wardIdEquals -  (optional)</li>
   *   <li>wardIdNotEquals -  (optional)</li>
   *   <li>wardIdSpecified -  (optional)</li>
   *   <li>wardIdIn -  (optional)</li>
   *   <li>wardIdNotIn -  (optional)</li>
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
   *   <li>conditionIdGreaterThan -  (optional)</li>
   *   <li>conditionIdLessThan -  (optional)</li>
   *   <li>conditionIdGreaterThanOrEqual -  (optional)</li>
   *   <li>conditionIdLessThanOrEqual -  (optional)</li>
   *   <li>conditionIdEquals -  (optional)</li>
   *   <li>conditionIdNotEquals -  (optional)</li>
   *   <li>conditionIdSpecified -  (optional)</li>
   *   <li>conditionIdIn -  (optional)</li>
   *   <li>conditionIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return List&lt;ConditionLocationItemDTO&gt;
   */
  @RequestLine("GET /api/condition-location-items?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&provinceId.greaterThan={provinceIdGreaterThan}&provinceId.lessThan={provinceIdLessThan}&provinceId.greaterThanOrEqual={provinceIdGreaterThanOrEqual}&provinceId.lessThanOrEqual={provinceIdLessThanOrEqual}&provinceId.equals={provinceIdEquals}&provinceId.notEquals={provinceIdNotEquals}&provinceId.specified={provinceIdSpecified}&provinceId.in={provinceIdIn}&provinceId.notIn={provinceIdNotIn}&districtId.greaterThan={districtIdGreaterThan}&districtId.lessThan={districtIdLessThan}&districtId.greaterThanOrEqual={districtIdGreaterThanOrEqual}&districtId.lessThanOrEqual={districtIdLessThanOrEqual}&districtId.equals={districtIdEquals}&districtId.notEquals={districtIdNotEquals}&districtId.specified={districtIdSpecified}&districtId.in={districtIdIn}&districtId.notIn={districtIdNotIn}&wardId.greaterThan={wardIdGreaterThan}&wardId.lessThan={wardIdLessThan}&wardId.greaterThanOrEqual={wardIdGreaterThanOrEqual}&wardId.lessThanOrEqual={wardIdLessThanOrEqual}&wardId.equals={wardIdEquals}&wardId.notEquals={wardIdNotEquals}&wardId.specified={wardIdSpecified}&wardId.in={wardIdIn}&wardId.notIn={wardIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&conditionId.greaterThan={conditionIdGreaterThan}&conditionId.lessThan={conditionIdLessThan}&conditionId.greaterThanOrEqual={conditionIdGreaterThanOrEqual}&conditionId.lessThanOrEqual={conditionIdLessThanOrEqual}&conditionId.equals={conditionIdEquals}&conditionId.notEquals={conditionIdNotEquals}&conditionId.specified={conditionIdSpecified}&conditionId.in={conditionIdIn}&conditionId.notIn={conditionIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  List<ConditionLocationItemDTO> getAllConditionLocationItems(@QueryMap(encoded=true) GetAllConditionLocationItemsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllConditionLocationItems</code> that receives the query parameters as a map,
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
          *   <li>provinceIdGreaterThan -  (optional)</li>
          *   <li>provinceIdLessThan -  (optional)</li>
          *   <li>provinceIdGreaterThanOrEqual -  (optional)</li>
          *   <li>provinceIdLessThanOrEqual -  (optional)</li>
          *   <li>provinceIdEquals -  (optional)</li>
          *   <li>provinceIdNotEquals -  (optional)</li>
          *   <li>provinceIdSpecified -  (optional)</li>
          *   <li>provinceIdIn -  (optional)</li>
          *   <li>provinceIdNotIn -  (optional)</li>
          *   <li>districtIdGreaterThan -  (optional)</li>
          *   <li>districtIdLessThan -  (optional)</li>
          *   <li>districtIdGreaterThanOrEqual -  (optional)</li>
          *   <li>districtIdLessThanOrEqual -  (optional)</li>
          *   <li>districtIdEquals -  (optional)</li>
          *   <li>districtIdNotEquals -  (optional)</li>
          *   <li>districtIdSpecified -  (optional)</li>
          *   <li>districtIdIn -  (optional)</li>
          *   <li>districtIdNotIn -  (optional)</li>
          *   <li>wardIdGreaterThan -  (optional)</li>
          *   <li>wardIdLessThan -  (optional)</li>
          *   <li>wardIdGreaterThanOrEqual -  (optional)</li>
          *   <li>wardIdLessThanOrEqual -  (optional)</li>
          *   <li>wardIdEquals -  (optional)</li>
          *   <li>wardIdNotEquals -  (optional)</li>
          *   <li>wardIdSpecified -  (optional)</li>
          *   <li>wardIdIn -  (optional)</li>
          *   <li>wardIdNotIn -  (optional)</li>
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
          *   <li>conditionIdGreaterThan -  (optional)</li>
          *   <li>conditionIdLessThan -  (optional)</li>
          *   <li>conditionIdGreaterThanOrEqual -  (optional)</li>
          *   <li>conditionIdLessThanOrEqual -  (optional)</li>
          *   <li>conditionIdEquals -  (optional)</li>
          *   <li>conditionIdNotEquals -  (optional)</li>
          *   <li>conditionIdSpecified -  (optional)</li>
          *   <li>conditionIdIn -  (optional)</li>
          *   <li>conditionIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return List&lt;ConditionLocationItemDTO&gt;
      */
      @RequestLine("GET /api/condition-location-items?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&provinceId.greaterThan={provinceIdGreaterThan}&provinceId.lessThan={provinceIdLessThan}&provinceId.greaterThanOrEqual={provinceIdGreaterThanOrEqual}&provinceId.lessThanOrEqual={provinceIdLessThanOrEqual}&provinceId.equals={provinceIdEquals}&provinceId.notEquals={provinceIdNotEquals}&provinceId.specified={provinceIdSpecified}&provinceId.in={provinceIdIn}&provinceId.notIn={provinceIdNotIn}&districtId.greaterThan={districtIdGreaterThan}&districtId.lessThan={districtIdLessThan}&districtId.greaterThanOrEqual={districtIdGreaterThanOrEqual}&districtId.lessThanOrEqual={districtIdLessThanOrEqual}&districtId.equals={districtIdEquals}&districtId.notEquals={districtIdNotEquals}&districtId.specified={districtIdSpecified}&districtId.in={districtIdIn}&districtId.notIn={districtIdNotIn}&wardId.greaterThan={wardIdGreaterThan}&wardId.lessThan={wardIdLessThan}&wardId.greaterThanOrEqual={wardIdGreaterThanOrEqual}&wardId.lessThanOrEqual={wardIdLessThanOrEqual}&wardId.equals={wardIdEquals}&wardId.notEquals={wardIdNotEquals}&wardId.specified={wardIdSpecified}&wardId.in={wardIdIn}&wardId.notIn={wardIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&conditionId.greaterThan={conditionIdGreaterThan}&conditionId.lessThan={conditionIdLessThan}&conditionId.greaterThanOrEqual={conditionIdGreaterThanOrEqual}&conditionId.lessThanOrEqual={conditionIdLessThanOrEqual}&conditionId.equals={conditionIdEquals}&conditionId.notEquals={conditionIdNotEquals}&conditionId.specified={conditionIdSpecified}&conditionId.in={conditionIdIn}&conditionId.notIn={conditionIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<ConditionLocationItemDTO>> getAllConditionLocationItemsWithHttpInfo(@QueryMap(encoded=true) GetAllConditionLocationItemsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllConditionLocationItems</code> method in a fluent style.
   */
  public static class GetAllConditionLocationItemsQueryParams extends HashMap<String, Object> {
    public GetAllConditionLocationItemsQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams provinceIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("provinceId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams provinceIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("provinceId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams provinceIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("provinceId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams provinceIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("provinceId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams provinceIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("provinceId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams provinceIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("provinceId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams provinceIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("provinceId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams provinceIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("provinceId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams provinceIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("provinceId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams districtIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("districtId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams districtIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("districtId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams districtIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("districtId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams districtIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("districtId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams districtIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("districtId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams districtIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("districtId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams districtIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("districtId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams districtIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("districtId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams districtIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("districtId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams wardIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("wardId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams wardIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("wardId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams wardIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("wardId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams wardIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("wardId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams wardIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("wardId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams wardIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("wardId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams wardIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("wardId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams wardIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("wardId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams wardIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("wardId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams conditionIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("conditionId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams conditionIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("conditionId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams conditionIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("conditionId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams conditionIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("conditionId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams conditionIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("conditionId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams conditionIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("conditionId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams conditionIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("conditionId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams conditionIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("conditionId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams conditionIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("conditionId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionLocationItemsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @return ConditionLocationItemDTO
   */
  @RequestLine("GET /api/condition-location-items/{id}")
  @Headers({
    "Accept: */*",
  })
  ConditionLocationItemDTO getConditionLocationItem(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>getConditionLocationItem</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/condition-location-items/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<ConditionLocationItemDTO> getConditionLocationItemWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param id  (required)
   * @param conditionLocationItemDTO  (required)
   * @return ConditionLocationItemDTO
   */
  @RequestLine("PATCH /api/condition-location-items/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ConditionLocationItemDTO partialUpdateConditionLocationItem(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull ConditionLocationItemDTO conditionLocationItemDTO);

  /**
   * 
   * Similar to <code>partialUpdateConditionLocationItem</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param conditionLocationItemDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /api/condition-location-items/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<ConditionLocationItemDTO> partialUpdateConditionLocationItemWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull ConditionLocationItemDTO conditionLocationItemDTO);



  /**
   * 
   * 
   * @param id  (required)
   * @param conditionLocationItemDTO  (required)
   * @return ConditionLocationItemDTO
   */
  @RequestLine("PUT /api/condition-location-items/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ConditionLocationItemDTO updateConditionLocationItem(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull ConditionLocationItemDTO conditionLocationItemDTO);

  /**
   * 
   * Similar to <code>updateConditionLocationItem</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param conditionLocationItemDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/condition-location-items/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<ConditionLocationItemDTO> updateConditionLocationItemWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull ConditionLocationItemDTO conditionLocationItemDTO);


}
