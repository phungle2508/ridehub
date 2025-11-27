package com.ridehub.booking;

import com.ridehub.booking.config.AsyncSyncConfiguration;
import com.ridehub.booking.config.EmbeddedKafka;
import com.ridehub.booking.config.EmbeddedRedis;
import com.ridehub.booking.config.EmbeddedSQL;
import com.ridehub.booking.config.JacksonConfiguration;
import com.ridehub.booking.config.TestSecurityConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { MsBookingApp.class, JacksonConfiguration.class, AsyncSyncConfiguration.class, TestSecurityConfiguration.class })
@EmbeddedRedis
@EmbeddedSQL
@EmbeddedKafka
public @interface IntegrationTest {
}
