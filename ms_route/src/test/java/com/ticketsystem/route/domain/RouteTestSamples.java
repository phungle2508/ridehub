package com.ticketsystem.route.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class RouteTestSamples {

    private static final Random random = new Random();
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static Route getRouteSample1() {
        return new Route()
            .id(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"))
            .routeName("routeName1")
            .origin("origin1")
            .destination("destination1")
            .estimatedDuration(1);
    }

    public static Route getRouteSample2() {
        return new Route()
            .id(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"))
            .routeName("routeName2")
            .origin("origin2")
            .destination("destination2")
            .estimatedDuration(2);
    }

    public static Route getRouteRandomSampleGenerator() {
        return new Route()
            .id(UUID.randomUUID())
            .routeName(UUID.randomUUID().toString())
            .origin(UUID.randomUUID().toString())
            .destination(UUID.randomUUID().toString())
            .estimatedDuration(intCount.incrementAndGet());
    }
}
