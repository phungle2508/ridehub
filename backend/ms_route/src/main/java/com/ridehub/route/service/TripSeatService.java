package com.ridehub.route.service;

import com.ridehub.route.service.dto.TripSeatDTO;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ridehub.route.domain.TripSeat}.
 */
public interface TripSeatService {
    /**
     * Save a tripSeat.
     *
     * @param tripSeatDTO the entity to save.
     * @return the persisted entity.
     */
    TripSeatDTO save(TripSeatDTO tripSeatDTO);

    /**
     * Updates a tripSeat.
     *
     * @param tripSeatDTO the entity to update.
     * @return the persisted entity.
     */
    TripSeatDTO update(TripSeatDTO tripSeatDTO);

    /**
     * Partially updates a tripSeat.
     *
     * @param tripSeatDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<TripSeatDTO> partialUpdate(TripSeatDTO tripSeatDTO);

    /**
     * Get the "id" tripSeat.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<TripSeatDTO> findOne(Long id);

    /**
     * Delete the "id" tripSeat.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
