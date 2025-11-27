package com.ridehub.booking.service.mapper;

import static com.ridehub.booking.domain.PaymentWebhookLogAsserts.*;
import static com.ridehub.booking.domain.PaymentWebhookLogTestSamples.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaymentWebhookLogMapperTest {

    private PaymentWebhookLogMapper paymentWebhookLogMapper;

    @BeforeEach
    void setUp() {
        paymentWebhookLogMapper = new PaymentWebhookLogMapperImpl();
    }

    @Test
    void shouldConvertToDtoAndBack() {
        var expected = getPaymentWebhookLogSample1();
        var actual = paymentWebhookLogMapper.toEntity(paymentWebhookLogMapper.toDto(expected));
        assertPaymentWebhookLogAllPropertiesEquals(expected, actual);
    }
}
