package com.ridehub.route.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.route.domain.enumeration.VehicleType;
import java.time.Instant;
import org.junit.jupiter.api.Test;

class VehicleListDTOTest {

    @Test
    void testVehicleListDTOCreation() {
        // Given
        Long vehicleId = 1L;
        String plateNumber = "51B-12345";
        VehicleType vehicleType = VehicleType.LIMOUSINE;
        String brand = "Mercedes";
        String description = "Luxury limousine";
        Integer seatCount = 9;
        String currentRoute = "SG-CT";
        String currentRouteDescription = "TP.HCM - Cần Thơ";
        String driverName = "Driver 1";
        Long driverId = 1L;
        String driverLicenseClass = "D";
        Integer driverYearsExperience = 5;
        Instant createdAt = Instant.now();
        Instant updatedAt = Instant.now();

        // When
        VehicleListDTO vehicleListDTO = new VehicleListDTO(
                vehicleId, plateNumber, vehicleType, brand, description,
                seatCount, currentRoute, currentRouteDescription,
                driverName, driverId, driverLicenseClass, driverYearsExperience,
                createdAt, updatedAt);

        // Then
        assertThat(vehicleListDTO.getVehicleId()).isEqualTo(vehicleId);
        assertThat(vehicleListDTO.getPlateNumber()).isEqualTo(plateNumber);
        assertThat(vehicleListDTO.getVehicleType()).isEqualTo(vehicleType);
        assertThat(vehicleListDTO.getBrand()).isEqualTo(brand);
        assertThat(vehicleListDTO.getDescription()).isEqualTo(description);
        assertThat(vehicleListDTO.getSeatCount()).isEqualTo(seatCount);
        assertThat(vehicleListDTO.getCurrentRoute()).isEqualTo(currentRoute);
        assertThat(vehicleListDTO.getCurrentRouteDescription()).isEqualTo(currentRouteDescription);
        assertThat(vehicleListDTO.getDriverName()).isEqualTo(driverName);
        assertThat(vehicleListDTO.getDriverId()).isEqualTo(driverId);
        assertThat(vehicleListDTO.getDriverLicenseClass()).isEqualTo(driverLicenseClass);
        assertThat(vehicleListDTO.getDriverYearsExperience()).isEqualTo(driverYearsExperience);
        assertThat(vehicleListDTO.getCreatedAt()).isEqualTo(createdAt);
        assertThat(vehicleListDTO.getUpdatedAt()).isEqualTo(updatedAt);
        assertThat(vehicleListDTO.getStatus()).isEqualTo("Hoạt động"); // Active - has driver and route
    }

    @Test
    void testVehicleListDTOStatusDetermination() {
        // Test different status scenarios
        VehicleListDTO activeVehicle = new VehicleListDTO();
        activeVehicle.setDriverId(1L);
        activeVehicle.setCurrentRoute("SG-CT");
        assertThat(activeVehicle.getStatus()).isEqualTo("Hoạt động");

        VehicleListDTO waitingForDriver = new VehicleListDTO();
        waitingForDriver.setDriverId(null);
        waitingForDriver.setCurrentRoute("SG-CT");
        assertThat(waitingForDriver.getStatus()).isEqualTo("Chờ tài xế");

        VehicleListDTO waitingForRoute = new VehicleListDTO();
        waitingForRoute.setDriverId(1L);
        waitingForRoute.setCurrentRoute(null);
        assertThat(waitingForRoute.getStatus()).isEqualTo("Chờ tuyến");

        VehicleListDTO inactive = new VehicleListDTO();
        inactive.setDriverId(null);
        inactive.setCurrentRoute(null);
        assertThat(inactive.getStatus()).isEqualTo("Không hoạt động");
    }

    @Test
    void testVehicleListDTOToString() {
        // Given
        VehicleListDTO vehicleListDTO = new VehicleListDTO();
        vehicleListDTO.setVehicleId(1L);
        vehicleListDTO.setPlateNumber("51B-12345");
        vehicleListDTO.setVehicleType(VehicleType.LIMOUSINE);
        vehicleListDTO.setBrand("Mercedes");
        vehicleListDTO.setSeatCount(9);
        vehicleListDTO.setCurrentRoute("SG-CT");
        vehicleListDTO.setDriverName("Driver 1");
        vehicleListDTO.setStatus("Hoạt động");

        // When
        String toString = vehicleListDTO.toString();

        // Then
        assertThat(toString).contains("vehicleId=1");
        assertThat(toString).contains("plateNumber='51B-12345'");
        assertThat(toString).contains("vehicleType=LIMOUSINE");
        assertThat(toString).contains("brand='Mercedes'");
        assertThat(toString).contains("seatCount=9");
        assertThat(toString).contains("currentRoute='SG-CT'");
        assertThat(toString).contains("driverName='Driver 1'");
        assertThat(toString).contains("status='Hoạt động'");
    }

    @Test
    void testDefaultConstructor() {
        // When
        VehicleListDTO vehicleListDTO = new VehicleListDTO();

        // Then
        assertThat(vehicleListDTO.getVehicleId()).isNull();
        assertThat(vehicleListDTO.getPlateNumber()).isNull();
        assertThat(vehicleListDTO.getVehicleType()).isNull();
        assertThat(vehicleListDTO.getBrand()).isNull();
        assertThat(vehicleListDTO.getDescription()).isNull();
        assertThat(vehicleListDTO.getSeatCount()).isNull();
        assertThat(vehicleListDTO.getCurrentRoute()).isNull();
        assertThat(vehicleListDTO.getCurrentRouteDescription()).isNull();
        assertThat(vehicleListDTO.getDriverName()).isNull();
        assertThat(vehicleListDTO.getDriverId()).isNull();
        assertThat(vehicleListDTO.getDriverLicenseClass()).isNull();
        assertThat(vehicleListDTO.getDriverYearsExperience()).isNull();
        assertThat(vehicleListDTO.getCreatedAt()).isNull();
        assertThat(vehicleListDTO.getUpdatedAt()).isNull();
        assertThat(vehicleListDTO.getStatus()).isEqualTo("Không hoạt động"); // Default status
    }
}
