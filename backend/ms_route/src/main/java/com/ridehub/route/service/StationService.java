package com.ridehub.route.service;

import com.ridehub.route.service.dto.StationDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link com.ridehub.route.domain.Station}.
 */
public interface StationService {
    /**
     * Save a station.
     *
     * @param stationDTO the entity to save.
     * @return the persisted entity.
     */
    StationDTO save(StationDTO stationDTO);

    /**
     * Updates a station.
     *
     * @param stationDTO the entity to update.
     * @return the persisted entity.
     */
    StationDTO update(StationDTO stationDTO);

    /**
     * Partially updates a station.
     *
     * @param stationDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<StationDTO> partialUpdate(StationDTO stationDTO);

    /**
     * Get the "id" station.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<StationDTO> findOne(Long id);

    /**
     * Delete the "id" station.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    /**
     * Search for the station corresponding to the query.
     *
     * @param query the query of the search.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<StationDTO> search(String query, Pageable pageable);
}
