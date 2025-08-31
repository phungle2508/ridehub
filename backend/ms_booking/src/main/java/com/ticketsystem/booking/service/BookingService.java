package com.ticketsystem.booking.service;

import com.ticketsystem.booking.service.dto.BookingDTO;
import java.util.Optional;
import java.util.UUID;

/**
 * Service Interface for managing {@link com.ticketsystem.booking.domain.Booking}.
 */
public interface BookingService {
    /**
     * Save a booking.
     *
     * @param bookingDTO the entity to save.
     * @return the persisted entity.
     */
    BookingDTO save(BookingDTO bookingDTO);

    /**
     * Updates a booking.
     *
     * @param bookingDTO the entity to update.
     * @return the persisted entity.
     */
    BookingDTO update(BookingDTO bookingDTO);

    /**
     * Partially updates a booking.
     *
     * @param bookingDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<BookingDTO> partialUpdate(BookingDTO bookingDTO);

    /**
     * Get the "id" booking.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<BookingDTO> findOne(UUID id);

    /**
     * Delete the "id" booking.
     *
     * @param id the id of the entity.
     */
    void delete(UUID id);
}
