package com.ticketsystem.route.service.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class SeatCriteriaTest {

    @Test
    void newSeatCriteriaHasAllFiltersNullTest() {
        var seatCriteria = new SeatCriteria();
        assertThat(seatCriteria).is(criteriaFiltersAre(Objects::isNull));
    }

    @Test
    void seatCriteriaFluentMethodsCreatesFiltersTest() {
        var seatCriteria = new SeatCriteria();

        setAllFilters(seatCriteria);

        assertThat(seatCriteria).is(criteriaFiltersAre(Objects::nonNull));
    }

    @Test
    void seatCriteriaCopyCreatesNullFilterTest() {
        var seatCriteria = new SeatCriteria();
        var copy = seatCriteria.copy();

        assertThat(seatCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::isNull)),
            criteria -> assertThat(criteria).isEqualTo(seatCriteria)
        );
    }

    @Test
    void seatCriteriaCopyDuplicatesEveryExistingFilterTest() {
        var seatCriteria = new SeatCriteria();
        setAllFilters(seatCriteria);

        var copy = seatCriteria.copy();

        assertThat(seatCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::nonNull)),
            criteria -> assertThat(criteria).isEqualTo(seatCriteria)
        );
    }

    @Test
    void toStringVerifier() {
        var seatCriteria = new SeatCriteria();

        assertThat(seatCriteria).hasToString("SeatCriteria{}");
    }

    private static void setAllFilters(SeatCriteria seatCriteria) {
        seatCriteria.id();
        seatCriteria.seatNumber();
        seatCriteria.seatType();
        seatCriteria.deck();
        seatCriteria.priceModifier();
        seatCriteria.isAvailable();
        seatCriteria.tripId();
        seatCriteria.distinct();
    }

    private static Condition<SeatCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getSeatNumber()) &&
                condition.apply(criteria.getSeatType()) &&
                condition.apply(criteria.getDeck()) &&
                condition.apply(criteria.getPriceModifier()) &&
                condition.apply(criteria.getIsAvailable()) &&
                condition.apply(criteria.getTripId()) &&
                condition.apply(criteria.getDistinct()),
            "every filter matches"
        );
    }

    private static Condition<SeatCriteria> copyFiltersAre(SeatCriteria copy, BiFunction<Object, Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId(), copy.getId()) &&
                condition.apply(criteria.getSeatNumber(), copy.getSeatNumber()) &&
                condition.apply(criteria.getSeatType(), copy.getSeatType()) &&
                condition.apply(criteria.getDeck(), copy.getDeck()) &&
                condition.apply(criteria.getPriceModifier(), copy.getPriceModifier()) &&
                condition.apply(criteria.getIsAvailable(), copy.getIsAvailable()) &&
                condition.apply(criteria.getTripId(), copy.getTripId()) &&
                condition.apply(criteria.getDistinct(), copy.getDistinct()),
            "every filter matches"
        );
    }
}
