package com.ridehub.route.web.rest;

import com.ridehub.route.service.StationManagementService;
import com.ridehub.route.service.dto.StationFilterDTO;
import com.ridehub.route.service.dto.StationListDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing station list operations.
 */
@RestController
@RequestMapping("/api/station-management")
public class StationManagementResource {

    private static final Logger LOG = LoggerFactory.getLogger(StationManagementResource.class);

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final StationManagementService stationManagementService;

    public StationManagementResource(StationManagementService stationManagementService) {
        this.stationManagementService = stationManagementService;
    }

    /**
     * {@code GET /stations} : get all stations with filtering and pagination.
     *
     * @param filter the filter criteria
     * @param pageable the pagination information
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of stations in body
     */
    @GetMapping("/stations")
    public ResponseEntity<List<StationListDTO>> getAllStations(
            StationFilterDTO filter,
            @org.springdoc.core.annotations.ParameterObject Pageable pageable) {
        LOG.debug("REST request to get stations with filter: {}", filter);
        
        Page<StationListDTO> page = stationManagementService.getAllStations(filter, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(
                ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET /stations/:stationId} : get the station by ID.
     *
     * @param stationId the station ID to retrieve
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the station, or with status {@code 404 (Not Found)}
     */
    @GetMapping("/stations/{stationId}")
    public ResponseEntity<StationListDTO> getStationById(@PathVariable("stationId") Long stationId) {
        LOG.debug("REST request to get station by ID: {}", stationId);
        Optional<StationListDTO> station = stationManagementService.getStationById(stationId);
        return ResponseUtil.wrapOrNotFound(station);
    }

    /**
     * {@code GET /stations/route/:routeName} : get stations by route.
     *
     * @param routeName the route name
     * @param pageable the pagination information
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of stations in body
     */
    @GetMapping("/stations/route/{routeName}")
    public ResponseEntity<List<StationListDTO>> getStationsByRoute(
            @PathVariable("routeName") String routeName,
            @org.springdoc.core.annotations.ParameterObject Pageable pageable) {
        LOG.debug("REST request to get stations by route: {}", routeName);
        
        Page<StationListDTO> page = stationManagementService.getStationsByRoute(routeName, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(
                ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET /stations/type/:stationType} : get stations by type.
     *
     * @param stationType the station type
     * @param pageable the pagination information
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of stations in body
     */
    @GetMapping("/stations/type/{stationType}")
    public ResponseEntity<List<StationListDTO>> getStationsByType(
            @PathVariable("stationType") String stationType,
            @org.springdoc.core.annotations.ParameterObject Pageable pageable) {
        LOG.debug("REST request to get stations by type: {}", stationType);
        
        Page<StationListDTO> page = stationManagementService.getStationsByType(stationType, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(
                ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET /stations/status/:status} : get stations by status.
     *
     * @param status the station status
     * @param pageable the pagination information
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of stations in body
     */
    @GetMapping("/stations/status/{status}")
    public ResponseEntity<List<StationListDTO>> getStationsByStatus(
            @PathVariable("status") String status,
            @org.springdoc.core.annotations.ParameterObject Pageable pageable) {
        LOG.debug("REST request to get stations by status: {}", status);
        
        Page<StationListDTO> page = stationManagementService.getStationsByStatus(status, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(
                ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET /stations/search} : search stations by query.
     *
     * @param query the search query
     * @param pageable the pagination information
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of stations in body
     */
    @GetMapping("/stations/search")
    public ResponseEntity<List<StationListDTO>> searchStations(
            @RequestParam("query") String query,
            @org.springdoc.core.annotations.ParameterObject Pageable pageable) {
        LOG.debug("REST request to search stations with query: {}", query);
        
        Page<StationListDTO> page = stationManagementService.searchStations(query, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(
                ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET /stations/types} : get available station types.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of types in body
     */
    @GetMapping("/stations/types")
    public ResponseEntity<List<String>> getAvailableStationTypes() {
        LOG.debug("REST request to get available station types");
        List<String> types = stationManagementService.getAvailableStationTypes();
        return ResponseEntity.ok().body(types);
    }

    /**
     * {@code GET /stations/statuses} : get available station statuses.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of statuses in body
     */
    @GetMapping("/stations/statuses")
    public ResponseEntity<List<String>> getAvailableStatuses() {
        LOG.debug("REST request to get available station statuses");
        List<String> statuses = stationManagementService.getAvailableStatuses();
        return ResponseEntity.ok().body(statuses);
    }

    /**
     * {@code PUT /stations/:stationId/status} : update station status.
     *
     * @param stationId the station ID
     * @param newStatus the new status
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated station, or with status {@code 404 (Not Found)}
     */
    @PutMapping("/stations/{stationId}/status")
    public ResponseEntity<StationListDTO> updateStationStatus(
            @PathVariable("stationId") Long stationId,
            @RequestParam("status") String newStatus) {
        LOG.debug("REST request to update station status: {} to {}", stationId, newStatus);
        
        Optional<StationListDTO> updatedStation = stationManagementService.updateStationStatus(stationId, newStatus);
        return ResponseUtil.wrapOrNotFound(updatedStation);
    }

    /**
     * {@code POST /stations/:stationId/route} : add station to route.
     *
     * @param stationId the station ID
     * @param routeName the route name
     * @param orderInRoute the order in route
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated station, or with status {@code 404 (Not Found)}
     */
    @PostMapping("/stations/{stationId}/route")
    public ResponseEntity<StationListDTO> addStationToRoute(
            @PathVariable("stationId") Long stationId,
            @RequestParam("routeName") String routeName,
            @RequestParam("orderInRoute") Integer orderInRoute) {
        LOG.debug("REST request to add station {} to route {} at order {}", stationId, routeName, orderInRoute);
        
        Optional<StationListDTO> updatedStation = stationManagementService.addStationToRoute(stationId, routeName, orderInRoute);
        return ResponseUtil.wrapOrNotFound(updatedStation);
    }

    /**
     * {@code DELETE /stations/:stationId/route/:routeName} : remove station from route.
     *
     * @param stationId the station ID
     * @param routeName the route name
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated station, or with status {@code 404 (Not Found)}
     */
    @DeleteMapping("/stations/{stationId}/route/{routeName}")
    public ResponseEntity<StationListDTO> removeStationFromRoute(
            @PathVariable("stationId") Long stationId,
            @PathVariable("routeName") String routeName) {
        LOG.debug("REST request to remove station {} from route {}", stationId, routeName);
        
        Optional<StationListDTO> updatedStation = stationManagementService.removeStationFromRoute(stationId, routeName);
        return ResponseUtil.wrapOrNotFound(updatedStation);
    }
}
