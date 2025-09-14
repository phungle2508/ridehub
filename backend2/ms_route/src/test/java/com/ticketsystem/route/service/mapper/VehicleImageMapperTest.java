package com.ticketsystem.route.service.mapper;

import static com.ticketsystem.route.domain.VehicleImageAsserts.*;
import static com.ticketsystem.route.domain.VehicleImageTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VehicleImageMapperTest {

    private VehicleImageMapper vehicleImageMapper;

    @BeforeEach
    void setUp() {
        vehicleImageMapper = new VehicleImageMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getVehicleImageSample1();
        var actual = vehicleImageMapper.toEntity(vehicleImageMapper.toDto(expected));
        assertVehicleImageAllPropertiesEquals(expected, actual);
    }
}
