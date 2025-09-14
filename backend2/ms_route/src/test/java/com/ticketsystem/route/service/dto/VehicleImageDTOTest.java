package com.ticketsystem.route.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.ticketsystem.route.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class VehicleImageDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(VehicleImageDTO.class);
        VehicleImageDTO vehicleImageDTO1 = new VehicleImageDTO();
        vehicleImageDTO1.setId(1L);
        VehicleImageDTO vehicleImageDTO2 = new VehicleImageDTO();
        assertThat(vehicleImageDTO1).isNotEqualTo(vehicleImageDTO2);
        vehicleImageDTO2.setId(vehicleImageDTO1.getId());
        assertThat(vehicleImageDTO1).isEqualTo(vehicleImageDTO2);
        vehicleImageDTO2.setId(2L);
        assertThat(vehicleImageDTO1).isNotEqualTo(vehicleImageDTO2);
        vehicleImageDTO1.setId(null);
        assertThat(vehicleImageDTO1).isNotEqualTo(vehicleImageDTO2);
    }
}
