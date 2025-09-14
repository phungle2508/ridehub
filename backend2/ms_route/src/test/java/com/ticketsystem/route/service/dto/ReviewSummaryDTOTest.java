package com.ticketsystem.route.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.ticketsystem.route.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ReviewSummaryDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ReviewSummaryDTO.class);
        ReviewSummaryDTO reviewSummaryDTO1 = new ReviewSummaryDTO();
        reviewSummaryDTO1.setId(1L);
        ReviewSummaryDTO reviewSummaryDTO2 = new ReviewSummaryDTO();
        assertThat(reviewSummaryDTO1).isNotEqualTo(reviewSummaryDTO2);
        reviewSummaryDTO2.setId(reviewSummaryDTO1.getId());
        assertThat(reviewSummaryDTO1).isEqualTo(reviewSummaryDTO2);
        reviewSummaryDTO2.setId(2L);
        assertThat(reviewSummaryDTO1).isNotEqualTo(reviewSummaryDTO2);
        reviewSummaryDTO1.setId(null);
        assertThat(reviewSummaryDTO1).isNotEqualTo(reviewSummaryDTO2);
    }
}
