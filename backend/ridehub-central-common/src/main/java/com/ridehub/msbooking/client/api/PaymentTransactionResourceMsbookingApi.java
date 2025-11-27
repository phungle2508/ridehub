package com.ridehub.msbooking.client.api;

import com.ridehub.msbooking.client.invoker.ApiClient;
import com.ridehub.msbooking.client.invoker.EncodingUtils;
import com.ridehub.msbooking.client.model.ApiResponse;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import com.ridehub.msbooking.client.model.PaymentTransactionDTO;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface PaymentTransactionResourceMsbookingApi extends ApiClient.Api {


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
   * @param transactionIdContains  (optional)
   * @param transactionIdDoesNotContain  (optional)
   * @param transactionIdEquals  (optional)
   * @param transactionIdNotEquals  (optional)
   * @param transactionIdSpecified  (optional)
   * @param transactionIdIn  (optional)
   * @param transactionIdNotIn  (optional)
   * @param methodEquals  (optional)
   * @param methodNotEquals  (optional)
   * @param methodSpecified  (optional)
   * @param methodIn  (optional)
   * @param methodNotIn  (optional)
   * @param statusEquals  (optional)
   * @param statusNotEquals  (optional)
   * @param statusSpecified  (optional)
   * @param statusIn  (optional)
   * @param statusNotIn  (optional)
   * @param amountGreaterThan  (optional)
   * @param amountLessThan  (optional)
   * @param amountGreaterThanOrEqual  (optional)
   * @param amountLessThanOrEqual  (optional)
   * @param amountEquals  (optional)
   * @param amountNotEquals  (optional)
   * @param amountSpecified  (optional)
   * @param amountIn  (optional)
   * @param amountNotIn  (optional)
   * @param timeGreaterThan  (optional)
   * @param timeLessThan  (optional)
   * @param timeGreaterThanOrEqual  (optional)
   * @param timeLessThanOrEqual  (optional)
   * @param timeEquals  (optional)
   * @param timeNotEquals  (optional)
   * @param timeSpecified  (optional)
   * @param timeIn  (optional)
   * @param timeNotIn  (optional)
   * @param gatewayNoteContains  (optional)
   * @param gatewayNoteDoesNotContain  (optional)
   * @param gatewayNoteEquals  (optional)
   * @param gatewayNoteNotEquals  (optional)
   * @param gatewayNoteSpecified  (optional)
   * @param gatewayNoteIn  (optional)
   * @param gatewayNoteNotIn  (optional)
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
  @RequestLine("GET /api/payment-transactions/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&transactionId.contains={transactionIdContains}&transactionId.doesNotContain={transactionIdDoesNotContain}&transactionId.equals={transactionIdEquals}&transactionId.notEquals={transactionIdNotEquals}&transactionId.specified={transactionIdSpecified}&transactionId.in={transactionIdIn}&transactionId.notIn={transactionIdNotIn}&method.equals={methodEquals}&method.notEquals={methodNotEquals}&method.specified={methodSpecified}&method.in={methodIn}&method.notIn={methodNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&amount.greaterThan={amountGreaterThan}&amount.lessThan={amountLessThan}&amount.greaterThanOrEqual={amountGreaterThanOrEqual}&amount.lessThanOrEqual={amountLessThanOrEqual}&amount.equals={amountEquals}&amount.notEquals={amountNotEquals}&amount.specified={amountSpecified}&amount.in={amountIn}&amount.notIn={amountNotIn}&time.greaterThan={timeGreaterThan}&time.lessThan={timeLessThan}&time.greaterThanOrEqual={timeGreaterThanOrEqual}&time.lessThanOrEqual={timeLessThanOrEqual}&time.equals={timeEquals}&time.notEquals={timeNotEquals}&time.specified={timeSpecified}&time.in={timeIn}&time.notIn={timeNotIn}&gatewayNote.contains={gatewayNoteContains}&gatewayNote.doesNotContain={gatewayNoteDoesNotContain}&gatewayNote.equals={gatewayNoteEquals}&gatewayNote.notEquals={gatewayNoteNotEquals}&gatewayNote.specified={gatewayNoteSpecified}&gatewayNote.in={gatewayNoteIn}&gatewayNote.notIn={gatewayNoteNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  Long countPaymentTransactions(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("transactionIdContains") @jakarta.annotation.Nullable String transactionIdContains, @Param("transactionIdDoesNotContain") @jakarta.annotation.Nullable String transactionIdDoesNotContain, @Param("transactionIdEquals") @jakarta.annotation.Nullable String transactionIdEquals, @Param("transactionIdNotEquals") @jakarta.annotation.Nullable String transactionIdNotEquals, @Param("transactionIdSpecified") @jakarta.annotation.Nullable Boolean transactionIdSpecified, @Param("transactionIdIn") @jakarta.annotation.Nullable List<String> transactionIdIn, @Param("transactionIdNotIn") @jakarta.annotation.Nullable List<String> transactionIdNotIn, @Param("methodEquals") @jakarta.annotation.Nullable String methodEquals, @Param("methodNotEquals") @jakarta.annotation.Nullable String methodNotEquals, @Param("methodSpecified") @jakarta.annotation.Nullable Boolean methodSpecified, @Param("methodIn") @jakarta.annotation.Nullable List<String> methodIn, @Param("methodNotIn") @jakarta.annotation.Nullable List<String> methodNotIn, @Param("statusEquals") @jakarta.annotation.Nullable String statusEquals, @Param("statusNotEquals") @jakarta.annotation.Nullable String statusNotEquals, @Param("statusSpecified") @jakarta.annotation.Nullable Boolean statusSpecified, @Param("statusIn") @jakarta.annotation.Nullable List<String> statusIn, @Param("statusNotIn") @jakarta.annotation.Nullable List<String> statusNotIn, @Param("amountGreaterThan") @jakarta.annotation.Nullable BigDecimal amountGreaterThan, @Param("amountLessThan") @jakarta.annotation.Nullable BigDecimal amountLessThan, @Param("amountGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal amountGreaterThanOrEqual, @Param("amountLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal amountLessThanOrEqual, @Param("amountEquals") @jakarta.annotation.Nullable BigDecimal amountEquals, @Param("amountNotEquals") @jakarta.annotation.Nullable BigDecimal amountNotEquals, @Param("amountSpecified") @jakarta.annotation.Nullable Boolean amountSpecified, @Param("amountIn") @jakarta.annotation.Nullable List<BigDecimal> amountIn, @Param("amountNotIn") @jakarta.annotation.Nullable List<BigDecimal> amountNotIn, @Param("timeGreaterThan") @jakarta.annotation.Nullable OffsetDateTime timeGreaterThan, @Param("timeLessThan") @jakarta.annotation.Nullable OffsetDateTime timeLessThan, @Param("timeGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime timeGreaterThanOrEqual, @Param("timeLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime timeLessThanOrEqual, @Param("timeEquals") @jakarta.annotation.Nullable OffsetDateTime timeEquals, @Param("timeNotEquals") @jakarta.annotation.Nullable OffsetDateTime timeNotEquals, @Param("timeSpecified") @jakarta.annotation.Nullable Boolean timeSpecified, @Param("timeIn") @jakarta.annotation.Nullable List<OffsetDateTime> timeIn, @Param("timeNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> timeNotIn, @Param("gatewayNoteContains") @jakarta.annotation.Nullable String gatewayNoteContains, @Param("gatewayNoteDoesNotContain") @jakarta.annotation.Nullable String gatewayNoteDoesNotContain, @Param("gatewayNoteEquals") @jakarta.annotation.Nullable String gatewayNoteEquals, @Param("gatewayNoteNotEquals") @jakarta.annotation.Nullable String gatewayNoteNotEquals, @Param("gatewayNoteSpecified") @jakarta.annotation.Nullable Boolean gatewayNoteSpecified, @Param("gatewayNoteIn") @jakarta.annotation.Nullable List<String> gatewayNoteIn, @Param("gatewayNoteNotIn") @jakarta.annotation.Nullable List<String> gatewayNoteNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("bookingIdGreaterThan") @jakarta.annotation.Nullable Long bookingIdGreaterThan, @Param("bookingIdLessThan") @jakarta.annotation.Nullable Long bookingIdLessThan, @Param("bookingIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long bookingIdGreaterThanOrEqual, @Param("bookingIdLessThanOrEqual") @jakarta.annotation.Nullable Long bookingIdLessThanOrEqual, @Param("bookingIdEquals") @jakarta.annotation.Nullable Long bookingIdEquals, @Param("bookingIdNotEquals") @jakarta.annotation.Nullable Long bookingIdNotEquals, @Param("bookingIdSpecified") @jakarta.annotation.Nullable Boolean bookingIdSpecified, @Param("bookingIdIn") @jakarta.annotation.Nullable List<Long> bookingIdIn, @Param("bookingIdNotIn") @jakarta.annotation.Nullable List<Long> bookingIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>countPaymentTransactions</code> but it also returns the http response headers .
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
   * @param transactionIdContains  (optional)
   * @param transactionIdDoesNotContain  (optional)
   * @param transactionIdEquals  (optional)
   * @param transactionIdNotEquals  (optional)
   * @param transactionIdSpecified  (optional)
   * @param transactionIdIn  (optional)
   * @param transactionIdNotIn  (optional)
   * @param methodEquals  (optional)
   * @param methodNotEquals  (optional)
   * @param methodSpecified  (optional)
   * @param methodIn  (optional)
   * @param methodNotIn  (optional)
   * @param statusEquals  (optional)
   * @param statusNotEquals  (optional)
   * @param statusSpecified  (optional)
   * @param statusIn  (optional)
   * @param statusNotIn  (optional)
   * @param amountGreaterThan  (optional)
   * @param amountLessThan  (optional)
   * @param amountGreaterThanOrEqual  (optional)
   * @param amountLessThanOrEqual  (optional)
   * @param amountEquals  (optional)
   * @param amountNotEquals  (optional)
   * @param amountSpecified  (optional)
   * @param amountIn  (optional)
   * @param amountNotIn  (optional)
   * @param timeGreaterThan  (optional)
   * @param timeLessThan  (optional)
   * @param timeGreaterThanOrEqual  (optional)
   * @param timeLessThanOrEqual  (optional)
   * @param timeEquals  (optional)
   * @param timeNotEquals  (optional)
   * @param timeSpecified  (optional)
   * @param timeIn  (optional)
   * @param timeNotIn  (optional)
   * @param gatewayNoteContains  (optional)
   * @param gatewayNoteDoesNotContain  (optional)
   * @param gatewayNoteEquals  (optional)
   * @param gatewayNoteNotEquals  (optional)
   * @param gatewayNoteSpecified  (optional)
   * @param gatewayNoteIn  (optional)
   * @param gatewayNoteNotIn  (optional)
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
  @RequestLine("GET /api/payment-transactions/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&transactionId.contains={transactionIdContains}&transactionId.doesNotContain={transactionIdDoesNotContain}&transactionId.equals={transactionIdEquals}&transactionId.notEquals={transactionIdNotEquals}&transactionId.specified={transactionIdSpecified}&transactionId.in={transactionIdIn}&transactionId.notIn={transactionIdNotIn}&method.equals={methodEquals}&method.notEquals={methodNotEquals}&method.specified={methodSpecified}&method.in={methodIn}&method.notIn={methodNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&amount.greaterThan={amountGreaterThan}&amount.lessThan={amountLessThan}&amount.greaterThanOrEqual={amountGreaterThanOrEqual}&amount.lessThanOrEqual={amountLessThanOrEqual}&amount.equals={amountEquals}&amount.notEquals={amountNotEquals}&amount.specified={amountSpecified}&amount.in={amountIn}&amount.notIn={amountNotIn}&time.greaterThan={timeGreaterThan}&time.lessThan={timeLessThan}&time.greaterThanOrEqual={timeGreaterThanOrEqual}&time.lessThanOrEqual={timeLessThanOrEqual}&time.equals={timeEquals}&time.notEquals={timeNotEquals}&time.specified={timeSpecified}&time.in={timeIn}&time.notIn={timeNotIn}&gatewayNote.contains={gatewayNoteContains}&gatewayNote.doesNotContain={gatewayNoteDoesNotContain}&gatewayNote.equals={gatewayNoteEquals}&gatewayNote.notEquals={gatewayNoteNotEquals}&gatewayNote.specified={gatewayNoteSpecified}&gatewayNote.in={gatewayNoteIn}&gatewayNote.notIn={gatewayNoteNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Long> countPaymentTransactionsWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("transactionIdContains") @jakarta.annotation.Nullable String transactionIdContains, @Param("transactionIdDoesNotContain") @jakarta.annotation.Nullable String transactionIdDoesNotContain, @Param("transactionIdEquals") @jakarta.annotation.Nullable String transactionIdEquals, @Param("transactionIdNotEquals") @jakarta.annotation.Nullable String transactionIdNotEquals, @Param("transactionIdSpecified") @jakarta.annotation.Nullable Boolean transactionIdSpecified, @Param("transactionIdIn") @jakarta.annotation.Nullable List<String> transactionIdIn, @Param("transactionIdNotIn") @jakarta.annotation.Nullable List<String> transactionIdNotIn, @Param("methodEquals") @jakarta.annotation.Nullable String methodEquals, @Param("methodNotEquals") @jakarta.annotation.Nullable String methodNotEquals, @Param("methodSpecified") @jakarta.annotation.Nullable Boolean methodSpecified, @Param("methodIn") @jakarta.annotation.Nullable List<String> methodIn, @Param("methodNotIn") @jakarta.annotation.Nullable List<String> methodNotIn, @Param("statusEquals") @jakarta.annotation.Nullable String statusEquals, @Param("statusNotEquals") @jakarta.annotation.Nullable String statusNotEquals, @Param("statusSpecified") @jakarta.annotation.Nullable Boolean statusSpecified, @Param("statusIn") @jakarta.annotation.Nullable List<String> statusIn, @Param("statusNotIn") @jakarta.annotation.Nullable List<String> statusNotIn, @Param("amountGreaterThan") @jakarta.annotation.Nullable BigDecimal amountGreaterThan, @Param("amountLessThan") @jakarta.annotation.Nullable BigDecimal amountLessThan, @Param("amountGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal amountGreaterThanOrEqual, @Param("amountLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal amountLessThanOrEqual, @Param("amountEquals") @jakarta.annotation.Nullable BigDecimal amountEquals, @Param("amountNotEquals") @jakarta.annotation.Nullable BigDecimal amountNotEquals, @Param("amountSpecified") @jakarta.annotation.Nullable Boolean amountSpecified, @Param("amountIn") @jakarta.annotation.Nullable List<BigDecimal> amountIn, @Param("amountNotIn") @jakarta.annotation.Nullable List<BigDecimal> amountNotIn, @Param("timeGreaterThan") @jakarta.annotation.Nullable OffsetDateTime timeGreaterThan, @Param("timeLessThan") @jakarta.annotation.Nullable OffsetDateTime timeLessThan, @Param("timeGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime timeGreaterThanOrEqual, @Param("timeLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime timeLessThanOrEqual, @Param("timeEquals") @jakarta.annotation.Nullable OffsetDateTime timeEquals, @Param("timeNotEquals") @jakarta.annotation.Nullable OffsetDateTime timeNotEquals, @Param("timeSpecified") @jakarta.annotation.Nullable Boolean timeSpecified, @Param("timeIn") @jakarta.annotation.Nullable List<OffsetDateTime> timeIn, @Param("timeNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> timeNotIn, @Param("gatewayNoteContains") @jakarta.annotation.Nullable String gatewayNoteContains, @Param("gatewayNoteDoesNotContain") @jakarta.annotation.Nullable String gatewayNoteDoesNotContain, @Param("gatewayNoteEquals") @jakarta.annotation.Nullable String gatewayNoteEquals, @Param("gatewayNoteNotEquals") @jakarta.annotation.Nullable String gatewayNoteNotEquals, @Param("gatewayNoteSpecified") @jakarta.annotation.Nullable Boolean gatewayNoteSpecified, @Param("gatewayNoteIn") @jakarta.annotation.Nullable List<String> gatewayNoteIn, @Param("gatewayNoteNotIn") @jakarta.annotation.Nullable List<String> gatewayNoteNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("bookingIdGreaterThan") @jakarta.annotation.Nullable Long bookingIdGreaterThan, @Param("bookingIdLessThan") @jakarta.annotation.Nullable Long bookingIdLessThan, @Param("bookingIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long bookingIdGreaterThanOrEqual, @Param("bookingIdLessThanOrEqual") @jakarta.annotation.Nullable Long bookingIdLessThanOrEqual, @Param("bookingIdEquals") @jakarta.annotation.Nullable Long bookingIdEquals, @Param("bookingIdNotEquals") @jakarta.annotation.Nullable Long bookingIdNotEquals, @Param("bookingIdSpecified") @jakarta.annotation.Nullable Boolean bookingIdSpecified, @Param("bookingIdIn") @jakarta.annotation.Nullable List<Long> bookingIdIn, @Param("bookingIdNotIn") @jakarta.annotation.Nullable List<Long> bookingIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>countPaymentTransactions</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CountPaymentTransactionsQueryParams} class that allows for
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
   *   <li>transactionIdContains -  (optional)</li>
   *   <li>transactionIdDoesNotContain -  (optional)</li>
   *   <li>transactionIdEquals -  (optional)</li>
   *   <li>transactionIdNotEquals -  (optional)</li>
   *   <li>transactionIdSpecified -  (optional)</li>
   *   <li>transactionIdIn -  (optional)</li>
   *   <li>transactionIdNotIn -  (optional)</li>
   *   <li>methodEquals -  (optional)</li>
   *   <li>methodNotEquals -  (optional)</li>
   *   <li>methodSpecified -  (optional)</li>
   *   <li>methodIn -  (optional)</li>
   *   <li>methodNotIn -  (optional)</li>
   *   <li>statusEquals -  (optional)</li>
   *   <li>statusNotEquals -  (optional)</li>
   *   <li>statusSpecified -  (optional)</li>
   *   <li>statusIn -  (optional)</li>
   *   <li>statusNotIn -  (optional)</li>
   *   <li>amountGreaterThan -  (optional)</li>
   *   <li>amountLessThan -  (optional)</li>
   *   <li>amountGreaterThanOrEqual -  (optional)</li>
   *   <li>amountLessThanOrEqual -  (optional)</li>
   *   <li>amountEquals -  (optional)</li>
   *   <li>amountNotEquals -  (optional)</li>
   *   <li>amountSpecified -  (optional)</li>
   *   <li>amountIn -  (optional)</li>
   *   <li>amountNotIn -  (optional)</li>
   *   <li>timeGreaterThan -  (optional)</li>
   *   <li>timeLessThan -  (optional)</li>
   *   <li>timeGreaterThanOrEqual -  (optional)</li>
   *   <li>timeLessThanOrEqual -  (optional)</li>
   *   <li>timeEquals -  (optional)</li>
   *   <li>timeNotEquals -  (optional)</li>
   *   <li>timeSpecified -  (optional)</li>
   *   <li>timeIn -  (optional)</li>
   *   <li>timeNotIn -  (optional)</li>
   *   <li>gatewayNoteContains -  (optional)</li>
   *   <li>gatewayNoteDoesNotContain -  (optional)</li>
   *   <li>gatewayNoteEquals -  (optional)</li>
   *   <li>gatewayNoteNotEquals -  (optional)</li>
   *   <li>gatewayNoteSpecified -  (optional)</li>
   *   <li>gatewayNoteIn -  (optional)</li>
   *   <li>gatewayNoteNotIn -  (optional)</li>
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
  @RequestLine("GET /api/payment-transactions/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&transactionId.contains={transactionIdContains}&transactionId.doesNotContain={transactionIdDoesNotContain}&transactionId.equals={transactionIdEquals}&transactionId.notEquals={transactionIdNotEquals}&transactionId.specified={transactionIdSpecified}&transactionId.in={transactionIdIn}&transactionId.notIn={transactionIdNotIn}&method.equals={methodEquals}&method.notEquals={methodNotEquals}&method.specified={methodSpecified}&method.in={methodIn}&method.notIn={methodNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&amount.greaterThan={amountGreaterThan}&amount.lessThan={amountLessThan}&amount.greaterThanOrEqual={amountGreaterThanOrEqual}&amount.lessThanOrEqual={amountLessThanOrEqual}&amount.equals={amountEquals}&amount.notEquals={amountNotEquals}&amount.specified={amountSpecified}&amount.in={amountIn}&amount.notIn={amountNotIn}&time.greaterThan={timeGreaterThan}&time.lessThan={timeLessThan}&time.greaterThanOrEqual={timeGreaterThanOrEqual}&time.lessThanOrEqual={timeLessThanOrEqual}&time.equals={timeEquals}&time.notEquals={timeNotEquals}&time.specified={timeSpecified}&time.in={timeIn}&time.notIn={timeNotIn}&gatewayNote.contains={gatewayNoteContains}&gatewayNote.doesNotContain={gatewayNoteDoesNotContain}&gatewayNote.equals={gatewayNoteEquals}&gatewayNote.notEquals={gatewayNoteNotEquals}&gatewayNote.specified={gatewayNoteSpecified}&gatewayNote.in={gatewayNoteIn}&gatewayNote.notIn={gatewayNoteNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  Long countPaymentTransactions(@QueryMap(encoded=true) CountPaymentTransactionsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>countPaymentTransactions</code> that receives the query parameters as a map,
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
          *   <li>transactionIdContains -  (optional)</li>
          *   <li>transactionIdDoesNotContain -  (optional)</li>
          *   <li>transactionIdEquals -  (optional)</li>
          *   <li>transactionIdNotEquals -  (optional)</li>
          *   <li>transactionIdSpecified -  (optional)</li>
          *   <li>transactionIdIn -  (optional)</li>
          *   <li>transactionIdNotIn -  (optional)</li>
          *   <li>methodEquals -  (optional)</li>
          *   <li>methodNotEquals -  (optional)</li>
          *   <li>methodSpecified -  (optional)</li>
          *   <li>methodIn -  (optional)</li>
          *   <li>methodNotIn -  (optional)</li>
          *   <li>statusEquals -  (optional)</li>
          *   <li>statusNotEquals -  (optional)</li>
          *   <li>statusSpecified -  (optional)</li>
          *   <li>statusIn -  (optional)</li>
          *   <li>statusNotIn -  (optional)</li>
          *   <li>amountGreaterThan -  (optional)</li>
          *   <li>amountLessThan -  (optional)</li>
          *   <li>amountGreaterThanOrEqual -  (optional)</li>
          *   <li>amountLessThanOrEqual -  (optional)</li>
          *   <li>amountEquals -  (optional)</li>
          *   <li>amountNotEquals -  (optional)</li>
          *   <li>amountSpecified -  (optional)</li>
          *   <li>amountIn -  (optional)</li>
          *   <li>amountNotIn -  (optional)</li>
          *   <li>timeGreaterThan -  (optional)</li>
          *   <li>timeLessThan -  (optional)</li>
          *   <li>timeGreaterThanOrEqual -  (optional)</li>
          *   <li>timeLessThanOrEqual -  (optional)</li>
          *   <li>timeEquals -  (optional)</li>
          *   <li>timeNotEquals -  (optional)</li>
          *   <li>timeSpecified -  (optional)</li>
          *   <li>timeIn -  (optional)</li>
          *   <li>timeNotIn -  (optional)</li>
          *   <li>gatewayNoteContains -  (optional)</li>
          *   <li>gatewayNoteDoesNotContain -  (optional)</li>
          *   <li>gatewayNoteEquals -  (optional)</li>
          *   <li>gatewayNoteNotEquals -  (optional)</li>
          *   <li>gatewayNoteSpecified -  (optional)</li>
          *   <li>gatewayNoteIn -  (optional)</li>
          *   <li>gatewayNoteNotIn -  (optional)</li>
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
      @RequestLine("GET /api/payment-transactions/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&transactionId.contains={transactionIdContains}&transactionId.doesNotContain={transactionIdDoesNotContain}&transactionId.equals={transactionIdEquals}&transactionId.notEquals={transactionIdNotEquals}&transactionId.specified={transactionIdSpecified}&transactionId.in={transactionIdIn}&transactionId.notIn={transactionIdNotIn}&method.equals={methodEquals}&method.notEquals={methodNotEquals}&method.specified={methodSpecified}&method.in={methodIn}&method.notIn={methodNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&amount.greaterThan={amountGreaterThan}&amount.lessThan={amountLessThan}&amount.greaterThanOrEqual={amountGreaterThanOrEqual}&amount.lessThanOrEqual={amountLessThanOrEqual}&amount.equals={amountEquals}&amount.notEquals={amountNotEquals}&amount.specified={amountSpecified}&amount.in={amountIn}&amount.notIn={amountNotIn}&time.greaterThan={timeGreaterThan}&time.lessThan={timeLessThan}&time.greaterThanOrEqual={timeGreaterThanOrEqual}&time.lessThanOrEqual={timeLessThanOrEqual}&time.equals={timeEquals}&time.notEquals={timeNotEquals}&time.specified={timeSpecified}&time.in={timeIn}&time.notIn={timeNotIn}&gatewayNote.contains={gatewayNoteContains}&gatewayNote.doesNotContain={gatewayNoteDoesNotContain}&gatewayNote.equals={gatewayNoteEquals}&gatewayNote.notEquals={gatewayNoteNotEquals}&gatewayNote.specified={gatewayNoteSpecified}&gatewayNote.in={gatewayNoteIn}&gatewayNote.notIn={gatewayNoteNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Long> countPaymentTransactionsWithHttpInfo(@QueryMap(encoded=true) CountPaymentTransactionsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>countPaymentTransactions</code> method in a fluent style.
   */
  public static class CountPaymentTransactionsQueryParams extends HashMap<String, Object> {
    public CountPaymentTransactionsQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentTransactionsQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentTransactionsQueryParams transactionIdContains(@jakarta.annotation.Nullable final String value) {
      put("transactionId.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams transactionIdDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("transactionId.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams transactionIdEquals(@jakarta.annotation.Nullable final String value) {
      put("transactionId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams transactionIdNotEquals(@jakarta.annotation.Nullable final String value) {
      put("transactionId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams transactionIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("transactionId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams transactionIdIn(@jakarta.annotation.Nullable final List<String> value) {
      put("transactionId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentTransactionsQueryParams transactionIdNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("transactionId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentTransactionsQueryParams methodEquals(@jakarta.annotation.Nullable final String value) {
      put("method.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams methodNotEquals(@jakarta.annotation.Nullable final String value) {
      put("method.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams methodSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("method.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams methodIn(@jakarta.annotation.Nullable final List<String> value) {
      put("method.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentTransactionsQueryParams methodNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("method.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentTransactionsQueryParams statusEquals(@jakarta.annotation.Nullable final String value) {
      put("status.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams statusNotEquals(@jakarta.annotation.Nullable final String value) {
      put("status.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams statusSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("status.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams statusIn(@jakarta.annotation.Nullable final List<String> value) {
      put("status.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentTransactionsQueryParams statusNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("status.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentTransactionsQueryParams amountGreaterThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("amount.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams amountLessThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("amount.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams amountGreaterThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("amount.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams amountLessThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("amount.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams amountEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("amount.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams amountNotEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("amount.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams amountSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("amount.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams amountIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("amount.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentTransactionsQueryParams amountNotIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("amount.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentTransactionsQueryParams timeGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("time.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams timeLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("time.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams timeGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("time.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams timeLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("time.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams timeEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("time.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams timeNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("time.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams timeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("time.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams timeIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("time.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentTransactionsQueryParams timeNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("time.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentTransactionsQueryParams gatewayNoteContains(@jakarta.annotation.Nullable final String value) {
      put("gatewayNote.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams gatewayNoteDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("gatewayNote.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams gatewayNoteEquals(@jakarta.annotation.Nullable final String value) {
      put("gatewayNote.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams gatewayNoteNotEquals(@jakarta.annotation.Nullable final String value) {
      put("gatewayNote.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams gatewayNoteSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("gatewayNote.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams gatewayNoteIn(@jakarta.annotation.Nullable final List<String> value) {
      put("gatewayNote.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentTransactionsQueryParams gatewayNoteNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("gatewayNote.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentTransactionsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentTransactionsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentTransactionsQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentTransactionsQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentTransactionsQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentTransactionsQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentTransactionsQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentTransactionsQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentTransactionsQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentTransactionsQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentTransactionsQueryParams bookingIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams bookingIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams bookingIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams bookingIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams bookingIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams bookingIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams bookingIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("bookingId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountPaymentTransactionsQueryParams bookingIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("bookingId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentTransactionsQueryParams bookingIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("bookingId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountPaymentTransactionsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param paymentTransactionDTO  (required)
   * @return PaymentTransactionDTO
   */
  @RequestLine("POST /api/payment-transactions")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  PaymentTransactionDTO createPaymentTransaction(@jakarta.annotation.Nonnull PaymentTransactionDTO paymentTransactionDTO);

  /**
   * 
   * Similar to <code>createPaymentTransaction</code> but it also returns the http response headers .
   * 
   * @param paymentTransactionDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/payment-transactions")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<PaymentTransactionDTO> createPaymentTransactionWithHttpInfo(@jakarta.annotation.Nonnull PaymentTransactionDTO paymentTransactionDTO);



  /**
   * 
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/payment-transactions/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deletePaymentTransaction(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>deletePaymentTransaction</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/payment-transactions/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deletePaymentTransactionWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



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
   * @param transactionIdContains  (optional)
   * @param transactionIdDoesNotContain  (optional)
   * @param transactionIdEquals  (optional)
   * @param transactionIdNotEquals  (optional)
   * @param transactionIdSpecified  (optional)
   * @param transactionIdIn  (optional)
   * @param transactionIdNotIn  (optional)
   * @param methodEquals  (optional)
   * @param methodNotEquals  (optional)
   * @param methodSpecified  (optional)
   * @param methodIn  (optional)
   * @param methodNotIn  (optional)
   * @param statusEquals  (optional)
   * @param statusNotEquals  (optional)
   * @param statusSpecified  (optional)
   * @param statusIn  (optional)
   * @param statusNotIn  (optional)
   * @param amountGreaterThan  (optional)
   * @param amountLessThan  (optional)
   * @param amountGreaterThanOrEqual  (optional)
   * @param amountLessThanOrEqual  (optional)
   * @param amountEquals  (optional)
   * @param amountNotEquals  (optional)
   * @param amountSpecified  (optional)
   * @param amountIn  (optional)
   * @param amountNotIn  (optional)
   * @param timeGreaterThan  (optional)
   * @param timeLessThan  (optional)
   * @param timeGreaterThanOrEqual  (optional)
   * @param timeLessThanOrEqual  (optional)
   * @param timeEquals  (optional)
   * @param timeNotEquals  (optional)
   * @param timeSpecified  (optional)
   * @param timeIn  (optional)
   * @param timeNotIn  (optional)
   * @param gatewayNoteContains  (optional)
   * @param gatewayNoteDoesNotContain  (optional)
   * @param gatewayNoteEquals  (optional)
   * @param gatewayNoteNotEquals  (optional)
   * @param gatewayNoteSpecified  (optional)
   * @param gatewayNoteIn  (optional)
   * @param gatewayNoteNotIn  (optional)
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
   * @return List&lt;PaymentTransactionDTO&gt;
   */
  @RequestLine("GET /api/payment-transactions?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&transactionId.contains={transactionIdContains}&transactionId.doesNotContain={transactionIdDoesNotContain}&transactionId.equals={transactionIdEquals}&transactionId.notEquals={transactionIdNotEquals}&transactionId.specified={transactionIdSpecified}&transactionId.in={transactionIdIn}&transactionId.notIn={transactionIdNotIn}&method.equals={methodEquals}&method.notEquals={methodNotEquals}&method.specified={methodSpecified}&method.in={methodIn}&method.notIn={methodNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&amount.greaterThan={amountGreaterThan}&amount.lessThan={amountLessThan}&amount.greaterThanOrEqual={amountGreaterThanOrEqual}&amount.lessThanOrEqual={amountLessThanOrEqual}&amount.equals={amountEquals}&amount.notEquals={amountNotEquals}&amount.specified={amountSpecified}&amount.in={amountIn}&amount.notIn={amountNotIn}&time.greaterThan={timeGreaterThan}&time.lessThan={timeLessThan}&time.greaterThanOrEqual={timeGreaterThanOrEqual}&time.lessThanOrEqual={timeLessThanOrEqual}&time.equals={timeEquals}&time.notEquals={timeNotEquals}&time.specified={timeSpecified}&time.in={timeIn}&time.notIn={timeNotIn}&gatewayNote.contains={gatewayNoteContains}&gatewayNote.doesNotContain={gatewayNoteDoesNotContain}&gatewayNote.equals={gatewayNoteEquals}&gatewayNote.notEquals={gatewayNoteNotEquals}&gatewayNote.specified={gatewayNoteSpecified}&gatewayNote.in={gatewayNoteIn}&gatewayNote.notIn={gatewayNoteNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  List<PaymentTransactionDTO> getAllPaymentTransactions(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("transactionIdContains") @jakarta.annotation.Nullable String transactionIdContains, @Param("transactionIdDoesNotContain") @jakarta.annotation.Nullable String transactionIdDoesNotContain, @Param("transactionIdEquals") @jakarta.annotation.Nullable String transactionIdEquals, @Param("transactionIdNotEquals") @jakarta.annotation.Nullable String transactionIdNotEquals, @Param("transactionIdSpecified") @jakarta.annotation.Nullable Boolean transactionIdSpecified, @Param("transactionIdIn") @jakarta.annotation.Nullable List<String> transactionIdIn, @Param("transactionIdNotIn") @jakarta.annotation.Nullable List<String> transactionIdNotIn, @Param("methodEquals") @jakarta.annotation.Nullable String methodEquals, @Param("methodNotEquals") @jakarta.annotation.Nullable String methodNotEquals, @Param("methodSpecified") @jakarta.annotation.Nullable Boolean methodSpecified, @Param("methodIn") @jakarta.annotation.Nullable List<String> methodIn, @Param("methodNotIn") @jakarta.annotation.Nullable List<String> methodNotIn, @Param("statusEquals") @jakarta.annotation.Nullable String statusEquals, @Param("statusNotEquals") @jakarta.annotation.Nullable String statusNotEquals, @Param("statusSpecified") @jakarta.annotation.Nullable Boolean statusSpecified, @Param("statusIn") @jakarta.annotation.Nullable List<String> statusIn, @Param("statusNotIn") @jakarta.annotation.Nullable List<String> statusNotIn, @Param("amountGreaterThan") @jakarta.annotation.Nullable BigDecimal amountGreaterThan, @Param("amountLessThan") @jakarta.annotation.Nullable BigDecimal amountLessThan, @Param("amountGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal amountGreaterThanOrEqual, @Param("amountLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal amountLessThanOrEqual, @Param("amountEquals") @jakarta.annotation.Nullable BigDecimal amountEquals, @Param("amountNotEquals") @jakarta.annotation.Nullable BigDecimal amountNotEquals, @Param("amountSpecified") @jakarta.annotation.Nullable Boolean amountSpecified, @Param("amountIn") @jakarta.annotation.Nullable List<BigDecimal> amountIn, @Param("amountNotIn") @jakarta.annotation.Nullable List<BigDecimal> amountNotIn, @Param("timeGreaterThan") @jakarta.annotation.Nullable OffsetDateTime timeGreaterThan, @Param("timeLessThan") @jakarta.annotation.Nullable OffsetDateTime timeLessThan, @Param("timeGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime timeGreaterThanOrEqual, @Param("timeLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime timeLessThanOrEqual, @Param("timeEquals") @jakarta.annotation.Nullable OffsetDateTime timeEquals, @Param("timeNotEquals") @jakarta.annotation.Nullable OffsetDateTime timeNotEquals, @Param("timeSpecified") @jakarta.annotation.Nullable Boolean timeSpecified, @Param("timeIn") @jakarta.annotation.Nullable List<OffsetDateTime> timeIn, @Param("timeNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> timeNotIn, @Param("gatewayNoteContains") @jakarta.annotation.Nullable String gatewayNoteContains, @Param("gatewayNoteDoesNotContain") @jakarta.annotation.Nullable String gatewayNoteDoesNotContain, @Param("gatewayNoteEquals") @jakarta.annotation.Nullable String gatewayNoteEquals, @Param("gatewayNoteNotEquals") @jakarta.annotation.Nullable String gatewayNoteNotEquals, @Param("gatewayNoteSpecified") @jakarta.annotation.Nullable Boolean gatewayNoteSpecified, @Param("gatewayNoteIn") @jakarta.annotation.Nullable List<String> gatewayNoteIn, @Param("gatewayNoteNotIn") @jakarta.annotation.Nullable List<String> gatewayNoteNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("bookingIdGreaterThan") @jakarta.annotation.Nullable Long bookingIdGreaterThan, @Param("bookingIdLessThan") @jakarta.annotation.Nullable Long bookingIdLessThan, @Param("bookingIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long bookingIdGreaterThanOrEqual, @Param("bookingIdLessThanOrEqual") @jakarta.annotation.Nullable Long bookingIdLessThanOrEqual, @Param("bookingIdEquals") @jakarta.annotation.Nullable Long bookingIdEquals, @Param("bookingIdNotEquals") @jakarta.annotation.Nullable Long bookingIdNotEquals, @Param("bookingIdSpecified") @jakarta.annotation.Nullable Boolean bookingIdSpecified, @Param("bookingIdIn") @jakarta.annotation.Nullable List<Long> bookingIdIn, @Param("bookingIdNotIn") @jakarta.annotation.Nullable List<Long> bookingIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>getAllPaymentTransactions</code> but it also returns the http response headers .
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
   * @param transactionIdContains  (optional)
   * @param transactionIdDoesNotContain  (optional)
   * @param transactionIdEquals  (optional)
   * @param transactionIdNotEquals  (optional)
   * @param transactionIdSpecified  (optional)
   * @param transactionIdIn  (optional)
   * @param transactionIdNotIn  (optional)
   * @param methodEquals  (optional)
   * @param methodNotEquals  (optional)
   * @param methodSpecified  (optional)
   * @param methodIn  (optional)
   * @param methodNotIn  (optional)
   * @param statusEquals  (optional)
   * @param statusNotEquals  (optional)
   * @param statusSpecified  (optional)
   * @param statusIn  (optional)
   * @param statusNotIn  (optional)
   * @param amountGreaterThan  (optional)
   * @param amountLessThan  (optional)
   * @param amountGreaterThanOrEqual  (optional)
   * @param amountLessThanOrEqual  (optional)
   * @param amountEquals  (optional)
   * @param amountNotEquals  (optional)
   * @param amountSpecified  (optional)
   * @param amountIn  (optional)
   * @param amountNotIn  (optional)
   * @param timeGreaterThan  (optional)
   * @param timeLessThan  (optional)
   * @param timeGreaterThanOrEqual  (optional)
   * @param timeLessThanOrEqual  (optional)
   * @param timeEquals  (optional)
   * @param timeNotEquals  (optional)
   * @param timeSpecified  (optional)
   * @param timeIn  (optional)
   * @param timeNotIn  (optional)
   * @param gatewayNoteContains  (optional)
   * @param gatewayNoteDoesNotContain  (optional)
   * @param gatewayNoteEquals  (optional)
   * @param gatewayNoteNotEquals  (optional)
   * @param gatewayNoteSpecified  (optional)
   * @param gatewayNoteIn  (optional)
   * @param gatewayNoteNotIn  (optional)
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
  @RequestLine("GET /api/payment-transactions?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&transactionId.contains={transactionIdContains}&transactionId.doesNotContain={transactionIdDoesNotContain}&transactionId.equals={transactionIdEquals}&transactionId.notEquals={transactionIdNotEquals}&transactionId.specified={transactionIdSpecified}&transactionId.in={transactionIdIn}&transactionId.notIn={transactionIdNotIn}&method.equals={methodEquals}&method.notEquals={methodNotEquals}&method.specified={methodSpecified}&method.in={methodIn}&method.notIn={methodNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&amount.greaterThan={amountGreaterThan}&amount.lessThan={amountLessThan}&amount.greaterThanOrEqual={amountGreaterThanOrEqual}&amount.lessThanOrEqual={amountLessThanOrEqual}&amount.equals={amountEquals}&amount.notEquals={amountNotEquals}&amount.specified={amountSpecified}&amount.in={amountIn}&amount.notIn={amountNotIn}&time.greaterThan={timeGreaterThan}&time.lessThan={timeLessThan}&time.greaterThanOrEqual={timeGreaterThanOrEqual}&time.lessThanOrEqual={timeLessThanOrEqual}&time.equals={timeEquals}&time.notEquals={timeNotEquals}&time.specified={timeSpecified}&time.in={timeIn}&time.notIn={timeNotIn}&gatewayNote.contains={gatewayNoteContains}&gatewayNote.doesNotContain={gatewayNoteDoesNotContain}&gatewayNote.equals={gatewayNoteEquals}&gatewayNote.notEquals={gatewayNoteNotEquals}&gatewayNote.specified={gatewayNoteSpecified}&gatewayNote.in={gatewayNoteIn}&gatewayNote.notIn={gatewayNoteNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<PaymentTransactionDTO>> getAllPaymentTransactionsWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("transactionIdContains") @jakarta.annotation.Nullable String transactionIdContains, @Param("transactionIdDoesNotContain") @jakarta.annotation.Nullable String transactionIdDoesNotContain, @Param("transactionIdEquals") @jakarta.annotation.Nullable String transactionIdEquals, @Param("transactionIdNotEquals") @jakarta.annotation.Nullable String transactionIdNotEquals, @Param("transactionIdSpecified") @jakarta.annotation.Nullable Boolean transactionIdSpecified, @Param("transactionIdIn") @jakarta.annotation.Nullable List<String> transactionIdIn, @Param("transactionIdNotIn") @jakarta.annotation.Nullable List<String> transactionIdNotIn, @Param("methodEquals") @jakarta.annotation.Nullable String methodEquals, @Param("methodNotEquals") @jakarta.annotation.Nullable String methodNotEquals, @Param("methodSpecified") @jakarta.annotation.Nullable Boolean methodSpecified, @Param("methodIn") @jakarta.annotation.Nullable List<String> methodIn, @Param("methodNotIn") @jakarta.annotation.Nullable List<String> methodNotIn, @Param("statusEquals") @jakarta.annotation.Nullable String statusEquals, @Param("statusNotEquals") @jakarta.annotation.Nullable String statusNotEquals, @Param("statusSpecified") @jakarta.annotation.Nullable Boolean statusSpecified, @Param("statusIn") @jakarta.annotation.Nullable List<String> statusIn, @Param("statusNotIn") @jakarta.annotation.Nullable List<String> statusNotIn, @Param("amountGreaterThan") @jakarta.annotation.Nullable BigDecimal amountGreaterThan, @Param("amountLessThan") @jakarta.annotation.Nullable BigDecimal amountLessThan, @Param("amountGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal amountGreaterThanOrEqual, @Param("amountLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal amountLessThanOrEqual, @Param("amountEquals") @jakarta.annotation.Nullable BigDecimal amountEquals, @Param("amountNotEquals") @jakarta.annotation.Nullable BigDecimal amountNotEquals, @Param("amountSpecified") @jakarta.annotation.Nullable Boolean amountSpecified, @Param("amountIn") @jakarta.annotation.Nullable List<BigDecimal> amountIn, @Param("amountNotIn") @jakarta.annotation.Nullable List<BigDecimal> amountNotIn, @Param("timeGreaterThan") @jakarta.annotation.Nullable OffsetDateTime timeGreaterThan, @Param("timeLessThan") @jakarta.annotation.Nullable OffsetDateTime timeLessThan, @Param("timeGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime timeGreaterThanOrEqual, @Param("timeLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime timeLessThanOrEqual, @Param("timeEquals") @jakarta.annotation.Nullable OffsetDateTime timeEquals, @Param("timeNotEquals") @jakarta.annotation.Nullable OffsetDateTime timeNotEquals, @Param("timeSpecified") @jakarta.annotation.Nullable Boolean timeSpecified, @Param("timeIn") @jakarta.annotation.Nullable List<OffsetDateTime> timeIn, @Param("timeNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> timeNotIn, @Param("gatewayNoteContains") @jakarta.annotation.Nullable String gatewayNoteContains, @Param("gatewayNoteDoesNotContain") @jakarta.annotation.Nullable String gatewayNoteDoesNotContain, @Param("gatewayNoteEquals") @jakarta.annotation.Nullable String gatewayNoteEquals, @Param("gatewayNoteNotEquals") @jakarta.annotation.Nullable String gatewayNoteNotEquals, @Param("gatewayNoteSpecified") @jakarta.annotation.Nullable Boolean gatewayNoteSpecified, @Param("gatewayNoteIn") @jakarta.annotation.Nullable List<String> gatewayNoteIn, @Param("gatewayNoteNotIn") @jakarta.annotation.Nullable List<String> gatewayNoteNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("bookingIdGreaterThan") @jakarta.annotation.Nullable Long bookingIdGreaterThan, @Param("bookingIdLessThan") @jakarta.annotation.Nullable Long bookingIdLessThan, @Param("bookingIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long bookingIdGreaterThanOrEqual, @Param("bookingIdLessThanOrEqual") @jakarta.annotation.Nullable Long bookingIdLessThanOrEqual, @Param("bookingIdEquals") @jakarta.annotation.Nullable Long bookingIdEquals, @Param("bookingIdNotEquals") @jakarta.annotation.Nullable Long bookingIdNotEquals, @Param("bookingIdSpecified") @jakarta.annotation.Nullable Boolean bookingIdSpecified, @Param("bookingIdIn") @jakarta.annotation.Nullable List<Long> bookingIdIn, @Param("bookingIdNotIn") @jakarta.annotation.Nullable List<Long> bookingIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllPaymentTransactions</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllPaymentTransactionsQueryParams} class that allows for
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
   *   <li>transactionIdContains -  (optional)</li>
   *   <li>transactionIdDoesNotContain -  (optional)</li>
   *   <li>transactionIdEquals -  (optional)</li>
   *   <li>transactionIdNotEquals -  (optional)</li>
   *   <li>transactionIdSpecified -  (optional)</li>
   *   <li>transactionIdIn -  (optional)</li>
   *   <li>transactionIdNotIn -  (optional)</li>
   *   <li>methodEquals -  (optional)</li>
   *   <li>methodNotEquals -  (optional)</li>
   *   <li>methodSpecified -  (optional)</li>
   *   <li>methodIn -  (optional)</li>
   *   <li>methodNotIn -  (optional)</li>
   *   <li>statusEquals -  (optional)</li>
   *   <li>statusNotEquals -  (optional)</li>
   *   <li>statusSpecified -  (optional)</li>
   *   <li>statusIn -  (optional)</li>
   *   <li>statusNotIn -  (optional)</li>
   *   <li>amountGreaterThan -  (optional)</li>
   *   <li>amountLessThan -  (optional)</li>
   *   <li>amountGreaterThanOrEqual -  (optional)</li>
   *   <li>amountLessThanOrEqual -  (optional)</li>
   *   <li>amountEquals -  (optional)</li>
   *   <li>amountNotEquals -  (optional)</li>
   *   <li>amountSpecified -  (optional)</li>
   *   <li>amountIn -  (optional)</li>
   *   <li>amountNotIn -  (optional)</li>
   *   <li>timeGreaterThan -  (optional)</li>
   *   <li>timeLessThan -  (optional)</li>
   *   <li>timeGreaterThanOrEqual -  (optional)</li>
   *   <li>timeLessThanOrEqual -  (optional)</li>
   *   <li>timeEquals -  (optional)</li>
   *   <li>timeNotEquals -  (optional)</li>
   *   <li>timeSpecified -  (optional)</li>
   *   <li>timeIn -  (optional)</li>
   *   <li>timeNotIn -  (optional)</li>
   *   <li>gatewayNoteContains -  (optional)</li>
   *   <li>gatewayNoteDoesNotContain -  (optional)</li>
   *   <li>gatewayNoteEquals -  (optional)</li>
   *   <li>gatewayNoteNotEquals -  (optional)</li>
   *   <li>gatewayNoteSpecified -  (optional)</li>
   *   <li>gatewayNoteIn -  (optional)</li>
   *   <li>gatewayNoteNotIn -  (optional)</li>
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
   * @return List&lt;PaymentTransactionDTO&gt;
   */
  @RequestLine("GET /api/payment-transactions?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&transactionId.contains={transactionIdContains}&transactionId.doesNotContain={transactionIdDoesNotContain}&transactionId.equals={transactionIdEquals}&transactionId.notEquals={transactionIdNotEquals}&transactionId.specified={transactionIdSpecified}&transactionId.in={transactionIdIn}&transactionId.notIn={transactionIdNotIn}&method.equals={methodEquals}&method.notEquals={methodNotEquals}&method.specified={methodSpecified}&method.in={methodIn}&method.notIn={methodNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&amount.greaterThan={amountGreaterThan}&amount.lessThan={amountLessThan}&amount.greaterThanOrEqual={amountGreaterThanOrEqual}&amount.lessThanOrEqual={amountLessThanOrEqual}&amount.equals={amountEquals}&amount.notEquals={amountNotEquals}&amount.specified={amountSpecified}&amount.in={amountIn}&amount.notIn={amountNotIn}&time.greaterThan={timeGreaterThan}&time.lessThan={timeLessThan}&time.greaterThanOrEqual={timeGreaterThanOrEqual}&time.lessThanOrEqual={timeLessThanOrEqual}&time.equals={timeEquals}&time.notEquals={timeNotEquals}&time.specified={timeSpecified}&time.in={timeIn}&time.notIn={timeNotIn}&gatewayNote.contains={gatewayNoteContains}&gatewayNote.doesNotContain={gatewayNoteDoesNotContain}&gatewayNote.equals={gatewayNoteEquals}&gatewayNote.notEquals={gatewayNoteNotEquals}&gatewayNote.specified={gatewayNoteSpecified}&gatewayNote.in={gatewayNoteIn}&gatewayNote.notIn={gatewayNoteNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  List<PaymentTransactionDTO> getAllPaymentTransactions(@QueryMap(encoded=true) GetAllPaymentTransactionsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllPaymentTransactions</code> that receives the query parameters as a map,
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
          *   <li>transactionIdContains -  (optional)</li>
          *   <li>transactionIdDoesNotContain -  (optional)</li>
          *   <li>transactionIdEquals -  (optional)</li>
          *   <li>transactionIdNotEquals -  (optional)</li>
          *   <li>transactionIdSpecified -  (optional)</li>
          *   <li>transactionIdIn -  (optional)</li>
          *   <li>transactionIdNotIn -  (optional)</li>
          *   <li>methodEquals -  (optional)</li>
          *   <li>methodNotEquals -  (optional)</li>
          *   <li>methodSpecified -  (optional)</li>
          *   <li>methodIn -  (optional)</li>
          *   <li>methodNotIn -  (optional)</li>
          *   <li>statusEquals -  (optional)</li>
          *   <li>statusNotEquals -  (optional)</li>
          *   <li>statusSpecified -  (optional)</li>
          *   <li>statusIn -  (optional)</li>
          *   <li>statusNotIn -  (optional)</li>
          *   <li>amountGreaterThan -  (optional)</li>
          *   <li>amountLessThan -  (optional)</li>
          *   <li>amountGreaterThanOrEqual -  (optional)</li>
          *   <li>amountLessThanOrEqual -  (optional)</li>
          *   <li>amountEquals -  (optional)</li>
          *   <li>amountNotEquals -  (optional)</li>
          *   <li>amountSpecified -  (optional)</li>
          *   <li>amountIn -  (optional)</li>
          *   <li>amountNotIn -  (optional)</li>
          *   <li>timeGreaterThan -  (optional)</li>
          *   <li>timeLessThan -  (optional)</li>
          *   <li>timeGreaterThanOrEqual -  (optional)</li>
          *   <li>timeLessThanOrEqual -  (optional)</li>
          *   <li>timeEquals -  (optional)</li>
          *   <li>timeNotEquals -  (optional)</li>
          *   <li>timeSpecified -  (optional)</li>
          *   <li>timeIn -  (optional)</li>
          *   <li>timeNotIn -  (optional)</li>
          *   <li>gatewayNoteContains -  (optional)</li>
          *   <li>gatewayNoteDoesNotContain -  (optional)</li>
          *   <li>gatewayNoteEquals -  (optional)</li>
          *   <li>gatewayNoteNotEquals -  (optional)</li>
          *   <li>gatewayNoteSpecified -  (optional)</li>
          *   <li>gatewayNoteIn -  (optional)</li>
          *   <li>gatewayNoteNotIn -  (optional)</li>
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
          * @return List&lt;PaymentTransactionDTO&gt;
      */
      @RequestLine("GET /api/payment-transactions?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&transactionId.contains={transactionIdContains}&transactionId.doesNotContain={transactionIdDoesNotContain}&transactionId.equals={transactionIdEquals}&transactionId.notEquals={transactionIdNotEquals}&transactionId.specified={transactionIdSpecified}&transactionId.in={transactionIdIn}&transactionId.notIn={transactionIdNotIn}&method.equals={methodEquals}&method.notEquals={methodNotEquals}&method.specified={methodSpecified}&method.in={methodIn}&method.notIn={methodNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&amount.greaterThan={amountGreaterThan}&amount.lessThan={amountLessThan}&amount.greaterThanOrEqual={amountGreaterThanOrEqual}&amount.lessThanOrEqual={amountLessThanOrEqual}&amount.equals={amountEquals}&amount.notEquals={amountNotEquals}&amount.specified={amountSpecified}&amount.in={amountIn}&amount.notIn={amountNotIn}&time.greaterThan={timeGreaterThan}&time.lessThan={timeLessThan}&time.greaterThanOrEqual={timeGreaterThanOrEqual}&time.lessThanOrEqual={timeLessThanOrEqual}&time.equals={timeEquals}&time.notEquals={timeNotEquals}&time.specified={timeSpecified}&time.in={timeIn}&time.notIn={timeNotIn}&gatewayNote.contains={gatewayNoteContains}&gatewayNote.doesNotContain={gatewayNoteDoesNotContain}&gatewayNote.equals={gatewayNoteEquals}&gatewayNote.notEquals={gatewayNoteNotEquals}&gatewayNote.specified={gatewayNoteSpecified}&gatewayNote.in={gatewayNoteIn}&gatewayNote.notIn={gatewayNoteNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<PaymentTransactionDTO>> getAllPaymentTransactionsWithHttpInfo(@QueryMap(encoded=true) GetAllPaymentTransactionsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllPaymentTransactions</code> method in a fluent style.
   */
  public static class GetAllPaymentTransactionsQueryParams extends HashMap<String, Object> {
    public GetAllPaymentTransactionsQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams transactionIdContains(@jakarta.annotation.Nullable final String value) {
      put("transactionId.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams transactionIdDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("transactionId.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams transactionIdEquals(@jakarta.annotation.Nullable final String value) {
      put("transactionId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams transactionIdNotEquals(@jakarta.annotation.Nullable final String value) {
      put("transactionId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams transactionIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("transactionId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams transactionIdIn(@jakarta.annotation.Nullable final List<String> value) {
      put("transactionId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams transactionIdNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("transactionId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams methodEquals(@jakarta.annotation.Nullable final String value) {
      put("method.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams methodNotEquals(@jakarta.annotation.Nullable final String value) {
      put("method.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams methodSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("method.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams methodIn(@jakarta.annotation.Nullable final List<String> value) {
      put("method.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams methodNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("method.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams statusEquals(@jakarta.annotation.Nullable final String value) {
      put("status.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams statusNotEquals(@jakarta.annotation.Nullable final String value) {
      put("status.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams statusSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("status.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams statusIn(@jakarta.annotation.Nullable final List<String> value) {
      put("status.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams statusNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("status.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams amountGreaterThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("amount.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams amountLessThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("amount.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams amountGreaterThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("amount.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams amountLessThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("amount.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams amountEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("amount.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams amountNotEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("amount.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams amountSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("amount.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams amountIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("amount.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams amountNotIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("amount.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams timeGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("time.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams timeLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("time.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams timeGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("time.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams timeLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("time.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams timeEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("time.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams timeNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("time.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams timeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("time.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams timeIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("time.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams timeNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("time.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams gatewayNoteContains(@jakarta.annotation.Nullable final String value) {
      put("gatewayNote.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams gatewayNoteDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("gatewayNote.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams gatewayNoteEquals(@jakarta.annotation.Nullable final String value) {
      put("gatewayNote.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams gatewayNoteNotEquals(@jakarta.annotation.Nullable final String value) {
      put("gatewayNote.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams gatewayNoteSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("gatewayNote.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams gatewayNoteIn(@jakarta.annotation.Nullable final List<String> value) {
      put("gatewayNote.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams gatewayNoteNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("gatewayNote.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams bookingIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams bookingIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams bookingIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams bookingIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams bookingIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams bookingIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams bookingIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("bookingId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams bookingIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("bookingId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams bookingIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("bookingId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllPaymentTransactionsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @return PaymentTransactionDTO
   */
  @RequestLine("GET /api/payment-transactions/{id}")
  @Headers({
    "Accept: */*",
  })
  PaymentTransactionDTO getPaymentTransaction(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>getPaymentTransaction</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/payment-transactions/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<PaymentTransactionDTO> getPaymentTransactionWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param id  (required)
   * @param paymentTransactionDTO  (required)
   * @return PaymentTransactionDTO
   */
  @RequestLine("PATCH /api/payment-transactions/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  PaymentTransactionDTO partialUpdatePaymentTransaction(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull PaymentTransactionDTO paymentTransactionDTO);

  /**
   * 
   * Similar to <code>partialUpdatePaymentTransaction</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param paymentTransactionDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /api/payment-transactions/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<PaymentTransactionDTO> partialUpdatePaymentTransactionWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull PaymentTransactionDTO paymentTransactionDTO);



  /**
   * 
   * 
   * @param id  (required)
   * @param paymentTransactionDTO  (required)
   * @return PaymentTransactionDTO
   */
  @RequestLine("PUT /api/payment-transactions/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  PaymentTransactionDTO updatePaymentTransaction(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull PaymentTransactionDTO paymentTransactionDTO);

  /**
   * 
   * Similar to <code>updatePaymentTransaction</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param paymentTransactionDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/payment-transactions/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<PaymentTransactionDTO> updatePaymentTransactionWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull PaymentTransactionDTO paymentTransactionDTO);


}
