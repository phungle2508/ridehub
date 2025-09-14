package com.ticketsystem.booking.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ticketsystem.booking.domain.enumeration.BookingStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/**
 * A Booking.
 */
@Entity
@Table(name = "booking")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "user_id", length = 36, nullable = false)
    private UUID userId;

    @NotNull
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "trip_id", length = 36, nullable = false)
    private UUID tripId;

    @NotNull
    @Column(name = "booking_reference", nullable = false, unique = true)
    private String bookingReference;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private BookingStatus status;

    @NotNull
    @Column(name = "total_amount", precision = 21, scale = 2, nullable = false)
    private BigDecimal totalAmount;

    @Column(name = "contact_phone")
    private String contactPhone;

    @Column(name = "contact_email")
    private String contactEmail;

    @Column(name = "special_requests")
    private String specialRequests;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "expires_at")
    private Instant expiresAt;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "booking")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "booking" }, allowSetters = true)
    private Set<Passenger> passengers = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "booking")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "booking" }, allowSetters = true)
    private Set<BookingHistory> histories = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Booking id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUserId() {
        return this.userId;
    }

    public Booking userId(UUID userId) {
        this.setUserId(userId);
        return this;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getTripId() {
        return this.tripId;
    }

    public Booking tripId(UUID tripId) {
        this.setTripId(tripId);
        return this;
    }

    public void setTripId(UUID tripId) {
        this.tripId = tripId;
    }

    public String getBookingReference() {
        return this.bookingReference;
    }

    public Booking bookingReference(String bookingReference) {
        this.setBookingReference(bookingReference);
        return this;
    }

    public void setBookingReference(String bookingReference) {
        this.bookingReference = bookingReference;
    }

    public BookingStatus getStatus() {
        return this.status;
    }

    public Booking status(BookingStatus status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public BigDecimal getTotalAmount() {
        return this.totalAmount;
    }

    public Booking totalAmount(BigDecimal totalAmount) {
        this.setTotalAmount(totalAmount);
        return this;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getContactPhone() {
        return this.contactPhone;
    }

    public Booking contactPhone(String contactPhone) {
        this.setContactPhone(contactPhone);
        return this;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return this.contactEmail;
    }

    public Booking contactEmail(String contactEmail) {
        this.setContactEmail(contactEmail);
        return this;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getSpecialRequests() {
        return this.specialRequests;
    }

    public Booking specialRequests(String specialRequests) {
        this.setSpecialRequests(specialRequests);
        return this;
    }

    public void setSpecialRequests(String specialRequests) {
        this.specialRequests = specialRequests;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public Booking createdAt(Instant createdAt) {
        this.setCreatedAt(createdAt);
        return this;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getExpiresAt() {
        return this.expiresAt;
    }

    public Booking expiresAt(Instant expiresAt) {
        this.setExpiresAt(expiresAt);
        return this;
    }

    public void setExpiresAt(Instant expiresAt) {
        this.expiresAt = expiresAt;
    }

    public Set<Passenger> getPassengers() {
        return this.passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        if (this.passengers != null) {
            this.passengers.forEach(i -> i.setBooking(null));
        }
        if (passengers != null) {
            passengers.forEach(i -> i.setBooking(this));
        }
        this.passengers = passengers;
    }

    public Booking passengers(Set<Passenger> passengers) {
        this.setPassengers(passengers);
        return this;
    }

    public Booking addPassengers(Passenger passenger) {
        this.passengers.add(passenger);
        passenger.setBooking(this);
        return this;
    }

    public Booking removePassengers(Passenger passenger) {
        this.passengers.remove(passenger);
        passenger.setBooking(null);
        return this;
    }

    public Set<BookingHistory> getHistories() {
        return this.histories;
    }

    public void setHistories(Set<BookingHistory> bookingHistories) {
        if (this.histories != null) {
            this.histories.forEach(i -> i.setBooking(null));
        }
        if (bookingHistories != null) {
            bookingHistories.forEach(i -> i.setBooking(this));
        }
        this.histories = bookingHistories;
    }

    public Booking histories(Set<BookingHistory> bookingHistories) {
        this.setHistories(bookingHistories);
        return this;
    }

    public Booking addHistories(BookingHistory bookingHistory) {
        this.histories.add(bookingHistory);
        bookingHistory.setBooking(this);
        return this;
    }

    public Booking removeHistories(BookingHistory bookingHistory) {
        this.histories.remove(bookingHistory);
        bookingHistory.setBooking(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Booking)) {
            return false;
        }
        return getId() != null && getId().equals(((Booking) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Booking{" +
            "id=" + getId() +
            ", userId='" + getUserId() + "'" +
            ", tripId='" + getTripId() + "'" +
            ", bookingReference='" + getBookingReference() + "'" +
            ", status='" + getStatus() + "'" +
            ", totalAmount=" + getTotalAmount() +
            ", contactPhone='" + getContactPhone() + "'" +
            ", contactEmail='" + getContactEmail() + "'" +
            ", specialRequests='" + getSpecialRequests() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", expiresAt='" + getExpiresAt() + "'" +
            "}";
    }
}
