package com.ridehub.booking.domain.enumeration;

/**
 * The BookingStatus enumeration.
 */
public enum BookingStatus {
    DRAFT,
    AWAITING_PAYMENT,
    PAID,
    CONFIRMED,
    CANCELED,
    REFUNDED,
    RECOVERY_FAILED_SEAT_LOCKS,
}
