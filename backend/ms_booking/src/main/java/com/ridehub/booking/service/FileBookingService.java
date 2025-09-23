package com.ridehub.booking.service;

import com.ridehub.booking.service.dto.FileBookingDTO;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ridehub.booking.domain.FileBooking}.
 */
public interface FileBookingService {
    /**
     * Save a fileBooking.
     *
     * @param fileBookingDTO the entity to save.
     * @return the persisted entity.
     */
    FileBookingDTO save(FileBookingDTO fileBookingDTO);

    /**
     * Updates a fileBooking.
     *
     * @param fileBookingDTO the entity to update.
     * @return the persisted entity.
     */
    FileBookingDTO update(FileBookingDTO fileBookingDTO);

    /**
     * Partially updates a fileBooking.
     *
     * @param fileBookingDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<FileBookingDTO> partialUpdate(FileBookingDTO fileBookingDTO);

    /**
     * Get all the FileBookingDTO where Ticket is {@code null}.
     *
     * @return the {@link List} of entities.
     */
    List<FileBookingDTO> findAllWhereTicketIsNull();

    /**
     * Get the "id" fileBooking.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<FileBookingDTO> findOne(Long id);

    /**
     * Delete the "id" fileBooking.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
