package com.ticketsystem.route.service;

import com.ticketsystem.route.domain.*; // for static metamodels
import com.ticketsystem.route.domain.Trip;
import com.ticketsystem.route.repository.TripRepository;
import com.ticketsystem.route.service.criteria.TripCriteria;
import com.ticketsystem.route.service.dto.TripDTO;
import com.ticketsystem.route.service.mapper.TripMapper;
import jakarta.persistence.criteria.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link Trip} entities in the database.
 * The main input is a {@link TripCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link Page} of {@link TripDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class TripQueryService extends QueryService<Trip> {

    private static final Logger LOG = LoggerFactory.getLogger(TripQueryService.class);

    private final TripRepository tripRepository;

    private final TripMapper tripMapper;

    public TripQueryService(TripRepository tripRepository, TripMapper tripMapper) {
        this.tripRepository = tripRepository;
        this.tripMapper = tripMapper;
    }

    /**
     * Return a {@link Page} of {@link TripDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<TripDTO> findByCriteria(TripCriteria criteria, Pageable page) {
        LOG.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Trip> specification = createSpecification(criteria);
        return tripRepository.findAll(specification, page).map(tripMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(TripCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<Trip> specification = createSpecification(criteria);
        return tripRepository.count(specification);
    }

    /**
     * Function to convert {@link TripCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Trip> createSpecification(TripCriteria criteria) {
        Specification<Trip> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                buildRangeSpecification(criteria.getId(), Trip_.id),
                buildRangeSpecification(criteria.getDepartureTime(), Trip_.departureTime),
                buildRangeSpecification(criteria.getArrivalTime(), Trip_.arrivalTime),
                buildRangeSpecification(criteria.getAvailableSeats(), Trip_.availableSeats),
                buildRangeSpecification(criteria.getTotalSeats(), Trip_.totalSeats),
                buildStringSpecification(criteria.getStatus(), Trip_.status),
                buildSpecification(criteria.getDriverId(), Trip_.driverId),
                buildSpecification(criteria.getSeatsId(), root -> root.join(Trip_.seats, JoinType.LEFT).get(Seat_.id)),
                buildSpecification(criteria.getRouteId(), root -> root.join(Trip_.route, JoinType.LEFT).get(Route_.id))
            );
        }
        return specification;
    }
}
