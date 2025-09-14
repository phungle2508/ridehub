package com.ticketsystem.route.domain;

import static com.ticketsystem.route.domain.OperatorTestSamples.*;
import static com.ticketsystem.route.domain.ReviewSummaryTestSamples.*;
import static com.ticketsystem.route.domain.StationTestSamples.*;
import static com.ticketsystem.route.domain.VehicleAmenityTestSamples.*;
import static com.ticketsystem.route.domain.VehicleImageTestSamples.*;
import static com.ticketsystem.route.domain.VehicleReviewTestSamples.*;
import static com.ticketsystem.route.domain.VehicleTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ticketsystem.route.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class VehicleTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Vehicle.class);
        Vehicle vehicle1 = getVehicleSample1();
        Vehicle vehicle2 = new Vehicle();
        assertThat(vehicle1).isNotEqualTo(vehicle2);

        vehicle2.setId(vehicle1.getId());
        assertThat(vehicle1).isEqualTo(vehicle2);

        vehicle2 = getVehicleSample2();
        assertThat(vehicle1).isNotEqualTo(vehicle2);
    }

    @Test
    void summaryTest() {
        Vehicle vehicle = getVehicleRandomSampleGenerator();
        ReviewSummary reviewSummaryBack = getReviewSummaryRandomSampleGenerator();

        vehicle.setSummary(reviewSummaryBack);
        assertThat(vehicle.getSummary()).isEqualTo(reviewSummaryBack);

        vehicle.summary(null);
        assertThat(vehicle.getSummary()).isNull();
    }

    @Test
    void imagesTest() {
        Vehicle vehicle = getVehicleRandomSampleGenerator();
        VehicleImage vehicleImageBack = getVehicleImageRandomSampleGenerator();

        vehicle.addImages(vehicleImageBack);
        assertThat(vehicle.getImages()).containsOnly(vehicleImageBack);
        assertThat(vehicleImageBack.getVehicle()).isEqualTo(vehicle);

        vehicle.removeImages(vehicleImageBack);
        assertThat(vehicle.getImages()).doesNotContain(vehicleImageBack);
        assertThat(vehicleImageBack.getVehicle()).isNull();

        vehicle.images(new HashSet<>(Set.of(vehicleImageBack)));
        assertThat(vehicle.getImages()).containsOnly(vehicleImageBack);
        assertThat(vehicleImageBack.getVehicle()).isEqualTo(vehicle);

        vehicle.setImages(new HashSet<>());
        assertThat(vehicle.getImages()).doesNotContain(vehicleImageBack);
        assertThat(vehicleImageBack.getVehicle()).isNull();
    }

    @Test
    void reviewsTest() {
        Vehicle vehicle = getVehicleRandomSampleGenerator();
        VehicleReview vehicleReviewBack = getVehicleReviewRandomSampleGenerator();

        vehicle.addReviews(vehicleReviewBack);
        assertThat(vehicle.getReviews()).containsOnly(vehicleReviewBack);
        assertThat(vehicleReviewBack.getVehicle()).isEqualTo(vehicle);

        vehicle.removeReviews(vehicleReviewBack);
        assertThat(vehicle.getReviews()).doesNotContain(vehicleReviewBack);
        assertThat(vehicleReviewBack.getVehicle()).isNull();

        vehicle.reviews(new HashSet<>(Set.of(vehicleReviewBack)));
        assertThat(vehicle.getReviews()).containsOnly(vehicleReviewBack);
        assertThat(vehicleReviewBack.getVehicle()).isEqualTo(vehicle);

        vehicle.setReviews(new HashSet<>());
        assertThat(vehicle.getReviews()).doesNotContain(vehicleReviewBack);
        assertThat(vehicleReviewBack.getVehicle()).isNull();
    }

    @Test
    void amenityItemsTest() {
        Vehicle vehicle = getVehicleRandomSampleGenerator();
        VehicleAmenity vehicleAmenityBack = getVehicleAmenityRandomSampleGenerator();

        vehicle.addAmenityItems(vehicleAmenityBack);
        assertThat(vehicle.getAmenityItems()).containsOnly(vehicleAmenityBack);
        assertThat(vehicleAmenityBack.getVehicle()).isEqualTo(vehicle);

        vehicle.removeAmenityItems(vehicleAmenityBack);
        assertThat(vehicle.getAmenityItems()).doesNotContain(vehicleAmenityBack);
        assertThat(vehicleAmenityBack.getVehicle()).isNull();

        vehicle.amenityItems(new HashSet<>(Set.of(vehicleAmenityBack)));
        assertThat(vehicle.getAmenityItems()).containsOnly(vehicleAmenityBack);
        assertThat(vehicleAmenityBack.getVehicle()).isEqualTo(vehicle);

        vehicle.setAmenityItems(new HashSet<>());
        assertThat(vehicle.getAmenityItems()).doesNotContain(vehicleAmenityBack);
        assertThat(vehicleAmenityBack.getVehicle()).isNull();
    }

    @Test
    void homeStationTest() {
        Vehicle vehicle = getVehicleRandomSampleGenerator();
        Station stationBack = getStationRandomSampleGenerator();

        vehicle.setHomeStation(stationBack);
        assertThat(vehicle.getHomeStation()).isEqualTo(stationBack);

        vehicle.homeStation(null);
        assertThat(vehicle.getHomeStation()).isNull();
    }

    @Test
    void operatorTest() {
        Vehicle vehicle = getVehicleRandomSampleGenerator();
        Operator operatorBack = getOperatorRandomSampleGenerator();

        vehicle.setOperator(operatorBack);
        assertThat(vehicle.getOperator()).isEqualTo(operatorBack);

        vehicle.operator(null);
        assertThat(vehicle.getOperator()).isNull();
    }
}
