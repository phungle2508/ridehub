package com.ticketsystem.route.broker;

import org.springframework.stereotype.Component;


@Component
// public class KafkaProducer implements Supplier<String> {
public class KafkaProducer {
    // @Override
    public String get() {
        return "kafka_producer";
    }
}
