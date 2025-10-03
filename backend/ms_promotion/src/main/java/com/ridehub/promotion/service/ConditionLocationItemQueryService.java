package com.ridehub.promotion.service;

import com.ridehub.promotion.domain.*; // for static metamodels
import com.ridehub.promotion.domain.ConditionLocationItem;
import com.ridehub.promotion.repository.ConditionLocationItemRepository;
import com.ridehub.promotion.service.criteria.ConditionLocationItemCriteria;
import com.ridehub.promotion.service.dto.ConditionLocationItemDTO;
import com.ridehub.promotion.service.mapper.ConditionLocationItemMapper;
import jakarta.persistence.criteria.JoinType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link ConditionLocationItem} entities in the database.
 * The main input is a {@link ConditionLocationItemCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ConditionLocationItemDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ConditionLocationItemQueryService extends QueryService<ConditionLocationItem> {

    private static final Logger LOG = LoggerFactory.getLogger(ConditionLocationItemQueryService.class);

    private final ConditionLocationItemRepository conditionLocationItemRepository;

    private final ConditionLocationItemMapper conditionLocationItemMapper;

    public ConditionLocationItemQueryService(
        ConditionLocationItemRepository conditionLocationItemRepository,
        ConditionLocationItemMapper conditionLocationItemMapper
    ) {
        this.conditionLocationItemRepository = conditionLocationItemRepository;
        this.conditionLocationItemMapper = conditionLocationItemMapper;
    }

    /**
     * Return a {@link List} of {@link ConditionLocationItemDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ConditionLocationItemDTO> findByCriteria(ConditionLocationItemCriteria criteria) {
        LOG.debug("find by criteria : {}", criteria);
        final Specification<ConditionLocationItem> specification = createSpecification(criteria);
        return conditionLocationItemMapper.toDto(conditionLocationItemRepository.findAll(specification));
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(ConditionLocationItemCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<ConditionLocationItem> specification = createSpecification(criteria);
        return conditionLocationItemRepository.count(specification);
    }

    /**
     * Function to convert {@link ConditionLocationItemCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<ConditionLocationItem> createSpecification(ConditionLocationItemCriteria criteria) {
        Specification<ConditionLocationItem> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                buildRangeSpecification(criteria.getId(), ConditionLocationItem_.id),
                buildRangeSpecification(criteria.getProvinceId(), ConditionLocationItem_.provinceId),
                buildRangeSpecification(criteria.getDistrictId(), ConditionLocationItem_.districtId),
                buildRangeSpecification(criteria.getWardId(), ConditionLocationItem_.wardId),
                buildRangeSpecification(criteria.getCreatedAt(), ConditionLocationItem_.createdAt),
                buildRangeSpecification(criteria.getUpdatedAt(), ConditionLocationItem_.updatedAt),
                buildSpecification(criteria.getIsDeleted(), ConditionLocationItem_.isDeleted),
                buildRangeSpecification(criteria.getDeletedAt(), ConditionLocationItem_.deletedAt),
                buildSpecification(criteria.getDeletedBy(), ConditionLocationItem_.deletedBy),
                buildSpecification(criteria.getConditionId(), root ->
                    root.join(ConditionLocationItem_.condition, JoinType.LEFT).get(ConditionByLocation_.id)
                )
            );
        }
        return specification;
    }
}
