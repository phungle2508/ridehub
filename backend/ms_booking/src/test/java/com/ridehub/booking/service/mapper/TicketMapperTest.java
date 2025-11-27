package com.ridehub.booking.service.mapper;

import static com.ridehub.booking.domain.TicketAsserts.*;
import static com.ridehub.booking.domain.TicketTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TicketMapperTest {

    private TicketMapper ticketMapper;

    @BeforeEach
    void setUp() {
        ticketMapper = new TicketMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getTicketSample1();
        var actual = ticketMapper.toEntity(ticketMapper.toDto(expected));
        assertTicketAllPropertiesEquals(expected, actual);
    }
}
