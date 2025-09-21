package com.ridehub.promotion.service;

import com.ridehub.promotion.domain.*; // for static metamodels
import com.ridehub.promotion.domain.ConditionByRoute;
import com.ridehub.promotion.repository.ConditionByRouteRepository;
import com.ridehub.promotion.service.criteria.ConditionByRouteCriteria;
import com.ridehub.promotion.service.dto.ConditionByRouteDTO;
import com.ridehub.promotion.service.mapper.ConditionByRouteMapper;
import jakarta.persistence.criteria.JoinType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link ConditionByRoute} entities in the database.
 * The main input is a {@link ConditionByRouteCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ConditionByRouteDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ConditionByRouteQueryService extends QueryService<ConditionByRoute> {

    private static final Logger LOG = LoggerFactory.getLogger(ConditionByRouteQueryService.class);

    private final ConditionByRouteRepository conditionByRouteRepository;

    private final ConditionByRouteMapper conditionByRouteMapper;

    public ConditionByRouteQueryService(
        ConditionByRouteRepository conditionByRouteRepository,
        ConditionByRouteMapper conditionByRouteMapper
    ) {
        this.conditionByRouteRepository = conditionByRouteRepository;
        this.conditionByRouteMapper = conditionByRouteMapper;
    }

    /**
     * Return a {@link List} of {@link ConditionByRouteDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ConditionByRouteDTO> findByCriteria(ConditionByRouteCriteria criteria) {
        LOG.debug("find by criteria : {}", criteria);
        final Specification<ConditionByRoute> specification = createSpecification(criteria);
        return conditionByRouteMapper.toDto(conditionByRouteRepository.findAll(specification));
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(ConditionByRouteCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<ConditionByRoute> specification = createSpecification(criteria);
        return conditionByRouteRepository.count(specification);
    }

    /**
     * Function to convert {@link ConditionByRouteCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<ConditionByRoute> createSpecification(ConditionByRouteCriteria criteria) {
        Specification<ConditionByRoute> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                buildRangeSpecification(criteria.getId(), ConditionByRoute_.id),
                buildSpecification(criteria.getRouteId(), ConditionByRoute_.routeId),
                buildRangeSpecification(criteria.getCreatedAt(), ConditionByRoute_.createdAt),
                buildRangeSpecification(criteria.getUpdatedAt(), ConditionByRoute_.updatedAt),
                buildSpecification(criteria.getIsDeleted(), ConditionByRoute_.isDeleted),
                buildRangeSpecification(criteria.getDeletedAt(), ConditionByRoute_.deletedAt),
                buildSpecification(criteria.getDeletedBy(), ConditionByRoute_.deletedBy),
                buildSpecification(criteria.getPromotionId(), root ->
                    root.join(ConditionByRoute_.promotion, JoinType.LEFT).get(Promotion_.id)
                )
            );
        }
        return specification;
    }
}
