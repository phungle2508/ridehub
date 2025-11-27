package com.ridehub.promotion.service;

import com.ridehub.promotion.domain.*; // for static metamodels
import com.ridehub.promotion.repository.PromotionRepository;
import com.ridehub.promotion.service.criteria.PromotionCriteria;
import com.ridehub.promotion.service.dto.BuyNGetMFreeDTO;
import com.ridehub.promotion.service.dto.ConditionByDateDTO;
import com.ridehub.promotion.service.dto.ConditionByLocationDTO;
import com.ridehub.promotion.service.dto.ConditionByRouteDTO;
import com.ridehub.promotion.service.dto.ConditionDateItemDTO;
import com.ridehub.promotion.service.dto.ConditionLocationItemDTO;
import com.ridehub.promotion.service.dto.ConditionRouteItemDTO;
import com.ridehub.promotion.service.dto.FilePromotionDTO;
import com.ridehub.promotion.service.dto.PercentOffTotalDTO;
import com.ridehub.promotion.service.dto.PromotionDTO;
import com.ridehub.promotion.service.dto.PromotionDetailDTO;
import com.ridehub.promotion.service.mapper.PromotionMapper;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.JoinType;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.QueryService;

/**
 * Service for executing complex queries for {@link Promotion} entities in the
 * database.
 * The main input is a {@link PromotionCriteria} which gets converted to
 * {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link Page} of {@link PromotionDTO} which fulfills the
 * criteria.
 */
@Service
@Transactional(readOnly = true)
public class PromotionQueryService extends QueryService<Promotion> {

    private static final Logger LOG = LoggerFactory.getLogger(PromotionQueryService.class);

    private final PromotionRepository promotionRepository;

    private final PromotionMapper promotionMapper;

    public PromotionQueryService(PromotionRepository promotionRepository, PromotionMapper promotionMapper) {
        this.promotionRepository = promotionRepository;
        this.promotionMapper = promotionMapper;
    }

