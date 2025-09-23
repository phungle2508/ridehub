package com.ridehub.booking.domain;

import static com.ridehub.booking.domain.FileBookingTestSamples.*;
import static com.ridehub.booking.domain.TicketTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.booking.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class FileBookingTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(FileBooking.class);
        FileBooking fileBooking1 = getFileBookingSample1();
        FileBooking fileBooking2 = new FileBooking();
        assertThat(fileBooking1).isNotEqualTo(fileBooking2);

        fileBooking2.setId(fileBooking1.getId());
        assertThat(fileBooking1).isEqualTo(fileBooking2);

        fileBooking2 = getFileBookingSample2();
        assertThat(fileBooking1).isNotEqualTo(fileBooking2);
    }

    @Test
    void ticketTest() {
        FileBooking fileBooking = getFileBookingRandomSampleGenerator();
        Ticket ticketBack = getTicketRandomSampleGenerator();

        fileBooking.setTicket(ticketBack);
        assertThat(fileBooking.getTicket()).isEqualTo(ticketBack);
        assertThat(ticketBack.getQrCodeImg()).isEqualTo(fileBooking);

        fileBooking.ticket(null);
        assertThat(fileBooking.getTicket()).isNull();
        assertThat(ticketBack.getQrCodeImg()).isNull();
    }
}
