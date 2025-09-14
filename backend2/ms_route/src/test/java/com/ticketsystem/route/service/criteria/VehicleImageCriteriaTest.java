package com.ticketsystem.route.service.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class VehicleImageCriteriaTest {

    @Test
    void newVehicleImageCriteriaHasAllFiltersNullTest() {
        var vehicleImageCriteria = new VehicleImageCriteria();
        assertThat(vehicleImageCriteria).is(criteriaFiltersAre(Objects::isNull));
    }

    @Test
    void vehicleImageCriteriaFluentMethodsCreatesFiltersTest() {
        var vehicleImageCriteria = new VehicleImageCriteria();

        setAllFilters(vehicleImageCriteria);

        assertThat(vehicleImageCriteria).is(criteriaFiltersAre(Objects::nonNull));
    }

    @Test
    void vehicleImageCriteriaCopyCreatesNullFilterTest() {
        var vehicleImageCriteria = new VehicleImageCriteria();
        var copy = vehicleImageCriteria.copy();

        assertThat(vehicleImageCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::isNull)),
            criteria -> assertThat(criteria).isEqualTo(vehicleImageCriteria)
        );
    }

    @Test
    void vehicleImageCriteriaCopyDuplicatesEveryExistingFilterTest() {
        var vehicleImageCriteria = new VehicleImageCriteria();
        setAllFilters(vehicleImageCriteria);

        var copy = vehicleImageCriteria.copy();

        assertThat(vehicleImageCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::nonNull)),
            criteria -> assertThat(criteria).isEqualTo(vehicleImageCriteria)
        );
    }

    @Test
    void toStringVerifier() {
        var vehicleImageCriteria = new VehicleImageCriteria();

        assertThat(vehicleImageCriteria).hasToString("VehicleImageCriteria{}");
    }

    private static void setAllFilters(VehicleImageCriteria vehicleImageCriteria) {
        vehicleImageCriteria.id();
        vehicleImageCriteria.imageUrl();
        vehicleImageCriteria.imageType();
        vehicleImageCriteria.description();
        vehicleImageCriteria.isPrimary();
        vehicleImageCriteria.uploadedAt();
        vehicleImageCriteria.vehicleId();
        vehicleImageCriteria.distinct();
    }

    private static Condition<VehicleImageCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getImageUrl()) &&
                condition.apply(criteria.getImageType()) &&
                condition.apply(criteria.getDescription()) &&
                condition.apply(criteria.getIsPrimary()) &&
                condition.apply(criteria.getUploadedAt()) &&
                condition.apply(criteria.getVehicleId()) &&
                condition.apply(criteria.getDistinct()),
            "every filter matches"
        );
    }

    private static Condition<VehicleImageCriteria> copyFiltersAre(
        VehicleImageCriteria copy,
        BiFunction<Object, Object, Boolean> condition
    ) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId(), copy.getId()) &&
                condition.apply(criteria.getImageUrl(), copy.getImageUrl()) &&
                condition.apply(criteria.getImageType(), copy.getImageType()) &&
                condition.apply(criteria.getDescription(), copy.getDescription()) &&
                condition.apply(criteria.getIsPrimary(), copy.getIsPrimary()) &&
                condition.apply(criteria.getUploadedAt(), copy.getUploadedAt()) &&
                condition.apply(criteria.getVehicleId(), copy.getVehicleId()) &&
                condition.apply(criteria.getDistinct(), copy.getDistinct()),
            "every filter matches"
        );
    }
}
