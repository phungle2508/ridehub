package com.ticketsystem.booking.service.criteria;

import com.ticketsystem.booking.domain.enumeration.SeatType;
import com.ticketsystem.booking.domain.enumeration.TicketStatus;
import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.ticketsystem.booking.domain.Ticket} entity. This class is used
 * in {@link com.ticketsystem.booking.web.rest.TicketResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /tickets?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class TicketCriteria implements Serializable, Criteria {

    /**
     * Class for filtering SeatType
     */
    public static class SeatTypeFilter extends Filter<SeatType> {

        public SeatTypeFilter() {}

        public SeatTypeFilter(SeatTypeFilter filter) {
            super(filter);
        }

        @Override
        public SeatTypeFilter copy() {
            return new SeatTypeFilter(this);
        }
    }

    /**
     * Class for filtering TicketStatus
     */
    public static class TicketStatusFilter extends Filter<TicketStatus> {

        public TicketStatusFilter() {}

        public TicketStatusFilter(TicketStatusFilter filter) {
            super(filter);
        }

        @Override
        public TicketStatusFilter copy() {
            return new TicketStatusFilter(this);
        }
    }

    private static final long serialVersionUID = 1L;

    private UUIDFilter id;

    private UUIDFilter scheduleId;

    private StringFilter seatNumber;

    private SeatTypeFilter seatType;

    private BigDecimalFilter price;

    private TicketStatusFilter status;

    private InstantFilter reservedUntil;

    private InstantFilter createdAt;

    private InstantFilter updatedAt;

    private Boolean distinct;

    public TicketCriteria() {}

    public TicketCriteria(TicketCriteria other) {
        this.id = other.optionalId().map(UUIDFilter::copy).orElse(null);
        this.scheduleId = other.optionalScheduleId().map(UUIDFilter::copy).orElse(null);
        this.seatNumber = other.optionalSeatNumber().map(StringFilter::copy).orElse(null);
        this.seatType = other.optionalSeatType().map(SeatTypeFilter::copy).orElse(null);
        this.price = other.optionalPrice().map(BigDecimalFilter::copy).orElse(null);
        this.status = other.optionalStatus().map(TicketStatusFilter::copy).orElse(null);
        this.reservedUntil = other.optionalReservedUntil().map(InstantFilter::copy).orElse(null);
        this.createdAt = other.optionalCreatedAt().map(InstantFilter::copy).orElse(null);
        this.updatedAt = other.optionalUpdatedAt().map(InstantFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public TicketCriteria copy() {
        return new TicketCriteria(this);
    }

    public UUIDFilter getId() {
        return id;
    }

    public Optional<UUIDFilter> optionalId() {
        return Optional.ofNullable(id);
    }

    public UUIDFilter id() {
        if (id == null) {
            setId(new UUIDFilter());
        }
        return id;
    }

    public void setId(UUIDFilter id) {
        this.id = id;
    }

    public UUIDFilter getScheduleId() {
        return scheduleId;
    }

    public Optional<UUIDFilter> optionalScheduleId() {
        return Optional.ofNullable(scheduleId);
    }

    public UUIDFilter scheduleId() {
        if (scheduleId == null) {
            setScheduleId(new UUIDFilter());
        }
        return scheduleId;
    }

    public void setScheduleId(UUIDFilter scheduleId) {
        this.scheduleId = scheduleId;
    }

    public StringFilter getSeatNumber() {
        return seatNumber;
    }

    public Optional<StringFilter> optionalSeatNumber() {
        return Optional.ofNullable(seatNumber);
    }

    public StringFilter seatNumber() {
        if (seatNumber == null) {
            setSeatNumber(new StringFilter());
        }
        return seatNumber;
    }

    public void setSeatNumber(StringFilter seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatTypeFilter getSeatType() {
        return seatType;
    }

    public Optional<SeatTypeFilter> optionalSeatType() {
        return Optional.ofNullable(seatType);
    }

    public SeatTypeFilter seatType() {
        if (seatType == null) {
            setSeatType(new SeatTypeFilter());
        }
        return seatType;
    }

    public void setSeatType(SeatTypeFilter seatType) {
        this.seatType = seatType;
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

    public TicketStatusFilter getStatus() {
        return status;
    }

    public Optional<TicketStatusFilter> optionalStatus() {
        return Optional.ofNullable(status);
    }

    public TicketStatusFilter status() {
        if (status == null) {
            setStatus(new TicketStatusFilter());
        }
        return status;
    }

    public void setStatus(TicketStatusFilter status) {
        this.status = status;
    }

    public InstantFilter getReservedUntil() {
        return reservedUntil;
    }

    public Optional<InstantFilter> optionalReservedUntil() {
        return Optional.ofNullable(reservedUntil);
    }

    public InstantFilter reservedUntil() {
        if (reservedUntil == null) {
            setReservedUntil(new InstantFilter());
        }
        return reservedUntil;
    }

    public void setReservedUntil(InstantFilter reservedUntil) {
        this.reservedUntil = reservedUntil;
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
            Objects.equals(scheduleId, that.scheduleId) &&
            Objects.equals(seatNumber, that.seatNumber) &&
            Objects.equals(seatType, that.seatType) &&
            Objects.equals(price, that.price) &&
            Objects.equals(status, that.status) &&
            Objects.equals(reservedUntil, that.reservedUntil) &&
            Objects.equals(createdAt, that.createdAt) &&
            Objects.equals(updatedAt, that.updatedAt) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, scheduleId, seatNumber, seatType, price, status, reservedUntil, createdAt, updatedAt, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TicketCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalScheduleId().map(f -> "scheduleId=" + f + ", ").orElse("") +
            optionalSeatNumber().map(f -> "seatNumber=" + f + ", ").orElse("") +
            optionalSeatType().map(f -> "seatType=" + f + ", ").orElse("") +
            optionalPrice().map(f -> "price=" + f + ", ").orElse("") +
            optionalStatus().map(f -> "status=" + f + ", ").orElse("") +
            optionalReservedUntil().map(f -> "reservedUntil=" + f + ", ").orElse("") +
            optionalCreatedAt().map(f -> "createdAt=" + f + ", ").orElse("") +
            optionalUpdatedAt().map(f -> "updatedAt=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
