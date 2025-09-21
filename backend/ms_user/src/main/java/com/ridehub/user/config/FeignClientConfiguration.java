package com.ridehub.user.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import com.ridehub.msbooking.client.api.BookingResourceMsbookingApi;
import com.ridehub.msbooking.client.api.TicketResourceMsbookingApi; // ⟵ nếu thực sự gọi vào msbooking
import com.ridehub.mspromotion.client.api.PromotionResourceMspromotionApi;
import com.ridehub.msroute.client.api.RouteResourceMsrouteApi;
import com.ridehub.msuser.client.api.AppUserResourceMsuserApi;

import feign.Feign;
import feign.Logger;
import feign.RequestInterceptor;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.lang.reflect.*;

@Configuration
public class FeignClientConfiguration {

    private final LoadBalancerClient loadBalancerClient;

    public FeignClientConfiguration(LoadBalancerClient loadBalancerClient) {
        this.loadBalancerClient = loadBalancerClient;
    }

    // ---- Config qua properties (có giá trị mặc định) ----
    @Value("${services.ms-route:msroute}")
    private String msRouteId;

    @Value("${services.ms-booking:msbooking}")
    private String msBookingId;

    @Value("${services.ms-promotion:mspromotion}")
    private String msPromotionId;

    @Value("${services.ms-user:msuser}")
    private String msUserId;

    // Nếu bạn THỰC SỰ gọi msticket thì thêm cái này, còn không thì bỏ
    @Value("${services.ms-ticket:msticket}")
    private String msTicketId;

    // Nếu service có context-path (hiếm khi), có thể set "/app" ở đây, mặc định là
    // rỗng
    @Value("${services.context-path:}")
    private String contextPath;

    @Bean
    public RequestInterceptor authRequestInterceptor() {
        return req -> {
            var auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth instanceof JwtAuthenticationToken jwt) {
                req.header("Authorization", "Bearer " + jwt.getToken().getTokenValue());
            }
        };
    }

    @Bean
    public ObjectMapper feignObjectMapper() {
        var mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper;
    }

    @Bean
    public Encoder feignEncoder(ObjectMapper om) {
        return new JacksonEncoder(om);
    }

    @Bean
    public Decoder feignDecoder(ObjectMapper om) {
        return new JacksonDecoder(om);
    }

    // ================== LAZY FEIGN BEANS (đã sửa service-id) ==================

    @Bean
    @Lazy
    public RouteResourceMsrouteApi routeResourceMsrouteApi(RequestInterceptor auth, Encoder enc, Decoder dec) {
        return lazyFeignFor(msRouteId, RouteResourceMsrouteApi.class, auth, enc, dec);
    }

    @Bean
    @Lazy
    public BookingResourceMsbookingApi bookingResourceMsbookingApi(RequestInterceptor auth, Encoder enc, Decoder dec) {
        return lazyFeignFor(msBookingId, BookingResourceMsbookingApi.class, auth, enc, dec);
    }

    @Bean
    @Lazy
    public PromotionResourceMspromotionApi promotionResourceMspromotionApi(RequestInterceptor auth, Encoder enc,
            Decoder dec) {
        // FIX: trước đây trỏ nhầm sang "msuser"
        return lazyFeignFor(msPromotionId, PromotionResourceMspromotionApi.class, auth, enc, dec);
    }

    @Bean
    @Lazy
    public AppUserResourceMsuserApi appUserResourceMsuserApi(RequestInterceptor auth, Encoder enc, Decoder dec) {
        return lazyFeignFor(msUserId, AppUserResourceMsuserApi.class, auth, enc, dec);
    }

    // ---- TICKET: chọn 1 trong 2 phương án dưới đây ----
    // A) Nếu TicketResourceMsbookingApi là client gọi chính msbooking (tức API
    // Ticket nằm trong msbooking):
    @Bean
    @Lazy
    public TicketResourceMsbookingApi ticketResourceMsbookingApi(RequestInterceptor auth, Encoder enc, Decoder dec) {
        // FIX: bỏ "ticketResource" (tên controller) → dùng service-id thực
        return lazyFeignFor(msBookingId, TicketResourceMsbookingApi.class, auth, enc, dec);
    }

    // B) Nếu bạn có service riêng msticket và client tương ứng (ví dụ
    // com.ridehub.msticket.client.api.TicketResourceMsticketApi)
    // thì thay import + đổi sang msTicketId:
    // @Bean @Lazy
    // public TicketResourceMsticketApi ticketResourceMsticketApi(RequestInterceptor
    // auth, Encoder enc, Decoder dec) {
    // return lazyFeignFor(msTicketId, TicketResourceMsticketApi.class, auth, enc,
    // dec);
    // }

    // ================== Proxy factory ==================
    @SuppressWarnings("unchecked")
    private <T> T lazyFeignFor(String serviceId, Class<T> clazz, RequestInterceptor auth, Encoder enc, Decoder dec) {
        return (T) Proxy.newProxyInstance(
                clazz.getClassLoader(),
                new Class<?>[] { clazz },
                new LazyFeignHandler<>(serviceId, clazz, auth, enc, dec));
    }

    private class LazyFeignHandler<T> implements InvocationHandler {
        private final String serviceId;
        private final Class<T> clazz;
        private final RequestInterceptor auth;
        private final Encoder encoder;
        private final Decoder decoder;
        private volatile T feignClient;

        LazyFeignHandler(String serviceId, Class<T> clazz, RequestInterceptor auth, Encoder encoder, Decoder decoder) {
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
