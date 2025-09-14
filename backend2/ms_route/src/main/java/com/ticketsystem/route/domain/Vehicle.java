package com.ticketsystem.route.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Vehicle.
 */
@Entity
@Table(name = "vehicle")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "plate_number", nullable = false, unique = true)
    private String plateNumber;

    @Column(name = "model")
    private String model;

    @NotNull
    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @Column(name = "seat_layout")
    private String seatLayout;

    @Column(name = "amenities")
    private String amenities;

    @Column(name = "image_cover_url")
    private String imageCoverUrl;

    @Column(name = "average_rating")
    private Double averageRating;

    @Column(name = "total_reviews")
    private Integer totalReviews;

    @NotNull
    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @Column(name = "year_manufactured")
    private Integer yearManufactured;

    @Column(name = "last_maintenance_date")
    private LocalDate lastMaintenanceDate;

    @JsonIgnoreProperties(value = { "vehicle" }, allowSetters = true)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(unique = true)
    private ReviewSummary summary;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicle")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "vehicle" }, allowSetters = true)
    private Set<VehicleImage> images = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicle")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "vehicle" }, allowSetters = true)
    private Set<VehicleReview> reviews = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "vehicle")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "vehicle" }, allowSetters = true)
    private Set<VehicleAmenity> amenityItems = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Station homeStation;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "vehicles", "routes" }, allowSetters = true)
    private Operator operator;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Vehicle id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlateNumber() {
        return this.plateNumber;
    }

    public Vehicle plateNumber(String plateNumber) {
        this.setPlateNumber(plateNumber);
        return this;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getModel() {
        return this.model;
    }

    public Vehicle model(String model) {
        this.setModel(model);
        return this;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getCapacity() {
        return this.capacity;
    }

    public Vehicle capacity(Integer capacity) {
        this.setCapacity(capacity);
        return this;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getSeatLayout() {
        return this.seatLayout;
    }

    public Vehicle seatLayout(String seatLayout) {
        this.setSeatLayout(seatLayout);
        return this;
    }

    public void setSeatLayout(String seatLayout) {
        this.seatLayout = seatLayout;
    }

    public String getAmenities() {
        return this.amenities;
    }

    public Vehicle amenities(String amenities) {
        this.setAmenities(amenities);
        return this;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public String getImageCoverUrl() {
        return this.imageCoverUrl;
    }

    public Vehicle imageCoverUrl(String imageCoverUrl) {
        this.setImageCoverUrl(imageCoverUrl);
        return this;
    }

    public void setImageCoverUrl(String imageCoverUrl) {
        this.imageCoverUrl = imageCoverUrl;
    }

    public Double getAverageRating() {
        return this.averageRating;
    }

    public Vehicle averageRating(Double averageRating) {
        this.setAverageRating(averageRating);
        return this;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public Integer getTotalReviews() {
        return this.totalReviews;
    }

    public Vehicle totalReviews(Integer totalReviews) {
        this.setTotalReviews(totalReviews);
        return this;
    }

    public void setTotalReviews(Integer totalReviews) {
        this.totalReviews = totalReviews;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public Vehicle isActive(Boolean isActive) {
        this.setIsActive(isActive);
        return this;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Integer getYearManufactured() {
        return this.yearManufactured;
    }

    public Vehicle yearManufactured(Integer yearManufactured) {
        this.setYearManufactured(yearManufactured);
        return this;
    }

    public void setYearManufactured(Integer yearManufactured) {
        this.yearManufactured = yearManufactured;
    }

    public LocalDate getLastMaintenanceDate() {
        return this.lastMaintenanceDate;
    }

    public Vehicle lastMaintenanceDate(LocalDate lastMaintenanceDate) {
        this.setLastMaintenanceDate(lastMaintenanceDate);
        return this;
    }

    public void setLastMaintenanceDate(LocalDate lastMaintenanceDate) {
        this.lastMaintenanceDate = lastMaintenanceDate;
    }

    public ReviewSummary getSummary() {
        return this.summary;
    }

    public void setSummary(ReviewSummary reviewSummary) {
        this.summary = reviewSummary;
    }

    public Vehicle summary(ReviewSummary reviewSummary) {
        this.setSummary(reviewSummary);
        return this;
    }

    public Set<VehicleImage> getImages() {
        return this.images;
    }

    public void setImages(Set<VehicleImage> vehicleImages) {
        if (this.images != null) {
            this.images.forEach(i -> i.setVehicle(null));
        }
        if (vehicleImages != null) {
            vehicleImages.forEach(i -> i.setVehicle(this));
        }
        this.images = vehicleImages;
    }

    public Vehicle images(Set<VehicleImage> vehicleImages) {
        this.setImages(vehicleImages);
        return this;
    }

    public Vehicle addImages(VehicleImage vehicleImage) {
        this.images.add(vehicleImage);
        vehicleImage.setVehicle(this);
        return this;
    }

    public Vehicle removeImages(VehicleImage vehicleImage) {
        this.images.remove(vehicleImage);
        vehicleImage.setVehicle(null);
        return this;
    }

    public Set<VehicleReview> getReviews() {
        return this.reviews;
    }

    public void setReviews(Set<VehicleReview> vehicleReviews) {
        if (this.reviews != null) {
            this.reviews.forEach(i -> i.setVehicle(null));
        }
        if (vehicleReviews != null) {
            vehicleReviews.forEach(i -> i.setVehicle(this));
        }
        this.reviews = vehicleReviews;
    }

    public Vehicle reviews(Set<VehicleReview> vehicleReviews) {
        this.setReviews(vehicleReviews);
        return this;
    }

    public Vehicle addReviews(VehicleReview vehicleReview) {
        this.reviews.add(vehicleReview);
        vehicleReview.setVehicle(this);
        return this;
    }

    public Vehicle removeReviews(VehicleReview vehicleReview) {
        this.reviews.remove(vehicleReview);
        vehicleReview.setVehicle(null);
        return this;
    }

    public Set<VehicleAmenity> getAmenityItems() {
        return this.amenityItems;
    }

    public void setAmenityItems(Set<VehicleAmenity> vehicleAmenities) {
        if (this.amenityItems != null) {
            this.amenityItems.forEach(i -> i.setVehicle(null));
        }
        if (vehicleAmenities != null) {
            vehicleAmenities.forEach(i -> i.setVehicle(this));
        }
        this.amenityItems = vehicleAmenities;
    }

    public Vehicle amenityItems(Set<VehicleAmenity> vehicleAmenities) {
        this.setAmenityItems(vehicleAmenities);
        return this;
    }

    public Vehicle addAmenityItems(VehicleAmenity vehicleAmenity) {
        this.amenityItems.add(vehicleAmenity);
        vehicleAmenity.setVehicle(this);
        return this;
    }

    public Vehicle removeAmenityItems(VehicleAmenity vehicleAmenity) {
        this.amenityItems.remove(vehicleAmenity);
        vehicleAmenity.setVehicle(null);
        return this;
    }

    public Station getHomeStation() {
        return this.homeStation;
    }

    public void setHomeStation(Station station) {
        this.homeStation = station;
    }

    public Vehicle homeStation(Station station) {
        this.setHomeStation(station);
        return this;
    }

    public Operator getOperator() {
        return this.operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Vehicle operator(Operator operator) {
        this.setOperator(operator);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Vehicle)) {
            return false;
        }
        return getId() != null && getId().equals(((Vehicle) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Vehicle{" +
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
            "}";
    }
}
