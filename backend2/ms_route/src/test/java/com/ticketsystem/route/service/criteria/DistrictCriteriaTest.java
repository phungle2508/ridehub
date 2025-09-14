package com.ticketsystem.route.service.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class DistrictCriteriaTest {

    @Test
    void newDistrictCriteriaHasAllFiltersNullTest() {
        var districtCriteria = new DistrictCriteria();
        assertThat(districtCriteria).is(criteriaFiltersAre(Objects::isNull));
    }

    @Test
    void districtCriteriaFluentMethodsCreatesFiltersTest() {
        var districtCriteria = new DistrictCriteria();

        setAllFilters(districtCriteria);

        assertThat(districtCriteria).is(criteriaFiltersAre(Objects::nonNull));
    }

    @Test
    void districtCriteriaCopyCreatesNullFilterTest() {
        var districtCriteria = new DistrictCriteria();
        var copy = districtCriteria.copy();

        assertThat(districtCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::isNull)),
            criteria -> assertThat(criteria).isEqualTo(districtCriteria)
        );
    }

    @Test
    void districtCriteriaCopyDuplicatesEveryExistingFilterTest() {
        var districtCriteria = new DistrictCriteria();
        setAllFilters(districtCriteria);

        var copy = districtCriteria.copy();

        assertThat(districtCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::nonNull)),
            criteria -> assertThat(criteria).isEqualTo(districtCriteria)
        );
    }

    @Test
    void toStringVerifier() {
        var districtCriteria = new DistrictCriteria();

        assertThat(districtCriteria).hasToString("DistrictCriteria{}");
    }

    private static void setAllFilters(DistrictCriteria districtCriteria) {
        districtCriteria.id();
        districtCriteria.code();
        districtCriteria.name();
        districtCriteria.nameEn();
        districtCriteria.type();
        districtCriteria.wardsId();
        districtCriteria.provinceId();
        districtCriteria.distinct();
    }

    private static Condition<DistrictCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getCode()) &&
                condition.apply(criteria.getName()) &&
                condition.apply(criteria.getNameEn()) &&
                condition.apply(criteria.getType()) &&
                condition.apply(criteria.getWardsId()) &&
                condition.apply(criteria.getProvinceId()) &&
                condition.apply(criteria.getDistinct()),
            "every filter matches"
        );
    }

    private static Condition<DistrictCriteria> copyFiltersAre(DistrictCriteria copy, BiFunction<Object, Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId(), copy.getId()) &&
                condition.apply(criteria.getCode(), copy.getCode()) &&
                condition.apply(criteria.getName(), copy.getName()) &&
                condition.apply(criteria.getNameEn(), copy.getNameEn()) &&
                condition.apply(criteria.getType(), copy.getType()) &&
                condition.apply(criteria.getWardsId(), copy.getWardsId()) &&
                condition.apply(criteria.getProvinceId(), copy.getProvinceId()) &&
                condition.apply(criteria.getDistinct(), copy.getDistinct()),
            "every filter matches"
        );
    }
}
