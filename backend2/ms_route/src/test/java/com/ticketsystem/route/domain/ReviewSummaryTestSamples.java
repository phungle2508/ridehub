package com.ticketsystem.route.domain;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ReviewSummaryTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static ReviewSummary getReviewSummarySample1() {
        return new ReviewSummary().id(1L).totalReviews(1);
    }

    public static ReviewSummary getReviewSummarySample2() {
        return new ReviewSummary().id(2L).totalReviews(2);
    }

    public static ReviewSummary getReviewSummaryRandomSampleGenerator() {
        return new ReviewSummary().id(longCount.incrementAndGet()).totalReviews(intCount.incrementAndGet());
    }
}
