package com.ridehub.booking.service.vm;

import com.ridehub.booking.domain.enumeration.PaymentMethod;
import jakarta.validation.constraints.*;

public class InitiatePaymentRequestVM {
    
    @NotNull
    private Long bookingId;
    
    @NotNull
    private PaymentMethod method;
    
    @NotBlank
    private String returnUrl;
    
    private String ipAddress;

    public InitiatePaymentRequestVM() {
    }

    public InitiatePaymentRequestVM(@NotNull Long bookingId, @NotNull PaymentMethod method, 
                                  @NotBlank String returnUrl, String ipAddress) {
        this.bookingId = bookingId;
        this.method = method;
        this.returnUrl = returnUrl;
        this.ipAddress = ipAddress;
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

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
