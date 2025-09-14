package com.ticketsystem.route.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class OperatorTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Operator getOperatorSample1() {
        return new Operator()
            .id(1L)
            .name("name1")
            .businessLicense("businessLicense1")
            .logoUrl("logoUrl1")
            .contactPhone("contactPhone1")
            .contactEmail("contactEmail1");
    }

    public static Operator getOperatorSample2() {
        return new Operator()
            .id(2L)
            .name("name2")
            .businessLicense("businessLicense2")
            .logoUrl("logoUrl2")
            .contactPhone("contactPhone2")
            .contactEmail("contactEmail2");
    }

    public static Operator getOperatorRandomSampleGenerator() {
        return new Operator()
            .id(longCount.incrementAndGet())
            .name(UUID.randomUUID().toString())
            .businessLicense(UUID.randomUUID().toString())
            .logoUrl(UUID.randomUUID().toString())
            .contactPhone(UUID.randomUUID().toString())
            .contactEmail(UUID.randomUUID().toString());
    }
}
