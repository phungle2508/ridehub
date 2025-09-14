package com.ticketsystem.booking.service.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class PassengerCriteriaTest {

    @Test
    void newPassengerCriteriaHasAllFiltersNullTest() {
        var passengerCriteria = new PassengerCriteria();
        assertThat(passengerCriteria).is(criteriaFiltersAre(Objects::isNull));
    }

    @Test
    void passengerCriteriaFluentMethodsCreatesFiltersTest() {
        var passengerCriteria = new PassengerCriteria();

        setAllFilters(passengerCriteria);

        assertThat(passengerCriteria).is(criteriaFiltersAre(Objects::nonNull));
    }

    @Test
    void passengerCriteriaCopyCreatesNullFilterTest() {
        var passengerCriteria = new PassengerCriteria();
        var copy = passengerCriteria.copy();

        assertThat(passengerCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::isNull)),
            criteria -> assertThat(criteria).isEqualTo(passengerCriteria)
        );
    }

    @Test
    void passengerCriteriaCopyDuplicatesEveryExistingFilterTest() {
        var passengerCriteria = new PassengerCriteria();
        setAllFilters(passengerCriteria);

        var copy = passengerCriteria.copy();

        assertThat(passengerCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::nonNull)),
            criteria -> assertThat(criteria).isEqualTo(passengerCriteria)
        );
    }

    @Test
    void toStringVerifier() {
        var passengerCriteria = new PassengerCriteria();

        assertThat(passengerCriteria).hasToString("PassengerCriteria{}");
    }

    private static void setAllFilters(PassengerCriteria passengerCriteria) {
        passengerCriteria.id();
        passengerCriteria.seatId();
        passengerCriteria.firstName();
        passengerCriteria.lastName();
        passengerCriteria.idNumber();
        passengerCriteria.dateOfBirth();
        passengerCriteria.nationality();
        passengerCriteria.ticketNumber();
        passengerCriteria.bookingId();
        passengerCriteria.distinct();
    }

    private static Condition<PassengerCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getSeatId()) &&
                condition.apply(criteria.getFirstName()) &&
                condition.apply(criteria.getLastName()) &&
                condition.apply(criteria.getIdNumber()) &&
                condition.apply(criteria.getDateOfBirth()) &&
                condition.apply(criteria.getNationality()) &&
                condition.apply(criteria.getTicketNumber()) &&
                condition.apply(criteria.getBookingId()) &&
                condition.apply(criteria.getDistinct()),
            "every filter matches"
        );
    }

    private static Condition<PassengerCriteria> copyFiltersAre(PassengerCriteria copy, BiFunction<Object, Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId(), copy.getId()) &&
                condition.apply(criteria.getSeatId(), copy.getSeatId()) &&
                condition.apply(criteria.getFirstName(), copy.getFirstName()) &&
                condition.apply(criteria.getLastName(), copy.getLastName()) &&
                condition.apply(criteria.getIdNumber(), copy.getIdNumber()) &&
                condition.apply(criteria.getDateOfBirth(), copy.getDateOfBirth()) &&
                condition.apply(criteria.getNationality(), copy.getNationality()) &&
                condition.apply(criteria.getTicketNumber(), copy.getTicketNumber()) &&
                condition.apply(criteria.getBookingId(), copy.getBookingId()) &&
                condition.apply(criteria.getDistinct(), copy.getDistinct()),
            "every filter matches"
        );
    }
}
