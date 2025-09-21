package com.ridehub.promotion.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ConditionByDateTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static ConditionByDate getConditionByDateSample1() {
        return new ConditionByDate().id(1L).weekday(1).deletedBy(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"));
    }

    public static ConditionByDate getConditionByDateSample2() {
        return new ConditionByDate().id(2L).weekday(2).deletedBy(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"));
    }

    public static ConditionByDate getConditionByDateRandomSampleGenerator() {
        return new ConditionByDate().id(longCount.incrementAndGet()).weekday(intCount.incrementAndGet()).deletedBy(UUID.randomUUID());
    }
}
