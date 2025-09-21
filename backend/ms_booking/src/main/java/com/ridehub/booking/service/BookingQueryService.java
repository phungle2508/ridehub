package com.ridehub.booking.service;

import com.ridehub.booking.domain.*; // for static metamodels
import com.ridehub.booking.domain.Booking;
import com.ridehub.booking.repository.BookingRepository;
import com.ridehub.booking.service.criteria.BookingCriteria;
import com.ridehub.booking.service.dto.BookingDTO;
import com.ridehub.booking.service.mapper.BookingMapper;
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
 * Service for executing complex queries for {@link Booking} entities in the database.
 * The main input is a {@link BookingCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link Page} of {@link BookingDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class BookingQueryService extends QueryService<Booking> {

    private static final Logger LOG = LoggerFactory.getLogger(BookingQueryService.class);

    private final BookingRepository bookingRepository;

    private final BookingMapper bookingMapper;

    public BookingQueryService(BookingRepository bookingRepository, BookingMapper bookingMapper) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
    }

    /**
     * Return a {@link Page} of {@link BookingDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<BookingDTO> findByCriteria(BookingCriteria criteria, Pageable page) {
        LOG.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Booking> specification = createSpecification(criteria);
        return bookingRepository.findAll(specification, page).map(bookingMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(BookingCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<Booking> specification = createSpecification(criteria);
        return bookingRepository.count(specification);
    }

    /**
     * Function to convert {@link BookingCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Booking> createSpecification(BookingCriteria criteria) {
        Specification<Booking> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                buildRangeSpecification(criteria.getId(), Booking_.id),
                buildStringSpecification(criteria.getBookingCode(), Booking_.bookingCode),
                buildSpecification(criteria.getStatus(), Booking_.status),
                buildRangeSpecification(criteria.getQuantity(), Booking_.quantity),
                buildRangeSpecification(criteria.getTotalAmount(), Booking_.totalAmount),
                buildRangeSpecification(criteria.getCreatedTime(), Booking_.createdTime),
                buildSpecification(criteria.getCustomerId(), Booking_.customerId),
                buildRangeSpecification(criteria.getCreatedAt(), Booking_.createdAt),
                buildRangeSpecification(criteria.getUpdatedAt(), Booking_.updatedAt),
                buildSpecification(criteria.getIsDeleted(), Booking_.isDeleted),
                buildRangeSpecification(criteria.getDeletedAt(), Booking_.deletedAt),
                buildSpecification(criteria.getDeletedBy(), Booking_.deletedBy),
                buildSpecification(criteria.getInvoiceId(), root -> root.join(Booking_.invoice, JoinType.LEFT).get(Invoice_.id)),
                buildSpecification(criteria.getPaymentTransactionId(), root ->
                    root.join(Booking_.paymentTransaction, JoinType.LEFT).get(PaymentTransaction_.id)
                ),
                buildSpecification(criteria.getTicketsId(), root -> root.join(Booking_.tickets, JoinType.LEFT).get(Ticket_.id)),
                buildSpecification(criteria.getAppliedPromosId(), root ->
                    root.join(Booking_.appliedPromos, JoinType.LEFT).get(AppliedPromotion_.id)
                )
            );
        }
        return specification;
    }
}
