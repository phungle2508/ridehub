package com.ticketsystem.route.domain;

import static com.ticketsystem.route.domain.StationTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ticketsystem.route.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class StationTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Station.class);
        Station station1 = getStationSample1();
        Station station2 = new Station();
        assertThat(station1).isNotEqualTo(station2);

        station2.setId(station1.getId());
        assertThat(station1).isEqualTo(station2);

        station2 = getStationSample2();
        assertThat(station1).isNotEqualTo(station2);
    }
}
