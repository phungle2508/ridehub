package com.ticketsystem.route.service.impl;

import com.ticketsystem.route.domain.Route;
import com.ticketsystem.route.repository.RouteRepository;
import com.ticketsystem.route.repository.search.RouteSearchRepository;
import com.ticketsystem.route.service.RouteService;
import com.ticketsystem.route.service.dto.RouteDTO;
import com.ticketsystem.route.service.mapper.RouteMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.ticketsystem.route.domain.Route}.
 */
@Service
@Transactional
public class RouteServiceImpl implements RouteService {

    private static final Logger LOG = LoggerFactory.getLogger(RouteServiceImpl.class);

    private final RouteRepository routeRepository;

    private final RouteMapper routeMapper;

    private final RouteSearchRepository routeSearchRepository;

    public RouteServiceImpl(RouteRepository routeRepository, RouteMapper routeMapper, RouteSearchRepository routeSearchRepository) {
        this.routeRepository = routeRepository;
        this.routeMapper = routeMapper;
        this.routeSearchRepository = routeSearchRepository;
    }

    @Override
    public RouteDTO save(RouteDTO routeDTO) {
        LOG.debug("Request to save Route : {}", routeDTO);
        Route route = routeMapper.toEntity(routeDTO);
        route = routeRepository.save(route);
        routeSearchRepository.index(route);
        return routeMapper.toDto(route);
    }

    @Override
    public RouteDTO update(RouteDTO routeDTO) {
        LOG.debug("Request to update Route : {}", routeDTO);
        Route route = routeMapper.toEntity(routeDTO);
        route = routeRepository.save(route);
        routeSearchRepository.index(route);
        return routeMapper.toDto(route);
    }

    @Override
    public Optional<RouteDTO> partialUpdate(RouteDTO routeDTO) {
        LOG.debug("Request to partially update Route : {}", routeDTO);

        return routeRepository
            .findById(routeDTO.getId())
            .map(existingRoute -> {
                routeMapper.partialUpdate(existingRoute, routeDTO);

                return existingRoute;
            })
            .map(routeRepository::save)
            .map(savedRoute -> {
                routeSearchRepository.index(savedRoute);
                return savedRoute;
            })
            .map(routeMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<RouteDTO> findOne(Long id) {
        LOG.debug("Request to get Route : {}", id);
        return routeRepository.findById(id).map(routeMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete Route : {}", id);
        routeRepository.deleteById(id);
        routeSearchRepository.deleteFromIndexById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<RouteDTO> search(String query, Pageable pageable) {
        LOG.debug("Request to search for a page of Routes for query {}", query);
        return routeSearchRepository.search(query, pageable).map(routeMapper::toDto);
    }
}
