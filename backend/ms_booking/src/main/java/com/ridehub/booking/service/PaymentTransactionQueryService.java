package com.ridehub.booking.service;

import com.ridehub.booking.domain.*; // for static metamodels
import com.ridehub.booking.domain.PaymentTransaction;
import com.ridehub.booking.repository.PaymentTransactionRepository;
import com.ridehub.booking.service.criteria.PaymentTransactionCriteria;
import com.ridehub.booking.service.dto.PaymentTransactionDTO;
import com.ridehub.booking.service.mapper.PaymentTransactionMapper;
import jakarta.persistence.criteria.JoinType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link PaymentTransaction} entities in the database.
 * The main input is a {@link PaymentTransactionCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link PaymentTransactionDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class PaymentTransactionQueryService extends QueryService<PaymentTransaction> {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentTransactionQueryService.class);

    private final PaymentTransactionRepository paymentTransactionRepository;

    private final PaymentTransactionMapper paymentTransactionMapper;

    public PaymentTransactionQueryService(
        PaymentTransactionRepository paymentTransactionRepository,
        PaymentTransactionMapper paymentTransactionMapper
    ) {
        this.paymentTransactionRepository = paymentTransactionRepository;
        this.paymentTransactionMapper = paymentTransactionMapper;
    }

    /**
     * Return a {@link List} of {@link PaymentTransactionDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<PaymentTransactionDTO> findByCriteria(PaymentTransactionCriteria criteria) {
        LOG.debug("find by criteria : {}", criteria);
        final Specification<PaymentTransaction> specification = createSpecification(criteria);
        return paymentTransactionMapper.toDto(paymentTransactionRepository.findAll(specification));
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(PaymentTransactionCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<PaymentTransaction> specification = createSpecification(criteria);
        return paymentTransactionRepository.count(specification);
    }

    /**
     * Function to convert {@link PaymentTransactionCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<PaymentTransaction> createSpecification(PaymentTransactionCriteria criteria) {
        Specification<PaymentTransaction> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                buildRangeSpecification(criteria.getId(), PaymentTransaction_.id),
                buildStringSpecification(criteria.getTransactionId(), PaymentTransaction_.transactionId),
                buildSpecification(criteria.getMethod(), PaymentTransaction_.method),
                buildSpecification(criteria.getStatus(), PaymentTransaction_.status),
                buildRangeSpecification(criteria.getAmount(), PaymentTransaction_.amount),
                buildRangeSpecification(criteria.getTime(), PaymentTransaction_.time),
                buildStringSpecification(criteria.getGatewayNote(), PaymentTransaction_.gatewayNote),
                buildRangeSpecification(criteria.getCreatedAt(), PaymentTransaction_.createdAt),
                buildRangeSpecification(criteria.getUpdatedAt(), PaymentTransaction_.updatedAt),
                buildSpecification(criteria.getIsDeleted(), PaymentTransaction_.isDeleted),
                buildRangeSpecification(criteria.getDeletedAt(), PaymentTransaction_.deletedAt),
                buildSpecification(criteria.getDeletedBy(), PaymentTransaction_.deletedBy),
                buildSpecification(criteria.getBookingId(), root -> root.join(PaymentTransaction_.booking, JoinType.LEFT).get(Booking_.id))
            );
        }
        return specification;
    }
}
