package com.ticketsystem.route.domain;

import static com.ticketsystem.route.domain.ReviewSummaryTestSamples.*;
import static com.ticketsystem.route.domain.VehicleTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ticketsystem.route.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ReviewSummaryTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ReviewSummary.class);
        ReviewSummary reviewSummary1 = getReviewSummarySample1();
        ReviewSummary reviewSummary2 = new ReviewSummary();
        assertThat(reviewSummary1).isNotEqualTo(reviewSummary2);

        reviewSummary2.setId(reviewSummary1.getId());
        assertThat(reviewSummary1).isEqualTo(reviewSummary2);

        reviewSummary2 = getReviewSummarySample2();
        assertThat(reviewSummary1).isNotEqualTo(reviewSummary2);
    }

    @Test
    void vehicleTest() {
        ReviewSummary reviewSummary = getReviewSummaryRandomSampleGenerator();
        Vehicle vehicleBack = getVehicleRandomSampleGenerator();

        reviewSummary.setVehicle(vehicleBack);
        assertThat(reviewSummary.getVehicle()).isEqualTo(vehicleBack);
        assertThat(vehicleBack.getSummary()).isEqualTo(reviewSummary);

        reviewSummary.vehicle(null);
        assertThat(reviewSummary.getVehicle()).isNull();
        assertThat(vehicleBack.getSummary()).isNull();
    }
}
