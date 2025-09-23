package com.ridehub.booking.service.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class FileBookingCriteriaTest {

    @Test
    void newFileBookingCriteriaHasAllFiltersNullTest() {
        var fileBookingCriteria = new FileBookingCriteria();
        assertThat(fileBookingCriteria).is(criteriaFiltersAre(Objects::isNull));
    }

    @Test
    void fileBookingCriteriaFluentMethodsCreatesFiltersTest() {
        var fileBookingCriteria = new FileBookingCriteria();

        setAllFilters(fileBookingCriteria);

        assertThat(fileBookingCriteria).is(criteriaFiltersAre(Objects::nonNull));
    }

    @Test
    void fileBookingCriteriaCopyCreatesNullFilterTest() {
        var fileBookingCriteria = new FileBookingCriteria();
        var copy = fileBookingCriteria.copy();

        assertThat(fileBookingCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::isNull)),
            criteria -> assertThat(criteria).isEqualTo(fileBookingCriteria)
        );
    }

    @Test
    void fileBookingCriteriaCopyDuplicatesEveryExistingFilterTest() {
        var fileBookingCriteria = new FileBookingCriteria();
        setAllFilters(fileBookingCriteria);

        var copy = fileBookingCriteria.copy();

        assertThat(fileBookingCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::nonNull)),
            criteria -> assertThat(criteria).isEqualTo(fileBookingCriteria)
        );
    }

    @Test
    void toStringVerifier() {
        var fileBookingCriteria = new FileBookingCriteria();

        assertThat(fileBookingCriteria).hasToString("FileBookingCriteria{}");
    }

    private static void setAllFilters(FileBookingCriteria fileBookingCriteria) {
        fileBookingCriteria.id();
        fileBookingCriteria.bucket();
        fileBookingCriteria.objectKey();
        fileBookingCriteria.contentType();
        fileBookingCriteria.size();
        fileBookingCriteria.createdAt();
        fileBookingCriteria.updatedAt();
        fileBookingCriteria.isDeleted();
        fileBookingCriteria.deletedAt();
        fileBookingCriteria.deletedBy();
        fileBookingCriteria.ticketId();
        fileBookingCriteria.distinct();
    }

    private static Condition<FileBookingCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getBucket()) &&
                condition.apply(criteria.getObjectKey()) &&
                condition.apply(criteria.getContentType()) &&
                condition.apply(criteria.getSize()) &&
                condition.apply(criteria.getCreatedAt()) &&
                condition.apply(criteria.getUpdatedAt()) &&
                condition.apply(criteria.getIsDeleted()) &&
                condition.apply(criteria.getDeletedAt()) &&
                condition.apply(criteria.getDeletedBy()) &&
                condition.apply(criteria.getTicketId()) &&
                condition.apply(criteria.getDistinct()),
            "every filter matches"
        );
    }

    private static Condition<FileBookingCriteria> copyFiltersAre(FileBookingCriteria copy, BiFunction<Object, Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId(), copy.getId()) &&
                condition.apply(criteria.getBucket(), copy.getBucket()) &&
                condition.apply(criteria.getObjectKey(), copy.getObjectKey()) &&
                condition.apply(criteria.getContentType(), copy.getContentType()) &&
                condition.apply(criteria.getSize(), copy.getSize()) &&
                condition.apply(criteria.getCreatedAt(), copy.getCreatedAt()) &&
                condition.apply(criteria.getUpdatedAt(), copy.getUpdatedAt()) &&
                condition.apply(criteria.getIsDeleted(), copy.getIsDeleted()) &&
                condition.apply(criteria.getDeletedAt(), copy.getDeletedAt()) &&
                condition.apply(criteria.getDeletedBy(), copy.getDeletedBy()) &&
                condition.apply(criteria.getTicketId(), copy.getTicketId()) &&
                condition.apply(criteria.getDistinct(), copy.getDistinct()),
            "every filter matches"
        );
    }
}
