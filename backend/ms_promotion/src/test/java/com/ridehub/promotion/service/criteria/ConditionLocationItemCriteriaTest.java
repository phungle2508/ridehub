package com.ridehub.promotion.service.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class ConditionLocationItemCriteriaTest {

    @Test
    void newConditionLocationItemCriteriaHasAllFiltersNullTest() {
        var conditionLocationItemCriteria = new ConditionLocationItemCriteria();
        assertThat(conditionLocationItemCriteria).is(criteriaFiltersAre(Objects::isNull));
    }

    @Test
    void conditionLocationItemCriteriaFluentMethodsCreatesFiltersTest() {
        var conditionLocationItemCriteria = new ConditionLocationItemCriteria();

        setAllFilters(conditionLocationItemCriteria);

        assertThat(conditionLocationItemCriteria).is(criteriaFiltersAre(Objects::nonNull));
    }

    @Test
    void conditionLocationItemCriteriaCopyCreatesNullFilterTest() {
        var conditionLocationItemCriteria = new ConditionLocationItemCriteria();
        var copy = conditionLocationItemCriteria.copy();

        assertThat(conditionLocationItemCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::isNull)),
            criteria -> assertThat(criteria).isEqualTo(conditionLocationItemCriteria)
        );
    }

    @Test
    void conditionLocationItemCriteriaCopyDuplicatesEveryExistingFilterTest() {
        var conditionLocationItemCriteria = new ConditionLocationItemCriteria();
        setAllFilters(conditionLocationItemCriteria);

        var copy = conditionLocationItemCriteria.copy();

        assertThat(conditionLocationItemCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::nonNull)),
            criteria -> assertThat(criteria).isEqualTo(conditionLocationItemCriteria)
        );
    }

    @Test
    void toStringVerifier() {
        var conditionLocationItemCriteria = new ConditionLocationItemCriteria();

        assertThat(conditionLocationItemCriteria).hasToString("ConditionLocationItemCriteria{}");
    }

    private static void setAllFilters(ConditionLocationItemCriteria conditionLocationItemCriteria) {
        conditionLocationItemCriteria.id();
        conditionLocationItemCriteria.provinceId();
        conditionLocationItemCriteria.districtId();
        conditionLocationItemCriteria.wardId();
        conditionLocationItemCriteria.createdAt();
        conditionLocationItemCriteria.updatedAt();
        conditionLocationItemCriteria.isDeleted();
        conditionLocationItemCriteria.deletedAt();
        conditionLocationItemCriteria.deletedBy();
        conditionLocationItemCriteria.conditionId();
        conditionLocationItemCriteria.distinct();
    }

    private static Condition<ConditionLocationItemCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
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
                condition.apply(criteria.getConditionId()) &&
                condition.apply(criteria.getDistinct()),
            "every filter matches"
        );
    }

    private static Condition<ConditionLocationItemCriteria> copyFiltersAre(
        ConditionLocationItemCriteria copy,
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
                condition.apply(criteria.getConditionId(), copy.getConditionId()) &&
                condition.apply(criteria.getDistinct(), copy.getDistinct()),
            "every filter matches"
        );
    }
}
