package com.ridehub.booking.web.rest;

import com.ridehub.booking.broker.KafkaProducer;
import com.ridehub.booking.service.dto.BookingDTO;
import com.ridehub.kafka.service.KafkaUtilityService;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.common.KafkaException;
import org.apache.kafka.common.errors.RetriableException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ms-booking-kafka")
public class MsBookingKafkaResource {

    private static final Logger LOG = LoggerFactory.getLogger(MsBookingKafkaResource.class);

    private final KafkaProducer kafkaProducer; // now only has get() + send()
    private final KafkaUtilityService kafkaUtilityService;

    public MsBookingKafkaResource(
            KafkaProducer kafkaProducer,
            KafkaUtilityService kafkaUtilityService) {
        this.kafkaProducer = kafkaProducer;
        this.kafkaUtilityService = kafkaUtilityService;
    }

    /**
     * Test endpoint to send a simple message
     */
    @PostMapping("/publish/simple")
    public ResponseEntity<Map<String, String>> publishSimple(@RequestParam("message") String message) {
        LOG.debug("REST request to send simple message: {} to Kafka via Supplier", message);

        try {
            String messageKey = kafkaProducer.send("booking.test", message);
            if (messageKey == null) {
                throw new IllegalStateException("Failed to queue event (null key returned)");
            }

            Map<String, String> response = new HashMap<>();
            response.put("message", "Message queued successfully");
            response.put("messageKey", messageKey);
            response.put("payload", message);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOG.error("Error queueing simple message: {}", e.getMessage(), e);
            Map<String, String> error = new HashMap<>();
            error.put("error", "Failed to queue message: " + e.getMessage());
            return ResponseEntity.internalServerError().body(error);
        }
    }

    /**
     * Send a booking creation event
     */
    @PostMapping("/publish/booking-created")
    public ResponseEntity<Map<String, String>> publishBookingCreated(@RequestBody BookingDTO bookingDTO) {
        LOG.debug("REST request to queue booking created event for: {}", bookingDTO);

        try {
            String messageKey = kafkaProducer.send("booking.created", bookingDTO);
            if (messageKey == null) {
                throw new IllegalStateException("Failed to queue event (null key returned)");
            }

            Map<String, String> response = new HashMap<>();
            response.put("message", "Booking created event queued successfully");
            response.put("messageKey", messageKey);
            response.put("bookingId", String.valueOf(bookingDTO.getId()));

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOG.error("Error queueing booking created event: {}", e.getMessage(), e);
            Map<String, String> error = new HashMap<>();
            error.put("error", "Failed to queue booking created event: " + e.getMessage());
            return ResponseEntity.internalServerError().body(error);
        }
    }

    /**
     * Send a booking updated event
     */
    @PostMapping("/publish/booking-updated")
    public ResponseEntity<Map<String, String>> publishBookingUpdated(@RequestBody BookingDTO bookingDTO) {
        LOG.debug("REST request to queue booking updated event for: {}", bookingDTO);
        try {
            String messageKey = kafkaProducer.send("booking.updated", bookingDTO);
            if (messageKey == null) {
                throw new IllegalStateException("Failed to queue event (null key returned)");
            }

            Map<String, String> response = new HashMap<>();
            response.put("message", "Booking updated event queued successfully");
            response.put("messageKey", messageKey);
            response.put("bookingId", String.valueOf(bookingDTO.getId()));

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOG.error("Error queueing booking updated event: {}", e.getMessage(), e);
            Map<String, String> error = new HashMap<>();
            error.put("error", "Failed to queue booking updated event: " + e.getMessage());
            return ResponseEntity.internalServerError().body(error);
        }

    }

    /**
     * Send a booking deleted event
     */
    @DeleteMapping("/publish/booking-deleted/{id}")
    public ResponseEntity<Map<String, String>> publishBookingDeleted(@PathVariable Long id) {
        LOG.debug("REST request to queue booking deleted event for ID: {}", id);

        try {
            String messageKey = kafkaProducer.send("booking.deleted", id);
            if (messageKey == null) {
                throw new IllegalStateException("Failed to queue event (null key returned)");
            }

            Map<String, String> response = new HashMap<>();
            response.put("message", "Booking deleted event queued successfully");
            response.put("messageKey", messageKey);
            response.put("bookingId", String.valueOf(id));

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOG.error("Error queueing booking deleted event: {}", e.getMessage(), e);
            Map<String, String> error = new HashMap<>();
            error.put("error", "Failed to queue booking deleted event: " + e.getMessage());
            return ResponseEntity.internalServerError().body(error);
        }
    }

    /**
     * Get Kafka utility service status
     */
    @GetMapping("/status")
    public ResponseEntity<Map<String, Object>> getStatus() {
        Map<String, Object> status = new HashMap<>();
        status.put("service", "ms_booking");
        status.put("kafkaUtilityEnabled", true);
        status.put("sseClientsCount", kafkaUtilityService.getEmitters().size());
        status.put("timestamp", System.currentTimeMillis());
        return ResponseEntity.ok(status);
    }
}
