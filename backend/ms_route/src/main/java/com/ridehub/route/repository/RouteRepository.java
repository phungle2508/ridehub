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

    /**
     * Find all routes where the station is either origin or destination
     */
    @EntityGraph(attributePaths = {
                    "origin",
                    "origin.address",
                    "origin.address.ward",
                    "origin.address.ward.district",
                    "origin.address.ward.district.province",
                    "destination",
                    "destination.address",
                    "destination.address.ward",
                    "destination.address.ward.district",
                    "destination.address.ward.district.province"
    })
    @Query(value = """
                        SELECT DISTINCT r
                        FROM Route r
                        WHERE r.origin = :station OR r.destination = :station
                    """, countQuery = """
                        SELECT COUNT(DISTINCT r)
                        FROM Route r
                        WHERE r.origin = :station OR r.destination = :station
                    """)
    Page<Route> findByOriginOrDestination(@Param("station") Station station, Pageable pageable);

    @Query("""
            SELECT COUNT(DISTINCT r)
            FROM Route r
            WHERE r.origin = :station OR r.destination = :station
            """)
    long countByOriginOrDestination(@Param("station") Station station);

    @Query("""
                SELECT r.origin.id AS stationId, COUNT(DISTINCT r.id) AS routeCount
                FROM Route r
                WHERE r.origin.id IN :stationIds
                   OR r.destination.id IN :stationIds
                GROUP BY r.origin.id
            """)
    List<Object[]> countRoutesByStationIds(@Param("stationIds") List<Long> stationIds);

}
