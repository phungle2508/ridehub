package com.ridehub.promotion.service;

import com.ridehub.promotion.domain.*; // for static metamodels
import com.ridehub.promotion.domain.ConditionByLocation;
import com.ridehub.promotion.repository.ConditionByLocationRepository;
import com.ridehub.promotion.service.criteria.ConditionByLocationCriteria;
import com.ridehub.promotion.service.dto.ConditionByLocationDTO;
import com.ridehub.promotion.service.mapper.ConditionByLocationMapper;
import jakarta.persistence.criteria.JoinType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link ConditionByLocation} entities in the database.
 * The main input is a {@link ConditionByLocationCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ConditionByLocationDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ConditionByLocationQueryService extends QueryService<ConditionByLocation> {

    private static final Logger LOG = LoggerFactory.getLogger(ConditionByLocationQueryService.class);

    private final ConditionByLocationRepository conditionByLocationRepository;

    private final ConditionByLocationMapper conditionByLocationMapper;

    public ConditionByLocationQueryService(
        ConditionByLocationRepository conditionByLocationRepository,
        ConditionByLocationMapper conditionByLocationMapper
    ) {
        this.conditionByLocationRepository = conditionByLocationRepository;
        this.conditionByLocationMapper = conditionByLocationMapper;
    }

    /**
     * Return a {@link List} of {@link ConditionByLocationDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ConditionByLocationDTO> findByCriteria(ConditionByLocationCriteria criteria) {
        LOG.debug("find by criteria : {}", criteria);
        final Specification<ConditionByLocation> specification = createSpecification(criteria);
        return conditionByLocationMapper.toDto(conditionByLocationRepository.findAll(specification));
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(ConditionByLocationCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<ConditionByLocation> specification = createSpecification(criteria);
        return conditionByLocationRepository.count(specification);
    }

    /**
     * Function to convert {@link ConditionByLocationCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<ConditionByLocation> createSpecification(ConditionByLocationCriteria criteria) {
        Specification<ConditionByLocation> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                buildRangeSpecification(criteria.getId(), ConditionByLocation_.id),
                buildSpecification(criteria.getProvinceId(), ConditionByLocation_.provinceId),
                buildSpecification(criteria.getDistrictId(), ConditionByLocation_.districtId),
                buildSpecification(criteria.getWardId(), ConditionByLocation_.wardId),
                buildRangeSpecification(criteria.getCreatedAt(), ConditionByLocation_.createdAt),
                buildRangeSpecification(criteria.getUpdatedAt(), ConditionByLocation_.updatedAt),
                buildSpecification(criteria.getIsDeleted(), ConditionByLocation_.isDeleted),
                buildRangeSpecification(criteria.getDeletedAt(), ConditionByLocation_.deletedAt),
                buildSpecification(criteria.getDeletedBy(), ConditionByLocation_.deletedBy),
                buildSpecification(criteria.getPromotionId(), root ->
                    root.join(ConditionByLocation_.promotion, JoinType.LEFT).get(Promotion_.id)
                )
            );
        }
        return specification;
    }
}
