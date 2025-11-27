package com.ridehub.promotion.service;

import com.ridehub.promotion.service.dto.PercentOffTotalDTO;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ridehub.promotion.domain.PercentOffTotal}.
 */
public interface PercentOffTotalService {
    /**
     * Save a percentOffTotal.
     *
     * @param percentOffTotalDTO the entity to save.
     * @return the persisted entity.
     */
    PercentOffTotalDTO save(PercentOffTotalDTO percentOffTotalDTO);

    /**
     * Updates a percentOffTotal.
     *
     * @param percentOffTotalDTO the entity to update.
     * @return the persisted entity.
     */
    PercentOffTotalDTO update(PercentOffTotalDTO percentOffTotalDTO);

    /**
     * Partially updates a percentOffTotal.
     *
     * @param percentOffTotalDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<PercentOffTotalDTO> partialUpdate(PercentOffTotalDTO percentOffTotalDTO);

    /**
     * Get the "id" percentOffTotal.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PercentOffTotalDTO> findOne(Long id);

    /**
     * Delete the "id" percentOffTotal.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
