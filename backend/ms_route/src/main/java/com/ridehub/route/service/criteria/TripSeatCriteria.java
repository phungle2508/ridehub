package com.ridehub.route.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.ridehub.route.domain.TripSeat} entity. This class is used
 * in {@link com.ridehub.route.web.rest.TripSeatResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /trip-seats?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class TripSeatCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter seatNo;

    private IntegerFilter floorNo;

    private BooleanFilter booked;

    private BigDecimalFilter priceFactor;

    private InstantFilter createdAt;

    private InstantFilter updatedAt;

    private BooleanFilter isDeleted;

    private InstantFilter deletedAt;

    private UUIDFilter deletedBy;

    private LongFilter tripId;

    private Boolean distinct;

    public TripSeatCriteria() {}

    public TripSeatCriteria(TripSeatCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.seatNo = other.optionalSeatNo().map(StringFilter::copy).orElse(null);
        this.floorNo = other.optionalFloorNo().map(IntegerFilter::copy).orElse(null);
        this.booked = other.optionalBooked().map(BooleanFilter::copy).orElse(null);
        this.priceFactor = other.optionalPriceFactor().map(BigDecimalFilter::copy).orElse(null);
        this.createdAt = other.optionalCreatedAt().map(InstantFilter::copy).orElse(null);
        this.updatedAt = other.optionalUpdatedAt().map(InstantFilter::copy).orElse(null);
        this.isDeleted = other.optionalIsDeleted().map(BooleanFilter::copy).orElse(null);
        this.deletedAt = other.optionalDeletedAt().map(InstantFilter::copy).orElse(null);
        this.deletedBy = other.optionalDeletedBy().map(UUIDFilter::copy).orElse(null);
        this.tripId = other.optionalTripId().map(LongFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public TripSeatCriteria copy() {
        return new TripSeatCriteria(this);
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

    public StringFilter getSeatNo() {
        return seatNo;
    }

    public Optional<StringFilter> optionalSeatNo() {
        return Optional.ofNullable(seatNo);
    }

    public StringFilter seatNo() {
        if (seatNo == null) {
            setSeatNo(new StringFilter());
        }
        return seatNo;
    }

    public void setSeatNo(StringFilter seatNo) {
        this.seatNo = seatNo;
    }

    public IntegerFilter getFloorNo() {
        return floorNo;
    }

    public Optional<IntegerFilter> optionalFloorNo() {
        return Optional.ofNullable(floorNo);
    }

    public IntegerFilter floorNo() {
        if (floorNo == null) {
            setFloorNo(new IntegerFilter());
        }
        return floorNo;
    }

    public void setFloorNo(IntegerFilter floorNo) {
        this.floorNo = floorNo;
    }

    public BooleanFilter getBooked() {
        return booked;
    }

    public Optional<BooleanFilter> optionalBooked() {
        return Optional.ofNullable(booked);
    }

    public BooleanFilter booked() {
        if (booked == null) {
            setBooked(new BooleanFilter());
        }
        return booked;
    }

    public void setBooked(BooleanFilter booked) {
        this.booked = booked;
    }

    public BigDecimalFilter getPriceFactor() {
        return priceFactor;
    }

    public Optional<BigDecimalFilter> optionalPriceFactor() {
        return Optional.ofNullable(priceFactor);
    }

    public BigDecimalFilter priceFactor() {
        if (priceFactor == null) {
            setPriceFactor(new BigDecimalFilter());
        }
        return priceFactor;
    }

    public void setPriceFactor(BigDecimalFilter priceFactor) {
        this.priceFactor = priceFactor;
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
        final TripSeatCriteria that = (TripSeatCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(seatNo, that.seatNo) &&
            Objects.equals(floorNo, that.floorNo) &&
            Objects.equals(booked, that.booked) &&
            Objects.equals(priceFactor, that.priceFactor) &&
            Objects.equals(createdAt, that.createdAt) &&
            Objects.equals(updatedAt, that.updatedAt) &&
            Objects.equals(isDeleted, that.isDeleted) &&
            Objects.equals(deletedAt, that.deletedAt) &&
            Objects.equals(deletedBy, that.deletedBy) &&
            Objects.equals(tripId, that.tripId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            seatNo,
            floorNo,
            booked,
            priceFactor,
            createdAt,
            updatedAt,
            isDeleted,
            deletedAt,
            deletedBy,
            tripId,
            distinct
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TripSeatCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalSeatNo().map(f -> "seatNo=" + f + ", ").orElse("") +
            optionalFloorNo().map(f -> "floorNo=" + f + ", ").orElse("") +
            optionalBooked().map(f -> "booked=" + f + ", ").orElse("") +
            optionalPriceFactor().map(f -> "priceFactor=" + f + ", ").orElse("") +
            optionalCreatedAt().map(f -> "createdAt=" + f + ", ").orElse("") +
            optionalUpdatedAt().map(f -> "updatedAt=" + f + ", ").orElse("") +
            optionalIsDeleted().map(f -> "isDeleted=" + f + ", ").orElse("") +
            optionalDeletedAt().map(f -> "deletedAt=" + f + ", ").orElse("") +
            optionalDeletedBy().map(f -> "deletedBy=" + f + ", ").orElse("") +
            optionalTripId().map(f -> "tripId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
