package com.ridehub.booking.domain;

import static com.ridehub.booking.domain.BookingTestSamples.*;
import static com.ridehub.booking.domain.PricingSnapshotTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.booking.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class PricingSnapshotTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(PricingSnapshot.class);
        PricingSnapshot pricingSnapshot1 = getPricingSnapshotSample1();
        PricingSnapshot pricingSnapshot2 = new PricingSnapshot();
        assertThat(pricingSnapshot1).isNotEqualTo(pricingSnapshot2);

        pricingSnapshot2.setId(pricingSnapshot1.getId());
        assertThat(pricingSnapshot1).isEqualTo(pricingSnapshot2);

        pricingSnapshot2 = getPricingSnapshotSample2();
        assertThat(pricingSnapshot1).isNotEqualTo(pricingSnapshot2);
    }

    @Test
    void bookingTest() {
        PricingSnapshot pricingSnapshot = getPricingSnapshotRandomSampleGenerator();
        Booking bookingBack = getBookingRandomSampleGenerator();

        pricingSnapshot.setBooking(bookingBack);
        assertThat(pricingSnapshot.getBooking()).isEqualTo(bookingBack);

        pricingSnapshot.booking(null);
        assertThat(pricingSnapshot.getBooking()).isNull();
    }
}
