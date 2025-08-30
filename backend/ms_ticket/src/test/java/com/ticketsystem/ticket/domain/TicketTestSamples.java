package com.ticketsystem.ticket.domain;

import java.util.UUID;

public class TicketTestSamples {

    public static Ticket getTicketSample1() {
        return new Ticket()
            .id(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"))
            .scheduleId(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"))
            .seatNumber("seatNumber1");
    }

    public static Ticket getTicketSample2() {
        return new Ticket()
            .id(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"))
            .scheduleId(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"))
            .seatNumber("seatNumber2");
    }

    public static Ticket getTicketRandomSampleGenerator() {
        return new Ticket().id(UUID.randomUUID()).scheduleId(UUID.randomUUID()).seatNumber(UUID.randomUUID().toString());
    }
}
