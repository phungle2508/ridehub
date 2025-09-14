package com.ticketsystem.route.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A ReviewSummary.
 */
@Entity
@Table(name = "review_summary")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ReviewSummary implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "average_rating")
    private Double averageRating;

    @Column(name = "total_reviews")
    private Integer totalReviews;

    @NotNull
    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @JsonIgnoreProperties(value = { "summary", "images", "reviews", "amenityItems", "homeStation", "operator" }, allowSetters = true)
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "summary")
    private Vehicle vehicle;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public ReviewSummary id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAverageRating() {
        return this.averageRating;
    }

    public ReviewSummary averageRating(Double averageRating) {
        this.setAverageRating(averageRating);
        return this;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public Integer getTotalReviews() {
        return this.totalReviews;
    }

    public ReviewSummary totalReviews(Integer totalReviews) {
        this.setTotalReviews(totalReviews);
        return this;
    }

    public void setTotalReviews(Integer totalReviews) {
        this.totalReviews = totalReviews;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    public ReviewSummary updatedAt(Instant updatedAt) {
        this.setUpdatedAt(updatedAt);
        return this;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        if (this.vehicle != null) {
            this.vehicle.setSummary(null);
        }
        if (vehicle != null) {
            vehicle.setSummary(this);
        }
        this.vehicle = vehicle;
    }

    public ReviewSummary vehicle(Vehicle vehicle) {
        this.setVehicle(vehicle);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ReviewSummary)) {
            return false;
        }
        return getId() != null && getId().equals(((ReviewSummary) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ReviewSummary{" +
            "id=" + getId() +
            ", averageRating=" + getAverageRating() +
            ", totalReviews=" + getTotalReviews() +
            ", updatedAt='" + getUpdatedAt() + "'" +
            "}";
    }
}
