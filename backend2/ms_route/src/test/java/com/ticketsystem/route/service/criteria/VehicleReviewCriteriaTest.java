package com.ticketsystem.route.service.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class VehicleReviewCriteriaTest {

    @Test
    void newVehicleReviewCriteriaHasAllFiltersNullTest() {
        var vehicleReviewCriteria = new VehicleReviewCriteria();
        assertThat(vehicleReviewCriteria).is(criteriaFiltersAre(Objects::isNull));
    }

    @Test
    void vehicleReviewCriteriaFluentMethodsCreatesFiltersTest() {
        var vehicleReviewCriteria = new VehicleReviewCriteria();

        setAllFilters(vehicleReviewCriteria);

        assertThat(vehicleReviewCriteria).is(criteriaFiltersAre(Objects::nonNull));
    }

    @Test
    void vehicleReviewCriteriaCopyCreatesNullFilterTest() {
        var vehicleReviewCriteria = new VehicleReviewCriteria();
        var copy = vehicleReviewCriteria.copy();

        assertThat(vehicleReviewCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::isNull)),
            criteria -> assertThat(criteria).isEqualTo(vehicleReviewCriteria)
        );
    }

    @Test
    void vehicleReviewCriteriaCopyDuplicatesEveryExistingFilterTest() {
        var vehicleReviewCriteria = new VehicleReviewCriteria();
        setAllFilters(vehicleReviewCriteria);

        var copy = vehicleReviewCriteria.copy();

        assertThat(vehicleReviewCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::nonNull)),
            criteria -> assertThat(criteria).isEqualTo(vehicleReviewCriteria)
        );
    }

    @Test
    void toStringVerifier() {
        var vehicleReviewCriteria = new VehicleReviewCriteria();

        assertThat(vehicleReviewCriteria).hasToString("VehicleReviewCriteria{}");
    }

    private static void setAllFilters(VehicleReviewCriteria vehicleReviewCriteria) {
        vehicleReviewCriteria.id();
        vehicleReviewCriteria.userId();
        vehicleReviewCriteria.tripId();
        vehicleReviewCriteria.rating();
        vehicleReviewCriteria.comment();
        vehicleReviewCriteria.cleanliness();
        vehicleReviewCriteria.comfort();
        vehicleReviewCriteria.punctuality();
        vehicleReviewCriteria.staffService();
        vehicleReviewCriteria.createdAt();
        vehicleReviewCriteria.isVerified();
        vehicleReviewCriteria.vehicleId();
        vehicleReviewCriteria.distinct();
    }

    private static Condition<VehicleReviewCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getUserId()) &&
                condition.apply(criteria.getTripId()) &&
                condition.apply(criteria.getRating()) &&
                condition.apply(criteria.getComment()) &&
                condition.apply(criteria.getCleanliness()) &&
                condition.apply(criteria.getComfort()) &&
                condition.apply(criteria.getPunctuality()) &&
                condition.apply(criteria.getStaffService()) &&
                condition.apply(criteria.getCreatedAt()) &&
                condition.apply(criteria.getIsVerified()) &&
                condition.apply(criteria.getVehicleId()) &&
                condition.apply(criteria.getDistinct()),
            "every filter matches"
        );
    }

    private static Condition<VehicleReviewCriteria> copyFiltersAre(
        VehicleReviewCriteria copy,
        BiFunction<Object, Object, Boolean> condition
    ) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId(), copy.getId()) &&
                condition.apply(criteria.getUserId(), copy.getUserId()) &&
                condition.apply(criteria.getTripId(), copy.getTripId()) &&
                condition.apply(criteria.getRating(), copy.getRating()) &&
                condition.apply(criteria.getComment(), copy.getComment()) &&
                condition.apply(criteria.getCleanliness(), copy.getCleanliness()) &&
                condition.apply(criteria.getComfort(), copy.getComfort()) &&
                condition.apply(criteria.getPunctuality(), copy.getPunctuality()) &&
                condition.apply(criteria.getStaffService(), copy.getStaffService()) &&
                condition.apply(criteria.getCreatedAt(), copy.getCreatedAt()) &&
                condition.apply(criteria.getIsVerified(), copy.getIsVerified()) &&
                condition.apply(criteria.getVehicleId(), copy.getVehicleId()) &&
                condition.apply(criteria.getDistinct(), copy.getDistinct()),
            "every filter matches"
        );
    }
}
