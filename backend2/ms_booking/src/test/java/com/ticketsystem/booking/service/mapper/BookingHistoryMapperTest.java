package com.ticketsystem.booking.service.mapper;

import static com.ticketsystem.booking.domain.BookingHistoryAsserts.*;
import static com.ticketsystem.booking.domain.BookingHistoryTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookingHistoryMapperTest {

    private BookingHistoryMapper bookingHistoryMapper;

    @BeforeEach
    void setUp() {
        bookingHistoryMapper = new BookingHistoryMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getBookingHistorySample1();
        var actual = bookingHistoryMapper.toEntity(bookingHistoryMapper.toDto(expected));
        assertBookingHistoryAllPropertiesEquals(expected, actual);
    }
}
