package com.ticketsystem.route.service.mapper;

import static com.ticketsystem.route.domain.ProvinceAsserts.*;
import static com.ticketsystem.route.domain.ProvinceTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProvinceMapperTest {

    private ProvinceMapper provinceMapper;

    @BeforeEach
    void setUp() {
        provinceMapper = new ProvinceMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getProvinceSample1();
        var actual = provinceMapper.toEntity(provinceMapper.toDto(expected));
        assertProvinceAllPropertiesEquals(expected, actual);
    }
}
