package com.ticketsystem.booking.service.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class BookingHistoryCriteriaTest {

    @Test
    void newBookingHistoryCriteriaHasAllFiltersNullTest() {
        var bookingHistoryCriteria = new BookingHistoryCriteria();
        assertThat(bookingHistoryCriteria).is(criteriaFiltersAre(Objects::isNull));
    }

    @Test
    void bookingHistoryCriteriaFluentMethodsCreatesFiltersTest() {
        var bookingHistoryCriteria = new BookingHistoryCriteria();

        setAllFilters(bookingHistoryCriteria);

        assertThat(bookingHistoryCriteria).is(criteriaFiltersAre(Objects::nonNull));
    }

    @Test
    void bookingHistoryCriteriaCopyCreatesNullFilterTest() {
        var bookingHistoryCriteria = new BookingHistoryCriteria();
        var copy = bookingHistoryCriteria.copy();

        assertThat(bookingHistoryCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::isNull)),
            criteria -> assertThat(criteria).isEqualTo(bookingHistoryCriteria)
        );
    }

    @Test
    void bookingHistoryCriteriaCopyDuplicatesEveryExistingFilterTest() {
        var bookingHistoryCriteria = new BookingHistoryCriteria();
        setAllFilters(bookingHistoryCriteria);

        var copy = bookingHistoryCriteria.copy();

        assertThat(bookingHistoryCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::nonNull)),
            criteria -> assertThat(criteria).isEqualTo(bookingHistoryCriteria)
        );
    }

    @Test
    void toStringVerifier() {
        var bookingHistoryCriteria = new BookingHistoryCriteria();

        assertThat(bookingHistoryCriteria).hasToString("BookingHistoryCriteria{}");
    }

    private static void setAllFilters(BookingHistoryCriteria bookingHistoryCriteria) {
        bookingHistoryCriteria.id();
        bookingHistoryCriteria.previousStatus();
        bookingHistoryCriteria.newStatus();
        bookingHistoryCriteria.reason();
        bookingHistoryCriteria.changedBy();
        bookingHistoryCriteria.changedAt();
        bookingHistoryCriteria.bookingId();
        bookingHistoryCriteria.distinct();
    }

    private static Condition<BookingHistoryCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getPreviousStatus()) &&
                condition.apply(criteria.getNewStatus()) &&
                condition.apply(criteria.getReason()) &&
                condition.apply(criteria.getChangedBy()) &&
                condition.apply(criteria.getChangedAt()) &&
                condition.apply(criteria.getBookingId()) &&
                condition.apply(criteria.getDistinct()),
            "every filter matches"
        );
    }

    private static Condition<BookingHistoryCriteria> copyFiltersAre(
        BookingHistoryCriteria copy,
        BiFunction<Object, Object, Boolean> condition
    ) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId(), copy.getId()) &&
                condition.apply(criteria.getPreviousStatus(), copy.getPreviousStatus()) &&
                condition.apply(criteria.getNewStatus(), copy.getNewStatus()) &&
                condition.apply(criteria.getReason(), copy.getReason()) &&
                condition.apply(criteria.getChangedBy(), copy.getChangedBy()) &&
                condition.apply(criteria.getChangedAt(), copy.getChangedAt()) &&
                condition.apply(criteria.getBookingId(), copy.getBookingId()) &&
                condition.apply(criteria.getDistinct(), copy.getDistinct()),
            "every filter matches"
        );
    }
}
