package com.ticketsystem.route.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link com.ticketsystem.route.domain.VehicleImage} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class VehicleImageDTO implements Serializable {

    private Long id;

    @NotNull
    private String imageUrl;

    @NotNull
    private String imageType;

    private String description;

    private Boolean isPrimary;

    @NotNull
    private Instant uploadedAt;

    @NotNull
    private VehicleDTO vehicle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsPrimary() {
        return isPrimary;
    }

    public void setIsPrimary(Boolean isPrimary) {
        this.isPrimary = isPrimary;
    }

    public Instant getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(Instant uploadedAt) {
        this.uploadedAt = uploadedAt;
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
        if (!(o instanceof VehicleImageDTO)) {
            return false;
        }

        VehicleImageDTO vehicleImageDTO = (VehicleImageDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, vehicleImageDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "VehicleImageDTO{" +
            "id=" + getId() +
            ", imageUrl='" + getImageUrl() + "'" +
            ", imageType='" + getImageType() + "'" +
            ", description='" + getDescription() + "'" +
            ", isPrimary='" + getIsPrimary() + "'" +
            ", uploadedAt='" + getUploadedAt() + "'" +
            ", vehicle=" + getVehicle() +
            "}";
    }
}
