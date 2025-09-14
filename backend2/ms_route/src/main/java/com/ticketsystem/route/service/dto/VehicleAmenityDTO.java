package com.ticketsystem.route.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.ticketsystem.route.domain.VehicleAmenity} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class VehicleAmenityDTO implements Serializable {

    private Long id;

    @NotNull
    private String amenity;

    private String description;

    @NotNull
    private VehicleDTO vehicle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAmenity() {
        return amenity;
    }

    public void setAmenity(String amenity) {
        this.amenity = amenity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(o instanceof VehicleAmenityDTO)) {
            return false;
        }

        VehicleAmenityDTO vehicleAmenityDTO = (VehicleAmenityDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, vehicleAmenityDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "VehicleAmenityDTO{" +
            "id=" + getId() +
            ", amenity='" + getAmenity() + "'" +
            ", description='" + getDescription() + "'" +
            ", vehicle=" + getVehicle() +
            "}";
    }
}
