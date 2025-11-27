package com.ridehub.common.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.consul.ConditionalOnConsulEnabled;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Configuration class to properly handle Consul configuration in development environment.
 * This class imports the ConsulSSHTunnel configuration and ensures proper property ordering.
 */
@Configuration
@ConditionalOnConsulEnabled
@ConditionalOnProperty(value = "tunnel.enabled", havingValue = "true", matchIfMissing = true)
@Import({ConsulSSHTunnel.class, ConsulSSHTunnelProperties.class})
public class ConsulBootstrapConfiguration {
}