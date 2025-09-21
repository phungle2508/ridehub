package com.ridehub.promotion.repository;

import com.ridehub.promotion.domain.PercentOffTotal;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the PercentOffTotal entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PercentOffTotalRepository extends JpaRepository<PercentOffTotal, Long>, JpaSpecificationExecutor<PercentOffTotal> {}
