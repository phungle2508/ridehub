package com.ridehub.booking.service.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class PaymentTransactionCriteriaTest {

    @Test
    void newPaymentTransactionCriteriaHasAllFiltersNullTest() {
        var paymentTransactionCriteria = new PaymentTransactionCriteria();
        assertThat(paymentTransactionCriteria).is(criteriaFiltersAre(Objects::isNull));
    }

    @Test
    void paymentTransactionCriteriaFluentMethodsCreatesFiltersTest() {
        var paymentTransactionCriteria = new PaymentTransactionCriteria();

        setAllFilters(paymentTransactionCriteria);

        assertThat(paymentTransactionCriteria).is(criteriaFiltersAre(Objects::nonNull));
    }

    @Test
    void paymentTransactionCriteriaCopyCreatesNullFilterTest() {
        var paymentTransactionCriteria = new PaymentTransactionCriteria();
        var copy = paymentTransactionCriteria.copy();

        assertThat(paymentTransactionCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::isNull)),
            criteria -> assertThat(criteria).isEqualTo(paymentTransactionCriteria)
        );
    }

    @Test
    void paymentTransactionCriteriaCopyDuplicatesEveryExistingFilterTest() {
        var paymentTransactionCriteria = new PaymentTransactionCriteria();
        setAllFilters(paymentTransactionCriteria);

        var copy = paymentTransactionCriteria.copy();

        assertThat(paymentTransactionCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::nonNull)),
            criteria -> assertThat(criteria).isEqualTo(paymentTransactionCriteria)
        );
    }

    @Test
    void toStringVerifier() {
        var paymentTransactionCriteria = new PaymentTransactionCriteria();

        assertThat(paymentTransactionCriteria).hasToString("PaymentTransactionCriteria{}");
    }

    private static void setAllFilters(PaymentTransactionCriteria paymentTransactionCriteria) {
        paymentTransactionCriteria.id();
        paymentTransactionCriteria.transactionId();
        paymentTransactionCriteria.orderRef();
        paymentTransactionCriteria.method();
        paymentTransactionCriteria.status();
        paymentTransactionCriteria.amount();
        paymentTransactionCriteria.time();
        paymentTransactionCriteria.gatewayCreateDate();
        paymentTransactionCriteria.gatewayNote();
        paymentTransactionCriteria.createdAt();
        paymentTransactionCriteria.updatedAt();
        paymentTransactionCriteria.isDeleted();
        paymentTransactionCriteria.deletedAt();
        paymentTransactionCriteria.deletedBy();
        paymentTransactionCriteria.webhooksId();
        paymentTransactionCriteria.bookingId();
        paymentTransactionCriteria.distinct();
    }

    private static Condition<PaymentTransactionCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getTransactionId()) &&
                condition.apply(criteria.getOrderRef()) &&
                condition.apply(criteria.getMethod()) &&
                condition.apply(criteria.getStatus()) &&
                condition.apply(criteria.getAmount()) &&
                condition.apply(criteria.getTime()) &&
                condition.apply(criteria.getGatewayCreateDate()) &&
                condition.apply(criteria.getGatewayNote()) &&
                condition.apply(criteria.getCreatedAt()) &&
                condition.apply(criteria.getUpdatedAt()) &&
                condition.apply(criteria.getIsDeleted()) &&
                condition.apply(criteria.getDeletedAt()) &&
                condition.apply(criteria.getDeletedBy()) &&
                condition.apply(criteria.getWebhooksId()) &&
                condition.apply(criteria.getBookingId()) &&
                condition.apply(criteria.getDistinct()),
            "every filter matches"
        );
    }

    private static Condition<PaymentTransactionCriteria> copyFiltersAre(
        PaymentTransactionCriteria copy,
        BiFunction<Object, Object, Boolean> condition
    ) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId(), copy.getId()) &&
                condition.apply(criteria.getTransactionId(), copy.getTransactionId()) &&
                condition.apply(criteria.getOrderRef(), copy.getOrderRef()) &&
                condition.apply(criteria.getMethod(), copy.getMethod()) &&
                condition.apply(criteria.getStatus(), copy.getStatus()) &&
                condition.apply(criteria.getAmount(), copy.getAmount()) &&
                condition.apply(criteria.getTime(), copy.getTime()) &&
                condition.apply(criteria.getGatewayCreateDate(), copy.getGatewayCreateDate()) &&
                condition.apply(criteria.getGatewayNote(), copy.getGatewayNote()) &&
                condition.apply(criteria.getCreatedAt(), copy.getCreatedAt()) &&
                condition.apply(criteria.getUpdatedAt(), copy.getUpdatedAt()) &&
                condition.apply(criteria.getIsDeleted(), copy.getIsDeleted()) &&
                condition.apply(criteria.getDeletedAt(), copy.getDeletedAt()) &&
                condition.apply(criteria.getDeletedBy(), copy.getDeletedBy()) &&
                condition.apply(criteria.getWebhooksId(), copy.getWebhooksId()) &&
                condition.apply(criteria.getBookingId(), copy.getBookingId()) &&
                condition.apply(criteria.getDistinct(), copy.getDistinct()),
            "every filter matches"
        );
    }
}
