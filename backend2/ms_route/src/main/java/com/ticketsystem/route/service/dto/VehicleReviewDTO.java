package com.ticketsystem.route.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

/**
 * A DTO for the {@link com.ticketsystem.route.domain.VehicleReview} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class VehicleReviewDTO implements Serializable {

    private Long id;

    @NotNull
    private UUID userId;

    private UUID tripId;

    @NotNull
    @Min(value = 1)
    @Max(value = 5)
    private Integer rating;

    private String comment;

    @Min(value = 1)
    @Max(value = 5)
    private Integer cleanliness;

    @Min(value = 1)
    @Max(value = 5)
    private Integer comfort;

    @Min(value = 1)
    @Max(value = 5)
    private Integer punctuality;

    @Min(value = 1)
    @Max(value = 5)
    private Integer staffService;

    @NotNull
    private Instant createdAt;

    private Boolean isVerified;

    @NotNull
    private VehicleDTO vehicle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getTripId() {
        return tripId;
    }

    public void setTripId(UUID tripId) {
        this.tripId = tripId;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(Integer cleanliness) {
        this.cleanliness = cleanliness;
    }

    public Integer getComfort() {
        return comfort;
    }

    public void setComfort(Integer comfort) {
        this.comfort = comfort;
    }

    public Integer getPunctuality() {
        return punctuality;
    }

    public void setPunctuality(Integer punctuality) {
        this.punctuality = punctuality;
    }

    public Integer getStaffService() {
        return staffService;
    }

    public void setStaffService(Integer staffService) {
        this.staffService = staffService;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getIsVerified() {
        return isVerified;
    }

    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }

    public VehicleDTO getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDTO vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VehicleReviewDTO)) {
            return false;
        }

        VehicleReviewDTO vehicleReviewDTO = (VehicleReviewDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, vehicleReviewDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "VehicleReviewDTO{" +
            "id=" + getId() +
            ", userId='" + getUserId() + "'" +
            ", tripId='" + getTripId() + "'" +
            ", rating=" + getRating() +
            ", comment='" + getComment() + "'" +
            ", cleanliness=" + getCleanliness() +
            ", comfort=" + getComfort() +
            ", punctuality=" + getPunctuality() +
            ", staffService=" + getStaffService() +
            ", createdAt='" + getCreatedAt() + "'" +
            ", isVerified='" + getIsVerified() + "'" +
            ", vehicle=" + getVehicle() +
            "}";
    }
}
