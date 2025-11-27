package com.ridehub.promotion.service.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class ConditionRouteItemCriteriaTest {

    @Test
    void newConditionRouteItemCriteriaHasAllFiltersNullTest() {
        var conditionRouteItemCriteria = new ConditionRouteItemCriteria();
        assertThat(conditionRouteItemCriteria).is(criteriaFiltersAre(Objects::isNull));
    }

    @Test
    void conditionRouteItemCriteriaFluentMethodsCreatesFiltersTest() {
        var conditionRouteItemCriteria = new ConditionRouteItemCriteria();

        setAllFilters(conditionRouteItemCriteria);

        assertThat(conditionRouteItemCriteria).is(criteriaFiltersAre(Objects::nonNull));
    }

    @Test
    void conditionRouteItemCriteriaCopyCreatesNullFilterTest() {
        var conditionRouteItemCriteria = new ConditionRouteItemCriteria();
        var copy = conditionRouteItemCriteria.copy();

        assertThat(conditionRouteItemCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::isNull)),
            criteria -> assertThat(criteria).isEqualTo(conditionRouteItemCriteria)
        );
    }

    @Test
    void conditionRouteItemCriteriaCopyDuplicatesEveryExistingFilterTest() {
        var conditionRouteItemCriteria = new ConditionRouteItemCriteria();
        setAllFilters(conditionRouteItemCriteria);

        var copy = conditionRouteItemCriteria.copy();

        assertThat(conditionRouteItemCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::nonNull)),
            criteria -> assertThat(criteria).isEqualTo(conditionRouteItemCriteria)
        );
    }

    @Test
    void toStringVerifier() {
        var conditionRouteItemCriteria = new ConditionRouteItemCriteria();

        assertThat(conditionRouteItemCriteria).hasToString("ConditionRouteItemCriteria{}");
    }

    private static void setAllFilters(ConditionRouteItemCriteria conditionRouteItemCriteria) {
        conditionRouteItemCriteria.id();
        conditionRouteItemCriteria.routeId();
        conditionRouteItemCriteria.createdAt();
        conditionRouteItemCriteria.updatedAt();
        conditionRouteItemCriteria.isDeleted();
        conditionRouteItemCriteria.deletedAt();
        conditionRouteItemCriteria.deletedBy();
        conditionRouteItemCriteria.conditionId();
        conditionRouteItemCriteria.distinct();
    }

    private static Condition<ConditionRouteItemCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getRouteId()) &&
                condition.apply(criteria.getCreatedAt()) &&
                condition.apply(criteria.getUpdatedAt()) &&
                condition.apply(criteria.getIsDeleted()) &&
                condition.apply(criteria.getDeletedAt()) &&
                condition.apply(criteria.getDeletedBy()) &&
                condition.apply(criteria.getConditionId()) &&
                condition.apply(criteria.getDistinct()),
            "every filter matches"
        );
    }

    private static Condition<ConditionRouteItemCriteria> copyFiltersAre(
        ConditionRouteItemCriteria copy,
        BiFunction<Object, Object, Boolean> condition
    ) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId(), copy.getId()) &&
                condition.apply(criteria.getRouteId(), copy.getRouteId()) &&
                condition.apply(criteria.getCreatedAt(), copy.getCreatedAt()) &&
                condition.apply(criteria.getUpdatedAt(), copy.getUpdatedAt()) &&
                condition.apply(criteria.getIsDeleted(), copy.getIsDeleted()) &&
                condition.apply(criteria.getDeletedAt(), copy.getDeletedAt()) &&
                condition.apply(criteria.getDeletedBy(), copy.getDeletedBy()) &&
                condition.apply(criteria.getConditionId(), copy.getConditionId()) &&
                condition.apply(criteria.getDistinct(), copy.getDistinct()),
            "every filter matches"
        );
    }
}
