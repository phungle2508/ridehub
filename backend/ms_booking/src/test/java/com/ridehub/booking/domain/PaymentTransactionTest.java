package com.ridehub.booking.domain;

import static com.ridehub.booking.domain.BookingTestSamples.*;
import static com.ridehub.booking.domain.PaymentTransactionTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.booking.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class PaymentTransactionTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(PaymentTransaction.class);
        PaymentTransaction paymentTransaction1 = getPaymentTransactionSample1();
        PaymentTransaction paymentTransaction2 = new PaymentTransaction();
        assertThat(paymentTransaction1).isNotEqualTo(paymentTransaction2);

        paymentTransaction2.setId(paymentTransaction1.getId());
        assertThat(paymentTransaction1).isEqualTo(paymentTransaction2);

        paymentTransaction2 = getPaymentTransactionSample2();
        assertThat(paymentTransaction1).isNotEqualTo(paymentTransaction2);
    }

    @Test
    void bookingTest() {
        PaymentTransaction paymentTransaction = getPaymentTransactionRandomSampleGenerator();
        Booking bookingBack = getBookingRandomSampleGenerator();

        paymentTransaction.setBooking(bookingBack);
        assertThat(paymentTransaction.getBooking()).isEqualTo(bookingBack);
        assertThat(bookingBack.getPaymentTransaction()).isEqualTo(paymentTransaction);

        paymentTransaction.booking(null);
        assertThat(paymentTransaction.getBooking()).isNull();
        assertThat(bookingBack.getPaymentTransaction()).isNull();
    }
}
