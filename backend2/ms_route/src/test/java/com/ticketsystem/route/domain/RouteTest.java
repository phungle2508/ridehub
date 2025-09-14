package com.ticketsystem.route.domain;

import static com.ticketsystem.route.domain.OperatorTestSamples.*;
import static com.ticketsystem.route.domain.RouteTestSamples.*;
import static com.ticketsystem.route.domain.StationTestSamples.*;
import static com.ticketsystem.route.domain.TripTestSamples.*;
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
    void tripsTest() {
        Route route = getRouteRandomSampleGenerator();
        Trip tripBack = getTripRandomSampleGenerator();

        route.addTrips(tripBack);
        assertThat(route.getTrips()).containsOnly(tripBack);
        assertThat(tripBack.getRoute()).isEqualTo(route);

        route.removeTrips(tripBack);
        assertThat(route.getTrips()).doesNotContain(tripBack);
        assertThat(tripBack.getRoute()).isNull();

        route.trips(new HashSet<>(Set.of(tripBack)));
        assertThat(route.getTrips()).containsOnly(tripBack);
        assertThat(tripBack.getRoute()).isEqualTo(route);

        route.setTrips(new HashSet<>());
        assertThat(route.getTrips()).doesNotContain(tripBack);
        assertThat(tripBack.getRoute()).isNull();
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

    @Test
    void operatorTest() {
        Route route = getRouteRandomSampleGenerator();
        Operator operatorBack = getOperatorRandomSampleGenerator();

        route.setOperator(operatorBack);
        assertThat(route.getOperator()).isEqualTo(operatorBack);

        route.operator(null);
        assertThat(route.getOperator()).isNull();
    }
}
