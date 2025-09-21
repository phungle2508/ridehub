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
            .provinceId(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"))
            .districtId(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"))
            .wardId(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"))
            .deletedBy(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"));
    }

    public static ConditionLocationItem getConditionLocationItemSample2() {
        return new ConditionLocationItem()
            .id(2L)
            .provinceId(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"))
            .districtId(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"))
            .wardId(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"))
            .deletedBy(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"));
    }

    public static ConditionLocationItem getConditionLocationItemRandomSampleGenerator() {
        return new ConditionLocationItem()
            .id(longCount.incrementAndGet())
            .provinceId(UUID.randomUUID())
            .districtId(UUID.randomUUID())
            .wardId(UUID.randomUUID())
            .deletedBy(UUID.randomUUID());
    }
}
