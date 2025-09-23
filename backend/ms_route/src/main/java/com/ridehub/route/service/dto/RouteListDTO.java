package com.ridehub.route.service.dto;

import com.ridehub.route.domain.enumeration.VehicleType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * A DTO for displaying route list information combining Trip, Route, Driver,
 * and Vehicle data.
 */
public class RouteListDTO implements Serializable {

    private Long tripId;
    private String tripCode;
    private String routeCode;
    private String routeName; // Origin to Destination
    private String origin;
    private String destination;
    private BigDecimal distanceKm;
    private Instant departureTime;
    private Instant arrivalTime;
    private String plannedJourney; // Formatted departure-arrival time with distance
    private VehicleType vehicleType;
    private String vehiclePlateNumber;
    private String vehicleBrand;
    private Long driverId;
    private String driverLicenseClass;
    private Integer driverYearsExperience;
    private String driverName; // This will be null until we have Staff-Driver relationship
    private String status; // Based on trip status or current time vs departure time
    private BigDecimal baseFare;

    // Constructors
    public RouteListDTO() {
    }

    public RouteListDTO(Long tripId, String tripCode, String routeCode, String origin, String destination,
            BigDecimal distanceKm, Instant departureTime, Instant arrivalTime,
            VehicleType vehicleType, String vehiclePlateNumber, String vehicleBrand,
            Long driverId, String driverLicenseClass, Integer driverYearsExperience,
            BigDecimal baseFare) {
        this.tripId = tripId;
        this.tripCode = tripCode;
        this.routeCode = routeCode;
        this.origin = origin;
        this.destination = destination;
        this.distanceKm = distanceKm;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.vehicleType = vehicleType;
        this.vehiclePlateNumber = vehiclePlateNumber;
        this.vehicleBrand = vehicleBrand;
        this.driverId = driverId;
        this.driverLicenseClass = driverLicenseClass;
        this.driverYearsExperience = driverYearsExperience;
        this.baseFare = baseFare;

        // Generate computed fields
        this.routeName = origin + " - " + destination;
        this.plannedJourney = formatPlannedJourney();
        this.status = determineStatus();
    }

    // Getters and Setters
    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public String getTripCode() {
        return tripCode;
    }

    public void setTripCode(String tripCode) {
        this.tripCode = tripCode;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public void setRouteCode(String routeCode) {
        this.routeCode = routeCode;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public BigDecimal getDistanceKm() {
        return distanceKm;
    }

    public void setDistanceKm(BigDecimal distanceKm) {
        this.distanceKm = distanceKm;
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

    public String getPlannedJourney() {
        return plannedJourney;
    }

    public void setPlannedJourney(String plannedJourney) {
        this.plannedJourney = plannedJourney;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehiclePlateNumber() {
        return vehiclePlateNumber;
    }

    public void setVehiclePlateNumber(String vehiclePlateNumber) {
        this.vehiclePlateNumber = vehiclePlateNumber;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public String getDriverLicenseClass() {
        return driverLicenseClass;
    }

    public void setDriverLicenseClass(String driverLicenseClass) {
        this.driverLicenseClass = driverLicenseClass;
    }

    public Integer getDriverYearsExperience() {
        return driverYearsExperience;
    }

    public void setDriverYearsExperience(Integer driverYearsExperience) {
        this.driverYearsExperience = driverYearsExperience;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(BigDecimal baseFare) {
        this.baseFare = baseFare;
    }

    // Helper methods
    private String formatPlannedJourney() {
        if (departureTime == null || arrivalTime == null) {
            return "";
        }

        // Format times (you might want to adjust the format based on your needs)
        String departure = departureTime.toString().substring(11, 16); // HH:mm
        String arrival = arrivalTime.toString().substring(11, 16); // HH:mm
        String distance = distanceKm != null ? distanceKm + " km" : "";

        return departure + " - " + arrival + (distance.isEmpty() ? "" : "\n" + distance);
    }

    private String determineStatus() {
        if (departureTime == null) {
            return "Chưa xác định";
        }

        Instant now = Instant.now();
        if (now.isBefore(departureTime)) {
            return "Hoạt động"; // Active/Scheduled
        } else if (now.isAfter(arrivalTime)) {
            return "Hoàn thành"; // Completed
        } else {
            return "Đang chạy"; // In progress
        }
    }

    @Override
    public String toString() {
        return "RouteListDTO{" +
                "tripId=" + tripId +
                ", tripCode='" + tripCode + '\'' +
                ", routeCode='" + routeCode + '\'' +
                ", routeName='" + routeName + '\'' +
                ", plannedJourney='" + plannedJourney + '\'' +
                ", vehicleType=" + vehicleType +
                ", vehiclePlateNumber='" + vehiclePlateNumber + '\'' +
                ", driverId=" + driverId +
                ", status='" + status + '\'' +
                '}';
    }
}
