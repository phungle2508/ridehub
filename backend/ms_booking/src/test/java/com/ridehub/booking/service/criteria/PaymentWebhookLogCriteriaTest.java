package com.ridehub.booking.service.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class PaymentWebhookLogCriteriaTest {

    @Test
    void newPaymentWebhookLogCriteriaHasAllFiltersNullTest() {
        var paymentWebhookLogCriteria = new PaymentWebhookLogCriteria();
        assertThat(paymentWebhookLogCriteria).is(criteriaFiltersAre(Objects::isNull));
    }

    @Test
    void paymentWebhookLogCriteriaFluentMethodsCreatesFiltersTest() {
        var paymentWebhookLogCriteria = new PaymentWebhookLogCriteria();

        setAllFilters(paymentWebhookLogCriteria);

        assertThat(paymentWebhookLogCriteria).is(criteriaFiltersAre(Objects::nonNull));
    }

    @Test
    void paymentWebhookLogCriteriaCopyCreatesNullFilterTest() {
        var paymentWebhookLogCriteria = new PaymentWebhookLogCriteria();
        var copy = paymentWebhookLogCriteria.copy();

        assertThat(paymentWebhookLogCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::isNull)),
            criteria -> assertThat(criteria).isEqualTo(paymentWebhookLogCriteria)
        );
    }

    @Test
    void paymentWebhookLogCriteriaCopyDuplicatesEveryExistingFilterTest() {
        var paymentWebhookLogCriteria = new PaymentWebhookLogCriteria();
        setAllFilters(paymentWebhookLogCriteria);

        var copy = paymentWebhookLogCriteria.copy();

        assertThat(paymentWebhookLogCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::nonNull)),
            criteria -> assertThat(criteria).isEqualTo(paymentWebhookLogCriteria)
        );
    }

    @Test
    void toStringVerifier() {
        var paymentWebhookLogCriteria = new PaymentWebhookLogCriteria();

        assertThat(paymentWebhookLogCriteria).hasToString("PaymentWebhookLogCriteria{}");
    }

    private static void setAllFilters(PaymentWebhookLogCriteria paymentWebhookLogCriteria) {
        paymentWebhookLogCriteria.id();
        paymentWebhookLogCriteria.provider();
        paymentWebhookLogCriteria.payloadHash();
        paymentWebhookLogCriteria.receivedAt();
        paymentWebhookLogCriteria.processingStatus();
        paymentWebhookLogCriteria.createdAt();
        paymentWebhookLogCriteria.updatedAt();
        paymentWebhookLogCriteria.isDeleted();
        paymentWebhookLogCriteria.deletedAt();
        paymentWebhookLogCriteria.deletedBy();
        paymentWebhookLogCriteria.paymentTransactionId();
        paymentWebhookLogCriteria.distinct();
    }

    private static Condition<PaymentWebhookLogCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getProvider()) &&
                condition.apply(criteria.getPayloadHash()) &&
                condition.apply(criteria.getReceivedAt()) &&
                condition.apply(criteria.getProcessingStatus()) &&
                condition.apply(criteria.getCreatedAt()) &&
                condition.apply(criteria.getUpdatedAt()) &&
                condition.apply(criteria.getIsDeleted()) &&
                condition.apply(criteria.getDeletedAt()) &&
                condition.apply(criteria.getDeletedBy()) &&
                condition.apply(criteria.getPaymentTransactionId()) &&
                condition.apply(criteria.getDistinct()),
            "every filter matches"
        );
    }

    private static Condition<PaymentWebhookLogCriteria> copyFiltersAre(
        PaymentWebhookLogCriteria copy,
        BiFunction<Object, Object, Boolean> condition
    ) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId(), copy.getId()) &&
                condition.apply(criteria.getProvider(), copy.getProvider()) &&
                condition.apply(criteria.getPayloadHash(), copy.getPayloadHash()) &&
                condition.apply(criteria.getReceivedAt(), copy.getReceivedAt()) &&
                condition.apply(criteria.getProcessingStatus(), copy.getProcessingStatus()) &&
                condition.apply(criteria.getCreatedAt(), copy.getCreatedAt()) &&
                condition.apply(criteria.getUpdatedAt(), copy.getUpdatedAt()) &&
                condition.apply(criteria.getIsDeleted(), copy.getIsDeleted()) &&
                condition.apply(criteria.getDeletedAt(), copy.getDeletedAt()) &&
                condition.apply(criteria.getDeletedBy(), copy.getDeletedBy()) &&
                condition.apply(criteria.getPaymentTransactionId(), copy.getPaymentTransactionId()) &&
                condition.apply(criteria.getDistinct(), copy.getDistinct()),
            "every filter matches"
        );
    }
}
