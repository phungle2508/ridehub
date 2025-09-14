package com.ticketsystem.route.domain;

import static com.ticketsystem.route.domain.OperatorTestSamples.*;
import static com.ticketsystem.route.domain.RouteTestSamples.*;
import static com.ticketsystem.route.domain.VehicleTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ticketsystem.route.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class OperatorTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Operator.class);
        Operator operator1 = getOperatorSample1();
        Operator operator2 = new Operator();
        assertThat(operator1).isNotEqualTo(operator2);

        operator2.setId(operator1.getId());
        assertThat(operator1).isEqualTo(operator2);

        operator2 = getOperatorSample2();
        assertThat(operator1).isNotEqualTo(operator2);
    }

    @Test
    void vehiclesTest() {
        Operator operator = getOperatorRandomSampleGenerator();
        Vehicle vehicleBack = getVehicleRandomSampleGenerator();

        operator.addVehicles(vehicleBack);
        assertThat(operator.getVehicles()).containsOnly(vehicleBack);
        assertThat(vehicleBack.getOperator()).isEqualTo(operator);

        operator.removeVehicles(vehicleBack);
        assertThat(operator.getVehicles()).doesNotContain(vehicleBack);
        assertThat(vehicleBack.getOperator()).isNull();

        operator.vehicles(new HashSet<>(Set.of(vehicleBack)));
        assertThat(operator.getVehicles()).containsOnly(vehicleBack);
        assertThat(vehicleBack.getOperator()).isEqualTo(operator);

        operator.setVehicles(new HashSet<>());
        assertThat(operator.getVehicles()).doesNotContain(vehicleBack);
        assertThat(vehicleBack.getOperator()).isNull();
    }

    @Test
    void routesTest() {
        Operator operator = getOperatorRandomSampleGenerator();
        Route routeBack = getRouteRandomSampleGenerator();

        operator.addRoutes(routeBack);
        assertThat(operator.getRoutes()).containsOnly(routeBack);
        assertThat(routeBack.getOperator()).isEqualTo(operator);

        operator.removeRoutes(routeBack);
        assertThat(operator.getRoutes()).doesNotContain(routeBack);
        assertThat(routeBack.getOperator()).isNull();

        operator.routes(new HashSet<>(Set.of(routeBack)));
        assertThat(operator.getRoutes()).containsOnly(routeBack);
        assertThat(routeBack.getOperator()).isEqualTo(operator);

        operator.setRoutes(new HashSet<>());
        assertThat(operator.getRoutes()).doesNotContain(routeBack);
        assertThat(routeBack.getOperator()).isNull();
    }
}
