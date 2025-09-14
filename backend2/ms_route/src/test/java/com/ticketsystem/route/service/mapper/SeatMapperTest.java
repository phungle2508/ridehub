package com.ticketsystem.route.service.mapper;

import static com.ticketsystem.route.domain.SeatAsserts.*;
import static com.ticketsystem.route.domain.SeatTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SeatMapperTest {

    private SeatMapper seatMapper;

    @BeforeEach
    void setUp() {
        seatMapper = new SeatMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getSeatSample1();
        var actual = seatMapper.toEntity(seatMapper.toDto(expected));
        assertSeatAllPropertiesEquals(expected, actual);
    }
}
