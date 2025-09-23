package com.ridehub.route.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.route.domain.enumeration.VehicleType;
import java.math.BigDecimal;
import java.time.Instant;
import org.junit.jupiter.api.Test;

class RouteListDTOTest {

    @Test
    void testRouteListDTOCreation() {
        // Given
        Long tripId = 1L;
        String tripCode = "TRIP001";
        String routeCode = "ROUTE001";
        String origin = "TP.HCM";
        String destination = "An Giang";
        BigDecimal distanceKm = new BigDecimal("220");
        Instant departureTime = Instant.parse("2025-09-23T08:30:00Z");
        Instant arrivalTime = Instant.parse("2025-09-23T11:30:00Z");
        VehicleType vehicleType = VehicleType.LIMOUSINE;
        String vehiclePlateNumber = "29A-12345";
        String vehicleBrand = "Mercedes";
        Long driverId = 1L;
        String driverLicenseClass = "D";
        Integer driverYearsExperience = 5;
        BigDecimal baseFare = new BigDecimal("100000");

        // When
        RouteListDTO routeListDTO = new RouteListDTO(
                tripId, tripCode, routeCode, origin, destination,
                distanceKm, departureTime, arrivalTime,
                vehicleType, vehiclePlateNumber, vehicleBrand,
                driverId, driverLicenseClass, driverYearsExperience,
                baseFare);

        // Then
        assertThat(routeListDTO.getTripId()).isEqualTo(tripId);
        assertThat(routeListDTO.getTripCode()).isEqualTo(tripCode);
        assertThat(routeListDTO.getRouteCode()).isEqualTo(routeCode);
        assertThat(routeListDTO.getOrigin()).isEqualTo(origin);
        assertThat(routeListDTO.getDestination()).isEqualTo(destination);
        assertThat(routeListDTO.getRouteName()).isEqualTo("TP.HCM - An Giang");
        assertThat(routeListDTO.getDistanceKm()).isEqualTo(distanceKm);
        assertThat(routeListDTO.getDepartureTime()).isEqualTo(departureTime);
        assertThat(routeListDTO.getArrivalTime()).isEqualTo(arrivalTime);
        assertThat(routeListDTO.getVehicleType()).isEqualTo(vehicleType);
        assertThat(routeListDTO.getVehiclePlateNumber()).isEqualTo(vehiclePlateNumber);
        assertThat(routeListDTO.getVehicleBrand()).isEqualTo(vehicleBrand);
        assertThat(routeListDTO.getDriverId()).isEqualTo(driverId);
        assertThat(routeListDTO.getDriverLicenseClass()).isEqualTo(driverLicenseClass);
        assertThat(routeListDTO.getDriverYearsExperience()).isEqualTo(driverYearsExperience);
        assertThat(routeListDTO.getBaseFare()).isEqualTo(baseFare);

        // Test computed fields
        assertThat(routeListDTO.getPlannedJourney()).contains("08:30 - 11:30");
        assertThat(routeListDTO.getPlannedJourney()).contains("220 km");
        assertThat(routeListDTO.getStatus()).isNotNull();
    }

    @Test
    void testRouteListDTOToString() {
        // Given
        RouteListDTO routeListDTO = new RouteListDTO();
        routeListDTO.setTripId(1L);
        routeListDTO.setTripCode("TRIP001");
        routeListDTO.setRouteCode("ROUTE001");
        routeListDTO.setVehicleType(VehicleType.LIMOUSINE);
        routeListDTO.setVehiclePlateNumber("29A-12345");

        // When
        String toString = routeListDTO.toString();

        // Then
        assertThat(toString).contains("tripId=1");
        assertThat(toString).contains("tripCode='TRIP001'");
        assertThat(toString).contains("routeCode='ROUTE001'");
        assertThat(toString).contains("vehicleType=LIMOUSINE");
        assertThat(toString).contains("vehiclePlateNumber='29A-12345'");
    }

    @Test
    void testStatusDetermination() {
        // Test future trip (should be "Hoạt động")
        Instant futureTime = Instant.now().plusSeconds(3600); // 1 hour from now
        RouteListDTO futureTrip = new RouteListDTO();
        futureTrip.setDepartureTime(futureTime);
        futureTrip.setArrivalTime(futureTime.plusSeconds(7200)); // 2 hours later
        assertThat(futureTrip.getStatus()).isEqualTo("Hoạt động");

        // Test past trip (should be "Hoàn thành")
        Instant pastDeparture = Instant.now().minusSeconds(7200); // 2 hours ago
        Instant pastArrival = Instant.now().minusSeconds(3600); // 1 hour ago
        RouteListDTO pastTrip = new RouteListDTO();
        pastTrip.setDepartureTime(pastDeparture);
        pastTrip.setArrivalTime(pastArrival);
        assertThat(pastTrip.getStatus()).isEqualTo("Hoàn thành");

        // Test current trip (should be "Đang chạy")
        Instant currentDeparture = Instant.now().minusSeconds(1800); // 30 minutes ago
        Instant currentArrival = Instant.now().plusSeconds(1800); // 30 minutes from now
        RouteListDTO currentTrip = new RouteListDTO();
        currentTrip.setDepartureTime(currentDeparture);
        currentTrip.setArrivalTime(currentArrival);
        assertThat(currentTrip.getStatus()).isEqualTo("Đang chạy");
    }
}
