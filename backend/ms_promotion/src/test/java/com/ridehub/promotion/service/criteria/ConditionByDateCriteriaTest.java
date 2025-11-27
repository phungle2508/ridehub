package com.ridehub.promotion.service.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class ConditionByDateCriteriaTest {

    @Test
    void newConditionByDateCriteriaHasAllFiltersNullTest() {
        var conditionByDateCriteria = new ConditionByDateCriteria();
        assertThat(conditionByDateCriteria).is(criteriaFiltersAre(Objects::isNull));
    }

    @Test
    void conditionByDateCriteriaFluentMethodsCreatesFiltersTest() {
        var conditionByDateCriteria = new ConditionByDateCriteria();

        setAllFilters(conditionByDateCriteria);

        assertThat(conditionByDateCriteria).is(criteriaFiltersAre(Objects::nonNull));
    }

    @Test
    void conditionByDateCriteriaCopyCreatesNullFilterTest() {
        var conditionByDateCriteria = new ConditionByDateCriteria();
        var copy = conditionByDateCriteria.copy();

        assertThat(conditionByDateCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::isNull)),
            criteria -> assertThat(criteria).isEqualTo(conditionByDateCriteria)
        );
    }

    @Test
    void conditionByDateCriteriaCopyDuplicatesEveryExistingFilterTest() {
        var conditionByDateCriteria = new ConditionByDateCriteria();
        setAllFilters(conditionByDateCriteria);

        var copy = conditionByDateCriteria.copy();

        assertThat(conditionByDateCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::nonNull)),
            criteria -> assertThat(criteria).isEqualTo(conditionByDateCriteria)
        );
    }

    @Test
    void toStringVerifier() {
        var conditionByDateCriteria = new ConditionByDateCriteria();

        assertThat(conditionByDateCriteria).hasToString("ConditionByDateCriteria{}");
    }

    private static void setAllFilters(ConditionByDateCriteria conditionByDateCriteria) {
        conditionByDateCriteria.id();
        conditionByDateCriteria.createdAt();
        conditionByDateCriteria.updatedAt();
        conditionByDateCriteria.isDeleted();
        conditionByDateCriteria.deletedAt();
        conditionByDateCriteria.deletedBy();
        conditionByDateCriteria.itemsId();
        conditionByDateCriteria.promotionId();
        conditionByDateCriteria.distinct();
    }

    private static Condition<ConditionByDateCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getCreatedAt()) &&
                condition.apply(criteria.getUpdatedAt()) &&
                condition.apply(criteria.getIsDeleted()) &&
                condition.apply(criteria.getDeletedAt()) &&
                condition.apply(criteria.getDeletedBy()) &&
                condition.apply(criteria.getItemsId()) &&
                condition.apply(criteria.getPromotionId()) &&
                condition.apply(criteria.getDistinct()),
            "every filter matches"
        );
    }

    private static Condition<ConditionByDateCriteria> copyFiltersAre(
        ConditionByDateCriteria copy,
        BiFunction<Object, Object, Boolean> condition
    ) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId(), copy.getId()) &&
                condition.apply(criteria.getCreatedAt(), copy.getCreatedAt()) &&
                condition.apply(criteria.getUpdatedAt(), copy.getUpdatedAt()) &&
                condition.apply(criteria.getIsDeleted(), copy.getIsDeleted()) &&
                condition.apply(criteria.getDeletedAt(), copy.getDeletedAt()) &&
                condition.apply(criteria.getDeletedBy(), copy.getDeletedBy()) &&
                condition.apply(criteria.getItemsId(), copy.getItemsId()) &&
                condition.apply(criteria.getPromotionId(), copy.getPromotionId()) &&
                condition.apply(criteria.getDistinct(), copy.getDistinct()),
            "every filter matches"
        );
    }
}
