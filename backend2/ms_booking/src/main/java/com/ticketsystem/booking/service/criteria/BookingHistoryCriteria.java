package com.ticketsystem.booking.service.criteria;

import com.ticketsystem.booking.domain.enumeration.BookingStatus;
import com.ticketsystem.booking.domain.enumeration.BookingStatus;
import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.ticketsystem.booking.domain.BookingHistory} entity. This class is used
 * in {@link com.ticketsystem.booking.web.rest.BookingHistoryResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /booking-histories?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class BookingHistoryCriteria implements Serializable, Criteria {

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

    private BookingStatusFilter previousStatus;

    private BookingStatusFilter newStatus;

    private StringFilter reason;

    private UUIDFilter changedBy;

    private InstantFilter changedAt;

    private LongFilter bookingId;

    private Boolean distinct;

    public BookingHistoryCriteria() {}

    public BookingHistoryCriteria(BookingHistoryCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.previousStatus = other.optionalPreviousStatus().map(BookingStatusFilter::copy).orElse(null);
        this.newStatus = other.optionalNewStatus().map(BookingStatusFilter::copy).orElse(null);
        this.reason = other.optionalReason().map(StringFilter::copy).orElse(null);
        this.changedBy = other.optionalChangedBy().map(UUIDFilter::copy).orElse(null);
        this.changedAt = other.optionalChangedAt().map(InstantFilter::copy).orElse(null);
        this.bookingId = other.optionalBookingId().map(LongFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public BookingHistoryCriteria copy() {
        return new BookingHistoryCriteria(this);
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

    public BookingStatusFilter getPreviousStatus() {
        return previousStatus;
    }

    public Optional<BookingStatusFilter> optionalPreviousStatus() {
        return Optional.ofNullable(previousStatus);
    }

    public BookingStatusFilter previousStatus() {
        if (previousStatus == null) {
            setPreviousStatus(new BookingStatusFilter());
        }
        return previousStatus;
    }

    public void setPreviousStatus(BookingStatusFilter previousStatus) {
        this.previousStatus = previousStatus;
    }

    public BookingStatusFilter getNewStatus() {
        return newStatus;
    }

    public Optional<BookingStatusFilter> optionalNewStatus() {
        return Optional.ofNullable(newStatus);
    }

    public BookingStatusFilter newStatus() {
        if (newStatus == null) {
            setNewStatus(new BookingStatusFilter());
        }
        return newStatus;
    }

    public void setNewStatus(BookingStatusFilter newStatus) {
        this.newStatus = newStatus;
    }

    public StringFilter getReason() {
        return reason;
    }

    public Optional<StringFilter> optionalReason() {
        return Optional.ofNullable(reason);
    }

    public StringFilter reason() {
        if (reason == null) {
            setReason(new StringFilter());
        }
        return reason;
    }

    public void setReason(StringFilter reason) {
        this.reason = reason;
    }

    public UUIDFilter getChangedBy() {
        return changedBy;
    }

    public Optional<UUIDFilter> optionalChangedBy() {
        return Optional.ofNullable(changedBy);
    }

    public UUIDFilter changedBy() {
        if (changedBy == null) {
            setChangedBy(new UUIDFilter());
        }
        return changedBy;
    }

    public void setChangedBy(UUIDFilter changedBy) {
        this.changedBy = changedBy;
    }

    public InstantFilter getChangedAt() {
        return changedAt;
    }

    public Optional<InstantFilter> optionalChangedAt() {
        return Optional.ofNullable(changedAt);
    }

    public InstantFilter changedAt() {
        if (changedAt == null) {
            setChangedAt(new InstantFilter());
        }
        return changedAt;
    }

    public void setChangedAt(InstantFilter changedAt) {
        this.changedAt = changedAt;
    }

    public LongFilter getBookingId() {
        return bookingId;
    }

    public Optional<LongFilter> optionalBookingId() {
        return Optional.ofNullable(bookingId);
    }

    public LongFilter bookingId() {
        if (bookingId == null) {
            setBookingId(new LongFilter());
        }
        return bookingId;
    }

    public void setBookingId(LongFilter bookingId) {
        this.bookingId = bookingId;
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
        final BookingHistoryCriteria that = (BookingHistoryCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(previousStatus, that.previousStatus) &&
            Objects.equals(newStatus, that.newStatus) &&
            Objects.equals(reason, that.reason) &&
            Objects.equals(changedBy, that.changedBy) &&
            Objects.equals(changedAt, that.changedAt) &&
            Objects.equals(bookingId, that.bookingId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, previousStatus, newStatus, reason, changedBy, changedAt, bookingId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BookingHistoryCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalPreviousStatus().map(f -> "previousStatus=" + f + ", ").orElse("") +
            optionalNewStatus().map(f -> "newStatus=" + f + ", ").orElse("") +
            optionalReason().map(f -> "reason=" + f + ", ").orElse("") +
            optionalChangedBy().map(f -> "changedBy=" + f + ", ").orElse("") +
            optionalChangedAt().map(f -> "changedAt=" + f + ", ").orElse("") +
            optionalBookingId().map(f -> "bookingId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
