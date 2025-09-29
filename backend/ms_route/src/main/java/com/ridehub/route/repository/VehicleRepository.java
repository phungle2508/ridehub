package com.ridehub.route.repository;

import com.ridehub.route.domain.Vehicle;
import com.ridehub.route.service.dto.VehicleListDTO;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Vehicle entity.
 */
@SuppressWarnings("unused")
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long>, JpaSpecificationExecutor<Vehicle> {

    /**
     * Get all vehicles with their current route assignments and driver information.
     * This query joins Vehicle with Trip, Route, and Driver to get comprehensive
     * vehicle list data.
     */
    @EntityGraph(attributePaths = { "seatMap", "seatMap.seatMapImg" })
    @Query("""
            SELECT v
            FROM Vehicle v
            WHERE (v.isDeleted IS NULL OR v.isDeleted = false)
            ORDER BY v.plateNumber ASC
            """)
    Page<Vehicle> findVehicleListWithDetails(Pageable pageable);

    @EntityGraph(attributePaths = { "seatMap", "seatMap.seatMapImg", "vehicleImg" })
    Optional<Vehicle> findDetailById(Long id);
}
