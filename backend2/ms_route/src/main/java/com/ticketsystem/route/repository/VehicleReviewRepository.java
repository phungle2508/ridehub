package com.ticketsystem.route.repository;

import com.ticketsystem.route.domain.VehicleReview;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the VehicleReview entity.
 */
@SuppressWarnings("unused")
@Repository
public interface VehicleReviewRepository extends JpaRepository<VehicleReview, Long>, JpaSpecificationExecutor<VehicleReview> {}
