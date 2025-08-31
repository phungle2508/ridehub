package com.ticketsystem.route.domain;

import static com.ticketsystem.route.domain.RouteTestSamples.*;
import static com.ticketsystem.route.domain.ScheduleTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ticketsystem.route.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class RouteTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Route.class);
        Route route1 = getRouteSample1();
        Route route2 = new Route();
        assertThat(route1).isNotEqualTo(route2);

        route2.setId(route1.getId());
        assertThat(route1).isEqualTo(route2);

        route2 = getRouteSample2();
        assertThat(route1).isNotEqualTo(route2);
    }

    @Test
    void routeNameTest() {
        Route route = getRouteRandomSampleGenerator();
        Schedule scheduleBack = getScheduleRandomSampleGenerator();

        route.addRouteName(scheduleBack);
        assertThat(route.getRouteNames()).containsOnly(scheduleBack);
        assertThat(scheduleBack.getRoute()).isEqualTo(route);

        route.removeRouteName(scheduleBack);
        assertThat(route.getRouteNames()).doesNotContain(scheduleBack);
        assertThat(scheduleBack.getRoute()).isNull();

        route.routeNames(new HashSet<>(Set.of(scheduleBack)));
        assertThat(route.getRouteNames()).containsOnly(scheduleBack);
        assertThat(scheduleBack.getRoute()).isEqualTo(route);

        route.setRouteNames(new HashSet<>());
        assertThat(route.getRouteNames()).doesNotContain(scheduleBack);
        assertThat(scheduleBack.getRoute()).isNull();
    }
}
