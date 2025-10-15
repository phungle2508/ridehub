package com.ridehub.booking.web.rest.admin;

import com.ridehub.booking.domain.Booking;
import com.ridehub.booking.domain.PaymentTransaction;
import com.ridehub.booking.domain.Ticket;
import com.ridehub.booking.domain.enumeration.BookingStatus;
import com.ridehub.booking.domain.enumeration.PaymentStatus;
import com.ridehub.booking.repository.BookingRepository;
import com.ridehub.booking.repository.PaymentTransactionRepository;
import com.ridehub.booking.repository.TicketRepository;
import com.ridehub.booking.web.rest.errors.BadRequestAlertException;
import com.ridehub.msroute.client.api.SeatLockResourceMsrouteApi;
import com.ridehub.msroute.client.api.TripResourceMsrouteApi;
import com.ridehub.msroute.client.model.CancelGroupRequestDTO;
import com.ridehub.msroute.client.model.ConfirmGroupRequestDTO;
import com.ridehub.msroute.client.model.SeatDTO;
import com.ridehub.msroute.client.model.SeatLockActionRequestDTO;
import com.ridehub.msroute.client.model.SeatLockActionResponseDTO;
import com.ridehub.msroute.client.model.TripDetailVM;
import com.ridehub.msroute.client.model.TripDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.persistence.criteria.Predicate;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * REST controller for admin booking management.
 */
@RestController
@RequestMapping("/api/admin/bookings")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
public class AdminBookingController {

    private final Logger log = LoggerFactory.getLogger(AdminBookingController.class);

    private static final String ENTITY_NAME = "booking";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final BookingRepository bookingRepository;
    private final TicketRepository ticketRepository;
    private final PaymentTransactionRepository paymentTransactionRepository;
    private final SeatLockResourceMsrouteApi seatLockResourceMsrouteApi;
    private final TripResourceMsrouteApi tripResourceMsrouteApi;
    private final StringRedisTemplate redisTemplate;

    public AdminBookingController(
            BookingRepository bookingRepository,
            TicketRepository ticketRepository,
            PaymentTransactionRepository paymentTransactionRepository,
            SeatLockResourceMsrouteApi seatLockResourceMsrouteApi,
            TripResourceMsrouteApi tripResourceMsrouteApi,
            StringRedisTemplate redisTemplate) {
        this.bookingRepository = bookingRepository;
        this.ticketRepository = ticketRepository;
        this.paymentTransactionRepository = paymentTransactionRepository;
        this.seatLockResourceMsrouteApi = seatLockResourceMsrouteApi;
        this.tripResourceMsrouteApi = tripResourceMsrouteApi;
        this.redisTemplate = redisTemplate;
    }

    /**
     * {@code GET  /api/admin/bookings} : get all bookings with optional filtering.
     *
     * @param status     the booking status to filter by (optional).
     * @param customerId the customer ID to filter by (optional).
     * @param tripId     the trip ID to filter by (optional).
     * @param pageable   the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list
     *         of bookings in body.
     */
    @GetMapping("")
    public ResponseEntity<Page<Booking>> getAllBookings(
            @RequestParam(required = false) BookingStatus status,
            @RequestParam(required = false) UUID customerId,
            @RequestParam(required = false) Long tripId,
            Pageable pageable) {
        log.debug("REST request to get Bookings with filters - status: {}, customerId: {}, tripId: {}",
                status, customerId, tripId);

        Specification<Booking> spec = (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (status != null) {
                predicates.add(criteriaBuilder.equal(root.get("status"), status));
            }

            if (customerId != null) {
                predicates.add(criteriaBuilder.equal(root.get("customerId"), customerId));
            }

            if (tripId != null) {
                predicates.add(criteriaBuilder.equal(root.get("tripId"), tripId));
            }

            // Exclude deleted bookings
            predicates.add(criteriaBuilder.or(
                    criteriaBuilder.isNull(root.get("isDeleted")),
                    criteriaBuilder.equal(root.get("isDeleted"), false)));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };

        Page<Booking> bookings = bookingRepository.findAll(spec, pageable);
        return ResponseEntity.ok().body(bookings);
    }

