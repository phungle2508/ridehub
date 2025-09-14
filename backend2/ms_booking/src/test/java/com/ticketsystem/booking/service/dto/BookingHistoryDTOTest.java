package com.ticketsystem.booking.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.ticketsystem.booking.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class BookingHistoryDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(BookingHistoryDTO.class);
        BookingHistoryDTO bookingHistoryDTO1 = new BookingHistoryDTO();
        bookingHistoryDTO1.setId(1L);
        BookingHistoryDTO bookingHistoryDTO2 = new BookingHistoryDTO();
        assertThat(bookingHistoryDTO1).isNotEqualTo(bookingHistoryDTO2);
        bookingHistoryDTO2.setId(bookingHistoryDTO1.getId());
        assertThat(bookingHistoryDTO1).isEqualTo(bookingHistoryDTO2);
        bookingHistoryDTO2.setId(2L);
        assertThat(bookingHistoryDTO1).isNotEqualTo(bookingHistoryDTO2);
        bookingHistoryDTO1.setId(null);
        assertThat(bookingHistoryDTO1).isNotEqualTo(bookingHistoryDTO2);
    }
}
