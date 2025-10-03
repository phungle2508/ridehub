package com.ridehub.promotion.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class ConditionLocationItemTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static ConditionLocationItem getConditionLocationItemSample1() {
        return new ConditionLocationItem()
            .id(1L)
            .provinceId(1L)
            .districtId(1L)
            .wardId(1L)
            .deletedBy(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"));
    }

    public static ConditionLocationItem getConditionLocationItemSample2() {
        return new ConditionLocationItem()
            .id(2L)
            .provinceId(2L)
            .districtId(2L)
            .wardId(2L)
            .deletedBy(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"));
    }

    public static ConditionLocationItem getConditionLocationItemRandomSampleGenerator() {
        return new ConditionLocationItem()
            .id(longCount.incrementAndGet())
            .provinceId(longCount.incrementAndGet())
            .districtId(longCount.incrementAndGet())
            .wardId(longCount.incrementAndGet())
            .deletedBy(UUID.randomUUID());
    }
}
