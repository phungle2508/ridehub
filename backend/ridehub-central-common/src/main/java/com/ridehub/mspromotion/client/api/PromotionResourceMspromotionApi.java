package com.ridehub.mspromotion.client.api;

import com.ridehub.mspromotion.client.invoker.ApiClient;
import com.ridehub.mspromotion.client.invoker.EncodingUtils;
import com.ridehub.mspromotion.client.model.ApiResponse;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import com.ridehub.mspromotion.client.model.PromotionDTO;
import com.ridehub.mspromotion.client.model.PromotionDetailDTO;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface PromotionResourceMspromotionApi extends ApiClient.Api {


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
   * @param codeContains  (optional)
   * @param codeDoesNotContain  (optional)
   * @param codeEquals  (optional)
   * @param codeNotEquals  (optional)
   * @param codeSpecified  (optional)
   * @param codeIn  (optional)
   * @param codeNotIn  (optional)
   * @param descriptionContains  (optional)
   * @param descriptionDoesNotContain  (optional)
   * @param descriptionEquals  (optional)
   * @param descriptionNotEquals  (optional)
   * @param descriptionSpecified  (optional)
   * @param descriptionIn  (optional)
   * @param descriptionNotIn  (optional)
   * @param startDateGreaterThan  (optional)
   * @param startDateLessThan  (optional)
   * @param startDateGreaterThanOrEqual  (optional)
   * @param startDateLessThanOrEqual  (optional)
   * @param startDateEquals  (optional)
   * @param startDateNotEquals  (optional)
   * @param startDateSpecified  (optional)
   * @param startDateIn  (optional)
   * @param startDateNotIn  (optional)
   * @param endDateGreaterThan  (optional)
   * @param endDateLessThan  (optional)
   * @param endDateGreaterThanOrEqual  (optional)
   * @param endDateLessThanOrEqual  (optional)
   * @param endDateEquals  (optional)
   * @param endDateNotEquals  (optional)
   * @param endDateSpecified  (optional)
   * @param endDateIn  (optional)
   * @param endDateNotIn  (optional)
   * @param usageLimitGreaterThan  (optional)
   * @param usageLimitLessThan  (optional)
   * @param usageLimitGreaterThanOrEqual  (optional)
   * @param usageLimitLessThanOrEqual  (optional)
   * @param usageLimitEquals  (optional)
   * @param usageLimitNotEquals  (optional)
   * @param usageLimitSpecified  (optional)
   * @param usageLimitIn  (optional)
   * @param usageLimitNotIn  (optional)
   * @param usedCountGreaterThan  (optional)
   * @param usedCountLessThan  (optional)
   * @param usedCountGreaterThanOrEqual  (optional)
   * @param usedCountLessThanOrEqual  (optional)
   * @param usedCountEquals  (optional)
   * @param usedCountNotEquals  (optional)
   * @param usedCountSpecified  (optional)
   * @param usedCountIn  (optional)
   * @param usedCountNotIn  (optional)
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
   * @param filesIdGreaterThan  (optional)
   * @param filesIdLessThan  (optional)
   * @param filesIdGreaterThanOrEqual  (optional)
   * @param filesIdLessThanOrEqual  (optional)
   * @param filesIdEquals  (optional)
   * @param filesIdNotEquals  (optional)
   * @param filesIdSpecified  (optional)
   * @param filesIdIn  (optional)
   * @param filesIdNotIn  (optional)
   * @param buyNGetMIdGreaterThan  (optional)
   * @param buyNGetMIdLessThan  (optional)
   * @param buyNGetMIdGreaterThanOrEqual  (optional)
   * @param buyNGetMIdLessThanOrEqual  (optional)
   * @param buyNGetMIdEquals  (optional)
   * @param buyNGetMIdNotEquals  (optional)
   * @param buyNGetMIdSpecified  (optional)
   * @param buyNGetMIdIn  (optional)
   * @param buyNGetMIdNotIn  (optional)
   * @param percentOffIdGreaterThan  (optional)
   * @param percentOffIdLessThan  (optional)
   * @param percentOffIdGreaterThanOrEqual  (optional)
   * @param percentOffIdLessThanOrEqual  (optional)
   * @param percentOffIdEquals  (optional)
   * @param percentOffIdNotEquals  (optional)
   * @param percentOffIdSpecified  (optional)
   * @param percentOffIdIn  (optional)
   * @param percentOffIdNotIn  (optional)
   * @param conditionsRIdGreaterThan  (optional)
   * @param conditionsRIdLessThan  (optional)
   * @param conditionsRIdGreaterThanOrEqual  (optional)
   * @param conditionsRIdLessThanOrEqual  (optional)
   * @param conditionsRIdEquals  (optional)
   * @param conditionsRIdNotEquals  (optional)
   * @param conditionsRIdSpecified  (optional)
   * @param conditionsRIdIn  (optional)
   * @param conditionsRIdNotIn  (optional)
   * @param conditionsDIdGreaterThan  (optional)
   * @param conditionsDIdLessThan  (optional)
   * @param conditionsDIdGreaterThanOrEqual  (optional)
   * @param conditionsDIdLessThanOrEqual  (optional)
   * @param conditionsDIdEquals  (optional)
   * @param conditionsDIdNotEquals  (optional)
   * @param conditionsDIdSpecified  (optional)
   * @param conditionsDIdIn  (optional)
   * @param conditionsDIdNotIn  (optional)
   * @param conditionsLocIdGreaterThan  (optional)
   * @param conditionsLocIdLessThan  (optional)
   * @param conditionsLocIdGreaterThanOrEqual  (optional)
   * @param conditionsLocIdLessThanOrEqual  (optional)
   * @param conditionsLocIdEquals  (optional)
   * @param conditionsLocIdNotEquals  (optional)
   * @param conditionsLocIdSpecified  (optional)
   * @param conditionsLocIdIn  (optional)
   * @param conditionsLocIdNotIn  (optional)
   * @param distinct  (optional)
   * @return Long
   */
  @RequestLine("GET /api/promotions/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&code.contains={codeContains}&code.doesNotContain={codeDoesNotContain}&code.equals={codeEquals}&code.notEquals={codeNotEquals}&code.specified={codeSpecified}&code.in={codeIn}&code.notIn={codeNotIn}&description.contains={descriptionContains}&description.doesNotContain={descriptionDoesNotContain}&description.equals={descriptionEquals}&description.notEquals={descriptionNotEquals}&description.specified={descriptionSpecified}&description.in={descriptionIn}&description.notIn={descriptionNotIn}&startDate.greaterThan={startDateGreaterThan}&startDate.lessThan={startDateLessThan}&startDate.greaterThanOrEqual={startDateGreaterThanOrEqual}&startDate.lessThanOrEqual={startDateLessThanOrEqual}&startDate.equals={startDateEquals}&startDate.notEquals={startDateNotEquals}&startDate.specified={startDateSpecified}&startDate.in={startDateIn}&startDate.notIn={startDateNotIn}&endDate.greaterThan={endDateGreaterThan}&endDate.lessThan={endDateLessThan}&endDate.greaterThanOrEqual={endDateGreaterThanOrEqual}&endDate.lessThanOrEqual={endDateLessThanOrEqual}&endDate.equals={endDateEquals}&endDate.notEquals={endDateNotEquals}&endDate.specified={endDateSpecified}&endDate.in={endDateIn}&endDate.notIn={endDateNotIn}&usageLimit.greaterThan={usageLimitGreaterThan}&usageLimit.lessThan={usageLimitLessThan}&usageLimit.greaterThanOrEqual={usageLimitGreaterThanOrEqual}&usageLimit.lessThanOrEqual={usageLimitLessThanOrEqual}&usageLimit.equals={usageLimitEquals}&usageLimit.notEquals={usageLimitNotEquals}&usageLimit.specified={usageLimitSpecified}&usageLimit.in={usageLimitIn}&usageLimit.notIn={usageLimitNotIn}&usedCount.greaterThan={usedCountGreaterThan}&usedCount.lessThan={usedCountLessThan}&usedCount.greaterThanOrEqual={usedCountGreaterThanOrEqual}&usedCount.lessThanOrEqual={usedCountLessThanOrEqual}&usedCount.equals={usedCountEquals}&usedCount.notEquals={usedCountNotEquals}&usedCount.specified={usedCountSpecified}&usedCount.in={usedCountIn}&usedCount.notIn={usedCountNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&filesId.greaterThan={filesIdGreaterThan}&filesId.lessThan={filesIdLessThan}&filesId.greaterThanOrEqual={filesIdGreaterThanOrEqual}&filesId.lessThanOrEqual={filesIdLessThanOrEqual}&filesId.equals={filesIdEquals}&filesId.notEquals={filesIdNotEquals}&filesId.specified={filesIdSpecified}&filesId.in={filesIdIn}&filesId.notIn={filesIdNotIn}&buyNGetMId.greaterThan={buyNGetMIdGreaterThan}&buyNGetMId.lessThan={buyNGetMIdLessThan}&buyNGetMId.greaterThanOrEqual={buyNGetMIdGreaterThanOrEqual}&buyNGetMId.lessThanOrEqual={buyNGetMIdLessThanOrEqual}&buyNGetMId.equals={buyNGetMIdEquals}&buyNGetMId.notEquals={buyNGetMIdNotEquals}&buyNGetMId.specified={buyNGetMIdSpecified}&buyNGetMId.in={buyNGetMIdIn}&buyNGetMId.notIn={buyNGetMIdNotIn}&percentOffId.greaterThan={percentOffIdGreaterThan}&percentOffId.lessThan={percentOffIdLessThan}&percentOffId.greaterThanOrEqual={percentOffIdGreaterThanOrEqual}&percentOffId.lessThanOrEqual={percentOffIdLessThanOrEqual}&percentOffId.equals={percentOffIdEquals}&percentOffId.notEquals={percentOffIdNotEquals}&percentOffId.specified={percentOffIdSpecified}&percentOffId.in={percentOffIdIn}&percentOffId.notIn={percentOffIdNotIn}&conditionsRId.greaterThan={conditionsRIdGreaterThan}&conditionsRId.lessThan={conditionsRIdLessThan}&conditionsRId.greaterThanOrEqual={conditionsRIdGreaterThanOrEqual}&conditionsRId.lessThanOrEqual={conditionsRIdLessThanOrEqual}&conditionsRId.equals={conditionsRIdEquals}&conditionsRId.notEquals={conditionsRIdNotEquals}&conditionsRId.specified={conditionsRIdSpecified}&conditionsRId.in={conditionsRIdIn}&conditionsRId.notIn={conditionsRIdNotIn}&conditionsDId.greaterThan={conditionsDIdGreaterThan}&conditionsDId.lessThan={conditionsDIdLessThan}&conditionsDId.greaterThanOrEqual={conditionsDIdGreaterThanOrEqual}&conditionsDId.lessThanOrEqual={conditionsDIdLessThanOrEqual}&conditionsDId.equals={conditionsDIdEquals}&conditionsDId.notEquals={conditionsDIdNotEquals}&conditionsDId.specified={conditionsDIdSpecified}&conditionsDId.in={conditionsDIdIn}&conditionsDId.notIn={conditionsDIdNotIn}&conditionsLocId.greaterThan={conditionsLocIdGreaterThan}&conditionsLocId.lessThan={conditionsLocIdLessThan}&conditionsLocId.greaterThanOrEqual={conditionsLocIdGreaterThanOrEqual}&conditionsLocId.lessThanOrEqual={conditionsLocIdLessThanOrEqual}&conditionsLocId.equals={conditionsLocIdEquals}&conditionsLocId.notEquals={conditionsLocIdNotEquals}&conditionsLocId.specified={conditionsLocIdSpecified}&conditionsLocId.in={conditionsLocIdIn}&conditionsLocId.notIn={conditionsLocIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  Long countPromotions(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("codeContains") @jakarta.annotation.Nullable String codeContains, @Param("codeDoesNotContain") @jakarta.annotation.Nullable String codeDoesNotContain, @Param("codeEquals") @jakarta.annotation.Nullable String codeEquals, @Param("codeNotEquals") @jakarta.annotation.Nullable String codeNotEquals, @Param("codeSpecified") @jakarta.annotation.Nullable Boolean codeSpecified, @Param("codeIn") @jakarta.annotation.Nullable List<String> codeIn, @Param("codeNotIn") @jakarta.annotation.Nullable List<String> codeNotIn, @Param("descriptionContains") @jakarta.annotation.Nullable String descriptionContains, @Param("descriptionDoesNotContain") @jakarta.annotation.Nullable String descriptionDoesNotContain, @Param("descriptionEquals") @jakarta.annotation.Nullable String descriptionEquals, @Param("descriptionNotEquals") @jakarta.annotation.Nullable String descriptionNotEquals, @Param("descriptionSpecified") @jakarta.annotation.Nullable Boolean descriptionSpecified, @Param("descriptionIn") @jakarta.annotation.Nullable List<String> descriptionIn, @Param("descriptionNotIn") @jakarta.annotation.Nullable List<String> descriptionNotIn, @Param("startDateGreaterThan") @jakarta.annotation.Nullable LocalDate startDateGreaterThan, @Param("startDateLessThan") @jakarta.annotation.Nullable LocalDate startDateLessThan, @Param("startDateGreaterThanOrEqual") @jakarta.annotation.Nullable LocalDate startDateGreaterThanOrEqual, @Param("startDateLessThanOrEqual") @jakarta.annotation.Nullable LocalDate startDateLessThanOrEqual, @Param("startDateEquals") @jakarta.annotation.Nullable LocalDate startDateEquals, @Param("startDateNotEquals") @jakarta.annotation.Nullable LocalDate startDateNotEquals, @Param("startDateSpecified") @jakarta.annotation.Nullable Boolean startDateSpecified, @Param("startDateIn") @jakarta.annotation.Nullable List<LocalDate> startDateIn, @Param("startDateNotIn") @jakarta.annotation.Nullable List<LocalDate> startDateNotIn, @Param("endDateGreaterThan") @jakarta.annotation.Nullable LocalDate endDateGreaterThan, @Param("endDateLessThan") @jakarta.annotation.Nullable LocalDate endDateLessThan, @Param("endDateGreaterThanOrEqual") @jakarta.annotation.Nullable LocalDate endDateGreaterThanOrEqual, @Param("endDateLessThanOrEqual") @jakarta.annotation.Nullable LocalDate endDateLessThanOrEqual, @Param("endDateEquals") @jakarta.annotation.Nullable LocalDate endDateEquals, @Param("endDateNotEquals") @jakarta.annotation.Nullable LocalDate endDateNotEquals, @Param("endDateSpecified") @jakarta.annotation.Nullable Boolean endDateSpecified, @Param("endDateIn") @jakarta.annotation.Nullable List<LocalDate> endDateIn, @Param("endDateNotIn") @jakarta.annotation.Nullable List<LocalDate> endDateNotIn, @Param("usageLimitGreaterThan") @jakarta.annotation.Nullable Integer usageLimitGreaterThan, @Param("usageLimitLessThan") @jakarta.annotation.Nullable Integer usageLimitLessThan, @Param("usageLimitGreaterThanOrEqual") @jakarta.annotation.Nullable Integer usageLimitGreaterThanOrEqual, @Param("usageLimitLessThanOrEqual") @jakarta.annotation.Nullable Integer usageLimitLessThanOrEqual, @Param("usageLimitEquals") @jakarta.annotation.Nullable Integer usageLimitEquals, @Param("usageLimitNotEquals") @jakarta.annotation.Nullable Integer usageLimitNotEquals, @Param("usageLimitSpecified") @jakarta.annotation.Nullable Boolean usageLimitSpecified, @Param("usageLimitIn") @jakarta.annotation.Nullable List<Integer> usageLimitIn, @Param("usageLimitNotIn") @jakarta.annotation.Nullable List<Integer> usageLimitNotIn, @Param("usedCountGreaterThan") @jakarta.annotation.Nullable Integer usedCountGreaterThan, @Param("usedCountLessThan") @jakarta.annotation.Nullable Integer usedCountLessThan, @Param("usedCountGreaterThanOrEqual") @jakarta.annotation.Nullable Integer usedCountGreaterThanOrEqual, @Param("usedCountLessThanOrEqual") @jakarta.annotation.Nullable Integer usedCountLessThanOrEqual, @Param("usedCountEquals") @jakarta.annotation.Nullable Integer usedCountEquals, @Param("usedCountNotEquals") @jakarta.annotation.Nullable Integer usedCountNotEquals, @Param("usedCountSpecified") @jakarta.annotation.Nullable Boolean usedCountSpecified, @Param("usedCountIn") @jakarta.annotation.Nullable List<Integer> usedCountIn, @Param("usedCountNotIn") @jakarta.annotation.Nullable List<Integer> usedCountNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("filesIdGreaterThan") @jakarta.annotation.Nullable Long filesIdGreaterThan, @Param("filesIdLessThan") @jakarta.annotation.Nullable Long filesIdLessThan, @Param("filesIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long filesIdGreaterThanOrEqual, @Param("filesIdLessThanOrEqual") @jakarta.annotation.Nullable Long filesIdLessThanOrEqual, @Param("filesIdEquals") @jakarta.annotation.Nullable Long filesIdEquals, @Param("filesIdNotEquals") @jakarta.annotation.Nullable Long filesIdNotEquals, @Param("filesIdSpecified") @jakarta.annotation.Nullable Boolean filesIdSpecified, @Param("filesIdIn") @jakarta.annotation.Nullable List<Long> filesIdIn, @Param("filesIdNotIn") @jakarta.annotation.Nullable List<Long> filesIdNotIn, @Param("buyNGetMIdGreaterThan") @jakarta.annotation.Nullable Long buyNGetMIdGreaterThan, @Param("buyNGetMIdLessThan") @jakarta.annotation.Nullable Long buyNGetMIdLessThan, @Param("buyNGetMIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long buyNGetMIdGreaterThanOrEqual, @Param("buyNGetMIdLessThanOrEqual") @jakarta.annotation.Nullable Long buyNGetMIdLessThanOrEqual, @Param("buyNGetMIdEquals") @jakarta.annotation.Nullable Long buyNGetMIdEquals, @Param("buyNGetMIdNotEquals") @jakarta.annotation.Nullable Long buyNGetMIdNotEquals, @Param("buyNGetMIdSpecified") @jakarta.annotation.Nullable Boolean buyNGetMIdSpecified, @Param("buyNGetMIdIn") @jakarta.annotation.Nullable List<Long> buyNGetMIdIn, @Param("buyNGetMIdNotIn") @jakarta.annotation.Nullable List<Long> buyNGetMIdNotIn, @Param("percentOffIdGreaterThan") @jakarta.annotation.Nullable Long percentOffIdGreaterThan, @Param("percentOffIdLessThan") @jakarta.annotation.Nullable Long percentOffIdLessThan, @Param("percentOffIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long percentOffIdGreaterThanOrEqual, @Param("percentOffIdLessThanOrEqual") @jakarta.annotation.Nullable Long percentOffIdLessThanOrEqual, @Param("percentOffIdEquals") @jakarta.annotation.Nullable Long percentOffIdEquals, @Param("percentOffIdNotEquals") @jakarta.annotation.Nullable Long percentOffIdNotEquals, @Param("percentOffIdSpecified") @jakarta.annotation.Nullable Boolean percentOffIdSpecified, @Param("percentOffIdIn") @jakarta.annotation.Nullable List<Long> percentOffIdIn, @Param("percentOffIdNotIn") @jakarta.annotation.Nullable List<Long> percentOffIdNotIn, @Param("conditionsRIdGreaterThan") @jakarta.annotation.Nullable Long conditionsRIdGreaterThan, @Param("conditionsRIdLessThan") @jakarta.annotation.Nullable Long conditionsRIdLessThan, @Param("conditionsRIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long conditionsRIdGreaterThanOrEqual, @Param("conditionsRIdLessThanOrEqual") @jakarta.annotation.Nullable Long conditionsRIdLessThanOrEqual, @Param("conditionsRIdEquals") @jakarta.annotation.Nullable Long conditionsRIdEquals, @Param("conditionsRIdNotEquals") @jakarta.annotation.Nullable Long conditionsRIdNotEquals, @Param("conditionsRIdSpecified") @jakarta.annotation.Nullable Boolean conditionsRIdSpecified, @Param("conditionsRIdIn") @jakarta.annotation.Nullable List<Long> conditionsRIdIn, @Param("conditionsRIdNotIn") @jakarta.annotation.Nullable List<Long> conditionsRIdNotIn, @Param("conditionsDIdGreaterThan") @jakarta.annotation.Nullable Long conditionsDIdGreaterThan, @Param("conditionsDIdLessThan") @jakarta.annotation.Nullable Long conditionsDIdLessThan, @Param("conditionsDIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long conditionsDIdGreaterThanOrEqual, @Param("conditionsDIdLessThanOrEqual") @jakarta.annotation.Nullable Long conditionsDIdLessThanOrEqual, @Param("conditionsDIdEquals") @jakarta.annotation.Nullable Long conditionsDIdEquals, @Param("conditionsDIdNotEquals") @jakarta.annotation.Nullable Long conditionsDIdNotEquals, @Param("conditionsDIdSpecified") @jakarta.annotation.Nullable Boolean conditionsDIdSpecified, @Param("conditionsDIdIn") @jakarta.annotation.Nullable List<Long> conditionsDIdIn, @Param("conditionsDIdNotIn") @jakarta.annotation.Nullable List<Long> conditionsDIdNotIn, @Param("conditionsLocIdGreaterThan") @jakarta.annotation.Nullable Long conditionsLocIdGreaterThan, @Param("conditionsLocIdLessThan") @jakarta.annotation.Nullable Long conditionsLocIdLessThan, @Param("conditionsLocIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long conditionsLocIdGreaterThanOrEqual, @Param("conditionsLocIdLessThanOrEqual") @jakarta.annotation.Nullable Long conditionsLocIdLessThanOrEqual, @Param("conditionsLocIdEquals") @jakarta.annotation.Nullable Long conditionsLocIdEquals, @Param("conditionsLocIdNotEquals") @jakarta.annotation.Nullable Long conditionsLocIdNotEquals, @Param("conditionsLocIdSpecified") @jakarta.annotation.Nullable Boolean conditionsLocIdSpecified, @Param("conditionsLocIdIn") @jakarta.annotation.Nullable List<Long> conditionsLocIdIn, @Param("conditionsLocIdNotIn") @jakarta.annotation.Nullable List<Long> conditionsLocIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>countPromotions</code> but it also returns the http response headers .
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
   * @param codeContains  (optional)
   * @param codeDoesNotContain  (optional)
   * @param codeEquals  (optional)
   * @param codeNotEquals  (optional)
   * @param codeSpecified  (optional)
   * @param codeIn  (optional)
   * @param codeNotIn  (optional)
   * @param descriptionContains  (optional)
   * @param descriptionDoesNotContain  (optional)
   * @param descriptionEquals  (optional)
   * @param descriptionNotEquals  (optional)
   * @param descriptionSpecified  (optional)
   * @param descriptionIn  (optional)
   * @param descriptionNotIn  (optional)
   * @param startDateGreaterThan  (optional)
   * @param startDateLessThan  (optional)
   * @param startDateGreaterThanOrEqual  (optional)
   * @param startDateLessThanOrEqual  (optional)
   * @param startDateEquals  (optional)
   * @param startDateNotEquals  (optional)
   * @param startDateSpecified  (optional)
   * @param startDateIn  (optional)
   * @param startDateNotIn  (optional)
   * @param endDateGreaterThan  (optional)
   * @param endDateLessThan  (optional)
   * @param endDateGreaterThanOrEqual  (optional)
   * @param endDateLessThanOrEqual  (optional)
   * @param endDateEquals  (optional)
   * @param endDateNotEquals  (optional)
   * @param endDateSpecified  (optional)
   * @param endDateIn  (optional)
   * @param endDateNotIn  (optional)
   * @param usageLimitGreaterThan  (optional)
   * @param usageLimitLessThan  (optional)
   * @param usageLimitGreaterThanOrEqual  (optional)
   * @param usageLimitLessThanOrEqual  (optional)
   * @param usageLimitEquals  (optional)
   * @param usageLimitNotEquals  (optional)
   * @param usageLimitSpecified  (optional)
   * @param usageLimitIn  (optional)
   * @param usageLimitNotIn  (optional)
   * @param usedCountGreaterThan  (optional)
   * @param usedCountLessThan  (optional)
   * @param usedCountGreaterThanOrEqual  (optional)
   * @param usedCountLessThanOrEqual  (optional)
   * @param usedCountEquals  (optional)
   * @param usedCountNotEquals  (optional)
   * @param usedCountSpecified  (optional)
   * @param usedCountIn  (optional)
   * @param usedCountNotIn  (optional)
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
   * @param filesIdGreaterThan  (optional)
   * @param filesIdLessThan  (optional)
   * @param filesIdGreaterThanOrEqual  (optional)
   * @param filesIdLessThanOrEqual  (optional)
   * @param filesIdEquals  (optional)
   * @param filesIdNotEquals  (optional)
   * @param filesIdSpecified  (optional)
   * @param filesIdIn  (optional)
   * @param filesIdNotIn  (optional)
   * @param buyNGetMIdGreaterThan  (optional)
   * @param buyNGetMIdLessThan  (optional)
   * @param buyNGetMIdGreaterThanOrEqual  (optional)
   * @param buyNGetMIdLessThanOrEqual  (optional)
   * @param buyNGetMIdEquals  (optional)
   * @param buyNGetMIdNotEquals  (optional)
   * @param buyNGetMIdSpecified  (optional)
   * @param buyNGetMIdIn  (optional)
   * @param buyNGetMIdNotIn  (optional)
   * @param percentOffIdGreaterThan  (optional)
   * @param percentOffIdLessThan  (optional)
   * @param percentOffIdGreaterThanOrEqual  (optional)
   * @param percentOffIdLessThanOrEqual  (optional)
   * @param percentOffIdEquals  (optional)
   * @param percentOffIdNotEquals  (optional)
   * @param percentOffIdSpecified  (optional)
   * @param percentOffIdIn  (optional)
   * @param percentOffIdNotIn  (optional)
   * @param conditionsRIdGreaterThan  (optional)
   * @param conditionsRIdLessThan  (optional)
   * @param conditionsRIdGreaterThanOrEqual  (optional)
   * @param conditionsRIdLessThanOrEqual  (optional)
   * @param conditionsRIdEquals  (optional)
   * @param conditionsRIdNotEquals  (optional)
   * @param conditionsRIdSpecified  (optional)
   * @param conditionsRIdIn  (optional)
   * @param conditionsRIdNotIn  (optional)
   * @param conditionsDIdGreaterThan  (optional)
   * @param conditionsDIdLessThan  (optional)
   * @param conditionsDIdGreaterThanOrEqual  (optional)
   * @param conditionsDIdLessThanOrEqual  (optional)
   * @param conditionsDIdEquals  (optional)
   * @param conditionsDIdNotEquals  (optional)
   * @param conditionsDIdSpecified  (optional)
   * @param conditionsDIdIn  (optional)
   * @param conditionsDIdNotIn  (optional)
   * @param conditionsLocIdGreaterThan  (optional)
   * @param conditionsLocIdLessThan  (optional)
   * @param conditionsLocIdGreaterThanOrEqual  (optional)
   * @param conditionsLocIdLessThanOrEqual  (optional)
   * @param conditionsLocIdEquals  (optional)
   * @param conditionsLocIdNotEquals  (optional)
   * @param conditionsLocIdSpecified  (optional)
   * @param conditionsLocIdIn  (optional)
   * @param conditionsLocIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/promotions/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&code.contains={codeContains}&code.doesNotContain={codeDoesNotContain}&code.equals={codeEquals}&code.notEquals={codeNotEquals}&code.specified={codeSpecified}&code.in={codeIn}&code.notIn={codeNotIn}&description.contains={descriptionContains}&description.doesNotContain={descriptionDoesNotContain}&description.equals={descriptionEquals}&description.notEquals={descriptionNotEquals}&description.specified={descriptionSpecified}&description.in={descriptionIn}&description.notIn={descriptionNotIn}&startDate.greaterThan={startDateGreaterThan}&startDate.lessThan={startDateLessThan}&startDate.greaterThanOrEqual={startDateGreaterThanOrEqual}&startDate.lessThanOrEqual={startDateLessThanOrEqual}&startDate.equals={startDateEquals}&startDate.notEquals={startDateNotEquals}&startDate.specified={startDateSpecified}&startDate.in={startDateIn}&startDate.notIn={startDateNotIn}&endDate.greaterThan={endDateGreaterThan}&endDate.lessThan={endDateLessThan}&endDate.greaterThanOrEqual={endDateGreaterThanOrEqual}&endDate.lessThanOrEqual={endDateLessThanOrEqual}&endDate.equals={endDateEquals}&endDate.notEquals={endDateNotEquals}&endDate.specified={endDateSpecified}&endDate.in={endDateIn}&endDate.notIn={endDateNotIn}&usageLimit.greaterThan={usageLimitGreaterThan}&usageLimit.lessThan={usageLimitLessThan}&usageLimit.greaterThanOrEqual={usageLimitGreaterThanOrEqual}&usageLimit.lessThanOrEqual={usageLimitLessThanOrEqual}&usageLimit.equals={usageLimitEquals}&usageLimit.notEquals={usageLimitNotEquals}&usageLimit.specified={usageLimitSpecified}&usageLimit.in={usageLimitIn}&usageLimit.notIn={usageLimitNotIn}&usedCount.greaterThan={usedCountGreaterThan}&usedCount.lessThan={usedCountLessThan}&usedCount.greaterThanOrEqual={usedCountGreaterThanOrEqual}&usedCount.lessThanOrEqual={usedCountLessThanOrEqual}&usedCount.equals={usedCountEquals}&usedCount.notEquals={usedCountNotEquals}&usedCount.specified={usedCountSpecified}&usedCount.in={usedCountIn}&usedCount.notIn={usedCountNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&filesId.greaterThan={filesIdGreaterThan}&filesId.lessThan={filesIdLessThan}&filesId.greaterThanOrEqual={filesIdGreaterThanOrEqual}&filesId.lessThanOrEqual={filesIdLessThanOrEqual}&filesId.equals={filesIdEquals}&filesId.notEquals={filesIdNotEquals}&filesId.specified={filesIdSpecified}&filesId.in={filesIdIn}&filesId.notIn={filesIdNotIn}&buyNGetMId.greaterThan={buyNGetMIdGreaterThan}&buyNGetMId.lessThan={buyNGetMIdLessThan}&buyNGetMId.greaterThanOrEqual={buyNGetMIdGreaterThanOrEqual}&buyNGetMId.lessThanOrEqual={buyNGetMIdLessThanOrEqual}&buyNGetMId.equals={buyNGetMIdEquals}&buyNGetMId.notEquals={buyNGetMIdNotEquals}&buyNGetMId.specified={buyNGetMIdSpecified}&buyNGetMId.in={buyNGetMIdIn}&buyNGetMId.notIn={buyNGetMIdNotIn}&percentOffId.greaterThan={percentOffIdGreaterThan}&percentOffId.lessThan={percentOffIdLessThan}&percentOffId.greaterThanOrEqual={percentOffIdGreaterThanOrEqual}&percentOffId.lessThanOrEqual={percentOffIdLessThanOrEqual}&percentOffId.equals={percentOffIdEquals}&percentOffId.notEquals={percentOffIdNotEquals}&percentOffId.specified={percentOffIdSpecified}&percentOffId.in={percentOffIdIn}&percentOffId.notIn={percentOffIdNotIn}&conditionsRId.greaterThan={conditionsRIdGreaterThan}&conditionsRId.lessThan={conditionsRIdLessThan}&conditionsRId.greaterThanOrEqual={conditionsRIdGreaterThanOrEqual}&conditionsRId.lessThanOrEqual={conditionsRIdLessThanOrEqual}&conditionsRId.equals={conditionsRIdEquals}&conditionsRId.notEquals={conditionsRIdNotEquals}&conditionsRId.specified={conditionsRIdSpecified}&conditionsRId.in={conditionsRIdIn}&conditionsRId.notIn={conditionsRIdNotIn}&conditionsDId.greaterThan={conditionsDIdGreaterThan}&conditionsDId.lessThan={conditionsDIdLessThan}&conditionsDId.greaterThanOrEqual={conditionsDIdGreaterThanOrEqual}&conditionsDId.lessThanOrEqual={conditionsDIdLessThanOrEqual}&conditionsDId.equals={conditionsDIdEquals}&conditionsDId.notEquals={conditionsDIdNotEquals}&conditionsDId.specified={conditionsDIdSpecified}&conditionsDId.in={conditionsDIdIn}&conditionsDId.notIn={conditionsDIdNotIn}&conditionsLocId.greaterThan={conditionsLocIdGreaterThan}&conditionsLocId.lessThan={conditionsLocIdLessThan}&conditionsLocId.greaterThanOrEqual={conditionsLocIdGreaterThanOrEqual}&conditionsLocId.lessThanOrEqual={conditionsLocIdLessThanOrEqual}&conditionsLocId.equals={conditionsLocIdEquals}&conditionsLocId.notEquals={conditionsLocIdNotEquals}&conditionsLocId.specified={conditionsLocIdSpecified}&conditionsLocId.in={conditionsLocIdIn}&conditionsLocId.notIn={conditionsLocIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Long> countPromotionsWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("codeContains") @jakarta.annotation.Nullable String codeContains, @Param("codeDoesNotContain") @jakarta.annotation.Nullable String codeDoesNotContain, @Param("codeEquals") @jakarta.annotation.Nullable String codeEquals, @Param("codeNotEquals") @jakarta.annotation.Nullable String codeNotEquals, @Param("codeSpecified") @jakarta.annotation.Nullable Boolean codeSpecified, @Param("codeIn") @jakarta.annotation.Nullable List<String> codeIn, @Param("codeNotIn") @jakarta.annotation.Nullable List<String> codeNotIn, @Param("descriptionContains") @jakarta.annotation.Nullable String descriptionContains, @Param("descriptionDoesNotContain") @jakarta.annotation.Nullable String descriptionDoesNotContain, @Param("descriptionEquals") @jakarta.annotation.Nullable String descriptionEquals, @Param("descriptionNotEquals") @jakarta.annotation.Nullable String descriptionNotEquals, @Param("descriptionSpecified") @jakarta.annotation.Nullable Boolean descriptionSpecified, @Param("descriptionIn") @jakarta.annotation.Nullable List<String> descriptionIn, @Param("descriptionNotIn") @jakarta.annotation.Nullable List<String> descriptionNotIn, @Param("startDateGreaterThan") @jakarta.annotation.Nullable LocalDate startDateGreaterThan, @Param("startDateLessThan") @jakarta.annotation.Nullable LocalDate startDateLessThan, @Param("startDateGreaterThanOrEqual") @jakarta.annotation.Nullable LocalDate startDateGreaterThanOrEqual, @Param("startDateLessThanOrEqual") @jakarta.annotation.Nullable LocalDate startDateLessThanOrEqual, @Param("startDateEquals") @jakarta.annotation.Nullable LocalDate startDateEquals, @Param("startDateNotEquals") @jakarta.annotation.Nullable LocalDate startDateNotEquals, @Param("startDateSpecified") @jakarta.annotation.Nullable Boolean startDateSpecified, @Param("startDateIn") @jakarta.annotation.Nullable List<LocalDate> startDateIn, @Param("startDateNotIn") @jakarta.annotation.Nullable List<LocalDate> startDateNotIn, @Param("endDateGreaterThan") @jakarta.annotation.Nullable LocalDate endDateGreaterThan, @Param("endDateLessThan") @jakarta.annotation.Nullable LocalDate endDateLessThan, @Param("endDateGreaterThanOrEqual") @jakarta.annotation.Nullable LocalDate endDateGreaterThanOrEqual, @Param("endDateLessThanOrEqual") @jakarta.annotation.Nullable LocalDate endDateLessThanOrEqual, @Param("endDateEquals") @jakarta.annotation.Nullable LocalDate endDateEquals, @Param("endDateNotEquals") @jakarta.annotation.Nullable LocalDate endDateNotEquals, @Param("endDateSpecified") @jakarta.annotation.Nullable Boolean endDateSpecified, @Param("endDateIn") @jakarta.annotation.Nullable List<LocalDate> endDateIn, @Param("endDateNotIn") @jakarta.annotation.Nullable List<LocalDate> endDateNotIn, @Param("usageLimitGreaterThan") @jakarta.annotation.Nullable Integer usageLimitGreaterThan, @Param("usageLimitLessThan") @jakarta.annotation.Nullable Integer usageLimitLessThan, @Param("usageLimitGreaterThanOrEqual") @jakarta.annotation.Nullable Integer usageLimitGreaterThanOrEqual, @Param("usageLimitLessThanOrEqual") @jakarta.annotation.Nullable Integer usageLimitLessThanOrEqual, @Param("usageLimitEquals") @jakarta.annotation.Nullable Integer usageLimitEquals, @Param("usageLimitNotEquals") @jakarta.annotation.Nullable Integer usageLimitNotEquals, @Param("usageLimitSpecified") @jakarta.annotation.Nullable Boolean usageLimitSpecified, @Param("usageLimitIn") @jakarta.annotation.Nullable List<Integer> usageLimitIn, @Param("usageLimitNotIn") @jakarta.annotation.Nullable List<Integer> usageLimitNotIn, @Param("usedCountGreaterThan") @jakarta.annotation.Nullable Integer usedCountGreaterThan, @Param("usedCountLessThan") @jakarta.annotation.Nullable Integer usedCountLessThan, @Param("usedCountGreaterThanOrEqual") @jakarta.annotation.Nullable Integer usedCountGreaterThanOrEqual, @Param("usedCountLessThanOrEqual") @jakarta.annotation.Nullable Integer usedCountLessThanOrEqual, @Param("usedCountEquals") @jakarta.annotation.Nullable Integer usedCountEquals, @Param("usedCountNotEquals") @jakarta.annotation.Nullable Integer usedCountNotEquals, @Param("usedCountSpecified") @jakarta.annotation.Nullable Boolean usedCountSpecified, @Param("usedCountIn") @jakarta.annotation.Nullable List<Integer> usedCountIn, @Param("usedCountNotIn") @jakarta.annotation.Nullable List<Integer> usedCountNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("filesIdGreaterThan") @jakarta.annotation.Nullable Long filesIdGreaterThan, @Param("filesIdLessThan") @jakarta.annotation.Nullable Long filesIdLessThan, @Param("filesIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long filesIdGreaterThanOrEqual, @Param("filesIdLessThanOrEqual") @jakarta.annotation.Nullable Long filesIdLessThanOrEqual, @Param("filesIdEquals") @jakarta.annotation.Nullable Long filesIdEquals, @Param("filesIdNotEquals") @jakarta.annotation.Nullable Long filesIdNotEquals, @Param("filesIdSpecified") @jakarta.annotation.Nullable Boolean filesIdSpecified, @Param("filesIdIn") @jakarta.annotation.Nullable List<Long> filesIdIn, @Param("filesIdNotIn") @jakarta.annotation.Nullable List<Long> filesIdNotIn, @Param("buyNGetMIdGreaterThan") @jakarta.annotation.Nullable Long buyNGetMIdGreaterThan, @Param("buyNGetMIdLessThan") @jakarta.annotation.Nullable Long buyNGetMIdLessThan, @Param("buyNGetMIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long buyNGetMIdGreaterThanOrEqual, @Param("buyNGetMIdLessThanOrEqual") @jakarta.annotation.Nullable Long buyNGetMIdLessThanOrEqual, @Param("buyNGetMIdEquals") @jakarta.annotation.Nullable Long buyNGetMIdEquals, @Param("buyNGetMIdNotEquals") @jakarta.annotation.Nullable Long buyNGetMIdNotEquals, @Param("buyNGetMIdSpecified") @jakarta.annotation.Nullable Boolean buyNGetMIdSpecified, @Param("buyNGetMIdIn") @jakarta.annotation.Nullable List<Long> buyNGetMIdIn, @Param("buyNGetMIdNotIn") @jakarta.annotation.Nullable List<Long> buyNGetMIdNotIn, @Param("percentOffIdGreaterThan") @jakarta.annotation.Nullable Long percentOffIdGreaterThan, @Param("percentOffIdLessThan") @jakarta.annotation.Nullable Long percentOffIdLessThan, @Param("percentOffIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long percentOffIdGreaterThanOrEqual, @Param("percentOffIdLessThanOrEqual") @jakarta.annotation.Nullable Long percentOffIdLessThanOrEqual, @Param("percentOffIdEquals") @jakarta.annotation.Nullable Long percentOffIdEquals, @Param("percentOffIdNotEquals") @jakarta.annotation.Nullable Long percentOffIdNotEquals, @Param("percentOffIdSpecified") @jakarta.annotation.Nullable Boolean percentOffIdSpecified, @Param("percentOffIdIn") @jakarta.annotation.Nullable List<Long> percentOffIdIn, @Param("percentOffIdNotIn") @jakarta.annotation.Nullable List<Long> percentOffIdNotIn, @Param("conditionsRIdGreaterThan") @jakarta.annotation.Nullable Long conditionsRIdGreaterThan, @Param("conditionsRIdLessThan") @jakarta.annotation.Nullable Long conditionsRIdLessThan, @Param("conditionsRIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long conditionsRIdGreaterThanOrEqual, @Param("conditionsRIdLessThanOrEqual") @jakarta.annotation.Nullable Long conditionsRIdLessThanOrEqual, @Param("conditionsRIdEquals") @jakarta.annotation.Nullable Long conditionsRIdEquals, @Param("conditionsRIdNotEquals") @jakarta.annotation.Nullable Long conditionsRIdNotEquals, @Param("conditionsRIdSpecified") @jakarta.annotation.Nullable Boolean conditionsRIdSpecified, @Param("conditionsRIdIn") @jakarta.annotation.Nullable List<Long> conditionsRIdIn, @Param("conditionsRIdNotIn") @jakarta.annotation.Nullable List<Long> conditionsRIdNotIn, @Param("conditionsDIdGreaterThan") @jakarta.annotation.Nullable Long conditionsDIdGreaterThan, @Param("conditionsDIdLessThan") @jakarta.annotation.Nullable Long conditionsDIdLessThan, @Param("conditionsDIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long conditionsDIdGreaterThanOrEqual, @Param("conditionsDIdLessThanOrEqual") @jakarta.annotation.Nullable Long conditionsDIdLessThanOrEqual, @Param("conditionsDIdEquals") @jakarta.annotation.Nullable Long conditionsDIdEquals, @Param("conditionsDIdNotEquals") @jakarta.annotation.Nullable Long conditionsDIdNotEquals, @Param("conditionsDIdSpecified") @jakarta.annotation.Nullable Boolean conditionsDIdSpecified, @Param("conditionsDIdIn") @jakarta.annotation.Nullable List<Long> conditionsDIdIn, @Param("conditionsDIdNotIn") @jakarta.annotation.Nullable List<Long> conditionsDIdNotIn, @Param("conditionsLocIdGreaterThan") @jakarta.annotation.Nullable Long conditionsLocIdGreaterThan, @Param("conditionsLocIdLessThan") @jakarta.annotation.Nullable Long conditionsLocIdLessThan, @Param("conditionsLocIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long conditionsLocIdGreaterThanOrEqual, @Param("conditionsLocIdLessThanOrEqual") @jakarta.annotation.Nullable Long conditionsLocIdLessThanOrEqual, @Param("conditionsLocIdEquals") @jakarta.annotation.Nullable Long conditionsLocIdEquals, @Param("conditionsLocIdNotEquals") @jakarta.annotation.Nullable Long conditionsLocIdNotEquals, @Param("conditionsLocIdSpecified") @jakarta.annotation.Nullable Boolean conditionsLocIdSpecified, @Param("conditionsLocIdIn") @jakarta.annotation.Nullable List<Long> conditionsLocIdIn, @Param("conditionsLocIdNotIn") @jakarta.annotation.Nullable List<Long> conditionsLocIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>countPromotions</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CountPromotionsQueryParams} class that allows for
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
   *   <li>codeContains -  (optional)</li>
   *   <li>codeDoesNotContain -  (optional)</li>
   *   <li>codeEquals -  (optional)</li>
   *   <li>codeNotEquals -  (optional)</li>
   *   <li>codeSpecified -  (optional)</li>
   *   <li>codeIn -  (optional)</li>
   *   <li>codeNotIn -  (optional)</li>
   *   <li>descriptionContains -  (optional)</li>
   *   <li>descriptionDoesNotContain -  (optional)</li>
   *   <li>descriptionEquals -  (optional)</li>
   *   <li>descriptionNotEquals -  (optional)</li>
   *   <li>descriptionSpecified -  (optional)</li>
   *   <li>descriptionIn -  (optional)</li>
   *   <li>descriptionNotIn -  (optional)</li>
   *   <li>startDateGreaterThan -  (optional)</li>
   *   <li>startDateLessThan -  (optional)</li>
   *   <li>startDateGreaterThanOrEqual -  (optional)</li>
   *   <li>startDateLessThanOrEqual -  (optional)</li>
   *   <li>startDateEquals -  (optional)</li>
   *   <li>startDateNotEquals -  (optional)</li>
   *   <li>startDateSpecified -  (optional)</li>
   *   <li>startDateIn -  (optional)</li>
   *   <li>startDateNotIn -  (optional)</li>
   *   <li>endDateGreaterThan -  (optional)</li>
   *   <li>endDateLessThan -  (optional)</li>
   *   <li>endDateGreaterThanOrEqual -  (optional)</li>
   *   <li>endDateLessThanOrEqual -  (optional)</li>
   *   <li>endDateEquals -  (optional)</li>
   *   <li>endDateNotEquals -  (optional)</li>
   *   <li>endDateSpecified -  (optional)</li>
   *   <li>endDateIn -  (optional)</li>
   *   <li>endDateNotIn -  (optional)</li>
   *   <li>usageLimitGreaterThan -  (optional)</li>
   *   <li>usageLimitLessThan -  (optional)</li>
   *   <li>usageLimitGreaterThanOrEqual -  (optional)</li>
   *   <li>usageLimitLessThanOrEqual -  (optional)</li>
   *   <li>usageLimitEquals -  (optional)</li>
   *   <li>usageLimitNotEquals -  (optional)</li>
   *   <li>usageLimitSpecified -  (optional)</li>
   *   <li>usageLimitIn -  (optional)</li>
   *   <li>usageLimitNotIn -  (optional)</li>
   *   <li>usedCountGreaterThan -  (optional)</li>
   *   <li>usedCountLessThan -  (optional)</li>
   *   <li>usedCountGreaterThanOrEqual -  (optional)</li>
   *   <li>usedCountLessThanOrEqual -  (optional)</li>
   *   <li>usedCountEquals -  (optional)</li>
   *   <li>usedCountNotEquals -  (optional)</li>
   *   <li>usedCountSpecified -  (optional)</li>
   *   <li>usedCountIn -  (optional)</li>
   *   <li>usedCountNotIn -  (optional)</li>
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
   *   <li>filesIdGreaterThan -  (optional)</li>
   *   <li>filesIdLessThan -  (optional)</li>
   *   <li>filesIdGreaterThanOrEqual -  (optional)</li>
   *   <li>filesIdLessThanOrEqual -  (optional)</li>
   *   <li>filesIdEquals -  (optional)</li>
   *   <li>filesIdNotEquals -  (optional)</li>
   *   <li>filesIdSpecified -  (optional)</li>
   *   <li>filesIdIn -  (optional)</li>
   *   <li>filesIdNotIn -  (optional)</li>
   *   <li>buyNGetMIdGreaterThan -  (optional)</li>
   *   <li>buyNGetMIdLessThan -  (optional)</li>
   *   <li>buyNGetMIdGreaterThanOrEqual -  (optional)</li>
   *   <li>buyNGetMIdLessThanOrEqual -  (optional)</li>
   *   <li>buyNGetMIdEquals -  (optional)</li>
   *   <li>buyNGetMIdNotEquals -  (optional)</li>
   *   <li>buyNGetMIdSpecified -  (optional)</li>
   *   <li>buyNGetMIdIn -  (optional)</li>
   *   <li>buyNGetMIdNotIn -  (optional)</li>
   *   <li>percentOffIdGreaterThan -  (optional)</li>
   *   <li>percentOffIdLessThan -  (optional)</li>
   *   <li>percentOffIdGreaterThanOrEqual -  (optional)</li>
   *   <li>percentOffIdLessThanOrEqual -  (optional)</li>
   *   <li>percentOffIdEquals -  (optional)</li>
   *   <li>percentOffIdNotEquals -  (optional)</li>
   *   <li>percentOffIdSpecified -  (optional)</li>
   *   <li>percentOffIdIn -  (optional)</li>
   *   <li>percentOffIdNotIn -  (optional)</li>
   *   <li>conditionsRIdGreaterThan -  (optional)</li>
   *   <li>conditionsRIdLessThan -  (optional)</li>
   *   <li>conditionsRIdGreaterThanOrEqual -  (optional)</li>
   *   <li>conditionsRIdLessThanOrEqual -  (optional)</li>
   *   <li>conditionsRIdEquals -  (optional)</li>
   *   <li>conditionsRIdNotEquals -  (optional)</li>
   *   <li>conditionsRIdSpecified -  (optional)</li>
   *   <li>conditionsRIdIn -  (optional)</li>
   *   <li>conditionsRIdNotIn -  (optional)</li>
   *   <li>conditionsDIdGreaterThan -  (optional)</li>
   *   <li>conditionsDIdLessThan -  (optional)</li>
   *   <li>conditionsDIdGreaterThanOrEqual -  (optional)</li>
   *   <li>conditionsDIdLessThanOrEqual -  (optional)</li>
   *   <li>conditionsDIdEquals -  (optional)</li>
   *   <li>conditionsDIdNotEquals -  (optional)</li>
   *   <li>conditionsDIdSpecified -  (optional)</li>
   *   <li>conditionsDIdIn -  (optional)</li>
   *   <li>conditionsDIdNotIn -  (optional)</li>
   *   <li>conditionsLocIdGreaterThan -  (optional)</li>
   *   <li>conditionsLocIdLessThan -  (optional)</li>
   *   <li>conditionsLocIdGreaterThanOrEqual -  (optional)</li>
   *   <li>conditionsLocIdLessThanOrEqual -  (optional)</li>
   *   <li>conditionsLocIdEquals -  (optional)</li>
   *   <li>conditionsLocIdNotEquals -  (optional)</li>
   *   <li>conditionsLocIdSpecified -  (optional)</li>
   *   <li>conditionsLocIdIn -  (optional)</li>
   *   <li>conditionsLocIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return Long
   */
  @RequestLine("GET /api/promotions/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&code.contains={codeContains}&code.doesNotContain={codeDoesNotContain}&code.equals={codeEquals}&code.notEquals={codeNotEquals}&code.specified={codeSpecified}&code.in={codeIn}&code.notIn={codeNotIn}&description.contains={descriptionContains}&description.doesNotContain={descriptionDoesNotContain}&description.equals={descriptionEquals}&description.notEquals={descriptionNotEquals}&description.specified={descriptionSpecified}&description.in={descriptionIn}&description.notIn={descriptionNotIn}&startDate.greaterThan={startDateGreaterThan}&startDate.lessThan={startDateLessThan}&startDate.greaterThanOrEqual={startDateGreaterThanOrEqual}&startDate.lessThanOrEqual={startDateLessThanOrEqual}&startDate.equals={startDateEquals}&startDate.notEquals={startDateNotEquals}&startDate.specified={startDateSpecified}&startDate.in={startDateIn}&startDate.notIn={startDateNotIn}&endDate.greaterThan={endDateGreaterThan}&endDate.lessThan={endDateLessThan}&endDate.greaterThanOrEqual={endDateGreaterThanOrEqual}&endDate.lessThanOrEqual={endDateLessThanOrEqual}&endDate.equals={endDateEquals}&endDate.notEquals={endDateNotEquals}&endDate.specified={endDateSpecified}&endDate.in={endDateIn}&endDate.notIn={endDateNotIn}&usageLimit.greaterThan={usageLimitGreaterThan}&usageLimit.lessThan={usageLimitLessThan}&usageLimit.greaterThanOrEqual={usageLimitGreaterThanOrEqual}&usageLimit.lessThanOrEqual={usageLimitLessThanOrEqual}&usageLimit.equals={usageLimitEquals}&usageLimit.notEquals={usageLimitNotEquals}&usageLimit.specified={usageLimitSpecified}&usageLimit.in={usageLimitIn}&usageLimit.notIn={usageLimitNotIn}&usedCount.greaterThan={usedCountGreaterThan}&usedCount.lessThan={usedCountLessThan}&usedCount.greaterThanOrEqual={usedCountGreaterThanOrEqual}&usedCount.lessThanOrEqual={usedCountLessThanOrEqual}&usedCount.equals={usedCountEquals}&usedCount.notEquals={usedCountNotEquals}&usedCount.specified={usedCountSpecified}&usedCount.in={usedCountIn}&usedCount.notIn={usedCountNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&filesId.greaterThan={filesIdGreaterThan}&filesId.lessThan={filesIdLessThan}&filesId.greaterThanOrEqual={filesIdGreaterThanOrEqual}&filesId.lessThanOrEqual={filesIdLessThanOrEqual}&filesId.equals={filesIdEquals}&filesId.notEquals={filesIdNotEquals}&filesId.specified={filesIdSpecified}&filesId.in={filesIdIn}&filesId.notIn={filesIdNotIn}&buyNGetMId.greaterThan={buyNGetMIdGreaterThan}&buyNGetMId.lessThan={buyNGetMIdLessThan}&buyNGetMId.greaterThanOrEqual={buyNGetMIdGreaterThanOrEqual}&buyNGetMId.lessThanOrEqual={buyNGetMIdLessThanOrEqual}&buyNGetMId.equals={buyNGetMIdEquals}&buyNGetMId.notEquals={buyNGetMIdNotEquals}&buyNGetMId.specified={buyNGetMIdSpecified}&buyNGetMId.in={buyNGetMIdIn}&buyNGetMId.notIn={buyNGetMIdNotIn}&percentOffId.greaterThan={percentOffIdGreaterThan}&percentOffId.lessThan={percentOffIdLessThan}&percentOffId.greaterThanOrEqual={percentOffIdGreaterThanOrEqual}&percentOffId.lessThanOrEqual={percentOffIdLessThanOrEqual}&percentOffId.equals={percentOffIdEquals}&percentOffId.notEquals={percentOffIdNotEquals}&percentOffId.specified={percentOffIdSpecified}&percentOffId.in={percentOffIdIn}&percentOffId.notIn={percentOffIdNotIn}&conditionsRId.greaterThan={conditionsRIdGreaterThan}&conditionsRId.lessThan={conditionsRIdLessThan}&conditionsRId.greaterThanOrEqual={conditionsRIdGreaterThanOrEqual}&conditionsRId.lessThanOrEqual={conditionsRIdLessThanOrEqual}&conditionsRId.equals={conditionsRIdEquals}&conditionsRId.notEquals={conditionsRIdNotEquals}&conditionsRId.specified={conditionsRIdSpecified}&conditionsRId.in={conditionsRIdIn}&conditionsRId.notIn={conditionsRIdNotIn}&conditionsDId.greaterThan={conditionsDIdGreaterThan}&conditionsDId.lessThan={conditionsDIdLessThan}&conditionsDId.greaterThanOrEqual={conditionsDIdGreaterThanOrEqual}&conditionsDId.lessThanOrEqual={conditionsDIdLessThanOrEqual}&conditionsDId.equals={conditionsDIdEquals}&conditionsDId.notEquals={conditionsDIdNotEquals}&conditionsDId.specified={conditionsDIdSpecified}&conditionsDId.in={conditionsDIdIn}&conditionsDId.notIn={conditionsDIdNotIn}&conditionsLocId.greaterThan={conditionsLocIdGreaterThan}&conditionsLocId.lessThan={conditionsLocIdLessThan}&conditionsLocId.greaterThanOrEqual={conditionsLocIdGreaterThanOrEqual}&conditionsLocId.lessThanOrEqual={conditionsLocIdLessThanOrEqual}&conditionsLocId.equals={conditionsLocIdEquals}&conditionsLocId.notEquals={conditionsLocIdNotEquals}&conditionsLocId.specified={conditionsLocIdSpecified}&conditionsLocId.in={conditionsLocIdIn}&conditionsLocId.notIn={conditionsLocIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  Long countPromotions(@QueryMap(encoded=true) CountPromotionsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>countPromotions</code> that receives the query parameters as a map,
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
          *   <li>codeContains -  (optional)</li>
          *   <li>codeDoesNotContain -  (optional)</li>
          *   <li>codeEquals -  (optional)</li>
          *   <li>codeNotEquals -  (optional)</li>
          *   <li>codeSpecified -  (optional)</li>
          *   <li>codeIn -  (optional)</li>
          *   <li>codeNotIn -  (optional)</li>
          *   <li>descriptionContains -  (optional)</li>
          *   <li>descriptionDoesNotContain -  (optional)</li>
          *   <li>descriptionEquals -  (optional)</li>
          *   <li>descriptionNotEquals -  (optional)</li>
          *   <li>descriptionSpecified -  (optional)</li>
          *   <li>descriptionIn -  (optional)</li>
          *   <li>descriptionNotIn -  (optional)</li>
          *   <li>startDateGreaterThan -  (optional)</li>
          *   <li>startDateLessThan -  (optional)</li>
          *   <li>startDateGreaterThanOrEqual -  (optional)</li>
          *   <li>startDateLessThanOrEqual -  (optional)</li>
          *   <li>startDateEquals -  (optional)</li>
          *   <li>startDateNotEquals -  (optional)</li>
          *   <li>startDateSpecified -  (optional)</li>
          *   <li>startDateIn -  (optional)</li>
          *   <li>startDateNotIn -  (optional)</li>
          *   <li>endDateGreaterThan -  (optional)</li>
          *   <li>endDateLessThan -  (optional)</li>
          *   <li>endDateGreaterThanOrEqual -  (optional)</li>
          *   <li>endDateLessThanOrEqual -  (optional)</li>
          *   <li>endDateEquals -  (optional)</li>
          *   <li>endDateNotEquals -  (optional)</li>
          *   <li>endDateSpecified -  (optional)</li>
          *   <li>endDateIn -  (optional)</li>
          *   <li>endDateNotIn -  (optional)</li>
          *   <li>usageLimitGreaterThan -  (optional)</li>
          *   <li>usageLimitLessThan -  (optional)</li>
          *   <li>usageLimitGreaterThanOrEqual -  (optional)</li>
          *   <li>usageLimitLessThanOrEqual -  (optional)</li>
          *   <li>usageLimitEquals -  (optional)</li>
          *   <li>usageLimitNotEquals -  (optional)</li>
          *   <li>usageLimitSpecified -  (optional)</li>
          *   <li>usageLimitIn -  (optional)</li>
          *   <li>usageLimitNotIn -  (optional)</li>
          *   <li>usedCountGreaterThan -  (optional)</li>
          *   <li>usedCountLessThan -  (optional)</li>
          *   <li>usedCountGreaterThanOrEqual -  (optional)</li>
          *   <li>usedCountLessThanOrEqual -  (optional)</li>
          *   <li>usedCountEquals -  (optional)</li>
          *   <li>usedCountNotEquals -  (optional)</li>
          *   <li>usedCountSpecified -  (optional)</li>
          *   <li>usedCountIn -  (optional)</li>
          *   <li>usedCountNotIn -  (optional)</li>
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
          *   <li>filesIdGreaterThan -  (optional)</li>
          *   <li>filesIdLessThan -  (optional)</li>
          *   <li>filesIdGreaterThanOrEqual -  (optional)</li>
          *   <li>filesIdLessThanOrEqual -  (optional)</li>
          *   <li>filesIdEquals -  (optional)</li>
          *   <li>filesIdNotEquals -  (optional)</li>
          *   <li>filesIdSpecified -  (optional)</li>
          *   <li>filesIdIn -  (optional)</li>
          *   <li>filesIdNotIn -  (optional)</li>
          *   <li>buyNGetMIdGreaterThan -  (optional)</li>
          *   <li>buyNGetMIdLessThan -  (optional)</li>
          *   <li>buyNGetMIdGreaterThanOrEqual -  (optional)</li>
          *   <li>buyNGetMIdLessThanOrEqual -  (optional)</li>
          *   <li>buyNGetMIdEquals -  (optional)</li>
          *   <li>buyNGetMIdNotEquals -  (optional)</li>
          *   <li>buyNGetMIdSpecified -  (optional)</li>
          *   <li>buyNGetMIdIn -  (optional)</li>
          *   <li>buyNGetMIdNotIn -  (optional)</li>
          *   <li>percentOffIdGreaterThan -  (optional)</li>
          *   <li>percentOffIdLessThan -  (optional)</li>
          *   <li>percentOffIdGreaterThanOrEqual -  (optional)</li>
          *   <li>percentOffIdLessThanOrEqual -  (optional)</li>
          *   <li>percentOffIdEquals -  (optional)</li>
          *   <li>percentOffIdNotEquals -  (optional)</li>
          *   <li>percentOffIdSpecified -  (optional)</li>
          *   <li>percentOffIdIn -  (optional)</li>
          *   <li>percentOffIdNotIn -  (optional)</li>
          *   <li>conditionsRIdGreaterThan -  (optional)</li>
          *   <li>conditionsRIdLessThan -  (optional)</li>
          *   <li>conditionsRIdGreaterThanOrEqual -  (optional)</li>
          *   <li>conditionsRIdLessThanOrEqual -  (optional)</li>
          *   <li>conditionsRIdEquals -  (optional)</li>
          *   <li>conditionsRIdNotEquals -  (optional)</li>
          *   <li>conditionsRIdSpecified -  (optional)</li>
          *   <li>conditionsRIdIn -  (optional)</li>
          *   <li>conditionsRIdNotIn -  (optional)</li>
          *   <li>conditionsDIdGreaterThan -  (optional)</li>
          *   <li>conditionsDIdLessThan -  (optional)</li>
          *   <li>conditionsDIdGreaterThanOrEqual -  (optional)</li>
          *   <li>conditionsDIdLessThanOrEqual -  (optional)</li>
          *   <li>conditionsDIdEquals -  (optional)</li>
          *   <li>conditionsDIdNotEquals -  (optional)</li>
          *   <li>conditionsDIdSpecified -  (optional)</li>
          *   <li>conditionsDIdIn -  (optional)</li>
          *   <li>conditionsDIdNotIn -  (optional)</li>
          *   <li>conditionsLocIdGreaterThan -  (optional)</li>
          *   <li>conditionsLocIdLessThan -  (optional)</li>
          *   <li>conditionsLocIdGreaterThanOrEqual -  (optional)</li>
          *   <li>conditionsLocIdLessThanOrEqual -  (optional)</li>
          *   <li>conditionsLocIdEquals -  (optional)</li>
          *   <li>conditionsLocIdNotEquals -  (optional)</li>
          *   <li>conditionsLocIdSpecified -  (optional)</li>
          *   <li>conditionsLocIdIn -  (optional)</li>
          *   <li>conditionsLocIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return Long
      */
      @RequestLine("GET /api/promotions/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&code.contains={codeContains}&code.doesNotContain={codeDoesNotContain}&code.equals={codeEquals}&code.notEquals={codeNotEquals}&code.specified={codeSpecified}&code.in={codeIn}&code.notIn={codeNotIn}&description.contains={descriptionContains}&description.doesNotContain={descriptionDoesNotContain}&description.equals={descriptionEquals}&description.notEquals={descriptionNotEquals}&description.specified={descriptionSpecified}&description.in={descriptionIn}&description.notIn={descriptionNotIn}&startDate.greaterThan={startDateGreaterThan}&startDate.lessThan={startDateLessThan}&startDate.greaterThanOrEqual={startDateGreaterThanOrEqual}&startDate.lessThanOrEqual={startDateLessThanOrEqual}&startDate.equals={startDateEquals}&startDate.notEquals={startDateNotEquals}&startDate.specified={startDateSpecified}&startDate.in={startDateIn}&startDate.notIn={startDateNotIn}&endDate.greaterThan={endDateGreaterThan}&endDate.lessThan={endDateLessThan}&endDate.greaterThanOrEqual={endDateGreaterThanOrEqual}&endDate.lessThanOrEqual={endDateLessThanOrEqual}&endDate.equals={endDateEquals}&endDate.notEquals={endDateNotEquals}&endDate.specified={endDateSpecified}&endDate.in={endDateIn}&endDate.notIn={endDateNotIn}&usageLimit.greaterThan={usageLimitGreaterThan}&usageLimit.lessThan={usageLimitLessThan}&usageLimit.greaterThanOrEqual={usageLimitGreaterThanOrEqual}&usageLimit.lessThanOrEqual={usageLimitLessThanOrEqual}&usageLimit.equals={usageLimitEquals}&usageLimit.notEquals={usageLimitNotEquals}&usageLimit.specified={usageLimitSpecified}&usageLimit.in={usageLimitIn}&usageLimit.notIn={usageLimitNotIn}&usedCount.greaterThan={usedCountGreaterThan}&usedCount.lessThan={usedCountLessThan}&usedCount.greaterThanOrEqual={usedCountGreaterThanOrEqual}&usedCount.lessThanOrEqual={usedCountLessThanOrEqual}&usedCount.equals={usedCountEquals}&usedCount.notEquals={usedCountNotEquals}&usedCount.specified={usedCountSpecified}&usedCount.in={usedCountIn}&usedCount.notIn={usedCountNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&filesId.greaterThan={filesIdGreaterThan}&filesId.lessThan={filesIdLessThan}&filesId.greaterThanOrEqual={filesIdGreaterThanOrEqual}&filesId.lessThanOrEqual={filesIdLessThanOrEqual}&filesId.equals={filesIdEquals}&filesId.notEquals={filesIdNotEquals}&filesId.specified={filesIdSpecified}&filesId.in={filesIdIn}&filesId.notIn={filesIdNotIn}&buyNGetMId.greaterThan={buyNGetMIdGreaterThan}&buyNGetMId.lessThan={buyNGetMIdLessThan}&buyNGetMId.greaterThanOrEqual={buyNGetMIdGreaterThanOrEqual}&buyNGetMId.lessThanOrEqual={buyNGetMIdLessThanOrEqual}&buyNGetMId.equals={buyNGetMIdEquals}&buyNGetMId.notEquals={buyNGetMIdNotEquals}&buyNGetMId.specified={buyNGetMIdSpecified}&buyNGetMId.in={buyNGetMIdIn}&buyNGetMId.notIn={buyNGetMIdNotIn}&percentOffId.greaterThan={percentOffIdGreaterThan}&percentOffId.lessThan={percentOffIdLessThan}&percentOffId.greaterThanOrEqual={percentOffIdGreaterThanOrEqual}&percentOffId.lessThanOrEqual={percentOffIdLessThanOrEqual}&percentOffId.equals={percentOffIdEquals}&percentOffId.notEquals={percentOffIdNotEquals}&percentOffId.specified={percentOffIdSpecified}&percentOffId.in={percentOffIdIn}&percentOffId.notIn={percentOffIdNotIn}&conditionsRId.greaterThan={conditionsRIdGreaterThan}&conditionsRId.lessThan={conditionsRIdLessThan}&conditionsRId.greaterThanOrEqual={conditionsRIdGreaterThanOrEqual}&conditionsRId.lessThanOrEqual={conditionsRIdLessThanOrEqual}&conditionsRId.equals={conditionsRIdEquals}&conditionsRId.notEquals={conditionsRIdNotEquals}&conditionsRId.specified={conditionsRIdSpecified}&conditionsRId.in={conditionsRIdIn}&conditionsRId.notIn={conditionsRIdNotIn}&conditionsDId.greaterThan={conditionsDIdGreaterThan}&conditionsDId.lessThan={conditionsDIdLessThan}&conditionsDId.greaterThanOrEqual={conditionsDIdGreaterThanOrEqual}&conditionsDId.lessThanOrEqual={conditionsDIdLessThanOrEqual}&conditionsDId.equals={conditionsDIdEquals}&conditionsDId.notEquals={conditionsDIdNotEquals}&conditionsDId.specified={conditionsDIdSpecified}&conditionsDId.in={conditionsDIdIn}&conditionsDId.notIn={conditionsDIdNotIn}&conditionsLocId.greaterThan={conditionsLocIdGreaterThan}&conditionsLocId.lessThan={conditionsLocIdLessThan}&conditionsLocId.greaterThanOrEqual={conditionsLocIdGreaterThanOrEqual}&conditionsLocId.lessThanOrEqual={conditionsLocIdLessThanOrEqual}&conditionsLocId.equals={conditionsLocIdEquals}&conditionsLocId.notEquals={conditionsLocIdNotEquals}&conditionsLocId.specified={conditionsLocIdSpecified}&conditionsLocId.in={conditionsLocIdIn}&conditionsLocId.notIn={conditionsLocIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Long> countPromotionsWithHttpInfo(@QueryMap(encoded=true) CountPromotionsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>countPromotions</code> method in a fluent style.
   */
  public static class CountPromotionsQueryParams extends HashMap<String, Object> {
    public CountPromotionsQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams codeContains(@jakarta.annotation.Nullable final String value) {
      put("code.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams codeDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("code.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams codeEquals(@jakarta.annotation.Nullable final String value) {
      put("code.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams codeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("code.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams codeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("code.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams codeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("code.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams codeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("code.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams descriptionContains(@jakarta.annotation.Nullable final String value) {
      put("description.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams descriptionDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("description.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams descriptionEquals(@jakarta.annotation.Nullable final String value) {
      put("description.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams descriptionNotEquals(@jakarta.annotation.Nullable final String value) {
      put("description.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams descriptionSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("description.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams descriptionIn(@jakarta.annotation.Nullable final List<String> value) {
      put("description.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams descriptionNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("description.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams startDateGreaterThan(@jakarta.annotation.Nullable final LocalDate value) {
      put("startDate.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams startDateLessThan(@jakarta.annotation.Nullable final LocalDate value) {
      put("startDate.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams startDateGreaterThanOrEqual(@jakarta.annotation.Nullable final LocalDate value) {
      put("startDate.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams startDateLessThanOrEqual(@jakarta.annotation.Nullable final LocalDate value) {
      put("startDate.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams startDateEquals(@jakarta.annotation.Nullable final LocalDate value) {
      put("startDate.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams startDateNotEquals(@jakarta.annotation.Nullable final LocalDate value) {
      put("startDate.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams startDateSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("startDate.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams startDateIn(@jakarta.annotation.Nullable final List<LocalDate> value) {
      put("startDate.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams startDateNotIn(@jakarta.annotation.Nullable final List<LocalDate> value) {
      put("startDate.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams endDateGreaterThan(@jakarta.annotation.Nullable final LocalDate value) {
      put("endDate.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams endDateLessThan(@jakarta.annotation.Nullable final LocalDate value) {
      put("endDate.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams endDateGreaterThanOrEqual(@jakarta.annotation.Nullable final LocalDate value) {
      put("endDate.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams endDateLessThanOrEqual(@jakarta.annotation.Nullable final LocalDate value) {
      put("endDate.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams endDateEquals(@jakarta.annotation.Nullable final LocalDate value) {
      put("endDate.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams endDateNotEquals(@jakarta.annotation.Nullable final LocalDate value) {
      put("endDate.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams endDateSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("endDate.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams endDateIn(@jakarta.annotation.Nullable final List<LocalDate> value) {
      put("endDate.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams endDateNotIn(@jakarta.annotation.Nullable final List<LocalDate> value) {
      put("endDate.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams usageLimitGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("usageLimit.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams usageLimitLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("usageLimit.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams usageLimitGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("usageLimit.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams usageLimitLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("usageLimit.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams usageLimitEquals(@jakarta.annotation.Nullable final Integer value) {
      put("usageLimit.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams usageLimitNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("usageLimit.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams usageLimitSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("usageLimit.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams usageLimitIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("usageLimit.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams usageLimitNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("usageLimit.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams usedCountGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("usedCount.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams usedCountLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("usedCount.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams usedCountGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("usedCount.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams usedCountLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("usedCount.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams usedCountEquals(@jakarta.annotation.Nullable final Integer value) {
      put("usedCount.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams usedCountNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("usedCount.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams usedCountSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("usedCount.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams usedCountIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("usedCount.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams usedCountNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("usedCount.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams filesIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("filesId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams filesIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("filesId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams filesIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("filesId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams filesIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("filesId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams filesIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("filesId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams filesIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("filesId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams filesIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("filesId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams filesIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("filesId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams filesIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("filesId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams buyNGetMIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("buyNGetMId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams buyNGetMIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("buyNGetMId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams buyNGetMIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("buyNGetMId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams buyNGetMIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("buyNGetMId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams buyNGetMIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("buyNGetMId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams buyNGetMIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("buyNGetMId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams buyNGetMIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("buyNGetMId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams buyNGetMIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("buyNGetMId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams buyNGetMIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("buyNGetMId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams percentOffIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("percentOffId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams percentOffIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("percentOffId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams percentOffIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("percentOffId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams percentOffIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("percentOffId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams percentOffIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("percentOffId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams percentOffIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("percentOffId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams percentOffIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("percentOffId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams percentOffIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("percentOffId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams percentOffIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("percentOffId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams conditionsRIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("conditionsRId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams conditionsRIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("conditionsRId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams conditionsRIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("conditionsRId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams conditionsRIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("conditionsRId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams conditionsRIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("conditionsRId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams conditionsRIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("conditionsRId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams conditionsRIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("conditionsRId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams conditionsRIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("conditionsRId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams conditionsRIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("conditionsRId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams conditionsDIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("conditionsDId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams conditionsDIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("conditionsDId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams conditionsDIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("conditionsDId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams conditionsDIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("conditionsDId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams conditionsDIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("conditionsDId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams conditionsDIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("conditionsDId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams conditionsDIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("conditionsDId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams conditionsDIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("conditionsDId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams conditionsDIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("conditionsDId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams conditionsLocIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("conditionsLocId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams conditionsLocIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("conditionsLocId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams conditionsLocIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("conditionsLocId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams conditionsLocIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("conditionsLocId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams conditionsLocIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("conditionsLocId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams conditionsLocIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("conditionsLocId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams conditionsLocIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("conditionsLocId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPromotionsQueryParams conditionsLocIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("conditionsLocId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams conditionsLocIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("conditionsLocId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPromotionsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param promotionDTO  (required)
   * @return PromotionDTO
   */
  @RequestLine("POST /api/promotions")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  PromotionDTO createPromotion(@jakarta.annotation.Nonnull PromotionDTO promotionDTO);

  /**
   * 
   * Similar to <code>createPromotion</code> but it also returns the http response headers .
   * 
   * @param promotionDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/promotions")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<PromotionDTO> createPromotionWithHttpInfo(@jakarta.annotation.Nonnull PromotionDTO promotionDTO);



  /**
   * 
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/promotions/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deletePromotion(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>deletePromotion</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/promotions/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deletePromotionWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return List&lt;PromotionDetailDTO&gt;
   */
  @RequestLine("GET /api/promotions/detail?page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",
  })
  List<PromotionDetailDTO> getAllPromotionDetails(@Param("page") @jakarta.annotation.Nullable Integer page, @Param("size") @jakarta.annotation.Nullable Integer size, @Param("sort") @jakarta.annotation.Nullable List<String> sort);

  /**
   * 
   * Similar to <code>getAllPromotionDetails</code> but it also returns the http response headers .
   * 
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/promotions/detail?page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<PromotionDetailDTO>> getAllPromotionDetailsWithHttpInfo(@Param("page") @jakarta.annotation.Nullable Integer page, @Param("size") @jakarta.annotation.Nullable Integer size, @Param("sort") @jakarta.annotation.Nullable List<String> sort);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllPromotionDetails</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllPromotionDetailsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>page - Zero-based page index (0..N) (optional, default to 0)</li>
   *   <li>size - The size of the page to be returned (optional, default to 20)</li>
   *   <li>sort - Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)</li>
   *   </ul>
   * @return List&lt;PromotionDetailDTO&gt;
   */
  @RequestLine("GET /api/promotions/detail?page={page}&size={size}&sort={sort}")
  @Headers({
  "Accept: */*",
  })
  List<PromotionDetailDTO> getAllPromotionDetails(@QueryMap(encoded=true) GetAllPromotionDetailsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllPromotionDetails</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>page - Zero-based page index (0..N) (optional, default to 0)</li>
          *   <li>size - The size of the page to be returned (optional, default to 20)</li>
          *   <li>sort - Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)</li>
      *   </ul>
          * @return List&lt;PromotionDetailDTO&gt;
      */
      @RequestLine("GET /api/promotions/detail?page={page}&size={size}&sort={sort}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<PromotionDetailDTO>> getAllPromotionDetailsWithHttpInfo(@QueryMap(encoded=true) GetAllPromotionDetailsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllPromotionDetails</code> method in a fluent style.
   */
  public static class GetAllPromotionDetailsQueryParams extends HashMap<String, Object> {
    public GetAllPromotionDetailsQueryParams page(@jakarta.annotation.Nullable final Integer value) {
      put("page", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionDetailsQueryParams size(@jakarta.annotation.Nullable final Integer value) {
      put("size", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionDetailsQueryParams sort(@jakarta.annotation.Nullable final List<String> value) {
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
   * @param codeContains  (optional)
   * @param codeDoesNotContain  (optional)
   * @param codeEquals  (optional)
   * @param codeNotEquals  (optional)
   * @param codeSpecified  (optional)
   * @param codeIn  (optional)
   * @param codeNotIn  (optional)
   * @param descriptionContains  (optional)
   * @param descriptionDoesNotContain  (optional)
   * @param descriptionEquals  (optional)
   * @param descriptionNotEquals  (optional)
   * @param descriptionSpecified  (optional)
   * @param descriptionIn  (optional)
   * @param descriptionNotIn  (optional)
   * @param startDateGreaterThan  (optional)
   * @param startDateLessThan  (optional)
   * @param startDateGreaterThanOrEqual  (optional)
   * @param startDateLessThanOrEqual  (optional)
   * @param startDateEquals  (optional)
   * @param startDateNotEquals  (optional)
   * @param startDateSpecified  (optional)
   * @param startDateIn  (optional)
   * @param startDateNotIn  (optional)
   * @param endDateGreaterThan  (optional)
   * @param endDateLessThan  (optional)
   * @param endDateGreaterThanOrEqual  (optional)
   * @param endDateLessThanOrEqual  (optional)
   * @param endDateEquals  (optional)
   * @param endDateNotEquals  (optional)
   * @param endDateSpecified  (optional)
   * @param endDateIn  (optional)
   * @param endDateNotIn  (optional)
   * @param usageLimitGreaterThan  (optional)
   * @param usageLimitLessThan  (optional)
   * @param usageLimitGreaterThanOrEqual  (optional)
   * @param usageLimitLessThanOrEqual  (optional)
   * @param usageLimitEquals  (optional)
   * @param usageLimitNotEquals  (optional)
   * @param usageLimitSpecified  (optional)
   * @param usageLimitIn  (optional)
   * @param usageLimitNotIn  (optional)
   * @param usedCountGreaterThan  (optional)
   * @param usedCountLessThan  (optional)
   * @param usedCountGreaterThanOrEqual  (optional)
   * @param usedCountLessThanOrEqual  (optional)
   * @param usedCountEquals  (optional)
   * @param usedCountNotEquals  (optional)
   * @param usedCountSpecified  (optional)
   * @param usedCountIn  (optional)
   * @param usedCountNotIn  (optional)
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
   * @param filesIdGreaterThan  (optional)
   * @param filesIdLessThan  (optional)
   * @param filesIdGreaterThanOrEqual  (optional)
   * @param filesIdLessThanOrEqual  (optional)
   * @param filesIdEquals  (optional)
   * @param filesIdNotEquals  (optional)
   * @param filesIdSpecified  (optional)
   * @param filesIdIn  (optional)
   * @param filesIdNotIn  (optional)
   * @param buyNGetMIdGreaterThan  (optional)
   * @param buyNGetMIdLessThan  (optional)
   * @param buyNGetMIdGreaterThanOrEqual  (optional)
   * @param buyNGetMIdLessThanOrEqual  (optional)
   * @param buyNGetMIdEquals  (optional)
   * @param buyNGetMIdNotEquals  (optional)
   * @param buyNGetMIdSpecified  (optional)
   * @param buyNGetMIdIn  (optional)
   * @param buyNGetMIdNotIn  (optional)
   * @param percentOffIdGreaterThan  (optional)
   * @param percentOffIdLessThan  (optional)
   * @param percentOffIdGreaterThanOrEqual  (optional)
   * @param percentOffIdLessThanOrEqual  (optional)
   * @param percentOffIdEquals  (optional)
   * @param percentOffIdNotEquals  (optional)
   * @param percentOffIdSpecified  (optional)
   * @param percentOffIdIn  (optional)
   * @param percentOffIdNotIn  (optional)
   * @param conditionsRIdGreaterThan  (optional)
   * @param conditionsRIdLessThan  (optional)
   * @param conditionsRIdGreaterThanOrEqual  (optional)
   * @param conditionsRIdLessThanOrEqual  (optional)
   * @param conditionsRIdEquals  (optional)
   * @param conditionsRIdNotEquals  (optional)
   * @param conditionsRIdSpecified  (optional)
   * @param conditionsRIdIn  (optional)
   * @param conditionsRIdNotIn  (optional)
   * @param conditionsDIdGreaterThan  (optional)
   * @param conditionsDIdLessThan  (optional)
   * @param conditionsDIdGreaterThanOrEqual  (optional)
   * @param conditionsDIdLessThanOrEqual  (optional)
   * @param conditionsDIdEquals  (optional)
   * @param conditionsDIdNotEquals  (optional)
   * @param conditionsDIdSpecified  (optional)
   * @param conditionsDIdIn  (optional)
   * @param conditionsDIdNotIn  (optional)
   * @param conditionsLocIdGreaterThan  (optional)
   * @param conditionsLocIdLessThan  (optional)
   * @param conditionsLocIdGreaterThanOrEqual  (optional)
   * @param conditionsLocIdLessThanOrEqual  (optional)
   * @param conditionsLocIdEquals  (optional)
   * @param conditionsLocIdNotEquals  (optional)
   * @param conditionsLocIdSpecified  (optional)
   * @param conditionsLocIdIn  (optional)
   * @param conditionsLocIdNotIn  (optional)
   * @param distinct  (optional)
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return List&lt;PromotionDTO&gt;
   */
  @RequestLine("GET /api/promotions?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&code.contains={codeContains}&code.doesNotContain={codeDoesNotContain}&code.equals={codeEquals}&code.notEquals={codeNotEquals}&code.specified={codeSpecified}&code.in={codeIn}&code.notIn={codeNotIn}&description.contains={descriptionContains}&description.doesNotContain={descriptionDoesNotContain}&description.equals={descriptionEquals}&description.notEquals={descriptionNotEquals}&description.specified={descriptionSpecified}&description.in={descriptionIn}&description.notIn={descriptionNotIn}&startDate.greaterThan={startDateGreaterThan}&startDate.lessThan={startDateLessThan}&startDate.greaterThanOrEqual={startDateGreaterThanOrEqual}&startDate.lessThanOrEqual={startDateLessThanOrEqual}&startDate.equals={startDateEquals}&startDate.notEquals={startDateNotEquals}&startDate.specified={startDateSpecified}&startDate.in={startDateIn}&startDate.notIn={startDateNotIn}&endDate.greaterThan={endDateGreaterThan}&endDate.lessThan={endDateLessThan}&endDate.greaterThanOrEqual={endDateGreaterThanOrEqual}&endDate.lessThanOrEqual={endDateLessThanOrEqual}&endDate.equals={endDateEquals}&endDate.notEquals={endDateNotEquals}&endDate.specified={endDateSpecified}&endDate.in={endDateIn}&endDate.notIn={endDateNotIn}&usageLimit.greaterThan={usageLimitGreaterThan}&usageLimit.lessThan={usageLimitLessThan}&usageLimit.greaterThanOrEqual={usageLimitGreaterThanOrEqual}&usageLimit.lessThanOrEqual={usageLimitLessThanOrEqual}&usageLimit.equals={usageLimitEquals}&usageLimit.notEquals={usageLimitNotEquals}&usageLimit.specified={usageLimitSpecified}&usageLimit.in={usageLimitIn}&usageLimit.notIn={usageLimitNotIn}&usedCount.greaterThan={usedCountGreaterThan}&usedCount.lessThan={usedCountLessThan}&usedCount.greaterThanOrEqual={usedCountGreaterThanOrEqual}&usedCount.lessThanOrEqual={usedCountLessThanOrEqual}&usedCount.equals={usedCountEquals}&usedCount.notEquals={usedCountNotEquals}&usedCount.specified={usedCountSpecified}&usedCount.in={usedCountIn}&usedCount.notIn={usedCountNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&filesId.greaterThan={filesIdGreaterThan}&filesId.lessThan={filesIdLessThan}&filesId.greaterThanOrEqual={filesIdGreaterThanOrEqual}&filesId.lessThanOrEqual={filesIdLessThanOrEqual}&filesId.equals={filesIdEquals}&filesId.notEquals={filesIdNotEquals}&filesId.specified={filesIdSpecified}&filesId.in={filesIdIn}&filesId.notIn={filesIdNotIn}&buyNGetMId.greaterThan={buyNGetMIdGreaterThan}&buyNGetMId.lessThan={buyNGetMIdLessThan}&buyNGetMId.greaterThanOrEqual={buyNGetMIdGreaterThanOrEqual}&buyNGetMId.lessThanOrEqual={buyNGetMIdLessThanOrEqual}&buyNGetMId.equals={buyNGetMIdEquals}&buyNGetMId.notEquals={buyNGetMIdNotEquals}&buyNGetMId.specified={buyNGetMIdSpecified}&buyNGetMId.in={buyNGetMIdIn}&buyNGetMId.notIn={buyNGetMIdNotIn}&percentOffId.greaterThan={percentOffIdGreaterThan}&percentOffId.lessThan={percentOffIdLessThan}&percentOffId.greaterThanOrEqual={percentOffIdGreaterThanOrEqual}&percentOffId.lessThanOrEqual={percentOffIdLessThanOrEqual}&percentOffId.equals={percentOffIdEquals}&percentOffId.notEquals={percentOffIdNotEquals}&percentOffId.specified={percentOffIdSpecified}&percentOffId.in={percentOffIdIn}&percentOffId.notIn={percentOffIdNotIn}&conditionsRId.greaterThan={conditionsRIdGreaterThan}&conditionsRId.lessThan={conditionsRIdLessThan}&conditionsRId.greaterThanOrEqual={conditionsRIdGreaterThanOrEqual}&conditionsRId.lessThanOrEqual={conditionsRIdLessThanOrEqual}&conditionsRId.equals={conditionsRIdEquals}&conditionsRId.notEquals={conditionsRIdNotEquals}&conditionsRId.specified={conditionsRIdSpecified}&conditionsRId.in={conditionsRIdIn}&conditionsRId.notIn={conditionsRIdNotIn}&conditionsDId.greaterThan={conditionsDIdGreaterThan}&conditionsDId.lessThan={conditionsDIdLessThan}&conditionsDId.greaterThanOrEqual={conditionsDIdGreaterThanOrEqual}&conditionsDId.lessThanOrEqual={conditionsDIdLessThanOrEqual}&conditionsDId.equals={conditionsDIdEquals}&conditionsDId.notEquals={conditionsDIdNotEquals}&conditionsDId.specified={conditionsDIdSpecified}&conditionsDId.in={conditionsDIdIn}&conditionsDId.notIn={conditionsDIdNotIn}&conditionsLocId.greaterThan={conditionsLocIdGreaterThan}&conditionsLocId.lessThan={conditionsLocIdLessThan}&conditionsLocId.greaterThanOrEqual={conditionsLocIdGreaterThanOrEqual}&conditionsLocId.lessThanOrEqual={conditionsLocIdLessThanOrEqual}&conditionsLocId.equals={conditionsLocIdEquals}&conditionsLocId.notEquals={conditionsLocIdNotEquals}&conditionsLocId.specified={conditionsLocIdSpecified}&conditionsLocId.in={conditionsLocIdIn}&conditionsLocId.notIn={conditionsLocIdNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",
  })
  List<PromotionDTO> getAllPromotions(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("codeContains") @jakarta.annotation.Nullable String codeContains, @Param("codeDoesNotContain") @jakarta.annotation.Nullable String codeDoesNotContain, @Param("codeEquals") @jakarta.annotation.Nullable String codeEquals, @Param("codeNotEquals") @jakarta.annotation.Nullable String codeNotEquals, @Param("codeSpecified") @jakarta.annotation.Nullable Boolean codeSpecified, @Param("codeIn") @jakarta.annotation.Nullable List<String> codeIn, @Param("codeNotIn") @jakarta.annotation.Nullable List<String> codeNotIn, @Param("descriptionContains") @jakarta.annotation.Nullable String descriptionContains, @Param("descriptionDoesNotContain") @jakarta.annotation.Nullable String descriptionDoesNotContain, @Param("descriptionEquals") @jakarta.annotation.Nullable String descriptionEquals, @Param("descriptionNotEquals") @jakarta.annotation.Nullable String descriptionNotEquals, @Param("descriptionSpecified") @jakarta.annotation.Nullable Boolean descriptionSpecified, @Param("descriptionIn") @jakarta.annotation.Nullable List<String> descriptionIn, @Param("descriptionNotIn") @jakarta.annotation.Nullable List<String> descriptionNotIn, @Param("startDateGreaterThan") @jakarta.annotation.Nullable LocalDate startDateGreaterThan, @Param("startDateLessThan") @jakarta.annotation.Nullable LocalDate startDateLessThan, @Param("startDateGreaterThanOrEqual") @jakarta.annotation.Nullable LocalDate startDateGreaterThanOrEqual, @Param("startDateLessThanOrEqual") @jakarta.annotation.Nullable LocalDate startDateLessThanOrEqual, @Param("startDateEquals") @jakarta.annotation.Nullable LocalDate startDateEquals, @Param("startDateNotEquals") @jakarta.annotation.Nullable LocalDate startDateNotEquals, @Param("startDateSpecified") @jakarta.annotation.Nullable Boolean startDateSpecified, @Param("startDateIn") @jakarta.annotation.Nullable List<LocalDate> startDateIn, @Param("startDateNotIn") @jakarta.annotation.Nullable List<LocalDate> startDateNotIn, @Param("endDateGreaterThan") @jakarta.annotation.Nullable LocalDate endDateGreaterThan, @Param("endDateLessThan") @jakarta.annotation.Nullable LocalDate endDateLessThan, @Param("endDateGreaterThanOrEqual") @jakarta.annotation.Nullable LocalDate endDateGreaterThanOrEqual, @Param("endDateLessThanOrEqual") @jakarta.annotation.Nullable LocalDate endDateLessThanOrEqual, @Param("endDateEquals") @jakarta.annotation.Nullable LocalDate endDateEquals, @Param("endDateNotEquals") @jakarta.annotation.Nullable LocalDate endDateNotEquals, @Param("endDateSpecified") @jakarta.annotation.Nullable Boolean endDateSpecified, @Param("endDateIn") @jakarta.annotation.Nullable List<LocalDate> endDateIn, @Param("endDateNotIn") @jakarta.annotation.Nullable List<LocalDate> endDateNotIn, @Param("usageLimitGreaterThan") @jakarta.annotation.Nullable Integer usageLimitGreaterThan, @Param("usageLimitLessThan") @jakarta.annotation.Nullable Integer usageLimitLessThan, @Param("usageLimitGreaterThanOrEqual") @jakarta.annotation.Nullable Integer usageLimitGreaterThanOrEqual, @Param("usageLimitLessThanOrEqual") @jakarta.annotation.Nullable Integer usageLimitLessThanOrEqual, @Param("usageLimitEquals") @jakarta.annotation.Nullable Integer usageLimitEquals, @Param("usageLimitNotEquals") @jakarta.annotation.Nullable Integer usageLimitNotEquals, @Param("usageLimitSpecified") @jakarta.annotation.Nullable Boolean usageLimitSpecified, @Param("usageLimitIn") @jakarta.annotation.Nullable List<Integer> usageLimitIn, @Param("usageLimitNotIn") @jakarta.annotation.Nullable List<Integer> usageLimitNotIn, @Param("usedCountGreaterThan") @jakarta.annotation.Nullable Integer usedCountGreaterThan, @Param("usedCountLessThan") @jakarta.annotation.Nullable Integer usedCountLessThan, @Param("usedCountGreaterThanOrEqual") @jakarta.annotation.Nullable Integer usedCountGreaterThanOrEqual, @Param("usedCountLessThanOrEqual") @jakarta.annotation.Nullable Integer usedCountLessThanOrEqual, @Param("usedCountEquals") @jakarta.annotation.Nullable Integer usedCountEquals, @Param("usedCountNotEquals") @jakarta.annotation.Nullable Integer usedCountNotEquals, @Param("usedCountSpecified") @jakarta.annotation.Nullable Boolean usedCountSpecified, @Param("usedCountIn") @jakarta.annotation.Nullable List<Integer> usedCountIn, @Param("usedCountNotIn") @jakarta.annotation.Nullable List<Integer> usedCountNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("filesIdGreaterThan") @jakarta.annotation.Nullable Long filesIdGreaterThan, @Param("filesIdLessThan") @jakarta.annotation.Nullable Long filesIdLessThan, @Param("filesIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long filesIdGreaterThanOrEqual, @Param("filesIdLessThanOrEqual") @jakarta.annotation.Nullable Long filesIdLessThanOrEqual, @Param("filesIdEquals") @jakarta.annotation.Nullable Long filesIdEquals, @Param("filesIdNotEquals") @jakarta.annotation.Nullable Long filesIdNotEquals, @Param("filesIdSpecified") @jakarta.annotation.Nullable Boolean filesIdSpecified, @Param("filesIdIn") @jakarta.annotation.Nullable List<Long> filesIdIn, @Param("filesIdNotIn") @jakarta.annotation.Nullable List<Long> filesIdNotIn, @Param("buyNGetMIdGreaterThan") @jakarta.annotation.Nullable Long buyNGetMIdGreaterThan, @Param("buyNGetMIdLessThan") @jakarta.annotation.Nullable Long buyNGetMIdLessThan, @Param("buyNGetMIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long buyNGetMIdGreaterThanOrEqual, @Param("buyNGetMIdLessThanOrEqual") @jakarta.annotation.Nullable Long buyNGetMIdLessThanOrEqual, @Param("buyNGetMIdEquals") @jakarta.annotation.Nullable Long buyNGetMIdEquals, @Param("buyNGetMIdNotEquals") @jakarta.annotation.Nullable Long buyNGetMIdNotEquals, @Param("buyNGetMIdSpecified") @jakarta.annotation.Nullable Boolean buyNGetMIdSpecified, @Param("buyNGetMIdIn") @jakarta.annotation.Nullable List<Long> buyNGetMIdIn, @Param("buyNGetMIdNotIn") @jakarta.annotation.Nullable List<Long> buyNGetMIdNotIn, @Param("percentOffIdGreaterThan") @jakarta.annotation.Nullable Long percentOffIdGreaterThan, @Param("percentOffIdLessThan") @jakarta.annotation.Nullable Long percentOffIdLessThan, @Param("percentOffIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long percentOffIdGreaterThanOrEqual, @Param("percentOffIdLessThanOrEqual") @jakarta.annotation.Nullable Long percentOffIdLessThanOrEqual, @Param("percentOffIdEquals") @jakarta.annotation.Nullable Long percentOffIdEquals, @Param("percentOffIdNotEquals") @jakarta.annotation.Nullable Long percentOffIdNotEquals, @Param("percentOffIdSpecified") @jakarta.annotation.Nullable Boolean percentOffIdSpecified, @Param("percentOffIdIn") @jakarta.annotation.Nullable List<Long> percentOffIdIn, @Param("percentOffIdNotIn") @jakarta.annotation.Nullable List<Long> percentOffIdNotIn, @Param("conditionsRIdGreaterThan") @jakarta.annotation.Nullable Long conditionsRIdGreaterThan, @Param("conditionsRIdLessThan") @jakarta.annotation.Nullable Long conditionsRIdLessThan, @Param("conditionsRIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long conditionsRIdGreaterThanOrEqual, @Param("conditionsRIdLessThanOrEqual") @jakarta.annotation.Nullable Long conditionsRIdLessThanOrEqual, @Param("conditionsRIdEquals") @jakarta.annotation.Nullable Long conditionsRIdEquals, @Param("conditionsRIdNotEquals") @jakarta.annotation.Nullable Long conditionsRIdNotEquals, @Param("conditionsRIdSpecified") @jakarta.annotation.Nullable Boolean conditionsRIdSpecified, @Param("conditionsRIdIn") @jakarta.annotation.Nullable List<Long> conditionsRIdIn, @Param("conditionsRIdNotIn") @jakarta.annotation.Nullable List<Long> conditionsRIdNotIn, @Param("conditionsDIdGreaterThan") @jakarta.annotation.Nullable Long conditionsDIdGreaterThan, @Param("conditionsDIdLessThan") @jakarta.annotation.Nullable Long conditionsDIdLessThan, @Param("conditionsDIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long conditionsDIdGreaterThanOrEqual, @Param("conditionsDIdLessThanOrEqual") @jakarta.annotation.Nullable Long conditionsDIdLessThanOrEqual, @Param("conditionsDIdEquals") @jakarta.annotation.Nullable Long conditionsDIdEquals, @Param("conditionsDIdNotEquals") @jakarta.annotation.Nullable Long conditionsDIdNotEquals, @Param("conditionsDIdSpecified") @jakarta.annotation.Nullable Boolean conditionsDIdSpecified, @Param("conditionsDIdIn") @jakarta.annotation.Nullable List<Long> conditionsDIdIn, @Param("conditionsDIdNotIn") @jakarta.annotation.Nullable List<Long> conditionsDIdNotIn, @Param("conditionsLocIdGreaterThan") @jakarta.annotation.Nullable Long conditionsLocIdGreaterThan, @Param("conditionsLocIdLessThan") @jakarta.annotation.Nullable Long conditionsLocIdLessThan, @Param("conditionsLocIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long conditionsLocIdGreaterThanOrEqual, @Param("conditionsLocIdLessThanOrEqual") @jakarta.annotation.Nullable Long conditionsLocIdLessThanOrEqual, @Param("conditionsLocIdEquals") @jakarta.annotation.Nullable Long conditionsLocIdEquals, @Param("conditionsLocIdNotEquals") @jakarta.annotation.Nullable Long conditionsLocIdNotEquals, @Param("conditionsLocIdSpecified") @jakarta.annotation.Nullable Boolean conditionsLocIdSpecified, @Param("conditionsLocIdIn") @jakarta.annotation.Nullable List<Long> conditionsLocIdIn, @Param("conditionsLocIdNotIn") @jakarta.annotation.Nullable List<Long> conditionsLocIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct, @Param("page") @jakarta.annotation.Nullable Integer page, @Param("size") @jakarta.annotation.Nullable Integer size, @Param("sort") @jakarta.annotation.Nullable List<String> sort);

  /**
   * 
   * Similar to <code>getAllPromotions</code> but it also returns the http response headers .
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
   * @param codeContains  (optional)
   * @param codeDoesNotContain  (optional)
   * @param codeEquals  (optional)
   * @param codeNotEquals  (optional)
   * @param codeSpecified  (optional)
   * @param codeIn  (optional)
   * @param codeNotIn  (optional)
   * @param descriptionContains  (optional)
   * @param descriptionDoesNotContain  (optional)
   * @param descriptionEquals  (optional)
   * @param descriptionNotEquals  (optional)
   * @param descriptionSpecified  (optional)
   * @param descriptionIn  (optional)
   * @param descriptionNotIn  (optional)
   * @param startDateGreaterThan  (optional)
   * @param startDateLessThan  (optional)
   * @param startDateGreaterThanOrEqual  (optional)
   * @param startDateLessThanOrEqual  (optional)
   * @param startDateEquals  (optional)
   * @param startDateNotEquals  (optional)
   * @param startDateSpecified  (optional)
   * @param startDateIn  (optional)
   * @param startDateNotIn  (optional)
   * @param endDateGreaterThan  (optional)
   * @param endDateLessThan  (optional)
   * @param endDateGreaterThanOrEqual  (optional)
   * @param endDateLessThanOrEqual  (optional)
   * @param endDateEquals  (optional)
   * @param endDateNotEquals  (optional)
   * @param endDateSpecified  (optional)
   * @param endDateIn  (optional)
   * @param endDateNotIn  (optional)
   * @param usageLimitGreaterThan  (optional)
   * @param usageLimitLessThan  (optional)
   * @param usageLimitGreaterThanOrEqual  (optional)
   * @param usageLimitLessThanOrEqual  (optional)
   * @param usageLimitEquals  (optional)
   * @param usageLimitNotEquals  (optional)
   * @param usageLimitSpecified  (optional)
   * @param usageLimitIn  (optional)
   * @param usageLimitNotIn  (optional)
   * @param usedCountGreaterThan  (optional)
   * @param usedCountLessThan  (optional)
   * @param usedCountGreaterThanOrEqual  (optional)
   * @param usedCountLessThanOrEqual  (optional)
   * @param usedCountEquals  (optional)
   * @param usedCountNotEquals  (optional)
   * @param usedCountSpecified  (optional)
   * @param usedCountIn  (optional)
   * @param usedCountNotIn  (optional)
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
   * @param filesIdGreaterThan  (optional)
   * @param filesIdLessThan  (optional)
   * @param filesIdGreaterThanOrEqual  (optional)
   * @param filesIdLessThanOrEqual  (optional)
   * @param filesIdEquals  (optional)
   * @param filesIdNotEquals  (optional)
   * @param filesIdSpecified  (optional)
   * @param filesIdIn  (optional)
   * @param filesIdNotIn  (optional)
   * @param buyNGetMIdGreaterThan  (optional)
   * @param buyNGetMIdLessThan  (optional)
   * @param buyNGetMIdGreaterThanOrEqual  (optional)
   * @param buyNGetMIdLessThanOrEqual  (optional)
   * @param buyNGetMIdEquals  (optional)
   * @param buyNGetMIdNotEquals  (optional)
   * @param buyNGetMIdSpecified  (optional)
   * @param buyNGetMIdIn  (optional)
   * @param buyNGetMIdNotIn  (optional)
   * @param percentOffIdGreaterThan  (optional)
   * @param percentOffIdLessThan  (optional)
   * @param percentOffIdGreaterThanOrEqual  (optional)
   * @param percentOffIdLessThanOrEqual  (optional)
   * @param percentOffIdEquals  (optional)
   * @param percentOffIdNotEquals  (optional)
   * @param percentOffIdSpecified  (optional)
   * @param percentOffIdIn  (optional)
   * @param percentOffIdNotIn  (optional)
   * @param conditionsRIdGreaterThan  (optional)
   * @param conditionsRIdLessThan  (optional)
   * @param conditionsRIdGreaterThanOrEqual  (optional)
   * @param conditionsRIdLessThanOrEqual  (optional)
   * @param conditionsRIdEquals  (optional)
   * @param conditionsRIdNotEquals  (optional)
   * @param conditionsRIdSpecified  (optional)
   * @param conditionsRIdIn  (optional)
   * @param conditionsRIdNotIn  (optional)
   * @param conditionsDIdGreaterThan  (optional)
   * @param conditionsDIdLessThan  (optional)
   * @param conditionsDIdGreaterThanOrEqual  (optional)
   * @param conditionsDIdLessThanOrEqual  (optional)
   * @param conditionsDIdEquals  (optional)
   * @param conditionsDIdNotEquals  (optional)
   * @param conditionsDIdSpecified  (optional)
   * @param conditionsDIdIn  (optional)
   * @param conditionsDIdNotIn  (optional)
   * @param conditionsLocIdGreaterThan  (optional)
   * @param conditionsLocIdLessThan  (optional)
   * @param conditionsLocIdGreaterThanOrEqual  (optional)
   * @param conditionsLocIdLessThanOrEqual  (optional)
   * @param conditionsLocIdEquals  (optional)
   * @param conditionsLocIdNotEquals  (optional)
   * @param conditionsLocIdSpecified  (optional)
   * @param conditionsLocIdIn  (optional)
   * @param conditionsLocIdNotIn  (optional)
   * @param distinct  (optional)
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/promotions?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&code.contains={codeContains}&code.doesNotContain={codeDoesNotContain}&code.equals={codeEquals}&code.notEquals={codeNotEquals}&code.specified={codeSpecified}&code.in={codeIn}&code.notIn={codeNotIn}&description.contains={descriptionContains}&description.doesNotContain={descriptionDoesNotContain}&description.equals={descriptionEquals}&description.notEquals={descriptionNotEquals}&description.specified={descriptionSpecified}&description.in={descriptionIn}&description.notIn={descriptionNotIn}&startDate.greaterThan={startDateGreaterThan}&startDate.lessThan={startDateLessThan}&startDate.greaterThanOrEqual={startDateGreaterThanOrEqual}&startDate.lessThanOrEqual={startDateLessThanOrEqual}&startDate.equals={startDateEquals}&startDate.notEquals={startDateNotEquals}&startDate.specified={startDateSpecified}&startDate.in={startDateIn}&startDate.notIn={startDateNotIn}&endDate.greaterThan={endDateGreaterThan}&endDate.lessThan={endDateLessThan}&endDate.greaterThanOrEqual={endDateGreaterThanOrEqual}&endDate.lessThanOrEqual={endDateLessThanOrEqual}&endDate.equals={endDateEquals}&endDate.notEquals={endDateNotEquals}&endDate.specified={endDateSpecified}&endDate.in={endDateIn}&endDate.notIn={endDateNotIn}&usageLimit.greaterThan={usageLimitGreaterThan}&usageLimit.lessThan={usageLimitLessThan}&usageLimit.greaterThanOrEqual={usageLimitGreaterThanOrEqual}&usageLimit.lessThanOrEqual={usageLimitLessThanOrEqual}&usageLimit.equals={usageLimitEquals}&usageLimit.notEquals={usageLimitNotEquals}&usageLimit.specified={usageLimitSpecified}&usageLimit.in={usageLimitIn}&usageLimit.notIn={usageLimitNotIn}&usedCount.greaterThan={usedCountGreaterThan}&usedCount.lessThan={usedCountLessThan}&usedCount.greaterThanOrEqual={usedCountGreaterThanOrEqual}&usedCount.lessThanOrEqual={usedCountLessThanOrEqual}&usedCount.equals={usedCountEquals}&usedCount.notEquals={usedCountNotEquals}&usedCount.specified={usedCountSpecified}&usedCount.in={usedCountIn}&usedCount.notIn={usedCountNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&filesId.greaterThan={filesIdGreaterThan}&filesId.lessThan={filesIdLessThan}&filesId.greaterThanOrEqual={filesIdGreaterThanOrEqual}&filesId.lessThanOrEqual={filesIdLessThanOrEqual}&filesId.equals={filesIdEquals}&filesId.notEquals={filesIdNotEquals}&filesId.specified={filesIdSpecified}&filesId.in={filesIdIn}&filesId.notIn={filesIdNotIn}&buyNGetMId.greaterThan={buyNGetMIdGreaterThan}&buyNGetMId.lessThan={buyNGetMIdLessThan}&buyNGetMId.greaterThanOrEqual={buyNGetMIdGreaterThanOrEqual}&buyNGetMId.lessThanOrEqual={buyNGetMIdLessThanOrEqual}&buyNGetMId.equals={buyNGetMIdEquals}&buyNGetMId.notEquals={buyNGetMIdNotEquals}&buyNGetMId.specified={buyNGetMIdSpecified}&buyNGetMId.in={buyNGetMIdIn}&buyNGetMId.notIn={buyNGetMIdNotIn}&percentOffId.greaterThan={percentOffIdGreaterThan}&percentOffId.lessThan={percentOffIdLessThan}&percentOffId.greaterThanOrEqual={percentOffIdGreaterThanOrEqual}&percentOffId.lessThanOrEqual={percentOffIdLessThanOrEqual}&percentOffId.equals={percentOffIdEquals}&percentOffId.notEquals={percentOffIdNotEquals}&percentOffId.specified={percentOffIdSpecified}&percentOffId.in={percentOffIdIn}&percentOffId.notIn={percentOffIdNotIn}&conditionsRId.greaterThan={conditionsRIdGreaterThan}&conditionsRId.lessThan={conditionsRIdLessThan}&conditionsRId.greaterThanOrEqual={conditionsRIdGreaterThanOrEqual}&conditionsRId.lessThanOrEqual={conditionsRIdLessThanOrEqual}&conditionsRId.equals={conditionsRIdEquals}&conditionsRId.notEquals={conditionsRIdNotEquals}&conditionsRId.specified={conditionsRIdSpecified}&conditionsRId.in={conditionsRIdIn}&conditionsRId.notIn={conditionsRIdNotIn}&conditionsDId.greaterThan={conditionsDIdGreaterThan}&conditionsDId.lessThan={conditionsDIdLessThan}&conditionsDId.greaterThanOrEqual={conditionsDIdGreaterThanOrEqual}&conditionsDId.lessThanOrEqual={conditionsDIdLessThanOrEqual}&conditionsDId.equals={conditionsDIdEquals}&conditionsDId.notEquals={conditionsDIdNotEquals}&conditionsDId.specified={conditionsDIdSpecified}&conditionsDId.in={conditionsDIdIn}&conditionsDId.notIn={conditionsDIdNotIn}&conditionsLocId.greaterThan={conditionsLocIdGreaterThan}&conditionsLocId.lessThan={conditionsLocIdLessThan}&conditionsLocId.greaterThanOrEqual={conditionsLocIdGreaterThanOrEqual}&conditionsLocId.lessThanOrEqual={conditionsLocIdLessThanOrEqual}&conditionsLocId.equals={conditionsLocIdEquals}&conditionsLocId.notEquals={conditionsLocIdNotEquals}&conditionsLocId.specified={conditionsLocIdSpecified}&conditionsLocId.in={conditionsLocIdIn}&conditionsLocId.notIn={conditionsLocIdNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<PromotionDTO>> getAllPromotionsWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("codeContains") @jakarta.annotation.Nullable String codeContains, @Param("codeDoesNotContain") @jakarta.annotation.Nullable String codeDoesNotContain, @Param("codeEquals") @jakarta.annotation.Nullable String codeEquals, @Param("codeNotEquals") @jakarta.annotation.Nullable String codeNotEquals, @Param("codeSpecified") @jakarta.annotation.Nullable Boolean codeSpecified, @Param("codeIn") @jakarta.annotation.Nullable List<String> codeIn, @Param("codeNotIn") @jakarta.annotation.Nullable List<String> codeNotIn, @Param("descriptionContains") @jakarta.annotation.Nullable String descriptionContains, @Param("descriptionDoesNotContain") @jakarta.annotation.Nullable String descriptionDoesNotContain, @Param("descriptionEquals") @jakarta.annotation.Nullable String descriptionEquals, @Param("descriptionNotEquals") @jakarta.annotation.Nullable String descriptionNotEquals, @Param("descriptionSpecified") @jakarta.annotation.Nullable Boolean descriptionSpecified, @Param("descriptionIn") @jakarta.annotation.Nullable List<String> descriptionIn, @Param("descriptionNotIn") @jakarta.annotation.Nullable List<String> descriptionNotIn, @Param("startDateGreaterThan") @jakarta.annotation.Nullable LocalDate startDateGreaterThan, @Param("startDateLessThan") @jakarta.annotation.Nullable LocalDate startDateLessThan, @Param("startDateGreaterThanOrEqual") @jakarta.annotation.Nullable LocalDate startDateGreaterThanOrEqual, @Param("startDateLessThanOrEqual") @jakarta.annotation.Nullable LocalDate startDateLessThanOrEqual, @Param("startDateEquals") @jakarta.annotation.Nullable LocalDate startDateEquals, @Param("startDateNotEquals") @jakarta.annotation.Nullable LocalDate startDateNotEquals, @Param("startDateSpecified") @jakarta.annotation.Nullable Boolean startDateSpecified, @Param("startDateIn") @jakarta.annotation.Nullable List<LocalDate> startDateIn, @Param("startDateNotIn") @jakarta.annotation.Nullable List<LocalDate> startDateNotIn, @Param("endDateGreaterThan") @jakarta.annotation.Nullable LocalDate endDateGreaterThan, @Param("endDateLessThan") @jakarta.annotation.Nullable LocalDate endDateLessThan, @Param("endDateGreaterThanOrEqual") @jakarta.annotation.Nullable LocalDate endDateGreaterThanOrEqual, @Param("endDateLessThanOrEqual") @jakarta.annotation.Nullable LocalDate endDateLessThanOrEqual, @Param("endDateEquals") @jakarta.annotation.Nullable LocalDate endDateEquals, @Param("endDateNotEquals") @jakarta.annotation.Nullable LocalDate endDateNotEquals, @Param("endDateSpecified") @jakarta.annotation.Nullable Boolean endDateSpecified, @Param("endDateIn") @jakarta.annotation.Nullable List<LocalDate> endDateIn, @Param("endDateNotIn") @jakarta.annotation.Nullable List<LocalDate> endDateNotIn, @Param("usageLimitGreaterThan") @jakarta.annotation.Nullable Integer usageLimitGreaterThan, @Param("usageLimitLessThan") @jakarta.annotation.Nullable Integer usageLimitLessThan, @Param("usageLimitGreaterThanOrEqual") @jakarta.annotation.Nullable Integer usageLimitGreaterThanOrEqual, @Param("usageLimitLessThanOrEqual") @jakarta.annotation.Nullable Integer usageLimitLessThanOrEqual, @Param("usageLimitEquals") @jakarta.annotation.Nullable Integer usageLimitEquals, @Param("usageLimitNotEquals") @jakarta.annotation.Nullable Integer usageLimitNotEquals, @Param("usageLimitSpecified") @jakarta.annotation.Nullable Boolean usageLimitSpecified, @Param("usageLimitIn") @jakarta.annotation.Nullable List<Integer> usageLimitIn, @Param("usageLimitNotIn") @jakarta.annotation.Nullable List<Integer> usageLimitNotIn, @Param("usedCountGreaterThan") @jakarta.annotation.Nullable Integer usedCountGreaterThan, @Param("usedCountLessThan") @jakarta.annotation.Nullable Integer usedCountLessThan, @Param("usedCountGreaterThanOrEqual") @jakarta.annotation.Nullable Integer usedCountGreaterThanOrEqual, @Param("usedCountLessThanOrEqual") @jakarta.annotation.Nullable Integer usedCountLessThanOrEqual, @Param("usedCountEquals") @jakarta.annotation.Nullable Integer usedCountEquals, @Param("usedCountNotEquals") @jakarta.annotation.Nullable Integer usedCountNotEquals, @Param("usedCountSpecified") @jakarta.annotation.Nullable Boolean usedCountSpecified, @Param("usedCountIn") @jakarta.annotation.Nullable List<Integer> usedCountIn, @Param("usedCountNotIn") @jakarta.annotation.Nullable List<Integer> usedCountNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("filesIdGreaterThan") @jakarta.annotation.Nullable Long filesIdGreaterThan, @Param("filesIdLessThan") @jakarta.annotation.Nullable Long filesIdLessThan, @Param("filesIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long filesIdGreaterThanOrEqual, @Param("filesIdLessThanOrEqual") @jakarta.annotation.Nullable Long filesIdLessThanOrEqual, @Param("filesIdEquals") @jakarta.annotation.Nullable Long filesIdEquals, @Param("filesIdNotEquals") @jakarta.annotation.Nullable Long filesIdNotEquals, @Param("filesIdSpecified") @jakarta.annotation.Nullable Boolean filesIdSpecified, @Param("filesIdIn") @jakarta.annotation.Nullable List<Long> filesIdIn, @Param("filesIdNotIn") @jakarta.annotation.Nullable List<Long> filesIdNotIn, @Param("buyNGetMIdGreaterThan") @jakarta.annotation.Nullable Long buyNGetMIdGreaterThan, @Param("buyNGetMIdLessThan") @jakarta.annotation.Nullable Long buyNGetMIdLessThan, @Param("buyNGetMIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long buyNGetMIdGreaterThanOrEqual, @Param("buyNGetMIdLessThanOrEqual") @jakarta.annotation.Nullable Long buyNGetMIdLessThanOrEqual, @Param("buyNGetMIdEquals") @jakarta.annotation.Nullable Long buyNGetMIdEquals, @Param("buyNGetMIdNotEquals") @jakarta.annotation.Nullable Long buyNGetMIdNotEquals, @Param("buyNGetMIdSpecified") @jakarta.annotation.Nullable Boolean buyNGetMIdSpecified, @Param("buyNGetMIdIn") @jakarta.annotation.Nullable List<Long> buyNGetMIdIn, @Param("buyNGetMIdNotIn") @jakarta.annotation.Nullable List<Long> buyNGetMIdNotIn, @Param("percentOffIdGreaterThan") @jakarta.annotation.Nullable Long percentOffIdGreaterThan, @Param("percentOffIdLessThan") @jakarta.annotation.Nullable Long percentOffIdLessThan, @Param("percentOffIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long percentOffIdGreaterThanOrEqual, @Param("percentOffIdLessThanOrEqual") @jakarta.annotation.Nullable Long percentOffIdLessThanOrEqual, @Param("percentOffIdEquals") @jakarta.annotation.Nullable Long percentOffIdEquals, @Param("percentOffIdNotEquals") @jakarta.annotation.Nullable Long percentOffIdNotEquals, @Param("percentOffIdSpecified") @jakarta.annotation.Nullable Boolean percentOffIdSpecified, @Param("percentOffIdIn") @jakarta.annotation.Nullable List<Long> percentOffIdIn, @Param("percentOffIdNotIn") @jakarta.annotation.Nullable List<Long> percentOffIdNotIn, @Param("conditionsRIdGreaterThan") @jakarta.annotation.Nullable Long conditionsRIdGreaterThan, @Param("conditionsRIdLessThan") @jakarta.annotation.Nullable Long conditionsRIdLessThan, @Param("conditionsRIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long conditionsRIdGreaterThanOrEqual, @Param("conditionsRIdLessThanOrEqual") @jakarta.annotation.Nullable Long conditionsRIdLessThanOrEqual, @Param("conditionsRIdEquals") @jakarta.annotation.Nullable Long conditionsRIdEquals, @Param("conditionsRIdNotEquals") @jakarta.annotation.Nullable Long conditionsRIdNotEquals, @Param("conditionsRIdSpecified") @jakarta.annotation.Nullable Boolean conditionsRIdSpecified, @Param("conditionsRIdIn") @jakarta.annotation.Nullable List<Long> conditionsRIdIn, @Param("conditionsRIdNotIn") @jakarta.annotation.Nullable List<Long> conditionsRIdNotIn, @Param("conditionsDIdGreaterThan") @jakarta.annotation.Nullable Long conditionsDIdGreaterThan, @Param("conditionsDIdLessThan") @jakarta.annotation.Nullable Long conditionsDIdLessThan, @Param("conditionsDIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long conditionsDIdGreaterThanOrEqual, @Param("conditionsDIdLessThanOrEqual") @jakarta.annotation.Nullable Long conditionsDIdLessThanOrEqual, @Param("conditionsDIdEquals") @jakarta.annotation.Nullable Long conditionsDIdEquals, @Param("conditionsDIdNotEquals") @jakarta.annotation.Nullable Long conditionsDIdNotEquals, @Param("conditionsDIdSpecified") @jakarta.annotation.Nullable Boolean conditionsDIdSpecified, @Param("conditionsDIdIn") @jakarta.annotation.Nullable List<Long> conditionsDIdIn, @Param("conditionsDIdNotIn") @jakarta.annotation.Nullable List<Long> conditionsDIdNotIn, @Param("conditionsLocIdGreaterThan") @jakarta.annotation.Nullable Long conditionsLocIdGreaterThan, @Param("conditionsLocIdLessThan") @jakarta.annotation.Nullable Long conditionsLocIdLessThan, @Param("conditionsLocIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long conditionsLocIdGreaterThanOrEqual, @Param("conditionsLocIdLessThanOrEqual") @jakarta.annotation.Nullable Long conditionsLocIdLessThanOrEqual, @Param("conditionsLocIdEquals") @jakarta.annotation.Nullable Long conditionsLocIdEquals, @Param("conditionsLocIdNotEquals") @jakarta.annotation.Nullable Long conditionsLocIdNotEquals, @Param("conditionsLocIdSpecified") @jakarta.annotation.Nullable Boolean conditionsLocIdSpecified, @Param("conditionsLocIdIn") @jakarta.annotation.Nullable List<Long> conditionsLocIdIn, @Param("conditionsLocIdNotIn") @jakarta.annotation.Nullable List<Long> conditionsLocIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct, @Param("page") @jakarta.annotation.Nullable Integer page, @Param("size") @jakarta.annotation.Nullable Integer size, @Param("sort") @jakarta.annotation.Nullable List<String> sort);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllPromotions</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllPromotionsQueryParams} class that allows for
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
   *   <li>codeContains -  (optional)</li>
   *   <li>codeDoesNotContain -  (optional)</li>
   *   <li>codeEquals -  (optional)</li>
   *   <li>codeNotEquals -  (optional)</li>
   *   <li>codeSpecified -  (optional)</li>
   *   <li>codeIn -  (optional)</li>
   *   <li>codeNotIn -  (optional)</li>
   *   <li>descriptionContains -  (optional)</li>
   *   <li>descriptionDoesNotContain -  (optional)</li>
   *   <li>descriptionEquals -  (optional)</li>
   *   <li>descriptionNotEquals -  (optional)</li>
   *   <li>descriptionSpecified -  (optional)</li>
   *   <li>descriptionIn -  (optional)</li>
   *   <li>descriptionNotIn -  (optional)</li>
   *   <li>startDateGreaterThan -  (optional)</li>
   *   <li>startDateLessThan -  (optional)</li>
   *   <li>startDateGreaterThanOrEqual -  (optional)</li>
   *   <li>startDateLessThanOrEqual -  (optional)</li>
   *   <li>startDateEquals -  (optional)</li>
   *   <li>startDateNotEquals -  (optional)</li>
   *   <li>startDateSpecified -  (optional)</li>
   *   <li>startDateIn -  (optional)</li>
   *   <li>startDateNotIn -  (optional)</li>
   *   <li>endDateGreaterThan -  (optional)</li>
   *   <li>endDateLessThan -  (optional)</li>
   *   <li>endDateGreaterThanOrEqual -  (optional)</li>
   *   <li>endDateLessThanOrEqual -  (optional)</li>
   *   <li>endDateEquals -  (optional)</li>
   *   <li>endDateNotEquals -  (optional)</li>
   *   <li>endDateSpecified -  (optional)</li>
   *   <li>endDateIn -  (optional)</li>
   *   <li>endDateNotIn -  (optional)</li>
   *   <li>usageLimitGreaterThan -  (optional)</li>
   *   <li>usageLimitLessThan -  (optional)</li>
   *   <li>usageLimitGreaterThanOrEqual -  (optional)</li>
   *   <li>usageLimitLessThanOrEqual -  (optional)</li>
   *   <li>usageLimitEquals -  (optional)</li>
   *   <li>usageLimitNotEquals -  (optional)</li>
   *   <li>usageLimitSpecified -  (optional)</li>
   *   <li>usageLimitIn -  (optional)</li>
   *   <li>usageLimitNotIn -  (optional)</li>
   *   <li>usedCountGreaterThan -  (optional)</li>
   *   <li>usedCountLessThan -  (optional)</li>
   *   <li>usedCountGreaterThanOrEqual -  (optional)</li>
   *   <li>usedCountLessThanOrEqual -  (optional)</li>
   *   <li>usedCountEquals -  (optional)</li>
   *   <li>usedCountNotEquals -  (optional)</li>
   *   <li>usedCountSpecified -  (optional)</li>
   *   <li>usedCountIn -  (optional)</li>
   *   <li>usedCountNotIn -  (optional)</li>
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
   *   <li>filesIdGreaterThan -  (optional)</li>
   *   <li>filesIdLessThan -  (optional)</li>
   *   <li>filesIdGreaterThanOrEqual -  (optional)</li>
   *   <li>filesIdLessThanOrEqual -  (optional)</li>
   *   <li>filesIdEquals -  (optional)</li>
   *   <li>filesIdNotEquals -  (optional)</li>
   *   <li>filesIdSpecified -  (optional)</li>
   *   <li>filesIdIn -  (optional)</li>
   *   <li>filesIdNotIn -  (optional)</li>
   *   <li>buyNGetMIdGreaterThan -  (optional)</li>
   *   <li>buyNGetMIdLessThan -  (optional)</li>
   *   <li>buyNGetMIdGreaterThanOrEqual -  (optional)</li>
   *   <li>buyNGetMIdLessThanOrEqual -  (optional)</li>
   *   <li>buyNGetMIdEquals -  (optional)</li>
   *   <li>buyNGetMIdNotEquals -  (optional)</li>
   *   <li>buyNGetMIdSpecified -  (optional)</li>
   *   <li>buyNGetMIdIn -  (optional)</li>
   *   <li>buyNGetMIdNotIn -  (optional)</li>
   *   <li>percentOffIdGreaterThan -  (optional)</li>
   *   <li>percentOffIdLessThan -  (optional)</li>
   *   <li>percentOffIdGreaterThanOrEqual -  (optional)</li>
   *   <li>percentOffIdLessThanOrEqual -  (optional)</li>
   *   <li>percentOffIdEquals -  (optional)</li>
   *   <li>percentOffIdNotEquals -  (optional)</li>
   *   <li>percentOffIdSpecified -  (optional)</li>
   *   <li>percentOffIdIn -  (optional)</li>
   *   <li>percentOffIdNotIn -  (optional)</li>
   *   <li>conditionsRIdGreaterThan -  (optional)</li>
   *   <li>conditionsRIdLessThan -  (optional)</li>
   *   <li>conditionsRIdGreaterThanOrEqual -  (optional)</li>
   *   <li>conditionsRIdLessThanOrEqual -  (optional)</li>
   *   <li>conditionsRIdEquals -  (optional)</li>
   *   <li>conditionsRIdNotEquals -  (optional)</li>
   *   <li>conditionsRIdSpecified -  (optional)</li>
   *   <li>conditionsRIdIn -  (optional)</li>
   *   <li>conditionsRIdNotIn -  (optional)</li>
   *   <li>conditionsDIdGreaterThan -  (optional)</li>
   *   <li>conditionsDIdLessThan -  (optional)</li>
   *   <li>conditionsDIdGreaterThanOrEqual -  (optional)</li>
   *   <li>conditionsDIdLessThanOrEqual -  (optional)</li>
   *   <li>conditionsDIdEquals -  (optional)</li>
   *   <li>conditionsDIdNotEquals -  (optional)</li>
   *   <li>conditionsDIdSpecified -  (optional)</li>
   *   <li>conditionsDIdIn -  (optional)</li>
   *   <li>conditionsDIdNotIn -  (optional)</li>
   *   <li>conditionsLocIdGreaterThan -  (optional)</li>
   *   <li>conditionsLocIdLessThan -  (optional)</li>
   *   <li>conditionsLocIdGreaterThanOrEqual -  (optional)</li>
   *   <li>conditionsLocIdLessThanOrEqual -  (optional)</li>
   *   <li>conditionsLocIdEquals -  (optional)</li>
   *   <li>conditionsLocIdNotEquals -  (optional)</li>
   *   <li>conditionsLocIdSpecified -  (optional)</li>
   *   <li>conditionsLocIdIn -  (optional)</li>
   *   <li>conditionsLocIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   <li>page - Zero-based page index (0..N) (optional, default to 0)</li>
   *   <li>size - The size of the page to be returned (optional, default to 20)</li>
   *   <li>sort - Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)</li>
   *   </ul>
   * @return List&lt;PromotionDTO&gt;
   */
  @RequestLine("GET /api/promotions?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&code.contains={codeContains}&code.doesNotContain={codeDoesNotContain}&code.equals={codeEquals}&code.notEquals={codeNotEquals}&code.specified={codeSpecified}&code.in={codeIn}&code.notIn={codeNotIn}&description.contains={descriptionContains}&description.doesNotContain={descriptionDoesNotContain}&description.equals={descriptionEquals}&description.notEquals={descriptionNotEquals}&description.specified={descriptionSpecified}&description.in={descriptionIn}&description.notIn={descriptionNotIn}&startDate.greaterThan={startDateGreaterThan}&startDate.lessThan={startDateLessThan}&startDate.greaterThanOrEqual={startDateGreaterThanOrEqual}&startDate.lessThanOrEqual={startDateLessThanOrEqual}&startDate.equals={startDateEquals}&startDate.notEquals={startDateNotEquals}&startDate.specified={startDateSpecified}&startDate.in={startDateIn}&startDate.notIn={startDateNotIn}&endDate.greaterThan={endDateGreaterThan}&endDate.lessThan={endDateLessThan}&endDate.greaterThanOrEqual={endDateGreaterThanOrEqual}&endDate.lessThanOrEqual={endDateLessThanOrEqual}&endDate.equals={endDateEquals}&endDate.notEquals={endDateNotEquals}&endDate.specified={endDateSpecified}&endDate.in={endDateIn}&endDate.notIn={endDateNotIn}&usageLimit.greaterThan={usageLimitGreaterThan}&usageLimit.lessThan={usageLimitLessThan}&usageLimit.greaterThanOrEqual={usageLimitGreaterThanOrEqual}&usageLimit.lessThanOrEqual={usageLimitLessThanOrEqual}&usageLimit.equals={usageLimitEquals}&usageLimit.notEquals={usageLimitNotEquals}&usageLimit.specified={usageLimitSpecified}&usageLimit.in={usageLimitIn}&usageLimit.notIn={usageLimitNotIn}&usedCount.greaterThan={usedCountGreaterThan}&usedCount.lessThan={usedCountLessThan}&usedCount.greaterThanOrEqual={usedCountGreaterThanOrEqual}&usedCount.lessThanOrEqual={usedCountLessThanOrEqual}&usedCount.equals={usedCountEquals}&usedCount.notEquals={usedCountNotEquals}&usedCount.specified={usedCountSpecified}&usedCount.in={usedCountIn}&usedCount.notIn={usedCountNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&filesId.greaterThan={filesIdGreaterThan}&filesId.lessThan={filesIdLessThan}&filesId.greaterThanOrEqual={filesIdGreaterThanOrEqual}&filesId.lessThanOrEqual={filesIdLessThanOrEqual}&filesId.equals={filesIdEquals}&filesId.notEquals={filesIdNotEquals}&filesId.specified={filesIdSpecified}&filesId.in={filesIdIn}&filesId.notIn={filesIdNotIn}&buyNGetMId.greaterThan={buyNGetMIdGreaterThan}&buyNGetMId.lessThan={buyNGetMIdLessThan}&buyNGetMId.greaterThanOrEqual={buyNGetMIdGreaterThanOrEqual}&buyNGetMId.lessThanOrEqual={buyNGetMIdLessThanOrEqual}&buyNGetMId.equals={buyNGetMIdEquals}&buyNGetMId.notEquals={buyNGetMIdNotEquals}&buyNGetMId.specified={buyNGetMIdSpecified}&buyNGetMId.in={buyNGetMIdIn}&buyNGetMId.notIn={buyNGetMIdNotIn}&percentOffId.greaterThan={percentOffIdGreaterThan}&percentOffId.lessThan={percentOffIdLessThan}&percentOffId.greaterThanOrEqual={percentOffIdGreaterThanOrEqual}&percentOffId.lessThanOrEqual={percentOffIdLessThanOrEqual}&percentOffId.equals={percentOffIdEquals}&percentOffId.notEquals={percentOffIdNotEquals}&percentOffId.specified={percentOffIdSpecified}&percentOffId.in={percentOffIdIn}&percentOffId.notIn={percentOffIdNotIn}&conditionsRId.greaterThan={conditionsRIdGreaterThan}&conditionsRId.lessThan={conditionsRIdLessThan}&conditionsRId.greaterThanOrEqual={conditionsRIdGreaterThanOrEqual}&conditionsRId.lessThanOrEqual={conditionsRIdLessThanOrEqual}&conditionsRId.equals={conditionsRIdEquals}&conditionsRId.notEquals={conditionsRIdNotEquals}&conditionsRId.specified={conditionsRIdSpecified}&conditionsRId.in={conditionsRIdIn}&conditionsRId.notIn={conditionsRIdNotIn}&conditionsDId.greaterThan={conditionsDIdGreaterThan}&conditionsDId.lessThan={conditionsDIdLessThan}&conditionsDId.greaterThanOrEqual={conditionsDIdGreaterThanOrEqual}&conditionsDId.lessThanOrEqual={conditionsDIdLessThanOrEqual}&conditionsDId.equals={conditionsDIdEquals}&conditionsDId.notEquals={conditionsDIdNotEquals}&conditionsDId.specified={conditionsDIdSpecified}&conditionsDId.in={conditionsDIdIn}&conditionsDId.notIn={conditionsDIdNotIn}&conditionsLocId.greaterThan={conditionsLocIdGreaterThan}&conditionsLocId.lessThan={conditionsLocIdLessThan}&conditionsLocId.greaterThanOrEqual={conditionsLocIdGreaterThanOrEqual}&conditionsLocId.lessThanOrEqual={conditionsLocIdLessThanOrEqual}&conditionsLocId.equals={conditionsLocIdEquals}&conditionsLocId.notEquals={conditionsLocIdNotEquals}&conditionsLocId.specified={conditionsLocIdSpecified}&conditionsLocId.in={conditionsLocIdIn}&conditionsLocId.notIn={conditionsLocIdNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
  @Headers({
  "Accept: */*",
  })
  List<PromotionDTO> getAllPromotions(@QueryMap(encoded=true) GetAllPromotionsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllPromotions</code> that receives the query parameters as a map,
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
          *   <li>codeContains -  (optional)</li>
          *   <li>codeDoesNotContain -  (optional)</li>
          *   <li>codeEquals -  (optional)</li>
          *   <li>codeNotEquals -  (optional)</li>
          *   <li>codeSpecified -  (optional)</li>
          *   <li>codeIn -  (optional)</li>
          *   <li>codeNotIn -  (optional)</li>
          *   <li>descriptionContains -  (optional)</li>
          *   <li>descriptionDoesNotContain -  (optional)</li>
          *   <li>descriptionEquals -  (optional)</li>
          *   <li>descriptionNotEquals -  (optional)</li>
          *   <li>descriptionSpecified -  (optional)</li>
          *   <li>descriptionIn -  (optional)</li>
          *   <li>descriptionNotIn -  (optional)</li>
          *   <li>startDateGreaterThan -  (optional)</li>
          *   <li>startDateLessThan -  (optional)</li>
          *   <li>startDateGreaterThanOrEqual -  (optional)</li>
          *   <li>startDateLessThanOrEqual -  (optional)</li>
          *   <li>startDateEquals -  (optional)</li>
          *   <li>startDateNotEquals -  (optional)</li>
          *   <li>startDateSpecified -  (optional)</li>
          *   <li>startDateIn -  (optional)</li>
          *   <li>startDateNotIn -  (optional)</li>
          *   <li>endDateGreaterThan -  (optional)</li>
          *   <li>endDateLessThan -  (optional)</li>
          *   <li>endDateGreaterThanOrEqual -  (optional)</li>
          *   <li>endDateLessThanOrEqual -  (optional)</li>
          *   <li>endDateEquals -  (optional)</li>
          *   <li>endDateNotEquals -  (optional)</li>
          *   <li>endDateSpecified -  (optional)</li>
          *   <li>endDateIn -  (optional)</li>
          *   <li>endDateNotIn -  (optional)</li>
          *   <li>usageLimitGreaterThan -  (optional)</li>
          *   <li>usageLimitLessThan -  (optional)</li>
          *   <li>usageLimitGreaterThanOrEqual -  (optional)</li>
          *   <li>usageLimitLessThanOrEqual -  (optional)</li>
          *   <li>usageLimitEquals -  (optional)</li>
          *   <li>usageLimitNotEquals -  (optional)</li>
          *   <li>usageLimitSpecified -  (optional)</li>
          *   <li>usageLimitIn -  (optional)</li>
          *   <li>usageLimitNotIn -  (optional)</li>
          *   <li>usedCountGreaterThan -  (optional)</li>
          *   <li>usedCountLessThan -  (optional)</li>
          *   <li>usedCountGreaterThanOrEqual -  (optional)</li>
          *   <li>usedCountLessThanOrEqual -  (optional)</li>
          *   <li>usedCountEquals -  (optional)</li>
          *   <li>usedCountNotEquals -  (optional)</li>
          *   <li>usedCountSpecified -  (optional)</li>
          *   <li>usedCountIn -  (optional)</li>
          *   <li>usedCountNotIn -  (optional)</li>
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
          *   <li>filesIdGreaterThan -  (optional)</li>
          *   <li>filesIdLessThan -  (optional)</li>
          *   <li>filesIdGreaterThanOrEqual -  (optional)</li>
          *   <li>filesIdLessThanOrEqual -  (optional)</li>
          *   <li>filesIdEquals -  (optional)</li>
          *   <li>filesIdNotEquals -  (optional)</li>
          *   <li>filesIdSpecified -  (optional)</li>
          *   <li>filesIdIn -  (optional)</li>
          *   <li>filesIdNotIn -  (optional)</li>
          *   <li>buyNGetMIdGreaterThan -  (optional)</li>
          *   <li>buyNGetMIdLessThan -  (optional)</li>
          *   <li>buyNGetMIdGreaterThanOrEqual -  (optional)</li>
          *   <li>buyNGetMIdLessThanOrEqual -  (optional)</li>
          *   <li>buyNGetMIdEquals -  (optional)</li>
          *   <li>buyNGetMIdNotEquals -  (optional)</li>
          *   <li>buyNGetMIdSpecified -  (optional)</li>
          *   <li>buyNGetMIdIn -  (optional)</li>
          *   <li>buyNGetMIdNotIn -  (optional)</li>
          *   <li>percentOffIdGreaterThan -  (optional)</li>
          *   <li>percentOffIdLessThan -  (optional)</li>
          *   <li>percentOffIdGreaterThanOrEqual -  (optional)</li>
          *   <li>percentOffIdLessThanOrEqual -  (optional)</li>
          *   <li>percentOffIdEquals -  (optional)</li>
          *   <li>percentOffIdNotEquals -  (optional)</li>
          *   <li>percentOffIdSpecified -  (optional)</li>
          *   <li>percentOffIdIn -  (optional)</li>
          *   <li>percentOffIdNotIn -  (optional)</li>
          *   <li>conditionsRIdGreaterThan -  (optional)</li>
          *   <li>conditionsRIdLessThan -  (optional)</li>
          *   <li>conditionsRIdGreaterThanOrEqual -  (optional)</li>
          *   <li>conditionsRIdLessThanOrEqual -  (optional)</li>
          *   <li>conditionsRIdEquals -  (optional)</li>
          *   <li>conditionsRIdNotEquals -  (optional)</li>
          *   <li>conditionsRIdSpecified -  (optional)</li>
          *   <li>conditionsRIdIn -  (optional)</li>
          *   <li>conditionsRIdNotIn -  (optional)</li>
          *   <li>conditionsDIdGreaterThan -  (optional)</li>
          *   <li>conditionsDIdLessThan -  (optional)</li>
          *   <li>conditionsDIdGreaterThanOrEqual -  (optional)</li>
          *   <li>conditionsDIdLessThanOrEqual -  (optional)</li>
          *   <li>conditionsDIdEquals -  (optional)</li>
          *   <li>conditionsDIdNotEquals -  (optional)</li>
          *   <li>conditionsDIdSpecified -  (optional)</li>
          *   <li>conditionsDIdIn -  (optional)</li>
          *   <li>conditionsDIdNotIn -  (optional)</li>
          *   <li>conditionsLocIdGreaterThan -  (optional)</li>
          *   <li>conditionsLocIdLessThan -  (optional)</li>
          *   <li>conditionsLocIdGreaterThanOrEqual -  (optional)</li>
          *   <li>conditionsLocIdLessThanOrEqual -  (optional)</li>
          *   <li>conditionsLocIdEquals -  (optional)</li>
          *   <li>conditionsLocIdNotEquals -  (optional)</li>
          *   <li>conditionsLocIdSpecified -  (optional)</li>
          *   <li>conditionsLocIdIn -  (optional)</li>
          *   <li>conditionsLocIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
          *   <li>page - Zero-based page index (0..N) (optional, default to 0)</li>
          *   <li>size - The size of the page to be returned (optional, default to 20)</li>
          *   <li>sort - Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)</li>
      *   </ul>
          * @return List&lt;PromotionDTO&gt;
      */
      @RequestLine("GET /api/promotions?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&code.contains={codeContains}&code.doesNotContain={codeDoesNotContain}&code.equals={codeEquals}&code.notEquals={codeNotEquals}&code.specified={codeSpecified}&code.in={codeIn}&code.notIn={codeNotIn}&description.contains={descriptionContains}&description.doesNotContain={descriptionDoesNotContain}&description.equals={descriptionEquals}&description.notEquals={descriptionNotEquals}&description.specified={descriptionSpecified}&description.in={descriptionIn}&description.notIn={descriptionNotIn}&startDate.greaterThan={startDateGreaterThan}&startDate.lessThan={startDateLessThan}&startDate.greaterThanOrEqual={startDateGreaterThanOrEqual}&startDate.lessThanOrEqual={startDateLessThanOrEqual}&startDate.equals={startDateEquals}&startDate.notEquals={startDateNotEquals}&startDate.specified={startDateSpecified}&startDate.in={startDateIn}&startDate.notIn={startDateNotIn}&endDate.greaterThan={endDateGreaterThan}&endDate.lessThan={endDateLessThan}&endDate.greaterThanOrEqual={endDateGreaterThanOrEqual}&endDate.lessThanOrEqual={endDateLessThanOrEqual}&endDate.equals={endDateEquals}&endDate.notEquals={endDateNotEquals}&endDate.specified={endDateSpecified}&endDate.in={endDateIn}&endDate.notIn={endDateNotIn}&usageLimit.greaterThan={usageLimitGreaterThan}&usageLimit.lessThan={usageLimitLessThan}&usageLimit.greaterThanOrEqual={usageLimitGreaterThanOrEqual}&usageLimit.lessThanOrEqual={usageLimitLessThanOrEqual}&usageLimit.equals={usageLimitEquals}&usageLimit.notEquals={usageLimitNotEquals}&usageLimit.specified={usageLimitSpecified}&usageLimit.in={usageLimitIn}&usageLimit.notIn={usageLimitNotIn}&usedCount.greaterThan={usedCountGreaterThan}&usedCount.lessThan={usedCountLessThan}&usedCount.greaterThanOrEqual={usedCountGreaterThanOrEqual}&usedCount.lessThanOrEqual={usedCountLessThanOrEqual}&usedCount.equals={usedCountEquals}&usedCount.notEquals={usedCountNotEquals}&usedCount.specified={usedCountSpecified}&usedCount.in={usedCountIn}&usedCount.notIn={usedCountNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&filesId.greaterThan={filesIdGreaterThan}&filesId.lessThan={filesIdLessThan}&filesId.greaterThanOrEqual={filesIdGreaterThanOrEqual}&filesId.lessThanOrEqual={filesIdLessThanOrEqual}&filesId.equals={filesIdEquals}&filesId.notEquals={filesIdNotEquals}&filesId.specified={filesIdSpecified}&filesId.in={filesIdIn}&filesId.notIn={filesIdNotIn}&buyNGetMId.greaterThan={buyNGetMIdGreaterThan}&buyNGetMId.lessThan={buyNGetMIdLessThan}&buyNGetMId.greaterThanOrEqual={buyNGetMIdGreaterThanOrEqual}&buyNGetMId.lessThanOrEqual={buyNGetMIdLessThanOrEqual}&buyNGetMId.equals={buyNGetMIdEquals}&buyNGetMId.notEquals={buyNGetMIdNotEquals}&buyNGetMId.specified={buyNGetMIdSpecified}&buyNGetMId.in={buyNGetMIdIn}&buyNGetMId.notIn={buyNGetMIdNotIn}&percentOffId.greaterThan={percentOffIdGreaterThan}&percentOffId.lessThan={percentOffIdLessThan}&percentOffId.greaterThanOrEqual={percentOffIdGreaterThanOrEqual}&percentOffId.lessThanOrEqual={percentOffIdLessThanOrEqual}&percentOffId.equals={percentOffIdEquals}&percentOffId.notEquals={percentOffIdNotEquals}&percentOffId.specified={percentOffIdSpecified}&percentOffId.in={percentOffIdIn}&percentOffId.notIn={percentOffIdNotIn}&conditionsRId.greaterThan={conditionsRIdGreaterThan}&conditionsRId.lessThan={conditionsRIdLessThan}&conditionsRId.greaterThanOrEqual={conditionsRIdGreaterThanOrEqual}&conditionsRId.lessThanOrEqual={conditionsRIdLessThanOrEqual}&conditionsRId.equals={conditionsRIdEquals}&conditionsRId.notEquals={conditionsRIdNotEquals}&conditionsRId.specified={conditionsRIdSpecified}&conditionsRId.in={conditionsRIdIn}&conditionsRId.notIn={conditionsRIdNotIn}&conditionsDId.greaterThan={conditionsDIdGreaterThan}&conditionsDId.lessThan={conditionsDIdLessThan}&conditionsDId.greaterThanOrEqual={conditionsDIdGreaterThanOrEqual}&conditionsDId.lessThanOrEqual={conditionsDIdLessThanOrEqual}&conditionsDId.equals={conditionsDIdEquals}&conditionsDId.notEquals={conditionsDIdNotEquals}&conditionsDId.specified={conditionsDIdSpecified}&conditionsDId.in={conditionsDIdIn}&conditionsDId.notIn={conditionsDIdNotIn}&conditionsLocId.greaterThan={conditionsLocIdGreaterThan}&conditionsLocId.lessThan={conditionsLocIdLessThan}&conditionsLocId.greaterThanOrEqual={conditionsLocIdGreaterThanOrEqual}&conditionsLocId.lessThanOrEqual={conditionsLocIdLessThanOrEqual}&conditionsLocId.equals={conditionsLocIdEquals}&conditionsLocId.notEquals={conditionsLocIdNotEquals}&conditionsLocId.specified={conditionsLocIdSpecified}&conditionsLocId.in={conditionsLocIdIn}&conditionsLocId.notIn={conditionsLocIdNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<PromotionDTO>> getAllPromotionsWithHttpInfo(@QueryMap(encoded=true) GetAllPromotionsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllPromotions</code> method in a fluent style.
   */
  public static class GetAllPromotionsQueryParams extends HashMap<String, Object> {
    public GetAllPromotionsQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams codeContains(@jakarta.annotation.Nullable final String value) {
      put("code.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams codeDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("code.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams codeEquals(@jakarta.annotation.Nullable final String value) {
      put("code.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams codeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("code.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams codeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("code.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams codeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("code.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams codeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("code.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams descriptionContains(@jakarta.annotation.Nullable final String value) {
      put("description.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams descriptionDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("description.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams descriptionEquals(@jakarta.annotation.Nullable final String value) {
      put("description.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams descriptionNotEquals(@jakarta.annotation.Nullable final String value) {
      put("description.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams descriptionSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("description.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams descriptionIn(@jakarta.annotation.Nullable final List<String> value) {
      put("description.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams descriptionNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("description.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams startDateGreaterThan(@jakarta.annotation.Nullable final LocalDate value) {
      put("startDate.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams startDateLessThan(@jakarta.annotation.Nullable final LocalDate value) {
      put("startDate.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams startDateGreaterThanOrEqual(@jakarta.annotation.Nullable final LocalDate value) {
      put("startDate.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams startDateLessThanOrEqual(@jakarta.annotation.Nullable final LocalDate value) {
      put("startDate.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams startDateEquals(@jakarta.annotation.Nullable final LocalDate value) {
      put("startDate.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams startDateNotEquals(@jakarta.annotation.Nullable final LocalDate value) {
      put("startDate.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams startDateSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("startDate.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams startDateIn(@jakarta.annotation.Nullable final List<LocalDate> value) {
      put("startDate.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams startDateNotIn(@jakarta.annotation.Nullable final List<LocalDate> value) {
      put("startDate.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams endDateGreaterThan(@jakarta.annotation.Nullable final LocalDate value) {
      put("endDate.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams endDateLessThan(@jakarta.annotation.Nullable final LocalDate value) {
      put("endDate.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams endDateGreaterThanOrEqual(@jakarta.annotation.Nullable final LocalDate value) {
      put("endDate.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams endDateLessThanOrEqual(@jakarta.annotation.Nullable final LocalDate value) {
      put("endDate.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams endDateEquals(@jakarta.annotation.Nullable final LocalDate value) {
      put("endDate.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams endDateNotEquals(@jakarta.annotation.Nullable final LocalDate value) {
      put("endDate.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams endDateSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("endDate.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams endDateIn(@jakarta.annotation.Nullable final List<LocalDate> value) {
      put("endDate.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams endDateNotIn(@jakarta.annotation.Nullable final List<LocalDate> value) {
      put("endDate.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams usageLimitGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("usageLimit.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams usageLimitLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("usageLimit.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams usageLimitGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("usageLimit.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams usageLimitLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("usageLimit.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams usageLimitEquals(@jakarta.annotation.Nullable final Integer value) {
      put("usageLimit.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams usageLimitNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("usageLimit.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams usageLimitSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("usageLimit.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams usageLimitIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("usageLimit.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams usageLimitNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("usageLimit.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams usedCountGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("usedCount.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams usedCountLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("usedCount.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams usedCountGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("usedCount.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams usedCountLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("usedCount.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams usedCountEquals(@jakarta.annotation.Nullable final Integer value) {
      put("usedCount.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams usedCountNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("usedCount.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams usedCountSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("usedCount.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams usedCountIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("usedCount.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams usedCountNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("usedCount.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams filesIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("filesId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams filesIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("filesId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams filesIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("filesId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams filesIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("filesId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams filesIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("filesId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams filesIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("filesId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams filesIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("filesId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams filesIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("filesId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams filesIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("filesId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams buyNGetMIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("buyNGetMId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams buyNGetMIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("buyNGetMId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams buyNGetMIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("buyNGetMId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams buyNGetMIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("buyNGetMId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams buyNGetMIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("buyNGetMId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams buyNGetMIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("buyNGetMId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams buyNGetMIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("buyNGetMId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams buyNGetMIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("buyNGetMId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams buyNGetMIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("buyNGetMId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams percentOffIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("percentOffId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams percentOffIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("percentOffId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams percentOffIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("percentOffId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams percentOffIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("percentOffId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams percentOffIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("percentOffId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams percentOffIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("percentOffId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams percentOffIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("percentOffId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams percentOffIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("percentOffId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams percentOffIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("percentOffId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams conditionsRIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("conditionsRId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams conditionsRIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("conditionsRId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams conditionsRIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("conditionsRId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams conditionsRIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("conditionsRId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams conditionsRIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("conditionsRId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams conditionsRIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("conditionsRId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams conditionsRIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("conditionsRId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams conditionsRIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("conditionsRId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams conditionsRIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("conditionsRId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams conditionsDIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("conditionsDId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams conditionsDIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("conditionsDId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams conditionsDIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("conditionsDId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams conditionsDIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("conditionsDId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams conditionsDIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("conditionsDId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams conditionsDIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("conditionsDId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams conditionsDIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("conditionsDId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams conditionsDIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("conditionsDId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams conditionsDIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("conditionsDId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams conditionsLocIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("conditionsLocId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams conditionsLocIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("conditionsLocId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams conditionsLocIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("conditionsLocId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams conditionsLocIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("conditionsLocId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams conditionsLocIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("conditionsLocId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams conditionsLocIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("conditionsLocId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams conditionsLocIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("conditionsLocId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams conditionsLocIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("conditionsLocId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams conditionsLocIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("conditionsLocId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPromotionsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams page(@jakarta.annotation.Nullable final Integer value) {
      put("page", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams size(@jakarta.annotation.Nullable final Integer value) {
      put("size", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPromotionsQueryParams sort(@jakarta.annotation.Nullable final List<String> value) {
      put("sort", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @return PromotionDTO
   */
  @RequestLine("GET /api/promotions/{id}")
  @Headers({
    "Accept: */*",
  })
  PromotionDTO getPromotion(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>getPromotion</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/promotions/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<PromotionDTO> getPromotionWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param code  (required)
   * @return PromotionDetailDTO
   */
  @RequestLine("GET /api/promotions/detail-by-code?code={code}")
  @Headers({
    "Accept: */*",
  })
  PromotionDetailDTO getPromotionDetailByCode(@Param("code") @jakarta.annotation.Nonnull String code);

  /**
   * 
   * Similar to <code>getPromotionDetailByCode</code> but it also returns the http response headers .
   * 
   * @param code  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/promotions/detail-by-code?code={code}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<PromotionDetailDTO> getPromotionDetailByCodeWithHttpInfo(@Param("code") @jakarta.annotation.Nonnull String code);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getPromotionDetailByCode</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetPromotionDetailByCodeQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>code -  (required)</li>
   *   </ul>
   * @return PromotionDetailDTO
   */
  @RequestLine("GET /api/promotions/detail-by-code?code={code}")
  @Headers({
  "Accept: */*",
  })
  PromotionDetailDTO getPromotionDetailByCode(@QueryMap(encoded=true) GetPromotionDetailByCodeQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getPromotionDetailByCode</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>code -  (required)</li>
      *   </ul>
          * @return PromotionDetailDTO
      */
      @RequestLine("GET /api/promotions/detail-by-code?code={code}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<PromotionDetailDTO> getPromotionDetailByCodeWithHttpInfo(@QueryMap(encoded=true) GetPromotionDetailByCodeQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getPromotionDetailByCode</code> method in a fluent style.
   */
  public static class GetPromotionDetailByCodeQueryParams extends HashMap<String, Object> {
    public GetPromotionDetailByCodeQueryParams code(@jakarta.annotation.Nonnull final String value) {
      put("code", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @param promotionDTO  (required)
   * @return PromotionDTO
   */
  @RequestLine("PATCH /api/promotions/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  PromotionDTO partialUpdatePromotion(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull PromotionDTO promotionDTO);

  /**
   * 
   * Similar to <code>partialUpdatePromotion</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param promotionDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /api/promotions/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<PromotionDTO> partialUpdatePromotionWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull PromotionDTO promotionDTO);



  /**
   * 
   * 
   * @param id  (required)
   * @param promotionDTO  (required)
   * @return PromotionDTO
   */
  @RequestLine("PUT /api/promotions/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  PromotionDTO updatePromotion(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull PromotionDTO promotionDTO);

  /**
   * 
   * Similar to <code>updatePromotion</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param promotionDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/promotions/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<PromotionDTO> updatePromotionWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull PromotionDTO promotionDTO);


}
