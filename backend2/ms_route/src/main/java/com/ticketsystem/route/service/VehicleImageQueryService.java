package com.ticketsystem.route.service;

import com.ticketsystem.route.domain.*; // for static metamodels
import com.ticketsystem.route.domain.VehicleImage;
import com.ticketsystem.route.repository.VehicleImageRepository;
import com.ticketsystem.route.service.criteria.VehicleImageCriteria;
import com.ticketsystem.route.service.dto.VehicleImageDTO;
import com.ticketsystem.route.service.mapper.VehicleImageMapper;
import jakarta.persistence.criteria.JoinType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link VehicleImage} entities in the database.
 * The main input is a {@link VehicleImageCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link VehicleImageDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class VehicleImageQueryService extends QueryService<VehicleImage> {

    private static final Logger LOG = LoggerFactory.getLogger(VehicleImageQueryService.class);

    private final VehicleImageRepository vehicleImageRepository;

    private final VehicleImageMapper vehicleImageMapper;

    public VehicleImageQueryService(VehicleImageRepository vehicleImageRepository, VehicleImageMapper vehicleImageMapper) {
        this.vehicleImageRepository = vehicleImageRepository;
        this.vehicleImageMapper = vehicleImageMapper;
    }

    /**
     * Return a {@link List} of {@link VehicleImageDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<VehicleImageDTO> findByCriteria(VehicleImageCriteria criteria) {
        LOG.debug("find by criteria : {}", criteria);
        final Specification<VehicleImage> specification = createSpecification(criteria);
        return vehicleImageMapper.toDto(vehicleImageRepository.findAll(specification));
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(VehicleImageCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<VehicleImage> specification = createSpecification(criteria);
        return vehicleImageRepository.count(specification);
    }

    /**
     * Function to convert {@link VehicleImageCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<VehicleImage> createSpecification(VehicleImageCriteria criteria) {
        Specification<VehicleImage> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                buildRangeSpecification(criteria.getId(), VehicleImage_.id),
                buildStringSpecification(criteria.getImageUrl(), VehicleImage_.imageUrl),
                buildStringSpecification(criteria.getImageType(), VehicleImage_.imageType),
                buildStringSpecification(criteria.getDescription(), VehicleImage_.description),
                buildSpecification(criteria.getIsPrimary(), VehicleImage_.isPrimary),
                buildRangeSpecification(criteria.getUploadedAt(), VehicleImage_.uploadedAt),
                buildSpecification(criteria.getVehicleId(), root -> root.join(VehicleImage_.vehicle, JoinType.LEFT).get(Vehicle_.id))
            );
        }
        return specification;
    }
}
