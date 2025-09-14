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

    private LongFilter id;

    private TransportTypeFilter transportType;

    private BigDecimalFilter distance;

    private IntegerFilter estimatedDuration;

    private BigDecimalFilter basePrice;

    private BooleanFilter isActive;

    private LongFilter tripsId;

    private LongFilter originId;

    private LongFilter destinationId;

    private LongFilter operatorId;

    private Boolean distinct;

    public RouteCriteria() {}

    public RouteCriteria(RouteCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.transportType = other.optionalTransportType().map(TransportTypeFilter::copy).orElse(null);
        this.distance = other.optionalDistance().map(BigDecimalFilter::copy).orElse(null);
        this.estimatedDuration = other.optionalEstimatedDuration().map(IntegerFilter::copy).orElse(null);
        this.basePrice = other.optionalBasePrice().map(BigDecimalFilter::copy).orElse(null);
        this.isActive = other.optionalIsActive().map(BooleanFilter::copy).orElse(null);
        this.tripsId = other.optionalTripsId().map(LongFilter::copy).orElse(null);
        this.originId = other.optionalOriginId().map(LongFilter::copy).orElse(null);
        this.destinationId = other.optionalDestinationId().map(LongFilter::copy).orElse(null);
        this.operatorId = other.optionalOperatorId().map(LongFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public RouteCriteria copy() {
        return new RouteCriteria(this);
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

    public BigDecimalFilter getDistance() {
        return distance;
    }

    public Optional<BigDecimalFilter> optionalDistance() {
        return Optional.ofNullable(distance);
    }

    public BigDecimalFilter distance() {
        if (distance == null) {
            setDistance(new BigDecimalFilter());
        }
        return distance;
    }

    public void setDistance(BigDecimalFilter distance) {
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

    public LongFilter getTripsId() {
        return tripsId;
    }

    public Optional<LongFilter> optionalTripsId() {
        return Optional.ofNullable(tripsId);
    }

    public LongFilter tripsId() {
        if (tripsId == null) {
            setTripsId(new LongFilter());
        }
        return tripsId;
    }

    public void setTripsId(LongFilter tripsId) {
        this.tripsId = tripsId;
    }

    public LongFilter getOriginId() {
        return originId;
    }

    public Optional<LongFilter> optionalOriginId() {
        return Optional.ofNullable(originId);
    }

    public LongFilter originId() {
        if (originId == null) {
            setOriginId(new LongFilter());
        }
        return originId;
    }

    public void setOriginId(LongFilter originId) {
        this.originId = originId;
    }

    public LongFilter getDestinationId() {
        return destinationId;
    }

    public Optional<LongFilter> optionalDestinationId() {
        return Optional.ofNullable(destinationId);
    }

    public LongFilter destinationId() {
        if (destinationId == null) {
            setDestinationId(new LongFilter());
        }
        return destinationId;
    }

    public void setDestinationId(LongFilter destinationId) {
        this.destinationId = destinationId;
    }

    public LongFilter getOperatorId() {
        return operatorId;
    }

    public Optional<LongFilter> optionalOperatorId() {
        return Optional.ofNullable(operatorId);
    }

    public LongFilter operatorId() {
        if (operatorId == null) {
            setOperatorId(new LongFilter());
        }
        return operatorId;
    }

    public void setOperatorId(LongFilter operatorId) {
        this.operatorId = operatorId;
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
            Objects.equals(transportType, that.transportType) &&
            Objects.equals(distance, that.distance) &&
            Objects.equals(estimatedDuration, that.estimatedDuration) &&
            Objects.equals(basePrice, that.basePrice) &&
            Objects.equals(isActive, that.isActive) &&
            Objects.equals(tripsId, that.tripsId) &&
            Objects.equals(originId, that.originId) &&
            Objects.equals(destinationId, that.destinationId) &&
            Objects.equals(operatorId, that.operatorId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            transportType,
            distance,
            estimatedDuration,
            basePrice,
            isActive,
            tripsId,
            originId,
            destinationId,
            operatorId,
            distinct
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RouteCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalTransportType().map(f -> "transportType=" + f + ", ").orElse("") +
            optionalDistance().map(f -> "distance=" + f + ", ").orElse("") +
            optionalEstimatedDuration().map(f -> "estimatedDuration=" + f + ", ").orElse("") +
            optionalBasePrice().map(f -> "basePrice=" + f + ", ").orElse("") +
            optionalIsActive().map(f -> "isActive=" + f + ", ").orElse("") +
            optionalTripsId().map(f -> "tripsId=" + f + ", ").orElse("") +
            optionalOriginId().map(f -> "originId=" + f + ", ").orElse("") +
            optionalDestinationId().map(f -> "destinationId=" + f + ", ").orElse("") +
            optionalOperatorId().map(f -> "operatorId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
