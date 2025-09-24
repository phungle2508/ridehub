package com.ridehub.route.service;

import com.ridehub.route.service.dto.StationFilterDTO;
import com.ridehub.route.service.dto.StationListDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing station list operations.
 */
public interface StationManagementService {

    /**
     * Get all stations with pagination and filtering.
     *
     * @param filter the filter criteria
     * @param pageable the pagination information
     * @return the list of stations
     */
    Page<StationListDTO> getAllStations(StationFilterDTO filter, Pageable pageable);

    /**
     * Get station by ID.
     *
     * @param stationId the station ID
     * @return the station if found
     */
    Optional<StationListDTO> getStationById(Long stationId);

    /**
     * Get stations by route.
     *
     * @param routeName the route name
     * @param pageable the pagination information
     * @return the list of stations for the route
     */
    Page<StationListDTO> getStationsByRoute(String routeName, Pageable pageable);

    /**
     * Get stations by type.
     *
     * @param stationType the station type
     * @param pageable the pagination information
     * @return the list of stations with the specified type
     */
    Page<StationListDTO> getStationsByType(String stationType, Pageable pageable);

    /**
     * Get stations by status.
     *
     * @param status the station status
     * @param pageable the pagination information
     * @return the list of stations with the specified status
     */
    Page<StationListDTO> getStationsByStatus(String status, Pageable pageable);

    /**
     * Search stations by query string.
     *
     * @param query the search query
     * @param pageable the pagination information
     * @return the list of matching stations
     */
    Page<StationListDTO> searchStations(String query, Pageable pageable);

    /**
     * Get available station types.
     *
     * @return the list of available station types
     */
    List<String> getAvailableStationTypes();

    /**
     * Get available station statuses.
     *
     * @return the list of available statuses
     */
    List<String> getAvailableStatuses();

    /**
     * Update station status.
     *
     * @param stationId the station ID
     * @param newStatus the new status
     * @return the updated station
     */
    Optional<StationListDTO> updateStationStatus(Long stationId, String newStatus);

    /**
     * Add station to route.
     *
     * @param stationId the station ID
     * @param routeName the route name
     * @param orderInRoute the order in route
     * @return the updated station
     */
    Optional<StationListDTO> addStationToRoute(Long stationId, String routeName, Integer orderInRoute);

    /**
     * Remove station from route.
     *
     * @param stationId the station ID
     * @param routeName the route name
     * @return the updated station
     */
    Optional<StationListDTO> removeStationFromRoute(Long stationId, String routeName);
}
