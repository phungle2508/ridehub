package com.ridehub.route.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.route.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class TripSeatDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(TripSeatDTO.class);
        TripSeatDTO tripSeatDTO1 = new TripSeatDTO();
        tripSeatDTO1.setId(1L);
        TripSeatDTO tripSeatDTO2 = new TripSeatDTO();
        assertThat(tripSeatDTO1).isNotEqualTo(tripSeatDTO2);
        tripSeatDTO2.setId(tripSeatDTO1.getId());
        assertThat(tripSeatDTO1).isEqualTo(tripSeatDTO2);
        tripSeatDTO2.setId(2L);
        assertThat(tripSeatDTO1).isNotEqualTo(tripSeatDTO2);
        tripSeatDTO1.setId(null);
        assertThat(tripSeatDTO1).isNotEqualTo(tripSeatDTO2);
    }
}
