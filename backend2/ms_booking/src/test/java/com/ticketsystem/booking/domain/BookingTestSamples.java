package com.ticketsystem.booking.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class BookingTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Booking getBookingSample1() {
        return new Booking()
            .id(1L)
            .userId(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"))
            .tripId(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"))
            .bookingReference("bookingReference1")
            .contactPhone("contactPhone1")
            .contactEmail("contactEmail1")
            .specialRequests("specialRequests1");
    }

    public static Booking getBookingSample2() {
        return new Booking()
            .id(2L)
            .userId(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"))
            .tripId(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"))
            .bookingReference("bookingReference2")
            .contactPhone("contactPhone2")
            .contactEmail("contactEmail2")
            .specialRequests("specialRequests2");
    }

    public static Booking getBookingRandomSampleGenerator() {
        return new Booking()
            .id(longCount.incrementAndGet())
            .userId(UUID.randomUUID())
            .tripId(UUID.randomUUID())
            .bookingReference(UUID.randomUUID().toString())
            .contactPhone(UUID.randomUUID().toString())
            .contactEmail(UUID.randomUUID().toString())
            .specialRequests(UUID.randomUUID().toString());
    }
}
