package com.ticketsystem.route.service;

import com.ticketsystem.route.domain.*; // for static metamodels
import com.ticketsystem.route.domain.Operator;
import com.ticketsystem.route.repository.OperatorRepository;
import com.ticketsystem.route.service.criteria.OperatorCriteria;
import com.ticketsystem.route.service.dto.OperatorDTO;
import com.ticketsystem.route.service.mapper.OperatorMapper;
import jakarta.persistence.criteria.JoinType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link Operator} entities in the database.
 * The main input is a {@link OperatorCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link OperatorDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class OperatorQueryService extends QueryService<Operator> {

    private static final Logger LOG = LoggerFactory.getLogger(OperatorQueryService.class);

    private final OperatorRepository operatorRepository;

    private final OperatorMapper operatorMapper;

    public OperatorQueryService(OperatorRepository operatorRepository, OperatorMapper operatorMapper) {
        this.operatorRepository = operatorRepository;
        this.operatorMapper = operatorMapper;
    }

    /**
     * Return a {@link List} of {@link OperatorDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<OperatorDTO> findByCriteria(OperatorCriteria criteria) {
        LOG.debug("find by criteria : {}", criteria);
        final Specification<Operator> specification = createSpecification(criteria);
        return operatorMapper.toDto(operatorRepository.findAll(specification));
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(OperatorCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<Operator> specification = createSpecification(criteria);
        return operatorRepository.count(specification);
    }

    /**
     * Function to convert {@link OperatorCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Operator> createSpecification(OperatorCriteria criteria) {
        Specification<Operator> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                buildRangeSpecification(criteria.getId(), Operator_.id),
                buildStringSpecification(criteria.getName(), Operator_.name),
                buildStringSpecification(criteria.getBusinessLicense(), Operator_.businessLicense),
                buildStringSpecification(criteria.getLogoUrl(), Operator_.logoUrl),
                buildRangeSpecification(criteria.getRating(), Operator_.rating),
                buildStringSpecification(criteria.getContactPhone(), Operator_.contactPhone),
                buildStringSpecification(criteria.getContactEmail(), Operator_.contactEmail),
                buildSpecification(criteria.getIsActive(), Operator_.isActive),
                buildSpecification(criteria.getVehiclesId(), root -> root.join(Operator_.vehicles, JoinType.LEFT).get(Vehicle_.id)),
                buildSpecification(criteria.getRoutesId(), root -> root.join(Operator_.routes, JoinType.LEFT).get(Route_.id))
            );
        }
        return specification;
    }
}
