package com.ticketsystem.ticket;

import com.ticketsystem.ticket.config.AsyncSyncConfiguration;
import com.ticketsystem.ticket.config.EmbeddedRedis;
import com.ticketsystem.ticket.config.EmbeddedSQL;
import com.ticketsystem.ticket.config.JacksonConfiguration;
import com.ticketsystem.ticket.config.TestSecurityConfiguration;
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
@SpringBootTest(classes = { MsTicketApp.class, JacksonConfiguration.class, AsyncSyncConfiguration.class, TestSecurityConfiguration.class })
@EmbeddedRedis
@EmbeddedSQL
public @interface IntegrationTest {
}
