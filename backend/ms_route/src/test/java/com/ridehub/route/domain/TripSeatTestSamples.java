package com.ridehub.route.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class TripSeatTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static TripSeat getTripSeatSample1() {
        return new TripSeat().id(1L).seatNo("seatNo1").floorNo(1).deletedBy(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"));
    }

    public static TripSeat getTripSeatSample2() {
        return new TripSeat().id(2L).seatNo("seatNo2").floorNo(2).deletedBy(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"));
    }

    public static TripSeat getTripSeatRandomSampleGenerator() {
        return new TripSeat()
            .id(longCount.incrementAndGet())
            .seatNo(UUID.randomUUID().toString())
            .floorNo(intCount.incrementAndGet())
            .deletedBy(UUID.randomUUID());
    }
}
