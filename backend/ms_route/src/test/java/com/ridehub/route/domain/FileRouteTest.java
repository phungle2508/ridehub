package com.ridehub.route.domain;

import static com.ridehub.route.domain.FileRouteTestSamples.*;
import static com.ridehub.route.domain.SeatMapTestSamples.*;
import static com.ridehub.route.domain.StationTestSamples.*;
import static com.ridehub.route.domain.VehicleTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.route.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class FileRouteTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(FileRoute.class);
        FileRoute fileRoute1 = getFileRouteSample1();
        FileRoute fileRoute2 = new FileRoute();
        assertThat(fileRoute1).isNotEqualTo(fileRoute2);

        fileRoute2.setId(fileRoute1.getId());
        assertThat(fileRoute1).isEqualTo(fileRoute2);

        fileRoute2 = getFileRouteSample2();
        assertThat(fileRoute1).isNotEqualTo(fileRoute2);
    }

    @Test
    void stationTest() {
        FileRoute fileRoute = getFileRouteRandomSampleGenerator();
        Station stationBack = getStationRandomSampleGenerator();

        fileRoute.setStation(stationBack);
        assertThat(fileRoute.getStation()).isEqualTo(stationBack);
        assertThat(stationBack.getStationImg()).isEqualTo(fileRoute);

        fileRoute.station(null);
        assertThat(fileRoute.getStation()).isNull();
        assertThat(stationBack.getStationImg()).isNull();
    }

    @Test
    void vehicleTest() {
        FileRoute fileRoute = getFileRouteRandomSampleGenerator();
        Vehicle vehicleBack = getVehicleRandomSampleGenerator();

        fileRoute.setVehicle(vehicleBack);
        assertThat(fileRoute.getVehicle()).isEqualTo(vehicleBack);
        assertThat(vehicleBack.getVehicleImg()).isEqualTo(fileRoute);

        fileRoute.vehicle(null);
        assertThat(fileRoute.getVehicle()).isNull();
        assertThat(vehicleBack.getVehicleImg()).isNull();
    }

    @Test
    void seatMapTest() {
        FileRoute fileRoute = getFileRouteRandomSampleGenerator();
        SeatMap seatMapBack = getSeatMapRandomSampleGenerator();

        fileRoute.setSeatMap(seatMapBack);
        assertThat(fileRoute.getSeatMap()).isEqualTo(seatMapBack);
        assertThat(seatMapBack.getSeatMapImg()).isEqualTo(fileRoute);

        fileRoute.seatMap(null);
        assertThat(fileRoute.getSeatMap()).isNull();
        assertThat(seatMapBack.getSeatMapImg()).isNull();
    }
}
