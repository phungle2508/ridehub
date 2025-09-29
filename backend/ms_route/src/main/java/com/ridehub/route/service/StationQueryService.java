package com.ridehub.route.service;

import com.ridehub.route.domain.*; // for static metamodels
import com.ridehub.route.repository.StationRepository;
import com.ridehub.route.repository.search.StationSearchRepository;
import com.ridehub.route.service.criteria.StationCriteria;
import com.ridehub.route.service.dto.StationDTO;
import com.ridehub.route.service.dto.StationWithRoutesDTO;
import com.ridehub.route.service.mapper.StationMapper;
import com.ridehub.route.repository.RouteRepository;
import com.ridehub.route.service.mapper.RouteMapper;

import jakarta.persistence.criteria.JoinType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service for executing complex queries for {@link Station} entities in the
 * database.
 * The main input is a {@link StationCriteria} which gets converted to
 * {@link Specification},
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

    private final RouteRepository routeRepository;

    private final RouteMapper routeMapper;

    public StationQueryService(
            StationRepository stationRepository,
            StationMapper stationMapper,
            StationSearchRepository stationSearchRepository,
            RouteRepository routeRepository,
            RouteMapper routeMapper) {
        this.stationRepository = stationRepository;
        this.stationMapper = stationMapper;
        this.stationSearchRepository = stationSearchRepository;
        this.routeRepository = routeRepository;
        this.routeMapper = routeMapper;
    }

    /**
     * Return a {@link Page} of {@link StationDTO} which matches the criteria from
     * the database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @param page     The page, which should be returned.
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
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
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
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Station> createSpecification(StationCriteria criteria) {
        Specification<Station> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                    Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                    buildRangeSpecification(criteria.getId(), Station_.id),
                    buildStringSpecification(criteria.getName(), Station_.name),
                    buildStringSpecification(criteria.getPhoneNumber(), Station_.phoneNumber),
                    buildStringSpecification(criteria.getDescription(), Station_.description),
                    buildSpecification(criteria.getActive(), Station_.active),
                    buildRangeSpecification(criteria.getCreatedAt(), Station_.createdAt),
                    buildRangeSpecification(criteria.getUpdatedAt(), Station_.updatedAt),
                    buildSpecification(criteria.getIsDeleted(), Station_.isDeleted),
                    buildRangeSpecification(criteria.getDeletedAt(), Station_.deletedAt),
                    buildSpecification(criteria.getDeletedBy(), Station_.deletedBy),
                    buildSpecification(criteria.getAddressId(),
                            root -> root.join(Station_.address, JoinType.LEFT).get(Address_.id)),
                    buildSpecification(criteria.getStationImgId(),
                            root -> root.join(Station_.stationImg, JoinType.LEFT).get(FileRoute_.id)));
            // 🔹 Filter by districtCode
            if (criteria.getDistrictCode() != null) {
                specification = specification.and(
                        buildSpecification(
                                criteria.getDistrictCode(), // StringFilter
                                root -> root.join(Station_.address, JoinType.LEFT)
                                        .join(Address_.ward, JoinType.LEFT)
                                        .join(Ward_.district, JoinType.LEFT)
                                        .get(District_.districtCode)));
            }

            // provinceCode by equals/in/notEquals/specified
            if (criteria.getProvinceCode() != null) {
                specification = specification.and(
                        buildSpecification(
                                criteria.getProvinceCode(), // StringFilter
                                root -> root.join(Station_.address, JoinType.LEFT)
                                        .join(Address_.ward, JoinType.LEFT)
                                        .join(Ward_.district, JoinType.LEFT)
                                        .join(District_.province, JoinType.LEFT)
                                        .get(Province_.provinceCode)));
            }
        }
        return specification;
    }

    @Transactional(readOnly = true)
    public Map<Long, Long> getRouteCountsByStationIds(List<Long> stationIds) {
        List<Object[]> results = routeRepository.countRoutesByStationIds(stationIds);
        return results.stream()
                .collect(Collectors.toMap(
                        row -> ((Number) row[0]).longValue(), // station_id
                        row -> ((Number) row[1]).longValue() // route_count
                ));
    }

    /**
     * Get all stations with their associated routes
     * 
     * @param pageable pagination information
     * @return Page of StationWithRoutesDTO
     */
    @Transactional(readOnly = true)
    public Page<StationWithRoutesDTO> getStationsWithRoutes(Pageable pageable) {
        LOG.debug("Request to get all stations with routes");

        Page<Station> stations = stationRepository.findAll(pageable);
        List<Long> stationIds = stations.stream().map(Station::getId).toList();
        Map<Long, Long> counts = getRouteCountsByStationIds(stationIds);

        // Map each station to DTO
        List<StationWithRoutesDTO> stationWithRoutesDTOs = stations.stream()
                .map(s -> {
                    StationWithRoutesDTO dto = stationMapper.toStationWithRoutesDto(s);
                    dto.setRoutresCount(counts.getOrDefault(s.getId(), 0L));
                    return dto;
                })
                .toList();

        return new PageImpl<>(stationWithRoutesDTOs, pageable, stations.getTotalElements());
    }

    /**
     * Get a station by ID with all its associated routes.
     *
     * @param id the ID of the station to retrieve.
     * @return an Optional containing the StationWithRoutesDTO with its routes, or
     *         empty if not found.
     */
    @Transactional(readOnly = true)
    public Optional<StationWithRoutesDTO> getStationsWithRoutesAndId(Long id, Pageable pageable) {
        return stationRepository.findById(id).map(station -> {
            StationWithRoutesDTO dto = stationMapper.toStationWithRoutesDto(station);

            Page<Route> routePage = routeRepository.findByOriginOrDestination(station, pageable);
            dto.setRoutes(routePage.getContent().stream().map(routeMapper::toDto).toList());
            // dto.setRoutesCount(routePage.getTotalElements()); // total across all pages

            return dto;
        });
    }

}
