package com.ridehub.promotion.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import com.esotericsoftware.kryo.serializers.FieldSerializer.NotNull;

public class PromotionDetailDTO implements Serializable {
    private Long id;
    @NotNull
    private String code;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer usageLimit;
    private Integer usedCount;
    @NotNull
    private Instant createdAt;
    private Instant updatedAt;
    private Boolean isDeleted;
    private Instant deletedAt;
    private UUID deletedBy;

    private FilePromotionDTO bannerImg;

    // Add these (use your actual DTO types)
    private Set<BuyNGetMFreeDTO> buyNGetMS;
    private Set<PercentOffTotalDTO> percentOffs;

    private Set<ConditionByRouteDTO> conditionsRS;
    private Set<ConditionByDateDTO> conditionsDS;
    private Set<ConditionByLocationDTO> conditionsLocs;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getUsageLimit() {
        return this.usageLimit;
    }

    public void setUsageLimit(Integer usageLimit) {
        this.usageLimit = usageLimit;
    }

    public Integer getUsedCount() {
        return this.usedCount;
    }

    public void setUsedCount(Integer usedCount) {
        this.usedCount = usedCount;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean isIsDeleted() {
        return this.isDeleted;
    }

    public Boolean getIsDeleted() {
        return this.isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Instant getDeletedAt() {
        return this.deletedAt;
    }

    public void setDeletedAt(Instant deletedAt) {
        this.deletedAt = deletedAt;
    }

    public UUID getDeletedBy() {
        return this.deletedBy;
    }

    public void setDeletedBy(UUID deletedBy) {
        this.deletedBy = deletedBy;
    }

    public FilePromotionDTO getBannerImg() {
        return this.bannerImg;
    }

    public void setBannerImg(FilePromotionDTO bannerImg) {
        this.bannerImg = bannerImg;
    }

    public Set<BuyNGetMFreeDTO> getBuyNGetMS() {
        return this.buyNGetMS;
    }

    public void setBuyNGetMS(Set<BuyNGetMFreeDTO> buyNGetMS) {
        this.buyNGetMS = buyNGetMS;
    }

    public Set<PercentOffTotalDTO> getPercentOffs() {
        return this.percentOffs;
    }

    public void setPercentOffs(Set<PercentOffTotalDTO> percentOffs) {
        this.percentOffs = percentOffs;
    }

    public Set<ConditionByRouteDTO> getConditionsRS() {
        return this.conditionsRS;
    }

    public void setConditionsRS(Set<ConditionByRouteDTO> conditionsRS) {
        this.conditionsRS = conditionsRS;
    }

    public Set<ConditionByDateDTO> getConditionsDS() {
        return this.conditionsDS;
    }

    public void setConditionsDS(Set<ConditionByDateDTO> conditionsDS) {
        this.conditionsDS = conditionsDS;
    }

    public Set<ConditionByLocationDTO> getConditionsLocs() {
        return this.conditionsLocs;
    }

    public void setConditionsLocs(Set<ConditionByLocationDTO> conditionsLocs) {
        this.conditionsLocs = conditionsLocs;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", code='" + getCode() + "'" +
            ", description='" + getDescription() + "'" +
            ", startDate='" + getStartDate() + "'" +
            ", endDate='" + getEndDate() + "'" +
            ", usageLimit='" + getUsageLimit() + "'" +
            ", usedCount='" + getUsedCount() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            ", isDeleted='" + isIsDeleted() + "'" +
            ", deletedAt='" + getDeletedAt() + "'" +
            ", deletedBy='" + getDeletedBy() + "'" +
            ", bannerImg='" + getBannerImg() + "'" +
            ", buyNGetMS='" + getBuyNGetMS() + "'" +
            ", percentOffs='" + getPercentOffs() + "'" +
            ", conditionsRS='" + getConditionsRS() + "'" +
            ", conditionsDS='" + getConditionsDS() + "'" +
            ", conditionsLocs='" + getConditionsLocs() + "'" +
            "}";
    }

}
