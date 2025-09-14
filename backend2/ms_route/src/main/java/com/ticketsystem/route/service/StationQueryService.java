package com.ticketsystem.route.service;

import com.ticketsystem.route.domain.*; // for static metamodels
import com.ticketsystem.route.domain.Station;
import com.ticketsystem.route.repository.StationRepository;
import com.ticketsystem.route.repository.search.StationSearchRepository;
import com.ticketsystem.route.service.criteria.StationCriteria;
import com.ticketsystem.route.service.dto.StationDTO;
import com.ticketsystem.route.service.mapper.StationMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link Station} entities in the database.
 * The main input is a {@link StationCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link Page} of {@link StationDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class StationQueryService extends QueryService<Station> {

    private static final Logger LOG = LoggerFactory.getLogger(StationQueryService.class);

    private final StationRepository stationRepository;

    private final StationMapper stationMapper;

    private final StationSearchRepository stationSearchRepository;

    public StationQueryService(
        StationRepository stationRepository,
        StationMapper stationMapper,
        StationSearchRepository stationSearchRepository
    ) {
        this.stationRepository = stationRepository;
        this.stationMapper = stationMapper;
        this.stationSearchRepository = stationSearchRepository;
    }

    /**
     * Return a {@link Page} of {@link StationDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<StationDTO> findByCriteria(StationCriteria criteria, Pageable page) {
        LOG.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Station> specification = createSpecification(criteria);
        return stationRepository.findAll(specification, page).map(stationMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(StationCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<Station> specification = createSpecification(criteria);
        return stationRepository.count(specification);
    }

    /**
     * Function to convert {@link StationCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Station> createSpecification(StationCriteria criteria) {
        Specification<Station> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                buildRangeSpecification(criteria.getId(), Station_.id),
                buildStringSpecification(criteria.getCode(), Station_.code),
                buildStringSpecification(criteria.getName(), Station_.name),
                buildStringSpecification(criteria.getNameEn(), Station_.nameEn),
                buildSpecification(criteria.getAddressId(), Station_.addressId),
                buildStringSpecification(criteria.getFacilities(), Station_.facilities),
                buildStringSpecification(criteria.getOperatingHours(), Station_.operatingHours),
                buildSpecification(criteria.getIsActive(), Station_.isActive)
            );
        }
        return specification;
    }
}
