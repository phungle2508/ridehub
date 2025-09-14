package com.ticketsystem.route.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.ticketsystem.route.domain.Trip} entity. This class is used
 * in {@link com.ticketsystem.route.web.rest.TripResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /trips?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class TripCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private InstantFilter departureTime;

    private InstantFilter arrivalTime;

    private IntegerFilter availableSeats;

    private IntegerFilter totalSeats;

    private StringFilter status;

    private UUIDFilter driverId;

    private LongFilter seatsId;

    private LongFilter routeId;

    private Boolean distinct;

    public TripCriteria() {}

    public TripCriteria(TripCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.departureTime = other.optionalDepartureTime().map(InstantFilter::copy).orElse(null);
        this.arrivalTime = other.optionalArrivalTime().map(InstantFilter::copy).orElse(null);
        this.availableSeats = other.optionalAvailableSeats().map(IntegerFilter::copy).orElse(null);
        this.totalSeats = other.optionalTotalSeats().map(IntegerFilter::copy).orElse(null);
        this.status = other.optionalStatus().map(StringFilter::copy).orElse(null);
        this.driverId = other.optionalDriverId().map(UUIDFilter::copy).orElse(null);
        this.seatsId = other.optionalSeatsId().map(LongFilter::copy).orElse(null);
        this.routeId = other.optionalRouteId().map(LongFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public TripCriteria copy() {
        return new TripCriteria(this);
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

    public StringFilter getStatus() {
        return status;
    }

    public Optional<StringFilter> optionalStatus() {
        return Optional.ofNullable(status);
    }

    public StringFilter status() {
        if (status == null) {
            setStatus(new StringFilter());
        }
        return status;
    }

    public void setStatus(StringFilter status) {
        this.status = status;
    }

    public UUIDFilter getDriverId() {
        return driverId;
    }

    public Optional<UUIDFilter> optionalDriverId() {
        return Optional.ofNullable(driverId);
    }

    public UUIDFilter driverId() {
        if (driverId == null) {
            setDriverId(new UUIDFilter());
        }
        return driverId;
    }

    public void setDriverId(UUIDFilter driverId) {
        this.driverId = driverId;
    }

    public LongFilter getSeatsId() {
        return seatsId;
    }

    public Optional<LongFilter> optionalSeatsId() {
        return Optional.ofNullable(seatsId);
    }

    public LongFilter seatsId() {
        if (seatsId == null) {
            setSeatsId(new LongFilter());
        }
        return seatsId;
    }

    public void setSeatsId(LongFilter seatsId) {
        this.seatsId = seatsId;
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
        final TripCriteria that = (TripCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(departureTime, that.departureTime) &&
            Objects.equals(arrivalTime, that.arrivalTime) &&
            Objects.equals(availableSeats, that.availableSeats) &&
            Objects.equals(totalSeats, that.totalSeats) &&
            Objects.equals(status, that.status) &&
            Objects.equals(driverId, that.driverId) &&
            Objects.equals(seatsId, that.seatsId) &&
            Objects.equals(routeId, that.routeId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, departureTime, arrivalTime, availableSeats, totalSeats, status, driverId, seatsId, routeId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TripCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalDepartureTime().map(f -> "departureTime=" + f + ", ").orElse("") +
            optionalArrivalTime().map(f -> "arrivalTime=" + f + ", ").orElse("") +
            optionalAvailableSeats().map(f -> "availableSeats=" + f + ", ").orElse("") +
            optionalTotalSeats().map(f -> "totalSeats=" + f + ", ").orElse("") +
            optionalStatus().map(f -> "status=" + f + ", ").orElse("") +
            optionalDriverId().map(f -> "driverId=" + f + ", ").orElse("") +
            optionalSeatsId().map(f -> "seatsId=" + f + ", ").orElse("") +
            optionalRouteId().map(f -> "routeId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
