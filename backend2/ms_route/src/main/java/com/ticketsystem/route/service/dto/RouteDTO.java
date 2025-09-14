package com.ticketsystem.route.service.dto;

import com.ticketsystem.route.domain.enumeration.TransportType;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link com.ticketsystem.route.domain.Route} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class RouteDTO implements Serializable {

    private Long id;

    @NotNull
    private TransportType transportType;

    private BigDecimal distance;

    private Integer estimatedDuration;

    @NotNull
    private BigDecimal basePrice;

    @NotNull
    private Boolean isActive;

    private StationDTO origin;

    private StationDTO destination;

    @NotNull
    private OperatorDTO operator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public BigDecimal getDistance() {
        return distance;
    }

    public void setDistance(BigDecimal distance) {
        this.distance = distance;
    }

    public Integer getEstimatedDuration() {
        return estimatedDuration;
    }

    public void setEstimatedDuration(Integer estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public StationDTO getOrigin() {
        return origin;
    }

    public void setOrigin(StationDTO origin) {
        this.origin = origin;
    }

    public StationDTO getDestination() {
        return destination;
    }

    public void setDestination(StationDTO destination) {
        this.destination = destination;
    }

    public OperatorDTO getOperator() {
        return operator;
    }

    public void setOperator(OperatorDTO operator) {
        this.operator = operator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RouteDTO)) {
            return false;
        }

        RouteDTO routeDTO = (RouteDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, routeDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RouteDTO{" +
            "id=" + getId() +
            ", transportType='" + getTransportType() + "'" +
            ", distance=" + getDistance() +
            ", estimatedDuration=" + getEstimatedDuration() +
            ", basePrice=" + getBasePrice() +
            ", isActive='" + getIsActive() + "'" +
            ", origin=" + getOrigin() +
            ", destination=" + getDestination() +
            ", operator=" + getOperator() +
            "}";
    }
}
