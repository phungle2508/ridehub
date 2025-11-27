package com.ridehub.msbooking.client.api;

import com.ridehub.msbooking.client.invoker.ApiClient;
import com.ridehub.msbooking.client.invoker.EncodingUtils;
import com.ridehub.msbooking.client.model.ApiResponse;

import java.math.BigDecimal;
import com.ridehub.msbooking.client.model.InvoiceDTO;
import java.time.OffsetDateTime;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface InvoiceResourceMsbookingApi extends ApiClient.Api {


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
   * @param invoiceNoContains  (optional)
   * @param invoiceNoDoesNotContain  (optional)
   * @param invoiceNoEquals  (optional)
   * @param invoiceNoNotEquals  (optional)
   * @param invoiceNoSpecified  (optional)
   * @param invoiceNoIn  (optional)
   * @param invoiceNoNotIn  (optional)
   * @param issuedAtGreaterThan  (optional)
   * @param issuedAtLessThan  (optional)
   * @param issuedAtGreaterThanOrEqual  (optional)
   * @param issuedAtLessThanOrEqual  (optional)
   * @param issuedAtEquals  (optional)
   * @param issuedAtNotEquals  (optional)
   * @param issuedAtSpecified  (optional)
   * @param issuedAtIn  (optional)
   * @param issuedAtNotIn  (optional)
   * @param grossAmountGreaterThan  (optional)
   * @param grossAmountLessThan  (optional)
   * @param grossAmountGreaterThanOrEqual  (optional)
   * @param grossAmountLessThanOrEqual  (optional)
   * @param grossAmountEquals  (optional)
   * @param grossAmountNotEquals  (optional)
   * @param grossAmountSpecified  (optional)
   * @param grossAmountIn  (optional)
   * @param grossAmountNotIn  (optional)
   * @param vatAmountGreaterThan  (optional)
   * @param vatAmountLessThan  (optional)
   * @param vatAmountGreaterThanOrEqual  (optional)
   * @param vatAmountLessThanOrEqual  (optional)
   * @param vatAmountEquals  (optional)
   * @param vatAmountNotEquals  (optional)
   * @param vatAmountSpecified  (optional)
   * @param vatAmountIn  (optional)
   * @param vatAmountNotIn  (optional)
   * @param netAmountGreaterThan  (optional)
   * @param netAmountLessThan  (optional)
   * @param netAmountGreaterThanOrEqual  (optional)
   * @param netAmountLessThanOrEqual  (optional)
   * @param netAmountEquals  (optional)
   * @param netAmountNotEquals  (optional)
   * @param netAmountSpecified  (optional)
   * @param netAmountIn  (optional)
   * @param netAmountNotIn  (optional)
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
  @RequestLine("GET /api/invoices/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&invoiceNo.contains={invoiceNoContains}&invoiceNo.doesNotContain={invoiceNoDoesNotContain}&invoiceNo.equals={invoiceNoEquals}&invoiceNo.notEquals={invoiceNoNotEquals}&invoiceNo.specified={invoiceNoSpecified}&invoiceNo.in={invoiceNoIn}&invoiceNo.notIn={invoiceNoNotIn}&issuedAt.greaterThan={issuedAtGreaterThan}&issuedAt.lessThan={issuedAtLessThan}&issuedAt.greaterThanOrEqual={issuedAtGreaterThanOrEqual}&issuedAt.lessThanOrEqual={issuedAtLessThanOrEqual}&issuedAt.equals={issuedAtEquals}&issuedAt.notEquals={issuedAtNotEquals}&issuedAt.specified={issuedAtSpecified}&issuedAt.in={issuedAtIn}&issuedAt.notIn={issuedAtNotIn}&grossAmount.greaterThan={grossAmountGreaterThan}&grossAmount.lessThan={grossAmountLessThan}&grossAmount.greaterThanOrEqual={grossAmountGreaterThanOrEqual}&grossAmount.lessThanOrEqual={grossAmountLessThanOrEqual}&grossAmount.equals={grossAmountEquals}&grossAmount.notEquals={grossAmountNotEquals}&grossAmount.specified={grossAmountSpecified}&grossAmount.in={grossAmountIn}&grossAmount.notIn={grossAmountNotIn}&vatAmount.greaterThan={vatAmountGreaterThan}&vatAmount.lessThan={vatAmountLessThan}&vatAmount.greaterThanOrEqual={vatAmountGreaterThanOrEqual}&vatAmount.lessThanOrEqual={vatAmountLessThanOrEqual}&vatAmount.equals={vatAmountEquals}&vatAmount.notEquals={vatAmountNotEquals}&vatAmount.specified={vatAmountSpecified}&vatAmount.in={vatAmountIn}&vatAmount.notIn={vatAmountNotIn}&netAmount.greaterThan={netAmountGreaterThan}&netAmount.lessThan={netAmountLessThan}&netAmount.greaterThanOrEqual={netAmountGreaterThanOrEqual}&netAmount.lessThanOrEqual={netAmountLessThanOrEqual}&netAmount.equals={netAmountEquals}&netAmount.notEquals={netAmountNotEquals}&netAmount.specified={netAmountSpecified}&netAmount.in={netAmountIn}&netAmount.notIn={netAmountNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  Long countInvoices(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("invoiceNoContains") @jakarta.annotation.Nullable String invoiceNoContains, @Param("invoiceNoDoesNotContain") @jakarta.annotation.Nullable String invoiceNoDoesNotContain, @Param("invoiceNoEquals") @jakarta.annotation.Nullable String invoiceNoEquals, @Param("invoiceNoNotEquals") @jakarta.annotation.Nullable String invoiceNoNotEquals, @Param("invoiceNoSpecified") @jakarta.annotation.Nullable Boolean invoiceNoSpecified, @Param("invoiceNoIn") @jakarta.annotation.Nullable List<String> invoiceNoIn, @Param("invoiceNoNotIn") @jakarta.annotation.Nullable List<String> invoiceNoNotIn, @Param("issuedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime issuedAtGreaterThan, @Param("issuedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime issuedAtLessThan, @Param("issuedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime issuedAtGreaterThanOrEqual, @Param("issuedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime issuedAtLessThanOrEqual, @Param("issuedAtEquals") @jakarta.annotation.Nullable OffsetDateTime issuedAtEquals, @Param("issuedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime issuedAtNotEquals, @Param("issuedAtSpecified") @jakarta.annotation.Nullable Boolean issuedAtSpecified, @Param("issuedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> issuedAtIn, @Param("issuedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> issuedAtNotIn, @Param("grossAmountGreaterThan") @jakarta.annotation.Nullable BigDecimal grossAmountGreaterThan, @Param("grossAmountLessThan") @jakarta.annotation.Nullable BigDecimal grossAmountLessThan, @Param("grossAmountGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal grossAmountGreaterThanOrEqual, @Param("grossAmountLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal grossAmountLessThanOrEqual, @Param("grossAmountEquals") @jakarta.annotation.Nullable BigDecimal grossAmountEquals, @Param("grossAmountNotEquals") @jakarta.annotation.Nullable BigDecimal grossAmountNotEquals, @Param("grossAmountSpecified") @jakarta.annotation.Nullable Boolean grossAmountSpecified, @Param("grossAmountIn") @jakarta.annotation.Nullable List<BigDecimal> grossAmountIn, @Param("grossAmountNotIn") @jakarta.annotation.Nullable List<BigDecimal> grossAmountNotIn, @Param("vatAmountGreaterThan") @jakarta.annotation.Nullable BigDecimal vatAmountGreaterThan, @Param("vatAmountLessThan") @jakarta.annotation.Nullable BigDecimal vatAmountLessThan, @Param("vatAmountGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal vatAmountGreaterThanOrEqual, @Param("vatAmountLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal vatAmountLessThanOrEqual, @Param("vatAmountEquals") @jakarta.annotation.Nullable BigDecimal vatAmountEquals, @Param("vatAmountNotEquals") @jakarta.annotation.Nullable BigDecimal vatAmountNotEquals, @Param("vatAmountSpecified") @jakarta.annotation.Nullable Boolean vatAmountSpecified, @Param("vatAmountIn") @jakarta.annotation.Nullable List<BigDecimal> vatAmountIn, @Param("vatAmountNotIn") @jakarta.annotation.Nullable List<BigDecimal> vatAmountNotIn, @Param("netAmountGreaterThan") @jakarta.annotation.Nullable BigDecimal netAmountGreaterThan, @Param("netAmountLessThan") @jakarta.annotation.Nullable BigDecimal netAmountLessThan, @Param("netAmountGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal netAmountGreaterThanOrEqual, @Param("netAmountLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal netAmountLessThanOrEqual, @Param("netAmountEquals") @jakarta.annotation.Nullable BigDecimal netAmountEquals, @Param("netAmountNotEquals") @jakarta.annotation.Nullable BigDecimal netAmountNotEquals, @Param("netAmountSpecified") @jakarta.annotation.Nullable Boolean netAmountSpecified, @Param("netAmountIn") @jakarta.annotation.Nullable List<BigDecimal> netAmountIn, @Param("netAmountNotIn") @jakarta.annotation.Nullable List<BigDecimal> netAmountNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("bookingIdGreaterThan") @jakarta.annotation.Nullable Long bookingIdGreaterThan, @Param("bookingIdLessThan") @jakarta.annotation.Nullable Long bookingIdLessThan, @Param("bookingIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long bookingIdGreaterThanOrEqual, @Param("bookingIdLessThanOrEqual") @jakarta.annotation.Nullable Long bookingIdLessThanOrEqual, @Param("bookingIdEquals") @jakarta.annotation.Nullable Long bookingIdEquals, @Param("bookingIdNotEquals") @jakarta.annotation.Nullable Long bookingIdNotEquals, @Param("bookingIdSpecified") @jakarta.annotation.Nullable Boolean bookingIdSpecified, @Param("bookingIdIn") @jakarta.annotation.Nullable List<Long> bookingIdIn, @Param("bookingIdNotIn") @jakarta.annotation.Nullable List<Long> bookingIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>countInvoices</code> but it also returns the http response headers .
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
   * @param invoiceNoContains  (optional)
   * @param invoiceNoDoesNotContain  (optional)
   * @param invoiceNoEquals  (optional)
   * @param invoiceNoNotEquals  (optional)
   * @param invoiceNoSpecified  (optional)
   * @param invoiceNoIn  (optional)
   * @param invoiceNoNotIn  (optional)
   * @param issuedAtGreaterThan  (optional)
   * @param issuedAtLessThan  (optional)
   * @param issuedAtGreaterThanOrEqual  (optional)
   * @param issuedAtLessThanOrEqual  (optional)
   * @param issuedAtEquals  (optional)
   * @param issuedAtNotEquals  (optional)
   * @param issuedAtSpecified  (optional)
   * @param issuedAtIn  (optional)
   * @param issuedAtNotIn  (optional)
   * @param grossAmountGreaterThan  (optional)
   * @param grossAmountLessThan  (optional)
   * @param grossAmountGreaterThanOrEqual  (optional)
   * @param grossAmountLessThanOrEqual  (optional)
   * @param grossAmountEquals  (optional)
   * @param grossAmountNotEquals  (optional)
   * @param grossAmountSpecified  (optional)
   * @param grossAmountIn  (optional)
   * @param grossAmountNotIn  (optional)
   * @param vatAmountGreaterThan  (optional)
   * @param vatAmountLessThan  (optional)
   * @param vatAmountGreaterThanOrEqual  (optional)
   * @param vatAmountLessThanOrEqual  (optional)
   * @param vatAmountEquals  (optional)
   * @param vatAmountNotEquals  (optional)
   * @param vatAmountSpecified  (optional)
   * @param vatAmountIn  (optional)
   * @param vatAmountNotIn  (optional)
   * @param netAmountGreaterThan  (optional)
   * @param netAmountLessThan  (optional)
   * @param netAmountGreaterThanOrEqual  (optional)
   * @param netAmountLessThanOrEqual  (optional)
   * @param netAmountEquals  (optional)
   * @param netAmountNotEquals  (optional)
   * @param netAmountSpecified  (optional)
   * @param netAmountIn  (optional)
   * @param netAmountNotIn  (optional)
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
  @RequestLine("GET /api/invoices/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&invoiceNo.contains={invoiceNoContains}&invoiceNo.doesNotContain={invoiceNoDoesNotContain}&invoiceNo.equals={invoiceNoEquals}&invoiceNo.notEquals={invoiceNoNotEquals}&invoiceNo.specified={invoiceNoSpecified}&invoiceNo.in={invoiceNoIn}&invoiceNo.notIn={invoiceNoNotIn}&issuedAt.greaterThan={issuedAtGreaterThan}&issuedAt.lessThan={issuedAtLessThan}&issuedAt.greaterThanOrEqual={issuedAtGreaterThanOrEqual}&issuedAt.lessThanOrEqual={issuedAtLessThanOrEqual}&issuedAt.equals={issuedAtEquals}&issuedAt.notEquals={issuedAtNotEquals}&issuedAt.specified={issuedAtSpecified}&issuedAt.in={issuedAtIn}&issuedAt.notIn={issuedAtNotIn}&grossAmount.greaterThan={grossAmountGreaterThan}&grossAmount.lessThan={grossAmountLessThan}&grossAmount.greaterThanOrEqual={grossAmountGreaterThanOrEqual}&grossAmount.lessThanOrEqual={grossAmountLessThanOrEqual}&grossAmount.equals={grossAmountEquals}&grossAmount.notEquals={grossAmountNotEquals}&grossAmount.specified={grossAmountSpecified}&grossAmount.in={grossAmountIn}&grossAmount.notIn={grossAmountNotIn}&vatAmount.greaterThan={vatAmountGreaterThan}&vatAmount.lessThan={vatAmountLessThan}&vatAmount.greaterThanOrEqual={vatAmountGreaterThanOrEqual}&vatAmount.lessThanOrEqual={vatAmountLessThanOrEqual}&vatAmount.equals={vatAmountEquals}&vatAmount.notEquals={vatAmountNotEquals}&vatAmount.specified={vatAmountSpecified}&vatAmount.in={vatAmountIn}&vatAmount.notIn={vatAmountNotIn}&netAmount.greaterThan={netAmountGreaterThan}&netAmount.lessThan={netAmountLessThan}&netAmount.greaterThanOrEqual={netAmountGreaterThanOrEqual}&netAmount.lessThanOrEqual={netAmountLessThanOrEqual}&netAmount.equals={netAmountEquals}&netAmount.notEquals={netAmountNotEquals}&netAmount.specified={netAmountSpecified}&netAmount.in={netAmountIn}&netAmount.notIn={netAmountNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Long> countInvoicesWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("invoiceNoContains") @jakarta.annotation.Nullable String invoiceNoContains, @Param("invoiceNoDoesNotContain") @jakarta.annotation.Nullable String invoiceNoDoesNotContain, @Param("invoiceNoEquals") @jakarta.annotation.Nullable String invoiceNoEquals, @Param("invoiceNoNotEquals") @jakarta.annotation.Nullable String invoiceNoNotEquals, @Param("invoiceNoSpecified") @jakarta.annotation.Nullable Boolean invoiceNoSpecified, @Param("invoiceNoIn") @jakarta.annotation.Nullable List<String> invoiceNoIn, @Param("invoiceNoNotIn") @jakarta.annotation.Nullable List<String> invoiceNoNotIn, @Param("issuedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime issuedAtGreaterThan, @Param("issuedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime issuedAtLessThan, @Param("issuedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime issuedAtGreaterThanOrEqual, @Param("issuedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime issuedAtLessThanOrEqual, @Param("issuedAtEquals") @jakarta.annotation.Nullable OffsetDateTime issuedAtEquals, @Param("issuedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime issuedAtNotEquals, @Param("issuedAtSpecified") @jakarta.annotation.Nullable Boolean issuedAtSpecified, @Param("issuedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> issuedAtIn, @Param("issuedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> issuedAtNotIn, @Param("grossAmountGreaterThan") @jakarta.annotation.Nullable BigDecimal grossAmountGreaterThan, @Param("grossAmountLessThan") @jakarta.annotation.Nullable BigDecimal grossAmountLessThan, @Param("grossAmountGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal grossAmountGreaterThanOrEqual, @Param("grossAmountLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal grossAmountLessThanOrEqual, @Param("grossAmountEquals") @jakarta.annotation.Nullable BigDecimal grossAmountEquals, @Param("grossAmountNotEquals") @jakarta.annotation.Nullable BigDecimal grossAmountNotEquals, @Param("grossAmountSpecified") @jakarta.annotation.Nullable Boolean grossAmountSpecified, @Param("grossAmountIn") @jakarta.annotation.Nullable List<BigDecimal> grossAmountIn, @Param("grossAmountNotIn") @jakarta.annotation.Nullable List<BigDecimal> grossAmountNotIn, @Param("vatAmountGreaterThan") @jakarta.annotation.Nullable BigDecimal vatAmountGreaterThan, @Param("vatAmountLessThan") @jakarta.annotation.Nullable BigDecimal vatAmountLessThan, @Param("vatAmountGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal vatAmountGreaterThanOrEqual, @Param("vatAmountLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal vatAmountLessThanOrEqual, @Param("vatAmountEquals") @jakarta.annotation.Nullable BigDecimal vatAmountEquals, @Param("vatAmountNotEquals") @jakarta.annotation.Nullable BigDecimal vatAmountNotEquals, @Param("vatAmountSpecified") @jakarta.annotation.Nullable Boolean vatAmountSpecified, @Param("vatAmountIn") @jakarta.annotation.Nullable List<BigDecimal> vatAmountIn, @Param("vatAmountNotIn") @jakarta.annotation.Nullable List<BigDecimal> vatAmountNotIn, @Param("netAmountGreaterThan") @jakarta.annotation.Nullable BigDecimal netAmountGreaterThan, @Param("netAmountLessThan") @jakarta.annotation.Nullable BigDecimal netAmountLessThan, @Param("netAmountGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal netAmountGreaterThanOrEqual, @Param("netAmountLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal netAmountLessThanOrEqual, @Param("netAmountEquals") @jakarta.annotation.Nullable BigDecimal netAmountEquals, @Param("netAmountNotEquals") @jakarta.annotation.Nullable BigDecimal netAmountNotEquals, @Param("netAmountSpecified") @jakarta.annotation.Nullable Boolean netAmountSpecified, @Param("netAmountIn") @jakarta.annotation.Nullable List<BigDecimal> netAmountIn, @Param("netAmountNotIn") @jakarta.annotation.Nullable List<BigDecimal> netAmountNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("bookingIdGreaterThan") @jakarta.annotation.Nullable Long bookingIdGreaterThan, @Param("bookingIdLessThan") @jakarta.annotation.Nullable Long bookingIdLessThan, @Param("bookingIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long bookingIdGreaterThanOrEqual, @Param("bookingIdLessThanOrEqual") @jakarta.annotation.Nullable Long bookingIdLessThanOrEqual, @Param("bookingIdEquals") @jakarta.annotation.Nullable Long bookingIdEquals, @Param("bookingIdNotEquals") @jakarta.annotation.Nullable Long bookingIdNotEquals, @Param("bookingIdSpecified") @jakarta.annotation.Nullable Boolean bookingIdSpecified, @Param("bookingIdIn") @jakarta.annotation.Nullable List<Long> bookingIdIn, @Param("bookingIdNotIn") @jakarta.annotation.Nullable List<Long> bookingIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>countInvoices</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CountInvoicesQueryParams} class that allows for
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
   *   <li>invoiceNoContains -  (optional)</li>
   *   <li>invoiceNoDoesNotContain -  (optional)</li>
   *   <li>invoiceNoEquals -  (optional)</li>
   *   <li>invoiceNoNotEquals -  (optional)</li>
   *   <li>invoiceNoSpecified -  (optional)</li>
   *   <li>invoiceNoIn -  (optional)</li>
   *   <li>invoiceNoNotIn -  (optional)</li>
   *   <li>issuedAtGreaterThan -  (optional)</li>
   *   <li>issuedAtLessThan -  (optional)</li>
   *   <li>issuedAtGreaterThanOrEqual -  (optional)</li>
   *   <li>issuedAtLessThanOrEqual -  (optional)</li>
   *   <li>issuedAtEquals -  (optional)</li>
   *   <li>issuedAtNotEquals -  (optional)</li>
   *   <li>issuedAtSpecified -  (optional)</li>
   *   <li>issuedAtIn -  (optional)</li>
   *   <li>issuedAtNotIn -  (optional)</li>
   *   <li>grossAmountGreaterThan -  (optional)</li>
   *   <li>grossAmountLessThan -  (optional)</li>
   *   <li>grossAmountGreaterThanOrEqual -  (optional)</li>
   *   <li>grossAmountLessThanOrEqual -  (optional)</li>
   *   <li>grossAmountEquals -  (optional)</li>
   *   <li>grossAmountNotEquals -  (optional)</li>
   *   <li>grossAmountSpecified -  (optional)</li>
   *   <li>grossAmountIn -  (optional)</li>
   *   <li>grossAmountNotIn -  (optional)</li>
   *   <li>vatAmountGreaterThan -  (optional)</li>
   *   <li>vatAmountLessThan -  (optional)</li>
   *   <li>vatAmountGreaterThanOrEqual -  (optional)</li>
   *   <li>vatAmountLessThanOrEqual -  (optional)</li>
   *   <li>vatAmountEquals -  (optional)</li>
   *   <li>vatAmountNotEquals -  (optional)</li>
   *   <li>vatAmountSpecified -  (optional)</li>
   *   <li>vatAmountIn -  (optional)</li>
   *   <li>vatAmountNotIn -  (optional)</li>
   *   <li>netAmountGreaterThan -  (optional)</li>
   *   <li>netAmountLessThan -  (optional)</li>
   *   <li>netAmountGreaterThanOrEqual -  (optional)</li>
   *   <li>netAmountLessThanOrEqual -  (optional)</li>
   *   <li>netAmountEquals -  (optional)</li>
   *   <li>netAmountNotEquals -  (optional)</li>
   *   <li>netAmountSpecified -  (optional)</li>
   *   <li>netAmountIn -  (optional)</li>
   *   <li>netAmountNotIn -  (optional)</li>
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
  @RequestLine("GET /api/invoices/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&invoiceNo.contains={invoiceNoContains}&invoiceNo.doesNotContain={invoiceNoDoesNotContain}&invoiceNo.equals={invoiceNoEquals}&invoiceNo.notEquals={invoiceNoNotEquals}&invoiceNo.specified={invoiceNoSpecified}&invoiceNo.in={invoiceNoIn}&invoiceNo.notIn={invoiceNoNotIn}&issuedAt.greaterThan={issuedAtGreaterThan}&issuedAt.lessThan={issuedAtLessThan}&issuedAt.greaterThanOrEqual={issuedAtGreaterThanOrEqual}&issuedAt.lessThanOrEqual={issuedAtLessThanOrEqual}&issuedAt.equals={issuedAtEquals}&issuedAt.notEquals={issuedAtNotEquals}&issuedAt.specified={issuedAtSpecified}&issuedAt.in={issuedAtIn}&issuedAt.notIn={issuedAtNotIn}&grossAmount.greaterThan={grossAmountGreaterThan}&grossAmount.lessThan={grossAmountLessThan}&grossAmount.greaterThanOrEqual={grossAmountGreaterThanOrEqual}&grossAmount.lessThanOrEqual={grossAmountLessThanOrEqual}&grossAmount.equals={grossAmountEquals}&grossAmount.notEquals={grossAmountNotEquals}&grossAmount.specified={grossAmountSpecified}&grossAmount.in={grossAmountIn}&grossAmount.notIn={grossAmountNotIn}&vatAmount.greaterThan={vatAmountGreaterThan}&vatAmount.lessThan={vatAmountLessThan}&vatAmount.greaterThanOrEqual={vatAmountGreaterThanOrEqual}&vatAmount.lessThanOrEqual={vatAmountLessThanOrEqual}&vatAmount.equals={vatAmountEquals}&vatAmount.notEquals={vatAmountNotEquals}&vatAmount.specified={vatAmountSpecified}&vatAmount.in={vatAmountIn}&vatAmount.notIn={vatAmountNotIn}&netAmount.greaterThan={netAmountGreaterThan}&netAmount.lessThan={netAmountLessThan}&netAmount.greaterThanOrEqual={netAmountGreaterThanOrEqual}&netAmount.lessThanOrEqual={netAmountLessThanOrEqual}&netAmount.equals={netAmountEquals}&netAmount.notEquals={netAmountNotEquals}&netAmount.specified={netAmountSpecified}&netAmount.in={netAmountIn}&netAmount.notIn={netAmountNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  Long countInvoices(@QueryMap(encoded=true) CountInvoicesQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>countInvoices</code> that receives the query parameters as a map,
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
          *   <li>invoiceNoContains -  (optional)</li>
          *   <li>invoiceNoDoesNotContain -  (optional)</li>
          *   <li>invoiceNoEquals -  (optional)</li>
          *   <li>invoiceNoNotEquals -  (optional)</li>
          *   <li>invoiceNoSpecified -  (optional)</li>
          *   <li>invoiceNoIn -  (optional)</li>
          *   <li>invoiceNoNotIn -  (optional)</li>
          *   <li>issuedAtGreaterThan -  (optional)</li>
          *   <li>issuedAtLessThan -  (optional)</li>
          *   <li>issuedAtGreaterThanOrEqual -  (optional)</li>
          *   <li>issuedAtLessThanOrEqual -  (optional)</li>
          *   <li>issuedAtEquals -  (optional)</li>
          *   <li>issuedAtNotEquals -  (optional)</li>
          *   <li>issuedAtSpecified -  (optional)</li>
          *   <li>issuedAtIn -  (optional)</li>
          *   <li>issuedAtNotIn -  (optional)</li>
          *   <li>grossAmountGreaterThan -  (optional)</li>
          *   <li>grossAmountLessThan -  (optional)</li>
          *   <li>grossAmountGreaterThanOrEqual -  (optional)</li>
          *   <li>grossAmountLessThanOrEqual -  (optional)</li>
          *   <li>grossAmountEquals -  (optional)</li>
          *   <li>grossAmountNotEquals -  (optional)</li>
          *   <li>grossAmountSpecified -  (optional)</li>
          *   <li>grossAmountIn -  (optional)</li>
          *   <li>grossAmountNotIn -  (optional)</li>
          *   <li>vatAmountGreaterThan -  (optional)</li>
          *   <li>vatAmountLessThan -  (optional)</li>
          *   <li>vatAmountGreaterThanOrEqual -  (optional)</li>
          *   <li>vatAmountLessThanOrEqual -  (optional)</li>
          *   <li>vatAmountEquals -  (optional)</li>
          *   <li>vatAmountNotEquals -  (optional)</li>
          *   <li>vatAmountSpecified -  (optional)</li>
          *   <li>vatAmountIn -  (optional)</li>
          *   <li>vatAmountNotIn -  (optional)</li>
          *   <li>netAmountGreaterThan -  (optional)</li>
          *   <li>netAmountLessThan -  (optional)</li>
          *   <li>netAmountGreaterThanOrEqual -  (optional)</li>
          *   <li>netAmountLessThanOrEqual -  (optional)</li>
          *   <li>netAmountEquals -  (optional)</li>
          *   <li>netAmountNotEquals -  (optional)</li>
          *   <li>netAmountSpecified -  (optional)</li>
          *   <li>netAmountIn -  (optional)</li>
          *   <li>netAmountNotIn -  (optional)</li>
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
      @RequestLine("GET /api/invoices/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&invoiceNo.contains={invoiceNoContains}&invoiceNo.doesNotContain={invoiceNoDoesNotContain}&invoiceNo.equals={invoiceNoEquals}&invoiceNo.notEquals={invoiceNoNotEquals}&invoiceNo.specified={invoiceNoSpecified}&invoiceNo.in={invoiceNoIn}&invoiceNo.notIn={invoiceNoNotIn}&issuedAt.greaterThan={issuedAtGreaterThan}&issuedAt.lessThan={issuedAtLessThan}&issuedAt.greaterThanOrEqual={issuedAtGreaterThanOrEqual}&issuedAt.lessThanOrEqual={issuedAtLessThanOrEqual}&issuedAt.equals={issuedAtEquals}&issuedAt.notEquals={issuedAtNotEquals}&issuedAt.specified={issuedAtSpecified}&issuedAt.in={issuedAtIn}&issuedAt.notIn={issuedAtNotIn}&grossAmount.greaterThan={grossAmountGreaterThan}&grossAmount.lessThan={grossAmountLessThan}&grossAmount.greaterThanOrEqual={grossAmountGreaterThanOrEqual}&grossAmount.lessThanOrEqual={grossAmountLessThanOrEqual}&grossAmount.equals={grossAmountEquals}&grossAmount.notEquals={grossAmountNotEquals}&grossAmount.specified={grossAmountSpecified}&grossAmount.in={grossAmountIn}&grossAmount.notIn={grossAmountNotIn}&vatAmount.greaterThan={vatAmountGreaterThan}&vatAmount.lessThan={vatAmountLessThan}&vatAmount.greaterThanOrEqual={vatAmountGreaterThanOrEqual}&vatAmount.lessThanOrEqual={vatAmountLessThanOrEqual}&vatAmount.equals={vatAmountEquals}&vatAmount.notEquals={vatAmountNotEquals}&vatAmount.specified={vatAmountSpecified}&vatAmount.in={vatAmountIn}&vatAmount.notIn={vatAmountNotIn}&netAmount.greaterThan={netAmountGreaterThan}&netAmount.lessThan={netAmountLessThan}&netAmount.greaterThanOrEqual={netAmountGreaterThanOrEqual}&netAmount.lessThanOrEqual={netAmountLessThanOrEqual}&netAmount.equals={netAmountEquals}&netAmount.notEquals={netAmountNotEquals}&netAmount.specified={netAmountSpecified}&netAmount.in={netAmountIn}&netAmount.notIn={netAmountNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Long> countInvoicesWithHttpInfo(@QueryMap(encoded=true) CountInvoicesQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>countInvoices</code> method in a fluent style.
   */
  public static class CountInvoicesQueryParams extends HashMap<String, Object> {
    public CountInvoicesQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountInvoicesQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountInvoicesQueryParams invoiceNoContains(@jakarta.annotation.Nullable final String value) {
      put("invoiceNo.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams invoiceNoDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("invoiceNo.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams invoiceNoEquals(@jakarta.annotation.Nullable final String value) {
      put("invoiceNo.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams invoiceNoNotEquals(@jakarta.annotation.Nullable final String value) {
      put("invoiceNo.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams invoiceNoSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("invoiceNo.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams invoiceNoIn(@jakarta.annotation.Nullable final List<String> value) {
      put("invoiceNo.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountInvoicesQueryParams invoiceNoNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("invoiceNo.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountInvoicesQueryParams issuedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("issuedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams issuedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("issuedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams issuedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("issuedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams issuedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("issuedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams issuedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("issuedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams issuedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("issuedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams issuedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("issuedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams issuedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("issuedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountInvoicesQueryParams issuedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("issuedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountInvoicesQueryParams grossAmountGreaterThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("grossAmount.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams grossAmountLessThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("grossAmount.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams grossAmountGreaterThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("grossAmount.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams grossAmountLessThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("grossAmount.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams grossAmountEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("grossAmount.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams grossAmountNotEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("grossAmount.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams grossAmountSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("grossAmount.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams grossAmountIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("grossAmount.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountInvoicesQueryParams grossAmountNotIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("grossAmount.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountInvoicesQueryParams vatAmountGreaterThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("vatAmount.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams vatAmountLessThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("vatAmount.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams vatAmountGreaterThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("vatAmount.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams vatAmountLessThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("vatAmount.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams vatAmountEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("vatAmount.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams vatAmountNotEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("vatAmount.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams vatAmountSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("vatAmount.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams vatAmountIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("vatAmount.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountInvoicesQueryParams vatAmountNotIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("vatAmount.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountInvoicesQueryParams netAmountGreaterThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("netAmount.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams netAmountLessThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("netAmount.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams netAmountGreaterThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("netAmount.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams netAmountLessThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("netAmount.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams netAmountEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("netAmount.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams netAmountNotEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("netAmount.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams netAmountSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("netAmount.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams netAmountIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("netAmount.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountInvoicesQueryParams netAmountNotIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("netAmount.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountInvoicesQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountInvoicesQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountInvoicesQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountInvoicesQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountInvoicesQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountInvoicesQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountInvoicesQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountInvoicesQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountInvoicesQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountInvoicesQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountInvoicesQueryParams bookingIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams bookingIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams bookingIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams bookingIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams bookingIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams bookingIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams bookingIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("bookingId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountInvoicesQueryParams bookingIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("bookingId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountInvoicesQueryParams bookingIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("bookingId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountInvoicesQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param invoiceDTO  (required)
   * @return InvoiceDTO
   */
  @RequestLine("POST /api/invoices")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  InvoiceDTO createInvoice(@jakarta.annotation.Nonnull InvoiceDTO invoiceDTO);

  /**
   * 
   * Similar to <code>createInvoice</code> but it also returns the http response headers .
   * 
   * @param invoiceDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/invoices")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<InvoiceDTO> createInvoiceWithHttpInfo(@jakarta.annotation.Nonnull InvoiceDTO invoiceDTO);



  /**
   * 
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/invoices/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteInvoice(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>deleteInvoice</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/invoices/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteInvoiceWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



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
   * @param invoiceNoContains  (optional)
   * @param invoiceNoDoesNotContain  (optional)
   * @param invoiceNoEquals  (optional)
   * @param invoiceNoNotEquals  (optional)
   * @param invoiceNoSpecified  (optional)
   * @param invoiceNoIn  (optional)
   * @param invoiceNoNotIn  (optional)
   * @param issuedAtGreaterThan  (optional)
   * @param issuedAtLessThan  (optional)
   * @param issuedAtGreaterThanOrEqual  (optional)
   * @param issuedAtLessThanOrEqual  (optional)
   * @param issuedAtEquals  (optional)
   * @param issuedAtNotEquals  (optional)
   * @param issuedAtSpecified  (optional)
   * @param issuedAtIn  (optional)
   * @param issuedAtNotIn  (optional)
   * @param grossAmountGreaterThan  (optional)
   * @param grossAmountLessThan  (optional)
   * @param grossAmountGreaterThanOrEqual  (optional)
   * @param grossAmountLessThanOrEqual  (optional)
   * @param grossAmountEquals  (optional)
   * @param grossAmountNotEquals  (optional)
   * @param grossAmountSpecified  (optional)
   * @param grossAmountIn  (optional)
   * @param grossAmountNotIn  (optional)
   * @param vatAmountGreaterThan  (optional)
   * @param vatAmountLessThan  (optional)
   * @param vatAmountGreaterThanOrEqual  (optional)
   * @param vatAmountLessThanOrEqual  (optional)
   * @param vatAmountEquals  (optional)
   * @param vatAmountNotEquals  (optional)
   * @param vatAmountSpecified  (optional)
   * @param vatAmountIn  (optional)
   * @param vatAmountNotIn  (optional)
   * @param netAmountGreaterThan  (optional)
   * @param netAmountLessThan  (optional)
   * @param netAmountGreaterThanOrEqual  (optional)
   * @param netAmountLessThanOrEqual  (optional)
   * @param netAmountEquals  (optional)
   * @param netAmountNotEquals  (optional)
   * @param netAmountSpecified  (optional)
   * @param netAmountIn  (optional)
   * @param netAmountNotIn  (optional)
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
   * @return List&lt;InvoiceDTO&gt;
   */
  @RequestLine("GET /api/invoices?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&invoiceNo.contains={invoiceNoContains}&invoiceNo.doesNotContain={invoiceNoDoesNotContain}&invoiceNo.equals={invoiceNoEquals}&invoiceNo.notEquals={invoiceNoNotEquals}&invoiceNo.specified={invoiceNoSpecified}&invoiceNo.in={invoiceNoIn}&invoiceNo.notIn={invoiceNoNotIn}&issuedAt.greaterThan={issuedAtGreaterThan}&issuedAt.lessThan={issuedAtLessThan}&issuedAt.greaterThanOrEqual={issuedAtGreaterThanOrEqual}&issuedAt.lessThanOrEqual={issuedAtLessThanOrEqual}&issuedAt.equals={issuedAtEquals}&issuedAt.notEquals={issuedAtNotEquals}&issuedAt.specified={issuedAtSpecified}&issuedAt.in={issuedAtIn}&issuedAt.notIn={issuedAtNotIn}&grossAmount.greaterThan={grossAmountGreaterThan}&grossAmount.lessThan={grossAmountLessThan}&grossAmount.greaterThanOrEqual={grossAmountGreaterThanOrEqual}&grossAmount.lessThanOrEqual={grossAmountLessThanOrEqual}&grossAmount.equals={grossAmountEquals}&grossAmount.notEquals={grossAmountNotEquals}&grossAmount.specified={grossAmountSpecified}&grossAmount.in={grossAmountIn}&grossAmount.notIn={grossAmountNotIn}&vatAmount.greaterThan={vatAmountGreaterThan}&vatAmount.lessThan={vatAmountLessThan}&vatAmount.greaterThanOrEqual={vatAmountGreaterThanOrEqual}&vatAmount.lessThanOrEqual={vatAmountLessThanOrEqual}&vatAmount.equals={vatAmountEquals}&vatAmount.notEquals={vatAmountNotEquals}&vatAmount.specified={vatAmountSpecified}&vatAmount.in={vatAmountIn}&vatAmount.notIn={vatAmountNotIn}&netAmount.greaterThan={netAmountGreaterThan}&netAmount.lessThan={netAmountLessThan}&netAmount.greaterThanOrEqual={netAmountGreaterThanOrEqual}&netAmount.lessThanOrEqual={netAmountLessThanOrEqual}&netAmount.equals={netAmountEquals}&netAmount.notEquals={netAmountNotEquals}&netAmount.specified={netAmountSpecified}&netAmount.in={netAmountIn}&netAmount.notIn={netAmountNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  List<InvoiceDTO> getAllInvoices(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("invoiceNoContains") @jakarta.annotation.Nullable String invoiceNoContains, @Param("invoiceNoDoesNotContain") @jakarta.annotation.Nullable String invoiceNoDoesNotContain, @Param("invoiceNoEquals") @jakarta.annotation.Nullable String invoiceNoEquals, @Param("invoiceNoNotEquals") @jakarta.annotation.Nullable String invoiceNoNotEquals, @Param("invoiceNoSpecified") @jakarta.annotation.Nullable Boolean invoiceNoSpecified, @Param("invoiceNoIn") @jakarta.annotation.Nullable List<String> invoiceNoIn, @Param("invoiceNoNotIn") @jakarta.annotation.Nullable List<String> invoiceNoNotIn, @Param("issuedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime issuedAtGreaterThan, @Param("issuedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime issuedAtLessThan, @Param("issuedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime issuedAtGreaterThanOrEqual, @Param("issuedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime issuedAtLessThanOrEqual, @Param("issuedAtEquals") @jakarta.annotation.Nullable OffsetDateTime issuedAtEquals, @Param("issuedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime issuedAtNotEquals, @Param("issuedAtSpecified") @jakarta.annotation.Nullable Boolean issuedAtSpecified, @Param("issuedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> issuedAtIn, @Param("issuedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> issuedAtNotIn, @Param("grossAmountGreaterThan") @jakarta.annotation.Nullable BigDecimal grossAmountGreaterThan, @Param("grossAmountLessThan") @jakarta.annotation.Nullable BigDecimal grossAmountLessThan, @Param("grossAmountGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal grossAmountGreaterThanOrEqual, @Param("grossAmountLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal grossAmountLessThanOrEqual, @Param("grossAmountEquals") @jakarta.annotation.Nullable BigDecimal grossAmountEquals, @Param("grossAmountNotEquals") @jakarta.annotation.Nullable BigDecimal grossAmountNotEquals, @Param("grossAmountSpecified") @jakarta.annotation.Nullable Boolean grossAmountSpecified, @Param("grossAmountIn") @jakarta.annotation.Nullable List<BigDecimal> grossAmountIn, @Param("grossAmountNotIn") @jakarta.annotation.Nullable List<BigDecimal> grossAmountNotIn, @Param("vatAmountGreaterThan") @jakarta.annotation.Nullable BigDecimal vatAmountGreaterThan, @Param("vatAmountLessThan") @jakarta.annotation.Nullable BigDecimal vatAmountLessThan, @Param("vatAmountGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal vatAmountGreaterThanOrEqual, @Param("vatAmountLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal vatAmountLessThanOrEqual, @Param("vatAmountEquals") @jakarta.annotation.Nullable BigDecimal vatAmountEquals, @Param("vatAmountNotEquals") @jakarta.annotation.Nullable BigDecimal vatAmountNotEquals, @Param("vatAmountSpecified") @jakarta.annotation.Nullable Boolean vatAmountSpecified, @Param("vatAmountIn") @jakarta.annotation.Nullable List<BigDecimal> vatAmountIn, @Param("vatAmountNotIn") @jakarta.annotation.Nullable List<BigDecimal> vatAmountNotIn, @Param("netAmountGreaterThan") @jakarta.annotation.Nullable BigDecimal netAmountGreaterThan, @Param("netAmountLessThan") @jakarta.annotation.Nullable BigDecimal netAmountLessThan, @Param("netAmountGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal netAmountGreaterThanOrEqual, @Param("netAmountLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal netAmountLessThanOrEqual, @Param("netAmountEquals") @jakarta.annotation.Nullable BigDecimal netAmountEquals, @Param("netAmountNotEquals") @jakarta.annotation.Nullable BigDecimal netAmountNotEquals, @Param("netAmountSpecified") @jakarta.annotation.Nullable Boolean netAmountSpecified, @Param("netAmountIn") @jakarta.annotation.Nullable List<BigDecimal> netAmountIn, @Param("netAmountNotIn") @jakarta.annotation.Nullable List<BigDecimal> netAmountNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("bookingIdGreaterThan") @jakarta.annotation.Nullable Long bookingIdGreaterThan, @Param("bookingIdLessThan") @jakarta.annotation.Nullable Long bookingIdLessThan, @Param("bookingIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long bookingIdGreaterThanOrEqual, @Param("bookingIdLessThanOrEqual") @jakarta.annotation.Nullable Long bookingIdLessThanOrEqual, @Param("bookingIdEquals") @jakarta.annotation.Nullable Long bookingIdEquals, @Param("bookingIdNotEquals") @jakarta.annotation.Nullable Long bookingIdNotEquals, @Param("bookingIdSpecified") @jakarta.annotation.Nullable Boolean bookingIdSpecified, @Param("bookingIdIn") @jakarta.annotation.Nullable List<Long> bookingIdIn, @Param("bookingIdNotIn") @jakarta.annotation.Nullable List<Long> bookingIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>getAllInvoices</code> but it also returns the http response headers .
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
   * @param invoiceNoContains  (optional)
   * @param invoiceNoDoesNotContain  (optional)
   * @param invoiceNoEquals  (optional)
   * @param invoiceNoNotEquals  (optional)
   * @param invoiceNoSpecified  (optional)
   * @param invoiceNoIn  (optional)
   * @param invoiceNoNotIn  (optional)
   * @param issuedAtGreaterThan  (optional)
   * @param issuedAtLessThan  (optional)
   * @param issuedAtGreaterThanOrEqual  (optional)
   * @param issuedAtLessThanOrEqual  (optional)
   * @param issuedAtEquals  (optional)
   * @param issuedAtNotEquals  (optional)
   * @param issuedAtSpecified  (optional)
   * @param issuedAtIn  (optional)
   * @param issuedAtNotIn  (optional)
   * @param grossAmountGreaterThan  (optional)
   * @param grossAmountLessThan  (optional)
   * @param grossAmountGreaterThanOrEqual  (optional)
   * @param grossAmountLessThanOrEqual  (optional)
   * @param grossAmountEquals  (optional)
   * @param grossAmountNotEquals  (optional)
   * @param grossAmountSpecified  (optional)
   * @param grossAmountIn  (optional)
   * @param grossAmountNotIn  (optional)
   * @param vatAmountGreaterThan  (optional)
   * @param vatAmountLessThan  (optional)
   * @param vatAmountGreaterThanOrEqual  (optional)
   * @param vatAmountLessThanOrEqual  (optional)
   * @param vatAmountEquals  (optional)
   * @param vatAmountNotEquals  (optional)
   * @param vatAmountSpecified  (optional)
   * @param vatAmountIn  (optional)
   * @param vatAmountNotIn  (optional)
   * @param netAmountGreaterThan  (optional)
   * @param netAmountLessThan  (optional)
   * @param netAmountGreaterThanOrEqual  (optional)
   * @param netAmountLessThanOrEqual  (optional)
   * @param netAmountEquals  (optional)
   * @param netAmountNotEquals  (optional)
   * @param netAmountSpecified  (optional)
   * @param netAmountIn  (optional)
   * @param netAmountNotIn  (optional)
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
  @RequestLine("GET /api/invoices?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&invoiceNo.contains={invoiceNoContains}&invoiceNo.doesNotContain={invoiceNoDoesNotContain}&invoiceNo.equals={invoiceNoEquals}&invoiceNo.notEquals={invoiceNoNotEquals}&invoiceNo.specified={invoiceNoSpecified}&invoiceNo.in={invoiceNoIn}&invoiceNo.notIn={invoiceNoNotIn}&issuedAt.greaterThan={issuedAtGreaterThan}&issuedAt.lessThan={issuedAtLessThan}&issuedAt.greaterThanOrEqual={issuedAtGreaterThanOrEqual}&issuedAt.lessThanOrEqual={issuedAtLessThanOrEqual}&issuedAt.equals={issuedAtEquals}&issuedAt.notEquals={issuedAtNotEquals}&issuedAt.specified={issuedAtSpecified}&issuedAt.in={issuedAtIn}&issuedAt.notIn={issuedAtNotIn}&grossAmount.greaterThan={grossAmountGreaterThan}&grossAmount.lessThan={grossAmountLessThan}&grossAmount.greaterThanOrEqual={grossAmountGreaterThanOrEqual}&grossAmount.lessThanOrEqual={grossAmountLessThanOrEqual}&grossAmount.equals={grossAmountEquals}&grossAmount.notEquals={grossAmountNotEquals}&grossAmount.specified={grossAmountSpecified}&grossAmount.in={grossAmountIn}&grossAmount.notIn={grossAmountNotIn}&vatAmount.greaterThan={vatAmountGreaterThan}&vatAmount.lessThan={vatAmountLessThan}&vatAmount.greaterThanOrEqual={vatAmountGreaterThanOrEqual}&vatAmount.lessThanOrEqual={vatAmountLessThanOrEqual}&vatAmount.equals={vatAmountEquals}&vatAmount.notEquals={vatAmountNotEquals}&vatAmount.specified={vatAmountSpecified}&vatAmount.in={vatAmountIn}&vatAmount.notIn={vatAmountNotIn}&netAmount.greaterThan={netAmountGreaterThan}&netAmount.lessThan={netAmountLessThan}&netAmount.greaterThanOrEqual={netAmountGreaterThanOrEqual}&netAmount.lessThanOrEqual={netAmountLessThanOrEqual}&netAmount.equals={netAmountEquals}&netAmount.notEquals={netAmountNotEquals}&netAmount.specified={netAmountSpecified}&netAmount.in={netAmountIn}&netAmount.notIn={netAmountNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<InvoiceDTO>> getAllInvoicesWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("invoiceNoContains") @jakarta.annotation.Nullable String invoiceNoContains, @Param("invoiceNoDoesNotContain") @jakarta.annotation.Nullable String invoiceNoDoesNotContain, @Param("invoiceNoEquals") @jakarta.annotation.Nullable String invoiceNoEquals, @Param("invoiceNoNotEquals") @jakarta.annotation.Nullable String invoiceNoNotEquals, @Param("invoiceNoSpecified") @jakarta.annotation.Nullable Boolean invoiceNoSpecified, @Param("invoiceNoIn") @jakarta.annotation.Nullable List<String> invoiceNoIn, @Param("invoiceNoNotIn") @jakarta.annotation.Nullable List<String> invoiceNoNotIn, @Param("issuedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime issuedAtGreaterThan, @Param("issuedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime issuedAtLessThan, @Param("issuedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime issuedAtGreaterThanOrEqual, @Param("issuedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime issuedAtLessThanOrEqual, @Param("issuedAtEquals") @jakarta.annotation.Nullable OffsetDateTime issuedAtEquals, @Param("issuedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime issuedAtNotEquals, @Param("issuedAtSpecified") @jakarta.annotation.Nullable Boolean issuedAtSpecified, @Param("issuedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> issuedAtIn, @Param("issuedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> issuedAtNotIn, @Param("grossAmountGreaterThan") @jakarta.annotation.Nullable BigDecimal grossAmountGreaterThan, @Param("grossAmountLessThan") @jakarta.annotation.Nullable BigDecimal grossAmountLessThan, @Param("grossAmountGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal grossAmountGreaterThanOrEqual, @Param("grossAmountLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal grossAmountLessThanOrEqual, @Param("grossAmountEquals") @jakarta.annotation.Nullable BigDecimal grossAmountEquals, @Param("grossAmountNotEquals") @jakarta.annotation.Nullable BigDecimal grossAmountNotEquals, @Param("grossAmountSpecified") @jakarta.annotation.Nullable Boolean grossAmountSpecified, @Param("grossAmountIn") @jakarta.annotation.Nullable List<BigDecimal> grossAmountIn, @Param("grossAmountNotIn") @jakarta.annotation.Nullable List<BigDecimal> grossAmountNotIn, @Param("vatAmountGreaterThan") @jakarta.annotation.Nullable BigDecimal vatAmountGreaterThan, @Param("vatAmountLessThan") @jakarta.annotation.Nullable BigDecimal vatAmountLessThan, @Param("vatAmountGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal vatAmountGreaterThanOrEqual, @Param("vatAmountLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal vatAmountLessThanOrEqual, @Param("vatAmountEquals") @jakarta.annotation.Nullable BigDecimal vatAmountEquals, @Param("vatAmountNotEquals") @jakarta.annotation.Nullable BigDecimal vatAmountNotEquals, @Param("vatAmountSpecified") @jakarta.annotation.Nullable Boolean vatAmountSpecified, @Param("vatAmountIn") @jakarta.annotation.Nullable List<BigDecimal> vatAmountIn, @Param("vatAmountNotIn") @jakarta.annotation.Nullable List<BigDecimal> vatAmountNotIn, @Param("netAmountGreaterThan") @jakarta.annotation.Nullable BigDecimal netAmountGreaterThan, @Param("netAmountLessThan") @jakarta.annotation.Nullable BigDecimal netAmountLessThan, @Param("netAmountGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal netAmountGreaterThanOrEqual, @Param("netAmountLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal netAmountLessThanOrEqual, @Param("netAmountEquals") @jakarta.annotation.Nullable BigDecimal netAmountEquals, @Param("netAmountNotEquals") @jakarta.annotation.Nullable BigDecimal netAmountNotEquals, @Param("netAmountSpecified") @jakarta.annotation.Nullable Boolean netAmountSpecified, @Param("netAmountIn") @jakarta.annotation.Nullable List<BigDecimal> netAmountIn, @Param("netAmountNotIn") @jakarta.annotation.Nullable List<BigDecimal> netAmountNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("bookingIdGreaterThan") @jakarta.annotation.Nullable Long bookingIdGreaterThan, @Param("bookingIdLessThan") @jakarta.annotation.Nullable Long bookingIdLessThan, @Param("bookingIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long bookingIdGreaterThanOrEqual, @Param("bookingIdLessThanOrEqual") @jakarta.annotation.Nullable Long bookingIdLessThanOrEqual, @Param("bookingIdEquals") @jakarta.annotation.Nullable Long bookingIdEquals, @Param("bookingIdNotEquals") @jakarta.annotation.Nullable Long bookingIdNotEquals, @Param("bookingIdSpecified") @jakarta.annotation.Nullable Boolean bookingIdSpecified, @Param("bookingIdIn") @jakarta.annotation.Nullable List<Long> bookingIdIn, @Param("bookingIdNotIn") @jakarta.annotation.Nullable List<Long> bookingIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllInvoices</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllInvoicesQueryParams} class that allows for
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
   *   <li>invoiceNoContains -  (optional)</li>
   *   <li>invoiceNoDoesNotContain -  (optional)</li>
   *   <li>invoiceNoEquals -  (optional)</li>
   *   <li>invoiceNoNotEquals -  (optional)</li>
   *   <li>invoiceNoSpecified -  (optional)</li>
   *   <li>invoiceNoIn -  (optional)</li>
   *   <li>invoiceNoNotIn -  (optional)</li>
   *   <li>issuedAtGreaterThan -  (optional)</li>
   *   <li>issuedAtLessThan -  (optional)</li>
   *   <li>issuedAtGreaterThanOrEqual -  (optional)</li>
   *   <li>issuedAtLessThanOrEqual -  (optional)</li>
   *   <li>issuedAtEquals -  (optional)</li>
   *   <li>issuedAtNotEquals -  (optional)</li>
   *   <li>issuedAtSpecified -  (optional)</li>
   *   <li>issuedAtIn -  (optional)</li>
   *   <li>issuedAtNotIn -  (optional)</li>
   *   <li>grossAmountGreaterThan -  (optional)</li>
   *   <li>grossAmountLessThan -  (optional)</li>
   *   <li>grossAmountGreaterThanOrEqual -  (optional)</li>
   *   <li>grossAmountLessThanOrEqual -  (optional)</li>
   *   <li>grossAmountEquals -  (optional)</li>
   *   <li>grossAmountNotEquals -  (optional)</li>
   *   <li>grossAmountSpecified -  (optional)</li>
   *   <li>grossAmountIn -  (optional)</li>
   *   <li>grossAmountNotIn -  (optional)</li>
   *   <li>vatAmountGreaterThan -  (optional)</li>
   *   <li>vatAmountLessThan -  (optional)</li>
   *   <li>vatAmountGreaterThanOrEqual -  (optional)</li>
   *   <li>vatAmountLessThanOrEqual -  (optional)</li>
   *   <li>vatAmountEquals -  (optional)</li>
   *   <li>vatAmountNotEquals -  (optional)</li>
   *   <li>vatAmountSpecified -  (optional)</li>
   *   <li>vatAmountIn -  (optional)</li>
   *   <li>vatAmountNotIn -  (optional)</li>
   *   <li>netAmountGreaterThan -  (optional)</li>
   *   <li>netAmountLessThan -  (optional)</li>
   *   <li>netAmountGreaterThanOrEqual -  (optional)</li>
   *   <li>netAmountLessThanOrEqual -  (optional)</li>
   *   <li>netAmountEquals -  (optional)</li>
   *   <li>netAmountNotEquals -  (optional)</li>
   *   <li>netAmountSpecified -  (optional)</li>
   *   <li>netAmountIn -  (optional)</li>
   *   <li>netAmountNotIn -  (optional)</li>
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
   * @return List&lt;InvoiceDTO&gt;
   */
  @RequestLine("GET /api/invoices?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&invoiceNo.contains={invoiceNoContains}&invoiceNo.doesNotContain={invoiceNoDoesNotContain}&invoiceNo.equals={invoiceNoEquals}&invoiceNo.notEquals={invoiceNoNotEquals}&invoiceNo.specified={invoiceNoSpecified}&invoiceNo.in={invoiceNoIn}&invoiceNo.notIn={invoiceNoNotIn}&issuedAt.greaterThan={issuedAtGreaterThan}&issuedAt.lessThan={issuedAtLessThan}&issuedAt.greaterThanOrEqual={issuedAtGreaterThanOrEqual}&issuedAt.lessThanOrEqual={issuedAtLessThanOrEqual}&issuedAt.equals={issuedAtEquals}&issuedAt.notEquals={issuedAtNotEquals}&issuedAt.specified={issuedAtSpecified}&issuedAt.in={issuedAtIn}&issuedAt.notIn={issuedAtNotIn}&grossAmount.greaterThan={grossAmountGreaterThan}&grossAmount.lessThan={grossAmountLessThan}&grossAmount.greaterThanOrEqual={grossAmountGreaterThanOrEqual}&grossAmount.lessThanOrEqual={grossAmountLessThanOrEqual}&grossAmount.equals={grossAmountEquals}&grossAmount.notEquals={grossAmountNotEquals}&grossAmount.specified={grossAmountSpecified}&grossAmount.in={grossAmountIn}&grossAmount.notIn={grossAmountNotIn}&vatAmount.greaterThan={vatAmountGreaterThan}&vatAmount.lessThan={vatAmountLessThan}&vatAmount.greaterThanOrEqual={vatAmountGreaterThanOrEqual}&vatAmount.lessThanOrEqual={vatAmountLessThanOrEqual}&vatAmount.equals={vatAmountEquals}&vatAmount.notEquals={vatAmountNotEquals}&vatAmount.specified={vatAmountSpecified}&vatAmount.in={vatAmountIn}&vatAmount.notIn={vatAmountNotIn}&netAmount.greaterThan={netAmountGreaterThan}&netAmount.lessThan={netAmountLessThan}&netAmount.greaterThanOrEqual={netAmountGreaterThanOrEqual}&netAmount.lessThanOrEqual={netAmountLessThanOrEqual}&netAmount.equals={netAmountEquals}&netAmount.notEquals={netAmountNotEquals}&netAmount.specified={netAmountSpecified}&netAmount.in={netAmountIn}&netAmount.notIn={netAmountNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  List<InvoiceDTO> getAllInvoices(@QueryMap(encoded=true) GetAllInvoicesQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllInvoices</code> that receives the query parameters as a map,
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
          *   <li>invoiceNoContains -  (optional)</li>
          *   <li>invoiceNoDoesNotContain -  (optional)</li>
          *   <li>invoiceNoEquals -  (optional)</li>
          *   <li>invoiceNoNotEquals -  (optional)</li>
          *   <li>invoiceNoSpecified -  (optional)</li>
          *   <li>invoiceNoIn -  (optional)</li>
          *   <li>invoiceNoNotIn -  (optional)</li>
          *   <li>issuedAtGreaterThan -  (optional)</li>
          *   <li>issuedAtLessThan -  (optional)</li>
          *   <li>issuedAtGreaterThanOrEqual -  (optional)</li>
          *   <li>issuedAtLessThanOrEqual -  (optional)</li>
          *   <li>issuedAtEquals -  (optional)</li>
          *   <li>issuedAtNotEquals -  (optional)</li>
          *   <li>issuedAtSpecified -  (optional)</li>
          *   <li>issuedAtIn -  (optional)</li>
          *   <li>issuedAtNotIn -  (optional)</li>
          *   <li>grossAmountGreaterThan -  (optional)</li>
          *   <li>grossAmountLessThan -  (optional)</li>
          *   <li>grossAmountGreaterThanOrEqual -  (optional)</li>
          *   <li>grossAmountLessThanOrEqual -  (optional)</li>
          *   <li>grossAmountEquals -  (optional)</li>
          *   <li>grossAmountNotEquals -  (optional)</li>
          *   <li>grossAmountSpecified -  (optional)</li>
          *   <li>grossAmountIn -  (optional)</li>
          *   <li>grossAmountNotIn -  (optional)</li>
          *   <li>vatAmountGreaterThan -  (optional)</li>
          *   <li>vatAmountLessThan -  (optional)</li>
          *   <li>vatAmountGreaterThanOrEqual -  (optional)</li>
          *   <li>vatAmountLessThanOrEqual -  (optional)</li>
          *   <li>vatAmountEquals -  (optional)</li>
          *   <li>vatAmountNotEquals -  (optional)</li>
          *   <li>vatAmountSpecified -  (optional)</li>
          *   <li>vatAmountIn -  (optional)</li>
          *   <li>vatAmountNotIn -  (optional)</li>
          *   <li>netAmountGreaterThan -  (optional)</li>
          *   <li>netAmountLessThan -  (optional)</li>
          *   <li>netAmountGreaterThanOrEqual -  (optional)</li>
          *   <li>netAmountLessThanOrEqual -  (optional)</li>
          *   <li>netAmountEquals -  (optional)</li>
          *   <li>netAmountNotEquals -  (optional)</li>
          *   <li>netAmountSpecified -  (optional)</li>
          *   <li>netAmountIn -  (optional)</li>
          *   <li>netAmountNotIn -  (optional)</li>
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
          * @return List&lt;InvoiceDTO&gt;
      */
      @RequestLine("GET /api/invoices?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&invoiceNo.contains={invoiceNoContains}&invoiceNo.doesNotContain={invoiceNoDoesNotContain}&invoiceNo.equals={invoiceNoEquals}&invoiceNo.notEquals={invoiceNoNotEquals}&invoiceNo.specified={invoiceNoSpecified}&invoiceNo.in={invoiceNoIn}&invoiceNo.notIn={invoiceNoNotIn}&issuedAt.greaterThan={issuedAtGreaterThan}&issuedAt.lessThan={issuedAtLessThan}&issuedAt.greaterThanOrEqual={issuedAtGreaterThanOrEqual}&issuedAt.lessThanOrEqual={issuedAtLessThanOrEqual}&issuedAt.equals={issuedAtEquals}&issuedAt.notEquals={issuedAtNotEquals}&issuedAt.specified={issuedAtSpecified}&issuedAt.in={issuedAtIn}&issuedAt.notIn={issuedAtNotIn}&grossAmount.greaterThan={grossAmountGreaterThan}&grossAmount.lessThan={grossAmountLessThan}&grossAmount.greaterThanOrEqual={grossAmountGreaterThanOrEqual}&grossAmount.lessThanOrEqual={grossAmountLessThanOrEqual}&grossAmount.equals={grossAmountEquals}&grossAmount.notEquals={grossAmountNotEquals}&grossAmount.specified={grossAmountSpecified}&grossAmount.in={grossAmountIn}&grossAmount.notIn={grossAmountNotIn}&vatAmount.greaterThan={vatAmountGreaterThan}&vatAmount.lessThan={vatAmountLessThan}&vatAmount.greaterThanOrEqual={vatAmountGreaterThanOrEqual}&vatAmount.lessThanOrEqual={vatAmountLessThanOrEqual}&vatAmount.equals={vatAmountEquals}&vatAmount.notEquals={vatAmountNotEquals}&vatAmount.specified={vatAmountSpecified}&vatAmount.in={vatAmountIn}&vatAmount.notIn={vatAmountNotIn}&netAmount.greaterThan={netAmountGreaterThan}&netAmount.lessThan={netAmountLessThan}&netAmount.greaterThanOrEqual={netAmountGreaterThanOrEqual}&netAmount.lessThanOrEqual={netAmountLessThanOrEqual}&netAmount.equals={netAmountEquals}&netAmount.notEquals={netAmountNotEquals}&netAmount.specified={netAmountSpecified}&netAmount.in={netAmountIn}&netAmount.notIn={netAmountNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<InvoiceDTO>> getAllInvoicesWithHttpInfo(@QueryMap(encoded=true) GetAllInvoicesQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllInvoices</code> method in a fluent style.
   */
  public static class GetAllInvoicesQueryParams extends HashMap<String, Object> {
    public GetAllInvoicesQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllInvoicesQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllInvoicesQueryParams invoiceNoContains(@jakarta.annotation.Nullable final String value) {
      put("invoiceNo.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams invoiceNoDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("invoiceNo.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams invoiceNoEquals(@jakarta.annotation.Nullable final String value) {
      put("invoiceNo.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams invoiceNoNotEquals(@jakarta.annotation.Nullable final String value) {
      put("invoiceNo.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams invoiceNoSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("invoiceNo.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams invoiceNoIn(@jakarta.annotation.Nullable final List<String> value) {
      put("invoiceNo.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllInvoicesQueryParams invoiceNoNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("invoiceNo.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllInvoicesQueryParams issuedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("issuedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams issuedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("issuedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams issuedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("issuedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams issuedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("issuedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams issuedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("issuedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams issuedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("issuedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams issuedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("issuedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams issuedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("issuedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllInvoicesQueryParams issuedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("issuedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllInvoicesQueryParams grossAmountGreaterThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("grossAmount.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams grossAmountLessThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("grossAmount.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams grossAmountGreaterThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("grossAmount.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams grossAmountLessThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("grossAmount.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams grossAmountEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("grossAmount.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams grossAmountNotEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("grossAmount.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams grossAmountSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("grossAmount.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams grossAmountIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("grossAmount.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllInvoicesQueryParams grossAmountNotIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("grossAmount.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllInvoicesQueryParams vatAmountGreaterThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("vatAmount.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams vatAmountLessThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("vatAmount.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams vatAmountGreaterThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("vatAmount.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams vatAmountLessThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("vatAmount.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams vatAmountEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("vatAmount.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams vatAmountNotEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("vatAmount.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams vatAmountSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("vatAmount.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams vatAmountIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("vatAmount.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllInvoicesQueryParams vatAmountNotIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("vatAmount.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllInvoicesQueryParams netAmountGreaterThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("netAmount.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams netAmountLessThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("netAmount.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams netAmountGreaterThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("netAmount.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams netAmountLessThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("netAmount.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams netAmountEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("netAmount.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams netAmountNotEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("netAmount.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams netAmountSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("netAmount.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams netAmountIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("netAmount.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllInvoicesQueryParams netAmountNotIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("netAmount.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllInvoicesQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllInvoicesQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllInvoicesQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllInvoicesQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllInvoicesQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllInvoicesQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllInvoicesQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllInvoicesQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllInvoicesQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllInvoicesQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllInvoicesQueryParams bookingIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams bookingIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams bookingIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams bookingIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams bookingIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams bookingIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams bookingIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("bookingId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllInvoicesQueryParams bookingIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("bookingId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllInvoicesQueryParams bookingIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("bookingId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllInvoicesQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @return InvoiceDTO
   */
  @RequestLine("GET /api/invoices/{id}")
  @Headers({
    "Accept: */*",
  })
  InvoiceDTO getInvoice(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>getInvoice</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/invoices/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<InvoiceDTO> getInvoiceWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param id  (required)
   * @param invoiceDTO  (required)
   * @return InvoiceDTO
   */
  @RequestLine("PATCH /api/invoices/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  InvoiceDTO partialUpdateInvoice(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull InvoiceDTO invoiceDTO);

  /**
   * 
   * Similar to <code>partialUpdateInvoice</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param invoiceDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /api/invoices/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<InvoiceDTO> partialUpdateInvoiceWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull InvoiceDTO invoiceDTO);



  /**
   * 
   * 
   * @param id  (required)
   * @param invoiceDTO  (required)
   * @return InvoiceDTO
   */
  @RequestLine("PUT /api/invoices/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  InvoiceDTO updateInvoice(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull InvoiceDTO invoiceDTO);

  /**
   * 
   * Similar to <code>updateInvoice</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param invoiceDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/invoices/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<InvoiceDTO> updateInvoiceWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull InvoiceDTO invoiceDTO);


}
