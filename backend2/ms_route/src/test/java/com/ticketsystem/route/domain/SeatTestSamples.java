package com.ticketsystem.route.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class SeatTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Seat getSeatSample1() {
        return new Seat().id(1L).seatNumber("seatNumber1").deck("deck1");
    }

    public static Seat getSeatSample2() {
        return new Seat().id(2L).seatNumber("seatNumber2").deck("deck2");
    }

    public static Seat getSeatRandomSampleGenerator() {
        return new Seat().id(longCount.incrementAndGet()).seatNumber(UUID.randomUUID().toString()).deck(UUID.randomUUID().toString());
    }
}
