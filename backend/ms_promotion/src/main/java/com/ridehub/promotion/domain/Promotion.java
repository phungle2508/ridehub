package com.ridehub.promotion.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/**
 * A Promotion.
 */
@Entity
@Table(name = "promotion")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Promotion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "usage_limit")
    private Integer usageLimit;

    @Column(name = "used_count")
    private Integer usedCount;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "deleted_by", length = 36)
    private UUID deletedBy;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "promotion")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "promotion" }, allowSetters = true)
    private Set<BuyNGetMFree> buyNGetMS = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "promotion")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "promotion" }, allowSetters = true)
    private Set<PercentOffTotal> percentOffs = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "promotion")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "promotion" }, allowSetters = true)
    private Set<ConditionByRoute> conditionsRS = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "promotion")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "promotion" }, allowSetters = true)
    private Set<ConditionByDate> conditionsDS = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "promotion")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "promotion" }, allowSetters = true)
    private Set<ConditionByLocation> conditionsLocs = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Promotion id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public Promotion code(String code) {
        this.setCode(code);
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return this.description;
    }

    public Promotion description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public Promotion startDate(LocalDate startDate) {
        this.setStartDate(startDate);
        return this;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public Promotion endDate(LocalDate endDate) {
        this.setEndDate(endDate);
        return this;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getUsageLimit() {
        return this.usageLimit;
    }

    public Promotion usageLimit(Integer usageLimit) {
        this.setUsageLimit(usageLimit);
        return this;
    }

    public void setUsageLimit(Integer usageLimit) {
        this.usageLimit = usageLimit;
    }

    public Integer getUsedCount() {
        return this.usedCount;
    }

    public Promotion usedCount(Integer usedCount) {
        this.setUsedCount(usedCount);
        return this;
    }

    public void setUsedCount(Integer usedCount) {
        this.usedCount = usedCount;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public Promotion createdAt(Instant createdAt) {
        this.setCreatedAt(createdAt);
        return this;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    public Promotion updatedAt(Instant updatedAt) {
        this.setUpdatedAt(updatedAt);
        return this;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getIsDeleted() {
        return this.isDeleted;
    }

    public Promotion isDeleted(Boolean isDeleted) {
        this.setIsDeleted(isDeleted);
        return this;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Instant getDeletedAt() {
        return this.deletedAt;
    }

    public Promotion deletedAt(Instant deletedAt) {
        this.setDeletedAt(deletedAt);
        return this;
    }

    public void setDeletedAt(Instant deletedAt) {
        this.deletedAt = deletedAt;
    }

    public UUID getDeletedBy() {
        return this.deletedBy;
    }

    public Promotion deletedBy(UUID deletedBy) {
        this.setDeletedBy(deletedBy);
        return this;
    }

    public void setDeletedBy(UUID deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Set<BuyNGetMFree> getBuyNGetMS() {
        return this.buyNGetMS;
    }

    public void setBuyNGetMS(Set<BuyNGetMFree> buyNGetMFrees) {
        if (this.buyNGetMS != null) {
            this.buyNGetMS.forEach(i -> i.setPromotion(null));
        }
        if (buyNGetMFrees != null) {
            buyNGetMFrees.forEach(i -> i.setPromotion(this));
        }
        this.buyNGetMS = buyNGetMFrees;
    }

    public Promotion buyNGetMS(Set<BuyNGetMFree> buyNGetMFrees) {
        this.setBuyNGetMS(buyNGetMFrees);
        return this;
    }

    public Promotion addBuyNGetM(BuyNGetMFree buyNGetMFree) {
        this.buyNGetMS.add(buyNGetMFree);
        buyNGetMFree.setPromotion(this);
        return this;
    }

    public Promotion removeBuyNGetM(BuyNGetMFree buyNGetMFree) {
        this.buyNGetMS.remove(buyNGetMFree);
        buyNGetMFree.setPromotion(null);
        return this;
    }

    public Set<PercentOffTotal> getPercentOffs() {
        return this.percentOffs;
    }

    public void setPercentOffs(Set<PercentOffTotal> percentOffTotals) {
        if (this.percentOffs != null) {
            this.percentOffs.forEach(i -> i.setPromotion(null));
        }
        if (percentOffTotals != null) {
            percentOffTotals.forEach(i -> i.setPromotion(this));
        }
        this.percentOffs = percentOffTotals;
    }

    public Promotion percentOffs(Set<PercentOffTotal> percentOffTotals) {
        this.setPercentOffs(percentOffTotals);
        return this;
    }

    public Promotion addPercentOff(PercentOffTotal percentOffTotal) {
        this.percentOffs.add(percentOffTotal);
        percentOffTotal.setPromotion(this);
        return this;
    }

    public Promotion removePercentOff(PercentOffTotal percentOffTotal) {
        this.percentOffs.remove(percentOffTotal);
        percentOffTotal.setPromotion(null);
        return this;
    }

    public Set<ConditionByRoute> getConditionsRS() {
        return this.conditionsRS;
    }

    public void setConditionsRS(Set<ConditionByRoute> conditionByRoutes) {
        if (this.conditionsRS != null) {
            this.conditionsRS.forEach(i -> i.setPromotion(null));
        }
        if (conditionByRoutes != null) {
            conditionByRoutes.forEach(i -> i.setPromotion(this));
        }
        this.conditionsRS = conditionByRoutes;
    }

    public Promotion conditionsRS(Set<ConditionByRoute> conditionByRoutes) {
        this.setConditionsRS(conditionByRoutes);
        return this;
    }

    public Promotion addConditionsR(ConditionByRoute conditionByRoute) {
        this.conditionsRS.add(conditionByRoute);
        conditionByRoute.setPromotion(this);
        return this;
    }

    public Promotion removeConditionsR(ConditionByRoute conditionByRoute) {
        this.conditionsRS.remove(conditionByRoute);
        conditionByRoute.setPromotion(null);
        return this;
    }

    public Set<ConditionByDate> getConditionsDS() {
        return this.conditionsDS;
    }

    public void setConditionsDS(Set<ConditionByDate> conditionByDates) {
        if (this.conditionsDS != null) {
            this.conditionsDS.forEach(i -> i.setPromotion(null));
        }
        if (conditionByDates != null) {
            conditionByDates.forEach(i -> i.setPromotion(this));
        }
        this.conditionsDS = conditionByDates;
    }

    public Promotion conditionsDS(Set<ConditionByDate> conditionByDates) {
        this.setConditionsDS(conditionByDates);
        return this;
    }

    public Promotion addConditionsD(ConditionByDate conditionByDate) {
        this.conditionsDS.add(conditionByDate);
        conditionByDate.setPromotion(this);
        return this;
    }

    public Promotion removeConditionsD(ConditionByDate conditionByDate) {
        this.conditionsDS.remove(conditionByDate);
        conditionByDate.setPromotion(null);
        return this;
    }

    public Set<ConditionByLocation> getConditionsLocs() {
        return this.conditionsLocs;
    }

    public void setConditionsLocs(Set<ConditionByLocation> conditionByLocations) {
        if (this.conditionsLocs != null) {
            this.conditionsLocs.forEach(i -> i.setPromotion(null));
        }
        if (conditionByLocations != null) {
            conditionByLocations.forEach(i -> i.setPromotion(this));
        }
        this.conditionsLocs = conditionByLocations;
    }

    public Promotion conditionsLocs(Set<ConditionByLocation> conditionByLocations) {
        this.setConditionsLocs(conditionByLocations);
        return this;
    }

    public Promotion addConditionsLoc(ConditionByLocation conditionByLocation) {
        this.conditionsLocs.add(conditionByLocation);
        conditionByLocation.setPromotion(this);
        return this;
    }

    public Promotion removeConditionsLoc(ConditionByLocation conditionByLocation) {
        this.conditionsLocs.remove(conditionByLocation);
        conditionByLocation.setPromotion(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Promotion)) {
            return false;
        }
        return getId() != null && getId().equals(((Promotion) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Promotion{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", description='" + getDescription() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", usageLimit=" + getUsageLimit() +
            ", usedCount=" + getUsedCount() +
            ", createdAt='" + getCreatedAt() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            ", isDeleted='" + getIsDeleted() + "'" +
            ", deletedAt='" + getDeletedAt() + "'" +
            ", deletedBy='" + getDeletedBy() + "'" +
            "}";
    }
}
