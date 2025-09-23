package com.ridehub.booking.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.booking.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class FileBookingDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(FileBookingDTO.class);
        FileBookingDTO fileBookingDTO1 = new FileBookingDTO();
        fileBookingDTO1.setId(1L);
        FileBookingDTO fileBookingDTO2 = new FileBookingDTO();
        assertThat(fileBookingDTO1).isNotEqualTo(fileBookingDTO2);
        fileBookingDTO2.setId(fileBookingDTO1.getId());
        assertThat(fileBookingDTO1).isEqualTo(fileBookingDTO2);
        fileBookingDTO2.setId(2L);
        assertThat(fileBookingDTO1).isNotEqualTo(fileBookingDTO2);
        fileBookingDTO1.setId(null);
        assertThat(fileBookingDTO1).isNotEqualTo(fileBookingDTO2);
    }
}
