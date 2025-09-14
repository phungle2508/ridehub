package com.ticketsystem.route.service;

import com.ticketsystem.route.domain.*; // for static metamodels
import com.ticketsystem.route.domain.Seat;
import com.ticketsystem.route.repository.SeatRepository;
import com.ticketsystem.route.service.criteria.SeatCriteria;
import com.ticketsystem.route.service.dto.SeatDTO;
import com.ticketsystem.route.service.mapper.SeatMapper;
import jakarta.persistence.criteria.JoinType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link Seat} entities in the database.
 * The main input is a {@link SeatCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link SeatDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class SeatQueryService extends QueryService<Seat> {

    private static final Logger LOG = LoggerFactory.getLogger(SeatQueryService.class);

    private final SeatRepository seatRepository;

    private final SeatMapper seatMapper;

    public SeatQueryService(SeatRepository seatRepository, SeatMapper seatMapper) {
        this.seatRepository = seatRepository;
        this.seatMapper = seatMapper;
    }

    /**
     * Return a {@link List} of {@link SeatDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<SeatDTO> findByCriteria(SeatCriteria criteria) {
        LOG.debug("find by criteria : {}", criteria);
        final Specification<Seat> specification = createSpecification(criteria);
        return seatMapper.toDto(seatRepository.findAll(specification));
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(SeatCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<Seat> specification = createSpecification(criteria);
        return seatRepository.count(specification);
    }

    /**
     * Function to convert {@link SeatCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Seat> createSpecification(SeatCriteria criteria) {
        Specification<Seat> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                buildRangeSpecification(criteria.getId(), Seat_.id),
                buildStringSpecification(criteria.getSeatNumber(), Seat_.seatNumber),
                buildSpecification(criteria.getSeatType(), Seat_.seatType),
                buildStringSpecification(criteria.getDeck(), Seat_.deck),
                buildRangeSpecification(criteria.getPriceModifier(), Seat_.priceModifier),
                buildSpecification(criteria.getIsAvailable(), Seat_.isAvailable),
                buildSpecification(criteria.getTripId(), root -> root.join(Seat_.trip, JoinType.LEFT).get(Trip_.id))
            );
        }
        return specification;
    }
}
