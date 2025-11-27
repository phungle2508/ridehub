package com.ridehub.promotion.service;

import com.ridehub.promotion.domain.*; // for static metamodels
import com.ridehub.promotion.domain.PercentOffTotal;
import com.ridehub.promotion.repository.PercentOffTotalRepository;
import com.ridehub.promotion.service.criteria.PercentOffTotalCriteria;
import com.ridehub.promotion.service.dto.PercentOffTotalDTO;
import com.ridehub.promotion.service.mapper.PercentOffTotalMapper;
import jakarta.persistence.criteria.JoinType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link PercentOffTotal} entities in the database.
 * The main input is a {@link PercentOffTotalCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link PercentOffTotalDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class PercentOffTotalQueryService extends QueryService<PercentOffTotal> {

    private static final Logger LOG = LoggerFactory.getLogger(PercentOffTotalQueryService.class);

    private final PercentOffTotalRepository percentOffTotalRepository;

    private final PercentOffTotalMapper percentOffTotalMapper;

    public PercentOffTotalQueryService(PercentOffTotalRepository percentOffTotalRepository, PercentOffTotalMapper percentOffTotalMapper) {
        this.percentOffTotalRepository = percentOffTotalRepository;
        this.percentOffTotalMapper = percentOffTotalMapper;
    }

    /**
     * Return a {@link List} of {@link PercentOffTotalDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<PercentOffTotalDTO> findByCriteria(PercentOffTotalCriteria criteria) {
        LOG.debug("find by criteria : {}", criteria);
        final Specification<PercentOffTotal> specification = createSpecification(criteria);
        return percentOffTotalMapper.toDto(percentOffTotalRepository.findAll(specification));
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(PercentOffTotalCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<PercentOffTotal> specification = createSpecification(criteria);
        return percentOffTotalRepository.count(specification);
    }

    /**
     * Function to convert {@link PercentOffTotalCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<PercentOffTotal> createSpecification(PercentOffTotalCriteria criteria) {
        Specification<PercentOffTotal> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                buildRangeSpecification(criteria.getId(), PercentOffTotal_.id),
                buildRangeSpecification(criteria.getPercent(), PercentOffTotal_.percent),
                buildRangeSpecification(criteria.getMaxOff(), PercentOffTotal_.maxOff),
                buildRangeSpecification(criteria.getMinPrice(), PercentOffTotal_.minPrice),
                buildRangeSpecification(criteria.getCreatedAt(), PercentOffTotal_.createdAt),
                buildRangeSpecification(criteria.getUpdatedAt(), PercentOffTotal_.updatedAt),
                buildSpecification(criteria.getIsDeleted(), PercentOffTotal_.isDeleted),
                buildRangeSpecification(criteria.getDeletedAt(), PercentOffTotal_.deletedAt),
                buildSpecification(criteria.getDeletedBy(), PercentOffTotal_.deletedBy),
                buildSpecification(criteria.getPromotionId(), root ->
                    root.join(PercentOffTotal_.promotion, JoinType.LEFT).get(Promotion_.id)
                )
            );
        }
        return specification;
    }
}
