package com.ridehub.booking.service.criteria;

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
        bookingCriteria.bookingCode();
        bookingCriteria.status();
        bookingCriteria.quantity();
        bookingCriteria.totalAmount();
        bookingCriteria.bookedAt();
        bookingCriteria.customerId();
        bookingCriteria.idempotencyKey();
        bookingCriteria.tripId();
        bookingCriteria.lockGroupId();
        bookingCriteria.expiresAt();
        bookingCriteria.timeoutMinutes();
        bookingCriteria.createdAt();
        bookingCriteria.updatedAt();
        bookingCriteria.isDeleted();
        bookingCriteria.deletedAt();
        bookingCriteria.deletedBy();
        bookingCriteria.invoiceId();
        bookingCriteria.paymentTransactionId();
        bookingCriteria.ticketsId();
        bookingCriteria.appliedPromosId();
        bookingCriteria.pricingSnapshotsId();
        bookingCriteria.distinct();
    }

    private static Condition<BookingCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getBookingCode()) &&
                condition.apply(criteria.getStatus()) &&
                condition.apply(criteria.getQuantity()) &&
                condition.apply(criteria.getTotalAmount()) &&
                condition.apply(criteria.getBookedAt()) &&
                condition.apply(criteria.getCustomerId()) &&
                condition.apply(criteria.getIdempotencyKey()) &&
                condition.apply(criteria.getTripId()) &&
                condition.apply(criteria.getLockGroupId()) &&
                condition.apply(criteria.getExpiresAt()) &&
                condition.apply(criteria.getTimeoutMinutes()) &&
                condition.apply(criteria.getCreatedAt()) &&
                condition.apply(criteria.getUpdatedAt()) &&
                condition.apply(criteria.getIsDeleted()) &&
                condition.apply(criteria.getDeletedAt()) &&
                condition.apply(criteria.getDeletedBy()) &&
                condition.apply(criteria.getInvoiceId()) &&
                condition.apply(criteria.getPaymentTransactionId()) &&
                condition.apply(criteria.getTicketsId()) &&
                condition.apply(criteria.getAppliedPromosId()) &&
                condition.apply(criteria.getPricingSnapshotsId()) &&
                condition.apply(criteria.getDistinct()),
            "every filter matches"
        );
    }

    private static Condition<BookingCriteria> copyFiltersAre(BookingCriteria copy, BiFunction<Object, Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId(), copy.getId()) &&
                condition.apply(criteria.getBookingCode(), copy.getBookingCode()) &&
                condition.apply(criteria.getStatus(), copy.getStatus()) &&
                condition.apply(criteria.getQuantity(), copy.getQuantity()) &&
                condition.apply(criteria.getTotalAmount(), copy.getTotalAmount()) &&
                condition.apply(criteria.getBookedAt(), copy.getBookedAt()) &&
                condition.apply(criteria.getCustomerId(), copy.getCustomerId()) &&
                condition.apply(criteria.getIdempotencyKey(), copy.getIdempotencyKey()) &&
                condition.apply(criteria.getTripId(), copy.getTripId()) &&
                condition.apply(criteria.getLockGroupId(), copy.getLockGroupId()) &&
                condition.apply(criteria.getExpiresAt(), copy.getExpiresAt()) &&
                condition.apply(criteria.getTimeoutMinutes(), copy.getTimeoutMinutes()) &&
                condition.apply(criteria.getCreatedAt(), copy.getCreatedAt()) &&
                condition.apply(criteria.getUpdatedAt(), copy.getUpdatedAt()) &&
                condition.apply(criteria.getIsDeleted(), copy.getIsDeleted()) &&
                condition.apply(criteria.getDeletedAt(), copy.getDeletedAt()) &&
                condition.apply(criteria.getDeletedBy(), copy.getDeletedBy()) &&
                condition.apply(criteria.getInvoiceId(), copy.getInvoiceId()) &&
                condition.apply(criteria.getPaymentTransactionId(), copy.getPaymentTransactionId()) &&
                condition.apply(criteria.getTicketsId(), copy.getTicketsId()) &&
                condition.apply(criteria.getAppliedPromosId(), copy.getAppliedPromosId()) &&
                condition.apply(criteria.getPricingSnapshotsId(), copy.getPricingSnapshotsId()) &&
                condition.apply(criteria.getDistinct(), copy.getDistinct()),
            "every filter matches"
        );
    }
}
