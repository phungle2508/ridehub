package com.ticketsystem.route;

import com.ticketsystem.route.config.AsyncSyncConfiguration;
import com.ticketsystem.route.config.EmbeddedElasticsearch;
import com.ticketsystem.route.config.EmbeddedRedis;
import com.ticketsystem.route.config.EmbeddedSQL;
import com.ticketsystem.route.config.JacksonConfiguration;
import com.ticketsystem.route.config.TestSecurityConfiguration;
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
@SpringBootTest(classes = { MsRouteApp.class, JacksonConfiguration.class, AsyncSyncConfiguration.class, TestSecurityConfiguration.class })
@EmbeddedRedis
@EmbeddedElasticsearch
@EmbeddedSQL
public @interface IntegrationTest {
}
