package com.ridehub.promotion.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

/**
 * A DTO for the {@link com.ridehub.promotion.domain.ConditionLocationItem} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ConditionLocationItemDTO implements Serializable {

    private Long id;

    private UUID provinceId;

    private UUID districtId;

    private UUID wardId;

    @NotNull
    private Instant createdAt;

    private Instant updatedAt;

    private Boolean isDeleted;

    private Instant deletedAt;

    private UUID deletedBy;

    @NotNull
    private ConditionByLocationDTO condition;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(UUID provinceId) {
        this.provinceId = provinceId;
    }

    public UUID getDistrictId() {
        return districtId;
    }

    public void setDistrictId(UUID districtId) {
        this.districtId = districtId;
    }

    public UUID getWardId() {
        return wardId;
    }

    public void setWardId(UUID wardId) {
        this.wardId = wardId;
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

    public ConditionByLocationDTO getCondition() {
        return condition;
    }

    public void setCondition(ConditionByLocationDTO condition) {
        this.condition = condition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ConditionLocationItemDTO)) {
            return false;
        }

        ConditionLocationItemDTO conditionLocationItemDTO = (ConditionLocationItemDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, conditionLocationItemDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ConditionLocationItemDTO{" +
            "id=" + getId() +
            ", provinceId='" + getProvinceId() + "'" +
            ", districtId='" + getDistrictId() + "'" +
            ", wardId='" + getWardId() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            ", isDeleted='" + getIsDeleted() + "'" +
            ", deletedAt='" + getDeletedAt() + "'" +
            ", deletedBy='" + getDeletedBy() + "'" +
            ", condition=" + getCondition() +
            "}";
    }
}
