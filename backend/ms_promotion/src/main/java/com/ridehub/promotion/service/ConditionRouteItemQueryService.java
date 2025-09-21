package com.ridehub.promotion.service;

import com.ridehub.promotion.domain.*; // for static metamodels
import com.ridehub.promotion.domain.ConditionRouteItem;
import com.ridehub.promotion.repository.ConditionRouteItemRepository;
import com.ridehub.promotion.service.criteria.ConditionRouteItemCriteria;
import com.ridehub.promotion.service.dto.ConditionRouteItemDTO;
import com.ridehub.promotion.service.mapper.ConditionRouteItemMapper;
import jakarta.persistence.criteria.JoinType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link ConditionRouteItem} entities in the database.
 * The main input is a {@link ConditionRouteItemCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ConditionRouteItemDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ConditionRouteItemQueryService extends QueryService<ConditionRouteItem> {

    private static final Logger LOG = LoggerFactory.getLogger(ConditionRouteItemQueryService.class);

    private final ConditionRouteItemRepository conditionRouteItemRepository;

    private final ConditionRouteItemMapper conditionRouteItemMapper;

    public ConditionRouteItemQueryService(
        ConditionRouteItemRepository conditionRouteItemRepository,
        ConditionRouteItemMapper conditionRouteItemMapper
    ) {
        this.conditionRouteItemRepository = conditionRouteItemRepository;
        this.conditionRouteItemMapper = conditionRouteItemMapper;
    }

    /**
     * Return a {@link List} of {@link ConditionRouteItemDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ConditionRouteItemDTO> findByCriteria(ConditionRouteItemCriteria criteria) {
        LOG.debug("find by criteria : {}", criteria);
        final Specification<ConditionRouteItem> specification = createSpecification(criteria);
        return conditionRouteItemMapper.toDto(conditionRouteItemRepository.findAll(specification));
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(ConditionRouteItemCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<ConditionRouteItem> specification = createSpecification(criteria);
        return conditionRouteItemRepository.count(specification);
    }

    /**
     * Function to convert {@link ConditionRouteItemCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<ConditionRouteItem> createSpecification(ConditionRouteItemCriteria criteria) {
        Specification<ConditionRouteItem> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                buildRangeSpecification(criteria.getId(), ConditionRouteItem_.id),
                buildSpecification(criteria.getRouteId(), ConditionRouteItem_.routeId),
                buildRangeSpecification(criteria.getCreatedAt(), ConditionRouteItem_.createdAt),
                buildRangeSpecification(criteria.getUpdatedAt(), ConditionRouteItem_.updatedAt),
                buildSpecification(criteria.getIsDeleted(), ConditionRouteItem_.isDeleted),
                buildRangeSpecification(criteria.getDeletedAt(), ConditionRouteItem_.deletedAt),
                buildSpecification(criteria.getDeletedBy(), ConditionRouteItem_.deletedBy),
                buildSpecification(criteria.getConditionId(), root ->
                    root.join(ConditionRouteItem_.condition, JoinType.LEFT).get(ConditionByRoute_.id)
                )
            );
        }
        return specification;
    }
}
