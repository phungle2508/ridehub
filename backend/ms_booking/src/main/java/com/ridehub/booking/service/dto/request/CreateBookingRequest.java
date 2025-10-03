// src/main/java/com/ridehub/booking/service/dto/CreateBookingRequest.java
package com.ridehub.booking.service.dto.request;

import java.util.List;

public class CreateBookingRequest {
    private Long tripId;
    private List<String> seats;
    private String promoCode;
    private String idemKey;

    public CreateBookingRequest(Long tripId, List<String> seats, String promoCode, String idemKey) {
        this.tripId = tripId;
        this.seats = seats;
        this.promoCode = promoCode;
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

    public String getIdemKey() {
        return idemKey;
    }

    public void setIdemKey(String idemKey) {
        this.idemKey = idemKey;
    }

}
