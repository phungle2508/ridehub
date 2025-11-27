package com.ridehub.common.feign;

import feign.Feign;
import feign.Logger;
import feign.RequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Factory bean for creating Feign client instances dynamically.
 */
public class FeignClientFactoryBean<T> implements FactoryBean<T> {

    private final Class<T> clientInterface;
    private final String serviceId;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RequestInterceptor authRequestInterceptor;

    @Autowired
    private Encoder feignEncoder;

    @Autowired
    private Decoder feignDecoder;

    @Value("${services.context-path:}")
    private String contextPath;

    public FeignClientFactoryBean(Class<T> clientInterface, String serviceId) {
        this.clientInterface = clientInterface;
        this.serviceId = serviceId;
    }

    @Override
    public T getObject() throws Exception {
        return createLazyProxy();
    }

    @Override
    public Class<?> getObjectType() {
        return clientInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @SuppressWarnings("unchecked")
    private T createLazyProxy() {
        return (T) Proxy.newProxyInstance(
                clientInterface.getClassLoader(),
                new Class<?>[]{clientInterface},
                new LazyFeignHandler<>(serviceId, clientInterface, authRequestInterceptor, feignEncoder, feignDecoder));
    }

    private class LazyFeignHandler<U> implements InvocationHandler {
        private final String serviceId;
        private final Class<U> clazz;
        private final RequestInterceptor auth;
        private final Encoder encoder;
        private final Decoder decoder;
        private volatile U feignClient;

        LazyFeignHandler(String serviceId, Class<U> clazz, RequestInterceptor auth, Encoder encoder, Decoder decoder) {
            this.serviceId = serviceId;
            this.clazz = clazz;
            this.auth = auth;
            this.encoder = encoder;
            this.decoder = decoder;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            switch (method.getName()) {
                case "hashCode":
                    return System.identityHashCode(proxy);
                case "toString":
                    return "LazyFeignProxy(" + clazz.getSimpleName() + "->" + serviceId + ")";
                case "equals":
                    return proxy == args[0];
            }
            if (feignClient == null) {
                synchronized (this) {
                    if (feignClient == null) {
                        var instance = loadBalancerClient.choose(serviceId);
                        if (instance == null) {
                            throw new IllegalStateException("Service [" + serviceId + "] not found via discovery");
                        }
                        String baseUrl = instance.getUri().toString();
                        if (contextPath != null && !contextPath.isBlank()) {
                            // đảm bảo chỉ có duy nhất 1 dấu '/'
                            baseUrl = baseUrl.replaceAll("/+$", "")
                                    + (contextPath.startsWith("/") ? contextPath : "/" + contextPath);
                        }
                        feignClient = Feign.builder()
                                .encoder(encoder)
                                .decoder(decoder)
                                .requestInterceptor(auth)
                                .logger(new Slf4jLogger(clazz))
                                .logLevel(Logger.Level.FULL)
                                .target(clazz, baseUrl);
                    }
                }
            }
            return method.invoke(feignClient, args);
        }
    }
}
