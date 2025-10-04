// src/main/java/com/ridehub/booking/service/vm/CreateBookingDraftRequestVM.java
package com.ridehub.booking.service.vm;

import jakarta.validation.constraints.*;
import java.util.List;
import java.util.UUID;

public class CreateBookingDraftRequestVM {
    @NotNull
    private Long tripId;
    @NotEmpty
    private List<@NotBlank String> seats; // not persisted yet, used only for pricing
    private String promoCode; // optional
    @NotNull
    private UUID customerId; // UUID string (matches JDL)
    @NotBlank
    private String idemKey; // prevent duplicate POSTs

    public CreateBookingDraftRequestVM() {
    }

    public CreateBookingDraftRequestVM(@NotNull Long tripId, @NotEmpty List<@NotBlank String> seats, String promoCode,
            @NotNull UUID customerId, @NotBlank String idemKey) {
        this.tripId = tripId;
        this.seats = seats;
        this.promoCode = promoCode;
        this.customerId = customerId;
        this.idemKey = idemKey;
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

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public String getIdemKey() {
        return idemKey;
    }

    public void setIdemKey(String idemKey) {
        this.idemKey = idemKey;
    }

}
