package com.ridehub.promotion.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class ConditionByDateTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static ConditionByDate getConditionByDateSample1() {
        return new ConditionByDate().id(1L).deletedBy(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"));
    }

    public static ConditionByDate getConditionByDateSample2() {
        return new ConditionByDate().id(2L).deletedBy(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"));
    }

    public static ConditionByDate getConditionByDateRandomSampleGenerator() {
        return new ConditionByDate().id(longCount.incrementAndGet()).deletedBy(UUID.randomUUID());
    }
}
