package com.ridehub.promotion.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class ConditionRouteItemTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static ConditionRouteItem getConditionRouteItemSample1() {
        return new ConditionRouteItem()
            .id(1L)
            .routeId(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"))
            .deletedBy(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"));
    }

    public static ConditionRouteItem getConditionRouteItemSample2() {
        return new ConditionRouteItem()
            .id(2L)
            .routeId(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"))
            .deletedBy(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"));
    }

    public static ConditionRouteItem getConditionRouteItemRandomSampleGenerator() {
        return new ConditionRouteItem().id(longCount.incrementAndGet()).routeId(UUID.randomUUID()).deletedBy(UUID.randomUUID());
    }
}
