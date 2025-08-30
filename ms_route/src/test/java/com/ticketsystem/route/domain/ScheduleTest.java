package com.ticketsystem.route.domain;

import static com.ticketsystem.route.domain.RouteTestSamples.*;
import static com.ticketsystem.route.domain.ScheduleTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ticketsystem.route.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class ScheduleTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Schedule.class);
        Schedule schedule1 = getScheduleSample1();
        Schedule schedule2 = new Schedule();
        assertThat(schedule1).isNotEqualTo(schedule2);

        schedule2.setId(schedule1.getId());
        assertThat(schedule1).isEqualTo(schedule2);

        schedule2 = getScheduleSample2();
        assertThat(schedule1).isNotEqualTo(schedule2);
    }

    @Test
    void routeTest() {
        Schedule schedule = getScheduleRandomSampleGenerator();
        Route routeBack = getRouteRandomSampleGenerator();

        schedule.setRoute(routeBack);
        assertThat(schedule.getRoute()).isEqualTo(routeBack);

        schedule.route(null);
        assertThat(schedule.getRoute()).isNull();
    }
}
