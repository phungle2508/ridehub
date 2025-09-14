package com.ticketsystem.booking.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class BookingHistoryTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static BookingHistory getBookingHistorySample1() {
        return new BookingHistory().id(1L).reason("reason1").changedBy(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"));
    }

    public static BookingHistory getBookingHistorySample2() {
        return new BookingHistory().id(2L).reason("reason2").changedBy(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"));
    }

    public static BookingHistory getBookingHistoryRandomSampleGenerator() {
        return new BookingHistory().id(longCount.incrementAndGet()).reason(UUID.randomUUID().toString()).changedBy(UUID.randomUUID());
    }
}
