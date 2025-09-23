package com.ridehub.booking.repository;

import com.ridehub.booking.domain.FileBooking;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the FileBooking entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FileBookingRepository extends JpaRepository<FileBooking, Long>, JpaSpecificationExecutor<FileBooking> {}