    /**
     * Return a {@link Page} of {@link PromotionDTO} which matches the criteria from
     * the database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @param page     The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<PromotionDTO> findByCriteria(PromotionCriteria criteria, Pageable page) {
        LOG.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<Promotion> specification = createSpecification(criteria);
        return promotionRepository.findAll(specification, page).map(promotionMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(PromotionCriteria criteria) {
        LOG.debug("count by criteria : {}", criteria);
        final Specification<Promotion> specification = createSpecification(criteria);
        return promotionRepository.count(specification);
    }

    /**
     * Function to convert {@link PromotionCriteria} to a {@link Specification}
     * 
     * @param criteria The object which holds all the filters, which the entities
     *                 should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<Promotion> createSpecification(PromotionCriteria criteria) {
        Specification<Promotion> specification = Specification.where(null);
        if (criteria != null) {
            // This has to be called first, because the distinct method returns null
            specification = Specification.allOf(
                    Boolean.TRUE.equals(criteria.getDistinct()) ? distinct(criteria.getDistinct()) : null,
                    buildRangeSpecification(criteria.getId(), Promotion_.id),
                    buildStringSpecification(criteria.getCode(), Promotion_.code),
                    buildStringSpecification(criteria.getDescription(), Promotion_.description),
                    buildRangeSpecification(criteria.getStartDate(), Promotion_.startDate),
                    buildRangeSpecification(criteria.getEndDate(), Promotion_.endDate),
                    buildRangeSpecification(criteria.getUsageLimit(), Promotion_.usageLimit),
                    buildRangeSpecification(criteria.getUsedCount(), Promotion_.usedCount),
                    buildRangeSpecification(criteria.getCreatedAt(), Promotion_.createdAt),
                    buildRangeSpecification(criteria.getUpdatedAt(), Promotion_.updatedAt),
                    buildSpecification(criteria.getIsDeleted(), Promotion_.isDeleted),
                    buildRangeSpecification(criteria.getDeletedAt(), Promotion_.deletedAt),
                    buildSpecification(criteria.getDeletedBy(), Promotion_.deletedBy),
                    buildSpecification(criteria.getBuyNGetMId(),
                            root -> root.join(Promotion_.buyNGetMS, JoinType.LEFT).get(BuyNGetMFree_.id)),
                    buildSpecification(criteria.getPercentOffId(),
                            root -> root.join(Promotion_.percentOffs, JoinType.LEFT).get(PercentOffTotal_.id)),
                    buildSpecification(criteria.getConditionsRId(),
                            root -> root.join(Promotion_.conditionsRS, JoinType.LEFT).get(ConditionByRoute_.id)),
                    buildSpecification(criteria.getConditionsDId(),
                            root -> root.join(Promotion_.conditionsDS, JoinType.LEFT).get(ConditionByDate_.id)),
                    buildSpecification(criteria.getConditionsLocId(),
                            root -> root.join(Promotion_.conditionsLocs, JoinType.LEFT).get(ConditionByLocation_.id)));
        }
        return specification;
    }

    @Transactional(readOnly = true)
    public Page<PromotionDetailDTO> getAllDetail(Pageable pageable) {
        // Step 1: page the IDs only
        Page<Long> idPage = promotionRepository.findPageIds(pageable);
        // List<Long> ids = idPage.getContent();
        List<Long> ids = idPage.getContent().stream().limit(1).toList();
        if (ids.isEmpty()) {
            return new PageImpl<>(List.of(), pageable, idPage.getTotalElements());
        }

        // Step 2: load full graph for these IDs (no pagination)
        List<Promotion> loaded = promotionRepository.findAllDetailByIdIn(ids);

        // Step 3: preserve original page order
        Map<Long, Promotion> byId = loaded.stream()
                .collect(Collectors.toMap(Promotion::getId, p -> p));

        List<PromotionDetailDTO> dtos = ids.stream()
                .map(byId::get)
                .filter(Objects::nonNull)
                .map(this::convertToPromotionDetailDTO)
                .collect(Collectors.toList());

        return new PageImpl<>(dtos, pageable, idPage.getTotalElements());
    }

    @Transactional(readOnly = true)
    public PromotionDetailDTO getDetailById(Long id) {
        Promotion p = promotionRepository.findDetailById(id)
                .orElseThrow(() -> new EntityNotFoundException("Promotion not found: " + id));
        return convertToPromotionDetailDTO(p);
    }

    @Transactional(readOnly = true)
    public PromotionDetailDTO getDetailByIdByCode(String code) {
        Promotion p = promotionRepository.findDetailByCode(code)
                .orElseThrow(() -> new EntityNotFoundException("Promotion not found: " + code));

        // Filter out soft-deleted entities
        filterSoftDeleted(p);

        return convertToPromotionDetailDTO(p);
    }

    /**
     * Convert a Promotion entity (with children preloaded by EntityGraph)
     * into a PromotionDetailDTO manually.
     */
    private PromotionDetailDTO convertToPromotionDetailDTO(Promotion promotion) {
        PromotionDetailDTO dto = new PromotionDetailDTO();

        // ===== Basic fields =====
        dto.setId(promotion.getId());
        dto.setCode(promotion.getCode());
        dto.setDescription(promotion.getDescription());
        dto.setStartDate(promotion.getStartDate());
        dto.setEndDate(promotion.getEndDate());
        dto.setUsageLimit(promotion.getUsageLimit());
        dto.setUsedCount(promotion.getUsedCount());
        dto.setCreatedAt(promotion.getCreatedAt());
        dto.setUpdatedAt(promotion.getUpdatedAt());
        dto.setIsDeleted(promotion.getIsDeleted());
        dto.setDeletedAt(promotion.getDeletedAt());
        dto.setDeletedBy(promotion.getDeletedBy());

        // ===== Buy N Get M =====
        if (promotion.getBuyNGetMS() != null) {
            dto.setBuyNGetMS(
                    promotion.getBuyNGetMS().stream().map(b -> {
                        BuyNGetMFreeDTO bdto = new BuyNGetMFreeDTO();
                        bdto.setId(b.getId());
                        bdto.setBuyN(b.getBuyN());
                        bdto.setGetM(b.getGetM());
                        bdto.setCreatedAt(b.getCreatedAt());
                        bdto.setUpdatedAt(b.getUpdatedAt());
                        bdto.setIsDeleted(b.getIsDeleted());
                        bdto.setDeletedAt(b.getDeletedAt());
                        bdto.setDeletedBy(b.getDeletedBy());
                        return bdto;
                    }).collect(Collectors.toSet()));
        }

        // ===== Percent Off Total =====
        if (promotion.getPercentOffs() != null) {
            dto.setPercentOffs(
                    promotion.getPercentOffs().stream().map(p -> {
                        PercentOffTotalDTO pdto = new PercentOffTotalDTO();
                        pdto.setId(p.getId());
                        pdto.setPercent(p.getPercent());
                        pdto.setMaxOff(p.getMaxOff());
                        pdto.setMinPrice(p.getMinPrice());
                        pdto.setCreatedAt(p.getCreatedAt());
                        pdto.setUpdatedAt(p.getUpdatedAt());
                        pdto.setIsDeleted(p.getIsDeleted());
                        pdto.setDeletedAt(p.getDeletedAt());
                        pdto.setDeletedBy(p.getDeletedBy());
                        return pdto;
                    }).collect(Collectors.toSet()));
        }

        // ===== Condition By Route =====
        if (promotion.getConditionsRS() != null) {
            dto.setConditionsRS(
                    promotion.getConditionsRS().stream().map(cond -> {
                        ConditionByRouteDTO cdto = new ConditionByRouteDTO();
                        cdto.setId(cond.getId());
                        cdto.setCreatedAt(cond.getCreatedAt());
                        cdto.setUpdatedAt(cond.getUpdatedAt());
                        cdto.setIsDeleted(cond.getIsDeleted());
                        cdto.setDeletedAt(cond.getDeletedAt());
                        cdto.setDeletedBy(cond.getDeletedBy());

                        if (cond.getItems() != null) {
                            cdto.setItems(
                                    cond.getItems().stream().map(item -> {
                                        ConditionRouteItemDTO idto = new ConditionRouteItemDTO();
                                        idto.setId(item.getId());
                                        idto.setRouteId(item.getRouteId());
                                        idto.setCreatedAt(item.getCreatedAt());
                                        idto.setUpdatedAt(item.getUpdatedAt());
                                        idto.setIsDeleted(item.getIsDeleted());
                                        idto.setDeletedAt(item.getDeletedAt());
                                        idto.setDeletedBy(item.getDeletedBy());
                                        return idto;
                                    }).collect(Collectors.toSet()));
                        }
                        return cdto;
                    }).collect(Collectors.toSet()));
        }

        // ===== Condition By Date =====
        if (promotion.getConditionsDS() != null) {
            dto.setConditionsDS(
                    promotion.getConditionsDS().stream().map(cond -> {
                        ConditionByDateDTO cdto = new ConditionByDateDTO();
                        cdto.setId(cond.getId());
                        cdto.setCreatedAt(cond.getCreatedAt());
                        cdto.setUpdatedAt(cond.getUpdatedAt());
                        cdto.setIsDeleted(cond.getIsDeleted());
                        cdto.setDeletedAt(cond.getDeletedAt());
                        cdto.setDeletedBy(cond.getDeletedBy());

                        if (cond.getItems() != null) {
                            cdto.setItems(
                                    cond.getItems().stream().map(item -> {
                                        ConditionDateItemDTO idto = new ConditionDateItemDTO();
                                        idto.setId(item.getId());
                                        idto.setSpecificDate(item.getSpecificDate());
                                        idto.setWeekday(item.getWeekday());
                                        idto.setCreatedAt(item.getCreatedAt());
                                        idto.setUpdatedAt(item.getUpdatedAt());
                                        idto.setIsDeleted(item.getIsDeleted());
                                        idto.setDeletedAt(item.getDeletedAt());
                                        idto.setDeletedBy(item.getDeletedBy());
                                        return idto;
                                    }).collect(Collectors.toSet()));
                        }
                        return cdto;
                    }).collect(Collectors.toSet()));
        }

        // ===== Condition By Location =====
        if (promotion.getConditionsLocs() != null) {
            dto.setConditionsLocs(
                    promotion.getConditionsLocs().stream().map(cond -> {
                        ConditionByLocationDTO cdto = new ConditionByLocationDTO();
                        cdto.setId(cond.getId());
                        cdto.setCreatedAt(cond.getCreatedAt());
                        cdto.setUpdatedAt(cond.getUpdatedAt());
                        cdto.setIsDeleted(cond.getIsDeleted());
                        cdto.setDeletedAt(cond.getDeletedAt());
                        cdto.setDeletedBy(cond.getDeletedBy());

                        if (cond.getItems() != null) {
                            cdto.setItems(
                                    cond.getItems().stream().map(item -> {
                                        ConditionLocationItemDTO idto = new ConditionLocationItemDTO();
                                        idto.setId(item.getId());
                                        idto.setProvinceId(item.getProvinceId());
                                        idto.setDistrictId(item.getDistrictId());
                                        idto.setWardId(item.getWardId());
                                        idto.setCreatedAt(item.getCreatedAt());
                                        idto.setUpdatedAt(item.getUpdatedAt());
                                        idto.setIsDeleted(item.getIsDeleted());
                                        idto.setDeletedAt(item.getDeletedAt());
                                        idto.setDeletedBy(item.getDeletedBy());
                                        return idto;
                                    }).collect(Collectors.toSet()));
                        }
                        return cdto;
                    }).collect(Collectors.toSet()));
        }

        return dto;
    }

