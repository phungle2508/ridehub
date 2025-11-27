package com.ridehub.promotion.service.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class BuyNGetMFreeCriteriaTest {

    @Test
    void newBuyNGetMFreeCriteriaHasAllFiltersNullTest() {
        var buyNGetMFreeCriteria = new BuyNGetMFreeCriteria();
        assertThat(buyNGetMFreeCriteria).is(criteriaFiltersAre(Objects::isNull));
    }

    @Test
    void buyNGetMFreeCriteriaFluentMethodsCreatesFiltersTest() {
        var buyNGetMFreeCriteria = new BuyNGetMFreeCriteria();

        setAllFilters(buyNGetMFreeCriteria);

        assertThat(buyNGetMFreeCriteria).is(criteriaFiltersAre(Objects::nonNull));
    }

    @Test
    void buyNGetMFreeCriteriaCopyCreatesNullFilterTest() {
        var buyNGetMFreeCriteria = new BuyNGetMFreeCriteria();
        var copy = buyNGetMFreeCriteria.copy();

        assertThat(buyNGetMFreeCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::isNull)),
            criteria -> assertThat(criteria).isEqualTo(buyNGetMFreeCriteria)
        );
    }

    @Test
    void buyNGetMFreeCriteriaCopyDuplicatesEveryExistingFilterTest() {
        var buyNGetMFreeCriteria = new BuyNGetMFreeCriteria();
        setAllFilters(buyNGetMFreeCriteria);

        var copy = buyNGetMFreeCriteria.copy();

        assertThat(buyNGetMFreeCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::nonNull)),
            criteria -> assertThat(criteria).isEqualTo(buyNGetMFreeCriteria)
        );
    }

    @Test
    void toStringVerifier() {
        var buyNGetMFreeCriteria = new BuyNGetMFreeCriteria();

        assertThat(buyNGetMFreeCriteria).hasToString("BuyNGetMFreeCriteria{}");
    }

    private static void setAllFilters(BuyNGetMFreeCriteria buyNGetMFreeCriteria) {
        buyNGetMFreeCriteria.id();
        buyNGetMFreeCriteria.buyN();
        buyNGetMFreeCriteria.getM();
        buyNGetMFreeCriteria.createdAt();
        buyNGetMFreeCriteria.updatedAt();
        buyNGetMFreeCriteria.isDeleted();
        buyNGetMFreeCriteria.deletedAt();
        buyNGetMFreeCriteria.deletedBy();
        buyNGetMFreeCriteria.promotionId();
        buyNGetMFreeCriteria.distinct();
    }

    private static Condition<BuyNGetMFreeCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getBuyN()) &&
                condition.apply(criteria.getGetM()) &&
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

    private static Condition<BuyNGetMFreeCriteria> copyFiltersAre(
        BuyNGetMFreeCriteria copy,
        BiFunction<Object, Object, Boolean> condition
    ) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId(), copy.getId()) &&
                condition.apply(criteria.getBuyN(), copy.getBuyN()) &&
                condition.apply(criteria.getGetM(), copy.getGetM()) &&
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
