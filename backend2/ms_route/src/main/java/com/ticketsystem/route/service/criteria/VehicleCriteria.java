package com.ticketsystem.route.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.ticketsystem.route.domain.Vehicle} entity. This class is used
 * in {@link com.ticketsystem.route.web.rest.VehicleResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /vehicles?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class VehicleCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter plateNumber;

    private StringFilter model;

    private IntegerFilter capacity;

    private StringFilter seatLayout;

    private StringFilter amenities;

    private StringFilter imageCoverUrl;

    private DoubleFilter averageRating;

    private IntegerFilter totalReviews;

    private BooleanFilter isActive;

    private IntegerFilter yearManufactured;

    private LocalDateFilter lastMaintenanceDate;

    private LongFilter summaryId;

    private LongFilter imagesId;

    private LongFilter reviewsId;

    private LongFilter amenityItemsId;

    private LongFilter homeStationId;

    private LongFilter operatorId;

    private Boolean distinct;

    public VehicleCriteria() {}

    public VehicleCriteria(VehicleCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.plateNumber = other.optionalPlateNumber().map(StringFilter::copy).orElse(null);
        this.model = other.optionalModel().map(StringFilter::copy).orElse(null);
        this.capacity = other.optionalCapacity().map(IntegerFilter::copy).orElse(null);
        this.seatLayout = other.optionalSeatLayout().map(StringFilter::copy).orElse(null);
        this.amenities = other.optionalAmenities().map(StringFilter::copy).orElse(null);
        this.imageCoverUrl = other.optionalImageCoverUrl().map(StringFilter::copy).orElse(null);
        this.averageRating = other.optionalAverageRating().map(DoubleFilter::copy).orElse(null);
        this.totalReviews = other.optionalTotalReviews().map(IntegerFilter::copy).orElse(null);
        this.isActive = other.optionalIsActive().map(BooleanFilter::copy).orElse(null);
        this.yearManufactured = other.optionalYearManufactured().map(IntegerFilter::copy).orElse(null);
        this.lastMaintenanceDate = other.optionalLastMaintenanceDate().map(LocalDateFilter::copy).orElse(null);
        this.summaryId = other.optionalSummaryId().map(LongFilter::copy).orElse(null);
        this.imagesId = other.optionalImagesId().map(LongFilter::copy).orElse(null);
        this.reviewsId = other.optionalReviewsId().map(LongFilter::copy).orElse(null);
        this.amenityItemsId = other.optionalAmenityItemsId().map(LongFilter::copy).orElse(null);
        this.homeStationId = other.optionalHomeStationId().map(LongFilter::copy).orElse(null);
        this.operatorId = other.optionalOperatorId().map(LongFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public VehicleCriteria copy() {
        return new VehicleCriteria(this);
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

    public StringFilter getPlateNumber() {
        return plateNumber;
    }

    public Optional<StringFilter> optionalPlateNumber() {
        return Optional.ofNullable(plateNumber);
    }

    public StringFilter plateNumber() {
        if (plateNumber == null) {
            setPlateNumber(new StringFilter());
        }
        return plateNumber;
    }

    public void setPlateNumber(StringFilter plateNumber) {
        this.plateNumber = plateNumber;
    }

    public StringFilter getModel() {
        return model;
    }

    public Optional<StringFilter> optionalModel() {
        return Optional.ofNullable(model);
    }

    public StringFilter model() {
        if (model == null) {
            setModel(new StringFilter());
        }
        return model;
    }

    public void setModel(StringFilter model) {
        this.model = model;
    }

    public IntegerFilter getCapacity() {
        return capacity;
    }

    public Optional<IntegerFilter> optionalCapacity() {
        return Optional.ofNullable(capacity);
    }

    public IntegerFilter capacity() {
        if (capacity == null) {
            setCapacity(new IntegerFilter());
        }
        return capacity;
    }

    public void setCapacity(IntegerFilter capacity) {
        this.capacity = capacity;
    }

    public StringFilter getSeatLayout() {
        return seatLayout;
    }

    public Optional<StringFilter> optionalSeatLayout() {
        return Optional.ofNullable(seatLayout);
    }

    public StringFilter seatLayout() {
        if (seatLayout == null) {
            setSeatLayout(new StringFilter());
        }
        return seatLayout;
    }

    public void setSeatLayout(StringFilter seatLayout) {
        this.seatLayout = seatLayout;
    }

    public StringFilter getAmenities() {
        return amenities;
    }

    public Optional<StringFilter> optionalAmenities() {
        return Optional.ofNullable(amenities);
    }

    public StringFilter amenities() {
        if (amenities == null) {
            setAmenities(new StringFilter());
        }
        return amenities;
    }

    public void setAmenities(StringFilter amenities) {
        this.amenities = amenities;
    }

    public StringFilter getImageCoverUrl() {
        return imageCoverUrl;
    }

    public Optional<StringFilter> optionalImageCoverUrl() {
        return Optional.ofNullable(imageCoverUrl);
    }

    public StringFilter imageCoverUrl() {
        if (imageCoverUrl == null) {
            setImageCoverUrl(new StringFilter());
        }
        return imageCoverUrl;
    }

    public void setImageCoverUrl(StringFilter imageCoverUrl) {
        this.imageCoverUrl = imageCoverUrl;
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

    public IntegerFilter getYearManufactured() {
        return yearManufactured;
    }

    public Optional<IntegerFilter> optionalYearManufactured() {
        return Optional.ofNullable(yearManufactured);
    }

    public IntegerFilter yearManufactured() {
        if (yearManufactured == null) {
            setYearManufactured(new IntegerFilter());
        }
        return yearManufactured;
    }

    public void setYearManufactured(IntegerFilter yearManufactured) {
        this.yearManufactured = yearManufactured;
    }

    public LocalDateFilter getLastMaintenanceDate() {
        return lastMaintenanceDate;
    }

    public Optional<LocalDateFilter> optionalLastMaintenanceDate() {
        return Optional.ofNullable(lastMaintenanceDate);
    }

    public LocalDateFilter lastMaintenanceDate() {
        if (lastMaintenanceDate == null) {
            setLastMaintenanceDate(new LocalDateFilter());
        }
        return lastMaintenanceDate;
    }

    public void setLastMaintenanceDate(LocalDateFilter lastMaintenanceDate) {
        this.lastMaintenanceDate = lastMaintenanceDate;
    }

    public LongFilter getSummaryId() {
        return summaryId;
    }

    public Optional<LongFilter> optionalSummaryId() {
        return Optional.ofNullable(summaryId);
    }

    public LongFilter summaryId() {
        if (summaryId == null) {
            setSummaryId(new LongFilter());
        }
        return summaryId;
    }

    public void setSummaryId(LongFilter summaryId) {
        this.summaryId = summaryId;
    }

    public LongFilter getImagesId() {
        return imagesId;
    }

    public Optional<LongFilter> optionalImagesId() {
        return Optional.ofNullable(imagesId);
    }

    public LongFilter imagesId() {
        if (imagesId == null) {
            setImagesId(new LongFilter());
        }
        return imagesId;
    }

    public void setImagesId(LongFilter imagesId) {
        this.imagesId = imagesId;
    }

    public LongFilter getReviewsId() {
        return reviewsId;
    }

    public Optional<LongFilter> optionalReviewsId() {
        return Optional.ofNullable(reviewsId);
    }

    public LongFilter reviewsId() {
        if (reviewsId == null) {
            setReviewsId(new LongFilter());
        }
        return reviewsId;
    }

    public void setReviewsId(LongFilter reviewsId) {
        this.reviewsId = reviewsId;
    }

    public LongFilter getAmenityItemsId() {
        return amenityItemsId;
    }

    public Optional<LongFilter> optionalAmenityItemsId() {
        return Optional.ofNullable(amenityItemsId);
    }

    public LongFilter amenityItemsId() {
        if (amenityItemsId == null) {
            setAmenityItemsId(new LongFilter());
        }
        return amenityItemsId;
    }

    public void setAmenityItemsId(LongFilter amenityItemsId) {
        this.amenityItemsId = amenityItemsId;
    }

    public LongFilter getHomeStationId() {
        return homeStationId;
    }

    public Optional<LongFilter> optionalHomeStationId() {
        return Optional.ofNullable(homeStationId);
    }

    public LongFilter homeStationId() {
        if (homeStationId == null) {
            setHomeStationId(new LongFilter());
        }
        return homeStationId;
    }

    public void setHomeStationId(LongFilter homeStationId) {
        this.homeStationId = homeStationId;
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
        final VehicleCriteria that = (VehicleCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(plateNumber, that.plateNumber) &&
            Objects.equals(model, that.model) &&
            Objects.equals(capacity, that.capacity) &&
            Objects.equals(seatLayout, that.seatLayout) &&
            Objects.equals(amenities, that.amenities) &&
            Objects.equals(imageCoverUrl, that.imageCoverUrl) &&
            Objects.equals(averageRating, that.averageRating) &&
            Objects.equals(totalReviews, that.totalReviews) &&
            Objects.equals(isActive, that.isActive) &&
            Objects.equals(yearManufactured, that.yearManufactured) &&
            Objects.equals(lastMaintenanceDate, that.lastMaintenanceDate) &&
            Objects.equals(summaryId, that.summaryId) &&
            Objects.equals(imagesId, that.imagesId) &&
            Objects.equals(reviewsId, that.reviewsId) &&
            Objects.equals(amenityItemsId, that.amenityItemsId) &&
            Objects.equals(homeStationId, that.homeStationId) &&
            Objects.equals(operatorId, that.operatorId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            plateNumber,
            model,
            capacity,
            seatLayout,
            amenities,
            imageCoverUrl,
            averageRating,
            totalReviews,
            isActive,
            yearManufactured,
            lastMaintenanceDate,
            summaryId,
            imagesId,
            reviewsId,
            amenityItemsId,
            homeStationId,
            operatorId,
            distinct
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "VehicleCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalPlateNumber().map(f -> "plateNumber=" + f + ", ").orElse("") +
            optionalModel().map(f -> "model=" + f + ", ").orElse("") +
            optionalCapacity().map(f -> "capacity=" + f + ", ").orElse("") +
            optionalSeatLayout().map(f -> "seatLayout=" + f + ", ").orElse("") +
            optionalAmenities().map(f -> "amenities=" + f + ", ").orElse("") +
            optionalImageCoverUrl().map(f -> "imageCoverUrl=" + f + ", ").orElse("") +
            optionalAverageRating().map(f -> "averageRating=" + f + ", ").orElse("") +
            optionalTotalReviews().map(f -> "totalReviews=" + f + ", ").orElse("") +
            optionalIsActive().map(f -> "isActive=" + f + ", ").orElse("") +
            optionalYearManufactured().map(f -> "yearManufactured=" + f + ", ").orElse("") +
            optionalLastMaintenanceDate().map(f -> "lastMaintenanceDate=" + f + ", ").orElse("") +
            optionalSummaryId().map(f -> "summaryId=" + f + ", ").orElse("") +
            optionalImagesId().map(f -> "imagesId=" + f + ", ").orElse("") +
            optionalReviewsId().map(f -> "reviewsId=" + f + ", ").orElse("") +
            optionalAmenityItemsId().map(f -> "amenityItemsId=" + f + ", ").orElse("") +
            optionalHomeStationId().map(f -> "homeStationId=" + f + ", ").orElse("") +
            optionalOperatorId().map(f -> "operatorId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
