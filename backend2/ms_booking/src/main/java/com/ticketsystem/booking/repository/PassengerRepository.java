package com.ticketsystem.booking.repository;

import com.ticketsystem.booking.domain.Passenger;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Passenger entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long>, JpaSpecificationExecutor<Passenger> {}
