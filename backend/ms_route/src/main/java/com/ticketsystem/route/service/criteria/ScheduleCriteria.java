package com.ticketsystem.route.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.ticketsystem.route.domain.Schedule} entity. This class is used
 * in {@link com.ticketsystem.route.web.rest.ScheduleResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /schedules?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ScheduleCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private UUIDFilter id;

    private InstantFilter departureTime;

    private InstantFilter arrivalTime;

    private IntegerFilter totalSeats;

    private IntegerFilter availableSeats;

    private BigDecimalFilter basePrice;

    private BooleanFilter isActive;

    private InstantFilter createdAt;

    private InstantFilter updatedAt;

    private UUIDFilter routeId;

    private Boolean distinct;

    public ScheduleCriteria() {}

    public ScheduleCriteria(ScheduleCriteria other) {
        this.id = other.optionalId().map(UUIDFilter::copy).orElse(null);
        this.departureTime = other.optionalDepartureTime().map(InstantFilter::copy).orElse(null);
        this.arrivalTime = other.optionalArrivalTime().map(InstantFilter::copy).orElse(null);
        this.totalSeats = other.optionalTotalSeats().map(IntegerFilter::copy).orElse(null);
        this.availableSeats = other.optionalAvailableSeats().map(IntegerFilter::copy).orElse(null);
        this.basePrice = other.optionalBasePrice().map(BigDecimalFilter::copy).orElse(null);
        this.isActive = other.optionalIsActive().map(BooleanFilter::copy).orElse(null);
        this.createdAt = other.optionalCreatedAt().map(InstantFilter::copy).orElse(null);
        this.updatedAt = other.optionalUpdatedAt().map(InstantFilter::copy).orElse(null);
        this.routeId = other.optionalRouteId().map(UUIDFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public ScheduleCriteria copy() {
        return new ScheduleCriteria(this);
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

    public InstantFilter getDepartureTime() {
        return departureTime;
    }

    public Optional<InstantFilter> optionalDepartureTime() {
        return Optional.ofNullable(departureTime);
    }

    public InstantFilter departureTime() {
        if (departureTime == null) {
            setDepartureTime(new InstantFilter());
        }
        return departureTime;
    }

    public void setDepartureTime(InstantFilter departureTime) {
        this.departureTime = departureTime;
    }

    public InstantFilter getArrivalTime() {
        return arrivalTime;
    }

    public Optional<InstantFilter> optionalArrivalTime() {
        return Optional.ofNullable(arrivalTime);
    }

    public InstantFilter arrivalTime() {
        if (arrivalTime == null) {
            setArrivalTime(new InstantFilter());
        }
        return arrivalTime;
    }

    public void setArrivalTime(InstantFilter arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public IntegerFilter getTotalSeats() {
        return totalSeats;
    }

    public Optional<IntegerFilter> optionalTotalSeats() {
        return Optional.ofNullable(totalSeats);
    }

    public IntegerFilter totalSeats() {
        if (totalSeats == null) {
            setTotalSeats(new IntegerFilter());
        }
        return totalSeats;
    }

    public void setTotalSeats(IntegerFilter totalSeats) {
        this.totalSeats = totalSeats;
    }

    public IntegerFilter getAvailableSeats() {
        return availableSeats;
    }

    public Optional<IntegerFilter> optionalAvailableSeats() {
        return Optional.ofNullable(availableSeats);
    }

    public IntegerFilter availableSeats() {
        if (availableSeats == null) {
            setAvailableSeats(new IntegerFilter());
        }
        return availableSeats;
    }

    public void setAvailableSeats(IntegerFilter availableSeats) {
        this.availableSeats = availableSeats;
    }

    public BigDecimalFilter getBasePrice() {
        return basePrice;
    }

    public Optional<BigDecimalFilter> optionalBasePrice() {
        return Optional.ofNullable(basePrice);
    }

    public BigDecimalFilter basePrice() {
        if (basePrice == null) {
            setBasePrice(new BigDecimalFilter());
        }
        return basePrice;
    }

    public void setBasePrice(BigDecimalFilter basePrice) {
        this.basePrice = basePrice;
    }

    public BooleanFilter getIsActive() {
        return isActive;
    }

    public Optional<BooleanFilter> optionalIsActive() {
        return Optional.ofNullable(isActive);
    }

    public BooleanFilter isActive() {
        if (isActive == null) {
            setIsActive(new BooleanFilter());
        }
        return isActive;
    }

    public void setIsActive(BooleanFilter isActive) {
        this.isActive = isActive;
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

    public UUIDFilter getRouteId() {
        return routeId;
    }

    public Optional<UUIDFilter> optionalRouteId() {
        return Optional.ofNullable(routeId);
    }

    public UUIDFilter routeId() {
        if (routeId == null) {
            setRouteId(new UUIDFilter());
        }
        return routeId;
    }

    public void setRouteId(UUIDFilter routeId) {
        this.routeId = routeId;
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
        final ScheduleCriteria that = (ScheduleCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(departureTime, that.departureTime) &&
            Objects.equals(arrivalTime, that.arrivalTime) &&
            Objects.equals(totalSeats, that.totalSeats) &&
            Objects.equals(availableSeats, that.availableSeats) &&
            Objects.equals(basePrice, that.basePrice) &&
            Objects.equals(isActive, that.isActive) &&
            Objects.equals(createdAt, that.createdAt) &&
            Objects.equals(updatedAt, that.updatedAt) &&
            Objects.equals(routeId, that.routeId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            departureTime,
            arrivalTime,
            totalSeats,
            availableSeats,
            basePrice,
            isActive,
            createdAt,
            updatedAt,
            routeId,
            distinct
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ScheduleCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalDepartureTime().map(f -> "departureTime=" + f + ", ").orElse("") +
            optionalArrivalTime().map(f -> "arrivalTime=" + f + ", ").orElse("") +
            optionalTotalSeats().map(f -> "totalSeats=" + f + ", ").orElse("") +
            optionalAvailableSeats().map(f -> "availableSeats=" + f + ", ").orElse("") +
            optionalBasePrice().map(f -> "basePrice=" + f + ", ").orElse("") +
            optionalIsActive().map(f -> "isActive=" + f + ", ").orElse("") +
            optionalCreatedAt().map(f -> "createdAt=" + f + ", ").orElse("") +
            optionalUpdatedAt().map(f -> "updatedAt=" + f + ", ").orElse("") +
            optionalRouteId().map(f -> "routeId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
