package com.ridehub.promotion.service;

import com.ridehub.promotion.domain.*; // for static metamodels
import com.ridehub.promotion.domain.FilePromotion;
import com.ridehub.promotion.repository.FilePromotionRepository;
import com.ridehub.promotion.service.criteria.FilePromotionCriteria;
import com.ridehub.promotion.service.dto.FilePromotionDTO;
import com.ridehub.promotion.service.mapper.FilePromotionMapper;
import jakarta.persistence.criteria.JoinType;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link FilePromotion} entities in the database.
 * The main input is a {@link FilePromotionCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link FilePromotionDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class FilePromotionQueryService extends QueryService<FilePromotion> {

    private static final Logger LOG = LoggerFactory.getLogger(FilePromotionQueryService.class);

    private final FilePromotionRepository filePromotionRepository;

    private final FilePromotionMapper filePromotionMapper;

    public FilePromotionQueryService(FilePromotionRepository filePromotionRepository, FilePromotionMapper filePromotionMapper) {
        this.filePromotionRepository = filePromotionRepository;
        this.filePromotionMapper = filePromotionMapper;
    }

    /**
     * Return a {@link List} of {@link FilePromotionDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<FilePromotionDTO> findByCriteria(FilePromotionCriteria criteria) {
        LOG.debug("find by criteria : {}", criteria);
        final Specification<FilePromotion> specification = createSpecification(criteria);
        return filePromotionMapper.toDto(filePromotionRepository.findAll(specification));
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(FilePromotionCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<FilePromotion> specification = createSpecification(criteria);
        return filePromotionRepository.count(specification);
    }

    /**
     * Function to convert {@link FilePromotionCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<FilePromotion> createSpecification(FilePromotionCriteria criteria) {
        Specification<FilePromotion> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                buildRangeSpecification(criteria.getId(), FilePromotion_.id),
                buildStringSpecification(criteria.getBucket(), FilePromotion_.bucket),
                buildStringSpecification(criteria.getObjectKey(), FilePromotion_.objectKey),
                buildStringSpecification(criteria.getContentType(), FilePromotion_.contentType),
                buildRangeSpecification(criteria.getSize(), FilePromotion_.size),
                buildSpecification(criteria.getIsBanner(), FilePromotion_.isBanner),
                buildRangeSpecification(criteria.getCreatedAt(), FilePromotion_.createdAt),
                buildRangeSpecification(criteria.getUpdatedAt(), FilePromotion_.updatedAt),
                buildSpecification(criteria.getIsDeleted(), FilePromotion_.isDeleted),
                buildRangeSpecification(criteria.getDeletedAt(), FilePromotion_.deletedAt),
                buildSpecification(criteria.getDeletedBy(), FilePromotion_.deletedBy),
                buildSpecification(criteria.getPromotionId(), root -> root.join(FilePromotion_.promotion, JoinType.LEFT).get(Promotion_.id))
            );
        }
        return specification;
    }
}
