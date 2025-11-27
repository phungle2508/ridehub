package com.ridehub.promotion.web.rest;

import com.ridehub.promotion.broker.KafkaProducer;
import com.ridehub.promotion.service.dto.PromotionDTO;
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
@RequestMapping("/api/ms-promotion-kafka")
public class MsPromotionKafkaResource {

    private static final Logger LOG = LoggerFactory.getLogger(MsPromotionKafkaResource.class);

    private final KafkaProducer kafkaProducer; // now only has get() + send()
    private final KafkaUtilityService kafkaUtilityService;

    public MsPromotionKafkaResource(
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
            String messageKey = kafkaProducer.send("promotion.test", message);
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
     * Send a promotion creation event
     */
    @PostMapping("/publish/promotion-created")
    public ResponseEntity<Map<String, String>> publishPromotionCreated(@RequestBody PromotionDTO promotionDTO) {
        LOG.debug("REST request to queue promotion created event for: {}", promotionDTO);

        try {
            String messageKey = kafkaProducer.send("promotion.created", promotionDTO);
            if (messageKey == null) {
                throw new IllegalStateException("Failed to queue event (null key returned)");
            }

            Map<String, String> response = new HashMap<>();
            response.put("message", "Promotion created event queued successfully");
            response.put("messageKey", messageKey);
            response.put("promotionId", String.valueOf(promotionDTO.getId()));

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOG.error("Error queueing promotion created event: {}", e.getMessage(), e);
            Map<String, String> error = new HashMap<>();
            error.put("error", "Failed to queue promotion created event: " + e.getMessage());
            return ResponseEntity.internalServerError().body(error);
        }
    }

    /**
     * Send a promotion updated event
     */
    @PostMapping("/publish/promotion-updated")
    public ResponseEntity<Map<String, String>> publishPromotionUpdated(@RequestBody PromotionDTO promotionDTO) {
        LOG.debug("REST request to queue promotion updated event for: {}", promotionDTO);
        try {
            String messageKey = kafkaProducer.send("promotion.updated", promotionDTO);
            if (messageKey == null) {
                throw new IllegalStateException("Failed to queue event (null key returned)");
            }

            Map<String, String> response = new HashMap<>();
            response.put("message", "Promotion updated event queued successfully");
            response.put("messageKey", messageKey);
            response.put("promotionId", String.valueOf(promotionDTO.getId()));

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOG.error("Error queueing promotion updated event: {}", e.getMessage(), e);
            Map<String, String> error = new HashMap<>();
            error.put("error", "Failed to queue promotion updated event: " + e.getMessage());
            return ResponseEntity.internalServerError().body(error);
        }

    }

    /**
     * Send a promotion deleted event
     */
    @DeleteMapping("/publish/promotion-deleted/{id}")
    public ResponseEntity<Map<String, String>> publishPromotionDeleted(@PathVariable Long id) {
        LOG.debug("REST request to queue promotion deleted event for ID: {}", id);

        try {
            String messageKey = kafkaProducer.send("promotion.deleted", id);
            if (messageKey == null) {
                throw new IllegalStateException("Failed to queue event (null key returned)");
            }

            Map<String, String> response = new HashMap<>();
            response.put("message", "Promotion deleted event queued successfully");
            response.put("messageKey", messageKey);
            response.put("promotionId", String.valueOf(id));

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            LOG.error("Error queueing promotion deleted event: {}", e.getMessage(), e);
            Map<String, String> error = new HashMap<>();
            error.put("error", "Failed to queue promotion deleted event: " + e.getMessage());
            return ResponseEntity.internalServerError().body(error);
        }
    }

    /**
     * Get Kafka utility service status
     */
    @GetMapping("/status")
    public ResponseEntity<Map<String, Object>> getStatus() {
        Map<String, Object> status = new HashMap<>();
        status.put("service", "ms_promotion");
        status.put("kafkaUtilityEnabled", true);
        status.put("sseClientsCount", kafkaUtilityService.getEmitters().size());
        status.put("timestamp", System.currentTimeMillis());
        return ResponseEntity.ok(status);
    }
}
