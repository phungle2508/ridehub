package com.ticketsystem.route.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Operator.
 */
@Entity
@Table(name = "operator")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Operator implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "business_license")
    private String businessLicense;

    @Column(name = "logo_url")
    private String logoUrl;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "contact_phone")
    private String contactPhone;

    @Column(name = "contact_email")
    private String contactEmail;

    @NotNull
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "operator")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "summary", "images", "reviews", "amenityItems", "homeStation", "operator" }, allowSetters = true)
    private Set<Vehicle> vehicles = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "operator")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "trips", "origin", "destination", "operator" }, allowSetters = true)
    private Set<Route> routes = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Operator id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public Operator name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusinessLicense() {
        return this.businessLicense;
    }

    public Operator businessLicense(String businessLicense) {
        this.setBusinessLicense(businessLicense);
        return this;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public String getLogoUrl() {
        return this.logoUrl;
    }

    public Operator logoUrl(String logoUrl) {
        this.setLogoUrl(logoUrl);
        return this;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Double getRating() {
        return this.rating;
    }

    public Operator rating(Double rating) {
        this.setRating(rating);
        return this;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getContactPhone() {
        return this.contactPhone;
    }

    public Operator contactPhone(String contactPhone) {
        this.setContactPhone(contactPhone);
        return this;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactEmail() {
        return this.contactEmail;
    }

    public Operator contactEmail(String contactEmail) {
        this.setContactEmail(contactEmail);
        return this;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public Operator isActive(Boolean isActive) {
        this.setIsActive(isActive);
        return this;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Set<Vehicle> getVehicles() {
        return this.vehicles;
    }

    public void setVehicles(Set<Vehicle> vehicles) {
        if (this.vehicles != null) {
            this.vehicles.forEach(i -> i.setOperator(null));
        }
        if (vehicles != null) {
            vehicles.forEach(i -> i.setOperator(this));
        }
        this.vehicles = vehicles;
    }

    public Operator vehicles(Set<Vehicle> vehicles) {
        this.setVehicles(vehicles);
        return this;
    }

    public Operator addVehicles(Vehicle vehicle) {
        this.vehicles.add(vehicle);
        vehicle.setOperator(this);
        return this;
    }

    public Operator removeVehicles(Vehicle vehicle) {
        this.vehicles.remove(vehicle);
        vehicle.setOperator(null);
        return this;
    }

    public Set<Route> getRoutes() {
        return this.routes;
    }

    public void setRoutes(Set<Route> routes) {
        if (this.routes != null) {
            this.routes.forEach(i -> i.setOperator(null));
        }
        if (routes != null) {
            routes.forEach(i -> i.setOperator(this));
        }
        this.routes = routes;
    }

    public Operator routes(Set<Route> routes) {
        this.setRoutes(routes);
        return this;
    }

    public Operator addRoutes(Route route) {
        this.routes.add(route);
        route.setOperator(this);
        return this;
    }

    public Operator removeRoutes(Route route) {
        this.routes.remove(route);
        route.setOperator(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Operator)) {
            return false;
        }
        return getId() != null && getId().equals(((Operator) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Operator{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", businessLicense='" + getBusinessLicense() + "'" +
            ", logoUrl='" + getLogoUrl() + "'" +
            ", rating=" + getRating() +
            ", contactPhone='" + getContactPhone() + "'" +
            ", contactEmail='" + getContactEmail() + "'" +
            ", isActive='" + getIsActive() + "'" +
            "}";
    }
}
