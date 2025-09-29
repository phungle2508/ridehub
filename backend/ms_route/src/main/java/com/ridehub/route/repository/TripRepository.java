package com.ridehub.route.repository;

import com.ridehub.route.domain.Trip;
import java.time.Instant;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Trip entity.
 */
@Repository
public interface TripRepository extends JpaRepository<Trip, Long>, JpaSpecificationExecutor<Trip> {
    @EntityGraph(attributePaths = { "route", "route.origin", "route.destination", "vehicle", "driver", "driver.staff", "attendant", "attendant.staff" })
    @Query("select t from Trip t where t.isDeleted = false or t.isDeleted is null")
    Page<Trip> findAllWithDetails(Pageable pageable);

    @EntityGraph(attributePaths = { "route", "route.origin", "route.destination", "driver" })
    Optional<Trip> findFirstByVehicleIdAndDepartureTimeGreaterThanEqualAndIsDeletedFalseOrderByDepartureTimeAsc(
        Long vehicleId, Instant departureTime);

    // Alternative method that handles null isDeleted values
    @EntityGraph(attributePaths = { "route", "route.origin", "route.destination", "driver" })
    @Query("""
              select t from Trip t
              where t.vehicle.id = :vehicleId
                and t.departureTime >= :departureTime
                and (t.isDeleted = false or t.isDeleted is null)
              order by t.departureTime asc
            """)
    Optional<Trip> findNextTrip(@Param("vehicleId") Long vehicleId,
            @Param("departureTime") Instant departureTime);

    // Debug method to count trips for a vehicle
    @Query("select count(t) from Trip t where t.vehicle.id = :vehicleId")
    long countTripsByVehicleId(@Param("vehicleId") Long vehicleId);

}
