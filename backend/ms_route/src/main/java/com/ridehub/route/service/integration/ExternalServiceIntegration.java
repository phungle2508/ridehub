package com.ridehub.route.service.integration;

import com.ridehub.route.service.dto.external.BookingDTO;
import com.ridehub.route.service.dto.external.CustomerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service Interface for integrating with external microservices.
 */
public interface ExternalServiceIntegration {

    /**
     * Get booking by ID from msbooking service.
     *
     * @param bookingId the booking ID
     * @return the booking if found
     */
    Optional<BookingDTO> getBookingById(UUID bookingId);

    /**
     * Get bookings by trip ID from msbooking service.
     *
     * @param tripId the trip ID
     * @param pageable the pagination information
     * @return the list of bookings for the trip
     */
    Page<BookingDTO> getBookingsByTrip(Long tripId, Pageable pageable);

    /**
     * Get bookings by customer ID from msbooking service.
     *
     * @param customerId the customer ID
     * @param pageable the pagination information
     * @return the list of bookings for the customer
     */
    Page<BookingDTO> getBookingsByCustomer(UUID customerId, Pageable pageable);

    /**
     * Get all bookings with pagination from msbooking service.
     *
     * @param pageable the pagination information
     * @return the list of all bookings
     */
    Page<BookingDTO> getAllBookings(Pageable pageable);

    /**
     * Search bookings by query from msbooking service.
     *
     * @param query the search query
     * @param pageable the pagination information
     * @return the list of matching bookings
     */
    Page<BookingDTO> searchBookings(String query, Pageable pageable);

    /**
     * Get customer by ID from msuser service.
     *
     * @param customerId the customer ID
     * @return the customer if found
     */
    Optional<CustomerDTO> getCustomerById(UUID customerId);

    /**
     * Get customers by IDs from msuser service.
     *
     * @param customerIds the list of customer IDs
     * @return the list of customers
     */
    List<CustomerDTO> getCustomersByIds(List<UUID> customerIds);

    /**
     * Search customers by query from msuser service.
     *
     * @param query the search query
     * @param pageable the pagination information
     * @return the list of matching customers
     */
    Page<CustomerDTO> searchCustomers(String query, Pageable pageable);

    /**
     * Update booking status in msbooking service.
     *
     * @param bookingId the booking ID
     * @param newStatus the new status
     * @return the updated booking
     */
    Optional<BookingDTO> updateBookingStatus(UUID bookingId, String newStatus);
}
