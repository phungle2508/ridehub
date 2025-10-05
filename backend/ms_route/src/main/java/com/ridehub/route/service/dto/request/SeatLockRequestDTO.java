package com.ridehub.route.service.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Request DTO for seat lock operations.
 */
public class SeatLockRequestDTO implements Serializable {

    @NotNull
    private Long bookingId;

    @NotNull
    private Long tripId;

    @NotEmpty
    private List<@NotBlank String> seatNumbers;

    @NotBlank
    private String idemKey;

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public List<String> getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(List<String> seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

    public String getIdemKey() {
        return idemKey;
    }

    public void setIdemKey(String idemKey) {
        this.idemKey = idemKey;
    }

    @Override
    public String toString() {
        return "SeatLockRequest{" +
            "bookingId=" + bookingId +
            ", tripId=" + tripId +
            ", seatNumbers=" + seatNumbers +
            ", idemKey='" + idemKey + '\'' +
            '}';
    }
}
