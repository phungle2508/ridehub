package com.ridehub.booking.service;

import com.ridehub.booking.domain.*; // for static metamodels
import com.ridehub.booking.domain.FileBooking;
import com.ridehub.booking.repository.FileBookingRepository;
import com.ridehub.booking.service.criteria.FileBookingCriteria;
import com.ridehub.booking.service.dto.FileBookingDTO;
import com.ridehub.booking.service.mapper.FileBookingMapper;
import jakarta.persistence.criteria.JoinType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link FileBooking} entities in the database.
 * The main input is a {@link FileBookingCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link FileBookingDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class FileBookingQueryService extends QueryService<FileBooking> {

    private static final Logger LOG = LoggerFactory.getLogger(FileBookingQueryService.class);

    private final FileBookingRepository fileBookingRepository;

    private final FileBookingMapper fileBookingMapper;

    public FileBookingQueryService(FileBookingRepository fileBookingRepository, FileBookingMapper fileBookingMapper) {
        this.fileBookingRepository = fileBookingRepository;
        this.fileBookingMapper = fileBookingMapper;
    }

    /**
     * Return a {@link List} of {@link FileBookingDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<FileBookingDTO> findByCriteria(FileBookingCriteria criteria) {
        LOG.debug("find by criteria : {}", criteria);
        final Specification<FileBooking> specification = createSpecification(criteria);
        return fileBookingMapper.toDto(fileBookingRepository.findAll(specification));
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(FileBookingCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<FileBooking> specification = createSpecification(criteria);
        return fileBookingRepository.count(specification);
    }

    /**
     * Function to convert {@link FileBookingCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<FileBooking> createSpecification(FileBookingCriteria criteria) {
        Specification<FileBooking> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                buildRangeSpecification(criteria.getId(), FileBooking_.id),
                buildStringSpecification(criteria.getBucket(), FileBooking_.bucket),
                buildStringSpecification(criteria.getObjectKey(), FileBooking_.objectKey),
                buildStringSpecification(criteria.getContentType(), FileBooking_.contentType),
                buildRangeSpecification(criteria.getSize(), FileBooking_.size),
                buildRangeSpecification(criteria.getCreatedAt(), FileBooking_.createdAt),
                buildRangeSpecification(criteria.getUpdatedAt(), FileBooking_.updatedAt),
                buildSpecification(criteria.getIsDeleted(), FileBooking_.isDeleted),
                buildRangeSpecification(criteria.getDeletedAt(), FileBooking_.deletedAt),
                buildSpecification(criteria.getDeletedBy(), FileBooking_.deletedBy),
                buildSpecification(criteria.getTicketId(), root -> root.join(FileBooking_.ticket, JoinType.LEFT).get(Ticket_.id))
            );
        }
        return specification;
    }
}
