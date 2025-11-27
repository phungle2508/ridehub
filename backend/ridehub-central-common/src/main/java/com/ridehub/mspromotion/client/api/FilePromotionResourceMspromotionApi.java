package com.ridehub.mspromotion.client.api;

import com.ridehub.mspromotion.client.invoker.ApiClient;
import com.ridehub.mspromotion.client.invoker.EncodingUtils;
import com.ridehub.mspromotion.client.model.ApiResponse;

import com.ridehub.mspromotion.client.model.FilePromotionDTO;
import java.time.OffsetDateTime;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface FilePromotionResourceMspromotionApi extends ApiClient.Api {


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
   * @param isBannerEquals  (optional)
   * @param isBannerNotEquals  (optional)
   * @param isBannerSpecified  (optional)
   * @param isBannerIn  (optional)
   * @param isBannerNotIn  (optional)
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
  @RequestLine("GET /api/file-promotions/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bucket.contains={bucketContains}&bucket.doesNotContain={bucketDoesNotContain}&bucket.equals={bucketEquals}&bucket.notEquals={bucketNotEquals}&bucket.specified={bucketSpecified}&bucket.in={bucketIn}&bucket.notIn={bucketNotIn}&objectKey.contains={objectKeyContains}&objectKey.doesNotContain={objectKeyDoesNotContain}&objectKey.equals={objectKeyEquals}&objectKey.notEquals={objectKeyNotEquals}&objectKey.specified={objectKeySpecified}&objectKey.in={objectKeyIn}&objectKey.notIn={objectKeyNotIn}&contentType.contains={contentTypeContains}&contentType.doesNotContain={contentTypeDoesNotContain}&contentType.equals={contentTypeEquals}&contentType.notEquals={contentTypeNotEquals}&contentType.specified={contentTypeSpecified}&contentType.in={contentTypeIn}&contentType.notIn={contentTypeNotIn}&size.greaterThan={sizeGreaterThan}&size.lessThan={sizeLessThan}&size.greaterThanOrEqual={sizeGreaterThanOrEqual}&size.lessThanOrEqual={sizeLessThanOrEqual}&size.equals={sizeEquals}&size.notEquals={sizeNotEquals}&size.specified={sizeSpecified}&size.in={sizeIn}&size.notIn={sizeNotIn}&isBanner.equals={isBannerEquals}&isBanner.notEquals={isBannerNotEquals}&isBanner.specified={isBannerSpecified}&isBanner.in={isBannerIn}&isBanner.notIn={isBannerNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  Long countFilePromotions(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("bucketContains") @jakarta.annotation.Nullable String bucketContains, @Param("bucketDoesNotContain") @jakarta.annotation.Nullable String bucketDoesNotContain, @Param("bucketEquals") @jakarta.annotation.Nullable String bucketEquals, @Param("bucketNotEquals") @jakarta.annotation.Nullable String bucketNotEquals, @Param("bucketSpecified") @jakarta.annotation.Nullable Boolean bucketSpecified, @Param("bucketIn") @jakarta.annotation.Nullable List<String> bucketIn, @Param("bucketNotIn") @jakarta.annotation.Nullable List<String> bucketNotIn, @Param("objectKeyContains") @jakarta.annotation.Nullable String objectKeyContains, @Param("objectKeyDoesNotContain") @jakarta.annotation.Nullable String objectKeyDoesNotContain, @Param("objectKeyEquals") @jakarta.annotation.Nullable String objectKeyEquals, @Param("objectKeyNotEquals") @jakarta.annotation.Nullable String objectKeyNotEquals, @Param("objectKeySpecified") @jakarta.annotation.Nullable Boolean objectKeySpecified, @Param("objectKeyIn") @jakarta.annotation.Nullable List<String> objectKeyIn, @Param("objectKeyNotIn") @jakarta.annotation.Nullable List<String> objectKeyNotIn, @Param("contentTypeContains") @jakarta.annotation.Nullable String contentTypeContains, @Param("contentTypeDoesNotContain") @jakarta.annotation.Nullable String contentTypeDoesNotContain, @Param("contentTypeEquals") @jakarta.annotation.Nullable String contentTypeEquals, @Param("contentTypeNotEquals") @jakarta.annotation.Nullable String contentTypeNotEquals, @Param("contentTypeSpecified") @jakarta.annotation.Nullable Boolean contentTypeSpecified, @Param("contentTypeIn") @jakarta.annotation.Nullable List<String> contentTypeIn, @Param("contentTypeNotIn") @jakarta.annotation.Nullable List<String> contentTypeNotIn, @Param("sizeGreaterThan") @jakarta.annotation.Nullable Long sizeGreaterThan, @Param("sizeLessThan") @jakarta.annotation.Nullable Long sizeLessThan, @Param("sizeGreaterThanOrEqual") @jakarta.annotation.Nullable Long sizeGreaterThanOrEqual, @Param("sizeLessThanOrEqual") @jakarta.annotation.Nullable Long sizeLessThanOrEqual, @Param("sizeEquals") @jakarta.annotation.Nullable Long sizeEquals, @Param("sizeNotEquals") @jakarta.annotation.Nullable Long sizeNotEquals, @Param("sizeSpecified") @jakarta.annotation.Nullable Boolean sizeSpecified, @Param("sizeIn") @jakarta.annotation.Nullable List<Long> sizeIn, @Param("sizeNotIn") @jakarta.annotation.Nullable List<Long> sizeNotIn, @Param("isBannerEquals") @jakarta.annotation.Nullable Boolean isBannerEquals, @Param("isBannerNotEquals") @jakarta.annotation.Nullable Boolean isBannerNotEquals, @Param("isBannerSpecified") @jakarta.annotation.Nullable Boolean isBannerSpecified, @Param("isBannerIn") @jakarta.annotation.Nullable List<Boolean> isBannerIn, @Param("isBannerNotIn") @jakarta.annotation.Nullable List<Boolean> isBannerNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("promotionIdGreaterThan") @jakarta.annotation.Nullable Long promotionIdGreaterThan, @Param("promotionIdLessThan") @jakarta.annotation.Nullable Long promotionIdLessThan, @Param("promotionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long promotionIdGreaterThanOrEqual, @Param("promotionIdLessThanOrEqual") @jakarta.annotation.Nullable Long promotionIdLessThanOrEqual, @Param("promotionIdEquals") @jakarta.annotation.Nullable Long promotionIdEquals, @Param("promotionIdNotEquals") @jakarta.annotation.Nullable Long promotionIdNotEquals, @Param("promotionIdSpecified") @jakarta.annotation.Nullable Boolean promotionIdSpecified, @Param("promotionIdIn") @jakarta.annotation.Nullable List<Long> promotionIdIn, @Param("promotionIdNotIn") @jakarta.annotation.Nullable List<Long> promotionIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>countFilePromotions</code> but it also returns the http response headers .
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
   * @param isBannerEquals  (optional)
   * @param isBannerNotEquals  (optional)
   * @param isBannerSpecified  (optional)
   * @param isBannerIn  (optional)
   * @param isBannerNotIn  (optional)
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
  @RequestLine("GET /api/file-promotions/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bucket.contains={bucketContains}&bucket.doesNotContain={bucketDoesNotContain}&bucket.equals={bucketEquals}&bucket.notEquals={bucketNotEquals}&bucket.specified={bucketSpecified}&bucket.in={bucketIn}&bucket.notIn={bucketNotIn}&objectKey.contains={objectKeyContains}&objectKey.doesNotContain={objectKeyDoesNotContain}&objectKey.equals={objectKeyEquals}&objectKey.notEquals={objectKeyNotEquals}&objectKey.specified={objectKeySpecified}&objectKey.in={objectKeyIn}&objectKey.notIn={objectKeyNotIn}&contentType.contains={contentTypeContains}&contentType.doesNotContain={contentTypeDoesNotContain}&contentType.equals={contentTypeEquals}&contentType.notEquals={contentTypeNotEquals}&contentType.specified={contentTypeSpecified}&contentType.in={contentTypeIn}&contentType.notIn={contentTypeNotIn}&size.greaterThan={sizeGreaterThan}&size.lessThan={sizeLessThan}&size.greaterThanOrEqual={sizeGreaterThanOrEqual}&size.lessThanOrEqual={sizeLessThanOrEqual}&size.equals={sizeEquals}&size.notEquals={sizeNotEquals}&size.specified={sizeSpecified}&size.in={sizeIn}&size.notIn={sizeNotIn}&isBanner.equals={isBannerEquals}&isBanner.notEquals={isBannerNotEquals}&isBanner.specified={isBannerSpecified}&isBanner.in={isBannerIn}&isBanner.notIn={isBannerNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Long> countFilePromotionsWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("bucketContains") @jakarta.annotation.Nullable String bucketContains, @Param("bucketDoesNotContain") @jakarta.annotation.Nullable String bucketDoesNotContain, @Param("bucketEquals") @jakarta.annotation.Nullable String bucketEquals, @Param("bucketNotEquals") @jakarta.annotation.Nullable String bucketNotEquals, @Param("bucketSpecified") @jakarta.annotation.Nullable Boolean bucketSpecified, @Param("bucketIn") @jakarta.annotation.Nullable List<String> bucketIn, @Param("bucketNotIn") @jakarta.annotation.Nullable List<String> bucketNotIn, @Param("objectKeyContains") @jakarta.annotation.Nullable String objectKeyContains, @Param("objectKeyDoesNotContain") @jakarta.annotation.Nullable String objectKeyDoesNotContain, @Param("objectKeyEquals") @jakarta.annotation.Nullable String objectKeyEquals, @Param("objectKeyNotEquals") @jakarta.annotation.Nullable String objectKeyNotEquals, @Param("objectKeySpecified") @jakarta.annotation.Nullable Boolean objectKeySpecified, @Param("objectKeyIn") @jakarta.annotation.Nullable List<String> objectKeyIn, @Param("objectKeyNotIn") @jakarta.annotation.Nullable List<String> objectKeyNotIn, @Param("contentTypeContains") @jakarta.annotation.Nullable String contentTypeContains, @Param("contentTypeDoesNotContain") @jakarta.annotation.Nullable String contentTypeDoesNotContain, @Param("contentTypeEquals") @jakarta.annotation.Nullable String contentTypeEquals, @Param("contentTypeNotEquals") @jakarta.annotation.Nullable String contentTypeNotEquals, @Param("contentTypeSpecified") @jakarta.annotation.Nullable Boolean contentTypeSpecified, @Param("contentTypeIn") @jakarta.annotation.Nullable List<String> contentTypeIn, @Param("contentTypeNotIn") @jakarta.annotation.Nullable List<String> contentTypeNotIn, @Param("sizeGreaterThan") @jakarta.annotation.Nullable Long sizeGreaterThan, @Param("sizeLessThan") @jakarta.annotation.Nullable Long sizeLessThan, @Param("sizeGreaterThanOrEqual") @jakarta.annotation.Nullable Long sizeGreaterThanOrEqual, @Param("sizeLessThanOrEqual") @jakarta.annotation.Nullable Long sizeLessThanOrEqual, @Param("sizeEquals") @jakarta.annotation.Nullable Long sizeEquals, @Param("sizeNotEquals") @jakarta.annotation.Nullable Long sizeNotEquals, @Param("sizeSpecified") @jakarta.annotation.Nullable Boolean sizeSpecified, @Param("sizeIn") @jakarta.annotation.Nullable List<Long> sizeIn, @Param("sizeNotIn") @jakarta.annotation.Nullable List<Long> sizeNotIn, @Param("isBannerEquals") @jakarta.annotation.Nullable Boolean isBannerEquals, @Param("isBannerNotEquals") @jakarta.annotation.Nullable Boolean isBannerNotEquals, @Param("isBannerSpecified") @jakarta.annotation.Nullable Boolean isBannerSpecified, @Param("isBannerIn") @jakarta.annotation.Nullable List<Boolean> isBannerIn, @Param("isBannerNotIn") @jakarta.annotation.Nullable List<Boolean> isBannerNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("promotionIdGreaterThan") @jakarta.annotation.Nullable Long promotionIdGreaterThan, @Param("promotionIdLessThan") @jakarta.annotation.Nullable Long promotionIdLessThan, @Param("promotionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long promotionIdGreaterThanOrEqual, @Param("promotionIdLessThanOrEqual") @jakarta.annotation.Nullable Long promotionIdLessThanOrEqual, @Param("promotionIdEquals") @jakarta.annotation.Nullable Long promotionIdEquals, @Param("promotionIdNotEquals") @jakarta.annotation.Nullable Long promotionIdNotEquals, @Param("promotionIdSpecified") @jakarta.annotation.Nullable Boolean promotionIdSpecified, @Param("promotionIdIn") @jakarta.annotation.Nullable List<Long> promotionIdIn, @Param("promotionIdNotIn") @jakarta.annotation.Nullable List<Long> promotionIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>countFilePromotions</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CountFilePromotionsQueryParams} class that allows for
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
   *   <li>isBannerEquals -  (optional)</li>
   *   <li>isBannerNotEquals -  (optional)</li>
   *   <li>isBannerSpecified -  (optional)</li>
   *   <li>isBannerIn -  (optional)</li>
   *   <li>isBannerNotIn -  (optional)</li>
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
  @RequestLine("GET /api/file-promotions/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bucket.contains={bucketContains}&bucket.doesNotContain={bucketDoesNotContain}&bucket.equals={bucketEquals}&bucket.notEquals={bucketNotEquals}&bucket.specified={bucketSpecified}&bucket.in={bucketIn}&bucket.notIn={bucketNotIn}&objectKey.contains={objectKeyContains}&objectKey.doesNotContain={objectKeyDoesNotContain}&objectKey.equals={objectKeyEquals}&objectKey.notEquals={objectKeyNotEquals}&objectKey.specified={objectKeySpecified}&objectKey.in={objectKeyIn}&objectKey.notIn={objectKeyNotIn}&contentType.contains={contentTypeContains}&contentType.doesNotContain={contentTypeDoesNotContain}&contentType.equals={contentTypeEquals}&contentType.notEquals={contentTypeNotEquals}&contentType.specified={contentTypeSpecified}&contentType.in={contentTypeIn}&contentType.notIn={contentTypeNotIn}&size.greaterThan={sizeGreaterThan}&size.lessThan={sizeLessThan}&size.greaterThanOrEqual={sizeGreaterThanOrEqual}&size.lessThanOrEqual={sizeLessThanOrEqual}&size.equals={sizeEquals}&size.notEquals={sizeNotEquals}&size.specified={sizeSpecified}&size.in={sizeIn}&size.notIn={sizeNotIn}&isBanner.equals={isBannerEquals}&isBanner.notEquals={isBannerNotEquals}&isBanner.specified={isBannerSpecified}&isBanner.in={isBannerIn}&isBanner.notIn={isBannerNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  Long countFilePromotions(@QueryMap(encoded=true) CountFilePromotionsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>countFilePromotions</code> that receives the query parameters as a map,
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
          *   <li>isBannerEquals -  (optional)</li>
          *   <li>isBannerNotEquals -  (optional)</li>
          *   <li>isBannerSpecified -  (optional)</li>
          *   <li>isBannerIn -  (optional)</li>
          *   <li>isBannerNotIn -  (optional)</li>
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
      @RequestLine("GET /api/file-promotions/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bucket.contains={bucketContains}&bucket.doesNotContain={bucketDoesNotContain}&bucket.equals={bucketEquals}&bucket.notEquals={bucketNotEquals}&bucket.specified={bucketSpecified}&bucket.in={bucketIn}&bucket.notIn={bucketNotIn}&objectKey.contains={objectKeyContains}&objectKey.doesNotContain={objectKeyDoesNotContain}&objectKey.equals={objectKeyEquals}&objectKey.notEquals={objectKeyNotEquals}&objectKey.specified={objectKeySpecified}&objectKey.in={objectKeyIn}&objectKey.notIn={objectKeyNotIn}&contentType.contains={contentTypeContains}&contentType.doesNotContain={contentTypeDoesNotContain}&contentType.equals={contentTypeEquals}&contentType.notEquals={contentTypeNotEquals}&contentType.specified={contentTypeSpecified}&contentType.in={contentTypeIn}&contentType.notIn={contentTypeNotIn}&size.greaterThan={sizeGreaterThan}&size.lessThan={sizeLessThan}&size.greaterThanOrEqual={sizeGreaterThanOrEqual}&size.lessThanOrEqual={sizeLessThanOrEqual}&size.equals={sizeEquals}&size.notEquals={sizeNotEquals}&size.specified={sizeSpecified}&size.in={sizeIn}&size.notIn={sizeNotIn}&isBanner.equals={isBannerEquals}&isBanner.notEquals={isBannerNotEquals}&isBanner.specified={isBannerSpecified}&isBanner.in={isBannerIn}&isBanner.notIn={isBannerNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Long> countFilePromotionsWithHttpInfo(@QueryMap(encoded=true) CountFilePromotionsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>countFilePromotions</code> method in a fluent style.
   */
  public static class CountFilePromotionsQueryParams extends HashMap<String, Object> {
    public CountFilePromotionsQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFilePromotionsQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFilePromotionsQueryParams bucketContains(@jakarta.annotation.Nullable final String value) {
      put("bucket.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams bucketDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("bucket.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams bucketEquals(@jakarta.annotation.Nullable final String value) {
      put("bucket.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams bucketNotEquals(@jakarta.annotation.Nullable final String value) {
      put("bucket.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams bucketSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("bucket.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams bucketIn(@jakarta.annotation.Nullable final List<String> value) {
      put("bucket.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFilePromotionsQueryParams bucketNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("bucket.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFilePromotionsQueryParams objectKeyContains(@jakarta.annotation.Nullable final String value) {
      put("objectKey.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams objectKeyDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("objectKey.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams objectKeyEquals(@jakarta.annotation.Nullable final String value) {
      put("objectKey.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams objectKeyNotEquals(@jakarta.annotation.Nullable final String value) {
      put("objectKey.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams objectKeySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("objectKey.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams objectKeyIn(@jakarta.annotation.Nullable final List<String> value) {
      put("objectKey.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFilePromotionsQueryParams objectKeyNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("objectKey.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFilePromotionsQueryParams contentTypeContains(@jakarta.annotation.Nullable final String value) {
      put("contentType.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams contentTypeDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("contentType.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams contentTypeEquals(@jakarta.annotation.Nullable final String value) {
      put("contentType.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams contentTypeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("contentType.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams contentTypeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("contentType.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams contentTypeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("contentType.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFilePromotionsQueryParams contentTypeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("contentType.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFilePromotionsQueryParams sizeGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("size.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams sizeLessThan(@jakarta.annotation.Nullable final Long value) {
      put("size.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams sizeGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("size.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams sizeLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("size.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams sizeEquals(@jakarta.annotation.Nullable final Long value) {
      put("size.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams sizeNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("size.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams sizeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("size.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams sizeIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("size.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFilePromotionsQueryParams sizeNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("size.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFilePromotionsQueryParams isBannerEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isBanner.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams isBannerNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isBanner.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams isBannerSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isBanner.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams isBannerIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isBanner.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFilePromotionsQueryParams isBannerNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isBanner.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFilePromotionsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFilePromotionsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFilePromotionsQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFilePromotionsQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFilePromotionsQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFilePromotionsQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFilePromotionsQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFilePromotionsQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFilePromotionsQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFilePromotionsQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFilePromotionsQueryParams promotionIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams promotionIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams promotionIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams promotionIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams promotionIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams promotionIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams promotionIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("promotionId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountFilePromotionsQueryParams promotionIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("promotionId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFilePromotionsQueryParams promotionIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("promotionId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountFilePromotionsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param filePromotionDTO  (required)
   * @return FilePromotionDTO
   */
  @RequestLine("POST /api/file-promotions")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  FilePromotionDTO createFilePromotion(@jakarta.annotation.Nonnull FilePromotionDTO filePromotionDTO);

  /**
   * 
   * Similar to <code>createFilePromotion</code> but it also returns the http response headers .
   * 
   * @param filePromotionDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/file-promotions")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<FilePromotionDTO> createFilePromotionWithHttpInfo(@jakarta.annotation.Nonnull FilePromotionDTO filePromotionDTO);



  /**
   * 
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/file-promotions/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteFilePromotion(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>deleteFilePromotion</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/file-promotions/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteFilePromotionWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



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
   * @param isBannerEquals  (optional)
   * @param isBannerNotEquals  (optional)
   * @param isBannerSpecified  (optional)
   * @param isBannerIn  (optional)
   * @param isBannerNotIn  (optional)
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
   * @return List&lt;FilePromotionDTO&gt;
   */
  @RequestLine("GET /api/file-promotions?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bucket.contains={bucketContains}&bucket.doesNotContain={bucketDoesNotContain}&bucket.equals={bucketEquals}&bucket.notEquals={bucketNotEquals}&bucket.specified={bucketSpecified}&bucket.in={bucketIn}&bucket.notIn={bucketNotIn}&objectKey.contains={objectKeyContains}&objectKey.doesNotContain={objectKeyDoesNotContain}&objectKey.equals={objectKeyEquals}&objectKey.notEquals={objectKeyNotEquals}&objectKey.specified={objectKeySpecified}&objectKey.in={objectKeyIn}&objectKey.notIn={objectKeyNotIn}&contentType.contains={contentTypeContains}&contentType.doesNotContain={contentTypeDoesNotContain}&contentType.equals={contentTypeEquals}&contentType.notEquals={contentTypeNotEquals}&contentType.specified={contentTypeSpecified}&contentType.in={contentTypeIn}&contentType.notIn={contentTypeNotIn}&size.greaterThan={sizeGreaterThan}&size.lessThan={sizeLessThan}&size.greaterThanOrEqual={sizeGreaterThanOrEqual}&size.lessThanOrEqual={sizeLessThanOrEqual}&size.equals={sizeEquals}&size.notEquals={sizeNotEquals}&size.specified={sizeSpecified}&size.in={sizeIn}&size.notIn={sizeNotIn}&isBanner.equals={isBannerEquals}&isBanner.notEquals={isBannerNotEquals}&isBanner.specified={isBannerSpecified}&isBanner.in={isBannerIn}&isBanner.notIn={isBannerNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  List<FilePromotionDTO> getAllFilePromotions(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("bucketContains") @jakarta.annotation.Nullable String bucketContains, @Param("bucketDoesNotContain") @jakarta.annotation.Nullable String bucketDoesNotContain, @Param("bucketEquals") @jakarta.annotation.Nullable String bucketEquals, @Param("bucketNotEquals") @jakarta.annotation.Nullable String bucketNotEquals, @Param("bucketSpecified") @jakarta.annotation.Nullable Boolean bucketSpecified, @Param("bucketIn") @jakarta.annotation.Nullable List<String> bucketIn, @Param("bucketNotIn") @jakarta.annotation.Nullable List<String> bucketNotIn, @Param("objectKeyContains") @jakarta.annotation.Nullable String objectKeyContains, @Param("objectKeyDoesNotContain") @jakarta.annotation.Nullable String objectKeyDoesNotContain, @Param("objectKeyEquals") @jakarta.annotation.Nullable String objectKeyEquals, @Param("objectKeyNotEquals") @jakarta.annotation.Nullable String objectKeyNotEquals, @Param("objectKeySpecified") @jakarta.annotation.Nullable Boolean objectKeySpecified, @Param("objectKeyIn") @jakarta.annotation.Nullable List<String> objectKeyIn, @Param("objectKeyNotIn") @jakarta.annotation.Nullable List<String> objectKeyNotIn, @Param("contentTypeContains") @jakarta.annotation.Nullable String contentTypeContains, @Param("contentTypeDoesNotContain") @jakarta.annotation.Nullable String contentTypeDoesNotContain, @Param("contentTypeEquals") @jakarta.annotation.Nullable String contentTypeEquals, @Param("contentTypeNotEquals") @jakarta.annotation.Nullable String contentTypeNotEquals, @Param("contentTypeSpecified") @jakarta.annotation.Nullable Boolean contentTypeSpecified, @Param("contentTypeIn") @jakarta.annotation.Nullable List<String> contentTypeIn, @Param("contentTypeNotIn") @jakarta.annotation.Nullable List<String> contentTypeNotIn, @Param("sizeGreaterThan") @jakarta.annotation.Nullable Long sizeGreaterThan, @Param("sizeLessThan") @jakarta.annotation.Nullable Long sizeLessThan, @Param("sizeGreaterThanOrEqual") @jakarta.annotation.Nullable Long sizeGreaterThanOrEqual, @Param("sizeLessThanOrEqual") @jakarta.annotation.Nullable Long sizeLessThanOrEqual, @Param("sizeEquals") @jakarta.annotation.Nullable Long sizeEquals, @Param("sizeNotEquals") @jakarta.annotation.Nullable Long sizeNotEquals, @Param("sizeSpecified") @jakarta.annotation.Nullable Boolean sizeSpecified, @Param("sizeIn") @jakarta.annotation.Nullable List<Long> sizeIn, @Param("sizeNotIn") @jakarta.annotation.Nullable List<Long> sizeNotIn, @Param("isBannerEquals") @jakarta.annotation.Nullable Boolean isBannerEquals, @Param("isBannerNotEquals") @jakarta.annotation.Nullable Boolean isBannerNotEquals, @Param("isBannerSpecified") @jakarta.annotation.Nullable Boolean isBannerSpecified, @Param("isBannerIn") @jakarta.annotation.Nullable List<Boolean> isBannerIn, @Param("isBannerNotIn") @jakarta.annotation.Nullable List<Boolean> isBannerNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("promotionIdGreaterThan") @jakarta.annotation.Nullable Long promotionIdGreaterThan, @Param("promotionIdLessThan") @jakarta.annotation.Nullable Long promotionIdLessThan, @Param("promotionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long promotionIdGreaterThanOrEqual, @Param("promotionIdLessThanOrEqual") @jakarta.annotation.Nullable Long promotionIdLessThanOrEqual, @Param("promotionIdEquals") @jakarta.annotation.Nullable Long promotionIdEquals, @Param("promotionIdNotEquals") @jakarta.annotation.Nullable Long promotionIdNotEquals, @Param("promotionIdSpecified") @jakarta.annotation.Nullable Boolean promotionIdSpecified, @Param("promotionIdIn") @jakarta.annotation.Nullable List<Long> promotionIdIn, @Param("promotionIdNotIn") @jakarta.annotation.Nullable List<Long> promotionIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>getAllFilePromotions</code> but it also returns the http response headers .
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
   * @param isBannerEquals  (optional)
   * @param isBannerNotEquals  (optional)
   * @param isBannerSpecified  (optional)
   * @param isBannerIn  (optional)
   * @param isBannerNotIn  (optional)
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
  @RequestLine("GET /api/file-promotions?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bucket.contains={bucketContains}&bucket.doesNotContain={bucketDoesNotContain}&bucket.equals={bucketEquals}&bucket.notEquals={bucketNotEquals}&bucket.specified={bucketSpecified}&bucket.in={bucketIn}&bucket.notIn={bucketNotIn}&objectKey.contains={objectKeyContains}&objectKey.doesNotContain={objectKeyDoesNotContain}&objectKey.equals={objectKeyEquals}&objectKey.notEquals={objectKeyNotEquals}&objectKey.specified={objectKeySpecified}&objectKey.in={objectKeyIn}&objectKey.notIn={objectKeyNotIn}&contentType.contains={contentTypeContains}&contentType.doesNotContain={contentTypeDoesNotContain}&contentType.equals={contentTypeEquals}&contentType.notEquals={contentTypeNotEquals}&contentType.specified={contentTypeSpecified}&contentType.in={contentTypeIn}&contentType.notIn={contentTypeNotIn}&size.greaterThan={sizeGreaterThan}&size.lessThan={sizeLessThan}&size.greaterThanOrEqual={sizeGreaterThanOrEqual}&size.lessThanOrEqual={sizeLessThanOrEqual}&size.equals={sizeEquals}&size.notEquals={sizeNotEquals}&size.specified={sizeSpecified}&size.in={sizeIn}&size.notIn={sizeNotIn}&isBanner.equals={isBannerEquals}&isBanner.notEquals={isBannerNotEquals}&isBanner.specified={isBannerSpecified}&isBanner.in={isBannerIn}&isBanner.notIn={isBannerNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<FilePromotionDTO>> getAllFilePromotionsWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("bucketContains") @jakarta.annotation.Nullable String bucketContains, @Param("bucketDoesNotContain") @jakarta.annotation.Nullable String bucketDoesNotContain, @Param("bucketEquals") @jakarta.annotation.Nullable String bucketEquals, @Param("bucketNotEquals") @jakarta.annotation.Nullable String bucketNotEquals, @Param("bucketSpecified") @jakarta.annotation.Nullable Boolean bucketSpecified, @Param("bucketIn") @jakarta.annotation.Nullable List<String> bucketIn, @Param("bucketNotIn") @jakarta.annotation.Nullable List<String> bucketNotIn, @Param("objectKeyContains") @jakarta.annotation.Nullable String objectKeyContains, @Param("objectKeyDoesNotContain") @jakarta.annotation.Nullable String objectKeyDoesNotContain, @Param("objectKeyEquals") @jakarta.annotation.Nullable String objectKeyEquals, @Param("objectKeyNotEquals") @jakarta.annotation.Nullable String objectKeyNotEquals, @Param("objectKeySpecified") @jakarta.annotation.Nullable Boolean objectKeySpecified, @Param("objectKeyIn") @jakarta.annotation.Nullable List<String> objectKeyIn, @Param("objectKeyNotIn") @jakarta.annotation.Nullable List<String> objectKeyNotIn, @Param("contentTypeContains") @jakarta.annotation.Nullable String contentTypeContains, @Param("contentTypeDoesNotContain") @jakarta.annotation.Nullable String contentTypeDoesNotContain, @Param("contentTypeEquals") @jakarta.annotation.Nullable String contentTypeEquals, @Param("contentTypeNotEquals") @jakarta.annotation.Nullable String contentTypeNotEquals, @Param("contentTypeSpecified") @jakarta.annotation.Nullable Boolean contentTypeSpecified, @Param("contentTypeIn") @jakarta.annotation.Nullable List<String> contentTypeIn, @Param("contentTypeNotIn") @jakarta.annotation.Nullable List<String> contentTypeNotIn, @Param("sizeGreaterThan") @jakarta.annotation.Nullable Long sizeGreaterThan, @Param("sizeLessThan") @jakarta.annotation.Nullable Long sizeLessThan, @Param("sizeGreaterThanOrEqual") @jakarta.annotation.Nullable Long sizeGreaterThanOrEqual, @Param("sizeLessThanOrEqual") @jakarta.annotation.Nullable Long sizeLessThanOrEqual, @Param("sizeEquals") @jakarta.annotation.Nullable Long sizeEquals, @Param("sizeNotEquals") @jakarta.annotation.Nullable Long sizeNotEquals, @Param("sizeSpecified") @jakarta.annotation.Nullable Boolean sizeSpecified, @Param("sizeIn") @jakarta.annotation.Nullable List<Long> sizeIn, @Param("sizeNotIn") @jakarta.annotation.Nullable List<Long> sizeNotIn, @Param("isBannerEquals") @jakarta.annotation.Nullable Boolean isBannerEquals, @Param("isBannerNotEquals") @jakarta.annotation.Nullable Boolean isBannerNotEquals, @Param("isBannerSpecified") @jakarta.annotation.Nullable Boolean isBannerSpecified, @Param("isBannerIn") @jakarta.annotation.Nullable List<Boolean> isBannerIn, @Param("isBannerNotIn") @jakarta.annotation.Nullable List<Boolean> isBannerNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("promotionIdGreaterThan") @jakarta.annotation.Nullable Long promotionIdGreaterThan, @Param("promotionIdLessThan") @jakarta.annotation.Nullable Long promotionIdLessThan, @Param("promotionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long promotionIdGreaterThanOrEqual, @Param("promotionIdLessThanOrEqual") @jakarta.annotation.Nullable Long promotionIdLessThanOrEqual, @Param("promotionIdEquals") @jakarta.annotation.Nullable Long promotionIdEquals, @Param("promotionIdNotEquals") @jakarta.annotation.Nullable Long promotionIdNotEquals, @Param("promotionIdSpecified") @jakarta.annotation.Nullable Boolean promotionIdSpecified, @Param("promotionIdIn") @jakarta.annotation.Nullable List<Long> promotionIdIn, @Param("promotionIdNotIn") @jakarta.annotation.Nullable List<Long> promotionIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllFilePromotions</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllFilePromotionsQueryParams} class that allows for
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
   *   <li>isBannerEquals -  (optional)</li>
   *   <li>isBannerNotEquals -  (optional)</li>
   *   <li>isBannerSpecified -  (optional)</li>
   *   <li>isBannerIn -  (optional)</li>
   *   <li>isBannerNotIn -  (optional)</li>
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
   * @return List&lt;FilePromotionDTO&gt;
   */
  @RequestLine("GET /api/file-promotions?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bucket.contains={bucketContains}&bucket.doesNotContain={bucketDoesNotContain}&bucket.equals={bucketEquals}&bucket.notEquals={bucketNotEquals}&bucket.specified={bucketSpecified}&bucket.in={bucketIn}&bucket.notIn={bucketNotIn}&objectKey.contains={objectKeyContains}&objectKey.doesNotContain={objectKeyDoesNotContain}&objectKey.equals={objectKeyEquals}&objectKey.notEquals={objectKeyNotEquals}&objectKey.specified={objectKeySpecified}&objectKey.in={objectKeyIn}&objectKey.notIn={objectKeyNotIn}&contentType.contains={contentTypeContains}&contentType.doesNotContain={contentTypeDoesNotContain}&contentType.equals={contentTypeEquals}&contentType.notEquals={contentTypeNotEquals}&contentType.specified={contentTypeSpecified}&contentType.in={contentTypeIn}&contentType.notIn={contentTypeNotIn}&size.greaterThan={sizeGreaterThan}&size.lessThan={sizeLessThan}&size.greaterThanOrEqual={sizeGreaterThanOrEqual}&size.lessThanOrEqual={sizeLessThanOrEqual}&size.equals={sizeEquals}&size.notEquals={sizeNotEquals}&size.specified={sizeSpecified}&size.in={sizeIn}&size.notIn={sizeNotIn}&isBanner.equals={isBannerEquals}&isBanner.notEquals={isBannerNotEquals}&isBanner.specified={isBannerSpecified}&isBanner.in={isBannerIn}&isBanner.notIn={isBannerNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  List<FilePromotionDTO> getAllFilePromotions(@QueryMap(encoded=true) GetAllFilePromotionsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllFilePromotions</code> that receives the query parameters as a map,
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
          *   <li>isBannerEquals -  (optional)</li>
          *   <li>isBannerNotEquals -  (optional)</li>
          *   <li>isBannerSpecified -  (optional)</li>
          *   <li>isBannerIn -  (optional)</li>
          *   <li>isBannerNotIn -  (optional)</li>
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
          * @return List&lt;FilePromotionDTO&gt;
      */
      @RequestLine("GET /api/file-promotions?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bucket.contains={bucketContains}&bucket.doesNotContain={bucketDoesNotContain}&bucket.equals={bucketEquals}&bucket.notEquals={bucketNotEquals}&bucket.specified={bucketSpecified}&bucket.in={bucketIn}&bucket.notIn={bucketNotIn}&objectKey.contains={objectKeyContains}&objectKey.doesNotContain={objectKeyDoesNotContain}&objectKey.equals={objectKeyEquals}&objectKey.notEquals={objectKeyNotEquals}&objectKey.specified={objectKeySpecified}&objectKey.in={objectKeyIn}&objectKey.notIn={objectKeyNotIn}&contentType.contains={contentTypeContains}&contentType.doesNotContain={contentTypeDoesNotContain}&contentType.equals={contentTypeEquals}&contentType.notEquals={contentTypeNotEquals}&contentType.specified={contentTypeSpecified}&contentType.in={contentTypeIn}&contentType.notIn={contentTypeNotIn}&size.greaterThan={sizeGreaterThan}&size.lessThan={sizeLessThan}&size.greaterThanOrEqual={sizeGreaterThanOrEqual}&size.lessThanOrEqual={sizeLessThanOrEqual}&size.equals={sizeEquals}&size.notEquals={sizeNotEquals}&size.specified={sizeSpecified}&size.in={sizeIn}&size.notIn={sizeNotIn}&isBanner.equals={isBannerEquals}&isBanner.notEquals={isBannerNotEquals}&isBanner.specified={isBannerSpecified}&isBanner.in={isBannerIn}&isBanner.notIn={isBannerNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<FilePromotionDTO>> getAllFilePromotionsWithHttpInfo(@QueryMap(encoded=true) GetAllFilePromotionsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllFilePromotions</code> method in a fluent style.
   */
  public static class GetAllFilePromotionsQueryParams extends HashMap<String, Object> {
    public GetAllFilePromotionsQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFilePromotionsQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFilePromotionsQueryParams bucketContains(@jakarta.annotation.Nullable final String value) {
      put("bucket.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams bucketDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("bucket.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams bucketEquals(@jakarta.annotation.Nullable final String value) {
      put("bucket.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams bucketNotEquals(@jakarta.annotation.Nullable final String value) {
      put("bucket.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams bucketSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("bucket.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams bucketIn(@jakarta.annotation.Nullable final List<String> value) {
      put("bucket.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFilePromotionsQueryParams bucketNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("bucket.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFilePromotionsQueryParams objectKeyContains(@jakarta.annotation.Nullable final String value) {
      put("objectKey.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams objectKeyDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("objectKey.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams objectKeyEquals(@jakarta.annotation.Nullable final String value) {
      put("objectKey.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams objectKeyNotEquals(@jakarta.annotation.Nullable final String value) {
      put("objectKey.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams objectKeySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("objectKey.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams objectKeyIn(@jakarta.annotation.Nullable final List<String> value) {
      put("objectKey.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFilePromotionsQueryParams objectKeyNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("objectKey.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFilePromotionsQueryParams contentTypeContains(@jakarta.annotation.Nullable final String value) {
      put("contentType.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams contentTypeDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("contentType.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams contentTypeEquals(@jakarta.annotation.Nullable final String value) {
      put("contentType.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams contentTypeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("contentType.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams contentTypeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("contentType.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams contentTypeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("contentType.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFilePromotionsQueryParams contentTypeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("contentType.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFilePromotionsQueryParams sizeGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("size.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams sizeLessThan(@jakarta.annotation.Nullable final Long value) {
      put("size.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams sizeGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("size.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams sizeLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("size.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams sizeEquals(@jakarta.annotation.Nullable final Long value) {
      put("size.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams sizeNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("size.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams sizeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("size.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams sizeIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("size.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFilePromotionsQueryParams sizeNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("size.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFilePromotionsQueryParams isBannerEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isBanner.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams isBannerNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isBanner.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams isBannerSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isBanner.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams isBannerIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isBanner.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFilePromotionsQueryParams isBannerNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isBanner.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFilePromotionsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFilePromotionsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFilePromotionsQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFilePromotionsQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFilePromotionsQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFilePromotionsQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFilePromotionsQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFilePromotionsQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFilePromotionsQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFilePromotionsQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFilePromotionsQueryParams promotionIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams promotionIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams promotionIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams promotionIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams promotionIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams promotionIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams promotionIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("promotionId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllFilePromotionsQueryParams promotionIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("promotionId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFilePromotionsQueryParams promotionIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("promotionId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllFilePromotionsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @return FilePromotionDTO
   */
  @RequestLine("GET /api/file-promotions/{id}")
  @Headers({
    "Accept: */*",
  })
  FilePromotionDTO getFilePromotion(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>getFilePromotion</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/file-promotions/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<FilePromotionDTO> getFilePromotionWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param id  (required)
   * @param filePromotionDTO  (required)
   * @return FilePromotionDTO
   */
  @RequestLine("PATCH /api/file-promotions/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  FilePromotionDTO partialUpdateFilePromotion(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull FilePromotionDTO filePromotionDTO);

  /**
   * 
   * Similar to <code>partialUpdateFilePromotion</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param filePromotionDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /api/file-promotions/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<FilePromotionDTO> partialUpdateFilePromotionWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull FilePromotionDTO filePromotionDTO);



  /**
   * 
   * 
   * @param id  (required)
   * @param filePromotionDTO  (required)
   * @return FilePromotionDTO
   */
  @RequestLine("PUT /api/file-promotions/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  FilePromotionDTO updateFilePromotion(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull FilePromotionDTO filePromotionDTO);

  /**
   * 
   * Similar to <code>updateFilePromotion</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param filePromotionDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/file-promotions/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<FilePromotionDTO> updateFilePromotionWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull FilePromotionDTO filePromotionDTO);


}
