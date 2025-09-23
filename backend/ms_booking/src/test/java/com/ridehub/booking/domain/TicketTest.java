package com.ridehub.booking.domain;

import static com.ridehub.booking.domain.BookingTestSamples.*;
import static com.ridehub.booking.domain.FileBookingTestSamples.*;
import static com.ridehub.booking.domain.TicketTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.booking.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class TicketTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Ticket.class);
        Ticket ticket1 = getTicketSample1();
        Ticket ticket2 = new Ticket();
        assertThat(ticket1).isNotEqualTo(ticket2);

        ticket2.setId(ticket1.getId());
        assertThat(ticket1).isEqualTo(ticket2);

        ticket2 = getTicketSample2();
        assertThat(ticket1).isNotEqualTo(ticket2);
    }

    @Test
    void qrCodeImgTest() {
        Ticket ticket = getTicketRandomSampleGenerator();
        FileBooking fileBookingBack = getFileBookingRandomSampleGenerator();

        ticket.setQrCodeImg(fileBookingBack);
        assertThat(ticket.getQrCodeImg()).isEqualTo(fileBookingBack);

        ticket.qrCodeImg(null);
        assertThat(ticket.getQrCodeImg()).isNull();
    }

    @Test
    void bookingTest() {
        Ticket ticket = getTicketRandomSampleGenerator();
        Booking bookingBack = getBookingRandomSampleGenerator();

        ticket.setBooking(bookingBack);
        assertThat(ticket.getBooking()).isEqualTo(bookingBack);

        ticket.booking(null);
        assertThat(ticket.getBooking()).isNull();
    }
}
