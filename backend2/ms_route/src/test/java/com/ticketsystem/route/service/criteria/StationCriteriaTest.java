package com.ticketsystem.route.service.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class StationCriteriaTest {

    @Test
    void newStationCriteriaHasAllFiltersNullTest() {
        var stationCriteria = new StationCriteria();
        assertThat(stationCriteria).is(criteriaFiltersAre(Objects::isNull));
    }

    @Test
    void stationCriteriaFluentMethodsCreatesFiltersTest() {
        var stationCriteria = new StationCriteria();

        setAllFilters(stationCriteria);

        assertThat(stationCriteria).is(criteriaFiltersAre(Objects::nonNull));
    }

    @Test
    void stationCriteriaCopyCreatesNullFilterTest() {
        var stationCriteria = new StationCriteria();
        var copy = stationCriteria.copy();

        assertThat(stationCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::isNull)),
            criteria -> assertThat(criteria).isEqualTo(stationCriteria)
        );
    }

    @Test
    void stationCriteriaCopyDuplicatesEveryExistingFilterTest() {
        var stationCriteria = new StationCriteria();
        setAllFilters(stationCriteria);

        var copy = stationCriteria.copy();

        assertThat(stationCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::nonNull)),
            criteria -> assertThat(criteria).isEqualTo(stationCriteria)
        );
    }

    @Test
    void toStringVerifier() {
        var stationCriteria = new StationCriteria();

        assertThat(stationCriteria).hasToString("StationCriteria{}");
    }

    private static void setAllFilters(StationCriteria stationCriteria) {
        stationCriteria.id();
        stationCriteria.code();
        stationCriteria.name();
        stationCriteria.nameEn();
        stationCriteria.addressId();
        stationCriteria.facilities();
        stationCriteria.operatingHours();
        stationCriteria.isActive();
        stationCriteria.distinct();
    }

    private static Condition<StationCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getCode()) &&
                condition.apply(criteria.getName()) &&
                condition.apply(criteria.getNameEn()) &&
                condition.apply(criteria.getAddressId()) &&
                condition.apply(criteria.getFacilities()) &&
                condition.apply(criteria.getOperatingHours()) &&
                condition.apply(criteria.getIsActive()) &&
                condition.apply(criteria.getDistinct()),
            "every filter matches"
        );
    }

    private static Condition<StationCriteria> copyFiltersAre(StationCriteria copy, BiFunction<Object, Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId(), copy.getId()) &&
                condition.apply(criteria.getCode(), copy.getCode()) &&
                condition.apply(criteria.getName(), copy.getName()) &&
                condition.apply(criteria.getNameEn(), copy.getNameEn()) &&
                condition.apply(criteria.getAddressId(), copy.getAddressId()) &&
                condition.apply(criteria.getFacilities(), copy.getFacilities()) &&
                condition.apply(criteria.getOperatingHours(), copy.getOperatingHours()) &&
                condition.apply(criteria.getIsActive(), copy.getIsActive()) &&
                condition.apply(criteria.getDistinct(), copy.getDistinct()),
            "every filter matches"
        );
    }
}
