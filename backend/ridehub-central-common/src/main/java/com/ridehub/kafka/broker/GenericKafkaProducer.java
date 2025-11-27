package com.ridehub.kafka.broker;

import com.ridehub.avro.common.EventEnvelope;
import com.ridehub.kafka.service.KafkaUtilityService;

import jakarta.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

/**
 * Generic Kafka producer that supplies EventEnvelope messages via Supplier
 * binding.
 * No StreamBridge usage — messages are queued and emitted by get().
 */
@Component
public class GenericKafkaProducer implements Supplier<Message<EventEnvelope>> {

    private final KafkaUtilityService kafkaUtilityService;
    private final AtomicReference<EventEnvelope> messageToSupply = new AtomicReference<>();
    private final AtomicReference<String> keyToSupply = new AtomicReference<>();
    private static final Logger log = LoggerFactory.getLogger(GenericKafkaProducer.class);

    @Value("${spring.application.name:default-service}")
    private String serviceName;

    public GenericKafkaProducer(KafkaUtilityService kafkaUtilityService) {
        this.kafkaUtilityService = kafkaUtilityService;
    }

    @PostConstruct
    public void validateConfiguration() {
        log.info("GenericKafkaProducer initialized for service: {}", serviceName);
    }

    @Override
    public Message<EventEnvelope> get() {
        EventEnvelope event = messageToSupply.getAndSet(null);
        String key = keyToSupply.getAndSet(null);

        if (event != null) {
            log.info("Supplying event with unique key: {} to reactive stream", key);
            return MessageBuilder.withPayload(event)
                    .setHeader(KafkaHeaders.KEY, key)
                    .setHeader("serviceName", serviceName)
                    .build();
        } else {
            log.trace("No event to supply, returning null.");
            return null;
        }
    }

    /**
     * Queue event for reactive stream processing.
     */
    protected <T> String queueEvent(String eventName, T payload, String key) {
        try {
            EventEnvelope envelope = kafkaUtilityService.createEventEnvelope(eventName, payload);
            String uniqueKey = kafkaUtilityService.prepareAndCreateEvent(eventName, payload, key);

            if (envelope == null || uniqueKey == null) {
                log.error("Failed to create envelope or key for event: {}", eventName);
                return null;
            }

            messageToSupply.set(envelope);
            keyToSupply.set(uniqueKey);

            log.info("Event {} queued successfully with key: {}", eventName, uniqueKey);
            return uniqueKey;

        } catch (Exception e) {
            log.error("Error queuing event {}: {}", eventName, e.getMessage(), e);
            return null;
        }
    }

    /**
     * Public send that just queues to the Supplier; no direct broker send.
     */
    public <T> String send(String eventName, T payload, String key) {
        return queueEvent(eventName, payload, key);
    }

    public <T> String send(String eventName, T payload) {
        return send(eventName, payload, null);
    }

    public <T> Optional<String> sendSafely(String eventName, T payload, String key) {
        try {
            return Optional.ofNullable(send(eventName, payload, key));
        } catch (Exception e) {
            log.error("Safe send failed for event {}: {}", eventName, e.getMessage());
            return Optional.empty();
        }
    }

    // Protected helpers for subclasses
    protected KafkaUtilityService getKafkaUtilityService() {
        return kafkaUtilityService;
    }

    protected String getServiceName() {
        return serviceName;
    }
}
