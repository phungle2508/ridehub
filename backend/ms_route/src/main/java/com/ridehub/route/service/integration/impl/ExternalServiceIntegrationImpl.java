package com.ridehub.route.service.integration.impl;

import com.ridehub.msbooking.client.api.BookingResourceMsbookingApi;
import com.ridehub.msbooking.client.api.TicketResourceMsbookingApi;
import com.ridehub.msuser.client.api.AppUserResourceMsuserApi;
import com.ridehub.route.service.dto.external.BookingDTO;
import com.ridehub.route.service.dto.external.CustomerDTO;
import com.ridehub.route.service.integration.ExternalServiceIntegration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Service Implementation for integrating with external microservices.
 */
@Service
public class ExternalServiceIntegrationImpl implements ExternalServiceIntegration {

    private static final Logger LOG = LoggerFactory.getLogger(ExternalServiceIntegrationImpl.class);

    private final BookingResourceMsbookingApi bookingApi;
    private final TicketResourceMsbookingApi ticketApi;
    private final AppUserResourceMsuserApi userApi;

    public ExternalServiceIntegrationImpl(
            BookingResourceMsbookingApi bookingApi,
            TicketResourceMsbookingApi ticketApi,
            AppUserResourceMsuserApi userApi) {
        this.bookingApi = bookingApi;
        this.ticketApi = ticketApi;
        this.userApi = userApi;
    }

    @Override
    public Optional<BookingDTO> getBookingById(UUID bookingId) {
        LOG.debug("Request to get booking by ID: {}", bookingId);
        
        try {
            // TODO: Implement actual API call to msbooking service
            // For now, return mock data
            return createMockBookingData().stream()
                    .filter(booking -> bookingId.equals(booking.getId()))
                    .findFirst();
        } catch (Exception e) {
            LOG.error("Error fetching booking by ID: {}", bookingId, e);
            return Optional.empty();
        }
    }

    @Override
    public Page<BookingDTO> getBookingsByTrip(Long tripId, Pageable pageable) {
        LOG.debug("Request to get bookings by trip: {}", tripId);
        
        try {
            // TODO: Implement actual API call to msbooking service
            List<BookingDTO> tripBookings = createMockBookingData().stream()
                    .filter(booking -> tripId.equals(booking.getTripId()))
                    .collect(Collectors.toList());
            
            int start = (int) pageable.getOffset();
            int end = Math.min(start + pageable.getPageSize(), tripBookings.size());
            List<BookingDTO> pageContent = tripBookings.subList(start, end);
            
            return new PageImpl<>(pageContent, pageable, tripBookings.size());
        } catch (Exception e) {
            LOG.error("Error fetching bookings by trip: {}", tripId, e);
            return new PageImpl<>(Collections.emptyList(), pageable, 0);
        }
    }

    @Override
    public Page<BookingDTO> getBookingsByCustomer(UUID customerId, Pageable pageable) {
        LOG.debug("Request to get bookings by customer: {}", customerId);
        
        try {
            // TODO: Implement actual API call to msbooking service
            List<BookingDTO> customerBookings = createMockBookingData().stream()
                    .filter(booking -> customerId.equals(booking.getCustomerId()))
                    .collect(Collectors.toList());
            
            int start = (int) pageable.getOffset();
            int end = Math.min(start + pageable.getPageSize(), customerBookings.size());
            List<BookingDTO> pageContent = customerBookings.subList(start, end);
            
            return new PageImpl<>(pageContent, pageable, customerBookings.size());
        } catch (Exception e) {
            LOG.error("Error fetching bookings by customer: {}", customerId, e);
            return new PageImpl<>(Collections.emptyList(), pageable, 0);
        }
    }

    @Override
    public Page<BookingDTO> getAllBookings(Pageable pageable) {
        LOG.debug("Request to get all bookings");
        
        try {
            // TODO: Implement actual API call to msbooking service
            List<BookingDTO> allBookings = createMockBookingData();
            
            int start = (int) pageable.getOffset();
            int end = Math.min(start + pageable.getPageSize(), allBookings.size());
            List<BookingDTO> pageContent = allBookings.subList(start, end);
            
            return new PageImpl<>(pageContent, pageable, allBookings.size());
        } catch (Exception e) {
            LOG.error("Error fetching all bookings", e);
            return new PageImpl<>(Collections.emptyList(), pageable, 0);
        }
    }

    @Override
    public Page<BookingDTO> searchBookings(String query, Pageable pageable) {
        LOG.debug("Request to search bookings with query: {}", query);
        
        try {
            // TODO: Implement actual API call to msbooking service
            String lowerQuery = query.toLowerCase();
            List<BookingDTO> searchResults = createMockBookingData().stream()
                    .filter(booking -> booking.getBookingCode().toLowerCase().contains(lowerQuery))
                    .collect(Collectors.toList());
            
            int start = (int) pageable.getOffset();
            int end = Math.min(start + pageable.getPageSize(), searchResults.size());
            List<BookingDTO> pageContent = searchResults.subList(start, end);
            
            return new PageImpl<>(pageContent, pageable, searchResults.size());
        } catch (Exception e) {
            LOG.error("Error searching bookings with query: {}", query, e);
            return new PageImpl<>(Collections.emptyList(), pageable, 0);
        }
    }

