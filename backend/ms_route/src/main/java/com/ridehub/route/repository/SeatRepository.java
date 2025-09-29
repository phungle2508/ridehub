package com.ridehub.route.repository;

import com.ridehub.route.domain.Seat;
import com.ridehub.route.repository.projection.VehicleSeatCount;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Seat entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SeatRepository extends JpaRepository<Seat, Long>, JpaSpecificationExecutor<Seat> {

  @Query("""
          SELECT v.id AS vehicleId, COUNT(s) AS seatCount
          FROM Seat s
          JOIN s.floor f
          JOIN f.seatMap sm
          JOIN sm.vehicle v
          WHERE v.id IN :vehicleIds
            AND (s.isDeleted = false OR s.isDeleted IS NULL)
            AND (f.isDeleted = false OR f.isDeleted IS NULL)
            AND (v.isDeleted = false OR v.isDeleted IS NULL)
          GROUP BY v.id
      """)
  List<VehicleSeatCount> countSeatsByVehicleIds(@Param("vehicleIds") List<Long> vehicleIds);

  @Query("select s from Seat s where s.floor.id in :floorIds")
  List<Seat> findByFloorIds(@Param("floorIds") Collection<Long> floorIds);
}
