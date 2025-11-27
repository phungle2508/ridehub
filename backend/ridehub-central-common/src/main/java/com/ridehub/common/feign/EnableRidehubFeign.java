package com.ridehub.common.feign;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Enable auto-registration of Ridehub Feign clients.
 * This annotation will automatically scan and register Feign client beans
 * based on configuration properties, eliminating the need for manual
 * Feign client configuration.
 * 
 * Usage:
 * <pre>
 * &#64;SpringBootApplication
 * &#64;EnableRidehubFeign
 * public class Application {
 *     public static void main(String[] args) {
 *         SpringApplication.run(Application.class, args);
 *     }
 * }
 * </pre>
 */
// in starter: com.ridehub.common.feign.EnableRidehubFeign.java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(RidehubFeignRegistrar.class)
public @interface EnableRidehubFeign { }