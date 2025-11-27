package com.ridehub.promotion.service;

import com.ridehub.promotion.service.dto.ConditionDateItemDTO;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ridehub.promotion.domain.ConditionDateItem}.
 */
public interface ConditionDateItemService {
    /**
     * Save a conditionDateItem.
     *
     * @param conditionDateItemDTO the entity to save.
     * @return the persisted entity.
     */
    ConditionDateItemDTO save(ConditionDateItemDTO conditionDateItemDTO);

    /**
     * Updates a conditionDateItem.
     *
     * @param conditionDateItemDTO the entity to update.
     * @return the persisted entity.
     */
    ConditionDateItemDTO update(ConditionDateItemDTO conditionDateItemDTO);

    /**
     * Partially updates a conditionDateItem.
     *
     * @param conditionDateItemDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<ConditionDateItemDTO> partialUpdate(ConditionDateItemDTO conditionDateItemDTO);

    /**
     * Get the "id" conditionDateItem.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ConditionDateItemDTO> findOne(Long id);

    /**
     * Delete the "id" conditionDateItem.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
