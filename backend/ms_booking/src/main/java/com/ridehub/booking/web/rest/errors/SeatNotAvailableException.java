package com.ridehub.booking.web.rest.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Thrown when requested seats cannot be locked (already held/committed).
 * Maps to HTTP 409 CONFLICT.
 */
public class SeatNotAvailableException extends ResponseStatusException {
    private static final long serialVersionUID = 1L;

    public SeatNotAvailableException(String message) {
        super(HttpStatus.CONFLICT, message);
    }

    public SeatNotAvailableException(String message, Throwable cause) {
        super(HttpStatus.CONFLICT, message, cause);
    }

    /** Convenience factory to include a seat list in the message. */
    public static SeatNotAvailableException ofSeats(Collection<String> seats) {
        String seatList = (seats == null || seats.isEmpty())
                ? "Unknown"
                : seats.stream().collect(Collectors.joining(", "));
        return new SeatNotAvailableException("Seats not available: " + seatList);
    }
}
