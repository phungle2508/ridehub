package com.ridehub.route.service;

import com.ridehub.route.domain.*; // for static metamodels
import com.ridehub.route.domain.SeatLock;
import com.ridehub.route.repository.SeatLockRepository;
import com.ridehub.route.service.criteria.SeatLockCriteria;
import com.ridehub.route.service.dto.SeatLockDTO;
import com.ridehub.route.service.mapper.SeatLockMapper;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link SeatLock} entities in the database.
 * The main input is a {@link SeatLockCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link SeatLockDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class SeatLockQueryService extends QueryService<SeatLock> {

    private static final Logger LOG = LoggerFactory.getLogger(SeatLockQueryService.class);

    private final SeatLockRepository seatLockRepository;

    private final SeatLockMapper seatLockMapper;

    public SeatLockQueryService(SeatLockRepository seatLockRepository, SeatLockMapper seatLockMapper) {
        this.seatLockRepository = seatLockRepository;
        this.seatLockMapper = seatLockMapper;
    }

    /**
     * Return a {@link List} of {@link SeatLockDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<SeatLockDTO> findByCriteria(SeatLockCriteria criteria) {
        LOG.debug("find by criteria : {}", criteria);
        final Specification<SeatLock> specification = createSpecification(criteria);
        return seatLockMapper.toDto(seatLockRepository.findAll(specification));
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(SeatLockCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<SeatLock> specification = createSpecification(criteria);
        return seatLockRepository.count(specification);
    }

    /**
     * Function to convert {@link SeatLockCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<SeatLock> createSpecification(SeatLockCriteria criteria) {
        Specification<SeatLock> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                buildRangeSpecification(criteria.getId(), SeatLock_.id),
                buildSpecification(criteria.getTripId(), SeatLock_.tripId),
                buildStringSpecification(criteria.getSeatNo(), SeatLock_.seatNo),
                buildSpecification(criteria.getUserId(), SeatLock_.userId),
                buildSpecification(criteria.getStatus(), SeatLock_.status),
                buildRangeSpecification(criteria.getExpiresAt(), SeatLock_.expiresAt),
                buildStringSpecification(criteria.getIdempotencyKey(), SeatLock_.idempotencyKey),
                buildRangeSpecification(criteria.getCreatedAt(), SeatLock_.createdAt),
                buildRangeSpecification(criteria.getUpdatedAt(), SeatLock_.updatedAt),
                buildSpecification(criteria.getIsDeleted(), SeatLock_.isDeleted),
                buildRangeSpecification(criteria.getDeletedAt(), SeatLock_.deletedAt),
                buildSpecification(criteria.getDeletedBy(), SeatLock_.deletedBy)
            );
        }
        return specification;
    }
}
