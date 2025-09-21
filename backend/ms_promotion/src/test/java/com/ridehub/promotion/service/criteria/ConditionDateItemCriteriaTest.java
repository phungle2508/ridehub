package com.ridehub.promotion.service.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class ConditionDateItemCriteriaTest {

    @Test
    void newConditionDateItemCriteriaHasAllFiltersNullTest() {
        var conditionDateItemCriteria = new ConditionDateItemCriteria();
        assertThat(conditionDateItemCriteria).is(criteriaFiltersAre(Objects::isNull));
    }

    @Test
    void conditionDateItemCriteriaFluentMethodsCreatesFiltersTest() {
        var conditionDateItemCriteria = new ConditionDateItemCriteria();

        setAllFilters(conditionDateItemCriteria);

        assertThat(conditionDateItemCriteria).is(criteriaFiltersAre(Objects::nonNull));
    }

    @Test
    void conditionDateItemCriteriaCopyCreatesNullFilterTest() {
        var conditionDateItemCriteria = new ConditionDateItemCriteria();
        var copy = conditionDateItemCriteria.copy();

        assertThat(conditionDateItemCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::isNull)),
            criteria -> assertThat(criteria).isEqualTo(conditionDateItemCriteria)
        );
    }

    @Test
    void conditionDateItemCriteriaCopyDuplicatesEveryExistingFilterTest() {
        var conditionDateItemCriteria = new ConditionDateItemCriteria();
        setAllFilters(conditionDateItemCriteria);

        var copy = conditionDateItemCriteria.copy();

        assertThat(conditionDateItemCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::nonNull)),
            criteria -> assertThat(criteria).isEqualTo(conditionDateItemCriteria)
        );
    }

    @Test
    void toStringVerifier() {
        var conditionDateItemCriteria = new ConditionDateItemCriteria();

        assertThat(conditionDateItemCriteria).hasToString("ConditionDateItemCriteria{}");
    }

    private static void setAllFilters(ConditionDateItemCriteria conditionDateItemCriteria) {
        conditionDateItemCriteria.id();
        conditionDateItemCriteria.specificDate();
        conditionDateItemCriteria.weekday();
        conditionDateItemCriteria.createdAt();
        conditionDateItemCriteria.updatedAt();
        conditionDateItemCriteria.isDeleted();
        conditionDateItemCriteria.deletedAt();
        conditionDateItemCriteria.deletedBy();
        conditionDateItemCriteria.conditionId();
        conditionDateItemCriteria.distinct();
    }

    private static Condition<ConditionDateItemCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getSpecificDate()) &&
                condition.apply(criteria.getWeekday()) &&
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

    private static Condition<ConditionDateItemCriteria> copyFiltersAre(
        ConditionDateItemCriteria copy,
        BiFunction<Object, Object, Boolean> condition
    ) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId(), copy.getId()) &&
                condition.apply(criteria.getSpecificDate(), copy.getSpecificDate()) &&
                condition.apply(criteria.getWeekday(), copy.getWeekday()) &&
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
