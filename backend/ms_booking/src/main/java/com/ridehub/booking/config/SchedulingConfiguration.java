package com.ridehub.booking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

/**
 * Configuration for scheduling and external service communication.
 */
@Configuration
@EnableScheduling
public class SchedulingConfiguration {

    /**
     * RestTemplate bean for making HTTP requests to external services.
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
