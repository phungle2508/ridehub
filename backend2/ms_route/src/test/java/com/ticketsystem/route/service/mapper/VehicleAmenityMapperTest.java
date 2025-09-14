package com.ticketsystem.route.service.mapper;

import static com.ticketsystem.route.domain.VehicleAmenityAsserts.*;
import static com.ticketsystem.route.domain.VehicleAmenityTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VehicleAmenityMapperTest {

    private VehicleAmenityMapper vehicleAmenityMapper;

    @BeforeEach
    void setUp() {
        vehicleAmenityMapper = new VehicleAmenityMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getVehicleAmenitySample1();
        var actual = vehicleAmenityMapper.toEntity(vehicleAmenityMapper.toDto(expected));
        assertVehicleAmenityAllPropertiesEquals(expected, actual);
    }
}
