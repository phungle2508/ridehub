package com.ticketsystem.route.service;

import com.ticketsystem.route.service.dto.ReviewSummaryDTO;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ticketsystem.route.domain.ReviewSummary}.
 */
public interface ReviewSummaryService {
    /**
     * Save a reviewSummary.
     *
     * @param reviewSummaryDTO the entity to save.
     * @return the persisted entity.
     */
    ReviewSummaryDTO save(ReviewSummaryDTO reviewSummaryDTO);

    /**
     * Updates a reviewSummary.
     *
     * @param reviewSummaryDTO the entity to update.
     * @return the persisted entity.
     */
    ReviewSummaryDTO update(ReviewSummaryDTO reviewSummaryDTO);

    /**
     * Partially updates a reviewSummary.
     *
     * @param reviewSummaryDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<ReviewSummaryDTO> partialUpdate(ReviewSummaryDTO reviewSummaryDTO);

    /**
     * Get all the ReviewSummaryDTO where Vehicle is {@code null}.
     *
     * @return the {@link List} of entities.
     */
    List<ReviewSummaryDTO> findAllWhereVehicleIsNull();

    /**
     * Get the "id" reviewSummary.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<ReviewSummaryDTO> findOne(Long id);

    /**
     * Delete the "id" reviewSummary.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