    /**
     * {@code GET /api/admin/bookings/{id}} : get the booking by id.
     *
     * @param id the id of the booking to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body
     *         the booking.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable Long id) {
        log.debug("REST request to get Booking : {}", id);
        Optional<Booking> booking = bookingRepository.findById(id);
        return booking.map(response -> ResponseEntity.ok().body(response))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * {@code POST /api/admin/bookings/{id}/confirm} : confirm a booking.
     *
     * @param id the id of the booking to confirm.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)}.
     */
    @PostMapping("/{id}/confirm")
    public ResponseEntity<Void> confirmBooking(@PathVariable Long id) {
        log.debug("REST request to confirm Booking : {}", id);

        Optional<Booking> bookingOpt = bookingRepository.findById(id);
        if (bookingOpt.isEmpty()) {
            throw new BadRequestAlertException("Booking not found", ENTITY_NAME, "bookingnotfound");
        }

        Booking booking = bookingOpt.get();
        if (booking.getStatus() == BookingStatus.CONFIRMED) {
            throw new BadRequestAlertException("Booking already confirmed", ENTITY_NAME, "alreadyconfirmed");
        }

        if (booking.getStatus() == BookingStatus.CANCELED) {
            throw new BadRequestAlertException("Cannot confirm canceled booking", ENTITY_NAME, "bookingcanceled");
        }

        // Update booking status
        booking.setStatus(BookingStatus.CONFIRMED);
        booking.setUpdatedAt(Instant.now());

        // Create tickets if they don't exist
        createTicketsForBooking(booking);

        // Confirm seat locks
        if (booking.getLockGroupId() != null && booking.getTripId() != null) {
            confirmSeatLocks(booking);
        }

        bookingRepository.save(booking);

        log.info("Successfully confirmed booking: {}", booking.getBookingCode());
        return ResponseEntity.ok().build();
    }

    /**
     * {@code POST /api/admin/bookings/{id}/cancel} : cancel a booking.
     *
     * @param id the id of the booking to cancel.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)}.
     */
    @PostMapping("/{id}/cancel")
    public ResponseEntity<Void> cancelBooking(@PathVariable Long id) {
        log.debug("REST request to cancel Booking : {}", id);

        Optional<Booking> bookingOpt = bookingRepository.findById(id);
        if (bookingOpt.isEmpty()) {
            throw new BadRequestAlertException("Booking not found", ENTITY_NAME, "bookingnotfound");
        }

        Booking booking = bookingOpt.get();

        if (booking.getStatus() == BookingStatus.CANCELED) {
            throw new BadRequestAlertException("Booking already canceled", ENTITY_NAME, "alreadycanceled");
        }

        // Update booking status
        booking.setStatus(BookingStatus.CANCELED);
        booking.setUpdatedAt(Instant.now());
        bookingRepository.save(booking);

        // Cancel seat locks
        if (booking.getLockGroupId() != null && booking.getTripId() != null) {
            cancelSeatLocks(booking);
        }

        log.info("Successfully canceled booking: {}", booking.getBookingCode());
        return ResponseEntity.ok().build();
    }

