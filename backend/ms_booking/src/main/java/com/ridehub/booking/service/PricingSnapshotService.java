package com.ridehub.booking.service;

import com.ridehub.booking.service.dto.PricingSnapshotDTO;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ridehub.booking.domain.PricingSnapshot}.
 */
public interface PricingSnapshotService {
    /**
     * Save a pricingSnapshot.
     *
     * @param pricingSnapshotDTO the entity to save.
     * @return the persisted entity.
     */
    PricingSnapshotDTO save(PricingSnapshotDTO pricingSnapshotDTO);

    /**
     * Updates a pricingSnapshot.
     *
     * @param pricingSnapshotDTO the entity to update.
     * @return the persisted entity.
     */
    PricingSnapshotDTO update(PricingSnapshotDTO pricingSnapshotDTO);

    /**
     * Partially updates a pricingSnapshot.
     *
     * @param pricingSnapshotDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<PricingSnapshotDTO> partialUpdate(PricingSnapshotDTO pricingSnapshotDTO);

    /**
     * Get the "id" pricingSnapshot.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PricingSnapshotDTO> findOne(Long id);

    /**
     * Delete the "id" pricingSnapshot.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
