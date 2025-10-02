package com.ridehub.promotion.service.mapper;

import static com.ridehub.promotion.domain.PromotionAsserts.*;
import static com.ridehub.promotion.domain.PromotionTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PromotionMapperTest {

    private PromotionMapper promotionMapper;

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getPromotionSample1();
        var actual = promotionMapper.toEntity(promotionMapper.toDto(expected));
        assertPromotionAllPropertiesEquals(expected, actual);
    }
}
