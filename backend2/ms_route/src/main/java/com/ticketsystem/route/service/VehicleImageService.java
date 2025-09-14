package com.ticketsystem.route.service;

import com.ticketsystem.route.service.dto.VehicleImageDTO;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ticketsystem.route.domain.VehicleImage}.
 */
public interface VehicleImageService {
    /**
     * Save a vehicleImage.
     *
     * @param vehicleImageDTO the entity to save.
     * @return the persisted entity.
     */
    VehicleImageDTO save(VehicleImageDTO vehicleImageDTO);

    /**
     * Updates a vehicleImage.
     *
     * @param vehicleImageDTO the entity to update.
     * @return the persisted entity.
     */
    VehicleImageDTO update(VehicleImageDTO vehicleImageDTO);

    /**
     * Partially updates a vehicleImage.
     *
     * @param vehicleImageDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<VehicleImageDTO> partialUpdate(VehicleImageDTO vehicleImageDTO);

    /**
     * Get the "id" vehicleImage.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<VehicleImageDTO> findOne(Long id);

    /**
     * Delete the "id" vehicleImage.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
