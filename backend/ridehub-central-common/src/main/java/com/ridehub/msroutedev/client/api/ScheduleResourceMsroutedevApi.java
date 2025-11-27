package com.ridehub.msroutedev.client.api;

import com.ridehub.msroutedev.client.invoker.ApiClient;
import com.ridehub.msroutedev.client.invoker.EncodingUtils;
import com.ridehub.msroutedev.client.model.ApiResponse;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import com.ridehub.msroutedev.client.model.ScheduleDTO;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface ScheduleResourceMsroutedevApi extends ApiClient.Api {


  /**
   * 
   * 
   * @param idEquals  (optional)
   * @param idNotEquals  (optional)
   * @param idSpecified  (optional)
   * @param idIn  (optional)
   * @param idNotIn  (optional)
   * @param departureTimeGreaterThan  (optional)
   * @param departureTimeLessThan  (optional)
   * @param departureTimeGreaterThanOrEqual  (optional)
   * @param departureTimeLessThanOrEqual  (optional)
   * @param departureTimeEquals  (optional)
   * @param departureTimeNotEquals  (optional)
   * @param departureTimeSpecified  (optional)
   * @param departureTimeIn  (optional)
   * @param departureTimeNotIn  (optional)
   * @param arrivalTimeGreaterThan  (optional)
   * @param arrivalTimeLessThan  (optional)
   * @param arrivalTimeGreaterThanOrEqual  (optional)
   * @param arrivalTimeLessThanOrEqual  (optional)
   * @param arrivalTimeEquals  (optional)
   * @param arrivalTimeNotEquals  (optional)
   * @param arrivalTimeSpecified  (optional)
   * @param arrivalTimeIn  (optional)
   * @param arrivalTimeNotIn  (optional)
   * @param totalSeatsGreaterThan  (optional)
   * @param totalSeatsLessThan  (optional)
   * @param totalSeatsGreaterThanOrEqual  (optional)
   * @param totalSeatsLessThanOrEqual  (optional)
   * @param totalSeatsEquals  (optional)
   * @param totalSeatsNotEquals  (optional)
   * @param totalSeatsSpecified  (optional)
   * @param totalSeatsIn  (optional)
   * @param totalSeatsNotIn  (optional)
   * @param availableSeatsGreaterThan  (optional)
   * @param availableSeatsLessThan  (optional)
   * @param availableSeatsGreaterThanOrEqual  (optional)
   * @param availableSeatsLessThanOrEqual  (optional)
   * @param availableSeatsEquals  (optional)
   * @param availableSeatsNotEquals  (optional)
   * @param availableSeatsSpecified  (optional)
   * @param availableSeatsIn  (optional)
   * @param availableSeatsNotIn  (optional)
   * @param basePriceGreaterThan  (optional)
   * @param basePriceLessThan  (optional)
   * @param basePriceGreaterThanOrEqual  (optional)
   * @param basePriceLessThanOrEqual  (optional)
   * @param basePriceEquals  (optional)
   * @param basePriceNotEquals  (optional)
   * @param basePriceSpecified  (optional)
   * @param basePriceIn  (optional)
   * @param basePriceNotIn  (optional)
   * @param isActiveEquals  (optional)
   * @param isActiveNotEquals  (optional)
   * @param isActiveSpecified  (optional)
   * @param isActiveIn  (optional)
   * @param isActiveNotIn  (optional)
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
   * @param routeIdEquals  (optional)
   * @param routeIdNotEquals  (optional)
   * @param routeIdSpecified  (optional)
   * @param routeIdIn  (optional)
   * @param routeIdNotIn  (optional)
   * @param distinct  (optional)
   * @return Long
   */
  @RequestLine("GET /api/schedules/count?id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&departureTime.greaterThan={departureTimeGreaterThan}&departureTime.lessThan={departureTimeLessThan}&departureTime.greaterThanOrEqual={departureTimeGreaterThanOrEqual}&departureTime.lessThanOrEqual={departureTimeLessThanOrEqual}&departureTime.equals={departureTimeEquals}&departureTime.notEquals={departureTimeNotEquals}&departureTime.specified={departureTimeSpecified}&departureTime.in={departureTimeIn}&departureTime.notIn={departureTimeNotIn}&arrivalTime.greaterThan={arrivalTimeGreaterThan}&arrivalTime.lessThan={arrivalTimeLessThan}&arrivalTime.greaterThanOrEqual={arrivalTimeGreaterThanOrEqual}&arrivalTime.lessThanOrEqual={arrivalTimeLessThanOrEqual}&arrivalTime.equals={arrivalTimeEquals}&arrivalTime.notEquals={arrivalTimeNotEquals}&arrivalTime.specified={arrivalTimeSpecified}&arrivalTime.in={arrivalTimeIn}&arrivalTime.notIn={arrivalTimeNotIn}&totalSeats.greaterThan={totalSeatsGreaterThan}&totalSeats.lessThan={totalSeatsLessThan}&totalSeats.greaterThanOrEqual={totalSeatsGreaterThanOrEqual}&totalSeats.lessThanOrEqual={totalSeatsLessThanOrEqual}&totalSeats.equals={totalSeatsEquals}&totalSeats.notEquals={totalSeatsNotEquals}&totalSeats.specified={totalSeatsSpecified}&totalSeats.in={totalSeatsIn}&totalSeats.notIn={totalSeatsNotIn}&availableSeats.greaterThan={availableSeatsGreaterThan}&availableSeats.lessThan={availableSeatsLessThan}&availableSeats.greaterThanOrEqual={availableSeatsGreaterThanOrEqual}&availableSeats.lessThanOrEqual={availableSeatsLessThanOrEqual}&availableSeats.equals={availableSeatsEquals}&availableSeats.notEquals={availableSeatsNotEquals}&availableSeats.specified={availableSeatsSpecified}&availableSeats.in={availableSeatsIn}&availableSeats.notIn={availableSeatsNotIn}&basePrice.greaterThan={basePriceGreaterThan}&basePrice.lessThan={basePriceLessThan}&basePrice.greaterThanOrEqual={basePriceGreaterThanOrEqual}&basePrice.lessThanOrEqual={basePriceLessThanOrEqual}&basePrice.equals={basePriceEquals}&basePrice.notEquals={basePriceNotEquals}&basePrice.specified={basePriceSpecified}&basePrice.in={basePriceIn}&basePrice.notIn={basePriceNotIn}&isActive.equals={isActiveEquals}&isActive.notEquals={isActiveNotEquals}&isActive.specified={isActiveSpecified}&isActive.in={isActiveIn}&isActive.notIn={isActiveNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&routeId.equals={routeIdEquals}&routeId.notEquals={routeIdNotEquals}&routeId.specified={routeIdSpecified}&routeId.in={routeIdIn}&routeId.notIn={routeIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  Long countSchedules(@Param("idEquals") @jakarta.annotation.Nullable UUID idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable UUID idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<UUID> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<UUID> idNotIn, @Param("departureTimeGreaterThan") @jakarta.annotation.Nullable OffsetDateTime departureTimeGreaterThan, @Param("departureTimeLessThan") @jakarta.annotation.Nullable OffsetDateTime departureTimeLessThan, @Param("departureTimeGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime departureTimeGreaterThanOrEqual, @Param("departureTimeLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime departureTimeLessThanOrEqual, @Param("departureTimeEquals") @jakarta.annotation.Nullable OffsetDateTime departureTimeEquals, @Param("departureTimeNotEquals") @jakarta.annotation.Nullable OffsetDateTime departureTimeNotEquals, @Param("departureTimeSpecified") @jakarta.annotation.Nullable Boolean departureTimeSpecified, @Param("departureTimeIn") @jakarta.annotation.Nullable List<OffsetDateTime> departureTimeIn, @Param("departureTimeNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> departureTimeNotIn, @Param("arrivalTimeGreaterThan") @jakarta.annotation.Nullable OffsetDateTime arrivalTimeGreaterThan, @Param("arrivalTimeLessThan") @jakarta.annotation.Nullable OffsetDateTime arrivalTimeLessThan, @Param("arrivalTimeGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime arrivalTimeGreaterThanOrEqual, @Param("arrivalTimeLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime arrivalTimeLessThanOrEqual, @Param("arrivalTimeEquals") @jakarta.annotation.Nullable OffsetDateTime arrivalTimeEquals, @Param("arrivalTimeNotEquals") @jakarta.annotation.Nullable OffsetDateTime arrivalTimeNotEquals, @Param("arrivalTimeSpecified") @jakarta.annotation.Nullable Boolean arrivalTimeSpecified, @Param("arrivalTimeIn") @jakarta.annotation.Nullable List<OffsetDateTime> arrivalTimeIn, @Param("arrivalTimeNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> arrivalTimeNotIn, @Param("totalSeatsGreaterThan") @jakarta.annotation.Nullable Integer totalSeatsGreaterThan, @Param("totalSeatsLessThan") @jakarta.annotation.Nullable Integer totalSeatsLessThan, @Param("totalSeatsGreaterThanOrEqual") @jakarta.annotation.Nullable Integer totalSeatsGreaterThanOrEqual, @Param("totalSeatsLessThanOrEqual") @jakarta.annotation.Nullable Integer totalSeatsLessThanOrEqual, @Param("totalSeatsEquals") @jakarta.annotation.Nullable Integer totalSeatsEquals, @Param("totalSeatsNotEquals") @jakarta.annotation.Nullable Integer totalSeatsNotEquals, @Param("totalSeatsSpecified") @jakarta.annotation.Nullable Boolean totalSeatsSpecified, @Param("totalSeatsIn") @jakarta.annotation.Nullable List<Integer> totalSeatsIn, @Param("totalSeatsNotIn") @jakarta.annotation.Nullable List<Integer> totalSeatsNotIn, @Param("availableSeatsGreaterThan") @jakarta.annotation.Nullable Integer availableSeatsGreaterThan, @Param("availableSeatsLessThan") @jakarta.annotation.Nullable Integer availableSeatsLessThan, @Param("availableSeatsGreaterThanOrEqual") @jakarta.annotation.Nullable Integer availableSeatsGreaterThanOrEqual, @Param("availableSeatsLessThanOrEqual") @jakarta.annotation.Nullable Integer availableSeatsLessThanOrEqual, @Param("availableSeatsEquals") @jakarta.annotation.Nullable Integer availableSeatsEquals, @Param("availableSeatsNotEquals") @jakarta.annotation.Nullable Integer availableSeatsNotEquals, @Param("availableSeatsSpecified") @jakarta.annotation.Nullable Boolean availableSeatsSpecified, @Param("availableSeatsIn") @jakarta.annotation.Nullable List<Integer> availableSeatsIn, @Param("availableSeatsNotIn") @jakarta.annotation.Nullable List<Integer> availableSeatsNotIn, @Param("basePriceGreaterThan") @jakarta.annotation.Nullable BigDecimal basePriceGreaterThan, @Param("basePriceLessThan") @jakarta.annotation.Nullable BigDecimal basePriceLessThan, @Param("basePriceGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal basePriceGreaterThanOrEqual, @Param("basePriceLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal basePriceLessThanOrEqual, @Param("basePriceEquals") @jakarta.annotation.Nullable BigDecimal basePriceEquals, @Param("basePriceNotEquals") @jakarta.annotation.Nullable BigDecimal basePriceNotEquals, @Param("basePriceSpecified") @jakarta.annotation.Nullable Boolean basePriceSpecified, @Param("basePriceIn") @jakarta.annotation.Nullable List<BigDecimal> basePriceIn, @Param("basePriceNotIn") @jakarta.annotation.Nullable List<BigDecimal> basePriceNotIn, @Param("isActiveEquals") @jakarta.annotation.Nullable Boolean isActiveEquals, @Param("isActiveNotEquals") @jakarta.annotation.Nullable Boolean isActiveNotEquals, @Param("isActiveSpecified") @jakarta.annotation.Nullable Boolean isActiveSpecified, @Param("isActiveIn") @jakarta.annotation.Nullable List<Boolean> isActiveIn, @Param("isActiveNotIn") @jakarta.annotation.Nullable List<Boolean> isActiveNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("routeIdEquals") @jakarta.annotation.Nullable UUID routeIdEquals, @Param("routeIdNotEquals") @jakarta.annotation.Nullable UUID routeIdNotEquals, @Param("routeIdSpecified") @jakarta.annotation.Nullable Boolean routeIdSpecified, @Param("routeIdIn") @jakarta.annotation.Nullable List<UUID> routeIdIn, @Param("routeIdNotIn") @jakarta.annotation.Nullable List<UUID> routeIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>countSchedules</code> but it also returns the http response headers .
   * 
   * @param idEquals  (optional)
   * @param idNotEquals  (optional)
   * @param idSpecified  (optional)
   * @param idIn  (optional)
   * @param idNotIn  (optional)
   * @param departureTimeGreaterThan  (optional)
   * @param departureTimeLessThan  (optional)
   * @param departureTimeGreaterThanOrEqual  (optional)
   * @param departureTimeLessThanOrEqual  (optional)
   * @param departureTimeEquals  (optional)
   * @param departureTimeNotEquals  (optional)
   * @param departureTimeSpecified  (optional)
   * @param departureTimeIn  (optional)
   * @param departureTimeNotIn  (optional)
   * @param arrivalTimeGreaterThan  (optional)
   * @param arrivalTimeLessThan  (optional)
   * @param arrivalTimeGreaterThanOrEqual  (optional)
   * @param arrivalTimeLessThanOrEqual  (optional)
   * @param arrivalTimeEquals  (optional)
   * @param arrivalTimeNotEquals  (optional)
   * @param arrivalTimeSpecified  (optional)
   * @param arrivalTimeIn  (optional)
   * @param arrivalTimeNotIn  (optional)
   * @param totalSeatsGreaterThan  (optional)
   * @param totalSeatsLessThan  (optional)
   * @param totalSeatsGreaterThanOrEqual  (optional)
   * @param totalSeatsLessThanOrEqual  (optional)
   * @param totalSeatsEquals  (optional)
   * @param totalSeatsNotEquals  (optional)
   * @param totalSeatsSpecified  (optional)
   * @param totalSeatsIn  (optional)
   * @param totalSeatsNotIn  (optional)
   * @param availableSeatsGreaterThan  (optional)
   * @param availableSeatsLessThan  (optional)
   * @param availableSeatsGreaterThanOrEqual  (optional)
   * @param availableSeatsLessThanOrEqual  (optional)
   * @param availableSeatsEquals  (optional)
   * @param availableSeatsNotEquals  (optional)
   * @param availableSeatsSpecified  (optional)
   * @param availableSeatsIn  (optional)
   * @param availableSeatsNotIn  (optional)
   * @param basePriceGreaterThan  (optional)
   * @param basePriceLessThan  (optional)
   * @param basePriceGreaterThanOrEqual  (optional)
   * @param basePriceLessThanOrEqual  (optional)
   * @param basePriceEquals  (optional)
   * @param basePriceNotEquals  (optional)
   * @param basePriceSpecified  (optional)
   * @param basePriceIn  (optional)
   * @param basePriceNotIn  (optional)
   * @param isActiveEquals  (optional)
   * @param isActiveNotEquals  (optional)
   * @param isActiveSpecified  (optional)
   * @param isActiveIn  (optional)
   * @param isActiveNotIn  (optional)
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
   * @param routeIdEquals  (optional)
   * @param routeIdNotEquals  (optional)
   * @param routeIdSpecified  (optional)
   * @param routeIdIn  (optional)
   * @param routeIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/schedules/count?id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&departureTime.greaterThan={departureTimeGreaterThan}&departureTime.lessThan={departureTimeLessThan}&departureTime.greaterThanOrEqual={departureTimeGreaterThanOrEqual}&departureTime.lessThanOrEqual={departureTimeLessThanOrEqual}&departureTime.equals={departureTimeEquals}&departureTime.notEquals={departureTimeNotEquals}&departureTime.specified={departureTimeSpecified}&departureTime.in={departureTimeIn}&departureTime.notIn={departureTimeNotIn}&arrivalTime.greaterThan={arrivalTimeGreaterThan}&arrivalTime.lessThan={arrivalTimeLessThan}&arrivalTime.greaterThanOrEqual={arrivalTimeGreaterThanOrEqual}&arrivalTime.lessThanOrEqual={arrivalTimeLessThanOrEqual}&arrivalTime.equals={arrivalTimeEquals}&arrivalTime.notEquals={arrivalTimeNotEquals}&arrivalTime.specified={arrivalTimeSpecified}&arrivalTime.in={arrivalTimeIn}&arrivalTime.notIn={arrivalTimeNotIn}&totalSeats.greaterThan={totalSeatsGreaterThan}&totalSeats.lessThan={totalSeatsLessThan}&totalSeats.greaterThanOrEqual={totalSeatsGreaterThanOrEqual}&totalSeats.lessThanOrEqual={totalSeatsLessThanOrEqual}&totalSeats.equals={totalSeatsEquals}&totalSeats.notEquals={totalSeatsNotEquals}&totalSeats.specified={totalSeatsSpecified}&totalSeats.in={totalSeatsIn}&totalSeats.notIn={totalSeatsNotIn}&availableSeats.greaterThan={availableSeatsGreaterThan}&availableSeats.lessThan={availableSeatsLessThan}&availableSeats.greaterThanOrEqual={availableSeatsGreaterThanOrEqual}&availableSeats.lessThanOrEqual={availableSeatsLessThanOrEqual}&availableSeats.equals={availableSeatsEquals}&availableSeats.notEquals={availableSeatsNotEquals}&availableSeats.specified={availableSeatsSpecified}&availableSeats.in={availableSeatsIn}&availableSeats.notIn={availableSeatsNotIn}&basePrice.greaterThan={basePriceGreaterThan}&basePrice.lessThan={basePriceLessThan}&basePrice.greaterThanOrEqual={basePriceGreaterThanOrEqual}&basePrice.lessThanOrEqual={basePriceLessThanOrEqual}&basePrice.equals={basePriceEquals}&basePrice.notEquals={basePriceNotEquals}&basePrice.specified={basePriceSpecified}&basePrice.in={basePriceIn}&basePrice.notIn={basePriceNotIn}&isActive.equals={isActiveEquals}&isActive.notEquals={isActiveNotEquals}&isActive.specified={isActiveSpecified}&isActive.in={isActiveIn}&isActive.notIn={isActiveNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&routeId.equals={routeIdEquals}&routeId.notEquals={routeIdNotEquals}&routeId.specified={routeIdSpecified}&routeId.in={routeIdIn}&routeId.notIn={routeIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Long> countSchedulesWithHttpInfo(@Param("idEquals") @jakarta.annotation.Nullable UUID idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable UUID idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<UUID> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<UUID> idNotIn, @Param("departureTimeGreaterThan") @jakarta.annotation.Nullable OffsetDateTime departureTimeGreaterThan, @Param("departureTimeLessThan") @jakarta.annotation.Nullable OffsetDateTime departureTimeLessThan, @Param("departureTimeGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime departureTimeGreaterThanOrEqual, @Param("departureTimeLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime departureTimeLessThanOrEqual, @Param("departureTimeEquals") @jakarta.annotation.Nullable OffsetDateTime departureTimeEquals, @Param("departureTimeNotEquals") @jakarta.annotation.Nullable OffsetDateTime departureTimeNotEquals, @Param("departureTimeSpecified") @jakarta.annotation.Nullable Boolean departureTimeSpecified, @Param("departureTimeIn") @jakarta.annotation.Nullable List<OffsetDateTime> departureTimeIn, @Param("departureTimeNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> departureTimeNotIn, @Param("arrivalTimeGreaterThan") @jakarta.annotation.Nullable OffsetDateTime arrivalTimeGreaterThan, @Param("arrivalTimeLessThan") @jakarta.annotation.Nullable OffsetDateTime arrivalTimeLessThan, @Param("arrivalTimeGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime arrivalTimeGreaterThanOrEqual, @Param("arrivalTimeLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime arrivalTimeLessThanOrEqual, @Param("arrivalTimeEquals") @jakarta.annotation.Nullable OffsetDateTime arrivalTimeEquals, @Param("arrivalTimeNotEquals") @jakarta.annotation.Nullable OffsetDateTime arrivalTimeNotEquals, @Param("arrivalTimeSpecified") @jakarta.annotation.Nullable Boolean arrivalTimeSpecified, @Param("arrivalTimeIn") @jakarta.annotation.Nullable List<OffsetDateTime> arrivalTimeIn, @Param("arrivalTimeNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> arrivalTimeNotIn, @Param("totalSeatsGreaterThan") @jakarta.annotation.Nullable Integer totalSeatsGreaterThan, @Param("totalSeatsLessThan") @jakarta.annotation.Nullable Integer totalSeatsLessThan, @Param("totalSeatsGreaterThanOrEqual") @jakarta.annotation.Nullable Integer totalSeatsGreaterThanOrEqual, @Param("totalSeatsLessThanOrEqual") @jakarta.annotation.Nullable Integer totalSeatsLessThanOrEqual, @Param("totalSeatsEquals") @jakarta.annotation.Nullable Integer totalSeatsEquals, @Param("totalSeatsNotEquals") @jakarta.annotation.Nullable Integer totalSeatsNotEquals, @Param("totalSeatsSpecified") @jakarta.annotation.Nullable Boolean totalSeatsSpecified, @Param("totalSeatsIn") @jakarta.annotation.Nullable List<Integer> totalSeatsIn, @Param("totalSeatsNotIn") @jakarta.annotation.Nullable List<Integer> totalSeatsNotIn, @Param("availableSeatsGreaterThan") @jakarta.annotation.Nullable Integer availableSeatsGreaterThan, @Param("availableSeatsLessThan") @jakarta.annotation.Nullable Integer availableSeatsLessThan, @Param("availableSeatsGreaterThanOrEqual") @jakarta.annotation.Nullable Integer availableSeatsGreaterThanOrEqual, @Param("availableSeatsLessThanOrEqual") @jakarta.annotation.Nullable Integer availableSeatsLessThanOrEqual, @Param("availableSeatsEquals") @jakarta.annotation.Nullable Integer availableSeatsEquals, @Param("availableSeatsNotEquals") @jakarta.annotation.Nullable Integer availableSeatsNotEquals, @Param("availableSeatsSpecified") @jakarta.annotation.Nullable Boolean availableSeatsSpecified, @Param("availableSeatsIn") @jakarta.annotation.Nullable List<Integer> availableSeatsIn, @Param("availableSeatsNotIn") @jakarta.annotation.Nullable List<Integer> availableSeatsNotIn, @Param("basePriceGreaterThan") @jakarta.annotation.Nullable BigDecimal basePriceGreaterThan, @Param("basePriceLessThan") @jakarta.annotation.Nullable BigDecimal basePriceLessThan, @Param("basePriceGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal basePriceGreaterThanOrEqual, @Param("basePriceLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal basePriceLessThanOrEqual, @Param("basePriceEquals") @jakarta.annotation.Nullable BigDecimal basePriceEquals, @Param("basePriceNotEquals") @jakarta.annotation.Nullable BigDecimal basePriceNotEquals, @Param("basePriceSpecified") @jakarta.annotation.Nullable Boolean basePriceSpecified, @Param("basePriceIn") @jakarta.annotation.Nullable List<BigDecimal> basePriceIn, @Param("basePriceNotIn") @jakarta.annotation.Nullable List<BigDecimal> basePriceNotIn, @Param("isActiveEquals") @jakarta.annotation.Nullable Boolean isActiveEquals, @Param("isActiveNotEquals") @jakarta.annotation.Nullable Boolean isActiveNotEquals, @Param("isActiveSpecified") @jakarta.annotation.Nullable Boolean isActiveSpecified, @Param("isActiveIn") @jakarta.annotation.Nullable List<Boolean> isActiveIn, @Param("isActiveNotIn") @jakarta.annotation.Nullable List<Boolean> isActiveNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("routeIdEquals") @jakarta.annotation.Nullable UUID routeIdEquals, @Param("routeIdNotEquals") @jakarta.annotation.Nullable UUID routeIdNotEquals, @Param("routeIdSpecified") @jakarta.annotation.Nullable Boolean routeIdSpecified, @Param("routeIdIn") @jakarta.annotation.Nullable List<UUID> routeIdIn, @Param("routeIdNotIn") @jakarta.annotation.Nullable List<UUID> routeIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>countSchedules</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CountSchedulesQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>idEquals -  (optional)</li>
   *   <li>idNotEquals -  (optional)</li>
   *   <li>idSpecified -  (optional)</li>
   *   <li>idIn -  (optional)</li>
   *   <li>idNotIn -  (optional)</li>
   *   <li>departureTimeGreaterThan -  (optional)</li>
   *   <li>departureTimeLessThan -  (optional)</li>
   *   <li>departureTimeGreaterThanOrEqual -  (optional)</li>
   *   <li>departureTimeLessThanOrEqual -  (optional)</li>
   *   <li>departureTimeEquals -  (optional)</li>
   *   <li>departureTimeNotEquals -  (optional)</li>
   *   <li>departureTimeSpecified -  (optional)</li>
   *   <li>departureTimeIn -  (optional)</li>
   *   <li>departureTimeNotIn -  (optional)</li>
   *   <li>arrivalTimeGreaterThan -  (optional)</li>
   *   <li>arrivalTimeLessThan -  (optional)</li>
   *   <li>arrivalTimeGreaterThanOrEqual -  (optional)</li>
   *   <li>arrivalTimeLessThanOrEqual -  (optional)</li>
   *   <li>arrivalTimeEquals -  (optional)</li>
   *   <li>arrivalTimeNotEquals -  (optional)</li>
   *   <li>arrivalTimeSpecified -  (optional)</li>
   *   <li>arrivalTimeIn -  (optional)</li>
   *   <li>arrivalTimeNotIn -  (optional)</li>
   *   <li>totalSeatsGreaterThan -  (optional)</li>
   *   <li>totalSeatsLessThan -  (optional)</li>
   *   <li>totalSeatsGreaterThanOrEqual -  (optional)</li>
   *   <li>totalSeatsLessThanOrEqual -  (optional)</li>
   *   <li>totalSeatsEquals -  (optional)</li>
   *   <li>totalSeatsNotEquals -  (optional)</li>
   *   <li>totalSeatsSpecified -  (optional)</li>
   *   <li>totalSeatsIn -  (optional)</li>
   *   <li>totalSeatsNotIn -  (optional)</li>
   *   <li>availableSeatsGreaterThan -  (optional)</li>
   *   <li>availableSeatsLessThan -  (optional)</li>
   *   <li>availableSeatsGreaterThanOrEqual -  (optional)</li>
   *   <li>availableSeatsLessThanOrEqual -  (optional)</li>
   *   <li>availableSeatsEquals -  (optional)</li>
   *   <li>availableSeatsNotEquals -  (optional)</li>
   *   <li>availableSeatsSpecified -  (optional)</li>
   *   <li>availableSeatsIn -  (optional)</li>
   *   <li>availableSeatsNotIn -  (optional)</li>
   *   <li>basePriceGreaterThan -  (optional)</li>
   *   <li>basePriceLessThan -  (optional)</li>
   *   <li>basePriceGreaterThanOrEqual -  (optional)</li>
   *   <li>basePriceLessThanOrEqual -  (optional)</li>
   *   <li>basePriceEquals -  (optional)</li>
   *   <li>basePriceNotEquals -  (optional)</li>
   *   <li>basePriceSpecified -  (optional)</li>
   *   <li>basePriceIn -  (optional)</li>
   *   <li>basePriceNotIn -  (optional)</li>
   *   <li>isActiveEquals -  (optional)</li>
   *   <li>isActiveNotEquals -  (optional)</li>
   *   <li>isActiveSpecified -  (optional)</li>
   *   <li>isActiveIn -  (optional)</li>
   *   <li>isActiveNotIn -  (optional)</li>
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
   *   <li>routeIdEquals -  (optional)</li>
   *   <li>routeIdNotEquals -  (optional)</li>
   *   <li>routeIdSpecified -  (optional)</li>
   *   <li>routeIdIn -  (optional)</li>
   *   <li>routeIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return Long
   */
  @RequestLine("GET /api/schedules/count?id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&departureTime.greaterThan={departureTimeGreaterThan}&departureTime.lessThan={departureTimeLessThan}&departureTime.greaterThanOrEqual={departureTimeGreaterThanOrEqual}&departureTime.lessThanOrEqual={departureTimeLessThanOrEqual}&departureTime.equals={departureTimeEquals}&departureTime.notEquals={departureTimeNotEquals}&departureTime.specified={departureTimeSpecified}&departureTime.in={departureTimeIn}&departureTime.notIn={departureTimeNotIn}&arrivalTime.greaterThan={arrivalTimeGreaterThan}&arrivalTime.lessThan={arrivalTimeLessThan}&arrivalTime.greaterThanOrEqual={arrivalTimeGreaterThanOrEqual}&arrivalTime.lessThanOrEqual={arrivalTimeLessThanOrEqual}&arrivalTime.equals={arrivalTimeEquals}&arrivalTime.notEquals={arrivalTimeNotEquals}&arrivalTime.specified={arrivalTimeSpecified}&arrivalTime.in={arrivalTimeIn}&arrivalTime.notIn={arrivalTimeNotIn}&totalSeats.greaterThan={totalSeatsGreaterThan}&totalSeats.lessThan={totalSeatsLessThan}&totalSeats.greaterThanOrEqual={totalSeatsGreaterThanOrEqual}&totalSeats.lessThanOrEqual={totalSeatsLessThanOrEqual}&totalSeats.equals={totalSeatsEquals}&totalSeats.notEquals={totalSeatsNotEquals}&totalSeats.specified={totalSeatsSpecified}&totalSeats.in={totalSeatsIn}&totalSeats.notIn={totalSeatsNotIn}&availableSeats.greaterThan={availableSeatsGreaterThan}&availableSeats.lessThan={availableSeatsLessThan}&availableSeats.greaterThanOrEqual={availableSeatsGreaterThanOrEqual}&availableSeats.lessThanOrEqual={availableSeatsLessThanOrEqual}&availableSeats.equals={availableSeatsEquals}&availableSeats.notEquals={availableSeatsNotEquals}&availableSeats.specified={availableSeatsSpecified}&availableSeats.in={availableSeatsIn}&availableSeats.notIn={availableSeatsNotIn}&basePrice.greaterThan={basePriceGreaterThan}&basePrice.lessThan={basePriceLessThan}&basePrice.greaterThanOrEqual={basePriceGreaterThanOrEqual}&basePrice.lessThanOrEqual={basePriceLessThanOrEqual}&basePrice.equals={basePriceEquals}&basePrice.notEquals={basePriceNotEquals}&basePrice.specified={basePriceSpecified}&basePrice.in={basePriceIn}&basePrice.notIn={basePriceNotIn}&isActive.equals={isActiveEquals}&isActive.notEquals={isActiveNotEquals}&isActive.specified={isActiveSpecified}&isActive.in={isActiveIn}&isActive.notIn={isActiveNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&routeId.equals={routeIdEquals}&routeId.notEquals={routeIdNotEquals}&routeId.specified={routeIdSpecified}&routeId.in={routeIdIn}&routeId.notIn={routeIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  Long countSchedules(@QueryMap(encoded=true) CountSchedulesQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>countSchedules</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>idEquals -  (optional)</li>
          *   <li>idNotEquals -  (optional)</li>
          *   <li>idSpecified -  (optional)</li>
          *   <li>idIn -  (optional)</li>
          *   <li>idNotIn -  (optional)</li>
          *   <li>departureTimeGreaterThan -  (optional)</li>
          *   <li>departureTimeLessThan -  (optional)</li>
          *   <li>departureTimeGreaterThanOrEqual -  (optional)</li>
          *   <li>departureTimeLessThanOrEqual -  (optional)</li>
          *   <li>departureTimeEquals -  (optional)</li>
          *   <li>departureTimeNotEquals -  (optional)</li>
          *   <li>departureTimeSpecified -  (optional)</li>
          *   <li>departureTimeIn -  (optional)</li>
          *   <li>departureTimeNotIn -  (optional)</li>
          *   <li>arrivalTimeGreaterThan -  (optional)</li>
          *   <li>arrivalTimeLessThan -  (optional)</li>
          *   <li>arrivalTimeGreaterThanOrEqual -  (optional)</li>
          *   <li>arrivalTimeLessThanOrEqual -  (optional)</li>
          *   <li>arrivalTimeEquals -  (optional)</li>
          *   <li>arrivalTimeNotEquals -  (optional)</li>
          *   <li>arrivalTimeSpecified -  (optional)</li>
          *   <li>arrivalTimeIn -  (optional)</li>
          *   <li>arrivalTimeNotIn -  (optional)</li>
          *   <li>totalSeatsGreaterThan -  (optional)</li>
          *   <li>totalSeatsLessThan -  (optional)</li>
          *   <li>totalSeatsGreaterThanOrEqual -  (optional)</li>
          *   <li>totalSeatsLessThanOrEqual -  (optional)</li>
          *   <li>totalSeatsEquals -  (optional)</li>
          *   <li>totalSeatsNotEquals -  (optional)</li>
          *   <li>totalSeatsSpecified -  (optional)</li>
          *   <li>totalSeatsIn -  (optional)</li>
          *   <li>totalSeatsNotIn -  (optional)</li>
          *   <li>availableSeatsGreaterThan -  (optional)</li>
          *   <li>availableSeatsLessThan -  (optional)</li>
          *   <li>availableSeatsGreaterThanOrEqual -  (optional)</li>
          *   <li>availableSeatsLessThanOrEqual -  (optional)</li>
          *   <li>availableSeatsEquals -  (optional)</li>
          *   <li>availableSeatsNotEquals -  (optional)</li>
          *   <li>availableSeatsSpecified -  (optional)</li>
          *   <li>availableSeatsIn -  (optional)</li>
          *   <li>availableSeatsNotIn -  (optional)</li>
          *   <li>basePriceGreaterThan -  (optional)</li>
          *   <li>basePriceLessThan -  (optional)</li>
          *   <li>basePriceGreaterThanOrEqual -  (optional)</li>
          *   <li>basePriceLessThanOrEqual -  (optional)</li>
          *   <li>basePriceEquals -  (optional)</li>
          *   <li>basePriceNotEquals -  (optional)</li>
          *   <li>basePriceSpecified -  (optional)</li>
          *   <li>basePriceIn -  (optional)</li>
          *   <li>basePriceNotIn -  (optional)</li>
          *   <li>isActiveEquals -  (optional)</li>
          *   <li>isActiveNotEquals -  (optional)</li>
          *   <li>isActiveSpecified -  (optional)</li>
          *   <li>isActiveIn -  (optional)</li>
          *   <li>isActiveNotIn -  (optional)</li>
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
          *   <li>routeIdEquals -  (optional)</li>
          *   <li>routeIdNotEquals -  (optional)</li>
          *   <li>routeIdSpecified -  (optional)</li>
          *   <li>routeIdIn -  (optional)</li>
          *   <li>routeIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return Long
      */
      @RequestLine("GET /api/schedules/count?id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&departureTime.greaterThan={departureTimeGreaterThan}&departureTime.lessThan={departureTimeLessThan}&departureTime.greaterThanOrEqual={departureTimeGreaterThanOrEqual}&departureTime.lessThanOrEqual={departureTimeLessThanOrEqual}&departureTime.equals={departureTimeEquals}&departureTime.notEquals={departureTimeNotEquals}&departureTime.specified={departureTimeSpecified}&departureTime.in={departureTimeIn}&departureTime.notIn={departureTimeNotIn}&arrivalTime.greaterThan={arrivalTimeGreaterThan}&arrivalTime.lessThan={arrivalTimeLessThan}&arrivalTime.greaterThanOrEqual={arrivalTimeGreaterThanOrEqual}&arrivalTime.lessThanOrEqual={arrivalTimeLessThanOrEqual}&arrivalTime.equals={arrivalTimeEquals}&arrivalTime.notEquals={arrivalTimeNotEquals}&arrivalTime.specified={arrivalTimeSpecified}&arrivalTime.in={arrivalTimeIn}&arrivalTime.notIn={arrivalTimeNotIn}&totalSeats.greaterThan={totalSeatsGreaterThan}&totalSeats.lessThan={totalSeatsLessThan}&totalSeats.greaterThanOrEqual={totalSeatsGreaterThanOrEqual}&totalSeats.lessThanOrEqual={totalSeatsLessThanOrEqual}&totalSeats.equals={totalSeatsEquals}&totalSeats.notEquals={totalSeatsNotEquals}&totalSeats.specified={totalSeatsSpecified}&totalSeats.in={totalSeatsIn}&totalSeats.notIn={totalSeatsNotIn}&availableSeats.greaterThan={availableSeatsGreaterThan}&availableSeats.lessThan={availableSeatsLessThan}&availableSeats.greaterThanOrEqual={availableSeatsGreaterThanOrEqual}&availableSeats.lessThanOrEqual={availableSeatsLessThanOrEqual}&availableSeats.equals={availableSeatsEquals}&availableSeats.notEquals={availableSeatsNotEquals}&availableSeats.specified={availableSeatsSpecified}&availableSeats.in={availableSeatsIn}&availableSeats.notIn={availableSeatsNotIn}&basePrice.greaterThan={basePriceGreaterThan}&basePrice.lessThan={basePriceLessThan}&basePrice.greaterThanOrEqual={basePriceGreaterThanOrEqual}&basePrice.lessThanOrEqual={basePriceLessThanOrEqual}&basePrice.equals={basePriceEquals}&basePrice.notEquals={basePriceNotEquals}&basePrice.specified={basePriceSpecified}&basePrice.in={basePriceIn}&basePrice.notIn={basePriceNotIn}&isActive.equals={isActiveEquals}&isActive.notEquals={isActiveNotEquals}&isActive.specified={isActiveSpecified}&isActive.in={isActiveIn}&isActive.notIn={isActiveNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&routeId.equals={routeIdEquals}&routeId.notEquals={routeIdNotEquals}&routeId.specified={routeIdSpecified}&routeId.in={routeIdIn}&routeId.notIn={routeIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Long> countSchedulesWithHttpInfo(@QueryMap(encoded=true) CountSchedulesQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>countSchedules</code> method in a fluent style.
   */
  public static class CountSchedulesQueryParams extends HashMap<String, Object> {
    public CountSchedulesQueryParams idEquals(@jakarta.annotation.Nullable final UUID value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams idNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams idIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSchedulesQueryParams idNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSchedulesQueryParams departureTimeGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("departureTime.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams departureTimeLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("departureTime.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams departureTimeGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("departureTime.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams departureTimeLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("departureTime.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams departureTimeEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("departureTime.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams departureTimeNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("departureTime.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams departureTimeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("departureTime.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams departureTimeIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("departureTime.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSchedulesQueryParams departureTimeNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("departureTime.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSchedulesQueryParams arrivalTimeGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("arrivalTime.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams arrivalTimeLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("arrivalTime.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams arrivalTimeGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("arrivalTime.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams arrivalTimeLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("arrivalTime.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams arrivalTimeEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("arrivalTime.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams arrivalTimeNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("arrivalTime.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams arrivalTimeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("arrivalTime.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams arrivalTimeIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("arrivalTime.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSchedulesQueryParams arrivalTimeNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("arrivalTime.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSchedulesQueryParams totalSeatsGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("totalSeats.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams totalSeatsLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("totalSeats.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams totalSeatsGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("totalSeats.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams totalSeatsLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("totalSeats.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams totalSeatsEquals(@jakarta.annotation.Nullable final Integer value) {
      put("totalSeats.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams totalSeatsNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("totalSeats.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams totalSeatsSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("totalSeats.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams totalSeatsIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("totalSeats.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSchedulesQueryParams totalSeatsNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("totalSeats.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSchedulesQueryParams availableSeatsGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("availableSeats.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams availableSeatsLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("availableSeats.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams availableSeatsGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("availableSeats.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams availableSeatsLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("availableSeats.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams availableSeatsEquals(@jakarta.annotation.Nullable final Integer value) {
      put("availableSeats.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams availableSeatsNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("availableSeats.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams availableSeatsSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("availableSeats.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams availableSeatsIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("availableSeats.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSchedulesQueryParams availableSeatsNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("availableSeats.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSchedulesQueryParams basePriceGreaterThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("basePrice.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams basePriceLessThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("basePrice.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams basePriceGreaterThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("basePrice.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams basePriceLessThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("basePrice.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams basePriceEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("basePrice.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams basePriceNotEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("basePrice.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams basePriceSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("basePrice.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams basePriceIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("basePrice.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSchedulesQueryParams basePriceNotIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("basePrice.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSchedulesQueryParams isActiveEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isActive.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams isActiveNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isActive.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams isActiveSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isActive.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams isActiveIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isActive.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSchedulesQueryParams isActiveNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isActive.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSchedulesQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSchedulesQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSchedulesQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSchedulesQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSchedulesQueryParams routeIdEquals(@jakarta.annotation.Nullable final UUID value) {
      put("routeId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams routeIdNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("routeId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams routeIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("routeId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSchedulesQueryParams routeIdIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("routeId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSchedulesQueryParams routeIdNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("routeId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSchedulesQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param scheduleDTO  (required)
   * @return ScheduleDTO
   */
  @RequestLine("POST /api/schedules")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ScheduleDTO createSchedule(@jakarta.annotation.Nonnull ScheduleDTO scheduleDTO);

  /**
   * 
   * Similar to <code>createSchedule</code> but it also returns the http response headers .
   * 
   * @param scheduleDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/schedules")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<ScheduleDTO> createScheduleWithHttpInfo(@jakarta.annotation.Nonnull ScheduleDTO scheduleDTO);



  /**
   * 
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/schedules/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteSchedule(@Param("id") @jakarta.annotation.Nonnull UUID id);

  /**
   * 
   * Similar to <code>deleteSchedule</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/schedules/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteScheduleWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull UUID id);



  /**
   * 
   * 
   * @param idEquals  (optional)
   * @param idNotEquals  (optional)
   * @param idSpecified  (optional)
   * @param idIn  (optional)
   * @param idNotIn  (optional)
   * @param departureTimeGreaterThan  (optional)
   * @param departureTimeLessThan  (optional)
   * @param departureTimeGreaterThanOrEqual  (optional)
   * @param departureTimeLessThanOrEqual  (optional)
   * @param departureTimeEquals  (optional)
   * @param departureTimeNotEquals  (optional)
   * @param departureTimeSpecified  (optional)
   * @param departureTimeIn  (optional)
   * @param departureTimeNotIn  (optional)
   * @param arrivalTimeGreaterThan  (optional)
   * @param arrivalTimeLessThan  (optional)
   * @param arrivalTimeGreaterThanOrEqual  (optional)
   * @param arrivalTimeLessThanOrEqual  (optional)
   * @param arrivalTimeEquals  (optional)
   * @param arrivalTimeNotEquals  (optional)
   * @param arrivalTimeSpecified  (optional)
   * @param arrivalTimeIn  (optional)
   * @param arrivalTimeNotIn  (optional)
   * @param totalSeatsGreaterThan  (optional)
   * @param totalSeatsLessThan  (optional)
   * @param totalSeatsGreaterThanOrEqual  (optional)
   * @param totalSeatsLessThanOrEqual  (optional)
   * @param totalSeatsEquals  (optional)
   * @param totalSeatsNotEquals  (optional)
   * @param totalSeatsSpecified  (optional)
   * @param totalSeatsIn  (optional)
   * @param totalSeatsNotIn  (optional)
   * @param availableSeatsGreaterThan  (optional)
   * @param availableSeatsLessThan  (optional)
   * @param availableSeatsGreaterThanOrEqual  (optional)
   * @param availableSeatsLessThanOrEqual  (optional)
   * @param availableSeatsEquals  (optional)
   * @param availableSeatsNotEquals  (optional)
   * @param availableSeatsSpecified  (optional)
   * @param availableSeatsIn  (optional)
   * @param availableSeatsNotIn  (optional)
   * @param basePriceGreaterThan  (optional)
   * @param basePriceLessThan  (optional)
   * @param basePriceGreaterThanOrEqual  (optional)
   * @param basePriceLessThanOrEqual  (optional)
   * @param basePriceEquals  (optional)
   * @param basePriceNotEquals  (optional)
   * @param basePriceSpecified  (optional)
   * @param basePriceIn  (optional)
   * @param basePriceNotIn  (optional)
   * @param isActiveEquals  (optional)
   * @param isActiveNotEquals  (optional)
   * @param isActiveSpecified  (optional)
   * @param isActiveIn  (optional)
   * @param isActiveNotIn  (optional)
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
   * @param routeIdEquals  (optional)
   * @param routeIdNotEquals  (optional)
   * @param routeIdSpecified  (optional)
   * @param routeIdIn  (optional)
   * @param routeIdNotIn  (optional)
   * @param distinct  (optional)
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return List&lt;ScheduleDTO&gt;
   */
  @RequestLine("GET /api/schedules?id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&departureTime.greaterThan={departureTimeGreaterThan}&departureTime.lessThan={departureTimeLessThan}&departureTime.greaterThanOrEqual={departureTimeGreaterThanOrEqual}&departureTime.lessThanOrEqual={departureTimeLessThanOrEqual}&departureTime.equals={departureTimeEquals}&departureTime.notEquals={departureTimeNotEquals}&departureTime.specified={departureTimeSpecified}&departureTime.in={departureTimeIn}&departureTime.notIn={departureTimeNotIn}&arrivalTime.greaterThan={arrivalTimeGreaterThan}&arrivalTime.lessThan={arrivalTimeLessThan}&arrivalTime.greaterThanOrEqual={arrivalTimeGreaterThanOrEqual}&arrivalTime.lessThanOrEqual={arrivalTimeLessThanOrEqual}&arrivalTime.equals={arrivalTimeEquals}&arrivalTime.notEquals={arrivalTimeNotEquals}&arrivalTime.specified={arrivalTimeSpecified}&arrivalTime.in={arrivalTimeIn}&arrivalTime.notIn={arrivalTimeNotIn}&totalSeats.greaterThan={totalSeatsGreaterThan}&totalSeats.lessThan={totalSeatsLessThan}&totalSeats.greaterThanOrEqual={totalSeatsGreaterThanOrEqual}&totalSeats.lessThanOrEqual={totalSeatsLessThanOrEqual}&totalSeats.equals={totalSeatsEquals}&totalSeats.notEquals={totalSeatsNotEquals}&totalSeats.specified={totalSeatsSpecified}&totalSeats.in={totalSeatsIn}&totalSeats.notIn={totalSeatsNotIn}&availableSeats.greaterThan={availableSeatsGreaterThan}&availableSeats.lessThan={availableSeatsLessThan}&availableSeats.greaterThanOrEqual={availableSeatsGreaterThanOrEqual}&availableSeats.lessThanOrEqual={availableSeatsLessThanOrEqual}&availableSeats.equals={availableSeatsEquals}&availableSeats.notEquals={availableSeatsNotEquals}&availableSeats.specified={availableSeatsSpecified}&availableSeats.in={availableSeatsIn}&availableSeats.notIn={availableSeatsNotIn}&basePrice.greaterThan={basePriceGreaterThan}&basePrice.lessThan={basePriceLessThan}&basePrice.greaterThanOrEqual={basePriceGreaterThanOrEqual}&basePrice.lessThanOrEqual={basePriceLessThanOrEqual}&basePrice.equals={basePriceEquals}&basePrice.notEquals={basePriceNotEquals}&basePrice.specified={basePriceSpecified}&basePrice.in={basePriceIn}&basePrice.notIn={basePriceNotIn}&isActive.equals={isActiveEquals}&isActive.notEquals={isActiveNotEquals}&isActive.specified={isActiveSpecified}&isActive.in={isActiveIn}&isActive.notIn={isActiveNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&routeId.equals={routeIdEquals}&routeId.notEquals={routeIdNotEquals}&routeId.specified={routeIdSpecified}&routeId.in={routeIdIn}&routeId.notIn={routeIdNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",
  })
  List<ScheduleDTO> getAllSchedules(@Param("idEquals") @jakarta.annotation.Nullable UUID idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable UUID idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<UUID> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<UUID> idNotIn, @Param("departureTimeGreaterThan") @jakarta.annotation.Nullable OffsetDateTime departureTimeGreaterThan, @Param("departureTimeLessThan") @jakarta.annotation.Nullable OffsetDateTime departureTimeLessThan, @Param("departureTimeGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime departureTimeGreaterThanOrEqual, @Param("departureTimeLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime departureTimeLessThanOrEqual, @Param("departureTimeEquals") @jakarta.annotation.Nullable OffsetDateTime departureTimeEquals, @Param("departureTimeNotEquals") @jakarta.annotation.Nullable OffsetDateTime departureTimeNotEquals, @Param("departureTimeSpecified") @jakarta.annotation.Nullable Boolean departureTimeSpecified, @Param("departureTimeIn") @jakarta.annotation.Nullable List<OffsetDateTime> departureTimeIn, @Param("departureTimeNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> departureTimeNotIn, @Param("arrivalTimeGreaterThan") @jakarta.annotation.Nullable OffsetDateTime arrivalTimeGreaterThan, @Param("arrivalTimeLessThan") @jakarta.annotation.Nullable OffsetDateTime arrivalTimeLessThan, @Param("arrivalTimeGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime arrivalTimeGreaterThanOrEqual, @Param("arrivalTimeLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime arrivalTimeLessThanOrEqual, @Param("arrivalTimeEquals") @jakarta.annotation.Nullable OffsetDateTime arrivalTimeEquals, @Param("arrivalTimeNotEquals") @jakarta.annotation.Nullable OffsetDateTime arrivalTimeNotEquals, @Param("arrivalTimeSpecified") @jakarta.annotation.Nullable Boolean arrivalTimeSpecified, @Param("arrivalTimeIn") @jakarta.annotation.Nullable List<OffsetDateTime> arrivalTimeIn, @Param("arrivalTimeNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> arrivalTimeNotIn, @Param("totalSeatsGreaterThan") @jakarta.annotation.Nullable Integer totalSeatsGreaterThan, @Param("totalSeatsLessThan") @jakarta.annotation.Nullable Integer totalSeatsLessThan, @Param("totalSeatsGreaterThanOrEqual") @jakarta.annotation.Nullable Integer totalSeatsGreaterThanOrEqual, @Param("totalSeatsLessThanOrEqual") @jakarta.annotation.Nullable Integer totalSeatsLessThanOrEqual, @Param("totalSeatsEquals") @jakarta.annotation.Nullable Integer totalSeatsEquals, @Param("totalSeatsNotEquals") @jakarta.annotation.Nullable Integer totalSeatsNotEquals, @Param("totalSeatsSpecified") @jakarta.annotation.Nullable Boolean totalSeatsSpecified, @Param("totalSeatsIn") @jakarta.annotation.Nullable List<Integer> totalSeatsIn, @Param("totalSeatsNotIn") @jakarta.annotation.Nullable List<Integer> totalSeatsNotIn, @Param("availableSeatsGreaterThan") @jakarta.annotation.Nullable Integer availableSeatsGreaterThan, @Param("availableSeatsLessThan") @jakarta.annotation.Nullable Integer availableSeatsLessThan, @Param("availableSeatsGreaterThanOrEqual") @jakarta.annotation.Nullable Integer availableSeatsGreaterThanOrEqual, @Param("availableSeatsLessThanOrEqual") @jakarta.annotation.Nullable Integer availableSeatsLessThanOrEqual, @Param("availableSeatsEquals") @jakarta.annotation.Nullable Integer availableSeatsEquals, @Param("availableSeatsNotEquals") @jakarta.annotation.Nullable Integer availableSeatsNotEquals, @Param("availableSeatsSpecified") @jakarta.annotation.Nullable Boolean availableSeatsSpecified, @Param("availableSeatsIn") @jakarta.annotation.Nullable List<Integer> availableSeatsIn, @Param("availableSeatsNotIn") @jakarta.annotation.Nullable List<Integer> availableSeatsNotIn, @Param("basePriceGreaterThan") @jakarta.annotation.Nullable BigDecimal basePriceGreaterThan, @Param("basePriceLessThan") @jakarta.annotation.Nullable BigDecimal basePriceLessThan, @Param("basePriceGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal basePriceGreaterThanOrEqual, @Param("basePriceLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal basePriceLessThanOrEqual, @Param("basePriceEquals") @jakarta.annotation.Nullable BigDecimal basePriceEquals, @Param("basePriceNotEquals") @jakarta.annotation.Nullable BigDecimal basePriceNotEquals, @Param("basePriceSpecified") @jakarta.annotation.Nullable Boolean basePriceSpecified, @Param("basePriceIn") @jakarta.annotation.Nullable List<BigDecimal> basePriceIn, @Param("basePriceNotIn") @jakarta.annotation.Nullable List<BigDecimal> basePriceNotIn, @Param("isActiveEquals") @jakarta.annotation.Nullable Boolean isActiveEquals, @Param("isActiveNotEquals") @jakarta.annotation.Nullable Boolean isActiveNotEquals, @Param("isActiveSpecified") @jakarta.annotation.Nullable Boolean isActiveSpecified, @Param("isActiveIn") @jakarta.annotation.Nullable List<Boolean> isActiveIn, @Param("isActiveNotIn") @jakarta.annotation.Nullable List<Boolean> isActiveNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("routeIdEquals") @jakarta.annotation.Nullable UUID routeIdEquals, @Param("routeIdNotEquals") @jakarta.annotation.Nullable UUID routeIdNotEquals, @Param("routeIdSpecified") @jakarta.annotation.Nullable Boolean routeIdSpecified, @Param("routeIdIn") @jakarta.annotation.Nullable List<UUID> routeIdIn, @Param("routeIdNotIn") @jakarta.annotation.Nullable List<UUID> routeIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct, @Param("page") @jakarta.annotation.Nullable Integer page, @Param("size") @jakarta.annotation.Nullable Integer size, @Param("sort") @jakarta.annotation.Nullable List<String> sort);

  /**
   * 
   * Similar to <code>getAllSchedules</code> but it also returns the http response headers .
   * 
   * @param idEquals  (optional)
   * @param idNotEquals  (optional)
   * @param idSpecified  (optional)
   * @param idIn  (optional)
   * @param idNotIn  (optional)
   * @param departureTimeGreaterThan  (optional)
   * @param departureTimeLessThan  (optional)
   * @param departureTimeGreaterThanOrEqual  (optional)
   * @param departureTimeLessThanOrEqual  (optional)
   * @param departureTimeEquals  (optional)
   * @param departureTimeNotEquals  (optional)
   * @param departureTimeSpecified  (optional)
   * @param departureTimeIn  (optional)
   * @param departureTimeNotIn  (optional)
   * @param arrivalTimeGreaterThan  (optional)
   * @param arrivalTimeLessThan  (optional)
   * @param arrivalTimeGreaterThanOrEqual  (optional)
   * @param arrivalTimeLessThanOrEqual  (optional)
   * @param arrivalTimeEquals  (optional)
   * @param arrivalTimeNotEquals  (optional)
   * @param arrivalTimeSpecified  (optional)
   * @param arrivalTimeIn  (optional)
   * @param arrivalTimeNotIn  (optional)
   * @param totalSeatsGreaterThan  (optional)
   * @param totalSeatsLessThan  (optional)
   * @param totalSeatsGreaterThanOrEqual  (optional)
   * @param totalSeatsLessThanOrEqual  (optional)
   * @param totalSeatsEquals  (optional)
   * @param totalSeatsNotEquals  (optional)
   * @param totalSeatsSpecified  (optional)
   * @param totalSeatsIn  (optional)
   * @param totalSeatsNotIn  (optional)
   * @param availableSeatsGreaterThan  (optional)
   * @param availableSeatsLessThan  (optional)
   * @param availableSeatsGreaterThanOrEqual  (optional)
   * @param availableSeatsLessThanOrEqual  (optional)
   * @param availableSeatsEquals  (optional)
   * @param availableSeatsNotEquals  (optional)
   * @param availableSeatsSpecified  (optional)
   * @param availableSeatsIn  (optional)
   * @param availableSeatsNotIn  (optional)
   * @param basePriceGreaterThan  (optional)
   * @param basePriceLessThan  (optional)
   * @param basePriceGreaterThanOrEqual  (optional)
   * @param basePriceLessThanOrEqual  (optional)
   * @param basePriceEquals  (optional)
   * @param basePriceNotEquals  (optional)
   * @param basePriceSpecified  (optional)
   * @param basePriceIn  (optional)
   * @param basePriceNotIn  (optional)
   * @param isActiveEquals  (optional)
   * @param isActiveNotEquals  (optional)
   * @param isActiveSpecified  (optional)
   * @param isActiveIn  (optional)
   * @param isActiveNotIn  (optional)
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
   * @param routeIdEquals  (optional)
   * @param routeIdNotEquals  (optional)
   * @param routeIdSpecified  (optional)
   * @param routeIdIn  (optional)
   * @param routeIdNotIn  (optional)
   * @param distinct  (optional)
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/schedules?id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&departureTime.greaterThan={departureTimeGreaterThan}&departureTime.lessThan={departureTimeLessThan}&departureTime.greaterThanOrEqual={departureTimeGreaterThanOrEqual}&departureTime.lessThanOrEqual={departureTimeLessThanOrEqual}&departureTime.equals={departureTimeEquals}&departureTime.notEquals={departureTimeNotEquals}&departureTime.specified={departureTimeSpecified}&departureTime.in={departureTimeIn}&departureTime.notIn={departureTimeNotIn}&arrivalTime.greaterThan={arrivalTimeGreaterThan}&arrivalTime.lessThan={arrivalTimeLessThan}&arrivalTime.greaterThanOrEqual={arrivalTimeGreaterThanOrEqual}&arrivalTime.lessThanOrEqual={arrivalTimeLessThanOrEqual}&arrivalTime.equals={arrivalTimeEquals}&arrivalTime.notEquals={arrivalTimeNotEquals}&arrivalTime.specified={arrivalTimeSpecified}&arrivalTime.in={arrivalTimeIn}&arrivalTime.notIn={arrivalTimeNotIn}&totalSeats.greaterThan={totalSeatsGreaterThan}&totalSeats.lessThan={totalSeatsLessThan}&totalSeats.greaterThanOrEqual={totalSeatsGreaterThanOrEqual}&totalSeats.lessThanOrEqual={totalSeatsLessThanOrEqual}&totalSeats.equals={totalSeatsEquals}&totalSeats.notEquals={totalSeatsNotEquals}&totalSeats.specified={totalSeatsSpecified}&totalSeats.in={totalSeatsIn}&totalSeats.notIn={totalSeatsNotIn}&availableSeats.greaterThan={availableSeatsGreaterThan}&availableSeats.lessThan={availableSeatsLessThan}&availableSeats.greaterThanOrEqual={availableSeatsGreaterThanOrEqual}&availableSeats.lessThanOrEqual={availableSeatsLessThanOrEqual}&availableSeats.equals={availableSeatsEquals}&availableSeats.notEquals={availableSeatsNotEquals}&availableSeats.specified={availableSeatsSpecified}&availableSeats.in={availableSeatsIn}&availableSeats.notIn={availableSeatsNotIn}&basePrice.greaterThan={basePriceGreaterThan}&basePrice.lessThan={basePriceLessThan}&basePrice.greaterThanOrEqual={basePriceGreaterThanOrEqual}&basePrice.lessThanOrEqual={basePriceLessThanOrEqual}&basePrice.equals={basePriceEquals}&basePrice.notEquals={basePriceNotEquals}&basePrice.specified={basePriceSpecified}&basePrice.in={basePriceIn}&basePrice.notIn={basePriceNotIn}&isActive.equals={isActiveEquals}&isActive.notEquals={isActiveNotEquals}&isActive.specified={isActiveSpecified}&isActive.in={isActiveIn}&isActive.notIn={isActiveNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&routeId.equals={routeIdEquals}&routeId.notEquals={routeIdNotEquals}&routeId.specified={routeIdSpecified}&routeId.in={routeIdIn}&routeId.notIn={routeIdNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<ScheduleDTO>> getAllSchedulesWithHttpInfo(@Param("idEquals") @jakarta.annotation.Nullable UUID idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable UUID idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<UUID> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<UUID> idNotIn, @Param("departureTimeGreaterThan") @jakarta.annotation.Nullable OffsetDateTime departureTimeGreaterThan, @Param("departureTimeLessThan") @jakarta.annotation.Nullable OffsetDateTime departureTimeLessThan, @Param("departureTimeGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime departureTimeGreaterThanOrEqual, @Param("departureTimeLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime departureTimeLessThanOrEqual, @Param("departureTimeEquals") @jakarta.annotation.Nullable OffsetDateTime departureTimeEquals, @Param("departureTimeNotEquals") @jakarta.annotation.Nullable OffsetDateTime departureTimeNotEquals, @Param("departureTimeSpecified") @jakarta.annotation.Nullable Boolean departureTimeSpecified, @Param("departureTimeIn") @jakarta.annotation.Nullable List<OffsetDateTime> departureTimeIn, @Param("departureTimeNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> departureTimeNotIn, @Param("arrivalTimeGreaterThan") @jakarta.annotation.Nullable OffsetDateTime arrivalTimeGreaterThan, @Param("arrivalTimeLessThan") @jakarta.annotation.Nullable OffsetDateTime arrivalTimeLessThan, @Param("arrivalTimeGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime arrivalTimeGreaterThanOrEqual, @Param("arrivalTimeLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime arrivalTimeLessThanOrEqual, @Param("arrivalTimeEquals") @jakarta.annotation.Nullable OffsetDateTime arrivalTimeEquals, @Param("arrivalTimeNotEquals") @jakarta.annotation.Nullable OffsetDateTime arrivalTimeNotEquals, @Param("arrivalTimeSpecified") @jakarta.annotation.Nullable Boolean arrivalTimeSpecified, @Param("arrivalTimeIn") @jakarta.annotation.Nullable List<OffsetDateTime> arrivalTimeIn, @Param("arrivalTimeNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> arrivalTimeNotIn, @Param("totalSeatsGreaterThan") @jakarta.annotation.Nullable Integer totalSeatsGreaterThan, @Param("totalSeatsLessThan") @jakarta.annotation.Nullable Integer totalSeatsLessThan, @Param("totalSeatsGreaterThanOrEqual") @jakarta.annotation.Nullable Integer totalSeatsGreaterThanOrEqual, @Param("totalSeatsLessThanOrEqual") @jakarta.annotation.Nullable Integer totalSeatsLessThanOrEqual, @Param("totalSeatsEquals") @jakarta.annotation.Nullable Integer totalSeatsEquals, @Param("totalSeatsNotEquals") @jakarta.annotation.Nullable Integer totalSeatsNotEquals, @Param("totalSeatsSpecified") @jakarta.annotation.Nullable Boolean totalSeatsSpecified, @Param("totalSeatsIn") @jakarta.annotation.Nullable List<Integer> totalSeatsIn, @Param("totalSeatsNotIn") @jakarta.annotation.Nullable List<Integer> totalSeatsNotIn, @Param("availableSeatsGreaterThan") @jakarta.annotation.Nullable Integer availableSeatsGreaterThan, @Param("availableSeatsLessThan") @jakarta.annotation.Nullable Integer availableSeatsLessThan, @Param("availableSeatsGreaterThanOrEqual") @jakarta.annotation.Nullable Integer availableSeatsGreaterThanOrEqual, @Param("availableSeatsLessThanOrEqual") @jakarta.annotation.Nullable Integer availableSeatsLessThanOrEqual, @Param("availableSeatsEquals") @jakarta.annotation.Nullable Integer availableSeatsEquals, @Param("availableSeatsNotEquals") @jakarta.annotation.Nullable Integer availableSeatsNotEquals, @Param("availableSeatsSpecified") @jakarta.annotation.Nullable Boolean availableSeatsSpecified, @Param("availableSeatsIn") @jakarta.annotation.Nullable List<Integer> availableSeatsIn, @Param("availableSeatsNotIn") @jakarta.annotation.Nullable List<Integer> availableSeatsNotIn, @Param("basePriceGreaterThan") @jakarta.annotation.Nullable BigDecimal basePriceGreaterThan, @Param("basePriceLessThan") @jakarta.annotation.Nullable BigDecimal basePriceLessThan, @Param("basePriceGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal basePriceGreaterThanOrEqual, @Param("basePriceLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal basePriceLessThanOrEqual, @Param("basePriceEquals") @jakarta.annotation.Nullable BigDecimal basePriceEquals, @Param("basePriceNotEquals") @jakarta.annotation.Nullable BigDecimal basePriceNotEquals, @Param("basePriceSpecified") @jakarta.annotation.Nullable Boolean basePriceSpecified, @Param("basePriceIn") @jakarta.annotation.Nullable List<BigDecimal> basePriceIn, @Param("basePriceNotIn") @jakarta.annotation.Nullable List<BigDecimal> basePriceNotIn, @Param("isActiveEquals") @jakarta.annotation.Nullable Boolean isActiveEquals, @Param("isActiveNotEquals") @jakarta.annotation.Nullable Boolean isActiveNotEquals, @Param("isActiveSpecified") @jakarta.annotation.Nullable Boolean isActiveSpecified, @Param("isActiveIn") @jakarta.annotation.Nullable List<Boolean> isActiveIn, @Param("isActiveNotIn") @jakarta.annotation.Nullable List<Boolean> isActiveNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("routeIdEquals") @jakarta.annotation.Nullable UUID routeIdEquals, @Param("routeIdNotEquals") @jakarta.annotation.Nullable UUID routeIdNotEquals, @Param("routeIdSpecified") @jakarta.annotation.Nullable Boolean routeIdSpecified, @Param("routeIdIn") @jakarta.annotation.Nullable List<UUID> routeIdIn, @Param("routeIdNotIn") @jakarta.annotation.Nullable List<UUID> routeIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct, @Param("page") @jakarta.annotation.Nullable Integer page, @Param("size") @jakarta.annotation.Nullable Integer size, @Param("sort") @jakarta.annotation.Nullable List<String> sort);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllSchedules</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllSchedulesQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>idEquals -  (optional)</li>
   *   <li>idNotEquals -  (optional)</li>
   *   <li>idSpecified -  (optional)</li>
   *   <li>idIn -  (optional)</li>
   *   <li>idNotIn -  (optional)</li>
   *   <li>departureTimeGreaterThan -  (optional)</li>
   *   <li>departureTimeLessThan -  (optional)</li>
   *   <li>departureTimeGreaterThanOrEqual -  (optional)</li>
   *   <li>departureTimeLessThanOrEqual -  (optional)</li>
   *   <li>departureTimeEquals -  (optional)</li>
   *   <li>departureTimeNotEquals -  (optional)</li>
   *   <li>departureTimeSpecified -  (optional)</li>
   *   <li>departureTimeIn -  (optional)</li>
   *   <li>departureTimeNotIn -  (optional)</li>
   *   <li>arrivalTimeGreaterThan -  (optional)</li>
   *   <li>arrivalTimeLessThan -  (optional)</li>
   *   <li>arrivalTimeGreaterThanOrEqual -  (optional)</li>
   *   <li>arrivalTimeLessThanOrEqual -  (optional)</li>
   *   <li>arrivalTimeEquals -  (optional)</li>
   *   <li>arrivalTimeNotEquals -  (optional)</li>
   *   <li>arrivalTimeSpecified -  (optional)</li>
   *   <li>arrivalTimeIn -  (optional)</li>
   *   <li>arrivalTimeNotIn -  (optional)</li>
   *   <li>totalSeatsGreaterThan -  (optional)</li>
   *   <li>totalSeatsLessThan -  (optional)</li>
   *   <li>totalSeatsGreaterThanOrEqual -  (optional)</li>
   *   <li>totalSeatsLessThanOrEqual -  (optional)</li>
   *   <li>totalSeatsEquals -  (optional)</li>
   *   <li>totalSeatsNotEquals -  (optional)</li>
   *   <li>totalSeatsSpecified -  (optional)</li>
   *   <li>totalSeatsIn -  (optional)</li>
   *   <li>totalSeatsNotIn -  (optional)</li>
   *   <li>availableSeatsGreaterThan -  (optional)</li>
   *   <li>availableSeatsLessThan -  (optional)</li>
   *   <li>availableSeatsGreaterThanOrEqual -  (optional)</li>
   *   <li>availableSeatsLessThanOrEqual -  (optional)</li>
   *   <li>availableSeatsEquals -  (optional)</li>
   *   <li>availableSeatsNotEquals -  (optional)</li>
   *   <li>availableSeatsSpecified -  (optional)</li>
   *   <li>availableSeatsIn -  (optional)</li>
   *   <li>availableSeatsNotIn -  (optional)</li>
   *   <li>basePriceGreaterThan -  (optional)</li>
   *   <li>basePriceLessThan -  (optional)</li>
   *   <li>basePriceGreaterThanOrEqual -  (optional)</li>
   *   <li>basePriceLessThanOrEqual -  (optional)</li>
   *   <li>basePriceEquals -  (optional)</li>
   *   <li>basePriceNotEquals -  (optional)</li>
   *   <li>basePriceSpecified -  (optional)</li>
   *   <li>basePriceIn -  (optional)</li>
   *   <li>basePriceNotIn -  (optional)</li>
   *   <li>isActiveEquals -  (optional)</li>
   *   <li>isActiveNotEquals -  (optional)</li>
   *   <li>isActiveSpecified -  (optional)</li>
   *   <li>isActiveIn -  (optional)</li>
   *   <li>isActiveNotIn -  (optional)</li>
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
   *   <li>routeIdEquals -  (optional)</li>
   *   <li>routeIdNotEquals -  (optional)</li>
   *   <li>routeIdSpecified -  (optional)</li>
   *   <li>routeIdIn -  (optional)</li>
   *   <li>routeIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   <li>page - Zero-based page index (0..N) (optional, default to 0)</li>
   *   <li>size - The size of the page to be returned (optional, default to 20)</li>
   *   <li>sort - Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)</li>
   *   </ul>
   * @return List&lt;ScheduleDTO&gt;
   */
  @RequestLine("GET /api/schedules?id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&departureTime.greaterThan={departureTimeGreaterThan}&departureTime.lessThan={departureTimeLessThan}&departureTime.greaterThanOrEqual={departureTimeGreaterThanOrEqual}&departureTime.lessThanOrEqual={departureTimeLessThanOrEqual}&departureTime.equals={departureTimeEquals}&departureTime.notEquals={departureTimeNotEquals}&departureTime.specified={departureTimeSpecified}&departureTime.in={departureTimeIn}&departureTime.notIn={departureTimeNotIn}&arrivalTime.greaterThan={arrivalTimeGreaterThan}&arrivalTime.lessThan={arrivalTimeLessThan}&arrivalTime.greaterThanOrEqual={arrivalTimeGreaterThanOrEqual}&arrivalTime.lessThanOrEqual={arrivalTimeLessThanOrEqual}&arrivalTime.equals={arrivalTimeEquals}&arrivalTime.notEquals={arrivalTimeNotEquals}&arrivalTime.specified={arrivalTimeSpecified}&arrivalTime.in={arrivalTimeIn}&arrivalTime.notIn={arrivalTimeNotIn}&totalSeats.greaterThan={totalSeatsGreaterThan}&totalSeats.lessThan={totalSeatsLessThan}&totalSeats.greaterThanOrEqual={totalSeatsGreaterThanOrEqual}&totalSeats.lessThanOrEqual={totalSeatsLessThanOrEqual}&totalSeats.equals={totalSeatsEquals}&totalSeats.notEquals={totalSeatsNotEquals}&totalSeats.specified={totalSeatsSpecified}&totalSeats.in={totalSeatsIn}&totalSeats.notIn={totalSeatsNotIn}&availableSeats.greaterThan={availableSeatsGreaterThan}&availableSeats.lessThan={availableSeatsLessThan}&availableSeats.greaterThanOrEqual={availableSeatsGreaterThanOrEqual}&availableSeats.lessThanOrEqual={availableSeatsLessThanOrEqual}&availableSeats.equals={availableSeatsEquals}&availableSeats.notEquals={availableSeatsNotEquals}&availableSeats.specified={availableSeatsSpecified}&availableSeats.in={availableSeatsIn}&availableSeats.notIn={availableSeatsNotIn}&basePrice.greaterThan={basePriceGreaterThan}&basePrice.lessThan={basePriceLessThan}&basePrice.greaterThanOrEqual={basePriceGreaterThanOrEqual}&basePrice.lessThanOrEqual={basePriceLessThanOrEqual}&basePrice.equals={basePriceEquals}&basePrice.notEquals={basePriceNotEquals}&basePrice.specified={basePriceSpecified}&basePrice.in={basePriceIn}&basePrice.notIn={basePriceNotIn}&isActive.equals={isActiveEquals}&isActive.notEquals={isActiveNotEquals}&isActive.specified={isActiveSpecified}&isActive.in={isActiveIn}&isActive.notIn={isActiveNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&routeId.equals={routeIdEquals}&routeId.notEquals={routeIdNotEquals}&routeId.specified={routeIdSpecified}&routeId.in={routeIdIn}&routeId.notIn={routeIdNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
  @Headers({
  "Accept: */*",
  })
  List<ScheduleDTO> getAllSchedules(@QueryMap(encoded=true) GetAllSchedulesQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllSchedules</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>idEquals -  (optional)</li>
          *   <li>idNotEquals -  (optional)</li>
          *   <li>idSpecified -  (optional)</li>
          *   <li>idIn -  (optional)</li>
          *   <li>idNotIn -  (optional)</li>
          *   <li>departureTimeGreaterThan -  (optional)</li>
          *   <li>departureTimeLessThan -  (optional)</li>
          *   <li>departureTimeGreaterThanOrEqual -  (optional)</li>
          *   <li>departureTimeLessThanOrEqual -  (optional)</li>
          *   <li>departureTimeEquals -  (optional)</li>
          *   <li>departureTimeNotEquals -  (optional)</li>
          *   <li>departureTimeSpecified -  (optional)</li>
          *   <li>departureTimeIn -  (optional)</li>
          *   <li>departureTimeNotIn -  (optional)</li>
          *   <li>arrivalTimeGreaterThan -  (optional)</li>
          *   <li>arrivalTimeLessThan -  (optional)</li>
          *   <li>arrivalTimeGreaterThanOrEqual -  (optional)</li>
          *   <li>arrivalTimeLessThanOrEqual -  (optional)</li>
          *   <li>arrivalTimeEquals -  (optional)</li>
          *   <li>arrivalTimeNotEquals -  (optional)</li>
          *   <li>arrivalTimeSpecified -  (optional)</li>
          *   <li>arrivalTimeIn -  (optional)</li>
          *   <li>arrivalTimeNotIn -  (optional)</li>
          *   <li>totalSeatsGreaterThan -  (optional)</li>
          *   <li>totalSeatsLessThan -  (optional)</li>
          *   <li>totalSeatsGreaterThanOrEqual -  (optional)</li>
          *   <li>totalSeatsLessThanOrEqual -  (optional)</li>
          *   <li>totalSeatsEquals -  (optional)</li>
          *   <li>totalSeatsNotEquals -  (optional)</li>
          *   <li>totalSeatsSpecified -  (optional)</li>
          *   <li>totalSeatsIn -  (optional)</li>
          *   <li>totalSeatsNotIn -  (optional)</li>
          *   <li>availableSeatsGreaterThan -  (optional)</li>
          *   <li>availableSeatsLessThan -  (optional)</li>
          *   <li>availableSeatsGreaterThanOrEqual -  (optional)</li>
          *   <li>availableSeatsLessThanOrEqual -  (optional)</li>
          *   <li>availableSeatsEquals -  (optional)</li>
          *   <li>availableSeatsNotEquals -  (optional)</li>
          *   <li>availableSeatsSpecified -  (optional)</li>
          *   <li>availableSeatsIn -  (optional)</li>
          *   <li>availableSeatsNotIn -  (optional)</li>
          *   <li>basePriceGreaterThan -  (optional)</li>
          *   <li>basePriceLessThan -  (optional)</li>
          *   <li>basePriceGreaterThanOrEqual -  (optional)</li>
          *   <li>basePriceLessThanOrEqual -  (optional)</li>
          *   <li>basePriceEquals -  (optional)</li>
          *   <li>basePriceNotEquals -  (optional)</li>
          *   <li>basePriceSpecified -  (optional)</li>
          *   <li>basePriceIn -  (optional)</li>
          *   <li>basePriceNotIn -  (optional)</li>
          *   <li>isActiveEquals -  (optional)</li>
          *   <li>isActiveNotEquals -  (optional)</li>
          *   <li>isActiveSpecified -  (optional)</li>
          *   <li>isActiveIn -  (optional)</li>
          *   <li>isActiveNotIn -  (optional)</li>
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
          *   <li>routeIdEquals -  (optional)</li>
          *   <li>routeIdNotEquals -  (optional)</li>
          *   <li>routeIdSpecified -  (optional)</li>
          *   <li>routeIdIn -  (optional)</li>
          *   <li>routeIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
          *   <li>page - Zero-based page index (0..N) (optional, default to 0)</li>
          *   <li>size - The size of the page to be returned (optional, default to 20)</li>
          *   <li>sort - Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)</li>
      *   </ul>
          * @return List&lt;ScheduleDTO&gt;
      */
      @RequestLine("GET /api/schedules?id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&departureTime.greaterThan={departureTimeGreaterThan}&departureTime.lessThan={departureTimeLessThan}&departureTime.greaterThanOrEqual={departureTimeGreaterThanOrEqual}&departureTime.lessThanOrEqual={departureTimeLessThanOrEqual}&departureTime.equals={departureTimeEquals}&departureTime.notEquals={departureTimeNotEquals}&departureTime.specified={departureTimeSpecified}&departureTime.in={departureTimeIn}&departureTime.notIn={departureTimeNotIn}&arrivalTime.greaterThan={arrivalTimeGreaterThan}&arrivalTime.lessThan={arrivalTimeLessThan}&arrivalTime.greaterThanOrEqual={arrivalTimeGreaterThanOrEqual}&arrivalTime.lessThanOrEqual={arrivalTimeLessThanOrEqual}&arrivalTime.equals={arrivalTimeEquals}&arrivalTime.notEquals={arrivalTimeNotEquals}&arrivalTime.specified={arrivalTimeSpecified}&arrivalTime.in={arrivalTimeIn}&arrivalTime.notIn={arrivalTimeNotIn}&totalSeats.greaterThan={totalSeatsGreaterThan}&totalSeats.lessThan={totalSeatsLessThan}&totalSeats.greaterThanOrEqual={totalSeatsGreaterThanOrEqual}&totalSeats.lessThanOrEqual={totalSeatsLessThanOrEqual}&totalSeats.equals={totalSeatsEquals}&totalSeats.notEquals={totalSeatsNotEquals}&totalSeats.specified={totalSeatsSpecified}&totalSeats.in={totalSeatsIn}&totalSeats.notIn={totalSeatsNotIn}&availableSeats.greaterThan={availableSeatsGreaterThan}&availableSeats.lessThan={availableSeatsLessThan}&availableSeats.greaterThanOrEqual={availableSeatsGreaterThanOrEqual}&availableSeats.lessThanOrEqual={availableSeatsLessThanOrEqual}&availableSeats.equals={availableSeatsEquals}&availableSeats.notEquals={availableSeatsNotEquals}&availableSeats.specified={availableSeatsSpecified}&availableSeats.in={availableSeatsIn}&availableSeats.notIn={availableSeatsNotIn}&basePrice.greaterThan={basePriceGreaterThan}&basePrice.lessThan={basePriceLessThan}&basePrice.greaterThanOrEqual={basePriceGreaterThanOrEqual}&basePrice.lessThanOrEqual={basePriceLessThanOrEqual}&basePrice.equals={basePriceEquals}&basePrice.notEquals={basePriceNotEquals}&basePrice.specified={basePriceSpecified}&basePrice.in={basePriceIn}&basePrice.notIn={basePriceNotIn}&isActive.equals={isActiveEquals}&isActive.notEquals={isActiveNotEquals}&isActive.specified={isActiveSpecified}&isActive.in={isActiveIn}&isActive.notIn={isActiveNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&routeId.equals={routeIdEquals}&routeId.notEquals={routeIdNotEquals}&routeId.specified={routeIdSpecified}&routeId.in={routeIdIn}&routeId.notIn={routeIdNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<ScheduleDTO>> getAllSchedulesWithHttpInfo(@QueryMap(encoded=true) GetAllSchedulesQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllSchedules</code> method in a fluent style.
   */
  public static class GetAllSchedulesQueryParams extends HashMap<String, Object> {
    public GetAllSchedulesQueryParams idEquals(@jakarta.annotation.Nullable final UUID value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams idNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams idIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSchedulesQueryParams idNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSchedulesQueryParams departureTimeGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("departureTime.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams departureTimeLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("departureTime.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams departureTimeGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("departureTime.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams departureTimeLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("departureTime.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams departureTimeEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("departureTime.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams departureTimeNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("departureTime.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams departureTimeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("departureTime.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams departureTimeIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("departureTime.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSchedulesQueryParams departureTimeNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("departureTime.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSchedulesQueryParams arrivalTimeGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("arrivalTime.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams arrivalTimeLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("arrivalTime.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams arrivalTimeGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("arrivalTime.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams arrivalTimeLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("arrivalTime.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams arrivalTimeEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("arrivalTime.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams arrivalTimeNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("arrivalTime.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams arrivalTimeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("arrivalTime.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams arrivalTimeIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("arrivalTime.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSchedulesQueryParams arrivalTimeNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("arrivalTime.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSchedulesQueryParams totalSeatsGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("totalSeats.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams totalSeatsLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("totalSeats.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams totalSeatsGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("totalSeats.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams totalSeatsLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("totalSeats.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams totalSeatsEquals(@jakarta.annotation.Nullable final Integer value) {
      put("totalSeats.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams totalSeatsNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("totalSeats.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams totalSeatsSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("totalSeats.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams totalSeatsIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("totalSeats.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSchedulesQueryParams totalSeatsNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("totalSeats.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSchedulesQueryParams availableSeatsGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("availableSeats.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams availableSeatsLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("availableSeats.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams availableSeatsGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("availableSeats.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams availableSeatsLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("availableSeats.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams availableSeatsEquals(@jakarta.annotation.Nullable final Integer value) {
      put("availableSeats.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams availableSeatsNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("availableSeats.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams availableSeatsSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("availableSeats.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams availableSeatsIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("availableSeats.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSchedulesQueryParams availableSeatsNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("availableSeats.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSchedulesQueryParams basePriceGreaterThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("basePrice.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams basePriceLessThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("basePrice.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams basePriceGreaterThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("basePrice.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams basePriceLessThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("basePrice.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams basePriceEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("basePrice.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams basePriceNotEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("basePrice.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams basePriceSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("basePrice.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams basePriceIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("basePrice.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSchedulesQueryParams basePriceNotIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("basePrice.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSchedulesQueryParams isActiveEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isActive.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams isActiveNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isActive.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams isActiveSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isActive.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams isActiveIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isActive.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSchedulesQueryParams isActiveNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isActive.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSchedulesQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSchedulesQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSchedulesQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSchedulesQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSchedulesQueryParams routeIdEquals(@jakarta.annotation.Nullable final UUID value) {
      put("routeId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams routeIdNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("routeId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams routeIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("routeId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams routeIdIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("routeId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSchedulesQueryParams routeIdNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("routeId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSchedulesQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams page(@jakarta.annotation.Nullable final Integer value) {
      put("page", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams size(@jakarta.annotation.Nullable final Integer value) {
      put("size", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSchedulesQueryParams sort(@jakarta.annotation.Nullable final List<String> value) {
      put("sort", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @return ScheduleDTO
   */
  @RequestLine("GET /api/schedules/{id}")
  @Headers({
    "Accept: */*",
  })
  ScheduleDTO getSchedule(@Param("id") @jakarta.annotation.Nonnull UUID id);

  /**
   * 
   * Similar to <code>getSchedule</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/schedules/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<ScheduleDTO> getScheduleWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull UUID id);



  /**
   * 
   * 
   * @param id  (required)
   * @param scheduleDTO  (required)
   * @return ScheduleDTO
   */
  @RequestLine("PATCH /api/schedules/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ScheduleDTO partialUpdateSchedule(@Param("id") @jakarta.annotation.Nonnull UUID id, @jakarta.annotation.Nonnull ScheduleDTO scheduleDTO);

  /**
   * 
   * Similar to <code>partialUpdateSchedule</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param scheduleDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /api/schedules/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<ScheduleDTO> partialUpdateScheduleWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull UUID id, @jakarta.annotation.Nonnull ScheduleDTO scheduleDTO);



  /**
   * 
   * 
   * @param query  (required)
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return List&lt;ScheduleDTO&gt;
   */
  @RequestLine("GET /api/schedules/_search?query={query}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",
  })
  List<ScheduleDTO> searchSchedules(@Param("query") @jakarta.annotation.Nonnull String query, @Param("page") @jakarta.annotation.Nullable Integer page, @Param("size") @jakarta.annotation.Nullable Integer size, @Param("sort") @jakarta.annotation.Nullable List<String> sort);

  /**
   * 
   * Similar to <code>searchSchedules</code> but it also returns the http response headers .
   * 
   * @param query  (required)
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/schedules/_search?query={query}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<ScheduleDTO>> searchSchedulesWithHttpInfo(@Param("query") @jakarta.annotation.Nonnull String query, @Param("page") @jakarta.annotation.Nullable Integer page, @Param("size") @jakarta.annotation.Nullable Integer size, @Param("sort") @jakarta.annotation.Nullable List<String> sort);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>searchSchedules</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link SearchSchedulesQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>query -  (required)</li>
   *   <li>page - Zero-based page index (0..N) (optional, default to 0)</li>
   *   <li>size - The size of the page to be returned (optional, default to 20)</li>
   *   <li>sort - Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)</li>
   *   </ul>
   * @return List&lt;ScheduleDTO&gt;
   */
  @RequestLine("GET /api/schedules/_search?query={query}&page={page}&size={size}&sort={sort}")
  @Headers({
  "Accept: */*",
  })
  List<ScheduleDTO> searchSchedules(@QueryMap(encoded=true) SearchSchedulesQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>searchSchedules</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>query -  (required)</li>
          *   <li>page - Zero-based page index (0..N) (optional, default to 0)</li>
          *   <li>size - The size of the page to be returned (optional, default to 20)</li>
          *   <li>sort - Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)</li>
      *   </ul>
          * @return List&lt;ScheduleDTO&gt;
      */
      @RequestLine("GET /api/schedules/_search?query={query}&page={page}&size={size}&sort={sort}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<ScheduleDTO>> searchSchedulesWithHttpInfo(@QueryMap(encoded=true) SearchSchedulesQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>searchSchedules</code> method in a fluent style.
   */
  public static class SearchSchedulesQueryParams extends HashMap<String, Object> {
    public SearchSchedulesQueryParams query(@jakarta.annotation.Nonnull final String value) {
      put("query", EncodingUtils.encode(value));
      return this;
    }
    public SearchSchedulesQueryParams page(@jakarta.annotation.Nullable final Integer value) {
      put("page", EncodingUtils.encode(value));
      return this;
    }
    public SearchSchedulesQueryParams size(@jakarta.annotation.Nullable final Integer value) {
      put("size", EncodingUtils.encode(value));
      return this;
    }
    public SearchSchedulesQueryParams sort(@jakarta.annotation.Nullable final List<String> value) {
      put("sort", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @param scheduleDTO  (required)
   * @return ScheduleDTO
   */
  @RequestLine("PUT /api/schedules/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ScheduleDTO updateSchedule(@Param("id") @jakarta.annotation.Nonnull UUID id, @jakarta.annotation.Nonnull ScheduleDTO scheduleDTO);

  /**
   * 
   * Similar to <code>updateSchedule</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param scheduleDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/schedules/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<ScheduleDTO> updateScheduleWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull UUID id, @jakarta.annotation.Nonnull ScheduleDTO scheduleDTO);


}
