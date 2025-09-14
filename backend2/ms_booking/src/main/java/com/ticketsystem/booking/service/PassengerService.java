package com.ticketsystem.booking.service;

import com.ticketsystem.booking.service.dto.PassengerDTO;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ticketsystem.booking.domain.Passenger}.
 */
public interface PassengerService {
    /**
     * Save a passenger.
     *
     * @param passengerDTO the entity to save.
     * @return the persisted entity.
     */
    PassengerDTO save(PassengerDTO passengerDTO);

    /**
     * Updates a passenger.
     *
     * @param passengerDTO the entity to update.
     * @return the persisted entity.
     */
    PassengerDTO update(PassengerDTO passengerDTO);

    /**
     * Partially updates a passenger.
     *
     * @param passengerDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<PassengerDTO> partialUpdate(PassengerDTO passengerDTO);

    /**
     * Get the "id" passenger.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PassengerDTO> findOne(Long id);

    /**
     * Delete the "id" passenger.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
