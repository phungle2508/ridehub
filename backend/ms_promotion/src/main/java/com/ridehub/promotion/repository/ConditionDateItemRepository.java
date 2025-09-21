package com.ridehub.promotion.repository;

import com.ridehub.promotion.domain.ConditionDateItem;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the ConditionDateItem entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ConditionDateItemRepository extends JpaRepository<ConditionDateItem, Long>, JpaSpecificationExecutor<ConditionDateItem> {}
