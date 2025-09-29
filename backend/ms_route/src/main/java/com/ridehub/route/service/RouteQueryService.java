package com.ridehub.route.service;

import com.ridehub.route.domain.*; // for static metamodels
import com.ridehub.route.domain.Route;
import com.ridehub.route.domain.Trip;
import com.ridehub.route.domain.enumeration.VehicleType;
import com.ridehub.route.repository.RouteRepository;
import com.ridehub.route.repository.TripRepository;
import com.ridehub.route.repository.search.RouteSearchRepository;
import com.ridehub.route.service.criteria.RouteCriteria;
import com.ridehub.route.service.dto.RouteDTO;
import com.ridehub.route.service.dto.TripDetailDTO;
import com.ridehub.route.service.mapper.RouteMapper;
import jakarta.persistence.criteria.JoinType;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link Route} entities in the database.
 * The main input is a {@link RouteCriteria} which gets converted to {@link Specification},
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

    private final TripRepository tripRepository;

    public RouteQueryService(RouteRepository routeRepository, RouteMapper routeMapper, RouteSearchRepository routeSearchRepository, TripRepository tripRepository) {
        this.routeRepository = routeRepository;
        this.routeMapper = routeMapper;
        this.routeSearchRepository = routeSearchRepository;
        this.tripRepository = tripRepository;
    }

    /**
     * Return a {@link Page} of {@link RouteDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<RouteDTO> findByCriteria(RouteCriteria criteria, Pageable page) {
        LOG.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Route> specification = createSpecification(criteria);
        return routeRepository.findAll(specification, page).map(routeMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
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
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Route> createSpecification(RouteCriteria criteria) {
        Specification<Route> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                buildRangeSpecification(criteria.getId(), Route_.id),
                buildStringSpecification(criteria.getRouteCode(), Route_.routeCode),
                buildRangeSpecification(criteria.getDistanceKm(), Route_.distanceKm),
                buildRangeSpecification(criteria.getCreatedAt(), Route_.createdAt),
                buildRangeSpecification(criteria.getUpdatedAt(), Route_.updatedAt),
                buildSpecification(criteria.getIsDeleted(), Route_.isDeleted),
                buildRangeSpecification(criteria.getDeletedAt(), Route_.deletedAt),
                buildSpecification(criteria.getDeletedBy(), Route_.deletedBy),
                buildSpecification(criteria.getOriginId(), root -> root.join(Route_.origin, JoinType.LEFT).get(Station_.id)),
                buildSpecification(criteria.getDestinationId(), root -> root.join(Route_.destination, JoinType.LEFT).get(Station_.id))
            );
        }
        return specification;
    }
}
