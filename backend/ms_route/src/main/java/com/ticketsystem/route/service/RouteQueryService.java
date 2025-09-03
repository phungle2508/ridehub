package com.ticketsystem.route.service;

import com.ticketsystem.msroute.client.api.RouteResourceMsrouteApi;
import com.ticketsystem.route.domain.*; // for static metamodels
import com.ticketsystem.route.repository.RouteRepository;
import com.ticketsystem.route.repository.search.RouteSearchRepository;
import com.ticketsystem.route.service.criteria.RouteCriteria;
import com.ticketsystem.route.service.dto.RouteDTO;
import com.ticketsystem.route.service.mapper.RouteMapper;
import jakarta.persistence.criteria.JoinType;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link Route} entities in the
 * database.
 * The main input is a {@link RouteCriteria} which gets converted to
 * {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link Page} of {@link RouteDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class RouteQueryService extends QueryService<Route> {

    private static final Logger LOG = LoggerFactory.getLogger(RouteQueryService.class);

    private final RouteRepository routeRepository;

    private final RouteMapper routeMapper;

    private final RouteSearchRepository routeSearchRepository;
    private final RouteResourceMsrouteApi routeResourceMsrouteApi;

    public RouteQueryService(RouteRepository routeRepository, RouteMapper routeMapper,
            RouteSearchRepository routeSearchRepository, RouteResourceMsrouteApi routeResourceMsrouteApi) {
        this.routeRepository = routeRepository;
        this.routeMapper = routeMapper;
        this.routeSearchRepository = routeSearchRepository;
        this.routeResourceMsrouteApi = routeResourceMsrouteApi;
    }

    /**
     * Return a {@link Page} of {@link RouteDTO} which matches the criteria from the
     * database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @param page     The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<RouteDTO> findByCriteria(RouteCriteria criteria, Pageable page) {
        LOG.debug("find by criteria : {}, page: {}", criteria, page);
        
        System.out.println(routeResourceMsrouteApi.getRoute(UUID.fromString("18aade68-9849-4451-bc0e-9808dfce2bf9")).getDestination() + "asdasdasdsadsd");
        final Specification<Route> specification = createSpecification(criteria);
        return routeRepository.findAll(specification, page).map(routeMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(RouteCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<Route> specification = createSpecification(criteria);
        return routeRepository.count(specification);
    }

    /**
     * Function to convert {@link RouteCriteria} to a {@link Specification}
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Route> createSpecification(RouteCriteria criteria) {
        Specification<Route> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                    Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                    buildSpecification(criteria.getId(), Route_.id),
                    buildStringSpecification(criteria.getRouteName(), Route_.routeName),
                    buildStringSpecification(criteria.getOrigin(), Route_.origin),
                    buildStringSpecification(criteria.getDestination(), Route_.destination),
                    buildRangeSpecification(criteria.getDistance(), Route_.distance),
                    buildRangeSpecification(criteria.getEstimatedDuration(), Route_.estimatedDuration),
                    buildSpecification(criteria.getTransportType(), Route_.transportType),
                    buildSpecification(criteria.getIsActive(), Route_.isActive),
                    buildRangeSpecification(criteria.getCreatedAt(), Route_.createdAt),
                    buildRangeSpecification(criteria.getUpdatedAt(), Route_.updatedAt),
                    buildSpecification(criteria.getRouteNameId(),
                            root -> root.join(Route_.routeNames, JoinType.LEFT).get(Schedule_.id)));
        }
        return specification;
    }
}
