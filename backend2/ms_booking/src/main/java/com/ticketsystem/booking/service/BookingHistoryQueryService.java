package com.ticketsystem.booking.service;

import com.ticketsystem.booking.domain.*; // for static metamodels
import com.ticketsystem.booking.domain.BookingHistory;
import com.ticketsystem.booking.repository.BookingHistoryRepository;
import com.ticketsystem.booking.service.criteria.BookingHistoryCriteria;
import com.ticketsystem.booking.service.dto.BookingHistoryDTO;
import com.ticketsystem.booking.service.mapper.BookingHistoryMapper;
import jakarta.persistence.criteria.JoinType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link BookingHistory} entities in the database.
 * The main input is a {@link BookingHistoryCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link BookingHistoryDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class BookingHistoryQueryService extends QueryService<BookingHistory> {

    private static final Logger LOG = LoggerFactory.getLogger(BookingHistoryQueryService.class);

    private final BookingHistoryRepository bookingHistoryRepository;

    private final BookingHistoryMapper bookingHistoryMapper;

    public BookingHistoryQueryService(BookingHistoryRepository bookingHistoryRepository, BookingHistoryMapper bookingHistoryMapper) {
        this.bookingHistoryRepository = bookingHistoryRepository;
        this.bookingHistoryMapper = bookingHistoryMapper;
    }

    /**
     * Return a {@link List} of {@link BookingHistoryDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<BookingHistoryDTO> findByCriteria(BookingHistoryCriteria criteria) {
        LOG.debug("find by criteria : {}", criteria);
        final Specification<BookingHistory> specification = createSpecification(criteria);
        return bookingHistoryMapper.toDto(bookingHistoryRepository.findAll(specification));
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(BookingHistoryCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<BookingHistory> specification = createSpecification(criteria);
        return bookingHistoryRepository.count(specification);
    }

    /**
     * Function to convert {@link BookingHistoryCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<BookingHistory> createSpecification(BookingHistoryCriteria criteria) {
        Specification<BookingHistory> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                buildRangeSpecification(criteria.getId(), BookingHistory_.id),
                buildSpecification(criteria.getPreviousStatus(), BookingHistory_.previousStatus),
                buildSpecification(criteria.getNewStatus(), BookingHistory_.newStatus),
                buildStringSpecification(criteria.getReason(), BookingHistory_.reason),
                buildSpecification(criteria.getChangedBy(), BookingHistory_.changedBy),
                buildRangeSpecification(criteria.getChangedAt(), BookingHistory_.changedAt),
                buildSpecification(criteria.getBookingId(), root -> root.join(BookingHistory_.booking, JoinType.LEFT).get(Booking_.id))
            );
        }
        return specification;
    }
}
