package com.ticketsystem.route.service.criteria;

import com.ticketsystem.route.domain.enumeration.TransportType;
import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.ticketsystem.route.domain.Route} entity. This class is used
 * in {@link com.ticketsystem.route.web.rest.RouteResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /routes?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class RouteCriteria implements Serializable, Criteria {

    /**
     * Class for filtering TransportType
     */
    public static class TransportTypeFilter extends Filter<TransportType> {

        public TransportTypeFilter() {}

        public TransportTypeFilter(TransportTypeFilter filter) {
            super(filter);
        }

        @Override
        public TransportTypeFilter copy() {
            return new TransportTypeFilter(this);
        }
    }

    private static final long serialVersionUID = 1L;

    private UUIDFilter id;

    private StringFilter routeName;

    private StringFilter origin;

    private StringFilter destination;

    private DoubleFilter distance;

    private IntegerFilter estimatedDuration;

    private TransportTypeFilter transportType;

    private BooleanFilter isActive;

    private InstantFilter createdAt;

    private InstantFilter updatedAt;

    private UUIDFilter routeNameId;

    private Boolean distinct;

    public RouteCriteria() {}

    public RouteCriteria(RouteCriteria other) {
        this.id = other.optionalId().map(UUIDFilter::copy).orElse(null);
        this.routeName = other.optionalRouteName().map(StringFilter::copy).orElse(null);
        this.origin = other.optionalOrigin().map(StringFilter::copy).orElse(null);
        this.destination = other.optionalDestination().map(StringFilter::copy).orElse(null);
        this.distance = other.optionalDistance().map(DoubleFilter::copy).orElse(null);
        this.estimatedDuration = other.optionalEstimatedDuration().map(IntegerFilter::copy).orElse(null);
        this.transportType = other.optionalTransportType().map(TransportTypeFilter::copy).orElse(null);
        this.isActive = other.optionalIsActive().map(BooleanFilter::copy).orElse(null);
        this.createdAt = other.optionalCreatedAt().map(InstantFilter::copy).orElse(null);
        this.updatedAt = other.optionalUpdatedAt().map(InstantFilter::copy).orElse(null);
        this.routeNameId = other.optionalRouteNameId().map(UUIDFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public RouteCriteria copy() {
        return new RouteCriteria(this);
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

    public StringFilter getRouteName() {
        return routeName;
    }

    public Optional<StringFilter> optionalRouteName() {
        return Optional.ofNullable(routeName);
    }

    public StringFilter routeName() {
        if (routeName == null) {
            setRouteName(new StringFilter());
        }
        return routeName;
    }

    public void setRouteName(StringFilter routeName) {
        this.routeName = routeName;
    }

    public StringFilter getOrigin() {
        return origin;
    }

    public Optional<StringFilter> optionalOrigin() {
        return Optional.ofNullable(origin);
    }

    public StringFilter origin() {
        if (origin == null) {
            setOrigin(new StringFilter());
        }
        return origin;
    }

    public void setOrigin(StringFilter origin) {
        this.origin = origin;
    }

    public StringFilter getDestination() {
        return destination;
    }

    public Optional<StringFilter> optionalDestination() {
        return Optional.ofNullable(destination);
    }

    public StringFilter destination() {
        if (destination == null) {
            setDestination(new StringFilter());
        }
        return destination;
    }

    public void setDestination(StringFilter destination) {
        this.destination = destination;
    }

    public DoubleFilter getDistance() {
        return distance;
    }

    public Optional<DoubleFilter> optionalDistance() {
        return Optional.ofNullable(distance);
    }

    public DoubleFilter distance() {
        if (distance == null) {
            setDistance(new DoubleFilter());
        }
        return distance;
    }

    public void setDistance(DoubleFilter distance) {
        this.distance = distance;
    }

    public IntegerFilter getEstimatedDuration() {
        return estimatedDuration;
    }

    public Optional<IntegerFilter> optionalEstimatedDuration() {
        return Optional.ofNullable(estimatedDuration);
    }

    public IntegerFilter estimatedDuration() {
        if (estimatedDuration == null) {
            setEstimatedDuration(new IntegerFilter());
        }
        return estimatedDuration;
    }

    public void setEstimatedDuration(IntegerFilter estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }

    public TransportTypeFilter getTransportType() {
        return transportType;
    }

    public Optional<TransportTypeFilter> optionalTransportType() {
        return Optional.ofNullable(transportType);
    }

    public TransportTypeFilter transportType() {
        if (transportType == null) {
            setTransportType(new TransportTypeFilter());
        }
        return transportType;
    }

    public void setTransportType(TransportTypeFilter transportType) {
        this.transportType = transportType;
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

    public UUIDFilter getRouteNameId() {
        return routeNameId;
    }

    public Optional<UUIDFilter> optionalRouteNameId() {
        return Optional.ofNullable(routeNameId);
    }

    public UUIDFilter routeNameId() {
        if (routeNameId == null) {
            setRouteNameId(new UUIDFilter());
        }
        return routeNameId;
    }

    public void setRouteNameId(UUIDFilter routeNameId) {
        this.routeNameId = routeNameId;
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
        final RouteCriteria that = (RouteCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(routeName, that.routeName) &&
            Objects.equals(origin, that.origin) &&
            Objects.equals(destination, that.destination) &&
            Objects.equals(distance, that.distance) &&
            Objects.equals(estimatedDuration, that.estimatedDuration) &&
            Objects.equals(transportType, that.transportType) &&
            Objects.equals(isActive, that.isActive) &&
            Objects.equals(createdAt, that.createdAt) &&
            Objects.equals(updatedAt, that.updatedAt) &&
            Objects.equals(routeNameId, that.routeNameId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            routeName,
            origin,
            destination,
            distance,
            estimatedDuration,
            transportType,
            isActive,
            createdAt,
            updatedAt,
            routeNameId,
            distinct
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RouteCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalRouteName().map(f -> "routeName=" + f + ", ").orElse("") +
            optionalOrigin().map(f -> "origin=" + f + ", ").orElse("") +
            optionalDestination().map(f -> "destination=" + f + ", ").orElse("") +
            optionalDistance().map(f -> "distance=" + f + ", ").orElse("") +
            optionalEstimatedDuration().map(f -> "estimatedDuration=" + f + ", ").orElse("") +
            optionalTransportType().map(f -> "transportType=" + f + ", ").orElse("") +
            optionalIsActive().map(f -> "isActive=" + f + ", ").orElse("") +
            optionalCreatedAt().map(f -> "createdAt=" + f + ", ").orElse("") +
            optionalUpdatedAt().map(f -> "updatedAt=" + f + ", ").orElse("") +
            optionalRouteNameId().map(f -> "routeNameId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
