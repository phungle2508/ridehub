package com.ticketsystem.route.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class StationTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Station getStationSample1() {
        return new Station()
            .id(1L)
            .code("code1")
            .name("name1")
            .nameEn("nameEn1")
            .addressId(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"))
            .facilities("facilities1")
            .operatingHours("operatingHours1");
    }

    public static Station getStationSample2() {
        return new Station()
            .id(2L)
            .code("code2")
            .name("name2")
            .nameEn("nameEn2")
            .addressId(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"))
            .facilities("facilities2")
            .operatingHours("operatingHours2");
    }

    public static Station getStationRandomSampleGenerator() {
        return new Station()
            .id(longCount.incrementAndGet())
            .code(UUID.randomUUID().toString())
            .name(UUID.randomUUID().toString())
            .nameEn(UUID.randomUUID().toString())
            .addressId(UUID.randomUUID())
            .facilities(UUID.randomUUID().toString())
            .operatingHours(UUID.randomUUID().toString());
    }
}
