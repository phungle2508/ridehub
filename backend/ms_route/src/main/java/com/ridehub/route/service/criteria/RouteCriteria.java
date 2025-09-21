package com.ridehub.route.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.ridehub.route.domain.Route} entity. This class is used
 * in {@link com.ridehub.route.web.rest.RouteResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /routes?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class RouteCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter routeCode;

    private BigDecimalFilter distanceKm;

    private InstantFilter createdAt;

    private InstantFilter updatedAt;

    private BooleanFilter isDeleted;

    private InstantFilter deletedAt;

    private UUIDFilter deletedBy;

    private LongFilter originId;

    private LongFilter destinationId;

    private Boolean distinct;

    public RouteCriteria() {}

    public RouteCriteria(RouteCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.routeCode = other.optionalRouteCode().map(StringFilter::copy).orElse(null);
        this.distanceKm = other.optionalDistanceKm().map(BigDecimalFilter::copy).orElse(null);
        this.createdAt = other.optionalCreatedAt().map(InstantFilter::copy).orElse(null);
        this.updatedAt = other.optionalUpdatedAt().map(InstantFilter::copy).orElse(null);
        this.isDeleted = other.optionalIsDeleted().map(BooleanFilter::copy).orElse(null);
        this.deletedAt = other.optionalDeletedAt().map(InstantFilter::copy).orElse(null);
        this.deletedBy = other.optionalDeletedBy().map(UUIDFilter::copy).orElse(null);
        this.originId = other.optionalOriginId().map(LongFilter::copy).orElse(null);
        this.destinationId = other.optionalDestinationId().map(LongFilter::copy).orElse(null);
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

    public StringFilter getRouteCode() {
        return routeCode;
    }

    public Optional<StringFilter> optionalRouteCode() {
        return Optional.ofNullable(routeCode);
    }

    public StringFilter routeCode() {
        if (routeCode == null) {
            setRouteCode(new StringFilter());
        }
        return routeCode;
    }

    public void setRouteCode(StringFilter routeCode) {
        this.routeCode = routeCode;
    }

    public BigDecimalFilter getDistanceKm() {
        return distanceKm;
    }

    public Optional<BigDecimalFilter> optionalDistanceKm() {
        return Optional.ofNullable(distanceKm);
    }

    public BigDecimalFilter distanceKm() {
        if (distanceKm == null) {
            setDistanceKm(new BigDecimalFilter());
        }
        return distanceKm;
    }

    public void setDistanceKm(BigDecimalFilter distanceKm) {
        this.distanceKm = distanceKm;
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
            Objects.equals(routeCode, that.routeCode) &&
            Objects.equals(distanceKm, that.distanceKm) &&
            Objects.equals(createdAt, that.createdAt) &&
            Objects.equals(updatedAt, that.updatedAt) &&
            Objects.equals(isDeleted, that.isDeleted) &&
            Objects.equals(deletedAt, that.deletedAt) &&
            Objects.equals(deletedBy, that.deletedBy) &&
            Objects.equals(originId, that.originId) &&
            Objects.equals(destinationId, that.destinationId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            routeCode,
            distanceKm,
            createdAt,
            updatedAt,
            isDeleted,
            deletedAt,
            deletedBy,
            originId,
            destinationId,
            distinct
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RouteCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalRouteCode().map(f -> "routeCode=" + f + ", ").orElse("") +
            optionalDistanceKm().map(f -> "distanceKm=" + f + ", ").orElse("") +
            optionalCreatedAt().map(f -> "createdAt=" + f + ", ").orElse("") +
            optionalUpdatedAt().map(f -> "updatedAt=" + f + ", ").orElse("") +
            optionalIsDeleted().map(f -> "isDeleted=" + f + ", ").orElse("") +
            optionalDeletedAt().map(f -> "deletedAt=" + f + ", ").orElse("") +
            optionalDeletedBy().map(f -> "deletedBy=" + f + ", ").orElse("") +
            optionalOriginId().map(f -> "originId=" + f + ", ").orElse("") +
            optionalDestinationId().map(f -> "destinationId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
