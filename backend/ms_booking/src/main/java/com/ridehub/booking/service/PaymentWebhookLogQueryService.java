package com.ridehub.booking.service;

import com.ridehub.booking.domain.*; // for static metamodels
import com.ridehub.booking.domain.PaymentWebhookLog;
import com.ridehub.booking.repository.PaymentWebhookLogRepository;
import com.ridehub.booking.service.criteria.PaymentWebhookLogCriteria;
import com.ridehub.booking.service.dto.PaymentWebhookLogDTO;
import com.ridehub.booking.service.mapper.PaymentWebhookLogMapper;
import jakarta.persistence.criteria.JoinType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link PaymentWebhookLog} entities in the database.
 * The main input is a {@link PaymentWebhookLogCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link PaymentWebhookLogDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class PaymentWebhookLogQueryService extends QueryService<PaymentWebhookLog> {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentWebhookLogQueryService.class);

    private final PaymentWebhookLogRepository paymentWebhookLogRepository;

    private final PaymentWebhookLogMapper paymentWebhookLogMapper;

    public PaymentWebhookLogQueryService(
        PaymentWebhookLogRepository paymentWebhookLogRepository,
        PaymentWebhookLogMapper paymentWebhookLogMapper
    ) {
        this.paymentWebhookLogRepository = paymentWebhookLogRepository;
        this.paymentWebhookLogMapper = paymentWebhookLogMapper;
    }

    /**
     * Return a {@link List} of {@link PaymentWebhookLogDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<PaymentWebhookLogDTO> findByCriteria(PaymentWebhookLogCriteria criteria) {
        LOG.debug("find by criteria : {}", criteria);
        final Specification<PaymentWebhookLog> specification = createSpecification(criteria);
        return paymentWebhookLogMapper.toDto(paymentWebhookLogRepository.findAll(specification));
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(PaymentWebhookLogCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<PaymentWebhookLog> specification = createSpecification(criteria);
        return paymentWebhookLogRepository.count(specification);
    }

    /**
     * Function to convert {@link PaymentWebhookLogCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<PaymentWebhookLog> createSpecification(PaymentWebhookLogCriteria criteria) {
        Specification<PaymentWebhookLog> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                buildRangeSpecification(criteria.getId(), PaymentWebhookLog_.id),
                buildStringSpecification(criteria.getProvider(), PaymentWebhookLog_.provider),
                buildStringSpecification(criteria.getPayloadHash(), PaymentWebhookLog_.payloadHash),
                buildRangeSpecification(criteria.getReceivedAt(), PaymentWebhookLog_.receivedAt),
                buildStringSpecification(criteria.getProcessingStatus(), PaymentWebhookLog_.processingStatus),
                buildRangeSpecification(criteria.getCreatedAt(), PaymentWebhookLog_.createdAt),
                buildRangeSpecification(criteria.getUpdatedAt(), PaymentWebhookLog_.updatedAt),
                buildSpecification(criteria.getIsDeleted(), PaymentWebhookLog_.isDeleted),
                buildRangeSpecification(criteria.getDeletedAt(), PaymentWebhookLog_.deletedAt),
                buildSpecification(criteria.getDeletedBy(), PaymentWebhookLog_.deletedBy),
                buildSpecification(criteria.getPaymentTransactionId(), root ->
                    root.join(PaymentWebhookLog_.paymentTransaction, JoinType.LEFT).get(PaymentTransaction_.id)
                )
            );
        }
        return specification;
    }
}
