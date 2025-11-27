package com.ridehub.msuser.client.api;

import com.ridehub.msuser.client.invoker.ApiClient;
import com.ridehub.msuser.client.invoker.EncodingUtils;
import com.ridehub.msuser.client.model.ApiResponse;

import com.ridehub.msuser.client.model.FileUserDTO;
import java.time.OffsetDateTime;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface FileUserResourceMsuserApi extends ApiClient.Api {


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
   * @param profileIdGreaterThan  (optional)
   * @param profileIdLessThan  (optional)
   * @param profileIdGreaterThanOrEqual  (optional)
   * @param profileIdLessThanOrEqual  (optional)
   * @param profileIdEquals  (optional)
   * @param profileIdNotEquals  (optional)
   * @param profileIdSpecified  (optional)
   * @param profileIdIn  (optional)
   * @param profileIdNotIn  (optional)
   * @param distinct  (optional)
   * @return Long
   */
  @RequestLine("GET /api/file-users/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bucket.contains={bucketContains}&bucket.doesNotContain={bucketDoesNotContain}&bucket.equals={bucketEquals}&bucket.notEquals={bucketNotEquals}&bucket.specified={bucketSpecified}&bucket.in={bucketIn}&bucket.notIn={bucketNotIn}&objectKey.contains={objectKeyContains}&objectKey.doesNotContain={objectKeyDoesNotContain}&objectKey.equals={objectKeyEquals}&objectKey.notEquals={objectKeyNotEquals}&objectKey.specified={objectKeySpecified}&objectKey.in={objectKeyIn}&objectKey.notIn={objectKeyNotIn}&contentType.contains={contentTypeContains}&contentType.doesNotContain={contentTypeDoesNotContain}&contentType.equals={contentTypeEquals}&contentType.notEquals={contentTypeNotEquals}&contentType.specified={contentTypeSpecified}&contentType.in={contentTypeIn}&contentType.notIn={contentTypeNotIn}&size.greaterThan={sizeGreaterThan}&size.lessThan={sizeLessThan}&size.greaterThanOrEqual={sizeGreaterThanOrEqual}&size.lessThanOrEqual={sizeLessThanOrEqual}&size.equals={sizeEquals}&size.notEquals={sizeNotEquals}&size.specified={sizeSpecified}&size.in={sizeIn}&size.notIn={sizeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&profileId.greaterThan={profileIdGreaterThan}&profileId.lessThan={profileIdLessThan}&profileId.greaterThanOrEqual={profileIdGreaterThanOrEqual}&profileId.lessThanOrEqual={profileIdLessThanOrEqual}&profileId.equals={profileIdEquals}&profileId.notEquals={profileIdNotEquals}&profileId.specified={profileIdSpecified}&profileId.in={profileIdIn}&profileId.notIn={profileIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  Long countFileUsers(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("bucketContains") @jakarta.annotation.Nullable String bucketContains, @Param("bucketDoesNotContain") @jakarta.annotation.Nullable String bucketDoesNotContain, @Param("bucketEquals") @jakarta.annotation.Nullable String bucketEquals, @Param("bucketNotEquals") @jakarta.annotation.Nullable String bucketNotEquals, @Param("bucketSpecified") @jakarta.annotation.Nullable Boolean bucketSpecified, @Param("bucketIn") @jakarta.annotation.Nullable List<String> bucketIn, @Param("bucketNotIn") @jakarta.annotation.Nullable List<String> bucketNotIn, @Param("objectKeyContains") @jakarta.annotation.Nullable String objectKeyContains, @Param("objectKeyDoesNotContain") @jakarta.annotation.Nullable String objectKeyDoesNotContain, @Param("objectKeyEquals") @jakarta.annotation.Nullable String objectKeyEquals, @Param("objectKeyNotEquals") @jakarta.annotation.Nullable String objectKeyNotEquals, @Param("objectKeySpecified") @jakarta.annotation.Nullable Boolean objectKeySpecified, @Param("objectKeyIn") @jakarta.annotation.Nullable List<String> objectKeyIn, @Param("objectKeyNotIn") @jakarta.annotation.Nullable List<String> objectKeyNotIn, @Param("contentTypeContains") @jakarta.annotation.Nullable String contentTypeContains, @Param("contentTypeDoesNotContain") @jakarta.annotation.Nullable String contentTypeDoesNotContain, @Param("contentTypeEquals") @jakarta.annotation.Nullable String contentTypeEquals, @Param("contentTypeNotEquals") @jakarta.annotation.Nullable String contentTypeNotEquals, @Param("contentTypeSpecified") @jakarta.annotation.Nullable Boolean contentTypeSpecified, @Param("contentTypeIn") @jakarta.annotation.Nullable List<String> contentTypeIn, @Param("contentTypeNotIn") @jakarta.annotation.Nullable List<String> contentTypeNotIn, @Param("sizeGreaterThan") @jakarta.annotation.Nullable Long sizeGreaterThan, @Param("sizeLessThan") @jakarta.annotation.Nullable Long sizeLessThan, @Param("sizeGreaterThanOrEqual") @jakarta.annotation.Nullable Long sizeGreaterThanOrEqual, @Param("sizeLessThanOrEqual") @jakarta.annotation.Nullable Long sizeLessThanOrEqual, @Param("sizeEquals") @jakarta.annotation.Nullable Long sizeEquals, @Param("sizeNotEquals") @jakarta.annotation.Nullable Long sizeNotEquals, @Param("sizeSpecified") @jakarta.annotation.Nullable Boolean sizeSpecified, @Param("sizeIn") @jakarta.annotation.Nullable List<Long> sizeIn, @Param("sizeNotIn") @jakarta.annotation.Nullable List<Long> sizeNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("profileIdGreaterThan") @jakarta.annotation.Nullable Long profileIdGreaterThan, @Param("profileIdLessThan") @jakarta.annotation.Nullable Long profileIdLessThan, @Param("profileIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long profileIdGreaterThanOrEqual, @Param("profileIdLessThanOrEqual") @jakarta.annotation.Nullable Long profileIdLessThanOrEqual, @Param("profileIdEquals") @jakarta.annotation.Nullable Long profileIdEquals, @Param("profileIdNotEquals") @jakarta.annotation.Nullable Long profileIdNotEquals, @Param("profileIdSpecified") @jakarta.annotation.Nullable Boolean profileIdSpecified, @Param("profileIdIn") @jakarta.annotation.Nullable List<Long> profileIdIn, @Param("profileIdNotIn") @jakarta.annotation.Nullable List<Long> profileIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>countFileUsers</code> but it also returns the http response headers .
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
   * @param profileIdGreaterThan  (optional)
   * @param profileIdLessThan  (optional)
   * @param profileIdGreaterThanOrEqual  (optional)
   * @param profileIdLessThanOrEqual  (optional)
   * @param profileIdEquals  (optional)
   * @param profileIdNotEquals  (optional)
   * @param profileIdSpecified  (optional)
   * @param profileIdIn  (optional)
   * @param profileIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/file-users/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bucket.contains={bucketContains}&bucket.doesNotContain={bucketDoesNotContain}&bucket.equals={bucketEquals}&bucket.notEquals={bucketNotEquals}&bucket.specified={bucketSpecified}&bucket.in={bucketIn}&bucket.notIn={bucketNotIn}&objectKey.contains={objectKeyContains}&objectKey.doesNotContain={objectKeyDoesNotContain}&objectKey.equals={objectKeyEquals}&objectKey.notEquals={objectKeyNotEquals}&objectKey.specified={objectKeySpecified}&objectKey.in={objectKeyIn}&objectKey.notIn={objectKeyNotIn}&contentType.contains={contentTypeContains}&contentType.doesNotContain={contentTypeDoesNotContain}&contentType.equals={contentTypeEquals}&contentType.notEquals={contentTypeNotEquals}&contentType.specified={contentTypeSpecified}&contentType.in={contentTypeIn}&contentType.notIn={contentTypeNotIn}&size.greaterThan={sizeGreaterThan}&size.lessThan={sizeLessThan}&size.greaterThanOrEqual={sizeGreaterThanOrEqual}&size.lessThanOrEqual={sizeLessThanOrEqual}&size.equals={sizeEquals}&size.notEquals={sizeNotEquals}&size.specified={sizeSpecified}&size.in={sizeIn}&size.notIn={sizeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&profileId.greaterThan={profileIdGreaterThan}&profileId.lessThan={profileIdLessThan}&profileId.greaterThanOrEqual={profileIdGreaterThanOrEqual}&profileId.lessThanOrEqual={profileIdLessThanOrEqual}&profileId.equals={profileIdEquals}&profileId.notEquals={profileIdNotEquals}&profileId.specified={profileIdSpecified}&profileId.in={profileIdIn}&profileId.notIn={profileIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Long> countFileUsersWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("bucketContains") @jakarta.annotation.Nullable String bucketContains, @Param("bucketDoesNotContain") @jakarta.annotation.Nullable String bucketDoesNotContain, @Param("bucketEquals") @jakarta.annotation.Nullable String bucketEquals, @Param("bucketNotEquals") @jakarta.annotation.Nullable String bucketNotEquals, @Param("bucketSpecified") @jakarta.annotation.Nullable Boolean bucketSpecified, @Param("bucketIn") @jakarta.annotation.Nullable List<String> bucketIn, @Param("bucketNotIn") @jakarta.annotation.Nullable List<String> bucketNotIn, @Param("objectKeyContains") @jakarta.annotation.Nullable String objectKeyContains, @Param("objectKeyDoesNotContain") @jakarta.annotation.Nullable String objectKeyDoesNotContain, @Param("objectKeyEquals") @jakarta.annotation.Nullable String objectKeyEquals, @Param("objectKeyNotEquals") @jakarta.annotation.Nullable String objectKeyNotEquals, @Param("objectKeySpecified") @jakarta.annotation.Nullable Boolean objectKeySpecified, @Param("objectKeyIn") @jakarta.annotation.Nullable List<String> objectKeyIn, @Param("objectKeyNotIn") @jakarta.annotation.Nullable List<String> objectKeyNotIn, @Param("contentTypeContains") @jakarta.annotation.Nullable String contentTypeContains, @Param("contentTypeDoesNotContain") @jakarta.annotation.Nullable String contentTypeDoesNotContain, @Param("contentTypeEquals") @jakarta.annotation.Nullable String contentTypeEquals, @Param("contentTypeNotEquals") @jakarta.annotation.Nullable String contentTypeNotEquals, @Param("contentTypeSpecified") @jakarta.annotation.Nullable Boolean contentTypeSpecified, @Param("contentTypeIn") @jakarta.annotation.Nullable List<String> contentTypeIn, @Param("contentTypeNotIn") @jakarta.annotation.Nullable List<String> contentTypeNotIn, @Param("sizeGreaterThan") @jakarta.annotation.Nullable Long sizeGreaterThan, @Param("sizeLessThan") @jakarta.annotation.Nullable Long sizeLessThan, @Param("sizeGreaterThanOrEqual") @jakarta.annotation.Nullable Long sizeGreaterThanOrEqual, @Param("sizeLessThanOrEqual") @jakarta.annotation.Nullable Long sizeLessThanOrEqual, @Param("sizeEquals") @jakarta.annotation.Nullable Long sizeEquals, @Param("sizeNotEquals") @jakarta.annotation.Nullable Long sizeNotEquals, @Param("sizeSpecified") @jakarta.annotation.Nullable Boolean sizeSpecified, @Param("sizeIn") @jakarta.annotation.Nullable List<Long> sizeIn, @Param("sizeNotIn") @jakarta.annotation.Nullable List<Long> sizeNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("profileIdGreaterThan") @jakarta.annotation.Nullable Long profileIdGreaterThan, @Param("profileIdLessThan") @jakarta.annotation.Nullable Long profileIdLessThan, @Param("profileIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long profileIdGreaterThanOrEqual, @Param("profileIdLessThanOrEqual") @jakarta.annotation.Nullable Long profileIdLessThanOrEqual, @Param("profileIdEquals") @jakarta.annotation.Nullable Long profileIdEquals, @Param("profileIdNotEquals") @jakarta.annotation.Nullable Long profileIdNotEquals, @Param("profileIdSpecified") @jakarta.annotation.Nullable Boolean profileIdSpecified, @Param("profileIdIn") @jakarta.annotation.Nullable List<Long> profileIdIn, @Param("profileIdNotIn") @jakarta.annotation.Nullable List<Long> profileIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>countFileUsers</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CountFileUsersQueryParams} class that allows for
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
   *   <li>profileIdGreaterThan -  (optional)</li>
   *   <li>profileIdLessThan -  (optional)</li>
   *   <li>profileIdGreaterThanOrEqual -  (optional)</li>
   *   <li>profileIdLessThanOrEqual -  (optional)</li>
   *   <li>profileIdEquals -  (optional)</li>
   *   <li>profileIdNotEquals -  (optional)</li>
   *   <li>profileIdSpecified -  (optional)</li>
   *   <li>profileIdIn -  (optional)</li>
   *   <li>profileIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return Long
   */
  @RequestLine("GET /api/file-users/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bucket.contains={bucketContains}&bucket.doesNotContain={bucketDoesNotContain}&bucket.equals={bucketEquals}&bucket.notEquals={bucketNotEquals}&bucket.specified={bucketSpecified}&bucket.in={bucketIn}&bucket.notIn={bucketNotIn}&objectKey.contains={objectKeyContains}&objectKey.doesNotContain={objectKeyDoesNotContain}&objectKey.equals={objectKeyEquals}&objectKey.notEquals={objectKeyNotEquals}&objectKey.specified={objectKeySpecified}&objectKey.in={objectKeyIn}&objectKey.notIn={objectKeyNotIn}&contentType.contains={contentTypeContains}&contentType.doesNotContain={contentTypeDoesNotContain}&contentType.equals={contentTypeEquals}&contentType.notEquals={contentTypeNotEquals}&contentType.specified={contentTypeSpecified}&contentType.in={contentTypeIn}&contentType.notIn={contentTypeNotIn}&size.greaterThan={sizeGreaterThan}&size.lessThan={sizeLessThan}&size.greaterThanOrEqual={sizeGreaterThanOrEqual}&size.lessThanOrEqual={sizeLessThanOrEqual}&size.equals={sizeEquals}&size.notEquals={sizeNotEquals}&size.specified={sizeSpecified}&size.in={sizeIn}&size.notIn={sizeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&profileId.greaterThan={profileIdGreaterThan}&profileId.lessThan={profileIdLessThan}&profileId.greaterThanOrEqual={profileIdGreaterThanOrEqual}&profileId.lessThanOrEqual={profileIdLessThanOrEqual}&profileId.equals={profileIdEquals}&profileId.notEquals={profileIdNotEquals}&profileId.specified={profileIdSpecified}&profileId.in={profileIdIn}&profileId.notIn={profileIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  Long countFileUsers(@QueryMap(encoded=true) CountFileUsersQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>countFileUsers</code> that receives the query parameters as a map,
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
          *   <li>profileIdGreaterThan -  (optional)</li>
          *   <li>profileIdLessThan -  (optional)</li>
          *   <li>profileIdGreaterThanOrEqual -  (optional)</li>
          *   <li>profileIdLessThanOrEqual -  (optional)</li>
          *   <li>profileIdEquals -  (optional)</li>
          *   <li>profileIdNotEquals -  (optional)</li>
          *   <li>profileIdSpecified -  (optional)</li>
          *   <li>profileIdIn -  (optional)</li>
          *   <li>profileIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return Long
      */
      @RequestLine("GET /api/file-users/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bucket.contains={bucketContains}&bucket.doesNotContain={bucketDoesNotContain}&bucket.equals={bucketEquals}&bucket.notEquals={bucketNotEquals}&bucket.specified={bucketSpecified}&bucket.in={bucketIn}&bucket.notIn={bucketNotIn}&objectKey.contains={objectKeyContains}&objectKey.doesNotContain={objectKeyDoesNotContain}&objectKey.equals={objectKeyEquals}&objectKey.notEquals={objectKeyNotEquals}&objectKey.specified={objectKeySpecified}&objectKey.in={objectKeyIn}&objectKey.notIn={objectKeyNotIn}&contentType.contains={contentTypeContains}&contentType.doesNotContain={contentTypeDoesNotContain}&contentType.equals={contentTypeEquals}&contentType.notEquals={contentTypeNotEquals}&contentType.specified={contentTypeSpecified}&contentType.in={contentTypeIn}&contentType.notIn={contentTypeNotIn}&size.greaterThan={sizeGreaterThan}&size.lessThan={sizeLessThan}&size.greaterThanOrEqual={sizeGreaterThanOrEqual}&size.lessThanOrEqual={sizeLessThanOrEqual}&size.equals={sizeEquals}&size.notEquals={sizeNotEquals}&size.specified={sizeSpecified}&size.in={sizeIn}&size.notIn={sizeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&profileId.greaterThan={profileIdGreaterThan}&profileId.lessThan={profileIdLessThan}&profileId.greaterThanOrEqual={profileIdGreaterThanOrEqual}&profileId.lessThanOrEqual={profileIdLessThanOrEqual}&profileId.equals={profileIdEquals}&profileId.notEquals={profileIdNotEquals}&profileId.specified={profileIdSpecified}&profileId.in={profileIdIn}&profileId.notIn={profileIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Long> countFileUsersWithHttpInfo(@QueryMap(encoded=true) CountFileUsersQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>countFileUsers</code> method in a fluent style.
   */
  public static class CountFileUsersQueryParams extends HashMap<String, Object> {
    public CountFileUsersQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileUsersQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileUsersQueryParams bucketContains(@jakarta.annotation.Nullable final String value) {
      put("bucket.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams bucketDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("bucket.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams bucketEquals(@jakarta.annotation.Nullable final String value) {
      put("bucket.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams bucketNotEquals(@jakarta.annotation.Nullable final String value) {
      put("bucket.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams bucketSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("bucket.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams bucketIn(@jakarta.annotation.Nullable final List<String> value) {
      put("bucket.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileUsersQueryParams bucketNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("bucket.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileUsersQueryParams objectKeyContains(@jakarta.annotation.Nullable final String value) {
      put("objectKey.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams objectKeyDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("objectKey.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams objectKeyEquals(@jakarta.annotation.Nullable final String value) {
      put("objectKey.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams objectKeyNotEquals(@jakarta.annotation.Nullable final String value) {
      put("objectKey.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams objectKeySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("objectKey.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams objectKeyIn(@jakarta.annotation.Nullable final List<String> value) {
      put("objectKey.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileUsersQueryParams objectKeyNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("objectKey.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileUsersQueryParams contentTypeContains(@jakarta.annotation.Nullable final String value) {
      put("contentType.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams contentTypeDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("contentType.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams contentTypeEquals(@jakarta.annotation.Nullable final String value) {
      put("contentType.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams contentTypeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("contentType.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams contentTypeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("contentType.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams contentTypeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("contentType.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileUsersQueryParams contentTypeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("contentType.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileUsersQueryParams sizeGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("size.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams sizeLessThan(@jakarta.annotation.Nullable final Long value) {
      put("size.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams sizeGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("size.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams sizeLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("size.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams sizeEquals(@jakarta.annotation.Nullable final Long value) {
      put("size.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams sizeNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("size.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams sizeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("size.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams sizeIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("size.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileUsersQueryParams sizeNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("size.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileUsersQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileUsersQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileUsersQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileUsersQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileUsersQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileUsersQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileUsersQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileUsersQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileUsersQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileUsersQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileUsersQueryParams profileIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("profileId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams profileIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("profileId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams profileIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("profileId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams profileIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("profileId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams profileIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("profileId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams profileIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("profileId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams profileIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("profileId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFileUsersQueryParams profileIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("profileId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileUsersQueryParams profileIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("profileId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFileUsersQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param fileUserDTO  (required)
   * @return FileUserDTO
   */
  @RequestLine("POST /api/file-users")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  FileUserDTO createFileUser(@jakarta.annotation.Nonnull FileUserDTO fileUserDTO);

  /**
   * 
   * Similar to <code>createFileUser</code> but it also returns the http response headers .
   * 
   * @param fileUserDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/file-users")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<FileUserDTO> createFileUserWithHttpInfo(@jakarta.annotation.Nonnull FileUserDTO fileUserDTO);



  /**
   * 
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/file-users/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteFileUser(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>deleteFileUser</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/file-users/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteFileUserWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



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
   * @param profileIdGreaterThan  (optional)
   * @param profileIdLessThan  (optional)
   * @param profileIdGreaterThanOrEqual  (optional)
   * @param profileIdLessThanOrEqual  (optional)
   * @param profileIdEquals  (optional)
   * @param profileIdNotEquals  (optional)
   * @param profileIdSpecified  (optional)
   * @param profileIdIn  (optional)
   * @param profileIdNotIn  (optional)
   * @param distinct  (optional)
   * @return List&lt;FileUserDTO&gt;
   */
  @RequestLine("GET /api/file-users?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bucket.contains={bucketContains}&bucket.doesNotContain={bucketDoesNotContain}&bucket.equals={bucketEquals}&bucket.notEquals={bucketNotEquals}&bucket.specified={bucketSpecified}&bucket.in={bucketIn}&bucket.notIn={bucketNotIn}&objectKey.contains={objectKeyContains}&objectKey.doesNotContain={objectKeyDoesNotContain}&objectKey.equals={objectKeyEquals}&objectKey.notEquals={objectKeyNotEquals}&objectKey.specified={objectKeySpecified}&objectKey.in={objectKeyIn}&objectKey.notIn={objectKeyNotIn}&contentType.contains={contentTypeContains}&contentType.doesNotContain={contentTypeDoesNotContain}&contentType.equals={contentTypeEquals}&contentType.notEquals={contentTypeNotEquals}&contentType.specified={contentTypeSpecified}&contentType.in={contentTypeIn}&contentType.notIn={contentTypeNotIn}&size.greaterThan={sizeGreaterThan}&size.lessThan={sizeLessThan}&size.greaterThanOrEqual={sizeGreaterThanOrEqual}&size.lessThanOrEqual={sizeLessThanOrEqual}&size.equals={sizeEquals}&size.notEquals={sizeNotEquals}&size.specified={sizeSpecified}&size.in={sizeIn}&size.notIn={sizeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&profileId.greaterThan={profileIdGreaterThan}&profileId.lessThan={profileIdLessThan}&profileId.greaterThanOrEqual={profileIdGreaterThanOrEqual}&profileId.lessThanOrEqual={profileIdLessThanOrEqual}&profileId.equals={profileIdEquals}&profileId.notEquals={profileIdNotEquals}&profileId.specified={profileIdSpecified}&profileId.in={profileIdIn}&profileId.notIn={profileIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  List<FileUserDTO> getAllFileUsers(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("bucketContains") @jakarta.annotation.Nullable String bucketContains, @Param("bucketDoesNotContain") @jakarta.annotation.Nullable String bucketDoesNotContain, @Param("bucketEquals") @jakarta.annotation.Nullable String bucketEquals, @Param("bucketNotEquals") @jakarta.annotation.Nullable String bucketNotEquals, @Param("bucketSpecified") @jakarta.annotation.Nullable Boolean bucketSpecified, @Param("bucketIn") @jakarta.annotation.Nullable List<String> bucketIn, @Param("bucketNotIn") @jakarta.annotation.Nullable List<String> bucketNotIn, @Param("objectKeyContains") @jakarta.annotation.Nullable String objectKeyContains, @Param("objectKeyDoesNotContain") @jakarta.annotation.Nullable String objectKeyDoesNotContain, @Param("objectKeyEquals") @jakarta.annotation.Nullable String objectKeyEquals, @Param("objectKeyNotEquals") @jakarta.annotation.Nullable String objectKeyNotEquals, @Param("objectKeySpecified") @jakarta.annotation.Nullable Boolean objectKeySpecified, @Param("objectKeyIn") @jakarta.annotation.Nullable List<String> objectKeyIn, @Param("objectKeyNotIn") @jakarta.annotation.Nullable List<String> objectKeyNotIn, @Param("contentTypeContains") @jakarta.annotation.Nullable String contentTypeContains, @Param("contentTypeDoesNotContain") @jakarta.annotation.Nullable String contentTypeDoesNotContain, @Param("contentTypeEquals") @jakarta.annotation.Nullable String contentTypeEquals, @Param("contentTypeNotEquals") @jakarta.annotation.Nullable String contentTypeNotEquals, @Param("contentTypeSpecified") @jakarta.annotation.Nullable Boolean contentTypeSpecified, @Param("contentTypeIn") @jakarta.annotation.Nullable List<String> contentTypeIn, @Param("contentTypeNotIn") @jakarta.annotation.Nullable List<String> contentTypeNotIn, @Param("sizeGreaterThan") @jakarta.annotation.Nullable Long sizeGreaterThan, @Param("sizeLessThan") @jakarta.annotation.Nullable Long sizeLessThan, @Param("sizeGreaterThanOrEqual") @jakarta.annotation.Nullable Long sizeGreaterThanOrEqual, @Param("sizeLessThanOrEqual") @jakarta.annotation.Nullable Long sizeLessThanOrEqual, @Param("sizeEquals") @jakarta.annotation.Nullable Long sizeEquals, @Param("sizeNotEquals") @jakarta.annotation.Nullable Long sizeNotEquals, @Param("sizeSpecified") @jakarta.annotation.Nullable Boolean sizeSpecified, @Param("sizeIn") @jakarta.annotation.Nullable List<Long> sizeIn, @Param("sizeNotIn") @jakarta.annotation.Nullable List<Long> sizeNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("profileIdGreaterThan") @jakarta.annotation.Nullable Long profileIdGreaterThan, @Param("profileIdLessThan") @jakarta.annotation.Nullable Long profileIdLessThan, @Param("profileIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long profileIdGreaterThanOrEqual, @Param("profileIdLessThanOrEqual") @jakarta.annotation.Nullable Long profileIdLessThanOrEqual, @Param("profileIdEquals") @jakarta.annotation.Nullable Long profileIdEquals, @Param("profileIdNotEquals") @jakarta.annotation.Nullable Long profileIdNotEquals, @Param("profileIdSpecified") @jakarta.annotation.Nullable Boolean profileIdSpecified, @Param("profileIdIn") @jakarta.annotation.Nullable List<Long> profileIdIn, @Param("profileIdNotIn") @jakarta.annotation.Nullable List<Long> profileIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>getAllFileUsers</code> but it also returns the http response headers .
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
   * @param profileIdGreaterThan  (optional)
   * @param profileIdLessThan  (optional)
   * @param profileIdGreaterThanOrEqual  (optional)
   * @param profileIdLessThanOrEqual  (optional)
   * @param profileIdEquals  (optional)
   * @param profileIdNotEquals  (optional)
   * @param profileIdSpecified  (optional)
   * @param profileIdIn  (optional)
   * @param profileIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/file-users?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bucket.contains={bucketContains}&bucket.doesNotContain={bucketDoesNotContain}&bucket.equals={bucketEquals}&bucket.notEquals={bucketNotEquals}&bucket.specified={bucketSpecified}&bucket.in={bucketIn}&bucket.notIn={bucketNotIn}&objectKey.contains={objectKeyContains}&objectKey.doesNotContain={objectKeyDoesNotContain}&objectKey.equals={objectKeyEquals}&objectKey.notEquals={objectKeyNotEquals}&objectKey.specified={objectKeySpecified}&objectKey.in={objectKeyIn}&objectKey.notIn={objectKeyNotIn}&contentType.contains={contentTypeContains}&contentType.doesNotContain={contentTypeDoesNotContain}&contentType.equals={contentTypeEquals}&contentType.notEquals={contentTypeNotEquals}&contentType.specified={contentTypeSpecified}&contentType.in={contentTypeIn}&contentType.notIn={contentTypeNotIn}&size.greaterThan={sizeGreaterThan}&size.lessThan={sizeLessThan}&size.greaterThanOrEqual={sizeGreaterThanOrEqual}&size.lessThanOrEqual={sizeLessThanOrEqual}&size.equals={sizeEquals}&size.notEquals={sizeNotEquals}&size.specified={sizeSpecified}&size.in={sizeIn}&size.notIn={sizeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&profileId.greaterThan={profileIdGreaterThan}&profileId.lessThan={profileIdLessThan}&profileId.greaterThanOrEqual={profileIdGreaterThanOrEqual}&profileId.lessThanOrEqual={profileIdLessThanOrEqual}&profileId.equals={profileIdEquals}&profileId.notEquals={profileIdNotEquals}&profileId.specified={profileIdSpecified}&profileId.in={profileIdIn}&profileId.notIn={profileIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<FileUserDTO>> getAllFileUsersWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("bucketContains") @jakarta.annotation.Nullable String bucketContains, @Param("bucketDoesNotContain") @jakarta.annotation.Nullable String bucketDoesNotContain, @Param("bucketEquals") @jakarta.annotation.Nullable String bucketEquals, @Param("bucketNotEquals") @jakarta.annotation.Nullable String bucketNotEquals, @Param("bucketSpecified") @jakarta.annotation.Nullable Boolean bucketSpecified, @Param("bucketIn") @jakarta.annotation.Nullable List<String> bucketIn, @Param("bucketNotIn") @jakarta.annotation.Nullable List<String> bucketNotIn, @Param("objectKeyContains") @jakarta.annotation.Nullable String objectKeyContains, @Param("objectKeyDoesNotContain") @jakarta.annotation.Nullable String objectKeyDoesNotContain, @Param("objectKeyEquals") @jakarta.annotation.Nullable String objectKeyEquals, @Param("objectKeyNotEquals") @jakarta.annotation.Nullable String objectKeyNotEquals, @Param("objectKeySpecified") @jakarta.annotation.Nullable Boolean objectKeySpecified, @Param("objectKeyIn") @jakarta.annotation.Nullable List<String> objectKeyIn, @Param("objectKeyNotIn") @jakarta.annotation.Nullable List<String> objectKeyNotIn, @Param("contentTypeContains") @jakarta.annotation.Nullable String contentTypeContains, @Param("contentTypeDoesNotContain") @jakarta.annotation.Nullable String contentTypeDoesNotContain, @Param("contentTypeEquals") @jakarta.annotation.Nullable String contentTypeEquals, @Param("contentTypeNotEquals") @jakarta.annotation.Nullable String contentTypeNotEquals, @Param("contentTypeSpecified") @jakarta.annotation.Nullable Boolean contentTypeSpecified, @Param("contentTypeIn") @jakarta.annotation.Nullable List<String> contentTypeIn, @Param("contentTypeNotIn") @jakarta.annotation.Nullable List<String> contentTypeNotIn, @Param("sizeGreaterThan") @jakarta.annotation.Nullable Long sizeGreaterThan, @Param("sizeLessThan") @jakarta.annotation.Nullable Long sizeLessThan, @Param("sizeGreaterThanOrEqual") @jakarta.annotation.Nullable Long sizeGreaterThanOrEqual, @Param("sizeLessThanOrEqual") @jakarta.annotation.Nullable Long sizeLessThanOrEqual, @Param("sizeEquals") @jakarta.annotation.Nullable Long sizeEquals, @Param("sizeNotEquals") @jakarta.annotation.Nullable Long sizeNotEquals, @Param("sizeSpecified") @jakarta.annotation.Nullable Boolean sizeSpecified, @Param("sizeIn") @jakarta.annotation.Nullable List<Long> sizeIn, @Param("sizeNotIn") @jakarta.annotation.Nullable List<Long> sizeNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("profileIdGreaterThan") @jakarta.annotation.Nullable Long profileIdGreaterThan, @Param("profileIdLessThan") @jakarta.annotation.Nullable Long profileIdLessThan, @Param("profileIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long profileIdGreaterThanOrEqual, @Param("profileIdLessThanOrEqual") @jakarta.annotation.Nullable Long profileIdLessThanOrEqual, @Param("profileIdEquals") @jakarta.annotation.Nullable Long profileIdEquals, @Param("profileIdNotEquals") @jakarta.annotation.Nullable Long profileIdNotEquals, @Param("profileIdSpecified") @jakarta.annotation.Nullable Boolean profileIdSpecified, @Param("profileIdIn") @jakarta.annotation.Nullable List<Long> profileIdIn, @Param("profileIdNotIn") @jakarta.annotation.Nullable List<Long> profileIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllFileUsers</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllFileUsersQueryParams} class that allows for
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
   *   <li>profileIdGreaterThan -  (optional)</li>
   *   <li>profileIdLessThan -  (optional)</li>
   *   <li>profileIdGreaterThanOrEqual -  (optional)</li>
   *   <li>profileIdLessThanOrEqual -  (optional)</li>
   *   <li>profileIdEquals -  (optional)</li>
   *   <li>profileIdNotEquals -  (optional)</li>
   *   <li>profileIdSpecified -  (optional)</li>
   *   <li>profileIdIn -  (optional)</li>
   *   <li>profileIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return List&lt;FileUserDTO&gt;
   */
  @RequestLine("GET /api/file-users?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bucket.contains={bucketContains}&bucket.doesNotContain={bucketDoesNotContain}&bucket.equals={bucketEquals}&bucket.notEquals={bucketNotEquals}&bucket.specified={bucketSpecified}&bucket.in={bucketIn}&bucket.notIn={bucketNotIn}&objectKey.contains={objectKeyContains}&objectKey.doesNotContain={objectKeyDoesNotContain}&objectKey.equals={objectKeyEquals}&objectKey.notEquals={objectKeyNotEquals}&objectKey.specified={objectKeySpecified}&objectKey.in={objectKeyIn}&objectKey.notIn={objectKeyNotIn}&contentType.contains={contentTypeContains}&contentType.doesNotContain={contentTypeDoesNotContain}&contentType.equals={contentTypeEquals}&contentType.notEquals={contentTypeNotEquals}&contentType.specified={contentTypeSpecified}&contentType.in={contentTypeIn}&contentType.notIn={contentTypeNotIn}&size.greaterThan={sizeGreaterThan}&size.lessThan={sizeLessThan}&size.greaterThanOrEqual={sizeGreaterThanOrEqual}&size.lessThanOrEqual={sizeLessThanOrEqual}&size.equals={sizeEquals}&size.notEquals={sizeNotEquals}&size.specified={sizeSpecified}&size.in={sizeIn}&size.notIn={sizeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&profileId.greaterThan={profileIdGreaterThan}&profileId.lessThan={profileIdLessThan}&profileId.greaterThanOrEqual={profileIdGreaterThanOrEqual}&profileId.lessThanOrEqual={profileIdLessThanOrEqual}&profileId.equals={profileIdEquals}&profileId.notEquals={profileIdNotEquals}&profileId.specified={profileIdSpecified}&profileId.in={profileIdIn}&profileId.notIn={profileIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  List<FileUserDTO> getAllFileUsers(@QueryMap(encoded=true) GetAllFileUsersQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllFileUsers</code> that receives the query parameters as a map,
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
          *   <li>profileIdGreaterThan -  (optional)</li>
          *   <li>profileIdLessThan -  (optional)</li>
          *   <li>profileIdGreaterThanOrEqual -  (optional)</li>
          *   <li>profileIdLessThanOrEqual -  (optional)</li>
          *   <li>profileIdEquals -  (optional)</li>
          *   <li>profileIdNotEquals -  (optional)</li>
          *   <li>profileIdSpecified -  (optional)</li>
          *   <li>profileIdIn -  (optional)</li>
          *   <li>profileIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return List&lt;FileUserDTO&gt;
      */
      @RequestLine("GET /api/file-users?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bucket.contains={bucketContains}&bucket.doesNotContain={bucketDoesNotContain}&bucket.equals={bucketEquals}&bucket.notEquals={bucketNotEquals}&bucket.specified={bucketSpecified}&bucket.in={bucketIn}&bucket.notIn={bucketNotIn}&objectKey.contains={objectKeyContains}&objectKey.doesNotContain={objectKeyDoesNotContain}&objectKey.equals={objectKeyEquals}&objectKey.notEquals={objectKeyNotEquals}&objectKey.specified={objectKeySpecified}&objectKey.in={objectKeyIn}&objectKey.notIn={objectKeyNotIn}&contentType.contains={contentTypeContains}&contentType.doesNotContain={contentTypeDoesNotContain}&contentType.equals={contentTypeEquals}&contentType.notEquals={contentTypeNotEquals}&contentType.specified={contentTypeSpecified}&contentType.in={contentTypeIn}&contentType.notIn={contentTypeNotIn}&size.greaterThan={sizeGreaterThan}&size.lessThan={sizeLessThan}&size.greaterThanOrEqual={sizeGreaterThanOrEqual}&size.lessThanOrEqual={sizeLessThanOrEqual}&size.equals={sizeEquals}&size.notEquals={sizeNotEquals}&size.specified={sizeSpecified}&size.in={sizeIn}&size.notIn={sizeNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&profileId.greaterThan={profileIdGreaterThan}&profileId.lessThan={profileIdLessThan}&profileId.greaterThanOrEqual={profileIdGreaterThanOrEqual}&profileId.lessThanOrEqual={profileIdLessThanOrEqual}&profileId.equals={profileIdEquals}&profileId.notEquals={profileIdNotEquals}&profileId.specified={profileIdSpecified}&profileId.in={profileIdIn}&profileId.notIn={profileIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<FileUserDTO>> getAllFileUsersWithHttpInfo(@QueryMap(encoded=true) GetAllFileUsersQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllFileUsers</code> method in a fluent style.
   */
  public static class GetAllFileUsersQueryParams extends HashMap<String, Object> {
    public GetAllFileUsersQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileUsersQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileUsersQueryParams bucketContains(@jakarta.annotation.Nullable final String value) {
      put("bucket.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams bucketDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("bucket.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams bucketEquals(@jakarta.annotation.Nullable final String value) {
      put("bucket.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams bucketNotEquals(@jakarta.annotation.Nullable final String value) {
      put("bucket.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams bucketSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("bucket.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams bucketIn(@jakarta.annotation.Nullable final List<String> value) {
      put("bucket.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileUsersQueryParams bucketNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("bucket.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileUsersQueryParams objectKeyContains(@jakarta.annotation.Nullable final String value) {
      put("objectKey.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams objectKeyDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("objectKey.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams objectKeyEquals(@jakarta.annotation.Nullable final String value) {
      put("objectKey.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams objectKeyNotEquals(@jakarta.annotation.Nullable final String value) {
      put("objectKey.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams objectKeySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("objectKey.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams objectKeyIn(@jakarta.annotation.Nullable final List<String> value) {
      put("objectKey.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileUsersQueryParams objectKeyNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("objectKey.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileUsersQueryParams contentTypeContains(@jakarta.annotation.Nullable final String value) {
      put("contentType.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams contentTypeDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("contentType.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams contentTypeEquals(@jakarta.annotation.Nullable final String value) {
      put("contentType.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams contentTypeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("contentType.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams contentTypeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("contentType.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams contentTypeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("contentType.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileUsersQueryParams contentTypeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("contentType.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileUsersQueryParams sizeGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("size.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams sizeLessThan(@jakarta.annotation.Nullable final Long value) {
      put("size.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams sizeGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("size.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams sizeLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("size.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams sizeEquals(@jakarta.annotation.Nullable final Long value) {
      put("size.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams sizeNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("size.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams sizeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("size.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams sizeIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("size.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileUsersQueryParams sizeNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("size.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileUsersQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileUsersQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileUsersQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileUsersQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileUsersQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileUsersQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileUsersQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileUsersQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileUsersQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileUsersQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileUsersQueryParams profileIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("profileId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams profileIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("profileId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams profileIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("profileId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams profileIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("profileId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams profileIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("profileId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams profileIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("profileId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams profileIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("profileId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFileUsersQueryParams profileIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("profileId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileUsersQueryParams profileIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("profileId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFileUsersQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @return FileUserDTO
   */
  @RequestLine("GET /api/file-users/{id}")
  @Headers({
    "Accept: */*",
  })
  FileUserDTO getFileUser(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>getFileUser</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/file-users/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<FileUserDTO> getFileUserWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param id  (required)
   * @param fileUserDTO  (required)
   * @return FileUserDTO
   */
  @RequestLine("PATCH /api/file-users/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  FileUserDTO partialUpdateFileUser(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull FileUserDTO fileUserDTO);

  /**
   * 
   * Similar to <code>partialUpdateFileUser</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param fileUserDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /api/file-users/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<FileUserDTO> partialUpdateFileUserWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull FileUserDTO fileUserDTO);



  /**
   * 
   * 
   * @param id  (required)
   * @param fileUserDTO  (required)
   * @return FileUserDTO
   */
  @RequestLine("PUT /api/file-users/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  FileUserDTO updateFileUser(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull FileUserDTO fileUserDTO);

  /**
   * 
   * Similar to <code>updateFileUser</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param fileUserDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/file-users/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<FileUserDTO> updateFileUserWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull FileUserDTO fileUserDTO);


}
