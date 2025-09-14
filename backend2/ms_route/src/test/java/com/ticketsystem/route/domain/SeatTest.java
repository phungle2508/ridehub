package com.ticketsystem.route.domain;

import static com.ticketsystem.route.domain.SeatTestSamples.*;
import static com.ticketsystem.route.domain.TripTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ticketsystem.route.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class SeatTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Seat.class);
        Seat seat1 = getSeatSample1();
        Seat seat2 = new Seat();
        assertThat(seat1).isNotEqualTo(seat2);

        seat2.setId(seat1.getId());
        assertThat(seat1).isEqualTo(seat2);

        seat2 = getSeatSample2();
        assertThat(seat1).isNotEqualTo(seat2);
    }

    @Test
    void tripTest() {
        Seat seat = getSeatRandomSampleGenerator();
        Trip tripBack = getTripRandomSampleGenerator();

        seat.setTrip(tripBack);
        assertThat(seat.getTrip()).isEqualTo(tripBack);

        seat.trip(null);
        assertThat(seat.getTrip()).isNull();
    }
}
