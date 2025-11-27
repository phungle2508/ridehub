package com.ridehub.kafka.broker;

import com.ridehub.avro.common.EventEnvelope;
import com.ridehub.kafka.service.KafkaUtilityService;
import java.util.function.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;

public abstract class GenericKafkaConsumer implements Consumer<Message<EventEnvelope>> {
    private static final Logger LOG = LoggerFactory.getLogger(GenericKafkaConsumer.class);
    protected final KafkaUtilityService kafkaUtilityService;

    protected GenericKafkaConsumer(KafkaUtilityService kafkaUtilityService) {
        this.kafkaUtilityService = kafkaUtilityService;
    }

    public final void accept(Message<EventEnvelope> message) {
        try {
            if (message == null || message.getPayload() == null) {
                LOG.error("Received null message or payload");
                throw new IllegalArgumentException("Received null message or payload");
            }

            EventEnvelope envelope = message.getPayload();
            Object keyObject = message.getHeaders().get("kafka_receivedMessageKey");
            String key = keyObject != null ? keyObject.toString() : null;

            LOG.debug("Received event [{}] with key [{}]", envelope.getEventName(), key);

            // Process synchronously - any exception will trigger Spring Cloud Stream DLQ
            // handling
            this.kafkaUtilityService.processMessage(envelope);

            LOG.debug("Processing completed successfully for event: {}", envelope.getEventName());

        } catch (Exception e) {
            LOG.error("Error handling message: {}", e.getMessage(), e);
            // Re-throw to trigger Spring Cloud Stream DLQ handling
            // Spring will retry based on configuration, then send to DLQ after max attempts
            throw e;
        }
    }
}