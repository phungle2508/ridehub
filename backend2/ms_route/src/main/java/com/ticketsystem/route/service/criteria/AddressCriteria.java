package com.ticketsystem.route.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.ticketsystem.route.domain.Address} entity. This class is used
 * in {@link com.ticketsystem.route.web.rest.AddressResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /addresses?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class AddressCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter wardCode;

    private StringFilter streetAddress;

    private StringFilter postalCode;

    private BigDecimalFilter latitude;

    private BigDecimalFilter longitude;

    private StringFilter landmark;

    private LongFilter wardId;

    private Boolean distinct;

    public AddressCriteria() {}

    public AddressCriteria(AddressCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.wardCode = other.optionalWardCode().map(StringFilter::copy).orElse(null);
        this.streetAddress = other.optionalStreetAddress().map(StringFilter::copy).orElse(null);
        this.postalCode = other.optionalPostalCode().map(StringFilter::copy).orElse(null);
        this.latitude = other.optionalLatitude().map(BigDecimalFilter::copy).orElse(null);
        this.longitude = other.optionalLongitude().map(BigDecimalFilter::copy).orElse(null);
        this.landmark = other.optionalLandmark().map(StringFilter::copy).orElse(null);
        this.wardId = other.optionalWardId().map(LongFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public AddressCriteria copy() {
        return new AddressCriteria(this);
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

    public StringFilter getWardCode() {
        return wardCode;
    }

    public Optional<StringFilter> optionalWardCode() {
        return Optional.ofNullable(wardCode);
    }

    public StringFilter wardCode() {
        if (wardCode == null) {
            setWardCode(new StringFilter());
        }
        return wardCode;
    }

    public void setWardCode(StringFilter wardCode) {
        this.wardCode = wardCode;
    }

    public StringFilter getStreetAddress() {
        return streetAddress;
    }

    public Optional<StringFilter> optionalStreetAddress() {
        return Optional.ofNullable(streetAddress);
    }

    public StringFilter streetAddress() {
        if (streetAddress == null) {
            setStreetAddress(new StringFilter());
        }
        return streetAddress;
    }

    public void setStreetAddress(StringFilter streetAddress) {
        this.streetAddress = streetAddress;
    }

    public StringFilter getPostalCode() {
        return postalCode;
    }

    public Optional<StringFilter> optionalPostalCode() {
        return Optional.ofNullable(postalCode);
    }

    public StringFilter postalCode() {
        if (postalCode == null) {
            setPostalCode(new StringFilter());
        }
        return postalCode;
    }

    public void setPostalCode(StringFilter postalCode) {
        this.postalCode = postalCode;
    }

    public BigDecimalFilter getLatitude() {
        return latitude;
    }

    public Optional<BigDecimalFilter> optionalLatitude() {
        return Optional.ofNullable(latitude);
    }

    public BigDecimalFilter latitude() {
        if (latitude == null) {
            setLatitude(new BigDecimalFilter());
        }
        return latitude;
    }

    public void setLatitude(BigDecimalFilter latitude) {
        this.latitude = latitude;
    }

    public BigDecimalFilter getLongitude() {
        return longitude;
    }

    public Optional<BigDecimalFilter> optionalLongitude() {
        return Optional.ofNullable(longitude);
    }

    public BigDecimalFilter longitude() {
        if (longitude == null) {
            setLongitude(new BigDecimalFilter());
        }
        return longitude;
    }

    public void setLongitude(BigDecimalFilter longitude) {
        this.longitude = longitude;
    }

    public StringFilter getLandmark() {
        return landmark;
    }

    public Optional<StringFilter> optionalLandmark() {
        return Optional.ofNullable(landmark);
    }

    public StringFilter landmark() {
        if (landmark == null) {
            setLandmark(new StringFilter());
        }
        return landmark;
    }

    public void setLandmark(StringFilter landmark) {
        this.landmark = landmark;
    }

    public LongFilter getWardId() {
        return wardId;
    }

    public Optional<LongFilter> optionalWardId() {
        return Optional.ofNullable(wardId);
    }

    public LongFilter wardId() {
        if (wardId == null) {
            setWardId(new LongFilter());
        }
        return wardId;
    }

    public void setWardId(LongFilter wardId) {
        this.wardId = wardId;
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
        final AddressCriteria that = (AddressCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(wardCode, that.wardCode) &&
            Objects.equals(streetAddress, that.streetAddress) &&
            Objects.equals(postalCode, that.postalCode) &&
            Objects.equals(latitude, that.latitude) &&
            Objects.equals(longitude, that.longitude) &&
            Objects.equals(landmark, that.landmark) &&
            Objects.equals(wardId, that.wardId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, wardCode, streetAddress, postalCode, latitude, longitude, landmark, wardId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AddressCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalWardCode().map(f -> "wardCode=" + f + ", ").orElse("") +
            optionalStreetAddress().map(f -> "streetAddress=" + f + ", ").orElse("") +
            optionalPostalCode().map(f -> "postalCode=" + f + ", ").orElse("") +
            optionalLatitude().map(f -> "latitude=" + f + ", ").orElse("") +
            optionalLongitude().map(f -> "longitude=" + f + ", ").orElse("") +
            optionalLandmark().map(f -> "landmark=" + f + ", ").orElse("") +
            optionalWardId().map(f -> "wardId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
