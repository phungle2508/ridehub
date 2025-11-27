package com.ridehub.promotion.service.mapper;

import static com.ridehub.promotion.domain.ConditionByLocationAsserts.*;
import static com.ridehub.promotion.domain.ConditionByLocationTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConditionByLocationMapperTest {

    private ConditionByLocationMapper conditionByLocationMapper;

    @BeforeEach
    void setUp() {
        conditionByLocationMapper = new ConditionByLocationMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getConditionByLocationSample1();
        var actual = conditionByLocationMapper.toEntity(conditionByLocationMapper.toDto(expected));
        assertConditionByLocationAllPropertiesEquals(expected, actual);
    }
}
