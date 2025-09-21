package com.ridehub.promotion.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.ridehub.promotion.domain.ConditionByLocation} entity. This class is used
 * in {@link com.ridehub.promotion.web.rest.ConditionByLocationResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /condition-by-locations?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ConditionByLocationCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private UUIDFilter provinceId;

    private UUIDFilter districtId;

    private UUIDFilter wardId;

    private InstantFilter createdAt;

    private InstantFilter updatedAt;

    private BooleanFilter isDeleted;

    private InstantFilter deletedAt;

    private UUIDFilter deletedBy;

    private LongFilter promotionId;

    private Boolean distinct;

    public ConditionByLocationCriteria() {}

    public ConditionByLocationCriteria(ConditionByLocationCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.provinceId = other.optionalProvinceId().map(UUIDFilter::copy).orElse(null);
        this.districtId = other.optionalDistrictId().map(UUIDFilter::copy).orElse(null);
        this.wardId = other.optionalWardId().map(UUIDFilter::copy).orElse(null);
        this.createdAt = other.optionalCreatedAt().map(InstantFilter::copy).orElse(null);
        this.updatedAt = other.optionalUpdatedAt().map(InstantFilter::copy).orElse(null);
        this.isDeleted = other.optionalIsDeleted().map(BooleanFilter::copy).orElse(null);
        this.deletedAt = other.optionalDeletedAt().map(InstantFilter::copy).orElse(null);
        this.deletedBy = other.optionalDeletedBy().map(UUIDFilter::copy).orElse(null);
        this.promotionId = other.optionalPromotionId().map(LongFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public ConditionByLocationCriteria copy() {
        return new ConditionByLocationCriteria(this);
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

    public UUIDFilter getProvinceId() {
        return provinceId;
    }

    public Optional<UUIDFilter> optionalProvinceId() {
        return Optional.ofNullable(provinceId);
    }

    public UUIDFilter provinceId() {
        if (provinceId == null) {
            setProvinceId(new UUIDFilter());
        }
        return provinceId;
    }

    public void setProvinceId(UUIDFilter provinceId) {
        this.provinceId = provinceId;
    }

    public UUIDFilter getDistrictId() {
        return districtId;
    }

    public Optional<UUIDFilter> optionalDistrictId() {
        return Optional.ofNullable(districtId);
    }

    public UUIDFilter districtId() {
        if (districtId == null) {
            setDistrictId(new UUIDFilter());
        }
        return districtId;
    }

    public void setDistrictId(UUIDFilter districtId) {
        this.districtId = districtId;
    }

    public UUIDFilter getWardId() {
        return wardId;
    }

    public Optional<UUIDFilter> optionalWardId() {
        return Optional.ofNullable(wardId);
    }

    public UUIDFilter wardId() {
        if (wardId == null) {
            setWardId(new UUIDFilter());
        }
        return wardId;
    }

    public void setWardId(UUIDFilter wardId) {
        this.wardId = wardId;
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

    public LongFilter getPromotionId() {
        return promotionId;
    }

    public Optional<LongFilter> optionalPromotionId() {
        return Optional.ofNullable(promotionId);
    }

    public LongFilter promotionId() {
        if (promotionId == null) {
            setPromotionId(new LongFilter());
        }
        return promotionId;
    }

    public void setPromotionId(LongFilter promotionId) {
        this.promotionId = promotionId;
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
        final ConditionByLocationCriteria that = (ConditionByLocationCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(provinceId, that.provinceId) &&
            Objects.equals(districtId, that.districtId) &&
            Objects.equals(wardId, that.wardId) &&
            Objects.equals(createdAt, that.createdAt) &&
            Objects.equals(updatedAt, that.updatedAt) &&
            Objects.equals(isDeleted, that.isDeleted) &&
            Objects.equals(deletedAt, that.deletedAt) &&
            Objects.equals(deletedBy, that.deletedBy) &&
            Objects.equals(promotionId, that.promotionId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            provinceId,
            districtId,
            wardId,
            createdAt,
            updatedAt,
            isDeleted,
            deletedAt,
            deletedBy,
            promotionId,
            distinct
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ConditionByLocationCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalProvinceId().map(f -> "provinceId=" + f + ", ").orElse("") +
            optionalDistrictId().map(f -> "districtId=" + f + ", ").orElse("") +
            optionalWardId().map(f -> "wardId=" + f + ", ").orElse("") +
            optionalCreatedAt().map(f -> "createdAt=" + f + ", ").orElse("") +
            optionalUpdatedAt().map(f -> "updatedAt=" + f + ", ").orElse("") +
            optionalIsDeleted().map(f -> "isDeleted=" + f + ", ").orElse("") +
            optionalDeletedAt().map(f -> "deletedAt=" + f + ", ").orElse("") +
            optionalDeletedBy().map(f -> "deletedBy=" + f + ", ").orElse("") +
            optionalPromotionId().map(f -> "promotionId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