    /**
     * {@code POST /api/admin/bookings/recover-expired-payment} : Recover a booking
     * where payment succeeded but booking expired.
     * This is a CRITICAL endpoint to handle the race condition where VNPay payment
     * succeeded but database was down.
     *
     * @param transactionId the payment transaction ID to recover
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and recovery
     *         details
     */
    @PostMapping("/recover-expired-payment")
    public ResponseEntity<Map<String, Object>> recoverExpiredBookingPayment(@RequestParam String transactionId) {
        log.info("🚨 CRITICAL RECOVERY INITIATED: Recovering expired booking for successful payment transaction: {}",
                transactionId);

        Map<String, Object> response = new HashMap<>();

        try {
            // Find the payment transaction
            Optional<PaymentTransaction> transactionOpt = paymentTransactionRepository
                    .findByTransactionIdAndIsDeletedFalseOrIsDeletedIsNull(transactionId);

            if (transactionOpt.isEmpty()) {
                throw new BadRequestAlertException("Payment transaction not found", "paymentTransaction",
                        "transactionnotfound");
            }

            PaymentTransaction transaction = transactionOpt.get();

            // Validate this is a critical case that needs recovery
            if (transaction.getStatus() != PaymentStatus.PAYMENT_SUCCESS_BUT_BOOKING_EXPIRED) {
                throw new BadRequestAlertException(
                        "Transaction is not in PAYMENT_SUCCESS_BUT_BOOKING_EXPIRED status. Current status: "
                                + transaction.getStatus(),
                        "paymentTransaction", "invalidstatus");
            }

            // Get the associated booking
            Booking booking = transaction.getBooking();
            if (booking == null) {
                throw new BadRequestAlertException("No booking associated with this transaction", "paymentTransaction",
                        "nobooking");
            }

            log.warn("🚨 RECOVERING: Booking {} expired but payment {} succeeded. Starting recovery process...",
                    booking.getBookingCode(), transactionId);

            // Step 1: Reactivate the booking
            booking.setStatus(BookingStatus.CONFIRMED);
            booking.setUpdatedAt(Instant.now());

            // Extend booking expiration if needed (give customer more time)
            Instant newExpiration = Instant.now().plus(24, ChronoUnit.HOURS); // Give 24 hours
            booking.setExpiresAt(newExpiration);

            // Save the reactivated booking
            bookingRepository.save(booking);

            log.info("🚨 RECOVERY: Booking {} reactivated and extended until {} as compensation",
                    booking.getBookingCode(), newExpiration);

            // Step 2: Update payment transaction status to SUCCESS
            transaction.setStatus(PaymentStatus.SUCCESS);
            transaction.setUpdatedAt(Instant.now());

            String paymentRecoveryNote = String.format(
                    "🚨 RECOVERY COMPLETED: Payment successfully recovered and booking reactivated on %s. " +
                            "Original issue: Payment succeeded but booking expired due to race condition.",
                    Instant.now());

            String existingPaymentNote = transaction.getGatewayNote();
            if (existingPaymentNote != null && !existingPaymentNote.isEmpty()) {
                transaction.setGatewayNote(existingPaymentNote + " | " + paymentRecoveryNote);
            } else {
                transaction.setGatewayNote(paymentRecoveryNote);
            }

            paymentTransactionRepository.save(transaction);

            // Step 3: Confirm seat locks FIRST (critical before creating tickets)
            try {
                if (booking.getLockGroupId() != null && booking.getTripId() != null) {
                    confirmSeatLocks(booking);
                    log.info("✅ Seat locks confirmed successfully for recovered booking: {}", booking.getBookingCode());
                } else {
                    throw new IllegalStateException("Cannot confirm seat locks - missing lock group ID or trip ID");
                }
            } catch (Exception e) {
                log.error("❌ CRITICAL: Seat lock confirmation failed for recovered booking {}: {}",
                        booking.getBookingCode(), e.getMessage());

                // Mark booking with special status for seat lock failure
                booking.setStatus(BookingStatus.RECOVERY_FAILED_SEAT_LOCKS);
                booking.setUpdatedAt(Instant.now());
                bookingRepository.save(booking);

                // Update payment transaction with failure note
                String seatLockFailureNote = String.format(
                        "🚨 SEAT LOCK RECOVERY FAILED: Cannot confirm seat locks for recovered booking on %s. " +
                                "Error: %s. Manual intervention required to resolve seat allocation.",
                        Instant.now(),
                        e.getMessage());

                String currentPaymentNote = transaction.getGatewayNote();
                if (currentPaymentNote != null && !currentPaymentNote.isEmpty()) {
                    transaction.setGatewayNote(currentPaymentNote + " | " + seatLockFailureNote);
                } else {
                    transaction.setGatewayNote(seatLockFailureNote);
                }

                paymentTransactionRepository.save(transaction);

                // Return error response
                response.put("success", false);
                response.put("message",
                        "Recovery failed: Seat locks could not be confirmed. Seats may no longer be available.");
                response.put("bookingCode", booking.getBookingCode());
                response.put("transactionId", transactionId);
                response.put("bookingStatus", booking.getStatus());
                response.put("paymentStatus", transaction.getStatus());
                response.put("seatLockError", e.getMessage());
                response.put("requiresManualIntervention", true);

                return ResponseEntity.badRequest().body(response);
            }

            // Step 4: Create tickets for the recovered booking (only after seat locks are
            // confirmed)
            try {
                createTicketsForBooking(booking);
                log.info("✅ Tickets created successfully for recovered booking: {}", booking.getBookingCode());
            } catch (Exception e) {
                log.error("❌ Failed to create tickets for recovered booking {}: {}", booking.getBookingCode(),
                        e.getMessage());

                // Even if ticket creation fails, we don't roll back the entire recovery
                // since seat locks are confirmed and payment is successful
                // Admin can manually create tickets later
                response.put("warning",
                        "Seat locks confirmed but ticket creation failed. Manual ticket creation may be required.");
            }

            // Build success response
            response.put("success", true);
            response.put("message",
                    "CRITICAL RECOVERY COMPLETED: Booking successfully recovered after payment success");
            response.put("bookingCode", booking.getBookingCode());
            response.put("transactionId", transactionId);
            response.put("recoveredAt", Instant.now());
            response.put("newExpiration", newExpiration);
            response.put("originalAmount", transaction.getAmount());
            response.put("bookingStatus", booking.getStatus());
            response.put("paymentStatus", transaction.getStatus());
            response.put("ticketsCreated", ticketRepository.findByBookingId(booking.getId()).size());

            log.info(
                    "🎉 CRITICAL RECOVERY SUCCESS: Booking {} recovered with payment {}. Customer compensated for system issue.",
                    booking.getBookingCode(), transactionId);

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            log.error("💥 CRITICAL RECOVERY FAILED: Could not recover booking for payment transaction {}: {}",
                    transactionId, e.getMessage(), e);

            response.put("success", false);
            response.put("message", "Recovery failed: " + e.getMessage());
            response.put("transactionId", transactionId);
            response.put("error", e.getClass().getSimpleName());

            return ResponseEntity.badRequest().body(response);
        }
    }

