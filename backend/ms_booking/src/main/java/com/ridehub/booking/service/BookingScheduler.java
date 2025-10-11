package com.ridehub.booking.service;

import com.ridehub.booking.domain.Booking;
import com.ridehub.booking.domain.enumeration.BookingStatus;
import com.ridehub.booking.repository.BookingRepository;
import com.ridehub.msroute.client.api.SeatLockResourceMsrouteApi;
import com.ridehub.msroute.client.model.SeatLockActionRequestDTO;
import com.ridehub.msroute.client.model.SeatLockActionResponseDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

/**
 * Service for handling booking timeouts and expiration.
 */
@Service
@Transactional
public class BookingScheduler {

    private final Logger log = LoggerFactory.getLogger(BookingScheduler.class);

    private final BookingRepository bookingRepository;
    private final SeatLockResourceMsrouteApi seatLockResourceMsrouteApi;
    private final StringRedisTemplate redisTemplate;

    public BookingScheduler(
            BookingRepository bookingRepository,
            SeatLockResourceMsrouteApi seatLockResourceMsrouteApi,
            StringRedisTemplate redisTemplate) {
        this.bookingRepository = bookingRepository;
        this.seatLockResourceMsrouteApi = seatLockResourceMsrouteApi;
        this.redisTemplate = redisTemplate;
    }

    /**
     * Scheduled task to handle expired bookings.
     * Runs every minute to check for expired bookings.
     */
    @Scheduled(fixedRate = 60000) // Run every minute
    public void handleExpiredBookings() {
        log.info("Starting expired bookings cleanup task at {}", Instant.now());

        try {
            // Find all AWAITING_PAYMENT bookings that have expired
            Instant now = Instant.now();
                List<Booking> expiredBookings = bookingRepository.findExpiredAwaitingPaymentBookings(now);
            if (expiredBookings.isEmpty()) {
                log.debug("No expired bookings found");
                return;
            }

            log.info("Found {} expired bookings to process", expiredBookings.size());

            int canceledCount = 0;

            for (Booking booking : expiredBookings) {
                try {
                    // Update booking status to CANCELED
                    booking.setStatus(BookingStatus.CANCELED);
                    booking.setUpdatedAt(now);
                    bookingRepository.save(booking);

                    // Cancel seat locks via ms-route service
                    if (booking.getLockGroupId() != null && booking.getTripId() != null) {
                        cancelSeatLocks(booking);
                    }

                    // Remove booking session from Redis
                    String sessionKey = "booking:sess:" + booking.getId();
                    redisTemplate.delete(sessionKey);

                    canceledCount++;
                    log.debug("Successfully canceled expired booking: {}", booking.getBookingCode());

                } catch (Exception e) {
                    log.error("Failed to cancel expired booking: {}", booking.getBookingCode(), e);
                }
            }

            log.info("Expired bookings cleanup completed. Canceled {} out of {} bookings",
                    canceledCount, expiredBookings.size());

        } catch (Exception e) {
            log.error("Error during expired bookings cleanup", e);
        }
    }

    /**
     * Manual method to trigger expired bookings cleanup.
     * Useful for testing or manual intervention.
     */
    public void triggerExpiredBookingsCleanup() {
        log.info("Manually triggering expired bookings cleanup");
        handleExpiredBookings();
    }

    /**
     * Get count of expired bookings without processing them.
     * Useful for monitoring.
     */
    @Transactional(readOnly = true)
    public long getExpiredBookingsCount() {
        Instant now = Instant.now();
        List<Booking> expiredBookings = bookingRepository.findExpiredAwaitingPaymentBookings(now);
        return expiredBookings.size();
    }

    /**
     * Check if a specific booking has expired.
     */
    @Transactional(readOnly = true)
    public boolean isBookingExpired(Long bookingId) {
        return bookingRepository.findById(bookingId)
                .map(booking -> {
                    if (booking.getStatus() != BookingStatus.AWAITING_PAYMENT) {
                        return false;
                    }
                    if (booking.getExpiresAt() == null) {
                        return false;
                    }
                    return booking.getExpiresAt().isBefore(Instant.now());
                })
                .orElse(false);
    }

    /**
     * Set expiration time for a booking based on timeout minutes.
     */
    public void setBookingExpiration(Booking booking, int timeoutMinutes) {
        Instant expiresAt = Instant.now().plusSeconds(timeoutMinutes * 60L);
        booking.setExpiresAt(expiresAt);
        booking.setTimeoutMinutes(timeoutMinutes);
        log.debug("Set booking {} to expire at {}", booking.getBookingCode(), expiresAt);
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
    @SuppressWarnings("unchecked")
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
