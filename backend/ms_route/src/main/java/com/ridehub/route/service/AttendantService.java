package com.ridehub.route.service;

import com.ridehub.route.service.dto.AttendantDTO;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ridehub.route.domain.Attendant}.
 */
public interface AttendantService {
    /**
     * Save a attendant.
     *
     * @param attendantDTO the entity to save.
     * @return the persisted entity.
     */
    AttendantDTO save(AttendantDTO attendantDTO);

    /**
     * Updates a attendant.
     *
     * @param attendantDTO the entity to update.
     * @return the persisted entity.
     */
    AttendantDTO update(AttendantDTO attendantDTO);

    /**
     * Partially updates a attendant.
     *
     * @param attendantDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<AttendantDTO> partialUpdate(AttendantDTO attendantDTO);

    /**
     * Get the "id" attendant.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<AttendantDTO> findOne(Long id);

    /**
     * Delete the "id" attendant.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
