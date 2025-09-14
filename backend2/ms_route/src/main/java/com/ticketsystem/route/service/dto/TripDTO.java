package com.ticketsystem.route.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

/**
 * A DTO for the {@link com.ticketsystem.route.domain.Trip} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class TripDTO implements Serializable {

    private Long id;

    @NotNull
    private Instant departureTime;

    @NotNull
    private Instant arrivalTime;

    @NotNull
    private Integer availableSeats;

    @NotNull
    private Integer totalSeats;

    private String status;

    private UUID driverId;

    @NotNull
    private RouteDTO route;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Instant departureTime) {
        this.departureTime = departureTime;
    }

    public Instant getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Instant arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Integer getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Integer totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UUID getDriverId() {
        return driverId;
    }

    public void setDriverId(UUID driverId) {
        this.driverId = driverId;
    }

    public RouteDTO getRoute() {
        return route;
    }

    public void setRoute(RouteDTO route) {
        this.route = route;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TripDTO)) {
            return false;
        }

        TripDTO tripDTO = (TripDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, tripDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TripDTO{" +
            "id=" + getId() +
            ", departureTime='" + getDepartureTime() + "'" +
            ", arrivalTime='" + getArrivalTime() + "'" +
            ", availableSeats=" + getAvailableSeats() +
            ", totalSeats=" + getTotalSeats() +
            ", status='" + getStatus() + "'" +
            ", driverId='" + getDriverId() + "'" +
            ", route=" + getRoute() +
            "}";
    }
}
