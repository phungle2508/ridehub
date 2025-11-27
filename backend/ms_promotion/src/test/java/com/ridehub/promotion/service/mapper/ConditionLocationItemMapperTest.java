package com.ridehub.promotion.service.mapper;

import static com.ridehub.promotion.domain.ConditionLocationItemAsserts.*;
import static com.ridehub.promotion.domain.ConditionLocationItemTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConditionLocationItemMapperTest {

    private ConditionLocationItemMapper conditionLocationItemMapper;

    @BeforeEach
    void setUp() {
        conditionLocationItemMapper = new ConditionLocationItemMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getConditionLocationItemSample1();
        var actual = conditionLocationItemMapper.toEntity(conditionLocationItemMapper.toDto(expected));
        assertConditionLocationItemAllPropertiesEquals(expected, actual);
    }
}
