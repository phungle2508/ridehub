package com.ticketsystem.booking.service.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class BookingCriteriaTest {

    @Test
    void newBookingCriteriaHasAllFiltersNullTest() {
        var bookingCriteria = new BookingCriteria();
        assertThat(bookingCriteria).is(criteriaFiltersAre(Objects::isNull));
    }

    @Test
    void bookingCriteriaFluentMethodsCreatesFiltersTest() {
        var bookingCriteria = new BookingCriteria();

        setAllFilters(bookingCriteria);

        assertThat(bookingCriteria).is(criteriaFiltersAre(Objects::nonNull));
    }

    @Test
    void bookingCriteriaCopyCreatesNullFilterTest() {
        var bookingCriteria = new BookingCriteria();
        var copy = bookingCriteria.copy();

        assertThat(bookingCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::isNull)),
            criteria -> assertThat(criteria).isEqualTo(bookingCriteria)
        );
    }

    @Test
    void bookingCriteriaCopyDuplicatesEveryExistingFilterTest() {
        var bookingCriteria = new BookingCriteria();
        setAllFilters(bookingCriteria);

        var copy = bookingCriteria.copy();

        assertThat(bookingCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::nonNull)),
            criteria -> assertThat(criteria).isEqualTo(bookingCriteria)
        );
    }

    @Test
    void toStringVerifier() {
        var bookingCriteria = new BookingCriteria();

        assertThat(bookingCriteria).hasToString("BookingCriteria{}");
    }

    private static void setAllFilters(BookingCriteria bookingCriteria) {
        bookingCriteria.id();
        bookingCriteria.userId();
        bookingCriteria.tripId();
        bookingCriteria.bookingReference();
        bookingCriteria.status();
        bookingCriteria.totalAmount();
        bookingCriteria.contactPhone();
        bookingCriteria.contactEmail();
        bookingCriteria.specialRequests();
        bookingCriteria.createdAt();
        bookingCriteria.expiresAt();
        bookingCriteria.passengersId();
        bookingCriteria.historiesId();
        bookingCriteria.distinct();
    }

    private static Condition<BookingCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getUserId()) &&
                condition.apply(criteria.getTripId()) &&
                condition.apply(criteria.getBookingReference()) &&
                condition.apply(criteria.getStatus()) &&
                condition.apply(criteria.getTotalAmount()) &&
                condition.apply(criteria.getContactPhone()) &&
                condition.apply(criteria.getContactEmail()) &&
                condition.apply(criteria.getSpecialRequests()) &&
                condition.apply(criteria.getCreatedAt()) &&
                condition.apply(criteria.getExpiresAt()) &&
                condition.apply(criteria.getPassengersId()) &&
                condition.apply(criteria.getHistoriesId()) &&
                condition.apply(criteria.getDistinct()),
            "every filter matches"
        );
    }

    private static Condition<BookingCriteria> copyFiltersAre(BookingCriteria copy, BiFunction<Object, Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId(), copy.getId()) &&
                condition.apply(criteria.getUserId(), copy.getUserId()) &&
                condition.apply(criteria.getTripId(), copy.getTripId()) &&
                condition.apply(criteria.getBookingReference(), copy.getBookingReference()) &&
                condition.apply(criteria.getStatus(), copy.getStatus()) &&
                condition.apply(criteria.getTotalAmount(), copy.getTotalAmount()) &&
                condition.apply(criteria.getContactPhone(), copy.getContactPhone()) &&
                condition.apply(criteria.getContactEmail(), copy.getContactEmail()) &&
                condition.apply(criteria.getSpecialRequests(), copy.getSpecialRequests()) &&
                condition.apply(criteria.getCreatedAt(), copy.getCreatedAt()) &&
                condition.apply(criteria.getExpiresAt(), copy.getExpiresAt()) &&
                condition.apply(criteria.getPassengersId(), copy.getPassengersId()) &&
                condition.apply(criteria.getHistoriesId(), copy.getHistoriesId()) &&
                condition.apply(criteria.getDistinct(), copy.getDistinct()),
            "every filter matches"
        );
    }
}
