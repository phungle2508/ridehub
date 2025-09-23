package com.ridehub.booking.service.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class TicketCriteriaTest {

    @Test
    void newTicketCriteriaHasAllFiltersNullTest() {
        var ticketCriteria = new TicketCriteria();
        assertThat(ticketCriteria).is(criteriaFiltersAre(Objects::isNull));
    }

    @Test
    void ticketCriteriaFluentMethodsCreatesFiltersTest() {
        var ticketCriteria = new TicketCriteria();

        setAllFilters(ticketCriteria);

        assertThat(ticketCriteria).is(criteriaFiltersAre(Objects::nonNull));
    }

    @Test
    void ticketCriteriaCopyCreatesNullFilterTest() {
        var ticketCriteria = new TicketCriteria();
        var copy = ticketCriteria.copy();

        assertThat(ticketCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::isNull)),
            criteria -> assertThat(criteria).isEqualTo(ticketCriteria)
        );
    }

    @Test
    void ticketCriteriaCopyDuplicatesEveryExistingFilterTest() {
        var ticketCriteria = new TicketCriteria();
        setAllFilters(ticketCriteria);

        var copy = ticketCriteria.copy();

        assertThat(ticketCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::nonNull)),
            criteria -> assertThat(criteria).isEqualTo(ticketCriteria)
        );
    }

    @Test
    void toStringVerifier() {
        var ticketCriteria = new TicketCriteria();

        assertThat(ticketCriteria).hasToString("TicketCriteria{}");
    }

    private static void setAllFilters(TicketCriteria ticketCriteria) {
        ticketCriteria.id();
        ticketCriteria.ticketCode();
        ticketCriteria.price();
        ticketCriteria.qrCode();
        ticketCriteria.timeFrom();
        ticketCriteria.timeTo();
        ticketCriteria.checkedIn();
        ticketCriteria.tripId();
        ticketCriteria.routeId();
        ticketCriteria.tripSeatId();
        ticketCriteria.createdAt();
        ticketCriteria.updatedAt();
        ticketCriteria.isDeleted();
        ticketCriteria.deletedAt();
        ticketCriteria.deletedBy();
        ticketCriteria.qrCodeImgId();
        ticketCriteria.bookingId();
        ticketCriteria.distinct();
    }

    private static Condition<TicketCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getTicketCode()) &&
                condition.apply(criteria.getPrice()) &&
                condition.apply(criteria.getQrCode()) &&
                condition.apply(criteria.getTimeFrom()) &&
                condition.apply(criteria.getTimeTo()) &&
                condition.apply(criteria.getCheckedIn()) &&
                condition.apply(criteria.getTripId()) &&
                condition.apply(criteria.getRouteId()) &&
                condition.apply(criteria.getTripSeatId()) &&
                condition.apply(criteria.getCreatedAt()) &&
                condition.apply(criteria.getUpdatedAt()) &&
                condition.apply(criteria.getIsDeleted()) &&
                condition.apply(criteria.getDeletedAt()) &&
                condition.apply(criteria.getDeletedBy()) &&
                condition.apply(criteria.getQrCodeImgId()) &&
                condition.apply(criteria.getBookingId()) &&
                condition.apply(criteria.getDistinct()),
            "every filter matches"
        );
    }

    private static Condition<TicketCriteria> copyFiltersAre(TicketCriteria copy, BiFunction<Object, Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId(), copy.getId()) &&
                condition.apply(criteria.getTicketCode(), copy.getTicketCode()) &&
                condition.apply(criteria.getPrice(), copy.getPrice()) &&
                condition.apply(criteria.getQrCode(), copy.getQrCode()) &&
                condition.apply(criteria.getTimeFrom(), copy.getTimeFrom()) &&
                condition.apply(criteria.getTimeTo(), copy.getTimeTo()) &&
                condition.apply(criteria.getCheckedIn(), copy.getCheckedIn()) &&
                condition.apply(criteria.getTripId(), copy.getTripId()) &&
                condition.apply(criteria.getRouteId(), copy.getRouteId()) &&
                condition.apply(criteria.getTripSeatId(), copy.getTripSeatId()) &&
                condition.apply(criteria.getCreatedAt(), copy.getCreatedAt()) &&
                condition.apply(criteria.getUpdatedAt(), copy.getUpdatedAt()) &&
                condition.apply(criteria.getIsDeleted(), copy.getIsDeleted()) &&
                condition.apply(criteria.getDeletedAt(), copy.getDeletedAt()) &&
                condition.apply(criteria.getDeletedBy(), copy.getDeletedBy()) &&
                condition.apply(criteria.getQrCodeImgId(), copy.getQrCodeImgId()) &&
                condition.apply(criteria.getBookingId(), copy.getBookingId()) &&
                condition.apply(criteria.getDistinct(), copy.getDistinct()),
            "every filter matches"
        );
    }
}
