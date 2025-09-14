package com.ticketsystem.route.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link com.ticketsystem.route.domain.ReviewSummary} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ReviewSummaryDTO implements Serializable {

    private Long id;

    private Double averageRating;

    private Integer totalReviews;

    @NotNull
    private Instant updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ReviewSummaryDTO)) {
            return false;
        }

        ReviewSummaryDTO reviewSummaryDTO = (ReviewSummaryDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, reviewSummaryDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ReviewSummaryDTO{" +
            "id=" + getId() +
            ", averageRating=" + getAverageRating() +
            ", totalReviews=" + getTotalReviews() +
            ", updatedAt='" + getUpdatedAt() + "'" +
            "}";
    }
}
