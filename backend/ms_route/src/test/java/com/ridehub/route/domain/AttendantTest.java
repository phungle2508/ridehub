package com.ridehub.route.domain;

import static com.ridehub.route.domain.AttendantTestSamples.*;
import static com.ridehub.route.domain.TripTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.route.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class AttendantTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Attendant.class);
        Attendant attendant1 = getAttendantSample1();
        Attendant attendant2 = new Attendant();
        assertThat(attendant1).isNotEqualTo(attendant2);

        attendant2.setId(attendant1.getId());
        assertThat(attendant1).isEqualTo(attendant2);

        attendant2 = getAttendantSample2();
        assertThat(attendant1).isNotEqualTo(attendant2);
    }

    @Test
    void tripTest() {
        Attendant attendant = getAttendantRandomSampleGenerator();
        Trip tripBack = getTripRandomSampleGenerator();

        attendant.setTrip(tripBack);
        assertThat(attendant.getTrip()).isEqualTo(tripBack);
        assertThat(tripBack.getAttendant()).isEqualTo(attendant);

        attendant.trip(null);
        assertThat(attendant.getTrip()).isNull();
        assertThat(tripBack.getAttendant()).isNull();
    }
}
