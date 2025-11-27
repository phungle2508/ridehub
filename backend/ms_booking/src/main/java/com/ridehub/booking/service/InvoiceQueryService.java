package com.ridehub.booking.service;

import com.ridehub.booking.domain.*; // for static metamodels
import com.ridehub.booking.domain.Invoice;
import com.ridehub.booking.repository.InvoiceRepository;
import com.ridehub.booking.service.criteria.InvoiceCriteria;
import com.ridehub.booking.service.dto.InvoiceDTO;
import com.ridehub.booking.service.mapper.InvoiceMapper;
import jakarta.persistence.criteria.JoinType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link Invoice} entities in the database.
 * The main input is a {@link InvoiceCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link InvoiceDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class InvoiceQueryService extends QueryService<Invoice> {

    private static final Logger LOG = LoggerFactory.getLogger(InvoiceQueryService.class);

    private final InvoiceRepository invoiceRepository;

    private final InvoiceMapper invoiceMapper;

    public InvoiceQueryService(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
    }

    /**
     * Return a {@link List} of {@link InvoiceDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<InvoiceDTO> findByCriteria(InvoiceCriteria criteria) {
        LOG.debug("find by criteria : {}", criteria);
        final Specification<Invoice> specification = createSpecification(criteria);
        return invoiceMapper.toDto(invoiceRepository.findAll(specification));
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(InvoiceCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<Invoice> specification = createSpecification(criteria);
        return invoiceRepository.count(specification);
    }

    /**
     * Function to convert {@link InvoiceCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Invoice> createSpecification(InvoiceCriteria criteria) {
        Specification<Invoice> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                buildRangeSpecification(criteria.getId(), Invoice_.id),
                buildStringSpecification(criteria.getInvoiceNo(), Invoice_.invoiceNo),
                buildRangeSpecification(criteria.getIssuedAt(), Invoice_.issuedAt),
                buildRangeSpecification(criteria.getGrossAmount(), Invoice_.grossAmount),
                buildRangeSpecification(criteria.getVatAmount(), Invoice_.vatAmount),
                buildRangeSpecification(criteria.getNetAmount(), Invoice_.netAmount),
                buildRangeSpecification(criteria.getCreatedAt(), Invoice_.createdAt),
                buildRangeSpecification(criteria.getUpdatedAt(), Invoice_.updatedAt),
                buildSpecification(criteria.getIsDeleted(), Invoice_.isDeleted),
                buildRangeSpecification(criteria.getDeletedAt(), Invoice_.deletedAt),
                buildSpecification(criteria.getDeletedBy(), Invoice_.deletedBy),
                buildSpecification(criteria.getBookingId(), root -> root.join(Invoice_.booking, JoinType.LEFT).get(Booking_.id))
            );
        }
        return specification;
    }
}
