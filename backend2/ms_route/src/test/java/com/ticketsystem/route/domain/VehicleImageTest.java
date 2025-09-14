package com.ticketsystem.route.domain;

import static com.ticketsystem.route.domain.VehicleImageTestSamples.*;
import static com.ticketsystem.route.domain.VehicleTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ticketsystem.route.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class VehicleImageTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(VehicleImage.class);
        VehicleImage vehicleImage1 = getVehicleImageSample1();
        VehicleImage vehicleImage2 = new VehicleImage();
        assertThat(vehicleImage1).isNotEqualTo(vehicleImage2);

        vehicleImage2.setId(vehicleImage1.getId());
        assertThat(vehicleImage1).isEqualTo(vehicleImage2);

        vehicleImage2 = getVehicleImageSample2();
        assertThat(vehicleImage1).isNotEqualTo(vehicleImage2);
    }

    @Test
    void vehicleTest() {
        VehicleImage vehicleImage = getVehicleImageRandomSampleGenerator();
        Vehicle vehicleBack = getVehicleRandomSampleGenerator();

        vehicleImage.setVehicle(vehicleBack);
        assertThat(vehicleImage.getVehicle()).isEqualTo(vehicleBack);

        vehicleImage.vehicle(null);
        assertThat(vehicleImage.getVehicle()).isNull();
    }
}
