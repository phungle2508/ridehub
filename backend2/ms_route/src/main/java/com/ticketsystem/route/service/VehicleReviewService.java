package com.ticketsystem.route.service;

import com.ticketsystem.route.service.dto.VehicleReviewDTO;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ticketsystem.route.domain.VehicleReview}.
 */
public interface VehicleReviewService {
    /**
     * Save a vehicleReview.
     *
     * @param vehicleReviewDTO the entity to save.
     * @return the persisted entity.
     */
    VehicleReviewDTO save(VehicleReviewDTO vehicleReviewDTO);

    /**
     * Updates a vehicleReview.
     *
     * @param vehicleReviewDTO the entity to update.
     * @return the persisted entity.
     */
    VehicleReviewDTO update(VehicleReviewDTO vehicleReviewDTO);

    /**
     * Partially updates a vehicleReview.
     *
     * @param vehicleReviewDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<VehicleReviewDTO> partialUpdate(VehicleReviewDTO vehicleReviewDTO);

    /**
     * Get the "id" vehicleReview.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<VehicleReviewDTO> findOne(Long id);

    /**
     * Delete the "id" vehicleReview.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
