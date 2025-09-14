package com.ticketsystem.route.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A VehicleAmenity.
 */
@Entity
@Table(name = "vehicle_amenity")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class VehicleAmenity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "amenity", nullable = false)
    private String amenity;

    @Column(name = "description")
    private String description;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "summary", "images", "reviews", "amenityItems", "homeStation", "operator" }, allowSetters = true)
    private Vehicle vehicle;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public VehicleAmenity id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAmenity() {
        return this.amenity;
    }

    public VehicleAmenity amenity(String amenity) {
        this.setAmenity(amenity);
        return this;
    }

    public void setAmenity(String amenity) {
        this.amenity = amenity;
    }

    public String getDescription() {
        return this.description;
    }

    public VehicleAmenity description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleAmenity vehicle(Vehicle vehicle) {
        this.setVehicle(vehicle);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VehicleAmenity)) {
            return false;
        }
        return getId() != null && getId().equals(((VehicleAmenity) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "VehicleAmenity{" +
            "id=" + getId() +
            ", amenity='" + getAmenity() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
