package com.ticketsystem.route.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class AddressTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Address getAddressSample1() {
        return new Address().id(1L).wardCode("wardCode1").streetAddress("streetAddress1").postalCode("postalCode1").landmark("landmark1");
    }

    public static Address getAddressSample2() {
        return new Address().id(2L).wardCode("wardCode2").streetAddress("streetAddress2").postalCode("postalCode2").landmark("landmark2");
    }

    public static Address getAddressRandomSampleGenerator() {
        return new Address()
            .id(longCount.incrementAndGet())
            .wardCode(UUID.randomUUID().toString())
            .streetAddress(UUID.randomUUID().toString())
            .postalCode(UUID.randomUUID().toString())
            .landmark(UUID.randomUUID().toString());
    }
}
