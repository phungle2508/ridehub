package com.ridehub.msbooking.client.api;

import com.ridehub.msbooking.client.invoker.ApiClient;
import com.ridehub.msbooking.client.invoker.EncodingUtils;
import com.ridehub.msbooking.client.model.ApiResponse;

import java.math.BigDecimal;
import com.ridehub.msbooking.client.model.BookingDTO;
import java.time.OffsetDateTime;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface BookingResourceMsbookingApi extends ApiClient.Api {


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
   * @param bookingCodeContains  (optional)
   * @param bookingCodeDoesNotContain  (optional)
   * @param bookingCodeEquals  (optional)
   * @param bookingCodeNotEquals  (optional)
   * @param bookingCodeSpecified  (optional)
   * @param bookingCodeIn  (optional)
   * @param bookingCodeNotIn  (optional)
   * @param statusEquals  (optional)
   * @param statusNotEquals  (optional)
   * @param statusSpecified  (optional)
   * @param statusIn  (optional)
   * @param statusNotIn  (optional)
   * @param quantityGreaterThan  (optional)
   * @param quantityLessThan  (optional)
   * @param quantityGreaterThanOrEqual  (optional)
   * @param quantityLessThanOrEqual  (optional)
   * @param quantityEquals  (optional)
   * @param quantityNotEquals  (optional)
   * @param quantitySpecified  (optional)
   * @param quantityIn  (optional)
   * @param quantityNotIn  (optional)
   * @param totalAmountGreaterThan  (optional)
   * @param totalAmountLessThan  (optional)
   * @param totalAmountGreaterThanOrEqual  (optional)
   * @param totalAmountLessThanOrEqual  (optional)
   * @param totalAmountEquals  (optional)
   * @param totalAmountNotEquals  (optional)
   * @param totalAmountSpecified  (optional)
   * @param totalAmountIn  (optional)
   * @param totalAmountNotIn  (optional)
   * @param createdTimeGreaterThan  (optional)
   * @param createdTimeLessThan  (optional)
   * @param createdTimeGreaterThanOrEqual  (optional)
   * @param createdTimeLessThanOrEqual  (optional)
   * @param createdTimeEquals  (optional)
   * @param createdTimeNotEquals  (optional)
   * @param createdTimeSpecified  (optional)
   * @param createdTimeIn  (optional)
   * @param createdTimeNotIn  (optional)
   * @param customerIdEquals  (optional)
   * @param customerIdNotEquals  (optional)
   * @param customerIdSpecified  (optional)
   * @param customerIdIn  (optional)
   * @param customerIdNotIn  (optional)
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
   * @param invoiceIdGreaterThan  (optional)
   * @param invoiceIdLessThan  (optional)
   * @param invoiceIdGreaterThanOrEqual  (optional)
   * @param invoiceIdLessThanOrEqual  (optional)
   * @param invoiceIdEquals  (optional)
   * @param invoiceIdNotEquals  (optional)
   * @param invoiceIdSpecified  (optional)
   * @param invoiceIdIn  (optional)
   * @param invoiceIdNotIn  (optional)
   * @param paymentTransactionIdGreaterThan  (optional)
   * @param paymentTransactionIdLessThan  (optional)
   * @param paymentTransactionIdGreaterThanOrEqual  (optional)
   * @param paymentTransactionIdLessThanOrEqual  (optional)
   * @param paymentTransactionIdEquals  (optional)
   * @param paymentTransactionIdNotEquals  (optional)
   * @param paymentTransactionIdSpecified  (optional)
   * @param paymentTransactionIdIn  (optional)
   * @param paymentTransactionIdNotIn  (optional)
   * @param ticketsIdGreaterThan  (optional)
   * @param ticketsIdLessThan  (optional)
   * @param ticketsIdGreaterThanOrEqual  (optional)
   * @param ticketsIdLessThanOrEqual  (optional)
   * @param ticketsIdEquals  (optional)
   * @param ticketsIdNotEquals  (optional)
   * @param ticketsIdSpecified  (optional)
   * @param ticketsIdIn  (optional)
   * @param ticketsIdNotIn  (optional)
   * @param appliedPromosIdGreaterThan  (optional)
   * @param appliedPromosIdLessThan  (optional)
   * @param appliedPromosIdGreaterThanOrEqual  (optional)
   * @param appliedPromosIdLessThanOrEqual  (optional)
   * @param appliedPromosIdEquals  (optional)
   * @param appliedPromosIdNotEquals  (optional)
   * @param appliedPromosIdSpecified  (optional)
   * @param appliedPromosIdIn  (optional)
   * @param appliedPromosIdNotIn  (optional)
   * @param distinct  (optional)
   * @return Long
   */
  @RequestLine("GET /api/bookings/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bookingCode.contains={bookingCodeContains}&bookingCode.doesNotContain={bookingCodeDoesNotContain}&bookingCode.equals={bookingCodeEquals}&bookingCode.notEquals={bookingCodeNotEquals}&bookingCode.specified={bookingCodeSpecified}&bookingCode.in={bookingCodeIn}&bookingCode.notIn={bookingCodeNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&quantity.greaterThan={quantityGreaterThan}&quantity.lessThan={quantityLessThan}&quantity.greaterThanOrEqual={quantityGreaterThanOrEqual}&quantity.lessThanOrEqual={quantityLessThanOrEqual}&quantity.equals={quantityEquals}&quantity.notEquals={quantityNotEquals}&quantity.specified={quantitySpecified}&quantity.in={quantityIn}&quantity.notIn={quantityNotIn}&totalAmount.greaterThan={totalAmountGreaterThan}&totalAmount.lessThan={totalAmountLessThan}&totalAmount.greaterThanOrEqual={totalAmountGreaterThanOrEqual}&totalAmount.lessThanOrEqual={totalAmountLessThanOrEqual}&totalAmount.equals={totalAmountEquals}&totalAmount.notEquals={totalAmountNotEquals}&totalAmount.specified={totalAmountSpecified}&totalAmount.in={totalAmountIn}&totalAmount.notIn={totalAmountNotIn}&createdTime.greaterThan={createdTimeGreaterThan}&createdTime.lessThan={createdTimeLessThan}&createdTime.greaterThanOrEqual={createdTimeGreaterThanOrEqual}&createdTime.lessThanOrEqual={createdTimeLessThanOrEqual}&createdTime.equals={createdTimeEquals}&createdTime.notEquals={createdTimeNotEquals}&createdTime.specified={createdTimeSpecified}&createdTime.in={createdTimeIn}&createdTime.notIn={createdTimeNotIn}&customerId.equals={customerIdEquals}&customerId.notEquals={customerIdNotEquals}&customerId.specified={customerIdSpecified}&customerId.in={customerIdIn}&customerId.notIn={customerIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&invoiceId.greaterThan={invoiceIdGreaterThan}&invoiceId.lessThan={invoiceIdLessThan}&invoiceId.greaterThanOrEqual={invoiceIdGreaterThanOrEqual}&invoiceId.lessThanOrEqual={invoiceIdLessThanOrEqual}&invoiceId.equals={invoiceIdEquals}&invoiceId.notEquals={invoiceIdNotEquals}&invoiceId.specified={invoiceIdSpecified}&invoiceId.in={invoiceIdIn}&invoiceId.notIn={invoiceIdNotIn}&paymentTransactionId.greaterThan={paymentTransactionIdGreaterThan}&paymentTransactionId.lessThan={paymentTransactionIdLessThan}&paymentTransactionId.greaterThanOrEqual={paymentTransactionIdGreaterThanOrEqual}&paymentTransactionId.lessThanOrEqual={paymentTransactionIdLessThanOrEqual}&paymentTransactionId.equals={paymentTransactionIdEquals}&paymentTransactionId.notEquals={paymentTransactionIdNotEquals}&paymentTransactionId.specified={paymentTransactionIdSpecified}&paymentTransactionId.in={paymentTransactionIdIn}&paymentTransactionId.notIn={paymentTransactionIdNotIn}&ticketsId.greaterThan={ticketsIdGreaterThan}&ticketsId.lessThan={ticketsIdLessThan}&ticketsId.greaterThanOrEqual={ticketsIdGreaterThanOrEqual}&ticketsId.lessThanOrEqual={ticketsIdLessThanOrEqual}&ticketsId.equals={ticketsIdEquals}&ticketsId.notEquals={ticketsIdNotEquals}&ticketsId.specified={ticketsIdSpecified}&ticketsId.in={ticketsIdIn}&ticketsId.notIn={ticketsIdNotIn}&appliedPromosId.greaterThan={appliedPromosIdGreaterThan}&appliedPromosId.lessThan={appliedPromosIdLessThan}&appliedPromosId.greaterThanOrEqual={appliedPromosIdGreaterThanOrEqual}&appliedPromosId.lessThanOrEqual={appliedPromosIdLessThanOrEqual}&appliedPromosId.equals={appliedPromosIdEquals}&appliedPromosId.notEquals={appliedPromosIdNotEquals}&appliedPromosId.specified={appliedPromosIdSpecified}&appliedPromosId.in={appliedPromosIdIn}&appliedPromosId.notIn={appliedPromosIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  Long countBookings(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("bookingCodeContains") @jakarta.annotation.Nullable String bookingCodeContains, @Param("bookingCodeDoesNotContain") @jakarta.annotation.Nullable String bookingCodeDoesNotContain, @Param("bookingCodeEquals") @jakarta.annotation.Nullable String bookingCodeEquals, @Param("bookingCodeNotEquals") @jakarta.annotation.Nullable String bookingCodeNotEquals, @Param("bookingCodeSpecified") @jakarta.annotation.Nullable Boolean bookingCodeSpecified, @Param("bookingCodeIn") @jakarta.annotation.Nullable List<String> bookingCodeIn, @Param("bookingCodeNotIn") @jakarta.annotation.Nullable List<String> bookingCodeNotIn, @Param("statusEquals") @jakarta.annotation.Nullable String statusEquals, @Param("statusNotEquals") @jakarta.annotation.Nullable String statusNotEquals, @Param("statusSpecified") @jakarta.annotation.Nullable Boolean statusSpecified, @Param("statusIn") @jakarta.annotation.Nullable List<String> statusIn, @Param("statusNotIn") @jakarta.annotation.Nullable List<String> statusNotIn, @Param("quantityGreaterThan") @jakarta.annotation.Nullable Integer quantityGreaterThan, @Param("quantityLessThan") @jakarta.annotation.Nullable Integer quantityLessThan, @Param("quantityGreaterThanOrEqual") @jakarta.annotation.Nullable Integer quantityGreaterThanOrEqual, @Param("quantityLessThanOrEqual") @jakarta.annotation.Nullable Integer quantityLessThanOrEqual, @Param("quantityEquals") @jakarta.annotation.Nullable Integer quantityEquals, @Param("quantityNotEquals") @jakarta.annotation.Nullable Integer quantityNotEquals, @Param("quantitySpecified") @jakarta.annotation.Nullable Boolean quantitySpecified, @Param("quantityIn") @jakarta.annotation.Nullable List<Integer> quantityIn, @Param("quantityNotIn") @jakarta.annotation.Nullable List<Integer> quantityNotIn, @Param("totalAmountGreaterThan") @jakarta.annotation.Nullable BigDecimal totalAmountGreaterThan, @Param("totalAmountLessThan") @jakarta.annotation.Nullable BigDecimal totalAmountLessThan, @Param("totalAmountGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal totalAmountGreaterThanOrEqual, @Param("totalAmountLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal totalAmountLessThanOrEqual, @Param("totalAmountEquals") @jakarta.annotation.Nullable BigDecimal totalAmountEquals, @Param("totalAmountNotEquals") @jakarta.annotation.Nullable BigDecimal totalAmountNotEquals, @Param("totalAmountSpecified") @jakarta.annotation.Nullable Boolean totalAmountSpecified, @Param("totalAmountIn") @jakarta.annotation.Nullable List<BigDecimal> totalAmountIn, @Param("totalAmountNotIn") @jakarta.annotation.Nullable List<BigDecimal> totalAmountNotIn, @Param("createdTimeGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdTimeGreaterThan, @Param("createdTimeLessThan") @jakarta.annotation.Nullable OffsetDateTime createdTimeLessThan, @Param("createdTimeGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdTimeGreaterThanOrEqual, @Param("createdTimeLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdTimeLessThanOrEqual, @Param("createdTimeEquals") @jakarta.annotation.Nullable OffsetDateTime createdTimeEquals, @Param("createdTimeNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdTimeNotEquals, @Param("createdTimeSpecified") @jakarta.annotation.Nullable Boolean createdTimeSpecified, @Param("createdTimeIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdTimeIn, @Param("createdTimeNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdTimeNotIn, @Param("customerIdEquals") @jakarta.annotation.Nullable UUID customerIdEquals, @Param("customerIdNotEquals") @jakarta.annotation.Nullable UUID customerIdNotEquals, @Param("customerIdSpecified") @jakarta.annotation.Nullable Boolean customerIdSpecified, @Param("customerIdIn") @jakarta.annotation.Nullable List<UUID> customerIdIn, @Param("customerIdNotIn") @jakarta.annotation.Nullable List<UUID> customerIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("invoiceIdGreaterThan") @jakarta.annotation.Nullable Long invoiceIdGreaterThan, @Param("invoiceIdLessThan") @jakarta.annotation.Nullable Long invoiceIdLessThan, @Param("invoiceIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long invoiceIdGreaterThanOrEqual, @Param("invoiceIdLessThanOrEqual") @jakarta.annotation.Nullable Long invoiceIdLessThanOrEqual, @Param("invoiceIdEquals") @jakarta.annotation.Nullable Long invoiceIdEquals, @Param("invoiceIdNotEquals") @jakarta.annotation.Nullable Long invoiceIdNotEquals, @Param("invoiceIdSpecified") @jakarta.annotation.Nullable Boolean invoiceIdSpecified, @Param("invoiceIdIn") @jakarta.annotation.Nullable List<Long> invoiceIdIn, @Param("invoiceIdNotIn") @jakarta.annotation.Nullable List<Long> invoiceIdNotIn, @Param("paymentTransactionIdGreaterThan") @jakarta.annotation.Nullable Long paymentTransactionIdGreaterThan, @Param("paymentTransactionIdLessThan") @jakarta.annotation.Nullable Long paymentTransactionIdLessThan, @Param("paymentTransactionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long paymentTransactionIdGreaterThanOrEqual, @Param("paymentTransactionIdLessThanOrEqual") @jakarta.annotation.Nullable Long paymentTransactionIdLessThanOrEqual, @Param("paymentTransactionIdEquals") @jakarta.annotation.Nullable Long paymentTransactionIdEquals, @Param("paymentTransactionIdNotEquals") @jakarta.annotation.Nullable Long paymentTransactionIdNotEquals, @Param("paymentTransactionIdSpecified") @jakarta.annotation.Nullable Boolean paymentTransactionIdSpecified, @Param("paymentTransactionIdIn") @jakarta.annotation.Nullable List<Long> paymentTransactionIdIn, @Param("paymentTransactionIdNotIn") @jakarta.annotation.Nullable List<Long> paymentTransactionIdNotIn, @Param("ticketsIdGreaterThan") @jakarta.annotation.Nullable Long ticketsIdGreaterThan, @Param("ticketsIdLessThan") @jakarta.annotation.Nullable Long ticketsIdLessThan, @Param("ticketsIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long ticketsIdGreaterThanOrEqual, @Param("ticketsIdLessThanOrEqual") @jakarta.annotation.Nullable Long ticketsIdLessThanOrEqual, @Param("ticketsIdEquals") @jakarta.annotation.Nullable Long ticketsIdEquals, @Param("ticketsIdNotEquals") @jakarta.annotation.Nullable Long ticketsIdNotEquals, @Param("ticketsIdSpecified") @jakarta.annotation.Nullable Boolean ticketsIdSpecified, @Param("ticketsIdIn") @jakarta.annotation.Nullable List<Long> ticketsIdIn, @Param("ticketsIdNotIn") @jakarta.annotation.Nullable List<Long> ticketsIdNotIn, @Param("appliedPromosIdGreaterThan") @jakarta.annotation.Nullable Long appliedPromosIdGreaterThan, @Param("appliedPromosIdLessThan") @jakarta.annotation.Nullable Long appliedPromosIdLessThan, @Param("appliedPromosIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long appliedPromosIdGreaterThanOrEqual, @Param("appliedPromosIdLessThanOrEqual") @jakarta.annotation.Nullable Long appliedPromosIdLessThanOrEqual, @Param("appliedPromosIdEquals") @jakarta.annotation.Nullable Long appliedPromosIdEquals, @Param("appliedPromosIdNotEquals") @jakarta.annotation.Nullable Long appliedPromosIdNotEquals, @Param("appliedPromosIdSpecified") @jakarta.annotation.Nullable Boolean appliedPromosIdSpecified, @Param("appliedPromosIdIn") @jakarta.annotation.Nullable List<Long> appliedPromosIdIn, @Param("appliedPromosIdNotIn") @jakarta.annotation.Nullable List<Long> appliedPromosIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>countBookings</code> but it also returns the http response headers .
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
   * @param bookingCodeContains  (optional)
   * @param bookingCodeDoesNotContain  (optional)
   * @param bookingCodeEquals  (optional)
   * @param bookingCodeNotEquals  (optional)
   * @param bookingCodeSpecified  (optional)
   * @param bookingCodeIn  (optional)
   * @param bookingCodeNotIn  (optional)
   * @param statusEquals  (optional)
   * @param statusNotEquals  (optional)
   * @param statusSpecified  (optional)
   * @param statusIn  (optional)
   * @param statusNotIn  (optional)
   * @param quantityGreaterThan  (optional)
   * @param quantityLessThan  (optional)
   * @param quantityGreaterThanOrEqual  (optional)
   * @param quantityLessThanOrEqual  (optional)
   * @param quantityEquals  (optional)
   * @param quantityNotEquals  (optional)
   * @param quantitySpecified  (optional)
   * @param quantityIn  (optional)
   * @param quantityNotIn  (optional)
   * @param totalAmountGreaterThan  (optional)
   * @param totalAmountLessThan  (optional)
   * @param totalAmountGreaterThanOrEqual  (optional)
   * @param totalAmountLessThanOrEqual  (optional)
   * @param totalAmountEquals  (optional)
   * @param totalAmountNotEquals  (optional)
   * @param totalAmountSpecified  (optional)
   * @param totalAmountIn  (optional)
   * @param totalAmountNotIn  (optional)
   * @param createdTimeGreaterThan  (optional)
   * @param createdTimeLessThan  (optional)
   * @param createdTimeGreaterThanOrEqual  (optional)
   * @param createdTimeLessThanOrEqual  (optional)
   * @param createdTimeEquals  (optional)
   * @param createdTimeNotEquals  (optional)
   * @param createdTimeSpecified  (optional)
   * @param createdTimeIn  (optional)
   * @param createdTimeNotIn  (optional)
   * @param customerIdEquals  (optional)
   * @param customerIdNotEquals  (optional)
   * @param customerIdSpecified  (optional)
   * @param customerIdIn  (optional)
   * @param customerIdNotIn  (optional)
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
   * @param invoiceIdGreaterThan  (optional)
   * @param invoiceIdLessThan  (optional)
   * @param invoiceIdGreaterThanOrEqual  (optional)
   * @param invoiceIdLessThanOrEqual  (optional)
   * @param invoiceIdEquals  (optional)
   * @param invoiceIdNotEquals  (optional)
   * @param invoiceIdSpecified  (optional)
   * @param invoiceIdIn  (optional)
   * @param invoiceIdNotIn  (optional)
   * @param paymentTransactionIdGreaterThan  (optional)
   * @param paymentTransactionIdLessThan  (optional)
   * @param paymentTransactionIdGreaterThanOrEqual  (optional)
   * @param paymentTransactionIdLessThanOrEqual  (optional)
   * @param paymentTransactionIdEquals  (optional)
   * @param paymentTransactionIdNotEquals  (optional)
   * @param paymentTransactionIdSpecified  (optional)
   * @param paymentTransactionIdIn  (optional)
   * @param paymentTransactionIdNotIn  (optional)
   * @param ticketsIdGreaterThan  (optional)
   * @param ticketsIdLessThan  (optional)
   * @param ticketsIdGreaterThanOrEqual  (optional)
   * @param ticketsIdLessThanOrEqual  (optional)
   * @param ticketsIdEquals  (optional)
   * @param ticketsIdNotEquals  (optional)
   * @param ticketsIdSpecified  (optional)
   * @param ticketsIdIn  (optional)
   * @param ticketsIdNotIn  (optional)
   * @param appliedPromosIdGreaterThan  (optional)
   * @param appliedPromosIdLessThan  (optional)
   * @param appliedPromosIdGreaterThanOrEqual  (optional)
   * @param appliedPromosIdLessThanOrEqual  (optional)
   * @param appliedPromosIdEquals  (optional)
   * @param appliedPromosIdNotEquals  (optional)
   * @param appliedPromosIdSpecified  (optional)
   * @param appliedPromosIdIn  (optional)
   * @param appliedPromosIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/bookings/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bookingCode.contains={bookingCodeContains}&bookingCode.doesNotContain={bookingCodeDoesNotContain}&bookingCode.equals={bookingCodeEquals}&bookingCode.notEquals={bookingCodeNotEquals}&bookingCode.specified={bookingCodeSpecified}&bookingCode.in={bookingCodeIn}&bookingCode.notIn={bookingCodeNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&quantity.greaterThan={quantityGreaterThan}&quantity.lessThan={quantityLessThan}&quantity.greaterThanOrEqual={quantityGreaterThanOrEqual}&quantity.lessThanOrEqual={quantityLessThanOrEqual}&quantity.equals={quantityEquals}&quantity.notEquals={quantityNotEquals}&quantity.specified={quantitySpecified}&quantity.in={quantityIn}&quantity.notIn={quantityNotIn}&totalAmount.greaterThan={totalAmountGreaterThan}&totalAmount.lessThan={totalAmountLessThan}&totalAmount.greaterThanOrEqual={totalAmountGreaterThanOrEqual}&totalAmount.lessThanOrEqual={totalAmountLessThanOrEqual}&totalAmount.equals={totalAmountEquals}&totalAmount.notEquals={totalAmountNotEquals}&totalAmount.specified={totalAmountSpecified}&totalAmount.in={totalAmountIn}&totalAmount.notIn={totalAmountNotIn}&createdTime.greaterThan={createdTimeGreaterThan}&createdTime.lessThan={createdTimeLessThan}&createdTime.greaterThanOrEqual={createdTimeGreaterThanOrEqual}&createdTime.lessThanOrEqual={createdTimeLessThanOrEqual}&createdTime.equals={createdTimeEquals}&createdTime.notEquals={createdTimeNotEquals}&createdTime.specified={createdTimeSpecified}&createdTime.in={createdTimeIn}&createdTime.notIn={createdTimeNotIn}&customerId.equals={customerIdEquals}&customerId.notEquals={customerIdNotEquals}&customerId.specified={customerIdSpecified}&customerId.in={customerIdIn}&customerId.notIn={customerIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&invoiceId.greaterThan={invoiceIdGreaterThan}&invoiceId.lessThan={invoiceIdLessThan}&invoiceId.greaterThanOrEqual={invoiceIdGreaterThanOrEqual}&invoiceId.lessThanOrEqual={invoiceIdLessThanOrEqual}&invoiceId.equals={invoiceIdEquals}&invoiceId.notEquals={invoiceIdNotEquals}&invoiceId.specified={invoiceIdSpecified}&invoiceId.in={invoiceIdIn}&invoiceId.notIn={invoiceIdNotIn}&paymentTransactionId.greaterThan={paymentTransactionIdGreaterThan}&paymentTransactionId.lessThan={paymentTransactionIdLessThan}&paymentTransactionId.greaterThanOrEqual={paymentTransactionIdGreaterThanOrEqual}&paymentTransactionId.lessThanOrEqual={paymentTransactionIdLessThanOrEqual}&paymentTransactionId.equals={paymentTransactionIdEquals}&paymentTransactionId.notEquals={paymentTransactionIdNotEquals}&paymentTransactionId.specified={paymentTransactionIdSpecified}&paymentTransactionId.in={paymentTransactionIdIn}&paymentTransactionId.notIn={paymentTransactionIdNotIn}&ticketsId.greaterThan={ticketsIdGreaterThan}&ticketsId.lessThan={ticketsIdLessThan}&ticketsId.greaterThanOrEqual={ticketsIdGreaterThanOrEqual}&ticketsId.lessThanOrEqual={ticketsIdLessThanOrEqual}&ticketsId.equals={ticketsIdEquals}&ticketsId.notEquals={ticketsIdNotEquals}&ticketsId.specified={ticketsIdSpecified}&ticketsId.in={ticketsIdIn}&ticketsId.notIn={ticketsIdNotIn}&appliedPromosId.greaterThan={appliedPromosIdGreaterThan}&appliedPromosId.lessThan={appliedPromosIdLessThan}&appliedPromosId.greaterThanOrEqual={appliedPromosIdGreaterThanOrEqual}&appliedPromosId.lessThanOrEqual={appliedPromosIdLessThanOrEqual}&appliedPromosId.equals={appliedPromosIdEquals}&appliedPromosId.notEquals={appliedPromosIdNotEquals}&appliedPromosId.specified={appliedPromosIdSpecified}&appliedPromosId.in={appliedPromosIdIn}&appliedPromosId.notIn={appliedPromosIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Long> countBookingsWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("bookingCodeContains") @jakarta.annotation.Nullable String bookingCodeContains, @Param("bookingCodeDoesNotContain") @jakarta.annotation.Nullable String bookingCodeDoesNotContain, @Param("bookingCodeEquals") @jakarta.annotation.Nullable String bookingCodeEquals, @Param("bookingCodeNotEquals") @jakarta.annotation.Nullable String bookingCodeNotEquals, @Param("bookingCodeSpecified") @jakarta.annotation.Nullable Boolean bookingCodeSpecified, @Param("bookingCodeIn") @jakarta.annotation.Nullable List<String> bookingCodeIn, @Param("bookingCodeNotIn") @jakarta.annotation.Nullable List<String> bookingCodeNotIn, @Param("statusEquals") @jakarta.annotation.Nullable String statusEquals, @Param("statusNotEquals") @jakarta.annotation.Nullable String statusNotEquals, @Param("statusSpecified") @jakarta.annotation.Nullable Boolean statusSpecified, @Param("statusIn") @jakarta.annotation.Nullable List<String> statusIn, @Param("statusNotIn") @jakarta.annotation.Nullable List<String> statusNotIn, @Param("quantityGreaterThan") @jakarta.annotation.Nullable Integer quantityGreaterThan, @Param("quantityLessThan") @jakarta.annotation.Nullable Integer quantityLessThan, @Param("quantityGreaterThanOrEqual") @jakarta.annotation.Nullable Integer quantityGreaterThanOrEqual, @Param("quantityLessThanOrEqual") @jakarta.annotation.Nullable Integer quantityLessThanOrEqual, @Param("quantityEquals") @jakarta.annotation.Nullable Integer quantityEquals, @Param("quantityNotEquals") @jakarta.annotation.Nullable Integer quantityNotEquals, @Param("quantitySpecified") @jakarta.annotation.Nullable Boolean quantitySpecified, @Param("quantityIn") @jakarta.annotation.Nullable List<Integer> quantityIn, @Param("quantityNotIn") @jakarta.annotation.Nullable List<Integer> quantityNotIn, @Param("totalAmountGreaterThan") @jakarta.annotation.Nullable BigDecimal totalAmountGreaterThan, @Param("totalAmountLessThan") @jakarta.annotation.Nullable BigDecimal totalAmountLessThan, @Param("totalAmountGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal totalAmountGreaterThanOrEqual, @Param("totalAmountLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal totalAmountLessThanOrEqual, @Param("totalAmountEquals") @jakarta.annotation.Nullable BigDecimal totalAmountEquals, @Param("totalAmountNotEquals") @jakarta.annotation.Nullable BigDecimal totalAmountNotEquals, @Param("totalAmountSpecified") @jakarta.annotation.Nullable Boolean totalAmountSpecified, @Param("totalAmountIn") @jakarta.annotation.Nullable List<BigDecimal> totalAmountIn, @Param("totalAmountNotIn") @jakarta.annotation.Nullable List<BigDecimal> totalAmountNotIn, @Param("createdTimeGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdTimeGreaterThan, @Param("createdTimeLessThan") @jakarta.annotation.Nullable OffsetDateTime createdTimeLessThan, @Param("createdTimeGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdTimeGreaterThanOrEqual, @Param("createdTimeLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdTimeLessThanOrEqual, @Param("createdTimeEquals") @jakarta.annotation.Nullable OffsetDateTime createdTimeEquals, @Param("createdTimeNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdTimeNotEquals, @Param("createdTimeSpecified") @jakarta.annotation.Nullable Boolean createdTimeSpecified, @Param("createdTimeIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdTimeIn, @Param("createdTimeNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdTimeNotIn, @Param("customerIdEquals") @jakarta.annotation.Nullable UUID customerIdEquals, @Param("customerIdNotEquals") @jakarta.annotation.Nullable UUID customerIdNotEquals, @Param("customerIdSpecified") @jakarta.annotation.Nullable Boolean customerIdSpecified, @Param("customerIdIn") @jakarta.annotation.Nullable List<UUID> customerIdIn, @Param("customerIdNotIn") @jakarta.annotation.Nullable List<UUID> customerIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("invoiceIdGreaterThan") @jakarta.annotation.Nullable Long invoiceIdGreaterThan, @Param("invoiceIdLessThan") @jakarta.annotation.Nullable Long invoiceIdLessThan, @Param("invoiceIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long invoiceIdGreaterThanOrEqual, @Param("invoiceIdLessThanOrEqual") @jakarta.annotation.Nullable Long invoiceIdLessThanOrEqual, @Param("invoiceIdEquals") @jakarta.annotation.Nullable Long invoiceIdEquals, @Param("invoiceIdNotEquals") @jakarta.annotation.Nullable Long invoiceIdNotEquals, @Param("invoiceIdSpecified") @jakarta.annotation.Nullable Boolean invoiceIdSpecified, @Param("invoiceIdIn") @jakarta.annotation.Nullable List<Long> invoiceIdIn, @Param("invoiceIdNotIn") @jakarta.annotation.Nullable List<Long> invoiceIdNotIn, @Param("paymentTransactionIdGreaterThan") @jakarta.annotation.Nullable Long paymentTransactionIdGreaterThan, @Param("paymentTransactionIdLessThan") @jakarta.annotation.Nullable Long paymentTransactionIdLessThan, @Param("paymentTransactionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long paymentTransactionIdGreaterThanOrEqual, @Param("paymentTransactionIdLessThanOrEqual") @jakarta.annotation.Nullable Long paymentTransactionIdLessThanOrEqual, @Param("paymentTransactionIdEquals") @jakarta.annotation.Nullable Long paymentTransactionIdEquals, @Param("paymentTransactionIdNotEquals") @jakarta.annotation.Nullable Long paymentTransactionIdNotEquals, @Param("paymentTransactionIdSpecified") @jakarta.annotation.Nullable Boolean paymentTransactionIdSpecified, @Param("paymentTransactionIdIn") @jakarta.annotation.Nullable List<Long> paymentTransactionIdIn, @Param("paymentTransactionIdNotIn") @jakarta.annotation.Nullable List<Long> paymentTransactionIdNotIn, @Param("ticketsIdGreaterThan") @jakarta.annotation.Nullable Long ticketsIdGreaterThan, @Param("ticketsIdLessThan") @jakarta.annotation.Nullable Long ticketsIdLessThan, @Param("ticketsIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long ticketsIdGreaterThanOrEqual, @Param("ticketsIdLessThanOrEqual") @jakarta.annotation.Nullable Long ticketsIdLessThanOrEqual, @Param("ticketsIdEquals") @jakarta.annotation.Nullable Long ticketsIdEquals, @Param("ticketsIdNotEquals") @jakarta.annotation.Nullable Long ticketsIdNotEquals, @Param("ticketsIdSpecified") @jakarta.annotation.Nullable Boolean ticketsIdSpecified, @Param("ticketsIdIn") @jakarta.annotation.Nullable List<Long> ticketsIdIn, @Param("ticketsIdNotIn") @jakarta.annotation.Nullable List<Long> ticketsIdNotIn, @Param("appliedPromosIdGreaterThan") @jakarta.annotation.Nullable Long appliedPromosIdGreaterThan, @Param("appliedPromosIdLessThan") @jakarta.annotation.Nullable Long appliedPromosIdLessThan, @Param("appliedPromosIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long appliedPromosIdGreaterThanOrEqual, @Param("appliedPromosIdLessThanOrEqual") @jakarta.annotation.Nullable Long appliedPromosIdLessThanOrEqual, @Param("appliedPromosIdEquals") @jakarta.annotation.Nullable Long appliedPromosIdEquals, @Param("appliedPromosIdNotEquals") @jakarta.annotation.Nullable Long appliedPromosIdNotEquals, @Param("appliedPromosIdSpecified") @jakarta.annotation.Nullable Boolean appliedPromosIdSpecified, @Param("appliedPromosIdIn") @jakarta.annotation.Nullable List<Long> appliedPromosIdIn, @Param("appliedPromosIdNotIn") @jakarta.annotation.Nullable List<Long> appliedPromosIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>countBookings</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CountBookingsQueryParams} class that allows for
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
   *   <li>bookingCodeContains -  (optional)</li>
   *   <li>bookingCodeDoesNotContain -  (optional)</li>
   *   <li>bookingCodeEquals -  (optional)</li>
   *   <li>bookingCodeNotEquals -  (optional)</li>
   *   <li>bookingCodeSpecified -  (optional)</li>
   *   <li>bookingCodeIn -  (optional)</li>
   *   <li>bookingCodeNotIn -  (optional)</li>
   *   <li>statusEquals -  (optional)</li>
   *   <li>statusNotEquals -  (optional)</li>
   *   <li>statusSpecified -  (optional)</li>
   *   <li>statusIn -  (optional)</li>
   *   <li>statusNotIn -  (optional)</li>
   *   <li>quantityGreaterThan -  (optional)</li>
   *   <li>quantityLessThan -  (optional)</li>
   *   <li>quantityGreaterThanOrEqual -  (optional)</li>
   *   <li>quantityLessThanOrEqual -  (optional)</li>
   *   <li>quantityEquals -  (optional)</li>
   *   <li>quantityNotEquals -  (optional)</li>
   *   <li>quantitySpecified -  (optional)</li>
   *   <li>quantityIn -  (optional)</li>
   *   <li>quantityNotIn -  (optional)</li>
   *   <li>totalAmountGreaterThan -  (optional)</li>
   *   <li>totalAmountLessThan -  (optional)</li>
   *   <li>totalAmountGreaterThanOrEqual -  (optional)</li>
   *   <li>totalAmountLessThanOrEqual -  (optional)</li>
   *   <li>totalAmountEquals -  (optional)</li>
   *   <li>totalAmountNotEquals -  (optional)</li>
   *   <li>totalAmountSpecified -  (optional)</li>
   *   <li>totalAmountIn -  (optional)</li>
   *   <li>totalAmountNotIn -  (optional)</li>
   *   <li>createdTimeGreaterThan -  (optional)</li>
   *   <li>createdTimeLessThan -  (optional)</li>
   *   <li>createdTimeGreaterThanOrEqual -  (optional)</li>
   *   <li>createdTimeLessThanOrEqual -  (optional)</li>
   *   <li>createdTimeEquals -  (optional)</li>
   *   <li>createdTimeNotEquals -  (optional)</li>
   *   <li>createdTimeSpecified -  (optional)</li>
   *   <li>createdTimeIn -  (optional)</li>
   *   <li>createdTimeNotIn -  (optional)</li>
   *   <li>customerIdEquals -  (optional)</li>
   *   <li>customerIdNotEquals -  (optional)</li>
   *   <li>customerIdSpecified -  (optional)</li>
   *   <li>customerIdIn -  (optional)</li>
   *   <li>customerIdNotIn -  (optional)</li>
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
   *   <li>invoiceIdGreaterThan -  (optional)</li>
   *   <li>invoiceIdLessThan -  (optional)</li>
   *   <li>invoiceIdGreaterThanOrEqual -  (optional)</li>
   *   <li>invoiceIdLessThanOrEqual -  (optional)</li>
   *   <li>invoiceIdEquals -  (optional)</li>
   *   <li>invoiceIdNotEquals -  (optional)</li>
   *   <li>invoiceIdSpecified -  (optional)</li>
   *   <li>invoiceIdIn -  (optional)</li>
   *   <li>invoiceIdNotIn -  (optional)</li>
   *   <li>paymentTransactionIdGreaterThan -  (optional)</li>
   *   <li>paymentTransactionIdLessThan -  (optional)</li>
   *   <li>paymentTransactionIdGreaterThanOrEqual -  (optional)</li>
   *   <li>paymentTransactionIdLessThanOrEqual -  (optional)</li>
   *   <li>paymentTransactionIdEquals -  (optional)</li>
   *   <li>paymentTransactionIdNotEquals -  (optional)</li>
   *   <li>paymentTransactionIdSpecified -  (optional)</li>
   *   <li>paymentTransactionIdIn -  (optional)</li>
   *   <li>paymentTransactionIdNotIn -  (optional)</li>
   *   <li>ticketsIdGreaterThan -  (optional)</li>
   *   <li>ticketsIdLessThan -  (optional)</li>
   *   <li>ticketsIdGreaterThanOrEqual -  (optional)</li>
   *   <li>ticketsIdLessThanOrEqual -  (optional)</li>
   *   <li>ticketsIdEquals -  (optional)</li>
   *   <li>ticketsIdNotEquals -  (optional)</li>
   *   <li>ticketsIdSpecified -  (optional)</li>
   *   <li>ticketsIdIn -  (optional)</li>
   *   <li>ticketsIdNotIn -  (optional)</li>
   *   <li>appliedPromosIdGreaterThan -  (optional)</li>
   *   <li>appliedPromosIdLessThan -  (optional)</li>
   *   <li>appliedPromosIdGreaterThanOrEqual -  (optional)</li>
   *   <li>appliedPromosIdLessThanOrEqual -  (optional)</li>
   *   <li>appliedPromosIdEquals -  (optional)</li>
   *   <li>appliedPromosIdNotEquals -  (optional)</li>
   *   <li>appliedPromosIdSpecified -  (optional)</li>
   *   <li>appliedPromosIdIn -  (optional)</li>
   *   <li>appliedPromosIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return Long
   */
  @RequestLine("GET /api/bookings/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bookingCode.contains={bookingCodeContains}&bookingCode.doesNotContain={bookingCodeDoesNotContain}&bookingCode.equals={bookingCodeEquals}&bookingCode.notEquals={bookingCodeNotEquals}&bookingCode.specified={bookingCodeSpecified}&bookingCode.in={bookingCodeIn}&bookingCode.notIn={bookingCodeNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&quantity.greaterThan={quantityGreaterThan}&quantity.lessThan={quantityLessThan}&quantity.greaterThanOrEqual={quantityGreaterThanOrEqual}&quantity.lessThanOrEqual={quantityLessThanOrEqual}&quantity.equals={quantityEquals}&quantity.notEquals={quantityNotEquals}&quantity.specified={quantitySpecified}&quantity.in={quantityIn}&quantity.notIn={quantityNotIn}&totalAmount.greaterThan={totalAmountGreaterThan}&totalAmount.lessThan={totalAmountLessThan}&totalAmount.greaterThanOrEqual={totalAmountGreaterThanOrEqual}&totalAmount.lessThanOrEqual={totalAmountLessThanOrEqual}&totalAmount.equals={totalAmountEquals}&totalAmount.notEquals={totalAmountNotEquals}&totalAmount.specified={totalAmountSpecified}&totalAmount.in={totalAmountIn}&totalAmount.notIn={totalAmountNotIn}&createdTime.greaterThan={createdTimeGreaterThan}&createdTime.lessThan={createdTimeLessThan}&createdTime.greaterThanOrEqual={createdTimeGreaterThanOrEqual}&createdTime.lessThanOrEqual={createdTimeLessThanOrEqual}&createdTime.equals={createdTimeEquals}&createdTime.notEquals={createdTimeNotEquals}&createdTime.specified={createdTimeSpecified}&createdTime.in={createdTimeIn}&createdTime.notIn={createdTimeNotIn}&customerId.equals={customerIdEquals}&customerId.notEquals={customerIdNotEquals}&customerId.specified={customerIdSpecified}&customerId.in={customerIdIn}&customerId.notIn={customerIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&invoiceId.greaterThan={invoiceIdGreaterThan}&invoiceId.lessThan={invoiceIdLessThan}&invoiceId.greaterThanOrEqual={invoiceIdGreaterThanOrEqual}&invoiceId.lessThanOrEqual={invoiceIdLessThanOrEqual}&invoiceId.equals={invoiceIdEquals}&invoiceId.notEquals={invoiceIdNotEquals}&invoiceId.specified={invoiceIdSpecified}&invoiceId.in={invoiceIdIn}&invoiceId.notIn={invoiceIdNotIn}&paymentTransactionId.greaterThan={paymentTransactionIdGreaterThan}&paymentTransactionId.lessThan={paymentTransactionIdLessThan}&paymentTransactionId.greaterThanOrEqual={paymentTransactionIdGreaterThanOrEqual}&paymentTransactionId.lessThanOrEqual={paymentTransactionIdLessThanOrEqual}&paymentTransactionId.equals={paymentTransactionIdEquals}&paymentTransactionId.notEquals={paymentTransactionIdNotEquals}&paymentTransactionId.specified={paymentTransactionIdSpecified}&paymentTransactionId.in={paymentTransactionIdIn}&paymentTransactionId.notIn={paymentTransactionIdNotIn}&ticketsId.greaterThan={ticketsIdGreaterThan}&ticketsId.lessThan={ticketsIdLessThan}&ticketsId.greaterThanOrEqual={ticketsIdGreaterThanOrEqual}&ticketsId.lessThanOrEqual={ticketsIdLessThanOrEqual}&ticketsId.equals={ticketsIdEquals}&ticketsId.notEquals={ticketsIdNotEquals}&ticketsId.specified={ticketsIdSpecified}&ticketsId.in={ticketsIdIn}&ticketsId.notIn={ticketsIdNotIn}&appliedPromosId.greaterThan={appliedPromosIdGreaterThan}&appliedPromosId.lessThan={appliedPromosIdLessThan}&appliedPromosId.greaterThanOrEqual={appliedPromosIdGreaterThanOrEqual}&appliedPromosId.lessThanOrEqual={appliedPromosIdLessThanOrEqual}&appliedPromosId.equals={appliedPromosIdEquals}&appliedPromosId.notEquals={appliedPromosIdNotEquals}&appliedPromosId.specified={appliedPromosIdSpecified}&appliedPromosId.in={appliedPromosIdIn}&appliedPromosId.notIn={appliedPromosIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  Long countBookings(@QueryMap(encoded=true) CountBookingsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>countBookings</code> that receives the query parameters as a map,
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
          *   <li>bookingCodeContains -  (optional)</li>
          *   <li>bookingCodeDoesNotContain -  (optional)</li>
          *   <li>bookingCodeEquals -  (optional)</li>
          *   <li>bookingCodeNotEquals -  (optional)</li>
          *   <li>bookingCodeSpecified -  (optional)</li>
          *   <li>bookingCodeIn -  (optional)</li>
          *   <li>bookingCodeNotIn -  (optional)</li>
          *   <li>statusEquals -  (optional)</li>
          *   <li>statusNotEquals -  (optional)</li>
          *   <li>statusSpecified -  (optional)</li>
          *   <li>statusIn -  (optional)</li>
          *   <li>statusNotIn -  (optional)</li>
          *   <li>quantityGreaterThan -  (optional)</li>
          *   <li>quantityLessThan -  (optional)</li>
          *   <li>quantityGreaterThanOrEqual -  (optional)</li>
          *   <li>quantityLessThanOrEqual -  (optional)</li>
          *   <li>quantityEquals -  (optional)</li>
          *   <li>quantityNotEquals -  (optional)</li>
          *   <li>quantitySpecified -  (optional)</li>
          *   <li>quantityIn -  (optional)</li>
          *   <li>quantityNotIn -  (optional)</li>
          *   <li>totalAmountGreaterThan -  (optional)</li>
          *   <li>totalAmountLessThan -  (optional)</li>
          *   <li>totalAmountGreaterThanOrEqual -  (optional)</li>
          *   <li>totalAmountLessThanOrEqual -  (optional)</li>
          *   <li>totalAmountEquals -  (optional)</li>
          *   <li>totalAmountNotEquals -  (optional)</li>
          *   <li>totalAmountSpecified -  (optional)</li>
          *   <li>totalAmountIn -  (optional)</li>
          *   <li>totalAmountNotIn -  (optional)</li>
          *   <li>createdTimeGreaterThan -  (optional)</li>
          *   <li>createdTimeLessThan -  (optional)</li>
          *   <li>createdTimeGreaterThanOrEqual -  (optional)</li>
          *   <li>createdTimeLessThanOrEqual -  (optional)</li>
          *   <li>createdTimeEquals -  (optional)</li>
          *   <li>createdTimeNotEquals -  (optional)</li>
          *   <li>createdTimeSpecified -  (optional)</li>
          *   <li>createdTimeIn -  (optional)</li>
          *   <li>createdTimeNotIn -  (optional)</li>
          *   <li>customerIdEquals -  (optional)</li>
          *   <li>customerIdNotEquals -  (optional)</li>
          *   <li>customerIdSpecified -  (optional)</li>
          *   <li>customerIdIn -  (optional)</li>
          *   <li>customerIdNotIn -  (optional)</li>
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
          *   <li>invoiceIdGreaterThan -  (optional)</li>
          *   <li>invoiceIdLessThan -  (optional)</li>
          *   <li>invoiceIdGreaterThanOrEqual -  (optional)</li>
          *   <li>invoiceIdLessThanOrEqual -  (optional)</li>
          *   <li>invoiceIdEquals -  (optional)</li>
          *   <li>invoiceIdNotEquals -  (optional)</li>
          *   <li>invoiceIdSpecified -  (optional)</li>
          *   <li>invoiceIdIn -  (optional)</li>
          *   <li>invoiceIdNotIn -  (optional)</li>
          *   <li>paymentTransactionIdGreaterThan -  (optional)</li>
          *   <li>paymentTransactionIdLessThan -  (optional)</li>
          *   <li>paymentTransactionIdGreaterThanOrEqual -  (optional)</li>
          *   <li>paymentTransactionIdLessThanOrEqual -  (optional)</li>
          *   <li>paymentTransactionIdEquals -  (optional)</li>
          *   <li>paymentTransactionIdNotEquals -  (optional)</li>
          *   <li>paymentTransactionIdSpecified -  (optional)</li>
          *   <li>paymentTransactionIdIn -  (optional)</li>
          *   <li>paymentTransactionIdNotIn -  (optional)</li>
          *   <li>ticketsIdGreaterThan -  (optional)</li>
          *   <li>ticketsIdLessThan -  (optional)</li>
          *   <li>ticketsIdGreaterThanOrEqual -  (optional)</li>
          *   <li>ticketsIdLessThanOrEqual -  (optional)</li>
          *   <li>ticketsIdEquals -  (optional)</li>
          *   <li>ticketsIdNotEquals -  (optional)</li>
          *   <li>ticketsIdSpecified -  (optional)</li>
          *   <li>ticketsIdIn -  (optional)</li>
          *   <li>ticketsIdNotIn -  (optional)</li>
          *   <li>appliedPromosIdGreaterThan -  (optional)</li>
          *   <li>appliedPromosIdLessThan -  (optional)</li>
          *   <li>appliedPromosIdGreaterThanOrEqual -  (optional)</li>
          *   <li>appliedPromosIdLessThanOrEqual -  (optional)</li>
          *   <li>appliedPromosIdEquals -  (optional)</li>
          *   <li>appliedPromosIdNotEquals -  (optional)</li>
          *   <li>appliedPromosIdSpecified -  (optional)</li>
          *   <li>appliedPromosIdIn -  (optional)</li>
          *   <li>appliedPromosIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return Long
      */
      @RequestLine("GET /api/bookings/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bookingCode.contains={bookingCodeContains}&bookingCode.doesNotContain={bookingCodeDoesNotContain}&bookingCode.equals={bookingCodeEquals}&bookingCode.notEquals={bookingCodeNotEquals}&bookingCode.specified={bookingCodeSpecified}&bookingCode.in={bookingCodeIn}&bookingCode.notIn={bookingCodeNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&quantity.greaterThan={quantityGreaterThan}&quantity.lessThan={quantityLessThan}&quantity.greaterThanOrEqual={quantityGreaterThanOrEqual}&quantity.lessThanOrEqual={quantityLessThanOrEqual}&quantity.equals={quantityEquals}&quantity.notEquals={quantityNotEquals}&quantity.specified={quantitySpecified}&quantity.in={quantityIn}&quantity.notIn={quantityNotIn}&totalAmount.greaterThan={totalAmountGreaterThan}&totalAmount.lessThan={totalAmountLessThan}&totalAmount.greaterThanOrEqual={totalAmountGreaterThanOrEqual}&totalAmount.lessThanOrEqual={totalAmountLessThanOrEqual}&totalAmount.equals={totalAmountEquals}&totalAmount.notEquals={totalAmountNotEquals}&totalAmount.specified={totalAmountSpecified}&totalAmount.in={totalAmountIn}&totalAmount.notIn={totalAmountNotIn}&createdTime.greaterThan={createdTimeGreaterThan}&createdTime.lessThan={createdTimeLessThan}&createdTime.greaterThanOrEqual={createdTimeGreaterThanOrEqual}&createdTime.lessThanOrEqual={createdTimeLessThanOrEqual}&createdTime.equals={createdTimeEquals}&createdTime.notEquals={createdTimeNotEquals}&createdTime.specified={createdTimeSpecified}&createdTime.in={createdTimeIn}&createdTime.notIn={createdTimeNotIn}&customerId.equals={customerIdEquals}&customerId.notEquals={customerIdNotEquals}&customerId.specified={customerIdSpecified}&customerId.in={customerIdIn}&customerId.notIn={customerIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&invoiceId.greaterThan={invoiceIdGreaterThan}&invoiceId.lessThan={invoiceIdLessThan}&invoiceId.greaterThanOrEqual={invoiceIdGreaterThanOrEqual}&invoiceId.lessThanOrEqual={invoiceIdLessThanOrEqual}&invoiceId.equals={invoiceIdEquals}&invoiceId.notEquals={invoiceIdNotEquals}&invoiceId.specified={invoiceIdSpecified}&invoiceId.in={invoiceIdIn}&invoiceId.notIn={invoiceIdNotIn}&paymentTransactionId.greaterThan={paymentTransactionIdGreaterThan}&paymentTransactionId.lessThan={paymentTransactionIdLessThan}&paymentTransactionId.greaterThanOrEqual={paymentTransactionIdGreaterThanOrEqual}&paymentTransactionId.lessThanOrEqual={paymentTransactionIdLessThanOrEqual}&paymentTransactionId.equals={paymentTransactionIdEquals}&paymentTransactionId.notEquals={paymentTransactionIdNotEquals}&paymentTransactionId.specified={paymentTransactionIdSpecified}&paymentTransactionId.in={paymentTransactionIdIn}&paymentTransactionId.notIn={paymentTransactionIdNotIn}&ticketsId.greaterThan={ticketsIdGreaterThan}&ticketsId.lessThan={ticketsIdLessThan}&ticketsId.greaterThanOrEqual={ticketsIdGreaterThanOrEqual}&ticketsId.lessThanOrEqual={ticketsIdLessThanOrEqual}&ticketsId.equals={ticketsIdEquals}&ticketsId.notEquals={ticketsIdNotEquals}&ticketsId.specified={ticketsIdSpecified}&ticketsId.in={ticketsIdIn}&ticketsId.notIn={ticketsIdNotIn}&appliedPromosId.greaterThan={appliedPromosIdGreaterThan}&appliedPromosId.lessThan={appliedPromosIdLessThan}&appliedPromosId.greaterThanOrEqual={appliedPromosIdGreaterThanOrEqual}&appliedPromosId.lessThanOrEqual={appliedPromosIdLessThanOrEqual}&appliedPromosId.equals={appliedPromosIdEquals}&appliedPromosId.notEquals={appliedPromosIdNotEquals}&appliedPromosId.specified={appliedPromosIdSpecified}&appliedPromosId.in={appliedPromosIdIn}&appliedPromosId.notIn={appliedPromosIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Long> countBookingsWithHttpInfo(@QueryMap(encoded=true) CountBookingsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>countBookings</code> method in a fluent style.
   */
  public static class CountBookingsQueryParams extends HashMap<String, Object> {
    public CountBookingsQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBookingsQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBookingsQueryParams bookingCodeContains(@jakarta.annotation.Nullable final String value) {
      put("bookingCode.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams bookingCodeDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("bookingCode.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams bookingCodeEquals(@jakarta.annotation.Nullable final String value) {
      put("bookingCode.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams bookingCodeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("bookingCode.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams bookingCodeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("bookingCode.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams bookingCodeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("bookingCode.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBookingsQueryParams bookingCodeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("bookingCode.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBookingsQueryParams statusEquals(@jakarta.annotation.Nullable final String value) {
      put("status.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams statusNotEquals(@jakarta.annotation.Nullable final String value) {
      put("status.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams statusSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("status.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams statusIn(@jakarta.annotation.Nullable final List<String> value) {
      put("status.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBookingsQueryParams statusNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("status.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBookingsQueryParams quantityGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("quantity.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams quantityLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("quantity.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams quantityGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("quantity.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams quantityLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("quantity.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams quantityEquals(@jakarta.annotation.Nullable final Integer value) {
      put("quantity.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams quantityNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("quantity.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams quantitySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("quantity.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams quantityIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("quantity.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBookingsQueryParams quantityNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("quantity.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBookingsQueryParams totalAmountGreaterThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("totalAmount.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams totalAmountLessThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("totalAmount.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams totalAmountGreaterThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("totalAmount.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams totalAmountLessThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("totalAmount.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams totalAmountEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("totalAmount.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams totalAmountNotEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("totalAmount.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams totalAmountSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("totalAmount.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams totalAmountIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("totalAmount.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBookingsQueryParams totalAmountNotIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("totalAmount.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBookingsQueryParams createdTimeGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdTime.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams createdTimeLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdTime.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams createdTimeGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdTime.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams createdTimeLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdTime.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams createdTimeEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdTime.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams createdTimeNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdTime.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams createdTimeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdTime.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams createdTimeIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdTime.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBookingsQueryParams createdTimeNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdTime.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBookingsQueryParams customerIdEquals(@jakarta.annotation.Nullable final UUID value) {
      put("customerId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams customerIdNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("customerId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams customerIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("customerId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams customerIdIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("customerId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBookingsQueryParams customerIdNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("customerId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBookingsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBookingsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBookingsQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBookingsQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBookingsQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBookingsQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBookingsQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBookingsQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBookingsQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBookingsQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBookingsQueryParams invoiceIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("invoiceId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams invoiceIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("invoiceId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams invoiceIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("invoiceId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams invoiceIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("invoiceId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams invoiceIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("invoiceId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams invoiceIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("invoiceId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams invoiceIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("invoiceId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams invoiceIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("invoiceId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBookingsQueryParams invoiceIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("invoiceId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBookingsQueryParams paymentTransactionIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("paymentTransactionId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams paymentTransactionIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("paymentTransactionId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams paymentTransactionIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("paymentTransactionId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams paymentTransactionIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("paymentTransactionId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams paymentTransactionIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("paymentTransactionId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams paymentTransactionIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("paymentTransactionId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams paymentTransactionIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("paymentTransactionId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams paymentTransactionIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("paymentTransactionId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBookingsQueryParams paymentTransactionIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("paymentTransactionId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBookingsQueryParams ticketsIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("ticketsId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams ticketsIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("ticketsId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams ticketsIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("ticketsId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams ticketsIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("ticketsId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams ticketsIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("ticketsId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams ticketsIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("ticketsId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams ticketsIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("ticketsId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams ticketsIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("ticketsId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBookingsQueryParams ticketsIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("ticketsId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBookingsQueryParams appliedPromosIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("appliedPromosId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams appliedPromosIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("appliedPromosId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams appliedPromosIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("appliedPromosId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams appliedPromosIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("appliedPromosId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams appliedPromosIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("appliedPromosId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams appliedPromosIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("appliedPromosId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams appliedPromosIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("appliedPromosId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountBookingsQueryParams appliedPromosIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("appliedPromosId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBookingsQueryParams appliedPromosIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("appliedPromosId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountBookingsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param bookingDTO  (required)
   * @return BookingDTO
   */
  @RequestLine("POST /api/bookings")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  BookingDTO createBooking(@jakarta.annotation.Nonnull BookingDTO bookingDTO);

  /**
   * 
   * Similar to <code>createBooking</code> but it also returns the http response headers .
   * 
   * @param bookingDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/bookings")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<BookingDTO> createBookingWithHttpInfo(@jakarta.annotation.Nonnull BookingDTO bookingDTO);



  /**
   * 
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/bookings/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteBooking(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>deleteBooking</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/bookings/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteBookingWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



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
   * @param bookingCodeContains  (optional)
   * @param bookingCodeDoesNotContain  (optional)
   * @param bookingCodeEquals  (optional)
   * @param bookingCodeNotEquals  (optional)
   * @param bookingCodeSpecified  (optional)
   * @param bookingCodeIn  (optional)
   * @param bookingCodeNotIn  (optional)
   * @param statusEquals  (optional)
   * @param statusNotEquals  (optional)
   * @param statusSpecified  (optional)
   * @param statusIn  (optional)
   * @param statusNotIn  (optional)
   * @param quantityGreaterThan  (optional)
   * @param quantityLessThan  (optional)
   * @param quantityGreaterThanOrEqual  (optional)
   * @param quantityLessThanOrEqual  (optional)
   * @param quantityEquals  (optional)
   * @param quantityNotEquals  (optional)
   * @param quantitySpecified  (optional)
   * @param quantityIn  (optional)
   * @param quantityNotIn  (optional)
   * @param totalAmountGreaterThan  (optional)
   * @param totalAmountLessThan  (optional)
   * @param totalAmountGreaterThanOrEqual  (optional)
   * @param totalAmountLessThanOrEqual  (optional)
   * @param totalAmountEquals  (optional)
   * @param totalAmountNotEquals  (optional)
   * @param totalAmountSpecified  (optional)
   * @param totalAmountIn  (optional)
   * @param totalAmountNotIn  (optional)
   * @param createdTimeGreaterThan  (optional)
   * @param createdTimeLessThan  (optional)
   * @param createdTimeGreaterThanOrEqual  (optional)
   * @param createdTimeLessThanOrEqual  (optional)
   * @param createdTimeEquals  (optional)
   * @param createdTimeNotEquals  (optional)
   * @param createdTimeSpecified  (optional)
   * @param createdTimeIn  (optional)
   * @param createdTimeNotIn  (optional)
   * @param customerIdEquals  (optional)
   * @param customerIdNotEquals  (optional)
   * @param customerIdSpecified  (optional)
   * @param customerIdIn  (optional)
   * @param customerIdNotIn  (optional)
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
   * @param invoiceIdGreaterThan  (optional)
   * @param invoiceIdLessThan  (optional)
   * @param invoiceIdGreaterThanOrEqual  (optional)
   * @param invoiceIdLessThanOrEqual  (optional)
   * @param invoiceIdEquals  (optional)
   * @param invoiceIdNotEquals  (optional)
   * @param invoiceIdSpecified  (optional)
   * @param invoiceIdIn  (optional)
   * @param invoiceIdNotIn  (optional)
   * @param paymentTransactionIdGreaterThan  (optional)
   * @param paymentTransactionIdLessThan  (optional)
   * @param paymentTransactionIdGreaterThanOrEqual  (optional)
   * @param paymentTransactionIdLessThanOrEqual  (optional)
   * @param paymentTransactionIdEquals  (optional)
   * @param paymentTransactionIdNotEquals  (optional)
   * @param paymentTransactionIdSpecified  (optional)
   * @param paymentTransactionIdIn  (optional)
   * @param paymentTransactionIdNotIn  (optional)
   * @param ticketsIdGreaterThan  (optional)
   * @param ticketsIdLessThan  (optional)
   * @param ticketsIdGreaterThanOrEqual  (optional)
   * @param ticketsIdLessThanOrEqual  (optional)
   * @param ticketsIdEquals  (optional)
   * @param ticketsIdNotEquals  (optional)
   * @param ticketsIdSpecified  (optional)
   * @param ticketsIdIn  (optional)
   * @param ticketsIdNotIn  (optional)
   * @param appliedPromosIdGreaterThan  (optional)
   * @param appliedPromosIdLessThan  (optional)
   * @param appliedPromosIdGreaterThanOrEqual  (optional)
   * @param appliedPromosIdLessThanOrEqual  (optional)
   * @param appliedPromosIdEquals  (optional)
   * @param appliedPromosIdNotEquals  (optional)
   * @param appliedPromosIdSpecified  (optional)
   * @param appliedPromosIdIn  (optional)
   * @param appliedPromosIdNotIn  (optional)
   * @param distinct  (optional)
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return List&lt;BookingDTO&gt;
   */
  @RequestLine("GET /api/bookings?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bookingCode.contains={bookingCodeContains}&bookingCode.doesNotContain={bookingCodeDoesNotContain}&bookingCode.equals={bookingCodeEquals}&bookingCode.notEquals={bookingCodeNotEquals}&bookingCode.specified={bookingCodeSpecified}&bookingCode.in={bookingCodeIn}&bookingCode.notIn={bookingCodeNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&quantity.greaterThan={quantityGreaterThan}&quantity.lessThan={quantityLessThan}&quantity.greaterThanOrEqual={quantityGreaterThanOrEqual}&quantity.lessThanOrEqual={quantityLessThanOrEqual}&quantity.equals={quantityEquals}&quantity.notEquals={quantityNotEquals}&quantity.specified={quantitySpecified}&quantity.in={quantityIn}&quantity.notIn={quantityNotIn}&totalAmount.greaterThan={totalAmountGreaterThan}&totalAmount.lessThan={totalAmountLessThan}&totalAmount.greaterThanOrEqual={totalAmountGreaterThanOrEqual}&totalAmount.lessThanOrEqual={totalAmountLessThanOrEqual}&totalAmount.equals={totalAmountEquals}&totalAmount.notEquals={totalAmountNotEquals}&totalAmount.specified={totalAmountSpecified}&totalAmount.in={totalAmountIn}&totalAmount.notIn={totalAmountNotIn}&createdTime.greaterThan={createdTimeGreaterThan}&createdTime.lessThan={createdTimeLessThan}&createdTime.greaterThanOrEqual={createdTimeGreaterThanOrEqual}&createdTime.lessThanOrEqual={createdTimeLessThanOrEqual}&createdTime.equals={createdTimeEquals}&createdTime.notEquals={createdTimeNotEquals}&createdTime.specified={createdTimeSpecified}&createdTime.in={createdTimeIn}&createdTime.notIn={createdTimeNotIn}&customerId.equals={customerIdEquals}&customerId.notEquals={customerIdNotEquals}&customerId.specified={customerIdSpecified}&customerId.in={customerIdIn}&customerId.notIn={customerIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&invoiceId.greaterThan={invoiceIdGreaterThan}&invoiceId.lessThan={invoiceIdLessThan}&invoiceId.greaterThanOrEqual={invoiceIdGreaterThanOrEqual}&invoiceId.lessThanOrEqual={invoiceIdLessThanOrEqual}&invoiceId.equals={invoiceIdEquals}&invoiceId.notEquals={invoiceIdNotEquals}&invoiceId.specified={invoiceIdSpecified}&invoiceId.in={invoiceIdIn}&invoiceId.notIn={invoiceIdNotIn}&paymentTransactionId.greaterThan={paymentTransactionIdGreaterThan}&paymentTransactionId.lessThan={paymentTransactionIdLessThan}&paymentTransactionId.greaterThanOrEqual={paymentTransactionIdGreaterThanOrEqual}&paymentTransactionId.lessThanOrEqual={paymentTransactionIdLessThanOrEqual}&paymentTransactionId.equals={paymentTransactionIdEquals}&paymentTransactionId.notEquals={paymentTransactionIdNotEquals}&paymentTransactionId.specified={paymentTransactionIdSpecified}&paymentTransactionId.in={paymentTransactionIdIn}&paymentTransactionId.notIn={paymentTransactionIdNotIn}&ticketsId.greaterThan={ticketsIdGreaterThan}&ticketsId.lessThan={ticketsIdLessThan}&ticketsId.greaterThanOrEqual={ticketsIdGreaterThanOrEqual}&ticketsId.lessThanOrEqual={ticketsIdLessThanOrEqual}&ticketsId.equals={ticketsIdEquals}&ticketsId.notEquals={ticketsIdNotEquals}&ticketsId.specified={ticketsIdSpecified}&ticketsId.in={ticketsIdIn}&ticketsId.notIn={ticketsIdNotIn}&appliedPromosId.greaterThan={appliedPromosIdGreaterThan}&appliedPromosId.lessThan={appliedPromosIdLessThan}&appliedPromosId.greaterThanOrEqual={appliedPromosIdGreaterThanOrEqual}&appliedPromosId.lessThanOrEqual={appliedPromosIdLessThanOrEqual}&appliedPromosId.equals={appliedPromosIdEquals}&appliedPromosId.notEquals={appliedPromosIdNotEquals}&appliedPromosId.specified={appliedPromosIdSpecified}&appliedPromosId.in={appliedPromosIdIn}&appliedPromosId.notIn={appliedPromosIdNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",
  })
  List<BookingDTO> getAllBookings(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("bookingCodeContains") @jakarta.annotation.Nullable String bookingCodeContains, @Param("bookingCodeDoesNotContain") @jakarta.annotation.Nullable String bookingCodeDoesNotContain, @Param("bookingCodeEquals") @jakarta.annotation.Nullable String bookingCodeEquals, @Param("bookingCodeNotEquals") @jakarta.annotation.Nullable String bookingCodeNotEquals, @Param("bookingCodeSpecified") @jakarta.annotation.Nullable Boolean bookingCodeSpecified, @Param("bookingCodeIn") @jakarta.annotation.Nullable List<String> bookingCodeIn, @Param("bookingCodeNotIn") @jakarta.annotation.Nullable List<String> bookingCodeNotIn, @Param("statusEquals") @jakarta.annotation.Nullable String statusEquals, @Param("statusNotEquals") @jakarta.annotation.Nullable String statusNotEquals, @Param("statusSpecified") @jakarta.annotation.Nullable Boolean statusSpecified, @Param("statusIn") @jakarta.annotation.Nullable List<String> statusIn, @Param("statusNotIn") @jakarta.annotation.Nullable List<String> statusNotIn, @Param("quantityGreaterThan") @jakarta.annotation.Nullable Integer quantityGreaterThan, @Param("quantityLessThan") @jakarta.annotation.Nullable Integer quantityLessThan, @Param("quantityGreaterThanOrEqual") @jakarta.annotation.Nullable Integer quantityGreaterThanOrEqual, @Param("quantityLessThanOrEqual") @jakarta.annotation.Nullable Integer quantityLessThanOrEqual, @Param("quantityEquals") @jakarta.annotation.Nullable Integer quantityEquals, @Param("quantityNotEquals") @jakarta.annotation.Nullable Integer quantityNotEquals, @Param("quantitySpecified") @jakarta.annotation.Nullable Boolean quantitySpecified, @Param("quantityIn") @jakarta.annotation.Nullable List<Integer> quantityIn, @Param("quantityNotIn") @jakarta.annotation.Nullable List<Integer> quantityNotIn, @Param("totalAmountGreaterThan") @jakarta.annotation.Nullable BigDecimal totalAmountGreaterThan, @Param("totalAmountLessThan") @jakarta.annotation.Nullable BigDecimal totalAmountLessThan, @Param("totalAmountGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal totalAmountGreaterThanOrEqual, @Param("totalAmountLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal totalAmountLessThanOrEqual, @Param("totalAmountEquals") @jakarta.annotation.Nullable BigDecimal totalAmountEquals, @Param("totalAmountNotEquals") @jakarta.annotation.Nullable BigDecimal totalAmountNotEquals, @Param("totalAmountSpecified") @jakarta.annotation.Nullable Boolean totalAmountSpecified, @Param("totalAmountIn") @jakarta.annotation.Nullable List<BigDecimal> totalAmountIn, @Param("totalAmountNotIn") @jakarta.annotation.Nullable List<BigDecimal> totalAmountNotIn, @Param("createdTimeGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdTimeGreaterThan, @Param("createdTimeLessThan") @jakarta.annotation.Nullable OffsetDateTime createdTimeLessThan, @Param("createdTimeGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdTimeGreaterThanOrEqual, @Param("createdTimeLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdTimeLessThanOrEqual, @Param("createdTimeEquals") @jakarta.annotation.Nullable OffsetDateTime createdTimeEquals, @Param("createdTimeNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdTimeNotEquals, @Param("createdTimeSpecified") @jakarta.annotation.Nullable Boolean createdTimeSpecified, @Param("createdTimeIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdTimeIn, @Param("createdTimeNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdTimeNotIn, @Param("customerIdEquals") @jakarta.annotation.Nullable UUID customerIdEquals, @Param("customerIdNotEquals") @jakarta.annotation.Nullable UUID customerIdNotEquals, @Param("customerIdSpecified") @jakarta.annotation.Nullable Boolean customerIdSpecified, @Param("customerIdIn") @jakarta.annotation.Nullable List<UUID> customerIdIn, @Param("customerIdNotIn") @jakarta.annotation.Nullable List<UUID> customerIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("invoiceIdGreaterThan") @jakarta.annotation.Nullable Long invoiceIdGreaterThan, @Param("invoiceIdLessThan") @jakarta.annotation.Nullable Long invoiceIdLessThan, @Param("invoiceIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long invoiceIdGreaterThanOrEqual, @Param("invoiceIdLessThanOrEqual") @jakarta.annotation.Nullable Long invoiceIdLessThanOrEqual, @Param("invoiceIdEquals") @jakarta.annotation.Nullable Long invoiceIdEquals, @Param("invoiceIdNotEquals") @jakarta.annotation.Nullable Long invoiceIdNotEquals, @Param("invoiceIdSpecified") @jakarta.annotation.Nullable Boolean invoiceIdSpecified, @Param("invoiceIdIn") @jakarta.annotation.Nullable List<Long> invoiceIdIn, @Param("invoiceIdNotIn") @jakarta.annotation.Nullable List<Long> invoiceIdNotIn, @Param("paymentTransactionIdGreaterThan") @jakarta.annotation.Nullable Long paymentTransactionIdGreaterThan, @Param("paymentTransactionIdLessThan") @jakarta.annotation.Nullable Long paymentTransactionIdLessThan, @Param("paymentTransactionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long paymentTransactionIdGreaterThanOrEqual, @Param("paymentTransactionIdLessThanOrEqual") @jakarta.annotation.Nullable Long paymentTransactionIdLessThanOrEqual, @Param("paymentTransactionIdEquals") @jakarta.annotation.Nullable Long paymentTransactionIdEquals, @Param("paymentTransactionIdNotEquals") @jakarta.annotation.Nullable Long paymentTransactionIdNotEquals, @Param("paymentTransactionIdSpecified") @jakarta.annotation.Nullable Boolean paymentTransactionIdSpecified, @Param("paymentTransactionIdIn") @jakarta.annotation.Nullable List<Long> paymentTransactionIdIn, @Param("paymentTransactionIdNotIn") @jakarta.annotation.Nullable List<Long> paymentTransactionIdNotIn, @Param("ticketsIdGreaterThan") @jakarta.annotation.Nullable Long ticketsIdGreaterThan, @Param("ticketsIdLessThan") @jakarta.annotation.Nullable Long ticketsIdLessThan, @Param("ticketsIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long ticketsIdGreaterThanOrEqual, @Param("ticketsIdLessThanOrEqual") @jakarta.annotation.Nullable Long ticketsIdLessThanOrEqual, @Param("ticketsIdEquals") @jakarta.annotation.Nullable Long ticketsIdEquals, @Param("ticketsIdNotEquals") @jakarta.annotation.Nullable Long ticketsIdNotEquals, @Param("ticketsIdSpecified") @jakarta.annotation.Nullable Boolean ticketsIdSpecified, @Param("ticketsIdIn") @jakarta.annotation.Nullable List<Long> ticketsIdIn, @Param("ticketsIdNotIn") @jakarta.annotation.Nullable List<Long> ticketsIdNotIn, @Param("appliedPromosIdGreaterThan") @jakarta.annotation.Nullable Long appliedPromosIdGreaterThan, @Param("appliedPromosIdLessThan") @jakarta.annotation.Nullable Long appliedPromosIdLessThan, @Param("appliedPromosIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long appliedPromosIdGreaterThanOrEqual, @Param("appliedPromosIdLessThanOrEqual") @jakarta.annotation.Nullable Long appliedPromosIdLessThanOrEqual, @Param("appliedPromosIdEquals") @jakarta.annotation.Nullable Long appliedPromosIdEquals, @Param("appliedPromosIdNotEquals") @jakarta.annotation.Nullable Long appliedPromosIdNotEquals, @Param("appliedPromosIdSpecified") @jakarta.annotation.Nullable Boolean appliedPromosIdSpecified, @Param("appliedPromosIdIn") @jakarta.annotation.Nullable List<Long> appliedPromosIdIn, @Param("appliedPromosIdNotIn") @jakarta.annotation.Nullable List<Long> appliedPromosIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct, @Param("page") @jakarta.annotation.Nullable Integer page, @Param("size") @jakarta.annotation.Nullable Integer size, @Param("sort") @jakarta.annotation.Nullable List<String> sort);

  /**
   * 
   * Similar to <code>getAllBookings</code> but it also returns the http response headers .
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
   * @param bookingCodeContains  (optional)
   * @param bookingCodeDoesNotContain  (optional)
   * @param bookingCodeEquals  (optional)
   * @param bookingCodeNotEquals  (optional)
   * @param bookingCodeSpecified  (optional)
   * @param bookingCodeIn  (optional)
   * @param bookingCodeNotIn  (optional)
   * @param statusEquals  (optional)
   * @param statusNotEquals  (optional)
   * @param statusSpecified  (optional)
   * @param statusIn  (optional)
   * @param statusNotIn  (optional)
   * @param quantityGreaterThan  (optional)
   * @param quantityLessThan  (optional)
   * @param quantityGreaterThanOrEqual  (optional)
   * @param quantityLessThanOrEqual  (optional)
   * @param quantityEquals  (optional)
   * @param quantityNotEquals  (optional)
   * @param quantitySpecified  (optional)
   * @param quantityIn  (optional)
   * @param quantityNotIn  (optional)
   * @param totalAmountGreaterThan  (optional)
   * @param totalAmountLessThan  (optional)
   * @param totalAmountGreaterThanOrEqual  (optional)
   * @param totalAmountLessThanOrEqual  (optional)
   * @param totalAmountEquals  (optional)
   * @param totalAmountNotEquals  (optional)
   * @param totalAmountSpecified  (optional)
   * @param totalAmountIn  (optional)
   * @param totalAmountNotIn  (optional)
   * @param createdTimeGreaterThan  (optional)
   * @param createdTimeLessThan  (optional)
   * @param createdTimeGreaterThanOrEqual  (optional)
   * @param createdTimeLessThanOrEqual  (optional)
   * @param createdTimeEquals  (optional)
   * @param createdTimeNotEquals  (optional)
   * @param createdTimeSpecified  (optional)
   * @param createdTimeIn  (optional)
   * @param createdTimeNotIn  (optional)
   * @param customerIdEquals  (optional)
   * @param customerIdNotEquals  (optional)
   * @param customerIdSpecified  (optional)
   * @param customerIdIn  (optional)
   * @param customerIdNotIn  (optional)
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
   * @param invoiceIdGreaterThan  (optional)
   * @param invoiceIdLessThan  (optional)
   * @param invoiceIdGreaterThanOrEqual  (optional)
   * @param invoiceIdLessThanOrEqual  (optional)
   * @param invoiceIdEquals  (optional)
   * @param invoiceIdNotEquals  (optional)
   * @param invoiceIdSpecified  (optional)
   * @param invoiceIdIn  (optional)
   * @param invoiceIdNotIn  (optional)
   * @param paymentTransactionIdGreaterThan  (optional)
   * @param paymentTransactionIdLessThan  (optional)
   * @param paymentTransactionIdGreaterThanOrEqual  (optional)
   * @param paymentTransactionIdLessThanOrEqual  (optional)
   * @param paymentTransactionIdEquals  (optional)
   * @param paymentTransactionIdNotEquals  (optional)
   * @param paymentTransactionIdSpecified  (optional)
   * @param paymentTransactionIdIn  (optional)
   * @param paymentTransactionIdNotIn  (optional)
   * @param ticketsIdGreaterThan  (optional)
   * @param ticketsIdLessThan  (optional)
   * @param ticketsIdGreaterThanOrEqual  (optional)
   * @param ticketsIdLessThanOrEqual  (optional)
   * @param ticketsIdEquals  (optional)
   * @param ticketsIdNotEquals  (optional)
   * @param ticketsIdSpecified  (optional)
   * @param ticketsIdIn  (optional)
   * @param ticketsIdNotIn  (optional)
   * @param appliedPromosIdGreaterThan  (optional)
   * @param appliedPromosIdLessThan  (optional)
   * @param appliedPromosIdGreaterThanOrEqual  (optional)
   * @param appliedPromosIdLessThanOrEqual  (optional)
   * @param appliedPromosIdEquals  (optional)
   * @param appliedPromosIdNotEquals  (optional)
   * @param appliedPromosIdSpecified  (optional)
   * @param appliedPromosIdIn  (optional)
   * @param appliedPromosIdNotIn  (optional)
   * @param distinct  (optional)
   * @param page Zero-based page index (0..N) (optional, default to 0)
   * @param size The size of the page to be returned (optional, default to 20)
   * @param sort Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/bookings?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bookingCode.contains={bookingCodeContains}&bookingCode.doesNotContain={bookingCodeDoesNotContain}&bookingCode.equals={bookingCodeEquals}&bookingCode.notEquals={bookingCodeNotEquals}&bookingCode.specified={bookingCodeSpecified}&bookingCode.in={bookingCodeIn}&bookingCode.notIn={bookingCodeNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&quantity.greaterThan={quantityGreaterThan}&quantity.lessThan={quantityLessThan}&quantity.greaterThanOrEqual={quantityGreaterThanOrEqual}&quantity.lessThanOrEqual={quantityLessThanOrEqual}&quantity.equals={quantityEquals}&quantity.notEquals={quantityNotEquals}&quantity.specified={quantitySpecified}&quantity.in={quantityIn}&quantity.notIn={quantityNotIn}&totalAmount.greaterThan={totalAmountGreaterThan}&totalAmount.lessThan={totalAmountLessThan}&totalAmount.greaterThanOrEqual={totalAmountGreaterThanOrEqual}&totalAmount.lessThanOrEqual={totalAmountLessThanOrEqual}&totalAmount.equals={totalAmountEquals}&totalAmount.notEquals={totalAmountNotEquals}&totalAmount.specified={totalAmountSpecified}&totalAmount.in={totalAmountIn}&totalAmount.notIn={totalAmountNotIn}&createdTime.greaterThan={createdTimeGreaterThan}&createdTime.lessThan={createdTimeLessThan}&createdTime.greaterThanOrEqual={createdTimeGreaterThanOrEqual}&createdTime.lessThanOrEqual={createdTimeLessThanOrEqual}&createdTime.equals={createdTimeEquals}&createdTime.notEquals={createdTimeNotEquals}&createdTime.specified={createdTimeSpecified}&createdTime.in={createdTimeIn}&createdTime.notIn={createdTimeNotIn}&customerId.equals={customerIdEquals}&customerId.notEquals={customerIdNotEquals}&customerId.specified={customerIdSpecified}&customerId.in={customerIdIn}&customerId.notIn={customerIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&invoiceId.greaterThan={invoiceIdGreaterThan}&invoiceId.lessThan={invoiceIdLessThan}&invoiceId.greaterThanOrEqual={invoiceIdGreaterThanOrEqual}&invoiceId.lessThanOrEqual={invoiceIdLessThanOrEqual}&invoiceId.equals={invoiceIdEquals}&invoiceId.notEquals={invoiceIdNotEquals}&invoiceId.specified={invoiceIdSpecified}&invoiceId.in={invoiceIdIn}&invoiceId.notIn={invoiceIdNotIn}&paymentTransactionId.greaterThan={paymentTransactionIdGreaterThan}&paymentTransactionId.lessThan={paymentTransactionIdLessThan}&paymentTransactionId.greaterThanOrEqual={paymentTransactionIdGreaterThanOrEqual}&paymentTransactionId.lessThanOrEqual={paymentTransactionIdLessThanOrEqual}&paymentTransactionId.equals={paymentTransactionIdEquals}&paymentTransactionId.notEquals={paymentTransactionIdNotEquals}&paymentTransactionId.specified={paymentTransactionIdSpecified}&paymentTransactionId.in={paymentTransactionIdIn}&paymentTransactionId.notIn={paymentTransactionIdNotIn}&ticketsId.greaterThan={ticketsIdGreaterThan}&ticketsId.lessThan={ticketsIdLessThan}&ticketsId.greaterThanOrEqual={ticketsIdGreaterThanOrEqual}&ticketsId.lessThanOrEqual={ticketsIdLessThanOrEqual}&ticketsId.equals={ticketsIdEquals}&ticketsId.notEquals={ticketsIdNotEquals}&ticketsId.specified={ticketsIdSpecified}&ticketsId.in={ticketsIdIn}&ticketsId.notIn={ticketsIdNotIn}&appliedPromosId.greaterThan={appliedPromosIdGreaterThan}&appliedPromosId.lessThan={appliedPromosIdLessThan}&appliedPromosId.greaterThanOrEqual={appliedPromosIdGreaterThanOrEqual}&appliedPromosId.lessThanOrEqual={appliedPromosIdLessThanOrEqual}&appliedPromosId.equals={appliedPromosIdEquals}&appliedPromosId.notEquals={appliedPromosIdNotEquals}&appliedPromosId.specified={appliedPromosIdSpecified}&appliedPromosId.in={appliedPromosIdIn}&appliedPromosId.notIn={appliedPromosIdNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<BookingDTO>> getAllBookingsWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("bookingCodeContains") @jakarta.annotation.Nullable String bookingCodeContains, @Param("bookingCodeDoesNotContain") @jakarta.annotation.Nullable String bookingCodeDoesNotContain, @Param("bookingCodeEquals") @jakarta.annotation.Nullable String bookingCodeEquals, @Param("bookingCodeNotEquals") @jakarta.annotation.Nullable String bookingCodeNotEquals, @Param("bookingCodeSpecified") @jakarta.annotation.Nullable Boolean bookingCodeSpecified, @Param("bookingCodeIn") @jakarta.annotation.Nullable List<String> bookingCodeIn, @Param("bookingCodeNotIn") @jakarta.annotation.Nullable List<String> bookingCodeNotIn, @Param("statusEquals") @jakarta.annotation.Nullable String statusEquals, @Param("statusNotEquals") @jakarta.annotation.Nullable String statusNotEquals, @Param("statusSpecified") @jakarta.annotation.Nullable Boolean statusSpecified, @Param("statusIn") @jakarta.annotation.Nullable List<String> statusIn, @Param("statusNotIn") @jakarta.annotation.Nullable List<String> statusNotIn, @Param("quantityGreaterThan") @jakarta.annotation.Nullable Integer quantityGreaterThan, @Param("quantityLessThan") @jakarta.annotation.Nullable Integer quantityLessThan, @Param("quantityGreaterThanOrEqual") @jakarta.annotation.Nullable Integer quantityGreaterThanOrEqual, @Param("quantityLessThanOrEqual") @jakarta.annotation.Nullable Integer quantityLessThanOrEqual, @Param("quantityEquals") @jakarta.annotation.Nullable Integer quantityEquals, @Param("quantityNotEquals") @jakarta.annotation.Nullable Integer quantityNotEquals, @Param("quantitySpecified") @jakarta.annotation.Nullable Boolean quantitySpecified, @Param("quantityIn") @jakarta.annotation.Nullable List<Integer> quantityIn, @Param("quantityNotIn") @jakarta.annotation.Nullable List<Integer> quantityNotIn, @Param("totalAmountGreaterThan") @jakarta.annotation.Nullable BigDecimal totalAmountGreaterThan, @Param("totalAmountLessThan") @jakarta.annotation.Nullable BigDecimal totalAmountLessThan, @Param("totalAmountGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal totalAmountGreaterThanOrEqual, @Param("totalAmountLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal totalAmountLessThanOrEqual, @Param("totalAmountEquals") @jakarta.annotation.Nullable BigDecimal totalAmountEquals, @Param("totalAmountNotEquals") @jakarta.annotation.Nullable BigDecimal totalAmountNotEquals, @Param("totalAmountSpecified") @jakarta.annotation.Nullable Boolean totalAmountSpecified, @Param("totalAmountIn") @jakarta.annotation.Nullable List<BigDecimal> totalAmountIn, @Param("totalAmountNotIn") @jakarta.annotation.Nullable List<BigDecimal> totalAmountNotIn, @Param("createdTimeGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdTimeGreaterThan, @Param("createdTimeLessThan") @jakarta.annotation.Nullable OffsetDateTime createdTimeLessThan, @Param("createdTimeGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdTimeGreaterThanOrEqual, @Param("createdTimeLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdTimeLessThanOrEqual, @Param("createdTimeEquals") @jakarta.annotation.Nullable OffsetDateTime createdTimeEquals, @Param("createdTimeNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdTimeNotEquals, @Param("createdTimeSpecified") @jakarta.annotation.Nullable Boolean createdTimeSpecified, @Param("createdTimeIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdTimeIn, @Param("createdTimeNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdTimeNotIn, @Param("customerIdEquals") @jakarta.annotation.Nullable UUID customerIdEquals, @Param("customerIdNotEquals") @jakarta.annotation.Nullable UUID customerIdNotEquals, @Param("customerIdSpecified") @jakarta.annotation.Nullable Boolean customerIdSpecified, @Param("customerIdIn") @jakarta.annotation.Nullable List<UUID> customerIdIn, @Param("customerIdNotIn") @jakarta.annotation.Nullable List<UUID> customerIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("invoiceIdGreaterThan") @jakarta.annotation.Nullable Long invoiceIdGreaterThan, @Param("invoiceIdLessThan") @jakarta.annotation.Nullable Long invoiceIdLessThan, @Param("invoiceIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long invoiceIdGreaterThanOrEqual, @Param("invoiceIdLessThanOrEqual") @jakarta.annotation.Nullable Long invoiceIdLessThanOrEqual, @Param("invoiceIdEquals") @jakarta.annotation.Nullable Long invoiceIdEquals, @Param("invoiceIdNotEquals") @jakarta.annotation.Nullable Long invoiceIdNotEquals, @Param("invoiceIdSpecified") @jakarta.annotation.Nullable Boolean invoiceIdSpecified, @Param("invoiceIdIn") @jakarta.annotation.Nullable List<Long> invoiceIdIn, @Param("invoiceIdNotIn") @jakarta.annotation.Nullable List<Long> invoiceIdNotIn, @Param("paymentTransactionIdGreaterThan") @jakarta.annotation.Nullable Long paymentTransactionIdGreaterThan, @Param("paymentTransactionIdLessThan") @jakarta.annotation.Nullable Long paymentTransactionIdLessThan, @Param("paymentTransactionIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long paymentTransactionIdGreaterThanOrEqual, @Param("paymentTransactionIdLessThanOrEqual") @jakarta.annotation.Nullable Long paymentTransactionIdLessThanOrEqual, @Param("paymentTransactionIdEquals") @jakarta.annotation.Nullable Long paymentTransactionIdEquals, @Param("paymentTransactionIdNotEquals") @jakarta.annotation.Nullable Long paymentTransactionIdNotEquals, @Param("paymentTransactionIdSpecified") @jakarta.annotation.Nullable Boolean paymentTransactionIdSpecified, @Param("paymentTransactionIdIn") @jakarta.annotation.Nullable List<Long> paymentTransactionIdIn, @Param("paymentTransactionIdNotIn") @jakarta.annotation.Nullable List<Long> paymentTransactionIdNotIn, @Param("ticketsIdGreaterThan") @jakarta.annotation.Nullable Long ticketsIdGreaterThan, @Param("ticketsIdLessThan") @jakarta.annotation.Nullable Long ticketsIdLessThan, @Param("ticketsIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long ticketsIdGreaterThanOrEqual, @Param("ticketsIdLessThanOrEqual") @jakarta.annotation.Nullable Long ticketsIdLessThanOrEqual, @Param("ticketsIdEquals") @jakarta.annotation.Nullable Long ticketsIdEquals, @Param("ticketsIdNotEquals") @jakarta.annotation.Nullable Long ticketsIdNotEquals, @Param("ticketsIdSpecified") @jakarta.annotation.Nullable Boolean ticketsIdSpecified, @Param("ticketsIdIn") @jakarta.annotation.Nullable List<Long> ticketsIdIn, @Param("ticketsIdNotIn") @jakarta.annotation.Nullable List<Long> ticketsIdNotIn, @Param("appliedPromosIdGreaterThan") @jakarta.annotation.Nullable Long appliedPromosIdGreaterThan, @Param("appliedPromosIdLessThan") @jakarta.annotation.Nullable Long appliedPromosIdLessThan, @Param("appliedPromosIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long appliedPromosIdGreaterThanOrEqual, @Param("appliedPromosIdLessThanOrEqual") @jakarta.annotation.Nullable Long appliedPromosIdLessThanOrEqual, @Param("appliedPromosIdEquals") @jakarta.annotation.Nullable Long appliedPromosIdEquals, @Param("appliedPromosIdNotEquals") @jakarta.annotation.Nullable Long appliedPromosIdNotEquals, @Param("appliedPromosIdSpecified") @jakarta.annotation.Nullable Boolean appliedPromosIdSpecified, @Param("appliedPromosIdIn") @jakarta.annotation.Nullable List<Long> appliedPromosIdIn, @Param("appliedPromosIdNotIn") @jakarta.annotation.Nullable List<Long> appliedPromosIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct, @Param("page") @jakarta.annotation.Nullable Integer page, @Param("size") @jakarta.annotation.Nullable Integer size, @Param("sort") @jakarta.annotation.Nullable List<String> sort);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllBookings</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllBookingsQueryParams} class that allows for
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
   *   <li>bookingCodeContains -  (optional)</li>
   *   <li>bookingCodeDoesNotContain -  (optional)</li>
   *   <li>bookingCodeEquals -  (optional)</li>
   *   <li>bookingCodeNotEquals -  (optional)</li>
   *   <li>bookingCodeSpecified -  (optional)</li>
   *   <li>bookingCodeIn -  (optional)</li>
   *   <li>bookingCodeNotIn -  (optional)</li>
   *   <li>statusEquals -  (optional)</li>
   *   <li>statusNotEquals -  (optional)</li>
   *   <li>statusSpecified -  (optional)</li>
   *   <li>statusIn -  (optional)</li>
   *   <li>statusNotIn -  (optional)</li>
   *   <li>quantityGreaterThan -  (optional)</li>
   *   <li>quantityLessThan -  (optional)</li>
   *   <li>quantityGreaterThanOrEqual -  (optional)</li>
   *   <li>quantityLessThanOrEqual -  (optional)</li>
   *   <li>quantityEquals -  (optional)</li>
   *   <li>quantityNotEquals -  (optional)</li>
   *   <li>quantitySpecified -  (optional)</li>
   *   <li>quantityIn -  (optional)</li>
   *   <li>quantityNotIn -  (optional)</li>
   *   <li>totalAmountGreaterThan -  (optional)</li>
   *   <li>totalAmountLessThan -  (optional)</li>
   *   <li>totalAmountGreaterThanOrEqual -  (optional)</li>
   *   <li>totalAmountLessThanOrEqual -  (optional)</li>
   *   <li>totalAmountEquals -  (optional)</li>
   *   <li>totalAmountNotEquals -  (optional)</li>
   *   <li>totalAmountSpecified -  (optional)</li>
   *   <li>totalAmountIn -  (optional)</li>
   *   <li>totalAmountNotIn -  (optional)</li>
   *   <li>createdTimeGreaterThan -  (optional)</li>
   *   <li>createdTimeLessThan -  (optional)</li>
   *   <li>createdTimeGreaterThanOrEqual -  (optional)</li>
   *   <li>createdTimeLessThanOrEqual -  (optional)</li>
   *   <li>createdTimeEquals -  (optional)</li>
   *   <li>createdTimeNotEquals -  (optional)</li>
   *   <li>createdTimeSpecified -  (optional)</li>
   *   <li>createdTimeIn -  (optional)</li>
   *   <li>createdTimeNotIn -  (optional)</li>
   *   <li>customerIdEquals -  (optional)</li>
   *   <li>customerIdNotEquals -  (optional)</li>
   *   <li>customerIdSpecified -  (optional)</li>
   *   <li>customerIdIn -  (optional)</li>
   *   <li>customerIdNotIn -  (optional)</li>
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
   *   <li>invoiceIdGreaterThan -  (optional)</li>
   *   <li>invoiceIdLessThan -  (optional)</li>
   *   <li>invoiceIdGreaterThanOrEqual -  (optional)</li>
   *   <li>invoiceIdLessThanOrEqual -  (optional)</li>
   *   <li>invoiceIdEquals -  (optional)</li>
   *   <li>invoiceIdNotEquals -  (optional)</li>
   *   <li>invoiceIdSpecified -  (optional)</li>
   *   <li>invoiceIdIn -  (optional)</li>
   *   <li>invoiceIdNotIn -  (optional)</li>
   *   <li>paymentTransactionIdGreaterThan -  (optional)</li>
   *   <li>paymentTransactionIdLessThan -  (optional)</li>
   *   <li>paymentTransactionIdGreaterThanOrEqual -  (optional)</li>
   *   <li>paymentTransactionIdLessThanOrEqual -  (optional)</li>
   *   <li>paymentTransactionIdEquals -  (optional)</li>
   *   <li>paymentTransactionIdNotEquals -  (optional)</li>
   *   <li>paymentTransactionIdSpecified -  (optional)</li>
   *   <li>paymentTransactionIdIn -  (optional)</li>
   *   <li>paymentTransactionIdNotIn -  (optional)</li>
   *   <li>ticketsIdGreaterThan -  (optional)</li>
   *   <li>ticketsIdLessThan -  (optional)</li>
   *   <li>ticketsIdGreaterThanOrEqual -  (optional)</li>
   *   <li>ticketsIdLessThanOrEqual -  (optional)</li>
   *   <li>ticketsIdEquals -  (optional)</li>
   *   <li>ticketsIdNotEquals -  (optional)</li>
   *   <li>ticketsIdSpecified -  (optional)</li>
   *   <li>ticketsIdIn -  (optional)</li>
   *   <li>ticketsIdNotIn -  (optional)</li>
   *   <li>appliedPromosIdGreaterThan -  (optional)</li>
   *   <li>appliedPromosIdLessThan -  (optional)</li>
   *   <li>appliedPromosIdGreaterThanOrEqual -  (optional)</li>
   *   <li>appliedPromosIdLessThanOrEqual -  (optional)</li>
   *   <li>appliedPromosIdEquals -  (optional)</li>
   *   <li>appliedPromosIdNotEquals -  (optional)</li>
   *   <li>appliedPromosIdSpecified -  (optional)</li>
   *   <li>appliedPromosIdIn -  (optional)</li>
   *   <li>appliedPromosIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   <li>page - Zero-based page index (0..N) (optional, default to 0)</li>
   *   <li>size - The size of the page to be returned (optional, default to 20)</li>
   *   <li>sort - Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)</li>
   *   </ul>
   * @return List&lt;BookingDTO&gt;
   */
  @RequestLine("GET /api/bookings?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bookingCode.contains={bookingCodeContains}&bookingCode.doesNotContain={bookingCodeDoesNotContain}&bookingCode.equals={bookingCodeEquals}&bookingCode.notEquals={bookingCodeNotEquals}&bookingCode.specified={bookingCodeSpecified}&bookingCode.in={bookingCodeIn}&bookingCode.notIn={bookingCodeNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&quantity.greaterThan={quantityGreaterThan}&quantity.lessThan={quantityLessThan}&quantity.greaterThanOrEqual={quantityGreaterThanOrEqual}&quantity.lessThanOrEqual={quantityLessThanOrEqual}&quantity.equals={quantityEquals}&quantity.notEquals={quantityNotEquals}&quantity.specified={quantitySpecified}&quantity.in={quantityIn}&quantity.notIn={quantityNotIn}&totalAmount.greaterThan={totalAmountGreaterThan}&totalAmount.lessThan={totalAmountLessThan}&totalAmount.greaterThanOrEqual={totalAmountGreaterThanOrEqual}&totalAmount.lessThanOrEqual={totalAmountLessThanOrEqual}&totalAmount.equals={totalAmountEquals}&totalAmount.notEquals={totalAmountNotEquals}&totalAmount.specified={totalAmountSpecified}&totalAmount.in={totalAmountIn}&totalAmount.notIn={totalAmountNotIn}&createdTime.greaterThan={createdTimeGreaterThan}&createdTime.lessThan={createdTimeLessThan}&createdTime.greaterThanOrEqual={createdTimeGreaterThanOrEqual}&createdTime.lessThanOrEqual={createdTimeLessThanOrEqual}&createdTime.equals={createdTimeEquals}&createdTime.notEquals={createdTimeNotEquals}&createdTime.specified={createdTimeSpecified}&createdTime.in={createdTimeIn}&createdTime.notIn={createdTimeNotIn}&customerId.equals={customerIdEquals}&customerId.notEquals={customerIdNotEquals}&customerId.specified={customerIdSpecified}&customerId.in={customerIdIn}&customerId.notIn={customerIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&invoiceId.greaterThan={invoiceIdGreaterThan}&invoiceId.lessThan={invoiceIdLessThan}&invoiceId.greaterThanOrEqual={invoiceIdGreaterThanOrEqual}&invoiceId.lessThanOrEqual={invoiceIdLessThanOrEqual}&invoiceId.equals={invoiceIdEquals}&invoiceId.notEquals={invoiceIdNotEquals}&invoiceId.specified={invoiceIdSpecified}&invoiceId.in={invoiceIdIn}&invoiceId.notIn={invoiceIdNotIn}&paymentTransactionId.greaterThan={paymentTransactionIdGreaterThan}&paymentTransactionId.lessThan={paymentTransactionIdLessThan}&paymentTransactionId.greaterThanOrEqual={paymentTransactionIdGreaterThanOrEqual}&paymentTransactionId.lessThanOrEqual={paymentTransactionIdLessThanOrEqual}&paymentTransactionId.equals={paymentTransactionIdEquals}&paymentTransactionId.notEquals={paymentTransactionIdNotEquals}&paymentTransactionId.specified={paymentTransactionIdSpecified}&paymentTransactionId.in={paymentTransactionIdIn}&paymentTransactionId.notIn={paymentTransactionIdNotIn}&ticketsId.greaterThan={ticketsIdGreaterThan}&ticketsId.lessThan={ticketsIdLessThan}&ticketsId.greaterThanOrEqual={ticketsIdGreaterThanOrEqual}&ticketsId.lessThanOrEqual={ticketsIdLessThanOrEqual}&ticketsId.equals={ticketsIdEquals}&ticketsId.notEquals={ticketsIdNotEquals}&ticketsId.specified={ticketsIdSpecified}&ticketsId.in={ticketsIdIn}&ticketsId.notIn={ticketsIdNotIn}&appliedPromosId.greaterThan={appliedPromosIdGreaterThan}&appliedPromosId.lessThan={appliedPromosIdLessThan}&appliedPromosId.greaterThanOrEqual={appliedPromosIdGreaterThanOrEqual}&appliedPromosId.lessThanOrEqual={appliedPromosIdLessThanOrEqual}&appliedPromosId.equals={appliedPromosIdEquals}&appliedPromosId.notEquals={appliedPromosIdNotEquals}&appliedPromosId.specified={appliedPromosIdSpecified}&appliedPromosId.in={appliedPromosIdIn}&appliedPromosId.notIn={appliedPromosIdNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
  @Headers({
  "Accept: */*",
  })
  List<BookingDTO> getAllBookings(@QueryMap(encoded=true) GetAllBookingsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllBookings</code> that receives the query parameters as a map,
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
          *   <li>bookingCodeContains -  (optional)</li>
          *   <li>bookingCodeDoesNotContain -  (optional)</li>
          *   <li>bookingCodeEquals -  (optional)</li>
          *   <li>bookingCodeNotEquals -  (optional)</li>
          *   <li>bookingCodeSpecified -  (optional)</li>
          *   <li>bookingCodeIn -  (optional)</li>
          *   <li>bookingCodeNotIn -  (optional)</li>
          *   <li>statusEquals -  (optional)</li>
          *   <li>statusNotEquals -  (optional)</li>
          *   <li>statusSpecified -  (optional)</li>
          *   <li>statusIn -  (optional)</li>
          *   <li>statusNotIn -  (optional)</li>
          *   <li>quantityGreaterThan -  (optional)</li>
          *   <li>quantityLessThan -  (optional)</li>
          *   <li>quantityGreaterThanOrEqual -  (optional)</li>
          *   <li>quantityLessThanOrEqual -  (optional)</li>
          *   <li>quantityEquals -  (optional)</li>
          *   <li>quantityNotEquals -  (optional)</li>
          *   <li>quantitySpecified -  (optional)</li>
          *   <li>quantityIn -  (optional)</li>
          *   <li>quantityNotIn -  (optional)</li>
          *   <li>totalAmountGreaterThan -  (optional)</li>
          *   <li>totalAmountLessThan -  (optional)</li>
          *   <li>totalAmountGreaterThanOrEqual -  (optional)</li>
          *   <li>totalAmountLessThanOrEqual -  (optional)</li>
          *   <li>totalAmountEquals -  (optional)</li>
          *   <li>totalAmountNotEquals -  (optional)</li>
          *   <li>totalAmountSpecified -  (optional)</li>
          *   <li>totalAmountIn -  (optional)</li>
          *   <li>totalAmountNotIn -  (optional)</li>
          *   <li>createdTimeGreaterThan -  (optional)</li>
          *   <li>createdTimeLessThan -  (optional)</li>
          *   <li>createdTimeGreaterThanOrEqual -  (optional)</li>
          *   <li>createdTimeLessThanOrEqual -  (optional)</li>
          *   <li>createdTimeEquals -  (optional)</li>
          *   <li>createdTimeNotEquals -  (optional)</li>
          *   <li>createdTimeSpecified -  (optional)</li>
          *   <li>createdTimeIn -  (optional)</li>
          *   <li>createdTimeNotIn -  (optional)</li>
          *   <li>customerIdEquals -  (optional)</li>
          *   <li>customerIdNotEquals -  (optional)</li>
          *   <li>customerIdSpecified -  (optional)</li>
          *   <li>customerIdIn -  (optional)</li>
          *   <li>customerIdNotIn -  (optional)</li>
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
          *   <li>invoiceIdGreaterThan -  (optional)</li>
          *   <li>invoiceIdLessThan -  (optional)</li>
          *   <li>invoiceIdGreaterThanOrEqual -  (optional)</li>
          *   <li>invoiceIdLessThanOrEqual -  (optional)</li>
          *   <li>invoiceIdEquals -  (optional)</li>
          *   <li>invoiceIdNotEquals -  (optional)</li>
          *   <li>invoiceIdSpecified -  (optional)</li>
          *   <li>invoiceIdIn -  (optional)</li>
          *   <li>invoiceIdNotIn -  (optional)</li>
          *   <li>paymentTransactionIdGreaterThan -  (optional)</li>
          *   <li>paymentTransactionIdLessThan -  (optional)</li>
          *   <li>paymentTransactionIdGreaterThanOrEqual -  (optional)</li>
          *   <li>paymentTransactionIdLessThanOrEqual -  (optional)</li>
          *   <li>paymentTransactionIdEquals -  (optional)</li>
          *   <li>paymentTransactionIdNotEquals -  (optional)</li>
          *   <li>paymentTransactionIdSpecified -  (optional)</li>
          *   <li>paymentTransactionIdIn -  (optional)</li>
          *   <li>paymentTransactionIdNotIn -  (optional)</li>
          *   <li>ticketsIdGreaterThan -  (optional)</li>
          *   <li>ticketsIdLessThan -  (optional)</li>
          *   <li>ticketsIdGreaterThanOrEqual -  (optional)</li>
          *   <li>ticketsIdLessThanOrEqual -  (optional)</li>
          *   <li>ticketsIdEquals -  (optional)</li>
          *   <li>ticketsIdNotEquals -  (optional)</li>
          *   <li>ticketsIdSpecified -  (optional)</li>
          *   <li>ticketsIdIn -  (optional)</li>
          *   <li>ticketsIdNotIn -  (optional)</li>
          *   <li>appliedPromosIdGreaterThan -  (optional)</li>
          *   <li>appliedPromosIdLessThan -  (optional)</li>
          *   <li>appliedPromosIdGreaterThanOrEqual -  (optional)</li>
          *   <li>appliedPromosIdLessThanOrEqual -  (optional)</li>
          *   <li>appliedPromosIdEquals -  (optional)</li>
          *   <li>appliedPromosIdNotEquals -  (optional)</li>
          *   <li>appliedPromosIdSpecified -  (optional)</li>
          *   <li>appliedPromosIdIn -  (optional)</li>
          *   <li>appliedPromosIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
          *   <li>page - Zero-based page index (0..N) (optional, default to 0)</li>
          *   <li>size - The size of the page to be returned (optional, default to 20)</li>
          *   <li>sort - Sorting criteria in the format: property,(asc|desc). Default sort order is ascending. Multiple sort criteria are supported. (optional)</li>
      *   </ul>
          * @return List&lt;BookingDTO&gt;
      */
      @RequestLine("GET /api/bookings?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&bookingCode.contains={bookingCodeContains}&bookingCode.doesNotContain={bookingCodeDoesNotContain}&bookingCode.equals={bookingCodeEquals}&bookingCode.notEquals={bookingCodeNotEquals}&bookingCode.specified={bookingCodeSpecified}&bookingCode.in={bookingCodeIn}&bookingCode.notIn={bookingCodeNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&quantity.greaterThan={quantityGreaterThan}&quantity.lessThan={quantityLessThan}&quantity.greaterThanOrEqual={quantityGreaterThanOrEqual}&quantity.lessThanOrEqual={quantityLessThanOrEqual}&quantity.equals={quantityEquals}&quantity.notEquals={quantityNotEquals}&quantity.specified={quantitySpecified}&quantity.in={quantityIn}&quantity.notIn={quantityNotIn}&totalAmount.greaterThan={totalAmountGreaterThan}&totalAmount.lessThan={totalAmountLessThan}&totalAmount.greaterThanOrEqual={totalAmountGreaterThanOrEqual}&totalAmount.lessThanOrEqual={totalAmountLessThanOrEqual}&totalAmount.equals={totalAmountEquals}&totalAmount.notEquals={totalAmountNotEquals}&totalAmount.specified={totalAmountSpecified}&totalAmount.in={totalAmountIn}&totalAmount.notIn={totalAmountNotIn}&createdTime.greaterThan={createdTimeGreaterThan}&createdTime.lessThan={createdTimeLessThan}&createdTime.greaterThanOrEqual={createdTimeGreaterThanOrEqual}&createdTime.lessThanOrEqual={createdTimeLessThanOrEqual}&createdTime.equals={createdTimeEquals}&createdTime.notEquals={createdTimeNotEquals}&createdTime.specified={createdTimeSpecified}&createdTime.in={createdTimeIn}&createdTime.notIn={createdTimeNotIn}&customerId.equals={customerIdEquals}&customerId.notEquals={customerIdNotEquals}&customerId.specified={customerIdSpecified}&customerId.in={customerIdIn}&customerId.notIn={customerIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&invoiceId.greaterThan={invoiceIdGreaterThan}&invoiceId.lessThan={invoiceIdLessThan}&invoiceId.greaterThanOrEqual={invoiceIdGreaterThanOrEqual}&invoiceId.lessThanOrEqual={invoiceIdLessThanOrEqual}&invoiceId.equals={invoiceIdEquals}&invoiceId.notEquals={invoiceIdNotEquals}&invoiceId.specified={invoiceIdSpecified}&invoiceId.in={invoiceIdIn}&invoiceId.notIn={invoiceIdNotIn}&paymentTransactionId.greaterThan={paymentTransactionIdGreaterThan}&paymentTransactionId.lessThan={paymentTransactionIdLessThan}&paymentTransactionId.greaterThanOrEqual={paymentTransactionIdGreaterThanOrEqual}&paymentTransactionId.lessThanOrEqual={paymentTransactionIdLessThanOrEqual}&paymentTransactionId.equals={paymentTransactionIdEquals}&paymentTransactionId.notEquals={paymentTransactionIdNotEquals}&paymentTransactionId.specified={paymentTransactionIdSpecified}&paymentTransactionId.in={paymentTransactionIdIn}&paymentTransactionId.notIn={paymentTransactionIdNotIn}&ticketsId.greaterThan={ticketsIdGreaterThan}&ticketsId.lessThan={ticketsIdLessThan}&ticketsId.greaterThanOrEqual={ticketsIdGreaterThanOrEqual}&ticketsId.lessThanOrEqual={ticketsIdLessThanOrEqual}&ticketsId.equals={ticketsIdEquals}&ticketsId.notEquals={ticketsIdNotEquals}&ticketsId.specified={ticketsIdSpecified}&ticketsId.in={ticketsIdIn}&ticketsId.notIn={ticketsIdNotIn}&appliedPromosId.greaterThan={appliedPromosIdGreaterThan}&appliedPromosId.lessThan={appliedPromosIdLessThan}&appliedPromosId.greaterThanOrEqual={appliedPromosIdGreaterThanOrEqual}&appliedPromosId.lessThanOrEqual={appliedPromosIdLessThanOrEqual}&appliedPromosId.equals={appliedPromosIdEquals}&appliedPromosId.notEquals={appliedPromosIdNotEquals}&appliedPromosId.specified={appliedPromosIdSpecified}&appliedPromosId.in={appliedPromosIdIn}&appliedPromosId.notIn={appliedPromosIdNotIn}&distinct={distinct}&page={page}&size={size}&sort={sort}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<BookingDTO>> getAllBookingsWithHttpInfo(@QueryMap(encoded=true) GetAllBookingsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllBookings</code> method in a fluent style.
   */
  public static class GetAllBookingsQueryParams extends HashMap<String, Object> {
    public GetAllBookingsQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBookingsQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBookingsQueryParams bookingCodeContains(@jakarta.annotation.Nullable final String value) {
      put("bookingCode.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams bookingCodeDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("bookingCode.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams bookingCodeEquals(@jakarta.annotation.Nullable final String value) {
      put("bookingCode.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams bookingCodeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("bookingCode.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams bookingCodeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("bookingCode.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams bookingCodeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("bookingCode.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBookingsQueryParams bookingCodeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("bookingCode.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBookingsQueryParams statusEquals(@jakarta.annotation.Nullable final String value) {
      put("status.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams statusNotEquals(@jakarta.annotation.Nullable final String value) {
      put("status.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams statusSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("status.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams statusIn(@jakarta.annotation.Nullable final List<String> value) {
      put("status.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBookingsQueryParams statusNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("status.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBookingsQueryParams quantityGreaterThan(@jakarta.annotation.Nullable final Integer value) {
      put("quantity.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams quantityLessThan(@jakarta.annotation.Nullable final Integer value) {
      put("quantity.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams quantityGreaterThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("quantity.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams quantityLessThanOrEqual(@jakarta.annotation.Nullable final Integer value) {
      put("quantity.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams quantityEquals(@jakarta.annotation.Nullable final Integer value) {
      put("quantity.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams quantityNotEquals(@jakarta.annotation.Nullable final Integer value) {
      put("quantity.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams quantitySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("quantity.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams quantityIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("quantity.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBookingsQueryParams quantityNotIn(@jakarta.annotation.Nullable final List<Integer> value) {
      put("quantity.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBookingsQueryParams totalAmountGreaterThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("totalAmount.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams totalAmountLessThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("totalAmount.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams totalAmountGreaterThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("totalAmount.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams totalAmountLessThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("totalAmount.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams totalAmountEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("totalAmount.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams totalAmountNotEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("totalAmount.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams totalAmountSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("totalAmount.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams totalAmountIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("totalAmount.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBookingsQueryParams totalAmountNotIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("totalAmount.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBookingsQueryParams createdTimeGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdTime.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams createdTimeLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdTime.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams createdTimeGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdTime.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams createdTimeLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdTime.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams createdTimeEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdTime.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams createdTimeNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdTime.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams createdTimeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdTime.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams createdTimeIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdTime.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBookingsQueryParams createdTimeNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdTime.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBookingsQueryParams customerIdEquals(@jakarta.annotation.Nullable final UUID value) {
      put("customerId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams customerIdNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("customerId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams customerIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("customerId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams customerIdIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("customerId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBookingsQueryParams customerIdNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("customerId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBookingsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBookingsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBookingsQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBookingsQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBookingsQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBookingsQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBookingsQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBookingsQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBookingsQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBookingsQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBookingsQueryParams invoiceIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("invoiceId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams invoiceIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("invoiceId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams invoiceIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("invoiceId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams invoiceIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("invoiceId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams invoiceIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("invoiceId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams invoiceIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("invoiceId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams invoiceIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("invoiceId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams invoiceIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("invoiceId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBookingsQueryParams invoiceIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("invoiceId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBookingsQueryParams paymentTransactionIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("paymentTransactionId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams paymentTransactionIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("paymentTransactionId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams paymentTransactionIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("paymentTransactionId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams paymentTransactionIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("paymentTransactionId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams paymentTransactionIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("paymentTransactionId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams paymentTransactionIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("paymentTransactionId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams paymentTransactionIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("paymentTransactionId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams paymentTransactionIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("paymentTransactionId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBookingsQueryParams paymentTransactionIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("paymentTransactionId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBookingsQueryParams ticketsIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("ticketsId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams ticketsIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("ticketsId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams ticketsIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("ticketsId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams ticketsIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("ticketsId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams ticketsIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("ticketsId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams ticketsIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("ticketsId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams ticketsIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("ticketsId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams ticketsIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("ticketsId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBookingsQueryParams ticketsIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("ticketsId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBookingsQueryParams appliedPromosIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("appliedPromosId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams appliedPromosIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("appliedPromosId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams appliedPromosIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("appliedPromosId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams appliedPromosIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("appliedPromosId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams appliedPromosIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("appliedPromosId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams appliedPromosIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("appliedPromosId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams appliedPromosIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("appliedPromosId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams appliedPromosIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("appliedPromosId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBookingsQueryParams appliedPromosIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("appliedPromosId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllBookingsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams page(@jakarta.annotation.Nullable final Integer value) {
      put("page", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams size(@jakarta.annotation.Nullable final Integer value) {
      put("size", EncodingUtils.encode(value));
      return this;
    }
    public GetAllBookingsQueryParams sort(@jakarta.annotation.Nullable final List<String> value) {
      put("sort", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @return BookingDTO
   */
  @RequestLine("GET /api/bookings/{id}")
  @Headers({
    "Accept: */*",
  })
  BookingDTO getBooking(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>getBooking</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/bookings/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<BookingDTO> getBookingWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param id  (required)
   * @param bookingDTO  (required)
   * @return BookingDTO
   */
  @RequestLine("PATCH /api/bookings/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  BookingDTO partialUpdateBooking(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull BookingDTO bookingDTO);

  /**
   * 
   * Similar to <code>partialUpdateBooking</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param bookingDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /api/bookings/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<BookingDTO> partialUpdateBookingWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull BookingDTO bookingDTO);



  /**
   * 
   * 
   * @param id  (required)
   * @param bookingDTO  (required)
   * @return BookingDTO
   */
  @RequestLine("PUT /api/bookings/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  BookingDTO updateBooking(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull BookingDTO bookingDTO);

  /**
   * 
   * Similar to <code>updateBooking</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param bookingDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/bookings/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<BookingDTO> updateBookingWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull BookingDTO bookingDTO);


}
