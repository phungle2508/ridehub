package com.ridehub.promotion.service.mapper;

import static com.ridehub.promotion.domain.ConditionByRouteAsserts.*;
import static com.ridehub.promotion.domain.ConditionByRouteTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConditionByRouteMapperTest {

    private ConditionByRouteMapper conditionByRouteMapper;

    @BeforeEach
    void setUp() {
        conditionByRouteMapper = new ConditionByRouteMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getConditionByRouteSample1();
        var actual = conditionByRouteMapper.toEntity(conditionByRouteMapper.toDto(expected));
        assertConditionByRouteAllPropertiesEquals(expected, actual);
    }
}
