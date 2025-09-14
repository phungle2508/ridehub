package com.ticketsystem.route.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.ticketsystem.route.domain.ReviewSummary} entity. This class is used
 * in {@link com.ticketsystem.route.web.rest.ReviewSummaryResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /review-summaries?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ReviewSummaryCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private DoubleFilter averageRating;

    private IntegerFilter totalReviews;

    private InstantFilter updatedAt;

    private LongFilter vehicleId;

    private Boolean distinct;

    public ReviewSummaryCriteria() {}

    public ReviewSummaryCriteria(ReviewSummaryCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.averageRating = other.optionalAverageRating().map(DoubleFilter::copy).orElse(null);
        this.totalReviews = other.optionalTotalReviews().map(IntegerFilter::copy).orElse(null);
        this.updatedAt = other.optionalUpdatedAt().map(InstantFilter::copy).orElse(null);
        this.vehicleId = other.optionalVehicleId().map(LongFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public ReviewSummaryCriteria copy() {
        return new ReviewSummaryCriteria(this);
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

    public DoubleFilter getAverageRating() {
        return averageRating;
    }

    public Optional<DoubleFilter> optionalAverageRating() {
        return Optional.ofNullable(averageRating);
    }

    public DoubleFilter averageRating() {
        if (averageRating == null) {
            setAverageRating(new DoubleFilter());
        }
        return averageRating;
    }

    public void setAverageRating(DoubleFilter averageRating) {
        this.averageRating = averageRating;
    }

    public IntegerFilter getTotalReviews() {
        return totalReviews;
    }

    public Optional<IntegerFilter> optionalTotalReviews() {
        return Optional.ofNullable(totalReviews);
    }

    public IntegerFilter totalReviews() {
        if (totalReviews == null) {
            setTotalReviews(new IntegerFilter());
        }
        return totalReviews;
    }

    public void setTotalReviews(IntegerFilter totalReviews) {
        this.totalReviews = totalReviews;
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

    public LongFilter getVehicleId() {
        return vehicleId;
    }

    public Optional<LongFilter> optionalVehicleId() {
        return Optional.ofNullable(vehicleId);
    }

    public LongFilter vehicleId() {
        if (vehicleId == null) {
            setVehicleId(new LongFilter());
        }
        return vehicleId;
    }

    public void setVehicleId(LongFilter vehicleId) {
        this.vehicleId = vehicleId;
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
        final ReviewSummaryCriteria that = (ReviewSummaryCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(averageRating, that.averageRating) &&
            Objects.equals(totalReviews, that.totalReviews) &&
            Objects.equals(updatedAt, that.updatedAt) &&
            Objects.equals(vehicleId, that.vehicleId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, averageRating, totalReviews, updatedAt, vehicleId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ReviewSummaryCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalAverageRating().map(f -> "averageRating=" + f + ", ").orElse("") +
            optionalTotalReviews().map(f -> "totalReviews=" + f + ", ").orElse("") +
            optionalUpdatedAt().map(f -> "updatedAt=" + f + ", ").orElse("") +
            optionalVehicleId().map(f -> "vehicleId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
