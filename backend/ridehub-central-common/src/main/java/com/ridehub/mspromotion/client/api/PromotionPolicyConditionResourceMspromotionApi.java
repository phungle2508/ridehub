package com.ridehub.mspromotion.client.api;

import com.ridehub.mspromotion.client.invoker.ApiClient;
import com.ridehub.mspromotion.client.invoker.EncodingUtils;
import com.ridehub.mspromotion.client.model.ApiResponse;

import com.ridehub.mspromotion.client.model.BuyNGetMFreeDTO;
import com.ridehub.mspromotion.client.model.ConditionByDateDTO;
import com.ridehub.mspromotion.client.model.ConditionByLocationDTO;
import com.ridehub.mspromotion.client.model.ConditionByRouteDTO;
import com.ridehub.mspromotion.client.model.PercentOffTotalDTO;
import com.ridehub.mspromotion.client.model.PromotionDetailDTO;
import com.ridehub.mspromotion.client.model.PromotionPoliciesAndConditionsDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface PromotionPolicyConditionResourceMspromotionApi extends ApiClient.Api {


  /**
   * Create a new buyNGetMFree policy for the promotion
   * 
   * @param promotionId  (required)
   * @param buyNGetMFreeDTO  (required)
   * @return BuyNGetMFreeDTO
   */
  @RequestLine("POST /api/promotions/{promotionId}/buy-n-get-m-free")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  BuyNGetMFreeDTO createBuyNGetMFreePolicy(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId, @jakarta.annotation.Nonnull BuyNGetMFreeDTO buyNGetMFreeDTO);

  /**
   * Create a new buyNGetMFree policy for the promotion
   * Similar to <code>createBuyNGetMFreePolicy</code> but it also returns the http response headers .
   * 
   * @param promotionId  (required)
   * @param buyNGetMFreeDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/promotions/{promotionId}/buy-n-get-m-free")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<BuyNGetMFreeDTO> createBuyNGetMFreePolicyWithHttpInfo(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId, @jakarta.annotation.Nonnull BuyNGetMFreeDTO buyNGetMFreeDTO);



  /**
   * Create a new date condition for the promotion
   * 
   * @param promotionId  (required)
   * @param conditionByDateDTO  (required)
   * @return ConditionByDateDTO
   */
  @RequestLine("POST /api/promotions/{promotionId}/conditions/date")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ConditionByDateDTO createDateCondition(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId, @jakarta.annotation.Nonnull ConditionByDateDTO conditionByDateDTO);

  /**
   * Create a new date condition for the promotion
   * Similar to <code>createDateCondition</code> but it also returns the http response headers .
   * 
   * @param promotionId  (required)
   * @param conditionByDateDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/promotions/{promotionId}/conditions/date")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<ConditionByDateDTO> createDateConditionWithHttpInfo(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId, @jakarta.annotation.Nonnull ConditionByDateDTO conditionByDateDTO);



  /**
   * Create a new location condition for the promotion
   * 
   * @param promotionId  (required)
   * @param conditionByLocationDTO  (required)
   * @return ConditionByLocationDTO
   */
  @RequestLine("POST /api/promotions/{promotionId}/conditions/location")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ConditionByLocationDTO createLocationCondition(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId, @jakarta.annotation.Nonnull ConditionByLocationDTO conditionByLocationDTO);

  /**
   * Create a new location condition for the promotion
   * Similar to <code>createLocationCondition</code> but it also returns the http response headers .
   * 
   * @param promotionId  (required)
   * @param conditionByLocationDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/promotions/{promotionId}/conditions/location")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<ConditionByLocationDTO> createLocationConditionWithHttpInfo(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId, @jakarta.annotation.Nonnull ConditionByLocationDTO conditionByLocationDTO);



  /**
   * Create a new percentOffTotal policy for the promotion
   * 
   * @param promotionId  (required)
   * @param percentOffTotalDTO  (required)
   * @return PercentOffTotalDTO
   */
  @RequestLine("POST /api/promotions/{promotionId}/percent-off-total")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  PercentOffTotalDTO createPercentOffTotalPolicy(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId, @jakarta.annotation.Nonnull PercentOffTotalDTO percentOffTotalDTO);

  /**
   * Create a new percentOffTotal policy for the promotion
   * Similar to <code>createPercentOffTotalPolicy</code> but it also returns the http response headers .
   * 
   * @param promotionId  (required)
   * @param percentOffTotalDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/promotions/{promotionId}/percent-off-total")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<PercentOffTotalDTO> createPercentOffTotalPolicyWithHttpInfo(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId, @jakarta.annotation.Nonnull PercentOffTotalDTO percentOffTotalDTO);



  /**
   * Create a new route condition for the promotion
   * 
   * @param promotionId  (required)
   * @param conditionByRouteDTO  (required)
   * @return ConditionByRouteDTO
   */
  @RequestLine("POST /api/promotions/{promotionId}/conditions/route")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ConditionByRouteDTO createRouteCondition(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId, @jakarta.annotation.Nonnull ConditionByRouteDTO conditionByRouteDTO);

  /**
   * Create a new route condition for the promotion
   * Similar to <code>createRouteCondition</code> but it also returns the http response headers .
   * 
   * @param promotionId  (required)
   * @param conditionByRouteDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/promotions/{promotionId}/conditions/route")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<ConditionByRouteDTO> createRouteConditionWithHttpInfo(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId, @jakarta.annotation.Nonnull ConditionByRouteDTO conditionByRouteDTO);



  /**
   * Delete buyNGetMFree policy
   * 
   * @param promotionId  (required)
   * @param id  (required)
   */
  @RequestLine("DELETE /api/promotions/{promotionId}/buy-n-get-m-free/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteBuyNGetMFreePolicy(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId, @Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * Delete buyNGetMFree policy
   * Similar to <code>deleteBuyNGetMFreePolicy</code> but it also returns the http response headers .
   * 
   * @param promotionId  (required)
   * @param id  (required)
   */
  @RequestLine("DELETE /api/promotions/{promotionId}/buy-n-get-m-free/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteBuyNGetMFreePolicyWithHttpInfo(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId, @Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * Delete date condition
   * 
   * @param promotionId  (required)
   * @param id  (required)
   */
  @RequestLine("DELETE /api/promotions/{promotionId}/conditions/date/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteDateCondition(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId, @Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * Delete date condition
   * Similar to <code>deleteDateCondition</code> but it also returns the http response headers .
   * 
   * @param promotionId  (required)
   * @param id  (required)
   */
  @RequestLine("DELETE /api/promotions/{promotionId}/conditions/date/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteDateConditionWithHttpInfo(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId, @Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * Delete location condition
   * 
   * @param promotionId  (required)
   * @param id  (required)
   */
  @RequestLine("DELETE /api/promotions/{promotionId}/conditions/location/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteLocationCondition(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId, @Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * Delete location condition
   * Similar to <code>deleteLocationCondition</code> but it also returns the http response headers .
   * 
   * @param promotionId  (required)
   * @param id  (required)
   */
  @RequestLine("DELETE /api/promotions/{promotionId}/conditions/location/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteLocationConditionWithHttpInfo(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId, @Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * Delete percentOffTotal policy
   * 
   * @param promotionId  (required)
   * @param id  (required)
   */
  @RequestLine("DELETE /api/promotions/{promotionId}/percent-off-total/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deletePercentOffTotalPolicy(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId, @Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * Delete percentOffTotal policy
   * Similar to <code>deletePercentOffTotalPolicy</code> but it also returns the http response headers .
   * 
   * @param promotionId  (required)
   * @param id  (required)
   */
  @RequestLine("DELETE /api/promotions/{promotionId}/percent-off-total/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deletePercentOffTotalPolicyWithHttpInfo(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId, @Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * Delete route condition
   * 
   * @param promotionId  (required)
   * @param id  (required)
   */
  @RequestLine("DELETE /api/promotions/{promotionId}/conditions/route/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteRouteCondition(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId, @Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * Delete route condition
   * Similar to <code>deleteRouteCondition</code> but it also returns the http response headers .
   * 
   * @param promotionId  (required)
   * @param id  (required)
   */
  @RequestLine("DELETE /api/promotions/{promotionId}/conditions/route/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteRouteConditionWithHttpInfo(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId, @Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param promotionId  (required)
   * @return PromotionPoliciesAndConditionsDTO
   */
  @RequestLine("GET /api/promotions/{promotionId}/policies-and-conditions")
  @Headers({
    "Accept: */*",
  })
  PromotionPoliciesAndConditionsDTO getAllPoliciesAndConditions(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId);

  /**
   * 
   * Similar to <code>getAllPoliciesAndConditions</code> but it also returns the http response headers .
   * 
   * @param promotionId  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/promotions/{promotionId}/policies-and-conditions")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<PromotionPoliciesAndConditionsDTO> getAllPoliciesAndConditionsWithHttpInfo(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId);



  /**
   * 
   * 
   * @param promotionId  (required)
   * @return List&lt;BuyNGetMFreeDTO&gt;
   */
  @RequestLine("GET /api/promotions/{promotionId}/buy-n-get-m-free")
  @Headers({
    "Accept: */*",
  })
  List<BuyNGetMFreeDTO> getBuyNGetMFreePolicies(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId);

  /**
   * 
   * Similar to <code>getBuyNGetMFreePolicies</code> but it also returns the http response headers .
   * 
   * @param promotionId  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/promotions/{promotionId}/buy-n-get-m-free")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<BuyNGetMFreeDTO>> getBuyNGetMFreePoliciesWithHttpInfo(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId);



  /**
   * 
   * 
   * @param promotionId  (required)
   * @return List&lt;ConditionByDateDTO&gt;
   */
  @RequestLine("GET /api/promotions/{promotionId}/conditions/date")
  @Headers({
    "Accept: */*",
  })
  List<ConditionByDateDTO> getDateConditions(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId);

  /**
   * 
   * Similar to <code>getDateConditions</code> but it also returns the http response headers .
   * 
   * @param promotionId  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/promotions/{promotionId}/conditions/date")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<ConditionByDateDTO>> getDateConditionsWithHttpInfo(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId);



  /**
   * 
   * 
   * @param promotionId  (required)
   * @return List&lt;ConditionByLocationDTO&gt;
   */
  @RequestLine("GET /api/promotions/{promotionId}/conditions/location")
  @Headers({
    "Accept: */*",
  })
  List<ConditionByLocationDTO> getLocationConditions(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId);

  /**
   * 
   * Similar to <code>getLocationConditions</code> but it also returns the http response headers .
   * 
   * @param promotionId  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/promotions/{promotionId}/conditions/location")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<ConditionByLocationDTO>> getLocationConditionsWithHttpInfo(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId);



  /**
   * 
   * 
   * @param promotionId  (required)
   * @return List&lt;PercentOffTotalDTO&gt;
   */
  @RequestLine("GET /api/promotions/{promotionId}/percent-off-total")
  @Headers({
    "Accept: */*",
  })
  List<PercentOffTotalDTO> getPercentOffTotalPolicies(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId);

  /**
   * 
   * Similar to <code>getPercentOffTotalPolicies</code> but it also returns the http response headers .
   * 
   * @param promotionId  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/promotions/{promotionId}/percent-off-total")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<PercentOffTotalDTO>> getPercentOffTotalPoliciesWithHttpInfo(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId);



  /**
   * 
   * 
   * @param promotionId  (required)
   * @return PromotionDetailDTO
   */
  @RequestLine("GET /api/promotions/{promotionId}/detail")
  @Headers({
    "Accept: */*",
  })
  PromotionDetailDTO getPromotionDetail(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId);

  /**
   * 
   * Similar to <code>getPromotionDetail</code> but it also returns the http response headers .
   * 
   * @param promotionId  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/promotions/{promotionId}/detail")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<PromotionDetailDTO> getPromotionDetailWithHttpInfo(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId);



  /**
   * 
   * 
   * @param promotionId  (required)
   * @return List&lt;ConditionByRouteDTO&gt;
   */
  @RequestLine("GET /api/promotions/{promotionId}/conditions/route")
  @Headers({
    "Accept: */*",
  })
  List<ConditionByRouteDTO> getRouteConditions(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId);

  /**
   * 
   * Similar to <code>getRouteConditions</code> but it also returns the http response headers .
   * 
   * @param promotionId  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/promotions/{promotionId}/conditions/route")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<ConditionByRouteDTO>> getRouteConditionsWithHttpInfo(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId);



  /**
   * Update buyNGetMFree policy
   * 
   * @param promotionId  (required)
   * @param id  (required)
   * @param buyNGetMFreeDTO  (required)
   * @return BuyNGetMFreeDTO
   */
  @RequestLine("PUT /api/promotions/{promotionId}/buy-n-get-m-free/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  BuyNGetMFreeDTO updateBuyNGetMFreePolicy(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId, @Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull BuyNGetMFreeDTO buyNGetMFreeDTO);

  /**
   * Update buyNGetMFree policy
   * Similar to <code>updateBuyNGetMFreePolicy</code> but it also returns the http response headers .
   * 
   * @param promotionId  (required)
   * @param id  (required)
   * @param buyNGetMFreeDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/promotions/{promotionId}/buy-n-get-m-free/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<BuyNGetMFreeDTO> updateBuyNGetMFreePolicyWithHttpInfo(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId, @Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull BuyNGetMFreeDTO buyNGetMFreeDTO);



  /**
   * Update date condition
   * 
   * @param promotionId  (required)
   * @param id  (required)
   * @param conditionByDateDTO  (required)
   * @return ConditionByDateDTO
   */
  @RequestLine("PUT /api/promotions/{promotionId}/conditions/date/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ConditionByDateDTO updateDateCondition(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId, @Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull ConditionByDateDTO conditionByDateDTO);

  /**
   * Update date condition
   * Similar to <code>updateDateCondition</code> but it also returns the http response headers .
   * 
   * @param promotionId  (required)
   * @param id  (required)
   * @param conditionByDateDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/promotions/{promotionId}/conditions/date/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<ConditionByDateDTO> updateDateConditionWithHttpInfo(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId, @Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull ConditionByDateDTO conditionByDateDTO);



  /**
   * Update location condition
   * 
   * @param promotionId  (required)
   * @param id  (required)
   * @param conditionByLocationDTO  (required)
   * @return ConditionByLocationDTO
   */
  @RequestLine("PUT /api/promotions/{promotionId}/conditions/location/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ConditionByLocationDTO updateLocationCondition(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId, @Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull ConditionByLocationDTO conditionByLocationDTO);

  /**
   * Update location condition
   * Similar to <code>updateLocationCondition</code> but it also returns the http response headers .
   * 
   * @param promotionId  (required)
   * @param id  (required)
   * @param conditionByLocationDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/promotions/{promotionId}/conditions/location/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<ConditionByLocationDTO> updateLocationConditionWithHttpInfo(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId, @Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull ConditionByLocationDTO conditionByLocationDTO);



  /**
   * Update percentOffTotal policy
   * 
   * @param promotionId  (required)
   * @param id  (required)
   * @param percentOffTotalDTO  (required)
   * @return PercentOffTotalDTO
   */
  @RequestLine("PUT /api/promotions/{promotionId}/percent-off-total/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  PercentOffTotalDTO updatePercentOffTotalPolicy(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId, @Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull PercentOffTotalDTO percentOffTotalDTO);

  /**
   * Update percentOffTotal policy
   * Similar to <code>updatePercentOffTotalPolicy</code> but it also returns the http response headers .
   * 
   * @param promotionId  (required)
   * @param id  (required)
   * @param percentOffTotalDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/promotions/{promotionId}/percent-off-total/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<PercentOffTotalDTO> updatePercentOffTotalPolicyWithHttpInfo(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId, @Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull PercentOffTotalDTO percentOffTotalDTO);



  /**
   * Update route condition
   * 
   * @param promotionId  (required)
   * @param id  (required)
   * @param conditionByRouteDTO  (required)
   * @return ConditionByRouteDTO
   */
  @RequestLine("PUT /api/promotions/{promotionId}/conditions/route/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ConditionByRouteDTO updateRouteCondition(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId, @Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull ConditionByRouteDTO conditionByRouteDTO);

  /**
   * Update route condition
   * Similar to <code>updateRouteCondition</code> but it also returns the http response headers .
   * 
   * @param promotionId  (required)
   * @param id  (required)
   * @param conditionByRouteDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/promotions/{promotionId}/conditions/route/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<ConditionByRouteDTO> updateRouteConditionWithHttpInfo(@Param("promotionId") @jakarta.annotation.Nonnull Long promotionId, @Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull ConditionByRouteDTO conditionByRouteDTO);


}
