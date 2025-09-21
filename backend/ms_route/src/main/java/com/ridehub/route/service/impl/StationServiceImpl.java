package com.ridehub.route.service.impl;

import com.ridehub.route.domain.Station;
import com.ridehub.route.repository.StationRepository;
import com.ridehub.route.repository.search.StationSearchRepository;
import com.ridehub.route.service.StationService;
import com.ridehub.route.service.dto.StationDTO;
import com.ridehub.route.service.mapper.StationMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.ridehub.route.domain.Station}.
 */
@Service
@Transactional
public class StationServiceImpl implements StationService {

    private static final Logger LOG = LoggerFactory.getLogger(StationServiceImpl.class);

    private final StationRepository stationRepository;

    private final StationMapper stationMapper;

    private final StationSearchRepository stationSearchRepository;

    public StationServiceImpl(
        StationRepository stationRepository,
        StationMapper stationMapper,
        StationSearchRepository stationSearchRepository
    ) {
        this.stationRepository = stationRepository;
        this.stationMapper = stationMapper;
        this.stationSearchRepository = stationSearchRepository;
    }

    @Override
    public StationDTO save(StationDTO stationDTO) {
        LOG.debug("Request to save Station : {}", stationDTO);
        Station station = stationMapper.toEntity(stationDTO);
        station = stationRepository.save(station);
        stationSearchRepository.index(station);
        return stationMapper.toDto(station);
    }

    @Override
    public StationDTO update(StationDTO stationDTO) {
        LOG.debug("Request to update Station : {}", stationDTO);
        Station station = stationMapper.toEntity(stationDTO);
        station = stationRepository.save(station);
        stationSearchRepository.index(station);
        return stationMapper.toDto(station);
    }

    @Override
    public Optional<StationDTO> partialUpdate(StationDTO stationDTO) {
        LOG.debug("Request to partially update Station : {}", stationDTO);

        return stationRepository
            .findById(stationDTO.getId())
            .map(existingStation -> {
                stationMapper.partialUpdate(existingStation, stationDTO);

                return existingStation;
            })
            .map(stationRepository::save)
            .map(savedStation -> {
                stationSearchRepository.index(savedStation);
                return savedStation;
            })
            .map(stationMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<StationDTO> findOne(Long id) {
        LOG.debug("Request to get Station : {}", id);
        return stationRepository.findById(id).map(stationMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete Station : {}", id);
        stationRepository.deleteById(id);
        stationSearchRepository.deleteFromIndexById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<StationDTO> search(String query, Pageable pageable) {
        LOG.debug("Request to search for a page of Stations for query {}", query);
        return stationSearchRepository.search(query, pageable).map(stationMapper::toDto);
    }
}
