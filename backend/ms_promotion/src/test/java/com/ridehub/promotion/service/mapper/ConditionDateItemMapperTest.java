package com.ridehub.promotion.service.mapper;

import static com.ridehub.promotion.domain.ConditionDateItemAsserts.*;
import static com.ridehub.promotion.domain.ConditionDateItemTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConditionDateItemMapperTest {

    private ConditionDateItemMapper conditionDateItemMapper;

    @BeforeEach
    void setUp() {
        conditionDateItemMapper = new ConditionDateItemMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getConditionDateItemSample1();
        var actual = conditionDateItemMapper.toEntity(conditionDateItemMapper.toDto(expected));
        assertConditionDateItemAllPropertiesEquals(expected, actual);
    }
}