    private void filterSoftDeleted(Promotion promotion) {
        // Filter parent collections
        if (promotion.getBuyNGetMS() != null) {
            promotion.getBuyNGetMS().removeIf(item -> item.getIsDeleted() != null && item.getIsDeleted());
        }

        if (promotion.getPercentOffs() != null) {
            promotion.getPercentOffs().removeIf(item -> item.getIsDeleted() != null && item.getIsDeleted());
        }

        if (promotion.getConditionsRS() != null) {
            promotion.getConditionsRS().removeIf(item -> item.getIsDeleted() != null && item.getIsDeleted());
            // Filter child items
            promotion.getConditionsRS().forEach(crs -> {
                if (crs.getItems() != null) {
                    crs.getItems().removeIf(child -> child.getIsDeleted() != null && child.getIsDeleted());
                }
            });
        }

        if (promotion.getConditionsDS() != null) {
            promotion.getConditionsDS().removeIf(item -> item.getIsDeleted() != null && item.getIsDeleted());
            // Filter child items
            promotion.getConditionsDS().forEach(cds -> {
                if (cds.getItems() != null) {
                    cds.getItems().removeIf(child -> child.getIsDeleted() != null && child.getIsDeleted());
                }
            });
        }

        if (promotion.getConditionsLocs() != null) {
            promotion.getConditionsLocs().removeIf(item -> item.getIsDeleted() != null && item.getIsDeleted());
            // Filter child items
            promotion.getConditionsLocs().forEach(cl -> {
                if (cl.getItems() != null) {
                    cl.getItems().removeIf(child -> child.getIsDeleted() != null && child.getIsDeleted());
                }
            });
        }
    }

}