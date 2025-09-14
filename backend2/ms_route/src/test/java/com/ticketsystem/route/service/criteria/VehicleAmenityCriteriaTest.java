package com.ticketsystem.route.service.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class VehicleAmenityCriteriaTest {

    @Test
    void newVehicleAmenityCriteriaHasAllFiltersNullTest() {
        var vehicleAmenityCriteria = new VehicleAmenityCriteria();
        assertThat(vehicleAmenityCriteria).is(criteriaFiltersAre(Objects::isNull));
    }

    @Test
    void vehicleAmenityCriteriaFluentMethodsCreatesFiltersTest() {
        var vehicleAmenityCriteria = new VehicleAmenityCriteria();

        setAllFilters(vehicleAmenityCriteria);

        assertThat(vehicleAmenityCriteria).is(criteriaFiltersAre(Objects::nonNull));
    }

    @Test
    void vehicleAmenityCriteriaCopyCreatesNullFilterTest() {
        var vehicleAmenityCriteria = new VehicleAmenityCriteria();
        var copy = vehicleAmenityCriteria.copy();

        assertThat(vehicleAmenityCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::isNull)),
            criteria -> assertThat(criteria).isEqualTo(vehicleAmenityCriteria)
        );
    }

    @Test
    void vehicleAmenityCriteriaCopyDuplicatesEveryExistingFilterTest() {
        var vehicleAmenityCriteria = new VehicleAmenityCriteria();
        setAllFilters(vehicleAmenityCriteria);

        var copy = vehicleAmenityCriteria.copy();

        assertThat(vehicleAmenityCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::nonNull)),
            criteria -> assertThat(criteria).isEqualTo(vehicleAmenityCriteria)
        );
    }

    @Test
    void toStringVerifier() {
        var vehicleAmenityCriteria = new VehicleAmenityCriteria();

        assertThat(vehicleAmenityCriteria).hasToString("VehicleAmenityCriteria{}");
    }

    private static void setAllFilters(VehicleAmenityCriteria vehicleAmenityCriteria) {
        vehicleAmenityCriteria.id();
        vehicleAmenityCriteria.amenity();
        vehicleAmenityCriteria.description();
        vehicleAmenityCriteria.vehicleId();
        vehicleAmenityCriteria.distinct();
    }

    private static Condition<VehicleAmenityCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getAmenity()) &&
                condition.apply(criteria.getDescription()) &&
                condition.apply(criteria.getVehicleId()) &&
                condition.apply(criteria.getDistinct()),
            "every filter matches"
        );
    }

    private static Condition<VehicleAmenityCriteria> copyFiltersAre(
        VehicleAmenityCriteria copy,
        BiFunction<Object, Object, Boolean> condition
    ) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId(), copy.getId()) &&
                condition.apply(criteria.getAmenity(), copy.getAmenity()) &&
                condition.apply(criteria.getDescription(), copy.getDescription()) &&
                condition.apply(criteria.getVehicleId(), copy.getVehicleId()) &&
                condition.apply(criteria.getDistinct(), copy.getDistinct()),
            "every filter matches"
        );
    }
}
