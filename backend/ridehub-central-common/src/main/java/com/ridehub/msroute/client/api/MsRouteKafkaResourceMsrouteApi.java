package com.ridehub.msroute.client.api;

import com.ridehub.msroute.client.invoker.ApiClient;
import com.ridehub.msroute.client.invoker.EncodingUtils;
import com.ridehub.msroute.client.model.ApiResponse;

import com.ridehub.msroute.client.model.RouteDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface MsRouteKafkaResourceMsrouteApi extends ApiClient.Api {


  /**
   * 
   * 
   * @return Map&lt;String, Object&gt;
   */
  @RequestLine("GET /api/ms-route-kafka/status")
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
  @RequestLine("GET /api/ms-route-kafka/status")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Map<String, Object>> getStatusWithHttpInfo();



  /**
   * 
   * 
   * @param routeDTO  (required)
   * @return Map&lt;String, String&gt;
   */
  @RequestLine("POST /api/ms-route-kafka/publish/route-created")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  Map<String, String> publishRouteCreated(@jakarta.annotation.Nonnull RouteDTO routeDTO);

  /**
   * 
   * Similar to <code>publishRouteCreated</code> but it also returns the http response headers .
   * 
   * @param routeDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/ms-route-kafka/publish/route-created")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<Map<String, String>> publishRouteCreatedWithHttpInfo(@jakarta.annotation.Nonnull RouteDTO routeDTO);



  /**
   * 
   * 
   * @param id  (required)
   * @return Map&lt;String, String&gt;
   */
  @RequestLine("DELETE /api/ms-route-kafka/publish/route-deleted/{id}")
  @Headers({
    "Accept: */*",
  })
  Map<String, String> publishRouteDeleted(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>publishRouteDeleted</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("DELETE /api/ms-route-kafka/publish/route-deleted/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Map<String, String>> publishRouteDeletedWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param routeDTO  (required)
   * @return Map&lt;String, String&gt;
   */
  @RequestLine("POST /api/ms-route-kafka/publish/route-updated")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  Map<String, String> publishRouteUpdated(@jakarta.annotation.Nonnull RouteDTO routeDTO);

  /**
   * 
   * Similar to <code>publishRouteUpdated</code> but it also returns the http response headers .
   * 
   * @param routeDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/ms-route-kafka/publish/route-updated")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<Map<String, String>> publishRouteUpdatedWithHttpInfo(@jakarta.annotation.Nonnull RouteDTO routeDTO);



  /**
   * 
   * 
   * @param message  (required)
   * @return Map&lt;String, String&gt;
   */
  @RequestLine("POST /api/ms-route-kafka/publish/simple?message={message}")
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
  @RequestLine("POST /api/ms-route-kafka/publish/simple?message={message}")
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
  @RequestLine("POST /api/ms-route-kafka/publish/simple?message={message}")
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
      @RequestLine("POST /api/ms-route-kafka/publish/simple?message={message}")
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
