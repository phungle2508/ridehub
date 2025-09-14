package com.ticketsystem.route.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/**
 * A VehicleReview.
 */
@Entity
@Table(name = "vehicle_review")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class VehicleReview implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "user_id", length = 36, nullable = false)
    private UUID userId;

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "trip_id", length = 36)
    private UUID tripId;

    @NotNull
    @Min(value = 1)
    @Max(value = 5)
    @Column(name = "rating", nullable = false)
    private Integer rating;

    @Column(name = "comment")
    private String comment;

    @Min(value = 1)
    @Max(value = 5)
    @Column(name = "cleanliness")
    private Integer cleanliness;

    @Min(value = 1)
    @Max(value = 5)
    @Column(name = "comfort")
    private Integer comfort;

    @Min(value = 1)
    @Max(value = 5)
    @Column(name = "punctuality")
    private Integer punctuality;

    @Min(value = 1)
    @Max(value = 5)
    @Column(name = "staff_service")
    private Integer staffService;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "is_verified")
    private Boolean isVerified;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "summary", "images", "reviews", "amenityItems", "homeStation", "operator" }, allowSetters = true)
    private Vehicle vehicle;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public VehicleReview id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUserId() {
        return this.userId;
    }

    public VehicleReview userId(UUID userId) {
        this.setUserId(userId);
        return this;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getTripId() {
        return this.tripId;
    }

    public VehicleReview tripId(UUID tripId) {
        this.setTripId(tripId);
        return this;
    }

    public void setTripId(UUID tripId) {
        this.tripId = tripId;
    }

    public Integer getRating() {
        return this.rating;
    }

    public VehicleReview rating(Integer rating) {
        this.setRating(rating);
        return this;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return this.comment;
    }

    public VehicleReview comment(String comment) {
        this.setComment(comment);
        return this;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getCleanliness() {
        return this.cleanliness;
    }

    public VehicleReview cleanliness(Integer cleanliness) {
        this.setCleanliness(cleanliness);
        return this;
    }

    public void setCleanliness(Integer cleanliness) {
        this.cleanliness = cleanliness;
    }

    public Integer getComfort() {
        return this.comfort;
    }

    public VehicleReview comfort(Integer comfort) {
        this.setComfort(comfort);
        return this;
    }

    public void setComfort(Integer comfort) {
        this.comfort = comfort;
    }

    public Integer getPunctuality() {
        return this.punctuality;
    }

    public VehicleReview punctuality(Integer punctuality) {
        this.setPunctuality(punctuality);
        return this;
    }

    public void setPunctuality(Integer punctuality) {
        this.punctuality = punctuality;
    }

    public Integer getStaffService() {
        return this.staffService;
    }

    public VehicleReview staffService(Integer staffService) {
        this.setStaffService(staffService);
        return this;
    }

    public void setStaffService(Integer staffService) {
        this.staffService = staffService;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public VehicleReview createdAt(Instant createdAt) {
        this.setCreatedAt(createdAt);
        return this;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getIsVerified() {
        return this.isVerified;
    }

    public VehicleReview isVerified(Boolean isVerified) {
        this.setIsVerified(isVerified);
        return this;
    }

    public void setIsVerified(Boolean isVerified) {
        this.isVerified = isVerified;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleReview vehicle(Vehicle vehicle) {
        this.setVehicle(vehicle);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VehicleReview)) {
            return false;
        }
        return getId() != null && getId().equals(((VehicleReview) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "VehicleReview{" +
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
            "}";
    }
}
