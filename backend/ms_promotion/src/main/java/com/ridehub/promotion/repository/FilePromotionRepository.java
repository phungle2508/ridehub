package com.ridehub.promotion.repository;

import com.ridehub.promotion.domain.FilePromotion;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the FilePromotion entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FilePromotionRepository extends JpaRepository<FilePromotion, Long>, JpaSpecificationExecutor<FilePromotion> {}
