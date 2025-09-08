package com.ticketsystem.route.service.event;

import com.ticketsystem.kafka.handler.EventHandler;
import com.ticketsystem.route.service.RouteService;
import com.ticketsystem.route.service.dto.RouteDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Event handler for Route created events
 */
@Component("routeCreatedEventHandler")
class RouteCreatedEventHandler implements EventHandler<RouteDTO> {

    private static final Logger LOG = LoggerFactory.getLogger(RouteCreatedEventHandler.class);

    private final RouteService routeService;

    public RouteCreatedEventHandler(RouteService routeService) {
        this.routeService = routeService;
    }

    @Override
    public String getEventName() {
        return "route.created";
    }

    @Override
    public void handle(RouteDTO payload) {
        LOG.info("Processing route created event for route ID: {}", payload != null ? payload.getId() : "null");
        
        try {
            handleRouteCreated(payload);
        } catch (Exception e) {
            LOG.error("Error processing route created event: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to process route created event", e);
        }
    }

    private void handleRouteCreated(RouteDTO payload) {
        LOG.info("Handling route created event: {}", payload);
        
        // Add specific logic for route created events here
        // For example:
        // - Update search indexes
        // - Send notifications to subscribed services
        // - Trigger route optimization processes
        // - Update analytics/reporting
        
        LOG.info("Route created event processed successfully for route: {}", payload.getId());
    }
}

/**
 * Event handler for Route updated events
 */
@Component("routeUpdatedEventHandler")
class RouteUpdatedEventHandler implements EventHandler<RouteDTO> {

    private static final Logger LOG = LoggerFactory.getLogger(RouteUpdatedEventHandler.class);

    private final RouteService routeService;

    public RouteUpdatedEventHandler(RouteService routeService) {
        this.routeService = routeService;
    }

    @Override
    public String getEventName() {
        return "route.updated";
    }

    @Override
    public void handle(RouteDTO payload) {
        LOG.info("Processing route updated event for route ID: {}", payload != null ? payload.getId() : "null");
        
        try {
            handleRouteUpdated(payload);
        } catch (Exception e) {
            LOG.error("Error processing route updated event: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to process route updated event", e);
        }
    }

    private void handleRouteUpdated(RouteDTO payload) {
        LOG.info("Handling route updated event: {}", payload);
        
        // Add specific logic for route updated events here
        // For example:
        // - Update search indexes with new data
        // - Notify dependent services of the changes
        // - Recalculate route metrics
        // - Update caches
        
        LOG.info("Route updated event processed successfully for route: {}", payload.getId());
    }
}

/**
 * Event handler for Route deleted events
 */
@Component("routeDeletedEventHandler")
class RouteDeletedEventHandler implements EventHandler<Long> {

    private static final Logger LOG = LoggerFactory.getLogger(RouteDeletedEventHandler.class);

    private final RouteService routeService;

    public RouteDeletedEventHandler(RouteService routeService) {
        this.routeService = routeService;
    }

    @Override
    public String getEventName() {
        return "route.deleted";
    }

    @Override
    public void handle(Long payload) {
        LOG.info("Processing route deleted event for route ID: {}", payload);
        
        try {
            handleRouteDeleted(payload);
        } catch (Exception e) {
            LOG.error("Error processing route deleted event: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to process route deleted event", e);
        }
    }

    private void handleRouteDeleted(Long routeId) {
        LOG.info("Handling route deleted event for route ID: {}", routeId);
        
        // Add specific logic for route deleted events here
        // For example:
        // - Remove from search indexes
        // - Clean up related data
        // - Notify dependent services
        // - Archive related records
        
        LOG.info("Route deleted event processed successfully for route ID: {}", routeId);
    }
}

/**
 * Event handler for Route status changed events
 */
@Component("routeStatusChangedEventHandler")
class RouteStatusChangedEventHandler implements EventHandler<RouteDTO> {

    private static final Logger LOG = LoggerFactory.getLogger(RouteStatusChangedEventHandler.class);

    private final RouteService routeService;

    public RouteStatusChangedEventHandler(RouteService routeService) {
        this.routeService = routeService;
    }

    @Override
    public String getEventName() {
        return "route.status_changed";
    }

    @Override
    public void handle(RouteDTO payload) {
        LOG.info("Processing route status changed event for route ID: {}", payload != null ? payload.getId() : "null");
        
        try {
            handleRouteStatusChanged(payload);
        } catch (Exception e) {
            LOG.error("Error processing route status changed event: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to process route status changed event", e);
        }
    }

    private void handleRouteStatusChanged(RouteDTO payload) {
        LOG.info("Handling route status changed event: {}", payload);
        
        // Add specific logic for route status changed events here
        // For example:
        // - Update route availability
        // - Notify booking services
        // - Update route displays
        // - Send status notifications
        
        LOG.info("Route status changed event processed successfully for route: {}", payload.getId());
    }
}
