package com.ridehub.booking.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class PaymentTransactionTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static PaymentTransaction getPaymentTransactionSample1() {
        return new PaymentTransaction()
            .id(1L)
            .transactionId("transactionId1")
            .orderRef("orderRef1")
            .gatewayNote("gatewayNote1")
            .deletedBy(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"));
    }

    public static PaymentTransaction getPaymentTransactionSample2() {
        return new PaymentTransaction()
            .id(2L)
            .transactionId("transactionId2")
            .orderRef("orderRef2")
            .gatewayNote("gatewayNote2")
            .deletedBy(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"));
    }

    public static PaymentTransaction getPaymentTransactionRandomSampleGenerator() {
        return new PaymentTransaction()
            .id(longCount.incrementAndGet())
            .transactionId(UUID.randomUUID().toString())
            .orderRef(UUID.randomUUID().toString())
            .gatewayNote(UUID.randomUUID().toString())
            .deletedBy(UUID.randomUUID());
    }
}
