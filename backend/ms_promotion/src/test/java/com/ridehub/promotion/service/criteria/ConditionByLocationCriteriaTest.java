package com.ridehub.promotion.service.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class ConditionByLocationCriteriaTest {

    @Test
    void newConditionByLocationCriteriaHasAllFiltersNullTest() {
        var conditionByLocationCriteria = new ConditionByLocationCriteria();
        assertThat(conditionByLocationCriteria).is(criteriaFiltersAre(Objects::isNull));
    }

    @Test
    void conditionByLocationCriteriaFluentMethodsCreatesFiltersTest() {
        var conditionByLocationCriteria = new ConditionByLocationCriteria();

        setAllFilters(conditionByLocationCriteria);

        assertThat(conditionByLocationCriteria).is(criteriaFiltersAre(Objects::nonNull));
    }

    @Test
    void conditionByLocationCriteriaCopyCreatesNullFilterTest() {
        var conditionByLocationCriteria = new ConditionByLocationCriteria();
        var copy = conditionByLocationCriteria.copy();

        assertThat(conditionByLocationCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::isNull)),
            criteria -> assertThat(criteria).isEqualTo(conditionByLocationCriteria)
        );
    }

    @Test
    void conditionByLocationCriteriaCopyDuplicatesEveryExistingFilterTest() {
        var conditionByLocationCriteria = new ConditionByLocationCriteria();
        setAllFilters(conditionByLocationCriteria);

        var copy = conditionByLocationCriteria.copy();

        assertThat(conditionByLocationCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::nonNull)),
            criteria -> assertThat(criteria).isEqualTo(conditionByLocationCriteria)
        );
    }

    @Test
    void toStringVerifier() {
        var conditionByLocationCriteria = new ConditionByLocationCriteria();

        assertThat(conditionByLocationCriteria).hasToString("ConditionByLocationCriteria{}");
    }

    private static void setAllFilters(ConditionByLocationCriteria conditionByLocationCriteria) {
        conditionByLocationCriteria.id();
        conditionByLocationCriteria.provinceId();
        conditionByLocationCriteria.districtId();
        conditionByLocationCriteria.wardId();
        conditionByLocationCriteria.createdAt();
        conditionByLocationCriteria.updatedAt();
        conditionByLocationCriteria.isDeleted();
        conditionByLocationCriteria.deletedAt();
        conditionByLocationCriteria.deletedBy();
        conditionByLocationCriteria.promotionId();
        conditionByLocationCriteria.distinct();
    }

    private static Condition<ConditionByLocationCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getProvinceId()) &&
                condition.apply(criteria.getDistrictId()) &&
                condition.apply(criteria.getWardId()) &&
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

    private static Condition<ConditionByLocationCriteria> copyFiltersAre(
        ConditionByLocationCriteria copy,
        BiFunction<Object, Object, Boolean> condition
    ) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId(), copy.getId()) &&
                condition.apply(criteria.getProvinceId(), copy.getProvinceId()) &&
                condition.apply(criteria.getDistrictId(), copy.getDistrictId()) &&
                condition.apply(criteria.getWardId(), copy.getWardId()) &&
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
