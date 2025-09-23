package com.ridehub.route.service;

import com.ridehub.route.service.dto.RouteListDTO;
import com.ridehub.route.service.dto.TripDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.ridehub.route.domain.Trip}.
 */
public interface TripService {
    /**
     * Save a trip.
     *
     * @param tripDTO the entity to save.
     * @return the persisted entity.
     */
    TripDTO save(TripDTO tripDTO);

    /**
     * Updates a trip.
     *
     * @param tripDTO the entity to update.
     * @return the persisted entity.
     */
    TripDTO update(TripDTO tripDTO);

    /**
     * Partially updates a trip.
     *
     * @param tripDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<TripDTO> partialUpdate(TripDTO tripDTO);

    /**
     * Get the "id" trip.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<TripDTO> findOne(Long id);

    /**
     * Delete the "id" trip.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    /**
     * Get all route list information combining trip, route, driver, and vehicle
     * data.
     *
     * @param pageable the pagination information.
     * @return the list of route information.
     */
    Page<RouteListDTO> getRouteList(Pageable pageable);
}
