package com.ridehub.booking.service;

import com.ridehub.booking.service.dto.AppliedPromotionDTO;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ridehub.booking.domain.AppliedPromotion}.
 */
public interface AppliedPromotionService {
    /**
     * Save a appliedPromotion.
     *
     * @param appliedPromotionDTO the entity to save.
     * @return the persisted entity.
     */
    AppliedPromotionDTO save(AppliedPromotionDTO appliedPromotionDTO);

    /**
     * Updates a appliedPromotion.
     *
     * @param appliedPromotionDTO the entity to update.
     * @return the persisted entity.
     */
    AppliedPromotionDTO update(AppliedPromotionDTO appliedPromotionDTO);

    /**
     * Partially updates a appliedPromotion.
     *
     * @param appliedPromotionDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<AppliedPromotionDTO> partialUpdate(AppliedPromotionDTO appliedPromotionDTO);

    /**
     * Get the "id" appliedPromotion.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<AppliedPromotionDTO> findOne(Long id);

    /**
     * Delete the "id" appliedPromotion.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
