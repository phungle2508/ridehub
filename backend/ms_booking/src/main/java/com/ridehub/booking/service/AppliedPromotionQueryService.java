package com.ridehub.booking.service;

import com.ridehub.booking.domain.*; // for static metamodels
import com.ridehub.booking.domain.AppliedPromotion;
import com.ridehub.booking.repository.AppliedPromotionRepository;
import com.ridehub.booking.service.criteria.AppliedPromotionCriteria;
import com.ridehub.booking.service.dto.AppliedPromotionDTO;
import com.ridehub.booking.service.mapper.AppliedPromotionMapper;
import jakarta.persistence.criteria.JoinType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link AppliedPromotion} entities in the database.
 * The main input is a {@link AppliedPromotionCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link AppliedPromotionDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class AppliedPromotionQueryService extends QueryService<AppliedPromotion> {

    private static final Logger LOG = LoggerFactory.getLogger(AppliedPromotionQueryService.class);

    private final AppliedPromotionRepository appliedPromotionRepository;

    private final AppliedPromotionMapper appliedPromotionMapper;

    public AppliedPromotionQueryService(
        AppliedPromotionRepository appliedPromotionRepository,
        AppliedPromotionMapper appliedPromotionMapper
    ) {
        this.appliedPromotionRepository = appliedPromotionRepository;
        this.appliedPromotionMapper = appliedPromotionMapper;
    }

    /**
     * Return a {@link List} of {@link AppliedPromotionDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<AppliedPromotionDTO> findByCriteria(AppliedPromotionCriteria criteria) {
        LOG.debug("find by criteria : {}", criteria);
        final Specification<AppliedPromotion> specification = createSpecification(criteria);
        return appliedPromotionMapper.toDto(appliedPromotionRepository.findAll(specification));
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(AppliedPromotionCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<AppliedPromotion> specification = createSpecification(criteria);
        return appliedPromotionRepository.count(specification);
    }

    /**
     * Function to convert {@link AppliedPromotionCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<AppliedPromotion> createSpecification(AppliedPromotionCriteria criteria) {
        Specification<AppliedPromotion> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                buildRangeSpecification(criteria.getId(), AppliedPromotion_.id),
                buildSpecification(criteria.getPromotionId(), AppliedPromotion_.promotionId),
                buildStringSpecification(criteria.getPromotionCode(), AppliedPromotion_.promotionCode),
                buildRangeSpecification(criteria.getDiscountAmount(), AppliedPromotion_.discountAmount),
                buildRangeSpecification(criteria.getAppliedAt(), AppliedPromotion_.appliedAt),
                buildRangeSpecification(criteria.getCreatedAt(), AppliedPromotion_.createdAt),
                buildRangeSpecification(criteria.getUpdatedAt(), AppliedPromotion_.updatedAt),
                buildSpecification(criteria.getIsDeleted(), AppliedPromotion_.isDeleted),
                buildRangeSpecification(criteria.getDeletedAt(), AppliedPromotion_.deletedAt),
                buildSpecification(criteria.getDeletedBy(), AppliedPromotion_.deletedBy),
                buildSpecification(criteria.getBookingId(), root -> root.join(AppliedPromotion_.booking, JoinType.LEFT).get(Booking_.id))
            );
        }
        return specification;
    }
}
