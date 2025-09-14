package com.ticketsystem.route.domain;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class RouteTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static Route getRouteSample1() {
        return new Route().id(1L).estimatedDuration(1);
    }

    public static Route getRouteSample2() {
        return new Route().id(2L).estimatedDuration(2);
    }

    public static Route getRouteRandomSampleGenerator() {
        return new Route().id(longCount.incrementAndGet()).estimatedDuration(intCount.incrementAndGet());
    }
}
