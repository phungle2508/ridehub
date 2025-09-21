package com.ridehub.promotion.service;

import com.ridehub.promotion.domain.*; // for static metamodels
import com.ridehub.promotion.domain.ConditionByDate;
import com.ridehub.promotion.repository.ConditionByDateRepository;
import com.ridehub.promotion.service.criteria.ConditionByDateCriteria;
import com.ridehub.promotion.service.dto.ConditionByDateDTO;
import com.ridehub.promotion.service.mapper.ConditionByDateMapper;
import jakarta.persistence.criteria.JoinType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link ConditionByDate} entities in the database.
 * The main input is a {@link ConditionByDateCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ConditionByDateDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ConditionByDateQueryService extends QueryService<ConditionByDate> {

    private static final Logger LOG = LoggerFactory.getLogger(ConditionByDateQueryService.class);

    private final ConditionByDateRepository conditionByDateRepository;

    private final ConditionByDateMapper conditionByDateMapper;

    public ConditionByDateQueryService(ConditionByDateRepository conditionByDateRepository, ConditionByDateMapper conditionByDateMapper) {
        this.conditionByDateRepository = conditionByDateRepository;
        this.conditionByDateMapper = conditionByDateMapper;
    }

    /**
     * Return a {@link List} of {@link ConditionByDateDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ConditionByDateDTO> findByCriteria(ConditionByDateCriteria criteria) {
        LOG.debug("find by criteria : {}", criteria);
        final Specification<ConditionByDate> specification = createSpecification(criteria);
        return conditionByDateMapper.toDto(conditionByDateRepository.findAll(specification));
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(ConditionByDateCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<ConditionByDate> specification = createSpecification(criteria);
        return conditionByDateRepository.count(specification);
    }

    /**
     * Function to convert {@link ConditionByDateCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<ConditionByDate> createSpecification(ConditionByDateCriteria criteria) {
        Specification<ConditionByDate> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                buildRangeSpecification(criteria.getId(), ConditionByDate_.id),
                buildRangeSpecification(criteria.getSpecificDate(), ConditionByDate_.specificDate),
                buildRangeSpecification(criteria.getWeekday(), ConditionByDate_.weekday),
                buildRangeSpecification(criteria.getCreatedAt(), ConditionByDate_.createdAt),
                buildRangeSpecification(criteria.getUpdatedAt(), ConditionByDate_.updatedAt),
                buildSpecification(criteria.getIsDeleted(), ConditionByDate_.isDeleted),
                buildRangeSpecification(criteria.getDeletedAt(), ConditionByDate_.deletedAt),
                buildSpecification(criteria.getDeletedBy(), ConditionByDate_.deletedBy),
                buildSpecification(criteria.getPromotionId(), root ->
                    root.join(ConditionByDate_.promotion, JoinType.LEFT).get(Promotion_.id)
                )
            );
        }
        return specification;
    }
}
