package com.ticketsystem.booking.domain;

import static com.ticketsystem.booking.domain.BookingHistoryTestSamples.*;
import static com.ticketsystem.booking.domain.BookingTestSamples.*;
import static com.ticketsystem.booking.domain.PassengerTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ticketsystem.booking.web.rest.TestUtil;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class BookingTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Booking.class);
        Booking booking1 = getBookingSample1();
        Booking booking2 = new Booking();
        assertThat(booking1).isNotEqualTo(booking2);

        booking2.setId(booking1.getId());
        assertThat(booking1).isEqualTo(booking2);

        booking2 = getBookingSample2();
        assertThat(booking1).isNotEqualTo(booking2);
    }

    @Test
    void passengersTest() {
        Booking booking = getBookingRandomSampleGenerator();
        Passenger passengerBack = getPassengerRandomSampleGenerator();

        booking.addPassengers(passengerBack);
        assertThat(booking.getPassengers()).containsOnly(passengerBack);
        assertThat(passengerBack.getBooking()).isEqualTo(booking);

        booking.removePassengers(passengerBack);
        assertThat(booking.getPassengers()).doesNotContain(passengerBack);
        assertThat(passengerBack.getBooking()).isNull();

        booking.passengers(new HashSet<>(Set.of(passengerBack)));
        assertThat(booking.getPassengers()).containsOnly(passengerBack);
        assertThat(passengerBack.getBooking()).isEqualTo(booking);

        booking.setPassengers(new HashSet<>());
        assertThat(booking.getPassengers()).doesNotContain(passengerBack);
        assertThat(passengerBack.getBooking()).isNull();
    }

    @Test
    void historiesTest() {
        Booking booking = getBookingRandomSampleGenerator();
        BookingHistory bookingHistoryBack = getBookingHistoryRandomSampleGenerator();

        booking.addHistories(bookingHistoryBack);
        assertThat(booking.getHistories()).containsOnly(bookingHistoryBack);
        assertThat(bookingHistoryBack.getBooking()).isEqualTo(booking);

        booking.removeHistories(bookingHistoryBack);
        assertThat(booking.getHistories()).doesNotContain(bookingHistoryBack);
        assertThat(bookingHistoryBack.getBooking()).isNull();

        booking.histories(new HashSet<>(Set.of(bookingHistoryBack)));
        assertThat(booking.getHistories()).containsOnly(bookingHistoryBack);
        assertThat(bookingHistoryBack.getBooking()).isEqualTo(booking);

        booking.setHistories(new HashSet<>());
        assertThat(booking.getHistories()).doesNotContain(bookingHistoryBack);
        assertThat(bookingHistoryBack.getBooking()).isNull();
    }
}
