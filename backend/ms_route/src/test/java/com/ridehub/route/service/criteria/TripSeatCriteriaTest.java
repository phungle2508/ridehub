package com.ridehub.route.service.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class TripSeatCriteriaTest {

    @Test
    void newTripSeatCriteriaHasAllFiltersNullTest() {
        var tripSeatCriteria = new TripSeatCriteria();
        assertThat(tripSeatCriteria).is(criteriaFiltersAre(Objects::isNull));
    }

    @Test
    void tripSeatCriteriaFluentMethodsCreatesFiltersTest() {
        var tripSeatCriteria = new TripSeatCriteria();

        setAllFilters(tripSeatCriteria);

        assertThat(tripSeatCriteria).is(criteriaFiltersAre(Objects::nonNull));
    }

    @Test
    void tripSeatCriteriaCopyCreatesNullFilterTest() {
        var tripSeatCriteria = new TripSeatCriteria();
        var copy = tripSeatCriteria.copy();

        assertThat(tripSeatCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::isNull)),
            criteria -> assertThat(criteria).isEqualTo(tripSeatCriteria)
        );
    }

    @Test
    void tripSeatCriteriaCopyDuplicatesEveryExistingFilterTest() {
        var tripSeatCriteria = new TripSeatCriteria();
        setAllFilters(tripSeatCriteria);

        var copy = tripSeatCriteria.copy();

        assertThat(tripSeatCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::nonNull)),
            criteria -> assertThat(criteria).isEqualTo(tripSeatCriteria)
        );
    }

    @Test
    void toStringVerifier() {
        var tripSeatCriteria = new TripSeatCriteria();

        assertThat(tripSeatCriteria).hasToString("TripSeatCriteria{}");
    }

    private static void setAllFilters(TripSeatCriteria tripSeatCriteria) {
        tripSeatCriteria.id();
        tripSeatCriteria.seatNo();
        tripSeatCriteria.floorNo();
        tripSeatCriteria.booked();
        tripSeatCriteria.priceFactor();
        tripSeatCriteria.createdAt();
        tripSeatCriteria.updatedAt();
        tripSeatCriteria.isDeleted();
        tripSeatCriteria.deletedAt();
        tripSeatCriteria.deletedBy();
        tripSeatCriteria.tripId();
        tripSeatCriteria.distinct();
    }

    private static Condition<TripSeatCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getSeatNo()) &&
                condition.apply(criteria.getFloorNo()) &&
                condition.apply(criteria.getBooked()) &&
                condition.apply(criteria.getPriceFactor()) &&
                condition.apply(criteria.getCreatedAt()) &&
                condition.apply(criteria.getUpdatedAt()) &&
                condition.apply(criteria.getIsDeleted()) &&
                condition.apply(criteria.getDeletedAt()) &&
                condition.apply(criteria.getDeletedBy()) &&
                condition.apply(criteria.getTripId()) &&
                condition.apply(criteria.getDistinct()),
            "every filter matches"
        );
    }

    private static Condition<TripSeatCriteria> copyFiltersAre(TripSeatCriteria copy, BiFunction<Object, Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId(), copy.getId()) &&
                condition.apply(criteria.getSeatNo(), copy.getSeatNo()) &&
                condition.apply(criteria.getFloorNo(), copy.getFloorNo()) &&
                condition.apply(criteria.getBooked(), copy.getBooked()) &&
                condition.apply(criteria.getPriceFactor(), copy.getPriceFactor()) &&
                condition.apply(criteria.getCreatedAt(), copy.getCreatedAt()) &&
                condition.apply(criteria.getUpdatedAt(), copy.getUpdatedAt()) &&
                condition.apply(criteria.getIsDeleted(), copy.getIsDeleted()) &&
                condition.apply(criteria.getDeletedAt(), copy.getDeletedAt()) &&
                condition.apply(criteria.getDeletedBy(), copy.getDeletedBy()) &&
                condition.apply(criteria.getTripId(), copy.getTripId()) &&
                condition.apply(criteria.getDistinct(), copy.getDistinct()),
            "every filter matches"
        );
    }
}
