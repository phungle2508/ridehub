package com.ticketsystem.route.domain;

import static com.ticketsystem.route.domain.RouteTestSamples.*;
import static com.ticketsystem.route.domain.SeatTestSamples.*;
import static com.ticketsystem.route.domain.TripTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ticketsystem.route.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class TripTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Trip.class);
        Trip trip1 = getTripSample1();
        Trip trip2 = new Trip();
        assertThat(trip1).isNotEqualTo(trip2);

        trip2.setId(trip1.getId());
        assertThat(trip1).isEqualTo(trip2);

        trip2 = getTripSample2();
        assertThat(trip1).isNotEqualTo(trip2);
    }

    @Test
    void seatsTest() {
        Trip trip = getTripRandomSampleGenerator();
        Seat seatBack = getSeatRandomSampleGenerator();

        trip.addSeats(seatBack);
        assertThat(trip.getSeats()).containsOnly(seatBack);
        assertThat(seatBack.getTrip()).isEqualTo(trip);

        trip.removeSeats(seatBack);
        assertThat(trip.getSeats()).doesNotContain(seatBack);
        assertThat(seatBack.getTrip()).isNull();

        trip.seats(new HashSet<>(Set.of(seatBack)));
        assertThat(trip.getSeats()).containsOnly(seatBack);
        assertThat(seatBack.getTrip()).isEqualTo(trip);

        trip.setSeats(new HashSet<>());
        assertThat(trip.getSeats()).doesNotContain(seatBack);
        assertThat(seatBack.getTrip()).isNull();
    }

    @Test
    void routeTest() {
        Trip trip = getTripRandomSampleGenerator();
        Route routeBack = getRouteRandomSampleGenerator();

        trip.setRoute(routeBack);
        assertThat(trip.getRoute()).isEqualTo(routeBack);

        trip.route(null);
        assertThat(trip.getRoute()).isNull();
    }
}
