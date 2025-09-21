package com.ridehub.promotion.service.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class ConditionByRouteCriteriaTest {

    @Test
    void newConditionByRouteCriteriaHasAllFiltersNullTest() {
        var conditionByRouteCriteria = new ConditionByRouteCriteria();
        assertThat(conditionByRouteCriteria).is(criteriaFiltersAre(Objects::isNull));
    }

    @Test
    void conditionByRouteCriteriaFluentMethodsCreatesFiltersTest() {
        var conditionByRouteCriteria = new ConditionByRouteCriteria();

        setAllFilters(conditionByRouteCriteria);

        assertThat(conditionByRouteCriteria).is(criteriaFiltersAre(Objects::nonNull));
    }

    @Test
    void conditionByRouteCriteriaCopyCreatesNullFilterTest() {
        var conditionByRouteCriteria = new ConditionByRouteCriteria();
        var copy = conditionByRouteCriteria.copy();

        assertThat(conditionByRouteCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::isNull)),
            criteria -> assertThat(criteria).isEqualTo(conditionByRouteCriteria)
        );
    }

    @Test
    void conditionByRouteCriteriaCopyDuplicatesEveryExistingFilterTest() {
        var conditionByRouteCriteria = new ConditionByRouteCriteria();
        setAllFilters(conditionByRouteCriteria);

        var copy = conditionByRouteCriteria.copy();

        assertThat(conditionByRouteCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::nonNull)),
            criteria -> assertThat(criteria).isEqualTo(conditionByRouteCriteria)
        );
    }

    @Test
    void toStringVerifier() {
        var conditionByRouteCriteria = new ConditionByRouteCriteria();

        assertThat(conditionByRouteCriteria).hasToString("ConditionByRouteCriteria{}");
    }

    private static void setAllFilters(ConditionByRouteCriteria conditionByRouteCriteria) {
        conditionByRouteCriteria.id();
        conditionByRouteCriteria.routeId();
        conditionByRouteCriteria.createdAt();
        conditionByRouteCriteria.updatedAt();
        conditionByRouteCriteria.isDeleted();
        conditionByRouteCriteria.deletedAt();
        conditionByRouteCriteria.deletedBy();
        conditionByRouteCriteria.promotionId();
        conditionByRouteCriteria.distinct();
    }

    private static Condition<ConditionByRouteCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getRouteId()) &&
                condition.apply(criteria.getCreatedAt()) &&
                condition.apply(criteria.getUpdatedAt()) &&
                condition.apply(criteria.getIsDeleted()) &&
                condition.apply(criteria.getDeletedAt()) &&
                condition.apply(criteria.getDeletedBy()) &&
                condition.apply(criteria.getPromotionId()) &&
                condition.apply(criteria.getDistinct()),
            "every filter matches"
        );
    }

    private static Condition<ConditionByRouteCriteria> copyFiltersAre(
        ConditionByRouteCriteria copy,
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
                condition.apply(criteria.getPromotionId(), copy.getPromotionId()) &&
                condition.apply(criteria.getDistinct(), copy.getDistinct()),
            "every filter matches"
        );
    }
}
