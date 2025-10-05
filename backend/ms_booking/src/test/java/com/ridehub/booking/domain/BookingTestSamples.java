package com.ridehub.booking.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class BookingTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static Booking getBookingSample1() {
        return new Booking()
            .id(1L)
            .bookingCode("bookingCode1")
            .quantity(1)
            .customerId(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"))
            .idempotencyKey("idempotencyKey1")
            .tripId(1L)
            .lockGroupId("lockGroupId1")
            .timeoutMinutes(1)
            .deletedBy(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"));
    }

    public static Booking getBookingSample2() {
        return new Booking()
            .id(2L)
            .bookingCode("bookingCode2")
            .quantity(2)
            .customerId(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"))
            .idempotencyKey("idempotencyKey2")
            .tripId(2L)
            .lockGroupId("lockGroupId2")
            .timeoutMinutes(2)
            .deletedBy(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"));
    }

    public static Booking getBookingRandomSampleGenerator() {
        return new Booking()
            .id(longCount.incrementAndGet())
            .bookingCode(UUID.randomUUID().toString())
            .quantity(intCount.incrementAndGet())
            .customerId(UUID.randomUUID())
            .idempotencyKey(UUID.randomUUID().toString())
            .tripId(longCount.incrementAndGet())
            .lockGroupId(UUID.randomUUID().toString())
            .timeoutMinutes(intCount.incrementAndGet())
            .deletedBy(UUID.randomUUID());
    }
}
