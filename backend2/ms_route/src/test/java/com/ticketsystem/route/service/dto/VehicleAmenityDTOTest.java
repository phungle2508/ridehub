package com.ticketsystem.route.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.ticketsystem.route.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class VehicleAmenityDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(VehicleAmenityDTO.class);
        VehicleAmenityDTO vehicleAmenityDTO1 = new VehicleAmenityDTO();
        vehicleAmenityDTO1.setId(1L);
        VehicleAmenityDTO vehicleAmenityDTO2 = new VehicleAmenityDTO();
        assertThat(vehicleAmenityDTO1).isNotEqualTo(vehicleAmenityDTO2);
        vehicleAmenityDTO2.setId(vehicleAmenityDTO1.getId());
        assertThat(vehicleAmenityDTO1).isEqualTo(vehicleAmenityDTO2);
        vehicleAmenityDTO2.setId(2L);
        assertThat(vehicleAmenityDTO1).isNotEqualTo(vehicleAmenityDTO2);
        vehicleAmenityDTO1.setId(null);
        assertThat(vehicleAmenityDTO1).isNotEqualTo(vehicleAmenityDTO2);
    }
}
