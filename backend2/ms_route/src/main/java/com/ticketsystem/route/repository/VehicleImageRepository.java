package com.ticketsystem.route.repository;

import com.ticketsystem.route.domain.VehicleImage;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the VehicleImage entity.
 */
@SuppressWarnings("unused")
@Repository
public interface VehicleImageRepository extends JpaRepository<VehicleImage, Long>, JpaSpecificationExecutor<VehicleImage> {}
