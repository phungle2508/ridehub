package com.ridehub.common.feign;

import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.Logger;
import org.springframework.cloud.openfeign.FeignClientBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import feign.RequestInterceptor;

@Component
public class LazyFeignFactory {

    private final ApplicationContext ctx;
    private final Encoder encoder;
    private final Decoder decoder;
    private final RequestInterceptor auth;
    private final Logger.Level level;

    public LazyFeignFactory(
            ApplicationContext ctx,
            Encoder encoder,
            Decoder decoder,
            RequestInterceptor authRequestInterceptor,
            Logger.Level level) {
        this.ctx = ctx;
        this.encoder = encoder;
        this.decoder = decoder;
        this.auth = authRequestInterceptor;
        this.level = level;
    }

    public <T> T create(String serviceId, Class<T> apiType) {
        return new FeignClientBuilder(ctx)
                .forType(apiType, serviceId)
                .customize(builder -> {
                    builder.encoder(encoder);
                    builder.decoder(decoder);
                    builder.requestInterceptor(auth);
                    builder.logLevel(level);
                })
                .build();
    }
}
