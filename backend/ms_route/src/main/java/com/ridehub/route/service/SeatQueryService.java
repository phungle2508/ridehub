package com.ridehub.route.service;

import com.ridehub.route.domain.*; // for static metamodels
import com.ridehub.route.repository.SeatRepository;
import com.ridehub.route.service.criteria.SeatCriteria;
import com.ridehub.route.service.dto.SeatDTO;
import com.ridehub.route.service.mapper.SeatMapper;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.JoinType;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;
import tech.jhipster.service.filter.LongFilter;

/**
 * Service for executing complex queries for {@link Seat} entities in the
 * database.
 * The main input is a {@link SeatCriteria} which gets converted to
 * {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link SeatDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class SeatQueryService extends QueryService<Seat> {

    private static final Logger LOG = LoggerFactory.getLogger(SeatQueryService.class);

    private final SeatRepository seatRepository;

    private final SeatMapper seatMapper;

    @PersistenceContext
    private EntityManager entityManager;

    public SeatQueryService(SeatRepository seatRepository, SeatMapper seatMapper) {
        this.seatRepository = seatRepository;
        this.seatMapper = seatMapper;
    }

    /**
     * Return a {@link List} of {@link SeatDTO} which matches the criteria from the
     * database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<SeatDTO> findByCriteria(SeatCriteria criteria) {
        LOG.debug("find by criteria : {}", criteria);
        final Specification<Seat> specification = createSpecification(criteria);
        return seatMapper.toDto(seatRepository.findAll(specification));
    }

    /**
     * Return the number of matching entities in the database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(SeatCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<Seat> specification = createSpecification(criteria);
        return seatRepository.count(specification);
    }

    /**
     * Function to convert {@link SeatCriteria} to a {@link Specification}
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Seat> createSpecification(SeatCriteria criteria) {
        Specification<Seat> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                    Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                    buildRangeSpecification(criteria.getId(), Seat_.id),
                    buildStringSpecification(criteria.getSeatNo(), Seat_.seatNo),
                    buildRangeSpecification(criteria.getRowNo(), Seat_.rowNo),
                    buildRangeSpecification(criteria.getColNo(), Seat_.colNo),
                    buildRangeSpecification(criteria.getPriceFactor(), Seat_.priceFactor),
                    buildSpecification(criteria.getType(), Seat_.type),
                    buildRangeSpecification(criteria.getCreatedAt(), Seat_.createdAt),
                    buildRangeSpecification(criteria.getUpdatedAt(), Seat_.updatedAt),
                    buildSpecification(criteria.getIsDeleted(), Seat_.isDeleted),
                    buildRangeSpecification(criteria.getDeletedAt(), Seat_.deletedAt),
                    buildSpecification(criteria.getDeletedBy(), Seat_.deletedBy),
                    buildSpecification(criteria.getFloorId(),
                            root -> root.join(Seat_.floor, JoinType.LEFT).get(Floor_.id)));
        }
        return specification;
    }

    @Transactional(readOnly = true)
    public List<SeatDTO> findByFloorIds(List<Long> floorIds) {
        if (floorIds == null || floorIds.isEmpty())
            return List.of();

        SeatCriteria criteria = new SeatCriteria();
        LongFilter floorIdFilter = new LongFilter();
        floorIdFilter.setIn(floorIds.stream().toList());
        criteria.setFloorId(floorIdFilter);

        return findByCriteria(criteria);
    }

    /**
     * Count seats per vehicle for the given vehicle IDs using Criteria API.
     * Mirrors:
     * SELECT v.id, COUNT(s)
     * FROM Seat s
     * JOIN s.floor f
     * JOIN f.seatMap sm
     * JOIN sm.vehicle v
     * WHERE v.id IN (:vehicleIds)
     * AND (s.isDeleted = false OR s.isDeleted IS NULL)
     * AND (f.isDeleted = false OR f.isDeleted IS NULL)
     * AND (v.isDeleted = false OR v.isDeleted IS NULL)
     * GROUP BY v.id
     */
    @Transactional(readOnly = true)
    public Map<Long, Long> countSeatsByVehicleIds(List<Long> vehicleIds) {
        if (vehicleIds == null || vehicleIds.isEmpty()) {
            return Map.of();
        }

        var cb = entityManager.getCriteriaBuilder();
        var cq = cb.createTupleQuery();

        var seat = cq.from(Seat.class);
        var floor = seat.join(Seat_.floor, JoinType.INNER);
        var seatMap = floor.join(Floor_.seatMap, JoinType.INNER);
        var vehicle = seatMap.join(SeatMap_.vehicle, JoinType.INNER);

        cq.multiselect(
                vehicle.get(Vehicle_.id).alias("vehicleId"),
                cb.count(seat).alias("seatCount"));

        cq.where(cb.and(
                vehicle.get(Vehicle_.id).in(vehicleIds),
                cb.or(cb.isFalse(seat.get(Seat_.isDeleted)), cb.isNull(seat.get(Seat_.isDeleted))),
                cb.or(cb.isFalse(floor.get(Floor_.isDeleted)), cb.isNull(floor.get(Floor_.isDeleted))),
                cb.or(cb.isFalse(vehicle.get(Vehicle_.isDeleted)), cb.isNull(vehicle.get(Vehicle_.isDeleted)))));

        cq.groupBy(vehicle.get(Vehicle_.id));

        List<Tuple> rows = entityManager.createQuery(cq).getResultList();

        return rows.stream()
                .collect(Collectors.toMap(
                        t -> (Long) t.get("vehicleId"),
                        t -> (Long) t.get("seatCount")));
    }
}
