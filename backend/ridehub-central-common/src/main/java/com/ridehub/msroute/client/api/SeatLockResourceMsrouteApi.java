package com.ridehub.msroute.client.api;

import com.ridehub.msroute.client.invoker.ApiClient;
import com.ridehub.msroute.client.invoker.EncodingUtils;
import com.ridehub.msroute.client.model.ApiResponse;

import java.time.OffsetDateTime;
import com.ridehub.msroute.client.model.SeatLockActionRequestDTO;
import com.ridehub.msroute.client.model.SeatLockActionResponseDTO;
import com.ridehub.msroute.client.model.SeatLockDTO;
import com.ridehub.msroute.client.model.SeatLockRequestDTO;
import com.ridehub.msroute.client.model.SeatLockResponseDTO;
import java.util.UUID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import feign.*;

@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.14.0")
public interface SeatLockResourceMsrouteApi extends ApiClient.Api {


  /**
   * 
   * 
   * @param seatLockActionRequestDTO  (required)
   * @return SeatLockActionResponseDTO
   */
  @RequestLine("POST /api/seat-locks/cancel")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  SeatLockActionResponseDTO cancelSeatLocks(@jakarta.annotation.Nonnull SeatLockActionRequestDTO seatLockActionRequestDTO);

  /**
   * 
   * Similar to <code>cancelSeatLocks</code> but it also returns the http response headers .
   * 
   * @param seatLockActionRequestDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/seat-locks/cancel")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<SeatLockActionResponseDTO> cancelSeatLocksWithHttpInfo(@jakarta.annotation.Nonnull SeatLockActionRequestDTO seatLockActionRequestDTO);



  /**
   * 
   * 
   * @param seatLockActionRequestDTO  (required)
   * @return SeatLockActionResponseDTO
   */
  @RequestLine("POST /api/seat-locks/confirm")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  SeatLockActionResponseDTO confirmSeatLocks(@jakarta.annotation.Nonnull SeatLockActionRequestDTO seatLockActionRequestDTO);

