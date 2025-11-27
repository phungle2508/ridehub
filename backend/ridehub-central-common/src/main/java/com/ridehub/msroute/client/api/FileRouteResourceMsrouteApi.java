package com.ridehub.msroute.client.api;

import com.ridehub.msroute.client.invoker.ApiClient;
import com.ridehub.msroute.client.invoker.EncodingUtils;
import com.ridehub.msroute.client.model.ApiResponse;

import com.ridehub.msroute.client.model.FileRouteDTO;
import java.time.OffsetDateTime;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface FileRouteResourceMsrouteApi extends ApiClient.Api {


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
   * @param bucketContains  (optional)
   * @param bucketDoesNotContain  (optional)
   * @param bucketEquals  (optional)
   * @param bucketNotEquals  (optional)
   * @param bucketSpecified  (optional)
   * @param bucketIn  (optional)
   * @param bucketNotIn  (optional)
   * @param objectKeyContains  (optional)
   * @param objectKeyDoesNotContain  (optional)
   * @param objectKeyEquals  (optional)
   * @param objectKeyNotEquals  (optional)
   * @param objectKeySpecified  (optional)
   * @param objectKeyIn  (optional)
   * @param objectKeyNotIn  (optional)
   * @param contentTypeContains  (optional)
   * @param contentTypeDoesNotContain  (optional)
   * @param contentTypeEquals  (optional)
   * @param contentTypeNotEquals  (optional)
   * @param contentTypeSpecified  (optional)
   * @param contentTypeIn  (optional)
   * @param contentTypeNotIn  (optional)
   * @param sizeGreaterThan  (optional)
   * @param sizeLessThan  (optional)
   * @param sizeGreaterThanOrEqual  (optional)
   * @param sizeLessThanOrEqual  (optional)
   * @param sizeEquals  (optional)
   * @param sizeNotEquals  (optional)
   * @param sizeSpecified  (optional)
   * @param sizeIn  (optional)
   * @param sizeNotIn  (optional)
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
   * @param vehicleIdGreaterThan  (optional)
   * @param vehicleIdLessThan  (optional)
   * @param vehicleIdGreaterThanOrEqual  (optional)
   * @param vehicleIdLessThanOrEqual  (optional)
   * @param vehicleIdEquals  (optional)
   * @param vehicleIdNotEquals  (optional)
   * @param vehicleIdSpecified  (optional)
   * @param vehicleIdIn  (optional)
   * @param vehicleIdNotIn  (optional)
   * @param seatMapIdGreaterThan  (optional)
   * @param seatMapIdLessThan  (optional)
   * @param seatMapIdGreaterThanOrEqual  (optional)
   * @param seatMapIdLessThanOrEqual  (optional)
   * @param seatMapIdEquals  (optional)
   * @param seatMapIdNotEquals  (optional)
   * @param seatMapIdSpecified  (optional)
   * @param seatMapIdIn  (optional)
   * @param seatMapIdNotIn  (optional)
   * @param distinct  (optional)
   * @return Long
   */
  @RequestLine("GET /api/file-routes/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bucket.contains={bucketContains}&bucket.doesNotContain={bucketDoesNotContain}&bucket.equals={bucketEquals}&bucket.notEquals={bucketNotEquals}&bucket.specified={bucketSpecified}&bucket.in={bucketIn}&bucket.notIn={bucketNotIn}&objectKey.contains={objectKeyContains}&objectKey.doesNotContain={objectKeyDoesNotContain}&objectKey.equals={objectKeyEquals}&objectKey.notEquals={objectKeyNotEquals}&objectKey.specified={objectKeySpecified}&objectKey.in={objectKeyIn}&objectKey.notIn={objectKeyNotIn}&contentType.contains={contentTypeContains}&contentType.doesNotContain={contentTypeDoesNotContain}&contentType.equals={contentTypeEquals}&contentType.notEquals={contentTypeNotEquals}&contentType.specified={contentTypeSpecified}&contentType.in={contentTypeIn}&contentType.notIn={contentTypeNotIn}&size.greaterThan={sizeGreaterThan}&size.lessThan={sizeLessThan}&size.greaterThanOrEqual={sizeGreaterThanOrEqual}&size.lessThanOrEqual={sizeLessThanOrEqual}&size.equals={sizeEquals}&size.notEquals={sizeNotEquals}&size.specified={sizeSpecified}&size.in={sizeIn}&size.notIn={sizeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&stationId.greaterThan={stationIdGreaterThan}&stationId.lessThan={stationIdLessThan}&stationId.greaterThanOrEqual={stationIdGreaterThanOrEqual}&stationId.lessThanOrEqual={stationIdLessThanOrEqual}&stationId.equals={stationIdEquals}&stationId.notEquals={stationIdNotEquals}&stationId.specified={stationIdSpecified}&stationId.in={stationIdIn}&stationId.notIn={stationIdNotIn}&vehicleId.greaterThan={vehicleIdGreaterThan}&vehicleId.lessThan={vehicleIdLessThan}&vehicleId.greaterThanOrEqual={vehicleIdGreaterThanOrEqual}&vehicleId.lessThanOrEqual={vehicleIdLessThanOrEqual}&vehicleId.equals={vehicleIdEquals}&vehicleId.notEquals={vehicleIdNotEquals}&vehicleId.specified={vehicleIdSpecified}&vehicleId.in={vehicleIdIn}&vehicleId.notIn={vehicleIdNotIn}&seatMapId.greaterThan={seatMapIdGreaterThan}&seatMapId.lessThan={seatMapIdLessThan}&seatMapId.greaterThanOrEqual={seatMapIdGreaterThanOrEqual}&seatMapId.lessThanOrEqual={seatMapIdLessThanOrEqual}&seatMapId.equals={seatMapIdEquals}&seatMapId.notEquals={seatMapIdNotEquals}&seatMapId.specified={seatMapIdSpecified}&seatMapId.in={seatMapIdIn}&seatMapId.notIn={seatMapIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  Long countFileRoutes(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("bucketContains") @jakarta.annotation.Nullable String bucketContains, @Param("bucketDoesNotContain") @jakarta.annotation.Nullable String bucketDoesNotContain, @Param("bucketEquals") @jakarta.annotation.Nullable String bucketEquals, @Param("bucketNotEquals") @jakarta.annotation.Nullable String bucketNotEquals, @Param("bucketSpecified") @jakarta.annotation.Nullable Boolean bucketSpecified, @Param("bucketIn") @jakarta.annotation.Nullable List<String> bucketIn, @Param("bucketNotIn") @jakarta.annotation.Nullable List<String> bucketNotIn, @Param("objectKeyContains") @jakarta.annotation.Nullable String objectKeyContains, @Param("objectKeyDoesNotContain") @jakarta.annotation.Nullable String objectKeyDoesNotContain, @Param("objectKeyEquals") @jakarta.annotation.Nullable String objectKeyEquals, @Param("objectKeyNotEquals") @jakarta.annotation.Nullable String objectKeyNotEquals, @Param("objectKeySpecified") @jakarta.annotation.Nullable Boolean objectKeySpecified, @Param("objectKeyIn") @jakarta.annotation.Nullable List<String> objectKeyIn, @Param("objectKeyNotIn") @jakarta.annotation.Nullable List<String> objectKeyNotIn, @Param("contentTypeContains") @jakarta.annotation.Nullable String contentTypeContains, @Param("contentTypeDoesNotContain") @jakarta.annotation.Nullable String contentTypeDoesNotContain, @Param("contentTypeEquals") @jakarta.annotation.Nullable String contentTypeEquals, @Param("contentTypeNotEquals") @jakarta.annotation.Nullable String contentTypeNotEquals, @Param("contentTypeSpecified") @jakarta.annotation.Nullable Boolean contentTypeSpecified, @Param("contentTypeIn") @jakarta.annotation.Nullable List<String> contentTypeIn, @Param("contentTypeNotIn") @jakarta.annotation.Nullable List<String> contentTypeNotIn, @Param("sizeGreaterThan") @jakarta.annotation.Nullable Long sizeGreaterThan, @Param("sizeLessThan") @jakarta.annotation.Nullable Long sizeLessThan, @Param("sizeGreaterThanOrEqual") @jakarta.annotation.Nullable Long sizeGreaterThanOrEqual, @Param("sizeLessThanOrEqual") @jakarta.annotation.Nullable Long sizeLessThanOrEqual, @Param("sizeEquals") @jakarta.annotation.Nullable Long sizeEquals, @Param("sizeNotEquals") @jakarta.annotation.Nullable Long sizeNotEquals, @Param("sizeSpecified") @jakarta.annotation.Nullable Boolean sizeSpecified, @Param("sizeIn") @jakarta.annotation.Nullable List<Long> sizeIn, @Param("sizeNotIn") @jakarta.annotation.Nullable List<Long> sizeNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("stationIdGreaterThan") @jakarta.annotation.Nullable Long stationIdGreaterThan, @Param("stationIdLessThan") @jakarta.annotation.Nullable Long stationIdLessThan, @Param("stationIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long stationIdGreaterThanOrEqual, @Param("stationIdLessThanOrEqual") @jakarta.annotation.Nullable Long stationIdLessThanOrEqual, @Param("stationIdEquals") @jakarta.annotation.Nullable Long stationIdEquals, @Param("stationIdNotEquals") @jakarta.annotation.Nullable Long stationIdNotEquals, @Param("stationIdSpecified") @jakarta.annotation.Nullable Boolean stationIdSpecified, @Param("stationIdIn") @jakarta.annotation.Nullable List<Long> stationIdIn, @Param("stationIdNotIn") @jakarta.annotation.Nullable List<Long> stationIdNotIn, @Param("vehicleIdGreaterThan") @jakarta.annotation.Nullable Long vehicleIdGreaterThan, @Param("vehicleIdLessThan") @jakarta.annotation.Nullable Long vehicleIdLessThan, @Param("vehicleIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long vehicleIdGreaterThanOrEqual, @Param("vehicleIdLessThanOrEqual") @jakarta.annotation.Nullable Long vehicleIdLessThanOrEqual, @Param("vehicleIdEquals") @jakarta.annotation.Nullable Long vehicleIdEquals, @Param("vehicleIdNotEquals") @jakarta.annotation.Nullable Long vehicleIdNotEquals, @Param("vehicleIdSpecified") @jakarta.annotation.Nullable Boolean vehicleIdSpecified, @Param("vehicleIdIn") @jakarta.annotation.Nullable List<Long> vehicleIdIn, @Param("vehicleIdNotIn") @jakarta.annotation.Nullable List<Long> vehicleIdNotIn, @Param("seatMapIdGreaterThan") @jakarta.annotation.Nullable Long seatMapIdGreaterThan, @Param("seatMapIdLessThan") @jakarta.annotation.Nullable Long seatMapIdLessThan, @Param("seatMapIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long seatMapIdGreaterThanOrEqual, @Param("seatMapIdLessThanOrEqual") @jakarta.annotation.Nullable Long seatMapIdLessThanOrEqual, @Param("seatMapIdEquals") @jakarta.annotation.Nullable Long seatMapIdEquals, @Param("seatMapIdNotEquals") @jakarta.annotation.Nullable Long seatMapIdNotEquals, @Param("seatMapIdSpecified") @jakarta.annotation.Nullable Boolean seatMapIdSpecified, @Param("seatMapIdIn") @jakarta.annotation.Nullable List<Long> seatMapIdIn, @Param("seatMapIdNotIn") @jakarta.annotation.Nullable List<Long> seatMapIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>countFileRoutes</code> but it also returns the http response headers .
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
   * @param bucketContains  (optional)
   * @param bucketDoesNotContain  (optional)
   * @param bucketEquals  (optional)
   * @param bucketNotEquals  (optional)
   * @param bucketSpecified  (optional)
   * @param bucketIn  (optional)
   * @param bucketNotIn  (optional)
   * @param objectKeyContains  (optional)
   * @param objectKeyDoesNotContain  (optional)
   * @param objectKeyEquals  (optional)
   * @param objectKeyNotEquals  (optional)
   * @param objectKeySpecified  (optional)
   * @param objectKeyIn  (optional)
   * @param objectKeyNotIn  (optional)
   * @param contentTypeContains  (optional)
   * @param contentTypeDoesNotContain  (optional)
   * @param contentTypeEquals  (optional)
   * @param contentTypeNotEquals  (optional)
   * @param contentTypeSpecified  (optional)
   * @param contentTypeIn  (optional)
   * @param contentTypeNotIn  (optional)
   * @param sizeGreaterThan  (optional)
   * @param sizeLessThan  (optional)
   * @param sizeGreaterThanOrEqual  (optional)
   * @param sizeLessThanOrEqual  (optional)
   * @param sizeEquals  (optional)
   * @param sizeNotEquals  (optional)
   * @param sizeSpecified  (optional)
   * @param sizeIn  (optional)
   * @param sizeNotIn  (optional)
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
   * @param vehicleIdGreaterThan  (optional)
   * @param vehicleIdLessThan  (optional)
   * @param vehicleIdGreaterThanOrEqual  (optional)
   * @param vehicleIdLessThanOrEqual  (optional)
   * @param vehicleIdEquals  (optional)
   * @param vehicleIdNotEquals  (optional)
   * @param vehicleIdSpecified  (optional)
   * @param vehicleIdIn  (optional)
   * @param vehicleIdNotIn  (optional)
   * @param seatMapIdGreaterThan  (optional)
   * @param seatMapIdLessThan  (optional)
   * @param seatMapIdGreaterThanOrEqual  (optional)
   * @param seatMapIdLessThanOrEqual  (optional)
   * @param seatMapIdEquals  (optional)
   * @param seatMapIdNotEquals  (optional)
   * @param seatMapIdSpecified  (optional)
   * @param seatMapIdIn  (optional)
   * @param seatMapIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/file-routes/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bucket.contains={bucketContains}&bucket.doesNotContain={bucketDoesNotContain}&bucket.equals={bucketEquals}&bucket.notEquals={bucketNotEquals}&bucket.specified={bucketSpecified}&bucket.in={bucketIn}&bucket.notIn={bucketNotIn}&objectKey.contains={objectKeyContains}&objectKey.doesNotContain={objectKeyDoesNotContain}&objectKey.equals={objectKeyEquals}&objectKey.notEquals={objectKeyNotEquals}&objectKey.specified={objectKeySpecified}&objectKey.in={objectKeyIn}&objectKey.notIn={objectKeyNotIn}&contentType.contains={contentTypeContains}&contentType.doesNotContain={contentTypeDoesNotContain}&contentType.equals={contentTypeEquals}&contentType.notEquals={contentTypeNotEquals}&contentType.specified={contentTypeSpecified}&contentType.in={contentTypeIn}&contentType.notIn={contentTypeNotIn}&size.greaterThan={sizeGreaterThan}&size.lessThan={sizeLessThan}&size.greaterThanOrEqual={sizeGreaterThanOrEqual}&size.lessThanOrEqual={sizeLessThanOrEqual}&size.equals={sizeEquals}&size.notEquals={sizeNotEquals}&size.specified={sizeSpecified}&size.in={sizeIn}&size.notIn={sizeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&stationId.greaterThan={stationIdGreaterThan}&stationId.lessThan={stationIdLessThan}&stationId.greaterThanOrEqual={stationIdGreaterThanOrEqual}&stationId.lessThanOrEqual={stationIdLessThanOrEqual}&stationId.equals={stationIdEquals}&stationId.notEquals={stationIdNotEquals}&stationId.specified={stationIdSpecified}&stationId.in={stationIdIn}&stationId.notIn={stationIdNotIn}&vehicleId.greaterThan={vehicleIdGreaterThan}&vehicleId.lessThan={vehicleIdLessThan}&vehicleId.greaterThanOrEqual={vehicleIdGreaterThanOrEqual}&vehicleId.lessThanOrEqual={vehicleIdLessThanOrEqual}&vehicleId.equals={vehicleIdEquals}&vehicleId.notEquals={vehicleIdNotEquals}&vehicleId.specified={vehicleIdSpecified}&vehicleId.in={vehicleIdIn}&vehicleId.notIn={vehicleIdNotIn}&seatMapId.greaterThan={seatMapIdGreaterThan}&seatMapId.lessThan={seatMapIdLessThan}&seatMapId.greaterThanOrEqual={seatMapIdGreaterThanOrEqual}&seatMapId.lessThanOrEqual={seatMapIdLessThanOrEqual}&seatMapId.equals={seatMapIdEquals}&seatMapId.notEquals={seatMapIdNotEquals}&seatMapId.specified={seatMapIdSpecified}&seatMapId.in={seatMapIdIn}&seatMapId.notIn={seatMapIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Long> countFileRoutesWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("bucketContains") @jakarta.annotation.Nullable String bucketContains, @Param("bucketDoesNotContain") @jakarta.annotation.Nullable String bucketDoesNotContain, @Param("bucketEquals") @jakarta.annotation.Nullable String bucketEquals, @Param("bucketNotEquals") @jakarta.annotation.Nullable String bucketNotEquals, @Param("bucketSpecified") @jakarta.annotation.Nullable Boolean bucketSpecified, @Param("bucketIn") @jakarta.annotation.Nullable List<String> bucketIn, @Param("bucketNotIn") @jakarta.annotation.Nullable List<String> bucketNotIn, @Param("objectKeyContains") @jakarta.annotation.Nullable String objectKeyContains, @Param("objectKeyDoesNotContain") @jakarta.annotation.Nullable String objectKeyDoesNotContain, @Param("objectKeyEquals") @jakarta.annotation.Nullable String objectKeyEquals, @Param("objectKeyNotEquals") @jakarta.annotation.Nullable String objectKeyNotEquals, @Param("objectKeySpecified") @jakarta.annotation.Nullable Boolean objectKeySpecified, @Param("objectKeyIn") @jakarta.annotation.Nullable List<String> objectKeyIn, @Param("objectKeyNotIn") @jakarta.annotation.Nullable List<String> objectKeyNotIn, @Param("contentTypeContains") @jakarta.annotation.Nullable String contentTypeContains, @Param("contentTypeDoesNotContain") @jakarta.annotation.Nullable String contentTypeDoesNotContain, @Param("contentTypeEquals") @jakarta.annotation.Nullable String contentTypeEquals, @Param("contentTypeNotEquals") @jakarta.annotation.Nullable String contentTypeNotEquals, @Param("contentTypeSpecified") @jakarta.annotation.Nullable Boolean contentTypeSpecified, @Param("contentTypeIn") @jakarta.annotation.Nullable List<String> contentTypeIn, @Param("contentTypeNotIn") @jakarta.annotation.Nullable List<String> contentTypeNotIn, @Param("sizeGreaterThan") @jakarta.annotation.Nullable Long sizeGreaterThan, @Param("sizeLessThan") @jakarta.annotation.Nullable Long sizeLessThan, @Param("sizeGreaterThanOrEqual") @jakarta.annotation.Nullable Long sizeGreaterThanOrEqual, @Param("sizeLessThanOrEqual") @jakarta.annotation.Nullable Long sizeLessThanOrEqual, @Param("sizeEquals") @jakarta.annotation.Nullable Long sizeEquals, @Param("sizeNotEquals") @jakarta.annotation.Nullable Long sizeNotEquals, @Param("sizeSpecified") @jakarta.annotation.Nullable Boolean sizeSpecified, @Param("sizeIn") @jakarta.annotation.Nullable List<Long> sizeIn, @Param("sizeNotIn") @jakarta.annotation.Nullable List<Long> sizeNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("stationIdGreaterThan") @jakarta.annotation.Nullable Long stationIdGreaterThan, @Param("stationIdLessThan") @jakarta.annotation.Nullable Long stationIdLessThan, @Param("stationIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long stationIdGreaterThanOrEqual, @Param("stationIdLessThanOrEqual") @jakarta.annotation.Nullable Long stationIdLessThanOrEqual, @Param("stationIdEquals") @jakarta.annotation.Nullable Long stationIdEquals, @Param("stationIdNotEquals") @jakarta.annotation.Nullable Long stationIdNotEquals, @Param("stationIdSpecified") @jakarta.annotation.Nullable Boolean stationIdSpecified, @Param("stationIdIn") @jakarta.annotation.Nullable List<Long> stationIdIn, @Param("stationIdNotIn") @jakarta.annotation.Nullable List<Long> stationIdNotIn, @Param("vehicleIdGreaterThan") @jakarta.annotation.Nullable Long vehicleIdGreaterThan, @Param("vehicleIdLessThan") @jakarta.annotation.Nullable Long vehicleIdLessThan, @Param("vehicleIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long vehicleIdGreaterThanOrEqual, @Param("vehicleIdLessThanOrEqual") @jakarta.annotation.Nullable Long vehicleIdLessThanOrEqual, @Param("vehicleIdEquals") @jakarta.annotation.Nullable Long vehicleIdEquals, @Param("vehicleIdNotEquals") @jakarta.annotation.Nullable Long vehicleIdNotEquals, @Param("vehicleIdSpecified") @jakarta.annotation.Nullable Boolean vehicleIdSpecified, @Param("vehicleIdIn") @jakarta.annotation.Nullable List<Long> vehicleIdIn, @Param("vehicleIdNotIn") @jakarta.annotation.Nullable List<Long> vehicleIdNotIn, @Param("seatMapIdGreaterThan") @jakarta.annotation.Nullable Long seatMapIdGreaterThan, @Param("seatMapIdLessThan") @jakarta.annotation.Nullable Long seatMapIdLessThan, @Param("seatMapIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long seatMapIdGreaterThanOrEqual, @Param("seatMapIdLessThanOrEqual") @jakarta.annotation.Nullable Long seatMapIdLessThanOrEqual, @Param("seatMapIdEquals") @jakarta.annotation.Nullable Long seatMapIdEquals, @Param("seatMapIdNotEquals") @jakarta.annotation.Nullable Long seatMapIdNotEquals, @Param("seatMapIdSpecified") @jakarta.annotation.Nullable Boolean seatMapIdSpecified, @Param("seatMapIdIn") @jakarta.annotation.Nullable List<Long> seatMapIdIn, @Param("seatMapIdNotIn") @jakarta.annotation.Nullable List<Long> seatMapIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>countFileRoutes</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CountFileRoutesQueryParams} class that allows for
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
   *   <li>bucketContains -  (optional)</li>
   *   <li>bucketDoesNotContain -  (optional)</li>
   *   <li>bucketEquals -  (optional)</li>
   *   <li>bucketNotEquals -  (optional)</li>
   *   <li>bucketSpecified -  (optional)</li>
   *   <li>bucketIn -  (optional)</li>
   *   <li>bucketNotIn -  (optional)</li>
   *   <li>objectKeyContains -  (optional)</li>
   *   <li>objectKeyDoesNotContain -  (optional)</li>
   *   <li>objectKeyEquals -  (optional)</li>
   *   <li>objectKeyNotEquals -  (optional)</li>
   *   <li>objectKeySpecified -  (optional)</li>
   *   <li>objectKeyIn -  (optional)</li>
   *   <li>objectKeyNotIn -  (optional)</li>
   *   <li>contentTypeContains -  (optional)</li>
   *   <li>contentTypeDoesNotContain -  (optional)</li>
   *   <li>contentTypeEquals -  (optional)</li>
   *   <li>contentTypeNotEquals -  (optional)</li>
   *   <li>contentTypeSpecified -  (optional)</li>
   *   <li>contentTypeIn -  (optional)</li>
   *   <li>contentTypeNotIn -  (optional)</li>
   *   <li>sizeGreaterThan -  (optional)</li>
   *   <li>sizeLessThan -  (optional)</li>
   *   <li>sizeGreaterThanOrEqual -  (optional)</li>
   *   <li>sizeLessThanOrEqual -  (optional)</li>
   *   <li>sizeEquals -  (optional)</li>
   *   <li>sizeNotEquals -  (optional)</li>
   *   <li>sizeSpecified -  (optional)</li>
   *   <li>sizeIn -  (optional)</li>
   *   <li>sizeNotIn -  (optional)</li>
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
   *   <li>vehicleIdGreaterThan -  (optional)</li>
   *   <li>vehicleIdLessThan -  (optional)</li>
   *   <li>vehicleIdGreaterThanOrEqual -  (optional)</li>
   *   <li>vehicleIdLessThanOrEqual -  (optional)</li>
   *   <li>vehicleIdEquals -  (optional)</li>
   *   <li>vehicleIdNotEquals -  (optional)</li>
   *   <li>vehicleIdSpecified -  (optional)</li>
   *   <li>vehicleIdIn -  (optional)</li>
   *   <li>vehicleIdNotIn -  (optional)</li>
   *   <li>seatMapIdGreaterThan -  (optional)</li>
   *   <li>seatMapIdLessThan -  (optional)</li>
   *   <li>seatMapIdGreaterThanOrEqual -  (optional)</li>
   *   <li>seatMapIdLessThanOrEqual -  (optional)</li>
   *   <li>seatMapIdEquals -  (optional)</li>
   *   <li>seatMapIdNotEquals -  (optional)</li>
   *   <li>seatMapIdSpecified -  (optional)</li>
   *   <li>seatMapIdIn -  (optional)</li>
   *   <li>seatMapIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return Long
   */
  @RequestLine("GET /api/file-routes/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bucket.contains={bucketContains}&bucket.doesNotContain={bucketDoesNotContain}&bucket.equals={bucketEquals}&bucket.notEquals={bucketNotEquals}&bucket.specified={bucketSpecified}&bucket.in={bucketIn}&bucket.notIn={bucketNotIn}&objectKey.contains={objectKeyContains}&objectKey.doesNotContain={objectKeyDoesNotContain}&objectKey.equals={objectKeyEquals}&objectKey.notEquals={objectKeyNotEquals}&objectKey.specified={objectKeySpecified}&objectKey.in={objectKeyIn}&objectKey.notIn={objectKeyNotIn}&contentType.contains={contentTypeContains}&contentType.doesNotContain={contentTypeDoesNotContain}&contentType.equals={contentTypeEquals}&contentType.notEquals={contentTypeNotEquals}&contentType.specified={contentTypeSpecified}&contentType.in={contentTypeIn}&contentType.notIn={contentTypeNotIn}&size.greaterThan={sizeGreaterThan}&size.lessThan={sizeLessThan}&size.greaterThanOrEqual={sizeGreaterThanOrEqual}&size.lessThanOrEqual={sizeLessThanOrEqual}&size.equals={sizeEquals}&size.notEquals={sizeNotEquals}&size.specified={sizeSpecified}&size.in={sizeIn}&size.notIn={sizeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&stationId.greaterThan={stationIdGreaterThan}&stationId.lessThan={stationIdLessThan}&stationId.greaterThanOrEqual={stationIdGreaterThanOrEqual}&stationId.lessThanOrEqual={stationIdLessThanOrEqual}&stationId.equals={stationIdEquals}&stationId.notEquals={stationIdNotEquals}&stationId.specified={stationIdSpecified}&stationId.in={stationIdIn}&stationId.notIn={stationIdNotIn}&vehicleId.greaterThan={vehicleIdGreaterThan}&vehicleId.lessThan={vehicleIdLessThan}&vehicleId.greaterThanOrEqual={vehicleIdGreaterThanOrEqual}&vehicleId.lessThanOrEqual={vehicleIdLessThanOrEqual}&vehicleId.equals={vehicleIdEquals}&vehicleId.notEquals={vehicleIdNotEquals}&vehicleId.specified={vehicleIdSpecified}&vehicleId.in={vehicleIdIn}&vehicleId.notIn={vehicleIdNotIn}&seatMapId.greaterThan={seatMapIdGreaterThan}&seatMapId.lessThan={seatMapIdLessThan}&seatMapId.greaterThanOrEqual={seatMapIdGreaterThanOrEqual}&seatMapId.lessThanOrEqual={seatMapIdLessThanOrEqual}&seatMapId.equals={seatMapIdEquals}&seatMapId.notEquals={seatMapIdNotEquals}&seatMapId.specified={seatMapIdSpecified}&seatMapId.in={seatMapIdIn}&seatMapId.notIn={seatMapIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  Long countFileRoutes(@QueryMap(encoded=true) CountFileRoutesQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>countFileRoutes</code> that receives the query parameters as a map,
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
          *   <li>bucketContains -  (optional)</li>
          *   <li>bucketDoesNotContain -  (optional)</li>
          *   <li>bucketEquals -  (optional)</li>
          *   <li>bucketNotEquals -  (optional)</li>
          *   <li>bucketSpecified -  (optional)</li>
          *   <li>bucketIn -  (optional)</li>
          *   <li>bucketNotIn -  (optional)</li>
          *   <li>objectKeyContains -  (optional)</li>
          *   <li>objectKeyDoesNotContain -  (optional)</li>
          *   <li>objectKeyEquals -  (optional)</li>
          *   <li>objectKeyNotEquals -  (optional)</li>
          *   <li>objectKeySpecified -  (optional)</li>
          *   <li>objectKeyIn -  (optional)</li>
          *   <li>objectKeyNotIn -  (optional)</li>
          *   <li>contentTypeContains -  (optional)</li>
          *   <li>contentTypeDoesNotContain -  (optional)</li>
          *   <li>contentTypeEquals -  (optional)</li>
          *   <li>contentTypeNotEquals -  (optional)</li>
          *   <li>contentTypeSpecified -  (optional)</li>
          *   <li>contentTypeIn -  (optional)</li>
          *   <li>contentTypeNotIn -  (optional)</li>
          *   <li>sizeGreaterThan -  (optional)</li>
          *   <li>sizeLessThan -  (optional)</li>
          *   <li>sizeGreaterThanOrEqual -  (optional)</li>
          *   <li>sizeLessThanOrEqual -  (optional)</li>
          *   <li>sizeEquals -  (optional)</li>
          *   <li>sizeNotEquals -  (optional)</li>
          *   <li>sizeSpecified -  (optional)</li>
          *   <li>sizeIn -  (optional)</li>
          *   <li>sizeNotIn -  (optional)</li>
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
          *   <li>vehicleIdGreaterThan -  (optional)</li>
          *   <li>vehicleIdLessThan -  (optional)</li>
          *   <li>vehicleIdGreaterThanOrEqual -  (optional)</li>
          *   <li>vehicleIdLessThanOrEqual -  (optional)</li>
          *   <li>vehicleIdEquals -  (optional)</li>
          *   <li>vehicleIdNotEquals -  (optional)</li>
          *   <li>vehicleIdSpecified -  (optional)</li>
          *   <li>vehicleIdIn -  (optional)</li>
          *   <li>vehicleIdNotIn -  (optional)</li>
          *   <li>seatMapIdGreaterThan -  (optional)</li>
          *   <li>seatMapIdLessThan -  (optional)</li>
          *   <li>seatMapIdGreaterThanOrEqual -  (optional)</li>
          *   <li>seatMapIdLessThanOrEqual -  (optional)</li>
          *   <li>seatMapIdEquals -  (optional)</li>
          *   <li>seatMapIdNotEquals -  (optional)</li>
          *   <li>seatMapIdSpecified -  (optional)</li>
          *   <li>seatMapIdIn -  (optional)</li>
          *   <li>seatMapIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return Long
      */
      @RequestLine("GET /api/file-routes/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bucket.contains={bucketContains}&bucket.doesNotContain={bucketDoesNotContain}&bucket.equals={bucketEquals}&bucket.notEquals={bucketNotEquals}&bucket.specified={bucketSpecified}&bucket.in={bucketIn}&bucket.notIn={bucketNotIn}&objectKey.contains={objectKeyContains}&objectKey.doesNotContain={objectKeyDoesNotContain}&objectKey.equals={objectKeyEquals}&objectKey.notEquals={objectKeyNotEquals}&objectKey.specified={objectKeySpecified}&objectKey.in={objectKeyIn}&objectKey.notIn={objectKeyNotIn}&contentType.contains={contentTypeContains}&contentType.doesNotContain={contentTypeDoesNotContain}&contentType.equals={contentTypeEquals}&contentType.notEquals={contentTypeNotEquals}&contentType.specified={contentTypeSpecified}&contentType.in={contentTypeIn}&contentType.notIn={contentTypeNotIn}&size.greaterThan={sizeGreaterThan}&size.lessThan={sizeLessThan}&size.greaterThanOrEqual={sizeGreaterThanOrEqual}&size.lessThanOrEqual={sizeLessThanOrEqual}&size.equals={sizeEquals}&size.notEquals={sizeNotEquals}&size.specified={sizeSpecified}&size.in={sizeIn}&size.notIn={sizeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&stationId.greaterThan={stationIdGreaterThan}&stationId.lessThan={stationIdLessThan}&stationId.greaterThanOrEqual={stationIdGreaterThanOrEqual}&stationId.lessThanOrEqual={stationIdLessThanOrEqual}&stationId.equals={stationIdEquals}&stationId.notEquals={stationIdNotEquals}&stationId.specified={stationIdSpecified}&stationId.in={stationIdIn}&stationId.notIn={stationIdNotIn}&vehicleId.greaterThan={vehicleIdGreaterThan}&vehicleId.lessThan={vehicleIdLessThan}&vehicleId.greaterThanOrEqual={vehicleIdGreaterThanOrEqual}&vehicleId.lessThanOrEqual={vehicleIdLessThanOrEqual}&vehicleId.equals={vehicleIdEquals}&vehicleId.notEquals={vehicleIdNotEquals}&vehicleId.specified={vehicleIdSpecified}&vehicleId.in={vehicleIdIn}&vehicleId.notIn={vehicleIdNotIn}&seatMapId.greaterThan={seatMapIdGreaterThan}&seatMapId.lessThan={seatMapIdLessThan}&seatMapId.greaterThanOrEqual={seatMapIdGreaterThanOrEqual}&seatMapId.lessThanOrEqual={seatMapIdLessThanOrEqual}&seatMapId.equals={seatMapIdEquals}&seatMapId.notEquals={seatMapIdNotEquals}&seatMapId.specified={seatMapIdSpecified}&seatMapId.in={seatMapIdIn}&seatMapId.notIn={seatMapIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Long> countFileRoutesWithHttpInfo(@QueryMap(encoded=true) CountFileRoutesQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>countFileRoutes</code> method in a fluent style.
   */
  public static class CountFileRoutesQueryParams extends HashMap<String, Object> {
    public CountFileRoutesQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileRoutesQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileRoutesQueryParams bucketContains(@jakarta.annotation.Nullable final String value) {
      put("bucket.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams bucketDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("bucket.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams bucketEquals(@jakarta.annotation.Nullable final String value) {
      put("bucket.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams bucketNotEquals(@jakarta.annotation.Nullable final String value) {
      put("bucket.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams bucketSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("bucket.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams bucketIn(@jakarta.annotation.Nullable final List<String> value) {
      put("bucket.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileRoutesQueryParams bucketNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("bucket.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileRoutesQueryParams objectKeyContains(@jakarta.annotation.Nullable final String value) {
      put("objectKey.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams objectKeyDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("objectKey.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams objectKeyEquals(@jakarta.annotation.Nullable final String value) {
      put("objectKey.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams objectKeyNotEquals(@jakarta.annotation.Nullable final String value) {
      put("objectKey.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams objectKeySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("objectKey.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams objectKeyIn(@jakarta.annotation.Nullable final List<String> value) {
      put("objectKey.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileRoutesQueryParams objectKeyNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("objectKey.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileRoutesQueryParams contentTypeContains(@jakarta.annotation.Nullable final String value) {
      put("contentType.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams contentTypeDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("contentType.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams contentTypeEquals(@jakarta.annotation.Nullable final String value) {
      put("contentType.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams contentTypeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("contentType.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams contentTypeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("contentType.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams contentTypeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("contentType.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileRoutesQueryParams contentTypeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("contentType.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileRoutesQueryParams sizeGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("size.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams sizeLessThan(@jakarta.annotation.Nullable final Long value) {
      put("size.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams sizeGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("size.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams sizeLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("size.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams sizeEquals(@jakarta.annotation.Nullable final Long value) {
      put("size.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams sizeNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("size.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams sizeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("size.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams sizeIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("size.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileRoutesQueryParams sizeNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("size.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileRoutesQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileRoutesQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileRoutesQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileRoutesQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileRoutesQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileRoutesQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileRoutesQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileRoutesQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileRoutesQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileRoutesQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileRoutesQueryParams stationIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("stationId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams stationIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("stationId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams stationIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("stationId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams stationIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("stationId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams stationIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("stationId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams stationIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("stationId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams stationIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("stationId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams stationIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("stationId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileRoutesQueryParams stationIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("stationId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileRoutesQueryParams vehicleIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("vehicleId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams vehicleIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("vehicleId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams vehicleIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("vehicleId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams vehicleIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("vehicleId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams vehicleIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("vehicleId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams vehicleIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("vehicleId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams vehicleIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("vehicleId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams vehicleIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("vehicleId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileRoutesQueryParams vehicleIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("vehicleId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileRoutesQueryParams seatMapIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams seatMapIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams seatMapIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams seatMapIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams seatMapIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams seatMapIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams seatMapIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("seatMapId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFileRoutesQueryParams seatMapIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("seatMapId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileRoutesQueryParams seatMapIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("seatMapId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileRoutesQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param fileRouteDTO  (required)
   * @return FileRouteDTO
   */
  @RequestLine("POST /api/file-routes")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  FileRouteDTO createFileRoute(@jakarta.annotation.Nonnull FileRouteDTO fileRouteDTO);

  /**
   * 
   * Similar to <code>createFileRoute</code> but it also returns the http response headers .
   * 
   * @param fileRouteDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/file-routes")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<FileRouteDTO> createFileRouteWithHttpInfo(@jakarta.annotation.Nonnull FileRouteDTO fileRouteDTO);



  /**
   * 
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/file-routes/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteFileRoute(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>deleteFileRoute</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/file-routes/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteFileRouteWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



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
   * @param bucketContains  (optional)
   * @param bucketDoesNotContain  (optional)
   * @param bucketEquals  (optional)
   * @param bucketNotEquals  (optional)
   * @param bucketSpecified  (optional)
   * @param bucketIn  (optional)
   * @param bucketNotIn  (optional)
   * @param objectKeyContains  (optional)
   * @param objectKeyDoesNotContain  (optional)
   * @param objectKeyEquals  (optional)
   * @param objectKeyNotEquals  (optional)
   * @param objectKeySpecified  (optional)
   * @param objectKeyIn  (optional)
   * @param objectKeyNotIn  (optional)
   * @param contentTypeContains  (optional)
   * @param contentTypeDoesNotContain  (optional)
   * @param contentTypeEquals  (optional)
   * @param contentTypeNotEquals  (optional)
   * @param contentTypeSpecified  (optional)
   * @param contentTypeIn  (optional)
   * @param contentTypeNotIn  (optional)
   * @param sizeGreaterThan  (optional)
   * @param sizeLessThan  (optional)
   * @param sizeGreaterThanOrEqual  (optional)
   * @param sizeLessThanOrEqual  (optional)
   * @param sizeEquals  (optional)
   * @param sizeNotEquals  (optional)
   * @param sizeSpecified  (optional)
   * @param sizeIn  (optional)
   * @param sizeNotIn  (optional)
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
   * @param vehicleIdGreaterThan  (optional)
   * @param vehicleIdLessThan  (optional)
   * @param vehicleIdGreaterThanOrEqual  (optional)
   * @param vehicleIdLessThanOrEqual  (optional)
   * @param vehicleIdEquals  (optional)
   * @param vehicleIdNotEquals  (optional)
   * @param vehicleIdSpecified  (optional)
   * @param vehicleIdIn  (optional)
   * @param vehicleIdNotIn  (optional)
   * @param seatMapIdGreaterThan  (optional)
   * @param seatMapIdLessThan  (optional)
   * @param seatMapIdGreaterThanOrEqual  (optional)
   * @param seatMapIdLessThanOrEqual  (optional)
   * @param seatMapIdEquals  (optional)
   * @param seatMapIdNotEquals  (optional)
   * @param seatMapIdSpecified  (optional)
   * @param seatMapIdIn  (optional)
   * @param seatMapIdNotIn  (optional)
   * @param distinct  (optional)
   * @return List&lt;FileRouteDTO&gt;
   */
  @RequestLine("GET /api/file-routes?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bucket.contains={bucketContains}&bucket.doesNotContain={bucketDoesNotContain}&bucket.equals={bucketEquals}&bucket.notEquals={bucketNotEquals}&bucket.specified={bucketSpecified}&bucket.in={bucketIn}&bucket.notIn={bucketNotIn}&objectKey.contains={objectKeyContains}&objectKey.doesNotContain={objectKeyDoesNotContain}&objectKey.equals={objectKeyEquals}&objectKey.notEquals={objectKeyNotEquals}&objectKey.specified={objectKeySpecified}&objectKey.in={objectKeyIn}&objectKey.notIn={objectKeyNotIn}&contentType.contains={contentTypeContains}&contentType.doesNotContain={contentTypeDoesNotContain}&contentType.equals={contentTypeEquals}&contentType.notEquals={contentTypeNotEquals}&contentType.specified={contentTypeSpecified}&contentType.in={contentTypeIn}&contentType.notIn={contentTypeNotIn}&size.greaterThan={sizeGreaterThan}&size.lessThan={sizeLessThan}&size.greaterThanOrEqual={sizeGreaterThanOrEqual}&size.lessThanOrEqual={sizeLessThanOrEqual}&size.equals={sizeEquals}&size.notEquals={sizeNotEquals}&size.specified={sizeSpecified}&size.in={sizeIn}&size.notIn={sizeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&stationId.greaterThan={stationIdGreaterThan}&stationId.lessThan={stationIdLessThan}&stationId.greaterThanOrEqual={stationIdGreaterThanOrEqual}&stationId.lessThanOrEqual={stationIdLessThanOrEqual}&stationId.equals={stationIdEquals}&stationId.notEquals={stationIdNotEquals}&stationId.specified={stationIdSpecified}&stationId.in={stationIdIn}&stationId.notIn={stationIdNotIn}&vehicleId.greaterThan={vehicleIdGreaterThan}&vehicleId.lessThan={vehicleIdLessThan}&vehicleId.greaterThanOrEqual={vehicleIdGreaterThanOrEqual}&vehicleId.lessThanOrEqual={vehicleIdLessThanOrEqual}&vehicleId.equals={vehicleIdEquals}&vehicleId.notEquals={vehicleIdNotEquals}&vehicleId.specified={vehicleIdSpecified}&vehicleId.in={vehicleIdIn}&vehicleId.notIn={vehicleIdNotIn}&seatMapId.greaterThan={seatMapIdGreaterThan}&seatMapId.lessThan={seatMapIdLessThan}&seatMapId.greaterThanOrEqual={seatMapIdGreaterThanOrEqual}&seatMapId.lessThanOrEqual={seatMapIdLessThanOrEqual}&seatMapId.equals={seatMapIdEquals}&seatMapId.notEquals={seatMapIdNotEquals}&seatMapId.specified={seatMapIdSpecified}&seatMapId.in={seatMapIdIn}&seatMapId.notIn={seatMapIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  List<FileRouteDTO> getAllFileRoutes(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("bucketContains") @jakarta.annotation.Nullable String bucketContains, @Param("bucketDoesNotContain") @jakarta.annotation.Nullable String bucketDoesNotContain, @Param("bucketEquals") @jakarta.annotation.Nullable String bucketEquals, @Param("bucketNotEquals") @jakarta.annotation.Nullable String bucketNotEquals, @Param("bucketSpecified") @jakarta.annotation.Nullable Boolean bucketSpecified, @Param("bucketIn") @jakarta.annotation.Nullable List<String> bucketIn, @Param("bucketNotIn") @jakarta.annotation.Nullable List<String> bucketNotIn, @Param("objectKeyContains") @jakarta.annotation.Nullable String objectKeyContains, @Param("objectKeyDoesNotContain") @jakarta.annotation.Nullable String objectKeyDoesNotContain, @Param("objectKeyEquals") @jakarta.annotation.Nullable String objectKeyEquals, @Param("objectKeyNotEquals") @jakarta.annotation.Nullable String objectKeyNotEquals, @Param("objectKeySpecified") @jakarta.annotation.Nullable Boolean objectKeySpecified, @Param("objectKeyIn") @jakarta.annotation.Nullable List<String> objectKeyIn, @Param("objectKeyNotIn") @jakarta.annotation.Nullable List<String> objectKeyNotIn, @Param("contentTypeContains") @jakarta.annotation.Nullable String contentTypeContains, @Param("contentTypeDoesNotContain") @jakarta.annotation.Nullable String contentTypeDoesNotContain, @Param("contentTypeEquals") @jakarta.annotation.Nullable String contentTypeEquals, @Param("contentTypeNotEquals") @jakarta.annotation.Nullable String contentTypeNotEquals, @Param("contentTypeSpecified") @jakarta.annotation.Nullable Boolean contentTypeSpecified, @Param("contentTypeIn") @jakarta.annotation.Nullable List<String> contentTypeIn, @Param("contentTypeNotIn") @jakarta.annotation.Nullable List<String> contentTypeNotIn, @Param("sizeGreaterThan") @jakarta.annotation.Nullable Long sizeGreaterThan, @Param("sizeLessThan") @jakarta.annotation.Nullable Long sizeLessThan, @Param("sizeGreaterThanOrEqual") @jakarta.annotation.Nullable Long sizeGreaterThanOrEqual, @Param("sizeLessThanOrEqual") @jakarta.annotation.Nullable Long sizeLessThanOrEqual, @Param("sizeEquals") @jakarta.annotation.Nullable Long sizeEquals, @Param("sizeNotEquals") @jakarta.annotation.Nullable Long sizeNotEquals, @Param("sizeSpecified") @jakarta.annotation.Nullable Boolean sizeSpecified, @Param("sizeIn") @jakarta.annotation.Nullable List<Long> sizeIn, @Param("sizeNotIn") @jakarta.annotation.Nullable List<Long> sizeNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("stationIdGreaterThan") @jakarta.annotation.Nullable Long stationIdGreaterThan, @Param("stationIdLessThan") @jakarta.annotation.Nullable Long stationIdLessThan, @Param("stationIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long stationIdGreaterThanOrEqual, @Param("stationIdLessThanOrEqual") @jakarta.annotation.Nullable Long stationIdLessThanOrEqual, @Param("stationIdEquals") @jakarta.annotation.Nullable Long stationIdEquals, @Param("stationIdNotEquals") @jakarta.annotation.Nullable Long stationIdNotEquals, @Param("stationIdSpecified") @jakarta.annotation.Nullable Boolean stationIdSpecified, @Param("stationIdIn") @jakarta.annotation.Nullable List<Long> stationIdIn, @Param("stationIdNotIn") @jakarta.annotation.Nullable List<Long> stationIdNotIn, @Param("vehicleIdGreaterThan") @jakarta.annotation.Nullable Long vehicleIdGreaterThan, @Param("vehicleIdLessThan") @jakarta.annotation.Nullable Long vehicleIdLessThan, @Param("vehicleIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long vehicleIdGreaterThanOrEqual, @Param("vehicleIdLessThanOrEqual") @jakarta.annotation.Nullable Long vehicleIdLessThanOrEqual, @Param("vehicleIdEquals") @jakarta.annotation.Nullable Long vehicleIdEquals, @Param("vehicleIdNotEquals") @jakarta.annotation.Nullable Long vehicleIdNotEquals, @Param("vehicleIdSpecified") @jakarta.annotation.Nullable Boolean vehicleIdSpecified, @Param("vehicleIdIn") @jakarta.annotation.Nullable List<Long> vehicleIdIn, @Param("vehicleIdNotIn") @jakarta.annotation.Nullable List<Long> vehicleIdNotIn, @Param("seatMapIdGreaterThan") @jakarta.annotation.Nullable Long seatMapIdGreaterThan, @Param("seatMapIdLessThan") @jakarta.annotation.Nullable Long seatMapIdLessThan, @Param("seatMapIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long seatMapIdGreaterThanOrEqual, @Param("seatMapIdLessThanOrEqual") @jakarta.annotation.Nullable Long seatMapIdLessThanOrEqual, @Param("seatMapIdEquals") @jakarta.annotation.Nullable Long seatMapIdEquals, @Param("seatMapIdNotEquals") @jakarta.annotation.Nullable Long seatMapIdNotEquals, @Param("seatMapIdSpecified") @jakarta.annotation.Nullable Boolean seatMapIdSpecified, @Param("seatMapIdIn") @jakarta.annotation.Nullable List<Long> seatMapIdIn, @Param("seatMapIdNotIn") @jakarta.annotation.Nullable List<Long> seatMapIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>getAllFileRoutes</code> but it also returns the http response headers .
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
   * @param bucketContains  (optional)
   * @param bucketDoesNotContain  (optional)
   * @param bucketEquals  (optional)
   * @param bucketNotEquals  (optional)
   * @param bucketSpecified  (optional)
   * @param bucketIn  (optional)
   * @param bucketNotIn  (optional)
   * @param objectKeyContains  (optional)
   * @param objectKeyDoesNotContain  (optional)
   * @param objectKeyEquals  (optional)
   * @param objectKeyNotEquals  (optional)
   * @param objectKeySpecified  (optional)
   * @param objectKeyIn  (optional)
   * @param objectKeyNotIn  (optional)
   * @param contentTypeContains  (optional)
   * @param contentTypeDoesNotContain  (optional)
   * @param contentTypeEquals  (optional)
   * @param contentTypeNotEquals  (optional)
   * @param contentTypeSpecified  (optional)
   * @param contentTypeIn  (optional)
   * @param contentTypeNotIn  (optional)
   * @param sizeGreaterThan  (optional)
   * @param sizeLessThan  (optional)
   * @param sizeGreaterThanOrEqual  (optional)
   * @param sizeLessThanOrEqual  (optional)
   * @param sizeEquals  (optional)
   * @param sizeNotEquals  (optional)
   * @param sizeSpecified  (optional)
   * @param sizeIn  (optional)
   * @param sizeNotIn  (optional)
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
   * @param vehicleIdGreaterThan  (optional)
   * @param vehicleIdLessThan  (optional)
   * @param vehicleIdGreaterThanOrEqual  (optional)
   * @param vehicleIdLessThanOrEqual  (optional)
   * @param vehicleIdEquals  (optional)
   * @param vehicleIdNotEquals  (optional)
   * @param vehicleIdSpecified  (optional)
   * @param vehicleIdIn  (optional)
   * @param vehicleIdNotIn  (optional)
   * @param seatMapIdGreaterThan  (optional)
   * @param seatMapIdLessThan  (optional)
   * @param seatMapIdGreaterThanOrEqual  (optional)
   * @param seatMapIdLessThanOrEqual  (optional)
   * @param seatMapIdEquals  (optional)
   * @param seatMapIdNotEquals  (optional)
   * @param seatMapIdSpecified  (optional)
   * @param seatMapIdIn  (optional)
   * @param seatMapIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/file-routes?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bucket.contains={bucketContains}&bucket.doesNotContain={bucketDoesNotContain}&bucket.equals={bucketEquals}&bucket.notEquals={bucketNotEquals}&bucket.specified={bucketSpecified}&bucket.in={bucketIn}&bucket.notIn={bucketNotIn}&objectKey.contains={objectKeyContains}&objectKey.doesNotContain={objectKeyDoesNotContain}&objectKey.equals={objectKeyEquals}&objectKey.notEquals={objectKeyNotEquals}&objectKey.specified={objectKeySpecified}&objectKey.in={objectKeyIn}&objectKey.notIn={objectKeyNotIn}&contentType.contains={contentTypeContains}&contentType.doesNotContain={contentTypeDoesNotContain}&contentType.equals={contentTypeEquals}&contentType.notEquals={contentTypeNotEquals}&contentType.specified={contentTypeSpecified}&contentType.in={contentTypeIn}&contentType.notIn={contentTypeNotIn}&size.greaterThan={sizeGreaterThan}&size.lessThan={sizeLessThan}&size.greaterThanOrEqual={sizeGreaterThanOrEqual}&size.lessThanOrEqual={sizeLessThanOrEqual}&size.equals={sizeEquals}&size.notEquals={sizeNotEquals}&size.specified={sizeSpecified}&size.in={sizeIn}&size.notIn={sizeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&stationId.greaterThan={stationIdGreaterThan}&stationId.lessThan={stationIdLessThan}&stationId.greaterThanOrEqual={stationIdGreaterThanOrEqual}&stationId.lessThanOrEqual={stationIdLessThanOrEqual}&stationId.equals={stationIdEquals}&stationId.notEquals={stationIdNotEquals}&stationId.specified={stationIdSpecified}&stationId.in={stationIdIn}&stationId.notIn={stationIdNotIn}&vehicleId.greaterThan={vehicleIdGreaterThan}&vehicleId.lessThan={vehicleIdLessThan}&vehicleId.greaterThanOrEqual={vehicleIdGreaterThanOrEqual}&vehicleId.lessThanOrEqual={vehicleIdLessThanOrEqual}&vehicleId.equals={vehicleIdEquals}&vehicleId.notEquals={vehicleIdNotEquals}&vehicleId.specified={vehicleIdSpecified}&vehicleId.in={vehicleIdIn}&vehicleId.notIn={vehicleIdNotIn}&seatMapId.greaterThan={seatMapIdGreaterThan}&seatMapId.lessThan={seatMapIdLessThan}&seatMapId.greaterThanOrEqual={seatMapIdGreaterThanOrEqual}&seatMapId.lessThanOrEqual={seatMapIdLessThanOrEqual}&seatMapId.equals={seatMapIdEquals}&seatMapId.notEquals={seatMapIdNotEquals}&seatMapId.specified={seatMapIdSpecified}&seatMapId.in={seatMapIdIn}&seatMapId.notIn={seatMapIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<FileRouteDTO>> getAllFileRoutesWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("bucketContains") @jakarta.annotation.Nullable String bucketContains, @Param("bucketDoesNotContain") @jakarta.annotation.Nullable String bucketDoesNotContain, @Param("bucketEquals") @jakarta.annotation.Nullable String bucketEquals, @Param("bucketNotEquals") @jakarta.annotation.Nullable String bucketNotEquals, @Param("bucketSpecified") @jakarta.annotation.Nullable Boolean bucketSpecified, @Param("bucketIn") @jakarta.annotation.Nullable List<String> bucketIn, @Param("bucketNotIn") @jakarta.annotation.Nullable List<String> bucketNotIn, @Param("objectKeyContains") @jakarta.annotation.Nullable String objectKeyContains, @Param("objectKeyDoesNotContain") @jakarta.annotation.Nullable String objectKeyDoesNotContain, @Param("objectKeyEquals") @jakarta.annotation.Nullable String objectKeyEquals, @Param("objectKeyNotEquals") @jakarta.annotation.Nullable String objectKeyNotEquals, @Param("objectKeySpecified") @jakarta.annotation.Nullable Boolean objectKeySpecified, @Param("objectKeyIn") @jakarta.annotation.Nullable List<String> objectKeyIn, @Param("objectKeyNotIn") @jakarta.annotation.Nullable List<String> objectKeyNotIn, @Param("contentTypeContains") @jakarta.annotation.Nullable String contentTypeContains, @Param("contentTypeDoesNotContain") @jakarta.annotation.Nullable String contentTypeDoesNotContain, @Param("contentTypeEquals") @jakarta.annotation.Nullable String contentTypeEquals, @Param("contentTypeNotEquals") @jakarta.annotation.Nullable String contentTypeNotEquals, @Param("contentTypeSpecified") @jakarta.annotation.Nullable Boolean contentTypeSpecified, @Param("contentTypeIn") @jakarta.annotation.Nullable List<String> contentTypeIn, @Param("contentTypeNotIn") @jakarta.annotation.Nullable List<String> contentTypeNotIn, @Param("sizeGreaterThan") @jakarta.annotation.Nullable Long sizeGreaterThan, @Param("sizeLessThan") @jakarta.annotation.Nullable Long sizeLessThan, @Param("sizeGreaterThanOrEqual") @jakarta.annotation.Nullable Long sizeGreaterThanOrEqual, @Param("sizeLessThanOrEqual") @jakarta.annotation.Nullable Long sizeLessThanOrEqual, @Param("sizeEquals") @jakarta.annotation.Nullable Long sizeEquals, @Param("sizeNotEquals") @jakarta.annotation.Nullable Long sizeNotEquals, @Param("sizeSpecified") @jakarta.annotation.Nullable Boolean sizeSpecified, @Param("sizeIn") @jakarta.annotation.Nullable List<Long> sizeIn, @Param("sizeNotIn") @jakarta.annotation.Nullable List<Long> sizeNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("stationIdGreaterThan") @jakarta.annotation.Nullable Long stationIdGreaterThan, @Param("stationIdLessThan") @jakarta.annotation.Nullable Long stationIdLessThan, @Param("stationIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long stationIdGreaterThanOrEqual, @Param("stationIdLessThanOrEqual") @jakarta.annotation.Nullable Long stationIdLessThanOrEqual, @Param("stationIdEquals") @jakarta.annotation.Nullable Long stationIdEquals, @Param("stationIdNotEquals") @jakarta.annotation.Nullable Long stationIdNotEquals, @Param("stationIdSpecified") @jakarta.annotation.Nullable Boolean stationIdSpecified, @Param("stationIdIn") @jakarta.annotation.Nullable List<Long> stationIdIn, @Param("stationIdNotIn") @jakarta.annotation.Nullable List<Long> stationIdNotIn, @Param("vehicleIdGreaterThan") @jakarta.annotation.Nullable Long vehicleIdGreaterThan, @Param("vehicleIdLessThan") @jakarta.annotation.Nullable Long vehicleIdLessThan, @Param("vehicleIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long vehicleIdGreaterThanOrEqual, @Param("vehicleIdLessThanOrEqual") @jakarta.annotation.Nullable Long vehicleIdLessThanOrEqual, @Param("vehicleIdEquals") @jakarta.annotation.Nullable Long vehicleIdEquals, @Param("vehicleIdNotEquals") @jakarta.annotation.Nullable Long vehicleIdNotEquals, @Param("vehicleIdSpecified") @jakarta.annotation.Nullable Boolean vehicleIdSpecified, @Param("vehicleIdIn") @jakarta.annotation.Nullable List<Long> vehicleIdIn, @Param("vehicleIdNotIn") @jakarta.annotation.Nullable List<Long> vehicleIdNotIn, @Param("seatMapIdGreaterThan") @jakarta.annotation.Nullable Long seatMapIdGreaterThan, @Param("seatMapIdLessThan") @jakarta.annotation.Nullable Long seatMapIdLessThan, @Param("seatMapIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long seatMapIdGreaterThanOrEqual, @Param("seatMapIdLessThanOrEqual") @jakarta.annotation.Nullable Long seatMapIdLessThanOrEqual, @Param("seatMapIdEquals") @jakarta.annotation.Nullable Long seatMapIdEquals, @Param("seatMapIdNotEquals") @jakarta.annotation.Nullable Long seatMapIdNotEquals, @Param("seatMapIdSpecified") @jakarta.annotation.Nullable Boolean seatMapIdSpecified, @Param("seatMapIdIn") @jakarta.annotation.Nullable List<Long> seatMapIdIn, @Param("seatMapIdNotIn") @jakarta.annotation.Nullable List<Long> seatMapIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllFileRoutes</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllFileRoutesQueryParams} class that allows for
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
   *   <li>bucketContains -  (optional)</li>
   *   <li>bucketDoesNotContain -  (optional)</li>
   *   <li>bucketEquals -  (optional)</li>
   *   <li>bucketNotEquals -  (optional)</li>
   *   <li>bucketSpecified -  (optional)</li>
   *   <li>bucketIn -  (optional)</li>
   *   <li>bucketNotIn -  (optional)</li>
   *   <li>objectKeyContains -  (optional)</li>
   *   <li>objectKeyDoesNotContain -  (optional)</li>
   *   <li>objectKeyEquals -  (optional)</li>
   *   <li>objectKeyNotEquals -  (optional)</li>
   *   <li>objectKeySpecified -  (optional)</li>
   *   <li>objectKeyIn -  (optional)</li>
   *   <li>objectKeyNotIn -  (optional)</li>
   *   <li>contentTypeContains -  (optional)</li>
   *   <li>contentTypeDoesNotContain -  (optional)</li>
   *   <li>contentTypeEquals -  (optional)</li>
   *   <li>contentTypeNotEquals -  (optional)</li>
   *   <li>contentTypeSpecified -  (optional)</li>
   *   <li>contentTypeIn -  (optional)</li>
   *   <li>contentTypeNotIn -  (optional)</li>
   *   <li>sizeGreaterThan -  (optional)</li>
   *   <li>sizeLessThan -  (optional)</li>
   *   <li>sizeGreaterThanOrEqual -  (optional)</li>
   *   <li>sizeLessThanOrEqual -  (optional)</li>
   *   <li>sizeEquals -  (optional)</li>
   *   <li>sizeNotEquals -  (optional)</li>
   *   <li>sizeSpecified -  (optional)</li>
   *   <li>sizeIn -  (optional)</li>
   *   <li>sizeNotIn -  (optional)</li>
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
   *   <li>vehicleIdGreaterThan -  (optional)</li>
   *   <li>vehicleIdLessThan -  (optional)</li>
   *   <li>vehicleIdGreaterThanOrEqual -  (optional)</li>
   *   <li>vehicleIdLessThanOrEqual -  (optional)</li>
   *   <li>vehicleIdEquals -  (optional)</li>
   *   <li>vehicleIdNotEquals -  (optional)</li>
   *   <li>vehicleIdSpecified -  (optional)</li>
   *   <li>vehicleIdIn -  (optional)</li>
   *   <li>vehicleIdNotIn -  (optional)</li>
   *   <li>seatMapIdGreaterThan -  (optional)</li>
   *   <li>seatMapIdLessThan -  (optional)</li>
   *   <li>seatMapIdGreaterThanOrEqual -  (optional)</li>
   *   <li>seatMapIdLessThanOrEqual -  (optional)</li>
   *   <li>seatMapIdEquals -  (optional)</li>
   *   <li>seatMapIdNotEquals -  (optional)</li>
   *   <li>seatMapIdSpecified -  (optional)</li>
   *   <li>seatMapIdIn -  (optional)</li>
   *   <li>seatMapIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return List&lt;FileRouteDTO&gt;
   */
  @RequestLine("GET /api/file-routes?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bucket.contains={bucketContains}&bucket.doesNotContain={bucketDoesNotContain}&bucket.equals={bucketEquals}&bucket.notEquals={bucketNotEquals}&bucket.specified={bucketSpecified}&bucket.in={bucketIn}&bucket.notIn={bucketNotIn}&objectKey.contains={objectKeyContains}&objectKey.doesNotContain={objectKeyDoesNotContain}&objectKey.equals={objectKeyEquals}&objectKey.notEquals={objectKeyNotEquals}&objectKey.specified={objectKeySpecified}&objectKey.in={objectKeyIn}&objectKey.notIn={objectKeyNotIn}&contentType.contains={contentTypeContains}&contentType.doesNotContain={contentTypeDoesNotContain}&contentType.equals={contentTypeEquals}&contentType.notEquals={contentTypeNotEquals}&contentType.specified={contentTypeSpecified}&contentType.in={contentTypeIn}&contentType.notIn={contentTypeNotIn}&size.greaterThan={sizeGreaterThan}&size.lessThan={sizeLessThan}&size.greaterThanOrEqual={sizeGreaterThanOrEqual}&size.lessThanOrEqual={sizeLessThanOrEqual}&size.equals={sizeEquals}&size.notEquals={sizeNotEquals}&size.specified={sizeSpecified}&size.in={sizeIn}&size.notIn={sizeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&stationId.greaterThan={stationIdGreaterThan}&stationId.lessThan={stationIdLessThan}&stationId.greaterThanOrEqual={stationIdGreaterThanOrEqual}&stationId.lessThanOrEqual={stationIdLessThanOrEqual}&stationId.equals={stationIdEquals}&stationId.notEquals={stationIdNotEquals}&stationId.specified={stationIdSpecified}&stationId.in={stationIdIn}&stationId.notIn={stationIdNotIn}&vehicleId.greaterThan={vehicleIdGreaterThan}&vehicleId.lessThan={vehicleIdLessThan}&vehicleId.greaterThanOrEqual={vehicleIdGreaterThanOrEqual}&vehicleId.lessThanOrEqual={vehicleIdLessThanOrEqual}&vehicleId.equals={vehicleIdEquals}&vehicleId.notEquals={vehicleIdNotEquals}&vehicleId.specified={vehicleIdSpecified}&vehicleId.in={vehicleIdIn}&vehicleId.notIn={vehicleIdNotIn}&seatMapId.greaterThan={seatMapIdGreaterThan}&seatMapId.lessThan={seatMapIdLessThan}&seatMapId.greaterThanOrEqual={seatMapIdGreaterThanOrEqual}&seatMapId.lessThanOrEqual={seatMapIdLessThanOrEqual}&seatMapId.equals={seatMapIdEquals}&seatMapId.notEquals={seatMapIdNotEquals}&seatMapId.specified={seatMapIdSpecified}&seatMapId.in={seatMapIdIn}&seatMapId.notIn={seatMapIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  List<FileRouteDTO> getAllFileRoutes(@QueryMap(encoded=true) GetAllFileRoutesQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllFileRoutes</code> that receives the query parameters as a map,
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
          *   <li>bucketContains -  (optional)</li>
          *   <li>bucketDoesNotContain -  (optional)</li>
          *   <li>bucketEquals -  (optional)</li>
          *   <li>bucketNotEquals -  (optional)</li>
          *   <li>bucketSpecified -  (optional)</li>
          *   <li>bucketIn -  (optional)</li>
          *   <li>bucketNotIn -  (optional)</li>
          *   <li>objectKeyContains -  (optional)</li>
          *   <li>objectKeyDoesNotContain -  (optional)</li>
          *   <li>objectKeyEquals -  (optional)</li>
          *   <li>objectKeyNotEquals -  (optional)</li>
          *   <li>objectKeySpecified -  (optional)</li>
          *   <li>objectKeyIn -  (optional)</li>
          *   <li>objectKeyNotIn -  (optional)</li>
          *   <li>contentTypeContains -  (optional)</li>
          *   <li>contentTypeDoesNotContain -  (optional)</li>
          *   <li>contentTypeEquals -  (optional)</li>
          *   <li>contentTypeNotEquals -  (optional)</li>
          *   <li>contentTypeSpecified -  (optional)</li>
          *   <li>contentTypeIn -  (optional)</li>
          *   <li>contentTypeNotIn -  (optional)</li>
          *   <li>sizeGreaterThan -  (optional)</li>
          *   <li>sizeLessThan -  (optional)</li>
          *   <li>sizeGreaterThanOrEqual -  (optional)</li>
          *   <li>sizeLessThanOrEqual -  (optional)</li>
          *   <li>sizeEquals -  (optional)</li>
          *   <li>sizeNotEquals -  (optional)</li>
          *   <li>sizeSpecified -  (optional)</li>
          *   <li>sizeIn -  (optional)</li>
          *   <li>sizeNotIn -  (optional)</li>
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
          *   <li>vehicleIdGreaterThan -  (optional)</li>
          *   <li>vehicleIdLessThan -  (optional)</li>
          *   <li>vehicleIdGreaterThanOrEqual -  (optional)</li>
          *   <li>vehicleIdLessThanOrEqual -  (optional)</li>
          *   <li>vehicleIdEquals -  (optional)</li>
          *   <li>vehicleIdNotEquals -  (optional)</li>
          *   <li>vehicleIdSpecified -  (optional)</li>
          *   <li>vehicleIdIn -  (optional)</li>
          *   <li>vehicleIdNotIn -  (optional)</li>
          *   <li>seatMapIdGreaterThan -  (optional)</li>
          *   <li>seatMapIdLessThan -  (optional)</li>
          *   <li>seatMapIdGreaterThanOrEqual -  (optional)</li>
          *   <li>seatMapIdLessThanOrEqual -  (optional)</li>
          *   <li>seatMapIdEquals -  (optional)</li>
          *   <li>seatMapIdNotEquals -  (optional)</li>
          *   <li>seatMapIdSpecified -  (optional)</li>
          *   <li>seatMapIdIn -  (optional)</li>
          *   <li>seatMapIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return List&lt;FileRouteDTO&gt;
      */
      @RequestLine("GET /api/file-routes?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bucket.contains={bucketContains}&bucket.doesNotContain={bucketDoesNotContain}&bucket.equals={bucketEquals}&bucket.notEquals={bucketNotEquals}&bucket.specified={bucketSpecified}&bucket.in={bucketIn}&bucket.notIn={bucketNotIn}&objectKey.contains={objectKeyContains}&objectKey.doesNotContain={objectKeyDoesNotContain}&objectKey.equals={objectKeyEquals}&objectKey.notEquals={objectKeyNotEquals}&objectKey.specified={objectKeySpecified}&objectKey.in={objectKeyIn}&objectKey.notIn={objectKeyNotIn}&contentType.contains={contentTypeContains}&contentType.doesNotContain={contentTypeDoesNotContain}&contentType.equals={contentTypeEquals}&contentType.notEquals={contentTypeNotEquals}&contentType.specified={contentTypeSpecified}&contentType.in={contentTypeIn}&contentType.notIn={contentTypeNotIn}&size.greaterThan={sizeGreaterThan}&size.lessThan={sizeLessThan}&size.greaterThanOrEqual={sizeGreaterThanOrEqual}&size.lessThanOrEqual={sizeLessThanOrEqual}&size.equals={sizeEquals}&size.notEquals={sizeNotEquals}&size.specified={sizeSpecified}&size.in={sizeIn}&size.notIn={sizeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&stationId.greaterThan={stationIdGreaterThan}&stationId.lessThan={stationIdLessThan}&stationId.greaterThanOrEqual={stationIdGreaterThanOrEqual}&stationId.lessThanOrEqual={stationIdLessThanOrEqual}&stationId.equals={stationIdEquals}&stationId.notEquals={stationIdNotEquals}&stationId.specified={stationIdSpecified}&stationId.in={stationIdIn}&stationId.notIn={stationIdNotIn}&vehicleId.greaterThan={vehicleIdGreaterThan}&vehicleId.lessThan={vehicleIdLessThan}&vehicleId.greaterThanOrEqual={vehicleIdGreaterThanOrEqual}&vehicleId.lessThanOrEqual={vehicleIdLessThanOrEqual}&vehicleId.equals={vehicleIdEquals}&vehicleId.notEquals={vehicleIdNotEquals}&vehicleId.specified={vehicleIdSpecified}&vehicleId.in={vehicleIdIn}&vehicleId.notIn={vehicleIdNotIn}&seatMapId.greaterThan={seatMapIdGreaterThan}&seatMapId.lessThan={seatMapIdLessThan}&seatMapId.greaterThanOrEqual={seatMapIdGreaterThanOrEqual}&seatMapId.lessThanOrEqual={seatMapIdLessThanOrEqual}&seatMapId.equals={seatMapIdEquals}&seatMapId.notEquals={seatMapIdNotEquals}&seatMapId.specified={seatMapIdSpecified}&seatMapId.in={seatMapIdIn}&seatMapId.notIn={seatMapIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<FileRouteDTO>> getAllFileRoutesWithHttpInfo(@QueryMap(encoded=true) GetAllFileRoutesQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllFileRoutes</code> method in a fluent style.
   */
  public static class GetAllFileRoutesQueryParams extends HashMap<String, Object> {
    public GetAllFileRoutesQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileRoutesQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileRoutesQueryParams bucketContains(@jakarta.annotation.Nullable final String value) {
      put("bucket.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams bucketDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("bucket.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams bucketEquals(@jakarta.annotation.Nullable final String value) {
      put("bucket.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams bucketNotEquals(@jakarta.annotation.Nullable final String value) {
      put("bucket.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams bucketSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("bucket.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams bucketIn(@jakarta.annotation.Nullable final List<String> value) {
      put("bucket.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileRoutesQueryParams bucketNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("bucket.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileRoutesQueryParams objectKeyContains(@jakarta.annotation.Nullable final String value) {
      put("objectKey.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams objectKeyDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("objectKey.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams objectKeyEquals(@jakarta.annotation.Nullable final String value) {
      put("objectKey.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams objectKeyNotEquals(@jakarta.annotation.Nullable final String value) {
      put("objectKey.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams objectKeySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("objectKey.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams objectKeyIn(@jakarta.annotation.Nullable final List<String> value) {
      put("objectKey.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileRoutesQueryParams objectKeyNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("objectKey.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileRoutesQueryParams contentTypeContains(@jakarta.annotation.Nullable final String value) {
      put("contentType.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams contentTypeDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("contentType.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams contentTypeEquals(@jakarta.annotation.Nullable final String value) {
      put("contentType.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams contentTypeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("contentType.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams contentTypeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("contentType.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams contentTypeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("contentType.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileRoutesQueryParams contentTypeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("contentType.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileRoutesQueryParams sizeGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("size.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams sizeLessThan(@jakarta.annotation.Nullable final Long value) {
      put("size.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams sizeGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("size.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams sizeLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("size.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams sizeEquals(@jakarta.annotation.Nullable final Long value) {
      put("size.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams sizeNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("size.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams sizeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("size.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams sizeIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("size.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileRoutesQueryParams sizeNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("size.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileRoutesQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileRoutesQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileRoutesQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileRoutesQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileRoutesQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileRoutesQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileRoutesQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileRoutesQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileRoutesQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileRoutesQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileRoutesQueryParams stationIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("stationId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams stationIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("stationId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams stationIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("stationId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams stationIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("stationId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams stationIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("stationId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams stationIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("stationId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams stationIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("stationId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams stationIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("stationId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileRoutesQueryParams stationIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("stationId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileRoutesQueryParams vehicleIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("vehicleId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams vehicleIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("vehicleId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams vehicleIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("vehicleId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams vehicleIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("vehicleId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams vehicleIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("vehicleId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams vehicleIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("vehicleId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams vehicleIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("vehicleId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams vehicleIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("vehicleId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileRoutesQueryParams vehicleIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("vehicleId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileRoutesQueryParams seatMapIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams seatMapIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams seatMapIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams seatMapIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams seatMapIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams seatMapIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("seatMapId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams seatMapIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("seatMapId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileRoutesQueryParams seatMapIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("seatMapId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileRoutesQueryParams seatMapIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("seatMapId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileRoutesQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @return FileRouteDTO
   */
  @RequestLine("GET /api/file-routes/{id}")
  @Headers({
    "Accept: */*",
  })
  FileRouteDTO getFileRoute(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>getFileRoute</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/file-routes/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<FileRouteDTO> getFileRouteWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param id  (required)
   * @param fileRouteDTO  (required)
   * @return FileRouteDTO
   */
  @RequestLine("PATCH /api/file-routes/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  FileRouteDTO partialUpdateFileRoute(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull FileRouteDTO fileRouteDTO);

  /**
   * 
   * Similar to <code>partialUpdateFileRoute</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param fileRouteDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /api/file-routes/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<FileRouteDTO> partialUpdateFileRouteWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull FileRouteDTO fileRouteDTO);



  /**
   * 
   * 
   * @param id  (required)
   * @param fileRouteDTO  (required)
   * @return FileRouteDTO
   */
  @RequestLine("PUT /api/file-routes/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  FileRouteDTO updateFileRoute(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull FileRouteDTO fileRouteDTO);

  /**
   * 
   * Similar to <code>updateFileRoute</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param fileRouteDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/file-routes/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<FileRouteDTO> updateFileRouteWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull FileRouteDTO fileRouteDTO);


}
