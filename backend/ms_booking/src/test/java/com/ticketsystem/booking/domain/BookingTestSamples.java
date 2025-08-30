package com.ticketsystem.booking.domain;

import java.util.UUID;

public class BookingTestSamples {

    public static Booking getBookingSample1() {
        return new Booking()
            .id(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"))
            .userId(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"))
            .scheduleId(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"))
            .contactEmail("contactEmail1")
            .contactPhone("contactPhone1")
            .bookingReference("bookingReference1");
    }

    public static Booking getBookingSample2() {
        return new Booking()
            .id(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"))
            .userId(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"))
            .scheduleId(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"))
            .contactEmail("contactEmail2")
            .contactPhone("contactPhone2")
            .bookingReference("bookingReference2");
    }

    public static Booking getBookingRandomSampleGenerator() {
        return new Booking()
            .id(UUID.randomUUID())
            .userId(UUID.randomUUID())
            .scheduleId(UUID.randomUUID())
            .contactEmail(UUID.randomUUID().toString())
            .contactPhone(UUID.randomUUID().toString())
            .bookingReference(UUID.randomUUID().toString());
    }
}
