package com.ridehub.msroutedev.client.api;

import com.ridehub.msroutedev.client.invoker.ApiClient;
import com.ridehub.msroutedev.client.invoker.EncodingUtils;
import com.ridehub.msroutedev.client.model.ApiResponse;

import java.time.OffsetDateTime;
import com.ridehub.msroutedev.client.model.RouteDTO;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface RouteResourceMsroutedevApi extends ApiClient.Api {


  /**
   * 
   * 
   * @param idEquals  (optional)
   * @param idNotEquals  (optional)
   * @param idSpecified  (optional)
   * @param idIn  (optional)
   * @param idNotIn  (optional)
   * @param routeNameContains  (optional)
   * @param routeNameDoesNotContain  (optional)
   * @param routeNameEquals  (optional)
   * @param routeNameNotEquals  (optional)
   * @param routeNameSpecified  (optional)
   * @param routeNameIn  (optional)
   * @param routeNameNotIn  (optional)
   * @param originContains  (optional)
   * @param originDoesNotContain  (optional)
   * @param originEquals  (optional)
   * @param originNotEquals  (optional)
   * @param originSpecified  (optional)
   * @param originIn  (optional)
   * @param originNotIn  (optional)
   * @param destinationContains  (optional)
   * @param destinationDoesNotContain  (optional)
   * @param destinationEquals  (optional)
   * @param destinationNotEquals  (optional)
   * @param destinationSpecified  (optional)
   * @param destinationIn  (optional)
   * @param destinationNotIn  (optional)
   * @param distanceGreaterThan  (optional)
   * @param distanceLessThan  (optional)
   * @param distanceGreaterThanOrEqual  (optional)
   * @param distanceLessThanOrEqual  (optional)
   * @param distanceEquals  (optional)
   * @param distanceNotEquals  (optional)
   * @param distanceSpecified  (optional)
   * @param distanceIn  (optional)
   * @param distanceNotIn  (optional)
   * @param estimatedDurationGreaterThan  (optional)
   * @param estimatedDurationLessThan  (optional)
   * @param estimatedDurationGreaterThanOrEqual  (optional)
   * @param estimatedDurationLessThanOrEqual  (optional)
   * @param estimatedDurationEquals  (optional)
   * @param estimatedDurationNotEquals  (optional)
   * @param estimatedDurationSpecified  (optional)
   * @param estimatedDurationIn  (optional)
   * @param estimatedDurationNotIn  (optional)
   * @param transportTypeEquals  (optional)
   * @param transportTypeNotEquals  (optional)
   * @param transportTypeSpecified  (optional)
   * @param transportTypeIn  (optional)
   * @param transportTypeNotIn  (optional)
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
   * @param routeNameIdEquals  (optional)
   * @param routeNameIdNotEquals  (optional)
   * @param routeNameIdSpecified  (optional)
   * @param routeNameIdIn  (optional)
   * @param routeNameIdNotIn  (optional)
   * @param distinct  (optional)
   * @return Long
   */
  @RequestLine("GET /api/routes/count?id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&routeName.contains={routeNameContains}&routeName.doesNotContain={routeNameDoesNotContain}&routeName.equals={routeNameEquals}&routeName.notEquals={routeNameNotEquals}&routeName.specified={routeNameSpecified}&routeName.in={routeNameIn}&routeName.notIn={routeNameNotIn}&origin.contains={originContains}&origin.doesNotContain={originDoesNotContain}&origin.equals={originEquals}&origin.notEquals={originNotEquals}&origin.specified={originSpecified}&origin.in={originIn}&origin.notIn={originNotIn}&destination.contains={destinationContains}&destination.doesNotContain={destinationDoesNotContain}&destination.equals={destinationEquals}&destination.notEquals={destinationNotEquals}&destination.specified={destinationSpecified}&destination.in={destinationIn}&destination.notIn={destinationNotIn}&distance.greaterThan={distanceGreaterThan}&distance.lessThan={distanceLessThan}&distance.greaterThanOrEqual={distanceGreaterThanOrEqual}&distance.lessThanOrEqual={distanceLessThanOrEqual}&distance.equals={distanceEquals}&distance.notEquals={distanceNotEquals}&distance.specified={distanceSpecified}&distance.in={distanceIn}&distance.notIn={distanceNotIn}&estimatedDuration.greaterThan={estimatedDurationGreaterThan}&estimatedDuration.lessThan={estimatedDurationLessThan}&estimatedDuration.greaterThanOrEqual={estimatedDurationGreaterThanOrEqual}&estimatedDuration.lessThanOrEqual={estimatedDurationLessThanOrEqual}&estimatedDuration.equals={estimatedDurationEquals}&estimatedDuration.notEquals={estimatedDurationNotEquals}&estimatedDuration.specified={estimatedDurationSpecified}&estimatedDuration.in={estimatedDurationIn}&estimatedDuration.notIn={estimatedDurationNotIn}&transportType.equals={transportTypeEquals}&transportType.notEquals={transportTypeNotEquals}&transportType.specified={transportTypeSpecified}&transportType.in={transportTypeIn}&transportType.notIn={transportTypeNotIn}&isActive.equals={isActiveEquals}&isActive.notEquals={isActiveNotEquals}&isActive.specified={isActiveSpecified}&isActive.in={isActiveIn}&isActive.notIn={isActiveNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&routeNameId.equals={routeNameIdEquals}&routeNameId.notEquals={routeNameIdNotEquals}&routeNameId.specified={routeNameIdSpecified}&routeNameId.in={routeNameIdIn}&routeNameId.notIn={routeNameIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  Long countRoutes(@Param("idEquals") @jakarta.annotation.Nullable UUID idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable UUID idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<UUID> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<UUID> idNotIn, @Param("routeNameContains") @jakarta.annotation.Nullable String routeNameContains, @Param("routeNameDoesNotContain") @jakarta.annotation.Nullable String routeNameDoesNotContain, @Param("routeNameEquals") @jakarta.annotation.Nullable String routeNameEquals, @Param("routeNameNotEquals") @jakarta.annotation.Nullable String routeNameNotEquals, @Param("routeNameSpecified") @jakarta.annotation.Nullable Boolean routeNameSpecified, @Param("routeNameIn") @jakarta.annotation.Nullable List<String> routeNameIn, @Param("routeNameNotIn") @jakarta.annotation.Nullable List<String> routeNameNotIn, @Param("originContains") @jakarta.annotation.Nullable String originContains, @Param("originDoesNotContain") @jakarta.annotation.Nullable String originDoesNotContain, @Param("originEquals") @jakarta.annotation.Nullable String originEquals, @Param("originNotEquals") @jakarta.annotation.Nullable String originNotEquals, @Param("originSpecified") @jakarta.annotation.Nullable Boolean originSpecified, @Param("originIn") @jakarta.annotation.Nullable List<String> originIn, @Param("originNotIn") @jakarta.annotation.Nullable List<String> originNotIn, @Param("destinationContains") @jakarta.annotation.Nullable String destinationContains, @Param("destinationDoesNotContain") @jakarta.annotation.Nullable String destinationDoesNotContain, @Param("destinationEquals") @jakarta.annotation.Nullable String destinationEquals, @Param("destinationNotEquals") @jakarta.annotation.Nullable String destinationNotEquals, @Param("destinationSpecified") @jakarta.annotation.Nullable Boolean destinationSpecified, @Param("destinationIn") @jakarta.annotation.Nullable List<String> destinationIn, @Param("destinationNotIn") @jakarta.annotation.Nullable List<String> destinationNotIn, @Param("distanceGreaterThan") @jakarta.annotation.Nullable Double distanceGreaterThan, @Param("distanceLessThan") @jakarta.annotation.Nullable Double distanceLessThan, @Param("distanceGreaterThanOrEqual") @jakarta.annotation.Nullable Double distanceGreaterThanOrEqual, @Param("distanceLessThanOrEqual") @jakarta.annotation.Nullable Double distanceLessThanOrEqual, @Param("distanceEquals") @jakarta.annotation.Nullable Double distanceEquals, @Param("distanceNotEquals") @jakarta.annotation.Nullable Double distanceNotEquals, @Param("distanceSpecified") @jakarta.annotation.Nullable Boolean distanceSpecified, @Param("distanceIn") @jakarta.annotation.Nullable List<Double> distanceIn, @Param("distanceNotIn") @jakarta.annotation.Nullable List<Double> distanceNotIn, @Param("estimatedDurationGreaterThan") @jakarta.annotation.Nullable Integer estimatedDurationGreaterThan, @Param("estimatedDurationLessThan") @jakarta.annotation.Nullable Integer estimatedDurationLessThan, @Param("estimatedDurationGreaterThanOrEqual") @jakarta.annotation.Nullable Integer estimatedDurationGreaterThanOrEqual, @Param("estimatedDurationLessThanOrEqual") @jakarta.annotation.Nullable Integer estimatedDurationLessThanOrEqual, @Param("estimatedDurationEquals") @jakarta.annotation.Nullable Integer estimatedDurationEquals, @Param("estimatedDurationNotEquals") @jakarta.annotation.Nullable Integer estimatedDurationNotEquals, @Param("estimatedDurationSpecified") @jakarta.annotation.Nullable Boolean estimatedDurationSpecified, @Param("estimatedDurationIn") @jakarta.annotation.Nullable List<Integer> estimatedDurationIn, @Param("estimatedDurationNotIn") @jakarta.annotation.Nullable List<Integer> estimatedDurationNotIn, @Param("transportTypeEquals") @jakarta.annotation.Nullable String transportTypeEquals, @Param("transportTypeNotEquals") @jakarta.annotation.Nullable String transportTypeNotEquals, @Param("transportTypeSpecified") @jakarta.annotation.Nullable Boolean transportTypeSpecified, @Param("transportTypeIn") @jakarta.annotation.Nullable List<String> transportTypeIn, @Param("transportTypeNotIn") @jakarta.annotation.Nullable List<String> transportTypeNotIn, @Param("isActiveEquals") @jakarta.annotation.Nullable Boolean isActiveEquals, @Param("isActiveNotEquals") @jakarta.annotation.Nullable Boolean isActiveNotEquals, @Param("isActiveSpecified") @jakarta.annotation.Nullable Boolean isActiveSpecified, @Param("isActiveIn") @jakarta.annotation.Nullable List<Boolean> isActiveIn, @Param("isActiveNotIn") @jakarta.annotation.Nullable List<Boolean> isActiveNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("routeNameIdEquals") @jakarta.annotation.Nullable UUID routeNameIdEquals, @Param("routeNameIdNotEquals") @jakarta.annotation.Nullable UUID routeNameIdNotEquals, @Param("routeNameIdSpecified") @jakarta.annotation.Nullable Boolean routeNameIdSpecified, @Param("routeNameIdIn") @jakarta.annotation.Nullable List<UUID> routeNameIdIn, @Param("routeNameIdNotIn") @jakarta.annotation.Nullable List<UUID> routeNameIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>countRoutes</code> but it also returns the http response headers .
   * 
   * @param idEquals  (optional)
   * @param idNotEquals  (optional)
   * @param idSpecified  (optional)
   * @param idIn  (optional)
   * @param idNotIn  (optional)
   * @param routeNameContains  (optional)
   * @param routeNameDoesNotContain  (optional)
   * @param routeNameEquals  (optional)
   * @param routeNameNotEquals  (optional)
   * @param routeNameSpecified  (optional)
   * @param routeNameIn  (optional)
   * @param routeNameNotIn  (optional)
   * @param originContains  (optional)
   * @param originDoesNotContain  (optional)
   * @param originEquals  (optional)
   * @param originNotEquals  (optional)
   * @param originSpecified  (optional)
   * @param originIn  (optional)
   * @param originNotIn  (optional)
   * @param destinationContains  (optional)
   * @param destinationDoesNotContain  (optional)
   * @param destinationEquals  (optional)
   * @param destinationNotEquals  (optional)
   * @param destinationSpecified  (optional)
   * @param destinationIn  (optional)
   * @param destinationNotIn  (optional)
   * @param distanceGreaterThan  (optional)
   * @param distanceLessThan  (optional)
   * @param distanceGreaterThanOrEqual  (optional)
   * @param distanceLessThanOrEqual  (optional)
   * @param distanceEquals  (optional)
   * @param distanceNotEquals  (optional)
   * @param distanceSpecified  (optional)
   * @param distanceIn  (optional)
   * @param distanceNotIn  (optional)
   * @param estimatedDurationGreaterThan  (optional)
   * @param estimatedDurationLessThan  (optional)
   * @param estimatedDurationGreaterThanOrEqual  (optional)
   * @param estimatedDurationLessThanOrEqual  (optional)
   * @param estimatedDurationEquals  (optional)
   * @param estimatedDurationNotEquals  (optional)
   * @param estimatedDurationSpecified  (optional)
   * @param estimatedDurationIn  (optional)
   * @param estimatedDurationNotIn  (optional)
   * @param transportTypeEquals  (optional)
   * @param transportTypeNotEquals  (optional)
   * @param transportTypeSpecified  (optional)
   * @param transportTypeIn  (optional)
   * @param transportTypeNotIn  (optional)
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
   * @param routeNameIdEquals  (optional)
   * @param routeNameIdNotEquals  (optional)
   * @param routeNameIdSpecified  (optional)
   * @param routeNameIdIn  (optional)
   * @param routeNameIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/routes/count?id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&routeName.contains={routeNameContains}&routeName.doesNotContain={routeNameDoesNotContain}&routeName.equals={routeNameEquals}&routeName.notEquals={routeNameNotEquals}&routeName.specified={routeNameSpecified}&routeName.in={routeNameIn}&routeName.notIn={routeNameNotIn}&origin.contains={originContains}&origin.doesNotContain={originDoesNotContain}&origin.equals={originEquals}&origin.notEquals={originNotEquals}&origin.specified={originSpecified}&origin.in={originIn}&origin.notIn={originNotIn}&destination.contains={destinationContains}&destination.doesNotContain={destinationDoesNotContain}&destination.equals={destinationEquals}&destination.notEquals={destinationNotEquals}&destination.specified={destinationSpecified}&destination.in={destinationIn}&destination.notIn={destinationNotIn}&distance.greaterThan={distanceGreaterThan}&distance.lessThan={distanceLessThan}&distance.greaterThanOrEqual={distanceGreaterThanOrEqual}&distance.lessThanOrEqual={distanceLessThanOrEqual}&distance.equals={distanceEquals}&distance.notEquals={distanceNotEquals}&distance.specified={distanceSpecified}&distance.in={distanceIn}&distance.notIn={distanceNotIn}&estimatedDuration.greaterThan={estimatedDurationGreaterThan}&estimatedDuration.lessThan={estimatedDurationLessThan}&estimatedDuration.greaterThanOrEqual={estimatedDurationGreaterThanOrEqual}&estimatedDuration.lessThanOrEqual={estimatedDurationLessThanOrEqual}&estimatedDuration.equals={estimatedDurationEquals}&estimatedDuration.notEquals={estimatedDurationNotEquals}&estimatedDuration.specified={estimatedDurationSpecified}&estimatedDuration.in={estimatedDurationIn}&estimatedDuration.notIn={estimatedDurationNotIn}&transportType.equals={transportTypeEquals}&transportType.notEquals={transportTypeNotEquals}&transportType.specified={transportTypeSpecified}&transportType.in={transportTypeIn}&transportType.notIn={transportTypeNotIn}&isActive.equals={isActiveEquals}&isActive.notEquals={isActiveNotEquals}&isActive.specified={isActiveSpecified}&isActive.in={isActiveIn}&isActive.notIn={isActiveNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&routeNameId.equals={routeNameIdEquals}&routeNameId.notEquals={routeNameIdNotEquals}&routeNameId.specified={routeNameIdSpecified}&routeNameId.in={routeNameIdIn}&routeNameId.notIn={routeNameIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Long> countRoutesWithHttpInfo(@Param("idEquals") @jakarta.annotation.Nullable UUID idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable UUID idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<UUID> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<UUID> idNotIn, @Param("routeNameContains") @jakarta.annotation.Nullable String routeNameContains, @Param("routeNameDoesNotContain") @jakarta.annotation.Nullable String routeNameDoesNotContain, @Param("routeNameEquals") @jakarta.annotation.Nullable String routeNameEquals, @Param("routeNameNotEquals") @jakarta.annotation.Nullable String routeNameNotEquals, @Param("routeNameSpecified") @jakarta.annotation.Nullable Boolean routeNameSpecified, @Param("routeNameIn") @jakarta.annotation.Nullable List<String> routeNameIn, @Param("routeNameNotIn") @jakarta.annotation.Nullable List<String> routeNameNotIn, @Param("originContains") @jakarta.annotation.Nullable String originContains, @Param("originDoesNotContain") @jakarta.annotation.Nullable String originDoesNotContain, @Param("originEquals") @jakarta.annotation.Nullable String originEquals, @Param("originNotEquals") @jakarta.annotation.Nullable String originNotEquals, @Param("originSpecified") @jakarta.annotation.Nullable Boolean originSpecified, @Param("originIn") @jakarta.annotation.Nullable List<String> originIn, @Param("originNotIn") @jakarta.annotation.Nullable List<String> originNotIn, @Param("destinationContains") @jakarta.annotation.Nullable String destinationContains, @Param("destinationDoesNotContain") @jakarta.annotation.Nullable String destinationDoesNotContain, @Param("destinationEquals") @jakarta.annotation.Nullable String destinationEquals, @Param("destinationNotEquals") @jakarta.annotation.Nullable String destinationNotEquals, @Param("destinationSpecified") @jakarta.annotation.Nullable Boolean destinationSpecified, @Param("destinationIn") @jakarta.annotation.Nullable List<String> destinationIn, @Param("destinationNotIn") @jakarta.annotation.Nullable List<String> destinationNotIn, @Param("distanceGreaterThan") @jakarta.annotation.Nullable Double distanceGreaterThan, @Param("distanceLessThan") @jakarta.annotation.Nullable Double distanceLessThan, @Param("distanceGreaterThanOrEqual") @jakarta.annotation.Nullable Double distanceGreaterThanOrEqual, @Param("distanceLessThanOrEqual") @jakarta.annotation.Nullable Double distanceLessThanOrEqual, @Param("distanceEquals") @jakarta.annotation.Nullable Double distanceEquals, @Param("distanceNotEquals") @jakarta.annotation.Nullable Double distanceNotEquals, @Param("distanceSpecified") @jakarta.annotation.Nullable Boolean distanceSpecified, @Param("distanceIn") @jakarta.annotation.Nullable List<Double> distanceIn, @Param("distanceNotIn") @jakarta.annotation.Nullable List<Double> distanceNotIn, @Param("estimatedDurationGreaterThan") @jakarta.annotation.Nullable Integer estimatedDurationGreaterThan, @Param("estimatedDurationLessThan") @jakarta.annotation.Nullable Integer estimatedDurationLessThan, @Param("estimatedDurationGreaterThanOrEqual") @jakarta.annotation.Nullable Integer estimatedDurationGreaterThanOrEqual, @Param("estimatedDurationLessThanOrEqual") @jakarta.annotation.Nullable Integer estimatedDurationLessThanOrEqual, @Param("estimatedDurationEquals") @jakarta.annotation.Nullable Integer estimatedDurationEquals, @Param("estimatedDurationNotEquals") @jakarta.annotation.Nullable Integer estimatedDurationNotEquals, @Param("estimatedDurationSpecified") @jakarta.annotation.Nullable Boolean estimatedDurationSpecified, @Param("estimatedDurationIn") @jakarta.annotation.Nullable List<Integer> estimatedDurationIn, @Param("estimatedDurationNotIn") @jakarta.annotation.Nullable List<Integer> estimatedDurationNotIn, @Param("transportTypeEquals") @jakarta.annotation.Nullable String transportTypeEquals, @Param("transportTypeNotEquals") @jakarta.annotation.Nullable String transportTypeNotEquals, @Param("transportTypeSpecified") @jakarta.annotation.Nullable Boolean transportTypeSpecified, @Param("transportTypeIn") @jakarta.annotation.Nullable List<String> transportTypeIn, @Param("transportTypeNotIn") @jakarta.annotation.Nullable List<String> transportTypeNotIn, @Param("isActiveEquals") @jakarta.annotation.Nullable Boolean isActiveEquals, @Param("isActiveNotEquals") @jakarta.annotation.Nullable Boolean isActiveNotEquals, @Param("isActiveSpecified") @jakarta.annotation.Nullable Boolean isActiveSpecified, @Param("isActiveIn") @jakarta.annotation.Nullable List<Boolean> isActiveIn, @Param("isActiveNotIn") @jakarta.annotation.Nullable List<Boolean> isActiveNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("routeNameIdEquals") @jakarta.annotation.Nullable UUID routeNameIdEquals, @Param("routeNameIdNotEquals") @jakarta.annotation.Nullable UUID routeNameIdNotEquals, @Param("routeNameIdSpecified") @jakarta.annotation.Nullable Boolean routeNameIdSpecified, @Param("routeNameIdIn") @jakarta.annotation.Nullable List<UUID> routeNameIdIn, @Param("routeNameIdNotIn") @jakarta.annotation.Nullable List<UUID> routeNameIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>countRoutes</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CountRoutesQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>idEquals -  (optional)</li>
   *   <li>idNotEquals -  (optional)</li>
   *   <li>idSpecified -  (optional)</li>
   *   <li>idIn -  (optional)</li>
   *   <li>idNotIn -  (optional)</li>
   *   <li>routeNameContains -  (optional)</li>
   *   <li>routeNameDoesNotContain -  (optional)</li>
   *   <li>routeNameEquals -  (optional)</li>
   *   <li>routeNameNotEquals -  (optional)</li>
   *   <li>routeNameSpecified -  (optional)</li>
   *   <li>routeNameIn -  (optional)</li>
   *   <li>routeNameNotIn -  (optional)</li>
   *   <li>originContains -  (optional)</li>
   *   <li>originDoesNotContain -  (optional)</li>
   *   <li>originEquals -  (optional)</li>
   *   <li>originNotEquals -  (optional)</li>
   *   <li>originSpecified -  (optional)</li>
   *   <li>originIn -  (optional)</li>
   *   <li>originNotIn -  (optional)</li>
   *   <li>destinationContains -  (optional)</li>
   *   <li>destinationDoesNotContain -  (optional)</li>
   *   <li>destinationEquals -  (optional)</li>
   *   <li>destinationNotEquals -  (optional)</li>
   *   <li>destinationSpecified -  (optional)</li>
   *   <li>destinationIn -  (optional)</li>
   *   <li>destinationNotIn -  (optional)</li>
   *   <li>distanceGreaterThan -  (optional)</li>
   *   <li>distanceLessThan -  (optional)</li>
   *   <li>distanceGreaterThanOrEqual -  (optional)</li>
   *   <li>distanceLessThanOrEqual -  (optional)</li>
   *   <li>distanceEquals -  (optional)</li>
   *   <li>distanceNotEquals -  (optional)</li>
   *   <li>distanceSpecified -  (optional)</li>
   *   <li>distanceIn -  (optional)</li>
   *   <li>distanceNotIn -  (optional)</li>
   *   <li>estimatedDurationGreaterThan -  (optional)</li>
   *   <li>estimatedDurationLessThan -  (optional)</li>
   *   <li>estimatedDurationGreaterThanOrEqual -  (optional)</li>
   *   <li>estimatedDurationLessThanOrEqual -  (optional)</li>
   *   <li>estimatedDurationEquals -  (optional)</li>
   *   <li>estimatedDurationNotEquals -  (optional)</li>
   *   <li>estimatedDurationSpecified -  (optional)</li>
   *   <li>estimatedDurationIn -  (optional)</li>
   *   <li>estimatedDurationNotIn -  (optional)</li>
   *   <li>transportTypeEquals -  (optional)</li>
   *   <li>transportTypeNotEquals -  (optional)</li>
   *   <li>transportTypeSpecified -  (optional)</li>
   *   <li>transportTypeIn -  (optional)</li>
   *   <li>transportTypeNotIn -  (optional)</li>
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
   *   <li>routeNameIdEquals -  (optional)</li>
   *   <li>routeNameIdNotEquals -  (optional)</li>
   *   <li>routeNameIdSpecified -  (optional)</li>
   *   <li>routeNameIdIn -  (optional)</li>
   *   <li>routeNameIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return Long
   */
  @RequestLine("GET /api/routes/count?id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&routeName.contains={routeNameContains}&routeName.doesNotContain={routeNameDoesNotContain}&routeName.equals={routeNameEquals}&routeName.notEquals={routeNameNotEquals}&routeName.specified={routeNameSpecified}&routeName.in={routeNameIn}&routeName.notIn={routeNameNotIn}&origin.contains={originContains}&origin.doesNotContain={originDoesNotContain}&origin.equals={originEquals}&origin.notEquals={originNotEquals}&origin.specified={originSpecified}&origin.in={originIn}&origin.notIn={originNotIn}&destination.contains={destinationContains}&destination.doesNotContain={destinationDoesNotContain}&destination.equals={destinationEquals}&destination.notEquals={destinationNotEquals}&destination.specified={destinationSpecified}&destination.in={destinationIn}&destination.notIn={destinationNotIn}&distance.greaterThan={distanceGreaterThan}&distance.lessThan={distanceLessThan}&distance.greaterThanOrEqual={distanceGreaterThanOrEqual}&distance.lessThanOrEqual={distanceLessThanOrEqual}&distance.equals={distanceEquals}&distance.notEquals={distanceNotEquals}&distance.specified={distanceSpecified}&distance.in={distanceIn}&distance.notIn={distanceNotIn}&estimatedDuration.greaterThan={estimatedDurationGreaterThan}&estimatedDuration.lessThan={estimatedDurationLessThan}&estimatedDuration.greaterThanOrEqual={estimatedDurationGreaterThanOrEqual}&estimatedDuration.lessThanOrEqual={estimatedDurationLessThanOrEqual}&estimatedDuration.equals={estimatedDurationEquals}&estimatedDuration.notEquals={estimatedDurationNotEquals}&estimatedDuration.specified={estimatedDurationSpecified}&estimatedDuration.in={estimatedDurationIn}&estimatedDuration.notIn={estimatedDurationNotIn}&transportType.equals={transportTypeEquals}&transportType.notEquals={transportTypeNotEquals}&transportType.specified={transportTypeSpecified}&transportType.in={transportTypeIn}&transportType.notIn={transportTypeNotIn}&isActive.equals={isActiveEquals}&isActive.notEquals={isActiveNotEquals}&isActive.specified={isActiveSpecified}&isActive.in={isActiveIn}&isActive.notIn={isActiveNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&routeNameId.equals={routeNameIdEquals}&routeNameId.notEquals={routeNameIdNotEquals}&routeNameId.specified={routeNameIdSpecified}&routeNameId.in={routeNameIdIn}&routeNameId.notIn={routeNameIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  Long countRoutes(@QueryMap(encoded=true) CountRoutesQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>countRoutes</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>idEquals -  (optional)</li>
          *   <li>idNotEquals -  (optional)</li>
          *   <li>idSpecified -  (optional)</li>
          *   <li>idIn -  (optional)</li>
          *   <li>idNotIn -  (optional)</li>
          *   <li>routeNameContains -  (optional)</li>
          *   <li>routeNameDoesNotContain -  (optional)</li>
          *   <li>routeNameEquals -  (optional)</li>
          *   <li>routeNameNotEquals -  (optional)</li>
          *   <li>routeNameSpecified -  (optional)</li>
          *   <li>routeNameIn -  (optional)</li>
          *   <li>routeNameNotIn -  (optional)</li>
          *   <li>originContains -  (optional)</li>
          *   <li>originDoesNotContain -  (optional)</li>
          *   <li>originEquals -  (optional)</li>
          *   <li>originNotEquals -  (optional)</li>
          *   <li>originSpecified -  (optional)</li>
          *   <li>originIn -  (optional)</li>
          *   <li>originNotIn -  (optional)</li>
          *   <li>destinationContains -  (optional)</li>
          *   <li>destinationDoesNotContain -  (optional)</li>
          *   <li>destinationEquals -  (optional)</li>
          *   <li>destinationNotEquals -  (optional)</li>
          *   <li>destinationSpecified -  (optional)</li>
          *   <li>destinationIn -  (optional)</li>
          *   <li>destinationNotIn -  (optional)</li>
          *   <li>distanceGreaterThan -  (optional)</li>
          *   <li>distanceLessThan -  (optional)</li>
          *   <li>distanceGreaterThanOrEqual -  (optional)</li>
          *   <li>distanceLessThanOrEqual -  (optional)</li>
          *   <li>distanceEquals -  (optional)</li>
          *   <li>distanceNotEquals -  (optional)</li>
          *   <li>distanceSpecified -  (optional)</li>
          *   <li>distanceIn -  (optional)</li>
          *   <li>distanceNotIn -  (optional)</li>
          *   <li>estimatedDurationGreaterThan -  (optional)</li>
          *   <li>estimatedDurationLessThan -  (optional)</li>
          *   <li>estimatedDurationGreaterThanOrEqual -  (optional)</li>
          *   <li>estimatedDurationLessThanOrEqual -  (optional)</li>
          *   <li>estimatedDurationEquals -  (optional)</li>
          *   <li>estimatedDurationNotEquals -  (optional)</li>
          *   <li>estimatedDurationSpecified -  (optional)</li>
          *   <li>estimatedDurationIn -  (optional)</li>
          *   <li>estimatedDurationNotIn -  (optional)</li>
          *   <li>transportTypeEquals -  (optional)</li>
          *   <li>transportTypeNotEquals -  (optional)</li>
          *   <li>transportTypeSpecified -  (optional)</li>
          *   <li>transportTypeIn -  (optional)</li>
          *   <li>transportTypeNotIn -  (optional)</li>
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
          *   <li>routeNameIdEquals -  (optional)</li>
          *   <li>routeNameIdNotEquals -  (optional)</li>
          *   <li>routeNameIdSpecified -  (optional)</li>
          *   <li>routeNameIdIn -  (optional)</li>
          *   <li>routeNameIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return Long
      */
      @RequestLine("GET /api/routes/count?id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&routeName.contains={routeNameContains}&routeName.doesNotContain={routeNameDoesNotContain}&routeName.equals={routeNameEquals}&routeName.notEquals={routeNameNotEquals}&routeName.specified={routeNameSpecified}&routeName.in={routeNameIn}&routeName.notIn={routeNameNotIn}&origin.contains={originContains}&origin.doesNotContain={originDoesNotContain}&origin.equals={originEquals}&origin.notEquals={originNotEquals}&origin.specified={originSpecified}&origin.in={originIn}&origin.notIn={originNotIn}&destination.contains={destinationContains}&destination.doesNotContain={destinationDoesNotContain}&destination.equals={destinationEquals}&destination.notEquals={destinationNotEquals}&destination.specified={destinationSpecified}&destination.in={destinationIn}&destination.notIn={destinationNotIn}&distance.greaterThan={distanceGreaterThan}&distance.lessThan={distanceLessThan}&distance.greaterThanOrEqual={distanceGreaterThanOrEqual}&distance.lessThanOrEqual={distanceLessThanOrEqual}&distance.equals={distanceEquals}&distance.notEquals={distanceNotEquals}&distance.specified={distanceSpecified}&distance.in={distanceIn}&distance.notIn={distanceNotIn}&estimatedDuration.greaterThan={estimatedDurationGreaterThan}&estimatedDuration.lessThan={estimatedDurationLessThan}&estimatedDuration.greaterThanOrEqual={estimatedDurationGreaterThanOrEqual}&estimatedDuration.lessThanOrEqual={estimatedDurationLessThanOrEqual}&estimatedDuration.equals={estimatedDurationEquals}&estimatedDuration.notEquals={estimatedDurationNotEquals}&estimatedDuration.specified={estimatedDurationSpecified}&estimatedDuration.in={estimatedDurationIn}&estimatedDuration.notIn={estimatedDurationNotIn}&transportType.equals={transportTypeEquals}&transportType.notEquals={transportTypeNotEquals}&transportType.specified={transportTypeSpecified}&transportType.in={transportTypeIn}&transportType.notIn={transportTypeNotIn}&isActive.equals={isActiveEquals}&isActive.notEquals={isActiveNotEquals}&isActive.specified={isActiveSpecified}&isActive.in={isActiveIn}&isActive.notIn={isActiveNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&routeNameId.equals={routeNameIdEquals}&routeNameId.notEquals={routeNameIdNotEquals}&routeNameId.specified={routeNameIdSpecified}&routeNameId.in={routeNameIdIn}&routeNameId.notIn={routeNameIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Long> countRoutesWithHttpInfo(@QueryMap(encoded=true) CountRoutesQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>countRoutes</code> method in a fluent style.
   */
  public static class CountRoutesQueryParams extends HashMap<String, Object> {
    public CountRoutesQueryParams idEquals(@jakarta.annotation.Nullable final UUID value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams idNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams idIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountRoutesQueryParams idNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountRoutesQueryParams routeNameContains(@jakarta.annotation.Nullable final String value) {
      put("routeName.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams routeNameDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("routeName.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams routeNameEquals(@jakarta.annotation.Nullable final String value) {
      put("routeName.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams routeNameNotEquals(@jakarta.annotation.Nullable final String value) {
      put("routeName.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams routeNameSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("routeName.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams routeNameIn(@jakarta.annotation.Nullable final List<String> value) {
      put("routeName.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountRoutesQueryParams routeNameNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("routeName.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountRoutesQueryParams originContains(@jakarta.annotation.Nullable final String value) {
      put("origin.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams originDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("origin.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams originEquals(@jakarta.annotation.Nullable final String value) {
      put("origin.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams originNotEquals(@jakarta.annotation.Nullable final String value) {
      put("origin.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams originSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("origin.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams originIn(@jakarta.annotation.Nullable final List<String> value) {
      put("origin.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountRoutesQueryParams originNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("origin.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountRoutesQueryParams destinationContains(@jakarta.annotation.Nullable final String value) {
      put("destination.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams destinationDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("destination.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams destinationEquals(@jakarta.annotation.Nullable final String value) {
      put("destination.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams destinationNotEquals(@jakarta.annotation.Nullable final String value) {
      put("destination.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams destinationSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("destination.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams destinationIn(@jakarta.annotation.Nullable final List<String> value) {
      put("destination.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountRoutesQueryParams destinationNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("destination.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountRoutesQueryParams distanceGreaterThan(@jakarta.annotation.Nullable final Double value) {
      put("distance.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams distanceLessThan(@jakarta.annotation.Nullable final Double value) {
      put("distance.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams distanceGreaterThanOrEqual(@jakarta.annotation.Nullable final Double value) {
      put("distance.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams distanceLessThanOrEqual(@jakarta.annotation.Nullable final Double value) {
      put("distance.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams distanceEquals(@jakarta.annotation.Nullable final Double value) {
      put("distance.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams distanceNotEquals(@jakarta.annotation.Nullable final Double value) {
      put("distance.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams distanceSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("distance.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams distanceIn(@jakarta.annotation.Nullable final List<Double> value) {
      put("distance.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountRoutesQueryParams distanceNotIn(@jakarta.annotation.Nullable final List<Double> value) {
      put("distance.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountRoutesQueryParams estimatedDurationGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("estimatedDuration.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams estimatedDurationLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("estimatedDuration.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams estimatedDurationGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("estimatedDuration.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams estimatedDurationLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("estimatedDuration.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams estimatedDurationEquals(@jakarta.annotation.Nullable final Integer value) {
      put("estimatedDuration.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams estimatedDurationNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("estimatedDuration.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams estimatedDurationSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("estimatedDuration.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams estimatedDurationIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("estimatedDuration.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountRoutesQueryParams estimatedDurationNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("estimatedDuration.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountRoutesQueryParams transportTypeEquals(@jakarta.annotation.Nullable final String value) {
      put("transportType.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams transportTypeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("transportType.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams transportTypeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("transportType.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams transportTypeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("transportType.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountRoutesQueryParams transportTypeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("transportType.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountRoutesQueryParams isActiveEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isActive.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams isActiveNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isActive.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams isActiveSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isActive.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams isActiveIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isActive.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountRoutesQueryParams isActiveNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isActive.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountRoutesQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountRoutesQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountRoutesQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountRoutesQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountRoutesQueryParams routeNameIdEquals(@jakarta.annotation.Nullable final UUID value) {
      put("routeNameId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams routeNameIdNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("routeNameId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams routeNameIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("routeNameId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountRoutesQueryParams routeNameIdIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("routeNameId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountRoutesQueryParams routeNameIdNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("routeNameId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountRoutesQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param routeDTO  (required)
   * @return RouteDTO
   */
  @RequestLine("POST /api/routes")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  RouteDTO createRoute(@jakarta.annotation.Nonnull RouteDTO routeDTO);

  /**
   * 
   * Similar to <code>createRoute</code> but it also returns the http response headers .
   * 
   * @param routeDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/routes")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<RouteDTO> createRouteWithHttpInfo(@jakarta.annotation.Nonnull RouteDTO routeDTO);



  /**
   * 
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/routes/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteRoute(@Param("id") @jakarta.annotation.Nonnull UUID id);

  /**
   * 
   * Similar to <code>deleteRoute</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/routes/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteRouteWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull UUID id);



  /**
   * 
   * 
   * @param idEquals  (optional)
   * @param idNotEquals  (optional)
   * @param idSpecified  (optional)
   * @param idIn  (optional)
   * @param idNotIn  (optional)
   * @param routeNameContains  (optional)
   * @param routeNameDoesNotContain  (optional)
   * @param routeNameEquals  (optional)
   * @param routeNameNotEquals  (optional)
   * @param routeNameSpecified  (optional)
   * @param routeNameIn  (optional)
   * @param routeNameNotIn  (optional)
   * @param originContains  (optional)
   * @param originDoesNotContain  (optional)
   * @param originEquals  (optional)
   * @param originNotEquals  (optional)
   * @param originSpecified  (optional)
   * @param originIn  (optional)
   * @param originNotIn  (optional)
   * @param destinationContains  (optional)
   * @param destinationDoesNotContain  (optional)
   * @param destinationEquals  (optional)
   * @param destinationNotEquals  (optional)
   * @param destinationSpecified  (optional)
   * @param destinationIn  (optional)
   * @param destinationNotIn  (optional)
   * @param distanceGreaterThan  (optional)
   * @param distanceLessThan  (optional)
   * @param distanceGreaterThanOrEqual  (optional)
   * @param distanceLessThanOrEqual  (optional)
   * @param distanceEquals  (optional)
   * @param distanceNotEquals  (optional)
   * @param distanceSpecified  (optional)
   * @param distanceIn  (optional)
   * @param distanceNotIn  (optional)
   * @param estimatedDurationGreaterThan  (optional)
   * @param estimatedDurationLessThan  (optional)
   * @param estimatedDurationGreaterThanOrEqual  (optional)
   * @param estimatedDurationLessThanOrEqual  (optional)
   * @param estimatedDurationEquals  (optional)
   * @param estimatedDurationNotEquals  (optional)
   * @param estimatedDurationSpecified  (optional)
   * @param estimatedDurationIn  (optional)
   * @param estimatedDurationNotIn  (optional)
   * @param transportTypeEquals  (optional)
   * @param transportTypeNotEquals  (optional)
   * @param transportTypeSpecified  (optional)
   * @param transportTypeIn  (optional)
   * @param transportTypeNotIn  (optional)
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
   * @param routeNameIdEquals  (optional)
   * @param routeNameIdNotEquals  (optional)
   * @param routeNameIdSpecified  (optional)
   * @param routeNameIdIn  (optional)
   * @param routeNameIdNotIn  (optional)
   * @param distinct  (optional)
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return List&lt;RouteDTO&gt;
   */
  @RequestLine("GET /api/routes?id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&routeName.contains={routeNameContains}&routeName.doesNotContain={routeNameDoesNotContain}&routeName.equals={routeNameEquals}&routeName.notEquals={routeNameNotEquals}&routeName.specified={routeNameSpecified}&routeName.in={routeNameIn}&routeName.notIn={routeNameNotIn}&origin.contains={originContains}&origin.doesNotContain={originDoesNotContain}&origin.equals={originEquals}&origin.notEquals={originNotEquals}&origin.specified={originSpecified}&origin.in={originIn}&origin.notIn={originNotIn}&destination.contains={destinationContains}&destination.doesNotContain={destinationDoesNotContain}&destination.equals={destinationEquals}&destination.notEquals={destinationNotEquals}&destination.specified={destinationSpecified}&destination.in={destinationIn}&destination.notIn={destinationNotIn}&distance.greaterThan={distanceGreaterThan}&distance.lessThan={distanceLessThan}&distance.greaterThanOrEqual={distanceGreaterThanOrEqual}&distance.lessThanOrEqual={distanceLessThanOrEqual}&distance.equals={distanceEquals}&distance.notEquals={distanceNotEquals}&distance.specified={distanceSpecified}&distance.in={distanceIn}&distance.notIn={distanceNotIn}&estimatedDuration.greaterThan={estimatedDurationGreaterThan}&estimatedDuration.lessThan={estimatedDurationLessThan}&estimatedDuration.greaterThanOrEqual={estimatedDurationGreaterThanOrEqual}&estimatedDuration.lessThanOrEqual={estimatedDurationLessThanOrEqual}&estimatedDuration.equals={estimatedDurationEquals}&estimatedDuration.notEquals={estimatedDurationNotEquals}&estimatedDuration.specified={estimatedDurationSpecified}&estimatedDuration.in={estimatedDurationIn}&estimatedDuration.notIn={estimatedDurationNotIn}&transportType.equals={transportTypeEquals}&transportType.notEquals={transportTypeNotEquals}&transportType.specified={transportTypeSpecified}&transportType.in={transportTypeIn}&transportType.notIn={transportTypeNotIn}&isActive.equals={isActiveEquals}&isActive.notEquals={isActiveNotEquals}&isActive.specified={isActiveSpecified}&isActive.in={isActiveIn}&isActive.notIn={isActiveNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&routeNameId.equals={routeNameIdEquals}&routeNameId.notEquals={routeNameIdNotEquals}&routeNameId.specified={routeNameIdSpecified}&routeNameId.in={routeNameIdIn}&routeNameId.notIn={routeNameIdNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",
  })
  List<RouteDTO> getAllRoutes(@Param("idEquals") @jakarta.annotation.Nullable UUID idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable UUID idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<UUID> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<UUID> idNotIn, @Param("routeNameContains") @jakarta.annotation.Nullable String routeNameContains, @Param("routeNameDoesNotContain") @jakarta.annotation.Nullable String routeNameDoesNotContain, @Param("routeNameEquals") @jakarta.annotation.Nullable String routeNameEquals, @Param("routeNameNotEquals") @jakarta.annotation.Nullable String routeNameNotEquals, @Param("routeNameSpecified") @jakarta.annotation.Nullable Boolean routeNameSpecified, @Param("routeNameIn") @jakarta.annotation.Nullable List<String> routeNameIn, @Param("routeNameNotIn") @jakarta.annotation.Nullable List<String> routeNameNotIn, @Param("originContains") @jakarta.annotation.Nullable String originContains, @Param("originDoesNotContain") @jakarta.annotation.Nullable String originDoesNotContain, @Param("originEquals") @jakarta.annotation.Nullable String originEquals, @Param("originNotEquals") @jakarta.annotation.Nullable String originNotEquals, @Param("originSpecified") @jakarta.annotation.Nullable Boolean originSpecified, @Param("originIn") @jakarta.annotation.Nullable List<String> originIn, @Param("originNotIn") @jakarta.annotation.Nullable List<String> originNotIn, @Param("destinationContains") @jakarta.annotation.Nullable String destinationContains, @Param("destinationDoesNotContain") @jakarta.annotation.Nullable String destinationDoesNotContain, @Param("destinationEquals") @jakarta.annotation.Nullable String destinationEquals, @Param("destinationNotEquals") @jakarta.annotation.Nullable String destinationNotEquals, @Param("destinationSpecified") @jakarta.annotation.Nullable Boolean destinationSpecified, @Param("destinationIn") @jakarta.annotation.Nullable List<String> destinationIn, @Param("destinationNotIn") @jakarta.annotation.Nullable List<String> destinationNotIn, @Param("distanceGreaterThan") @jakarta.annotation.Nullable Double distanceGreaterThan, @Param("distanceLessThan") @jakarta.annotation.Nullable Double distanceLessThan, @Param("distanceGreaterThanOrEqual") @jakarta.annotation.Nullable Double distanceGreaterThanOrEqual, @Param("distanceLessThanOrEqual") @jakarta.annotation.Nullable Double distanceLessThanOrEqual, @Param("distanceEquals") @jakarta.annotation.Nullable Double distanceEquals, @Param("distanceNotEquals") @jakarta.annotation.Nullable Double distanceNotEquals, @Param("distanceSpecified") @jakarta.annotation.Nullable Boolean distanceSpecified, @Param("distanceIn") @jakarta.annotation.Nullable List<Double> distanceIn, @Param("distanceNotIn") @jakarta.annotation.Nullable List<Double> distanceNotIn, @Param("estimatedDurationGreaterThan") @jakarta.annotation.Nullable Integer estimatedDurationGreaterThan, @Param("estimatedDurationLessThan") @jakarta.annotation.Nullable Integer estimatedDurationLessThan, @Param("estimatedDurationGreaterThanOrEqual") @jakarta.annotation.Nullable Integer estimatedDurationGreaterThanOrEqual, @Param("estimatedDurationLessThanOrEqual") @jakarta.annotation.Nullable Integer estimatedDurationLessThanOrEqual, @Param("estimatedDurationEquals") @jakarta.annotation.Nullable Integer estimatedDurationEquals, @Param("estimatedDurationNotEquals") @jakarta.annotation.Nullable Integer estimatedDurationNotEquals, @Param("estimatedDurationSpecified") @jakarta.annotation.Nullable Boolean estimatedDurationSpecified, @Param("estimatedDurationIn") @jakarta.annotation.Nullable List<Integer> estimatedDurationIn, @Param("estimatedDurationNotIn") @jakarta.annotation.Nullable List<Integer> estimatedDurationNotIn, @Param("transportTypeEquals") @jakarta.annotation.Nullable String transportTypeEquals, @Param("transportTypeNotEquals") @jakarta.annotation.Nullable String transportTypeNotEquals, @Param("transportTypeSpecified") @jakarta.annotation.Nullable Boolean transportTypeSpecified, @Param("transportTypeIn") @jakarta.annotation.Nullable List<String> transportTypeIn, @Param("transportTypeNotIn") @jakarta.annotation.Nullable List<String> transportTypeNotIn, @Param("isActiveEquals") @jakarta.annotation.Nullable Boolean isActiveEquals, @Param("isActiveNotEquals") @jakarta.annotation.Nullable Boolean isActiveNotEquals, @Param("isActiveSpecified") @jakarta.annotation.Nullable Boolean isActiveSpecified, @Param("isActiveIn") @jakarta.annotation.Nullable List<Boolean> isActiveIn, @Param("isActiveNotIn") @jakarta.annotation.Nullable List<Boolean> isActiveNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("routeNameIdEquals") @jakarta.annotation.Nullable UUID routeNameIdEquals, @Param("routeNameIdNotEquals") @jakarta.annotation.Nullable UUID routeNameIdNotEquals, @Param("routeNameIdSpecified") @jakarta.annotation.Nullable Boolean routeNameIdSpecified, @Param("routeNameIdIn") @jakarta.annotation.Nullable List<UUID> routeNameIdIn, @Param("routeNameIdNotIn") @jakarta.annotation.Nullable List<UUID> routeNameIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct, @Param("page") @jakarta.annotation.Nullable Integer page, @Param("size") @jakarta.annotation.Nullable Integer size, @Param("sort") @jakarta.annotation.Nullable List<String> sort);

  /**
   * 
   * Similar to <code>getAllRoutes</code> but it also returns the http response headers .
   * 
   * @param idEquals  (optional)
   * @param idNotEquals  (optional)
   * @param idSpecified  (optional)
   * @param idIn  (optional)
   * @param idNotIn  (optional)
   * @param routeNameContains  (optional)
   * @param routeNameDoesNotContain  (optional)
   * @param routeNameEquals  (optional)
   * @param routeNameNotEquals  (optional)
   * @param routeNameSpecified  (optional)
   * @param routeNameIn  (optional)
   * @param routeNameNotIn  (optional)
   * @param originContains  (optional)
   * @param originDoesNotContain  (optional)
   * @param originEquals  (optional)
   * @param originNotEquals  (optional)
   * @param originSpecified  (optional)
   * @param originIn  (optional)
   * @param originNotIn  (optional)
   * @param destinationContains  (optional)
   * @param destinationDoesNotContain  (optional)
   * @param destinationEquals  (optional)
   * @param destinationNotEquals  (optional)
   * @param destinationSpecified  (optional)
   * @param destinationIn  (optional)
   * @param destinationNotIn  (optional)
   * @param distanceGreaterThan  (optional)
   * @param distanceLessThan  (optional)
   * @param distanceGreaterThanOrEqual  (optional)
   * @param distanceLessThanOrEqual  (optional)
   * @param distanceEquals  (optional)
   * @param distanceNotEquals  (optional)
   * @param distanceSpecified  (optional)
   * @param distanceIn  (optional)
   * @param distanceNotIn  (optional)
   * @param estimatedDurationGreaterThan  (optional)
   * @param estimatedDurationLessThan  (optional)
   * @param estimatedDurationGreaterThanOrEqual  (optional)
   * @param estimatedDurationLessThanOrEqual  (optional)
   * @param estimatedDurationEquals  (optional)
   * @param estimatedDurationNotEquals  (optional)
   * @param estimatedDurationSpecified  (optional)
   * @param estimatedDurationIn  (optional)
   * @param estimatedDurationNotIn  (optional)
   * @param transportTypeEquals  (optional)
   * @param transportTypeNotEquals  (optional)
   * @param transportTypeSpecified  (optional)
   * @param transportTypeIn  (optional)
   * @param transportTypeNotIn  (optional)
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
   * @param routeNameIdEquals  (optional)
   * @param routeNameIdNotEquals  (optional)
   * @param routeNameIdSpecified  (optional)
   * @param routeNameIdIn  (optional)
   * @param routeNameIdNotIn  (optional)
   * @param distinct  (optional)
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/routes?id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&routeName.contains={routeNameContains}&routeName.doesNotContain={routeNameDoesNotContain}&routeName.equals={routeNameEquals}&routeName.notEquals={routeNameNotEquals}&routeName.specified={routeNameSpecified}&routeName.in={routeNameIn}&routeName.notIn={routeNameNotIn}&origin.contains={originContains}&origin.doesNotContain={originDoesNotContain}&origin.equals={originEquals}&origin.notEquals={originNotEquals}&origin.specified={originSpecified}&origin.in={originIn}&origin.notIn={originNotIn}&destination.contains={destinationContains}&destination.doesNotContain={destinationDoesNotContain}&destination.equals={destinationEquals}&destination.notEquals={destinationNotEquals}&destination.specified={destinationSpecified}&destination.in={destinationIn}&destination.notIn={destinationNotIn}&distance.greaterThan={distanceGreaterThan}&distance.lessThan={distanceLessThan}&distance.greaterThanOrEqual={distanceGreaterThanOrEqual}&distance.lessThanOrEqual={distanceLessThanOrEqual}&distance.equals={distanceEquals}&distance.notEquals={distanceNotEquals}&distance.specified={distanceSpecified}&distance.in={distanceIn}&distance.notIn={distanceNotIn}&estimatedDuration.greaterThan={estimatedDurationGreaterThan}&estimatedDuration.lessThan={estimatedDurationLessThan}&estimatedDuration.greaterThanOrEqual={estimatedDurationGreaterThanOrEqual}&estimatedDuration.lessThanOrEqual={estimatedDurationLessThanOrEqual}&estimatedDuration.equals={estimatedDurationEquals}&estimatedDuration.notEquals={estimatedDurationNotEquals}&estimatedDuration.specified={estimatedDurationSpecified}&estimatedDuration.in={estimatedDurationIn}&estimatedDuration.notIn={estimatedDurationNotIn}&transportType.equals={transportTypeEquals}&transportType.notEquals={transportTypeNotEquals}&transportType.specified={transportTypeSpecified}&transportType.in={transportTypeIn}&transportType.notIn={transportTypeNotIn}&isActive.equals={isActiveEquals}&isActive.notEquals={isActiveNotEquals}&isActive.specified={isActiveSpecified}&isActive.in={isActiveIn}&isActive.notIn={isActiveNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&routeNameId.equals={routeNameIdEquals}&routeNameId.notEquals={routeNameIdNotEquals}&routeNameId.specified={routeNameIdSpecified}&routeNameId.in={routeNameIdIn}&routeNameId.notIn={routeNameIdNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<RouteDTO>> getAllRoutesWithHttpInfo(@Param("idEquals") @jakarta.annotation.Nullable UUID idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable UUID idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<UUID> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<UUID> idNotIn, @Param("routeNameContains") @jakarta.annotation.Nullable String routeNameContains, @Param("routeNameDoesNotContain") @jakarta.annotation.Nullable String routeNameDoesNotContain, @Param("routeNameEquals") @jakarta.annotation.Nullable String routeNameEquals, @Param("routeNameNotEquals") @jakarta.annotation.Nullable String routeNameNotEquals, @Param("routeNameSpecified") @jakarta.annotation.Nullable Boolean routeNameSpecified, @Param("routeNameIn") @jakarta.annotation.Nullable List<String> routeNameIn, @Param("routeNameNotIn") @jakarta.annotation.Nullable List<String> routeNameNotIn, @Param("originContains") @jakarta.annotation.Nullable String originContains, @Param("originDoesNotContain") @jakarta.annotation.Nullable String originDoesNotContain, @Param("originEquals") @jakarta.annotation.Nullable String originEquals, @Param("originNotEquals") @jakarta.annotation.Nullable String originNotEquals, @Param("originSpecified") @jakarta.annotation.Nullable Boolean originSpecified, @Param("originIn") @jakarta.annotation.Nullable List<String> originIn, @Param("originNotIn") @jakarta.annotation.Nullable List<String> originNotIn, @Param("destinationContains") @jakarta.annotation.Nullable String destinationContains, @Param("destinationDoesNotContain") @jakarta.annotation.Nullable String destinationDoesNotContain, @Param("destinationEquals") @jakarta.annotation.Nullable String destinationEquals, @Param("destinationNotEquals") @jakarta.annotation.Nullable String destinationNotEquals, @Param("destinationSpecified") @jakarta.annotation.Nullable Boolean destinationSpecified, @Param("destinationIn") @jakarta.annotation.Nullable List<String> destinationIn, @Param("destinationNotIn") @jakarta.annotation.Nullable List<String> destinationNotIn, @Param("distanceGreaterThan") @jakarta.annotation.Nullable Double distanceGreaterThan, @Param("distanceLessThan") @jakarta.annotation.Nullable Double distanceLessThan, @Param("distanceGreaterThanOrEqual") @jakarta.annotation.Nullable Double distanceGreaterThanOrEqual, @Param("distanceLessThanOrEqual") @jakarta.annotation.Nullable Double distanceLessThanOrEqual, @Param("distanceEquals") @jakarta.annotation.Nullable Double distanceEquals, @Param("distanceNotEquals") @jakarta.annotation.Nullable Double distanceNotEquals, @Param("distanceSpecified") @jakarta.annotation.Nullable Boolean distanceSpecified, @Param("distanceIn") @jakarta.annotation.Nullable List<Double> distanceIn, @Param("distanceNotIn") @jakarta.annotation.Nullable List<Double> distanceNotIn, @Param("estimatedDurationGreaterThan") @jakarta.annotation.Nullable Integer estimatedDurationGreaterThan, @Param("estimatedDurationLessThan") @jakarta.annotation.Nullable Integer estimatedDurationLessThan, @Param("estimatedDurationGreaterThanOrEqual") @jakarta.annotation.Nullable Integer estimatedDurationGreaterThanOrEqual, @Param("estimatedDurationLessThanOrEqual") @jakarta.annotation.Nullable Integer estimatedDurationLessThanOrEqual, @Param("estimatedDurationEquals") @jakarta.annotation.Nullable Integer estimatedDurationEquals, @Param("estimatedDurationNotEquals") @jakarta.annotation.Nullable Integer estimatedDurationNotEquals, @Param("estimatedDurationSpecified") @jakarta.annotation.Nullable Boolean estimatedDurationSpecified, @Param("estimatedDurationIn") @jakarta.annotation.Nullable List<Integer> estimatedDurationIn, @Param("estimatedDurationNotIn") @jakarta.annotation.Nullable List<Integer> estimatedDurationNotIn, @Param("transportTypeEquals") @jakarta.annotation.Nullable String transportTypeEquals, @Param("transportTypeNotEquals") @jakarta.annotation.Nullable String transportTypeNotEquals, @Param("transportTypeSpecified") @jakarta.annotation.Nullable Boolean transportTypeSpecified, @Param("transportTypeIn") @jakarta.annotation.Nullable List<String> transportTypeIn, @Param("transportTypeNotIn") @jakarta.annotation.Nullable List<String> transportTypeNotIn, @Param("isActiveEquals") @jakarta.annotation.Nullable Boolean isActiveEquals, @Param("isActiveNotEquals") @jakarta.annotation.Nullable Boolean isActiveNotEquals, @Param("isActiveSpecified") @jakarta.annotation.Nullable Boolean isActiveSpecified, @Param("isActiveIn") @jakarta.annotation.Nullable List<Boolean> isActiveIn, @Param("isActiveNotIn") @jakarta.annotation.Nullable List<Boolean> isActiveNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("routeNameIdEquals") @jakarta.annotation.Nullable UUID routeNameIdEquals, @Param("routeNameIdNotEquals") @jakarta.annotation.Nullable UUID routeNameIdNotEquals, @Param("routeNameIdSpecified") @jakarta.annotation.Nullable Boolean routeNameIdSpecified, @Param("routeNameIdIn") @jakarta.annotation.Nullable List<UUID> routeNameIdIn, @Param("routeNameIdNotIn") @jakarta.annotation.Nullable List<UUID> routeNameIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct, @Param("page") @jakarta.annotation.Nullable Integer page, @Param("size") @jakarta.annotation.Nullable Integer size, @Param("sort") @jakarta.annotation.Nullable List<String> sort);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllRoutes</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllRoutesQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>idEquals -  (optional)</li>
   *   <li>idNotEquals -  (optional)</li>
   *   <li>idSpecified -  (optional)</li>
   *   <li>idIn -  (optional)</li>
   *   <li>idNotIn -  (optional)</li>
   *   <li>routeNameContains -  (optional)</li>
   *   <li>routeNameDoesNotContain -  (optional)</li>
   *   <li>routeNameEquals -  (optional)</li>
   *   <li>routeNameNotEquals -  (optional)</li>
   *   <li>routeNameSpecified -  (optional)</li>
   *   <li>routeNameIn -  (optional)</li>
   *   <li>routeNameNotIn -  (optional)</li>
   *   <li>originContains -  (optional)</li>
   *   <li>originDoesNotContain -  (optional)</li>
   *   <li>originEquals -  (optional)</li>
   *   <li>originNotEquals -  (optional)</li>
   *   <li>originSpecified -  (optional)</li>
   *   <li>originIn -  (optional)</li>
   *   <li>originNotIn -  (optional)</li>
   *   <li>destinationContains -  (optional)</li>
   *   <li>destinationDoesNotContain -  (optional)</li>
   *   <li>destinationEquals -  (optional)</li>
   *   <li>destinationNotEquals -  (optional)</li>
   *   <li>destinationSpecified -  (optional)</li>
   *   <li>destinationIn -  (optional)</li>
   *   <li>destinationNotIn -  (optional)</li>
   *   <li>distanceGreaterThan -  (optional)</li>
   *   <li>distanceLessThan -  (optional)</li>
   *   <li>distanceGreaterThanOrEqual -  (optional)</li>
   *   <li>distanceLessThanOrEqual -  (optional)</li>
   *   <li>distanceEquals -  (optional)</li>
   *   <li>distanceNotEquals -  (optional)</li>
   *   <li>distanceSpecified -  (optional)</li>
   *   <li>distanceIn -  (optional)</li>
   *   <li>distanceNotIn -  (optional)</li>
   *   <li>estimatedDurationGreaterThan -  (optional)</li>
   *   <li>estimatedDurationLessThan -  (optional)</li>
   *   <li>estimatedDurationGreaterThanOrEqual -  (optional)</li>
   *   <li>estimatedDurationLessThanOrEqual -  (optional)</li>
   *   <li>estimatedDurationEquals -  (optional)</li>
   *   <li>estimatedDurationNotEquals -  (optional)</li>
   *   <li>estimatedDurationSpecified -  (optional)</li>
   *   <li>estimatedDurationIn -  (optional)</li>
   *   <li>estimatedDurationNotIn -  (optional)</li>
   *   <li>transportTypeEquals -  (optional)</li>
   *   <li>transportTypeNotEquals -  (optional)</li>
   *   <li>transportTypeSpecified -  (optional)</li>
   *   <li>transportTypeIn -  (optional)</li>
   *   <li>transportTypeNotIn -  (optional)</li>
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
   *   <li>routeNameIdEquals -  (optional)</li>
   *   <li>routeNameIdNotEquals -  (optional)</li>
   *   <li>routeNameIdSpecified -  (optional)</li>
   *   <li>routeNameIdIn -  (optional)</li>
   *   <li>routeNameIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   <li>page - Zero-based page index (0..N) (optional, default to 0)</li>
   *   <li>size - The size of the page to be returned (optional, default to 20)</li>
   *   <li>sort - Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)</li>
   *   </ul>
   * @return List&lt;RouteDTO&gt;
   */
  @RequestLine("GET /api/routes?id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&routeName.contains={routeNameContains}&routeName.doesNotContain={routeNameDoesNotContain}&routeName.equals={routeNameEquals}&routeName.notEquals={routeNameNotEquals}&routeName.specified={routeNameSpecified}&routeName.in={routeNameIn}&routeName.notIn={routeNameNotIn}&origin.contains={originContains}&origin.doesNotContain={originDoesNotContain}&origin.equals={originEquals}&origin.notEquals={originNotEquals}&origin.specified={originSpecified}&origin.in={originIn}&origin.notIn={originNotIn}&destination.contains={destinationContains}&destination.doesNotContain={destinationDoesNotContain}&destination.equals={destinationEquals}&destination.notEquals={destinationNotEquals}&destination.specified={destinationSpecified}&destination.in={destinationIn}&destination.notIn={destinationNotIn}&distance.greaterThan={distanceGreaterThan}&distance.lessThan={distanceLessThan}&distance.greaterThanOrEqual={distanceGreaterThanOrEqual}&distance.lessThanOrEqual={distanceLessThanOrEqual}&distance.equals={distanceEquals}&distance.notEquals={distanceNotEquals}&distance.specified={distanceSpecified}&distance.in={distanceIn}&distance.notIn={distanceNotIn}&estimatedDuration.greaterThan={estimatedDurationGreaterThan}&estimatedDuration.lessThan={estimatedDurationLessThan}&estimatedDuration.greaterThanOrEqual={estimatedDurationGreaterThanOrEqual}&estimatedDuration.lessThanOrEqual={estimatedDurationLessThanOrEqual}&estimatedDuration.equals={estimatedDurationEquals}&estimatedDuration.notEquals={estimatedDurationNotEquals}&estimatedDuration.specified={estimatedDurationSpecified}&estimatedDuration.in={estimatedDurationIn}&estimatedDuration.notIn={estimatedDurationNotIn}&transportType.equals={transportTypeEquals}&transportType.notEquals={transportTypeNotEquals}&transportType.specified={transportTypeSpecified}&transportType.in={transportTypeIn}&transportType.notIn={transportTypeNotIn}&isActive.equals={isActiveEquals}&isActive.notEquals={isActiveNotEquals}&isActive.specified={isActiveSpecified}&isActive.in={isActiveIn}&isActive.notIn={isActiveNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&routeNameId.equals={routeNameIdEquals}&routeNameId.notEquals={routeNameIdNotEquals}&routeNameId.specified={routeNameIdSpecified}&routeNameId.in={routeNameIdIn}&routeNameId.notIn={routeNameIdNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
  @Headers({
  "Accept: */*",
  })
  List<RouteDTO> getAllRoutes(@QueryMap(encoded=true) GetAllRoutesQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllRoutes</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>idEquals -  (optional)</li>
          *   <li>idNotEquals -  (optional)</li>
          *   <li>idSpecified -  (optional)</li>
          *   <li>idIn -  (optional)</li>
          *   <li>idNotIn -  (optional)</li>
          *   <li>routeNameContains -  (optional)</li>
          *   <li>routeNameDoesNotContain -  (optional)</li>
          *   <li>routeNameEquals -  (optional)</li>
          *   <li>routeNameNotEquals -  (optional)</li>
          *   <li>routeNameSpecified -  (optional)</li>
          *   <li>routeNameIn -  (optional)</li>
          *   <li>routeNameNotIn -  (optional)</li>
          *   <li>originContains -  (optional)</li>
          *   <li>originDoesNotContain -  (optional)</li>
          *   <li>originEquals -  (optional)</li>
          *   <li>originNotEquals -  (optional)</li>
          *   <li>originSpecified -  (optional)</li>
          *   <li>originIn -  (optional)</li>
          *   <li>originNotIn -  (optional)</li>
          *   <li>destinationContains -  (optional)</li>
          *   <li>destinationDoesNotContain -  (optional)</li>
          *   <li>destinationEquals -  (optional)</li>
          *   <li>destinationNotEquals -  (optional)</li>
          *   <li>destinationSpecified -  (optional)</li>
          *   <li>destinationIn -  (optional)</li>
          *   <li>destinationNotIn -  (optional)</li>
          *   <li>distanceGreaterThan -  (optional)</li>
          *   <li>distanceLessThan -  (optional)</li>
          *   <li>distanceGreaterThanOrEqual -  (optional)</li>
          *   <li>distanceLessThanOrEqual -  (optional)</li>
          *   <li>distanceEquals -  (optional)</li>
          *   <li>distanceNotEquals -  (optional)</li>
          *   <li>distanceSpecified -  (optional)</li>
          *   <li>distanceIn -  (optional)</li>
          *   <li>distanceNotIn -  (optional)</li>
          *   <li>estimatedDurationGreaterThan -  (optional)</li>
          *   <li>estimatedDurationLessThan -  (optional)</li>
          *   <li>estimatedDurationGreaterThanOrEqual -  (optional)</li>
          *   <li>estimatedDurationLessThanOrEqual -  (optional)</li>
          *   <li>estimatedDurationEquals -  (optional)</li>
          *   <li>estimatedDurationNotEquals -  (optional)</li>
          *   <li>estimatedDurationSpecified -  (optional)</li>
          *   <li>estimatedDurationIn -  (optional)</li>
          *   <li>estimatedDurationNotIn -  (optional)</li>
          *   <li>transportTypeEquals -  (optional)</li>
          *   <li>transportTypeNotEquals -  (optional)</li>
          *   <li>transportTypeSpecified -  (optional)</li>
          *   <li>transportTypeIn -  (optional)</li>
          *   <li>transportTypeNotIn -  (optional)</li>
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
          *   <li>routeNameIdEquals -  (optional)</li>
          *   <li>routeNameIdNotEquals -  (optional)</li>
          *   <li>routeNameIdSpecified -  (optional)</li>
          *   <li>routeNameIdIn -  (optional)</li>
          *   <li>routeNameIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
          *   <li>page - Zero-based page index (0..N) (optional, default to 0)</li>
          *   <li>size - The size of the page to be returned (optional, default to 20)</li>
          *   <li>sort - Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)</li>
      *   </ul>
          * @return List&lt;RouteDTO&gt;
      */
      @RequestLine("GET /api/routes?id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&routeName.contains={routeNameContains}&routeName.doesNotContain={routeNameDoesNotContain}&routeName.equals={routeNameEquals}&routeName.notEquals={routeNameNotEquals}&routeName.specified={routeNameSpecified}&routeName.in={routeNameIn}&routeName.notIn={routeNameNotIn}&origin.contains={originContains}&origin.doesNotContain={originDoesNotContain}&origin.equals={originEquals}&origin.notEquals={originNotEquals}&origin.specified={originSpecified}&origin.in={originIn}&origin.notIn={originNotIn}&destination.contains={destinationContains}&destination.doesNotContain={destinationDoesNotContain}&destination.equals={destinationEquals}&destination.notEquals={destinationNotEquals}&destination.specified={destinationSpecified}&destination.in={destinationIn}&destination.notIn={destinationNotIn}&distance.greaterThan={distanceGreaterThan}&distance.lessThan={distanceLessThan}&distance.greaterThanOrEqual={distanceGreaterThanOrEqual}&distance.lessThanOrEqual={distanceLessThanOrEqual}&distance.equals={distanceEquals}&distance.notEquals={distanceNotEquals}&distance.specified={distanceSpecified}&distance.in={distanceIn}&distance.notIn={distanceNotIn}&estimatedDuration.greaterThan={estimatedDurationGreaterThan}&estimatedDuration.lessThan={estimatedDurationLessThan}&estimatedDuration.greaterThanOrEqual={estimatedDurationGreaterThanOrEqual}&estimatedDuration.lessThanOrEqual={estimatedDurationLessThanOrEqual}&estimatedDuration.equals={estimatedDurationEquals}&estimatedDuration.notEquals={estimatedDurationNotEquals}&estimatedDuration.specified={estimatedDurationSpecified}&estimatedDuration.in={estimatedDurationIn}&estimatedDuration.notIn={estimatedDurationNotIn}&transportType.equals={transportTypeEquals}&transportType.notEquals={transportTypeNotEquals}&transportType.specified={transportTypeSpecified}&transportType.in={transportTypeIn}&transportType.notIn={transportTypeNotIn}&isActive.equals={isActiveEquals}&isActive.notEquals={isActiveNotEquals}&isActive.specified={isActiveSpecified}&isActive.in={isActiveIn}&isActive.notIn={isActiveNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&routeNameId.equals={routeNameIdEquals}&routeNameId.notEquals={routeNameIdNotEquals}&routeNameId.specified={routeNameIdSpecified}&routeNameId.in={routeNameIdIn}&routeNameId.notIn={routeNameIdNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<RouteDTO>> getAllRoutesWithHttpInfo(@QueryMap(encoded=true) GetAllRoutesQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllRoutes</code> method in a fluent style.
   */
  public static class GetAllRoutesQueryParams extends HashMap<String, Object> {
    public GetAllRoutesQueryParams idEquals(@jakarta.annotation.Nullable final UUID value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams idNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams idIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllRoutesQueryParams idNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllRoutesQueryParams routeNameContains(@jakarta.annotation.Nullable final String value) {
      put("routeName.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams routeNameDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("routeName.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams routeNameEquals(@jakarta.annotation.Nullable final String value) {
      put("routeName.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams routeNameNotEquals(@jakarta.annotation.Nullable final String value) {
      put("routeName.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams routeNameSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("routeName.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams routeNameIn(@jakarta.annotation.Nullable final List<String> value) {
      put("routeName.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllRoutesQueryParams routeNameNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("routeName.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllRoutesQueryParams originContains(@jakarta.annotation.Nullable final String value) {
      put("origin.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams originDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("origin.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams originEquals(@jakarta.annotation.Nullable final String value) {
      put("origin.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams originNotEquals(@jakarta.annotation.Nullable final String value) {
      put("origin.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams originSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("origin.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams originIn(@jakarta.annotation.Nullable final List<String> value) {
      put("origin.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllRoutesQueryParams originNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("origin.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllRoutesQueryParams destinationContains(@jakarta.annotation.Nullable final String value) {
      put("destination.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams destinationDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("destination.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams destinationEquals(@jakarta.annotation.Nullable final String value) {
      put("destination.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams destinationNotEquals(@jakarta.annotation.Nullable final String value) {
      put("destination.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams destinationSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("destination.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams destinationIn(@jakarta.annotation.Nullable final List<String> value) {
      put("destination.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllRoutesQueryParams destinationNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("destination.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllRoutesQueryParams distanceGreaterThan(@jakarta.annotation.Nullable final Double value) {
      put("distance.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams distanceLessThan(@jakarta.annotation.Nullable final Double value) {
      put("distance.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams distanceGreaterThanOrEqual(@jakarta.annotation.Nullable final Double value) {
      put("distance.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams distanceLessThanOrEqual(@jakarta.annotation.Nullable final Double value) {
      put("distance.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams distanceEquals(@jakarta.annotation.Nullable final Double value) {
      put("distance.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams distanceNotEquals(@jakarta.annotation.Nullable final Double value) {
      put("distance.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams distanceSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("distance.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams distanceIn(@jakarta.annotation.Nullable final List<Double> value) {
      put("distance.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllRoutesQueryParams distanceNotIn(@jakarta.annotation.Nullable final List<Double> value) {
      put("distance.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllRoutesQueryParams estimatedDurationGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("estimatedDuration.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams estimatedDurationLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("estimatedDuration.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams estimatedDurationGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("estimatedDuration.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams estimatedDurationLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("estimatedDuration.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams estimatedDurationEquals(@jakarta.annotation.Nullable final Integer value) {
      put("estimatedDuration.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams estimatedDurationNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("estimatedDuration.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams estimatedDurationSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("estimatedDuration.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams estimatedDurationIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("estimatedDuration.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllRoutesQueryParams estimatedDurationNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("estimatedDuration.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllRoutesQueryParams transportTypeEquals(@jakarta.annotation.Nullable final String value) {
      put("transportType.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams transportTypeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("transportType.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams transportTypeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("transportType.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams transportTypeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("transportType.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllRoutesQueryParams transportTypeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("transportType.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllRoutesQueryParams isActiveEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isActive.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams isActiveNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isActive.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams isActiveSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isActive.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams isActiveIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isActive.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllRoutesQueryParams isActiveNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isActive.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllRoutesQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllRoutesQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllRoutesQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllRoutesQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllRoutesQueryParams routeNameIdEquals(@jakarta.annotation.Nullable final UUID value) {
      put("routeNameId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams routeNameIdNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("routeNameId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams routeNameIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("routeNameId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams routeNameIdIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("routeNameId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllRoutesQueryParams routeNameIdNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("routeNameId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllRoutesQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams page(@jakarta.annotation.Nullable final Integer value) {
      put("page", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams size(@jakarta.annotation.Nullable final Integer value) {
      put("size", EncodingUtils.encode(value));
      return this;
    }
    public GetAllRoutesQueryParams sort(@jakarta.annotation.Nullable final List<String> value) {
      put("sort", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @return RouteDTO
   */
  @RequestLine("GET /api/routes/{id}")
  @Headers({
    "Accept: */*",
  })
  RouteDTO getRoute(@Param("id") @jakarta.annotation.Nonnull UUID id);

  /**
   * 
   * Similar to <code>getRoute</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/routes/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<RouteDTO> getRouteWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull UUID id);



  /**
   * 
   * 
   * @param id  (required)
   * @param routeDTO  (required)
   * @return RouteDTO
   */
  @RequestLine("PATCH /api/routes/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  RouteDTO partialUpdateRoute(@Param("id") @jakarta.annotation.Nonnull UUID id, @jakarta.annotation.Nonnull RouteDTO routeDTO);

  /**
   * 
   * Similar to <code>partialUpdateRoute</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param routeDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /api/routes/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<RouteDTO> partialUpdateRouteWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull UUID id, @jakarta.annotation.Nonnull RouteDTO routeDTO);



  /**
   * 
   * 
   * @param query  (required)
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return List&lt;RouteDTO&gt;
   */
  @RequestLine("GET /api/routes/_search?query={query}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",
  })
  List<RouteDTO> searchRoutes(@Param("query") @jakarta.annotation.Nonnull String query, @Param("page") @jakarta.annotation.Nullable Integer page, @Param("size") @jakarta.annotation.Nullable Integer size, @Param("sort") @jakarta.annotation.Nullable List<String> sort);

  /**
   * 
   * Similar to <code>searchRoutes</code> but it also returns the http response headers .
   * 
   * @param query  (required)
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/routes/_search?query={query}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<RouteDTO>> searchRoutesWithHttpInfo(@Param("query") @jakarta.annotation.Nonnull String query, @Param("page") @jakarta.annotation.Nullable Integer page, @Param("size") @jakarta.annotation.Nullable Integer size, @Param("sort") @jakarta.annotation.Nullable List<String> sort);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>searchRoutes</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link SearchRoutesQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>query -  (required)</li>
   *   <li>page - Zero-based page index (0..N) (optional, default to 0)</li>
   *   <li>size - The size of the page to be returned (optional, default to 20)</li>
   *   <li>sort - Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)</li>
   *   </ul>
   * @return List&lt;RouteDTO&gt;
   */
  @RequestLine("GET /api/routes/_search?query={query}&page={page}&size={size}&sort={sort}")
  @Headers({
  "Accept: */*",
  })
  List<RouteDTO> searchRoutes(@QueryMap(encoded=true) SearchRoutesQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>searchRoutes</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>query -  (required)</li>
          *   <li>page - Zero-based page index (0..N) (optional, default to 0)</li>
          *   <li>size - The size of the page to be returned (optional, default to 20)</li>
          *   <li>sort - Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)</li>
      *   </ul>
          * @return List&lt;RouteDTO&gt;
      */
      @RequestLine("GET /api/routes/_search?query={query}&page={page}&size={size}&sort={sort}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<RouteDTO>> searchRoutesWithHttpInfo(@QueryMap(encoded=true) SearchRoutesQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>searchRoutes</code> method in a fluent style.
   */
  public static class SearchRoutesQueryParams extends HashMap<String, Object> {
    public SearchRoutesQueryParams query(@jakarta.annotation.Nonnull final String value) {
      put("query", EncodingUtils.encode(value));
      return this;
    }
    public SearchRoutesQueryParams page(@jakarta.annotation.Nullable final Integer value) {
      put("page", EncodingUtils.encode(value));
      return this;
    }
    public SearchRoutesQueryParams size(@jakarta.annotation.Nullable final Integer value) {
      put("size", EncodingUtils.encode(value));
      return this;
    }
    public SearchRoutesQueryParams sort(@jakarta.annotation.Nullable final List<String> value) {
      put("sort", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @param routeDTO  (required)
   * @return RouteDTO
   */
  @RequestLine("PUT /api/routes/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  RouteDTO updateRoute(@Param("id") @jakarta.annotation.Nonnull UUID id, @jakarta.annotation.Nonnull RouteDTO routeDTO);

  /**
   * 
   * Similar to <code>updateRoute</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param routeDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/routes/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<RouteDTO> updateRouteWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull UUID id, @jakarta.annotation.Nonnull RouteDTO routeDTO);


}
