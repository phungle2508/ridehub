package com.ticketsystem.booking.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class PassengerTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Passenger getPassengerSample1() {
        return new Passenger()
            .id(1L)
            .seatId(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"))
            .firstName("firstName1")
            .lastName("lastName1")
            .idNumber("idNumber1")
            .nationality("nationality1")
            .ticketNumber("ticketNumber1");
    }

    public static Passenger getPassengerSample2() {
        return new Passenger()
            .id(2L)
            .seatId(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"))
            .firstName("firstName2")
            .lastName("lastName2")
            .idNumber("idNumber2")
            .nationality("nationality2")
            .ticketNumber("ticketNumber2");
    }

    public static Passenger getPassengerRandomSampleGenerator() {
        return new Passenger()
            .id(longCount.incrementAndGet())
            .seatId(UUID.randomUUID())
            .firstName(UUID.randomUUID().toString())
            .lastName(UUID.randomUUID().toString())
            .idNumber(UUID.randomUUID().toString())
            .nationality(UUID.randomUUID().toString())
            .ticketNumber(UUID.randomUUID().toString());
    }
}
