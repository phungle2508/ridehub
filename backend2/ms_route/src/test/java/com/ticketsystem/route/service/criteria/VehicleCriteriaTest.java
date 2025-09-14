package com.ticketsystem.route.service.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class VehicleCriteriaTest {

    @Test
    void newVehicleCriteriaHasAllFiltersNullTest() {
        var vehicleCriteria = new VehicleCriteria();
        assertThat(vehicleCriteria).is(criteriaFiltersAre(Objects::isNull));
    }

    @Test
    void vehicleCriteriaFluentMethodsCreatesFiltersTest() {
        var vehicleCriteria = new VehicleCriteria();

        setAllFilters(vehicleCriteria);

        assertThat(vehicleCriteria).is(criteriaFiltersAre(Objects::nonNull));
    }

    @Test
    void vehicleCriteriaCopyCreatesNullFilterTest() {
        var vehicleCriteria = new VehicleCriteria();
        var copy = vehicleCriteria.copy();

        assertThat(vehicleCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::isNull)),
            criteria -> assertThat(criteria).isEqualTo(vehicleCriteria)
        );
    }

    @Test
    void vehicleCriteriaCopyDuplicatesEveryExistingFilterTest() {
        var vehicleCriteria = new VehicleCriteria();
        setAllFilters(vehicleCriteria);

        var copy = vehicleCriteria.copy();

        assertThat(vehicleCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::nonNull)),
            criteria -> assertThat(criteria).isEqualTo(vehicleCriteria)
        );
    }

    @Test
    void toStringVerifier() {
        var vehicleCriteria = new VehicleCriteria();

        assertThat(vehicleCriteria).hasToString("VehicleCriteria{}");
    }

    private static void setAllFilters(VehicleCriteria vehicleCriteria) {
        vehicleCriteria.id();
        vehicleCriteria.plateNumber();
        vehicleCriteria.model();
        vehicleCriteria.capacity();
        vehicleCriteria.seatLayout();
        vehicleCriteria.amenities();
        vehicleCriteria.imageCoverUrl();
        vehicleCriteria.averageRating();
        vehicleCriteria.totalReviews();
        vehicleCriteria.isActive();
        vehicleCriteria.yearManufactured();
        vehicleCriteria.lastMaintenanceDate();
        vehicleCriteria.summaryId();
        vehicleCriteria.imagesId();
        vehicleCriteria.reviewsId();
        vehicleCriteria.amenityItemsId();
        vehicleCriteria.homeStationId();
        vehicleCriteria.operatorId();
        vehicleCriteria.distinct();
    }

    private static Condition<VehicleCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getPlateNumber()) &&
                condition.apply(criteria.getModel()) &&
                condition.apply(criteria.getCapacity()) &&
                condition.apply(criteria.getSeatLayout()) &&
                condition.apply(criteria.getAmenities()) &&
                condition.apply(criteria.getImageCoverUrl()) &&
                condition.apply(criteria.getAverageRating()) &&
                condition.apply(criteria.getTotalReviews()) &&
                condition.apply(criteria.getIsActive()) &&
                condition.apply(criteria.getYearManufactured()) &&
                condition.apply(criteria.getLastMaintenanceDate()) &&
                condition.apply(criteria.getSummaryId()) &&
                condition.apply(criteria.getImagesId()) &&
                condition.apply(criteria.getReviewsId()) &&
                condition.apply(criteria.getAmenityItemsId()) &&
                condition.apply(criteria.getHomeStationId()) &&
                condition.apply(criteria.getOperatorId()) &&
                condition.apply(criteria.getDistinct()),
            "every filter matches"
        );
    }

    private static Condition<VehicleCriteria> copyFiltersAre(VehicleCriteria copy, BiFunction<Object, Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId(), copy.getId()) &&
                condition.apply(criteria.getPlateNumber(), copy.getPlateNumber()) &&
                condition.apply(criteria.getModel(), copy.getModel()) &&
                condition.apply(criteria.getCapacity(), copy.getCapacity()) &&
                condition.apply(criteria.getSeatLayout(), copy.getSeatLayout()) &&
                condition.apply(criteria.getAmenities(), copy.getAmenities()) &&
                condition.apply(criteria.getImageCoverUrl(), copy.getImageCoverUrl()) &&
                condition.apply(criteria.getAverageRating(), copy.getAverageRating()) &&
                condition.apply(criteria.getTotalReviews(), copy.getTotalReviews()) &&
                condition.apply(criteria.getIsActive(), copy.getIsActive()) &&
                condition.apply(criteria.getYearManufactured(), copy.getYearManufactured()) &&
                condition.apply(criteria.getLastMaintenanceDate(), copy.getLastMaintenanceDate()) &&
                condition.apply(criteria.getSummaryId(), copy.getSummaryId()) &&
                condition.apply(criteria.getImagesId(), copy.getImagesId()) &&
                condition.apply(criteria.getReviewsId(), copy.getReviewsId()) &&
                condition.apply(criteria.getAmenityItemsId(), copy.getAmenityItemsId()) &&
                condition.apply(criteria.getHomeStationId(), copy.getHomeStationId()) &&
                condition.apply(criteria.getOperatorId(), copy.getOperatorId()) &&
                condition.apply(criteria.getDistinct(), copy.getDistinct()),
            "every filter matches"
        );
    }
}
