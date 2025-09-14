package com.ticketsystem.route.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.ticketsystem.route.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class VehicleReviewDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(VehicleReviewDTO.class);
        VehicleReviewDTO vehicleReviewDTO1 = new VehicleReviewDTO();
        vehicleReviewDTO1.setId(1L);
        VehicleReviewDTO vehicleReviewDTO2 = new VehicleReviewDTO();
        assertThat(vehicleReviewDTO1).isNotEqualTo(vehicleReviewDTO2);
        vehicleReviewDTO2.setId(vehicleReviewDTO1.getId());
        assertThat(vehicleReviewDTO1).isEqualTo(vehicleReviewDTO2);
        vehicleReviewDTO2.setId(2L);
        assertThat(vehicleReviewDTO1).isNotEqualTo(vehicleReviewDTO2);
        vehicleReviewDTO1.setId(null);
        assertThat(vehicleReviewDTO1).isNotEqualTo(vehicleReviewDTO2);
    }
}
