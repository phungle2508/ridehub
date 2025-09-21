package com.ridehub.promotion.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.ridehub.promotion.domain.Promotion} entity. This class is used
 * in {@link com.ridehub.promotion.web.rest.PromotionResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /promotions?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class PromotionCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter code;

    private StringFilter description;

    private LocalDateFilter startDate;

    private LocalDateFilter endDate;

    private IntegerFilter usageLimit;

    private IntegerFilter usedCount;

    private InstantFilter createdAt;

    private InstantFilter updatedAt;

    private BooleanFilter isDeleted;

    private InstantFilter deletedAt;

    private UUIDFilter deletedBy;

    private LongFilter buyNGetMId;

    private LongFilter percentOffId;

    private LongFilter conditionsRId;

    private LongFilter conditionsDId;

    private LongFilter conditionsLocId;

    private Boolean distinct;

    public PromotionCriteria() {}

    public PromotionCriteria(PromotionCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.code = other.optionalCode().map(StringFilter::copy).orElse(null);
        this.description = other.optionalDescription().map(StringFilter::copy).orElse(null);
        this.startDate = other.optionalStartDate().map(LocalDateFilter::copy).orElse(null);
        this.endDate = other.optionalEndDate().map(LocalDateFilter::copy).orElse(null);
        this.usageLimit = other.optionalUsageLimit().map(IntegerFilter::copy).orElse(null);
        this.usedCount = other.optionalUsedCount().map(IntegerFilter::copy).orElse(null);
        this.createdAt = other.optionalCreatedAt().map(InstantFilter::copy).orElse(null);
        this.updatedAt = other.optionalUpdatedAt().map(InstantFilter::copy).orElse(null);
        this.isDeleted = other.optionalIsDeleted().map(BooleanFilter::copy).orElse(null);
        this.deletedAt = other.optionalDeletedAt().map(InstantFilter::copy).orElse(null);
        this.deletedBy = other.optionalDeletedBy().map(UUIDFilter::copy).orElse(null);
        this.buyNGetMId = other.optionalBuyNGetMId().map(LongFilter::copy).orElse(null);
        this.percentOffId = other.optionalPercentOffId().map(LongFilter::copy).orElse(null);
        this.conditionsRId = other.optionalConditionsRId().map(LongFilter::copy).orElse(null);
        this.conditionsDId = other.optionalConditionsDId().map(LongFilter::copy).orElse(null);
        this.conditionsLocId = other.optionalConditionsLocId().map(LongFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public PromotionCriteria copy() {
        return new PromotionCriteria(this);
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

    public LocalDateFilter getStartDate() {
        return startDate;
    }

    public Optional<LocalDateFilter> optionalStartDate() {
        return Optional.ofNullable(startDate);
    }

    public LocalDateFilter startDate() {
        if (startDate == null) {
            setStartDate(new LocalDateFilter());
        }
        return startDate;
    }

    public void setStartDate(LocalDateFilter startDate) {
        this.startDate = startDate;
    }

    public LocalDateFilter getEndDate() {
        return endDate;
    }

    public Optional<LocalDateFilter> optionalEndDate() {
        return Optional.ofNullable(endDate);
    }

    public LocalDateFilter endDate() {
        if (endDate == null) {
            setEndDate(new LocalDateFilter());
        }
        return endDate;
    }

    public void setEndDate(LocalDateFilter endDate) {
        this.endDate = endDate;
    }

    public IntegerFilter getUsageLimit() {
        return usageLimit;
    }

    public Optional<IntegerFilter> optionalUsageLimit() {
        return Optional.ofNullable(usageLimit);
    }

    public IntegerFilter usageLimit() {
        if (usageLimit == null) {
            setUsageLimit(new IntegerFilter());
        }
        return usageLimit;
    }

    public void setUsageLimit(IntegerFilter usageLimit) {
        this.usageLimit = usageLimit;
    }

    public IntegerFilter getUsedCount() {
        return usedCount;
    }

    public Optional<IntegerFilter> optionalUsedCount() {
        return Optional.ofNullable(usedCount);
    }

    public IntegerFilter usedCount() {
        if (usedCount == null) {
            setUsedCount(new IntegerFilter());
        }
        return usedCount;
    }

    public void setUsedCount(IntegerFilter usedCount) {
        this.usedCount = usedCount;
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

    public LongFilter getBuyNGetMId() {
        return buyNGetMId;
    }

    public Optional<LongFilter> optionalBuyNGetMId() {
        return Optional.ofNullable(buyNGetMId);
    }

    public LongFilter buyNGetMId() {
        if (buyNGetMId == null) {
            setBuyNGetMId(new LongFilter());
        }
        return buyNGetMId;
    }

    public void setBuyNGetMId(LongFilter buyNGetMId) {
        this.buyNGetMId = buyNGetMId;
    }

    public LongFilter getPercentOffId() {
        return percentOffId;
    }

    public Optional<LongFilter> optionalPercentOffId() {
        return Optional.ofNullable(percentOffId);
    }

    public LongFilter percentOffId() {
        if (percentOffId == null) {
            setPercentOffId(new LongFilter());
        }
        return percentOffId;
    }

    public void setPercentOffId(LongFilter percentOffId) {
        this.percentOffId = percentOffId;
    }

    public LongFilter getConditionsRId() {
        return conditionsRId;
    }

    public Optional<LongFilter> optionalConditionsRId() {
        return Optional.ofNullable(conditionsRId);
    }

    public LongFilter conditionsRId() {
        if (conditionsRId == null) {
            setConditionsRId(new LongFilter());
        }
        return conditionsRId;
    }

    public void setConditionsRId(LongFilter conditionsRId) {
        this.conditionsRId = conditionsRId;
    }

    public LongFilter getConditionsDId() {
        return conditionsDId;
    }

    public Optional<LongFilter> optionalConditionsDId() {
        return Optional.ofNullable(conditionsDId);
    }

    public LongFilter conditionsDId() {
        if (conditionsDId == null) {
            setConditionsDId(new LongFilter());
        }
        return conditionsDId;
    }

    public void setConditionsDId(LongFilter conditionsDId) {
        this.conditionsDId = conditionsDId;
    }

    public LongFilter getConditionsLocId() {
        return conditionsLocId;
    }

    public Optional<LongFilter> optionalConditionsLocId() {
        return Optional.ofNullable(conditionsLocId);
    }

    public LongFilter conditionsLocId() {
        if (conditionsLocId == null) {
            setConditionsLocId(new LongFilter());
        }
        return conditionsLocId;
    }

    public void setConditionsLocId(LongFilter conditionsLocId) {
        this.conditionsLocId = conditionsLocId;
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
        final PromotionCriteria that = (PromotionCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(code, that.code) &&
            Objects.equals(description, that.description) &&
            Objects.equals(startDate, that.startDate) &&
            Objects.equals(endDate, that.endDate) &&
            Objects.equals(usageLimit, that.usageLimit) &&
            Objects.equals(usedCount, that.usedCount) &&
            Objects.equals(createdAt, that.createdAt) &&
            Objects.equals(updatedAt, that.updatedAt) &&
            Objects.equals(isDeleted, that.isDeleted) &&
            Objects.equals(deletedAt, that.deletedAt) &&
            Objects.equals(deletedBy, that.deletedBy) &&
            Objects.equals(buyNGetMId, that.buyNGetMId) &&
            Objects.equals(percentOffId, that.percentOffId) &&
            Objects.equals(conditionsRId, that.conditionsRId) &&
            Objects.equals(conditionsDId, that.conditionsDId) &&
            Objects.equals(conditionsLocId, that.conditionsLocId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            code,
            description,
            startDate,
            endDate,
            usageLimit,
            usedCount,
            createdAt,
            updatedAt,
            isDeleted,
            deletedAt,
            deletedBy,
            buyNGetMId,
            percentOffId,
            conditionsRId,
            conditionsDId,
            conditionsLocId,
            distinct
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PromotionCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalCode().map(f -> "code=" + f + ", ").orElse("") +
            optionalDescription().map(f -> "description=" + f + ", ").orElse("") +
            optionalStartDate().map(f -> "startDate=" + f + ", ").orElse("") +
            optionalEndDate().map(f -> "endDate=" + f + ", ").orElse("") +
            optionalUsageLimit().map(f -> "usageLimit=" + f + ", ").orElse("") +
            optionalUsedCount().map(f -> "usedCount=" + f + ", ").orElse("") +
            optionalCreatedAt().map(f -> "createdAt=" + f + ", ").orElse("") +
            optionalUpdatedAt().map(f -> "updatedAt=" + f + ", ").orElse("") +
            optionalIsDeleted().map(f -> "isDeleted=" + f + ", ").orElse("") +
            optionalDeletedAt().map(f -> "deletedAt=" + f + ", ").orElse("") +
            optionalDeletedBy().map(f -> "deletedBy=" + f + ", ").orElse("") +
            optionalBuyNGetMId().map(f -> "buyNGetMId=" + f + ", ").orElse("") +
            optionalPercentOffId().map(f -> "percentOffId=" + f + ", ").orElse("") +
            optionalConditionsRId().map(f -> "conditionsRId=" + f + ", ").orElse("") +
            optionalConditionsDId().map(f -> "conditionsDId=" + f + ", ").orElse("") +
            optionalConditionsLocId().map(f -> "conditionsLocId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
