package com.ridehub.promotion.service;

import com.ridehub.promotion.domain.*; // for static metamodels
import com.ridehub.promotion.domain.ConditionDateItem;
import com.ridehub.promotion.repository.ConditionDateItemRepository;
import com.ridehub.promotion.service.criteria.ConditionDateItemCriteria;
import com.ridehub.promotion.service.dto.ConditionDateItemDTO;
import com.ridehub.promotion.service.mapper.ConditionDateItemMapper;
import jakarta.persistence.criteria.JoinType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link ConditionDateItem} entities in the database.
 * The main input is a {@link ConditionDateItemCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ConditionDateItemDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ConditionDateItemQueryService extends QueryService<ConditionDateItem> {

    private static final Logger LOG = LoggerFactory.getLogger(ConditionDateItemQueryService.class);

    private final ConditionDateItemRepository conditionDateItemRepository;

    private final ConditionDateItemMapper conditionDateItemMapper;

    public ConditionDateItemQueryService(
        ConditionDateItemRepository conditionDateItemRepository,
        ConditionDateItemMapper conditionDateItemMapper
    ) {
        this.conditionDateItemRepository = conditionDateItemRepository;
        this.conditionDateItemMapper = conditionDateItemMapper;
    }

    /**
     * Return a {@link List} of {@link ConditionDateItemDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ConditionDateItemDTO> findByCriteria(ConditionDateItemCriteria criteria) {
        LOG.debug("find by criteria : {}", criteria);
        final Specification<ConditionDateItem> specification = createSpecification(criteria);
        return conditionDateItemMapper.toDto(conditionDateItemRepository.findAll(specification));
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(ConditionDateItemCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<ConditionDateItem> specification = createSpecification(criteria);
        return conditionDateItemRepository.count(specification);
    }

    /**
     * Function to convert {@link ConditionDateItemCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<ConditionDateItem> createSpecification(ConditionDateItemCriteria criteria) {
        Specification<ConditionDateItem> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                buildRangeSpecification(criteria.getId(), ConditionDateItem_.id),
                buildRangeSpecification(criteria.getSpecificDate(), ConditionDateItem_.specificDate),
                buildRangeSpecification(criteria.getWeekday(), ConditionDateItem_.weekday),
                buildRangeSpecification(criteria.getCreatedAt(), ConditionDateItem_.createdAt),
                buildRangeSpecification(criteria.getUpdatedAt(), ConditionDateItem_.updatedAt),
                buildSpecification(criteria.getIsDeleted(), ConditionDateItem_.isDeleted),
                buildRangeSpecification(criteria.getDeletedAt(), ConditionDateItem_.deletedAt),
                buildSpecification(criteria.getDeletedBy(), ConditionDateItem_.deletedBy),
                buildSpecification(criteria.getConditionId(), root ->
                    root.join(ConditionDateItem_.condition, JoinType.LEFT).get(ConditionByDate_.id)
                )
            );
        }
        return specification;
    }
}
