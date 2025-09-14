package com.ticketsystem.route.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.ticketsystem.route.domain.District} entity. This class is used
 * in {@link com.ticketsystem.route.web.rest.DistrictResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /districts?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class DistrictCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter code;

    private StringFilter name;

    private StringFilter nameEn;

    private StringFilter type;

    private LongFilter wardsId;

    private LongFilter provinceId;

    private Boolean distinct;

    public DistrictCriteria() {}

    public DistrictCriteria(DistrictCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.code = other.optionalCode().map(StringFilter::copy).orElse(null);
        this.name = other.optionalName().map(StringFilter::copy).orElse(null);
        this.nameEn = other.optionalNameEn().map(StringFilter::copy).orElse(null);
        this.type = other.optionalType().map(StringFilter::copy).orElse(null);
        this.wardsId = other.optionalWardsId().map(LongFilter::copy).orElse(null);
        this.provinceId = other.optionalProvinceId().map(LongFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public DistrictCriteria copy() {
        return new DistrictCriteria(this);
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

    public LongFilter getWardsId() {
        return wardsId;
    }

    public Optional<LongFilter> optionalWardsId() {
        return Optional.ofNullable(wardsId);
    }

    public LongFilter wardsId() {
        if (wardsId == null) {
            setWardsId(new LongFilter());
        }
        return wardsId;
    }

    public void setWardsId(LongFilter wardsId) {
        this.wardsId = wardsId;
    }

    public LongFilter getProvinceId() {
        return provinceId;
    }

    public Optional<LongFilter> optionalProvinceId() {
        return Optional.ofNullable(provinceId);
    }

    public LongFilter provinceId() {
        if (provinceId == null) {
            setProvinceId(new LongFilter());
        }
        return provinceId;
    }

    public void setProvinceId(LongFilter provinceId) {
        this.provinceId = provinceId;
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
        final DistrictCriteria that = (DistrictCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(code, that.code) &&
            Objects.equals(name, that.name) &&
            Objects.equals(nameEn, that.nameEn) &&
            Objects.equals(type, that.type) &&
            Objects.equals(wardsId, that.wardsId) &&
            Objects.equals(provinceId, that.provinceId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, nameEn, type, wardsId, provinceId, distinct);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "DistrictCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalCode().map(f -> "code=" + f + ", ").orElse("") +
            optionalName().map(f -> "name=" + f + ", ").orElse("") +
            optionalNameEn().map(f -> "nameEn=" + f + ", ").orElse("") +
            optionalType().map(f -> "type=" + f + ", ").orElse("") +
            optionalWardsId().map(f -> "wardsId=" + f + ", ").orElse("") +
            optionalProvinceId().map(f -> "provinceId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
