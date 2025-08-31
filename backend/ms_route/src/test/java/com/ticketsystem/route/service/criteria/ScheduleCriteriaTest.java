package com.ticketsystem.route.service.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class ScheduleCriteriaTest {

    @Test
    void newScheduleCriteriaHasAllFiltersNullTest() {
        var scheduleCriteria = new ScheduleCriteria();
        assertThat(scheduleCriteria).is(criteriaFiltersAre(Objects::isNull));
    }

    @Test
    void scheduleCriteriaFluentMethodsCreatesFiltersTest() {
        var scheduleCriteria = new ScheduleCriteria();

        setAllFilters(scheduleCriteria);

        assertThat(scheduleCriteria).is(criteriaFiltersAre(Objects::nonNull));
    }

    @Test
    void scheduleCriteriaCopyCreatesNullFilterTest() {
        var scheduleCriteria = new ScheduleCriteria();
        var copy = scheduleCriteria.copy();

        assertThat(scheduleCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::isNull)),
            criteria -> assertThat(criteria).isEqualTo(scheduleCriteria)
        );
    }

    @Test
    void scheduleCriteriaCopyDuplicatesEveryExistingFilterTest() {
        var scheduleCriteria = new ScheduleCriteria();
        setAllFilters(scheduleCriteria);

        var copy = scheduleCriteria.copy();

        assertThat(scheduleCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::nonNull)),
            criteria -> assertThat(criteria).isEqualTo(scheduleCriteria)
        );
    }

    @Test
    void toStringVerifier() {
        var scheduleCriteria = new ScheduleCriteria();

        assertThat(scheduleCriteria).hasToString("ScheduleCriteria{}");
    }

    private static void setAllFilters(ScheduleCriteria scheduleCriteria) {
        scheduleCriteria.id();
        scheduleCriteria.departureTime();
        scheduleCriteria.arrivalTime();
        scheduleCriteria.totalSeats();
        scheduleCriteria.availableSeats();
        scheduleCriteria.basePrice();
        scheduleCriteria.isActive();
        scheduleCriteria.createdAt();
        scheduleCriteria.updatedAt();
        scheduleCriteria.routeId();
        scheduleCriteria.distinct();
    }

    private static Condition<ScheduleCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getDepartureTime()) &&
                condition.apply(criteria.getArrivalTime()) &&
                condition.apply(criteria.getTotalSeats()) &&
                condition.apply(criteria.getAvailableSeats()) &&
                condition.apply(criteria.getBasePrice()) &&
                condition.apply(criteria.getIsActive()) &&
                condition.apply(criteria.getCreatedAt()) &&
                condition.apply(criteria.getUpdatedAt()) &&
                condition.apply(criteria.getRouteId()) &&
                condition.apply(criteria.getDistinct()),
            "every filter matches"
        );
    }

    private static Condition<ScheduleCriteria> copyFiltersAre(ScheduleCriteria copy, BiFunction<Object, Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId(), copy.getId()) &&
                condition.apply(criteria.getDepartureTime(), copy.getDepartureTime()) &&
                condition.apply(criteria.getArrivalTime(), copy.getArrivalTime()) &&
                condition.apply(criteria.getTotalSeats(), copy.getTotalSeats()) &&
                condition.apply(criteria.getAvailableSeats(), copy.getAvailableSeats()) &&
                condition.apply(criteria.getBasePrice(), copy.getBasePrice()) &&
                condition.apply(criteria.getIsActive(), copy.getIsActive()) &&
                condition.apply(criteria.getCreatedAt(), copy.getCreatedAt()) &&
                condition.apply(criteria.getUpdatedAt(), copy.getUpdatedAt()) &&
                condition.apply(criteria.getRouteId(), copy.getRouteId()) &&
                condition.apply(criteria.getDistinct(), copy.getDistinct()),
            "every filter matches"
        );
    }
}
