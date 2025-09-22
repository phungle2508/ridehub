package com.ridehub.booking.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class PaymentWebhookLogTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static PaymentWebhookLog getPaymentWebhookLogSample1() {
        return new PaymentWebhookLog()
            .id(1L)
            .provider("provider1")
            .payloadHash("payloadHash1")
            .processingStatus("processingStatus1")
            .deletedBy(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"));
    }

    public static PaymentWebhookLog getPaymentWebhookLogSample2() {
        return new PaymentWebhookLog()
            .id(2L)
            .provider("provider2")
            .payloadHash("payloadHash2")
            .processingStatus("processingStatus2")
            .deletedBy(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"));
    }

    public static PaymentWebhookLog getPaymentWebhookLogRandomSampleGenerator() {
        return new PaymentWebhookLog()
            .id(longCount.incrementAndGet())
            .provider(UUID.randomUUID().toString())
            .payloadHash(UUID.randomUUID().toString())
            .processingStatus(UUID.randomUUID().toString())
            .deletedBy(UUID.randomUUID());
    }
}
