package com.ridehub.route.domain;

import static com.ridehub.route.domain.SeatLockTestSamples.*;
import static org.assertj.core.api.Assertions.assertThat;

import com.ridehub.route.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class SeatLockTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SeatLock.class);
        SeatLock seatLock1 = getSeatLockSample1();
        SeatLock seatLock2 = new SeatLock();
        assertThat(seatLock1).isNotEqualTo(seatLock2);

        seatLock2.setId(seatLock1.getId());
        assertThat(seatLock1).isEqualTo(seatLock2);

        seatLock2 = getSeatLockSample2();
        assertThat(seatLock1).isNotEqualTo(seatLock2);
    }
}