  /**
   * 
   * Similar to <code>confirmSeatLocks</code> but it also returns the http response headers .
   * 
   * @param seatLockActionRequestDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/seat-locks/confirm")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<SeatLockActionResponseDTO> confirmSeatLocksWithHttpInfo(@jakarta.annotation.Nonnull SeatLockActionRequestDTO seatLockActionRequestDTO);



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
   * @param seatNoContains  (optional)
   * @param seatNoDoesNotContain  (optional)
   * @param seatNoEquals  (optional)
   * @param seatNoNotEquals  (optional)
   * @param seatNoSpecified  (optional)
   * @param seatNoIn  (optional)
   * @param seatNoNotIn  (optional)
   * @param userIdGreaterThan  (optional)
   * @param userIdLessThan  (optional)
   * @param userIdGreaterThanOrEqual  (optional)
   * @param userIdLessThanOrEqual  (optional)
   * @param userIdEquals  (optional)
   * @param userIdNotEquals  (optional)
   * @param userIdSpecified  (optional)
   * @param userIdIn  (optional)
   * @param userIdNotIn  (optional)
   * @param statusEquals  (optional)
   * @param statusNotEquals  (optional)
   * @param statusSpecified  (optional)
   * @param statusIn  (optional)
   * @param statusNotIn  (optional)
   * @param expiresAtGreaterThan  (optional)
   * @param expiresAtLessThan  (optional)
   * @param expiresAtGreaterThanOrEqual  (optional)
   * @param expiresAtLessThanOrEqual  (optional)
   * @param expiresAtEquals  (optional)
   * @param expiresAtNotEquals  (optional)
   * @param expiresAtSpecified  (optional)
   * @param expiresAtIn  (optional)
   * @param expiresAtNotIn  (optional)
   * @param idempotencyKeyContains  (optional)
   * @param idempotencyKeyDoesNotContain  (optional)
   * @param idempotencyKeyEquals  (optional)
   * @param idempotencyKeyNotEquals  (optional)
   * @param idempotencyKeySpecified  (optional)
   * @param idempotencyKeyIn  (optional)
   * @param idempotencyKeyNotIn  (optional)
   * @param bookingIdGreaterThan  (optional)
   * @param bookingIdLessThan  (optional)
   * @param bookingIdGreaterThanOrEqual  (optional)
   * @param bookingIdLessThanOrEqual  (optional)
   * @param bookingIdEquals  (optional)
   * @param bookingIdNotEquals  (optional)
   * @param bookingIdSpecified  (optional)
   * @param bookingIdIn  (optional)
   * @param bookingIdNotIn  (optional)
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
   * @param tripIdGreaterThan  (optional)
   * @param tripIdLessThan  (optional)
   * @param tripIdGreaterThanOrEqual  (optional)
   * @param tripIdLessThanOrEqual  (optional)
   * @param tripIdEquals  (optional)
   * @param tripIdNotEquals  (optional)
   * @param tripIdSpecified  (optional)
   * @param tripIdIn  (optional)
   * @param tripIdNotIn  (optional)
   * @param distinct  (optional)
   * @return Long
   */
  @RequestLine("GET /api/seat-locks/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&seatNo.contains={seatNoContains}&seatNo.doesNotContain={seatNoDoesNotContain}&seatNo.equals={seatNoEquals}&seatNo.notEquals={seatNoNotEquals}&seatNo.specified={seatNoSpecified}&seatNo.in={seatNoIn}&seatNo.notIn={seatNoNotIn}&userId.greaterThan={userIdGreaterThan}&userId.lessThan={userIdLessThan}&userId.greaterThanOrEqual={userIdGreaterThanOrEqual}&userId.lessThanOrEqual={userIdLessThanOrEqual}&userId.equals={userIdEquals}&userId.notEquals={userIdNotEquals}&userId.specified={userIdSpecified}&userId.in={userIdIn}&userId.notIn={userIdNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&expiresAt.greaterThan={expiresAtGreaterThan}&expiresAt.lessThan={expiresAtLessThan}&expiresAt.greaterThanOrEqual={expiresAtGreaterThanOrEqual}&expiresAt.lessThanOrEqual={expiresAtLessThanOrEqual}&expiresAt.equals={expiresAtEquals}&expiresAt.notEquals={expiresAtNotEquals}&expiresAt.specified={expiresAtSpecified}&expiresAt.in={expiresAtIn}&expiresAt.notIn={expiresAtNotIn}&idempotencyKey.contains={idempotencyKeyContains}&idempotencyKey.doesNotContain={idempotencyKeyDoesNotContain}&idempotencyKey.equals={idempotencyKeyEquals}&idempotencyKey.notEquals={idempotencyKeyNotEquals}&idempotencyKey.specified={idempotencyKeySpecified}&idempotencyKey.in={idempotencyKeyIn}&idempotencyKey.notIn={idempotencyKeyNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&tripId.greaterThan={tripIdGreaterThan}&tripId.lessThan={tripIdLessThan}&tripId.greaterThanOrEqual={tripIdGreaterThanOrEqual}&tripId.lessThanOrEqual={tripIdLessThanOrEqual}&tripId.equals={tripIdEquals}&tripId.notEquals={tripIdNotEquals}&tripId.specified={tripIdSpecified}&tripId.in={tripIdIn}&tripId.notIn={tripIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  Long countSeatLocks(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("seatNoContains") @jakarta.annotation.Nullable String seatNoContains, @Param("seatNoDoesNotContain") @jakarta.annotation.Nullable String seatNoDoesNotContain, @Param("seatNoEquals") @jakarta.annotation.Nullable String seatNoEquals, @Param("seatNoNotEquals") @jakarta.annotation.Nullable String seatNoNotEquals, @Param("seatNoSpecified") @jakarta.annotation.Nullable Boolean seatNoSpecified, @Param("seatNoIn") @jakarta.annotation.Nullable List<String> seatNoIn, @Param("seatNoNotIn") @jakarta.annotation.Nullable List<String> seatNoNotIn, @Param("userIdGreaterThan") @jakarta.annotation.Nullable Long userIdGreaterThan, @Param("userIdLessThan") @jakarta.annotation.Nullable Long userIdLessThan, @Param("userIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long userIdGreaterThanOrEqual, @Param("userIdLessThanOrEqual") @jakarta.annotation.Nullable Long userIdLessThanOrEqual, @Param("userIdEquals") @jakarta.annotation.Nullable Long userIdEquals, @Param("userIdNotEquals") @jakarta.annotation.Nullable Long userIdNotEquals, @Param("userIdSpecified") @jakarta.annotation.Nullable Boolean userIdSpecified, @Param("userIdIn") @jakarta.annotation.Nullable List<Long> userIdIn, @Param("userIdNotIn") @jakarta.annotation.Nullable List<Long> userIdNotIn, @Param("statusEquals") @jakarta.annotation.Nullable String statusEquals, @Param("statusNotEquals") @jakarta.annotation.Nullable String statusNotEquals, @Param("statusSpecified") @jakarta.annotation.Nullable Boolean statusSpecified, @Param("statusIn") @jakarta.annotation.Nullable List<String> statusIn, @Param("statusNotIn") @jakarta.annotation.Nullable List<String> statusNotIn, @Param("expiresAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime expiresAtGreaterThan, @Param("expiresAtLessThan") @jakarta.annotation.Nullable OffsetDateTime expiresAtLessThan, @Param("expiresAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime expiresAtGreaterThanOrEqual, @Param("expiresAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime expiresAtLessThanOrEqual, @Param("expiresAtEquals") @jakarta.annotation.Nullable OffsetDateTime expiresAtEquals, @Param("expiresAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime expiresAtNotEquals, @Param("expiresAtSpecified") @jakarta.annotation.Nullable Boolean expiresAtSpecified, @Param("expiresAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> expiresAtIn, @Param("expiresAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> expiresAtNotIn, @Param("idempotencyKeyContains") @jakarta.annotation.Nullable String idempotencyKeyContains, @Param("idempotencyKeyDoesNotContain") @jakarta.annotation.Nullable String idempotencyKeyDoesNotContain, @Param("idempotencyKeyEquals") @jakarta.annotation.Nullable String idempotencyKeyEquals, @Param("idempotencyKeyNotEquals") @jakarta.annotation.Nullable String idempotencyKeyNotEquals, @Param("idempotencyKeySpecified") @jakarta.annotation.Nullable Boolean idempotencyKeySpecified, @Param("idempotencyKeyIn") @jakarta.annotation.Nullable List<String> idempotencyKeyIn, @Param("idempotencyKeyNotIn") @jakarta.annotation.Nullable List<String> idempotencyKeyNotIn, @Param("bookingIdGreaterThan") @jakarta.annotation.Nullable Long bookingIdGreaterThan, @Param("bookingIdLessThan") @jakarta.annotation.Nullable Long bookingIdLessThan, @Param("bookingIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long bookingIdGreaterThanOrEqual, @Param("bookingIdLessThanOrEqual") @jakarta.annotation.Nullable Long bookingIdLessThanOrEqual, @Param("bookingIdEquals") @jakarta.annotation.Nullable Long bookingIdEquals, @Param("bookingIdNotEquals") @jakarta.annotation.Nullable Long bookingIdNotEquals, @Param("bookingIdSpecified") @jakarta.annotation.Nullable Boolean bookingIdSpecified, @Param("bookingIdIn") @jakarta.annotation.Nullable List<Long> bookingIdIn, @Param("bookingIdNotIn") @jakarta.annotation.Nullable List<Long> bookingIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("tripIdGreaterThan") @jakarta.annotation.Nullable Long tripIdGreaterThan, @Param("tripIdLessThan") @jakarta.annotation.Nullable Long tripIdLessThan, @Param("tripIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long tripIdGreaterThanOrEqual, @Param("tripIdLessThanOrEqual") @jakarta.annotation.Nullable Long tripIdLessThanOrEqual, @Param("tripIdEquals") @jakarta.annotation.Nullable Long tripIdEquals, @Param("tripIdNotEquals") @jakarta.annotation.Nullable Long tripIdNotEquals, @Param("tripIdSpecified") @jakarta.annotation.Nullable Boolean tripIdSpecified, @Param("tripIdIn") @jakarta.annotation.Nullable List<Long> tripIdIn, @Param("tripIdNotIn") @jakarta.annotation.Nullable List<Long> tripIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>countSeatLocks</code> but it also returns the http response headers .
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
   * @param seatNoContains  (optional)
   * @param seatNoDoesNotContain  (optional)
   * @param seatNoEquals  (optional)
   * @param seatNoNotEquals  (optional)
   * @param seatNoSpecified  (optional)
   * @param seatNoIn  (optional)
   * @param seatNoNotIn  (optional)
   * @param userIdGreaterThan  (optional)
   * @param userIdLessThan  (optional)
   * @param userIdGreaterThanOrEqual  (optional)
   * @param userIdLessThanOrEqual  (optional)
   * @param userIdEquals  (optional)
   * @param userIdNotEquals  (optional)
   * @param userIdSpecified  (optional)
   * @param userIdIn  (optional)
   * @param userIdNotIn  (optional)
   * @param statusEquals  (optional)
   * @param statusNotEquals  (optional)
   * @param statusSpecified  (optional)
   * @param statusIn  (optional)
   * @param statusNotIn  (optional)
   * @param expiresAtGreaterThan  (optional)
   * @param expiresAtLessThan  (optional)
   * @param expiresAtGreaterThanOrEqual  (optional)
   * @param expiresAtLessThanOrEqual  (optional)
   * @param expiresAtEquals  (optional)
   * @param expiresAtNotEquals  (optional)
   * @param expiresAtSpecified  (optional)
   * @param expiresAtIn  (optional)
   * @param expiresAtNotIn  (optional)
   * @param idempotencyKeyContains  (optional)
   * @param idempotencyKeyDoesNotContain  (optional)
   * @param idempotencyKeyEquals  (optional)
   * @param idempotencyKeyNotEquals  (optional)
   * @param idempotencyKeySpecified  (optional)
   * @param idempotencyKeyIn  (optional)
   * @param idempotencyKeyNotIn  (optional)
   * @param bookingIdGreaterThan  (optional)
   * @param bookingIdLessThan  (optional)
   * @param bookingIdGreaterThanOrEqual  (optional)
   * @param bookingIdLessThanOrEqual  (optional)
   * @param bookingIdEquals  (optional)
   * @param bookingIdNotEquals  (optional)
   * @param bookingIdSpecified  (optional)
   * @param bookingIdIn  (optional)
   * @param bookingIdNotIn  (optional)
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
   * @param tripIdGreaterThan  (optional)
   * @param tripIdLessThan  (optional)
   * @param tripIdGreaterThanOrEqual  (optional)
   * @param tripIdLessThanOrEqual  (optional)
   * @param tripIdEquals  (optional)
   * @param tripIdNotEquals  (optional)
   * @param tripIdSpecified  (optional)
   * @param tripIdIn  (optional)
   * @param tripIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/seat-locks/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&seatNo.contains={seatNoContains}&seatNo.doesNotContain={seatNoDoesNotContain}&seatNo.equals={seatNoEquals}&seatNo.notEquals={seatNoNotEquals}&seatNo.specified={seatNoSpecified}&seatNo.in={seatNoIn}&seatNo.notIn={seatNoNotIn}&userId.greaterThan={userIdGreaterThan}&userId.lessThan={userIdLessThan}&userId.greaterThanOrEqual={userIdGreaterThanOrEqual}&userId.lessThanOrEqual={userIdLessThanOrEqual}&userId.equals={userIdEquals}&userId.notEquals={userIdNotEquals}&userId.specified={userIdSpecified}&userId.in={userIdIn}&userId.notIn={userIdNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&expiresAt.greaterThan={expiresAtGreaterThan}&expiresAt.lessThan={expiresAtLessThan}&expiresAt.greaterThanOrEqual={expiresAtGreaterThanOrEqual}&expiresAt.lessThanOrEqual={expiresAtLessThanOrEqual}&expiresAt.equals={expiresAtEquals}&expiresAt.notEquals={expiresAtNotEquals}&expiresAt.specified={expiresAtSpecified}&expiresAt.in={expiresAtIn}&expiresAt.notIn={expiresAtNotIn}&idempotencyKey.contains={idempotencyKeyContains}&idempotencyKey.doesNotContain={idempotencyKeyDoesNotContain}&idempotencyKey.equals={idempotencyKeyEquals}&idempotencyKey.notEquals={idempotencyKeyNotEquals}&idempotencyKey.specified={idempotencyKeySpecified}&idempotencyKey.in={idempotencyKeyIn}&idempotencyKey.notIn={idempotencyKeyNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&tripId.greaterThan={tripIdGreaterThan}&tripId.lessThan={tripIdLessThan}&tripId.greaterThanOrEqual={tripIdGreaterThanOrEqual}&tripId.lessThanOrEqual={tripIdLessThanOrEqual}&tripId.equals={tripIdEquals}&tripId.notEquals={tripIdNotEquals}&tripId.specified={tripIdSpecified}&tripId.in={tripIdIn}&tripId.notIn={tripIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<Long> countSeatLocksWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("seatNoContains") @jakarta.annotation.Nullable String seatNoContains, @Param("seatNoDoesNotContain") @jakarta.annotation.Nullable String seatNoDoesNotContain, @Param("seatNoEquals") @jakarta.annotation.Nullable String seatNoEquals, @Param("seatNoNotEquals") @jakarta.annotation.Nullable String seatNoNotEquals, @Param("seatNoSpecified") @jakarta.annotation.Nullable Boolean seatNoSpecified, @Param("seatNoIn") @jakarta.annotation.Nullable List<String> seatNoIn, @Param("seatNoNotIn") @jakarta.annotation.Nullable List<String> seatNoNotIn, @Param("userIdGreaterThan") @jakarta.annotation.Nullable Long userIdGreaterThan, @Param("userIdLessThan") @jakarta.annotation.Nullable Long userIdLessThan, @Param("userIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long userIdGreaterThanOrEqual, @Param("userIdLessThanOrEqual") @jakarta.annotation.Nullable Long userIdLessThanOrEqual, @Param("userIdEquals") @jakarta.annotation.Nullable Long userIdEquals, @Param("userIdNotEquals") @jakarta.annotation.Nullable Long userIdNotEquals, @Param("userIdSpecified") @jakarta.annotation.Nullable Boolean userIdSpecified, @Param("userIdIn") @jakarta.annotation.Nullable List<Long> userIdIn, @Param("userIdNotIn") @jakarta.annotation.Nullable List<Long> userIdNotIn, @Param("statusEquals") @jakarta.annotation.Nullable String statusEquals, @Param("statusNotEquals") @jakarta.annotation.Nullable String statusNotEquals, @Param("statusSpecified") @jakarta.annotation.Nullable Boolean statusSpecified, @Param("statusIn") @jakarta.annotation.Nullable List<String> statusIn, @Param("statusNotIn") @jakarta.annotation.Nullable List<String> statusNotIn, @Param("expiresAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime expiresAtGreaterThan, @Param("expiresAtLessThan") @jakarta.annotation.Nullable OffsetDateTime expiresAtLessThan, @Param("expiresAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime expiresAtGreaterThanOrEqual, @Param("expiresAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime expiresAtLessThanOrEqual, @Param("expiresAtEquals") @jakarta.annotation.Nullable OffsetDateTime expiresAtEquals, @Param("expiresAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime expiresAtNotEquals, @Param("expiresAtSpecified") @jakarta.annotation.Nullable Boolean expiresAtSpecified, @Param("expiresAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> expiresAtIn, @Param("expiresAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> expiresAtNotIn, @Param("idempotencyKeyContains") @jakarta.annotation.Nullable String idempotencyKeyContains, @Param("idempotencyKeyDoesNotContain") @jakarta.annotation.Nullable String idempotencyKeyDoesNotContain, @Param("idempotencyKeyEquals") @jakarta.annotation.Nullable String idempotencyKeyEquals, @Param("idempotencyKeyNotEquals") @jakarta.annotation.Nullable String idempotencyKeyNotEquals, @Param("idempotencyKeySpecified") @jakarta.annotation.Nullable Boolean idempotencyKeySpecified, @Param("idempotencyKeyIn") @jakarta.annotation.Nullable List<String> idempotencyKeyIn, @Param("idempotencyKeyNotIn") @jakarta.annotation.Nullable List<String> idempotencyKeyNotIn, @Param("bookingIdGreaterThan") @jakarta.annotation.Nullable Long bookingIdGreaterThan, @Param("bookingIdLessThan") @jakarta.annotation.Nullable Long bookingIdLessThan, @Param("bookingIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long bookingIdGreaterThanOrEqual, @Param("bookingIdLessThanOrEqual") @jakarta.annotation.Nullable Long bookingIdLessThanOrEqual, @Param("bookingIdEquals") @jakarta.annotation.Nullable Long bookingIdEquals, @Param("bookingIdNotEquals") @jakarta.annotation.Nullable Long bookingIdNotEquals, @Param("bookingIdSpecified") @jakarta.annotation.Nullable Boolean bookingIdSpecified, @Param("bookingIdIn") @jakarta.annotation.Nullable List<Long> bookingIdIn, @Param("bookingIdNotIn") @jakarta.annotation.Nullable List<Long> bookingIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("tripIdGreaterThan") @jakarta.annotation.Nullable Long tripIdGreaterThan, @Param("tripIdLessThan") @jakarta.annotation.Nullable Long tripIdLessThan, @Param("tripIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long tripIdGreaterThanOrEqual, @Param("tripIdLessThanOrEqual") @jakarta.annotation.Nullable Long tripIdLessThanOrEqual, @Param("tripIdEquals") @jakarta.annotation.Nullable Long tripIdEquals, @Param("tripIdNotEquals") @jakarta.annotation.Nullable Long tripIdNotEquals, @Param("tripIdSpecified") @jakarta.annotation.Nullable Boolean tripIdSpecified, @Param("tripIdIn") @jakarta.annotation.Nullable List<Long> tripIdIn, @Param("tripIdNotIn") @jakarta.annotation.Nullable List<Long> tripIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>countSeatLocks</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link CountSeatLocksQueryParams} class that allows for
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
   *   <li>seatNoContains -  (optional)</li>
   *   <li>seatNoDoesNotContain -  (optional)</li>
   *   <li>seatNoEquals -  (optional)</li>
   *   <li>seatNoNotEquals -  (optional)</li>
   *   <li>seatNoSpecified -  (optional)</li>
   *   <li>seatNoIn -  (optional)</li>
   *   <li>seatNoNotIn -  (optional)</li>
   *   <li>userIdGreaterThan -  (optional)</li>
   *   <li>userIdLessThan -  (optional)</li>
   *   <li>userIdGreaterThanOrEqual -  (optional)</li>
   *   <li>userIdLessThanOrEqual -  (optional)</li>
   *   <li>userIdEquals -  (optional)</li>
   *   <li>userIdNotEquals -  (optional)</li>
   *   <li>userIdSpecified -  (optional)</li>
   *   <li>userIdIn -  (optional)</li>
   *   <li>userIdNotIn -  (optional)</li>
   *   <li>statusEquals -  (optional)</li>
   *   <li>statusNotEquals -  (optional)</li>
   *   <li>statusSpecified -  (optional)</li>
   *   <li>statusIn -  (optional)</li>
   *   <li>statusNotIn -  (optional)</li>
   *   <li>expiresAtGreaterThan -  (optional)</li>
   *   <li>expiresAtLessThan -  (optional)</li>
   *   <li>expiresAtGreaterThanOrEqual -  (optional)</li>
   *   <li>expiresAtLessThanOrEqual -  (optional)</li>
   *   <li>expiresAtEquals -  (optional)</li>
   *   <li>expiresAtNotEquals -  (optional)</li>
   *   <li>expiresAtSpecified -  (optional)</li>
   *   <li>expiresAtIn -  (optional)</li>
   *   <li>expiresAtNotIn -  (optional)</li>
   *   <li>idempotencyKeyContains -  (optional)</li>
   *   <li>idempotencyKeyDoesNotContain -  (optional)</li>
   *   <li>idempotencyKeyEquals -  (optional)</li>
   *   <li>idempotencyKeyNotEquals -  (optional)</li>
   *   <li>idempotencyKeySpecified -  (optional)</li>
   *   <li>idempotencyKeyIn -  (optional)</li>
   *   <li>idempotencyKeyNotIn -  (optional)</li>
   *   <li>bookingIdGreaterThan -  (optional)</li>
   *   <li>bookingIdLessThan -  (optional)</li>
   *   <li>bookingIdGreaterThanOrEqual -  (optional)</li>
   *   <li>bookingIdLessThanOrEqual -  (optional)</li>
   *   <li>bookingIdEquals -  (optional)</li>
   *   <li>bookingIdNotEquals -  (optional)</li>
   *   <li>bookingIdSpecified -  (optional)</li>
   *   <li>bookingIdIn -  (optional)</li>
   *   <li>bookingIdNotIn -  (optional)</li>
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
   *   <li>tripIdGreaterThan -  (optional)</li>
   *   <li>tripIdLessThan -  (optional)</li>
   *   <li>tripIdGreaterThanOrEqual -  (optional)</li>
   *   <li>tripIdLessThanOrEqual -  (optional)</li>
   *   <li>tripIdEquals -  (optional)</li>
   *   <li>tripIdNotEquals -  (optional)</li>
   *   <li>tripIdSpecified -  (optional)</li>
   *   <li>tripIdIn -  (optional)</li>
   *   <li>tripIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return Long
   */
  @RequestLine("GET /api/seat-locks/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&seatNo.contains={seatNoContains}&seatNo.doesNotContain={seatNoDoesNotContain}&seatNo.equals={seatNoEquals}&seatNo.notEquals={seatNoNotEquals}&seatNo.specified={seatNoSpecified}&seatNo.in={seatNoIn}&seatNo.notIn={seatNoNotIn}&userId.greaterThan={userIdGreaterThan}&userId.lessThan={userIdLessThan}&userId.greaterThanOrEqual={userIdGreaterThanOrEqual}&userId.lessThanOrEqual={userIdLessThanOrEqual}&userId.equals={userIdEquals}&userId.notEquals={userIdNotEquals}&userId.specified={userIdSpecified}&userId.in={userIdIn}&userId.notIn={userIdNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&expiresAt.greaterThan={expiresAtGreaterThan}&expiresAt.lessThan={expiresAtLessThan}&expiresAt.greaterThanOrEqual={expiresAtGreaterThanOrEqual}&expiresAt.lessThanOrEqual={expiresAtLessThanOrEqual}&expiresAt.equals={expiresAtEquals}&expiresAt.notEquals={expiresAtNotEquals}&expiresAt.specified={expiresAtSpecified}&expiresAt.in={expiresAtIn}&expiresAt.notIn={expiresAtNotIn}&idempotencyKey.contains={idempotencyKeyContains}&idempotencyKey.doesNotContain={idempotencyKeyDoesNotContain}&idempotencyKey.equals={idempotencyKeyEquals}&idempotencyKey.notEquals={idempotencyKeyNotEquals}&idempotencyKey.specified={idempotencyKeySpecified}&idempotencyKey.in={idempotencyKeyIn}&idempotencyKey.notIn={idempotencyKeyNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&tripId.greaterThan={tripIdGreaterThan}&tripId.lessThan={tripIdLessThan}&tripId.greaterThanOrEqual={tripIdGreaterThanOrEqual}&tripId.lessThanOrEqual={tripIdLessThanOrEqual}&tripId.equals={tripIdEquals}&tripId.notEquals={tripIdNotEquals}&tripId.specified={tripIdSpecified}&tripId.in={tripIdIn}&tripId.notIn={tripIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  Long countSeatLocks(@QueryMap(encoded=true) CountSeatLocksQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>countSeatLocks</code> that receives the query parameters as a map,
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
          *   <li>seatNoContains -  (optional)</li>
          *   <li>seatNoDoesNotContain -  (optional)</li>
          *   <li>seatNoEquals -  (optional)</li>
          *   <li>seatNoNotEquals -  (optional)</li>
          *   <li>seatNoSpecified -  (optional)</li>
          *   <li>seatNoIn -  (optional)</li>
          *   <li>seatNoNotIn -  (optional)</li>
          *   <li>userIdGreaterThan -  (optional)</li>
          *   <li>userIdLessThan -  (optional)</li>
          *   <li>userIdGreaterThanOrEqual -  (optional)</li>
          *   <li>userIdLessThanOrEqual -  (optional)</li>
          *   <li>userIdEquals -  (optional)</li>
          *   <li>userIdNotEquals -  (optional)</li>
          *   <li>userIdSpecified -  (optional)</li>
          *   <li>userIdIn -  (optional)</li>
          *   <li>userIdNotIn -  (optional)</li>
          *   <li>statusEquals -  (optional)</li>
          *   <li>statusNotEquals -  (optional)</li>
          *   <li>statusSpecified -  (optional)</li>
          *   <li>statusIn -  (optional)</li>
          *   <li>statusNotIn -  (optional)</li>
          *   <li>expiresAtGreaterThan -  (optional)</li>
          *   <li>expiresAtLessThan -  (optional)</li>
          *   <li>expiresAtGreaterThanOrEqual -  (optional)</li>
          *   <li>expiresAtLessThanOrEqual -  (optional)</li>
          *   <li>expiresAtEquals -  (optional)</li>
          *   <li>expiresAtNotEquals -  (optional)</li>
          *   <li>expiresAtSpecified -  (optional)</li>
          *   <li>expiresAtIn -  (optional)</li>
          *   <li>expiresAtNotIn -  (optional)</li>
          *   <li>idempotencyKeyContains -  (optional)</li>
          *   <li>idempotencyKeyDoesNotContain -  (optional)</li>
          *   <li>idempotencyKeyEquals -  (optional)</li>
          *   <li>idempotencyKeyNotEquals -  (optional)</li>
          *   <li>idempotencyKeySpecified -  (optional)</li>
          *   <li>idempotencyKeyIn -  (optional)</li>
          *   <li>idempotencyKeyNotIn -  (optional)</li>
          *   <li>bookingIdGreaterThan -  (optional)</li>
          *   <li>bookingIdLessThan -  (optional)</li>
          *   <li>bookingIdGreaterThanOrEqual -  (optional)</li>
          *   <li>bookingIdLessThanOrEqual -  (optional)</li>
          *   <li>bookingIdEquals -  (optional)</li>
          *   <li>bookingIdNotEquals -  (optional)</li>
          *   <li>bookingIdSpecified -  (optional)</li>
          *   <li>bookingIdIn -  (optional)</li>
          *   <li>bookingIdNotIn -  (optional)</li>
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
          *   <li>tripIdGreaterThan -  (optional)</li>
          *   <li>tripIdLessThan -  (optional)</li>
          *   <li>tripIdGreaterThanOrEqual -  (optional)</li>
          *   <li>tripIdLessThanOrEqual -  (optional)</li>
          *   <li>tripIdEquals -  (optional)</li>
          *   <li>tripIdNotEquals -  (optional)</li>
          *   <li>tripIdSpecified -  (optional)</li>
          *   <li>tripIdIn -  (optional)</li>
          *   <li>tripIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return Long
      */
      @RequestLine("GET /api/seat-locks/count?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&seatNo.contains={seatNoContains}&seatNo.doesNotContain={seatNoDoesNotContain}&seatNo.equals={seatNoEquals}&seatNo.notEquals={seatNoNotEquals}&seatNo.specified={seatNoSpecified}&seatNo.in={seatNoIn}&seatNo.notIn={seatNoNotIn}&userId.greaterThan={userIdGreaterThan}&userId.lessThan={userIdLessThan}&userId.greaterThanOrEqual={userIdGreaterThanOrEqual}&userId.lessThanOrEqual={userIdLessThanOrEqual}&userId.equals={userIdEquals}&userId.notEquals={userIdNotEquals}&userId.specified={userIdSpecified}&userId.in={userIdIn}&userId.notIn={userIdNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&expiresAt.greaterThan={expiresAtGreaterThan}&expiresAt.lessThan={expiresAtLessThan}&expiresAt.greaterThanOrEqual={expiresAtGreaterThanOrEqual}&expiresAt.lessThanOrEqual={expiresAtLessThanOrEqual}&expiresAt.equals={expiresAtEquals}&expiresAt.notEquals={expiresAtNotEquals}&expiresAt.specified={expiresAtSpecified}&expiresAt.in={expiresAtIn}&expiresAt.notIn={expiresAtNotIn}&idempotencyKey.contains={idempotencyKeyContains}&idempotencyKey.doesNotContain={idempotencyKeyDoesNotContain}&idempotencyKey.equals={idempotencyKeyEquals}&idempotencyKey.notEquals={idempotencyKeyNotEquals}&idempotencyKey.specified={idempotencyKeySpecified}&idempotencyKey.in={idempotencyKeyIn}&idempotencyKey.notIn={idempotencyKeyNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&tripId.greaterThan={tripIdGreaterThan}&tripId.lessThan={tripIdLessThan}&tripId.greaterThanOrEqual={tripIdGreaterThanOrEqual}&tripId.lessThanOrEqual={tripIdLessThanOrEqual}&tripId.equals={tripIdEquals}&tripId.notEquals={tripIdNotEquals}&tripId.specified={tripIdSpecified}&tripId.in={tripIdIn}&tripId.notIn={tripIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<Long> countSeatLocksWithHttpInfo(@QueryMap(encoded=true) CountSeatLocksQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>countSeatLocks</code> method in a fluent style.
   */
  public static class CountSeatLocksQueryParams extends HashMap<String, Object> {
    public CountSeatLocksQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatLocksQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatLocksQueryParams seatNoContains(@jakarta.annotation.Nullable final String value) {
      put("seatNo.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams seatNoDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("seatNo.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams seatNoEquals(@jakarta.annotation.Nullable final String value) {
      put("seatNo.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams seatNoNotEquals(@jakarta.annotation.Nullable final String value) {
      put("seatNo.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams seatNoSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("seatNo.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams seatNoIn(@jakarta.annotation.Nullable final List<String> value) {
      put("seatNo.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatLocksQueryParams seatNoNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("seatNo.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatLocksQueryParams userIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("userId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams userIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("userId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams userIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("userId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams userIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("userId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams userIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("userId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams userIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("userId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams userIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("userId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams userIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("userId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatLocksQueryParams userIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("userId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatLocksQueryParams statusEquals(@jakarta.annotation.Nullable final String value) {
      put("status.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams statusNotEquals(@jakarta.annotation.Nullable final String value) {
      put("status.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams statusSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("status.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams statusIn(@jakarta.annotation.Nullable final List<String> value) {
      put("status.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatLocksQueryParams statusNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("status.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatLocksQueryParams expiresAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("expiresAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams expiresAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("expiresAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams expiresAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("expiresAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams expiresAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("expiresAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams expiresAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("expiresAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams expiresAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("expiresAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams expiresAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("expiresAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams expiresAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("expiresAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatLocksQueryParams expiresAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("expiresAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatLocksQueryParams idempotencyKeyContains(@jakarta.annotation.Nullable final String value) {
      put("idempotencyKey.contains", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams idempotencyKeyDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("idempotencyKey.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams idempotencyKeyEquals(@jakarta.annotation.Nullable final String value) {
      put("idempotencyKey.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams idempotencyKeyNotEquals(@jakarta.annotation.Nullable final String value) {
      put("idempotencyKey.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams idempotencyKeySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("idempotencyKey.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams idempotencyKeyIn(@jakarta.annotation.Nullable final List<String> value) {
      put("idempotencyKey.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatLocksQueryParams idempotencyKeyNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("idempotencyKey.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatLocksQueryParams bookingIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams bookingIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams bookingIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams bookingIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams bookingIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams bookingIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams bookingIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("bookingId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams bookingIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("bookingId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatLocksQueryParams bookingIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("bookingId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatLocksQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatLocksQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatLocksQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatLocksQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatLocksQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatLocksQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatLocksQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatLocksQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatLocksQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatLocksQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatLocksQueryParams tripIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("tripId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams tripIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("tripId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams tripIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("tripId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams tripIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("tripId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams tripIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("tripId.equals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams tripIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("tripId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams tripIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("tripId.specified", EncodingUtils.encode(value));
      return this;
    }
    public CountSeatLocksQueryParams tripIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("tripId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatLocksQueryParams tripIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("tripId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public CountSeatLocksQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param seatLockDTO  (required)
   * @return SeatLockDTO
   */
  @RequestLine("POST /api/seat-locks")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  SeatLockDTO createSeatLock(@jakarta.annotation.Nonnull SeatLockDTO seatLockDTO);

  /**
   * 
   * Similar to <code>createSeatLock</code> but it also returns the http response headers .
   * 
   * @param seatLockDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/seat-locks")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<SeatLockDTO> createSeatLockWithHttpInfo(@jakarta.annotation.Nonnull SeatLockDTO seatLockDTO);



  /**
   * 
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/seat-locks/{id}")
  @Headers({
    "Accept: application/json",
  })
  void deleteSeatLock(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>deleteSeatLock</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   */
  @RequestLine("DELETE /api/seat-locks/{id}")
  @Headers({
    "Accept: application/json",
  })
  ApiResponse<Void> deleteSeatLockWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



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
   * @param seatNoContains  (optional)
   * @param seatNoDoesNotContain  (optional)
   * @param seatNoEquals  (optional)
   * @param seatNoNotEquals  (optional)
   * @param seatNoSpecified  (optional)
   * @param seatNoIn  (optional)
   * @param seatNoNotIn  (optional)
   * @param userIdGreaterThan  (optional)
   * @param userIdLessThan  (optional)
   * @param userIdGreaterThanOrEqual  (optional)
   * @param userIdLessThanOrEqual  (optional)
   * @param userIdEquals  (optional)
   * @param userIdNotEquals  (optional)
   * @param userIdSpecified  (optional)
   * @param userIdIn  (optional)
   * @param userIdNotIn  (optional)
   * @param statusEquals  (optional)
   * @param statusNotEquals  (optional)
   * @param statusSpecified  (optional)
   * @param statusIn  (optional)
   * @param statusNotIn  (optional)
   * @param expiresAtGreaterThan  (optional)
   * @param expiresAtLessThan  (optional)
   * @param expiresAtGreaterThanOrEqual  (optional)
   * @param expiresAtLessThanOrEqual  (optional)
   * @param expiresAtEquals  (optional)
   * @param expiresAtNotEquals  (optional)
   * @param expiresAtSpecified  (optional)
   * @param expiresAtIn  (optional)
   * @param expiresAtNotIn  (optional)
   * @param idempotencyKeyContains  (optional)
   * @param idempotencyKeyDoesNotContain  (optional)
   * @param idempotencyKeyEquals  (optional)
   * @param idempotencyKeyNotEquals  (optional)
   * @param idempotencyKeySpecified  (optional)
   * @param idempotencyKeyIn  (optional)
   * @param idempotencyKeyNotIn  (optional)
   * @param bookingIdGreaterThan  (optional)
   * @param bookingIdLessThan  (optional)
   * @param bookingIdGreaterThanOrEqual  (optional)
   * @param bookingIdLessThanOrEqual  (optional)
   * @param bookingIdEquals  (optional)
   * @param bookingIdNotEquals  (optional)
   * @param bookingIdSpecified  (optional)
   * @param bookingIdIn  (optional)
   * @param bookingIdNotIn  (optional)
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
   * @param tripIdGreaterThan  (optional)
   * @param tripIdLessThan  (optional)
   * @param tripIdGreaterThanOrEqual  (optional)
   * @param tripIdLessThanOrEqual  (optional)
   * @param tripIdEquals  (optional)
   * @param tripIdNotEquals  (optional)
   * @param tripIdSpecified  (optional)
   * @param tripIdIn  (optional)
   * @param tripIdNotIn  (optional)
   * @param distinct  (optional)
   * @return List&lt;SeatLockDTO&gt;
   */
  @RequestLine("GET /api/seat-locks?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&seatNo.contains={seatNoContains}&seatNo.doesNotContain={seatNoDoesNotContain}&seatNo.equals={seatNoEquals}&seatNo.notEquals={seatNoNotEquals}&seatNo.specified={seatNoSpecified}&seatNo.in={seatNoIn}&seatNo.notIn={seatNoNotIn}&userId.greaterThan={userIdGreaterThan}&userId.lessThan={userIdLessThan}&userId.greaterThanOrEqual={userIdGreaterThanOrEqual}&userId.lessThanOrEqual={userIdLessThanOrEqual}&userId.equals={userIdEquals}&userId.notEquals={userIdNotEquals}&userId.specified={userIdSpecified}&userId.in={userIdIn}&userId.notIn={userIdNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&expiresAt.greaterThan={expiresAtGreaterThan}&expiresAt.lessThan={expiresAtLessThan}&expiresAt.greaterThanOrEqual={expiresAtGreaterThanOrEqual}&expiresAt.lessThanOrEqual={expiresAtLessThanOrEqual}&expiresAt.equals={expiresAtEquals}&expiresAt.notEquals={expiresAtNotEquals}&expiresAt.specified={expiresAtSpecified}&expiresAt.in={expiresAtIn}&expiresAt.notIn={expiresAtNotIn}&idempotencyKey.contains={idempotencyKeyContains}&idempotencyKey.doesNotContain={idempotencyKeyDoesNotContain}&idempotencyKey.equals={idempotencyKeyEquals}&idempotencyKey.notEquals={idempotencyKeyNotEquals}&idempotencyKey.specified={idempotencyKeySpecified}&idempotencyKey.in={idempotencyKeyIn}&idempotencyKey.notIn={idempotencyKeyNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&tripId.greaterThan={tripIdGreaterThan}&tripId.lessThan={tripIdLessThan}&tripId.greaterThanOrEqual={tripIdGreaterThanOrEqual}&tripId.lessThanOrEqual={tripIdLessThanOrEqual}&tripId.equals={tripIdEquals}&tripId.notEquals={tripIdNotEquals}&tripId.specified={tripIdSpecified}&tripId.in={tripIdIn}&tripId.notIn={tripIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  List<SeatLockDTO> getAllSeatLocks(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("seatNoContains") @jakarta.annotation.Nullable String seatNoContains, @Param("seatNoDoesNotContain") @jakarta.annotation.Nullable String seatNoDoesNotContain, @Param("seatNoEquals") @jakarta.annotation.Nullable String seatNoEquals, @Param("seatNoNotEquals") @jakarta.annotation.Nullable String seatNoNotEquals, @Param("seatNoSpecified") @jakarta.annotation.Nullable Boolean seatNoSpecified, @Param("seatNoIn") @jakarta.annotation.Nullable List<String> seatNoIn, @Param("seatNoNotIn") @jakarta.annotation.Nullable List<String> seatNoNotIn, @Param("userIdGreaterThan") @jakarta.annotation.Nullable Long userIdGreaterThan, @Param("userIdLessThan") @jakarta.annotation.Nullable Long userIdLessThan, @Param("userIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long userIdGreaterThanOrEqual, @Param("userIdLessThanOrEqual") @jakarta.annotation.Nullable Long userIdLessThanOrEqual, @Param("userIdEquals") @jakarta.annotation.Nullable Long userIdEquals, @Param("userIdNotEquals") @jakarta.annotation.Nullable Long userIdNotEquals, @Param("userIdSpecified") @jakarta.annotation.Nullable Boolean userIdSpecified, @Param("userIdIn") @jakarta.annotation.Nullable List<Long> userIdIn, @Param("userIdNotIn") @jakarta.annotation.Nullable List<Long> userIdNotIn, @Param("statusEquals") @jakarta.annotation.Nullable String statusEquals, @Param("statusNotEquals") @jakarta.annotation.Nullable String statusNotEquals, @Param("statusSpecified") @jakarta.annotation.Nullable Boolean statusSpecified, @Param("statusIn") @jakarta.annotation.Nullable List<String> statusIn, @Param("statusNotIn") @jakarta.annotation.Nullable List<String> statusNotIn, @Param("expiresAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime expiresAtGreaterThan, @Param("expiresAtLessThan") @jakarta.annotation.Nullable OffsetDateTime expiresAtLessThan, @Param("expiresAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime expiresAtGreaterThanOrEqual, @Param("expiresAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime expiresAtLessThanOrEqual, @Param("expiresAtEquals") @jakarta.annotation.Nullable OffsetDateTime expiresAtEquals, @Param("expiresAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime expiresAtNotEquals, @Param("expiresAtSpecified") @jakarta.annotation.Nullable Boolean expiresAtSpecified, @Param("expiresAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> expiresAtIn, @Param("expiresAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> expiresAtNotIn, @Param("idempotencyKeyContains") @jakarta.annotation.Nullable String idempotencyKeyContains, @Param("idempotencyKeyDoesNotContain") @jakarta.annotation.Nullable String idempotencyKeyDoesNotContain, @Param("idempotencyKeyEquals") @jakarta.annotation.Nullable String idempotencyKeyEquals, @Param("idempotencyKeyNotEquals") @jakarta.annotation.Nullable String idempotencyKeyNotEquals, @Param("idempotencyKeySpecified") @jakarta.annotation.Nullable Boolean idempotencyKeySpecified, @Param("idempotencyKeyIn") @jakarta.annotation.Nullable List<String> idempotencyKeyIn, @Param("idempotencyKeyNotIn") @jakarta.annotation.Nullable List<String> idempotencyKeyNotIn, @Param("bookingIdGreaterThan") @jakarta.annotation.Nullable Long bookingIdGreaterThan, @Param("bookingIdLessThan") @jakarta.annotation.Nullable Long bookingIdLessThan, @Param("bookingIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long bookingIdGreaterThanOrEqual, @Param("bookingIdLessThanOrEqual") @jakarta.annotation.Nullable Long bookingIdLessThanOrEqual, @Param("bookingIdEquals") @jakarta.annotation.Nullable Long bookingIdEquals, @Param("bookingIdNotEquals") @jakarta.annotation.Nullable Long bookingIdNotEquals, @Param("bookingIdSpecified") @jakarta.annotation.Nullable Boolean bookingIdSpecified, @Param("bookingIdIn") @jakarta.annotation.Nullable List<Long> bookingIdIn, @Param("bookingIdNotIn") @jakarta.annotation.Nullable List<Long> bookingIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("tripIdGreaterThan") @jakarta.annotation.Nullable Long tripIdGreaterThan, @Param("tripIdLessThan") @jakarta.annotation.Nullable Long tripIdLessThan, @Param("tripIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long tripIdGreaterThanOrEqual, @Param("tripIdLessThanOrEqual") @jakarta.annotation.Nullable Long tripIdLessThanOrEqual, @Param("tripIdEquals") @jakarta.annotation.Nullable Long tripIdEquals, @Param("tripIdNotEquals") @jakarta.annotation.Nullable Long tripIdNotEquals, @Param("tripIdSpecified") @jakarta.annotation.Nullable Boolean tripIdSpecified, @Param("tripIdIn") @jakarta.annotation.Nullable List<Long> tripIdIn, @Param("tripIdNotIn") @jakarta.annotation.Nullable List<Long> tripIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);

  /**
   * 
   * Similar to <code>getAllSeatLocks</code> but it also returns the http response headers .
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
   * @param seatNoContains  (optional)
   * @param seatNoDoesNotContain  (optional)
   * @param seatNoEquals  (optional)
   * @param seatNoNotEquals  (optional)
   * @param seatNoSpecified  (optional)
   * @param seatNoIn  (optional)
   * @param seatNoNotIn  (optional)
   * @param userIdGreaterThan  (optional)
   * @param userIdLessThan  (optional)
   * @param userIdGreaterThanOrEqual  (optional)
   * @param userIdLessThanOrEqual  (optional)
   * @param userIdEquals  (optional)
   * @param userIdNotEquals  (optional)
   * @param userIdSpecified  (optional)
   * @param userIdIn  (optional)
   * @param userIdNotIn  (optional)
   * @param statusEquals  (optional)
   * @param statusNotEquals  (optional)
   * @param statusSpecified  (optional)
   * @param statusIn  (optional)
   * @param statusNotIn  (optional)
   * @param expiresAtGreaterThan  (optional)
   * @param expiresAtLessThan  (optional)
   * @param expiresAtGreaterThanOrEqual  (optional)
   * @param expiresAtLessThanOrEqual  (optional)
   * @param expiresAtEquals  (optional)
   * @param expiresAtNotEquals  (optional)
   * @param expiresAtSpecified  (optional)
   * @param expiresAtIn  (optional)
   * @param expiresAtNotIn  (optional)
   * @param idempotencyKeyContains  (optional)
   * @param idempotencyKeyDoesNotContain  (optional)
   * @param idempotencyKeyEquals  (optional)
   * @param idempotencyKeyNotEquals  (optional)
   * @param idempotencyKeySpecified  (optional)
   * @param idempotencyKeyIn  (optional)
   * @param idempotencyKeyNotIn  (optional)
   * @param bookingIdGreaterThan  (optional)
   * @param bookingIdLessThan  (optional)
   * @param bookingIdGreaterThanOrEqual  (optional)
   * @param bookingIdLessThanOrEqual  (optional)
   * @param bookingIdEquals  (optional)
   * @param bookingIdNotEquals  (optional)
   * @param bookingIdSpecified  (optional)
   * @param bookingIdIn  (optional)
   * @param bookingIdNotIn  (optional)
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
   * @param tripIdGreaterThan  (optional)
   * @param tripIdLessThan  (optional)
   * @param tripIdGreaterThanOrEqual  (optional)
   * @param tripIdLessThanOrEqual  (optional)
   * @param tripIdEquals  (optional)
   * @param tripIdNotEquals  (optional)
   * @param tripIdSpecified  (optional)
   * @param tripIdIn  (optional)
   * @param tripIdNotIn  (optional)
   * @param distinct  (optional)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/seat-locks?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&seatNo.contains={seatNoContains}&seatNo.doesNotContain={seatNoDoesNotContain}&seatNo.equals={seatNoEquals}&seatNo.notEquals={seatNoNotEquals}&seatNo.specified={seatNoSpecified}&seatNo.in={seatNoIn}&seatNo.notIn={seatNoNotIn}&userId.greaterThan={userIdGreaterThan}&userId.lessThan={userIdLessThan}&userId.greaterThanOrEqual={userIdGreaterThanOrEqual}&userId.lessThanOrEqual={userIdLessThanOrEqual}&userId.equals={userIdEquals}&userId.notEquals={userIdNotEquals}&userId.specified={userIdSpecified}&userId.in={userIdIn}&userId.notIn={userIdNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&expiresAt.greaterThan={expiresAtGreaterThan}&expiresAt.lessThan={expiresAtLessThan}&expiresAt.greaterThanOrEqual={expiresAtGreaterThanOrEqual}&expiresAt.lessThanOrEqual={expiresAtLessThanOrEqual}&expiresAt.equals={expiresAtEquals}&expiresAt.notEquals={expiresAtNotEquals}&expiresAt.specified={expiresAtSpecified}&expiresAt.in={expiresAtIn}&expiresAt.notIn={expiresAtNotIn}&idempotencyKey.contains={idempotencyKeyContains}&idempotencyKey.doesNotContain={idempotencyKeyDoesNotContain}&idempotencyKey.equals={idempotencyKeyEquals}&idempotencyKey.notEquals={idempotencyKeyNotEquals}&idempotencyKey.specified={idempotencyKeySpecified}&idempotencyKey.in={idempotencyKeyIn}&idempotencyKey.notIn={idempotencyKeyNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&tripId.greaterThan={tripIdGreaterThan}&tripId.lessThan={tripIdLessThan}&tripId.greaterThanOrEqual={tripIdGreaterThanOrEqual}&tripId.lessThanOrEqual={tripIdLessThanOrEqual}&tripId.equals={tripIdEquals}&tripId.notEquals={tripIdNotEquals}&tripId.specified={tripIdSpecified}&tripId.in={tripIdIn}&tripId.notIn={tripIdNotIn}&distinct={distinct}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<List<SeatLockDTO>> getAllSeatLocksWithHttpInfo(@Param("idGreaterThan") @jakarta.annotation.Nullable Long idGreaterThan, @Param("idLessThan") @jakarta.annotation.Nullable Long idLessThan, @Param("idGreaterThanOrEqual") @jakarta.annotation.Nullable Long idGreaterThanOrEqual, @Param("idLessThanOrEqual") @jakarta.annotation.Nullable Long idLessThanOrEqual, @Param("idEquals") @jakarta.annotation.Nullable Long idEquals, @Param("idNotEquals") @jakarta.annotation.Nullable Long idNotEquals, @Param("idSpecified") @jakarta.annotation.Nullable Boolean idSpecified, @Param("idIn") @jakarta.annotation.Nullable List<Long> idIn, @Param("idNotIn") @jakarta.annotation.Nullable List<Long> idNotIn, @Param("seatNoContains") @jakarta.annotation.Nullable String seatNoContains, @Param("seatNoDoesNotContain") @jakarta.annotation.Nullable String seatNoDoesNotContain, @Param("seatNoEquals") @jakarta.annotation.Nullable String seatNoEquals, @Param("seatNoNotEquals") @jakarta.annotation.Nullable String seatNoNotEquals, @Param("seatNoSpecified") @jakarta.annotation.Nullable Boolean seatNoSpecified, @Param("seatNoIn") @jakarta.annotation.Nullable List<String> seatNoIn, @Param("seatNoNotIn") @jakarta.annotation.Nullable List<String> seatNoNotIn, @Param("userIdGreaterThan") @jakarta.annotation.Nullable Long userIdGreaterThan, @Param("userIdLessThan") @jakarta.annotation.Nullable Long userIdLessThan, @Param("userIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long userIdGreaterThanOrEqual, @Param("userIdLessThanOrEqual") @jakarta.annotation.Nullable Long userIdLessThanOrEqual, @Param("userIdEquals") @jakarta.annotation.Nullable Long userIdEquals, @Param("userIdNotEquals") @jakarta.annotation.Nullable Long userIdNotEquals, @Param("userIdSpecified") @jakarta.annotation.Nullable Boolean userIdSpecified, @Param("userIdIn") @jakarta.annotation.Nullable List<Long> userIdIn, @Param("userIdNotIn") @jakarta.annotation.Nullable List<Long> userIdNotIn, @Param("statusEquals") @jakarta.annotation.Nullable String statusEquals, @Param("statusNotEquals") @jakarta.annotation.Nullable String statusNotEquals, @Param("statusSpecified") @jakarta.annotation.Nullable Boolean statusSpecified, @Param("statusIn") @jakarta.annotation.Nullable List<String> statusIn, @Param("statusNotIn") @jakarta.annotation.Nullable List<String> statusNotIn, @Param("expiresAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime expiresAtGreaterThan, @Param("expiresAtLessThan") @jakarta.annotation.Nullable OffsetDateTime expiresAtLessThan, @Param("expiresAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime expiresAtGreaterThanOrEqual, @Param("expiresAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime expiresAtLessThanOrEqual, @Param("expiresAtEquals") @jakarta.annotation.Nullable OffsetDateTime expiresAtEquals, @Param("expiresAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime expiresAtNotEquals, @Param("expiresAtSpecified") @jakarta.annotation.Nullable Boolean expiresAtSpecified, @Param("expiresAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> expiresAtIn, @Param("expiresAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> expiresAtNotIn, @Param("idempotencyKeyContains") @jakarta.annotation.Nullable String idempotencyKeyContains, @Param("idempotencyKeyDoesNotContain") @jakarta.annotation.Nullable String idempotencyKeyDoesNotContain, @Param("idempotencyKeyEquals") @jakarta.annotation.Nullable String idempotencyKeyEquals, @Param("idempotencyKeyNotEquals") @jakarta.annotation.Nullable String idempotencyKeyNotEquals, @Param("idempotencyKeySpecified") @jakarta.annotation.Nullable Boolean idempotencyKeySpecified, @Param("idempotencyKeyIn") @jakarta.annotation.Nullable List<String> idempotencyKeyIn, @Param("idempotencyKeyNotIn") @jakarta.annotation.Nullable List<String> idempotencyKeyNotIn, @Param("bookingIdGreaterThan") @jakarta.annotation.Nullable Long bookingIdGreaterThan, @Param("bookingIdLessThan") @jakarta.annotation.Nullable Long bookingIdLessThan, @Param("bookingIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long bookingIdGreaterThanOrEqual, @Param("bookingIdLessThanOrEqual") @jakarta.annotation.Nullable Long bookingIdLessThanOrEqual, @Param("bookingIdEquals") @jakarta.annotation.Nullable Long bookingIdEquals, @Param("bookingIdNotEquals") @jakarta.annotation.Nullable Long bookingIdNotEquals, @Param("bookingIdSpecified") @jakarta.annotation.Nullable Boolean bookingIdSpecified, @Param("bookingIdIn") @jakarta.annotation.Nullable List<Long> bookingIdIn, @Param("bookingIdNotIn") @jakarta.annotation.Nullable List<Long> bookingIdNotIn, @Param("createdAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThan, @Param("createdAtLessThan") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThan, @Param("createdAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtGreaterThanOrEqual, @Param("createdAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime createdAtLessThanOrEqual, @Param("createdAtEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtEquals, @Param("createdAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime createdAtNotEquals, @Param("createdAtSpecified") @jakarta.annotation.Nullable Boolean createdAtSpecified, @Param("createdAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtIn, @Param("createdAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> createdAtNotIn, @Param("updatedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThan, @Param("updatedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThan, @Param("updatedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtGreaterThanOrEqual, @Param("updatedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime updatedAtLessThanOrEqual, @Param("updatedAtEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtEquals, @Param("updatedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime updatedAtNotEquals, @Param("updatedAtSpecified") @jakarta.annotation.Nullable Boolean updatedAtSpecified, @Param("updatedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtIn, @Param("updatedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> updatedAtNotIn, @Param("isDeletedEquals") @jakarta.annotation.Nullable Boolean isDeletedEquals, @Param("isDeletedNotEquals") @jakarta.annotation.Nullable Boolean isDeletedNotEquals, @Param("isDeletedSpecified") @jakarta.annotation.Nullable Boolean isDeletedSpecified, @Param("isDeletedIn") @jakarta.annotation.Nullable List<Boolean> isDeletedIn, @Param("isDeletedNotIn") @jakarta.annotation.Nullable List<Boolean> isDeletedNotIn, @Param("deletedAtGreaterThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThan, @Param("deletedAtLessThan") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThan, @Param("deletedAtGreaterThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtGreaterThanOrEqual, @Param("deletedAtLessThanOrEqual") @jakarta.annotation.Nullable OffsetDateTime deletedAtLessThanOrEqual, @Param("deletedAtEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtEquals, @Param("deletedAtNotEquals") @jakarta.annotation.Nullable OffsetDateTime deletedAtNotEquals, @Param("deletedAtSpecified") @jakarta.annotation.Nullable Boolean deletedAtSpecified, @Param("deletedAtIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtIn, @Param("deletedAtNotIn") @jakarta.annotation.Nullable List<OffsetDateTime> deletedAtNotIn, @Param("deletedByEquals") @jakarta.annotation.Nullable UUID deletedByEquals, @Param("deletedByNotEquals") @jakarta.annotation.Nullable UUID deletedByNotEquals, @Param("deletedBySpecified") @jakarta.annotation.Nullable Boolean deletedBySpecified, @Param("deletedByIn") @jakarta.annotation.Nullable List<UUID> deletedByIn, @Param("deletedByNotIn") @jakarta.annotation.Nullable List<UUID> deletedByNotIn, @Param("tripIdGreaterThan") @jakarta.annotation.Nullable Long tripIdGreaterThan, @Param("tripIdLessThan") @jakarta.annotation.Nullable Long tripIdLessThan, @Param("tripIdGreaterThanOrEqual") @jakarta.annotation.Nullable Long tripIdGreaterThanOrEqual, @Param("tripIdLessThanOrEqual") @jakarta.annotation.Nullable Long tripIdLessThanOrEqual, @Param("tripIdEquals") @jakarta.annotation.Nullable Long tripIdEquals, @Param("tripIdNotEquals") @jakarta.annotation.Nullable Long tripIdNotEquals, @Param("tripIdSpecified") @jakarta.annotation.Nullable Boolean tripIdSpecified, @Param("tripIdIn") @jakarta.annotation.Nullable List<Long> tripIdIn, @Param("tripIdNotIn") @jakarta.annotation.Nullable List<Long> tripIdNotIn, @Param("distinct") @jakarta.annotation.Nullable Boolean distinct);


  /**
   * 
   * 
   * Note, this is equivalent to the other <code>getAllSeatLocks</code> method,
   * but with the query parameters collected into a single Map parameter. This
   * is convenient for services with optional query parameters, especially when
   * used with the {@link GetAllSeatLocksQueryParams} class that allows for
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
   *   <li>seatNoContains -  (optional)</li>
   *   <li>seatNoDoesNotContain -  (optional)</li>
   *   <li>seatNoEquals -  (optional)</li>
   *   <li>seatNoNotEquals -  (optional)</li>
   *   <li>seatNoSpecified -  (optional)</li>
   *   <li>seatNoIn -  (optional)</li>
   *   <li>seatNoNotIn -  (optional)</li>
   *   <li>userIdGreaterThan -  (optional)</li>
   *   <li>userIdLessThan -  (optional)</li>
   *   <li>userIdGreaterThanOrEqual -  (optional)</li>
   *   <li>userIdLessThanOrEqual -  (optional)</li>
   *   <li>userIdEquals -  (optional)</li>
   *   <li>userIdNotEquals -  (optional)</li>
   *   <li>userIdSpecified -  (optional)</li>
   *   <li>userIdIn -  (optional)</li>
   *   <li>userIdNotIn -  (optional)</li>
   *   <li>statusEquals -  (optional)</li>
   *   <li>statusNotEquals -  (optional)</li>
   *   <li>statusSpecified -  (optional)</li>
   *   <li>statusIn -  (optional)</li>
   *   <li>statusNotIn -  (optional)</li>
   *   <li>expiresAtGreaterThan -  (optional)</li>
   *   <li>expiresAtLessThan -  (optional)</li>
   *   <li>expiresAtGreaterThanOrEqual -  (optional)</li>
   *   <li>expiresAtLessThanOrEqual -  (optional)</li>
   *   <li>expiresAtEquals -  (optional)</li>
   *   <li>expiresAtNotEquals -  (optional)</li>
   *   <li>expiresAtSpecified -  (optional)</li>
   *   <li>expiresAtIn -  (optional)</li>
   *   <li>expiresAtNotIn -  (optional)</li>
   *   <li>idempotencyKeyContains -  (optional)</li>
   *   <li>idempotencyKeyDoesNotContain -  (optional)</li>
   *   <li>idempotencyKeyEquals -  (optional)</li>
   *   <li>idempotencyKeyNotEquals -  (optional)</li>
   *   <li>idempotencyKeySpecified -  (optional)</li>
   *   <li>idempotencyKeyIn -  (optional)</li>
   *   <li>idempotencyKeyNotIn -  (optional)</li>
   *   <li>bookingIdGreaterThan -  (optional)</li>
   *   <li>bookingIdLessThan -  (optional)</li>
   *   <li>bookingIdGreaterThanOrEqual -  (optional)</li>
   *   <li>bookingIdLessThanOrEqual -  (optional)</li>
   *   <li>bookingIdEquals -  (optional)</li>
   *   <li>bookingIdNotEquals -  (optional)</li>
   *   <li>bookingIdSpecified -  (optional)</li>
   *   <li>bookingIdIn -  (optional)</li>
   *   <li>bookingIdNotIn -  (optional)</li>
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
   *   <li>tripIdGreaterThan -  (optional)</li>
   *   <li>tripIdLessThan -  (optional)</li>
   *   <li>tripIdGreaterThanOrEqual -  (optional)</li>
   *   <li>tripIdLessThanOrEqual -  (optional)</li>
   *   <li>tripIdEquals -  (optional)</li>
   *   <li>tripIdNotEquals -  (optional)</li>
   *   <li>tripIdSpecified -  (optional)</li>
   *   <li>tripIdIn -  (optional)</li>
   *   <li>tripIdNotIn -  (optional)</li>
   *   <li>distinct -  (optional)</li>
   *   </ul>
   * @return List&lt;SeatLockDTO&gt;
   */
  @RequestLine("GET /api/seat-locks?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&seatNo.contains={seatNoContains}&seatNo.doesNotContain={seatNoDoesNotContain}&seatNo.equals={seatNoEquals}&seatNo.notEquals={seatNoNotEquals}&seatNo.specified={seatNoSpecified}&seatNo.in={seatNoIn}&seatNo.notIn={seatNoNotIn}&userId.greaterThan={userIdGreaterThan}&userId.lessThan={userIdLessThan}&userId.greaterThanOrEqual={userIdGreaterThanOrEqual}&userId.lessThanOrEqual={userIdLessThanOrEqual}&userId.equals={userIdEquals}&userId.notEquals={userIdNotEquals}&userId.specified={userIdSpecified}&userId.in={userIdIn}&userId.notIn={userIdNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&expiresAt.greaterThan={expiresAtGreaterThan}&expiresAt.lessThan={expiresAtLessThan}&expiresAt.greaterThanOrEqual={expiresAtGreaterThanOrEqual}&expiresAt.lessThanOrEqual={expiresAtLessThanOrEqual}&expiresAt.equals={expiresAtEquals}&expiresAt.notEquals={expiresAtNotEquals}&expiresAt.specified={expiresAtSpecified}&expiresAt.in={expiresAtIn}&expiresAt.notIn={expiresAtNotIn}&idempotencyKey.contains={idempotencyKeyContains}&idempotencyKey.doesNotContain={idempotencyKeyDoesNotContain}&idempotencyKey.equals={idempotencyKeyEquals}&idempotencyKey.notEquals={idempotencyKeyNotEquals}&idempotencyKey.specified={idempotencyKeySpecified}&idempotencyKey.in={idempotencyKeyIn}&idempotencyKey.notIn={idempotencyKeyNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&tripId.greaterThan={tripIdGreaterThan}&tripId.lessThan={tripIdLessThan}&tripId.greaterThanOrEqual={tripIdGreaterThanOrEqual}&tripId.lessThanOrEqual={tripIdLessThanOrEqual}&tripId.equals={tripIdEquals}&tripId.notEquals={tripIdNotEquals}&tripId.specified={tripIdSpecified}&tripId.in={tripIdIn}&tripId.notIn={tripIdNotIn}&distinct={distinct}")
  @Headers({
  "Accept: */*",
  })
  List<SeatLockDTO> getAllSeatLocks(@QueryMap(encoded=true) GetAllSeatLocksQueryParams queryParams);

  /**
  * 
  * 
  * Note, this is equivalent to the other <code>getAllSeatLocks</code> that receives the query parameters as a map,
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
          *   <li>seatNoContains -  (optional)</li>
          *   <li>seatNoDoesNotContain -  (optional)</li>
          *   <li>seatNoEquals -  (optional)</li>
          *   <li>seatNoNotEquals -  (optional)</li>
          *   <li>seatNoSpecified -  (optional)</li>
          *   <li>seatNoIn -  (optional)</li>
          *   <li>seatNoNotIn -  (optional)</li>
          *   <li>userIdGreaterThan -  (optional)</li>
          *   <li>userIdLessThan -  (optional)</li>
          *   <li>userIdGreaterThanOrEqual -  (optional)</li>
          *   <li>userIdLessThanOrEqual -  (optional)</li>
          *   <li>userIdEquals -  (optional)</li>
          *   <li>userIdNotEquals -  (optional)</li>
          *   <li>userIdSpecified -  (optional)</li>
          *   <li>userIdIn -  (optional)</li>
          *   <li>userIdNotIn -  (optional)</li>
          *   <li>statusEquals -  (optional)</li>
          *   <li>statusNotEquals -  (optional)</li>
          *   <li>statusSpecified -  (optional)</li>
          *   <li>statusIn -  (optional)</li>
          *   <li>statusNotIn -  (optional)</li>
          *   <li>expiresAtGreaterThan -  (optional)</li>
          *   <li>expiresAtLessThan -  (optional)</li>
          *   <li>expiresAtGreaterThanOrEqual -  (optional)</li>
          *   <li>expiresAtLessThanOrEqual -  (optional)</li>
          *   <li>expiresAtEquals -  (optional)</li>
          *   <li>expiresAtNotEquals -  (optional)</li>
          *   <li>expiresAtSpecified -  (optional)</li>
          *   <li>expiresAtIn -  (optional)</li>
          *   <li>expiresAtNotIn -  (optional)</li>
          *   <li>idempotencyKeyContains -  (optional)</li>
          *   <li>idempotencyKeyDoesNotContain -  (optional)</li>
          *   <li>idempotencyKeyEquals -  (optional)</li>
          *   <li>idempotencyKeyNotEquals -  (optional)</li>
          *   <li>idempotencyKeySpecified -  (optional)</li>
          *   <li>idempotencyKeyIn -  (optional)</li>
          *   <li>idempotencyKeyNotIn -  (optional)</li>
          *   <li>bookingIdGreaterThan -  (optional)</li>
          *   <li>bookingIdLessThan -  (optional)</li>
          *   <li>bookingIdGreaterThanOrEqual -  (optional)</li>
          *   <li>bookingIdLessThanOrEqual -  (optional)</li>
          *   <li>bookingIdEquals -  (optional)</li>
          *   <li>bookingIdNotEquals -  (optional)</li>
          *   <li>bookingIdSpecified -  (optional)</li>
          *   <li>bookingIdIn -  (optional)</li>
          *   <li>bookingIdNotIn -  (optional)</li>
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
          *   <li>tripIdGreaterThan -  (optional)</li>
          *   <li>tripIdLessThan -  (optional)</li>
          *   <li>tripIdGreaterThanOrEqual -  (optional)</li>
          *   <li>tripIdLessThanOrEqual -  (optional)</li>
          *   <li>tripIdEquals -  (optional)</li>
          *   <li>tripIdNotEquals -  (optional)</li>
          *   <li>tripIdSpecified -  (optional)</li>
          *   <li>tripIdIn -  (optional)</li>
          *   <li>tripIdNotIn -  (optional)</li>
          *   <li>distinct -  (optional)</li>
      *   </ul>
          * @return List&lt;SeatLockDTO&gt;
      */
      @RequestLine("GET /api/seat-locks?id.greaterThan={idGreaterThan}&id.lessThan={idLessThan}&id.greaterThanOrEqual={idGreaterThanOrEqual}&id.lessThanOrEqual={idLessThanOrEqual}&id.equals={idEquals}&id.notEquals={idNotEquals}&id.specified={idSpecified}&id.in={idIn}&id.notIn={idNotIn}&seatNo.contains={seatNoContains}&seatNo.doesNotContain={seatNoDoesNotContain}&seatNo.equals={seatNoEquals}&seatNo.notEquals={seatNoNotEquals}&seatNo.specified={seatNoSpecified}&seatNo.in={seatNoIn}&seatNo.notIn={seatNoNotIn}&userId.greaterThan={userIdGreaterThan}&userId.lessThan={userIdLessThan}&userId.greaterThanOrEqual={userIdGreaterThanOrEqual}&userId.lessThanOrEqual={userIdLessThanOrEqual}&userId.equals={userIdEquals}&userId.notEquals={userIdNotEquals}&userId.specified={userIdSpecified}&userId.in={userIdIn}&userId.notIn={userIdNotIn}&status.equals={statusEquals}&status.notEquals={statusNotEquals}&status.specified={statusSpecified}&status.in={statusIn}&status.notIn={statusNotIn}&expiresAt.greaterThan={expiresAtGreaterThan}&expiresAt.lessThan={expiresAtLessThan}&expiresAt.greaterThanOrEqual={expiresAtGreaterThanOrEqual}&expiresAt.lessThanOrEqual={expiresAtLessThanOrEqual}&expiresAt.equals={expiresAtEquals}&expiresAt.notEquals={expiresAtNotEquals}&expiresAt.specified={expiresAtSpecified}&expiresAt.in={expiresAtIn}&expiresAt.notIn={expiresAtNotIn}&idempotencyKey.contains={idempotencyKeyContains}&idempotencyKey.doesNotContain={idempotencyKeyDoesNotContain}&idempotencyKey.equals={idempotencyKeyEquals}&idempotencyKey.notEquals={idempotencyKeyNotEquals}&idempotencyKey.specified={idempotencyKeySpecified}&idempotencyKey.in={idempotencyKeyIn}&idempotencyKey.notIn={idempotencyKeyNotIn}&bookingId.greaterThan={bookingIdGreaterThan}&bookingId.lessThan={bookingIdLessThan}&bookingId.greaterThanOrEqual={bookingIdGreaterThanOrEqual}&bookingId.lessThanOrEqual={bookingIdLessThanOrEqual}&bookingId.equals={bookingIdEquals}&bookingId.notEquals={bookingIdNotEquals}&bookingId.specified={bookingIdSpecified}&bookingId.in={bookingIdIn}&bookingId.notIn={bookingIdNotIn}&createdAt.greaterThan={createdAtGreaterThan}&createdAt.lessThan={createdAtLessThan}&createdAt.greaterThanOrEqual={createdAtGreaterThanOrEqual}&createdAt.lessThanOrEqual={createdAtLessThanOrEqual}&createdAt.equals={createdAtEquals}&createdAt.notEquals={createdAtNotEquals}&createdAt.specified={createdAtSpecified}&createdAt.in={createdAtIn}&createdAt.notIn={createdAtNotIn}&updatedAt.greaterThan={updatedAtGreaterThan}&updatedAt.lessThan={updatedAtLessThan}&updatedAt.greaterThanOrEqual={updatedAtGreaterThanOrEqual}&updatedAt.lessThanOrEqual={updatedAtLessThanOrEqual}&updatedAt.equals={updatedAtEquals}&updatedAt.notEquals={updatedAtNotEquals}&updatedAt.specified={updatedAtSpecified}&updatedAt.in={updatedAtIn}&updatedAt.notIn={updatedAtNotIn}&isDeleted.equals={isDeletedEquals}&isDeleted.notEquals={isDeletedNotEquals}&isDeleted.specified={isDeletedSpecified}&isDeleted.in={isDeletedIn}&isDeleted.notIn={isDeletedNotIn}&deletedAt.greaterThan={deletedAtGreaterThan}&deletedAt.lessThan={deletedAtLessThan}&deletedAt.greaterThanOrEqual={deletedAtGreaterThanOrEqual}&deletedAt.lessThanOrEqual={deletedAtLessThanOrEqual}&deletedAt.equals={deletedAtEquals}&deletedAt.notEquals={deletedAtNotEquals}&deletedAt.specified={deletedAtSpecified}&deletedAt.in={deletedAtIn}&deletedAt.notIn={deletedAtNotIn}&deletedBy.equals={deletedByEquals}&deletedBy.notEquals={deletedByNotEquals}&deletedBy.specified={deletedBySpecified}&deletedBy.in={deletedByIn}&deletedBy.notIn={deletedByNotIn}&tripId.greaterThan={tripIdGreaterThan}&tripId.lessThan={tripIdLessThan}&tripId.greaterThanOrEqual={tripIdGreaterThanOrEqual}&tripId.lessThanOrEqual={tripIdLessThanOrEqual}&tripId.equals={tripIdEquals}&tripId.notEquals={tripIdNotEquals}&tripId.specified={tripIdSpecified}&tripId.in={tripIdIn}&tripId.notIn={tripIdNotIn}&distinct={distinct}")
      @Headers({
    "Accept: */*",
      })
   ApiResponse<List<SeatLockDTO>> getAllSeatLocksWithHttpInfo(@QueryMap(encoded=true) GetAllSeatLocksQueryParams queryParams);


   /**
   * A convenience class for generating query parameters for the
   * <code>getAllSeatLocks</code> method in a fluent style.
   */
  public static class GetAllSeatLocksQueryParams extends HashMap<String, Object> {
    public GetAllSeatLocksQueryParams idGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams idLessThan(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams idGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams idLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("id.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams idEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams idNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("id.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams idSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("id.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams idIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatLocksQueryParams idNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("id.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatLocksQueryParams seatNoContains(@jakarta.annotation.Nullable final String value) {
      put("seatNo.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams seatNoDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("seatNo.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams seatNoEquals(@jakarta.annotation.Nullable final String value) {
      put("seatNo.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams seatNoNotEquals(@jakarta.annotation.Nullable final String value) {
      put("seatNo.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams seatNoSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("seatNo.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams seatNoIn(@jakarta.annotation.Nullable final List<String> value) {
      put("seatNo.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatLocksQueryParams seatNoNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("seatNo.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatLocksQueryParams userIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("userId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams userIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("userId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams userIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("userId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams userIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("userId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams userIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("userId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams userIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("userId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams userIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("userId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams userIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("userId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatLocksQueryParams userIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("userId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatLocksQueryParams statusEquals(@jakarta.annotation.Nullable final String value) {
      put("status.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams statusNotEquals(@jakarta.annotation.Nullable final String value) {
      put("status.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams statusSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("status.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams statusIn(@jakarta.annotation.Nullable final List<String> value) {
      put("status.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatLocksQueryParams statusNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("status.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatLocksQueryParams expiresAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("expiresAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams expiresAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("expiresAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams expiresAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("expiresAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams expiresAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("expiresAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams expiresAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("expiresAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams expiresAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("expiresAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams expiresAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("expiresAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams expiresAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("expiresAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatLocksQueryParams expiresAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("expiresAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatLocksQueryParams idempotencyKeyContains(@jakarta.annotation.Nullable final String value) {
      put("idempotencyKey.contains", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams idempotencyKeyDoesNotContain(@jakarta.annotation.Nullable final String value) {
      put("idempotencyKey.doesNotContain", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams idempotencyKeyEquals(@jakarta.annotation.Nullable final String value) {
      put("idempotencyKey.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams idempotencyKeyNotEquals(@jakarta.annotation.Nullable final String value) {
      put("idempotencyKey.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams idempotencyKeySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("idempotencyKey.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams idempotencyKeyIn(@jakarta.annotation.Nullable final List<String> value) {
      put("idempotencyKey.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatLocksQueryParams idempotencyKeyNotIn(@jakarta.annotation.Nullable final List<String> value) {
      put("idempotencyKey.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatLocksQueryParams bookingIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams bookingIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams bookingIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams bookingIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams bookingIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams bookingIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("bookingId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams bookingIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("bookingId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams bookingIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("bookingId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatLocksQueryParams bookingIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("bookingId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatLocksQueryParams createdAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams createdAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams createdAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams createdAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams createdAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams createdAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("createdAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams createdAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("createdAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams createdAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatLocksQueryParams createdAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("createdAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatLocksQueryParams updatedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams updatedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams updatedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams updatedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams updatedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams updatedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("updatedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams updatedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("updatedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams updatedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatLocksQueryParams updatedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("updatedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatLocksQueryParams isDeletedEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams isDeletedNotEquals(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams isDeletedSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("isDeleted.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams isDeletedIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatLocksQueryParams isDeletedNotIn(@jakarta.annotation.Nullable final List<Boolean> value) {
      put("isDeleted.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatLocksQueryParams deletedAtGreaterThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams deletedAtLessThan(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams deletedAtGreaterThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams deletedAtLessThanOrEqual(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams deletedAtEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams deletedAtNotEquals(@jakarta.annotation.Nullable final OffsetDateTime value) {
      put("deletedAt.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams deletedAtSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedAt.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams deletedAtIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatLocksQueryParams deletedAtNotIn(@jakarta.annotation.Nullable final List<OffsetDateTime> value) {
      put("deletedAt.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatLocksQueryParams deletedByEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams deletedByNotEquals(@jakarta.annotation.Nullable final UUID value) {
      put("deletedBy.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams deletedBySpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("deletedBy.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams deletedByIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatLocksQueryParams deletedByNotIn(@jakarta.annotation.Nullable final List<UUID> value) {
      put("deletedBy.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatLocksQueryParams tripIdGreaterThan(@jakarta.annotation.Nullable final Long value) {
      put("tripId.greaterThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams tripIdLessThan(@jakarta.annotation.Nullable final Long value) {
      put("tripId.lessThan", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams tripIdGreaterThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("tripId.greaterThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams tripIdLessThanOrEqual(@jakarta.annotation.Nullable final Long value) {
      put("tripId.lessThanOrEqual", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams tripIdEquals(@jakarta.annotation.Nullable final Long value) {
      put("tripId.equals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams tripIdNotEquals(@jakarta.annotation.Nullable final Long value) {
      put("tripId.notEquals", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams tripIdSpecified(@jakarta.annotation.Nullable final Boolean value) {
      put("tripId.specified", EncodingUtils.encode(value));
      return this;
    }
    public GetAllSeatLocksQueryParams tripIdIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("tripId.in", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatLocksQueryParams tripIdNotIn(@jakarta.annotation.Nullable final List<Long> value) {
      put("tripId.notIn", EncodingUtils.encodeCollection(value, "multi"));
      return this;
    }
    public GetAllSeatLocksQueryParams distinct(@jakarta.annotation.Nullable final Boolean value) {
      put("distinct", EncodingUtils.encode(value));
      return this;
    }
  }

  /**
   * 
   * 
   * @param id  (required)
   * @return SeatLockDTO
   */
  @RequestLine("GET /api/seat-locks/{id}")
  @Headers({
    "Accept: */*",
  })
  SeatLockDTO getSeatLock(@Param("id") @jakarta.annotation.Nonnull Long id);

  /**
   * 
   * Similar to <code>getSeatLock</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("GET /api/seat-locks/{id}")
  @Headers({
    "Accept: */*",
  })
  ApiResponse<SeatLockDTO> getSeatLockWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id);



  /**
   * 
   * 
   * @param id  (required)
   * @param seatLockDTO  (required)
   * @return SeatLockDTO
   */
  @RequestLine("PATCH /api/seat-locks/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  SeatLockDTO partialUpdateSeatLock(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull SeatLockDTO seatLockDTO);

  /**
   * 
   * Similar to <code>partialUpdateSeatLock</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param seatLockDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PATCH /api/seat-locks/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<SeatLockDTO> partialUpdateSeatLockWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull SeatLockDTO seatLockDTO);



  /**
   * 
   * 
   * @param seatLockRequestDTO  (required)
   * @return SeatLockResponseDTO
   */
  @RequestLine("POST /api/seat-locks/try-lock")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  SeatLockResponseDTO tryLockSeats(@jakarta.annotation.Nonnull SeatLockRequestDTO seatLockRequestDTO);

  /**
   * 
   * Similar to <code>tryLockSeats</code> but it also returns the http response headers .
   * 
   * @param seatLockRequestDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("POST /api/seat-locks/try-lock")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<SeatLockResponseDTO> tryLockSeatsWithHttpInfo(@jakarta.annotation.Nonnull SeatLockRequestDTO seatLockRequestDTO);



  /**
   * 
   * 
   * @param id  (required)
   * @param seatLockDTO  (required)
   * @return SeatLockDTO
   */
  @RequestLine("PUT /api/seat-locks/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  SeatLockDTO updateSeatLock(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull SeatLockDTO seatLockDTO);

  /**
   * 
   * Similar to <code>updateSeatLock</code> but it also returns the http response headers .
   * 
   * @param id  (required)
   * @param seatLockDTO  (required)
   * @return A ApiResponse that wraps the response boyd and the http headers.
   */
  @RequestLine("PUT /api/seat-locks/{id}")
  @Headers({
    "Content-Type: application/json",
    "Accept: */*",
  })
  ApiResponse<SeatLockDTO> updateSeatLockWithHttpInfo(@Param("id") @jakarta.annotation.Nonnull Long id, @jakarta.annotation.Nonnull SeatLockDTO seatLockDTO);


}
