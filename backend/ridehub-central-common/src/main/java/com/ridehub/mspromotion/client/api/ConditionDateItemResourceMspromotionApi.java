package com.ridehub.mspromotion.client.api;

import com.ridehub.mspromotion.client.invoker.ApiClient;
import com.ridehub.mspromotion.client.invoker.EncodingUtils;
import com.ridehub.mspromotion.client.model.ApiResponse;

import com.ridehub.mspromotion.client.model.ConditionDateItemDTO;
import com.ridehub.mspromotion.client.model.ConditionLocationItemDTO;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface ConditionDateItemResourceMspromotionApi extends ApiClient.Api {


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
   * @param specificDateGreaterThan  (optional)
   * @param specificDateLessThan  (optional)
   * @param specificDateGreaterThanOrEqual  (optional)
   * @param specificDateLessThanOrEqual  (optional)
   * @param specificDateEquals  (optional)
   * @param specificDateNotEquals  (optional)
   * @param specificDateSpecified  (optional)
   * @param specificDateIn  (optional)
   * @param specificDateNotIn  (optional)
   * @param weekdayGreaterThan  (optional)
   * @param weekdayLessThan  (optional)
   * @param weekdayGreaterThanOrEqual  (optional)
   * @param weekdayLessThanOrEqual  (optional)
   * @param weekdayEquals  (optional)
   * @param weekdayNotEquals  (optional)
   * @param weekdaySpecified  (optional)
   * @param weekdayIn  (optional)
   * @param weekdayNotIn  (optional)
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
  @RequestLine("GET /api/condition-date-items/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&specificDate.greaterThan={specificDateGreaterThan}&specificDate.lessThan={specificDateLessThan}&specificDate.greaterThanOrEqual={specificDateGreaterThanOrEqual}&specificDate.lessThanOrEqual={specificDateLessThanOrEqual}&specificDate.equals={specificDateEquals}&specificDate.notEquals={specificDateNotEquals}&specificDate.specified={specificDateSpecified}&specificDate.in={specificDateIn}&specificDate.notIn={specificDateNotIn}&weekday.greaterThan={weekdayGreaterThan}&weekday.lessThan={weekdayLessThan}&weekday.greaterThanOrEqual={weekdayGreaterThanOrEqual}&weekday.lessThanOrEqual={weekdayLessThanOrEqual}&weekday.equals={weekdayEquals}&weekday.notEquals={weekdayNotEquals}&weekday.specified={weekdaySpecified}&weekday.in={weekdayIn}&weekday.notIn={weekdayNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&conditionId.greaterThan={conditionIdGreaterThan}&conditionId.lessThan={conditionIdLessThan}&conditionId.greaterThanOrEqual={conditionIdGreaterThanOrEqual}&conditionId.lessThanOrEqual={conditionIdLessThanOrEqual}&conditionId.equals={conditionIdEquals}&conditionId.notEquals={conditionIdNotEquals}&conditionId.specified={conditionIdSpecified}&conditionId.in={conditionIdIn}&conditionId.notIn={conditionIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  Long countConditionDateItems(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("specificDateGreaterThan") @jakarta.annotation.Nullable LocalDate specificDateGreaterThan, @Param("specificDateLessThan") @jakarta.annotation.Nullable LocalDate specificDateLessThan, @Param("specificDateGreaterThanOrEqual") @jakarta.annotation.Nullable LocalDate specificDateGreaterThanOrEqual, @Param("specificDateLessThanOrEqual") @jakarta.annotation.Nullable LocalDate specificDateLessThanOrEqual, @Param("specificDateEquals") @jakarta.annotation.Nullable LocalDate specificDateEquals, @Param("specificDateNotEquals") @jakarta.annotation.Nullable LocalDate specificDateNotEquals, @Param("specificDateSpecified") @jakarta.annotation.Nullable Boolean specificDateSpecified, @Param("specificDateIn") @jakarta.annotation.Nullable List<LocalDate> specificDateIn, @Param("specificDateNotIn") @jakarta.annotation.Nullable List<LocalDate> specificDateNotIn, @Param("weekdayGreaterThan") @jakarta.annotation.Nullable Integer weekdayGreaterThan, @Param("weekdayLessThan") @jakarta.annotation.Nullable Integer weekdayLessThan, @Param("weekdayGreaterThanOrEqual") @jakarta.annotation.Nullable Integer weekdayGreaterThanOrEqual, @Param("weekdayLessThanOrEqual") @jakarta.annotation.Nullable Integer weekdayLessThanOrEqual, @Param("weekdayEquals") @jakarta.annotation.Nullable Integer weekdayEquals, @Param("weekdayNotEquals") @jakarta.annotation.Nullable Integer weekdayNotEquals, @Param("weekdaySpecified") @jakarta.annotation.Nullable Boolean weekdaySpecified, @Param("weekdayIn") @jakarta.annotation.Nullable List<Integer> weekdayIn, @Param("weekdayNotIn") @jakarta.annotation.Nullable List<Integer> weekdayNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("conditionIdGreaterThan") @jakarta.annotation.Nullable Long conditionIdGreaterThan, @Param("conditionIdLessThan") @jakarta.annotation.Nullable Long conditionIdLessThan, @Param("conditionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long conditionIdGreaterThanOrEqual, @Param("conditionIdLessThanOrEqual") @jakarta.annotation.Nullable Long conditionIdLessThanOrEqual, @Param("conditionIdEquals") @jakarta.annotation.Nullable Long conditionIdEquals, @Param("conditionIdNotEquals") @jakarta.annotation.Nullable Long conditionIdNotEquals, @Param("conditionIdSpecified") @jakarta.annotation.Nullable Boolean conditionIdSpecified, @Param("conditionIdIn") @jakarta.annotation.Nullable List<Long> conditionIdIn, @Param("conditionIdNotIn") @jakarta.annotation.Nullable List<Long> conditionIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>countConditionDateItems</code> but it also returns the http response headers .
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
   * @param specificDateGreaterThan  (optional)
   * @param specificDateLessThan  (optional)
   * @param specificDateGreaterThanOrEqual  (optional)
   * @param specificDateLessThanOrEqual  (optional)
   * @param specificDateEquals  (optional)
   * @param specificDateNotEquals  (optional)
   * @param specificDateSpecified  (optional)
   * @param specificDateIn  (optional)
   * @param specificDateNotIn  (optional)
   * @param weekdayGreaterThan  (optional)
   * @param weekdayLessThan  (optional)
   * @param weekdayGreaterThanOrEqual  (optional)
   * @param weekdayLessThanOrEqual  (optional)
   * @param weekdayEquals  (optional)
   * @param weekdayNotEquals  (optional)
   * @param weekdaySpecified  (optional)
   * @param weekdayIn  (optional)
   * @param weekdayNotIn  (optional)
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
  @RequestLine("GET /api/condition-date-items/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&specificDate.greaterThan={specificDateGreaterThan}&specificDate.lessThan={specificDateLessThan}&specificDate.greaterThanOrEqual={specificDateGreaterThanOrEqual}&specificDate.lessThanOrEqual={specificDateLessThanOrEqual}&specificDate.equals={specificDateEquals}&specificDate.notEquals={specificDateNotEquals}&specificDate.specified={specificDateSpecified}&specificDate.in={specificDateIn}&specificDate.notIn={specificDateNotIn}&weekday.greaterThan={weekdayGreaterThan}&weekday.lessThan={weekdayLessThan}&weekday.greaterThanOrEqual={weekdayGreaterThanOrEqual}&weekday.lessThanOrEqual={weekdayLessThanOrEqual}&weekday.equals={weekdayEquals}&weekday.notEquals={weekdayNotEquals}&weekday.specified={weekdaySpecified}&weekday.in={weekdayIn}&weekday.notIn={weekdayNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&conditionId.greaterThan={conditionIdGreaterThan}&conditionId.lessThan={conditionIdLessThan}&conditionId.greaterThanOrEqual={conditionIdGreaterThanOrEqual}&conditionId.lessThanOrEqual={conditionIdLessThanOrEqual}&conditionId.equals={conditionIdEquals}&conditionId.notEquals={conditionIdNotEquals}&conditionId.specified={conditionIdSpecified}&conditionId.in={conditionIdIn}&conditionId.notIn={conditionIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Long> countConditionDateItemsWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("specificDateGreaterThan") @jakarta.annotation.Nullable LocalDate specificDateGreaterThan, @Param("specificDateLessThan") @jakarta.annotation.Nullable LocalDate specificDateLessThan, @Param("specificDateGreaterThanOrEqual") @jakarta.annotation.Nullable LocalDate specificDateGreaterThanOrEqual, @Param("specificDateLessThanOrEqual") @jakarta.annotation.Nullable LocalDate specificDateLessThanOrEqual, @Param("specificDateEquals") @jakarta.annotation.Nullable LocalDate specificDateEquals, @Param("specificDateNotEquals") @jakarta.annotation.Nullable LocalDate specificDateNotEquals, @Param("specificDateSpecified") @jakarta.annotation.Nullable Boolean specificDateSpecified, @Param("specificDateIn") @jakarta.annotation.Nullable List<LocalDate> specificDateIn, @Param("specificDateNotIn") @jakarta.annotation.Nullable List<LocalDate> specificDateNotIn, @Param("weekdayGreaterThan") @jakarta.annotation.Nullable Integer weekdayGreaterThan, @Param("weekdayLessThan") @jakarta.annotation.Nullable Integer weekdayLessThan, @Param("weekdayGreaterThanOrEqual") @jakarta.annotation.Nullable Integer weekdayGreaterThanOrEqual, @Param("weekdayLessThanOrEqual") @jakarta.annotation.Nullable Integer weekdayLessThanOrEqual, @Param("weekdayEquals") @jakarta.annotation.Nullable Integer weekdayEquals, @Param("weekdayNotEquals") @jakarta.annotation.Nullable Integer weekdayNotEquals, @Param("weekdaySpecified") @jakarta.annotation.Nullable Boolean weekdaySpecified, @Param("weekdayIn") @jakarta.annotation.Nullable List<Integer> weekdayIn, @Param("weekdayNotIn") @jakarta.annotation.Nullable List<Integer> weekdayNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("conditionIdGreaterThan") @jakarta.annotation.Nullable Long conditionIdGreaterThan, @Param("conditionIdLessThan") @jakarta.annotation.Nullable Long conditionIdLessThan, @Param("conditionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long conditionIdGreaterThanOrEqual, @Param("conditionIdLessThanOrEqual") @jakarta.annotation.Nullable Long conditionIdLessThanOrEqual, @Param("conditionIdEquals") @jakarta.annotation.Nullable Long conditionIdEquals, @Param("conditionIdNotEquals") @jakarta.annotation.Nullable Long conditionIdNotEquals, @Param("conditionIdSpecified") @jakarta.annotation.Nullable Boolean conditionIdSpecified, @Param("conditionIdIn") @jakarta.annotation.Nullable List<Long> conditionIdIn, @Param("conditionIdNotIn") @jakarta.annotation.Nullable List<Long> conditionIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>countConditionDateItems</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CountConditionDateItemsQueryParams} class that allows for
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
   *   <li>specificDateGreaterThan -  (optional)</li>
   *   <li>specificDateLessThan -  (optional)</li>
   *   <li>specificDateGreaterThanOrEqual -  (optional)</li>
   *   <li>specificDateLessThanOrEqual -  (optional)</li>
   *   <li>specificDateEquals -  (optional)</li>
   *   <li>specificDateNotEquals -  (optional)</li>
   *   <li>specificDateSpecified -  (optional)</li>
   *   <li>specificDateIn -  (optional)</li>
   *   <li>specificDateNotIn -  (optional)</li>
   *   <li>weekdayGreaterThan -  (optional)</li>
   *   <li>weekdayLessThan -  (optional)</li>
   *   <li>weekdayGreaterThanOrEqual -  (optional)</li>
   *   <li>weekdayLessThanOrEqual -  (optional)</li>
   *   <li>weekdayEquals -  (optional)</li>
   *   <li>weekdayNotEquals -  (optional)</li>
   *   <li>weekdaySpecified -  (optional)</li>
   *   <li>weekdayIn -  (optional)</li>
   *   <li>weekdayNotIn -  (optional)</li>
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
  @RequestLine("GET /api/condition-date-items/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&specificDate.greaterThan={specificDateGreaterThan}&specificDate.lessThan={specificDateLessThan}&specificDate.greaterThanOrEqual={specificDateGreaterThanOrEqual}&specificDate.lessThanOrEqual={specificDateLessThanOrEqual}&specificDate.equals={specificDateEquals}&specificDate.notEquals={specificDateNotEquals}&specificDate.specified={specificDateSpecified}&specificDate.in={specificDateIn}&specificDate.notIn={specificDateNotIn}&weekday.greaterThan={weekdayGreaterThan}&weekday.lessThan={weekdayLessThan}&weekday.greaterThanOrEqual={weekdayGreaterThanOrEqual}&weekday.lessThanOrEqual={weekdayLessThanOrEqual}&weekday.equals={weekdayEquals}&weekday.notEquals={weekdayNotEquals}&weekday.specified={weekdaySpecified}&weekday.in={weekdayIn}&weekday.notIn={weekdayNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&conditionId.greaterThan={conditionIdGreaterThan}&conditionId.lessThan={conditionIdLessThan}&conditionId.greaterThanOrEqual={conditionIdGreaterThanOrEqual}&conditionId.lessThanOrEqual={conditionIdLessThanOrEqual}&conditionId.equals={conditionIdEquals}&conditionId.notEquals={conditionIdNotEquals}&conditionId.specified={conditionIdSpecified}&conditionId.in={conditionIdIn}&conditionId.notIn={conditionIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  Long countConditionDateItems(@QueryMap(encoded=true) CountConditionDateItemsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>countConditionDateItems</code> that receives the query parameters as a map,
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
          *   <li>specificDateGreaterThan -  (optional)</li>
          *   <li>specificDateLessThan -  (optional)</li>
          *   <li>specificDateGreaterThanOrEqual -  (optional)</li>
          *   <li>specificDateLessThanOrEqual -  (optional)</li>
          *   <li>specificDateEquals -  (optional)</li>
          *   <li>specificDateNotEquals -  (optional)</li>
          *   <li>specificDateSpecified -  (optional)</li>
          *   <li>specificDateIn -  (optional)</li>
          *   <li>specificDateNotIn -  (optional)</li>
          *   <li>weekdayGreaterThan -  (optional)</li>
          *   <li>weekdayLessThan -  (optional)</li>
          *   <li>weekdayGreaterThanOrEqual -  (optional)</li>
          *   <li>weekdayLessThanOrEqual -  (optional)</li>
          *   <li>weekdayEquals -  (optional)</li>
          *   <li>weekdayNotEquals -  (optional)</li>
          *   <li>weekdaySpecified -  (optional)</li>
          *   <li>weekdayIn -  (optional)</li>
          *   <li>weekdayNotIn -  (optional)</li>
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
      @RequestLine("GET /api/condition-date-items/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&specificDate.greaterThan={specificDateGreaterThan}&specificDate.lessThan={specificDateLessThan}&specificDate.greaterThanOrEqual={specificDateGreaterThanOrEqual}&specificDate.lessThanOrEqual={specificDateLessThanOrEqual}&specificDate.equals={specificDateEquals}&specificDate.notEquals={specificDateNotEquals}&specificDate.specified={specificDateSpecified}&specificDate.in={specificDateIn}&specificDate.notIn={specificDateNotIn}&weekday.greaterThan={weekdayGreaterThan}&weekday.lessThan={weekdayLessThan}&weekday.greaterThanOrEqual={weekdayGreaterThanOrEqual}&weekday.lessThanOrEqual={weekdayLessThanOrEqual}&weekday.equals={weekdayEquals}&weekday.notEquals={weekdayNotEquals}&weekday.specified={weekdaySpecified}&weekday.in={weekdayIn}&weekday.notIn={weekdayNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&conditionId.greaterThan={conditionIdGreaterThan}&conditionId.lessThan={conditionIdLessThan}&conditionId.greaterThanOrEqual={conditionIdGreaterThanOrEqual}&conditionId.lessThanOrEqual={conditionIdLessThanOrEqual}&conditionId.equals={conditionIdEquals}&conditionId.notEquals={conditionIdNotEquals}&conditionId.specified={conditionIdSpecified}&conditionId.in={conditionIdIn}&conditionId.notIn={conditionIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Long> countConditionDateItemsWithHttpInfo(@QueryMap(encoded=true) CountConditionDateItemsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>countConditionDateItems</code> method in a fluent style.
   */
  public static class CountConditionDateItemsQueryParams extends HashMap<String, Object> {
    public CountConditionDateItemsQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionDateItemsQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionDateItemsQueryParams specificDateGreaterThan(@jakarta.annotation.Nullable final LocalDate value) {
      put("specificDate.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams specificDateLessThan(@jakarta.annotation.Nullable final LocalDate value) {
      put("specificDate.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams specificDateGreaterThanOrEqual(@jakarta.annotation.Nullable final LocalDate value) {
      put("specificDate.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams specificDateLessThanOrEqual(@jakarta.annotation.Nullable final LocalDate value) {
      put("specificDate.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams specificDateEquals(@jakarta.annotation.Nullable final LocalDate value) {
      put("specificDate.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams specificDateNotEquals(@jakarta.annotation.Nullable final LocalDate value) {
      put("specificDate.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams specificDateSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("specificDate.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams specificDateIn(@jakarta.annotation.Nullable final List<LocalDate> value) {
      put("specificDate.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionDateItemsQueryParams specificDateNotIn(@jakarta.annotation.Nullable final List<LocalDate> value) {
      put("specificDate.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionDateItemsQueryParams weekdayGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("weekday.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams weekdayLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("weekday.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams weekdayGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("weekday.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams weekdayLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("weekday.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams weekdayEquals(@jakarta.annotation.Nullable final Integer value) {
      put("weekday.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams weekdayNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("weekday.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams weekdaySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("weekday.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams weekdayIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("weekday.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionDateItemsQueryParams weekdayNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("weekday.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionDateItemsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionDateItemsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionDateItemsQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionDateItemsQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionDateItemsQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionDateItemsQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionDateItemsQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionDateItemsQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionDateItemsQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionDateItemsQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionDateItemsQueryParams conditionIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("conditionId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams conditionIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("conditionId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams conditionIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("conditionId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams conditionIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("conditionId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams conditionIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("conditionId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams conditionIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("conditionId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams conditionIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("conditionId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountConditionDateItemsQueryParams conditionIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("conditionId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionDateItemsQueryParams conditionIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("conditionId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountConditionDateItemsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param conditionDateItemDTO  (required)
   * @return ConditionDateItemDTO
   */
  @RequestLine("POST /api/condition-date-items")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ConditionDateItemDTO createConditionDateItem(@jakarta.annotation.Nonnull ConditionDateItemDTO conditionDateItemDTO);

  /**
   * 
   * Similar to <code>createConditionDateItem</code> but it also returns the http response headers .
   * 
   * @param conditionDateItemDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/condition-date-items")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<ConditionDateItemDTO> createConditionDateItemWithHttpInfo(@jakarta.annotation.Nonnull ConditionDateItemDTO conditionDateItemDTO);



  /**
   * 
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/condition-date-items/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteConditionDateItem(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>deleteConditionDateItem</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/condition-date-items/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteConditionDateItemWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



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
   * @param specificDateGreaterThan  (optional)
   * @param specificDateLessThan  (optional)
   * @param specificDateGreaterThanOrEqual  (optional)
   * @param specificDateLessThanOrEqual  (optional)
   * @param specificDateEquals  (optional)
   * @param specificDateNotEquals  (optional)
   * @param specificDateSpecified  (optional)
   * @param specificDateIn  (optional)
   * @param specificDateNotIn  (optional)
   * @param weekdayGreaterThan  (optional)
   * @param weekdayLessThan  (optional)
   * @param weekdayGreaterThanOrEqual  (optional)
   * @param weekdayLessThanOrEqual  (optional)
   * @param weekdayEquals  (optional)
   * @param weekdayNotEquals  (optional)
   * @param weekdaySpecified  (optional)
   * @param weekdayIn  (optional)
   * @param weekdayNotIn  (optional)
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
   * @return List&lt;ConditionDateItemDTO&gt;
   */
  @RequestLine("GET /api/condition-date-items?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&specificDate.greaterThan={specificDateGreaterThan}&specificDate.lessThan={specificDateLessThan}&specificDate.greaterThanOrEqual={specificDateGreaterThanOrEqual}&specificDate.lessThanOrEqual={specificDateLessThanOrEqual}&specificDate.equals={specificDateEquals}&specificDate.notEquals={specificDateNotEquals}&specificDate.specified={specificDateSpecified}&specificDate.in={specificDateIn}&specificDate.notIn={specificDateNotIn}&weekday.greaterThan={weekdayGreaterThan}&weekday.lessThan={weekdayLessThan}&weekday.greaterThanOrEqual={weekdayGreaterThanOrEqual}&weekday.lessThanOrEqual={weekdayLessThanOrEqual}&weekday.equals={weekdayEquals}&weekday.notEquals={weekdayNotEquals}&weekday.specified={weekdaySpecified}&weekday.in={weekdayIn}&weekday.notIn={weekdayNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&conditionId.greaterThan={conditionIdGreaterThan}&conditionId.lessThan={conditionIdLessThan}&conditionId.greaterThanOrEqual={conditionIdGreaterThanOrEqual}&conditionId.lessThanOrEqual={conditionIdLessThanOrEqual}&conditionId.equals={conditionIdEquals}&conditionId.notEquals={conditionIdNotEquals}&conditionId.specified={conditionIdSpecified}&conditionId.in={conditionIdIn}&conditionId.notIn={conditionIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  List<ConditionDateItemDTO> getAllConditionDateItems(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("specificDateGreaterThan") @jakarta.annotation.Nullable LocalDate specificDateGreaterThan, @Param("specificDateLessThan") @jakarta.annotation.Nullable LocalDate specificDateLessThan, @Param("specificDateGreaterThanOrEqual") @jakarta.annotation.Nullable LocalDate specificDateGreaterThanOrEqual, @Param("specificDateLessThanOrEqual") @jakarta.annotation.Nullable LocalDate specificDateLessThanOrEqual, @Param("specificDateEquals") @jakarta.annotation.Nullable LocalDate specificDateEquals, @Param("specificDateNotEquals") @jakarta.annotation.Nullable LocalDate specificDateNotEquals, @Param("specificDateSpecified") @jakarta.annotation.Nullable Boolean specificDateSpecified, @Param("specificDateIn") @jakarta.annotation.Nullable List<LocalDate> specificDateIn, @Param("specificDateNotIn") @jakarta.annotation.Nullable List<LocalDate> specificDateNotIn, @Param("weekdayGreaterThan") @jakarta.annotation.Nullable Integer weekdayGreaterThan, @Param("weekdayLessThan") @jakarta.annotation.Nullable Integer weekdayLessThan, @Param("weekdayGreaterThanOrEqual") @jakarta.annotation.Nullable Integer weekdayGreaterThanOrEqual, @Param("weekdayLessThanOrEqual") @jakarta.annotation.Nullable Integer weekdayLessThanOrEqual, @Param("weekdayEquals") @jakarta.annotation.Nullable Integer weekdayEquals, @Param("weekdayNotEquals") @jakarta.annotation.Nullable Integer weekdayNotEquals, @Param("weekdaySpecified") @jakarta.annotation.Nullable Boolean weekdaySpecified, @Param("weekdayIn") @jakarta.annotation.Nullable List<Integer> weekdayIn, @Param("weekdayNotIn") @jakarta.annotation.Nullable List<Integer> weekdayNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("conditionIdGreaterThan") @jakarta.annotation.Nullable Long conditionIdGreaterThan, @Param("conditionIdLessThan") @jakarta.annotation.Nullable Long conditionIdLessThan, @Param("conditionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long conditionIdGreaterThanOrEqual, @Param("conditionIdLessThanOrEqual") @jakarta.annotation.Nullable Long conditionIdLessThanOrEqual, @Param("conditionIdEquals") @jakarta.annotation.Nullable Long conditionIdEquals, @Param("conditionIdNotEquals") @jakarta.annotation.Nullable Long conditionIdNotEquals, @Param("conditionIdSpecified") @jakarta.annotation.Nullable Boolean conditionIdSpecified, @Param("conditionIdIn") @jakarta.annotation.Nullable List<Long> conditionIdIn, @Param("conditionIdNotIn") @jakarta.annotation.Nullable List<Long> conditionIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>getAllConditionDateItems</code> but it also returns the http response headers .
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
   * @param specificDateGreaterThan  (optional)
   * @param specificDateLessThan  (optional)
   * @param specificDateGreaterThanOrEqual  (optional)
   * @param specificDateLessThanOrEqual  (optional)
   * @param specificDateEquals  (optional)
   * @param specificDateNotEquals  (optional)
   * @param specificDateSpecified  (optional)
   * @param specificDateIn  (optional)
   * @param specificDateNotIn  (optional)
   * @param weekdayGreaterThan  (optional)
   * @param weekdayLessThan  (optional)
   * @param weekdayGreaterThanOrEqual  (optional)
   * @param weekdayLessThanOrEqual  (optional)
   * @param weekdayEquals  (optional)
   * @param weekdayNotEquals  (optional)
   * @param weekdaySpecified  (optional)
   * @param weekdayIn  (optional)
   * @param weekdayNotIn  (optional)
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
  @RequestLine("GET /api/condition-date-items?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&specificDate.greaterThan={specificDateGreaterThan}&specificDate.lessThan={specificDateLessThan}&specificDate.greaterThanOrEqual={specificDateGreaterThanOrEqual}&specificDate.lessThanOrEqual={specificDateLessThanOrEqual}&specificDate.equals={specificDateEquals}&specificDate.notEquals={specificDateNotEquals}&specificDate.specified={specificDateSpecified}&specificDate.in={specificDateIn}&specificDate.notIn={specificDateNotIn}&weekday.greaterThan={weekdayGreaterThan}&weekday.lessThan={weekdayLessThan}&weekday.greaterThanOrEqual={weekdayGreaterThanOrEqual}&weekday.lessThanOrEqual={weekdayLessThanOrEqual}&weekday.equals={weekdayEquals}&weekday.notEquals={weekdayNotEquals}&weekday.specified={weekdaySpecified}&weekday.in={weekdayIn}&weekday.notIn={weekdayNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&conditionId.greaterThan={conditionIdGreaterThan}&conditionId.lessThan={conditionIdLessThan}&conditionId.greaterThanOrEqual={conditionIdGreaterThanOrEqual}&conditionId.lessThanOrEqual={conditionIdLessThanOrEqual}&conditionId.equals={conditionIdEquals}&conditionId.notEquals={conditionIdNotEquals}&conditionId.specified={conditionIdSpecified}&conditionId.in={conditionIdIn}&conditionId.notIn={conditionIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<ConditionDateItemDTO>> getAllConditionDateItemsWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("specificDateGreaterThan") @jakarta.annotation.Nullable LocalDate specificDateGreaterThan, @Param("specificDateLessThan") @jakarta.annotation.Nullable LocalDate specificDateLessThan, @Param("specificDateGreaterThanOrEqual") @jakarta.annotation.Nullable LocalDate specificDateGreaterThanOrEqual, @Param("specificDateLessThanOrEqual") @jakarta.annotation.Nullable LocalDate specificDateLessThanOrEqual, @Param("specificDateEquals") @jakarta.annotation.Nullable LocalDate specificDateEquals, @Param("specificDateNotEquals") @jakarta.annotation.Nullable LocalDate specificDateNotEquals, @Param("specificDateSpecified") @jakarta.annotation.Nullable Boolean specificDateSpecified, @Param("specificDateIn") @jakarta.annotation.Nullable List<LocalDate> specificDateIn, @Param("specificDateNotIn") @jakarta.annotation.Nullable List<LocalDate> specificDateNotIn, @Param("weekdayGreaterThan") @jakarta.annotation.Nullable Integer weekdayGreaterThan, @Param("weekdayLessThan") @jakarta.annotation.Nullable Integer weekdayLessThan, @Param("weekdayGreaterThanOrEqual") @jakarta.annotation.Nullable Integer weekdayGreaterThanOrEqual, @Param("weekdayLessThanOrEqual") @jakarta.annotation.Nullable Integer weekdayLessThanOrEqual, @Param("weekdayEquals") @jakarta.annotation.Nullable Integer weekdayEquals, @Param("weekdayNotEquals") @jakarta.annotation.Nullable Integer weekdayNotEquals, @Param("weekdaySpecified") @jakarta.annotation.Nullable Boolean weekdaySpecified, @Param("weekdayIn") @jakarta.annotation.Nullable List<Integer> weekdayIn, @Param("weekdayNotIn") @jakarta.annotation.Nullable List<Integer> weekdayNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("conditionIdGreaterThan") @jakarta.annotation.Nullable Long conditionIdGreaterThan, @Param("conditionIdLessThan") @jakarta.annotation.Nullable Long conditionIdLessThan, @Param("conditionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long conditionIdGreaterThanOrEqual, @Param("conditionIdLessThanOrEqual") @jakarta.annotation.Nullable Long conditionIdLessThanOrEqual, @Param("conditionIdEquals") @jakarta.annotation.Nullable Long conditionIdEquals, @Param("conditionIdNotEquals") @jakarta.annotation.Nullable Long conditionIdNotEquals, @Param("conditionIdSpecified") @jakarta.annotation.Nullable Boolean conditionIdSpecified, @Param("conditionIdIn") @jakarta.annotation.Nullable List<Long> conditionIdIn, @Param("conditionIdNotIn") @jakarta.annotation.Nullable List<Long> conditionIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllConditionDateItems</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllConditionDateItemsQueryParams} class that allows for
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
   *   <li>specificDateGreaterThan -  (optional)</li>
   *   <li>specificDateLessThan -  (optional)</li>
   *   <li>specificDateGreaterThanOrEqual -  (optional)</li>
   *   <li>specificDateLessThanOrEqual -  (optional)</li>
   *   <li>specificDateEquals -  (optional)</li>
   *   <li>specificDateNotEquals -  (optional)</li>
   *   <li>specificDateSpecified -  (optional)</li>
   *   <li>specificDateIn -  (optional)</li>
   *   <li>specificDateNotIn -  (optional)</li>
   *   <li>weekdayGreaterThan -  (optional)</li>
   *   <li>weekdayLessThan -  (optional)</li>
   *   <li>weekdayGreaterThanOrEqual -  (optional)</li>
   *   <li>weekdayLessThanOrEqual -  (optional)</li>
   *   <li>weekdayEquals -  (optional)</li>
   *   <li>weekdayNotEquals -  (optional)</li>
   *   <li>weekdaySpecified -  (optional)</li>
   *   <li>weekdayIn -  (optional)</li>
   *   <li>weekdayNotIn -  (optional)</li>
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
   * @return List&lt;ConditionDateItemDTO&gt;
   */
  @RequestLine("GET /api/condition-date-items?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&specificDate.greaterThan={specificDateGreaterThan}&specificDate.lessThan={specificDateLessThan}&specificDate.greaterThanOrEqual={specificDateGreaterThanOrEqual}&specificDate.lessThanOrEqual={specificDateLessThanOrEqual}&specificDate.equals={specificDateEquals}&specificDate.notEquals={specificDateNotEquals}&specificDate.specified={specificDateSpecified}&specificDate.in={specificDateIn}&specificDate.notIn={specificDateNotIn}&weekday.greaterThan={weekdayGreaterThan}&weekday.lessThan={weekdayLessThan}&weekday.greaterThanOrEqual={weekdayGreaterThanOrEqual}&weekday.lessThanOrEqual={weekdayLessThanOrEqual}&weekday.equals={weekdayEquals}&weekday.notEquals={weekdayNotEquals}&weekday.specified={weekdaySpecified}&weekday.in={weekdayIn}&weekday.notIn={weekdayNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&conditionId.greaterThan={conditionIdGreaterThan}&conditionId.lessThan={conditionIdLessThan}&conditionId.greaterThanOrEqual={conditionIdGreaterThanOrEqual}&conditionId.lessThanOrEqual={conditionIdLessThanOrEqual}&conditionId.equals={conditionIdEquals}&conditionId.notEquals={conditionIdNotEquals}&conditionId.specified={conditionIdSpecified}&conditionId.in={conditionIdIn}&conditionId.notIn={conditionIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  List<ConditionDateItemDTO> getAllConditionDateItems(@QueryMap(encoded=true) GetAllConditionDateItemsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllConditionDateItems</code> that receives the query parameters as a map,
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
          *   <li>specificDateGreaterThan -  (optional)</li>
          *   <li>specificDateLessThan -  (optional)</li>
          *   <li>specificDateGreaterThanOrEqual -  (optional)</li>
          *   <li>specificDateLessThanOrEqual -  (optional)</li>
          *   <li>specificDateEquals -  (optional)</li>
          *   <li>specificDateNotEquals -  (optional)</li>
          *   <li>specificDateSpecified -  (optional)</li>
          *   <li>specificDateIn -  (optional)</li>
          *   <li>specificDateNotIn -  (optional)</li>
          *   <li>weekdayGreaterThan -  (optional)</li>
          *   <li>weekdayLessThan -  (optional)</li>
          *   <li>weekdayGreaterThanOrEqual -  (optional)</li>
          *   <li>weekdayLessThanOrEqual -  (optional)</li>
          *   <li>weekdayEquals -  (optional)</li>
          *   <li>weekdayNotEquals -  (optional)</li>
          *   <li>weekdaySpecified -  (optional)</li>
          *   <li>weekdayIn -  (optional)</li>
          *   <li>weekdayNotIn -  (optional)</li>
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
          * @return List&lt;ConditionDateItemDTO&gt;
      */
      @RequestLine("GET /api/condition-date-items?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&specificDate.greaterThan={specificDateGreaterThan}&specificDate.lessThan={specificDateLessThan}&specificDate.greaterThanOrEqual={specificDateGreaterThanOrEqual}&specificDate.lessThanOrEqual={specificDateLessThanOrEqual}&specificDate.equals={specificDateEquals}&specificDate.notEquals={specificDateNotEquals}&specificDate.specified={specificDateSpecified}&specificDate.in={specificDateIn}&specificDate.notIn={specificDateNotIn}&weekday.greaterThan={weekdayGreaterThan}&weekday.lessThan={weekdayLessThan}&weekday.greaterThanOrEqual={weekdayGreaterThanOrEqual}&weekday.lessThanOrEqual={weekdayLessThanOrEqual}&weekday.equals={weekdayEquals}&weekday.notEquals={weekdayNotEquals}&weekday.specified={weekdaySpecified}&weekday.in={weekdayIn}&weekday.notIn={weekdayNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&conditionId.greaterThan={conditionIdGreaterThan}&conditionId.lessThan={conditionIdLessThan}&conditionId.greaterThanOrEqual={conditionIdGreaterThanOrEqual}&conditionId.lessThanOrEqual={conditionIdLessThanOrEqual}&conditionId.equals={conditionIdEquals}&conditionId.notEquals={conditionIdNotEquals}&conditionId.specified={conditionIdSpecified}&conditionId.in={conditionIdIn}&conditionId.notIn={conditionIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<ConditionDateItemDTO>> getAllConditionDateItemsWithHttpInfo(@QueryMap(encoded=true) GetAllConditionDateItemsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllConditionDateItems</code> method in a fluent style.
   */
  public static class GetAllConditionDateItemsQueryParams extends HashMap<String, Object> {
    public GetAllConditionDateItemsQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionDateItemsQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionDateItemsQueryParams specificDateGreaterThan(@jakarta.annotation.Nullable final LocalDate value) {
      put("specificDate.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams specificDateLessThan(@jakarta.annotation.Nullable final LocalDate value) {
      put("specificDate.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams specificDateGreaterThanOrEqual(@jakarta.annotation.Nullable final LocalDate value) {
      put("specificDate.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams specificDateLessThanOrEqual(@jakarta.annotation.Nullable final LocalDate value) {
      put("specificDate.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams specificDateEquals(@jakarta.annotation.Nullable final LocalDate value) {
      put("specificDate.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams specificDateNotEquals(@jakarta.annotation.Nullable final LocalDate value) {
      put("specificDate.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams specificDateSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("specificDate.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams specificDateIn(@jakarta.annotation.Nullable final List<LocalDate> value) {
      put("specificDate.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionDateItemsQueryParams specificDateNotIn(@jakarta.annotation.Nullable final List<LocalDate> value) {
      put("specificDate.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionDateItemsQueryParams weekdayGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("weekday.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams weekdayLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("weekday.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams weekdayGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("weekday.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams weekdayLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("weekday.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams weekdayEquals(@jakarta.annotation.Nullable final Integer value) {
      put("weekday.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams weekdayNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("weekday.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams weekdaySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("weekday.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams weekdayIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("weekday.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionDateItemsQueryParams weekdayNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("weekday.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionDateItemsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionDateItemsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionDateItemsQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionDateItemsQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionDateItemsQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionDateItemsQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionDateItemsQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionDateItemsQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionDateItemsQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionDateItemsQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionDateItemsQueryParams conditionIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("conditionId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams conditionIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("conditionId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams conditionIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("conditionId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams conditionIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("conditionId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams conditionIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("conditionId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams conditionIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("conditionId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams conditionIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("conditionId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllConditionDateItemsQueryParams conditionIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("conditionId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionDateItemsQueryParams conditionIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("conditionId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllConditionDateItemsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @return ConditionDateItemDTO
   */
  @RequestLine("GET /api/condition-date-items/{id}")
  @Headers({
    "Accept: */*",
  })
  ConditionDateItemDTO getConditionDateItem(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>getConditionDateItem</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/condition-date-items/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<ConditionDateItemDTO> getConditionDateItemWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param id  (required)
   * @param conditionDateItemDTO  (required)
   * @return ConditionDateItemDTO
   */
  @RequestLine("PATCH /api/condition-date-items/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ConditionDateItemDTO partialUpdateConditionDateItem(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull ConditionDateItemDTO conditionDateItemDTO);

  /**
   * 
   * Similar to <code>partialUpdateConditionDateItem</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param conditionDateItemDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /api/condition-date-items/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<ConditionDateItemDTO> partialUpdateConditionDateItemWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull ConditionDateItemDTO conditionDateItemDTO);



  /**
   * 
   * 
   * @param id  (required)
   * @param conditionLocationItemDTO  (required)
   * @return ConditionDateItemDTO
   */
  @RequestLine("PUT /api/condition-date-items/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ConditionDateItemDTO updateConditionDateItem(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull ConditionLocationItemDTO conditionLocationItemDTO);

  /**
   * 
   * Similar to <code>updateConditionDateItem</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param conditionLocationItemDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/condition-date-items/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<ConditionDateItemDTO> updateConditionDateItemWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull ConditionLocationItemDTO conditionLocationItemDTO);


}
