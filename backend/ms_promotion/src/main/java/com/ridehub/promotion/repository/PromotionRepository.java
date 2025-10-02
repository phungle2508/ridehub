package com.ridehub.promotion.repository;

import com.ridehub.promotion.domain.Promotion;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Promotion entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long>, JpaSpecificationExecutor<Promotion> {
        @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {
                        "bannerImg",
                        "buyNGetMS",
                        "percentOffs",
                        "conditionsRS", "conditionsRS.items",
                        "conditionsDS", "conditionsDS.items",
                        "conditionsLocs", "conditionsLocs.items"
        })
        @Query("select distinct p from Promotion p")
        Page<Promotion> findAllDetail(Pageable pageable);

        // Step 1: page just the IDs (sorted by whatever Sort is on the Pageable)
        @Query("select p.id from Promotion p")
        Page<Long> findPageIds(Pageable pageable);

        // Step 2: fetch full graph for those IDs (NO pagination here)
        @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {
                        "buyNGetMS",
                        "percentOffs",
                        "conditionsRS", "conditionsRS.items",
                        "conditionsDS", "conditionsDS.items",
                        "conditionsLocs", "conditionsLocs.items"
        })
        @Query("select distinct p from Promotion p where p.id in :ids")
        List<Promotion> findAllDetailByIdIn(@Param("ids") List<Long> ids);

        @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {
                        "buyNGetMS",
                        "percentOffs",
                        "conditionsRS", "conditionsRS.items",
                        "conditionsDS", "conditionsDS.items",
                        "conditionsLocs", "conditionsLocs.items"
        })
        Optional<Promotion> findDetailById(Long id);

        @EntityGraph(type = EntityGraph.EntityGraphType.LOAD, attributePaths = {
                        "buyNGetMS",
                        "percentOffs",
                        "conditionsRS", "conditionsRS.items",
                        "conditionsDS", "conditionsDS.items",
                        "conditionsLocs", "conditionsLocs.items"
        })
        Optional<Promotion> findDetailByCode(String code);
}
