package com.ridehub.promotion.repository;

import com.ridehub.promotion.domain.ConditionLocationItem;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the ConditionLocationItem entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ConditionLocationItemRepository
    extends JpaRepository<ConditionLocationItem, Long>, JpaSpecificationExecutor<ConditionLocationItem> {}
