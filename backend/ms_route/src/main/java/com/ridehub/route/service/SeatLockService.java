package com.ridehub.route.service;

import com.ridehub.route.service.dto.SeatLockDTO;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ridehub.route.domain.SeatLock}.
 */
public interface SeatLockService {
    /**
     * Save a seatLock.
     *
     * @param seatLockDTO the entity to save.
     * @return the persisted entity.
     */
    SeatLockDTO save(SeatLockDTO seatLockDTO);

    /**
     * Updates a seatLock.
     *
     * @param seatLockDTO the entity to update.
     * @return the persisted entity.
     */
    SeatLockDTO update(SeatLockDTO seatLockDTO);

    /**
     * Partially updates a seatLock.
     *
     * @param seatLockDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<SeatLockDTO> partialUpdate(SeatLockDTO seatLockDTO);

    /**
     * Get the "id" seatLock.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SeatLockDTO> findOne(Long id);

    /**
     * Delete the "id" seatLock.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
