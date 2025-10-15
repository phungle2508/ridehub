package com.ridehub.booking.domain.enumeration;

/**
 * The PaymentStatus enumeration.
 */
public enum PaymentStatus {
    INITIATED,
    PROCESSING,
    SUCCESS,
    FAILED,
    REFUNDED,
    PAYMENT_SUCCESS_BUT_BOOKING_EXPIRED,
    REQUIRES_MANUAL_REVIEW,
}
