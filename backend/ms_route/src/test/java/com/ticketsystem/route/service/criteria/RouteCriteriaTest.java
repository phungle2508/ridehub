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
        routeCriteria.routeName();
        routeCriteria.origin();
        routeCriteria.destination();
        routeCriteria.distance();
        routeCriteria.estimatedDuration();
        routeCriteria.transportType();
        routeCriteria.isActive();
        routeCriteria.createdAt();
        routeCriteria.updatedAt();
        routeCriteria.routeNameId();
        routeCriteria.distinct();
    }

    private static Condition<RouteCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getRouteName()) &&
                condition.apply(criteria.getOrigin()) &&
                condition.apply(criteria.getDestination()) &&
                condition.apply(criteria.getDistance()) &&
                condition.apply(criteria.getEstimatedDuration()) &&
                condition.apply(criteria.getTransportType()) &&
                condition.apply(criteria.getIsActive()) &&
                condition.apply(criteria.getCreatedAt()) &&
                condition.apply(criteria.getUpdatedAt()) &&
                condition.apply(criteria.getRouteNameId()) &&
                condition.apply(criteria.getDistinct()),
            "every filter matches"
        );
    }

    private static Condition<RouteCriteria> copyFiltersAre(RouteCriteria copy, BiFunction<Object, Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId(), copy.getId()) &&
                condition.apply(criteria.getRouteName(), copy.getRouteName()) &&
                condition.apply(criteria.getOrigin(), copy.getOrigin()) &&
                condition.apply(criteria.getDestination(), copy.getDestination()) &&
                condition.apply(criteria.getDistance(), copy.getDistance()) &&
                condition.apply(criteria.getEstimatedDuration(), copy.getEstimatedDuration()) &&
                condition.apply(criteria.getTransportType(), copy.getTransportType()) &&
                condition.apply(criteria.getIsActive(), copy.getIsActive()) &&
                condition.apply(criteria.getCreatedAt(), copy.getCreatedAt()) &&
                condition.apply(criteria.getUpdatedAt(), copy.getUpdatedAt()) &&
                condition.apply(criteria.getRouteNameId(), copy.getRouteNameId()) &&
                condition.apply(criteria.getDistinct(), copy.getDistinct()),
            "every filter matches"
        );
    }
}
