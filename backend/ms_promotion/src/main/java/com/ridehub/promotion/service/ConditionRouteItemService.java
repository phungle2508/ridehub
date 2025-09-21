package com.ridehub.promotion.service;

import com.ridehub.promotion.service.dto.ConditionRouteItemDTO;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ridehub.promotion.domain.ConditionRouteItem}.
 */
public interface ConditionRouteItemService {
    /**
     * Save a conditionRouteItem.
     *
     * @param conditionRouteItemDTO the entity to save.
     * @return the persisted entity.
     */
    ConditionRouteItemDTO save(ConditionRouteItemDTO conditionRouteItemDTO);

    /**
     * Updates a conditionRouteItem.
     *
     * @param conditionRouteItemDTO the entity to update.
     * @return the persisted entity.
     */
    ConditionRouteItemDTO update(ConditionRouteItemDTO conditionRouteItemDTO);

    /**
     * Partially updates a conditionRouteItem.
     *
     * @param conditionRouteItemDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<ConditionRouteItemDTO> partialUpdate(ConditionRouteItemDTO conditionRouteItemDTO);

    /**
     * Get the "id" conditionRouteItem.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ConditionRouteItemDTO> findOne(Long id);

    /**
     * Delete the "id" conditionRouteItem.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
