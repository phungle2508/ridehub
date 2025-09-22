package com.ridehub.booking.repository;

import com.ridehub.booking.domain.PricingSnapshot;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the PricingSnapshot entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PricingSnapshotRepository extends JpaRepository<PricingSnapshot, Long>, JpaSpecificationExecutor<PricingSnapshot> {}
