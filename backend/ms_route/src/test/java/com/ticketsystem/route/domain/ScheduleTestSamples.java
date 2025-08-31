package com.ticketsystem.route.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class ScheduleTestSamples {

    private static final Random random = new Random();
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static Schedule getScheduleSample1() {
        return new Schedule().id(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa")).totalSeats(1).availableSeats(1);
    }

    public static Schedule getScheduleSample2() {
        return new Schedule().id(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367")).totalSeats(2).availableSeats(2);
    }

    public static Schedule getScheduleRandomSampleGenerator() {
        return new Schedule().id(UUID.randomUUID()).totalSeats(intCount.incrementAndGet()).availableSeats(intCount.incrementAndGet());
    }
}
