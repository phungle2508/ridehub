package com.ridehub.promotion.service.mapper;

import static com.ridehub.promotion.domain.FilePromotionAsserts.*;
import static com.ridehub.promotion.domain.FilePromotionTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FilePromotionMapperTest {

    private FilePromotionMapper filePromotionMapper;

    @BeforeEach
    void setUp() {
        filePromotionMapper = new FilePromotionMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getFilePromotionSample1();
        var actual = filePromotionMapper.toEntity(filePromotionMapper.toDto(expected));
        assertFilePromotionAllPropertiesEquals(expected, actual);
    }
}
