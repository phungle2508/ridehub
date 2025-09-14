package com.ticketsystem.booking.domain;

import static com.ticketsystem.booking.domain.BookingHistoryTestSamples.*;
import static com.ticketsystem.booking.domain.BookingTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ticketsystem.booking.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class BookingHistoryTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(BookingHistory.class);
        BookingHistory bookingHistory1 = getBookingHistorySample1();
        BookingHistory bookingHistory2 = new BookingHistory();
        assertThat(bookingHistory1).isNotEqualTo(bookingHistory2);

        bookingHistory2.setId(bookingHistory1.getId());
        assertThat(bookingHistory1).isEqualTo(bookingHistory2);

        bookingHistory2 = getBookingHistorySample2();
        assertThat(bookingHistory1).isNotEqualTo(bookingHistory2);
    }

    @Test
    void bookingTest() {
        BookingHistory bookingHistory = getBookingHistoryRandomSampleGenerator();
        Booking bookingBack = getBookingRandomSampleGenerator();

        bookingHistory.setBooking(bookingBack);
        assertThat(bookingHistory.getBooking()).isEqualTo(bookingBack);

        bookingHistory.booking(null);
        assertThat(bookingHistory.getBooking()).isNull();
    }
}
