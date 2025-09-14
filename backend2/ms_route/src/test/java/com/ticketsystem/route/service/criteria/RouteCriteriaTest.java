package com.ticketsystem.route.service.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class RouteCriteriaTest {

    @Test
    void newRouteCriteriaHasAllFiltersNullTest() {
        var routeCriteria = new RouteCriteria();
        assertThat(routeCriteria).is(criteriaFiltersAre(Objects::isNull));
    }

    @Test
    void routeCriteriaFluentMethodsCreatesFiltersTest() {
        var routeCriteria = new RouteCriteria();

        setAllFilters(routeCriteria);

        assertThat(routeCriteria).is(criteriaFiltersAre(Objects::nonNull));
    }

    @Test
    void routeCriteriaCopyCreatesNullFilterTest() {
        var routeCriteria = new RouteCriteria();
        var copy = routeCriteria.copy();

        assertThat(routeCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::isNull)),
            criteria -> assertThat(criteria).isEqualTo(routeCriteria)
        );
    }

    @Test
    void routeCriteriaCopyDuplicatesEveryExistingFilterTest() {
        var routeCriteria = new RouteCriteria();
        setAllFilters(routeCriteria);

        var copy = routeCriteria.copy();

        assertThat(routeCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::nonNull)),
            criteria -> assertThat(criteria).isEqualTo(routeCriteria)
        );
    }

    @Test
    void toStringVerifier() {
        var routeCriteria = new RouteCriteria();

        assertThat(routeCriteria).hasToString("RouteCriteria{}");
    }

    private static void setAllFilters(RouteCriteria routeCriteria) {
        routeCriteria.id();
        routeCriteria.transportType();
        routeCriteria.distance();
        routeCriteria.estimatedDuration();
        routeCriteria.basePrice();
        routeCriteria.isActive();
        routeCriteria.tripsId();
        routeCriteria.originId();
        routeCriteria.destinationId();
        routeCriteria.operatorId();
        routeCriteria.distinct();
    }

    private static Condition<RouteCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getTransportType()) &&
                condition.apply(criteria.getDistance()) &&
                condition.apply(criteria.getEstimatedDuration()) &&
                condition.apply(criteria.getBasePrice()) &&
                condition.apply(criteria.getIsActive()) &&
                condition.apply(criteria.getTripsId()) &&
                condition.apply(criteria.getOriginId()) &&
                condition.apply(criteria.getDestinationId()) &&
                condition.apply(criteria.getOperatorId()) &&
                condition.apply(criteria.getDistinct()),
            "every filter matches"
        );
    }

    private static Condition<RouteCriteria> copyFiltersAre(RouteCriteria copy, BiFunction<Object, Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId(), copy.getId()) &&
                condition.apply(criteria.getTransportType(), copy.getTransportType()) &&
                condition.apply(criteria.getDistance(), copy.getDistance()) &&
                condition.apply(criteria.getEstimatedDuration(), copy.getEstimatedDuration()) &&
                condition.apply(criteria.getBasePrice(), copy.getBasePrice()) &&
                condition.apply(criteria.getIsActive(), copy.getIsActive()) &&
                condition.apply(criteria.getTripsId(), copy.getTripsId()) &&
                condition.apply(criteria.getOriginId(), copy.getOriginId()) &&
                condition.apply(criteria.getDestinationId(), copy.getDestinationId()) &&
                condition.apply(criteria.getOperatorId(), copy.getOperatorId()) &&
                condition.apply(criteria.getDistinct(), copy.getDistinct()),
            "every filter matches"
        );
    }
}