    @Override
    public Optional<CustomerDTO> getCustomerById(UUID customerId) {
        LOG.debug("Request to get customer by ID: {}", customerId);
        
        try {
            // TODO: Implement actual API call to msuser service
            return createMockCustomerData().stream()
                    .filter(customer -> customerId.equals(customer.getId()))
                    .findFirst();
        } catch (Exception e) {
            LOG.error("Error fetching customer by ID: {}", customerId, e);
            return Optional.empty();
        }
    }

    @Override
    public List<CustomerDTO> getCustomersByIds(List<UUID> customerIds) {
        LOG.debug("Request to get customers by IDs: {}", customerIds);
        
        try {
            // TODO: Implement actual API call to msuser service
            return createMockCustomerData().stream()
                    .filter(customer -> customerIds.contains(customer.getId()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            LOG.error("Error fetching customers by IDs: {}", customerIds, e);
            return Collections.emptyList();
        }
    }

    @Override
    public Page<CustomerDTO> searchCustomers(String query, Pageable pageable) {
        LOG.debug("Request to search customers with query: {}", query);
        
        try {
            // TODO: Implement actual API call to msuser service
            String lowerQuery = query.toLowerCase();
            List<CustomerDTO> searchResults = createMockCustomerData().stream()
                    .filter(customer -> 
                        customer.getFullName().toLowerCase().contains(lowerQuery) ||
                        customer.getPhoneNumber().contains(query) ||
                        customer.getEmail().toLowerCase().contains(lowerQuery))
                    .collect(Collectors.toList());
            
            int start = (int) pageable.getOffset();
            int end = Math.min(start + pageable.getPageSize(), searchResults.size());
            List<CustomerDTO> pageContent = searchResults.subList(start, end);
            
            return new PageImpl<>(pageContent, pageable, searchResults.size());
        } catch (Exception e) {
            LOG.error("Error searching customers with query: {}", query, e);
            return new PageImpl<>(Collections.emptyList(), pageable, 0);
        }
    }

    @Override
    public Optional<BookingDTO> updateBookingStatus(UUID bookingId, String newStatus) {
        LOG.debug("Request to update booking status: {} to {}", bookingId, newStatus);
        
        try {
            // TODO: Implement actual API call to msbooking service
            Optional<BookingDTO> booking = getBookingById(bookingId);
            if (booking.isPresent()) {
                booking.orElseThrow().setStatus(newStatus);
                return booking;
            }
            return Optional.empty();
        } catch (Exception e) {
            LOG.error("Error updating booking status: {}", bookingId, e);
            return Optional.empty();
        }
    }

    // Helper methods for mock data
    private List<BookingDTO> createMockBookingData() {
        List<BookingDTO> mockBookings = new ArrayList<>();
        
        // Mock booking 1
        BookingDTO booking1 = new BookingDTO();
        booking1.setId(UUID.randomUUID());
        booking1.setBookingCode("47291");
        booking1.setCustomerId(UUID.fromString("550e8400-e29b-41d4-a716-446655440001"));
        booking1.setTripId(1L);
        booking1.setStatus("CONFIRMED");
        booking1.setTotalAmount(new BigDecimal("250000"));
        booking1.setSeatNumbers(Arrays.asList("A21", "A22", "+3"));
        booking1.setBookingDate(Instant.now());
        booking1.setDepartureTime(Instant.parse("2025-09-23T08:30:00Z"));
        booking1.setPaymentStatus("PAID");
        booking1.setPaymentMethod("CREDIT_CARD");
        booking1.setCreatedAt(Instant.now());
        mockBookings.add(booking1);

        // Mock booking 2
        BookingDTO booking2 = new BookingDTO();
        booking2.setId(UUID.randomUUID());
        booking2.setBookingCode("47292");
        booking2.setCustomerId(UUID.fromString("550e8400-e29b-41d4-a716-446655440001"));
        booking2.setTripId(2L);
        booking2.setStatus("PENDING");
        booking2.setTotalAmount(new BigDecimal("180000"));
        booking2.setSeatNumbers(Arrays.asList("A21"));
        booking2.setBookingDate(Instant.now());
        booking2.setDepartureTime(Instant.parse("2025-09-23T08:30:00Z"));
        booking2.setPaymentStatus("PENDING");
        booking2.setPaymentMethod("BANK_TRANSFER");
        booking2.setCreatedAt(Instant.now());
        mockBookings.add(booking2);

        return mockBookings;
    }

    private List<CustomerDTO> createMockCustomerData() {
        List<CustomerDTO> mockCustomers = new ArrayList<>();
        
        // Mock customer 1
        CustomerDTO customer1 = new CustomerDTO();
        customer1.setId(UUID.fromString("550e8400-e29b-41d4-a716-446655440001"));
        customer1.setUsername("jose.leos");
        customer1.setEmail("jose.leos@example.com");
        customer1.setFirstName("Jose");
        customer1.setLastName("Leos");
        customer1.setFullName("Jose Leos");
        customer1.setPhoneNumber("0921493489");
        customer1.setDateOfBirth(LocalDate.of(1990, 5, 15));
        customer1.setGender("MALE");
        customer1.setAvatarUrl("https://example.com/avatar1.jpg");
        customer1.setAddress("123 Main St");
        customer1.setCity("Ho Chi Minh City");
        customer1.setCountry("Vietnam");
        customer1.setActive(true);
        customer1.setCreatedAt(Instant.now());
        mockCustomers.add(customer1);

        return mockCustomers;
    }
}
