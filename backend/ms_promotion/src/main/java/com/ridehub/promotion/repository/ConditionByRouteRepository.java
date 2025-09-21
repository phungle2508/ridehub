package com.ridehub.promotion.repository;

import com.ridehub.promotion.domain.ConditionByRoute;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the ConditionByRoute entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ConditionByRouteRepository extends JpaRepository<ConditionByRoute, Long>, JpaSpecificationExecutor<ConditionByRoute> {}
