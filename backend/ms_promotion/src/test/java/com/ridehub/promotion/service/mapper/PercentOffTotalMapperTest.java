package com.ridehub.promotion.service.mapper;

import static com.ridehub.promotion.domain.PercentOffTotalAsserts.*;
import static com.ridehub.promotion.domain.PercentOffTotalTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PercentOffTotalMapperTest {

    private PercentOffTotalMapper percentOffTotalMapper;

    @BeforeEach
    void setUp() {
        percentOffTotalMapper = new PercentOffTotalMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getPercentOffTotalSample1();
        var actual = percentOffTotalMapper.toEntity(percentOffTotalMapper.toDto(expected));
        assertPercentOffTotalAllPropertiesEquals(expected, actual);
    }
}
