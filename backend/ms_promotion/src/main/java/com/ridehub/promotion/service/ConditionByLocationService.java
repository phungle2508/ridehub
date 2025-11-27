package com.ridehub.promotion.service;

import com.ridehub.promotion.service.dto.ConditionByLocationDTO;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ridehub.promotion.domain.ConditionByLocation}.
 */
public interface ConditionByLocationService {
    /**
     * Save a conditionByLocation.
     *
     * @param conditionByLocationDTO the entity to save.
     * @return the persisted entity.
     */
    ConditionByLocationDTO save(ConditionByLocationDTO conditionByLocationDTO);

    /**
     * Updates a conditionByLocation.
     *
     * @param conditionByLocationDTO the entity to update.
     * @return the persisted entity.
     */
    ConditionByLocationDTO update(ConditionByLocationDTO conditionByLocationDTO);

    /**
     * Partially updates a conditionByLocation.
     *
     * @param conditionByLocationDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<ConditionByLocationDTO> partialUpdate(ConditionByLocationDTO conditionByLocationDTO);

    /**
     * Get the "id" conditionByLocation.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ConditionByLocationDTO> findOne(Long id);

    /**
     * Delete the "id" conditionByLocation.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
