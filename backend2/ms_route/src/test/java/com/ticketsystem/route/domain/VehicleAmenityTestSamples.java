package com.ticketsystem.route.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class VehicleAmenityTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static VehicleAmenity getVehicleAmenitySample1() {
        return new VehicleAmenity().id(1L).amenity("amenity1").description("description1");
    }

    public static VehicleAmenity getVehicleAmenitySample2() {
        return new VehicleAmenity().id(2L).amenity("amenity2").description("description2");
    }

    public static VehicleAmenity getVehicleAmenityRandomSampleGenerator() {
        return new VehicleAmenity()
            .id(longCount.incrementAndGet())
            .amenity(UUID.randomUUID().toString())
            .description(UUID.randomUUID().toString());
    }
}
