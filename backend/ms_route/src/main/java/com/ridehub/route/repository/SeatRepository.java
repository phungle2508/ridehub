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
}
