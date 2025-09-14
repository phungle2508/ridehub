package com.ticketsystem.route.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link com.ticketsystem.route.domain.Vehicle} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class VehicleDTO implements Serializable {

    private Long id;

    @NotNull
    private String plateNumber;

    private String model;

    @NotNull
    private Integer capacity;

    private String seatLayout;

    private String amenities;

    private String imageCoverUrl;

    private Double averageRating;

    private Integer totalReviews;

    @NotNull
    private Boolean isActive;

    private Integer yearManufactured;

    private LocalDate lastMaintenanceDate;

    private ReviewSummaryDTO summary;

    private StationDTO homeStation;

    @NotNull
    private OperatorDTO operator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getSeatLayout() {
        return seatLayout;
    }

    public void setSeatLayout(String seatLayout) {
        this.seatLayout = seatLayout;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public String getImageCoverUrl() {
        return imageCoverUrl;
    }

    public void setImageCoverUrl(String imageCoverUrl) {
        this.imageCoverUrl = imageCoverUrl;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public Integer getTotalReviews() {
        return totalReviews;
    }

    public void setTotalReviews(Integer totalReviews) {
        this.totalReviews = totalReviews;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Integer getYearManufactured() {
        return yearManufactured;
    }

    public void setYearManufactured(Integer yearManufactured) {
        this.yearManufactured = yearManufactured;
    }

    public LocalDate getLastMaintenanceDate() {
        return lastMaintenanceDate;
    }

    public void setLastMaintenanceDate(LocalDate lastMaintenanceDate) {
        this.lastMaintenanceDate = lastMaintenanceDate;
    }

    public ReviewSummaryDTO getSummary() {
        return summary;
    }

    public void setSummary(ReviewSummaryDTO summary) {
        this.summary = summary;
    }

    public StationDTO getHomeStation() {
        return homeStation;
    }

    public void setHomeStation(StationDTO homeStation) {
        this.homeStation = homeStation;
    }

    public OperatorDTO getOperator() {
        return operator;
    }

    public void setOperator(OperatorDTO operator) {
        this.operator = operator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VehicleDTO)) {
            return false;
        }

        VehicleDTO vehicleDTO = (VehicleDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, vehicleDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "VehicleDTO{" +
            "id=" + getId() +
            ", plateNumber='" + getPlateNumber() + "'" +
            ", model='" + getModel() + "'" +
            ", capacity=" + getCapacity() +
            ", seatLayout='" + getSeatLayout() + "'" +
            ", amenities='" + getAmenities() + "'" +
            ", imageCoverUrl='" + getImageCoverUrl() + "'" +
            ", averageRating=" + getAverageRating() +
            ", totalReviews=" + getTotalReviews() +
            ", isActive='" + getIsActive() + "'" +
            ", yearManufactured=" + getYearManufactured() +
            ", lastMaintenanceDate='" + getLastMaintenanceDate() + "'" +
            ", summary=" + getSummary() +
            ", homeStation=" + getHomeStation() +
            ", operator=" + getOperator() +
            "}";
    }
}
