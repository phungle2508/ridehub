package com.ridehub.msroute.client.api;

import com.ridehub.msroute.client.invoker.ApiClient;
import com.ridehub.msroute.client.invoker.EncodingUtils;
import com.ridehub.msroute.client.model.ApiResponse;

import com.ridehub.msroute.client.model.AddressDTO;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface AddressResourceMsrouteApi extends ApiClient.Api {


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
   * @param streetAddressContains  (optional)
   * @param streetAddressDoesNotContain  (optional)
   * @param streetAddressEquals  (optional)
   * @param streetAddressNotEquals  (optional)
   * @param streetAddressSpecified  (optional)
   * @param streetAddressIn  (optional)
   * @param streetAddressNotIn  (optional)
   * @param latitudeGreaterThan  (optional)
   * @param latitudeLessThan  (optional)
   * @param latitudeGreaterThanOrEqual  (optional)
   * @param latitudeLessThanOrEqual  (optional)
   * @param latitudeEquals  (optional)
   * @param latitudeNotEquals  (optional)
   * @param latitudeSpecified  (optional)
   * @param latitudeIn  (optional)
   * @param latitudeNotIn  (optional)
   * @param longitudeGreaterThan  (optional)
   * @param longitudeLessThan  (optional)
   * @param longitudeGreaterThanOrEqual  (optional)
   * @param longitudeLessThanOrEqual  (optional)
   * @param longitudeEquals  (optional)
   * @param longitudeNotEquals  (optional)
   * @param longitudeSpecified  (optional)
   * @param longitudeIn  (optional)
   * @param longitudeNotIn  (optional)
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
   * @param stationIdGreaterThan  (optional)
   * @param stationIdLessThan  (optional)
   * @param stationIdGreaterThanOrEqual  (optional)
   * @param stationIdLessThanOrEqual  (optional)
   * @param stationIdEquals  (optional)
   * @param stationIdNotEquals  (optional)
   * @param stationIdSpecified  (optional)
   * @param stationIdIn  (optional)
   * @param stationIdNotIn  (optional)
   * @param wardIdGreaterThan  (optional)
   * @param wardIdLessThan  (optional)
   * @param wardIdGreaterThanOrEqual  (optional)
   * @param wardIdLessThanOrEqual  (optional)
   * @param wardIdEquals  (optional)
   * @param wardIdNotEquals  (optional)
   * @param wardIdSpecified  (optional)
   * @param wardIdIn  (optional)
   * @param wardIdNotIn  (optional)
   * @param distinct  (optional)
   * @return Long
   */
  @RequestLine("GET /api/addresses/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&streetAddress.contains={streetAddressContains}&streetAddress.doesNotContain={streetAddressDoesNotContain}&streetAddress.equals={streetAddressEquals}&streetAddress.notEquals={streetAddressNotEquals}&streetAddress.specified={streetAddressSpecified}&streetAddress.in={streetAddressIn}&streetAddress.notIn={streetAddressNotIn}&latitude.greaterThan={latitudeGreaterThan}&latitude.lessThan={latitudeLessThan}&latitude.greaterThanOrEqual={latitudeGreaterThanOrEqual}&latitude.lessThanOrEqual={latitudeLessThanOrEqual}&latitude.equals={latitudeEquals}&latitude.notEquals={latitudeNotEquals}&latitude.specified={latitudeSpecified}&latitude.in={latitudeIn}&latitude.notIn={latitudeNotIn}&longitude.greaterThan={longitudeGreaterThan}&longitude.lessThan={longitudeLessThan}&longitude.greaterThanOrEqual={longitudeGreaterThanOrEqual}&longitude.lessThanOrEqual={longitudeLessThanOrEqual}&longitude.equals={longitudeEquals}&longitude.notEquals={longitudeNotEquals}&longitude.specified={longitudeSpecified}&longitude.in={longitudeIn}&longitude.notIn={longitudeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&stationId.greaterThan={stationIdGreaterThan}&stationId.lessThan={stationIdLessThan}&stationId.greaterThanOrEqual={stationIdGreaterThanOrEqual}&stationId.lessThanOrEqual={stationIdLessThanOrEqual}&stationId.equals={stationIdEquals}&stationId.notEquals={stationIdNotEquals}&stationId.specified={stationIdSpecified}&stationId.in={stationIdIn}&stationId.notIn={stationIdNotIn}&wardId.greaterThan={wardIdGreaterThan}&wardId.lessThan={wardIdLessThan}&wardId.greaterThanOrEqual={wardIdGreaterThanOrEqual}&wardId.lessThanOrEqual={wardIdLessThanOrEqual}&wardId.equals={wardIdEquals}&wardId.notEquals={wardIdNotEquals}&wardId.specified={wardIdSpecified}&wardId.in={wardIdIn}&wardId.notIn={wardIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  Long countAddresses(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("streetAddressContains") @jakarta.annotation.Nullable String streetAddressContains, @Param("streetAddressDoesNotContain") @jakarta.annotation.Nullable String streetAddressDoesNotContain, @Param("streetAddressEquals") @jakarta.annotation.Nullable String streetAddressEquals, @Param("streetAddressNotEquals") @jakarta.annotation.Nullable String streetAddressNotEquals, @Param("streetAddressSpecified") @jakarta.annotation.Nullable Boolean streetAddressSpecified, @Param("streetAddressIn") @jakarta.annotation.Nullable List<String> streetAddressIn, @Param("streetAddressNotIn") @jakarta.annotation.Nullable List<String> streetAddressNotIn, @Param("latitudeGreaterThan") @jakarta.annotation.Nullable BigDecimal latitudeGreaterThan, @Param("latitudeLessThan") @jakarta.annotation.Nullable BigDecimal latitudeLessThan, @Param("latitudeGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal latitudeGreaterThanOrEqual, @Param("latitudeLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal latitudeLessThanOrEqual, @Param("latitudeEquals") @jakarta.annotation.Nullable BigDecimal latitudeEquals, @Param("latitudeNotEquals") @jakarta.annotation.Nullable BigDecimal latitudeNotEquals, @Param("latitudeSpecified") @jakarta.annotation.Nullable Boolean latitudeSpecified, @Param("latitudeIn") @jakarta.annotation.Nullable List<BigDecimal> latitudeIn, @Param("latitudeNotIn") @jakarta.annotation.Nullable List<BigDecimal> latitudeNotIn, @Param("longitudeGreaterThan") @jakarta.annotation.Nullable BigDecimal longitudeGreaterThan, @Param("longitudeLessThan") @jakarta.annotation.Nullable BigDecimal longitudeLessThan, @Param("longitudeGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal longitudeGreaterThanOrEqual, @Param("longitudeLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal longitudeLessThanOrEqual, @Param("longitudeEquals") @jakarta.annotation.Nullable BigDecimal longitudeEquals, @Param("longitudeNotEquals") @jakarta.annotation.Nullable BigDecimal longitudeNotEquals, @Param("longitudeSpecified") @jakarta.annotation.Nullable Boolean longitudeSpecified, @Param("longitudeIn") @jakarta.annotation.Nullable List<BigDecimal> longitudeIn, @Param("longitudeNotIn") @jakarta.annotation.Nullable List<BigDecimal> longitudeNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("stationIdGreaterThan") @jakarta.annotation.Nullable Long stationIdGreaterThan, @Param("stationIdLessThan") @jakarta.annotation.Nullable Long stationIdLessThan, @Param("stationIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long stationIdGreaterThanOrEqual, @Param("stationIdLessThanOrEqual") @jakarta.annotation.Nullable Long stationIdLessThanOrEqual, @Param("stationIdEquals") @jakarta.annotation.Nullable Long stationIdEquals, @Param("stationIdNotEquals") @jakarta.annotation.Nullable Long stationIdNotEquals, @Param("stationIdSpecified") @jakarta.annotation.Nullable Boolean stationIdSpecified, @Param("stationIdIn") @jakarta.annotation.Nullable List<Long> stationIdIn, @Param("stationIdNotIn") @jakarta.annotation.Nullable List<Long> stationIdNotIn, @Param("wardIdGreaterThan") @jakarta.annotation.Nullable Long wardIdGreaterThan, @Param("wardIdLessThan") @jakarta.annotation.Nullable Long wardIdLessThan, @Param("wardIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long wardIdGreaterThanOrEqual, @Param("wardIdLessThanOrEqual") @jakarta.annotation.Nullable Long wardIdLessThanOrEqual, @Param("wardIdEquals") @jakarta.annotation.Nullable Long wardIdEquals, @Param("wardIdNotEquals") @jakarta.annotation.Nullable Long wardIdNotEquals, @Param("wardIdSpecified") @jakarta.annotation.Nullable Boolean wardIdSpecified, @Param("wardIdIn") @jakarta.annotation.Nullable List<Long> wardIdIn, @Param("wardIdNotIn") @jakarta.annotation.Nullable List<Long> wardIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>countAddresses</code> but it also returns the http response headers .
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
   * @param streetAddressContains  (optional)
   * @param streetAddressDoesNotContain  (optional)
   * @param streetAddressEquals  (optional)
   * @param streetAddressNotEquals  (optional)
   * @param streetAddressSpecified  (optional)
   * @param streetAddressIn  (optional)
   * @param streetAddressNotIn  (optional)
   * @param latitudeGreaterThan  (optional)
   * @param latitudeLessThan  (optional)
   * @param latitudeGreaterThanOrEqual  (optional)
   * @param latitudeLessThanOrEqual  (optional)
   * @param latitudeEquals  (optional)
   * @param latitudeNotEquals  (optional)
   * @param latitudeSpecified  (optional)
   * @param latitudeIn  (optional)
   * @param latitudeNotIn  (optional)
   * @param longitudeGreaterThan  (optional)
   * @param longitudeLessThan  (optional)
   * @param longitudeGreaterThanOrEqual  (optional)
   * @param longitudeLessThanOrEqual  (optional)
   * @param longitudeEquals  (optional)
   * @param longitudeNotEquals  (optional)
   * @param longitudeSpecified  (optional)
   * @param longitudeIn  (optional)
   * @param longitudeNotIn  (optional)
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
   * @param stationIdGreaterThan  (optional)
   * @param stationIdLessThan  (optional)
   * @param stationIdGreaterThanOrEqual  (optional)
   * @param stationIdLessThanOrEqual  (optional)
   * @param stationIdEquals  (optional)
   * @param stationIdNotEquals  (optional)
   * @param stationIdSpecified  (optional)
   * @param stationIdIn  (optional)
   * @param stationIdNotIn  (optional)
   * @param wardIdGreaterThan  (optional)
   * @param wardIdLessThan  (optional)
   * @param wardIdGreaterThanOrEqual  (optional)
   * @param wardIdLessThanOrEqual  (optional)
   * @param wardIdEquals  (optional)
   * @param wardIdNotEquals  (optional)
   * @param wardIdSpecified  (optional)
   * @param wardIdIn  (optional)
   * @param wardIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/addresses/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&streetAddress.contains={streetAddressContains}&streetAddress.doesNotContain={streetAddressDoesNotContain}&streetAddress.equals={streetAddressEquals}&streetAddress.notEquals={streetAddressNotEquals}&streetAddress.specified={streetAddressSpecified}&streetAddress.in={streetAddressIn}&streetAddress.notIn={streetAddressNotIn}&latitude.greaterThan={latitudeGreaterThan}&latitude.lessThan={latitudeLessThan}&latitude.greaterThanOrEqual={latitudeGreaterThanOrEqual}&latitude.lessThanOrEqual={latitudeLessThanOrEqual}&latitude.equals={latitudeEquals}&latitude.notEquals={latitudeNotEquals}&latitude.specified={latitudeSpecified}&latitude.in={latitudeIn}&latitude.notIn={latitudeNotIn}&longitude.greaterThan={longitudeGreaterThan}&longitude.lessThan={longitudeLessThan}&longitude.greaterThanOrEqual={longitudeGreaterThanOrEqual}&longitude.lessThanOrEqual={longitudeLessThanOrEqual}&longitude.equals={longitudeEquals}&longitude.notEquals={longitudeNotEquals}&longitude.specified={longitudeSpecified}&longitude.in={longitudeIn}&longitude.notIn={longitudeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&stationId.greaterThan={stationIdGreaterThan}&stationId.lessThan={stationIdLessThan}&stationId.greaterThanOrEqual={stationIdGreaterThanOrEqual}&stationId.lessThanOrEqual={stationIdLessThanOrEqual}&stationId.equals={stationIdEquals}&stationId.notEquals={stationIdNotEquals}&stationId.specified={stationIdSpecified}&stationId.in={stationIdIn}&stationId.notIn={stationIdNotIn}&wardId.greaterThan={wardIdGreaterThan}&wardId.lessThan={wardIdLessThan}&wardId.greaterThanOrEqual={wardIdGreaterThanOrEqual}&wardId.lessThanOrEqual={wardIdLessThanOrEqual}&wardId.equals={wardIdEquals}&wardId.notEquals={wardIdNotEquals}&wardId.specified={wardIdSpecified}&wardId.in={wardIdIn}&wardId.notIn={wardIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Long> countAddressesWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("streetAddressContains") @jakarta.annotation.Nullable String streetAddressContains, @Param("streetAddressDoesNotContain") @jakarta.annotation.Nullable String streetAddressDoesNotContain, @Param("streetAddressEquals") @jakarta.annotation.Nullable String streetAddressEquals, @Param("streetAddressNotEquals") @jakarta.annotation.Nullable String streetAddressNotEquals, @Param("streetAddressSpecified") @jakarta.annotation.Nullable Boolean streetAddressSpecified, @Param("streetAddressIn") @jakarta.annotation.Nullable List<String> streetAddressIn, @Param("streetAddressNotIn") @jakarta.annotation.Nullable List<String> streetAddressNotIn, @Param("latitudeGreaterThan") @jakarta.annotation.Nullable BigDecimal latitudeGreaterThan, @Param("latitudeLessThan") @jakarta.annotation.Nullable BigDecimal latitudeLessThan, @Param("latitudeGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal latitudeGreaterThanOrEqual, @Param("latitudeLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal latitudeLessThanOrEqual, @Param("latitudeEquals") @jakarta.annotation.Nullable BigDecimal latitudeEquals, @Param("latitudeNotEquals") @jakarta.annotation.Nullable BigDecimal latitudeNotEquals, @Param("latitudeSpecified") @jakarta.annotation.Nullable Boolean latitudeSpecified, @Param("latitudeIn") @jakarta.annotation.Nullable List<BigDecimal> latitudeIn, @Param("latitudeNotIn") @jakarta.annotation.Nullable List<BigDecimal> latitudeNotIn, @Param("longitudeGreaterThan") @jakarta.annotation.Nullable BigDecimal longitudeGreaterThan, @Param("longitudeLessThan") @jakarta.annotation.Nullable BigDecimal longitudeLessThan, @Param("longitudeGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal longitudeGreaterThanOrEqual, @Param("longitudeLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal longitudeLessThanOrEqual, @Param("longitudeEquals") @jakarta.annotation.Nullable BigDecimal longitudeEquals, @Param("longitudeNotEquals") @jakarta.annotation.Nullable BigDecimal longitudeNotEquals, @Param("longitudeSpecified") @jakarta.annotation.Nullable Boolean longitudeSpecified, @Param("longitudeIn") @jakarta.annotation.Nullable List<BigDecimal> longitudeIn, @Param("longitudeNotIn") @jakarta.annotation.Nullable List<BigDecimal> longitudeNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("stationIdGreaterThan") @jakarta.annotation.Nullable Long stationIdGreaterThan, @Param("stationIdLessThan") @jakarta.annotation.Nullable Long stationIdLessThan, @Param("stationIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long stationIdGreaterThanOrEqual, @Param("stationIdLessThanOrEqual") @jakarta.annotation.Nullable Long stationIdLessThanOrEqual, @Param("stationIdEquals") @jakarta.annotation.Nullable Long stationIdEquals, @Param("stationIdNotEquals") @jakarta.annotation.Nullable Long stationIdNotEquals, @Param("stationIdSpecified") @jakarta.annotation.Nullable Boolean stationIdSpecified, @Param("stationIdIn") @jakarta.annotation.Nullable List<Long> stationIdIn, @Param("stationIdNotIn") @jakarta.annotation.Nullable List<Long> stationIdNotIn, @Param("wardIdGreaterThan") @jakarta.annotation.Nullable Long wardIdGreaterThan, @Param("wardIdLessThan") @jakarta.annotation.Nullable Long wardIdLessThan, @Param("wardIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long wardIdGreaterThanOrEqual, @Param("wardIdLessThanOrEqual") @jakarta.annotation.Nullable Long wardIdLessThanOrEqual, @Param("wardIdEquals") @jakarta.annotation.Nullable Long wardIdEquals, @Param("wardIdNotEquals") @jakarta.annotation.Nullable Long wardIdNotEquals, @Param("wardIdSpecified") @jakarta.annotation.Nullable Boolean wardIdSpecified, @Param("wardIdIn") @jakarta.annotation.Nullable List<Long> wardIdIn, @Param("wardIdNotIn") @jakarta.annotation.Nullable List<Long> wardIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>countAddresses</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CountAddressesQueryParams} class that allows for
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
   *   <li>streetAddressContains -  (optional)</li>
   *   <li>streetAddressDoesNotContain -  (optional)</li>
   *   <li>streetAddressEquals -  (optional)</li>
   *   <li>streetAddressNotEquals -  (optional)</li>
   *   <li>streetAddressSpecified -  (optional)</li>
   *   <li>streetAddressIn -  (optional)</li>
   *   <li>streetAddressNotIn -  (optional)</li>
   *   <li>latitudeGreaterThan -  (optional)</li>
   *   <li>latitudeLessThan -  (optional)</li>
   *   <li>latitudeGreaterThanOrEqual -  (optional)</li>
   *   <li>latitudeLessThanOrEqual -  (optional)</li>
   *   <li>latitudeEquals -  (optional)</li>
   *   <li>latitudeNotEquals -  (optional)</li>
   *   <li>latitudeSpecified -  (optional)</li>
   *   <li>latitudeIn -  (optional)</li>
   *   <li>latitudeNotIn -  (optional)</li>
   *   <li>longitudeGreaterThan -  (optional)</li>
   *   <li>longitudeLessThan -  (optional)</li>
   *   <li>longitudeGreaterThanOrEqual -  (optional)</li>
   *   <li>longitudeLessThanOrEqual -  (optional)</li>
   *   <li>longitudeEquals -  (optional)</li>
   *   <li>longitudeNotEquals -  (optional)</li>
   *   <li>longitudeSpecified -  (optional)</li>
   *   <li>longitudeIn -  (optional)</li>
   *   <li>longitudeNotIn -  (optional)</li>
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
   *   <li>stationIdGreaterThan -  (optional)</li>
   *   <li>stationIdLessThan -  (optional)</li>
   *   <li>stationIdGreaterThanOrEqual -  (optional)</li>
   *   <li>stationIdLessThanOrEqual -  (optional)</li>
   *   <li>stationIdEquals -  (optional)</li>
   *   <li>stationIdNotEquals -  (optional)</li>
   *   <li>stationIdSpecified -  (optional)</li>
   *   <li>stationIdIn -  (optional)</li>
   *   <li>stationIdNotIn -  (optional)</li>
   *   <li>wardIdGreaterThan -  (optional)</li>
   *   <li>wardIdLessThan -  (optional)</li>
   *   <li>wardIdGreaterThanOrEqual -  (optional)</li>
   *   <li>wardIdLessThanOrEqual -  (optional)</li>
   *   <li>wardIdEquals -  (optional)</li>
   *   <li>wardIdNotEquals -  (optional)</li>
   *   <li>wardIdSpecified -  (optional)</li>
   *   <li>wardIdIn -  (optional)</li>
   *   <li>wardIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return Long
   */
  @RequestLine("GET /api/addresses/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&streetAddress.contains={streetAddressContains}&streetAddress.doesNotContain={streetAddressDoesNotContain}&streetAddress.equals={streetAddressEquals}&streetAddress.notEquals={streetAddressNotEquals}&streetAddress.specified={streetAddressSpecified}&streetAddress.in={streetAddressIn}&streetAddress.notIn={streetAddressNotIn}&latitude.greaterThan={latitudeGreaterThan}&latitude.lessThan={latitudeLessThan}&latitude.greaterThanOrEqual={latitudeGreaterThanOrEqual}&latitude.lessThanOrEqual={latitudeLessThanOrEqual}&latitude.equals={latitudeEquals}&latitude.notEquals={latitudeNotEquals}&latitude.specified={latitudeSpecified}&latitude.in={latitudeIn}&latitude.notIn={latitudeNotIn}&longitude.greaterThan={longitudeGreaterThan}&longitude.lessThan={longitudeLessThan}&longitude.greaterThanOrEqual={longitudeGreaterThanOrEqual}&longitude.lessThanOrEqual={longitudeLessThanOrEqual}&longitude.equals={longitudeEquals}&longitude.notEquals={longitudeNotEquals}&longitude.specified={longitudeSpecified}&longitude.in={longitudeIn}&longitude.notIn={longitudeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&stationId.greaterThan={stationIdGreaterThan}&stationId.lessThan={stationIdLessThan}&stationId.greaterThanOrEqual={stationIdGreaterThanOrEqual}&stationId.lessThanOrEqual={stationIdLessThanOrEqual}&stationId.equals={stationIdEquals}&stationId.notEquals={stationIdNotEquals}&stationId.specified={stationIdSpecified}&stationId.in={stationIdIn}&stationId.notIn={stationIdNotIn}&wardId.greaterThan={wardIdGreaterThan}&wardId.lessThan={wardIdLessThan}&wardId.greaterThanOrEqual={wardIdGreaterThanOrEqual}&wardId.lessThanOrEqual={wardIdLessThanOrEqual}&wardId.equals={wardIdEquals}&wardId.notEquals={wardIdNotEquals}&wardId.specified={wardIdSpecified}&wardId.in={wardIdIn}&wardId.notIn={wardIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  Long countAddresses(@QueryMap(encoded=true) CountAddressesQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>countAddresses</code> that receives the query parameters as a map,
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
          *   <li>streetAddressContains -  (optional)</li>
          *   <li>streetAddressDoesNotContain -  (optional)</li>
          *   <li>streetAddressEquals -  (optional)</li>
          *   <li>streetAddressNotEquals -  (optional)</li>
          *   <li>streetAddressSpecified -  (optional)</li>
          *   <li>streetAddressIn -  (optional)</li>
          *   <li>streetAddressNotIn -  (optional)</li>
          *   <li>latitudeGreaterThan -  (optional)</li>
          *   <li>latitudeLessThan -  (optional)</li>
          *   <li>latitudeGreaterThanOrEqual -  (optional)</li>
          *   <li>latitudeLessThanOrEqual -  (optional)</li>
          *   <li>latitudeEquals -  (optional)</li>
          *   <li>latitudeNotEquals -  (optional)</li>
          *   <li>latitudeSpecified -  (optional)</li>
          *   <li>latitudeIn -  (optional)</li>
          *   <li>latitudeNotIn -  (optional)</li>
          *   <li>longitudeGreaterThan -  (optional)</li>
          *   <li>longitudeLessThan -  (optional)</li>
          *   <li>longitudeGreaterThanOrEqual -  (optional)</li>
          *   <li>longitudeLessThanOrEqual -  (optional)</li>
          *   <li>longitudeEquals -  (optional)</li>
          *   <li>longitudeNotEquals -  (optional)</li>
          *   <li>longitudeSpecified -  (optional)</li>
          *   <li>longitudeIn -  (optional)</li>
          *   <li>longitudeNotIn -  (optional)</li>
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
          *   <li>stationIdGreaterThan -  (optional)</li>
          *   <li>stationIdLessThan -  (optional)</li>
          *   <li>stationIdGreaterThanOrEqual -  (optional)</li>
          *   <li>stationIdLessThanOrEqual -  (optional)</li>
          *   <li>stationIdEquals -  (optional)</li>
          *   <li>stationIdNotEquals -  (optional)</li>
          *   <li>stationIdSpecified -  (optional)</li>
          *   <li>stationIdIn -  (optional)</li>
          *   <li>stationIdNotIn -  (optional)</li>
          *   <li>wardIdGreaterThan -  (optional)</li>
          *   <li>wardIdLessThan -  (optional)</li>
          *   <li>wardIdGreaterThanOrEqual -  (optional)</li>
          *   <li>wardIdLessThanOrEqual -  (optional)</li>
          *   <li>wardIdEquals -  (optional)</li>
          *   <li>wardIdNotEquals -  (optional)</li>
          *   <li>wardIdSpecified -  (optional)</li>
          *   <li>wardIdIn -  (optional)</li>
          *   <li>wardIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return Long
      */
      @RequestLine("GET /api/addresses/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&streetAddress.contains={streetAddressContains}&streetAddress.doesNotContain={streetAddressDoesNotContain}&streetAddress.equals={streetAddressEquals}&streetAddress.notEquals={streetAddressNotEquals}&streetAddress.specified={streetAddressSpecified}&streetAddress.in={streetAddressIn}&streetAddress.notIn={streetAddressNotIn}&latitude.greaterThan={latitudeGreaterThan}&latitude.lessThan={latitudeLessThan}&latitude.greaterThanOrEqual={latitudeGreaterThanOrEqual}&latitude.lessThanOrEqual={latitudeLessThanOrEqual}&latitude.equals={latitudeEquals}&latitude.notEquals={latitudeNotEquals}&latitude.specified={latitudeSpecified}&latitude.in={latitudeIn}&latitude.notIn={latitudeNotIn}&longitude.greaterThan={longitudeGreaterThan}&longitude.lessThan={longitudeLessThan}&longitude.greaterThanOrEqual={longitudeGreaterThanOrEqual}&longitude.lessThanOrEqual={longitudeLessThanOrEqual}&longitude.equals={longitudeEquals}&longitude.notEquals={longitudeNotEquals}&longitude.specified={longitudeSpecified}&longitude.in={longitudeIn}&longitude.notIn={longitudeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&stationId.greaterThan={stationIdGreaterThan}&stationId.lessThan={stationIdLessThan}&stationId.greaterThanOrEqual={stationIdGreaterThanOrEqual}&stationId.lessThanOrEqual={stationIdLessThanOrEqual}&stationId.equals={stationIdEquals}&stationId.notEquals={stationIdNotEquals}&stationId.specified={stationIdSpecified}&stationId.in={stationIdIn}&stationId.notIn={stationIdNotIn}&wardId.greaterThan={wardIdGreaterThan}&wardId.lessThan={wardIdLessThan}&wardId.greaterThanOrEqual={wardIdGreaterThanOrEqual}&wardId.lessThanOrEqual={wardIdLessThanOrEqual}&wardId.equals={wardIdEquals}&wardId.notEquals={wardIdNotEquals}&wardId.specified={wardIdSpecified}&wardId.in={wardIdIn}&wardId.notIn={wardIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Long> countAddressesWithHttpInfo(@QueryMap(encoded=true) CountAddressesQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>countAddresses</code> method in a fluent style.
   */
  public static class CountAddressesQueryParams extends HashMap<String, Object> {
    public CountAddressesQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAddressesQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAddressesQueryParams streetAddressContains(@jakarta.annotation.Nullable final String value) {
      put("streetAddress.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams streetAddressDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("streetAddress.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams streetAddressEquals(@jakarta.annotation.Nullable final String value) {
      put("streetAddress.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams streetAddressNotEquals(@jakarta.annotation.Nullable final String value) {
      put("streetAddress.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams streetAddressSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("streetAddress.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams streetAddressIn(@jakarta.annotation.Nullable final List<String> value) {
      put("streetAddress.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAddressesQueryParams streetAddressNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("streetAddress.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAddressesQueryParams latitudeGreaterThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("latitude.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams latitudeLessThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("latitude.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams latitudeGreaterThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("latitude.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams latitudeLessThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("latitude.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams latitudeEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("latitude.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams latitudeNotEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("latitude.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams latitudeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("latitude.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams latitudeIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("latitude.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAddressesQueryParams latitudeNotIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("latitude.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAddressesQueryParams longitudeGreaterThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("longitude.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams longitudeLessThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("longitude.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams longitudeGreaterThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("longitude.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams longitudeLessThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("longitude.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams longitudeEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("longitude.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams longitudeNotEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("longitude.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams longitudeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("longitude.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams longitudeIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("longitude.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAddressesQueryParams longitudeNotIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("longitude.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAddressesQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAddressesQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAddressesQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAddressesQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAddressesQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAddressesQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAddressesQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAddressesQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAddressesQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAddressesQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAddressesQueryParams stationIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("stationId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams stationIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("stationId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams stationIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("stationId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams stationIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("stationId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams stationIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("stationId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams stationIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("stationId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams stationIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("stationId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams stationIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("stationId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAddressesQueryParams stationIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("stationId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAddressesQueryParams wardIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("wardId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams wardIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("wardId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams wardIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("wardId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams wardIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("wardId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams wardIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("wardId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams wardIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("wardId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams wardIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("wardId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAddressesQueryParams wardIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("wardId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAddressesQueryParams wardIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("wardId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAddressesQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param addressDTO  (required)
   * @return AddressDTO
   */
  @RequestLine("POST /api/addresses")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  AddressDTO createAddress(@jakarta.annotation.Nonnull AddressDTO addressDTO);

  /**
   * 
   * Similar to <code>createAddress</code> but it also returns the http response headers .
   * 
   * @param addressDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/addresses")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<AddressDTO> createAddressWithHttpInfo(@jakarta.annotation.Nonnull AddressDTO addressDTO);



  /**
   * 
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/addresses/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteAddress(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>deleteAddress</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/addresses/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteAddressWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param id  (required)
   * @return AddressDTO
   */
  @RequestLine("GET /api/addresses/{id}")
  @Headers({
    "Accept: */*",
  })
  AddressDTO getAddress(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>getAddress</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/addresses/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<AddressDTO> getAddressWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



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
   * @param streetAddressContains  (optional)
   * @param streetAddressDoesNotContain  (optional)
   * @param streetAddressEquals  (optional)
   * @param streetAddressNotEquals  (optional)
   * @param streetAddressSpecified  (optional)
   * @param streetAddressIn  (optional)
   * @param streetAddressNotIn  (optional)
   * @param latitudeGreaterThan  (optional)
   * @param latitudeLessThan  (optional)
   * @param latitudeGreaterThanOrEqual  (optional)
   * @param latitudeLessThanOrEqual  (optional)
   * @param latitudeEquals  (optional)
   * @param latitudeNotEquals  (optional)
   * @param latitudeSpecified  (optional)
   * @param latitudeIn  (optional)
   * @param latitudeNotIn  (optional)
   * @param longitudeGreaterThan  (optional)
   * @param longitudeLessThan  (optional)
   * @param longitudeGreaterThanOrEqual  (optional)
   * @param longitudeLessThanOrEqual  (optional)
   * @param longitudeEquals  (optional)
   * @param longitudeNotEquals  (optional)
   * @param longitudeSpecified  (optional)
   * @param longitudeIn  (optional)
   * @param longitudeNotIn  (optional)
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
   * @param stationIdGreaterThan  (optional)
   * @param stationIdLessThan  (optional)
   * @param stationIdGreaterThanOrEqual  (optional)
   * @param stationIdLessThanOrEqual  (optional)
   * @param stationIdEquals  (optional)
   * @param stationIdNotEquals  (optional)
   * @param stationIdSpecified  (optional)
   * @param stationIdIn  (optional)
   * @param stationIdNotIn  (optional)
   * @param wardIdGreaterThan  (optional)
   * @param wardIdLessThan  (optional)
   * @param wardIdGreaterThanOrEqual  (optional)
   * @param wardIdLessThanOrEqual  (optional)
   * @param wardIdEquals  (optional)
   * @param wardIdNotEquals  (optional)
   * @param wardIdSpecified  (optional)
   * @param wardIdIn  (optional)
   * @param wardIdNotIn  (optional)
   * @param distinct  (optional)
   * @return List&lt;AddressDTO&gt;
   */
  @RequestLine("GET /api/addresses?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&streetAddress.contains={streetAddressContains}&streetAddress.doesNotContain={streetAddressDoesNotContain}&streetAddress.equals={streetAddressEquals}&streetAddress.notEquals={streetAddressNotEquals}&streetAddress.specified={streetAddressSpecified}&streetAddress.in={streetAddressIn}&streetAddress.notIn={streetAddressNotIn}&latitude.greaterThan={latitudeGreaterThan}&latitude.lessThan={latitudeLessThan}&latitude.greaterThanOrEqual={latitudeGreaterThanOrEqual}&latitude.lessThanOrEqual={latitudeLessThanOrEqual}&latitude.equals={latitudeEquals}&latitude.notEquals={latitudeNotEquals}&latitude.specified={latitudeSpecified}&latitude.in={latitudeIn}&latitude.notIn={latitudeNotIn}&longitude.greaterThan={longitudeGreaterThan}&longitude.lessThan={longitudeLessThan}&longitude.greaterThanOrEqual={longitudeGreaterThanOrEqual}&longitude.lessThanOrEqual={longitudeLessThanOrEqual}&longitude.equals={longitudeEquals}&longitude.notEquals={longitudeNotEquals}&longitude.specified={longitudeSpecified}&longitude.in={longitudeIn}&longitude.notIn={longitudeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&stationId.greaterThan={stationIdGreaterThan}&stationId.lessThan={stationIdLessThan}&stationId.greaterThanOrEqual={stationIdGreaterThanOrEqual}&stationId.lessThanOrEqual={stationIdLessThanOrEqual}&stationId.equals={stationIdEquals}&stationId.notEquals={stationIdNotEquals}&stationId.specified={stationIdSpecified}&stationId.in={stationIdIn}&stationId.notIn={stationIdNotIn}&wardId.greaterThan={wardIdGreaterThan}&wardId.lessThan={wardIdLessThan}&wardId.greaterThanOrEqual={wardIdGreaterThanOrEqual}&wardId.lessThanOrEqual={wardIdLessThanOrEqual}&wardId.equals={wardIdEquals}&wardId.notEquals={wardIdNotEquals}&wardId.specified={wardIdSpecified}&wardId.in={wardIdIn}&wardId.notIn={wardIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  List<AddressDTO> getAllAddresses(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("streetAddressContains") @jakarta.annotation.Nullable String streetAddressContains, @Param("streetAddressDoesNotContain") @jakarta.annotation.Nullable String streetAddressDoesNotContain, @Param("streetAddressEquals") @jakarta.annotation.Nullable String streetAddressEquals, @Param("streetAddressNotEquals") @jakarta.annotation.Nullable String streetAddressNotEquals, @Param("streetAddressSpecified") @jakarta.annotation.Nullable Boolean streetAddressSpecified, @Param("streetAddressIn") @jakarta.annotation.Nullable List<String> streetAddressIn, @Param("streetAddressNotIn") @jakarta.annotation.Nullable List<String> streetAddressNotIn, @Param("latitudeGreaterThan") @jakarta.annotation.Nullable BigDecimal latitudeGreaterThan, @Param("latitudeLessThan") @jakarta.annotation.Nullable BigDecimal latitudeLessThan, @Param("latitudeGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal latitudeGreaterThanOrEqual, @Param("latitudeLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal latitudeLessThanOrEqual, @Param("latitudeEquals") @jakarta.annotation.Nullable BigDecimal latitudeEquals, @Param("latitudeNotEquals") @jakarta.annotation.Nullable BigDecimal latitudeNotEquals, @Param("latitudeSpecified") @jakarta.annotation.Nullable Boolean latitudeSpecified, @Param("latitudeIn") @jakarta.annotation.Nullable List<BigDecimal> latitudeIn, @Param("latitudeNotIn") @jakarta.annotation.Nullable List<BigDecimal> latitudeNotIn, @Param("longitudeGreaterThan") @jakarta.annotation.Nullable BigDecimal longitudeGreaterThan, @Param("longitudeLessThan") @jakarta.annotation.Nullable BigDecimal longitudeLessThan, @Param("longitudeGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal longitudeGreaterThanOrEqual, @Param("longitudeLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal longitudeLessThanOrEqual, @Param("longitudeEquals") @jakarta.annotation.Nullable BigDecimal longitudeEquals, @Param("longitudeNotEquals") @jakarta.annotation.Nullable BigDecimal longitudeNotEquals, @Param("longitudeSpecified") @jakarta.annotation.Nullable Boolean longitudeSpecified, @Param("longitudeIn") @jakarta.annotation.Nullable List<BigDecimal> longitudeIn, @Param("longitudeNotIn") @jakarta.annotation.Nullable List<BigDecimal> longitudeNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("stationIdGreaterThan") @jakarta.annotation.Nullable Long stationIdGreaterThan, @Param("stationIdLessThan") @jakarta.annotation.Nullable Long stationIdLessThan, @Param("stationIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long stationIdGreaterThanOrEqual, @Param("stationIdLessThanOrEqual") @jakarta.annotation.Nullable Long stationIdLessThanOrEqual, @Param("stationIdEquals") @jakarta.annotation.Nullable Long stationIdEquals, @Param("stationIdNotEquals") @jakarta.annotation.Nullable Long stationIdNotEquals, @Param("stationIdSpecified") @jakarta.annotation.Nullable Boolean stationIdSpecified, @Param("stationIdIn") @jakarta.annotation.Nullable List<Long> stationIdIn, @Param("stationIdNotIn") @jakarta.annotation.Nullable List<Long> stationIdNotIn, @Param("wardIdGreaterThan") @jakarta.annotation.Nullable Long wardIdGreaterThan, @Param("wardIdLessThan") @jakarta.annotation.Nullable Long wardIdLessThan, @Param("wardIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long wardIdGreaterThanOrEqual, @Param("wardIdLessThanOrEqual") @jakarta.annotation.Nullable Long wardIdLessThanOrEqual, @Param("wardIdEquals") @jakarta.annotation.Nullable Long wardIdEquals, @Param("wardIdNotEquals") @jakarta.annotation.Nullable Long wardIdNotEquals, @Param("wardIdSpecified") @jakarta.annotation.Nullable Boolean wardIdSpecified, @Param("wardIdIn") @jakarta.annotation.Nullable List<Long> wardIdIn, @Param("wardIdNotIn") @jakarta.annotation.Nullable List<Long> wardIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>getAllAddresses</code> but it also returns the http response headers .
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
   * @param streetAddressContains  (optional)
   * @param streetAddressDoesNotContain  (optional)
   * @param streetAddressEquals  (optional)
   * @param streetAddressNotEquals  (optional)
   * @param streetAddressSpecified  (optional)
   * @param streetAddressIn  (optional)
   * @param streetAddressNotIn  (optional)
   * @param latitudeGreaterThan  (optional)
   * @param latitudeLessThan  (optional)
   * @param latitudeGreaterThanOrEqual  (optional)
   * @param latitudeLessThanOrEqual  (optional)
   * @param latitudeEquals  (optional)
   * @param latitudeNotEquals  (optional)
   * @param latitudeSpecified  (optional)
   * @param latitudeIn  (optional)
   * @param latitudeNotIn  (optional)
   * @param longitudeGreaterThan  (optional)
   * @param longitudeLessThan  (optional)
   * @param longitudeGreaterThanOrEqual  (optional)
   * @param longitudeLessThanOrEqual  (optional)
   * @param longitudeEquals  (optional)
   * @param longitudeNotEquals  (optional)
   * @param longitudeSpecified  (optional)
   * @param longitudeIn  (optional)
   * @param longitudeNotIn  (optional)
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
   * @param stationIdGreaterThan  (optional)
   * @param stationIdLessThan  (optional)
   * @param stationIdGreaterThanOrEqual  (optional)
   * @param stationIdLessThanOrEqual  (optional)
   * @param stationIdEquals  (optional)
   * @param stationIdNotEquals  (optional)
   * @param stationIdSpecified  (optional)
   * @param stationIdIn  (optional)
   * @param stationIdNotIn  (optional)
   * @param wardIdGreaterThan  (optional)
   * @param wardIdLessThan  (optional)
   * @param wardIdGreaterThanOrEqual  (optional)
   * @param wardIdLessThanOrEqual  (optional)
   * @param wardIdEquals  (optional)
   * @param wardIdNotEquals  (optional)
   * @param wardIdSpecified  (optional)
   * @param wardIdIn  (optional)
   * @param wardIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/addresses?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&streetAddress.contains={streetAddressContains}&streetAddress.doesNotContain={streetAddressDoesNotContain}&streetAddress.equals={streetAddressEquals}&streetAddress.notEquals={streetAddressNotEquals}&streetAddress.specified={streetAddressSpecified}&streetAddress.in={streetAddressIn}&streetAddress.notIn={streetAddressNotIn}&latitude.greaterThan={latitudeGreaterThan}&latitude.lessThan={latitudeLessThan}&latitude.greaterThanOrEqual={latitudeGreaterThanOrEqual}&latitude.lessThanOrEqual={latitudeLessThanOrEqual}&latitude.equals={latitudeEquals}&latitude.notEquals={latitudeNotEquals}&latitude.specified={latitudeSpecified}&latitude.in={latitudeIn}&latitude.notIn={latitudeNotIn}&longitude.greaterThan={longitudeGreaterThan}&longitude.lessThan={longitudeLessThan}&longitude.greaterThanOrEqual={longitudeGreaterThanOrEqual}&longitude.lessThanOrEqual={longitudeLessThanOrEqual}&longitude.equals={longitudeEquals}&longitude.notEquals={longitudeNotEquals}&longitude.specified={longitudeSpecified}&longitude.in={longitudeIn}&longitude.notIn={longitudeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&stationId.greaterThan={stationIdGreaterThan}&stationId.lessThan={stationIdLessThan}&stationId.greaterThanOrEqual={stationIdGreaterThanOrEqual}&stationId.lessThanOrEqual={stationIdLessThanOrEqual}&stationId.equals={stationIdEquals}&stationId.notEquals={stationIdNotEquals}&stationId.specified={stationIdSpecified}&stationId.in={stationIdIn}&stationId.notIn={stationIdNotIn}&wardId.greaterThan={wardIdGreaterThan}&wardId.lessThan={wardIdLessThan}&wardId.greaterThanOrEqual={wardIdGreaterThanOrEqual}&wardId.lessThanOrEqual={wardIdLessThanOrEqual}&wardId.equals={wardIdEquals}&wardId.notEquals={wardIdNotEquals}&wardId.specified={wardIdSpecified}&wardId.in={wardIdIn}&wardId.notIn={wardIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<AddressDTO>> getAllAddressesWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("streetAddressContains") @jakarta.annotation.Nullable String streetAddressContains, @Param("streetAddressDoesNotContain") @jakarta.annotation.Nullable String streetAddressDoesNotContain, @Param("streetAddressEquals") @jakarta.annotation.Nullable String streetAddressEquals, @Param("streetAddressNotEquals") @jakarta.annotation.Nullable String streetAddressNotEquals, @Param("streetAddressSpecified") @jakarta.annotation.Nullable Boolean streetAddressSpecified, @Param("streetAddressIn") @jakarta.annotation.Nullable List<String> streetAddressIn, @Param("streetAddressNotIn") @jakarta.annotation.Nullable List<String> streetAddressNotIn, @Param("latitudeGreaterThan") @jakarta.annotation.Nullable BigDecimal latitudeGreaterThan, @Param("latitudeLessThan") @jakarta.annotation.Nullable BigDecimal latitudeLessThan, @Param("latitudeGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal latitudeGreaterThanOrEqual, @Param("latitudeLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal latitudeLessThanOrEqual, @Param("latitudeEquals") @jakarta.annotation.Nullable BigDecimal latitudeEquals, @Param("latitudeNotEquals") @jakarta.annotation.Nullable BigDecimal latitudeNotEquals, @Param("latitudeSpecified") @jakarta.annotation.Nullable Boolean latitudeSpecified, @Param("latitudeIn") @jakarta.annotation.Nullable List<BigDecimal> latitudeIn, @Param("latitudeNotIn") @jakarta.annotation.Nullable List<BigDecimal> latitudeNotIn, @Param("longitudeGreaterThan") @jakarta.annotation.Nullable BigDecimal longitudeGreaterThan, @Param("longitudeLessThan") @jakarta.annotation.Nullable BigDecimal longitudeLessThan, @Param("longitudeGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal longitudeGreaterThanOrEqual, @Param("longitudeLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal longitudeLessThanOrEqual, @Param("longitudeEquals") @jakarta.annotation.Nullable BigDecimal longitudeEquals, @Param("longitudeNotEquals") @jakarta.annotation.Nullable BigDecimal longitudeNotEquals, @Param("longitudeSpecified") @jakarta.annotation.Nullable Boolean longitudeSpecified, @Param("longitudeIn") @jakarta.annotation.Nullable List<BigDecimal> longitudeIn, @Param("longitudeNotIn") @jakarta.annotation.Nullable List<BigDecimal> longitudeNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("stationIdGreaterThan") @jakarta.annotation.Nullable Long stationIdGreaterThan, @Param("stationIdLessThan") @jakarta.annotation.Nullable Long stationIdLessThan, @Param("stationIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long stationIdGreaterThanOrEqual, @Param("stationIdLessThanOrEqual") @jakarta.annotation.Nullable Long stationIdLessThanOrEqual, @Param("stationIdEquals") @jakarta.annotation.Nullable Long stationIdEquals, @Param("stationIdNotEquals") @jakarta.annotation.Nullable Long stationIdNotEquals, @Param("stationIdSpecified") @jakarta.annotation.Nullable Boolean stationIdSpecified, @Param("stationIdIn") @jakarta.annotation.Nullable List<Long> stationIdIn, @Param("stationIdNotIn") @jakarta.annotation.Nullable List<Long> stationIdNotIn, @Param("wardIdGreaterThan") @jakarta.annotation.Nullable Long wardIdGreaterThan, @Param("wardIdLessThan") @jakarta.annotation.Nullable Long wardIdLessThan, @Param("wardIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long wardIdGreaterThanOrEqual, @Param("wardIdLessThanOrEqual") @jakarta.annotation.Nullable Long wardIdLessThanOrEqual, @Param("wardIdEquals") @jakarta.annotation.Nullable Long wardIdEquals, @Param("wardIdNotEquals") @jakarta.annotation.Nullable Long wardIdNotEquals, @Param("wardIdSpecified") @jakarta.annotation.Nullable Boolean wardIdSpecified, @Param("wardIdIn") @jakarta.annotation.Nullable List<Long> wardIdIn, @Param("wardIdNotIn") @jakarta.annotation.Nullable List<Long> wardIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllAddresses</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllAddressesQueryParams} class that allows for
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
   *   <li>streetAddressContains -  (optional)</li>
   *   <li>streetAddressDoesNotContain -  (optional)</li>
   *   <li>streetAddressEquals -  (optional)</li>
   *   <li>streetAddressNotEquals -  (optional)</li>
   *   <li>streetAddressSpecified -  (optional)</li>
   *   <li>streetAddressIn -  (optional)</li>
   *   <li>streetAddressNotIn -  (optional)</li>
   *   <li>latitudeGreaterThan -  (optional)</li>
   *   <li>latitudeLessThan -  (optional)</li>
   *   <li>latitudeGreaterThanOrEqual -  (optional)</li>
   *   <li>latitudeLessThanOrEqual -  (optional)</li>
   *   <li>latitudeEquals -  (optional)</li>
   *   <li>latitudeNotEquals -  (optional)</li>
   *   <li>latitudeSpecified -  (optional)</li>
   *   <li>latitudeIn -  (optional)</li>
   *   <li>latitudeNotIn -  (optional)</li>
   *   <li>longitudeGreaterThan -  (optional)</li>
   *   <li>longitudeLessThan -  (optional)</li>
   *   <li>longitudeGreaterThanOrEqual -  (optional)</li>
   *   <li>longitudeLessThanOrEqual -  (optional)</li>
   *   <li>longitudeEquals -  (optional)</li>
   *   <li>longitudeNotEquals -  (optional)</li>
   *   <li>longitudeSpecified -  (optional)</li>
   *   <li>longitudeIn -  (optional)</li>
   *   <li>longitudeNotIn -  (optional)</li>
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
   *   <li>stationIdGreaterThan -  (optional)</li>
   *   <li>stationIdLessThan -  (optional)</li>
   *   <li>stationIdGreaterThanOrEqual -  (optional)</li>
   *   <li>stationIdLessThanOrEqual -  (optional)</li>
   *   <li>stationIdEquals -  (optional)</li>
   *   <li>stationIdNotEquals -  (optional)</li>
   *   <li>stationIdSpecified -  (optional)</li>
   *   <li>stationIdIn -  (optional)</li>
   *   <li>stationIdNotIn -  (optional)</li>
   *   <li>wardIdGreaterThan -  (optional)</li>
   *   <li>wardIdLessThan -  (optional)</li>
   *   <li>wardIdGreaterThanOrEqual -  (optional)</li>
   *   <li>wardIdLessThanOrEqual -  (optional)</li>
   *   <li>wardIdEquals -  (optional)</li>
   *   <li>wardIdNotEquals -  (optional)</li>
   *   <li>wardIdSpecified -  (optional)</li>
   *   <li>wardIdIn -  (optional)</li>
   *   <li>wardIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return List&lt;AddressDTO&gt;
   */
  @RequestLine("GET /api/addresses?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&streetAddress.contains={streetAddressContains}&streetAddress.doesNotContain={streetAddressDoesNotContain}&streetAddress.equals={streetAddressEquals}&streetAddress.notEquals={streetAddressNotEquals}&streetAddress.specified={streetAddressSpecified}&streetAddress.in={streetAddressIn}&streetAddress.notIn={streetAddressNotIn}&latitude.greaterThan={latitudeGreaterThan}&latitude.lessThan={latitudeLessThan}&latitude.greaterThanOrEqual={latitudeGreaterThanOrEqual}&latitude.lessThanOrEqual={latitudeLessThanOrEqual}&latitude.equals={latitudeEquals}&latitude.notEquals={latitudeNotEquals}&latitude.specified={latitudeSpecified}&latitude.in={latitudeIn}&latitude.notIn={latitudeNotIn}&longitude.greaterThan={longitudeGreaterThan}&longitude.lessThan={longitudeLessThan}&longitude.greaterThanOrEqual={longitudeGreaterThanOrEqual}&longitude.lessThanOrEqual={longitudeLessThanOrEqual}&longitude.equals={longitudeEquals}&longitude.notEquals={longitudeNotEquals}&longitude.specified={longitudeSpecified}&longitude.in={longitudeIn}&longitude.notIn={longitudeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&stationId.greaterThan={stationIdGreaterThan}&stationId.lessThan={stationIdLessThan}&stationId.greaterThanOrEqual={stationIdGreaterThanOrEqual}&stationId.lessThanOrEqual={stationIdLessThanOrEqual}&stationId.equals={stationIdEquals}&stationId.notEquals={stationIdNotEquals}&stationId.specified={stationIdSpecified}&stationId.in={stationIdIn}&stationId.notIn={stationIdNotIn}&wardId.greaterThan={wardIdGreaterThan}&wardId.lessThan={wardIdLessThan}&wardId.greaterThanOrEqual={wardIdGreaterThanOrEqual}&wardId.lessThanOrEqual={wardIdLessThanOrEqual}&wardId.equals={wardIdEquals}&wardId.notEquals={wardIdNotEquals}&wardId.specified={wardIdSpecified}&wardId.in={wardIdIn}&wardId.notIn={wardIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  List<AddressDTO> getAllAddresses(@QueryMap(encoded=true) GetAllAddressesQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllAddresses</code> that receives the query parameters as a map,
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
          *   <li>streetAddressContains -  (optional)</li>
          *   <li>streetAddressDoesNotContain -  (optional)</li>
          *   <li>streetAddressEquals -  (optional)</li>
          *   <li>streetAddressNotEquals -  (optional)</li>
          *   <li>streetAddressSpecified -  (optional)</li>
          *   <li>streetAddressIn -  (optional)</li>
          *   <li>streetAddressNotIn -  (optional)</li>
          *   <li>latitudeGreaterThan -  (optional)</li>
          *   <li>latitudeLessThan -  (optional)</li>
          *   <li>latitudeGreaterThanOrEqual -  (optional)</li>
          *   <li>latitudeLessThanOrEqual -  (optional)</li>
          *   <li>latitudeEquals -  (optional)</li>
          *   <li>latitudeNotEquals -  (optional)</li>
          *   <li>latitudeSpecified -  (optional)</li>
          *   <li>latitudeIn -  (optional)</li>
          *   <li>latitudeNotIn -  (optional)</li>
          *   <li>longitudeGreaterThan -  (optional)</li>
          *   <li>longitudeLessThan -  (optional)</li>
          *   <li>longitudeGreaterThanOrEqual -  (optional)</li>
          *   <li>longitudeLessThanOrEqual -  (optional)</li>
          *   <li>longitudeEquals -  (optional)</li>
          *   <li>longitudeNotEquals -  (optional)</li>
          *   <li>longitudeSpecified -  (optional)</li>
          *   <li>longitudeIn -  (optional)</li>
          *   <li>longitudeNotIn -  (optional)</li>
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
          *   <li>stationIdGreaterThan -  (optional)</li>
          *   <li>stationIdLessThan -  (optional)</li>
          *   <li>stationIdGreaterThanOrEqual -  (optional)</li>
          *   <li>stationIdLessThanOrEqual -  (optional)</li>
          *   <li>stationIdEquals -  (optional)</li>
          *   <li>stationIdNotEquals -  (optional)</li>
          *   <li>stationIdSpecified -  (optional)</li>
          *   <li>stationIdIn -  (optional)</li>
          *   <li>stationIdNotIn -  (optional)</li>
          *   <li>wardIdGreaterThan -  (optional)</li>
          *   <li>wardIdLessThan -  (optional)</li>
          *   <li>wardIdGreaterThanOrEqual -  (optional)</li>
          *   <li>wardIdLessThanOrEqual -  (optional)</li>
          *   <li>wardIdEquals -  (optional)</li>
          *   <li>wardIdNotEquals -  (optional)</li>
          *   <li>wardIdSpecified -  (optional)</li>
          *   <li>wardIdIn -  (optional)</li>
          *   <li>wardIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return List&lt;AddressDTO&gt;
      */
      @RequestLine("GET /api/addresses?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&streetAddress.contains={streetAddressContains}&streetAddress.doesNotContain={streetAddressDoesNotContain}&streetAddress.equals={streetAddressEquals}&streetAddress.notEquals={streetAddressNotEquals}&streetAddress.specified={streetAddressSpecified}&streetAddress.in={streetAddressIn}&streetAddress.notIn={streetAddressNotIn}&latitude.greaterThan={latitudeGreaterThan}&latitude.lessThan={latitudeLessThan}&latitude.greaterThanOrEqual={latitudeGreaterThanOrEqual}&latitude.lessThanOrEqual={latitudeLessThanOrEqual}&latitude.equals={latitudeEquals}&latitude.notEquals={latitudeNotEquals}&latitude.specified={latitudeSpecified}&latitude.in={latitudeIn}&latitude.notIn={latitudeNotIn}&longitude.greaterThan={longitudeGreaterThan}&longitude.lessThan={longitudeLessThan}&longitude.greaterThanOrEqual={longitudeGreaterThanOrEqual}&longitude.lessThanOrEqual={longitudeLessThanOrEqual}&longitude.equals={longitudeEquals}&longitude.notEquals={longitudeNotEquals}&longitude.specified={longitudeSpecified}&longitude.in={longitudeIn}&longitude.notIn={longitudeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&stationId.greaterThan={stationIdGreaterThan}&stationId.lessThan={stationIdLessThan}&stationId.greaterThanOrEqual={stationIdGreaterThanOrEqual}&stationId.lessThanOrEqual={stationIdLessThanOrEqual}&stationId.equals={stationIdEquals}&stationId.notEquals={stationIdNotEquals}&stationId.specified={stationIdSpecified}&stationId.in={stationIdIn}&stationId.notIn={stationIdNotIn}&wardId.greaterThan={wardIdGreaterThan}&wardId.lessThan={wardIdLessThan}&wardId.greaterThanOrEqual={wardIdGreaterThanOrEqual}&wardId.lessThanOrEqual={wardIdLessThanOrEqual}&wardId.equals={wardIdEquals}&wardId.notEquals={wardIdNotEquals}&wardId.specified={wardIdSpecified}&wardId.in={wardIdIn}&wardId.notIn={wardIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<AddressDTO>> getAllAddressesWithHttpInfo(@QueryMap(encoded=true) GetAllAddressesQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllAddresses</code> method in a fluent style.
   */
  public static class GetAllAddressesQueryParams extends HashMap<String, Object> {
    public GetAllAddressesQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAddressesQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAddressesQueryParams streetAddressContains(@jakarta.annotation.Nullable final String value) {
      put("streetAddress.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams streetAddressDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("streetAddress.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams streetAddressEquals(@jakarta.annotation.Nullable final String value) {
      put("streetAddress.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams streetAddressNotEquals(@jakarta.annotation.Nullable final String value) {
      put("streetAddress.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams streetAddressSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("streetAddress.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams streetAddressIn(@jakarta.annotation.Nullable final List<String> value) {
      put("streetAddress.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAddressesQueryParams streetAddressNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("streetAddress.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAddressesQueryParams latitudeGreaterThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("latitude.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams latitudeLessThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("latitude.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams latitudeGreaterThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("latitude.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams latitudeLessThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("latitude.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams latitudeEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("latitude.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams latitudeNotEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("latitude.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams latitudeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("latitude.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams latitudeIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("latitude.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAddressesQueryParams latitudeNotIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("latitude.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAddressesQueryParams longitudeGreaterThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("longitude.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams longitudeLessThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("longitude.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams longitudeGreaterThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("longitude.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams longitudeLessThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("longitude.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams longitudeEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("longitude.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams longitudeNotEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("longitude.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams longitudeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("longitude.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams longitudeIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("longitude.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAddressesQueryParams longitudeNotIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("longitude.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAddressesQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAddressesQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAddressesQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAddressesQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAddressesQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAddressesQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAddressesQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAddressesQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAddressesQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAddressesQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAddressesQueryParams stationIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("stationId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams stationIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("stationId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams stationIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("stationId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams stationIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("stationId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams stationIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("stationId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams stationIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("stationId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams stationIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("stationId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams stationIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("stationId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAddressesQueryParams stationIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("stationId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAddressesQueryParams wardIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("wardId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams wardIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("wardId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams wardIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("wardId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams wardIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("wardId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams wardIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("wardId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams wardIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("wardId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams wardIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("wardId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAddressesQueryParams wardIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("wardId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAddressesQueryParams wardIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("wardId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAddressesQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @param addressDTO  (required)
   * @return AddressDTO
   */
  @RequestLine("PATCH /api/addresses/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  AddressDTO partialUpdateAddress(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull AddressDTO addressDTO);

  /**
   * 
   * Similar to <code>partialUpdateAddress</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param addressDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /api/addresses/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<AddressDTO> partialUpdateAddressWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull AddressDTO addressDTO);



  /**
   * 
   * 
   * @param id  (required)
   * @param addressDTO  (required)
   * @return AddressDTO
   */
  @RequestLine("PUT /api/addresses/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  AddressDTO updateAddress(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull AddressDTO addressDTO);

  /**
   * 
   * Similar to <code>updateAddress</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param addressDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/addresses/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<AddressDTO> updateAddressWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull AddressDTO addressDTO);


}
