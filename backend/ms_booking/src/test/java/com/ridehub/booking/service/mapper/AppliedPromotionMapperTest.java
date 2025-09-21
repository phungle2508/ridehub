package com.ridehub.booking.service.mapper;

import static com.ridehub.booking.domain.AppliedPromotionAsserts.*;
import static com.ridehub.booking.domain.AppliedPromotionTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppliedPromotionMapperTest {

    private AppliedPromotionMapper appliedPromotionMapper;

    @BeforeEach
    void setUp() {
        appliedPromotionMapper = new AppliedPromotionMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getAppliedPromotionSample1();
        var actual = appliedPromotionMapper.toEntity(appliedPromotionMapper.toDto(expected));
        assertAppliedPromotionAllPropertiesEquals(expected, actual);
    }
}
