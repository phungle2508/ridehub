// src/main/java/com/ridehub/booking/service/vm/CreateBookingDraftRequestVM.java
package com.ridehub.booking.service.vm;

import jakarta.validation.constraints.*;
import java.util.List;

public class CreateBookingDraftRequestVM {
    @NotNull
    private Long tripId;
    @NotEmpty
    private List<@NotBlank String> seats; // not persisted yet, used only for pricing
    private String promoCode; // optional
    @NotNull
    private Long customerId; // UUID string (matches JDL)
    // getters/setters

    public CreateBookingDraftRequestVM(@NotNull Long tripId, @NotEmpty List<@NotBlank String> seats, String promoCode,
            @NotNull Long customerId) {
        this.tripId = tripId;
        this.seats = seats;
        this.promoCode = promoCode;
        this.customerId = customerId;
    }

    public CreateBookingDraftRequestVM() {
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public List<String> getSeats() {
        return seats;
    }

    public void setSeats(List<String> seats) {
        this.seats = seats;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

}
