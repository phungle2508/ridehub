package com.ticketsystem.route.domain;

import static com.ticketsystem.route.domain.VehicleAmenityTestSamples.*;
import static com.ticketsystem.route.domain.VehicleTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ticketsystem.route.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class VehicleAmenityTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(VehicleAmenity.class);
        VehicleAmenity vehicleAmenity1 = getVehicleAmenitySample1();
        VehicleAmenity vehicleAmenity2 = new VehicleAmenity();
        assertThat(vehicleAmenity1).isNotEqualTo(vehicleAmenity2);

        vehicleAmenity2.setId(vehicleAmenity1.getId());
        assertThat(vehicleAmenity1).isEqualTo(vehicleAmenity2);

        vehicleAmenity2 = getVehicleAmenitySample2();
        assertThat(vehicleAmenity1).isNotEqualTo(vehicleAmenity2);
    }

    @Test
    void vehicleTest() {
        VehicleAmenity vehicleAmenity = getVehicleAmenityRandomSampleGenerator();
        Vehicle vehicleBack = getVehicleRandomSampleGenerator();

        vehicleAmenity.setVehicle(vehicleBack);
        assertThat(vehicleAmenity.getVehicle()).isEqualTo(vehicleBack);

        vehicleAmenity.vehicle(null);
        assertThat(vehicleAmenity.getVehicle()).isNull();
    }
}
