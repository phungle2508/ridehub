package com.ticketsystem.route.service.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class ProvinceCriteriaTest {

    @Test
    void newProvinceCriteriaHasAllFiltersNullTest() {
        var provinceCriteria = new ProvinceCriteria();
        assertThat(provinceCriteria).is(criteriaFiltersAre(Objects::isNull));
    }

    @Test
    void provinceCriteriaFluentMethodsCreatesFiltersTest() {
        var provinceCriteria = new ProvinceCriteria();

        setAllFilters(provinceCriteria);

        assertThat(provinceCriteria).is(criteriaFiltersAre(Objects::nonNull));
    }

    @Test
    void provinceCriteriaCopyCreatesNullFilterTest() {
        var provinceCriteria = new ProvinceCriteria();
        var copy = provinceCriteria.copy();

        assertThat(provinceCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::isNull)),
            criteria -> assertThat(criteria).isEqualTo(provinceCriteria)
        );
    }

    @Test
    void provinceCriteriaCopyDuplicatesEveryExistingFilterTest() {
        var provinceCriteria = new ProvinceCriteria();
        setAllFilters(provinceCriteria);

        var copy = provinceCriteria.copy();

        assertThat(provinceCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::nonNull)),
            criteria -> assertThat(criteria).isEqualTo(provinceCriteria)
        );
    }

    @Test
    void toStringVerifier() {
        var provinceCriteria = new ProvinceCriteria();

        assertThat(provinceCriteria).hasToString("ProvinceCriteria{}");
    }

    private static void setAllFilters(ProvinceCriteria provinceCriteria) {
        provinceCriteria.id();
        provinceCriteria.code();
        provinceCriteria.name();
        provinceCriteria.nameEn();
        provinceCriteria.region();
        provinceCriteria.districtsId();
        provinceCriteria.distinct();
    }

    private static Condition<ProvinceCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getCode()) &&
                condition.apply(criteria.getName()) &&
                condition.apply(criteria.getNameEn()) &&
                condition.apply(criteria.getRegion()) &&
                condition.apply(criteria.getDistrictsId()) &&
                condition.apply(criteria.getDistinct()),
            "every filter matches"
        );
    }

    private static Condition<ProvinceCriteria> copyFiltersAre(ProvinceCriteria copy, BiFunction<Object, Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId(), copy.getId()) &&
                condition.apply(criteria.getCode(), copy.getCode()) &&
                condition.apply(criteria.getName(), copy.getName()) &&
                condition.apply(criteria.getNameEn(), copy.getNameEn()) &&
                condition.apply(criteria.getRegion(), copy.getRegion()) &&
                condition.apply(criteria.getDistrictsId(), copy.getDistrictsId()) &&
                condition.apply(criteria.getDistinct(), copy.getDistinct()),
            "every filter matches"
        );
    }
}
