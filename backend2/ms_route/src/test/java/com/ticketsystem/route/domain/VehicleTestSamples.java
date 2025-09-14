package com.ticketsystem.route.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class VehicleTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static Vehicle getVehicleSample1() {
        return new Vehicle()
            .id(1L)
            .plateNumber("plateNumber1")
            .model("model1")
            .capacity(1)
            .seatLayout("seatLayout1")
            .amenities("amenities1")
            .imageCoverUrl("imageCoverUrl1")
            .totalReviews(1)
            .yearManufactured(1);
    }

    public static Vehicle getVehicleSample2() {
        return new Vehicle()
            .id(2L)
            .plateNumber("plateNumber2")
            .model("model2")
            .capacity(2)
            .seatLayout("seatLayout2")
            .amenities("amenities2")
            .imageCoverUrl("imageCoverUrl2")
            .totalReviews(2)
            .yearManufactured(2);
    }

    public static Vehicle getVehicleRandomSampleGenerator() {
        return new Vehicle()
            .id(longCount.incrementAndGet())
            .plateNumber(UUID.randomUUID().toString())
            .model(UUID.randomUUID().toString())
            .capacity(intCount.incrementAndGet())
            .seatLayout(UUID.randomUUID().toString())
            .amenities(UUID.randomUUID().toString())
            .imageCoverUrl(UUID.randomUUID().toString())
            .totalReviews(intCount.incrementAndGet())
            .yearManufactured(intCount.incrementAndGet());
    }
}
