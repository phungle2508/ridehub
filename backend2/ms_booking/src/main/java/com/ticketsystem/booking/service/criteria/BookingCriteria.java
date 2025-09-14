package com.ticketsystem.booking.service.criteria;

import com.ticketsystem.booking.domain.enumeration.BookingStatus;
import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.ticketsystem.booking.domain.Booking} entity. This class is used
 * in {@link com.ticketsystem.booking.web.rest.BookingResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /bookings?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class BookingCriteria implements Serializable, Criteria {

    /**
     * Class for filtering BookingStatus
     */
    public static class BookingStatusFilter extends Filter<BookingStatus> {

        public BookingStatusFilter() {}

        public BookingStatusFilter(BookingStatusFilter filter) {
            super(filter);
        }

        @Override
        public BookingStatusFilter copy() {
            return new BookingStatusFilter(this);
        }
    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private UUIDFilter userId;

    private UUIDFilter tripId;

    private StringFilter bookingReference;

    private BookingStatusFilter status;

    private BigDecimalFilter totalAmount;

    private StringFilter contactPhone;

    private StringFilter contactEmail;

    private StringFilter specialRequests;

    private InstantFilter createdAt;

    private InstantFilter expiresAt;

    private LongFilter passengersId;

    private LongFilter historiesId;

    private Boolean distinct;

    public BookingCriteria() {}

    public BookingCriteria(BookingCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.userId = other.optionalUserId().map(UUIDFilter::copy).orElse(null);
        this.tripId = other.optionalTripId().map(UUIDFilter::copy).orElse(null);
        this.bookingReference = other.optionalBookingReference().map(StringFilter::copy).orElse(null);
        this.status = other.optionalStatus().map(BookingStatusFilter::copy).orElse(null);
        this.totalAmount = other.optionalTotalAmount().map(BigDecimalFilter::copy).orElse(null);
        this.contactPhone = other.optionalContactPhone().map(StringFilter::copy).orElse(null);
        this.contactEmail = other.optionalContactEmail().map(StringFilter::copy).orElse(null);
        this.specialRequests = other.optionalSpecialRequests().map(StringFilter::copy).orElse(null);
        this.createdAt = other.optionalCreatedAt().map(InstantFilter::copy).orElse(null);
        this.expiresAt = other.optionalExpiresAt().map(InstantFilter::copy).orElse(null);
        this.passengersId = other.optionalPassengersId().map(LongFilter::copy).orElse(null);
        this.historiesId = other.optionalHistoriesId().map(LongFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public BookingCriteria copy() {
        return new BookingCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public Optional<LongFilter> optionalId() {
        return Optional.ofNullable(id);
    }

    public LongFilter id() {
        if (id == null) {
            setId(new LongFilter());
        }
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public UUIDFilter getUserId() {
        return userId;
    }

    public Optional<UUIDFilter> optionalUserId() {
        return Optional.ofNullable(userId);
    }

    public UUIDFilter userId() {
        if (userId == null) {
            setUserId(new UUIDFilter());
        }
        return userId;
    }

    public void setUserId(UUIDFilter userId) {
        this.userId = userId;
    }

    public UUIDFilter getTripId() {
        return tripId;
    }

    public Optional<UUIDFilter> optionalTripId() {
        return Optional.ofNullable(tripId);
    }

    public UUIDFilter tripId() {
        if (tripId == null) {
            setTripId(new UUIDFilter());
        }
        return tripId;
    }

    public void setTripId(UUIDFilter tripId) {
        this.tripId = tripId;
    }

    public StringFilter getBookingReference() {
        return bookingReference;
    }

    public Optional<StringFilter> optionalBookingReference() {
        return Optional.ofNullable(bookingReference);
    }

    public StringFilter bookingReference() {
        if (bookingReference == null) {
            setBookingReference(new StringFilter());
        }
        return bookingReference;
    }

    public void setBookingReference(StringFilter bookingReference) {
        this.bookingReference = bookingReference;
    }

    public BookingStatusFilter getStatus() {
        return status;
    }

    public Optional<BookingStatusFilter> optionalStatus() {
        return Optional.ofNullable(status);
    }

    public BookingStatusFilter status() {
        if (status == null) {
            setStatus(new BookingStatusFilter());
        }
        return status;
    }

    public void setStatus(BookingStatusFilter status) {
        this.status = status;
    }

    public BigDecimalFilter getTotalAmount() {
        return totalAmount;
    }

    public Optional<BigDecimalFilter> optionalTotalAmount() {
        return Optional.ofNullable(totalAmount);
    }

    public BigDecimalFilter totalAmount() {
        if (totalAmount == null) {
            setTotalAmount(new BigDecimalFilter());
        }
        return totalAmount;
    }

    public void setTotalAmount(BigDecimalFilter totalAmount) {
        this.totalAmount = totalAmount;
    }

    public StringFilter getContactPhone() {
        return contactPhone;
    }

    public Optional<StringFilter> optionalContactPhone() {
        return Optional.ofNullable(contactPhone);
    }

    public StringFilter contactPhone() {
        if (contactPhone == null) {
            setContactPhone(new StringFilter());
        }
        return contactPhone;
    }

    public void setContactPhone(StringFilter contactPhone) {
        this.contactPhone = contactPhone;
    }

    public StringFilter getContactEmail() {
        return contactEmail;
    }

    public Optional<StringFilter> optionalContactEmail() {
        return Optional.ofNullable(contactEmail);
    }

    public StringFilter contactEmail() {
        if (contactEmail == null) {
            setContactEmail(new StringFilter());
        }
        return contactEmail;
    }

    public void setContactEmail(StringFilter contactEmail) {
        this.contactEmail = contactEmail;
    }

    public StringFilter getSpecialRequests() {
        return specialRequests;
    }

    public Optional<StringFilter> optionalSpecialRequests() {
        return Optional.ofNullable(specialRequests);
    }

    public StringFilter specialRequests() {
        if (specialRequests == null) {
            setSpecialRequests(new StringFilter());
        }
        return specialRequests;
    }

    public void setSpecialRequests(StringFilter specialRequests) {
        this.specialRequests = specialRequests;
    }

    public InstantFilter getCreatedAt() {
        return createdAt;
    }

    public Optional<InstantFilter> optionalCreatedAt() {
        return Optional.ofNullable(createdAt);
    }

    public InstantFilter createdAt() {
        if (createdAt == null) {
            setCreatedAt(new InstantFilter());
        }
        return createdAt;
    }

    public void setCreatedAt(InstantFilter createdAt) {
        this.createdAt = createdAt;
    }

    public InstantFilter getExpiresAt() {
        return expiresAt;
    }

    public Optional<InstantFilter> optionalExpiresAt() {
        return Optional.ofNullable(expiresAt);
    }

    public InstantFilter expiresAt() {
        if (expiresAt == null) {
            setExpiresAt(new InstantFilter());
        }
        return expiresAt;
    }

    public void setExpiresAt(InstantFilter expiresAt) {
        this.expiresAt = expiresAt;
    }

    public LongFilter getPassengersId() {
        return passengersId;
    }

    public Optional<LongFilter> optionalPassengersId() {
        return Optional.ofNullable(passengersId);
    }

    public LongFilter passengersId() {
        if (passengersId == null) {
            setPassengersId(new LongFilter());
        }
        return passengersId;
    }

    public void setPassengersId(LongFilter passengersId) {
        this.passengersId = passengersId;
    }

    public LongFilter getHistoriesId() {
        return historiesId;
    }

    public Optional<LongFilter> optionalHistoriesId() {
        return Optional.ofNullable(historiesId);
    }

    public LongFilter historiesId() {
        if (historiesId == null) {
            setHistoriesId(new LongFilter());
        }
        return historiesId;
    }

    public void setHistoriesId(LongFilter historiesId) {
        this.historiesId = historiesId;
    }

    public Boolean getDistinct() {
        return distinct;
    }

    public Optional<Boolean> optionalDistinct() {
        return Optional.ofNullable(distinct);
    }

    public Boolean distinct() {
        if (distinct == null) {
            setDistinct(true);
        }
        return distinct;
    }

    public void setDistinct(Boolean distinct) {
        this.distinct = distinct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final BookingCriteria that = (BookingCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(userId, that.userId) &&
            Objects.equals(tripId, that.tripId) &&
            Objects.equals(bookingReference, that.bookingReference) &&
            Objects.equals(status, that.status) &&
            Objects.equals(totalAmount, that.totalAmount) &&
            Objects.equals(contactPhone, that.contactPhone) &&
            Objects.equals(contactEmail, that.contactEmail) &&
            Objects.equals(specialRequests, that.specialRequests) &&
            Objects.equals(createdAt, that.createdAt) &&
            Objects.equals(expiresAt, that.expiresAt) &&
            Objects.equals(passengersId, that.passengersId) &&
            Objects.equals(historiesId, that.historiesId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            userId,
            tripId,
            bookingReference,
            status,
            totalAmount,
            contactPhone,
            contactEmail,
            specialRequests,
            createdAt,
            expiresAt,
            passengersId,
            historiesId,
            distinct
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BookingCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalUserId().map(f -> "userId=" + f + ", ").orElse("") +
            optionalTripId().map(f -> "tripId=" + f + ", ").orElse("") +
            optionalBookingReference().map(f -> "bookingReference=" + f + ", ").orElse("") +
            optionalStatus().map(f -> "status=" + f + ", ").orElse("") +
            optionalTotalAmount().map(f -> "totalAmount=" + f + ", ").orElse("") +
            optionalContactPhone().map(f -> "contactPhone=" + f + ", ").orElse("") +
            optionalContactEmail().map(f -> "contactEmail=" + f + ", ").orElse("") +
            optionalSpecialRequests().map(f -> "specialRequests=" + f + ", ").orElse("") +
            optionalCreatedAt().map(f -> "createdAt=" + f + ", ").orElse("") +
            optionalExpiresAt().map(f -> "expiresAt=" + f + ", ").orElse("") +
            optionalPassengersId().map(f -> "passengersId=" + f + ", ").orElse("") +
            optionalHistoriesId().map(f -> "historiesId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
