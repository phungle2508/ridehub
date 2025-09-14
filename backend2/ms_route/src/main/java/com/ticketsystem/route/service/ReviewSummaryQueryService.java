package com.ticketsystem.route.service;

import com.ticketsystem.route.domain.*; // for static metamodels
import com.ticketsystem.route.domain.ReviewSummary;
import com.ticketsystem.route.repository.ReviewSummaryRepository;
import com.ticketsystem.route.service.criteria.ReviewSummaryCriteria;
import com.ticketsystem.route.service.dto.ReviewSummaryDTO;
import com.ticketsystem.route.service.mapper.ReviewSummaryMapper;
import jakarta.persistence.criteria.JoinType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link ReviewSummary} entities in the database.
 * The main input is a {@link ReviewSummaryCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link ReviewSummaryDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class ReviewSummaryQueryService extends QueryService<ReviewSummary> {

    private static final Logger LOG = LoggerFactory.getLogger(ReviewSummaryQueryService.class);

    private final ReviewSummaryRepository reviewSummaryRepository;

    private final ReviewSummaryMapper reviewSummaryMapper;

    public ReviewSummaryQueryService(ReviewSummaryRepository reviewSummaryRepository, ReviewSummaryMapper reviewSummaryMapper) {
        this.reviewSummaryRepository = reviewSummaryRepository;
        this.reviewSummaryMapper = reviewSummaryMapper;
    }

    /**
     * Return a {@link List} of {@link ReviewSummaryDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<ReviewSummaryDTO> findByCriteria(ReviewSummaryCriteria criteria) {
        LOG.debug("find by criteria : {}", criteria);
        final Specification<ReviewSummary> specification = createSpecification(criteria);
        return reviewSummaryMapper.toDto(reviewSummaryRepository.findAll(specification));
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(ReviewSummaryCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<ReviewSummary> specification = createSpecification(criteria);
        return reviewSummaryRepository.count(specification);
    }

    /**
     * Function to convert {@link ReviewSummaryCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<ReviewSummary> createSpecification(ReviewSummaryCriteria criteria) {
        Specification<ReviewSummary> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                buildRangeSpecification(criteria.getId(), ReviewSummary_.id),
                buildRangeSpecification(criteria.getAverageRating(), ReviewSummary_.averageRating),
                buildRangeSpecification(criteria.getTotalReviews(), ReviewSummary_.totalReviews),
                buildRangeSpecification(criteria.getUpdatedAt(), ReviewSummary_.updatedAt),
                buildSpecification(criteria.getVehicleId(), root -> root.join(ReviewSummary_.vehicle, JoinType.LEFT).get(Vehicle_.id))
            );
        }
        return specification;
    }
}
