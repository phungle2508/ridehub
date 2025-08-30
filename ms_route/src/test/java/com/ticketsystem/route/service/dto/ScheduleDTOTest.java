package com.ticketsystem.route.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.ticketsystem.route.web.rest.TestUtil;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class ScheduleDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(ScheduleDTO.class);
        ScheduleDTO scheduleDTO1 = new ScheduleDTO();
        scheduleDTO1.setId(UUID.randomUUID());
        ScheduleDTO scheduleDTO2 = new ScheduleDTO();
        assertThat(scheduleDTO1).isNotEqualTo(scheduleDTO2);
        scheduleDTO2.setId(scheduleDTO1.getId());
        assertThat(scheduleDTO1).isEqualTo(scheduleDTO2);
        scheduleDTO2.setId(UUID.randomUUID());
        assertThat(scheduleDTO1).isNotEqualTo(scheduleDTO2);
        scheduleDTO1.setId(null);
        assertThat(scheduleDTO1).isNotEqualTo(scheduleDTO2);
    }
}
