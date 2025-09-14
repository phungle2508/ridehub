package com.ticketsystem.route.service;

import com.ticketsystem.route.domain.*; // for static metamodels
import com.ticketsystem.route.domain.VehicleReview;
import com.ticketsystem.route.repository.VehicleReviewRepository;
import com.ticketsystem.route.service.criteria.VehicleReviewCriteria;
import com.ticketsystem.route.service.dto.VehicleReviewDTO;
import com.ticketsystem.route.service.mapper.VehicleReviewMapper;
import jakarta.persistence.criteria.JoinType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link VehicleReview} entities in the database.
 * The main input is a {@link VehicleReviewCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link VehicleReviewDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class VehicleReviewQueryService extends QueryService<VehicleReview> {

    private static final Logger LOG = LoggerFactory.getLogger(VehicleReviewQueryService.class);

    private final VehicleReviewRepository vehicleReviewRepository;

    private final VehicleReviewMapper vehicleReviewMapper;

    public VehicleReviewQueryService(VehicleReviewRepository vehicleReviewRepository, VehicleReviewMapper vehicleReviewMapper) {
        this.vehicleReviewRepository = vehicleReviewRepository;
        this.vehicleReviewMapper = vehicleReviewMapper;
    }

    /**
     * Return a {@link List} of {@link VehicleReviewDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<VehicleReviewDTO> findByCriteria(VehicleReviewCriteria criteria) {
        LOG.debug("find by criteria : {}", criteria);
        final Specification<VehicleReview> specification = createSpecification(criteria);
        return vehicleReviewMapper.toDto(vehicleReviewRepository.findAll(specification));
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(VehicleReviewCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<VehicleReview> specification = createSpecification(criteria);
        return vehicleReviewRepository.count(specification);
    }

    /**
     * Function to convert {@link VehicleReviewCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<VehicleReview> createSpecification(VehicleReviewCriteria criteria) {
        Specification<VehicleReview> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                buildRangeSpecification(criteria.getId(), VehicleReview_.id),
                buildSpecification(criteria.getUserId(), VehicleReview_.userId),
                buildSpecification(criteria.getTripId(), VehicleReview_.tripId),
                buildRangeSpecification(criteria.getRating(), VehicleReview_.rating),
                buildStringSpecification(criteria.getComment(), VehicleReview_.comment),
                buildRangeSpecification(criteria.getCleanliness(), VehicleReview_.cleanliness),
                buildRangeSpecification(criteria.getComfort(), VehicleReview_.comfort),
                buildRangeSpecification(criteria.getPunctuality(), VehicleReview_.punctuality),
                buildRangeSpecification(criteria.getStaffService(), VehicleReview_.staffService),
                buildRangeSpecification(criteria.getCreatedAt(), VehicleReview_.createdAt),
                buildSpecification(criteria.getIsVerified(), VehicleReview_.isVerified),
                buildSpecification(criteria.getVehicleId(), root -> root.join(VehicleReview_.vehicle, JoinType.LEFT).get(Vehicle_.id))
            );
        }
        return specification;
    }
}
