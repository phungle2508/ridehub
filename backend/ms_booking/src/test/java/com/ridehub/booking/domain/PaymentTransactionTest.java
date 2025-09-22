package com.ridehub.booking.domain;

import static com.ridehub.booking.domain.BookingTestSamples.*;
import static com.ridehub.booking.domain.PaymentTransactionTestSamples.*;
import static com.ridehub.booking.domain.PaymentWebhookLogTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.booking.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
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
    void webhooksTest() {
        PaymentTransaction paymentTransaction = getPaymentTransactionRandomSampleGenerator();
        PaymentWebhookLog paymentWebhookLogBack = getPaymentWebhookLogRandomSampleGenerator();

        paymentTransaction.addWebhooks(paymentWebhookLogBack);
        assertThat(paymentTransaction.getWebhooks()).containsOnly(paymentWebhookLogBack);
        assertThat(paymentWebhookLogBack.getPaymentTransaction()).isEqualTo(paymentTransaction);

        paymentTransaction.removeWebhooks(paymentWebhookLogBack);
        assertThat(paymentTransaction.getWebhooks()).doesNotContain(paymentWebhookLogBack);
        assertThat(paymentWebhookLogBack.getPaymentTransaction()).isNull();

        paymentTransaction.webhooks(new HashSet<>(Set.of(paymentWebhookLogBack)));
        assertThat(paymentTransaction.getWebhooks()).containsOnly(paymentWebhookLogBack);
        assertThat(paymentWebhookLogBack.getPaymentTransaction()).isEqualTo(paymentTransaction);

        paymentTransaction.setWebhooks(new HashSet<>());
        assertThat(paymentTransaction.getWebhooks()).doesNotContain(paymentWebhookLogBack);
        assertThat(paymentWebhookLogBack.getPaymentTransaction()).isNull();
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
