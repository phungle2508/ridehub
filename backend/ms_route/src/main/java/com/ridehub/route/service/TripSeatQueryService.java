package com.ridehub.route.service;

import com.ridehub.route.domain.*; // for static metamodels
import com.ridehub.route.domain.TripSeat;
import com.ridehub.route.repository.TripSeatRepository;
import com.ridehub.route.service.criteria.TripSeatCriteria;
import com.ridehub.route.service.dto.TripSeatDTO;
import com.ridehub.route.service.mapper.TripSeatMapper;
import jakarta.persistence.criteria.JoinType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link TripSeat} entities in the database.
 * The main input is a {@link TripSeatCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link TripSeatDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class TripSeatQueryService extends QueryService<TripSeat> {

    private static final Logger LOG = LoggerFactory.getLogger(TripSeatQueryService.class);

    private final TripSeatRepository tripSeatRepository;

    private final TripSeatMapper tripSeatMapper;

    public TripSeatQueryService(TripSeatRepository tripSeatRepository, TripSeatMapper tripSeatMapper) {
        this.tripSeatRepository = tripSeatRepository;
        this.tripSeatMapper = tripSeatMapper;
    }

    /**
     * Return a {@link List} of {@link TripSeatDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<TripSeatDTO> findByCriteria(TripSeatCriteria criteria) {
        LOG.debug("find by criteria : {}", criteria);
        final Specification<TripSeat> specification = createSpecification(criteria);
        return tripSeatMapper.toDto(tripSeatRepository.findAll(specification));
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(TripSeatCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<TripSeat> specification = createSpecification(criteria);
        return tripSeatRepository.count(specification);
    }

    /**
     * Function to convert {@link TripSeatCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<TripSeat> createSpecification(TripSeatCriteria criteria) {
        Specification<TripSeat> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                buildRangeSpecification(criteria.getId(), TripSeat_.id),
                buildStringSpecification(criteria.getSeatNo(), TripSeat_.seatNo),
                buildRangeSpecification(criteria.getFloorNo(), TripSeat_.floorNo),
                buildSpecification(criteria.getBooked(), TripSeat_.booked),
                buildRangeSpecification(criteria.getPriceFactor(), TripSeat_.priceFactor),
                buildRangeSpecification(criteria.getCreatedAt(), TripSeat_.createdAt),
                buildRangeSpecification(criteria.getUpdatedAt(), TripSeat_.updatedAt),
                buildSpecification(criteria.getIsDeleted(), TripSeat_.isDeleted),
                buildRangeSpecification(criteria.getDeletedAt(), TripSeat_.deletedAt),
                buildSpecification(criteria.getDeletedBy(), TripSeat_.deletedBy),
                buildSpecification(criteria.getTripId(), root -> root.join(TripSeat_.trip, JoinType.LEFT).get(Trip_.id))
            );
        }
        return specification;
    }
}
