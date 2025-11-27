package com.ridehub.common.feign;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

public class RidehubOpenApiClassFactoryBean<T> implements FactoryBean<T> {
    private final Class<T> apiClass;
    private final String serviceId;

    @Autowired
    private LoadBalancerClient lb;

    public RidehubOpenApiClassFactoryBean(Class<T> apiClass, String serviceId) {
        this.apiClass = apiClass;
        this.serviceId = serviceId;
    }

    @Override
    public T getObject() throws Exception {
        var instance = lb.choose(serviceId);
        if (instance == null) throw new IllegalStateException("Service [" + serviceId + "] not found");
        String base = instance.getUri().toString().replaceAll("/+$", "");

        // find the generated ApiClient in same package
        String apiClientClassName = apiClass.getPackageName().replace(".api", "") + ".ApiClient";
        Class<?> apiClientClass = Class.forName(apiClientClassName);
        Object apiClient = apiClientClass.getConstructor().newInstance();
        apiClientClass.getMethod("setBasePath", String.class).invoke(apiClient, base);

        return apiClass.getConstructor(apiClientClass).newInstance(apiClient);
    }

    @Override
    public Class<?> getObjectType() { return apiClass; }

    @Override
    public boolean isSingleton() { return true; }
}
