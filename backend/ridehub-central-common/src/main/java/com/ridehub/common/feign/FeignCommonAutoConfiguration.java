package com.ridehub.common.feign;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import feign.Feign;
import feign.Logger;
import feign.RequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * Auto-configuration for Ridehub Feign clients.
 * This configuration is automatically loaded when the central common package is
 * on the classpath.
 * It automatically scans for Feign client interfaces and registers them as
 * beans.
 */
@AutoConfiguration
@ConditionalOnClass({ Feign.class, LoadBalancerClient.class })
@EnableConfigurationProperties({ RidehubFeignScanProperties.class, ServiceAuthProperties.class })
@Import(FeignCommonAutoConfiguration.FeignClientRegistrar.class)
public class FeignCommonAutoConfiguration {

    // Nếu service có context-path (hiếm khi), có thể set "/app" ở đây, mặc định là
    // rỗng
    @Value("${services.context-path:}")
    private String contextPath;

    @Bean
    @ConditionalOnMissingBean(name = "feignObjectMapper")
    public ObjectMapper feignObjectMapper() {
        var mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }

    @Bean
    @ConditionalOnMissingBean(name = "feignEncoder")
    public Encoder feignEncoder(@Qualifier("feignObjectMapper") ObjectMapper om) {
        return new JacksonEncoder(om);
    }

    @Bean
    @ConditionalOnMissingBean(name = "feignDecoder")
    public Decoder feignDecoder(@Qualifier("feignObjectMapper") ObjectMapper om) {
        return new JacksonDecoder(om);
    }

    @Bean
    @ConditionalOnMissingBean(name = "authRequestInterceptor")
    public RequestInterceptor authRequestInterceptor(ServiceAuthProperties props) {
        final ServiceTokenManager s2s = new ServiceTokenManager(
                props.getTokenUrl(), props.getClientId(), props.getClientSecret(), props.getScope());

        return req -> {
            // 1) If there's a user JWT in SecurityContext, forward it (current behavior)
            try {
                Class<?> sch = Class.forName("org.springframework.security.core.context.SecurityContextHolder");
                Object context = sch.getMethod("getContext").invoke(null);
                if (context != null) {
                    Object auth = context.getClass().getMethod("getAuthentication").invoke(context);
                    if (auth != null) {
                        Class<?> jwtAuthClass = Class.forName(
                                "org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken");
                        if (jwtAuthClass.isInstance(auth)) {
                            Object token = auth.getClass().getMethod("getToken").invoke(auth);
                            if (token != null) {
                                String tokenValue = (String) token.getClass().getMethod("getTokenValue").invoke(token);
                                if (tokenValue != null && !tokenValue.isBlank()) {
                                    req.header("Authorization", "Bearer " + tokenValue);
                                    return; // done
                                }
                            }
                        }
                    }
                }
            } catch (ClassNotFoundException ignore) {
                // security not on classpath
            } catch (Throwable ignore) {
                /* best-effort */ }

            // 2) No user token -> use service-to-service client_credentials token
            try {
                String token = s2s.getAccessToken();
                req.header("Authorization", "Bearer " + token);
            } catch (Throwable e) {
                // don’t block the app from starting; request will 401 if truly required
            }
        };
    }

    @Bean
    @ConditionalOnMissingBean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    // ================== AUTOMATIC FEIGN CLIENT REGISTRATION ==================

    /**
     * Registrar that automatically scans for Feign client interfaces and registers
     * them as beans.
     */
    public static class FeignClientRegistrar implements ImportBeanDefinitionRegistrar {

        @Override
        public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata,
                BeanDefinitionRegistry registry) {
            // Get the properties to determine what packages to scan
            RidehubFeignScanProperties properties = new RidehubFeignScanProperties();

            // Default scan configurations if none provided
            if (properties.getScans().isEmpty()) {
                addDefaultScanConfigurations(properties);
            }

            PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

            for (RidehubFeignScanProperties.ScanSpec scanSpec : properties.getScans()) {
                try {
                    String packagePath = scanSpec.getBasePackage().replace('.', '/');
                    String pattern = "classpath*:" + packagePath + "/**/*.class";
                    Resource[] resources = resolver.getResources(pattern);

                    for (Resource resource : resources) {
                        try {
                            String className = getClassNameFromResource(resource, packagePath);
                            if (className != null) {
                                Class<?> clazz = Class.forName(className);
                                if (clazz.isInterface() && isFeignClient(clazz)) {
                                    registerFeignClientBean(registry, clazz, scanSpec.getServiceId());
                                }
                            }
                        } catch (Exception e) {
                            // Skip classes that can't be loaded
                        }
                    }
                } catch (IOException e) {
                    // Skip packages that can't be scanned
                }
            }
        }

        private void addDefaultScanConfigurations(RidehubFeignScanProperties properties) {
            // Add default scan configurations for known packages
            addScanSpec(properties, "com.ridehub.msroute.client.api", "msroute");
            addScanSpec(properties, "com.ridehub.msbooking.client.api", "msbooking");
            addScanSpec(properties, "com.ridehub.mspromotion.client.api", "mspromotion");
            addScanSpec(properties, "com.ridehub.msuser.client.api", "msuser");
        }

        private void addScanSpec(RidehubFeignScanProperties properties, String basePackage, String serviceId) {
            RidehubFeignScanProperties.ScanSpec spec = new RidehubFeignScanProperties.ScanSpec();
            spec.setBasePackage(basePackage);
            spec.setServiceId(serviceId);
            properties.getScans().add(spec);
        }

        private String getClassNameFromResource(Resource resource, String packagePath) {
            try {
                String resourcePath = resource.getURI().toString();
                int packageIndex = resourcePath.indexOf(packagePath);
                if (packageIndex == -1)
                    return null;

                String classPath = resourcePath.substring(packageIndex);
                if (classPath.endsWith(".class")) {
                    return classPath.substring(0, classPath.length() - 6).replace('/', '.');
                }
                return null;
            } catch (Exception e) {
                return null;
            }
        }

        private boolean isFeignClient(Class<?> clazz) {
            // Check if it's likely a Feign client interface
            // You can add more sophisticated checks here
            return clazz.isInterface() &&
                    clazz.getSimpleName().contains("Api") &&
                    clazz.getMethods().length > 0;
        }

        private void registerFeignClientBean(BeanDefinitionRegistry registry, Class<?> clientInterface,
                String serviceId) {
            String beanName = getBeanName(clientInterface);

            if (!registry.containsBeanDefinition(beanName)) {
                BeanDefinition beanDefinition = BeanDefinitionBuilder
                        .genericBeanDefinition(FeignClientFactoryBean.class)
                        .addConstructorArgValue(clientInterface)
                        .addConstructorArgValue(serviceId)
                        .setLazyInit(true)
                        .getBeanDefinition();

                registry.registerBeanDefinition(beanName, beanDefinition);
            }
        }

        private String getBeanName(Class<?> clientInterface) {
            String simpleName = clientInterface.getSimpleName();
            return Character.toLowerCase(simpleName.charAt(0)) + simpleName.substring(1);
        }
    }

}
