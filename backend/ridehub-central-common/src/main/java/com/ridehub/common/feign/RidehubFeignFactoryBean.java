package com.ridehub.common.feign;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

// in starter: com.ridehub.common.feign.RidehubFeignFactoryBean
public class RidehubFeignFactoryBean<T> implements FactoryBean<T> {
    private final Class<T> apiType;
    private final String serviceId;

    @Autowired
    private LazyFeignFactory factory;

    public RidehubFeignFactoryBean(Class<T> apiType, String serviceId) {
        this.apiType = apiType;
        this.serviceId = serviceId;
    }

    @Override
    public T getObject() {
        return factory.create(serviceId, apiType);
    }

    @Override
    public Class<?> getObjectType() {
        return apiType;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
