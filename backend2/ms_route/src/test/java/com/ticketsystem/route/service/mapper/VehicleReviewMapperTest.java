package com.ticketsystem.route.service.mapper;

import static com.ticketsystem.route.domain.VehicleReviewAsserts.*;
import static com.ticketsystem.route.domain.VehicleReviewTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VehicleReviewMapperTest {

    private VehicleReviewMapper vehicleReviewMapper;

    @BeforeEach
    void setUp() {
        vehicleReviewMapper = new VehicleReviewMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getVehicleReviewSample1();
        var actual = vehicleReviewMapper.toEntity(vehicleReviewMapper.toDto(expected));
        assertVehicleReviewAllPropertiesEquals(expected, actual);
    }
}
