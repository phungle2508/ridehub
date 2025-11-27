package com.ridehub.booking.repository;

import com.ridehub.booking.domain.AppliedPromotion;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the AppliedPromotion entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AppliedPromotionRepository extends JpaRepository<AppliedPromotion, Long>, JpaSpecificationExecutor<AppliedPromotion> {}
