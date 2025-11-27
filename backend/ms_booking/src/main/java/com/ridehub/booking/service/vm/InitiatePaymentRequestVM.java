package com.ridehub.booking.service.vm;

import com.ridehub.booking.domain.enumeration.PaymentMethod;
import jakarta.validation.constraints.*;

public class InitiatePaymentRequestVM {
    
    @NotNull
    private Long bookingId;
    
    @NotNull
    private PaymentMethod method;

    public InitiatePaymentRequestVM() {
    }

    public InitiatePaymentRequestVM(@NotNull Long bookingId, @NotNull PaymentMethod method) {
        this.bookingId = bookingId;
        this.method = method;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }
}
