package com.ticketsystem.route.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class VehicleReviewTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static VehicleReview getVehicleReviewSample1() {
        return new VehicleReview()
            .id(1L)
            .userId(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"))
            .tripId(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"))
            .rating(1)
            .comment("comment1")
            .cleanliness(1)
            .comfort(1)
            .punctuality(1)
            .staffService(1);
    }

    public static VehicleReview getVehicleReviewSample2() {
        return new VehicleReview()
            .id(2L)
            .userId(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"))
            .tripId(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"))
            .rating(2)
            .comment("comment2")
            .cleanliness(2)
            .comfort(2)
            .punctuality(2)
            .staffService(2);
    }

    public static VehicleReview getVehicleReviewRandomSampleGenerator() {
        return new VehicleReview()
            .id(longCount.incrementAndGet())
            .userId(UUID.randomUUID())
            .tripId(UUID.randomUUID())
            .rating(intCount.incrementAndGet())
            .comment(UUID.randomUUID().toString())
            .cleanliness(intCount.incrementAndGet())
            .comfort(intCount.incrementAndGet())
            .punctuality(intCount.incrementAndGet())
            .staffService(intCount.incrementAndGet());
    }
}
