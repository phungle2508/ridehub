package com.ticketsystem.route.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/**
 * A Trip.
 */
@Entity
@Table(name = "trip")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Trip implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "departure_time", nullable = false)
    private Instant departureTime;

    @NotNull
    @Column(name = "arrival_time", nullable = false)
    private Instant arrivalTime;

    @NotNull
    @Column(name = "available_seats", nullable = false)
    private Integer availableSeats;

    @NotNull
    @Column(name = "total_seats", nullable = false)
    private Integer totalSeats;

    @Column(name = "status")
    private String status;

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "driver_id", length = 36)
    private UUID driverId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "trip")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "trip" }, allowSetters = true)
    private Set<Seat> seats = new HashSet<>();

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "trips", "origin", "destination", "operator" }, allowSetters = true)
    private Route route;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Trip id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDepartureTime() {
        return this.departureTime;
    }

    public Trip departureTime(Instant departureTime) {
        this.setDepartureTime(departureTime);
        return this;
    }

    public void setDepartureTime(Instant departureTime) {
        this.departureTime = departureTime;
    }

    public Instant getArrivalTime() {
        return this.arrivalTime;
    }

    public Trip arrivalTime(Instant arrivalTime) {
        this.setArrivalTime(arrivalTime);
        return this;
    }

    public void setArrivalTime(Instant arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Integer getAvailableSeats() {
        return this.availableSeats;
    }

    public Trip availableSeats(Integer availableSeats) {
        this.setAvailableSeats(availableSeats);
        return this;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Integer getTotalSeats() {
        return this.totalSeats;
    }

    public Trip totalSeats(Integer totalSeats) {
        this.setTotalSeats(totalSeats);
        return this;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String getStatus() {
        return this.status;
    }

    public Trip status(String status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UUID getDriverId() {
        return this.driverId;
    }

    public Trip driverId(UUID driverId) {
        this.setDriverId(driverId);
        return this;
    }

    public void setDriverId(UUID driverId) {
        this.driverId = driverId;
    }

    public Set<Seat> getSeats() {
        return this.seats;
    }

    public void setSeats(Set<Seat> seats) {
        if (this.seats != null) {
            this.seats.forEach(i -> i.setTrip(null));
        }
        if (seats != null) {
            seats.forEach(i -> i.setTrip(this));
        }
        this.seats = seats;
    }

    public Trip seats(Set<Seat> seats) {
        this.setSeats(seats);
        return this;
    }

    public Trip addSeats(Seat seat) {
        this.seats.add(seat);
        seat.setTrip(this);
        return this;
    }

    public Trip removeSeats(Seat seat) {
        this.seats.remove(seat);
        seat.setTrip(null);
        return this;
    }

    public Route getRoute() {
        return this.route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Trip route(Route route) {
        this.setRoute(route);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Trip)) {
            return false;
        }
        return getId() != null && getId().equals(((Trip) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Trip{" +
            "id=" + getId() +
            ", departureTime='" + getDepartureTime() + "'" +
            ", arrivalTime='" + getArrivalTime() + "'" +
            ", availableSeats=" + getAvailableSeats() +
            ", totalSeats=" + getTotalSeats() +
            ", status='" + getStatus() + "'" +
            ", driverId='" + getDriverId() + "'" +
            "}";
    }
}
