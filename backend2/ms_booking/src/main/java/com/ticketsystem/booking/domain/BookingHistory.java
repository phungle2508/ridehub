package com.ticketsystem.booking.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ticketsystem.booking.domain.enumeration.BookingStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/**
 * A BookingHistory.
 */
@Entity
@Table(name = "booking_history")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class BookingHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "previous_status", nullable = false)
    private BookingStatus previousStatus;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "new_status", nullable = false)
    private BookingStatus newStatus;

    @Column(name = "reason")
    private String reason;

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "changed_by", length = 36)
    private UUID changedBy;

    @NotNull
    @Column(name = "changed_at", nullable = false)
    private Instant changedAt;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "passengers", "histories" }, allowSetters = true)
    private Booking booking;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public BookingHistory id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BookingStatus getPreviousStatus() {
        return this.previousStatus;
    }

    public BookingHistory previousStatus(BookingStatus previousStatus) {
        this.setPreviousStatus(previousStatus);
        return this;
    }

    public void setPreviousStatus(BookingStatus previousStatus) {
        this.previousStatus = previousStatus;
    }

    public BookingStatus getNewStatus() {
        return this.newStatus;
    }

    public BookingHistory newStatus(BookingStatus newStatus) {
        this.setNewStatus(newStatus);
        return this;
    }

    public void setNewStatus(BookingStatus newStatus) {
        this.newStatus = newStatus;
    }

    public String getReason() {
        return this.reason;
    }

    public BookingHistory reason(String reason) {
        this.setReason(reason);
        return this;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public UUID getChangedBy() {
        return this.changedBy;
    }

    public BookingHistory changedBy(UUID changedBy) {
        this.setChangedBy(changedBy);
        return this;
    }

    public void setChangedBy(UUID changedBy) {
        this.changedBy = changedBy;
    }

    public Instant getChangedAt() {
        return this.changedAt;
    }

    public BookingHistory changedAt(Instant changedAt) {
        this.setChangedAt(changedAt);
        return this;
    }

    public void setChangedAt(Instant changedAt) {
        this.changedAt = changedAt;
    }

    public Booking getBooking() {
        return this.booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public BookingHistory booking(Booking booking) {
        this.setBooking(booking);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BookingHistory)) {
            return false;
        }
        return getId() != null && getId().equals(((BookingHistory) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BookingHistory{" +
            "id=" + getId() +
            ", previousStatus='" + getPreviousStatus() + "'" +
            ", newStatus='" + getNewStatus() + "'" +
            ", reason='" + getReason() + "'" +
            ", changedBy='" + getChangedBy() + "'" +
            ", changedAt='" + getChangedAt() + "'" +
            "}";
    }
}
