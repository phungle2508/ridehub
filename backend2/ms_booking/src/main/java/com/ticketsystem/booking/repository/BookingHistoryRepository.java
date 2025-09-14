package com.ticketsystem.booking.repository;

import com.ticketsystem.booking.domain.BookingHistory;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the BookingHistory entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BookingHistoryRepository extends JpaRepository<BookingHistory, Long>, JpaSpecificationExecutor<BookingHistory> {}
