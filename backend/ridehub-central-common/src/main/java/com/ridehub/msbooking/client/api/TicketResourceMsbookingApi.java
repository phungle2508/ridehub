package com.ridehub.msbooking.client.api;

import com.ridehub.msbooking.client.invoker.ApiClient;
import com.ridehub.msbooking.client.invoker.EncodingUtils;
import com.ridehub.msbooking.client.model.ApiResponse;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import com.ridehub.msbooking.client.model.TicketDTO;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface TicketResourceMsbookingApi extends ApiClient.Api {


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
   * @param ticketCodeContains  (optional)
   * @param ticketCodeDoesNotContain  (optional)
   * @param ticketCodeEquals  (optional)
   * @param ticketCodeNotEquals  (optional)
   * @param ticketCodeSpecified  (optional)
   * @param ticketCodeIn  (optional)
   * @param ticketCodeNotIn  (optional)
   * @param priceGreaterThan  (optional)
   * @param priceLessThan  (optional)
   * @param priceGreaterThanOrEqual  (optional)
   * @param priceLessThanOrEqual  (optional)
   * @param priceEquals  (optional)
   * @param priceNotEquals  (optional)
   * @param priceSpecified  (optional)
   * @param priceIn  (optional)
   * @param priceNotIn  (optional)
   * @param qrCodeContains  (optional)
   * @param qrCodeDoesNotContain  (optional)
   * @param qrCodeEquals  (optional)
   * @param qrCodeNotEquals  (optional)
   * @param qrCodeSpecified  (optional)
   * @param qrCodeIn  (optional)
   * @param qrCodeNotIn  (optional)
   * @param timeFromGreaterThan  (optional)
   * @param timeFromLessThan  (optional)
   * @param timeFromGreaterThanOrEqual  (optional)
   * @param timeFromLessThanOrEqual  (optional)
   * @param timeFromEquals  (optional)
   * @param timeFromNotEquals  (optional)
   * @param timeFromSpecified  (optional)
   * @param timeFromIn  (optional)
   * @param timeFromNotIn  (optional)
   * @param timeToGreaterThan  (optional)
   * @param timeToLessThan  (optional)
   * @param timeToGreaterThanOrEqual  (optional)
   * @param timeToLessThanOrEqual  (optional)
   * @param timeToEquals  (optional)
   * @param timeToNotEquals  (optional)
   * @param timeToSpecified  (optional)
   * @param timeToIn  (optional)
   * @param timeToNotIn  (optional)
   * @param checkedInEquals  (optional)
   * @param checkedInNotEquals  (optional)
   * @param checkedInSpecified  (optional)
   * @param checkedInIn  (optional)
   * @param checkedInNotIn  (optional)
   * @param tripIdEquals  (optional)
   * @param tripIdNotEquals  (optional)
   * @param tripIdSpecified  (optional)
   * @param tripIdIn  (optional)
   * @param tripIdNotIn  (optional)
   * @param routeIdEquals  (optional)
   * @param routeIdNotEquals  (optional)
   * @param routeIdSpecified  (optional)
   * @param routeIdIn  (optional)
   * @param routeIdNotIn  (optional)
   * @param tripSeatIdEquals  (optional)
   * @param tripSeatIdNotEquals  (optional)
   * @param tripSeatIdSpecified  (optional)
   * @param tripSeatIdIn  (optional)
   * @param tripSeatIdNotIn  (optional)
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
  @RequestLine("GET /api/tickets/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&ticketCode.contains={ticketCodeContains}&ticketCode.doesNotContain={ticketCodeDoesNotContain}&ticketCode.equals={ticketCodeEquals}&ticketCode.notEquals={ticketCodeNotEquals}&ticketCode.specified={ticketCodeSpecified}&ticketCode.in={ticketCodeIn}&ticketCode.notIn={ticketCodeNotIn}&price.greaterThan={priceGreaterThan}&price.lessThan={priceLessThan}&price.greaterThanOrEqual={priceGreaterThanOrEqual}&price.lessThanOrEqual={priceLessThanOrEqual}&price.equals={priceEquals}&price.notEquals={priceNotEquals}&price.specified={priceSpecified}&price.in={priceIn}&price.notIn={priceNotIn}&qrCode.contains={qrCodeContains}&qrCode.doesNotContain={qrCodeDoesNotContain}&qrCode.equals={qrCodeEquals}&qrCode.notEquals={qrCodeNotEquals}&qrCode.specified={qrCodeSpecified}&qrCode.in={qrCodeIn}&qrCode.notIn={qrCodeNotIn}&timeFrom.greaterThan={timeFromGreaterThan}&timeFrom.lessThan={timeFromLessThan}&timeFrom.greaterThanOrEqual={timeFromGreaterThanOrEqual}&timeFrom.lessThanOrEqual={timeFromLessThanOrEqual}&timeFrom.equals={timeFromEquals}&timeFrom.notEquals={timeFromNotEquals}&timeFrom.specified={timeFromSpecified}&timeFrom.in={timeFromIn}&timeFrom.notIn={timeFromNotIn}&timeTo.greaterThan={timeToGreaterThan}&timeTo.lessThan={timeToLessThan}&timeTo.greaterThanOrEqual={timeToGreaterThanOrEqual}&timeTo.lessThanOrEqual={timeToLessThanOrEqual}&timeTo.equals={timeToEquals}&timeTo.notEquals={timeToNotEquals}&timeTo.specified={timeToSpecified}&timeTo.in={timeToIn}&timeTo.notIn={timeToNotIn}&checkedIn.equals={checkedInEquals}&checkedIn.notEquals={checkedInNotEquals}&checkedIn.specified={checkedInSpecified}&checkedIn.in={checkedInIn}&checkedIn.notIn={checkedInNotIn}&tripId.equals={tripIdEquals}&tripId.notEquals={tripIdNotEquals}&tripId.specified={tripIdSpecified}&tripId.in={tripIdIn}&tripId.notIn={tripIdNotIn}&routeId.equals={routeIdEquals}&routeId.notEquals={routeIdNotEquals}&routeId.specified={routeIdSpecified}&routeId.in={routeIdIn}&routeId.notIn={routeIdNotIn}&tripSeatId.equals={tripSeatIdEquals}&tripSeatId.notEquals={tripSeatIdNotEquals}&tripSeatId.specified={tripSeatIdSpecified}&tripSeatId.in={tripSeatIdIn}&tripSeatId.notIn={tripSeatIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  Long countTickets(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("ticketCodeContains") @jakarta.annotation.Nullable String ticketCodeContains, @Param("ticketCodeDoesNotContain") @jakarta.annotation.Nullable String ticketCodeDoesNotContain, @Param("ticketCodeEquals") @jakarta.annotation.Nullable String ticketCodeEquals, @Param("ticketCodeNotEquals") @jakarta.annotation.Nullable String ticketCodeNotEquals, @Param("ticketCodeSpecified") @jakarta.annotation.Nullable Boolean ticketCodeSpecified, @Param("ticketCodeIn") @jakarta.annotation.Nullable List<String> ticketCodeIn, @Param("ticketCodeNotIn") @jakarta.annotation.Nullable List<String> ticketCodeNotIn, @Param("priceGreaterThan") @jakarta.annotation.Nullable BigDecimal priceGreaterThan, @Param("priceLessThan") @jakarta.annotation.Nullable BigDecimal priceLessThan, @Param("priceGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal priceGreaterThanOrEqual, @Param("priceLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal priceLessThanOrEqual, @Param("priceEquals") @jakarta.annotation.Nullable BigDecimal priceEquals, @Param("priceNotEquals") @jakarta.annotation.Nullable BigDecimal priceNotEquals, @Param("priceSpecified") @jakarta.annotation.Nullable Boolean priceSpecified, @Param("priceIn") @jakarta.annotation.Nullable List<BigDecimal> priceIn, @Param("priceNotIn") @jakarta.annotation.Nullable List<BigDecimal> priceNotIn, @Param("qrCodeContains") @jakarta.annotation.Nullable String qrCodeContains, @Param("qrCodeDoesNotContain") @jakarta.annotation.Nullable String qrCodeDoesNotContain, @Param("qrCodeEquals") @jakarta.annotation.Nullable String qrCodeEquals, @Param("qrCodeNotEquals") @jakarta.annotation.Nullable String qrCodeNotEquals, @Param("qrCodeSpecified") @jakarta.annotation.Nullable Boolean qrCodeSpecified, @Param("qrCodeIn") @jakarta.annotation.Nullable List<String> qrCodeIn, @Param("qrCodeNotIn") @jakarta.annotation.Nullable List<String> qrCodeNotIn, @Param("timeFromGreaterThan") @jakarta.annotation.Nullable OffsetDateTime timeFromGreaterThan, @Param("timeFromLessThan") @jakarta.annotation.Nullable OffsetDateTime timeFromLessThan, @Param("timeFromGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime timeFromGreaterThanOrEqual, @Param("timeFromLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime timeFromLessThanOrEqual, @Param("timeFromEquals") @jakarta.annotation.Nullable OffsetDateTime timeFromEquals, @Param("timeFromNotEquals") @jakarta.annotation.Nullable OffsetDateTime timeFromNotEquals, @Param("timeFromSpecified") @jakarta.annotation.Nullable Boolean timeFromSpecified, @Param("timeFromIn") @jakarta.annotation.Nullable List<OffsetDateTime> timeFromIn, @Param("timeFromNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> timeFromNotIn, @Param("timeToGreaterThan") @jakarta.annotation.Nullable OffsetDateTime timeToGreaterThan, @Param("timeToLessThan") @jakarta.annotation.Nullable OffsetDateTime timeToLessThan, @Param("timeToGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime timeToGreaterThanOrEqual, @Param("timeToLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime timeToLessThanOrEqual, @Param("timeToEquals") @jakarta.annotation.Nullable OffsetDateTime timeToEquals, @Param("timeToNotEquals") @jakarta.annotation.Nullable OffsetDateTime timeToNotEquals, @Param("timeToSpecified") @jakarta.annotation.Nullable Boolean timeToSpecified, @Param("timeToIn") @jakarta.annotation.Nullable List<OffsetDateTime> timeToIn, @Param("timeToNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> timeToNotIn, @Param("checkedInEquals") @jakarta.annotation.Nullable Boolean checkedInEquals, @Param("checkedInNotEquals") @jakarta.annotation.Nullable Boolean checkedInNotEquals, @Param("checkedInSpecified") @jakarta.annotation.Nullable Boolean checkedInSpecified, @Param("checkedInIn") @jakarta.annotation.Nullable List<Boolean> checkedInIn, @Param("checkedInNotIn") @jakarta.annotation.Nullable List<Boolean> checkedInNotIn, @Param("tripIdEquals") @jakarta.annotation.Nullable UUID tripIdEquals, @Param("tripIdNotEquals") @jakarta.annotation.Nullable UUID tripIdNotEquals, @Param("tripIdSpecified") @jakarta.annotation.Nullable Boolean tripIdSpecified, @Param("tripIdIn") @jakarta.annotation.Nullable List<UUID> tripIdIn, @Param("tripIdNotIn") @jakarta.annotation.Nullable List<UUID> tripIdNotIn, @Param("routeIdEquals") @jakarta.annotation.Nullable UUID routeIdEquals, @Param("routeIdNotEquals") @jakarta.annotation.Nullable UUID routeIdNotEquals, @Param("routeIdSpecified") @jakarta.annotation.Nullable Boolean routeIdSpecified, @Param("routeIdIn") @jakarta.annotation.Nullable List<UUID> routeIdIn, @Param("routeIdNotIn") @jakarta.annotation.Nullable List<UUID> routeIdNotIn, @Param("tripSeatIdEquals") @jakarta.annotation.Nullable UUID tripSeatIdEquals, @Param("tripSeatIdNotEquals") @jakarta.annotation.Nullable UUID tripSeatIdNotEquals, @Param("tripSeatIdSpecified") @jakarta.annotation.Nullable Boolean tripSeatIdSpecified, @Param("tripSeatIdIn") @jakarta.annotation.Nullable List<UUID> tripSeatIdIn, @Param("tripSeatIdNotIn") @jakarta.annotation.Nullable List<UUID> tripSeatIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("bookingIdGreaterThan") @jakarta.annotation.Nullable Long bookingIdGreaterThan, @Param("bookingIdLessThan") @jakarta.annotation.Nullable Long bookingIdLessThan, @Param("bookingIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long bookingIdGreaterThanOrEqual, @Param("bookingIdLessThanOrEqual") @jakarta.annotation.Nullable Long bookingIdLessThanOrEqual, @Param("bookingIdEquals") @jakarta.annotation.Nullable Long bookingIdEquals, @Param("bookingIdNotEquals") @jakarta.annotation.Nullable Long bookingIdNotEquals, @Param("bookingIdSpecified") @jakarta.annotation.Nullable Boolean bookingIdSpecified, @Param("bookingIdIn") @jakarta.annotation.Nullable List<Long> bookingIdIn, @Param("bookingIdNotIn") @jakarta.annotation.Nullable List<Long> bookingIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>countTickets</code> but it also returns the http response headers .
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
   * @param ticketCodeContains  (optional)
   * @param ticketCodeDoesNotContain  (optional)
   * @param ticketCodeEquals  (optional)
   * @param ticketCodeNotEquals  (optional)
   * @param ticketCodeSpecified  (optional)
   * @param ticketCodeIn  (optional)
   * @param ticketCodeNotIn  (optional)
   * @param priceGreaterThan  (optional)
   * @param priceLessThan  (optional)
   * @param priceGreaterThanOrEqual  (optional)
   * @param priceLessThanOrEqual  (optional)
   * @param priceEquals  (optional)
   * @param priceNotEquals  (optional)
   * @param priceSpecified  (optional)
   * @param priceIn  (optional)
   * @param priceNotIn  (optional)
   * @param qrCodeContains  (optional)
   * @param qrCodeDoesNotContain  (optional)
   * @param qrCodeEquals  (optional)
   * @param qrCodeNotEquals  (optional)
   * @param qrCodeSpecified  (optional)
   * @param qrCodeIn  (optional)
   * @param qrCodeNotIn  (optional)
   * @param timeFromGreaterThan  (optional)
   * @param timeFromLessThan  (optional)
   * @param timeFromGreaterThanOrEqual  (optional)
   * @param timeFromLessThanOrEqual  (optional)
   * @param timeFromEquals  (optional)
   * @param timeFromNotEquals  (optional)
   * @param timeFromSpecified  (optional)
   * @param timeFromIn  (optional)
   * @param timeFromNotIn  (optional)
   * @param timeToGreaterThan  (optional)
   * @param timeToLessThan  (optional)
   * @param timeToGreaterThanOrEqual  (optional)
   * @param timeToLessThanOrEqual  (optional)
   * @param timeToEquals  (optional)
   * @param timeToNotEquals  (optional)
   * @param timeToSpecified  (optional)
   * @param timeToIn  (optional)
   * @param timeToNotIn  (optional)
   * @param checkedInEquals  (optional)
   * @param checkedInNotEquals  (optional)
   * @param checkedInSpecified  (optional)
   * @param checkedInIn  (optional)
   * @param checkedInNotIn  (optional)
   * @param tripIdEquals  (optional)
   * @param tripIdNotEquals  (optional)
   * @param tripIdSpecified  (optional)
   * @param tripIdIn  (optional)
   * @param tripIdNotIn  (optional)
   * @param routeIdEquals  (optional)
   * @param routeIdNotEquals  (optional)
   * @param routeIdSpecified  (optional)
   * @param routeIdIn  (optional)
   * @param routeIdNotIn  (optional)
   * @param tripSeatIdEquals  (optional)
   * @param tripSeatIdNotEquals  (optional)
   * @param tripSeatIdSpecified  (optional)
   * @param tripSeatIdIn  (optional)
   * @param tripSeatIdNotIn  (optional)
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
  @RequestLine("GET /api/tickets/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&ticketCode.contains={ticketCodeContains}&ticketCode.doesNotContain={ticketCodeDoesNotContain}&ticketCode.equals={ticketCodeEquals}&ticketCode.notEquals={ticketCodeNotEquals}&ticketCode.specified={ticketCodeSpecified}&ticketCode.in={ticketCodeIn}&ticketCode.notIn={ticketCodeNotIn}&price.greaterThan={priceGreaterThan}&price.lessThan={priceLessThan}&price.greaterThanOrEqual={priceGreaterThanOrEqual}&price.lessThanOrEqual={priceLessThanOrEqual}&price.equals={priceEquals}&price.notEquals={priceNotEquals}&price.specified={priceSpecified}&price.in={priceIn}&price.notIn={priceNotIn}&qrCode.contains={qrCodeContains}&qrCode.doesNotContain={qrCodeDoesNotContain}&qrCode.equals={qrCodeEquals}&qrCode.notEquals={qrCodeNotEquals}&qrCode.specified={qrCodeSpecified}&qrCode.in={qrCodeIn}&qrCode.notIn={qrCodeNotIn}&timeFrom.greaterThan={timeFromGreaterThan}&timeFrom.lessThan={timeFromLessThan}&timeFrom.greaterThanOrEqual={timeFromGreaterThanOrEqual}&timeFrom.lessThanOrEqual={timeFromLessThanOrEqual}&timeFrom.equals={timeFromEquals}&timeFrom.notEquals={timeFromNotEquals}&timeFrom.specified={timeFromSpecified}&timeFrom.in={timeFromIn}&timeFrom.notIn={timeFromNotIn}&timeTo.greaterThan={timeToGreaterThan}&timeTo.lessThan={timeToLessThan}&timeTo.greaterThanOrEqual={timeToGreaterThanOrEqual}&timeTo.lessThanOrEqual={timeToLessThanOrEqual}&timeTo.equals={timeToEquals}&timeTo.notEquals={timeToNotEquals}&timeTo.specified={timeToSpecified}&timeTo.in={timeToIn}&timeTo.notIn={timeToNotIn}&checkedIn.equals={checkedInEquals}&checkedIn.notEquals={checkedInNotEquals}&checkedIn.specified={checkedInSpecified}&checkedIn.in={checkedInIn}&checkedIn.notIn={checkedInNotIn}&tripId.equals={tripIdEquals}&tripId.notEquals={tripIdNotEquals}&tripId.specified={tripIdSpecified}&tripId.in={tripIdIn}&tripId.notIn={tripIdNotIn}&routeId.equals={routeIdEquals}&routeId.notEquals={routeIdNotEquals}&routeId.specified={routeIdSpecified}&routeId.in={routeIdIn}&routeId.notIn={routeIdNotIn}&tripSeatId.equals={tripSeatIdEquals}&tripSeatId.notEquals={tripSeatIdNotEquals}&tripSeatId.specified={tripSeatIdSpecified}&tripSeatId.in={tripSeatIdIn}&tripSeatId.notIn={tripSeatIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Long> countTicketsWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("ticketCodeContains") @jakarta.annotation.Nullable String ticketCodeContains, @Param("ticketCodeDoesNotContain") @jakarta.annotation.Nullable String ticketCodeDoesNotContain, @Param("ticketCodeEquals") @jakarta.annotation.Nullable String ticketCodeEquals, @Param("ticketCodeNotEquals") @jakarta.annotation.Nullable String ticketCodeNotEquals, @Param("ticketCodeSpecified") @jakarta.annotation.Nullable Boolean ticketCodeSpecified, @Param("ticketCodeIn") @jakarta.annotation.Nullable List<String> ticketCodeIn, @Param("ticketCodeNotIn") @jakarta.annotation.Nullable List<String> ticketCodeNotIn, @Param("priceGreaterThan") @jakarta.annotation.Nullable BigDecimal priceGreaterThan, @Param("priceLessThan") @jakarta.annotation.Nullable BigDecimal priceLessThan, @Param("priceGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal priceGreaterThanOrEqual, @Param("priceLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal priceLessThanOrEqual, @Param("priceEquals") @jakarta.annotation.Nullable BigDecimal priceEquals, @Param("priceNotEquals") @jakarta.annotation.Nullable BigDecimal priceNotEquals, @Param("priceSpecified") @jakarta.annotation.Nullable Boolean priceSpecified, @Param("priceIn") @jakarta.annotation.Nullable List<BigDecimal> priceIn, @Param("priceNotIn") @jakarta.annotation.Nullable List<BigDecimal> priceNotIn, @Param("qrCodeContains") @jakarta.annotation.Nullable String qrCodeContains, @Param("qrCodeDoesNotContain") @jakarta.annotation.Nullable String qrCodeDoesNotContain, @Param("qrCodeEquals") @jakarta.annotation.Nullable String qrCodeEquals, @Param("qrCodeNotEquals") @jakarta.annotation.Nullable String qrCodeNotEquals, @Param("qrCodeSpecified") @jakarta.annotation.Nullable Boolean qrCodeSpecified, @Param("qrCodeIn") @jakarta.annotation.Nullable List<String> qrCodeIn, @Param("qrCodeNotIn") @jakarta.annotation.Nullable List<String> qrCodeNotIn, @Param("timeFromGreaterThan") @jakarta.annotation.Nullable OffsetDateTime timeFromGreaterThan, @Param("timeFromLessThan") @jakarta.annotation.Nullable OffsetDateTime timeFromLessThan, @Param("timeFromGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime timeFromGreaterThanOrEqual, @Param("timeFromLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime timeFromLessThanOrEqual, @Param("timeFromEquals") @jakarta.annotation.Nullable OffsetDateTime timeFromEquals, @Param("timeFromNotEquals") @jakarta.annotation.Nullable OffsetDateTime timeFromNotEquals, @Param("timeFromSpecified") @jakarta.annotation.Nullable Boolean timeFromSpecified, @Param("timeFromIn") @jakarta.annotation.Nullable List<OffsetDateTime> timeFromIn, @Param("timeFromNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> timeFromNotIn, @Param("timeToGreaterThan") @jakarta.annotation.Nullable OffsetDateTime timeToGreaterThan, @Param("timeToLessThan") @jakarta.annotation.Nullable OffsetDateTime timeToLessThan, @Param("timeToGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime timeToGreaterThanOrEqual, @Param("timeToLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime timeToLessThanOrEqual, @Param("timeToEquals") @jakarta.annotation.Nullable OffsetDateTime timeToEquals, @Param("timeToNotEquals") @jakarta.annotation.Nullable OffsetDateTime timeToNotEquals, @Param("timeToSpecified") @jakarta.annotation.Nullable Boolean timeToSpecified, @Param("timeToIn") @jakarta.annotation.Nullable List<OffsetDateTime> timeToIn, @Param("timeToNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> timeToNotIn, @Param("checkedInEquals") @jakarta.annotation.Nullable Boolean checkedInEquals, @Param("checkedInNotEquals") @jakarta.annotation.Nullable Boolean checkedInNotEquals, @Param("checkedInSpecified") @jakarta.annotation.Nullable Boolean checkedInSpecified, @Param("checkedInIn") @jakarta.annotation.Nullable List<Boolean> checkedInIn, @Param("checkedInNotIn") @jakarta.annotation.Nullable List<Boolean> checkedInNotIn, @Param("tripIdEquals") @jakarta.annotation.Nullable UUID tripIdEquals, @Param("tripIdNotEquals") @jakarta.annotation.Nullable UUID tripIdNotEquals, @Param("tripIdSpecified") @jakarta.annotation.Nullable Boolean tripIdSpecified, @Param("tripIdIn") @jakarta.annotation.Nullable List<UUID> tripIdIn, @Param("tripIdNotIn") @jakarta.annotation.Nullable List<UUID> tripIdNotIn, @Param("routeIdEquals") @jakarta.annotation.Nullable UUID routeIdEquals, @Param("routeIdNotEquals") @jakarta.annotation.Nullable UUID routeIdNotEquals, @Param("routeIdSpecified") @jakarta.annotation.Nullable Boolean routeIdSpecified, @Param("routeIdIn") @jakarta.annotation.Nullable List<UUID> routeIdIn, @Param("routeIdNotIn") @jakarta.annotation.Nullable List<UUID> routeIdNotIn, @Param("tripSeatIdEquals") @jakarta.annotation.Nullable UUID tripSeatIdEquals, @Param("tripSeatIdNotEquals") @jakarta.annotation.Nullable UUID tripSeatIdNotEquals, @Param("tripSeatIdSpecified") @jakarta.annotation.Nullable Boolean tripSeatIdSpecified, @Param("tripSeatIdIn") @jakarta.annotation.Nullable List<UUID> tripSeatIdIn, @Param("tripSeatIdNotIn") @jakarta.annotation.Nullable List<UUID> tripSeatIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("bookingIdGreaterThan") @jakarta.annotation.Nullable Long bookingIdGreaterThan, @Param("bookingIdLessThan") @jakarta.annotation.Nullable Long bookingIdLessThan, @Param("bookingIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long bookingIdGreaterThanOrEqual, @Param("bookingIdLessThanOrEqual") @jakarta.annotation.Nullable Long bookingIdLessThanOrEqual, @Param("bookingIdEquals") @jakarta.annotation.Nullable Long bookingIdEquals, @Param("bookingIdNotEquals") @jakarta.annotation.Nullable Long bookingIdNotEquals, @Param("bookingIdSpecified") @jakarta.annotation.Nullable Boolean bookingIdSpecified, @Param("bookingIdIn") @jakarta.annotation.Nullable List<Long> bookingIdIn, @Param("bookingIdNotIn") @jakarta.annotation.Nullable List<Long> bookingIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>countTickets</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CountTicketsQueryParams} class that allows for
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
   *   <li>ticketCodeContains -  (optional)</li>
   *   <li>ticketCodeDoesNotContain -  (optional)</li>
   *   <li>ticketCodeEquals -  (optional)</li>
   *   <li>ticketCodeNotEquals -  (optional)</li>
   *   <li>ticketCodeSpecified -  (optional)</li>
   *   <li>ticketCodeIn -  (optional)</li>
   *   <li>ticketCodeNotIn -  (optional)</li>
   *   <li>priceGreaterThan -  (optional)</li>
   *   <li>priceLessThan -  (optional)</li>
   *   <li>priceGreaterThanOrEqual -  (optional)</li>
   *   <li>priceLessThanOrEqual -  (optional)</li>
   *   <li>priceEquals -  (optional)</li>
   *   <li>priceNotEquals -  (optional)</li>
   *   <li>priceSpecified -  (optional)</li>
   *   <li>priceIn -  (optional)</li>
   *   <li>priceNotIn -  (optional)</li>
   *   <li>qrCodeContains -  (optional)</li>
   *   <li>qrCodeDoesNotContain -  (optional)</li>
   *   <li>qrCodeEquals -  (optional)</li>
   *   <li>qrCodeNotEquals -  (optional)</li>
   *   <li>qrCodeSpecified -  (optional)</li>
   *   <li>qrCodeIn -  (optional)</li>
   *   <li>qrCodeNotIn -  (optional)</li>
   *   <li>timeFromGreaterThan -  (optional)</li>
   *   <li>timeFromLessThan -  (optional)</li>
   *   <li>timeFromGreaterThanOrEqual -  (optional)</li>
   *   <li>timeFromLessThanOrEqual -  (optional)</li>
   *   <li>timeFromEquals -  (optional)</li>
   *   <li>timeFromNotEquals -  (optional)</li>
   *   <li>timeFromSpecified -  (optional)</li>
   *   <li>timeFromIn -  (optional)</li>
   *   <li>timeFromNotIn -  (optional)</li>
   *   <li>timeToGreaterThan -  (optional)</li>
   *   <li>timeToLessThan -  (optional)</li>
   *   <li>timeToGreaterThanOrEqual -  (optional)</li>
   *   <li>timeToLessThanOrEqual -  (optional)</li>
   *   <li>timeToEquals -  (optional)</li>
   *   <li>timeToNotEquals -  (optional)</li>
   *   <li>timeToSpecified -  (optional)</li>
   *   <li>timeToIn -  (optional)</li>
   *   <li>timeToNotIn -  (optional)</li>
   *   <li>checkedInEquals -  (optional)</li>
   *   <li>checkedInNotEquals -  (optional)</li>
   *   <li>checkedInSpecified -  (optional)</li>
   *   <li>checkedInIn -  (optional)</li>
   *   <li>checkedInNotIn -  (optional)</li>
   *   <li>tripIdEquals -  (optional)</li>
   *   <li>tripIdNotEquals -  (optional)</li>
   *   <li>tripIdSpecified -  (optional)</li>
   *   <li>tripIdIn -  (optional)</li>
   *   <li>tripIdNotIn -  (optional)</li>
   *   <li>routeIdEquals -  (optional)</li>
   *   <li>routeIdNotEquals -  (optional)</li>
   *   <li>routeIdSpecified -  (optional)</li>
   *   <li>routeIdIn -  (optional)</li>
   *   <li>routeIdNotIn -  (optional)</li>
   *   <li>tripSeatIdEquals -  (optional)</li>
   *   <li>tripSeatIdNotEquals -  (optional)</li>
   *   <li>tripSeatIdSpecified -  (optional)</li>
   *   <li>tripSeatIdIn -  (optional)</li>
   *   <li>tripSeatIdNotIn -  (optional)</li>
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
  @RequestLine("GET /api/tickets/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&ticketCode.contains={ticketCodeContains}&ticketCode.doesNotContain={ticketCodeDoesNotContain}&ticketCode.equals={ticketCodeEquals}&ticketCode.notEquals={ticketCodeNotEquals}&ticketCode.specified={ticketCodeSpecified}&ticketCode.in={ticketCodeIn}&ticketCode.notIn={ticketCodeNotIn}&price.greaterThan={priceGreaterThan}&price.lessThan={priceLessThan}&price.greaterThanOrEqual={priceGreaterThanOrEqual}&price.lessThanOrEqual={priceLessThanOrEqual}&price.equals={priceEquals}&price.notEquals={priceNotEquals}&price.specified={priceSpecified}&price.in={priceIn}&price.notIn={priceNotIn}&qrCode.contains={qrCodeContains}&qrCode.doesNotContain={qrCodeDoesNotContain}&qrCode.equals={qrCodeEquals}&qrCode.notEquals={qrCodeNotEquals}&qrCode.specified={qrCodeSpecified}&qrCode.in={qrCodeIn}&qrCode.notIn={qrCodeNotIn}&timeFrom.greaterThan={timeFromGreaterThan}&timeFrom.lessThan={timeFromLessThan}&timeFrom.greaterThanOrEqual={timeFromGreaterThanOrEqual}&timeFrom.lessThanOrEqual={timeFromLessThanOrEqual}&timeFrom.equals={timeFromEquals}&timeFrom.notEquals={timeFromNotEquals}&timeFrom.specified={timeFromSpecified}&timeFrom.in={timeFromIn}&timeFrom.notIn={timeFromNotIn}&timeTo.greaterThan={timeToGreaterThan}&timeTo.lessThan={timeToLessThan}&timeTo.greaterThanOrEqual={timeToGreaterThanOrEqual}&timeTo.lessThanOrEqual={timeToLessThanOrEqual}&timeTo.equals={timeToEquals}&timeTo.notEquals={timeToNotEquals}&timeTo.specified={timeToSpecified}&timeTo.in={timeToIn}&timeTo.notIn={timeToNotIn}&checkedIn.equals={checkedInEquals}&checkedIn.notEquals={checkedInNotEquals}&checkedIn.specified={checkedInSpecified}&checkedIn.in={checkedInIn}&checkedIn.notIn={checkedInNotIn}&tripId.equals={tripIdEquals}&tripId.notEquals={tripIdNotEquals}&tripId.specified={tripIdSpecified}&tripId.in={tripIdIn}&tripId.notIn={tripIdNotIn}&routeId.equals={routeIdEquals}&routeId.notEquals={routeIdNotEquals}&routeId.specified={routeIdSpecified}&routeId.in={routeIdIn}&routeId.notIn={routeIdNotIn}&tripSeatId.equals={tripSeatIdEquals}&tripSeatId.notEquals={tripSeatIdNotEquals}&tripSeatId.specified={tripSeatIdSpecified}&tripSeatId.in={tripSeatIdIn}&tripSeatId.notIn={tripSeatIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  Long countTickets(@QueryMap(encoded=true) CountTicketsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>countTickets</code> that receives the query parameters as a map,
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
          *   <li>ticketCodeContains -  (optional)</li>
          *   <li>ticketCodeDoesNotContain -  (optional)</li>
          *   <li>ticketCodeEquals -  (optional)</li>
          *   <li>ticketCodeNotEquals -  (optional)</li>
          *   <li>ticketCodeSpecified -  (optional)</li>
          *   <li>ticketCodeIn -  (optional)</li>
          *   <li>ticketCodeNotIn -  (optional)</li>
          *   <li>priceGreaterThan -  (optional)</li>
          *   <li>priceLessThan -  (optional)</li>
          *   <li>priceGreaterThanOrEqual -  (optional)</li>
          *   <li>priceLessThanOrEqual -  (optional)</li>
          *   <li>priceEquals -  (optional)</li>
          *   <li>priceNotEquals -  (optional)</li>
          *   <li>priceSpecified -  (optional)</li>
          *   <li>priceIn -  (optional)</li>
          *   <li>priceNotIn -  (optional)</li>
          *   <li>qrCodeContains -  (optional)</li>
          *   <li>qrCodeDoesNotContain -  (optional)</li>
          *   <li>qrCodeEquals -  (optional)</li>
          *   <li>qrCodeNotEquals -  (optional)</li>
          *   <li>qrCodeSpecified -  (optional)</li>
          *   <li>qrCodeIn -  (optional)</li>
          *   <li>qrCodeNotIn -  (optional)</li>
          *   <li>timeFromGreaterThan -  (optional)</li>
          *   <li>timeFromLessThan -  (optional)</li>
          *   <li>timeFromGreaterThanOrEqual -  (optional)</li>
          *   <li>timeFromLessThanOrEqual -  (optional)</li>
          *   <li>timeFromEquals -  (optional)</li>
          *   <li>timeFromNotEquals -  (optional)</li>
          *   <li>timeFromSpecified -  (optional)</li>
          *   <li>timeFromIn -  (optional)</li>
          *   <li>timeFromNotIn -  (optional)</li>
          *   <li>timeToGreaterThan -  (optional)</li>
          *   <li>timeToLessThan -  (optional)</li>
          *   <li>timeToGreaterThanOrEqual -  (optional)</li>
          *   <li>timeToLessThanOrEqual -  (optional)</li>
          *   <li>timeToEquals -  (optional)</li>
          *   <li>timeToNotEquals -  (optional)</li>
          *   <li>timeToSpecified -  (optional)</li>
          *   <li>timeToIn -  (optional)</li>
          *   <li>timeToNotIn -  (optional)</li>
          *   <li>checkedInEquals -  (optional)</li>
          *   <li>checkedInNotEquals -  (optional)</li>
          *   <li>checkedInSpecified -  (optional)</li>
          *   <li>checkedInIn -  (optional)</li>
          *   <li>checkedInNotIn -  (optional)</li>
          *   <li>tripIdEquals -  (optional)</li>
          *   <li>tripIdNotEquals -  (optional)</li>
          *   <li>tripIdSpecified -  (optional)</li>
          *   <li>tripIdIn -  (optional)</li>
          *   <li>tripIdNotIn -  (optional)</li>
          *   <li>routeIdEquals -  (optional)</li>
          *   <li>routeIdNotEquals -  (optional)</li>
          *   <li>routeIdSpecified -  (optional)</li>
          *   <li>routeIdIn -  (optional)</li>
          *   <li>routeIdNotIn -  (optional)</li>
          *   <li>tripSeatIdEquals -  (optional)</li>
          *   <li>tripSeatIdNotEquals -  (optional)</li>
          *   <li>tripSeatIdSpecified -  (optional)</li>
          *   <li>tripSeatIdIn -  (optional)</li>
          *   <li>tripSeatIdNotIn -  (optional)</li>
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
      @RequestLine("GET /api/tickets/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&ticketCode.contains={ticketCodeContains}&ticketCode.doesNotContain={ticketCodeDoesNotContain}&ticketCode.equals={ticketCodeEquals}&ticketCode.notEquals={ticketCodeNotEquals}&ticketCode.specified={ticketCodeSpecified}&ticketCode.in={ticketCodeIn}&ticketCode.notIn={ticketCodeNotIn}&price.greaterThan={priceGreaterThan}&price.lessThan={priceLessThan}&price.greaterThanOrEqual={priceGreaterThanOrEqual}&price.lessThanOrEqual={priceLessThanOrEqual}&price.equals={priceEquals}&price.notEquals={priceNotEquals}&price.specified={priceSpecified}&price.in={priceIn}&price.notIn={priceNotIn}&qrCode.contains={qrCodeContains}&qrCode.doesNotContain={qrCodeDoesNotContain}&qrCode.equals={qrCodeEquals}&qrCode.notEquals={qrCodeNotEquals}&qrCode.specified={qrCodeSpecified}&qrCode.in={qrCodeIn}&qrCode.notIn={qrCodeNotIn}&timeFrom.greaterThan={timeFromGreaterThan}&timeFrom.lessThan={timeFromLessThan}&timeFrom.greaterThanOrEqual={timeFromGreaterThanOrEqual}&timeFrom.lessThanOrEqual={timeFromLessThanOrEqual}&timeFrom.equals={timeFromEquals}&timeFrom.notEquals={timeFromNotEquals}&timeFrom.specified={timeFromSpecified}&timeFrom.in={timeFromIn}&timeFrom.notIn={timeFromNotIn}&timeTo.greaterThan={timeToGreaterThan}&timeTo.lessThan={timeToLessThan}&timeTo.greaterThanOrEqual={timeToGreaterThanOrEqual}&timeTo.lessThanOrEqual={timeToLessThanOrEqual}&timeTo.equals={timeToEquals}&timeTo.notEquals={timeToNotEquals}&timeTo.specified={timeToSpecified}&timeTo.in={timeToIn}&timeTo.notIn={timeToNotIn}&checkedIn.equals={checkedInEquals}&checkedIn.notEquals={checkedInNotEquals}&checkedIn.specified={checkedInSpecified}&checkedIn.in={checkedInIn}&checkedIn.notIn={checkedInNotIn}&tripId.equals={tripIdEquals}&tripId.notEquals={tripIdNotEquals}&tripId.specified={tripIdSpecified}&tripId.in={tripIdIn}&tripId.notIn={tripIdNotIn}&routeId.equals={routeIdEquals}&routeId.notEquals={routeIdNotEquals}&routeId.specified={routeIdSpecified}&routeId.in={routeIdIn}&routeId.notIn={routeIdNotIn}&tripSeatId.equals={tripSeatIdEquals}&tripSeatId.notEquals={tripSeatIdNotEquals}&tripSeatId.specified={tripSeatIdSpecified}&tripSeatId.in={tripSeatIdIn}&tripSeatId.notIn={tripSeatIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Long> countTicketsWithHttpInfo(@QueryMap(encoded=true) CountTicketsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>countTickets</code> method in a fluent style.
   */
  public static class CountTicketsQueryParams extends HashMap<String, Object> {
    public CountTicketsQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountTicketsQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountTicketsQueryParams ticketCodeContains(@jakarta.annotation.Nullable final String value) {
      put("ticketCode.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams ticketCodeDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("ticketCode.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams ticketCodeEquals(@jakarta.annotation.Nullable final String value) {
      put("ticketCode.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams ticketCodeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("ticketCode.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams ticketCodeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("ticketCode.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams ticketCodeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("ticketCode.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountTicketsQueryParams ticketCodeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("ticketCode.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountTicketsQueryParams priceGreaterThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("price.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams priceLessThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("price.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams priceGreaterThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("price.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams priceLessThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("price.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams priceEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("price.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams priceNotEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("price.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams priceSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("price.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams priceIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("price.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountTicketsQueryParams priceNotIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("price.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountTicketsQueryParams qrCodeContains(@jakarta.annotation.Nullable final String value) {
      put("qrCode.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams qrCodeDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("qrCode.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams qrCodeEquals(@jakarta.annotation.Nullable final String value) {
      put("qrCode.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams qrCodeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("qrCode.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams qrCodeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("qrCode.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams qrCodeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("qrCode.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountTicketsQueryParams qrCodeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("qrCode.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountTicketsQueryParams timeFromGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("timeFrom.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams timeFromLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("timeFrom.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams timeFromGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("timeFrom.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams timeFromLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("timeFrom.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams timeFromEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("timeFrom.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams timeFromNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("timeFrom.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams timeFromSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("timeFrom.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams timeFromIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("timeFrom.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountTicketsQueryParams timeFromNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("timeFrom.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountTicketsQueryParams timeToGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("timeTo.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams timeToLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("timeTo.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams timeToGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("timeTo.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams timeToLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("timeTo.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams timeToEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("timeTo.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams timeToNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("timeTo.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams timeToSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("timeTo.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams timeToIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("timeTo.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountTicketsQueryParams timeToNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("timeTo.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountTicketsQueryParams checkedInEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("checkedIn.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams checkedInNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("checkedIn.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams checkedInSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("checkedIn.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams checkedInIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("checkedIn.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountTicketsQueryParams checkedInNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("checkedIn.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountTicketsQueryParams tripIdEquals(@jakarta.annotation.Nullable final UUID value) {
      put("tripId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams tripIdNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("tripId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams tripIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("tripId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams tripIdIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("tripId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountTicketsQueryParams tripIdNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("tripId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountTicketsQueryParams routeIdEquals(@jakarta.annotation.Nullable final UUID value) {
      put("routeId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams routeIdNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("routeId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams routeIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("routeId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams routeIdIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("routeId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountTicketsQueryParams routeIdNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("routeId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountTicketsQueryParams tripSeatIdEquals(@jakarta.annotation.Nullable final UUID value) {
      put("tripSeatId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams tripSeatIdNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("tripSeatId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams tripSeatIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("tripSeatId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams tripSeatIdIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("tripSeatId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountTicketsQueryParams tripSeatIdNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("tripSeatId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountTicketsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountTicketsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountTicketsQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountTicketsQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountTicketsQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountTicketsQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountTicketsQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountTicketsQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountTicketsQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountTicketsQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountTicketsQueryParams bookingIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams bookingIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams bookingIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams bookingIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams bookingIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams bookingIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams bookingIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("bookingId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountTicketsQueryParams bookingIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("bookingId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountTicketsQueryParams bookingIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("bookingId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountTicketsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param ticketDTO  (required)
   * @return TicketDTO
   */
  @RequestLine("POST /api/tickets")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  TicketDTO createTicket(@jakarta.annotation.Nonnull TicketDTO ticketDTO);

  /**
   * 
   * Similar to <code>createTicket</code> but it also returns the http response headers .
   * 
   * @param ticketDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/tickets")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<TicketDTO> createTicketWithHttpInfo(@jakarta.annotation.Nonnull TicketDTO ticketDTO);



  /**
   * 
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/tickets/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteTicket(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>deleteTicket</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/tickets/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteTicketWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



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
   * @param ticketCodeContains  (optional)
   * @param ticketCodeDoesNotContain  (optional)
   * @param ticketCodeEquals  (optional)
   * @param ticketCodeNotEquals  (optional)
   * @param ticketCodeSpecified  (optional)
   * @param ticketCodeIn  (optional)
   * @param ticketCodeNotIn  (optional)
   * @param priceGreaterThan  (optional)
   * @param priceLessThan  (optional)
   * @param priceGreaterThanOrEqual  (optional)
   * @param priceLessThanOrEqual  (optional)
   * @param priceEquals  (optional)
   * @param priceNotEquals  (optional)
   * @param priceSpecified  (optional)
   * @param priceIn  (optional)
   * @param priceNotIn  (optional)
   * @param qrCodeContains  (optional)
   * @param qrCodeDoesNotContain  (optional)
   * @param qrCodeEquals  (optional)
   * @param qrCodeNotEquals  (optional)
   * @param qrCodeSpecified  (optional)
   * @param qrCodeIn  (optional)
   * @param qrCodeNotIn  (optional)
   * @param timeFromGreaterThan  (optional)
   * @param timeFromLessThan  (optional)
   * @param timeFromGreaterThanOrEqual  (optional)
   * @param timeFromLessThanOrEqual  (optional)
   * @param timeFromEquals  (optional)
   * @param timeFromNotEquals  (optional)
   * @param timeFromSpecified  (optional)
   * @param timeFromIn  (optional)
   * @param timeFromNotIn  (optional)
   * @param timeToGreaterThan  (optional)
   * @param timeToLessThan  (optional)
   * @param timeToGreaterThanOrEqual  (optional)
   * @param timeToLessThanOrEqual  (optional)
   * @param timeToEquals  (optional)
   * @param timeToNotEquals  (optional)
   * @param timeToSpecified  (optional)
   * @param timeToIn  (optional)
   * @param timeToNotIn  (optional)
   * @param checkedInEquals  (optional)
   * @param checkedInNotEquals  (optional)
   * @param checkedInSpecified  (optional)
   * @param checkedInIn  (optional)
   * @param checkedInNotIn  (optional)
   * @param tripIdEquals  (optional)
   * @param tripIdNotEquals  (optional)
   * @param tripIdSpecified  (optional)
   * @param tripIdIn  (optional)
   * @param tripIdNotIn  (optional)
   * @param routeIdEquals  (optional)
   * @param routeIdNotEquals  (optional)
   * @param routeIdSpecified  (optional)
   * @param routeIdIn  (optional)
   * @param routeIdNotIn  (optional)
   * @param tripSeatIdEquals  (optional)
   * @param tripSeatIdNotEquals  (optional)
   * @param tripSeatIdSpecified  (optional)
   * @param tripSeatIdIn  (optional)
   * @param tripSeatIdNotIn  (optional)
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
   * @return List&lt;TicketDTO&gt;
   */
  @RequestLine("GET /api/tickets?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&ticketCode.contains={ticketCodeContains}&ticketCode.doesNotContain={ticketCodeDoesNotContain}&ticketCode.equals={ticketCodeEquals}&ticketCode.notEquals={ticketCodeNotEquals}&ticketCode.specified={ticketCodeSpecified}&ticketCode.in={ticketCodeIn}&ticketCode.notIn={ticketCodeNotIn}&price.greaterThan={priceGreaterThan}&price.lessThan={priceLessThan}&price.greaterThanOrEqual={priceGreaterThanOrEqual}&price.lessThanOrEqual={priceLessThanOrEqual}&price.equals={priceEquals}&price.notEquals={priceNotEquals}&price.specified={priceSpecified}&price.in={priceIn}&price.notIn={priceNotIn}&qrCode.contains={qrCodeContains}&qrCode.doesNotContain={qrCodeDoesNotContain}&qrCode.equals={qrCodeEquals}&qrCode.notEquals={qrCodeNotEquals}&qrCode.specified={qrCodeSpecified}&qrCode.in={qrCodeIn}&qrCode.notIn={qrCodeNotIn}&timeFrom.greaterThan={timeFromGreaterThan}&timeFrom.lessThan={timeFromLessThan}&timeFrom.greaterThanOrEqual={timeFromGreaterThanOrEqual}&timeFrom.lessThanOrEqual={timeFromLessThanOrEqual}&timeFrom.equals={timeFromEquals}&timeFrom.notEquals={timeFromNotEquals}&timeFrom.specified={timeFromSpecified}&timeFrom.in={timeFromIn}&timeFrom.notIn={timeFromNotIn}&timeTo.greaterThan={timeToGreaterThan}&timeTo.lessThan={timeToLessThan}&timeTo.greaterThanOrEqual={timeToGreaterThanOrEqual}&timeTo.lessThanOrEqual={timeToLessThanOrEqual}&timeTo.equals={timeToEquals}&timeTo.notEquals={timeToNotEquals}&timeTo.specified={timeToSpecified}&timeTo.in={timeToIn}&timeTo.notIn={timeToNotIn}&checkedIn.equals={checkedInEquals}&checkedIn.notEquals={checkedInNotEquals}&checkedIn.specified={checkedInSpecified}&checkedIn.in={checkedInIn}&checkedIn.notIn={checkedInNotIn}&tripId.equals={tripIdEquals}&tripId.notEquals={tripIdNotEquals}&tripId.specified={tripIdSpecified}&tripId.in={tripIdIn}&tripId.notIn={tripIdNotIn}&routeId.equals={routeIdEquals}&routeId.notEquals={routeIdNotEquals}&routeId.specified={routeIdSpecified}&routeId.in={routeIdIn}&routeId.notIn={routeIdNotIn}&tripSeatId.equals={tripSeatIdEquals}&tripSeatId.notEquals={tripSeatIdNotEquals}&tripSeatId.specified={tripSeatIdSpecified}&tripSeatId.in={tripSeatIdIn}&tripSeatId.notIn={tripSeatIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  List<TicketDTO> getAllTickets(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("ticketCodeContains") @jakarta.annotation.Nullable String ticketCodeContains, @Param("ticketCodeDoesNotContain") @jakarta.annotation.Nullable String ticketCodeDoesNotContain, @Param("ticketCodeEquals") @jakarta.annotation.Nullable String ticketCodeEquals, @Param("ticketCodeNotEquals") @jakarta.annotation.Nullable String ticketCodeNotEquals, @Param("ticketCodeSpecified") @jakarta.annotation.Nullable Boolean ticketCodeSpecified, @Param("ticketCodeIn") @jakarta.annotation.Nullable List<String> ticketCodeIn, @Param("ticketCodeNotIn") @jakarta.annotation.Nullable List<String> ticketCodeNotIn, @Param("priceGreaterThan") @jakarta.annotation.Nullable BigDecimal priceGreaterThan, @Param("priceLessThan") @jakarta.annotation.Nullable BigDecimal priceLessThan, @Param("priceGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal priceGreaterThanOrEqual, @Param("priceLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal priceLessThanOrEqual, @Param("priceEquals") @jakarta.annotation.Nullable BigDecimal priceEquals, @Param("priceNotEquals") @jakarta.annotation.Nullable BigDecimal priceNotEquals, @Param("priceSpecified") @jakarta.annotation.Nullable Boolean priceSpecified, @Param("priceIn") @jakarta.annotation.Nullable List<BigDecimal> priceIn, @Param("priceNotIn") @jakarta.annotation.Nullable List<BigDecimal> priceNotIn, @Param("qrCodeContains") @jakarta.annotation.Nullable String qrCodeContains, @Param("qrCodeDoesNotContain") @jakarta.annotation.Nullable String qrCodeDoesNotContain, @Param("qrCodeEquals") @jakarta.annotation.Nullable String qrCodeEquals, @Param("qrCodeNotEquals") @jakarta.annotation.Nullable String qrCodeNotEquals, @Param("qrCodeSpecified") @jakarta.annotation.Nullable Boolean qrCodeSpecified, @Param("qrCodeIn") @jakarta.annotation.Nullable List<String> qrCodeIn, @Param("qrCodeNotIn") @jakarta.annotation.Nullable List<String> qrCodeNotIn, @Param("timeFromGreaterThan") @jakarta.annotation.Nullable OffsetDateTime timeFromGreaterThan, @Param("timeFromLessThan") @jakarta.annotation.Nullable OffsetDateTime timeFromLessThan, @Param("timeFromGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime timeFromGreaterThanOrEqual, @Param("timeFromLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime timeFromLessThanOrEqual, @Param("timeFromEquals") @jakarta.annotation.Nullable OffsetDateTime timeFromEquals, @Param("timeFromNotEquals") @jakarta.annotation.Nullable OffsetDateTime timeFromNotEquals, @Param("timeFromSpecified") @jakarta.annotation.Nullable Boolean timeFromSpecified, @Param("timeFromIn") @jakarta.annotation.Nullable List<OffsetDateTime> timeFromIn, @Param("timeFromNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> timeFromNotIn, @Param("timeToGreaterThan") @jakarta.annotation.Nullable OffsetDateTime timeToGreaterThan, @Param("timeToLessThan") @jakarta.annotation.Nullable OffsetDateTime timeToLessThan, @Param("timeToGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime timeToGreaterThanOrEqual, @Param("timeToLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime timeToLessThanOrEqual, @Param("timeToEquals") @jakarta.annotation.Nullable OffsetDateTime timeToEquals, @Param("timeToNotEquals") @jakarta.annotation.Nullable OffsetDateTime timeToNotEquals, @Param("timeToSpecified") @jakarta.annotation.Nullable Boolean timeToSpecified, @Param("timeToIn") @jakarta.annotation.Nullable List<OffsetDateTime> timeToIn, @Param("timeToNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> timeToNotIn, @Param("checkedInEquals") @jakarta.annotation.Nullable Boolean checkedInEquals, @Param("checkedInNotEquals") @jakarta.annotation.Nullable Boolean checkedInNotEquals, @Param("checkedInSpecified") @jakarta.annotation.Nullable Boolean checkedInSpecified, @Param("checkedInIn") @jakarta.annotation.Nullable List<Boolean> checkedInIn, @Param("checkedInNotIn") @jakarta.annotation.Nullable List<Boolean> checkedInNotIn, @Param("tripIdEquals") @jakarta.annotation.Nullable UUID tripIdEquals, @Param("tripIdNotEquals") @jakarta.annotation.Nullable UUID tripIdNotEquals, @Param("tripIdSpecified") @jakarta.annotation.Nullable Boolean tripIdSpecified, @Param("tripIdIn") @jakarta.annotation.Nullable List<UUID> tripIdIn, @Param("tripIdNotIn") @jakarta.annotation.Nullable List<UUID> tripIdNotIn, @Param("routeIdEquals") @jakarta.annotation.Nullable UUID routeIdEquals, @Param("routeIdNotEquals") @jakarta.annotation.Nullable UUID routeIdNotEquals, @Param("routeIdSpecified") @jakarta.annotation.Nullable Boolean routeIdSpecified, @Param("routeIdIn") @jakarta.annotation.Nullable List<UUID> routeIdIn, @Param("routeIdNotIn") @jakarta.annotation.Nullable List<UUID> routeIdNotIn, @Param("tripSeatIdEquals") @jakarta.annotation.Nullable UUID tripSeatIdEquals, @Param("tripSeatIdNotEquals") @jakarta.annotation.Nullable UUID tripSeatIdNotEquals, @Param("tripSeatIdSpecified") @jakarta.annotation.Nullable Boolean tripSeatIdSpecified, @Param("tripSeatIdIn") @jakarta.annotation.Nullable List<UUID> tripSeatIdIn, @Param("tripSeatIdNotIn") @jakarta.annotation.Nullable List<UUID> tripSeatIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("bookingIdGreaterThan") @jakarta.annotation.Nullable Long bookingIdGreaterThan, @Param("bookingIdLessThan") @jakarta.annotation.Nullable Long bookingIdLessThan, @Param("bookingIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long bookingIdGreaterThanOrEqual, @Param("bookingIdLessThanOrEqual") @jakarta.annotation.Nullable Long bookingIdLessThanOrEqual, @Param("bookingIdEquals") @jakarta.annotation.Nullable Long bookingIdEquals, @Param("bookingIdNotEquals") @jakarta.annotation.Nullable Long bookingIdNotEquals, @Param("bookingIdSpecified") @jakarta.annotation.Nullable Boolean bookingIdSpecified, @Param("bookingIdIn") @jakarta.annotation.Nullable List<Long> bookingIdIn, @Param("bookingIdNotIn") @jakarta.annotation.Nullable List<Long> bookingIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>getAllTickets</code> but it also returns the http response headers .
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
   * @param ticketCodeContains  (optional)
   * @param ticketCodeDoesNotContain  (optional)
   * @param ticketCodeEquals  (optional)
   * @param ticketCodeNotEquals  (optional)
   * @param ticketCodeSpecified  (optional)
   * @param ticketCodeIn  (optional)
   * @param ticketCodeNotIn  (optional)
   * @param priceGreaterThan  (optional)
   * @param priceLessThan  (optional)
   * @param priceGreaterThanOrEqual  (optional)
   * @param priceLessThanOrEqual  (optional)
   * @param priceEquals  (optional)
   * @param priceNotEquals  (optional)
   * @param priceSpecified  (optional)
   * @param priceIn  (optional)
   * @param priceNotIn  (optional)
   * @param qrCodeContains  (optional)
   * @param qrCodeDoesNotContain  (optional)
   * @param qrCodeEquals  (optional)
   * @param qrCodeNotEquals  (optional)
   * @param qrCodeSpecified  (optional)
   * @param qrCodeIn  (optional)
   * @param qrCodeNotIn  (optional)
   * @param timeFromGreaterThan  (optional)
   * @param timeFromLessThan  (optional)
   * @param timeFromGreaterThanOrEqual  (optional)
   * @param timeFromLessThanOrEqual  (optional)
   * @param timeFromEquals  (optional)
   * @param timeFromNotEquals  (optional)
   * @param timeFromSpecified  (optional)
   * @param timeFromIn  (optional)
   * @param timeFromNotIn  (optional)
   * @param timeToGreaterThan  (optional)
   * @param timeToLessThan  (optional)
   * @param timeToGreaterThanOrEqual  (optional)
   * @param timeToLessThanOrEqual  (optional)
   * @param timeToEquals  (optional)
   * @param timeToNotEquals  (optional)
   * @param timeToSpecified  (optional)
   * @param timeToIn  (optional)
   * @param timeToNotIn  (optional)
   * @param checkedInEquals  (optional)
   * @param checkedInNotEquals  (optional)
   * @param checkedInSpecified  (optional)
   * @param checkedInIn  (optional)
   * @param checkedInNotIn  (optional)
   * @param tripIdEquals  (optional)
   * @param tripIdNotEquals  (optional)
   * @param tripIdSpecified  (optional)
   * @param tripIdIn  (optional)
   * @param tripIdNotIn  (optional)
   * @param routeIdEquals  (optional)
   * @param routeIdNotEquals  (optional)
   * @param routeIdSpecified  (optional)
   * @param routeIdIn  (optional)
   * @param routeIdNotIn  (optional)
   * @param tripSeatIdEquals  (optional)
   * @param tripSeatIdNotEquals  (optional)
   * @param tripSeatIdSpecified  (optional)
   * @param tripSeatIdIn  (optional)
   * @param tripSeatIdNotIn  (optional)
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
  @RequestLine("GET /api/tickets?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&ticketCode.contains={ticketCodeContains}&ticketCode.doesNotContain={ticketCodeDoesNotContain}&ticketCode.equals={ticketCodeEquals}&ticketCode.notEquals={ticketCodeNotEquals}&ticketCode.specified={ticketCodeSpecified}&ticketCode.in={ticketCodeIn}&ticketCode.notIn={ticketCodeNotIn}&price.greaterThan={priceGreaterThan}&price.lessThan={priceLessThan}&price.greaterThanOrEqual={priceGreaterThanOrEqual}&price.lessThanOrEqual={priceLessThanOrEqual}&price.equals={priceEquals}&price.notEquals={priceNotEquals}&price.specified={priceSpecified}&price.in={priceIn}&price.notIn={priceNotIn}&qrCode.contains={qrCodeContains}&qrCode.doesNotContain={qrCodeDoesNotContain}&qrCode.equals={qrCodeEquals}&qrCode.notEquals={qrCodeNotEquals}&qrCode.specified={qrCodeSpecified}&qrCode.in={qrCodeIn}&qrCode.notIn={qrCodeNotIn}&timeFrom.greaterThan={timeFromGreaterThan}&timeFrom.lessThan={timeFromLessThan}&timeFrom.greaterThanOrEqual={timeFromGreaterThanOrEqual}&timeFrom.lessThanOrEqual={timeFromLessThanOrEqual}&timeFrom.equals={timeFromEquals}&timeFrom.notEquals={timeFromNotEquals}&timeFrom.specified={timeFromSpecified}&timeFrom.in={timeFromIn}&timeFrom.notIn={timeFromNotIn}&timeTo.greaterThan={timeToGreaterThan}&timeTo.lessThan={timeToLessThan}&timeTo.greaterThanOrEqual={timeToGreaterThanOrEqual}&timeTo.lessThanOrEqual={timeToLessThanOrEqual}&timeTo.equals={timeToEquals}&timeTo.notEquals={timeToNotEquals}&timeTo.specified={timeToSpecified}&timeTo.in={timeToIn}&timeTo.notIn={timeToNotIn}&checkedIn.equals={checkedInEquals}&checkedIn.notEquals={checkedInNotEquals}&checkedIn.specified={checkedInSpecified}&checkedIn.in={checkedInIn}&checkedIn.notIn={checkedInNotIn}&tripId.equals={tripIdEquals}&tripId.notEquals={tripIdNotEquals}&tripId.specified={tripIdSpecified}&tripId.in={tripIdIn}&tripId.notIn={tripIdNotIn}&routeId.equals={routeIdEquals}&routeId.notEquals={routeIdNotEquals}&routeId.specified={routeIdSpecified}&routeId.in={routeIdIn}&routeId.notIn={routeIdNotIn}&tripSeatId.equals={tripSeatIdEquals}&tripSeatId.notEquals={tripSeatIdNotEquals}&tripSeatId.specified={tripSeatIdSpecified}&tripSeatId.in={tripSeatIdIn}&tripSeatId.notIn={tripSeatIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<TicketDTO>> getAllTicketsWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("ticketCodeContains") @jakarta.annotation.Nullable String ticketCodeContains, @Param("ticketCodeDoesNotContain") @jakarta.annotation.Nullable String ticketCodeDoesNotContain, @Param("ticketCodeEquals") @jakarta.annotation.Nullable String ticketCodeEquals, @Param("ticketCodeNotEquals") @jakarta.annotation.Nullable String ticketCodeNotEquals, @Param("ticketCodeSpecified") @jakarta.annotation.Nullable Boolean ticketCodeSpecified, @Param("ticketCodeIn") @jakarta.annotation.Nullable List<String> ticketCodeIn, @Param("ticketCodeNotIn") @jakarta.annotation.Nullable List<String> ticketCodeNotIn, @Param("priceGreaterThan") @jakarta.annotation.Nullable BigDecimal priceGreaterThan, @Param("priceLessThan") @jakarta.annotation.Nullable BigDecimal priceLessThan, @Param("priceGreaterThanOrEqual") @jakarta.annotation.Nullable BigDecimal priceGreaterThanOrEqual, @Param("priceLessThanOrEqual") @jakarta.annotation.Nullable BigDecimal priceLessThanOrEqual, @Param("priceEquals") @jakarta.annotation.Nullable BigDecimal priceEquals, @Param("priceNotEquals") @jakarta.annotation.Nullable BigDecimal priceNotEquals, @Param("priceSpecified") @jakarta.annotation.Nullable Boolean priceSpecified, @Param("priceIn") @jakarta.annotation.Nullable List<BigDecimal> priceIn, @Param("priceNotIn") @jakarta.annotation.Nullable List<BigDecimal> priceNotIn, @Param("qrCodeContains") @jakarta.annotation.Nullable String qrCodeContains, @Param("qrCodeDoesNotContain") @jakarta.annotation.Nullable String qrCodeDoesNotContain, @Param("qrCodeEquals") @jakarta.annotation.Nullable String qrCodeEquals, @Param("qrCodeNotEquals") @jakarta.annotation.Nullable String qrCodeNotEquals, @Param("qrCodeSpecified") @jakarta.annotation.Nullable Boolean qrCodeSpecified, @Param("qrCodeIn") @jakarta.annotation.Nullable List<String> qrCodeIn, @Param("qrCodeNotIn") @jakarta.annotation.Nullable List<String> qrCodeNotIn, @Param("timeFromGreaterThan") @jakarta.annotation.Nullable OffsetDateTime timeFromGreaterThan, @Param("timeFromLessThan") @jakarta.annotation.Nullable OffsetDateTime timeFromLessThan, @Param("timeFromGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime timeFromGreaterThanOrEqual, @Param("timeFromLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime timeFromLessThanOrEqual, @Param("timeFromEquals") @jakarta.annotation.Nullable OffsetDateTime timeFromEquals, @Param("timeFromNotEquals") @jakarta.annotation.Nullable OffsetDateTime timeFromNotEquals, @Param("timeFromSpecified") @jakarta.annotation.Nullable Boolean timeFromSpecified, @Param("timeFromIn") @jakarta.annotation.Nullable List<OffsetDateTime> timeFromIn, @Param("timeFromNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> timeFromNotIn, @Param("timeToGreaterThan") @jakarta.annotation.Nullable OffsetDateTime timeToGreaterThan, @Param("timeToLessThan") @jakarta.annotation.Nullable OffsetDateTime timeToLessThan, @Param("timeToGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime timeToGreaterThanOrEqual, @Param("timeToLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime timeToLessThanOrEqual, @Param("timeToEquals") @jakarta.annotation.Nullable OffsetDateTime timeToEquals, @Param("timeToNotEquals") @jakarta.annotation.Nullable OffsetDateTime timeToNotEquals, @Param("timeToSpecified") @jakarta.annotation.Nullable Boolean timeToSpecified, @Param("timeToIn") @jakarta.annotation.Nullable List<OffsetDateTime> timeToIn, @Param("timeToNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> timeToNotIn, @Param("checkedInEquals") @jakarta.annotation.Nullable Boolean checkedInEquals, @Param("checkedInNotEquals") @jakarta.annotation.Nullable Boolean checkedInNotEquals, @Param("checkedInSpecified") @jakarta.annotation.Nullable Boolean checkedInSpecified, @Param("checkedInIn") @jakarta.annotation.Nullable List<Boolean> checkedInIn, @Param("checkedInNotIn") @jakarta.annotation.Nullable List<Boolean> checkedInNotIn, @Param("tripIdEquals") @jakarta.annotation.Nullable UUID tripIdEquals, @Param("tripIdNotEquals") @jakarta.annotation.Nullable UUID tripIdNotEquals, @Param("tripIdSpecified") @jakarta.annotation.Nullable Boolean tripIdSpecified, @Param("tripIdIn") @jakarta.annotation.Nullable List<UUID> tripIdIn, @Param("tripIdNotIn") @jakarta.annotation.Nullable List<UUID> tripIdNotIn, @Param("routeIdEquals") @jakarta.annotation.Nullable UUID routeIdEquals, @Param("routeIdNotEquals") @jakarta.annotation.Nullable UUID routeIdNotEquals, @Param("routeIdSpecified") @jakarta.annotation.Nullable Boolean routeIdSpecified, @Param("routeIdIn") @jakarta.annotation.Nullable List<UUID> routeIdIn, @Param("routeIdNotIn") @jakarta.annotation.Nullable List<UUID> routeIdNotIn, @Param("tripSeatIdEquals") @jakarta.annotation.Nullable UUID tripSeatIdEquals, @Param("tripSeatIdNotEquals") @jakarta.annotation.Nullable UUID tripSeatIdNotEquals, @Param("tripSeatIdSpecified") @jakarta.annotation.Nullable Boolean tripSeatIdSpecified, @Param("tripSeatIdIn") @jakarta.annotation.Nullable List<UUID> tripSeatIdIn, @Param("tripSeatIdNotIn") @jakarta.annotation.Nullable List<UUID> tripSeatIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("bookingIdGreaterThan") @jakarta.annotation.Nullable Long bookingIdGreaterThan, @Param("bookingIdLessThan") @jakarta.annotation.Nullable Long bookingIdLessThan, @Param("bookingIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long bookingIdGreaterThanOrEqual, @Param("bookingIdLessThanOrEqual") @jakarta.annotation.Nullable Long bookingIdLessThanOrEqual, @Param("bookingIdEquals") @jakarta.annotation.Nullable Long bookingIdEquals, @Param("bookingIdNotEquals") @jakarta.annotation.Nullable Long bookingIdNotEquals, @Param("bookingIdSpecified") @jakarta.annotation.Nullable Boolean bookingIdSpecified, @Param("bookingIdIn") @jakarta.annotation.Nullable List<Long> bookingIdIn, @Param("bookingIdNotIn") @jakarta.annotation.Nullable List<Long> bookingIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllTickets</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllTicketsQueryParams} class that allows for
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
   *   <li>ticketCodeContains -  (optional)</li>
   *   <li>ticketCodeDoesNotContain -  (optional)</li>
   *   <li>ticketCodeEquals -  (optional)</li>
   *   <li>ticketCodeNotEquals -  (optional)</li>
   *   <li>ticketCodeSpecified -  (optional)</li>
   *   <li>ticketCodeIn -  (optional)</li>
   *   <li>ticketCodeNotIn -  (optional)</li>
   *   <li>priceGreaterThan -  (optional)</li>
   *   <li>priceLessThan -  (optional)</li>
   *   <li>priceGreaterThanOrEqual -  (optional)</li>
   *   <li>priceLessThanOrEqual -  (optional)</li>
   *   <li>priceEquals -  (optional)</li>
   *   <li>priceNotEquals -  (optional)</li>
   *   <li>priceSpecified -  (optional)</li>
   *   <li>priceIn -  (optional)</li>
   *   <li>priceNotIn -  (optional)</li>
   *   <li>qrCodeContains -  (optional)</li>
   *   <li>qrCodeDoesNotContain -  (optional)</li>
   *   <li>qrCodeEquals -  (optional)</li>
   *   <li>qrCodeNotEquals -  (optional)</li>
   *   <li>qrCodeSpecified -  (optional)</li>
   *   <li>qrCodeIn -  (optional)</li>
   *   <li>qrCodeNotIn -  (optional)</li>
   *   <li>timeFromGreaterThan -  (optional)</li>
   *   <li>timeFromLessThan -  (optional)</li>
   *   <li>timeFromGreaterThanOrEqual -  (optional)</li>
   *   <li>timeFromLessThanOrEqual -  (optional)</li>
   *   <li>timeFromEquals -  (optional)</li>
   *   <li>timeFromNotEquals -  (optional)</li>
   *   <li>timeFromSpecified -  (optional)</li>
   *   <li>timeFromIn -  (optional)</li>
   *   <li>timeFromNotIn -  (optional)</li>
   *   <li>timeToGreaterThan -  (optional)</li>
   *   <li>timeToLessThan -  (optional)</li>
   *   <li>timeToGreaterThanOrEqual -  (optional)</li>
   *   <li>timeToLessThanOrEqual -  (optional)</li>
   *   <li>timeToEquals -  (optional)</li>
   *   <li>timeToNotEquals -  (optional)</li>
   *   <li>timeToSpecified -  (optional)</li>
   *   <li>timeToIn -  (optional)</li>
   *   <li>timeToNotIn -  (optional)</li>
   *   <li>checkedInEquals -  (optional)</li>
   *   <li>checkedInNotEquals -  (optional)</li>
   *   <li>checkedInSpecified -  (optional)</li>
   *   <li>checkedInIn -  (optional)</li>
   *   <li>checkedInNotIn -  (optional)</li>
   *   <li>tripIdEquals -  (optional)</li>
   *   <li>tripIdNotEquals -  (optional)</li>
   *   <li>tripIdSpecified -  (optional)</li>
   *   <li>tripIdIn -  (optional)</li>
   *   <li>tripIdNotIn -  (optional)</li>
   *   <li>routeIdEquals -  (optional)</li>
   *   <li>routeIdNotEquals -  (optional)</li>
   *   <li>routeIdSpecified -  (optional)</li>
   *   <li>routeIdIn -  (optional)</li>
   *   <li>routeIdNotIn -  (optional)</li>
   *   <li>tripSeatIdEquals -  (optional)</li>
   *   <li>tripSeatIdNotEquals -  (optional)</li>
   *   <li>tripSeatIdSpecified -  (optional)</li>
   *   <li>tripSeatIdIn -  (optional)</li>
   *   <li>tripSeatIdNotIn -  (optional)</li>
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
   * @return List&lt;TicketDTO&gt;
   */
  @RequestLine("GET /api/tickets?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&ticketCode.contains={ticketCodeContains}&ticketCode.doesNotContain={ticketCodeDoesNotContain}&ticketCode.equals={ticketCodeEquals}&ticketCode.notEquals={ticketCodeNotEquals}&ticketCode.specified={ticketCodeSpecified}&ticketCode.in={ticketCodeIn}&ticketCode.notIn={ticketCodeNotIn}&price.greaterThan={priceGreaterThan}&price.lessThan={priceLessThan}&price.greaterThanOrEqual={priceGreaterThanOrEqual}&price.lessThanOrEqual={priceLessThanOrEqual}&price.equals={priceEquals}&price.notEquals={priceNotEquals}&price.specified={priceSpecified}&price.in={priceIn}&price.notIn={priceNotIn}&qrCode.contains={qrCodeContains}&qrCode.doesNotContain={qrCodeDoesNotContain}&qrCode.equals={qrCodeEquals}&qrCode.notEquals={qrCodeNotEquals}&qrCode.specified={qrCodeSpecified}&qrCode.in={qrCodeIn}&qrCode.notIn={qrCodeNotIn}&timeFrom.greaterThan={timeFromGreaterThan}&timeFrom.lessThan={timeFromLessThan}&timeFrom.greaterThanOrEqual={timeFromGreaterThanOrEqual}&timeFrom.lessThanOrEqual={timeFromLessThanOrEqual}&timeFrom.equals={timeFromEquals}&timeFrom.notEquals={timeFromNotEquals}&timeFrom.specified={timeFromSpecified}&timeFrom.in={timeFromIn}&timeFrom.notIn={timeFromNotIn}&timeTo.greaterThan={timeToGreaterThan}&timeTo.lessThan={timeToLessThan}&timeTo.greaterThanOrEqual={timeToGreaterThanOrEqual}&timeTo.lessThanOrEqual={timeToLessThanOrEqual}&timeTo.equals={timeToEquals}&timeTo.notEquals={timeToNotEquals}&timeTo.specified={timeToSpecified}&timeTo.in={timeToIn}&timeTo.notIn={timeToNotIn}&checkedIn.equals={checkedInEquals}&checkedIn.notEquals={checkedInNotEquals}&checkedIn.specified={checkedInSpecified}&checkedIn.in={checkedInIn}&checkedIn.notIn={checkedInNotIn}&tripId.equals={tripIdEquals}&tripId.notEquals={tripIdNotEquals}&tripId.specified={tripIdSpecified}&tripId.in={tripIdIn}&tripId.notIn={tripIdNotIn}&routeId.equals={routeIdEquals}&routeId.notEquals={routeIdNotEquals}&routeId.specified={routeIdSpecified}&routeId.in={routeIdIn}&routeId.notIn={routeIdNotIn}&tripSeatId.equals={tripSeatIdEquals}&tripSeatId.notEquals={tripSeatIdNotEquals}&tripSeatId.specified={tripSeatIdSpecified}&tripSeatId.in={tripSeatIdIn}&tripSeatId.notIn={tripSeatIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  List<TicketDTO> getAllTickets(@QueryMap(encoded=true) GetAllTicketsQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllTickets</code> that receives the query parameters as a map,
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
          *   <li>ticketCodeContains -  (optional)</li>
          *   <li>ticketCodeDoesNotContain -  (optional)</li>
          *   <li>ticketCodeEquals -  (optional)</li>
          *   <li>ticketCodeNotEquals -  (optional)</li>
          *   <li>ticketCodeSpecified -  (optional)</li>
          *   <li>ticketCodeIn -  (optional)</li>
          *   <li>ticketCodeNotIn -  (optional)</li>
          *   <li>priceGreaterThan -  (optional)</li>
          *   <li>priceLessThan -  (optional)</li>
          *   <li>priceGreaterThanOrEqual -  (optional)</li>
          *   <li>priceLessThanOrEqual -  (optional)</li>
          *   <li>priceEquals -  (optional)</li>
          *   <li>priceNotEquals -  (optional)</li>
          *   <li>priceSpecified -  (optional)</li>
          *   <li>priceIn -  (optional)</li>
          *   <li>priceNotIn -  (optional)</li>
          *   <li>qrCodeContains -  (optional)</li>
          *   <li>qrCodeDoesNotContain -  (optional)</li>
          *   <li>qrCodeEquals -  (optional)</li>
          *   <li>qrCodeNotEquals -  (optional)</li>
          *   <li>qrCodeSpecified -  (optional)</li>
          *   <li>qrCodeIn -  (optional)</li>
          *   <li>qrCodeNotIn -  (optional)</li>
          *   <li>timeFromGreaterThan -  (optional)</li>
          *   <li>timeFromLessThan -  (optional)</li>
          *   <li>timeFromGreaterThanOrEqual -  (optional)</li>
          *   <li>timeFromLessThanOrEqual -  (optional)</li>
          *   <li>timeFromEquals -  (optional)</li>
          *   <li>timeFromNotEquals -  (optional)</li>
          *   <li>timeFromSpecified -  (optional)</li>
          *   <li>timeFromIn -  (optional)</li>
          *   <li>timeFromNotIn -  (optional)</li>
          *   <li>timeToGreaterThan -  (optional)</li>
          *   <li>timeToLessThan -  (optional)</li>
          *   <li>timeToGreaterThanOrEqual -  (optional)</li>
          *   <li>timeToLessThanOrEqual -  (optional)</li>
          *   <li>timeToEquals -  (optional)</li>
          *   <li>timeToNotEquals -  (optional)</li>
          *   <li>timeToSpecified -  (optional)</li>
          *   <li>timeToIn -  (optional)</li>
          *   <li>timeToNotIn -  (optional)</li>
          *   <li>checkedInEquals -  (optional)</li>
          *   <li>checkedInNotEquals -  (optional)</li>
          *   <li>checkedInSpecified -  (optional)</li>
          *   <li>checkedInIn -  (optional)</li>
          *   <li>checkedInNotIn -  (optional)</li>
          *   <li>tripIdEquals -  (optional)</li>
          *   <li>tripIdNotEquals -  (optional)</li>
          *   <li>tripIdSpecified -  (optional)</li>
          *   <li>tripIdIn -  (optional)</li>
          *   <li>tripIdNotIn -  (optional)</li>
          *   <li>routeIdEquals -  (optional)</li>
          *   <li>routeIdNotEquals -  (optional)</li>
          *   <li>routeIdSpecified -  (optional)</li>
          *   <li>routeIdIn -  (optional)</li>
          *   <li>routeIdNotIn -  (optional)</li>
          *   <li>tripSeatIdEquals -  (optional)</li>
          *   <li>tripSeatIdNotEquals -  (optional)</li>
          *   <li>tripSeatIdSpecified -  (optional)</li>
          *   <li>tripSeatIdIn -  (optional)</li>
          *   <li>tripSeatIdNotIn -  (optional)</li>
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
          * @return List&lt;TicketDTO&gt;
      */
      @RequestLine("GET /api/tickets?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&ticketCode.contains={ticketCodeContains}&ticketCode.doesNotContain={ticketCodeDoesNotContain}&ticketCode.equals={ticketCodeEquals}&ticketCode.notEquals={ticketCodeNotEquals}&ticketCode.specified={ticketCodeSpecified}&ticketCode.in={ticketCodeIn}&ticketCode.notIn={ticketCodeNotIn}&price.greaterThan={priceGreaterThan}&price.lessThan={priceLessThan}&price.greaterThanOrEqual={priceGreaterThanOrEqual}&price.lessThanOrEqual={priceLessThanOrEqual}&price.equals={priceEquals}&price.notEquals={priceNotEquals}&price.specified={priceSpecified}&price.in={priceIn}&price.notIn={priceNotIn}&qrCode.contains={qrCodeContains}&qrCode.doesNotContain={qrCodeDoesNotContain}&qrCode.equals={qrCodeEquals}&qrCode.notEquals={qrCodeNotEquals}&qrCode.specified={qrCodeSpecified}&qrCode.in={qrCodeIn}&qrCode.notIn={qrCodeNotIn}&timeFrom.greaterThan={timeFromGreaterThan}&timeFrom.lessThan={timeFromLessThan}&timeFrom.greaterThanOrEqual={timeFromGreaterThanOrEqual}&timeFrom.lessThanOrEqual={timeFromLessThanOrEqual}&timeFrom.equals={timeFromEquals}&timeFrom.notEquals={timeFromNotEquals}&timeFrom.specified={timeFromSpecified}&timeFrom.in={timeFromIn}&timeFrom.notIn={timeFromNotIn}&timeTo.greaterThan={timeToGreaterThan}&timeTo.lessThan={timeToLessThan}&timeTo.greaterThanOrEqual={timeToGreaterThanOrEqual}&timeTo.lessThanOrEqual={timeToLessThanOrEqual}&timeTo.equals={timeToEquals}&timeTo.notEquals={timeToNotEquals}&timeTo.specified={timeToSpecified}&timeTo.in={timeToIn}&timeTo.notIn={timeToNotIn}&checkedIn.equals={checkedInEquals}&checkedIn.notEquals={checkedInNotEquals}&checkedIn.specified={checkedInSpecified}&checkedIn.in={checkedInIn}&checkedIn.notIn={checkedInNotIn}&tripId.equals={tripIdEquals}&tripId.notEquals={tripIdNotEquals}&tripId.specified={tripIdSpecified}&tripId.in={tripIdIn}&tripId.notIn={tripIdNotIn}&routeId.equals={routeIdEquals}&routeId.notEquals={routeIdNotEquals}&routeId.specified={routeIdSpecified}&routeId.in={routeIdIn}&routeId.notIn={routeIdNotIn}&tripSeatId.equals={tripSeatIdEquals}&tripSeatId.notEquals={tripSeatIdNotEquals}&tripSeatId.specified={tripSeatIdSpecified}&tripSeatId.in={tripSeatIdIn}&tripSeatId.notIn={tripSeatIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<TicketDTO>> getAllTicketsWithHttpInfo(@QueryMap(encoded=true) GetAllTicketsQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllTickets</code> method in a fluent style.
   */
  public static class GetAllTicketsQueryParams extends HashMap<String, Object> {
    public GetAllTicketsQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllTicketsQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllTicketsQueryParams ticketCodeContains(@jakarta.annotation.Nullable final String value) {
      put("ticketCode.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams ticketCodeDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("ticketCode.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams ticketCodeEquals(@jakarta.annotation.Nullable final String value) {
      put("ticketCode.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams ticketCodeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("ticketCode.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams ticketCodeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("ticketCode.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams ticketCodeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("ticketCode.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllTicketsQueryParams ticketCodeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("ticketCode.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllTicketsQueryParams priceGreaterThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("price.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams priceLessThan(@jakarta.annotation.Nullable final BigDecimal value) {
      put("price.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams priceGreaterThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("price.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams priceLessThanOrEqual(@jakarta.annotation.Nullable final BigDecimal value) {
      put("price.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams priceEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("price.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams priceNotEquals(@jakarta.annotation.Nullable final BigDecimal value) {
      put("price.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams priceSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("price.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams priceIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("price.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllTicketsQueryParams priceNotIn(@jakarta.annotation.Nullable final List<BigDecimal> value) {
      put("price.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllTicketsQueryParams qrCodeContains(@jakarta.annotation.Nullable final String value) {
      put("qrCode.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams qrCodeDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("qrCode.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams qrCodeEquals(@jakarta.annotation.Nullable final String value) {
      put("qrCode.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams qrCodeNotEquals(@jakarta.annotation.Nullable final String value) {
      put("qrCode.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams qrCodeSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("qrCode.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams qrCodeIn(@jakarta.annotation.Nullable final List<String> value) {
      put("qrCode.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllTicketsQueryParams qrCodeNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("qrCode.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllTicketsQueryParams timeFromGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("timeFrom.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams timeFromLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("timeFrom.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams timeFromGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("timeFrom.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams timeFromLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("timeFrom.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams timeFromEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("timeFrom.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams timeFromNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("timeFrom.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams timeFromSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("timeFrom.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams timeFromIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("timeFrom.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllTicketsQueryParams timeFromNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("timeFrom.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllTicketsQueryParams timeToGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("timeTo.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams timeToLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("timeTo.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams timeToGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("timeTo.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams timeToLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("timeTo.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams timeToEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("timeTo.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams timeToNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("timeTo.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams timeToSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("timeTo.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams timeToIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("timeTo.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllTicketsQueryParams timeToNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("timeTo.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllTicketsQueryParams checkedInEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("checkedIn.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams checkedInNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("checkedIn.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams checkedInSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("checkedIn.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams checkedInIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("checkedIn.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllTicketsQueryParams checkedInNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("checkedIn.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllTicketsQueryParams tripIdEquals(@jakarta.annotation.Nullable final UUID value) {
      put("tripId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams tripIdNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("tripId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams tripIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("tripId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams tripIdIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("tripId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllTicketsQueryParams tripIdNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("tripId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllTicketsQueryParams routeIdEquals(@jakarta.annotation.Nullable final UUID value) {
      put("routeId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams routeIdNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("routeId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams routeIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("routeId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams routeIdIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("routeId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllTicketsQueryParams routeIdNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("routeId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllTicketsQueryParams tripSeatIdEquals(@jakarta.annotation.Nullable final UUID value) {
      put("tripSeatId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams tripSeatIdNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("tripSeatId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams tripSeatIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("tripSeatId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams tripSeatIdIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("tripSeatId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllTicketsQueryParams tripSeatIdNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("tripSeatId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllTicketsQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllTicketsQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllTicketsQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllTicketsQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllTicketsQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllTicketsQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllTicketsQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllTicketsQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllTicketsQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllTicketsQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllTicketsQueryParams bookingIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams bookingIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams bookingIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams bookingIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams bookingIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams bookingIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams bookingIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("bookingId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllTicketsQueryParams bookingIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("bookingId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllTicketsQueryParams bookingIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("bookingId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllTicketsQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @return TicketDTO
   */
  @RequestLine("GET /api/tickets/{id}")
  @Headers({
    "Accept: */*",
  })
  TicketDTO getTicket(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>getTicket</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/tickets/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<TicketDTO> getTicketWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param id  (required)
   * @param ticketDTO  (required)
   * @return TicketDTO
   */
  @RequestLine("PATCH /api/tickets/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  TicketDTO partialUpdateTicket(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull TicketDTO ticketDTO);

  /**
   * 
   * Similar to <code>partialUpdateTicket</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param ticketDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /api/tickets/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<TicketDTO> partialUpdateTicketWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull TicketDTO ticketDTO);



  /**
   * 
   * 
   * @param id  (required)
   * @param ticketDTO  (required)
   * @return TicketDTO
   */
  @RequestLine("PUT /api/tickets/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  TicketDTO updateTicket(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull TicketDTO ticketDTO);

  /**
   * 
   * Similar to <code>updateTicket</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param ticketDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/tickets/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<TicketDTO> updateTicketWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull TicketDTO ticketDTO);


}
