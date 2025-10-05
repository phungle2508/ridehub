package com.ridehub.booking.web.rest.admin;

import com.ridehub.booking.domain.Booking;
import com.ridehub.booking.domain.Ticket;
import com.ridehub.booking.domain.enumeration.BookingStatus;
import com.ridehub.booking.repository.BookingRepository;
import com.ridehub.booking.repository.TicketRepository;
import com.ridehub.booking.web.rest.errors.BadRequestAlertException;
import com.ridehub.msroute.client.api.SeatLockResourceMsrouteApi;
import com.ridehub.msroute.client.model.SeatLockActionRequestDTO;
import com.ridehub.msroute.client.model.SeatLockActionResponseDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.persistence.criteria.Predicate;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

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
    private final SeatLockResourceMsrouteApi seatLockResourceMsrouteApi;
    private final StringRedisTemplate redisTemplate;

    public AdminBookingController(
            BookingRepository bookingRepository,
            TicketRepository ticketRepository,
            SeatLockResourceMsrouteApi seatLockResourceMsrouteApi,
            StringRedisTemplate redisTemplate) {
        this.bookingRepository = bookingRepository;
        this.ticketRepository = ticketRepository;
        this.seatLockResourceMsrouteApi = seatLockResourceMsrouteApi;
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
        bookingRepository.save(booking);

        // Create tickets if they don't exist
        createTicketsForBooking(booking);

        // Confirm seat locks
        if (booking.getLockGroupId() != null && booking.getTripId() != null) {
            confirmSeatLocks(booking);
        }

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

    private void createTicketsForBooking(Booking booking) {
        // Check if tickets already exist
        List<Ticket> existingTickets = ticketRepository.findByBookingId(booking.getId());
        if (!existingTickets.isEmpty()) {
            log.debug("Tickets already exist for booking: {}", booking.getBookingCode());
            return;
        }

        // Create tickets based on booking quantity
        Integer quantity = booking.getQuantity();
        if (quantity == null || quantity <= 0) {
            quantity = 1; // Default to 1 ticket
        }

        for (int i = 0; i < quantity; i++) {
            Ticket ticket = new Ticket();
            ticket.setTicketCode(generateTicketCode(booking.getBookingCode(), i + 1));
            ticket.setPrice(booking.getTotalAmount().divide(java.math.BigDecimal.valueOf(quantity)));
            ticket.setTripId(booking.getTripId());
            ticket.setRouteId(1L); // Default route ID - should be derived from trip
            ticket.setSeatId(1L + i); // Default seat ID - should be derived from seat locks
            ticket.setCheckedIn(false);
            ticket.setCreatedAt(Instant.now());
            ticket.setBooking(booking);

            ticketRepository.save(ticket);
        }

        log.info("Created {} tickets for booking: {}", quantity, booking.getBookingCode());
    }

    private void confirmSeatLocks(Booking booking) {
        try {
            log.info("Confirming seat locks for booking: {}", booking.getBookingCode());

            // Load seat numbers for the booking from Redis
            List<String> seatNos = loadSeatNosForBooking(booking);

            SeatLockActionRequestDTO body = new SeatLockActionRequestDTO();
            body.setBookingId(booking.getId());
            body.setTripId(booking.getTripId());
            body.setSeatNumbers(seatNos);

            SeatLockActionResponseDTO res = seatLockResourceMsrouteApi.confirmSeatLocks(body);
            if (res == null || res.getStatus() == null || !"OK".equalsIgnoreCase(res.getStatus())) {
                throw new IllegalStateException(
                        "Seat confirm failed: " + (res != null ? res.getMessage() : "null response"));
            }
        } catch (Exception e) {
            log.error("Failed to confirm seat locks for booking: {}", booking.getBookingCode(), e);
            throw new BadRequestAlertException("Failed to confirm seat locks", ENTITY_NAME, "seatlockerror");
        }
    }

    private String generateTicketCode(String bookingCode, int ticketNumber) {
        return bookingCode + "-T" + String.format("%02d", ticketNumber);
    }

    /**
     * Cancel seat locks for a booking using ms-route API.
     */
    private void cancelSeatLocks(Booking booking) {
        try {
            // Load seat numbers for the booking from Redis
            List<String> seatNos = loadSeatNosForBooking(booking);

            SeatLockActionRequestDTO body = new SeatLockActionRequestDTO();
            body.setBookingId(booking.getId());
            body.setTripId(booking.getTripId());
            body.setSeatNumbers(seatNos);

            SeatLockActionResponseDTO res = seatLockResourceMsrouteApi.cancelSeatLocks(body);
            if (res == null || res.getStatus() == null || !"OK".equalsIgnoreCase(res.getStatus())) {
                log.warn("Seat cancel returned non-OK for booking {}: {}",
                        booking.getBookingCode(), res != null ? res.getMessage() : "null response");
            } else {
                log.debug("Successfully canceled seat locks for booking: {}", booking.getBookingCode());
            }
        } catch (Exception e) {
            log.error("Failed to cancel seat locks for booking: {}", booking.getBookingCode(), e);
        }
    }

    /**
     * Load the seat numbers for this booking from Redis.
     */
    private List<String> loadSeatNosForBooking(Booking booking) {
        // Try Redis first: e.g., "booking:seats:{bookingId}" holding List<String>
        String key = "booking:seats:" + booking.getId();
        Object obj = redisTemplate.opsForValue().get(key);
        if (obj instanceof List<?> raw) {
            List<String> seats = raw.stream()
                    .filter(Objects::nonNull)
                    .map(Object::toString)
                    .toList();
            if (!seats.isEmpty()) {
                return seats;
            }
        }

        // If not in Redis, fallback to empty list and log warning
        log.warn("Seat list not found for booking {} (expected in Redis key {})",
                booking.getId(), key);
        return List.of();
    }
}
