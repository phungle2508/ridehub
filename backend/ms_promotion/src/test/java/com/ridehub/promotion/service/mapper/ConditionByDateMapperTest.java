package com.ridehub.promotion.service.mapper;

import static com.ridehub.promotion.domain.ConditionByDateAsserts.*;
import static com.ridehub.promotion.domain.ConditionByDateTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConditionByDateMapperTest {

    private ConditionByDateMapper conditionByDateMapper;

    @BeforeEach
    void setUp() {
        conditionByDateMapper = new ConditionByDateMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getConditionByDateSample1();
        var actual = conditionByDateMapper.toEntity(conditionByDateMapper.toDto(expected));
        assertConditionByDateAllPropertiesEquals(expected, actual);
    }
}
