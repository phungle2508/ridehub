package com.ticketsystem.route.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.ticketsystem.route.domain.Ward} entity. This class is used
 * in {@link com.ticketsystem.route.web.rest.WardResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /wards?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class WardCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter code;

    private StringFilter name;

    private StringFilter nameEn;

    private StringFilter type;

    private LongFilter addressesId;

    private LongFilter districtId;

    private Boolean distinct;

    public WardCriteria() {}

    public WardCriteria(WardCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.code = other.optionalCode().map(StringFilter::copy).orElse(null);
        this.name = other.optionalName().map(StringFilter::copy).orElse(null);
        this.nameEn = other.optionalNameEn().map(StringFilter::copy).orElse(null);
        this.type = other.optionalType().map(StringFilter::copy).orElse(null);
        this.addressesId = other.optionalAddressesId().map(LongFilter::copy).orElse(null);
        this.districtId = other.optionalDistrictId().map(LongFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public WardCriteria copy() {
        return new WardCriteria(this);
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

    public StringFilter getType() {
        return type;
    }

    public Optional<StringFilter> optionalType() {
        return Optional.ofNullable(type);
    }

    public StringFilter type() {
        if (type == null) {
            setType(new StringFilter());
        }
        return type;
    }

    public void setType(StringFilter type) {
        this.type = type;
    }

    public LongFilter getAddressesId() {
        return addressesId;
    }

    public Optional<LongFilter> optionalAddressesId() {
        return Optional.ofNullable(addressesId);
    }

    public LongFilter addressesId() {
        if (addressesId == null) {
            setAddressesId(new LongFilter());
        }
        return addressesId;
    }

    public void setAddressesId(LongFilter addressesId) {
        this.addressesId = addressesId;
    }

    public LongFilter getDistrictId() {
        return districtId;
    }

    public Optional<LongFilter> optionalDistrictId() {
        return Optional.ofNullable(districtId);
    }

    public LongFilter districtId() {
        if (districtId == null) {
            setDistrictId(new LongFilter());
        }
        return districtId;
    }

    public void setDistrictId(LongFilter districtId) {
        this.districtId = districtId;
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
        final WardCriteria that = (WardCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(code, that.code) &&
            Objects.equals(name, that.name) &&
            Objects.equals(nameEn, that.nameEn) &&
            Objects.equals(type, that.type) &&
            Objects.equals(addressesId, that.addressesId) &&
            Objects.equals(districtId, that.districtId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, nameEn, type, addressesId, districtId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "WardCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalCode().map(f -> "code=" + f + ", ").orElse("") +
            optionalName().map(f -> "name=" + f + ", ").orElse("") +
            optionalNameEn().map(f -> "nameEn=" + f + ", ").orElse("") +
            optionalType().map(f -> "type=" + f + ", ").orElse("") +
            optionalAddressesId().map(f -> "addressesId=" + f + ", ").orElse("") +
            optionalDistrictId().map(f -> "districtId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
