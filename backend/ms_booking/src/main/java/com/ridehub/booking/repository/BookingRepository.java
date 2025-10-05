package com.ridehub.booking.repository;

import com.ridehub.booking.domain.Booking;
import com.ridehub.booking.domain.enumeration.BookingStatus;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

/**
 * Spring Data JPA repository for the Booking entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>, JpaSpecificationExecutor<Booking> {

    /**
     * Find all bookings that are awaiting payment and have expired.
     */
    @Query("SELECT b FROM Booking b WHERE b.status = :status AND b.expiresAt IS NOT NULL AND b.expiresAt < :now")
    List<Booking> findExpiredAwaitingPaymentBookings(@Param("status") BookingStatus status, @Param("now") Instant now);

    /**
     * Find expired awaiting payment bookings with default status.
     */
    default List<Booking> findExpiredAwaitingPaymentBookings(Instant now) {
        return findExpiredAwaitingPaymentBookings(BookingStatus.AWAITING_PAYMENT, now);
    }
}
