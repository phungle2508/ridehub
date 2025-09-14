package com.ticketsystem.route.repository;

import com.ticketsystem.route.domain.VehicleAmenity;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the VehicleAmenity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface VehicleAmenityRepository extends JpaRepository<VehicleAmenity, Long>, JpaSpecificationExecutor<VehicleAmenity> {}
