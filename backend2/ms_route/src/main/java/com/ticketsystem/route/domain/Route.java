package com.ticketsystem.route.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ticketsystem.route.domain.enumeration.TransportType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Route.
 */
@Entity
@Table(name = "route")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@org.springframework.data.elasticsearch.annotations.Document(indexName = "route")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Route implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "transport_type", nullable = false)
    @org.springframework.data.elasticsearch.annotations.Field(type = org.springframework.data.elasticsearch.annotations.FieldType.Keyword)
    private TransportType transportType;

    @Column(name = "distance", precision = 21, scale = 2)
    private BigDecimal distance;

    @Column(name = "estimated_duration")
    @org.springframework.data.elasticsearch.annotations.Field(type = org.springframework.data.elasticsearch.annotations.FieldType.Integer)
    private Integer estimatedDuration;

    @NotNull
    @Column(name = "base_price", precision = 21, scale = 2, nullable = false)
    private BigDecimal basePrice;

    @NotNull
    @Column(name = "is_active", nullable = false)
    @org.springframework.data.elasticsearch.annotations.Field(type = org.springframework.data.elasticsearch.annotations.FieldType.Boolean)
    private Boolean isActive;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "route")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @org.springframework.data.annotation.Transient
    @JsonIgnoreProperties(value = { "seats", "route" }, allowSetters = true)
    private Set<Trip> trips = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Station origin;

    @ManyToOne(fetch = FetchType.LAZY)
    private Station destination;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "vehicles", "routes" }, allowSetters = true)
    private Operator operator;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Route id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TransportType getTransportType() {
        return this.transportType;
    }

    public Route transportType(TransportType transportType) {
        this.setTransportType(transportType);
        return this;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public BigDecimal getDistance() {
        return this.distance;
    }

    public Route distance(BigDecimal distance) {
        this.setDistance(distance);
        return this;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public Integer getEstimatedDuration() {
        return this.estimatedDuration;
    }

    public Route estimatedDuration(Integer estimatedDuration) {
        this.setEstimatedDuration(estimatedDuration);
        return this;
    }

    public void setEstimatedDuration(Integer estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }

    public BigDecimal getBasePrice() {
        return this.basePrice;
    }

    public Route basePrice(BigDecimal basePrice) {
        this.setBasePrice(basePrice);
        return this;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public Route isActive(Boolean isActive) {
        this.setIsActive(isActive);
        return this;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Set<Trip> getTrips() {
        return this.trips;
    }

    public void setTrips(Set<Trip> trips) {
        if (this.trips != null) {
            this.trips.forEach(i -> i.setRoute(null));
        }
        if (trips != null) {
            trips.forEach(i -> i.setRoute(this));
        }
        this.trips = trips;
    }

    public Route trips(Set<Trip> trips) {
        this.setTrips(trips);
        return this;
    }

    public Route addTrips(Trip trip) {
        this.trips.add(trip);
        trip.setRoute(this);
        return this;
    }

    public Route removeTrips(Trip trip) {
        this.trips.remove(trip);
        trip.setRoute(null);
        return this;
    }

    public Station getOrigin() {
        return this.origin;
    }

    public void setOrigin(Station station) {
        this.origin = station;
    }

    public Route origin(Station station) {
        this.setOrigin(station);
        return this;
    }

    public Station getDestination() {
        return this.destination;
    }

    public void setDestination(Station station) {
        this.destination = station;
    }

    public Route destination(Station station) {
        this.setDestination(station);
        return this;
    }

    public Operator getOperator() {
        return this.operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Route operator(Operator operator) {
        this.setOperator(operator);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Route)) {
            return false;
        }
        return getId() != null && getId().equals(((Route) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Route{" +
            "id=" + getId() +
            ", transportType='" + getTransportType() + "'" +
            ", distance=" + getDistance() +
            ", estimatedDuration=" + getEstimatedDuration() +
            ", basePrice=" + getBasePrice() +
            ", isActive='" + getIsActive() + "'" +
            "}";
    }
}
