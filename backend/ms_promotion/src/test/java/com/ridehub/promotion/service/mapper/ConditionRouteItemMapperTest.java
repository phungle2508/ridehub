package com.ridehub.promotion.service.mapper;

import static com.ridehub.promotion.domain.ConditionRouteItemAsserts.*;
import static com.ridehub.promotion.domain.ConditionRouteItemTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConditionRouteItemMapperTest {

    private ConditionRouteItemMapper conditionRouteItemMapper;

    @BeforeEach
    void setUp() {
        conditionRouteItemMapper = new ConditionRouteItemMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getConditionRouteItemSample1();
        var actual = conditionRouteItemMapper.toEntity(conditionRouteItemMapper.toDto(expected));
        assertConditionRouteItemAllPropertiesEquals(expected, actual);
    }
}
