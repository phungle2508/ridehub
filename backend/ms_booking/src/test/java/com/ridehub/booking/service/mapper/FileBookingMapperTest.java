package com.ridehub.booking.service.mapper;

import static com.ridehub.booking.domain.FileBookingAsserts.*;
import static com.ridehub.booking.domain.FileBookingTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileBookingMapperTest {

    private FileBookingMapper fileBookingMapper;

    @BeforeEach
    void setUp() {
        fileBookingMapper = new FileBookingMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getFileBookingSample1();
        var actual = fileBookingMapper.toEntity(fileBookingMapper.toDto(expected));
        assertFileBookingAllPropertiesEquals(expected, actual);
    }
}
