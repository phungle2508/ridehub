package com.ticketsystem.route.service.mapper;

import static com.ticketsystem.route.domain.StationAsserts.*;
import static com.ticketsystem.route.domain.StationTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StationMapperTest {

    private StationMapper stationMapper;

    @BeforeEach
    void setUp() {
        stationMapper = new StationMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getStationSample1();
        var actual = stationMapper.toEntity(stationMapper.toDto(expected));
        assertStationAllPropertiesEquals(expected, actual);
    }
}
