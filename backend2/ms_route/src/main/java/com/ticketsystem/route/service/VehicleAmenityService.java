package com.ticketsystem.route.service;

import com.ticketsystem.route.service.dto.VehicleAmenityDTO;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ticketsystem.route.domain.VehicleAmenity}.
 */
public interface VehicleAmenityService {
    /**
     * Save a vehicleAmenity.
     *
     * @param vehicleAmenityDTO the entity to save.
     * @return the persisted entity.
     */
    VehicleAmenityDTO save(VehicleAmenityDTO vehicleAmenityDTO);

    /**
     * Updates a vehicleAmenity.
     *
     * @param vehicleAmenityDTO the entity to update.
     * @return the persisted entity.
     */
    VehicleAmenityDTO update(VehicleAmenityDTO vehicleAmenityDTO);

    /**
     * Partially updates a vehicleAmenity.
     *
     * @param vehicleAmenityDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<VehicleAmenityDTO> partialUpdate(VehicleAmenityDTO vehicleAmenityDTO);

    /**
     * Get the "id" vehicleAmenity.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<VehicleAmenityDTO> findOne(Long id);

    /**
     * Delete the "id" vehicleAmenity.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
