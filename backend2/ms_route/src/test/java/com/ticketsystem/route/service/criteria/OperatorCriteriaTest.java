package com.ticketsystem.route.service.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class OperatorCriteriaTest {

    @Test
    void newOperatorCriteriaHasAllFiltersNullTest() {
        var operatorCriteria = new OperatorCriteria();
        assertThat(operatorCriteria).is(criteriaFiltersAre(Objects::isNull));
    }

    @Test
    void operatorCriteriaFluentMethodsCreatesFiltersTest() {
        var operatorCriteria = new OperatorCriteria();

        setAllFilters(operatorCriteria);

        assertThat(operatorCriteria).is(criteriaFiltersAre(Objects::nonNull));
    }

    @Test
    void operatorCriteriaCopyCreatesNullFilterTest() {
        var operatorCriteria = new OperatorCriteria();
        var copy = operatorCriteria.copy();

        assertThat(operatorCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::isNull)),
            criteria -> assertThat(criteria).isEqualTo(operatorCriteria)
        );
    }

    @Test
    void operatorCriteriaCopyDuplicatesEveryExistingFilterTest() {
        var operatorCriteria = new OperatorCriteria();
        setAllFilters(operatorCriteria);

        var copy = operatorCriteria.copy();

        assertThat(operatorCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::nonNull)),
            criteria -> assertThat(criteria).isEqualTo(operatorCriteria)
        );
    }

    @Test
    void toStringVerifier() {
        var operatorCriteria = new OperatorCriteria();

        assertThat(operatorCriteria).hasToString("OperatorCriteria{}");
    }

    private static void setAllFilters(OperatorCriteria operatorCriteria) {
        operatorCriteria.id();
        operatorCriteria.name();
        operatorCriteria.businessLicense();
        operatorCriteria.logoUrl();
        operatorCriteria.rating();
        operatorCriteria.contactPhone();
        operatorCriteria.contactEmail();
        operatorCriteria.isActive();
        operatorCriteria.vehiclesId();
        operatorCriteria.routesId();
        operatorCriteria.distinct();
    }

    private static Condition<OperatorCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getName()) &&
                condition.apply(criteria.getBusinessLicense()) &&
                condition.apply(criteria.getLogoUrl()) &&
                condition.apply(criteria.getRating()) &&
                condition.apply(criteria.getContactPhone()) &&
                condition.apply(criteria.getContactEmail()) &&
                condition.apply(criteria.getIsActive()) &&
                condition.apply(criteria.getVehiclesId()) &&
                condition.apply(criteria.getRoutesId()) &&
                condition.apply(criteria.getDistinct()),
            "every filter matches"
        );
    }

    private static Condition<OperatorCriteria> copyFiltersAre(OperatorCriteria copy, BiFunction<Object, Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId(), copy.getId()) &&
                condition.apply(criteria.getName(), copy.getName()) &&
                condition.apply(criteria.getBusinessLicense(), copy.getBusinessLicense()) &&
                condition.apply(criteria.getLogoUrl(), copy.getLogoUrl()) &&
                condition.apply(criteria.getRating(), copy.getRating()) &&
                condition.apply(criteria.getContactPhone(), copy.getContactPhone()) &&
                condition.apply(criteria.getContactEmail(), copy.getContactEmail()) &&
                condition.apply(criteria.getIsActive(), copy.getIsActive()) &&
                condition.apply(criteria.getVehiclesId(), copy.getVehiclesId()) &&
                condition.apply(criteria.getRoutesId(), copy.getRoutesId()) &&
                condition.apply(criteria.getDistinct(), copy.getDistinct()),
            "every filter matches"
        );
    }
}
