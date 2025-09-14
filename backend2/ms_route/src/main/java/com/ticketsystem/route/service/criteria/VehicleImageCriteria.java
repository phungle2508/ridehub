package com.ticketsystem.route.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.ticketsystem.route.domain.VehicleImage} entity. This class is used
 * in {@link com.ticketsystem.route.web.rest.VehicleImageResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /vehicle-images?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class VehicleImageCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter imageUrl;

    private StringFilter imageType;

    private StringFilter description;

    private BooleanFilter isPrimary;

    private InstantFilter uploadedAt;

    private LongFilter vehicleId;

    private Boolean distinct;

    public VehicleImageCriteria() {}

    public VehicleImageCriteria(VehicleImageCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.imageUrl = other.optionalImageUrl().map(StringFilter::copy).orElse(null);
        this.imageType = other.optionalImageType().map(StringFilter::copy).orElse(null);
        this.description = other.optionalDescription().map(StringFilter::copy).orElse(null);
        this.isPrimary = other.optionalIsPrimary().map(BooleanFilter::copy).orElse(null);
        this.uploadedAt = other.optionalUploadedAt().map(InstantFilter::copy).orElse(null);
        this.vehicleId = other.optionalVehicleId().map(LongFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public VehicleImageCriteria copy() {
        return new VehicleImageCriteria(this);
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

    public StringFilter getImageUrl() {
        return imageUrl;
    }

    public Optional<StringFilter> optionalImageUrl() {
        return Optional.ofNullable(imageUrl);
    }

    public StringFilter imageUrl() {
        if (imageUrl == null) {
            setImageUrl(new StringFilter());
        }
        return imageUrl;
    }

    public void setImageUrl(StringFilter imageUrl) {
        this.imageUrl = imageUrl;
    }

    public StringFilter getImageType() {
        return imageType;
    }

    public Optional<StringFilter> optionalImageType() {
        return Optional.ofNullable(imageType);
    }

    public StringFilter imageType() {
        if (imageType == null) {
            setImageType(new StringFilter());
        }
        return imageType;
    }

    public void setImageType(StringFilter imageType) {
        this.imageType = imageType;
    }

    public StringFilter getDescription() {
        return description;
    }

    public Optional<StringFilter> optionalDescription() {
        return Optional.ofNullable(description);
    }

    public StringFilter description() {
        if (description == null) {
            setDescription(new StringFilter());
        }
        return description;
    }

    public void setDescription(StringFilter description) {
        this.description = description;
    }

    public BooleanFilter getIsPrimary() {
        return isPrimary;
    }

    public Optional<BooleanFilter> optionalIsPrimary() {
        return Optional.ofNullable(isPrimary);
    }

    public BooleanFilter isPrimary() {
        if (isPrimary == null) {
            setIsPrimary(new BooleanFilter());
        }
        return isPrimary;
    }

    public void setIsPrimary(BooleanFilter isPrimary) {
        this.isPrimary = isPrimary;
    }

    public InstantFilter getUploadedAt() {
        return uploadedAt;
    }

    public Optional<InstantFilter> optionalUploadedAt() {
        return Optional.ofNullable(uploadedAt);
    }

    public InstantFilter uploadedAt() {
        if (uploadedAt == null) {
            setUploadedAt(new InstantFilter());
        }
        return uploadedAt;
    }

    public void setUploadedAt(InstantFilter uploadedAt) {
        this.uploadedAt = uploadedAt;
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
        final VehicleImageCriteria that = (VehicleImageCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(imageUrl, that.imageUrl) &&
            Objects.equals(imageType, that.imageType) &&
            Objects.equals(description, that.description) &&
            Objects.equals(isPrimary, that.isPrimary) &&
            Objects.equals(uploadedAt, that.uploadedAt) &&
            Objects.equals(vehicleId, that.vehicleId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imageUrl, imageType, description, isPrimary, uploadedAt, vehicleId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "VehicleImageCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalImageUrl().map(f -> "imageUrl=" + f + ", ").orElse("") +
            optionalImageType().map(f -> "imageType=" + f + ", ").orElse("") +
            optionalDescription().map(f -> "description=" + f + ", ").orElse("") +
            optionalIsPrimary().map(f -> "isPrimary=" + f + ", ").orElse("") +
            optionalUploadedAt().map(f -> "uploadedAt=" + f + ", ").orElse("") +
            optionalVehicleId().map(f -> "vehicleId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
