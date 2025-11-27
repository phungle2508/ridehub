package com.ridehub.mspromotion.client.api;

import com.ridehub.mspromotion.client.invoker.ApiClient;
import com.ridehub.mspromotion.client.invoker.EncodingUtils;
import com.ridehub.mspromotion.client.model.ApiResponse;

import com.ridehub.mspromotion.client.model.PromotionDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface MsPromotionKafkaResourceMspromotionApi extends ApiClient.Api {


  /**
   * 
   * 
   * @return Map&lt;String, Object&gt;
   */
  @RequestLine("GET /api/ms-promotion-kafka/status")
  @Headers({
    "Accept: */*",
  })
  Map<String, Object> getStatus();

  /**
   * 
   * Similar to <code>getStatus</code> but it also returns the http response headers .
   * 
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/ms-promotion-kafka/status")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Map<String, Object>> getStatusWithHttpInfo();



  /**
   * 
   * 
   * @param promotionDTO  (required)
   * @return Map&lt;String, String&gt;
   */
  @RequestLine("POST /api/ms-promotion-kafka/publish/promotion-created")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  Map<String, String> publishPromotionCreated(@jakarta.annotation.Nonnull PromotionDTO promotionDTO);

  /**
   * 
   * Similar to <code>publishPromotionCreated</code> but it also returns the http response headers .
   * 
   * @param promotionDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/ms-promotion-kafka/publish/promotion-created")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<Map<String, String>> publishPromotionCreatedWithHttpInfo(@jakarta.annotation.Nonnull PromotionDTO promotionDTO);



  /**
   * 
   * 
   * @param id  (required)
   * @return Map&lt;String, String&gt;
   */
  @RequestLine("DELETE /api/ms-promotion-kafka/publish/promotion-deleted/{id}")
  @Headers({
    "Accept: */*",
  })
  Map<String, String> publishPromotionDeleted(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>publishPromotionDeleted</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("DELETE /api/ms-promotion-kafka/publish/promotion-deleted/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Map<String, String>> publishPromotionDeletedWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param promotionDTO  (required)
   * @return Map&lt;String, String&gt;
   */
  @RequestLine("POST /api/ms-promotion-kafka/publish/promotion-updated")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  Map<String, String> publishPromotionUpdated(@jakarta.annotation.Nonnull PromotionDTO promotionDTO);

  /**
   * 
   * Similar to <code>publishPromotionUpdated</code> but it also returns the http response headers .
   * 
   * @param promotionDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/ms-promotion-kafka/publish/promotion-updated")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<Map<String, String>> publishPromotionUpdatedWithHttpInfo(@jakarta.annotation.Nonnull PromotionDTO promotionDTO);



  /**
   * 
   * 
   * @param message  (required)
   * @return Map&lt;String, String&gt;
   */
  @RequestLine("POST /api/ms-promotion-kafka/publish/simple?message={message}")
  @Headers({
    "Accept: */*",
  })
  Map<String, String> publishSimple(@Param("message") @jakarta.annotation.Nonnull String message);

  /**
   * 
   * Similar to <code>publishSimple</code> but it also returns the http response headers .
   * 
   * @param message  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/ms-promotion-kafka/publish/simple?message={message}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Map<String, String>> publishSimpleWithHttpInfo(@Param("message") @jakarta.annotation.Nonnull String message);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>publishSimple</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link PublishSimpleQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>message -  (required)</li>
   *   </ul>
   * @return Map&lt;String, String&gt;
   */
  @RequestLine("POST /api/ms-promotion-kafka/publish/simple?message={message}")
  @Headers({
  "Accept: */*",
  })
  Map<String, String> publishSimple(@QueryMap(encoded=true) PublishSimpleQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>publishSimple</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>message -  (required)</li>
      *   </ul>
          * @return Map&lt;String, String&gt;
      */
      @RequestLine("POST /api/ms-promotion-kafka/publish/simple?message={message}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Map<String, String>> publishSimpleWithHttpInfo(@QueryMap(encoded=true) PublishSimpleQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>publishSimple</code> method in a fluent style.
   */
  public static class PublishSimpleQueryParams extends HashMap<String, Object> {
    public PublishSimpleQueryParams message(@jakarta.annotation.Nonnull final String value) {
      put("message", EncodingUtils.encode(value));
      return this;
    }
  }
}
