package com.ridehub.promotion;

import com.ridehub.promotion.config.AsyncSyncConfiguration;
import com.ridehub.promotion.config.EmbeddedKafka;
import com.ridehub.promotion.config.EmbeddedRedis;
import com.ridehub.promotion.config.EmbeddedSQL;
import com.ridehub.promotion.config.JacksonConfiguration;
import com.ridehub.promotion.config.TestSecurityConfiguration;
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
@SpringBootTest(
    classes = { MsPromotionApp.class, JacksonConfiguration.class, AsyncSyncConfiguration.class, TestSecurityConfiguration.class }
)
@EmbeddedRedis
@EmbeddedSQL
@EmbeddedKafka
public @interface IntegrationTest {
}
