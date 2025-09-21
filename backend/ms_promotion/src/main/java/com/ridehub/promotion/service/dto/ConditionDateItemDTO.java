package com.ridehub.promotion.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

/**
 * A DTO for the {@link com.ridehub.promotion.domain.ConditionDateItem} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ConditionDateItemDTO implements Serializable {

    private Long id;

    private LocalDate specificDate;

    private Integer weekday;

    @NotNull
    private Instant createdAt;

    private Instant updatedAt;

    private Boolean isDeleted;

    private Instant deletedAt;

    private UUID deletedBy;

    @NotNull
    private ConditionByDateDTO condition;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getSpecificDate() {
        return specificDate;
    }

    public void setSpecificDate(LocalDate specificDate) {
        this.specificDate = specificDate;
    }

    public Integer getWeekday() {
        return weekday;
    }

    public void setWeekday(Integer weekday) {
        this.weekday = weekday;
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

    public ConditionByDateDTO getCondition() {
        return condition;
    }

    public void setCondition(ConditionByDateDTO condition) {
        this.condition = condition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ConditionDateItemDTO)) {
            return false;
        }

        ConditionDateItemDTO conditionDateItemDTO = (ConditionDateItemDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, conditionDateItemDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ConditionDateItemDTO{" +
            "id=" + getId() +
            ", specificDate='" + getSpecificDate() + "'" +
            ", weekday=" + getWeekday() +
            ", createdAt='" + getCreatedAt() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            ", isDeleted='" + getIsDeleted() + "'" +
            ", deletedAt='" + getDeletedAt() + "'" +
            ", deletedBy='" + getDeletedBy() + "'" +
            ", condition=" + getCondition() +
            "}";
    }
}
