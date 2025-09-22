package com.ridehub.booking.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class AppliedPromotionTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static AppliedPromotion getAppliedPromotionSample1() {
        return new AppliedPromotion()
            .id(1L)
            .promotionId(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"))
            .promotionCode("promotionCode1")
            .policyType("policyType1")
            .percent(1)
            .deletedBy(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"));
    }

    public static AppliedPromotion getAppliedPromotionSample2() {
        return new AppliedPromotion()
            .id(2L)
            .promotionId(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"))
            .promotionCode("promotionCode2")
            .policyType("policyType2")
            .percent(2)
            .deletedBy(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"));
    }

    public static AppliedPromotion getAppliedPromotionRandomSampleGenerator() {
        return new AppliedPromotion()
            .id(longCount.incrementAndGet())
            .promotionId(UUID.randomUUID())
            .promotionCode(UUID.randomUUID().toString())
            .policyType(UUID.randomUUID().toString())
            .percent(intCount.incrementAndGet())
            .deletedBy(UUID.randomUUID());
    }
}
