package com.ridehub.promotion.service;

import com.ridehub.promotion.service.dto.ConditionByRouteDTO;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ridehub.promotion.domain.ConditionByRoute}.
 */
public interface ConditionByRouteService {
    /**
     * Save a conditionByRoute.
     *
     * @param conditionByRouteDTO the entity to save.
     * @return the persisted entity.
     */
    ConditionByRouteDTO save(ConditionByRouteDTO conditionByRouteDTO);

    /**
     * Updates a conditionByRoute.
     *
     * @param conditionByRouteDTO the entity to update.
     * @return the persisted entity.
     */
    ConditionByRouteDTO update(ConditionByRouteDTO conditionByRouteDTO);

    /**
     * Partially updates a conditionByRoute.
     *
     * @param conditionByRouteDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<ConditionByRouteDTO> partialUpdate(ConditionByRouteDTO conditionByRouteDTO);

    /**
     * Get the "id" conditionByRoute.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ConditionByRouteDTO> findOne(Long id);

    /**
     * Delete the "id" conditionByRoute.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
