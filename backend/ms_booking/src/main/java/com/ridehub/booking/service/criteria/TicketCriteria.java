package com.ridehub.booking.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.ridehub.booking.domain.Ticket} entity. This class is used
 * in {@link com.ridehub.booking.web.rest.TicketResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /tickets?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class TicketCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter ticketCode;

    private BigDecimalFilter price;

    private StringFilter qrCode;

    private InstantFilter timeFrom;

    private InstantFilter timeTo;

    private BooleanFilter checkedIn;

    private LongFilter tripId;

    private LongFilter routeId;

    private LongFilter seatId;

    private InstantFilter createdAt;

    private InstantFilter updatedAt;

    private BooleanFilter isDeleted;

    private InstantFilter deletedAt;

    private UUIDFilter deletedBy;

    private LongFilter qrCodeImgId;

    private LongFilter bookingId;

    private Boolean distinct;

    public TicketCriteria() {}

    public TicketCriteria(TicketCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.ticketCode = other.optionalTicketCode().map(StringFilter::copy).orElse(null);
        this.price = other.optionalPrice().map(BigDecimalFilter::copy).orElse(null);
        this.qrCode = other.optionalQrCode().map(StringFilter::copy).orElse(null);
        this.timeFrom = other.optionalTimeFrom().map(InstantFilter::copy).orElse(null);
        this.timeTo = other.optionalTimeTo().map(InstantFilter::copy).orElse(null);
        this.checkedIn = other.optionalCheckedIn().map(BooleanFilter::copy).orElse(null);
        this.tripId = other.optionalTripId().map(LongFilter::copy).orElse(null);
        this.routeId = other.optionalRouteId().map(LongFilter::copy).orElse(null);
        this.seatId = other.optionalSeatId().map(LongFilter::copy).orElse(null);
        this.createdAt = other.optionalCreatedAt().map(InstantFilter::copy).orElse(null);
        this.updatedAt = other.optionalUpdatedAt().map(InstantFilter::copy).orElse(null);
        this.isDeleted = other.optionalIsDeleted().map(BooleanFilter::copy).orElse(null);
        this.deletedAt = other.optionalDeletedAt().map(InstantFilter::copy).orElse(null);
        this.deletedBy = other.optionalDeletedBy().map(UUIDFilter::copy).orElse(null);
        this.qrCodeImgId = other.optionalQrCodeImgId().map(LongFilter::copy).orElse(null);
        this.bookingId = other.optionalBookingId().map(LongFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public TicketCriteria copy() {
        return new TicketCriteria(this);
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

    public StringFilter getTicketCode() {
        return ticketCode;
    }

    public Optional<StringFilter> optionalTicketCode() {
        return Optional.ofNullable(ticketCode);
    }

    public StringFilter ticketCode() {
        if (ticketCode == null) {
            setTicketCode(new StringFilter());
        }
        return ticketCode;
    }

    public void setTicketCode(StringFilter ticketCode) {
        this.ticketCode = ticketCode;
    }

    public BigDecimalFilter getPrice() {
        return price;
    }

    public Optional<BigDecimalFilter> optionalPrice() {
        return Optional.ofNullable(price);
    }

    public BigDecimalFilter price() {
        if (price == null) {
            setPrice(new BigDecimalFilter());
        }
        return price;
    }

    public void setPrice(BigDecimalFilter price) {
        this.price = price;
    }

    public StringFilter getQrCode() {
        return qrCode;
    }

    public Optional<StringFilter> optionalQrCode() {
        return Optional.ofNullable(qrCode);
    }

    public StringFilter qrCode() {
        if (qrCode == null) {
            setQrCode(new StringFilter());
        }
        return qrCode;
    }

    public void setQrCode(StringFilter qrCode) {
        this.qrCode = qrCode;
    }

    public InstantFilter getTimeFrom() {
        return timeFrom;
    }

    public Optional<InstantFilter> optionalTimeFrom() {
        return Optional.ofNullable(timeFrom);
    }

    public InstantFilter timeFrom() {
        if (timeFrom == null) {
            setTimeFrom(new InstantFilter());
        }
        return timeFrom;
    }

    public void setTimeFrom(InstantFilter timeFrom) {
        this.timeFrom = timeFrom;
    }

    public InstantFilter getTimeTo() {
        return timeTo;
    }

    public Optional<InstantFilter> optionalTimeTo() {
        return Optional.ofNullable(timeTo);
    }

    public InstantFilter timeTo() {
        if (timeTo == null) {
            setTimeTo(new InstantFilter());
        }
        return timeTo;
    }

    public void setTimeTo(InstantFilter timeTo) {
        this.timeTo = timeTo;
    }

    public BooleanFilter getCheckedIn() {
        return checkedIn;
    }

    public Optional<BooleanFilter> optionalCheckedIn() {
        return Optional.ofNullable(checkedIn);
    }

    public BooleanFilter checkedIn() {
        if (checkedIn == null) {
            setCheckedIn(new BooleanFilter());
        }
        return checkedIn;
    }

    public void setCheckedIn(BooleanFilter checkedIn) {
        this.checkedIn = checkedIn;
    }

    public LongFilter getTripId() {
        return tripId;
    }

    public Optional<LongFilter> optionalTripId() {
        return Optional.ofNullable(tripId);
    }

    public LongFilter tripId() {
        if (tripId == null) {
            setTripId(new LongFilter());
        }
        return tripId;
    }

    public void setTripId(LongFilter tripId) {
        this.tripId = tripId;
    }

    public LongFilter getRouteId() {
        return routeId;
    }

    public Optional<LongFilter> optionalRouteId() {
        return Optional.ofNullable(routeId);
    }

    public LongFilter routeId() {
        if (routeId == null) {
            setRouteId(new LongFilter());
        }
        return routeId;
    }

    public void setRouteId(LongFilter routeId) {
        this.routeId = routeId;
    }

    public LongFilter getSeatId() {
        return seatId;
    }

    public Optional<LongFilter> optionalSeatId() {
        return Optional.ofNullable(seatId);
    }

    public LongFilter seatId() {
        if (seatId == null) {
            setSeatId(new LongFilter());
        }
        return seatId;
    }

    public void setSeatId(LongFilter seatId) {
        this.seatId = seatId;
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

    public InstantFilter getUpdatedAt() {
        return updatedAt;
    }

    public Optional<InstantFilter> optionalUpdatedAt() {
        return Optional.ofNullable(updatedAt);
    }

    public InstantFilter updatedAt() {
        if (updatedAt == null) {
            setUpdatedAt(new InstantFilter());
        }
        return updatedAt;
    }

    public void setUpdatedAt(InstantFilter updatedAt) {
        this.updatedAt = updatedAt;
    }

    public BooleanFilter getIsDeleted() {
        return isDeleted;
    }

    public Optional<BooleanFilter> optionalIsDeleted() {
        return Optional.ofNullable(isDeleted);
    }

    public BooleanFilter isDeleted() {
        if (isDeleted == null) {
            setIsDeleted(new BooleanFilter());
        }
        return isDeleted;
    }

    public void setIsDeleted(BooleanFilter isDeleted) {
        this.isDeleted = isDeleted;
    }

    public InstantFilter getDeletedAt() {
        return deletedAt;
    }

    public Optional<InstantFilter> optionalDeletedAt() {
        return Optional.ofNullable(deletedAt);
    }

    public InstantFilter deletedAt() {
        if (deletedAt == null) {
            setDeletedAt(new InstantFilter());
        }
        return deletedAt;
    }

    public void setDeletedAt(InstantFilter deletedAt) {
        this.deletedAt = deletedAt;
    }

    public UUIDFilter getDeletedBy() {
        return deletedBy;
    }

    public Optional<UUIDFilter> optionalDeletedBy() {
        return Optional.ofNullable(deletedBy);
    }

    public UUIDFilter deletedBy() {
        if (deletedBy == null) {
            setDeletedBy(new UUIDFilter());
        }
        return deletedBy;
    }

    public void setDeletedBy(UUIDFilter deletedBy) {
        this.deletedBy = deletedBy;
    }

    public LongFilter getQrCodeImgId() {
        return qrCodeImgId;
    }

    public Optional<LongFilter> optionalQrCodeImgId() {
        return Optional.ofNullable(qrCodeImgId);
    }

    public LongFilter qrCodeImgId() {
        if (qrCodeImgId == null) {
            setQrCodeImgId(new LongFilter());
        }
        return qrCodeImgId;
    }

    public void setQrCodeImgId(LongFilter qrCodeImgId) {
        this.qrCodeImgId = qrCodeImgId;
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
        final TicketCriteria that = (TicketCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(ticketCode, that.ticketCode) &&
            Objects.equals(price, that.price) &&
            Objects.equals(qrCode, that.qrCode) &&
            Objects.equals(timeFrom, that.timeFrom) &&
            Objects.equals(timeTo, that.timeTo) &&
            Objects.equals(checkedIn, that.checkedIn) &&
            Objects.equals(tripId, that.tripId) &&
            Objects.equals(routeId, that.routeId) &&
            Objects.equals(seatId, that.seatId) &&
            Objects.equals(createdAt, that.createdAt) &&
            Objects.equals(updatedAt, that.updatedAt) &&
            Objects.equals(isDeleted, that.isDeleted) &&
            Objects.equals(deletedAt, that.deletedAt) &&
            Objects.equals(deletedBy, that.deletedBy) &&
            Objects.equals(qrCodeImgId, that.qrCodeImgId) &&
            Objects.equals(bookingId, that.bookingId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            ticketCode,
            price,
            qrCode,
            timeFrom,
            timeTo,
            checkedIn,
            tripId,
            routeId,
            seatId,
            createdAt,
            updatedAt,
            isDeleted,
            deletedAt,
            deletedBy,
            qrCodeImgId,
            bookingId,
            distinct
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TicketCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalTicketCode().map(f -> "ticketCode=" + f + ", ").orElse("") +
            optionalPrice().map(f -> "price=" + f + ", ").orElse("") +
            optionalQrCode().map(f -> "qrCode=" + f + ", ").orElse("") +
            optionalTimeFrom().map(f -> "timeFrom=" + f + ", ").orElse("") +
            optionalTimeTo().map(f -> "timeTo=" + f + ", ").orElse("") +
            optionalCheckedIn().map(f -> "checkedIn=" + f + ", ").orElse("") +
            optionalTripId().map(f -> "tripId=" + f + ", ").orElse("") +
            optionalRouteId().map(f -> "routeId=" + f + ", ").orElse("") +
            optionalSeatId().map(f -> "seatId=" + f + ", ").orElse("") +
            optionalCreatedAt().map(f -> "createdAt=" + f + ", ").orElse("") +
            optionalUpdatedAt().map(f -> "updatedAt=" + f + ", ").orElse("") +
            optionalIsDeleted().map(f -> "isDeleted=" + f + ", ").orElse("") +
            optionalDeletedAt().map(f -> "deletedAt=" + f + ", ").orElse("") +
            optionalDeletedBy().map(f -> "deletedBy=" + f + ", ").orElse("") +
            optionalQrCodeImgId().map(f -> "qrCodeImgId=" + f + ", ").orElse("") +
            optionalBookingId().map(f -> "bookingId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
