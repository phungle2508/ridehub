package com.ticketsystem.route.broker;

import java.util.function.Supplier;
import org.springframework.stereotype.Component;
import com.ticketsystem.avro.booking.Booking;
@Component
// public class KafkaProducer implements Supplier<String> {
public class KafkaProducer  {

    // @Override
    public String get() {
        return "kafka_producer";
    }
}
