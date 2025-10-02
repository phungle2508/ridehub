package com.ridehub.promotion.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

/**
 * A DTO for the {@link com.ridehub.promotion.domain.PercentOffTotal} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class PercentOffTotalDTO implements Serializable {

    private Long id;

    @NotNull
    @Min(value = 1)
    @Max(value = 100)
    private Integer percent;

    private BigDecimal maxOff;

    private BigDecimal minPrice;

    @NotNull
    private Instant createdAt;

    private Instant updatedAt;

    private Boolean isDeleted;

    private Instant deletedAt;

    private UUID deletedBy;

    @NotNull
    private PromotionDTO promotion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    public BigDecimal getMaxOff() {
        return maxOff;
    }

    public void setMaxOff(BigDecimal maxOff) {
        this.maxOff = maxOff;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Instant deletedAt) {
        this.deletedAt = deletedAt;
    }

    public UUID getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(UUID deletedBy) {
        this.deletedBy = deletedBy;
    }

    public PromotionDTO getPromotion() {
        return promotion;
    }

    public void setPromotion(PromotionDTO promotion) {
        this.promotion = promotion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PercentOffTotalDTO)) {
            return false;
        }

        PercentOffTotalDTO percentOffTotalDTO = (PercentOffTotalDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, percentOffTotalDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PercentOffTotalDTO{" +
            "id=" + getId() +
            ", percent=" + getPercent() +
            ", maxOff=" + getMaxOff() +
            ", minPrice=" + getMinPrice() +
            ", createdAt='" + getCreatedAt() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            ", isDeleted='" + getIsDeleted() + "'" +
            ", deletedAt='" + getDeletedAt() + "'" +
            ", deletedBy='" + getDeletedBy() + "'" +
            ", promotion=" + getPromotion() +
            "}";
    }
}
