package com.ticketsystem.route.service.mapper;

import static com.ticketsystem.route.domain.ReviewSummaryAsserts.*;
import static com.ticketsystem.route.domain.ReviewSummaryTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReviewSummaryMapperTest {

    private ReviewSummaryMapper reviewSummaryMapper;

    @BeforeEach
    void setUp() {
        reviewSummaryMapper = new ReviewSummaryMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getReviewSummarySample1();
        var actual = reviewSummaryMapper.toEntity(reviewSummaryMapper.toDto(expected));
        assertReviewSummaryAllPropertiesEquals(expected, actual);
    }
}
