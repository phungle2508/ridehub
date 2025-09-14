package com.ticketsystem.route.repository;

import com.ticketsystem.route.domain.Operator;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Operator entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OperatorRepository extends JpaRepository<Operator, Long>, JpaSpecificationExecutor<Operator> {}
