package com.ticketsystem.route.repository;

import com.ticketsystem.route.domain.Station;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Station entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StationRepository extends JpaRepository<Station, Long>, JpaSpecificationExecutor<Station> {}
