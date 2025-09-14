package com.ticketsystem.route.repository;

import com.ticketsystem.route.domain.ReviewSummary;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the ReviewSummary entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ReviewSummaryRepository extends JpaRepository<ReviewSummary, Long>, JpaSpecificationExecutor<ReviewSummary> {}
