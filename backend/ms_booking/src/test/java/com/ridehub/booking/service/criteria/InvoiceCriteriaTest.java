package com.ridehub.booking.service.criteria;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

class InvoiceCriteriaTest {

    @Test
    void newInvoiceCriteriaHasAllFiltersNullTest() {
        var invoiceCriteria = new InvoiceCriteria();
        assertThat(invoiceCriteria).is(criteriaFiltersAre(Objects::isNull));
    }

    @Test
    void invoiceCriteriaFluentMethodsCreatesFiltersTest() {
        var invoiceCriteria = new InvoiceCriteria();

        setAllFilters(invoiceCriteria);

        assertThat(invoiceCriteria).is(criteriaFiltersAre(Objects::nonNull));
    }

    @Test
    void invoiceCriteriaCopyCreatesNullFilterTest() {
        var invoiceCriteria = new InvoiceCriteria();
        var copy = invoiceCriteria.copy();

        assertThat(invoiceCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::isNull)),
            criteria -> assertThat(criteria).isEqualTo(invoiceCriteria)
        );
    }

    @Test
    void invoiceCriteriaCopyDuplicatesEveryExistingFilterTest() {
        var invoiceCriteria = new InvoiceCriteria();
        setAllFilters(invoiceCriteria);

        var copy = invoiceCriteria.copy();

        assertThat(invoiceCriteria).satisfies(
            criteria ->
                assertThat(criteria).is(
                    copyFiltersAre(copy, (a, b) -> (a == null || a instanceof Boolean) ? a == b : (a != b && a.equals(b)))
                ),
            criteria -> assertThat(criteria).isEqualTo(copy),
            criteria -> assertThat(criteria).hasSameHashCodeAs(copy)
        );

        assertThat(copy).satisfies(
            criteria -> assertThat(criteria).is(criteriaFiltersAre(Objects::nonNull)),
            criteria -> assertThat(criteria).isEqualTo(invoiceCriteria)
        );
    }

    @Test
    void toStringVerifier() {
        var invoiceCriteria = new InvoiceCriteria();

        assertThat(invoiceCriteria).hasToString("InvoiceCriteria{}");
    }

    private static void setAllFilters(InvoiceCriteria invoiceCriteria) {
        invoiceCriteria.id();
        invoiceCriteria.invoiceNo();
        invoiceCriteria.issuedAt();
        invoiceCriteria.grossAmount();
        invoiceCriteria.vatAmount();
        invoiceCriteria.netAmount();
        invoiceCriteria.createdAt();
        invoiceCriteria.updatedAt();
        invoiceCriteria.isDeleted();
        invoiceCriteria.deletedAt();
        invoiceCriteria.deletedBy();
        invoiceCriteria.bookingId();
        invoiceCriteria.distinct();
    }

    private static Condition<InvoiceCriteria> criteriaFiltersAre(Function<Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId()) &&
                condition.apply(criteria.getInvoiceNo()) &&
                condition.apply(criteria.getIssuedAt()) &&
                condition.apply(criteria.getGrossAmount()) &&
                condition.apply(criteria.getVatAmount()) &&
                condition.apply(criteria.getNetAmount()) &&
                condition.apply(criteria.getCreatedAt()) &&
                condition.apply(criteria.getUpdatedAt()) &&
                condition.apply(criteria.getIsDeleted()) &&
                condition.apply(criteria.getDeletedAt()) &&
                condition.apply(criteria.getDeletedBy()) &&
                condition.apply(criteria.getBookingId()) &&
                condition.apply(criteria.getDistinct()),
            "every filter matches"
        );
    }

    private static Condition<InvoiceCriteria> copyFiltersAre(InvoiceCriteria copy, BiFunction<Object, Object, Boolean> condition) {
        return new Condition<>(
            criteria ->
                condition.apply(criteria.getId(), copy.getId()) &&
                condition.apply(criteria.getInvoiceNo(), copy.getInvoiceNo()) &&
                condition.apply(criteria.getIssuedAt(), copy.getIssuedAt()) &&
                condition.apply(criteria.getGrossAmount(), copy.getGrossAmount()) &&
                condition.apply(criteria.getVatAmount(), copy.getVatAmount()) &&
                condition.apply(criteria.getNetAmount(), copy.getNetAmount()) &&
                condition.apply(criteria.getCreatedAt(), copy.getCreatedAt()) &&
                condition.apply(criteria.getUpdatedAt(), copy.getUpdatedAt()) &&
                condition.apply(criteria.getIsDeleted(), copy.getIsDeleted()) &&
                condition.apply(criteria.getDeletedAt(), copy.getDeletedAt()) &&
                condition.apply(criteria.getDeletedBy(), copy.getDeletedBy()) &&
                condition.apply(criteria.getBookingId(), copy.getBookingId()) &&
                condition.apply(criteria.getDistinct(), copy.getDistinct()),
            "every filter matches"
        );
    }
}
