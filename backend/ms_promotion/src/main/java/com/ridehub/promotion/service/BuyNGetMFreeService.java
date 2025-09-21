package com.ridehub.promotion.service;

import com.ridehub.promotion.service.dto.BuyNGetMFreeDTO;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ridehub.promotion.domain.BuyNGetMFree}.
 */
public interface BuyNGetMFreeService {
    /**
     * Save a buyNGetMFree.
     *
     * @param buyNGetMFreeDTO the entity to save.
     * @return the persisted entity.
     */
    BuyNGetMFreeDTO save(BuyNGetMFreeDTO buyNGetMFreeDTO);

    /**
     * Updates a buyNGetMFree.
     *
     * @param buyNGetMFreeDTO the entity to update.
     * @return the persisted entity.
     */
    BuyNGetMFreeDTO update(BuyNGetMFreeDTO buyNGetMFreeDTO);

    /**
     * Partially updates a buyNGetMFree.
     *
     * @param buyNGetMFreeDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<BuyNGetMFreeDTO> partialUpdate(BuyNGetMFreeDTO buyNGetMFreeDTO);

    /**
     * Get the "id" buyNGetMFree.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<BuyNGetMFreeDTO> findOne(Long id);

    /**
     * Delete the "id" buyNGetMFree.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
