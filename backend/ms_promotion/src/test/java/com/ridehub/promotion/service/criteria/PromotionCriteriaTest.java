package com.ridehub.promotion.service.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class PromotionCriteriaTest {

    @Test
    void newPromotionCriteriaHasAllFiltersNullTest() {
        var promotionCriteria = new PromotionCriteria();
        assertThat(promotionCriteria).is(criteriaFiltersAre(Objects::isNull));
    }

    @Test
    void promotionCriteriaFluentMethodsCreatesFiltersTest() {
        var promotionCriteria = new PromotionCriteria();

        setAllFilters(promotionCriteria);

        assertThat(promotionCriteria).is(criteriaFiltersAre(Objects::nonNull));
    }

    @Test
    void promotionCriteriaCopyCreatesNullFilterTest() {
        var promotionCriteria = new PromotionCriteria();
        var copy = promotionCriteria.copy();

        assertThat(promotionCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::isNull)),
            criteria -> assertThat(criteria).isEqualTo(promotionCriteria)
        );
    }

    @Test
    void promotionCriteriaCopyDuplicatesEveryExistingFilterTest() {
        var promotionCriteria = new PromotionCriteria();
        setAllFilters(promotionCriteria);

        var copy = promotionCriteria.copy();

        assertThat(promotionCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::nonNull)),
            criteria -> assertThat(criteria).isEqualTo(promotionCriteria)
        );
    }

    @Test
    void toStringVerifier() {
        var promotionCriteria = new PromotionCriteria();

        assertThat(promotionCriteria).hasToString("PromotionCriteria{}");
    }

    private static void setAllFilters(PromotionCriteria promotionCriteria) {
        promotionCriteria.id();
        promotionCriteria.code();
        promotionCriteria.description();
        promotionCriteria.startDate();
        promotionCriteria.endDate();
        promotionCriteria.usageLimit();
        promotionCriteria.usedCount();
        promotionCriteria.createdAt();
        promotionCriteria.updatedAt();
        promotionCriteria.isDeleted();
        promotionCriteria.deletedAt();
        promotionCriteria.deletedBy();
        promotionCriteria.buyNGetMId();
        promotionCriteria.percentOffId();
        promotionCriteria.conditionsRId();
        promotionCriteria.conditionsDId();
        promotionCriteria.conditionsLocId();
        promotionCriteria.distinct();
    }

    private static Condition<PromotionCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getCode()) &&
                condition.apply(criteria.getDescription()) &&
                condition.apply(criteria.getStartDate()) &&
                condition.apply(criteria.getEndDate()) &&
                condition.apply(criteria.getUsageLimit()) &&
                condition.apply(criteria.getUsedCount()) &&
                condition.apply(criteria.getCreatedAt()) &&
                condition.apply(criteria.getUpdatedAt()) &&
                condition.apply(criteria.getIsDeleted()) &&
                condition.apply(criteria.getDeletedAt()) &&
                condition.apply(criteria.getDeletedBy()) &&
                condition.apply(criteria.getBuyNGetMId()) &&
                condition.apply(criteria.getPercentOffId()) &&
                condition.apply(criteria.getConditionsRId()) &&
                condition.apply(criteria.getConditionsDId()) &&
                condition.apply(criteria.getConditionsLocId()) &&
                condition.apply(criteria.getDistinct()),
            "every filter matches"
        );
    }

    private static Condition<PromotionCriteria> copyFiltersAre(PromotionCriteria copy, BiFunction<Object, Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId(), copy.getId()) &&
                condition.apply(criteria.getCode(), copy.getCode()) &&
                condition.apply(criteria.getDescription(), copy.getDescription()) &&
                condition.apply(criteria.getStartDate(), copy.getStartDate()) &&
                condition.apply(criteria.getEndDate(), copy.getEndDate()) &&
                condition.apply(criteria.getUsageLimit(), copy.getUsageLimit()) &&
                condition.apply(criteria.getUsedCount(), copy.getUsedCount()) &&
                condition.apply(criteria.getCreatedAt(), copy.getCreatedAt()) &&
                condition.apply(criteria.getUpdatedAt(), copy.getUpdatedAt()) &&
                condition.apply(criteria.getIsDeleted(), copy.getIsDeleted()) &&
                condition.apply(criteria.getDeletedAt(), copy.getDeletedAt()) &&
                condition.apply(criteria.getDeletedBy(), copy.getDeletedBy()) &&
                condition.apply(criteria.getBuyNGetMId(), copy.getBuyNGetMId()) &&
                condition.apply(criteria.getPercentOffId(), copy.getPercentOffId()) &&
                condition.apply(criteria.getConditionsRId(), copy.getConditionsRId()) &&
                condition.apply(criteria.getConditionsDId(), copy.getConditionsDId()) &&
                condition.apply(criteria.getConditionsLocId(), copy.getConditionsLocId()) &&
                condition.apply(criteria.getDistinct(), copy.getDistinct()),
            "every filter matches"
        );
    }
}
