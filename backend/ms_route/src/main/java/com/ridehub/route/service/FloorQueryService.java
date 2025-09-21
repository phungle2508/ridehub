package com.ridehub.route.service;

import com.ridehub.route.domain.*; // for static metamodels
import com.ridehub.route.domain.Floor;
import com.ridehub.route.repository.FloorRepository;
import com.ridehub.route.service.criteria.FloorCriteria;
import com.ridehub.route.service.dto.FloorDTO;
import com.ridehub.route.service.mapper.FloorMapper;
import jakarta.persistence.criteria.JoinType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link Floor} entities in the database.
 * The main input is a {@link FloorCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link FloorDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class FloorQueryService extends QueryService<Floor> {

    private static final Logger LOG = LoggerFactory.getLogger(FloorQueryService.class);

    private final FloorRepository floorRepository;

    private final FloorMapper floorMapper;

    public FloorQueryService(FloorRepository floorRepository, FloorMapper floorMapper) {
        this.floorRepository = floorRepository;
        this.floorMapper = floorMapper;
    }

    /**
     * Return a {@link List} of {@link FloorDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<FloorDTO> findByCriteria(FloorCriteria criteria) {
        LOG.debug("find by criteria : {}", criteria);
        final Specification<Floor> specification = createSpecification(criteria);
        return floorMapper.toDto(floorRepository.findAll(specification));
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(FloorCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<Floor> specification = createSpecification(criteria);
        return floorRepository.count(specification);
    }

    /**
     * Function to convert {@link FloorCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Floor> createSpecification(FloorCriteria criteria) {
        Specification<Floor> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                buildRangeSpecification(criteria.getId(), Floor_.id),
                buildRangeSpecification(criteria.getFloorNo(), Floor_.floorNo),
                buildRangeSpecification(criteria.getPriceFactorFloor(), Floor_.priceFactorFloor),
                buildRangeSpecification(criteria.getCreatedAt(), Floor_.createdAt),
                buildRangeSpecification(criteria.getUpdatedAt(), Floor_.updatedAt),
                buildSpecification(criteria.getIsDeleted(), Floor_.isDeleted),
                buildRangeSpecification(criteria.getDeletedAt(), Floor_.deletedAt),
                buildSpecification(criteria.getDeletedBy(), Floor_.deletedBy),
                buildSpecification(criteria.getSeatMapId(), root -> root.join(Floor_.seatMap, JoinType.LEFT).get(SeatMap_.id))
            );
        }
        return specification;
    }
}
