package com.ridehub.promotion.service;

import com.ridehub.promotion.service.dto.FilePromotionDTO;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ridehub.promotion.domain.FilePromotion}.
 */
public interface FilePromotionService {
    /**
     * Save a filePromotion.
     *
     * @param filePromotionDTO the entity to save.
     * @return the persisted entity.
     */
    FilePromotionDTO save(FilePromotionDTO filePromotionDTO);

    /**
     * Updates a filePromotion.
     *
     * @param filePromotionDTO the entity to update.
     * @return the persisted entity.
     */
    FilePromotionDTO update(FilePromotionDTO filePromotionDTO);

    /**
     * Partially updates a filePromotion.
     *
     * @param filePromotionDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<FilePromotionDTO> partialUpdate(FilePromotionDTO filePromotionDTO);

    /**
     * Get all the FilePromotionDTO where Promotion is {@code null}.
     *
     * @return the {@link List} of entities.
     */
    List<FilePromotionDTO> findAllWherePromotionIsNull();

    /**
     * Get the "id" filePromotion.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<FilePromotionDTO> findOne(Long id);

    /**
     * Delete the "id" filePromotion.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
