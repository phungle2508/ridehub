package com.ticketsystem.route.service.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class ReviewSummaryCriteriaTest {

    @Test
    void newReviewSummaryCriteriaHasAllFiltersNullTest() {
        var reviewSummaryCriteria = new ReviewSummaryCriteria();
        assertThat(reviewSummaryCriteria).is(criteriaFiltersAre(Objects::isNull));
    }

    @Test
    void reviewSummaryCriteriaFluentMethodsCreatesFiltersTest() {
        var reviewSummaryCriteria = new ReviewSummaryCriteria();

        setAllFilters(reviewSummaryCriteria);

        assertThat(reviewSummaryCriteria).is(criteriaFiltersAre(Objects::nonNull));
    }

    @Test
    void reviewSummaryCriteriaCopyCreatesNullFilterTest() {
        var reviewSummaryCriteria = new ReviewSummaryCriteria();
        var copy = reviewSummaryCriteria.copy();

        assertThat(reviewSummaryCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::isNull)),
            criteria -> assertThat(criteria).isEqualTo(reviewSummaryCriteria)
        );
    }

    @Test
    void reviewSummaryCriteriaCopyDuplicatesEveryExistingFilterTest() {
        var reviewSummaryCriteria = new ReviewSummaryCriteria();
        setAllFilters(reviewSummaryCriteria);

        var copy = reviewSummaryCriteria.copy();

        assertThat(reviewSummaryCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::nonNull)),
            criteria -> assertThat(criteria).isEqualTo(reviewSummaryCriteria)
        );
    }

    @Test
    void toStringVerifier() {
        var reviewSummaryCriteria = new ReviewSummaryCriteria();

        assertThat(reviewSummaryCriteria).hasToString("ReviewSummaryCriteria{}");
    }

    private static void setAllFilters(ReviewSummaryCriteria reviewSummaryCriteria) {
        reviewSummaryCriteria.id();
        reviewSummaryCriteria.averageRating();
        reviewSummaryCriteria.totalReviews();
        reviewSummaryCriteria.updatedAt();
        reviewSummaryCriteria.vehicleId();
        reviewSummaryCriteria.distinct();
    }

    private static Condition<ReviewSummaryCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getAverageRating()) &&
                condition.apply(criteria.getTotalReviews()) &&
                condition.apply(criteria.getUpdatedAt()) &&
                condition.apply(criteria.getVehicleId()) &&
                condition.apply(criteria.getDistinct()),
            "every filter matches"
        );
    }

    private static Condition<ReviewSummaryCriteria> copyFiltersAre(
        ReviewSummaryCriteria copy,
        BiFunction<Object, Object, Boolean> condition
    ) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId(), copy.getId()) &&
                condition.apply(criteria.getAverageRating(), copy.getAverageRating()) &&
                condition.apply(criteria.getTotalReviews(), copy.getTotalReviews()) &&
                condition.apply(criteria.getUpdatedAt(), copy.getUpdatedAt()) &&
                condition.apply(criteria.getVehicleId(), copy.getVehicleId()) &&
                condition.apply(criteria.getDistinct(), copy.getDistinct()),
            "every filter matches"
        );
    }
}
