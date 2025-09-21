package com.ridehub.promotion.repository;

import com.ridehub.promotion.domain.ConditionRouteItem;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the ConditionRouteItem entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ConditionRouteItemRepository
    extends JpaRepository<ConditionRouteItem, Long>, JpaSpecificationExecutor<ConditionRouteItem> {}
