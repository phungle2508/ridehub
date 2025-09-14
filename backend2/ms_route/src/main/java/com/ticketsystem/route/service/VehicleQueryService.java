package com.ticketsystem.route.service;

import com.ticketsystem.route.domain.*; // for static metamodels
import com.ticketsystem.route.domain.Vehicle;
import com.ticketsystem.route.repository.VehicleRepository;
import com.ticketsystem.route.service.criteria.VehicleCriteria;
import com.ticketsystem.route.service.dto.VehicleDTO;
import com.ticketsystem.route.service.mapper.VehicleMapper;
import jakarta.persistence.criteria.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link Vehicle} entities in the database.
 * The main input is a {@link VehicleCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link Page} of {@link VehicleDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class VehicleQueryService extends QueryService<Vehicle> {

    private static final Logger LOG = LoggerFactory.getLogger(VehicleQueryService.class);

    private final VehicleRepository vehicleRepository;

    private final VehicleMapper vehicleMapper;

    public VehicleQueryService(VehicleRepository vehicleRepository, VehicleMapper vehicleMapper) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleMapper = vehicleMapper;
    }

    /**
     * Return a {@link Page} of {@link VehicleDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<VehicleDTO> findByCriteria(VehicleCriteria criteria, Pageable page) {
        LOG.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Vehicle> specification = createSpecification(criteria);
        return vehicleRepository.findAll(specification, page).map(vehicleMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(VehicleCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<Vehicle> specification = createSpecification(criteria);
        return vehicleRepository.count(specification);
    }

    /**
     * Function to convert {@link VehicleCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Vehicle> createSpecification(VehicleCriteria criteria) {
        Specification<Vehicle> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                buildRangeSpecification(criteria.getId(), Vehicle_.id),
                buildStringSpecification(criteria.getPlateNumber(), Vehicle_.plateNumber),
                buildStringSpecification(criteria.getModel(), Vehicle_.model),
                buildRangeSpecification(criteria.getCapacity(), Vehicle_.capacity),
                buildStringSpecification(criteria.getSeatLayout(), Vehicle_.seatLayout),
                buildStringSpecification(criteria.getAmenities(), Vehicle_.amenities),
                buildStringSpecification(criteria.getImageCoverUrl(), Vehicle_.imageCoverUrl),
                buildRangeSpecification(criteria.getAverageRating(), Vehicle_.averageRating),
                buildRangeSpecification(criteria.getTotalReviews(), Vehicle_.totalReviews),
                buildSpecification(criteria.getIsActive(), Vehicle_.isActive),
                buildRangeSpecification(criteria.getYearManufactured(), Vehicle_.yearManufactured),
                buildRangeSpecification(criteria.getLastMaintenanceDate(), Vehicle_.lastMaintenanceDate),
                buildSpecification(criteria.getSummaryId(), root -> root.join(Vehicle_.summary, JoinType.LEFT).get(ReviewSummary_.id)),
                buildSpecification(criteria.getImagesId(), root -> root.join(Vehicle_.images, JoinType.LEFT).get(VehicleImage_.id)),
                buildSpecification(criteria.getReviewsId(), root -> root.join(Vehicle_.reviews, JoinType.LEFT).get(VehicleReview_.id)),
                buildSpecification(criteria.getAmenityItemsId(), root ->
                    root.join(Vehicle_.amenityItems, JoinType.LEFT).get(VehicleAmenity_.id)
                ),
                buildSpecification(criteria.getHomeStationId(), root -> root.join(Vehicle_.homeStation, JoinType.LEFT).get(Station_.id)),
                buildSpecification(criteria.getOperatorId(), root -> root.join(Vehicle_.operator, JoinType.LEFT).get(Operator_.id))
            );
        }
        return specification;
    }
}
