package com.ridehub.booking.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class TicketTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Ticket getTicketSample1() {
        return new Ticket()
            .id(1L)
            .ticketCode("ticketCode1")
            .qrCode("qrCode1")
            .tripId(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"))
            .routeId(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"))
            .tripSeatId(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"))
            .deletedBy(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"));
    }

    public static Ticket getTicketSample2() {
        return new Ticket()
            .id(2L)
            .ticketCode("ticketCode2")
            .qrCode("qrCode2")
            .tripId(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"))
            .routeId(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"))
            .tripSeatId(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"))
            .deletedBy(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"));
    }

    public static Ticket getTicketRandomSampleGenerator() {
        return new Ticket()
            .id(longCount.incrementAndGet())
            .ticketCode(UUID.randomUUID().toString())
            .qrCode(UUID.randomUUID().toString())
            .tripId(UUID.randomUUID())
            .routeId(UUID.randomUUID())
            .tripSeatId(UUID.randomUUID())
            .deletedBy(UUID.randomUUID());
    }
}
