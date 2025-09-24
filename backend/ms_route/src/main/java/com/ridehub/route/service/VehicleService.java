package com.ridehub.route.service;

import com.ridehub.route.service.dto.VehicleDTO;
import com.ridehub.route.service.dto.VehicleListDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.ridehub.route.domain.Vehicle}.
 */
public interface VehicleService {
    /**
     * Save a vehicle.
     *
     * @param vehicleDTO the entity to save.
     * @return the persisted entity.
     */
    VehicleDTO save(VehicleDTO vehicleDTO);

    /**
     * Updates a vehicle.
     *
     * @param vehicleDTO the entity to update.
     * @return the persisted entity.
     */
    VehicleDTO update(VehicleDTO vehicleDTO);

    /**
     * Partially updates a vehicle.
     *
     * @param vehicleDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<VehicleDTO> partialUpdate(VehicleDTO vehicleDTO);

    /**
     * Get the "id" vehicle.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<VehicleDTO> findOne(Long id);

    /**
     * Delete the "id" vehicle.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    /**
     * Get all vehicles with their current route assignments and driver information.
     *
     * @param pageable the pagination information.
     * @return the list of vehicles with route and driver details.
     */
    Page<VehicleListDTO> getVehicleList(Pageable pageable);
}