    /**
     * {@code GET /api/admin/bookings/critical-payments} : Get all payments that
     * need manual recovery.
     * This endpoint helps admins identify all the critical cases that need
     * attention.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and list of
     *         critical payments
     */
    @GetMapping("/critical-payments")
    public ResponseEntity<List<Map<String, Object>>> getCriticalPayments() {
        log.debug("Fetching all payments that require manual recovery");

        try {
            // Find all transactions with critical statuses
            List<PaymentStatus> criticalStatuses = List.of(
                    PaymentStatus.PAYMENT_SUCCESS_BUT_BOOKING_EXPIRED,
                    PaymentStatus.REQUIRES_MANUAL_REVIEW);

            List<PaymentTransaction> criticalTransactions = paymentTransactionRepository
                    .findByStatusInAndIsDeletedFalseOrIsDeletedIsNull(criticalStatuses);

            List<Map<String, Object>> result = new ArrayList<>();

            for (PaymentTransaction transaction : criticalTransactions) {
                Map<String, Object> transactionInfo = new HashMap<>();
                transactionInfo.put("id", transaction.getId());
                transactionInfo.put("transactionId", transaction.getTransactionId());
                transactionInfo.put("orderRef", transaction.getOrderRef());
                transactionInfo.put("amount", transaction.getAmount());
                transactionInfo.put("status", transaction.getStatus());
                transactionInfo.put("method", transaction.getMethod());
                transactionInfo.put("createdAt", transaction.getCreatedAt());
                transactionInfo.put("updatedAt", transaction.getUpdatedAt());
                transactionInfo.put("gatewayNote", transaction.getGatewayNote());

                // Add booking info if available
                if (transaction.getBooking() != null) {
                    Booking booking = transaction.getBooking();
                    Map<String, Object> bookingInfo = new HashMap<>();
                    bookingInfo.put("id", booking.getId());
                    bookingInfo.put("bookingCode", booking.getBookingCode());
                    bookingInfo.put("status", booking.getStatus());
                    bookingInfo.put("customerId", booking.getCustomerId());
                    bookingInfo.put("totalAmount", booking.getTotalAmount());
                    bookingInfo.put("expiresAt", booking.getExpiresAt());
                    transactionInfo.put("booking", bookingInfo);
                }

                result.add(transactionInfo);
            }

            log.info("Found {} critical payments requiring attention", result.size());
            return ResponseEntity.ok(result);

        } catch (Exception e) {
            log.error("Error fetching critical payments: {}", e.getMessage(), e);
            return ResponseEntity.internalServerError().build();
        }
    }

