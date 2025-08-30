package com.ticketsystem.booking;

import com.ticketsystem.booking.config.AsyncSyncConfiguration;
import com.ticketsystem.booking.config.EmbeddedRedis;
import com.ticketsystem.booking.config.EmbeddedSQL;
import com.ticketsystem.booking.config.JacksonConfiguration;
import com.ticketsystem.booking.config.TestSecurityConfiguration;
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
public @interface IntegrationTest {
}
