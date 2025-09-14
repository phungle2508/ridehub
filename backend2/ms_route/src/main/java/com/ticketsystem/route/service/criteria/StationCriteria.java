package com.ticketsystem.route.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.ticketsystem.route.domain.Station} entity. This class is used
 * in {@link com.ticketsystem.route.web.rest.StationResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /stations?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class StationCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter code;

    private StringFilter name;

    private StringFilter nameEn;

    private UUIDFilter addressId;

    private StringFilter facilities;

    private StringFilter operatingHours;

    private BooleanFilter isActive;

    private Boolean distinct;

    public StationCriteria() {}

    public StationCriteria(StationCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.code = other.optionalCode().map(StringFilter::copy).orElse(null);
        this.name = other.optionalName().map(StringFilter::copy).orElse(null);
        this.nameEn = other.optionalNameEn().map(StringFilter::copy).orElse(null);
        this.addressId = other.optionalAddressId().map(UUIDFilter::copy).orElse(null);
        this.facilities = other.optionalFacilities().map(StringFilter::copy).orElse(null);
        this.operatingHours = other.optionalOperatingHours().map(StringFilter::copy).orElse(null);
        this.isActive = other.optionalIsActive().map(BooleanFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public StationCriteria copy() {
        return new StationCriteria(this);
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

    public StringFilter getCode() {
        return code;
    }

    public Optional<StringFilter> optionalCode() {
        return Optional.ofNullable(code);
    }

    public StringFilter code() {
        if (code == null) {
            setCode(new StringFilter());
        }
        return code;
    }

    public void setCode(StringFilter code) {
        this.code = code;
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

    public StringFilter getNameEn() {
        return nameEn;
    }

    public Optional<StringFilter> optionalNameEn() {
        return Optional.ofNullable(nameEn);
    }

    public StringFilter nameEn() {
        if (nameEn == null) {
            setNameEn(new StringFilter());
        }
        return nameEn;
    }

    public void setNameEn(StringFilter nameEn) {
        this.nameEn = nameEn;
    }

    public UUIDFilter getAddressId() {
        return addressId;
    }

    public Optional<UUIDFilter> optionalAddressId() {
        return Optional.ofNullable(addressId);
    }

    public UUIDFilter addressId() {
        if (addressId == null) {
            setAddressId(new UUIDFilter());
        }
        return addressId;
    }

    public void setAddressId(UUIDFilter addressId) {
        this.addressId = addressId;
    }

    public StringFilter getFacilities() {
        return facilities;
    }

    public Optional<StringFilter> optionalFacilities() {
        return Optional.ofNullable(facilities);
    }

    public StringFilter facilities() {
        if (facilities == null) {
            setFacilities(new StringFilter());
        }
        return facilities;
    }

    public void setFacilities(StringFilter facilities) {
        this.facilities = facilities;
    }

    public StringFilter getOperatingHours() {
        return operatingHours;
    }

    public Optional<StringFilter> optionalOperatingHours() {
        return Optional.ofNullable(operatingHours);
    }

    public StringFilter operatingHours() {
        if (operatingHours == null) {
            setOperatingHours(new StringFilter());
        }
        return operatingHours;
    }

    public void setOperatingHours(StringFilter operatingHours) {
        this.operatingHours = operatingHours;
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
        final StationCriteria that = (StationCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(code, that.code) &&
            Objects.equals(name, that.name) &&
            Objects.equals(nameEn, that.nameEn) &&
            Objects.equals(addressId, that.addressId) &&
            Objects.equals(facilities, that.facilities) &&
            Objects.equals(operatingHours, that.operatingHours) &&
            Objects.equals(isActive, that.isActive) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, nameEn, addressId, facilities, operatingHours, isActive, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "StationCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalCode().map(f -> "code=" + f + ", ").orElse("") +
            optionalName().map(f -> "name=" + f + ", ").orElse("") +
            optionalNameEn().map(f -> "nameEn=" + f + ", ").orElse("") +
            optionalAddressId().map(f -> "addressId=" + f + ", ").orElse("") +
            optionalFacilities().map(f -> "facilities=" + f + ", ").orElse("") +
            optionalOperatingHours().map(f -> "operatingHours=" + f + ", ").orElse("") +
            optionalIsActive().map(f -> "isActive=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
