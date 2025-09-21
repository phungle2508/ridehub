package com.ridehub.route.domain;

import static com.ridehub.route.domain.RouteTestSamples.*;
import static com.ridehub.route.domain.StationTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.route.web.rest.TestUtil;
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
    void originTest() {
        Route route = getRouteRandomSampleGenerator();
        Station stationBack = getStationRandomSampleGenerator();

        route.setOrigin(stationBack);
        assertThat(route.getOrigin()).isEqualTo(stationBack);

        route.origin(null);
        assertThat(route.getOrigin()).isNull();
    }

    @Test
    void destinationTest() {
        Route route = getRouteRandomSampleGenerator();
        Station stationBack = getStationRandomSampleGenerator();

        route.setDestination(stationBack);
        assertThat(route.getDestination()).isEqualTo(stationBack);

        route.destination(null);
        assertThat(route.getDestination()).isNull();
    }
}
