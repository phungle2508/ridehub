package com.ridehub.mspromotion.client.api;

import com.ridehub.mspromotion.client.invoker.ApiClient;
import com.ridehub.mspromotion.client.invoker.EncodingUtils;
import com.ridehub.mspromotion.client.model.ApiResponse;

import com.ridehub.mspromotion.client.model.BuyNGetMFreeDTO;
import java.time.OffsetDateTime;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface BuyNGetMFreeResourceMspromotionApi extends ApiClient.Api {


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
   * @param buyNGreaterThan  (optional)
   * @param buyNLessThan  (optional)
   * @param buyNGreaterThanOrEqual  (optional)
   * @param buyNLessThanOrEqual  (optional)
   * @param buyNEquals  (optional)
   * @param buyNNotEquals  (optional)
   * @param buyNSpecified  (optional)
   * @param buyNIn  (optional)
   * @param buyNNotIn  (optional)
   * @param getMGreaterThan  (optional)
   * @param getMLessThan  (optional)
   * @param getMGreaterThanOrEqual  (optional)
   * @param getMLessThanOrEqual  (optional)
   * @param getMEquals  (optional)
   * @param getMNotEquals  (optional)
   * @param getMSpecified  (optional)
   * @param getMIn  (optional)
   * @param getMNotIn  (optional)
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
  @RequestLine("GET /api/buy-n-get-m-frees/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&buyN.greaterThan={buyNGreaterThan}&buyN.lessThan={buyNLessThan}&buyN.greaterThanOrEqual={buyNGreaterThanOrEqual}&buyN.lessThanOrEqual={buyNLessThanOrEqual}&buyN.equals={buyNEquals}&buyN.notEquals={buyNNotEquals}&buyN.specified={buyNSpecified}&buyN.in={buyNIn}&buyN.notIn={buyNNotIn}&getM.greaterThan={getMGreaterThan}&getM.lessThan={getMLessThan}&getM.greaterThanOrEqual={getMGreaterThanOrEqual}&getM.lessThanOrEqual={getMLessThanOrEqual}&getM.equals={getMEquals}&getM.notEquals={getMNotEquals}&getM.specified={getMSpecified}&getM.in={getMIn}&getM.notIn={getMNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  Long countBuyNGetMFrees(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("buyNGreaterThan") @jakarta.annotation.Nullable Integer buyNGreaterThan, @Param("buyNLessThan") @jakarta.annotation.Nullable Integer buyNLessThan, @Param("buyNGreaterThanOrEqual") @jakarta.annotation.Nullable Integer buyNGreaterThanOrEqual, @Param("buyNLessThanOrEqual") @jakarta.annotation.Nullable Integer buyNLessThanOrEqual, @Param("buyNEquals") @jakarta.annotation.Nullable Integer buyNEquals, @Param("buyNNotEquals") @jakarta.annotation.Nullable Integer buyNNotEquals, @Param("buyNSpecified") @jakarta.annotation.Nullable Boolean buyNSpecified, @Param("buyNIn") @jakarta.annotation.Nullable List<Integer> buyNIn, @Param("buyNNotIn") @jakarta.annotation.Nullable List<Integer> buyNNotIn, @Param("getMGreaterThan") @jakarta.annotation.Nullable Integer getMGreaterThan, @Param("getMLessThan") @jakarta.annotation.Nullable Integer getMLessThan, @Param("getMGreaterThanOrEqual") @jakarta.annotation.Nullable Integer getMGreaterThanOrEqual, @Param("getMLessThanOrEqual") @jakarta.annotation.Nullable Integer getMLessThanOrEqual, @Param("getMEquals") @jakarta.annotation.Nullable Integer getMEquals, @Param("getMNotEquals") @jakarta.annotation.Nullable Integer getMNotEquals, @Param("getMSpecified") @jakarta.annotation.Nullable Boolean getMSpecified, @Param("getMIn") @jakarta.annotation.Nullable List<Integer> getMIn, @Param("getMNotIn") @jakarta.annotation.Nullable List<Integer> getMNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("promotionIdGreaterThan") @jakarta.annotation.Nullable Long promotionIdGreaterThan, @Param("promotionIdLessThan") @jakarta.annotation.Nullable Long promotionIdLessThan, @Param("promotionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long promotionIdGreaterThanOrEqual, @Param("promotionIdLessThanOrEqual") @jakarta.annotation.Nullable Long promotionIdLessThanOrEqual, @Param("promotionIdEquals") @jakarta.annotation.Nullable Long promotionIdEquals, @Param("promotionIdNotEquals") @jakarta.annotation.Nullable Long promotionIdNotEquals, @Param("promotionIdSpecified") @jakarta.annotation.Nullable Boolean promotionIdSpecified, @Param("promotionIdIn") @jakarta.annotation.Nullable List<Long> promotionIdIn, @Param("promotionIdNotIn") @jakarta.annotation.Nullable List<Long> promotionIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>countBuyNGetMFrees</code> but it also returns the http response headers .
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
   * @param buyNGreaterThan  (optional)
   * @param buyNLessThan  (optional)
   * @param buyNGreaterThanOrEqual  (optional)
   * @param buyNLessThanOrEqual  (optional)
   * @param buyNEquals  (optional)
   * @param buyNNotEquals  (optional)
   * @param buyNSpecified  (optional)
   * @param buyNIn  (optional)
   * @param buyNNotIn  (optional)
   * @param getMGreaterThan  (optional)
   * @param getMLessThan  (optional)
   * @param getMGreaterThanOrEqual  (optional)
   * @param getMLessThanOrEqual  (optional)
   * @param getMEquals  (optional)
   * @param getMNotEquals  (optional)
   * @param getMSpecified  (optional)
   * @param getMIn  (optional)
   * @param getMNotIn  (optional)
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
  @RequestLine("GET /api/buy-n-get-m-frees/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&buyN.greaterThan={buyNGreaterThan}&buyN.lessThan={buyNLessThan}&buyN.greaterThanOrEqual={buyNGreaterThanOrEqual}&buyN.lessThanOrEqual={buyNLessThanOrEqual}&buyN.equals={buyNEquals}&buyN.notEquals={buyNNotEquals}&buyN.specified={buyNSpecified}&buyN.in={buyNIn}&buyN.notIn={buyNNotIn}&getM.greaterThan={getMGreaterThan}&getM.lessThan={getMLessThan}&getM.greaterThanOrEqual={getMGreaterThanOrEqual}&getM.lessThanOrEqual={getMLessThanOrEqual}&getM.equals={getMEquals}&getM.notEquals={getMNotEquals}&getM.specified={getMSpecified}&getM.in={getMIn}&getM.notIn={getMNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Long> countBuyNGetMFreesWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("buyNGreaterThan") @jakarta.annotation.Nullable Integer buyNGreaterThan, @Param("buyNLessThan") @jakarta.annotation.Nullable Integer buyNLessThan, @Param("buyNGreaterThanOrEqual") @jakarta.annotation.Nullable Integer buyNGreaterThanOrEqual, @Param("buyNLessThanOrEqual") @jakarta.annotation.Nullable Integer buyNLessThanOrEqual, @Param("buyNEquals") @jakarta.annotation.Nullable Integer buyNEquals, @Param("buyNNotEquals") @jakarta.annotation.Nullable Integer buyNNotEquals, @Param("buyNSpecified") @jakarta.annotation.Nullable Boolean buyNSpecified, @Param("buyNIn") @jakarta.annotation.Nullable List<Integer> buyNIn, @Param("buyNNotIn") @jakarta.annotation.Nullable List<Integer> buyNNotIn, @Param("getMGreaterThan") @jakarta.annotation.Nullable Integer getMGreaterThan, @Param("getMLessThan") @jakarta.annotation.Nullable Integer getMLessThan, @Param("getMGreaterThanOrEqual") @jakarta.annotation.Nullable Integer getMGreaterThanOrEqual, @Param("getMLessThanOrEqual") @jakarta.annotation.Nullable Integer getMLessThanOrEqual, @Param("getMEquals") @jakarta.annotation.Nullable Integer getMEquals, @Param("getMNotEquals") @jakarta.annotation.Nullable Integer getMNotEquals, @Param("getMSpecified") @jakarta.annotation.Nullable Boolean getMSpecified, @Param("getMIn") @jakarta.annotation.Nullable List<Integer> getMIn, @Param("getMNotIn") @jakarta.annotation.Nullable List<Integer> getMNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("promotionIdGreaterThan") @jakarta.annotation.Nullable Long promotionIdGreaterThan, @Param("promotionIdLessThan") @jakarta.annotation.Nullable Long promotionIdLessThan, @Param("promotionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long promotionIdGreaterThanOrEqual, @Param("promotionIdLessThanOrEqual") @jakarta.annotation.Nullable Long promotionIdLessThanOrEqual, @Param("promotionIdEquals") @jakarta.annotation.Nullable Long promotionIdEquals, @Param("promotionIdNotEquals") @jakarta.annotation.Nullable Long promotionIdNotEquals, @Param("promotionIdSpecified") @jakarta.annotation.Nullable Boolean promotionIdSpecified, @Param("promotionIdIn") @jakarta.annotation.Nullable List<Long> promotionIdIn, @Param("promotionIdNotIn") @jakarta.annotation.Nullable List<Long> promotionIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>countBuyNGetMFrees</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CountBuyNGetMFreesQueryParams} class that allows for
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
   *   <li>buyNGreaterThan -  (optional)</li>
   *   <li>buyNLessThan -  (optional)</li>
   *   <li>buyNGreaterThanOrEqual -  (optional)</li>
   *   <li>buyNLessThanOrEqual -  (optional)</li>
   *   <li>buyNEquals -  (optional)</li>
   *   <li>buyNNotEquals -  (optional)</li>
   *   <li>buyNSpecified -  (optional)</li>
   *   <li>buyNIn -  (optional)</li>
   *   <li>buyNNotIn -  (optional)</li>
   *   <li>getMGreaterThan -  (optional)</li>
   *   <li>getMLessThan -  (optional)</li>
   *   <li>getMGreaterThanOrEqual -  (optional)</li>
   *   <li>getMLessThanOrEqual -  (optional)</li>
   *   <li>getMEquals -  (optional)</li>
   *   <li>getMNotEquals -  (optional)</li>
   *   <li>getMSpecified -  (optional)</li>
   *   <li>getMIn -  (optional)</li>
   *   <li>getMNotIn -  (optional)</li>
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
  @RequestLine("GET /api/buy-n-get-m-frees/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&buyN.greaterThan={buyNGreaterThan}&buyN.lessThan={buyNLessThan}&buyN.greaterThanOrEqual={buyNGreaterThanOrEqual}&buyN.lessThanOrEqual={buyNLessThanOrEqual}&buyN.equals={buyNEquals}&buyN.notEquals={buyNNotEquals}&buyN.specified={buyNSpecified}&buyN.in={buyNIn}&buyN.notIn={buyNNotIn}&getM.greaterThan={getMGreaterThan}&getM.lessThan={getMLessThan}&getM.greaterThanOrEqual={getMGreaterThanOrEqual}&getM.lessThanOrEqual={getMLessThanOrEqual}&getM.equals={getMEquals}&getM.notEquals={getMNotEquals}&getM.specified={getMSpecified}&getM.in={getMIn}&getM.notIn={getMNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  Long countBuyNGetMFrees(@QueryMap(encoded=true) CountBuyNGetMFreesQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>countBuyNGetMFrees</code> that receives the query parameters as a map,
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
          *   <li>buyNGreaterThan -  (optional)</li>
          *   <li>buyNLessThan -  (optional)</li>
          *   <li>buyNGreaterThanOrEqual -  (optional)</li>
          *   <li>buyNLessThanOrEqual -  (optional)</li>
          *   <li>buyNEquals -  (optional)</li>
          *   <li>buyNNotEquals -  (optional)</li>
          *   <li>buyNSpecified -  (optional)</li>
          *   <li>buyNIn -  (optional)</li>
          *   <li>buyNNotIn -  (optional)</li>
          *   <li>getMGreaterThan -  (optional)</li>
          *   <li>getMLessThan -  (optional)</li>
          *   <li>getMGreaterThanOrEqual -  (optional)</li>
          *   <li>getMLessThanOrEqual -  (optional)</li>
          *   <li>getMEquals -  (optional)</li>
          *   <li>getMNotEquals -  (optional)</li>
          *   <li>getMSpecified -  (optional)</li>
          *   <li>getMIn -  (optional)</li>
          *   <li>getMNotIn -  (optional)</li>
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
      @RequestLine("GET /api/buy-n-get-m-frees/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&buyN.greaterThan={buyNGreaterThan}&buyN.lessThan={buyNLessThan}&buyN.greaterThanOrEqual={buyNGreaterThanOrEqual}&buyN.lessThanOrEqual={buyNLessThanOrEqual}&buyN.equals={buyNEquals}&buyN.notEquals={buyNNotEquals}&buyN.specified={buyNSpecified}&buyN.in={buyNIn}&buyN.notIn={buyNNotIn}&getM.greaterThan={getMGreaterThan}&getM.lessThan={getMLessThan}&getM.greaterThanOrEqual={getMGreaterThanOrEqual}&getM.lessThanOrEqual={getMLessThanOrEqual}&getM.equals={getMEquals}&getM.notEquals={getMNotEquals}&getM.specified={getMSpecified}&getM.in={getMIn}&getM.notIn={getMNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Long> countBuyNGetMFreesWithHttpInfo(@QueryMap(encoded=true) CountBuyNGetMFreesQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>countBuyNGetMFrees</code> method in a fluent style.
   */
  public static class CountBuyNGetMFreesQueryParams extends HashMap<String, Object> {
    public CountBuyNGetMFreesQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBuyNGetMFreesQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBuyNGetMFreesQueryParams buyNGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("buyN.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams buyNLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("buyN.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams buyNGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("buyN.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams buyNLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("buyN.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams buyNEquals(@jakarta.annotation.Nullable final Integer value) {
      put("buyN.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams buyNNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("buyN.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams buyNSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("buyN.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams buyNIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("buyN.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBuyNGetMFreesQueryParams buyNNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("buyN.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBuyNGetMFreesQueryParams getMGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("getM.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams getMLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("getM.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams getMGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("getM.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams getMLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("getM.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams getMEquals(@jakarta.annotation.Nullable final Integer value) {
      put("getM.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams getMNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("getM.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams getMSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("getM.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams getMIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("getM.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBuyNGetMFreesQueryParams getMNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("getM.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBuyNGetMFreesQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBuyNGetMFreesQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBuyNGetMFreesQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBuyNGetMFreesQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBuyNGetMFreesQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBuyNGetMFreesQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBuyNGetMFreesQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBuyNGetMFreesQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBuyNGetMFreesQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBuyNGetMFreesQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBuyNGetMFreesQueryParams promotionIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams promotionIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams promotionIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams promotionIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams promotionIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams promotionIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams promotionIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("promotionId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountBuyNGetMFreesQueryParams promotionIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("promotionId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBuyNGetMFreesQueryParams promotionIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("promotionId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBuyNGetMFreesQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param buyNGetMFreeDTO  (required)
   * @return BuyNGetMFreeDTO
   */
  @RequestLine("POST /api/buy-n-get-m-frees")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  BuyNGetMFreeDTO createBuyNGetMFree(@jakarta.annotation.Nonnull BuyNGetMFreeDTO buyNGetMFreeDTO);

  /**
   * 
   * Similar to <code>createBuyNGetMFree</code> but it also returns the http response headers .
   * 
   * @param buyNGetMFreeDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/buy-n-get-m-frees")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<BuyNGetMFreeDTO> createBuyNGetMFreeWithHttpInfo(@jakarta.annotation.Nonnull BuyNGetMFreeDTO buyNGetMFreeDTO);



  /**
   * 
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/buy-n-get-m-frees/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteBuyNGetMFree(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>deleteBuyNGetMFree</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/buy-n-get-m-frees/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteBuyNGetMFreeWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



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
   * @param buyNGreaterThan  (optional)
   * @param buyNLessThan  (optional)
   * @param buyNGreaterThanOrEqual  (optional)
   * @param buyNLessThanOrEqual  (optional)
   * @param buyNEquals  (optional)
   * @param buyNNotEquals  (optional)
   * @param buyNSpecified  (optional)
   * @param buyNIn  (optional)
   * @param buyNNotIn  (optional)
   * @param getMGreaterThan  (optional)
   * @param getMLessThan  (optional)
   * @param getMGreaterThanOrEqual  (optional)
   * @param getMLessThanOrEqual  (optional)
   * @param getMEquals  (optional)
   * @param getMNotEquals  (optional)
   * @param getMSpecified  (optional)
   * @param getMIn  (optional)
   * @param getMNotIn  (optional)
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
   * @return List&lt;BuyNGetMFreeDTO&gt;
   */
  @RequestLine("GET /api/buy-n-get-m-frees?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&buyN.greaterThan={buyNGreaterThan}&buyN.lessThan={buyNLessThan}&buyN.greaterThanOrEqual={buyNGreaterThanOrEqual}&buyN.lessThanOrEqual={buyNLessThanOrEqual}&buyN.equals={buyNEquals}&buyN.notEquals={buyNNotEquals}&buyN.specified={buyNSpecified}&buyN.in={buyNIn}&buyN.notIn={buyNNotIn}&getM.greaterThan={getMGreaterThan}&getM.lessThan={getMLessThan}&getM.greaterThanOrEqual={getMGreaterThanOrEqual}&getM.lessThanOrEqual={getMLessThanOrEqual}&getM.equals={getMEquals}&getM.notEquals={getMNotEquals}&getM.specified={getMSpecified}&getM.in={getMIn}&getM.notIn={getMNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  List<BuyNGetMFreeDTO> getAllBuyNGetMFrees(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("buyNGreaterThan") @jakarta.annotation.Nullable Integer buyNGreaterThan, @Param("buyNLessThan") @jakarta.annotation.Nullable Integer buyNLessThan, @Param("buyNGreaterThanOrEqual") @jakarta.annotation.Nullable Integer buyNGreaterThanOrEqual, @Param("buyNLessThanOrEqual") @jakarta.annotation.Nullable Integer buyNLessThanOrEqual, @Param("buyNEquals") @jakarta.annotation.Nullable Integer buyNEquals, @Param("buyNNotEquals") @jakarta.annotation.Nullable Integer buyNNotEquals, @Param("buyNSpecified") @jakarta.annotation.Nullable Boolean buyNSpecified, @Param("buyNIn") @jakarta.annotation.Nullable List<Integer> buyNIn, @Param("buyNNotIn") @jakarta.annotation.Nullable List<Integer> buyNNotIn, @Param("getMGreaterThan") @jakarta.annotation.Nullable Integer getMGreaterThan, @Param("getMLessThan") @jakarta.annotation.Nullable Integer getMLessThan, @Param("getMGreaterThanOrEqual") @jakarta.annotation.Nullable Integer getMGreaterThanOrEqual, @Param("getMLessThanOrEqual") @jakarta.annotation.Nullable Integer getMLessThanOrEqual, @Param("getMEquals") @jakarta.annotation.Nullable Integer getMEquals, @Param("getMNotEquals") @jakarta.annotation.Nullable Integer getMNotEquals, @Param("getMSpecified") @jakarta.annotation.Nullable Boolean getMSpecified, @Param("getMIn") @jakarta.annotation.Nullable List<Integer> getMIn, @Param("getMNotIn") @jakarta.annotation.Nullable List<Integer> getMNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("promotionIdGreaterThan") @jakarta.annotation.Nullable Long promotionIdGreaterThan, @Param("promotionIdLessThan") @jakarta.annotation.Nullable Long promotionIdLessThan, @Param("promotionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long promotionIdGreaterThanOrEqual, @Param("promotionIdLessThanOrEqual") @jakarta.annotation.Nullable Long promotionIdLessThanOrEqual, @Param("promotionIdEquals") @jakarta.annotation.Nullable Long promotionIdEquals, @Param("promotionIdNotEquals") @jakarta.annotation.Nullable Long promotionIdNotEquals, @Param("promotionIdSpecified") @jakarta.annotation.Nullable Boolean promotionIdSpecified, @Param("promotionIdIn") @jakarta.annotation.Nullable List<Long> promotionIdIn, @Param("promotionIdNotIn") @jakarta.annotation.Nullable List<Long> promotionIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>getAllBuyNGetMFrees</code> but it also returns the http response headers .
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
   * @param buyNGreaterThan  (optional)
   * @param buyNLessThan  (optional)
   * @param buyNGreaterThanOrEqual  (optional)
   * @param buyNLessThanOrEqual  (optional)
   * @param buyNEquals  (optional)
   * @param buyNNotEquals  (optional)
   * @param buyNSpecified  (optional)
   * @param buyNIn  (optional)
   * @param buyNNotIn  (optional)
   * @param getMGreaterThan  (optional)
   * @param getMLessThan  (optional)
   * @param getMGreaterThanOrEqual  (optional)
   * @param getMLessThanOrEqual  (optional)
   * @param getMEquals  (optional)
   * @param getMNotEquals  (optional)
   * @param getMSpecified  (optional)
   * @param getMIn  (optional)
   * @param getMNotIn  (optional)
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
  @RequestLine("GET /api/buy-n-get-m-frees?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&buyN.greaterThan={buyNGreaterThan}&buyN.lessThan={buyNLessThan}&buyN.greaterThanOrEqual={buyNGreaterThanOrEqual}&buyN.lessThanOrEqual={buyNLessThanOrEqual}&buyN.equals={buyNEquals}&buyN.notEquals={buyNNotEquals}&buyN.specified={buyNSpecified}&buyN.in={buyNIn}&buyN.notIn={buyNNotIn}&getM.greaterThan={getMGreaterThan}&getM.lessThan={getMLessThan}&getM.greaterThanOrEqual={getMGreaterThanOrEqual}&getM.lessThanOrEqual={getMLessThanOrEqual}&getM.equals={getMEquals}&getM.notEquals={getMNotEquals}&getM.specified={getMSpecified}&getM.in={getMIn}&getM.notIn={getMNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<BuyNGetMFreeDTO>> getAllBuyNGetMFreesWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("buyNGreaterThan") @jakarta.annotation.Nullable Integer buyNGreaterThan, @Param("buyNLessThan") @jakarta.annotation.Nullable Integer buyNLessThan, @Param("buyNGreaterThanOrEqual") @jakarta.annotation.Nullable Integer buyNGreaterThanOrEqual, @Param("buyNLessThanOrEqual") @jakarta.annotation.Nullable Integer buyNLessThanOrEqual, @Param("buyNEquals") @jakarta.annotation.Nullable Integer buyNEquals, @Param("buyNNotEquals") @jakarta.annotation.Nullable Integer buyNNotEquals, @Param("buyNSpecified") @jakarta.annotation.Nullable Boolean buyNSpecified, @Param("buyNIn") @jakarta.annotation.Nullable List<Integer> buyNIn, @Param("buyNNotIn") @jakarta.annotation.Nullable List<Integer> buyNNotIn, @Param("getMGreaterThan") @jakarta.annotation.Nullable Integer getMGreaterThan, @Param("getMLessThan") @jakarta.annotation.Nullable Integer getMLessThan, @Param("getMGreaterThanOrEqual") @jakarta.annotation.Nullable Integer getMGreaterThanOrEqual, @Param("getMLessThanOrEqual") @jakarta.annotation.Nullable Integer getMLessThanOrEqual, @Param("getMEquals") @jakarta.annotation.Nullable Integer getMEquals, @Param("getMNotEquals") @jakarta.annotation.Nullable Integer getMNotEquals, @Param("getMSpecified") @jakarta.annotation.Nullable Boolean getMSpecified, @Param("getMIn") @jakarta.annotation.Nullable List<Integer> getMIn, @Param("getMNotIn") @jakarta.annotation.Nullable List<Integer> getMNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("promotionIdGreaterThan") @jakarta.annotation.Nullable Long promotionIdGreaterThan, @Param("promotionIdLessThan") @jakarta.annotation.Nullable Long promotionIdLessThan, @Param("promotionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long promotionIdGreaterThanOrEqual, @Param("promotionIdLessThanOrEqual") @jakarta.annotation.Nullable Long promotionIdLessThanOrEqual, @Param("promotionIdEquals") @jakarta.annotation.Nullable Long promotionIdEquals, @Param("promotionIdNotEquals") @jakarta.annotation.Nullable Long promotionIdNotEquals, @Param("promotionIdSpecified") @jakarta.annotation.Nullable Boolean promotionIdSpecified, @Param("promotionIdIn") @jakarta.annotation.Nullable List<Long> promotionIdIn, @Param("promotionIdNotIn") @jakarta.annotation.Nullable List<Long> promotionIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllBuyNGetMFrees</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllBuyNGetMFreesQueryParams} class that allows for
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
   *   <li>buyNGreaterThan -  (optional)</li>
   *   <li>buyNLessThan -  (optional)</li>
   *   <li>buyNGreaterThanOrEqual -  (optional)</li>
   *   <li>buyNLessThanOrEqual -  (optional)</li>
   *   <li>buyNEquals -  (optional)</li>
   *   <li>buyNNotEquals -  (optional)</li>
   *   <li>buyNSpecified -  (optional)</li>
   *   <li>buyNIn -  (optional)</li>
   *   <li>buyNNotIn -  (optional)</li>
   *   <li>getMGreaterThan -  (optional)</li>
   *   <li>getMLessThan -  (optional)</li>
   *   <li>getMGreaterThanOrEqual -  (optional)</li>
   *   <li>getMLessThanOrEqual -  (optional)</li>
   *   <li>getMEquals -  (optional)</li>
   *   <li>getMNotEquals -  (optional)</li>
   *   <li>getMSpecified -  (optional)</li>
   *   <li>getMIn -  (optional)</li>
   *   <li>getMNotIn -  (optional)</li>
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
   * @return List&lt;BuyNGetMFreeDTO&gt;
   */
  @RequestLine("GET /api/buy-n-get-m-frees?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&buyN.greaterThan={buyNGreaterThan}&buyN.lessThan={buyNLessThan}&buyN.greaterThanOrEqual={buyNGreaterThanOrEqual}&buyN.lessThanOrEqual={buyNLessThanOrEqual}&buyN.equals={buyNEquals}&buyN.notEquals={buyNNotEquals}&buyN.specified={buyNSpecified}&buyN.in={buyNIn}&buyN.notIn={buyNNotIn}&getM.greaterThan={getMGreaterThan}&getM.lessThan={getMLessThan}&getM.greaterThanOrEqual={getMGreaterThanOrEqual}&getM.lessThanOrEqual={getMLessThanOrEqual}&getM.equals={getMEquals}&getM.notEquals={getMNotEquals}&getM.specified={getMSpecified}&getM.in={getMIn}&getM.notIn={getMNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  List<BuyNGetMFreeDTO> getAllBuyNGetMFrees(@QueryMap(encoded=true) GetAllBuyNGetMFreesQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllBuyNGetMFrees</code> that receives the query parameters as a map,
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
          *   <li>buyNGreaterThan -  (optional)</li>
          *   <li>buyNLessThan -  (optional)</li>
          *   <li>buyNGreaterThanOrEqual -  (optional)</li>
          *   <li>buyNLessThanOrEqual -  (optional)</li>
          *   <li>buyNEquals -  (optional)</li>
          *   <li>buyNNotEquals -  (optional)</li>
          *   <li>buyNSpecified -  (optional)</li>
          *   <li>buyNIn -  (optional)</li>
          *   <li>buyNNotIn -  (optional)</li>
          *   <li>getMGreaterThan -  (optional)</li>
          *   <li>getMLessThan -  (optional)</li>
          *   <li>getMGreaterThanOrEqual -  (optional)</li>
          *   <li>getMLessThanOrEqual -  (optional)</li>
          *   <li>getMEquals -  (optional)</li>
          *   <li>getMNotEquals -  (optional)</li>
          *   <li>getMSpecified -  (optional)</li>
          *   <li>getMIn -  (optional)</li>
          *   <li>getMNotIn -  (optional)</li>
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
          * @return List&lt;BuyNGetMFreeDTO&gt;
      */
      @RequestLine("GET /api/buy-n-get-m-frees?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&buyN.greaterThan={buyNGreaterThan}&buyN.lessThan={buyNLessThan}&buyN.greaterThanOrEqual={buyNGreaterThanOrEqual}&buyN.lessThanOrEqual={buyNLessThanOrEqual}&buyN.equals={buyNEquals}&buyN.notEquals={buyNNotEquals}&buyN.specified={buyNSpecified}&buyN.in={buyNIn}&buyN.notIn={buyNNotIn}&getM.greaterThan={getMGreaterThan}&getM.lessThan={getMLessThan}&getM.greaterThanOrEqual={getMGreaterThanOrEqual}&getM.lessThanOrEqual={getMLessThanOrEqual}&getM.equals={getMEquals}&getM.notEquals={getMNotEquals}&getM.specified={getMSpecified}&getM.in={getMIn}&getM.notIn={getMNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&promotionId.greaterThan={promotionIdGreaterThan}&promotionId.lessThan={promotionIdLessThan}&promotionId.greaterThanOrEqual={promotionIdGreaterThanOrEqual}&promotionId.lessThanOrEqual={promotionIdLessThanOrEqual}&promotionId.equals={promotionIdEquals}&promotionId.notEquals={promotionIdNotEquals}&promotionId.specified={promotionIdSpecified}&promotionId.in={promotionIdIn}&promotionId.notIn={promotionIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<BuyNGetMFreeDTO>> getAllBuyNGetMFreesWithHttpInfo(@QueryMap(encoded=true) GetAllBuyNGetMFreesQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllBuyNGetMFrees</code> method in a fluent style.
   */
  public static class GetAllBuyNGetMFreesQueryParams extends HashMap<String, Object> {
    public GetAllBuyNGetMFreesQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams buyNGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("buyN.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams buyNLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("buyN.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams buyNGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("buyN.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams buyNLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("buyN.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams buyNEquals(@jakarta.annotation.Nullable final Integer value) {
      put("buyN.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams buyNNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("buyN.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams buyNSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("buyN.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams buyNIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("buyN.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams buyNNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("buyN.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams getMGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("getM.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams getMLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("getM.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams getMGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("getM.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams getMLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("getM.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams getMEquals(@jakarta.annotation.Nullable final Integer value) {
      put("getM.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams getMNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("getM.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams getMSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("getM.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams getMIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("getM.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams getMNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("getM.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams promotionIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams promotionIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams promotionIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams promotionIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams promotionIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams promotionIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("promotionId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams promotionIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("promotionId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams promotionIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("promotionId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams promotionIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("promotionId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBuyNGetMFreesQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @return BuyNGetMFreeDTO
   */
  @RequestLine("GET /api/buy-n-get-m-frees/{id}")
  @Headers({
    "Accept: */*",
  })
  BuyNGetMFreeDTO getBuyNGetMFree(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>getBuyNGetMFree</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/buy-n-get-m-frees/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<BuyNGetMFreeDTO> getBuyNGetMFreeWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param id  (required)
   * @param buyNGetMFreeDTO  (required)
   * @return BuyNGetMFreeDTO
   */
  @RequestLine("PATCH /api/buy-n-get-m-frees/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  BuyNGetMFreeDTO partialUpdateBuyNGetMFree(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull BuyNGetMFreeDTO buyNGetMFreeDTO);

  /**
   * 
   * Similar to <code>partialUpdateBuyNGetMFree</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param buyNGetMFreeDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /api/buy-n-get-m-frees/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<BuyNGetMFreeDTO> partialUpdateBuyNGetMFreeWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull BuyNGetMFreeDTO buyNGetMFreeDTO);



  /**
   * 
   * 
   * @param id  (required)
   * @param buyNGetMFreeDTO  (required)
   * @return BuyNGetMFreeDTO
   */
  @RequestLine("PUT /api/buy-n-get-m-frees/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  BuyNGetMFreeDTO updateBuyNGetMFree(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull BuyNGetMFreeDTO buyNGetMFreeDTO);

  /**
   * 
   * Similar to <code>updateBuyNGetMFree</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param buyNGetMFreeDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/buy-n-get-m-frees/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<BuyNGetMFreeDTO> updateBuyNGetMFreeWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull BuyNGetMFreeDTO buyNGetMFreeDTO);


}
