package com.ridehub.booking.service.mapper;

import static com.ridehub.booking.domain.PricingSnapshotAsserts.*;
import static com.ridehub.booking.domain.PricingSnapshotTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PricingSnapshotMapperTest {

    private PricingSnapshotMapper pricingSnapshotMapper;

    @BeforeEach
    void setUp() {
        pricingSnapshotMapper = new PricingSnapshotMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getPricingSnapshotSample1();
        var actual = pricingSnapshotMapper.toEntity(pricingSnapshotMapper.toDto(expected));
        assertPricingSnapshotAllPropertiesEquals(expected, actual);
    }
}
