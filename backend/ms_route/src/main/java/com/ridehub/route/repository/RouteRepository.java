package com.ridehub.route.repository;

import com.ridehub.route.domain.Route;
import com.ridehub.route.domain.Station;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Spring Data JPA repository for the Route entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RouteRepository extends JpaRepository<Route, Long>, JpaSpecificationExecutor<Route> {
}
