package com.ridehub.route.service;

import com.ridehub.route.service.dto.SeatLockDTO;
import com.ridehub.route.service.dto.request.SeatLockRequestDTO;
import com.ridehub.route.service.dto.request.SeatLockActionRequestDTO;
import com.ridehub.route.service.dto.response.SeatLockResponseDTO;
import com.ridehub.route.service.dto.response.SeatLockActionResponseDTO;
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

    /**
     * Try to lock seats for a booking.
     *
     * @param request the seat lock request containing booking details and seat numbers.
     * @return the seat lock response with status HELD or REJECTED.
     */
    SeatLockResponseDTO tryLockSeats(SeatLockRequestDTO request);

    /**
     * Confirm seat locks for a booking.
     *
     * @param request the seat lock action request.
     * @return the seat lock action response.
     */
    SeatLockActionResponseDTO confirmSeatLocks(SeatLockActionRequestDTO request);

    /**
     * Cancel seat locks for a booking.
     *
     * @param request the seat lock action request.
     * @return the seat lock action response.
     */
    SeatLockActionResponseDTO cancelSeatLocks(SeatLockActionRequestDTO request);
}

