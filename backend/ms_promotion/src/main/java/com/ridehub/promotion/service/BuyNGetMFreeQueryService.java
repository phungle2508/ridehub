package com.ridehub.promotion.service;

import com.ridehub.promotion.domain.*; // for static metamodels
import com.ridehub.promotion.domain.BuyNGetMFree;
import com.ridehub.promotion.repository.BuyNGetMFreeRepository;
import com.ridehub.promotion.service.criteria.BuyNGetMFreeCriteria;
import com.ridehub.promotion.service.dto.BuyNGetMFreeDTO;
import com.ridehub.promotion.service.mapper.BuyNGetMFreeMapper;
import jakarta.persistence.criteria.JoinType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link BuyNGetMFree} entities in the database.
 * The main input is a {@link BuyNGetMFreeCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link BuyNGetMFreeDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class BuyNGetMFreeQueryService extends QueryService<BuyNGetMFree> {

    private static final Logger LOG = LoggerFactory.getLogger(BuyNGetMFreeQueryService.class);

    private final BuyNGetMFreeRepository buyNGetMFreeRepository;

    private final BuyNGetMFreeMapper buyNGetMFreeMapper;

    public BuyNGetMFreeQueryService(BuyNGetMFreeRepository buyNGetMFreeRepository, BuyNGetMFreeMapper buyNGetMFreeMapper) {
        this.buyNGetMFreeRepository = buyNGetMFreeRepository;
        this.buyNGetMFreeMapper = buyNGetMFreeMapper;
    }

    /**
     * Return a {@link List} of {@link BuyNGetMFreeDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<BuyNGetMFreeDTO> findByCriteria(BuyNGetMFreeCriteria criteria) {
        LOG.debug("find by criteria : {}", criteria);
        final Specification<BuyNGetMFree> specification = createSpecification(criteria);
        return buyNGetMFreeMapper.toDto(buyNGetMFreeRepository.findAll(specification));
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(BuyNGetMFreeCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<BuyNGetMFree> specification = createSpecification(criteria);
        return buyNGetMFreeRepository.count(specification);
    }

    /**
     * Function to convert {@link BuyNGetMFreeCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<BuyNGetMFree> createSpecification(BuyNGetMFreeCriteria criteria) {
        Specification<BuyNGetMFree> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                buildRangeSpecification(criteria.getId(), BuyNGetMFree_.id),
                buildRangeSpecification(criteria.getBuyN(), BuyNGetMFree_.buyN),
                buildRangeSpecification(criteria.getGetM(), BuyNGetMFree_.getM),
                buildRangeSpecification(criteria.getCreatedAt(), BuyNGetMFree_.createdAt),
                buildRangeSpecification(criteria.getUpdatedAt(), BuyNGetMFree_.updatedAt),
                buildSpecification(criteria.getIsDeleted(), BuyNGetMFree_.isDeleted),
                buildRangeSpecification(criteria.getDeletedAt(), BuyNGetMFree_.deletedAt),
                buildSpecification(criteria.getDeletedBy(), BuyNGetMFree_.deletedBy),
                buildSpecification(criteria.getPromotionId(), root -> root.join(BuyNGetMFree_.promotion, JoinType.LEFT).get(Promotion_.id))
            );
        }
        return specification;
    }
}
