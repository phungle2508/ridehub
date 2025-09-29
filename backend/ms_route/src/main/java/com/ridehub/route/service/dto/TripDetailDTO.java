package com.ridehub.route.service.dto;

import com.ridehub.route.domain.enumeration.VehicleType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * A DTO for displaying route list information combining Trip, Route, Driver,
 * and Vehicle data.
 */
public class TripDetailDTO implements Serializable {

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
    private Long attendantId;
    private String attendantName;
    private String attendantPhoneNumber;
    private String status; // Based on trip status or current time vs departure time
    private BigDecimal baseFare;

    private Boolean tripDeleted;
    private Boolean routeDeleted;
    private Boolean originDeleted;
    private Boolean destinationDeleted;
    private Boolean vehicleDeleted;
    private Boolean driverDeleted;
    private Boolean driverStaffDeleted;
    private Boolean attendantDeleted;
    private Boolean attendantStaffDeleted;

    // Constructors
    public TripDetailDTO() {
    }

    public TripDetailDTO(Long tripId, String tripCode, String routeCode, String routeName, String origin,
            String destination, BigDecimal distanceKm, Instant departureTime, Instant arrivalTime,
            String plannedJourney, VehicleType vehicleType, String vehiclePlateNumber, String vehicleBrand,
            Long driverId, String driverLicenseClass, Integer driverYearsExperience, String driverName,
            Long attendantId, String attendantName, String attendantPhoneNumber, String status, BigDecimal baseFare,
            Boolean tripDeleted, Boolean routeDeleted, Boolean originDeleted, Boolean destinationDeleted,
            Boolean vehicleDeleted, Boolean driverDeleted, Boolean driverStaffDeleted, Boolean attendantDeleted,
            Boolean attendantStaffDeleted) {
        this.tripId = tripId;
        this.tripCode = tripCode;
        this.routeCode = routeCode;
        this.routeName = routeName;
        this.origin = origin;
        this.destination = destination;
        this.distanceKm = distanceKm;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.plannedJourney = plannedJourney;
        this.vehicleType = vehicleType;
        this.vehiclePlateNumber = vehiclePlateNumber;
        this.vehicleBrand = vehicleBrand;
        this.driverId = driverId;
        this.driverLicenseClass = driverLicenseClass;
        this.driverYearsExperience = driverYearsExperience;
        this.driverName = driverName;
        this.attendantId = attendantId;
        this.attendantName = attendantName;
        this.attendantPhoneNumber = attendantPhoneNumber;
        this.status = status;
        this.baseFare = baseFare;
        this.tripDeleted = tripDeleted;
        this.routeDeleted = routeDeleted;
        this.originDeleted = originDeleted;
        this.destinationDeleted = destinationDeleted;
        this.vehicleDeleted = vehicleDeleted;
        this.driverDeleted = driverDeleted;
        this.driverStaffDeleted = driverStaffDeleted;
        this.attendantDeleted = attendantDeleted;
        this.attendantStaffDeleted = attendantStaffDeleted;
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

    public Long getAttendantId() {
        return attendantId;
    }

    public void setAttendantId(Long attendantId) {
        this.attendantId = attendantId;
    }

    public String getAttendantName() {
        return attendantName;
    }

    public void setAttendantName(String attendantName) {
        this.attendantName = attendantName;
    }

    public String getAttendantPhoneNumber() {
        return attendantPhoneNumber;
    }

    public void setAttendantPhoneNumber(String attendantPhoneNumber) {
        this.attendantPhoneNumber = attendantPhoneNumber;
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

    public Boolean getTripDeleted() {
        return tripDeleted;
    }

    public void setTripDeleted(Boolean tripDeleted) {
        this.tripDeleted = tripDeleted;
    }

    public Boolean getRouteDeleted() {
        return routeDeleted;
    }

    public void setRouteDeleted(Boolean routeDeleted) {
        this.routeDeleted = routeDeleted;
    }

    public Boolean getOriginDeleted() {
        return originDeleted;
    }

    public void setOriginDeleted(Boolean originDeleted) {
        this.originDeleted = originDeleted;
    }

    public Boolean getDestinationDeleted() {
        return destinationDeleted;
    }

    public void setDestinationDeleted(Boolean destinationDeleted) {
        this.destinationDeleted = destinationDeleted;
    }

    public Boolean getVehicleDeleted() {
        return vehicleDeleted;
    }

    public void setVehicleDeleted(Boolean vehicleDeleted) {
        this.vehicleDeleted = vehicleDeleted;
    }

    public Boolean getDriverDeleted() {
        return driverDeleted;
    }

    public void setDriverDeleted(Boolean driverDeleted) {
        this.driverDeleted = driverDeleted;
    }

    public Boolean getDriverStaffDeleted() {
        return driverStaffDeleted;
    }

    public void setDriverStaffDeleted(Boolean driverStaffDeleted) {
        this.driverStaffDeleted = driverStaffDeleted;
    }

    public Boolean getAttendantDeleted() {
        return attendantDeleted;
    }

    public void setAttendantDeleted(Boolean attendantDeleted) {
        this.attendantDeleted = attendantDeleted;
    }

    public Boolean getAttendantStaffDeleted() {
        return attendantStaffDeleted;
    }

    public void setAttendantStaffDeleted(Boolean attendantStaffDeleted) {
        this.attendantStaffDeleted = attendantStaffDeleted;
    }

    @Override
    public String toString() {
        return "TripDetailDTO{" +
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
