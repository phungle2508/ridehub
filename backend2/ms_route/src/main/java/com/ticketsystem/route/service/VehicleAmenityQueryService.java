package com.ticketsystem.route.service;

import com.ticketsystem.route.domain.*; // for static metamodels
import com.ticketsystem.route.domain.VehicleAmenity;
import com.ticketsystem.route.repository.VehicleAmenityRepository;
import com.ticketsystem.route.service.criteria.VehicleAmenityCriteria;
import com.ticketsystem.route.service.dto.VehicleAmenityDTO;
import com.ticketsystem.route.service.mapper.VehicleAmenityMapper;
import jakarta.persistence.criteria.JoinType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link VehicleAmenity} entities in the database.
 * The main input is a {@link VehicleAmenityCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link VehicleAmenityDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class VehicleAmenityQueryService extends QueryService<VehicleAmenity> {

    private static final Logger LOG = LoggerFactory.getLogger(VehicleAmenityQueryService.class);

    private final VehicleAmenityRepository vehicleAmenityRepository;

    private final VehicleAmenityMapper vehicleAmenityMapper;

    public VehicleAmenityQueryService(VehicleAmenityRepository vehicleAmenityRepository, VehicleAmenityMapper vehicleAmenityMapper) {
        this.vehicleAmenityRepository = vehicleAmenityRepository;
        this.vehicleAmenityMapper = vehicleAmenityMapper;
    }

    /**
     * Return a {@link List} of {@link VehicleAmenityDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<VehicleAmenityDTO> findByCriteria(VehicleAmenityCriteria criteria) {
        LOG.debug("find by criteria : {}", criteria);
        final Specification<VehicleAmenity> specification = createSpecification(criteria);
        return vehicleAmenityMapper.toDto(vehicleAmenityRepository.findAll(specification));
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(VehicleAmenityCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<VehicleAmenity> specification = createSpecification(criteria);
        return vehicleAmenityRepository.count(specification);
    }

    /**
     * Function to convert {@link VehicleAmenityCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<VehicleAmenity> createSpecification(VehicleAmenityCriteria criteria) {
        Specification<VehicleAmenity> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                buildRangeSpecification(criteria.getId(), VehicleAmenity_.id),
                buildStringSpecification(criteria.getAmenity(), VehicleAmenity_.amenity),
                buildStringSpecification(criteria.getDescription(), VehicleAmenity_.description),
                buildSpecification(criteria.getVehicleId(), root -> root.join(VehicleAmenity_.vehicle, JoinType.LEFT).get(Vehicle_.id))
            );
        }
        return specification;
    }
}
