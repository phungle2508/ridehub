package com.ticketsystem.route.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class VehicleImageTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static VehicleImage getVehicleImageSample1() {
        return new VehicleImage().id(1L).imageUrl("imageUrl1").imageType("imageType1").description("description1");
    }

    public static VehicleImage getVehicleImageSample2() {
        return new VehicleImage().id(2L).imageUrl("imageUrl2").imageType("imageType2").description("description2");
    }

    public static VehicleImage getVehicleImageRandomSampleGenerator() {
        return new VehicleImage()
            .id(longCount.incrementAndGet())
            .imageUrl(UUID.randomUUID().toString())
            .imageType(UUID.randomUUID().toString())
            .description(UUID.randomUUID().toString());
    }
}
