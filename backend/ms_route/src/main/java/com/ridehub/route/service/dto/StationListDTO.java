package com.ridehub.route.service.dto;

import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for displaying station list information with route and location details.
 */
public class StationListDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long stationId;
    private String stationName;
    private String address;
    private String stationType; // "Dón/Trả", "Pickup", "Drop-off", etc.
    private String routeName;
    private String routeCode;
    private Integer orderInRoute; // Thứ tự trong tuyến
    private String status; // "Hoạt động", "Đã ngưng", etc.
    private Instant createdAt;
    private Instant updatedAt;
    private String phoneNumber;
    private String description;
    private Boolean active;

    // Default constructor
    public StationListDTO() {}

    // Constructor with essential fields
    public StationListDTO(Long stationId, String stationName, String address, 
                         String stationType, String routeName, String status) {
        this.stationId = stationId;
        this.stationName = stationName;
        this.address = address;
        this.stationType = stationType;
        this.routeName = routeName;
        this.status = status;
    }

    // Getters and Setters
    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStationType() {
        return stationType;
    }

    public void setStationType(String stationType) {
        this.stationType = stationType;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public Integer getOrderInRoute() {
        return orderInRoute;
    }

    public void setOrderInRoute(Integer orderInRoute) {
        this.orderInRoute = orderInRoute;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "StationListDTO{" +
            "stationId=" + stationId +
            ", stationName='" + stationName + '\'' +
            ", address='" + address + '\'' +
            ", stationType='" + stationType + '\'' +
            ", routeName='" + routeName + '\'' +
            ", routeCode='" + routeCode + '\'' +
            ", orderInRoute=" + orderInRoute +
            ", status='" + status + '\'' +
            ", createdAt=" + createdAt +
            ", updatedAt=" + updatedAt +
            ", phoneNumber='" + phoneNumber + '\'' +
            ", description='" + description + '\'' +
            ", active=" + active +
            '}';
    }
}
