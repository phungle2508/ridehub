package com.ridehub.msroutedev.client.api;

import com.ridehub.msroutedev.client.invoker.ApiClient;
import com.ridehub.msroutedev.client.invoker.EncodingUtils;
import com.ridehub.msroutedev.client.model.ApiResponse;

import com.ridehub.msroutedev.client.model.ResponseBodyEmitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface MsRouteKafkaResourceMsroutedevApi extends ApiClient.Api {


  /**
   * 
   * 
   * @param message  (required)
   */
  @RequestLine("POST /api/ms-route-kafka/publish?message={message}")
  @Headers({
    "Accept: application/json",
  })
  void publish(@Param("message") @jakarta.annotation.Nonnull String message);

  /**
   * 
   * Similar to <code>publish</code> but it also returns the http response headers .
   * 
   * @param message  (required)
   */
  @RequestLine("POST /api/ms-route-kafka/publish?message={message}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> publishWithHttpInfo(@Param("message") @jakarta.annotation.Nonnull String message);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>publish</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link PublishQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>message -  (required)</li>
   *   </ul>
   */
  @RequestLine("POST /api/ms-route-kafka/publish?message={message}")
  @Headers({
  "Accept: application/json",
  })
  void publish(@QueryMap(encoded=true) PublishQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>publish</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>message -  (required)</li>
      *   </ul>
      */
      @RequestLine("POST /api/ms-route-kafka/publish?message={message}")
      @Headers({
    "Accept: application/json",
      })
   ApiResponse<Void> publishWithHttpInfo(@QueryMap(encoded=true) PublishQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>publish</code> method in a fluent style.
   */
  public static class PublishQueryParams extends HashMap<String, Object> {
    public PublishQueryParams message(@jakarta.annotation.Nonnull final String value) {
      put("message", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @return ResponseBodyEmitter
   */
  @RequestLine("GET /api/ms-route-kafka/register")
  @Headers({
    "Accept: */*",
  })
  ResponseBodyEmitter register();

  /**
   * 
   * Similar to <code>register</code> but it also returns the http response headers .
   * 
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/ms-route-kafka/register")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<ResponseBodyEmitter> registerWithHttpInfo();



  /**
   * 
   * 
   */
  @RequestLine("GET /api/ms-route-kafka/unregister")
  @Headers({
    "Accept: application/json",
  })
  void unregister();

  /**
   * 
   * Similar to <code>unregister</code> but it also returns the http response headers .
   * 
   */
  @RequestLine("GET /api/ms-route-kafka/unregister")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> unregisterWithHttpInfo();


}
