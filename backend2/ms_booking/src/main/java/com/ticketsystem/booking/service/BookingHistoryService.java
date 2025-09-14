package com.ticketsystem.booking.service;

import com.ticketsystem.booking.service.dto.BookingHistoryDTO;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ticketsystem.booking.domain.BookingHistory}.
 */
public interface BookingHistoryService {
    /**
     * Save a bookingHistory.
     *
     * @param bookingHistoryDTO the entity to save.
     * @return the persisted entity.
     */
    BookingHistoryDTO save(BookingHistoryDTO bookingHistoryDTO);

    /**
     * Updates a bookingHistory.
     *
     * @param bookingHistoryDTO the entity to update.
     * @return the persisted entity.
     */
    BookingHistoryDTO update(BookingHistoryDTO bookingHistoryDTO);

    /**
     * Partially updates a bookingHistory.
     *
     * @param bookingHistoryDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<BookingHistoryDTO> partialUpdate(BookingHistoryDTO bookingHistoryDTO);

    /**
     * Get the "id" bookingHistory.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<BookingHistoryDTO> findOne(Long id);

    /**
     * Delete the "id" bookingHistory.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
