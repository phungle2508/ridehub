package com.ridehub.route.service;

import com.ridehub.route.domain.*; // for static metamodels
import com.ridehub.route.domain.SeatMap;
import com.ridehub.route.repository.SeatMapRepository;
import com.ridehub.route.service.criteria.SeatMapCriteria;
import com.ridehub.route.service.dto.SeatMapDTO;
import com.ridehub.route.service.mapper.SeatMapMapper;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link SeatMap} entities in the database.
 * The main input is a {@link SeatMapCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link SeatMapDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class SeatMapQueryService extends QueryService<SeatMap> {

    private static final Logger LOG = LoggerFactory.getLogger(SeatMapQueryService.class);

    private final SeatMapRepository seatMapRepository;

    private final SeatMapMapper seatMapMapper;

    public SeatMapQueryService(SeatMapRepository seatMapRepository, SeatMapMapper seatMapMapper) {
        this.seatMapRepository = seatMapRepository;
        this.seatMapMapper = seatMapMapper;
    }

    /**
     * Return a {@link List} of {@link SeatMapDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<SeatMapDTO> findByCriteria(SeatMapCriteria criteria) {
        LOG.debug("find by criteria : {}", criteria);
        final Specification<SeatMap> specification = createSpecification(criteria);
        return seatMapMapper.toDto(seatMapRepository.findAll(specification));
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(SeatMapCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<SeatMap> specification = createSpecification(criteria);
        return seatMapRepository.count(specification);
    }

    /**
     * Function to convert {@link SeatMapCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<SeatMap> createSpecification(SeatMapCriteria criteria) {
        Specification<SeatMap> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                buildRangeSpecification(criteria.getId(), SeatMap_.id),
                buildStringSpecification(criteria.getName(), SeatMap_.name),
                buildRangeSpecification(criteria.getCreatedAt(), SeatMap_.createdAt),
                buildRangeSpecification(criteria.getUpdatedAt(), SeatMap_.updatedAt),
                buildSpecification(criteria.getIsDeleted(), SeatMap_.isDeleted),
                buildRangeSpecification(criteria.getDeletedAt(), SeatMap_.deletedAt),
                buildSpecification(criteria.getDeletedBy(), SeatMap_.deletedBy)
            );
        }
        return specification;
    }
}
