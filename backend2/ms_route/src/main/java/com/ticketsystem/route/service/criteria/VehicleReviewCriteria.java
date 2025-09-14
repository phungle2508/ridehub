package com.ticketsystem.route.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.ticketsystem.route.domain.VehicleReview} entity. This class is used
 * in {@link com.ticketsystem.route.web.rest.VehicleReviewResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /vehicle-reviews?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class VehicleReviewCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private UUIDFilter userId;

    private UUIDFilter tripId;

    private IntegerFilter rating;

    private StringFilter comment;

    private IntegerFilter cleanliness;

    private IntegerFilter comfort;

    private IntegerFilter punctuality;

    private IntegerFilter staffService;

    private InstantFilter createdAt;

    private BooleanFilter isVerified;

    private LongFilter vehicleId;

    private Boolean distinct;

    public VehicleReviewCriteria() {}

    public VehicleReviewCriteria(VehicleReviewCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.userId = other.optionalUserId().map(UUIDFilter::copy).orElse(null);
        this.tripId = other.optionalTripId().map(UUIDFilter::copy).orElse(null);
        this.rating = other.optionalRating().map(IntegerFilter::copy).orElse(null);
        this.comment = other.optionalComment().map(StringFilter::copy).orElse(null);
        this.cleanliness = other.optionalCleanliness().map(IntegerFilter::copy).orElse(null);
        this.comfort = other.optionalComfort().map(IntegerFilter::copy).orElse(null);
        this.punctuality = other.optionalPunctuality().map(IntegerFilter::copy).orElse(null);
        this.staffService = other.optionalStaffService().map(IntegerFilter::copy).orElse(null);
        this.createdAt = other.optionalCreatedAt().map(InstantFilter::copy).orElse(null);
        this.isVerified = other.optionalIsVerified().map(BooleanFilter::copy).orElse(null);
        this.vehicleId = other.optionalVehicleId().map(LongFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public VehicleReviewCriteria copy() {
        return new VehicleReviewCriteria(this);
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

    public UUIDFilter getUserId() {
        return userId;
    }

    public Optional<UUIDFilter> optionalUserId() {
        return Optional.ofNullable(userId);
    }

    public UUIDFilter userId() {
        if (userId == null) {
            setUserId(new UUIDFilter());
        }
        return userId;
    }

    public void setUserId(UUIDFilter userId) {
        this.userId = userId;
    }

    public UUIDFilter getTripId() {
        return tripId;
    }

    public Optional<UUIDFilter> optionalTripId() {
        return Optional.ofNullable(tripId);
    }

    public UUIDFilter tripId() {
        if (tripId == null) {
            setTripId(new UUIDFilter());
        }
        return tripId;
    }

    public void setTripId(UUIDFilter tripId) {
        this.tripId = tripId;
    }

    public IntegerFilter getRating() {
        return rating;
    }

    public Optional<IntegerFilter> optionalRating() {
        return Optional.ofNullable(rating);
    }

    public IntegerFilter rating() {
        if (rating == null) {
            setRating(new IntegerFilter());
        }
        return rating;
    }

    public void setRating(IntegerFilter rating) {
        this.rating = rating;
    }

    public StringFilter getComment() {
        return comment;
    }

    public Optional<StringFilter> optionalComment() {
        return Optional.ofNullable(comment);
    }

    public StringFilter comment() {
        if (comment == null) {
            setComment(new StringFilter());
        }
        return comment;
    }

    public void setComment(StringFilter comment) {
        this.comment = comment;
    }

    public IntegerFilter getCleanliness() {
        return cleanliness;
    }

    public Optional<IntegerFilter> optionalCleanliness() {
        return Optional.ofNullable(cleanliness);
    }

    public IntegerFilter cleanliness() {
        if (cleanliness == null) {
            setCleanliness(new IntegerFilter());
        }
        return cleanliness;
    }

    public void setCleanliness(IntegerFilter cleanliness) {
        this.cleanliness = cleanliness;
    }

    public IntegerFilter getComfort() {
        return comfort;
    }

    public Optional<IntegerFilter> optionalComfort() {
        return Optional.ofNullable(comfort);
    }

    public IntegerFilter comfort() {
        if (comfort == null) {
            setComfort(new IntegerFilter());
        }
        return comfort;
    }

    public void setComfort(IntegerFilter comfort) {
        this.comfort = comfort;
    }

    public IntegerFilter getPunctuality() {
        return punctuality;
    }

    public Optional<IntegerFilter> optionalPunctuality() {
        return Optional.ofNullable(punctuality);
    }

    public IntegerFilter punctuality() {
        if (punctuality == null) {
            setPunctuality(new IntegerFilter());
        }
        return punctuality;
    }

    public void setPunctuality(IntegerFilter punctuality) {
        this.punctuality = punctuality;
    }

    public IntegerFilter getStaffService() {
        return staffService;
    }

    public Optional<IntegerFilter> optionalStaffService() {
        return Optional.ofNullable(staffService);
    }

    public IntegerFilter staffService() {
        if (staffService == null) {
            setStaffService(new IntegerFilter());
        }
        return staffService;
    }

    public void setStaffService(IntegerFilter staffService) {
        this.staffService = staffService;
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

    public BooleanFilter getIsVerified() {
        return isVerified;
    }

    public Optional<BooleanFilter> optionalIsVerified() {
        return Optional.ofNullable(isVerified);
    }

    public BooleanFilter isVerified() {
        if (isVerified == null) {
            setIsVerified(new BooleanFilter());
        }
        return isVerified;
    }

    public void setIsVerified(BooleanFilter isVerified) {
        this.isVerified = isVerified;
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
        final VehicleReviewCriteria that = (VehicleReviewCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(userId, that.userId) &&
            Objects.equals(tripId, that.tripId) &&
            Objects.equals(rating, that.rating) &&
            Objects.equals(comment, that.comment) &&
            Objects.equals(cleanliness, that.cleanliness) &&
            Objects.equals(comfort, that.comfort) &&
            Objects.equals(punctuality, that.punctuality) &&
            Objects.equals(staffService, that.staffService) &&
            Objects.equals(createdAt, that.createdAt) &&
            Objects.equals(isVerified, that.isVerified) &&
            Objects.equals(vehicleId, that.vehicleId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            userId,
            tripId,
            rating,
            comment,
            cleanliness,
            comfort,
            punctuality,
            staffService,
            createdAt,
            isVerified,
            vehicleId,
            distinct
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "VehicleReviewCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalUserId().map(f -> "userId=" + f + ", ").orElse("") +
            optionalTripId().map(f -> "tripId=" + f + ", ").orElse("") +
            optionalRating().map(f -> "rating=" + f + ", ").orElse("") +
            optionalComment().map(f -> "comment=" + f + ", ").orElse("") +
            optionalCleanliness().map(f -> "cleanliness=" + f + ", ").orElse("") +
            optionalComfort().map(f -> "comfort=" + f + ", ").orElse("") +
            optionalPunctuality().map(f -> "punctuality=" + f + ", ").orElse("") +
            optionalStaffService().map(f -> "staffService=" + f + ", ").orElse("") +
            optionalCreatedAt().map(f -> "createdAt=" + f + ", ").orElse("") +
            optionalIsVerified().map(f -> "isVerified=" + f + ", ").orElse("") +
            optionalVehicleId().map(f -> "vehicleId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
