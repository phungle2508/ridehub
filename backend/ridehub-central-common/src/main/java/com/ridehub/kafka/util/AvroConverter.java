package com.ridehub.kafka.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ridehub.avro.common.EventEnvelope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Generic Avro converter utility for creating and converting EventEnvelope messages
 * @param <T> The payload type
 */
public class AvroConverter {

    private static final Logger LOG = LoggerFactory.getLogger(AvroConverter.class);
    private static final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule());

    // Private constructor to prevent instantiation of utility class
    private AvroConverter() {
    }

    /**
     * Creates a generic Avro EventEnvelope for any event type.
     * 
     * @param eventName The name of the event
     * @param payload   The payload object to serialize
     * @param <T>       The type of the payload
     * @return The created Avro EventEnvelope
     */
    public static <T> EventEnvelope createEvent(String eventName, T payload) {
        LOG.debug("Creating Avro EventEnvelope for eventName: {}, payload type: {}", 
                eventName, payload != null ? payload.getClass().getSimpleName() : "null");
        
        try {
            String payloadJson = null;
            String payloadType = null;
            
            if (payload != null) {
                payloadJson = objectMapper.writeValueAsString(payload);
                payloadType = payload.getClass().getName();
            }

            EventEnvelope envelope = EventEnvelope.newBuilder()
                    .setEventName(eventName)
                    .setPayload(payloadJson)
                    .setPayloadType(payloadType)
                    .build();

            LOG.debug("Successfully created Avro EventEnvelope: {}", envelope);
            return envelope;
            
        } catch (Exception e) {
            LOG.error("Error creating Avro EventEnvelope for eventName: {}", eventName, e);
            throw new RuntimeException("Failed to create Avro EventEnvelope", e);
        }
    }

    /**
     * Converts an Avro EventEnvelope payload to the specified type.
     *
     * @param envelope The Avro EventEnvelope
     * @param targetClass The target class to deserialize to
     * @param <T> The target type
     * @return The converted payload, or null if envelope or payload is null
     */
    public static <T> T convertPayload(EventEnvelope envelope, Class<T> targetClass) {
        if (envelope == null || envelope.getPayload() == null) {
            LOG.warn("Attempted to convert a null EventEnvelope or payload to type: {}", 
                    targetClass.getSimpleName());
            return null;
        }
        
        LOG.debug("Converting EventEnvelope payload to type: {}", targetClass.getSimpleName());
        
        try {
            T result = objectMapper.readValue(envelope.getPayload().toString(), targetClass);
            LOG.debug("Successfully converted payload to type: {}", targetClass.getSimpleName());
            return result;
            
        } catch (Exception e) {
            LOG.error("Error converting EventEnvelope payload to type: {}", targetClass.getSimpleName(), e);
            throw new RuntimeException("Failed to convert EventEnvelope payload", e);
        }
    }

    /**
     * Converts an Avro EventEnvelope payload using the stored payload type.
     *
     * @param envelope The Avro EventEnvelope
     * @param <T> The target type
     * @return The converted payload, or null if envelope or payload is null
     */
    @SuppressWarnings("unchecked")
    public static <T> T convertPayload(EventEnvelope envelope) {
        if (envelope == null || envelope.getPayload() == null || envelope.getPayloadType() == null) {
            LOG.warn("Attempted to convert an EventEnvelope with missing payload or payloadType");
            return null;
        }
        
        try {
            Class<?> payloadClass = Class.forName(envelope.getPayloadType().toString());
            LOG.debug("Converting EventEnvelope payload to stored type: {}", payloadClass.getSimpleName());
            
            Object result = objectMapper.readValue(envelope.getPayload().toString(), payloadClass);
            LOG.debug("Successfully converted payload to stored type: {}", payloadClass.getSimpleName());
            return (T) result;
            
        } catch (Exception e) {
            LOG.error("Error converting EventEnvelope payload using stored type: {}", 
                    envelope.getPayloadType(), e);
            throw new RuntimeException("Failed to convert EventEnvelope payload using stored type", e);
        }
    }
}