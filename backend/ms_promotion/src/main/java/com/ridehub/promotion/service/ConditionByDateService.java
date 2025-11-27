package com.ridehub.promotion.service;

import com.ridehub.promotion.service.dto.ConditionByDateDTO;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ridehub.promotion.domain.ConditionByDate}.
 */
public interface ConditionByDateService {
    /**
     * Save a conditionByDate.
     *
     * @param conditionByDateDTO the entity to save.
     * @return the persisted entity.
     */
    ConditionByDateDTO save(ConditionByDateDTO conditionByDateDTO);

    /**
     * Updates a conditionByDate.
     *
     * @param conditionByDateDTO the entity to update.
     * @return the persisted entity.
     */
    ConditionByDateDTO update(ConditionByDateDTO conditionByDateDTO);

    /**
     * Partially updates a conditionByDate.
     *
     * @param conditionByDateDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<ConditionByDateDTO> partialUpdate(ConditionByDateDTO conditionByDateDTO);

    /**
     * Get the "id" conditionByDate.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ConditionByDateDTO> findOne(Long id);

    /**
     * Delete the "id" conditionByDate.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
