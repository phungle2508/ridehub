package com.ridehub.promotion.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class PromotionTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static Promotion getPromotionSample1() {
        return new Promotion()
            .id(1L)
            .code("code1")
            .description("description1")
            .usageLimit(1)
            .usedCount(1)
            .deletedBy(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"));
    }

    public static Promotion getPromotionSample2() {
        return new Promotion()
            .id(2L)
            .code("code2")
            .description("description2")
            .usageLimit(2)
            .usedCount(2)
            .deletedBy(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"));
    }

    public static Promotion getPromotionRandomSampleGenerator() {
        return new Promotion()
            .id(longCount.incrementAndGet())
            .code(UUID.randomUUID().toString())
            .description(UUID.randomUUID().toString())
            .usageLimit(intCount.incrementAndGet())
            .usedCount(intCount.incrementAndGet())
            .deletedBy(UUID.randomUUID());
    }
}
