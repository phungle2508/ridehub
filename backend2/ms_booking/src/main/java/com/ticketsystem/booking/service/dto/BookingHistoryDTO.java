package com.ticketsystem.booking.service.dto;

import com.ticketsystem.booking.domain.enumeration.BookingStatus;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

/**
 * A DTO for the {@link com.ticketsystem.booking.domain.BookingHistory} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class BookingHistoryDTO implements Serializable {

    private Long id;

    @NotNull
    private BookingStatus previousStatus;

    @NotNull
    private BookingStatus newStatus;

    private String reason;

    private UUID changedBy;

    @NotNull
    private Instant changedAt;

    @NotNull
    private BookingDTO booking;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BookingStatus getPreviousStatus() {
        return previousStatus;
    }

    public void setPreviousStatus(BookingStatus previousStatus) {
        this.previousStatus = previousStatus;
    }

    public BookingStatus getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(BookingStatus newStatus) {
        this.newStatus = newStatus;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public UUID getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(UUID changedBy) {
        this.changedBy = changedBy;
    }

    public Instant getChangedAt() {
        return changedAt;
    }

    public void setChangedAt(Instant changedAt) {
        this.changedAt = changedAt;
    }

    public BookingDTO getBooking() {
        return booking;
    }

    public void setBooking(BookingDTO booking) {
        this.booking = booking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BookingHistoryDTO)) {
            return false;
        }

        BookingHistoryDTO bookingHistoryDTO = (BookingHistoryDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, bookingHistoryDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BookingHistoryDTO{" +
            "id=" + getId() +
            ", previousStatus='" + getPreviousStatus() + "'" +
            ", newStatus='" + getNewStatus() + "'" +
            ", reason='" + getReason() + "'" +
            ", changedBy='" + getChangedBy() + "'" +
            ", changedAt='" + getChangedAt() + "'" +
            ", booking=" + getBooking() +
            "}";
    }
}
