package com.ridehub.common.feign;

import java.util.Objects;
import java.util.regex.Pattern;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.RegexPatternTypeFilter;

public class RidehubFeignRegistrar
        implements ImportBeanDefinitionRegistrar, ResourceLoaderAware, EnvironmentAware {

    private ResourceLoader resourceLoader;
    private Environment environment;

    @Override
    public void setResourceLoader(ResourceLoader rl) {
        this.resourceLoader = rl;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata meta, BeanDefinitionRegistry registry) {
        RidehubFeignScanProperties props = Binder.get(environment)
                .bind("ridehub.feign", Bindable.of(RidehubFeignScanProperties.class))
                .orElseGet(RidehubFeignScanProperties::new);

        if (props.getScans() == null)
            return;

        // Only consider classes ending with "...Api"
        Pattern apiPattern = Pattern.compile(".*Api$");

        for (var spec : props.getScans()) {
            String basePackage = Objects.requireNonNull(spec.getBasePackage(), "basePackage");
            String serviceId = Objects.requireNonNull(spec.getServiceId(), "serviceId");

            ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false,
                    environment);
            scanner.setResourceLoader(resourceLoader);
            scanner.addIncludeFilter(new RegexPatternTypeFilter(apiPattern));

            scanner.findCandidateComponents(basePackage).forEach(bd -> {
                try {
                    Class<?> apiClass = Class.forName(bd.getBeanClassName());
                    String beanName = apiClass.getName(); // FQCN avoids collisions

                    // Register only once
                    if (registry.containsBeanDefinition(beanName))
                        return;

                    BeanDefinitionBuilder bdb;
                    if (apiClass.isInterface()) {
                        // Interface => build via programmatic OpenFeign
                        bdb = BeanDefinitionBuilder
                                .genericBeanDefinition(RidehubFeignFactoryBean.class)
                                .addConstructorArgValue(apiClass)
                                .addConstructorArgValue(serviceId);
                    } else {
                        // Concrete class (OpenAPI generated `*Api`) => instantiate with ApiClient
                        bdb = BeanDefinitionBuilder
                                .genericBeanDefinition(RidehubOpenApiClassFactoryBean.class)
                                .addConstructorArgValue(apiClass)
                                .addConstructorArgValue(serviceId);
                    }
                    registry.registerBeanDefinition(beanName, bdb.getBeanDefinition());
                } catch (ClassNotFoundException ignored) {
                    /* ignore */ }
            });
        }
    }
}
