package com.ticketsystem.route.domain;

import static com.ticketsystem.route.domain.VehicleReviewTestSamples.*;
import static com.ticketsystem.route.domain.VehicleTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ticketsystem.route.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class VehicleReviewTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(VehicleReview.class);
        VehicleReview vehicleReview1 = getVehicleReviewSample1();
        VehicleReview vehicleReview2 = new VehicleReview();
        assertThat(vehicleReview1).isNotEqualTo(vehicleReview2);

        vehicleReview2.setId(vehicleReview1.getId());
        assertThat(vehicleReview1).isEqualTo(vehicleReview2);

        vehicleReview2 = getVehicleReviewSample2();
        assertThat(vehicleReview1).isNotEqualTo(vehicleReview2);
    }

    @Test
    void vehicleTest() {
        VehicleReview vehicleReview = getVehicleReviewRandomSampleGenerator();
        Vehicle vehicleBack = getVehicleRandomSampleGenerator();

        vehicleReview.setVehicle(vehicleBack);
        assertThat(vehicleReview.getVehicle()).isEqualTo(vehicleBack);

        vehicleReview.vehicle(null);
        assertThat(vehicleReview.getVehicle()).isNull();
    }
}
