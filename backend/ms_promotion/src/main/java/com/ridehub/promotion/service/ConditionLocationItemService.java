package com.ridehub.promotion.service;

import com.ridehub.promotion.service.dto.ConditionLocationItemDTO;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ridehub.promotion.domain.ConditionLocationItem}.
 */
public interface ConditionLocationItemService {
    /**
     * Save a conditionLocationItem.
     *
     * @param conditionLocationItemDTO the entity to save.
     * @return the persisted entity.
     */
    ConditionLocationItemDTO save(ConditionLocationItemDTO conditionLocationItemDTO);

    /**
     * Updates a conditionLocationItem.
     *
     * @param conditionLocationItemDTO the entity to update.
     * @return the persisted entity.
     */
    ConditionLocationItemDTO update(ConditionLocationItemDTO conditionLocationItemDTO);

    /**
     * Partially updates a conditionLocationItem.
     *
     * @param conditionLocationItemDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<ConditionLocationItemDTO> partialUpdate(ConditionLocationItemDTO conditionLocationItemDTO);

    /**
     * Get the "id" conditionLocationItem.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ConditionLocationItemDTO> findOne(Long id);

    /**
     * Delete the "id" conditionLocationItem.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
