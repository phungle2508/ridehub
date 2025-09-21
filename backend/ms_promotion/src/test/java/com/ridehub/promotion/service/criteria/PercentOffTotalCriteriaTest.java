package com.ridehub.promotion.service.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class PercentOffTotalCriteriaTest {

    @Test
    void newPercentOffTotalCriteriaHasAllFiltersNullTest() {
        var percentOffTotalCriteria = new PercentOffTotalCriteria();
        assertThat(percentOffTotalCriteria).is(criteriaFiltersAre(Objects::isNull));
    }

    @Test
    void percentOffTotalCriteriaFluentMethodsCreatesFiltersTest() {
        var percentOffTotalCriteria = new PercentOffTotalCriteria();

        setAllFilters(percentOffTotalCriteria);

        assertThat(percentOffTotalCriteria).is(criteriaFiltersAre(Objects::nonNull));
    }

    @Test
    void percentOffTotalCriteriaCopyCreatesNullFilterTest() {
        var percentOffTotalCriteria = new PercentOffTotalCriteria();
        var copy = percentOffTotalCriteria.copy();

        assertThat(percentOffTotalCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::isNull)),
            criteria -> assertThat(criteria).isEqualTo(percentOffTotalCriteria)
        );
    }

    @Test
    void percentOffTotalCriteriaCopyDuplicatesEveryExistingFilterTest() {
        var percentOffTotalCriteria = new PercentOffTotalCriteria();
        setAllFilters(percentOffTotalCriteria);

        var copy = percentOffTotalCriteria.copy();

        assertThat(percentOffTotalCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::nonNull)),
            criteria -> assertThat(criteria).isEqualTo(percentOffTotalCriteria)
        );
    }

    @Test
    void toStringVerifier() {
        var percentOffTotalCriteria = new PercentOffTotalCriteria();

        assertThat(percentOffTotalCriteria).hasToString("PercentOffTotalCriteria{}");
    }

    private static void setAllFilters(PercentOffTotalCriteria percentOffTotalCriteria) {
        percentOffTotalCriteria.id();
        percentOffTotalCriteria.percent();
        percentOffTotalCriteria.maxOff();
        percentOffTotalCriteria.createdAt();
        percentOffTotalCriteria.updatedAt();
        percentOffTotalCriteria.isDeleted();
        percentOffTotalCriteria.deletedAt();
        percentOffTotalCriteria.deletedBy();
        percentOffTotalCriteria.promotionId();
        percentOffTotalCriteria.distinct();
    }

    private static Condition<PercentOffTotalCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getPercent()) &&
                condition.apply(criteria.getMaxOff()) &&
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

    private static Condition<PercentOffTotalCriteria> copyFiltersAre(
        PercentOffTotalCriteria copy,
        BiFunction<Object, Object, Boolean> condition
    ) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId(), copy.getId()) &&
                condition.apply(criteria.getPercent(), copy.getPercent()) &&
                condition.apply(criteria.getMaxOff(), copy.getMaxOff()) &&
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
