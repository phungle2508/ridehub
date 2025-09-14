package com.ticketsystem.route.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class WardTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Ward getWardSample1() {
        return new Ward().id(1L).code("code1").name("name1").nameEn("nameEn1").type("type1");
    }

    public static Ward getWardSample2() {
        return new Ward().id(2L).code("code2").name("name2").nameEn("nameEn2").type("type2");
    }

    public static Ward getWardRandomSampleGenerator() {
        return new Ward()
            .id(longCount.incrementAndGet())
            .code(UUID.randomUUID().toString())
            .name(UUID.randomUUID().toString())
            .nameEn(UUID.randomUUID().toString())
            .type(UUID.randomUUID().toString());
    }
}
