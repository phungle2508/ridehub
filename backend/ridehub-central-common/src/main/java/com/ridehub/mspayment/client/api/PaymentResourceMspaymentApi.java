package com.ridehub.mspayment.client.api;

import com.ridehub.mspayment.client.invoker.ApiClient;
import com.ridehub.mspayment.client.invoker.EncodingUtils;
import com.ridehub.mspayment.client.model.ApiResponse;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import com.ridehub.mspayment.client.model.PaymentDTO;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface PaymentResourceMspaymentApi extends ApiClient.Api {


  /**
   * 
   * 
   * @param idEquals  (optional)
   * @param idNotEquals  (optional)
   * @param idSpecified  (optional)
   * @param idIn  (optional)
   * @param idNotIn  (optional)
   * @param bookingIdEquals  (optional)
   * @param bookingIdNotEquals  (optional)
   * @param bookingIdSpecified  (optional)
   * @param bookingIdIn  (optional)
   * @param bookingIdNotIn  (optional)
   * @param userIdEquals  (optional)
   * @param userIdNotEquals  (optional)
   * @param userIdSpecified  (optional)
   * @param userIdIn  (optional)
   * @param userIdNotIn  (optional)
   * @param amountGreaterThan  (optional)
   * @param amountLessThan  (optional)
   * @param amountGreaterThanOrEqual  (optional)
   * @param amountLessThanOrEqual  (optional)
   * @param amountEquals  (optional)
   * @param amountNotEquals  (optional)
   * @param amountSpecified  (optional)
   * @param amountIn  (optional)
   * @param amountNotIn  (optional)
   * @param currencyContains  (optional)
   * @param currencyDoesNotContain  (optional)
   * @param currencyEquals  (optional)
   * @param currencyNotEquals  (optional)
   * @param currencySpecified  (optional)
   * @param currencyIn  (optional)
   * @param currencyNotIn  (optional)
   * @param paymentMethodContains  (optional)
   * @param paymentMethodDoesNotContain  (optional)
   * @param paymentMethodEquals  (optional)
   * @param paymentMethodNotEquals  (optional)
   * @param paymentMethodSpecified  (optional)
   * @param paymentMethodIn  (optional)
   * @param paymentMethodNotIn  (optional)
   * @param statusEquals  (optional)
   * @param statusNotEquals  (optional)
   * @param statusSpecified  (optional)
   * @param statusIn  (optional)
   * @param statusNotIn  (optional)
   * @param transactionIdContains  (optional)
   * @param transactionIdDoesNotContain  (optional)
   * @param transactionIdEquals  (optional)
   * @param transactionIdNotEquals  (optional)
   * @param transactionIdSpecified  (optional)
   * @param transactionIdIn  (optional)
   * @param transactionIdNotIn  (optional)
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
   * @param distinct  (optional)
   * @return Long
   */
  @RequestLine("GET /api/payments/count?id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&userId.equals={userIdEquals}&userId.notEquals={userIdNotEquals}&userId.specified={userIdSpecified}&userId.in={userIdIn}&userId.notIn={userIdNotIn}&amount.greaterThan={amountGreaterThan}&amount.lessThan={amountLessThan}&amount.greaterThanOrEqual={amountGreaterThanOrEqual}&amount.lessThanOrEqual={amountLessThanOrEqual}&amount.equals={amountEquals}&amount.notEquals={amountNotEquals}&amount.specified={amountSpecified}&amount.in={amountIn}&amount.notIn={amountNotIn}&currency.contains={currencyContains}&currency.doesNotContain={currencyDoesNotContain}&currency.equals={currencyEquals}&currency.notEquals={currencyNotEquals}&currency.specified={currencySpecified}&currency.in={currencyIn}&currency.notIn={currencyNotIn}&paymentMethod.contains={paymentMethodContains}&paymentMethod.doesNotContain={paymentMethodDoesNotContain}&paymentMethod.equals={paymentMethodEquals}&paymentMethod.notEquals={paymentMethodNotEquals}&paymentMethod.specified={paymentMethodSpecified}&paymentMethod.in={paymentMethodIn}&paymentMethod.notIn={paymentMethodNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&transactionId.contains={transactionIdContains}&transactionId.doesNotContain={transactionIdDoesNotContain}&transactionId.equals={transactionIdEquals}&transactionId.notEquals={transactionIdNotEquals}&transactionId.specified={transactionIdSpecified}&transactionId.in={transactionIdIn}&transactionId.notIn={transactionIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  Long countPayments(@Param("idEquals") @jakarta.annotation.Nullable UUID idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable UUID idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<UUID> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<UUID> idNotIn, @Param("bookingIdEquals") @jakarta.annotation.Nullable UUID bookingIdEquals, @Param("bookingIdNotEquals") @jakarta.annotation.Nullable UUID bookingIdNotEquals, @Param("bookingIdSpecified") @jakarta.annotation.Nullable Boolean bookingIdSpecified, @Param("bookingIdIn") @jakarta.annotation.Nullable List<UUID> bookingIdIn, @Param("bookingIdNotIn") @jakarta.annotation.Nullable List<UUID> bookingIdNotIn, @Param("userIdEquals") @jakarta.annotation.Nullable UUID userIdEquals, @Param("userIdNotEquals") @jakarta.annotation.Nullable UUID userIdNotEquals, @Param("userIdSpecified") @jakarta.annotation.Nullable Boolean userIdSpecified, @Param("userIdIn") @jakarta.annotation.Nullable List<UUID> userIdIn, @Param("userIdNotIn") @jakarta.annotation.Nullable List<UUID> userIdNotIn, @Param("amountGreaterThan") @jakarta.annotation.Nullable BigDecimal amountGreaterThan, @Param("amountLessThan") @jakarta.annotation.Nullable BigDecimal amountLessThan, @Param("amountGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal amountGreaterThanOrEqual, @Param("amountLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal amountLessThanOrEqual, @Param("amountEquals") @jakarta.annotation.Nullable BigDecimal amountEquals, @Param("amountNotEquals") @jakarta.annotation.Nullable BigDecimal amountNotEquals, @Param("amountSpecified") @jakarta.annotation.Nullable Boolean amountSpecified, @Param("amountIn") @jakarta.annotation.Nullable List<BigDecimal> amountIn, @Param("amountNotIn") @jakarta.annotation.Nullable List<BigDecimal> amountNotIn, @Param("currencyContains") @jakarta.annotation.Nullable String currencyContains, @Param("currencyDoesNotContain") @jakarta.annotation.Nullable String currencyDoesNotContain, @Param("currencyEquals") @jakarta.annotation.Nullable String currencyEquals, @Param("currencyNotEquals") @jakarta.annotation.Nullable String currencyNotEquals, @Param("currencySpecified") @jakarta.annotation.Nullable Boolean currencySpecified, @Param("currencyIn") @jakarta.annotation.Nullable List<String> currencyIn, @Param("currencyNotIn") @jakarta.annotation.Nullable List<String> currencyNotIn, @Param("paymentMethodContains") @jakarta.annotation.Nullable String paymentMethodContains, @Param("paymentMethodDoesNotContain") @jakarta.annotation.Nullable String paymentMethodDoesNotContain, @Param("paymentMethodEquals") @jakarta.annotation.Nullable String paymentMethodEquals, @Param("paymentMethodNotEquals") @jakarta.annotation.Nullable String paymentMethodNotEquals, @Param("paymentMethodSpecified") @jakarta.annotation.Nullable Boolean paymentMethodSpecified, @Param("paymentMethodIn") @jakarta.annotation.Nullable List<String> paymentMethodIn, @Param("paymentMethodNotIn") @jakarta.annotation.Nullable List<String> paymentMethodNotIn, @Param("statusEquals") @jakarta.annotation.Nullable String statusEquals, @Param("statusNotEquals") @jakarta.annotation.Nullable String statusNotEquals, @Param("statusSpecified") @jakarta.annotation.Nullable Boolean statusSpecified, @Param("statusIn") @jakarta.annotation.Nullable List<String> statusIn, @Param("statusNotIn") @jakarta.annotation.Nullable List<String> statusNotIn, @Param("transactionIdContains") @jakarta.annotation.Nullable String transactionIdContains, @Param("transactionIdDoesNotContain") @jakarta.annotation.Nullable String transactionIdDoesNotContain, @Param("transactionIdEquals") @jakarta.annotation.Nullable String transactionIdEquals, @Param("transactionIdNotEquals") @jakarta.annotation.Nullable String transactionIdNotEquals, @Param("transactionIdSpecified") @jakarta.annotation.Nullable Boolean transactionIdSpecified, @Param("transactionIdIn") @jakarta.annotation.Nullable List<String> transactionIdIn, @Param("transactionIdNotIn") @jakarta.annotation.Nullable List<String> transactionIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>countPayments</code> but it also returns the http response headers .
   * 
   * @param idEquals  (optional)
   * @param idNotEquals  (optional)
   * @param idSpecified  (optional)
   * @param idIn  (optional)
   * @param idNotIn  (optional)
   * @param bookingIdEquals  (optional)
   * @param bookingIdNotEquals  (optional)
   * @param bookingIdSpecified  (optional)
   * @param bookingIdIn  (optional)
   * @param bookingIdNotIn  (optional)
   * @param userIdEquals  (optional)
   * @param userIdNotEquals  (optional)
   * @param userIdSpecified  (optional)
   * @param userIdIn  (optional)
   * @param userIdNotIn  (optional)
   * @param amountGreaterThan  (optional)
   * @param amountLessThan  (optional)
   * @param amountGreaterThanOrEqual  (optional)
   * @param amountLessThanOrEqual  (optional)
   * @param amountEquals  (optional)
   * @param amountNotEquals  (optional)
   * @param amountSpecified  (optional)
   * @param amountIn  (optional)
   * @param amountNotIn  (optional)
   * @param currencyContains  (optional)
   * @param currencyDoesNotContain  (optional)
   * @param currencyEquals  (optional)
   * @param currencyNotEquals  (optional)
   * @param currencySpecified  (optional)
   * @param currencyIn  (optional)
   * @param currencyNotIn  (optional)
   * @param paymentMethodContains  (optional)
   * @param paymentMethodDoesNotContain  (optional)
   * @param paymentMethodEquals  (optional)
   * @param paymentMethodNotEquals  (optional)
   * @param paymentMethodSpecified  (optional)
   * @param paymentMethodIn  (optional)
   * @param paymentMethodNotIn  (optional)
   * @param statusEquals  (optional)
   * @param statusNotEquals  (optional)
   * @param statusSpecified  (optional)
   * @param statusIn  (optional)
   * @param statusNotIn  (optional)
   * @param transactionIdContains  (optional)
   * @param transactionIdDoesNotContain  (optional)
   * @param transactionIdEquals  (optional)
   * @param transactionIdNotEquals  (optional)
   * @param transactionIdSpecified  (optional)
   * @param transactionIdIn  (optional)
   * @param transactionIdNotIn  (optional)
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
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/payments/count?id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&userId.equals={userIdEquals}&userId.notEquals={userIdNotEquals}&userId.specified={userIdSpecified}&userId.in={userIdIn}&userId.notIn={userIdNotIn}&amount.greaterThan={amountGreaterThan}&amount.lessThan={amountLessThan}&amount.greaterThanOrEqual={amountGreaterThanOrEqual}&amount.lessThanOrEqual={amountLessThanOrEqual}&amount.equals={amountEquals}&amount.notEquals={amountNotEquals}&amount.specified={amountSpecified}&amount.in={amountIn}&amount.notIn={amountNotIn}&currency.contains={currencyContains}&currency.doesNotContain={currencyDoesNotContain}&currency.equals={currencyEquals}&currency.notEquals={currencyNotEquals}&currency.specified={currencySpecified}&currency.in={currencyIn}&currency.notIn={currencyNotIn}&paymentMethod.contains={paymentMethodContains}&paymentMethod.doesNotContain={paymentMethodDoesNotContain}&paymentMethod.equals={paymentMethodEquals}&paymentMethod.notEquals={paymentMethodNotEquals}&paymentMethod.specified={paymentMethodSpecified}&paymentMethod.in={paymentMethodIn}&paymentMethod.notIn={paymentMethodNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&transactionId.contains={transactionIdContains}&transactionId.doesNotContain={transactionIdDoesNotContain}&transactionId.equals={transactionIdEquals}&transactionId.notEquals={transactionIdNotEquals}&transactionId.specified={transactionIdSpecified}&transactionId.in={transactionIdIn}&transactionId.notIn={transactionIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Long> countPaymentsWithHttpInfo(@Param("idEquals") @jakarta.annotation.Nullable UUID idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable UUID idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<UUID> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<UUID> idNotIn, @Param("bookingIdEquals") @jakarta.annotation.Nullable UUID bookingIdEquals, @Param("bookingIdNotEquals") @jakarta.annotation.Nullable UUID bookingIdNotEquals, @Param("bookingIdSpecified") @jakarta.annotation.Nullable Boolean bookingIdSpecified, @Param("bookingIdIn") @jakarta.annotation.Nullable List<UUID> bookingIdIn, @Param("bookingIdNotIn") @jakarta.annotation.Nullable List<UUID> bookingIdNotIn, @Param("userIdEquals") @jakarta.annotation.Nullable UUID userIdEquals, @Param("userIdNotEquals") @jakarta.annotation.Nullable UUID userIdNotEquals, @Param("userIdSpecified") @jakarta.annotation.Nullable Boolean userIdSpecified, @Param("userIdIn") @jakarta.annotation.Nullable List<UUID> userIdIn, @Param("userIdNotIn") @jakarta.annotation.Nullable List<UUID> userIdNotIn, @Param("amountGreaterThan") @jakarta.annotation.Nullable BigDecimal amountGreaterThan, @Param("amountLessThan") @jakarta.annotation.Nullable BigDecimal amountLessThan, @Param("amountGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal amountGreaterThanOrEqual, @Param("amountLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal amountLessThanOrEqual, @Param("amountEquals") @jakarta.annotation.Nullable BigDecimal amountEquals, @Param("amountNotEquals") @jakarta.annotation.Nullable BigDecimal amountNotEquals, @Param("amountSpecified") @jakarta.annotation.Nullable Boolean amountSpecified, @Param("amountIn") @jakarta.annotation.Nullable List<BigDecimal> amountIn, @Param("amountNotIn") @jakarta.annotation.Nullable List<BigDecimal> amountNotIn, @Param("currencyContains") @jakarta.annotation.Nullable String currencyContains, @Param("currencyDoesNotContain") @jakarta.annotation.Nullable String currencyDoesNotContain, @Param("currencyEquals") @jakarta.annotation.Nullable String currencyEquals, @Param("currencyNotEquals") @jakarta.annotation.Nullable String currencyNotEquals, @Param("currencySpecified") @jakarta.annotation.Nullable Boolean currencySpecified, @Param("currencyIn") @jakarta.annotation.Nullable List<String> currencyIn, @Param("currencyNotIn") @jakarta.annotation.Nullable List<String> currencyNotIn, @Param("paymentMethodContains") @jakarta.annotation.Nullable String paymentMethodContains, @Param("paymentMethodDoesNotContain") @jakarta.annotation.Nullable String paymentMethodDoesNotContain, @Param("paymentMethodEquals") @jakarta.annotation.Nullable String paymentMethodEquals, @Param("paymentMethodNotEquals") @jakarta.annotation.Nullable String paymentMethodNotEquals, @Param("paymentMethodSpecified") @jakarta.annotation.Nullable Boolean paymentMethodSpecified, @Param("paymentMethodIn") @jakarta.annotation.Nullable List<String> paymentMethodIn, @Param("paymentMethodNotIn") @jakarta.annotation.Nullable List<String> paymentMethodNotIn, @Param("statusEquals") @jakarta.annotation.Nullable String statusEquals, @Param("statusNotEquals") @jakarta.annotation.Nullable String statusNotEquals, @Param("statusSpecified") @jakarta.annotation.Nullable Boolean statusSpecified, @Param("statusIn") @jakarta.annotation.Nullable List<String> statusIn, @Param("statusNotIn") @jakarta.annotation.Nullable List<String> statusNotIn, @Param("transactionIdContains") @jakarta.annotation.Nullable String transactionIdContains, @Param("transactionIdDoesNotContain") @jakarta.annotation.Nullable String transactionIdDoesNotContain, @Param("transactionIdEquals") @jakarta.annotation.Nullable String transactionIdEquals, @Param("transactionIdNotEquals") @jakarta.annotation.Nullable String transactionIdNotEquals, @Param("transactionIdSpecified") @jakarta.annotation.Nullable Boolean transactionIdSpecified, @Param("transactionIdIn") @jakarta.annotation.Nullable List<String> transactionIdIn, @Param("transactionIdNotIn") @jakarta.annotation.Nullable List<String> transactionIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>countPayments</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CountPaymentsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>idEquals -  (optional)</li>
   *   <li>idNotEquals -  (optional)</li>
   *   <li>idSpecified -  (optional)</li>
   *   <li>idIn -  (optional)</li>
   *   <li>idNotIn -  (optional)</li>
   *   <li>bookingIdEquals -  (optional)</li>
   *   <li>bookingIdNotEquals -  (optional)</li>
   *   <li>bookingIdSpecified -  (optional)</li>
   *   <li>bookingIdIn -  (optional)</li>
   *   <li>bookingIdNotIn -  (optional)</li>
   *   <li>userIdEquals -  (optional)</li>
   *   <li>userIdNotEquals -  (optional)</li>
   *   <li>userIdSpecified -  (optional)</li>
   *   <li>userIdIn -  (optional)</li>
   *   <li>userIdNotIn -  (optional)</li>
   *   <li>amountGreaterThan -  (optional)</li>
   *   <li>amountLessThan -  (optional)</li>
   *   <li>amountGreaterThanOrEqual -  (optional)</li>
   *   <li>amountLessThanOrEqual -  (optional)</li>
   *   <li>amountEquals -  (optional)</li>
   *   <li>amountNotEquals -  (optional)</li>
   *   <li>amountSpecified -  (optional)</li>
   *   <li>amountIn -  (optional)</li>
   *   <li>amountNotIn -  (optional)</li>
   *   <li>currencyContains -  (optional)</li>
   *   <li>currencyDoesNotContain -  (optional)</li>
   *   <li>currencyEquals -  (optional)</li>
   *   <li>currencyNotEquals -  (optional)</li>
   *   <li>currencySpecified -  (optional)</li>
   *   <li>currencyIn -  (optional)</li>
   *   <li>currencyNotIn -  (optional)</li>
   *   <li>paymentMethodContains -  (optional)</li>
   *   <li>paymentMethodDoesNotContain -  (optional)</li>
   *   <li>paymentMethodEquals -  (optional)</li>
   *   <li>paymentMethodNotEquals -  (optional)</li>
   *   <li>paymentMethodSpecified -  (optional)</li>
   *   <li>paymentMethodIn -  (optional)</li>
   *   <li>paymentMethodNotIn -  (optional)</li>
   *   <li>statusEquals -  (optional)</li>
   *   <li>statusNotEquals -  (optional)</li>
   *   <li>statusSpecified -  (optional)</li>
   *   <li>statusIn -  (optional)</li>
   *   <li>statusNotIn -  (optional)</li>
   *   <li>transactionIdContains -  (optional)</li>
   *   <li>transactionIdDoesNotContain -  (optional)</li>
   *   <li>transactionIdEquals -  (optional)</li>
   *   <li>transactionIdNotEquals -  (optional)</li>
   *   <li>transactionIdSpecified -  (optional)</li>
   *   <li>transactionIdIn -  (optional)</li>
   *   <li>transactionIdNotIn -  (optional)</li>
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
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return Long
   */
  @RequestLine("GET /api/payments/count?id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&userId.equals={userIdEquals}&userId.notEquals={userIdNotEquals}&userId.specified={userIdSpecified}&userId.in={userIdIn}&userId.notIn={userIdNotIn}&amount.greaterThan={amountGreaterThan}&amount.lessThan={amountLessThan}&amount.greaterThanOrEqual={amountGreaterThanOrEqual}&amount.lessThanOrEqual={amountLessThanOrEqual}&amount.equals={amountEquals}&amount.notEquals={amountNotEquals}&amount.specified={amountSpecified}&amount.in={amountIn}&amount.notIn={amountNotIn}&currency.contains={currencyContains}&currency.doesNotContain={currencyDoesNotContain}&currency.equals={currencyEquals}&currency.notEquals={currencyNotEquals}&currency.specified={currencySpecified}&currency.in={currencyIn}&currency.notIn={currencyNotIn}&paymentMethod.contains={paymentMethodContains}&paymentMethod.doesNotContain={paymentMethodDoesNotContain}&paymentMethod.equals={paymentMethodEquals}&paymentMethod.notEquals={paymentMethodNotEquals}&paymentMethod.specified={paymentMethodSpecified}&paymentMethod.in={paymentMethodIn}&paymentMethod.notIn={paymentMethodNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&transactionId.contains={transactionIdContains}&transactionId.doesNotContain={transactionIdDoesNotContain}&transactionId.equals={transactionIdEquals}&transactionId.notEquals={transactionIdNotEquals}&transactionId.specified={transactionIdSpecified}&transactionId.in={transactionIdIn}&transactionId.notIn={transactionIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  Long countPayments(@QueryMap(encoded=true) CountPaymentsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>countPayments</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>idEquals -  (optional)</li>
          *   <li>idNotEquals -  (optional)</li>
          *   <li>idSpecified -  (optional)</li>
          *   <li>idIn -  (optional)</li>
          *   <li>idNotIn -  (optional)</li>
          *   <li>bookingIdEquals -  (optional)</li>
          *   <li>bookingIdNotEquals -  (optional)</li>
          *   <li>bookingIdSpecified -  (optional)</li>
          *   <li>bookingIdIn -  (optional)</li>
          *   <li>bookingIdNotIn -  (optional)</li>
          *   <li>userIdEquals -  (optional)</li>
          *   <li>userIdNotEquals -  (optional)</li>
          *   <li>userIdSpecified -  (optional)</li>
          *   <li>userIdIn -  (optional)</li>
          *   <li>userIdNotIn -  (optional)</li>
          *   <li>amountGreaterThan -  (optional)</li>
          *   <li>amountLessThan -  (optional)</li>
          *   <li>amountGreaterThanOrEqual -  (optional)</li>
          *   <li>amountLessThanOrEqual -  (optional)</li>
          *   <li>amountEquals -  (optional)</li>
          *   <li>amountNotEquals -  (optional)</li>
          *   <li>amountSpecified -  (optional)</li>
          *   <li>amountIn -  (optional)</li>
          *   <li>amountNotIn -  (optional)</li>
          *   <li>currencyContains -  (optional)</li>
          *   <li>currencyDoesNotContain -  (optional)</li>
          *   <li>currencyEquals -  (optional)</li>
          *   <li>currencyNotEquals -  (optional)</li>
          *   <li>currencySpecified -  (optional)</li>
          *   <li>currencyIn -  (optional)</li>
          *   <li>currencyNotIn -  (optional)</li>
          *   <li>paymentMethodContains -  (optional)</li>
          *   <li>paymentMethodDoesNotContain -  (optional)</li>
          *   <li>paymentMethodEquals -  (optional)</li>
          *   <li>paymentMethodNotEquals -  (optional)</li>
          *   <li>paymentMethodSpecified -  (optional)</li>
          *   <li>paymentMethodIn -  (optional)</li>
          *   <li>paymentMethodNotIn -  (optional)</li>
          *   <li>statusEquals -  (optional)</li>
          *   <li>statusNotEquals -  (optional)</li>
          *   <li>statusSpecified -  (optional)</li>
          *   <li>statusIn -  (optional)</li>
          *   <li>statusNotIn -  (optional)</li>
          *   <li>transactionIdContains -  (optional)</li>
          *   <li>transactionIdDoesNotContain -  (optional)</li>
          *   <li>transactionIdEquals -  (optional)</li>
          *   <li>transactionIdNotEquals -  (optional)</li>
          *   <li>transactionIdSpecified -  (optional)</li>
          *   <li>transactionIdIn -  (optional)</li>
          *   <li>transactionIdNotIn -  (optional)</li>
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
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return Long
      */
      @RequestLine("GET /api/payments/count?id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&userId.equals={userIdEquals}&userId.notEquals={userIdNotEquals}&userId.specified={userIdSpecified}&userId.in={userIdIn}&userId.notIn={userIdNotIn}&amount.greaterThan={amountGreaterThan}&amount.lessThan={amountLessThan}&amount.greaterThanOrEqual={amountGreaterThanOrEqual}&amount.lessThanOrEqual={amountLessThanOrEqual}&amount.equals={amountEquals}&amount.notEquals={amountNotEquals}&amount.specified={amountSpecified}&amount.in={amountIn}&amount.notIn={amountNotIn}&currency.contains={currencyContains}&currency.doesNotContain={currencyDoesNotContain}&currency.equals={currencyEquals}&currency.notEquals={currencyNotEquals}&currency.specified={currencySpecified}&currency.in={currencyIn}&currency.notIn={currencyNotIn}&paymentMethod.contains={paymentMethodContains}&paymentMethod.doesNotContain={paymentMethodDoesNotContain}&paymentMethod.equals={paymentMethodEquals}&paymentMethod.notEquals={paymentMethodNotEquals}&paymentMethod.specified={paymentMethodSpecified}&paymentMethod.in={paymentMethodIn}&paymentMethod.notIn={paymentMethodNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&transactionId.contains={transactionIdContains}&transactionId.doesNotContain={transactionIdDoesNotContain}&transactionId.equals={transactionIdEquals}&transactionId.notEquals={transactionIdNotEquals}&transactionId.specified={transactionIdSpecified}&transactionId.in={transactionIdIn}&transactionId.notIn={transactionIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Long> countPaymentsWithHttpInfo(@QueryMap(encoded=true) CountPaymentsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>countPayments</code> method in a fluent style.
   */
  public static class CountPaymentsQueryParams extends HashMap<String, Object> {
    public CountPaymentsQueryParams idEquals(@jakarta.annotation.Nullable final UUID value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams idNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams idIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentsQueryParams idNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentsQueryParams bookingIdEquals(@jakarta.annotation.Nullable final UUID value) {
      put("bookingId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams bookingIdNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("bookingId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams bookingIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("bookingId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams bookingIdIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("bookingId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentsQueryParams bookingIdNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("bookingId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentsQueryParams userIdEquals(@jakarta.annotation.Nullable final UUID value) {
      put("userId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams userIdNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("userId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams userIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("userId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams userIdIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("userId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentsQueryParams userIdNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("userId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentsQueryParams amountGreaterThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("amount.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams amountLessThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("amount.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams amountGreaterThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("amount.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams amountLessThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("amount.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams amountEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("amount.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams amountNotEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("amount.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams amountSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("amount.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams amountIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("amount.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentsQueryParams amountNotIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("amount.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentsQueryParams currencyContains(@jakarta.annotation.Nullable final String value) {
      put("currency.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams currencyDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("currency.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams currencyEquals(@jakarta.annotation.Nullable final String value) {
      put("currency.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams currencyNotEquals(@jakarta.annotation.Nullable final String value) {
      put("currency.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams currencySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("currency.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams currencyIn(@jakarta.annotation.Nullable final List<String> value) {
      put("currency.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentsQueryParams currencyNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("currency.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentsQueryParams paymentMethodContains(@jakarta.annotation.Nullable final String value) {
      put("paymentMethod.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams paymentMethodDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("paymentMethod.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams paymentMethodEquals(@jakarta.annotation.Nullable final String value) {
      put("paymentMethod.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams paymentMethodNotEquals(@jakarta.annotation.Nullable final String value) {
      put("paymentMethod.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams paymentMethodSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("paymentMethod.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams paymentMethodIn(@jakarta.annotation.Nullable final List<String> value) {
      put("paymentMethod.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentsQueryParams paymentMethodNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("paymentMethod.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentsQueryParams statusEquals(@jakarta.annotation.Nullable final String value) {
      put("status.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams statusNotEquals(@jakarta.annotation.Nullable final String value) {
      put("status.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams statusSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("status.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams statusIn(@jakarta.annotation.Nullable final List<String> value) {
      put("status.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentsQueryParams statusNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("status.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentsQueryParams transactionIdContains(@jakarta.annotation.Nullable final String value) {
      put("transactionId.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams transactionIdDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("transactionId.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams transactionIdEquals(@jakarta.annotation.Nullable final String value) {
      put("transactionId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams transactionIdNotEquals(@jakarta.annotation.Nullable final String value) {
      put("transactionId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams transactionIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("transactionId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams transactionIdIn(@jakarta.annotation.Nullable final List<String> value) {
      put("transactionId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentsQueryParams transactionIdNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("transactionId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentsQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentsQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentsQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param paymentDTO  (required)
   * @return PaymentDTO
   */
  @RequestLine("POST /api/payments")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  PaymentDTO createPayment(@jakarta.annotation.Nonnull PaymentDTO paymentDTO);

  /**
   * 
   * Similar to <code>createPayment</code> but it also returns the http response headers .
   * 
   * @param paymentDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/payments")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<PaymentDTO> createPaymentWithHttpInfo(@jakarta.annotation.Nonnull PaymentDTO paymentDTO);



  /**
   * 
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/payments/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deletePayment(@Param("id") @jakarta.annotation.Nonnull UUID id);

  /**
   * 
   * Similar to <code>deletePayment</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/payments/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deletePaymentWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull UUID id);



  /**
   * 
   * 
   * @param idEquals  (optional)
   * @param idNotEquals  (optional)
   * @param idSpecified  (optional)
   * @param idIn  (optional)
   * @param idNotIn  (optional)
   * @param bookingIdEquals  (optional)
   * @param bookingIdNotEquals  (optional)
   * @param bookingIdSpecified  (optional)
   * @param bookingIdIn  (optional)
   * @param bookingIdNotIn  (optional)
   * @param userIdEquals  (optional)
   * @param userIdNotEquals  (optional)
   * @param userIdSpecified  (optional)
   * @param userIdIn  (optional)
   * @param userIdNotIn  (optional)
   * @param amountGreaterThan  (optional)
   * @param amountLessThan  (optional)
   * @param amountGreaterThanOrEqual  (optional)
   * @param amountLessThanOrEqual  (optional)
   * @param amountEquals  (optional)
   * @param amountNotEquals  (optional)
   * @param amountSpecified  (optional)
   * @param amountIn  (optional)
   * @param amountNotIn  (optional)
   * @param currencyContains  (optional)
   * @param currencyDoesNotContain  (optional)
   * @param currencyEquals  (optional)
   * @param currencyNotEquals  (optional)
   * @param currencySpecified  (optional)
   * @param currencyIn  (optional)
   * @param currencyNotIn  (optional)
   * @param paymentMethodContains  (optional)
   * @param paymentMethodDoesNotContain  (optional)
   * @param paymentMethodEquals  (optional)
   * @param paymentMethodNotEquals  (optional)
   * @param paymentMethodSpecified  (optional)
   * @param paymentMethodIn  (optional)
   * @param paymentMethodNotIn  (optional)
   * @param statusEquals  (optional)
   * @param statusNotEquals  (optional)
   * @param statusSpecified  (optional)
   * @param statusIn  (optional)
   * @param statusNotIn  (optional)
   * @param transactionIdContains  (optional)
   * @param transactionIdDoesNotContain  (optional)
   * @param transactionIdEquals  (optional)
   * @param transactionIdNotEquals  (optional)
   * @param transactionIdSpecified  (optional)
   * @param transactionIdIn  (optional)
   * @param transactionIdNotIn  (optional)
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
   * @param distinct  (optional)
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return List&lt;PaymentDTO&gt;
   */
  @RequestLine("GET /api/payments?id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&userId.equals={userIdEquals}&userId.notEquals={userIdNotEquals}&userId.specified={userIdSpecified}&userId.in={userIdIn}&userId.notIn={userIdNotIn}&amount.greaterThan={amountGreaterThan}&amount.lessThan={amountLessThan}&amount.greaterThanOrEqual={amountGreaterThanOrEqual}&amount.lessThanOrEqual={amountLessThanOrEqual}&amount.equals={amountEquals}&amount.notEquals={amountNotEquals}&amount.specified={amountSpecified}&amount.in={amountIn}&amount.notIn={amountNotIn}&currency.contains={currencyContains}&currency.doesNotContain={currencyDoesNotContain}&currency.equals={currencyEquals}&currency.notEquals={currencyNotEquals}&currency.specified={currencySpecified}&currency.in={currencyIn}&currency.notIn={currencyNotIn}&paymentMethod.contains={paymentMethodContains}&paymentMethod.doesNotContain={paymentMethodDoesNotContain}&paymentMethod.equals={paymentMethodEquals}&paymentMethod.notEquals={paymentMethodNotEquals}&paymentMethod.specified={paymentMethodSpecified}&paymentMethod.in={paymentMethodIn}&paymentMethod.notIn={paymentMethodNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&transactionId.contains={transactionIdContains}&transactionId.doesNotContain={transactionIdDoesNotContain}&transactionId.equals={transactionIdEquals}&transactionId.notEquals={transactionIdNotEquals}&transactionId.specified={transactionIdSpecified}&transactionId.in={transactionIdIn}&transactionId.notIn={transactionIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",
  })
  List<PaymentDTO> getAllPayments(@Param("idEquals") @jakarta.annotation.Nullable UUID idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable UUID idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<UUID> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<UUID> idNotIn, @Param("bookingIdEquals") @jakarta.annotation.Nullable UUID bookingIdEquals, @Param("bookingIdNotEquals") @jakarta.annotation.Nullable UUID bookingIdNotEquals, @Param("bookingIdSpecified") @jakarta.annotation.Nullable Boolean bookingIdSpecified, @Param("bookingIdIn") @jakarta.annotation.Nullable List<UUID> bookingIdIn, @Param("bookingIdNotIn") @jakarta.annotation.Nullable List<UUID> bookingIdNotIn, @Param("userIdEquals") @jakarta.annotation.Nullable UUID userIdEquals, @Param("userIdNotEquals") @jakarta.annotation.Nullable UUID userIdNotEquals, @Param("userIdSpecified") @jakarta.annotation.Nullable Boolean userIdSpecified, @Param("userIdIn") @jakarta.annotation.Nullable List<UUID> userIdIn, @Param("userIdNotIn") @jakarta.annotation.Nullable List<UUID> userIdNotIn, @Param("amountGreaterThan") @jakarta.annotation.Nullable BigDecimal amountGreaterThan, @Param("amountLessThan") @jakarta.annotation.Nullable BigDecimal amountLessThan, @Param("amountGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal amountGreaterThanOrEqual, @Param("amountLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal amountLessThanOrEqual, @Param("amountEquals") @jakarta.annotation.Nullable BigDecimal amountEquals, @Param("amountNotEquals") @jakarta.annotation.Nullable BigDecimal amountNotEquals, @Param("amountSpecified") @jakarta.annotation.Nullable Boolean amountSpecified, @Param("amountIn") @jakarta.annotation.Nullable List<BigDecimal> amountIn, @Param("amountNotIn") @jakarta.annotation.Nullable List<BigDecimal> amountNotIn, @Param("currencyContains") @jakarta.annotation.Nullable String currencyContains, @Param("currencyDoesNotContain") @jakarta.annotation.Nullable String currencyDoesNotContain, @Param("currencyEquals") @jakarta.annotation.Nullable String currencyEquals, @Param("currencyNotEquals") @jakarta.annotation.Nullable String currencyNotEquals, @Param("currencySpecified") @jakarta.annotation.Nullable Boolean currencySpecified, @Param("currencyIn") @jakarta.annotation.Nullable List<String> currencyIn, @Param("currencyNotIn") @jakarta.annotation.Nullable List<String> currencyNotIn, @Param("paymentMethodContains") @jakarta.annotation.Nullable String paymentMethodContains, @Param("paymentMethodDoesNotContain") @jakarta.annotation.Nullable String paymentMethodDoesNotContain, @Param("paymentMethodEquals") @jakarta.annotation.Nullable String paymentMethodEquals, @Param("paymentMethodNotEquals") @jakarta.annotation.Nullable String paymentMethodNotEquals, @Param("paymentMethodSpecified") @jakarta.annotation.Nullable Boolean paymentMethodSpecified, @Param("paymentMethodIn") @jakarta.annotation.Nullable List<String> paymentMethodIn, @Param("paymentMethodNotIn") @jakarta.annotation.Nullable List<String> paymentMethodNotIn, @Param("statusEquals") @jakarta.annotation.Nullable String statusEquals, @Param("statusNotEquals") @jakarta.annotation.Nullable String statusNotEquals, @Param("statusSpecified") @jakarta.annotation.Nullable Boolean statusSpecified, @Param("statusIn") @jakarta.annotation.Nullable List<String> statusIn, @Param("statusNotIn") @jakarta.annotation.Nullable List<String> statusNotIn, @Param("transactionIdContains") @jakarta.annotation.Nullable String transactionIdContains, @Param("transactionIdDoesNotContain") @jakarta.annotation.Nullable String transactionIdDoesNotContain, @Param("transactionIdEquals") @jakarta.annotation.Nullable String transactionIdEquals, @Param("transactionIdNotEquals") @jakarta.annotation.Nullable String transactionIdNotEquals, @Param("transactionIdSpecified") @jakarta.annotation.Nullable Boolean transactionIdSpecified, @Param("transactionIdIn") @jakarta.annotation.Nullable List<String> transactionIdIn, @Param("transactionIdNotIn") @jakarta.annotation.Nullable List<String> transactionIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct, @Param("page") @jakarta.annotation.Nullable Integer page, @Param("size") @jakarta.annotation.Nullable Integer size, @Param("sort") @jakarta.annotation.Nullable List<String> sort);

  /**
   * 
   * Similar to <code>getAllPayments</code> but it also returns the http response headers .
   * 
   * @param idEquals  (optional)
   * @param idNotEquals  (optional)
   * @param idSpecified  (optional)
   * @param idIn  (optional)
   * @param idNotIn  (optional)
   * @param bookingIdEquals  (optional)
   * @param bookingIdNotEquals  (optional)
   * @param bookingIdSpecified  (optional)
   * @param bookingIdIn  (optional)
   * @param bookingIdNotIn  (optional)
   * @param userIdEquals  (optional)
   * @param userIdNotEquals  (optional)
   * @param userIdSpecified  (optional)
   * @param userIdIn  (optional)
   * @param userIdNotIn  (optional)
   * @param amountGreaterThan  (optional)
   * @param amountLessThan  (optional)
   * @param amountGreaterThanOrEqual  (optional)
   * @param amountLessThanOrEqual  (optional)
   * @param amountEquals  (optional)
   * @param amountNotEquals  (optional)
   * @param amountSpecified  (optional)
   * @param amountIn  (optional)
   * @param amountNotIn  (optional)
   * @param currencyContains  (optional)
   * @param currencyDoesNotContain  (optional)
   * @param currencyEquals  (optional)
   * @param currencyNotEquals  (optional)
   * @param currencySpecified  (optional)
   * @param currencyIn  (optional)
   * @param currencyNotIn  (optional)
   * @param paymentMethodContains  (optional)
   * @param paymentMethodDoesNotContain  (optional)
   * @param paymentMethodEquals  (optional)
   * @param paymentMethodNotEquals  (optional)
   * @param paymentMethodSpecified  (optional)
   * @param paymentMethodIn  (optional)
   * @param paymentMethodNotIn  (optional)
   * @param statusEquals  (optional)
   * @param statusNotEquals  (optional)
   * @param statusSpecified  (optional)
   * @param statusIn  (optional)
   * @param statusNotIn  (optional)
   * @param transactionIdContains  (optional)
   * @param transactionIdDoesNotContain  (optional)
   * @param transactionIdEquals  (optional)
   * @param transactionIdNotEquals  (optional)
   * @param transactionIdSpecified  (optional)
   * @param transactionIdIn  (optional)
   * @param transactionIdNotIn  (optional)
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
   * @param distinct  (optional)
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/payments?id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&userId.equals={userIdEquals}&userId.notEquals={userIdNotEquals}&userId.specified={userIdSpecified}&userId.in={userIdIn}&userId.notIn={userIdNotIn}&amount.greaterThan={amountGreaterThan}&amount.lessThan={amountLessThan}&amount.greaterThanOrEqual={amountGreaterThanOrEqual}&amount.lessThanOrEqual={amountLessThanOrEqual}&amount.equals={amountEquals}&amount.notEquals={amountNotEquals}&amount.specified={amountSpecified}&amount.in={amountIn}&amount.notIn={amountNotIn}&currency.contains={currencyContains}&currency.doesNotContain={currencyDoesNotContain}&currency.equals={currencyEquals}&currency.notEquals={currencyNotEquals}&currency.specified={currencySpecified}&currency.in={currencyIn}&currency.notIn={currencyNotIn}&paymentMethod.contains={paymentMethodContains}&paymentMethod.doesNotContain={paymentMethodDoesNotContain}&paymentMethod.equals={paymentMethodEquals}&paymentMethod.notEquals={paymentMethodNotEquals}&paymentMethod.specified={paymentMethodSpecified}&paymentMethod.in={paymentMethodIn}&paymentMethod.notIn={paymentMethodNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&transactionId.contains={transactionIdContains}&transactionId.doesNotContain={transactionIdDoesNotContain}&transactionId.equals={transactionIdEquals}&transactionId.notEquals={transactionIdNotEquals}&transactionId.specified={transactionIdSpecified}&transactionId.in={transactionIdIn}&transactionId.notIn={transactionIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<PaymentDTO>> getAllPaymentsWithHttpInfo(@Param("idEquals") @jakarta.annotation.Nullable UUID idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable UUID idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<UUID> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<UUID> idNotIn, @Param("bookingIdEquals") @jakarta.annotation.Nullable UUID bookingIdEquals, @Param("bookingIdNotEquals") @jakarta.annotation.Nullable UUID bookingIdNotEquals, @Param("bookingIdSpecified") @jakarta.annotation.Nullable Boolean bookingIdSpecified, @Param("bookingIdIn") @jakarta.annotation.Nullable List<UUID> bookingIdIn, @Param("bookingIdNotIn") @jakarta.annotation.Nullable List<UUID> bookingIdNotIn, @Param("userIdEquals") @jakarta.annotation.Nullable UUID userIdEquals, @Param("userIdNotEquals") @jakarta.annotation.Nullable UUID userIdNotEquals, @Param("userIdSpecified") @jakarta.annotation.Nullable Boolean userIdSpecified, @Param("userIdIn") @jakarta.annotation.Nullable List<UUID> userIdIn, @Param("userIdNotIn") @jakarta.annotation.Nullable List<UUID> userIdNotIn, @Param("amountGreaterThan") @jakarta.annotation.Nullable BigDecimal amountGreaterThan, @Param("amountLessThan") @jakarta.annotation.Nullable BigDecimal amountLessThan, @Param("amountGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal amountGreaterThanOrEqual, @Param("amountLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal amountLessThanOrEqual, @Param("amountEquals") @jakarta.annotation.Nullable BigDecimal amountEquals, @Param("amountNotEquals") @jakarta.annotation.Nullable BigDecimal amountNotEquals, @Param("amountSpecified") @jakarta.annotation.Nullable Boolean amountSpecified, @Param("amountIn") @jakarta.annotation.Nullable List<BigDecimal> amountIn, @Param("amountNotIn") @jakarta.annotation.Nullable List<BigDecimal> amountNotIn, @Param("currencyContains") @jakarta.annotation.Nullable String currencyContains, @Param("currencyDoesNotContain") @jakarta.annotation.Nullable String currencyDoesNotContain, @Param("currencyEquals") @jakarta.annotation.Nullable String currencyEquals, @Param("currencyNotEquals") @jakarta.annotation.Nullable String currencyNotEquals, @Param("currencySpecified") @jakarta.annotation.Nullable Boolean currencySpecified, @Param("currencyIn") @jakarta.annotation.Nullable List<String> currencyIn, @Param("currencyNotIn") @jakarta.annotation.Nullable List<String> currencyNotIn, @Param("paymentMethodContains") @jakarta.annotation.Nullable String paymentMethodContains, @Param("paymentMethodDoesNotContain") @jakarta.annotation.Nullable String paymentMethodDoesNotContain, @Param("paymentMethodEquals") @jakarta.annotation.Nullable String paymentMethodEquals, @Param("paymentMethodNotEquals") @jakarta.annotation.Nullable String paymentMethodNotEquals, @Param("paymentMethodSpecified") @jakarta.annotation.Nullable Boolean paymentMethodSpecified, @Param("paymentMethodIn") @jakarta.annotation.Nullable List<String> paymentMethodIn, @Param("paymentMethodNotIn") @jakarta.annotation.Nullable List<String> paymentMethodNotIn, @Param("statusEquals") @jakarta.annotation.Nullable String statusEquals, @Param("statusNotEquals") @jakarta.annotation.Nullable String statusNotEquals, @Param("statusSpecified") @jakarta.annotation.Nullable Boolean statusSpecified, @Param("statusIn") @jakarta.annotation.Nullable List<String> statusIn, @Param("statusNotIn") @jakarta.annotation.Nullable List<String> statusNotIn, @Param("transactionIdContains") @jakarta.annotation.Nullable String transactionIdContains, @Param("transactionIdDoesNotContain") @jakarta.annotation.Nullable String transactionIdDoesNotContain, @Param("transactionIdEquals") @jakarta.annotation.Nullable String transactionIdEquals, @Param("transactionIdNotEquals") @jakarta.annotation.Nullable String transactionIdNotEquals, @Param("transactionIdSpecified") @jakarta.annotation.Nullable Boolean transactionIdSpecified, @Param("transactionIdIn") @jakarta.annotation.Nullable List<String> transactionIdIn, @Param("transactionIdNotIn") @jakarta.annotation.Nullable List<String> transactionIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct, @Param("page") @jakarta.annotation.Nullable Integer page, @Param("size") @jakarta.annotation.Nullable Integer size, @Param("sort") @jakarta.annotation.Nullable List<String> sort);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllPayments</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllPaymentsQueryParams} class that allows for
   * building up this map in a fluent style.
   * @param queryParams Map of query parameters as name-value pairs
   *   <p>The following elements may be specified in the query map:</p>
   *   <ul>
   *   <li>idEquals -  (optional)</li>
   *   <li>idNotEquals -  (optional)</li>
   *   <li>idSpecified -  (optional)</li>
   *   <li>idIn -  (optional)</li>
   *   <li>idNotIn -  (optional)</li>
   *   <li>bookingIdEquals -  (optional)</li>
   *   <li>bookingIdNotEquals -  (optional)</li>
   *   <li>bookingIdSpecified -  (optional)</li>
   *   <li>bookingIdIn -  (optional)</li>
   *   <li>bookingIdNotIn -  (optional)</li>
   *   <li>userIdEquals -  (optional)</li>
   *   <li>userIdNotEquals -  (optional)</li>
   *   <li>userIdSpecified -  (optional)</li>
   *   <li>userIdIn -  (optional)</li>
   *   <li>userIdNotIn -  (optional)</li>
   *   <li>amountGreaterThan -  (optional)</li>
   *   <li>amountLessThan -  (optional)</li>
   *   <li>amountGreaterThanOrEqual -  (optional)</li>
   *   <li>amountLessThanOrEqual -  (optional)</li>
   *   <li>amountEquals -  (optional)</li>
   *   <li>amountNotEquals -  (optional)</li>
   *   <li>amountSpecified -  (optional)</li>
   *   <li>amountIn -  (optional)</li>
   *   <li>amountNotIn -  (optional)</li>
   *   <li>currencyContains -  (optional)</li>
   *   <li>currencyDoesNotContain -  (optional)</li>
   *   <li>currencyEquals -  (optional)</li>
   *   <li>currencyNotEquals -  (optional)</li>
   *   <li>currencySpecified -  (optional)</li>
   *   <li>currencyIn -  (optional)</li>
   *   <li>currencyNotIn -  (optional)</li>
   *   <li>paymentMethodContains -  (optional)</li>
   *   <li>paymentMethodDoesNotContain -  (optional)</li>
   *   <li>paymentMethodEquals -  (optional)</li>
   *   <li>paymentMethodNotEquals -  (optional)</li>
   *   <li>paymentMethodSpecified -  (optional)</li>
   *   <li>paymentMethodIn -  (optional)</li>
   *   <li>paymentMethodNotIn -  (optional)</li>
   *   <li>statusEquals -  (optional)</li>
   *   <li>statusNotEquals -  (optional)</li>
   *   <li>statusSpecified -  (optional)</li>
   *   <li>statusIn -  (optional)</li>
   *   <li>statusNotIn -  (optional)</li>
   *   <li>transactionIdContains -  (optional)</li>
   *   <li>transactionIdDoesNotContain -  (optional)</li>
   *   <li>transactionIdEquals -  (optional)</li>
   *   <li>transactionIdNotEquals -  (optional)</li>
   *   <li>transactionIdSpecified -  (optional)</li>
   *   <li>transactionIdIn -  (optional)</li>
   *   <li>transactionIdNotIn -  (optional)</li>
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
   *   <li>distinct -  (optional)</li>
   *   <li>page - Zero-based page index (0..N) (optional, default to 0)</li>
   *   <li>size - The size of the page to be returned (optional, default to 20)</li>
   *   <li>sort - Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)</li>
   *   </ul>
   * @return List&lt;PaymentDTO&gt;
   */
  @RequestLine("GET /api/payments?id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&userId.equals={userIdEquals}&userId.notEquals={userIdNotEquals}&userId.specified={userIdSpecified}&userId.in={userIdIn}&userId.notIn={userIdNotIn}&amount.greaterThan={amountGreaterThan}&amount.lessThan={amountLessThan}&amount.greaterThanOrEqual={amountGreaterThanOrEqual}&amount.lessThanOrEqual={amountLessThanOrEqual}&amount.equals={amountEquals}&amount.notEquals={amountNotEquals}&amount.specified={amountSpecified}&amount.in={amountIn}&amount.notIn={amountNotIn}&currency.contains={currencyContains}&currency.doesNotContain={currencyDoesNotContain}&currency.equals={currencyEquals}&currency.notEquals={currencyNotEquals}&currency.specified={currencySpecified}&currency.in={currencyIn}&currency.notIn={currencyNotIn}&paymentMethod.contains={paymentMethodContains}&paymentMethod.doesNotContain={paymentMethodDoesNotContain}&paymentMethod.equals={paymentMethodEquals}&paymentMethod.notEquals={paymentMethodNotEquals}&paymentMethod.specified={paymentMethodSpecified}&paymentMethod.in={paymentMethodIn}&paymentMethod.notIn={paymentMethodNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&transactionId.contains={transactionIdContains}&transactionId.doesNotContain={transactionIdDoesNotContain}&transactionId.equals={transactionIdEquals}&transactionId.notEquals={transactionIdNotEquals}&transactionId.specified={transactionIdSpecified}&transactionId.in={transactionIdIn}&transactionId.notIn={transactionIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
  @Headers({
  "Accept: */*",
  })
  List<PaymentDTO> getAllPayments(@QueryMap(encoded=true) GetAllPaymentsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllPayments</code> that receives the query parameters as a map,
  * but this one also exposes the Http response headers
      * @param queryParams Map of query parameters as name-value pairs
      *   <p>The following elements may be specified in the query map:</p>
      *   <ul>
          *   <li>idEquals -  (optional)</li>
          *   <li>idNotEquals -  (optional)</li>
          *   <li>idSpecified -  (optional)</li>
          *   <li>idIn -  (optional)</li>
          *   <li>idNotIn -  (optional)</li>
          *   <li>bookingIdEquals -  (optional)</li>
          *   <li>bookingIdNotEquals -  (optional)</li>
          *   <li>bookingIdSpecified -  (optional)</li>
          *   <li>bookingIdIn -  (optional)</li>
          *   <li>bookingIdNotIn -  (optional)</li>
          *   <li>userIdEquals -  (optional)</li>
          *   <li>userIdNotEquals -  (optional)</li>
          *   <li>userIdSpecified -  (optional)</li>
          *   <li>userIdIn -  (optional)</li>
          *   <li>userIdNotIn -  (optional)</li>
          *   <li>amountGreaterThan -  (optional)</li>
          *   <li>amountLessThan -  (optional)</li>
          *   <li>amountGreaterThanOrEqual -  (optional)</li>
          *   <li>amountLessThanOrEqual -  (optional)</li>
          *   <li>amountEquals -  (optional)</li>
          *   <li>amountNotEquals -  (optional)</li>
          *   <li>amountSpecified -  (optional)</li>
          *   <li>amountIn -  (optional)</li>
          *   <li>amountNotIn -  (optional)</li>
          *   <li>currencyContains -  (optional)</li>
          *   <li>currencyDoesNotContain -  (optional)</li>
          *   <li>currencyEquals -  (optional)</li>
          *   <li>currencyNotEquals -  (optional)</li>
          *   <li>currencySpecified -  (optional)</li>
          *   <li>currencyIn -  (optional)</li>
          *   <li>currencyNotIn -  (optional)</li>
          *   <li>paymentMethodContains -  (optional)</li>
          *   <li>paymentMethodDoesNotContain -  (optional)</li>
          *   <li>paymentMethodEquals -  (optional)</li>
          *   <li>paymentMethodNotEquals -  (optional)</li>
          *   <li>paymentMethodSpecified -  (optional)</li>
          *   <li>paymentMethodIn -  (optional)</li>
          *   <li>paymentMethodNotIn -  (optional)</li>
          *   <li>statusEquals -  (optional)</li>
          *   <li>statusNotEquals -  (optional)</li>
          *   <li>statusSpecified -  (optional)</li>
          *   <li>statusIn -  (optional)</li>
          *   <li>statusNotIn -  (optional)</li>
          *   <li>transactionIdContains -  (optional)</li>
          *   <li>transactionIdDoesNotContain -  (optional)</li>
          *   <li>transactionIdEquals -  (optional)</li>
          *   <li>transactionIdNotEquals -  (optional)</li>
          *   <li>transactionIdSpecified -  (optional)</li>
          *   <li>transactionIdIn -  (optional)</li>
          *   <li>transactionIdNotIn -  (optional)</li>
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
          *   <li>distinct -  (optional)</li>
          *   <li>page - Zero-based page index (0..N) (optional, default to 0)</li>
          *   <li>size - The size of the page to be returned (optional, default to 20)</li>
          *   <li>sort - Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)</li>
      *   </ul>
          * @return List&lt;PaymentDTO&gt;
      */
      @RequestLine("GET /api/payments?id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&userId.equals={userIdEquals}&userId.notEquals={userIdNotEquals}&userId.specified={userIdSpecified}&userId.in={userIdIn}&userId.notIn={userIdNotIn}&amount.greaterThan={amountGreaterThan}&amount.lessThan={amountLessThan}&amount.greaterThanOrEqual={amountGreaterThanOrEqual}&amount.lessThanOrEqual={amountLessThanOrEqual}&amount.equals={amountEquals}&amount.notEquals={amountNotEquals}&amount.specified={amountSpecified}&amount.in={amountIn}&amount.notIn={amountNotIn}&currency.contains={currencyContains}&currency.doesNotContain={currencyDoesNotContain}&currency.equals={currencyEquals}&currency.notEquals={currencyNotEquals}&currency.specified={currencySpecified}&currency.in={currencyIn}&currency.notIn={currencyNotIn}&paymentMethod.contains={paymentMethodContains}&paymentMethod.doesNotContain={paymentMethodDoesNotContain}&paymentMethod.equals={paymentMethodEquals}&paymentMethod.notEquals={paymentMethodNotEquals}&paymentMethod.specified={paymentMethodSpecified}&paymentMethod.in={paymentMethodIn}&paymentMethod.notIn={paymentMethodNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&transactionId.contains={transactionIdContains}&transactionId.doesNotContain={transactionIdDoesNotContain}&transactionId.equals={transactionIdEquals}&transactionId.notEquals={transactionIdNotEquals}&transactionId.specified={transactionIdSpecified}&transactionId.in={transactionIdIn}&transactionId.notIn={transactionIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<PaymentDTO>> getAllPaymentsWithHttpInfo(@QueryMap(encoded=true) GetAllPaymentsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllPayments</code> method in a fluent style.
   */
  public static class GetAllPaymentsQueryParams extends HashMap<String, Object> {
    public GetAllPaymentsQueryParams idEquals(@jakarta.annotation.Nullable final UUID value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams idNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams idIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentsQueryParams idNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentsQueryParams bookingIdEquals(@jakarta.annotation.Nullable final UUID value) {
      put("bookingId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams bookingIdNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("bookingId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams bookingIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("bookingId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams bookingIdIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("bookingId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentsQueryParams bookingIdNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("bookingId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentsQueryParams userIdEquals(@jakarta.annotation.Nullable final UUID value) {
      put("userId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams userIdNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("userId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams userIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("userId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams userIdIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("userId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentsQueryParams userIdNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("userId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentsQueryParams amountGreaterThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("amount.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams amountLessThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("amount.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams amountGreaterThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("amount.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams amountLessThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("amount.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams amountEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("amount.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams amountNotEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("amount.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams amountSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("amount.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams amountIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("amount.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentsQueryParams amountNotIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("amount.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentsQueryParams currencyContains(@jakarta.annotation.Nullable final String value) {
      put("currency.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams currencyDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("currency.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams currencyEquals(@jakarta.annotation.Nullable final String value) {
      put("currency.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams currencyNotEquals(@jakarta.annotation.Nullable final String value) {
      put("currency.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams currencySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("currency.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams currencyIn(@jakarta.annotation.Nullable final List<String> value) {
      put("currency.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentsQueryParams currencyNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("currency.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentsQueryParams paymentMethodContains(@jakarta.annotation.Nullable final String value) {
      put("paymentMethod.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams paymentMethodDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("paymentMethod.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams paymentMethodEquals(@jakarta.annotation.Nullable final String value) {
      put("paymentMethod.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams paymentMethodNotEquals(@jakarta.annotation.Nullable final String value) {
      put("paymentMethod.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams paymentMethodSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("paymentMethod.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams paymentMethodIn(@jakarta.annotation.Nullable final List<String> value) {
      put("paymentMethod.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentsQueryParams paymentMethodNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("paymentMethod.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentsQueryParams statusEquals(@jakarta.annotation.Nullable final String value) {
      put("status.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams statusNotEquals(@jakarta.annotation.Nullable final String value) {
      put("status.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams statusSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("status.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams statusIn(@jakarta.annotation.Nullable final List<String> value) {
      put("status.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentsQueryParams statusNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("status.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentsQueryParams transactionIdContains(@jakarta.annotation.Nullable final String value) {
      put("transactionId.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams transactionIdDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("transactionId.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams transactionIdEquals(@jakarta.annotation.Nullable final String value) {
      put("transactionId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams transactionIdNotEquals(@jakarta.annotation.Nullable final String value) {
      put("transactionId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams transactionIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("transactionId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams transactionIdIn(@jakarta.annotation.Nullable final List<String> value) {
      put("transactionId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentsQueryParams transactionIdNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("transactionId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentsQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentsQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams page(@jakarta.annotation.Nullable final Integer value) {
      put("page", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams size(@jakarta.annotation.Nullable final Integer value) {
      put("size", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentsQueryParams sort(@jakarta.annotation.Nullable final List<String> value) {
      put("sort", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @return PaymentDTO
   */
  @RequestLine("GET /api/payments/{id}")
  @Headers({
    "Accept: */*",
  })
  PaymentDTO getPayment(@Param("id") @jakarta.annotation.Nonnull UUID id);

  /**
   * 
   * Similar to <code>getPayment</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/payments/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<PaymentDTO> getPaymentWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull UUID id);



  /**
   * 
   * 
   * @param id  (required)
   * @param paymentDTO  (required)
   * @return PaymentDTO
   */
  @RequestLine("PATCH /api/payments/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  PaymentDTO partialUpdatePayment(@Param("id") @jakarta.annotation.Nonnull UUID id, @jakarta.annotation.Nonnull PaymentDTO paymentDTO);

  /**
   * 
   * Similar to <code>partialUpdatePayment</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param paymentDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /api/payments/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<PaymentDTO> partialUpdatePaymentWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull UUID id, @jakarta.annotation.Nonnull PaymentDTO paymentDTO);



  /**
   * 
   * 
   * @param id  (required)
   * @param paymentDTO  (required)
   * @return PaymentDTO
   */
  @RequestLine("PUT /api/payments/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  PaymentDTO updatePayment(@Param("id") @jakarta.annotation.Nonnull UUID id, @jakarta.annotation.Nonnull PaymentDTO paymentDTO);

  /**
   * 
   * Similar to <code>updatePayment</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param paymentDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/payments/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<PaymentDTO> updatePaymentWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull UUID id, @jakarta.annotation.Nonnull PaymentDTO paymentDTO);


}
