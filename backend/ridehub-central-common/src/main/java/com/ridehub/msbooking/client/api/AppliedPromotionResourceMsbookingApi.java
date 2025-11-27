package com.ridehub.msbooking.client.api;

import com.ridehub.msbooking.client.invoker.ApiClient;
import com.ridehub.msbooking.client.invoker.EncodingUtils;
import com.ridehub.msbooking.client.model.ApiResponse;

import com.ridehub.msbooking.client.model.AppliedPromotionDTO;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface AppliedPromotionResourceMsbookingApi extends ApiClient.Api {


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
   * @param promotionIdEquals  (optional)
   * @param promotionIdNotEquals  (optional)
   * @param promotionIdSpecified  (optional)
   * @param promotionIdIn  (optional)
   * @param promotionIdNotIn  (optional)
   * @param promotionCodeContains  (optional)
   * @param promotionCodeDoesNotContain  (optional)
   * @param promotionCodeEquals  (optional)
   * @param promotionCodeNotEquals  (optional)
   * @param promotionCodeSpecified  (optional)
   * @param promotionCodeIn  (optional)
   * @param promotionCodeNotIn  (optional)
   * @param discountAmountGreaterThan  (optional)
   * @param discountAmountLessThan  (optional)
   * @param discountAmountGreaterThanOrEqual  (optional)
   * @param discountAmountLessThanOrEqual  (optional)
   * @param discountAmountEquals  (optional)
   * @param discountAmountNotEquals  (optional)
   * @param discountAmountSpecified  (optional)
   * @param discountAmountIn  (optional)
   * @param discountAmountNotIn  (optional)
   * @param appliedAtGreaterThan  (optional)
   * @param appliedAtLessThan  (optional)
   * @param appliedAtGreaterThanOrEqual  (optional)
   * @param appliedAtLessThanOrEqual  (optional)
   * @param appliedAtEquals  (optional)
   * @param appliedAtNotEquals  (optional)
   * @param appliedAtSpecified  (optional)
   * @param appliedAtIn  (optional)
   * @param appliedAtNotIn  (optional)
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
   * @param bookingIdGreaterThan  (optional)
   * @param bookingIdLessThan  (optional)
   * @param bookingIdGreaterThanOrEqual  (optional)
   * @param bookingIdLessThanOrEqual  (optional)
   * @param bookingIdEquals  (optional)
   * @param bookingIdNotEquals  (optional)
   * @param bookingIdSpecified  (optional)
   * @param bookingIdIn  (optional)
   * @param bookingIdNotIn  (optional)
   * @param distinct  (optional)
   * @return Long
   */
  @RequestLine("GET /api/applied-promotions/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&promotionCode.contains={promotionCodeContains}&promotionCode.doesNotContain={promotionCodeDoesNotContain}&promotionCode.equals={promotionCodeEquals}&promotionCode.notEquals={promotionCodeNotEquals}&promotionCode.specified={promotionCodeSpecified}&promotionCode.in={promotionCodeIn}&promotionCode.notIn={promotionCodeNotIn}&discountAmount.greaterThan={discountAmountGreaterThan}&discountAmount.lessThan={discountAmountLessThan}&discountAmount.greaterThanOrEqual={discountAmountGreaterThanOrEqual}&discountAmount.lessThanOrEqual={discountAmountLessThanOrEqual}&discountAmount.equals={discountAmountEquals}&discountAmount.notEquals={discountAmountNotEquals}&discountAmount.specified={discountAmountSpecified}&discountAmount.in={discountAmountIn}&discountAmount.notIn={discountAmountNotIn}&appliedAt.greaterThan={appliedAtGreaterThan}&appliedAt.lessThan={appliedAtLessThan}&appliedAt.greaterThanOrEqual={appliedAtGreaterThanOrEqual}&appliedAt.lessThanOrEqual={appliedAtLessThanOrEqual}&appliedAt.equals={appliedAtEquals}&appliedAt.notEquals={appliedAtNotEquals}&appliedAt.specified={appliedAtSpecified}&appliedAt.in={appliedAtIn}&appliedAt.notIn={appliedAtNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  Long countAppliedPromotions(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("promotionIdEquals") @jakarta.annotation.Nullable UUID promotionIdEquals, @Param("promotionIdNotEquals") @jakarta.annotation.Nullable UUID promotionIdNotEquals, @Param("promotionIdSpecified") @jakarta.annotation.Nullable Boolean promotionIdSpecified, @Param("promotionIdIn") @jakarta.annotation.Nullable List<UUID> promotionIdIn, @Param("promotionIdNotIn") @jakarta.annotation.Nullable List<UUID> promotionIdNotIn, @Param("promotionCodeContains") @jakarta.annotation.Nullable String promotionCodeContains, @Param("promotionCodeDoesNotContain") @jakarta.annotation.Nullable String promotionCodeDoesNotContain, @Param("promotionCodeEquals") @jakarta.annotation.Nullable String promotionCodeEquals, @Param("promotionCodeNotEquals") @jakarta.annotation.Nullable String promotionCodeNotEquals, @Param("promotionCodeSpecified") @jakarta.annotation.Nullable Boolean promotionCodeSpecified, @Param("promotionCodeIn") @jakarta.annotation.Nullable List<String> promotionCodeIn, @Param("promotionCodeNotIn") @jakarta.annotation.Nullable List<String> promotionCodeNotIn, @Param("discountAmountGreaterThan") @jakarta.annotation.Nullable BigDecimal discountAmountGreaterThan, @Param("discountAmountLessThan") @jakarta.annotation.Nullable BigDecimal discountAmountLessThan, @Param("discountAmountGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal discountAmountGreaterThanOrEqual, @Param("discountAmountLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal discountAmountLessThanOrEqual, @Param("discountAmountEquals") @jakarta.annotation.Nullable BigDecimal discountAmountEquals, @Param("discountAmountNotEquals") @jakarta.annotation.Nullable BigDecimal discountAmountNotEquals, @Param("discountAmountSpecified") @jakarta.annotation.Nullable Boolean discountAmountSpecified, @Param("discountAmountIn") @jakarta.annotation.Nullable List<BigDecimal> discountAmountIn, @Param("discountAmountNotIn") @jakarta.annotation.Nullable List<BigDecimal> discountAmountNotIn, @Param("appliedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime appliedAtGreaterThan, @Param("appliedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime appliedAtLessThan, @Param("appliedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime appliedAtGreaterThanOrEqual, @Param("appliedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime appliedAtLessThanOrEqual, @Param("appliedAtEquals") @jakarta.annotation.Nullable OffsetDateTime appliedAtEquals, @Param("appliedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime appliedAtNotEquals, @Param("appliedAtSpecified") @jakarta.annotation.Nullable Boolean appliedAtSpecified, @Param("appliedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> appliedAtIn, @Param("appliedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> appliedAtNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("bookingIdGreaterThan") @jakarta.annotation.Nullable Long bookingIdGreaterThan, @Param("bookingIdLessThan") @jakarta.annotation.Nullable Long bookingIdLessThan, @Param("bookingIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long bookingIdGreaterThanOrEqual, @Param("bookingIdLessThanOrEqual") @jakarta.annotation.Nullable Long bookingIdLessThanOrEqual, @Param("bookingIdEquals") @jakarta.annotation.Nullable Long bookingIdEquals, @Param("bookingIdNotEquals") @jakarta.annotation.Nullable Long bookingIdNotEquals, @Param("bookingIdSpecified") @jakarta.annotation.Nullable Boolean bookingIdSpecified, @Param("bookingIdIn") @jakarta.annotation.Nullable List<Long> bookingIdIn, @Param("bookingIdNotIn") @jakarta.annotation.Nullable List<Long> bookingIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>countAppliedPromotions</code> but it also returns the http response headers .
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
   * @param promotionIdEquals  (optional)
   * @param promotionIdNotEquals  (optional)
   * @param promotionIdSpecified  (optional)
   * @param promotionIdIn  (optional)
   * @param promotionIdNotIn  (optional)
   * @param promotionCodeContains  (optional)
   * @param promotionCodeDoesNotContain  (optional)
   * @param promotionCodeEquals  (optional)
   * @param promotionCodeNotEquals  (optional)
   * @param promotionCodeSpecified  (optional)
   * @param promotionCodeIn  (optional)
   * @param promotionCodeNotIn  (optional)
   * @param discountAmountGreaterThan  (optional)
   * @param discountAmountLessThan  (optional)
   * @param discountAmountGreaterThanOrEqual  (optional)
   * @param discountAmountLessThanOrEqual  (optional)
   * @param discountAmountEquals  (optional)
   * @param discountAmountNotEquals  (optional)
   * @param discountAmountSpecified  (optional)
   * @param discountAmountIn  (optional)
   * @param discountAmountNotIn  (optional)
   * @param appliedAtGreaterThan  (optional)
   * @param appliedAtLessThan  (optional)
   * @param appliedAtGreaterThanOrEqual  (optional)
   * @param appliedAtLessThanOrEqual  (optional)
   * @param appliedAtEquals  (optional)
   * @param appliedAtNotEquals  (optional)
   * @param appliedAtSpecified  (optional)
   * @param appliedAtIn  (optional)
   * @param appliedAtNotIn  (optional)
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
   * @param bookingIdGreaterThan  (optional)
   * @param bookingIdLessThan  (optional)
   * @param bookingIdGreaterThanOrEqual  (optional)
   * @param bookingIdLessThanOrEqual  (optional)
   * @param bookingIdEquals  (optional)
   * @param bookingIdNotEquals  (optional)
   * @param bookingIdSpecified  (optional)
   * @param bookingIdIn  (optional)
   * @param bookingIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/applied-promotions/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&promotionCode.contains={promotionCodeContains}&promotionCode.doesNotContain={promotionCodeDoesNotContain}&promotionCode.equals={promotionCodeEquals}&promotionCode.notEquals={promotionCodeNotEquals}&promotionCode.specified={promotionCodeSpecified}&promotionCode.in={promotionCodeIn}&promotionCode.notIn={promotionCodeNotIn}&discountAmount.greaterThan={discountAmountGreaterThan}&discountAmount.lessThan={discountAmountLessThan}&discountAmount.greaterThanOrEqual={discountAmountGreaterThanOrEqual}&discountAmount.lessThanOrEqual={discountAmountLessThanOrEqual}&discountAmount.equals={discountAmountEquals}&discountAmount.notEquals={discountAmountNotEquals}&discountAmount.specified={discountAmountSpecified}&discountAmount.in={discountAmountIn}&discountAmount.notIn={discountAmountNotIn}&appliedAt.greaterThan={appliedAtGreaterThan}&appliedAt.lessThan={appliedAtLessThan}&appliedAt.greaterThanOrEqual={appliedAtGreaterThanOrEqual}&appliedAt.lessThanOrEqual={appliedAtLessThanOrEqual}&appliedAt.equals={appliedAtEquals}&appliedAt.notEquals={appliedAtNotEquals}&appliedAt.specified={appliedAtSpecified}&appliedAt.in={appliedAtIn}&appliedAt.notIn={appliedAtNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Long> countAppliedPromotionsWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("promotionIdEquals") @jakarta.annotation.Nullable UUID promotionIdEquals, @Param("promotionIdNotEquals") @jakarta.annotation.Nullable UUID promotionIdNotEquals, @Param("promotionIdSpecified") @jakarta.annotation.Nullable Boolean promotionIdSpecified, @Param("promotionIdIn") @jakarta.annotation.Nullable List<UUID> promotionIdIn, @Param("promotionIdNotIn") @jakarta.annotation.Nullable List<UUID> promotionIdNotIn, @Param("promotionCodeContains") @jakarta.annotation.Nullable String promotionCodeContains, @Param("promotionCodeDoesNotContain") @jakarta.annotation.Nullable String promotionCodeDoesNotContain, @Param("promotionCodeEquals") @jakarta.annotation.Nullable String promotionCodeEquals, @Param("promotionCodeNotEquals") @jakarta.annotation.Nullable String promotionCodeNotEquals, @Param("promotionCodeSpecified") @jakarta.annotation.Nullable Boolean promotionCodeSpecified, @Param("promotionCodeIn") @jakarta.annotation.Nullable List<String> promotionCodeIn, @Param("promotionCodeNotIn") @jakarta.annotation.Nullable List<String> promotionCodeNotIn, @Param("discountAmountGreaterThan") @jakarta.annotation.Nullable BigDecimal discountAmountGreaterThan, @Param("discountAmountLessThan") @jakarta.annotation.Nullable BigDecimal discountAmountLessThan, @Param("discountAmountGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal discountAmountGreaterThanOrEqual, @Param("discountAmountLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal discountAmountLessThanOrEqual, @Param("discountAmountEquals") @jakarta.annotation.Nullable BigDecimal discountAmountEquals, @Param("discountAmountNotEquals") @jakarta.annotation.Nullable BigDecimal discountAmountNotEquals, @Param("discountAmountSpecified") @jakarta.annotation.Nullable Boolean discountAmountSpecified, @Param("discountAmountIn") @jakarta.annotation.Nullable List<BigDecimal> discountAmountIn, @Param("discountAmountNotIn") @jakarta.annotation.Nullable List<BigDecimal> discountAmountNotIn, @Param("appliedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime appliedAtGreaterThan, @Param("appliedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime appliedAtLessThan, @Param("appliedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime appliedAtGreaterThanOrEqual, @Param("appliedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime appliedAtLessThanOrEqual, @Param("appliedAtEquals") @jakarta.annotation.Nullable OffsetDateTime appliedAtEquals, @Param("appliedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime appliedAtNotEquals, @Param("appliedAtSpecified") @jakarta.annotation.Nullable Boolean appliedAtSpecified, @Param("appliedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> appliedAtIn, @Param("appliedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> appliedAtNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("bookingIdGreaterThan") @jakarta.annotation.Nullable Long bookingIdGreaterThan, @Param("bookingIdLessThan") @jakarta.annotation.Nullable Long bookingIdLessThan, @Param("bookingIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long bookingIdGreaterThanOrEqual, @Param("bookingIdLessThanOrEqual") @jakarta.annotation.Nullable Long bookingIdLessThanOrEqual, @Param("bookingIdEquals") @jakarta.annotation.Nullable Long bookingIdEquals, @Param("bookingIdNotEquals") @jakarta.annotation.Nullable Long bookingIdNotEquals, @Param("bookingIdSpecified") @jakarta.annotation.Nullable Boolean bookingIdSpecified, @Param("bookingIdIn") @jakarta.annotation.Nullable List<Long> bookingIdIn, @Param("bookingIdNotIn") @jakarta.annotation.Nullable List<Long> bookingIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>countAppliedPromotions</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CountAppliedPromotionsQueryParams} class that allows for
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
   *   <li>promotionIdEquals -  (optional)</li>
   *   <li>promotionIdNotEquals -  (optional)</li>
   *   <li>promotionIdSpecified -  (optional)</li>
   *   <li>promotionIdIn -  (optional)</li>
   *   <li>promotionIdNotIn -  (optional)</li>
   *   <li>promotionCodeContains -  (optional)</li>
   *   <li>promotionCodeDoesNotContain -  (optional)</li>
   *   <li>promotionCodeEquals -  (optional)</li>
   *   <li>promotionCodeNotEquals -  (optional)</li>
   *   <li>promotionCodeSpecified -  (optional)</li>
   *   <li>promotionCodeIn -  (optional)</li>
   *   <li>promotionCodeNotIn -  (optional)</li>
   *   <li>discountAmountGreaterThan -  (optional)</li>
   *   <li>discountAmountLessThan -  (optional)</li>
   *   <li>discountAmountGreaterThanOrEqual -  (optional)</li>
   *   <li>discountAmountLessThanOrEqual -  (optional)</li>
   *   <li>discountAmountEquals -  (optional)</li>
   *   <li>discountAmountNotEquals -  (optional)</li>
   *   <li>discountAmountSpecified -  (optional)</li>
   *   <li>discountAmountIn -  (optional)</li>
   *   <li>discountAmountNotIn -  (optional)</li>
   *   <li>appliedAtGreaterThan -  (optional)</li>
   *   <li>appliedAtLessThan -  (optional)</li>
   *   <li>appliedAtGreaterThanOrEqual -  (optional)</li>
   *   <li>appliedAtLessThanOrEqual -  (optional)</li>
   *   <li>appliedAtEquals -  (optional)</li>
   *   <li>appliedAtNotEquals -  (optional)</li>
   *   <li>appliedAtSpecified -  (optional)</li>
   *   <li>appliedAtIn -  (optional)</li>
   *   <li>appliedAtNotIn -  (optional)</li>
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
   *   <li>bookingIdGreaterThan -  (optional)</li>
   *   <li>bookingIdLessThan -  (optional)</li>
   *   <li>bookingIdGreaterThanOrEqual -  (optional)</li>
   *   <li>bookingIdLessThanOrEqual -  (optional)</li>
   *   <li>bookingIdEquals -  (optional)</li>
   *   <li>bookingIdNotEquals -  (optional)</li>
   *   <li>bookingIdSpecified -  (optional)</li>
   *   <li>bookingIdIn -  (optional)</li>
   *   <li>bookingIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return Long
   */
  @RequestLine("GET /api/applied-promotions/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&promotionCode.contains={promotionCodeContains}&promotionCode.doesNotContain={promotionCodeDoesNotContain}&promotionCode.equals={promotionCodeEquals}&promotionCode.notEquals={promotionCodeNotEquals}&promotionCode.specified={promotionCodeSpecified}&promotionCode.in={promotionCodeIn}&promotionCode.notIn={promotionCodeNotIn}&discountAmount.greaterThan={discountAmountGreaterThan}&discountAmount.lessThan={discountAmountLessThan}&discountAmount.greaterThanOrEqual={discountAmountGreaterThanOrEqual}&discountAmount.lessThanOrEqual={discountAmountLessThanOrEqual}&discountAmount.equals={discountAmountEquals}&discountAmount.notEquals={discountAmountNotEquals}&discountAmount.specified={discountAmountSpecified}&discountAmount.in={discountAmountIn}&discountAmount.notIn={discountAmountNotIn}&appliedAt.greaterThan={appliedAtGreaterThan}&appliedAt.lessThan={appliedAtLessThan}&appliedAt.greaterThanOrEqual={appliedAtGreaterThanOrEqual}&appliedAt.lessThanOrEqual={appliedAtLessThanOrEqual}&appliedAt.equals={appliedAtEquals}&appliedAt.notEquals={appliedAtNotEquals}&appliedAt.specified={appliedAtSpecified}&appliedAt.in={appliedAtIn}&appliedAt.notIn={appliedAtNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  Long countAppliedPromotions(@QueryMap(encoded=true) CountAppliedPromotionsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>countAppliedPromotions</code> that receives the query parameters as a map,
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
          *   <li>promotionIdEquals -  (optional)</li>
          *   <li>promotionIdNotEquals -  (optional)</li>
          *   <li>promotionIdSpecified -  (optional)</li>
          *   <li>promotionIdIn -  (optional)</li>
          *   <li>promotionIdNotIn -  (optional)</li>
          *   <li>promotionCodeContains -  (optional)</li>
          *   <li>promotionCodeDoesNotContain -  (optional)</li>
          *   <li>promotionCodeEquals -  (optional)</li>
          *   <li>promotionCodeNotEquals -  (optional)</li>
          *   <li>promotionCodeSpecified -  (optional)</li>
          *   <li>promotionCodeIn -  (optional)</li>
          *   <li>promotionCodeNotIn -  (optional)</li>
          *   <li>discountAmountGreaterThan -  (optional)</li>
          *   <li>discountAmountLessThan -  (optional)</li>
          *   <li>discountAmountGreaterThanOrEqual -  (optional)</li>
          *   <li>discountAmountLessThanOrEqual -  (optional)</li>
          *   <li>discountAmountEquals -  (optional)</li>
          *   <li>discountAmountNotEquals -  (optional)</li>
          *   <li>discountAmountSpecified -  (optional)</li>
          *   <li>discountAmountIn -  (optional)</li>
          *   <li>discountAmountNotIn -  (optional)</li>
          *   <li>appliedAtGreaterThan -  (optional)</li>
          *   <li>appliedAtLessThan -  (optional)</li>
          *   <li>appliedAtGreaterThanOrEqual -  (optional)</li>
          *   <li>appliedAtLessThanOrEqual -  (optional)</li>
          *   <li>appliedAtEquals -  (optional)</li>
          *   <li>appliedAtNotEquals -  (optional)</li>
          *   <li>appliedAtSpecified -  (optional)</li>
          *   <li>appliedAtIn -  (optional)</li>
          *   <li>appliedAtNotIn -  (optional)</li>
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
          *   <li>bookingIdGreaterThan -  (optional)</li>
          *   <li>bookingIdLessThan -  (optional)</li>
          *   <li>bookingIdGreaterThanOrEqual -  (optional)</li>
          *   <li>bookingIdLessThanOrEqual -  (optional)</li>
          *   <li>bookingIdEquals -  (optional)</li>
          *   <li>bookingIdNotEquals -  (optional)</li>
          *   <li>bookingIdSpecified -  (optional)</li>
          *   <li>bookingIdIn -  (optional)</li>
          *   <li>bookingIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return Long
      */
      @RequestLine("GET /api/applied-promotions/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&promotionCode.contains={promotionCodeContains}&promotionCode.doesNotContain={promotionCodeDoesNotContain}&promotionCode.equals={promotionCodeEquals}&promotionCode.notEquals={promotionCodeNotEquals}&promotionCode.specified={promotionCodeSpecified}&promotionCode.in={promotionCodeIn}&promotionCode.notIn={promotionCodeNotIn}&discountAmount.greaterThan={discountAmountGreaterThan}&discountAmount.lessThan={discountAmountLessThan}&discountAmount.greaterThanOrEqual={discountAmountGreaterThanOrEqual}&discountAmount.lessThanOrEqual={discountAmountLessThanOrEqual}&discountAmount.equals={discountAmountEquals}&discountAmount.notEquals={discountAmountNotEquals}&discountAmount.specified={discountAmountSpecified}&discountAmount.in={discountAmountIn}&discountAmount.notIn={discountAmountNotIn}&appliedAt.greaterThan={appliedAtGreaterThan}&appliedAt.lessThan={appliedAtLessThan}&appliedAt.greaterThanOrEqual={appliedAtGreaterThanOrEqual}&appliedAt.lessThanOrEqual={appliedAtLessThanOrEqual}&appliedAt.equals={appliedAtEquals}&appliedAt.notEquals={appliedAtNotEquals}&appliedAt.specified={appliedAtSpecified}&appliedAt.in={appliedAtIn}&appliedAt.notIn={appliedAtNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Long> countAppliedPromotionsWithHttpInfo(@QueryMap(encoded=true) CountAppliedPromotionsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>countAppliedPromotions</code> method in a fluent style.
   */
  public static class CountAppliedPromotionsQueryParams extends HashMap<String, Object> {
    public CountAppliedPromotionsQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppliedPromotionsQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppliedPromotionsQueryParams promotionIdEquals(@jakarta.annotation.Nullable final UUID value) {
      put("promotionId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams promotionIdNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("promotionId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams promotionIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("promotionId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams promotionIdIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("promotionId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppliedPromotionsQueryParams promotionIdNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("promotionId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppliedPromotionsQueryParams promotionCodeContains(@jakarta.annotation.Nullable final String value) {
      put("promotionCode.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams promotionCodeDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("promotionCode.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams promotionCodeEquals(@jakarta.annotation.Nullable final String value) {
      put("promotionCode.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams promotionCodeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("promotionCode.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams promotionCodeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("promotionCode.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams promotionCodeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("promotionCode.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppliedPromotionsQueryParams promotionCodeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("promotionCode.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppliedPromotionsQueryParams discountAmountGreaterThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("discountAmount.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams discountAmountLessThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("discountAmount.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams discountAmountGreaterThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("discountAmount.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams discountAmountLessThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("discountAmount.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams discountAmountEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("discountAmount.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams discountAmountNotEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("discountAmount.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams discountAmountSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("discountAmount.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams discountAmountIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("discountAmount.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppliedPromotionsQueryParams discountAmountNotIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("discountAmount.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppliedPromotionsQueryParams appliedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("appliedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams appliedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("appliedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams appliedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("appliedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams appliedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("appliedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams appliedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("appliedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams appliedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("appliedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams appliedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("appliedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams appliedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("appliedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppliedPromotionsQueryParams appliedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("appliedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppliedPromotionsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppliedPromotionsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppliedPromotionsQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppliedPromotionsQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppliedPromotionsQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppliedPromotionsQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppliedPromotionsQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppliedPromotionsQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppliedPromotionsQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppliedPromotionsQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppliedPromotionsQueryParams bookingIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams bookingIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams bookingIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams bookingIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams bookingIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams bookingIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams bookingIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("bookingId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountAppliedPromotionsQueryParams bookingIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("bookingId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppliedPromotionsQueryParams bookingIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("bookingId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountAppliedPromotionsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param appliedPromotionDTO  (required)
   * @return AppliedPromotionDTO
   */
  @RequestLine("POST /api/applied-promotions")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  AppliedPromotionDTO createAppliedPromotion(@jakarta.annotation.Nonnull AppliedPromotionDTO appliedPromotionDTO);

  /**
   * 
   * Similar to <code>createAppliedPromotion</code> but it also returns the http response headers .
   * 
   * @param appliedPromotionDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/applied-promotions")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<AppliedPromotionDTO> createAppliedPromotionWithHttpInfo(@jakarta.annotation.Nonnull AppliedPromotionDTO appliedPromotionDTO);



  /**
   * 
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/applied-promotions/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteAppliedPromotion(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>deleteAppliedPromotion</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/applied-promotions/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteAppliedPromotionWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



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
   * @param promotionIdEquals  (optional)
   * @param promotionIdNotEquals  (optional)
   * @param promotionIdSpecified  (optional)
   * @param promotionIdIn  (optional)
   * @param promotionIdNotIn  (optional)
   * @param promotionCodeContains  (optional)
   * @param promotionCodeDoesNotContain  (optional)
   * @param promotionCodeEquals  (optional)
   * @param promotionCodeNotEquals  (optional)
   * @param promotionCodeSpecified  (optional)
   * @param promotionCodeIn  (optional)
   * @param promotionCodeNotIn  (optional)
   * @param discountAmountGreaterThan  (optional)
   * @param discountAmountLessThan  (optional)
   * @param discountAmountGreaterThanOrEqual  (optional)
   * @param discountAmountLessThanOrEqual  (optional)
   * @param discountAmountEquals  (optional)
   * @param discountAmountNotEquals  (optional)
   * @param discountAmountSpecified  (optional)
   * @param discountAmountIn  (optional)
   * @param discountAmountNotIn  (optional)
   * @param appliedAtGreaterThan  (optional)
   * @param appliedAtLessThan  (optional)
   * @param appliedAtGreaterThanOrEqual  (optional)
   * @param appliedAtLessThanOrEqual  (optional)
   * @param appliedAtEquals  (optional)
   * @param appliedAtNotEquals  (optional)
   * @param appliedAtSpecified  (optional)
   * @param appliedAtIn  (optional)
   * @param appliedAtNotIn  (optional)
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
   * @param bookingIdGreaterThan  (optional)
   * @param bookingIdLessThan  (optional)
   * @param bookingIdGreaterThanOrEqual  (optional)
   * @param bookingIdLessThanOrEqual  (optional)
   * @param bookingIdEquals  (optional)
   * @param bookingIdNotEquals  (optional)
   * @param bookingIdSpecified  (optional)
   * @param bookingIdIn  (optional)
   * @param bookingIdNotIn  (optional)
   * @param distinct  (optional)
   * @return List&lt;AppliedPromotionDTO&gt;
   */
  @RequestLine("GET /api/applied-promotions?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&promotionCode.contains={promotionCodeContains}&promotionCode.doesNotContain={promotionCodeDoesNotContain}&promotionCode.equals={promotionCodeEquals}&promotionCode.notEquals={promotionCodeNotEquals}&promotionCode.specified={promotionCodeSpecified}&promotionCode.in={promotionCodeIn}&promotionCode.notIn={promotionCodeNotIn}&discountAmount.greaterThan={discountAmountGreaterThan}&discountAmount.lessThan={discountAmountLessThan}&discountAmount.greaterThanOrEqual={discountAmountGreaterThanOrEqual}&discountAmount.lessThanOrEqual={discountAmountLessThanOrEqual}&discountAmount.equals={discountAmountEquals}&discountAmount.notEquals={discountAmountNotEquals}&discountAmount.specified={discountAmountSpecified}&discountAmount.in={discountAmountIn}&discountAmount.notIn={discountAmountNotIn}&appliedAt.greaterThan={appliedAtGreaterThan}&appliedAt.lessThan={appliedAtLessThan}&appliedAt.greaterThanOrEqual={appliedAtGreaterThanOrEqual}&appliedAt.lessThanOrEqual={appliedAtLessThanOrEqual}&appliedAt.equals={appliedAtEquals}&appliedAt.notEquals={appliedAtNotEquals}&appliedAt.specified={appliedAtSpecified}&appliedAt.in={appliedAtIn}&appliedAt.notIn={appliedAtNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  List<AppliedPromotionDTO> getAllAppliedPromotions(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("promotionIdEquals") @jakarta.annotation.Nullable UUID promotionIdEquals, @Param("promotionIdNotEquals") @jakarta.annotation.Nullable UUID promotionIdNotEquals, @Param("promotionIdSpecified") @jakarta.annotation.Nullable Boolean promotionIdSpecified, @Param("promotionIdIn") @jakarta.annotation.Nullable List<UUID> promotionIdIn, @Param("promotionIdNotIn") @jakarta.annotation.Nullable List<UUID> promotionIdNotIn, @Param("promotionCodeContains") @jakarta.annotation.Nullable String promotionCodeContains, @Param("promotionCodeDoesNotContain") @jakarta.annotation.Nullable String promotionCodeDoesNotContain, @Param("promotionCodeEquals") @jakarta.annotation.Nullable String promotionCodeEquals, @Param("promotionCodeNotEquals") @jakarta.annotation.Nullable String promotionCodeNotEquals, @Param("promotionCodeSpecified") @jakarta.annotation.Nullable Boolean promotionCodeSpecified, @Param("promotionCodeIn") @jakarta.annotation.Nullable List<String> promotionCodeIn, @Param("promotionCodeNotIn") @jakarta.annotation.Nullable List<String> promotionCodeNotIn, @Param("discountAmountGreaterThan") @jakarta.annotation.Nullable BigDecimal discountAmountGreaterThan, @Param("discountAmountLessThan") @jakarta.annotation.Nullable BigDecimal discountAmountLessThan, @Param("discountAmountGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal discountAmountGreaterThanOrEqual, @Param("discountAmountLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal discountAmountLessThanOrEqual, @Param("discountAmountEquals") @jakarta.annotation.Nullable BigDecimal discountAmountEquals, @Param("discountAmountNotEquals") @jakarta.annotation.Nullable BigDecimal discountAmountNotEquals, @Param("discountAmountSpecified") @jakarta.annotation.Nullable Boolean discountAmountSpecified, @Param("discountAmountIn") @jakarta.annotation.Nullable List<BigDecimal> discountAmountIn, @Param("discountAmountNotIn") @jakarta.annotation.Nullable List<BigDecimal> discountAmountNotIn, @Param("appliedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime appliedAtGreaterThan, @Param("appliedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime appliedAtLessThan, @Param("appliedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime appliedAtGreaterThanOrEqual, @Param("appliedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime appliedAtLessThanOrEqual, @Param("appliedAtEquals") @jakarta.annotation.Nullable OffsetDateTime appliedAtEquals, @Param("appliedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime appliedAtNotEquals, @Param("appliedAtSpecified") @jakarta.annotation.Nullable Boolean appliedAtSpecified, @Param("appliedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> appliedAtIn, @Param("appliedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> appliedAtNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("bookingIdGreaterThan") @jakarta.annotation.Nullable Long bookingIdGreaterThan, @Param("bookingIdLessThan") @jakarta.annotation.Nullable Long bookingIdLessThan, @Param("bookingIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long bookingIdGreaterThanOrEqual, @Param("bookingIdLessThanOrEqual") @jakarta.annotation.Nullable Long bookingIdLessThanOrEqual, @Param("bookingIdEquals") @jakarta.annotation.Nullable Long bookingIdEquals, @Param("bookingIdNotEquals") @jakarta.annotation.Nullable Long bookingIdNotEquals, @Param("bookingIdSpecified") @jakarta.annotation.Nullable Boolean bookingIdSpecified, @Param("bookingIdIn") @jakarta.annotation.Nullable List<Long> bookingIdIn, @Param("bookingIdNotIn") @jakarta.annotation.Nullable List<Long> bookingIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>getAllAppliedPromotions</code> but it also returns the http response headers .
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
   * @param promotionIdEquals  (optional)
   * @param promotionIdNotEquals  (optional)
   * @param promotionIdSpecified  (optional)
   * @param promotionIdIn  (optional)
   * @param promotionIdNotIn  (optional)
   * @param promotionCodeContains  (optional)
   * @param promotionCodeDoesNotContain  (optional)
   * @param promotionCodeEquals  (optional)
   * @param promotionCodeNotEquals  (optional)
   * @param promotionCodeSpecified  (optional)
   * @param promotionCodeIn  (optional)
   * @param promotionCodeNotIn  (optional)
   * @param discountAmountGreaterThan  (optional)
   * @param discountAmountLessThan  (optional)
   * @param discountAmountGreaterThanOrEqual  (optional)
   * @param discountAmountLessThanOrEqual  (optional)
   * @param discountAmountEquals  (optional)
   * @param discountAmountNotEquals  (optional)
   * @param discountAmountSpecified  (optional)
   * @param discountAmountIn  (optional)
   * @param discountAmountNotIn  (optional)
   * @param appliedAtGreaterThan  (optional)
   * @param appliedAtLessThan  (optional)
   * @param appliedAtGreaterThanOrEqual  (optional)
   * @param appliedAtLessThanOrEqual  (optional)
   * @param appliedAtEquals  (optional)
   * @param appliedAtNotEquals  (optional)
   * @param appliedAtSpecified  (optional)
   * @param appliedAtIn  (optional)
   * @param appliedAtNotIn  (optional)
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
   * @param bookingIdGreaterThan  (optional)
   * @param bookingIdLessThan  (optional)
   * @param bookingIdGreaterThanOrEqual  (optional)
   * @param bookingIdLessThanOrEqual  (optional)
   * @param bookingIdEquals  (optional)
   * @param bookingIdNotEquals  (optional)
   * @param bookingIdSpecified  (optional)
   * @param bookingIdIn  (optional)
   * @param bookingIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/applied-promotions?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&promotionCode.contains={promotionCodeContains}&promotionCode.doesNotContain={promotionCodeDoesNotContain}&promotionCode.equals={promotionCodeEquals}&promotionCode.notEquals={promotionCodeNotEquals}&promotionCode.specified={promotionCodeSpecified}&promotionCode.in={promotionCodeIn}&promotionCode.notIn={promotionCodeNotIn}&discountAmount.greaterThan={discountAmountGreaterThan}&discountAmount.lessThan={discountAmountLessThan}&discountAmount.greaterThanOrEqual={discountAmountGreaterThanOrEqual}&discountAmount.lessThanOrEqual={discountAmountLessThanOrEqual}&discountAmount.equals={discountAmountEquals}&discountAmount.notEquals={discountAmountNotEquals}&discountAmount.specified={discountAmountSpecified}&discountAmount.in={discountAmountIn}&discountAmount.notIn={discountAmountNotIn}&appliedAt.greaterThan={appliedAtGreaterThan}&appliedAt.lessThan={appliedAtLessThan}&appliedAt.greaterThanOrEqual={appliedAtGreaterThanOrEqual}&appliedAt.lessThanOrEqual={appliedAtLessThanOrEqual}&appliedAt.equals={appliedAtEquals}&appliedAt.notEquals={appliedAtNotEquals}&appliedAt.specified={appliedAtSpecified}&appliedAt.in={appliedAtIn}&appliedAt.notIn={appliedAtNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<AppliedPromotionDTO>> getAllAppliedPromotionsWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("promotionIdEquals") @jakarta.annotation.Nullable UUID promotionIdEquals, @Param("promotionIdNotEquals") @jakarta.annotation.Nullable UUID promotionIdNotEquals, @Param("promotionIdSpecified") @jakarta.annotation.Nullable Boolean promotionIdSpecified, @Param("promotionIdIn") @jakarta.annotation.Nullable List<UUID> promotionIdIn, @Param("promotionIdNotIn") @jakarta.annotation.Nullable List<UUID> promotionIdNotIn, @Param("promotionCodeContains") @jakarta.annotation.Nullable String promotionCodeContains, @Param("promotionCodeDoesNotContain") @jakarta.annotation.Nullable String promotionCodeDoesNotContain, @Param("promotionCodeEquals") @jakarta.annotation.Nullable String promotionCodeEquals, @Param("promotionCodeNotEquals") @jakarta.annotation.Nullable String promotionCodeNotEquals, @Param("promotionCodeSpecified") @jakarta.annotation.Nullable Boolean promotionCodeSpecified, @Param("promotionCodeIn") @jakarta.annotation.Nullable List<String> promotionCodeIn, @Param("promotionCodeNotIn") @jakarta.annotation.Nullable List<String> promotionCodeNotIn, @Param("discountAmountGreaterThan") @jakarta.annotation.Nullable BigDecimal discountAmountGreaterThan, @Param("discountAmountLessThan") @jakarta.annotation.Nullable BigDecimal discountAmountLessThan, @Param("discountAmountGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal discountAmountGreaterThanOrEqual, @Param("discountAmountLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal discountAmountLessThanOrEqual, @Param("discountAmountEquals") @jakarta.annotation.Nullable BigDecimal discountAmountEquals, @Param("discountAmountNotEquals") @jakarta.annotation.Nullable BigDecimal discountAmountNotEquals, @Param("discountAmountSpecified") @jakarta.annotation.Nullable Boolean discountAmountSpecified, @Param("discountAmountIn") @jakarta.annotation.Nullable List<BigDecimal> discountAmountIn, @Param("discountAmountNotIn") @jakarta.annotation.Nullable List<BigDecimal> discountAmountNotIn, @Param("appliedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime appliedAtGreaterThan, @Param("appliedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime appliedAtLessThan, @Param("appliedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime appliedAtGreaterThanOrEqual, @Param("appliedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime appliedAtLessThanOrEqual, @Param("appliedAtEquals") @jakarta.annotation.Nullable OffsetDateTime appliedAtEquals, @Param("appliedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime appliedAtNotEquals, @Param("appliedAtSpecified") @jakarta.annotation.Nullable Boolean appliedAtSpecified, @Param("appliedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> appliedAtIn, @Param("appliedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> appliedAtNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("bookingIdGreaterThan") @jakarta.annotation.Nullable Long bookingIdGreaterThan, @Param("bookingIdLessThan") @jakarta.annotation.Nullable Long bookingIdLessThan, @Param("bookingIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long bookingIdGreaterThanOrEqual, @Param("bookingIdLessThanOrEqual") @jakarta.annotation.Nullable Long bookingIdLessThanOrEqual, @Param("bookingIdEquals") @jakarta.annotation.Nullable Long bookingIdEquals, @Param("bookingIdNotEquals") @jakarta.annotation.Nullable Long bookingIdNotEquals, @Param("bookingIdSpecified") @jakarta.annotation.Nullable Boolean bookingIdSpecified, @Param("bookingIdIn") @jakarta.annotation.Nullable List<Long> bookingIdIn, @Param("bookingIdNotIn") @jakarta.annotation.Nullable List<Long> bookingIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllAppliedPromotions</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllAppliedPromotionsQueryParams} class that allows for
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
   *   <li>promotionIdEquals -  (optional)</li>
   *   <li>promotionIdNotEquals -  (optional)</li>
   *   <li>promotionIdSpecified -  (optional)</li>
   *   <li>promotionIdIn -  (optional)</li>
   *   <li>promotionIdNotIn -  (optional)</li>
   *   <li>promotionCodeContains -  (optional)</li>
   *   <li>promotionCodeDoesNotContain -  (optional)</li>
   *   <li>promotionCodeEquals -  (optional)</li>
   *   <li>promotionCodeNotEquals -  (optional)</li>
   *   <li>promotionCodeSpecified -  (optional)</li>
   *   <li>promotionCodeIn -  (optional)</li>
   *   <li>promotionCodeNotIn -  (optional)</li>
   *   <li>discountAmountGreaterThan -  (optional)</li>
   *   <li>discountAmountLessThan -  (optional)</li>
   *   <li>discountAmountGreaterThanOrEqual -  (optional)</li>
   *   <li>discountAmountLessThanOrEqual -  (optional)</li>
   *   <li>discountAmountEquals -  (optional)</li>
   *   <li>discountAmountNotEquals -  (optional)</li>
   *   <li>discountAmountSpecified -  (optional)</li>
   *   <li>discountAmountIn -  (optional)</li>
   *   <li>discountAmountNotIn -  (optional)</li>
   *   <li>appliedAtGreaterThan -  (optional)</li>
   *   <li>appliedAtLessThan -  (optional)</li>
   *   <li>appliedAtGreaterThanOrEqual -  (optional)</li>
   *   <li>appliedAtLessThanOrEqual -  (optional)</li>
   *   <li>appliedAtEquals -  (optional)</li>
   *   <li>appliedAtNotEquals -  (optional)</li>
   *   <li>appliedAtSpecified -  (optional)</li>
   *   <li>appliedAtIn -  (optional)</li>
   *   <li>appliedAtNotIn -  (optional)</li>
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
   *   <li>bookingIdGreaterThan -  (optional)</li>
   *   <li>bookingIdLessThan -  (optional)</li>
   *   <li>bookingIdGreaterThanOrEqual -  (optional)</li>
   *   <li>bookingIdLessThanOrEqual -  (optional)</li>
   *   <li>bookingIdEquals -  (optional)</li>
   *   <li>bookingIdNotEquals -  (optional)</li>
   *   <li>bookingIdSpecified -  (optional)</li>
   *   <li>bookingIdIn -  (optional)</li>
   *   <li>bookingIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return List&lt;AppliedPromotionDTO&gt;
   */
  @RequestLine("GET /api/applied-promotions?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&promotionCode.contains={promotionCodeContains}&promotionCode.doesNotContain={promotionCodeDoesNotContain}&promotionCode.equals={promotionCodeEquals}&promotionCode.notEquals={promotionCodeNotEquals}&promotionCode.specified={promotionCodeSpecified}&promotionCode.in={promotionCodeIn}&promotionCode.notIn={promotionCodeNotIn}&discountAmount.greaterThan={discountAmountGreaterThan}&discountAmount.lessThan={discountAmountLessThan}&discountAmount.greaterThanOrEqual={discountAmountGreaterThanOrEqual}&discountAmount.lessThanOrEqual={discountAmountLessThanOrEqual}&discountAmount.equals={discountAmountEquals}&discountAmount.notEquals={discountAmountNotEquals}&discountAmount.specified={discountAmountSpecified}&discountAmount.in={discountAmountIn}&discountAmount.notIn={discountAmountNotIn}&appliedAt.greaterThan={appliedAtGreaterThan}&appliedAt.lessThan={appliedAtLessThan}&appliedAt.greaterThanOrEqual={appliedAtGreaterThanOrEqual}&appliedAt.lessThanOrEqual={appliedAtLessThanOrEqual}&appliedAt.equals={appliedAtEquals}&appliedAt.notEquals={appliedAtNotEquals}&appliedAt.specified={appliedAtSpecified}&appliedAt.in={appliedAtIn}&appliedAt.notIn={appliedAtNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  List<AppliedPromotionDTO> getAllAppliedPromotions(@QueryMap(encoded=true) GetAllAppliedPromotionsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllAppliedPromotions</code> that receives the query parameters as a map,
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
          *   <li>promotionIdEquals -  (optional)</li>
          *   <li>promotionIdNotEquals -  (optional)</li>
          *   <li>promotionIdSpecified -  (optional)</li>
          *   <li>promotionIdIn -  (optional)</li>
          *   <li>promotionIdNotIn -  (optional)</li>
          *   <li>promotionCodeContains -  (optional)</li>
          *   <li>promotionCodeDoesNotContain -  (optional)</li>
          *   <li>promotionCodeEquals -  (optional)</li>
          *   <li>promotionCodeNotEquals -  (optional)</li>
          *   <li>promotionCodeSpecified -  (optional)</li>
          *   <li>promotionCodeIn -  (optional)</li>
          *   <li>promotionCodeNotIn -  (optional)</li>
          *   <li>discountAmountGreaterThan -  (optional)</li>
          *   <li>discountAmountLessThan -  (optional)</li>
          *   <li>discountAmountGreaterThanOrEqual -  (optional)</li>
          *   <li>discountAmountLessThanOrEqual -  (optional)</li>
          *   <li>discountAmountEquals -  (optional)</li>
          *   <li>discountAmountNotEquals -  (optional)</li>
          *   <li>discountAmountSpecified -  (optional)</li>
          *   <li>discountAmountIn -  (optional)</li>
          *   <li>discountAmountNotIn -  (optional)</li>
          *   <li>appliedAtGreaterThan -  (optional)</li>
          *   <li>appliedAtLessThan -  (optional)</li>
          *   <li>appliedAtGreaterThanOrEqual -  (optional)</li>
          *   <li>appliedAtLessThanOrEqual -  (optional)</li>
          *   <li>appliedAtEquals -  (optional)</li>
          *   <li>appliedAtNotEquals -  (optional)</li>
          *   <li>appliedAtSpecified -  (optional)</li>
          *   <li>appliedAtIn -  (optional)</li>
          *   <li>appliedAtNotIn -  (optional)</li>
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
          *   <li>bookingIdGreaterThan -  (optional)</li>
          *   <li>bookingIdLessThan -  (optional)</li>
          *   <li>bookingIdGreaterThanOrEqual -  (optional)</li>
          *   <li>bookingIdLessThanOrEqual -  (optional)</li>
          *   <li>bookingIdEquals -  (optional)</li>
          *   <li>bookingIdNotEquals -  (optional)</li>
          *   <li>bookingIdSpecified -  (optional)</li>
          *   <li>bookingIdIn -  (optional)</li>
          *   <li>bookingIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return List&lt;AppliedPromotionDTO&gt;
      */
      @RequestLine("GET /api/applied-promotions?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&promotionCode.contains={promotionCodeContains}&promotionCode.doesNotContain={promotionCodeDoesNotContain}&promotionCode.equals={promotionCodeEquals}&promotionCode.notEquals={promotionCodeNotEquals}&promotionCode.specified={promotionCodeSpecified}&promotionCode.in={promotionCodeIn}&promotionCode.notIn={promotionCodeNotIn}&discountAmount.greaterThan={discountAmountGreaterThan}&discountAmount.lessThan={discountAmountLessThan}&discountAmount.greaterThanOrEqual={discountAmountGreaterThanOrEqual}&discountAmount.lessThanOrEqual={discountAmountLessThanOrEqual}&discountAmount.equals={discountAmountEquals}&discountAmount.notEquals={discountAmountNotEquals}&discountAmount.specified={discountAmountSpecified}&discountAmount.in={discountAmountIn}&discountAmount.notIn={discountAmountNotIn}&appliedAt.greaterThan={appliedAtGreaterThan}&appliedAt.lessThan={appliedAtLessThan}&appliedAt.greaterThanOrEqual={appliedAtGreaterThanOrEqual}&appliedAt.lessThanOrEqual={appliedAtLessThanOrEqual}&appliedAt.equals={appliedAtEquals}&appliedAt.notEquals={appliedAtNotEquals}&appliedAt.specified={appliedAtSpecified}&appliedAt.in={appliedAtIn}&appliedAt.notIn={appliedAtNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<AppliedPromotionDTO>> getAllAppliedPromotionsWithHttpInfo(@QueryMap(encoded=true) GetAllAppliedPromotionsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllAppliedPromotions</code> method in a fluent style.
   */
  public static class GetAllAppliedPromotionsQueryParams extends HashMap<String, Object> {
    public GetAllAppliedPromotionsQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams promotionIdEquals(@jakarta.annotation.Nullable final UUID value) {
      put("promotionId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams promotionIdNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("promotionId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams promotionIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("promotionId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams promotionIdIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("promotionId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams promotionIdNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("promotionId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams promotionCodeContains(@jakarta.annotation.Nullable final String value) {
      put("promotionCode.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams promotionCodeDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("promotionCode.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams promotionCodeEquals(@jakarta.annotation.Nullable final String value) {
      put("promotionCode.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams promotionCodeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("promotionCode.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams promotionCodeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("promotionCode.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams promotionCodeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("promotionCode.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams promotionCodeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("promotionCode.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams discountAmountGreaterThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("discountAmount.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams discountAmountLessThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("discountAmount.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams discountAmountGreaterThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("discountAmount.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams discountAmountLessThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("discountAmount.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams discountAmountEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("discountAmount.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams discountAmountNotEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("discountAmount.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams discountAmountSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("discountAmount.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams discountAmountIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("discountAmount.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams discountAmountNotIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("discountAmount.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams appliedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("appliedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams appliedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("appliedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams appliedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("appliedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams appliedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("appliedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams appliedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("appliedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams appliedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("appliedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams appliedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("appliedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams appliedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("appliedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams appliedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("appliedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams bookingIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams bookingIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams bookingIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams bookingIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams bookingIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams bookingIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams bookingIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("bookingId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams bookingIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("bookingId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams bookingIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("bookingId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllAppliedPromotionsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @return AppliedPromotionDTO
   */
  @RequestLine("GET /api/applied-promotions/{id}")
  @Headers({
    "Accept: */*",
  })
  AppliedPromotionDTO getAppliedPromotion(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>getAppliedPromotion</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/applied-promotions/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<AppliedPromotionDTO> getAppliedPromotionWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param id  (required)
   * @param appliedPromotionDTO  (required)
   * @return AppliedPromotionDTO
   */
  @RequestLine("PATCH /api/applied-promotions/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  AppliedPromotionDTO partialUpdateAppliedPromotion(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull AppliedPromotionDTO appliedPromotionDTO);

  /**
   * 
   * Similar to <code>partialUpdateAppliedPromotion</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param appliedPromotionDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /api/applied-promotions/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<AppliedPromotionDTO> partialUpdateAppliedPromotionWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull AppliedPromotionDTO appliedPromotionDTO);



  /**
   * 
   * 
   * @param id  (required)
   * @param appliedPromotionDTO  (required)
   * @return AppliedPromotionDTO
   */
  @RequestLine("PUT /api/applied-promotions/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  AppliedPromotionDTO updateAppliedPromotion(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull AppliedPromotionDTO appliedPromotionDTO);

  /**
   * 
   * Similar to <code>updateAppliedPromotion</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param appliedPromotionDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/applied-promotions/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<AppliedPromotionDTO> updateAppliedPromotionWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull AppliedPromotionDTO appliedPromotionDTO);


}
