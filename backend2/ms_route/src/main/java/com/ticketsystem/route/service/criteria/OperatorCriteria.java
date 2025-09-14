package com.ticketsystem.route.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.ticketsystem.route.domain.Operator} entity. This class is used
 * in {@link com.ticketsystem.route.web.rest.OperatorResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /operators?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class OperatorCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter name;

    private StringFilter businessLicense;

    private StringFilter logoUrl;

    private DoubleFilter rating;

    private StringFilter contactPhone;

    private StringFilter contactEmail;

    private BooleanFilter isActive;

    private LongFilter vehiclesId;

    private LongFilter routesId;

    private Boolean distinct;

    public OperatorCriteria() {}

    public OperatorCriteria(OperatorCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.name = other.optionalName().map(StringFilter::copy).orElse(null);
        this.businessLicense = other.optionalBusinessLicense().map(StringFilter::copy).orElse(null);
        this.logoUrl = other.optionalLogoUrl().map(StringFilter::copy).orElse(null);
        this.rating = other.optionalRating().map(DoubleFilter::copy).orElse(null);
        this.contactPhone = other.optionalContactPhone().map(StringFilter::copy).orElse(null);
        this.contactEmail = other.optionalContactEmail().map(StringFilter::copy).orElse(null);
        this.isActive = other.optionalIsActive().map(BooleanFilter::copy).orElse(null);
        this.vehiclesId = other.optionalVehiclesId().map(LongFilter::copy).orElse(null);
        this.routesId = other.optionalRoutesId().map(LongFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public OperatorCriteria copy() {
        return new OperatorCriteria(this);
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

    public StringFilter getName() {
        return name;
    }

    public Optional<StringFilter> optionalName() {
        return Optional.ofNullable(name);
    }

    public StringFilter name() {
        if (name == null) {
            setName(new StringFilter());
        }
        return name;
    }

    public void setName(StringFilter name) {
        this.name = name;
    }

    public StringFilter getBusinessLicense() {
        return businessLicense;
    }

    public Optional<StringFilter> optionalBusinessLicense() {
        return Optional.ofNullable(businessLicense);
    }

    public StringFilter businessLicense() {
        if (businessLicense == null) {
            setBusinessLicense(new StringFilter());
        }
        return businessLicense;
    }

    public void setBusinessLicense(StringFilter businessLicense) {
        this.businessLicense = businessLicense;
    }

    public StringFilter getLogoUrl() {
        return logoUrl;
    }

    public Optional<StringFilter> optionalLogoUrl() {
        return Optional.ofNullable(logoUrl);
    }

    public StringFilter logoUrl() {
        if (logoUrl == null) {
            setLogoUrl(new StringFilter());
        }
        return logoUrl;
    }

    public void setLogoUrl(StringFilter logoUrl) {
        this.logoUrl = logoUrl;
    }

    public DoubleFilter getRating() {
        return rating;
    }

    public Optional<DoubleFilter> optionalRating() {
        return Optional.ofNullable(rating);
    }

    public DoubleFilter rating() {
        if (rating == null) {
            setRating(new DoubleFilter());
        }
        return rating;
    }

    public void setRating(DoubleFilter rating) {
        this.rating = rating;
    }

    public StringFilter getContactPhone() {
        return contactPhone;
    }

    public Optional<StringFilter> optionalContactPhone() {
        return Optional.ofNullable(contactPhone);
    }

    public StringFilter contactPhone() {
        if (contactPhone == null) {
            setContactPhone(new StringFilter());
        }
        return contactPhone;
    }

    public void setContactPhone(StringFilter contactPhone) {
        this.contactPhone = contactPhone;
    }

    public StringFilter getContactEmail() {
        return contactEmail;
    }

    public Optional<StringFilter> optionalContactEmail() {
        return Optional.ofNullable(contactEmail);
    }

    public StringFilter contactEmail() {
        if (contactEmail == null) {
            setContactEmail(new StringFilter());
        }
        return contactEmail;
    }

    public void setContactEmail(StringFilter contactEmail) {
        this.contactEmail = contactEmail;
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

    public LongFilter getVehiclesId() {
        return vehiclesId;
    }

    public Optional<LongFilter> optionalVehiclesId() {
        return Optional.ofNullable(vehiclesId);
    }

    public LongFilter vehiclesId() {
        if (vehiclesId == null) {
            setVehiclesId(new LongFilter());
        }
        return vehiclesId;
    }

    public void setVehiclesId(LongFilter vehiclesId) {
        this.vehiclesId = vehiclesId;
    }

    public LongFilter getRoutesId() {
        return routesId;
    }

    public Optional<LongFilter> optionalRoutesId() {
        return Optional.ofNullable(routesId);
    }

    public LongFilter routesId() {
        if (routesId == null) {
            setRoutesId(new LongFilter());
        }
        return routesId;
    }

    public void setRoutesId(LongFilter routesId) {
        this.routesId = routesId;
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
        final OperatorCriteria that = (OperatorCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(name, that.name) &&
            Objects.equals(businessLicense, that.businessLicense) &&
            Objects.equals(logoUrl, that.logoUrl) &&
            Objects.equals(rating, that.rating) &&
            Objects.equals(contactPhone, that.contactPhone) &&
            Objects.equals(contactEmail, that.contactEmail) &&
            Objects.equals(isActive, that.isActive) &&
            Objects.equals(vehiclesId, that.vehiclesId) &&
            Objects.equals(routesId, that.routesId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            name,
            businessLicense,
            logoUrl,
            rating,
            contactPhone,
            contactEmail,
            isActive,
            vehiclesId,
            routesId,
            distinct
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "OperatorCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalName().map(f -> "name=" + f + ", ").orElse("") +
            optionalBusinessLicense().map(f -> "businessLicense=" + f + ", ").orElse("") +
            optionalLogoUrl().map(f -> "logoUrl=" + f + ", ").orElse("") +
            optionalRating().map(f -> "rating=" + f + ", ").orElse("") +
            optionalContactPhone().map(f -> "contactPhone=" + f + ", ").orElse("") +
            optionalContactEmail().map(f -> "contactEmail=" + f + ", ").orElse("") +
            optionalIsActive().map(f -> "isActive=" + f + ", ").orElse("") +
            optionalVehiclesId().map(f -> "vehiclesId=" + f + ", ").orElse("") +
            optionalRoutesId().map(f -> "routesId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