    private void createTicketsForBooking(Booking booking) {
        // Check if tickets already exist
        List<Ticket> existingTickets = ticketRepository.findByBookingId(booking.getId());
        if (!existingTickets.isEmpty()) {
            log.debug("Tickets already exist for booking: {}", booking.getBookingCode());
            return;
        }

        try {
            // 1) Fetch trip detail to get route information
            TripDetailVM trip = tripResourceMsrouteApi.getTripDetail(booking.getTripId());
            TripDTO tripDTO = trip.getTripDTO();

            if (tripDTO == null || tripDTO.getRoute() == null) {
                throw new IllegalStateException("Trip detail/route not found for trip " + booking.getTripId());
            }

            // 2) For ticket creation, we need to get seat information from existing tickets
            // or from the trip details. Since we're using group-based seat lock operations,
            // we'll create tickets based on the booking's existing tickets if they exist,
            // or use a simplified approach for new tickets.

            // For group-based seat lock operations, we create tickets without needing
            // individual seat numbers
            // Create a single ticket for the booking amount when using group operations
            log.info("Creating single ticket for booking: {} using group-based approach",
                    booking.getBookingCode());

            Ticket ticket = new Ticket();
            ticket.setTicketCode(generateTicketCode());
            ticket.setPrice(booking.getTotalAmount());
            ticket.setQrCode(null);
            ticket.setTimeFrom(tripDTO.getDepartureTime().toInstant());
            ticket.setTimeTo(tripDTO.getArrivalTime().toInstant());
            ticket.setCheckedIn(false);
            ticket.setTripId(tripDTO.getId());
            ticket.setRouteId(tripDTO.getRoute().getId());
            ticket.setSeatId(null); // Will be set later when seat info is available from ms-route
            ticket.setCreatedAt(Instant.now());
            ticket.setBooking(booking);
            ticketRepository.save(ticket);

            log.info("Created single ticket for booking: {}", booking.getBookingCode());

        } catch (Exception e) {
            log.error("Failed to create tickets for booking: {}", booking.getBookingCode(), e);
            throw new BadRequestAlertException("Failed to create tickets: " + e.getMessage(), ENTITY_NAME,
                    "ticketcreationerror");
        }
    }

    private void confirmSeatLocks(Booking booking) {
        try {
            log.info("Confirming seat locks for booking: {} using group-based operation", booking.getBookingCode());

            // Use booking-level confirmation instead of individual seat numbers
            // This is more efficient and doesn't require loading seat numbers
            ConfirmGroupRequestDTO body = new ConfirmGroupRequestDTO();
            body.setBookingId(booking.getId());
            body.setLockGroupId(booking.getLockGroupId());
            // Note: No need to set seatNumbers for group operations
            // The API should handle all seats in the booking's lock group

            SeatLockActionResponseDTO res = seatLockResourceMsrouteApi.confirmGroup(body);
            if (res == null || res.getStatus() == null || !"CONFIRMED".equalsIgnoreCase(res.getStatus())) {
                throw new IllegalStateException(
                        "Seat confirm failed: " + (res != null ? res.getMessage() : "null response"));
            }

            log.info("Successfully confirmed seat locks for booking: {}", booking.getBookingCode());
        } catch (Exception e) {
            log.error("Failed to confirm seat locks for booking: {}", booking.getBookingCode(), e);
            throw new BadRequestAlertException("Failed to confirm seat locks", ENTITY_NAME, "seatlockerror");
        }
    }

    private String generateTicketCode() {
        return "TKT-" + UUID.randomUUID().toString().substring(0, 12).toUpperCase();
    }

    /**
     * Cancel seat locks for a booking using group-based operation.
     */
    private void cancelSeatLocks(Booking booking) {
        try {
            log.info("Canceling seat locks for booking: {} using group-based operation", booking.getBookingCode());

            // Use booking-level cancellation instead of individual seat numbers
            // This is more efficient and doesn't require loading seat numbers
            CancelGroupRequestDTO body = new CancelGroupRequestDTO();
            body.setBookingId(booking.getId());
            body.setLockGroupId(booking.getLockGroupId());
            // Note: No need to set seatNumbers for group operations
            // The API should handle all seats in the booking's lock group

            SeatLockActionResponseDTO res = seatLockResourceMsrouteApi.cancelGroup(body);
            if (res == null || res.getStatus() == null || !"CONFIRMED".equalsIgnoreCase(res.getStatus())) {
                log.warn("Seat cancel returned non-OK for booking {}: {}",
                        booking.getBookingCode(), res != null ? res.getMessage() : "null response");
            } else {
                log.info("Successfully canceled seat locks for booking: {}", booking.getBookingCode());
            }
        } catch (Exception e) {
            log.error("Failed to cancel seat locks for booking: {}", booking.getBookingCode(), e);
        }
    }

}
