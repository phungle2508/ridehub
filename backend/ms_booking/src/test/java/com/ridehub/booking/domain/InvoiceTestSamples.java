package com.ridehub.booking.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class InvoiceTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Invoice getInvoiceSample1() {
        return new Invoice().id(1L).invoiceNo("invoiceNo1").deletedBy(UUID.fromString("23d8dc04-a48b-45d9-a01d-4b728f0ad4aa"));
    }

    public static Invoice getInvoiceSample2() {
        return new Invoice().id(2L).invoiceNo("invoiceNo2").deletedBy(UUID.fromString("ad79f240-3727-46c3-b89f-2cf6ebd74367"));
    }

    public static Invoice getInvoiceRandomSampleGenerator() {
        return new Invoice().id(longCount.incrementAndGet()).invoiceNo(UUID.randomUUID().toString()).deletedBy(UUID.randomUUID());
    }
}
