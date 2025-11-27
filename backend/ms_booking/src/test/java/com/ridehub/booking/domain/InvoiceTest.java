package com.ridehub.booking.domain;

import static com.ridehub.booking.domain.BookingTestSamples.*;
import static com.ridehub.booking.domain.InvoiceTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.booking.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class InvoiceTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Invoice.class);
        Invoice invoice1 = getInvoiceSample1();
        Invoice invoice2 = new Invoice();
        assertThat(invoice1).isNotEqualTo(invoice2);

        invoice2.setId(invoice1.getId());
        assertThat(invoice1).isEqualTo(invoice2);

        invoice2 = getInvoiceSample2();
        assertThat(invoice1).isNotEqualTo(invoice2);
    }

    @Test
    void bookingTest() {
        Invoice invoice = getInvoiceRandomSampleGenerator();
        Booking bookingBack = getBookingRandomSampleGenerator();

        invoice.setBooking(bookingBack);
        assertThat(invoice.getBooking()).isEqualTo(bookingBack);
        assertThat(bookingBack.getInvoice()).isEqualTo(invoice);

        invoice.booking(null);
        assertThat(invoice.getBooking()).isNull();
        assertThat(bookingBack.getInvoice()).isNull();
    }
}
