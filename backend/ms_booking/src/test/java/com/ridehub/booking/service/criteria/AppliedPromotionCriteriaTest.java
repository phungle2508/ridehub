package com.ridehub.booking.service.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class AppliedPromotionCriteriaTest {

    @Test
    void newAppliedPromotionCriteriaHasAllFiltersNullTest() {
        var appliedPromotionCriteria = new AppliedPromotionCriteria();
        assertThat(appliedPromotionCriteria).is(criteriaFiltersAre(Objects::isNull));
    }

    @Test
    void appliedPromotionCriteriaFluentMethodsCreatesFiltersTest() {
        var appliedPromotionCriteria = new AppliedPromotionCriteria();

        setAllFilters(appliedPromotionCriteria);

        assertThat(appliedPromotionCriteria).is(criteriaFiltersAre(Objects::nonNull));
    }

    @Test
    void appliedPromotionCriteriaCopyCreatesNullFilterTest() {
        var appliedPromotionCriteria = new AppliedPromotionCriteria();
        var copy = appliedPromotionCriteria.copy();

        assertThat(appliedPromotionCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::isNull)),
            criteria -> assertThat(criteria).isEqualTo(appliedPromotionCriteria)
        );
    }

    @Test
    void appliedPromotionCriteriaCopyDuplicatesEveryExistingFilterTest() {
        var appliedPromotionCriteria = new AppliedPromotionCriteria();
        setAllFilters(appliedPromotionCriteria);

        var copy = appliedPromotionCriteria.copy();

        assertThat(appliedPromotionCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::nonNull)),
            criteria -> assertThat(criteria).isEqualTo(appliedPromotionCriteria)
        );
    }

    @Test
    void toStringVerifier() {
        var appliedPromotionCriteria = new AppliedPromotionCriteria();

        assertThat(appliedPromotionCriteria).hasToString("AppliedPromotionCriteria{}");
    }

    private static void setAllFilters(AppliedPromotionCriteria appliedPromotionCriteria) {
        appliedPromotionCriteria.id();
        appliedPromotionCriteria.promotionId();
        appliedPromotionCriteria.promotionCode();
        appliedPromotionCriteria.discountAmount();
        appliedPromotionCriteria.appliedAt();
        appliedPromotionCriteria.createdAt();
        appliedPromotionCriteria.updatedAt();
        appliedPromotionCriteria.isDeleted();
        appliedPromotionCriteria.deletedAt();
        appliedPromotionCriteria.deletedBy();
        appliedPromotionCriteria.bookingId();
        appliedPromotionCriteria.distinct();
    }

    private static Condition<AppliedPromotionCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getPromotionId()) &&
                condition.apply(criteria.getPromotionCode()) &&
                condition.apply(criteria.getDiscountAmount()) &&
                condition.apply(criteria.getAppliedAt()) &&
                condition.apply(criteria.getCreatedAt()) &&
                condition.apply(criteria.getUpdatedAt()) &&
                condition.apply(criteria.getIsDeleted()) &&
                condition.apply(criteria.getDeletedAt()) &&
                condition.apply(criteria.getDeletedBy()) &&
                condition.apply(criteria.getBookingId()) &&
                condition.apply(criteria.getDistinct()),
            "every filter matches"
        );
    }

    private static Condition<AppliedPromotionCriteria> copyFiltersAre(
        AppliedPromotionCriteria copy,
        BiFunction<Object, Object, Boolean> condition
    ) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId(), copy.getId()) &&
                condition.apply(criteria.getPromotionId(), copy.getPromotionId()) &&
                condition.apply(criteria.getPromotionCode(), copy.getPromotionCode()) &&
                condition.apply(criteria.getDiscountAmount(), copy.getDiscountAmount()) &&
                condition.apply(criteria.getAppliedAt(), copy.getAppliedAt()) &&
                condition.apply(criteria.getCreatedAt(), copy.getCreatedAt()) &&
                condition.apply(criteria.getUpdatedAt(), copy.getUpdatedAt()) &&
                condition.apply(criteria.getIsDeleted(), copy.getIsDeleted()) &&
                condition.apply(criteria.getDeletedAt(), copy.getDeletedAt()) &&
                condition.apply(criteria.getDeletedBy(), copy.getDeletedBy()) &&
                condition.apply(criteria.getBookingId(), copy.getBookingId()) &&
                condition.apply(criteria.getDistinct(), copy.getDistinct()),
            "every filter matches"
        );
    }
}
