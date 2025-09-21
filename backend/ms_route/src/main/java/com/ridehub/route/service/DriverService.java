package com.ridehub.route.service;

import com.ridehub.route.service.dto.DriverDTO;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ridehub.route.domain.Driver}.
 */
public interface DriverService {
    /**
     * Save a driver.
     *
     * @param driverDTO the entity to save.
     * @return the persisted entity.
     */
    DriverDTO save(DriverDTO driverDTO);

    /**
     * Updates a driver.
     *
     * @param driverDTO the entity to update.
     * @return the persisted entity.
     */
    DriverDTO update(DriverDTO driverDTO);

    /**
     * Partially updates a driver.
     *
     * @param driverDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<DriverDTO> partialUpdate(DriverDTO driverDTO);

    /**
     * Get all the DriverDTO where Trip is {@code null}.
     *
     * @return the {@link List} of entities.
     */
    List<DriverDTO> findAllWhereTripIsNull();

    /**
     * Get the "id" driver.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<DriverDTO> findOne(Long id);

    /**
     * Delete the "id" driver.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
