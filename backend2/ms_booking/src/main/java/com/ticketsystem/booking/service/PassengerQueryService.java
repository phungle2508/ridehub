package com.ticketsystem.booking.service;

import com.ticketsystem.booking.domain.*; // for static metamodels
import com.ticketsystem.booking.domain.Passenger;
import com.ticketsystem.booking.repository.PassengerRepository;
import com.ticketsystem.booking.service.criteria.PassengerCriteria;
import com.ticketsystem.booking.service.dto.PassengerDTO;
import com.ticketsystem.booking.service.mapper.PassengerMapper;
import jakarta.persistence.criteria.JoinType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link Passenger} entities in the database.
 * The main input is a {@link PassengerCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link PassengerDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class PassengerQueryService extends QueryService<Passenger> {

    private static final Logger LOG = LoggerFactory.getLogger(PassengerQueryService.class);

    private final PassengerRepository passengerRepository;

    private final PassengerMapper passengerMapper;

    public PassengerQueryService(PassengerRepository passengerRepository, PassengerMapper passengerMapper) {
        this.passengerRepository = passengerRepository;
        this.passengerMapper = passengerMapper;
    }

    /**
     * Return a {@link List} of {@link PassengerDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<PassengerDTO> findByCriteria(PassengerCriteria criteria) {
        LOG.debug("find by criteria : {}", criteria);
        final Specification<Passenger> specification = createSpecification(criteria);
        return passengerMapper.toDto(passengerRepository.findAll(specification));
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(PassengerCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<Passenger> specification = createSpecification(criteria);
        return passengerRepository.count(specification);
    }

    /**
     * Function to convert {@link PassengerCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Passenger> createSpecification(PassengerCriteria criteria) {
        Specification<Passenger> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                buildRangeSpecification(criteria.getId(), Passenger_.id),
                buildSpecification(criteria.getSeatId(), Passenger_.seatId),
                buildStringSpecification(criteria.getFirstName(), Passenger_.firstName),
                buildStringSpecification(criteria.getLastName(), Passenger_.lastName),
                buildStringSpecification(criteria.getIdNumber(), Passenger_.idNumber),
                buildRangeSpecification(criteria.getDateOfBirth(), Passenger_.dateOfBirth),
                buildStringSpecification(criteria.getNationality(), Passenger_.nationality),
                buildStringSpecification(criteria.getTicketNumber(), Passenger_.ticketNumber),
                buildSpecification(criteria.getBookingId(), root -> root.join(Passenger_.booking, JoinType.LEFT).get(Booking_.id))
            );
        }
        return specification;
    }
}
