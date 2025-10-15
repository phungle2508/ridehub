package com.ridehub.route.service.impl;

import com.ridehub.route.domain.SeatLock;
import com.ridehub.route.domain.Trip;
import com.ridehub.route.domain.enumeration.LockStatus;
import com.ridehub.route.repository.SeatLockRepository;
import com.ridehub.route.repository.TripRepository;
import com.ridehub.route.service.SeatLockQueryService;
import com.ridehub.route.service.dto.request.ConfirmGroupRequestDTO;
import com.ridehub.route.service.dto.response.SeatLockActionResponseDTO;
import com.ridehub.route.service.mapper.SeatLockMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SeatLockServiceImplReclaimTest {

    @Mock
    private SeatLockRepository seatLockRepository;

    @Mock
    private TripRepository tripRepository;

    @Mock
    private SeatLockQueryService queryService;

    @Mock
    private SeatLockMapper seatLockMapper;

    @InjectMocks
    private SeatLockServiceImpl seatLockService;

    private Trip testTrip;
    private SeatLock bookingLock;
    private SeatLock expiredLock;
    private Instant now;

    @BeforeEach
    void setUp() {
        now = Instant.now();
        
        // Create test trip
        testTrip = new Trip();
        testTrip.setId(1L);
        
        // Create booking lock (current booking's seat lock)
        bookingLock = new SeatLock();
        bookingLock.setId(1L);
        bookingLock.setSeatNo("A1");
        bookingLock.setTrip(testTrip);
        bookingLock.setBookingId(100L);
        bookingLock.setStatus(LockStatus.HELD);
        bookingLock.setExpiresAt(now.plusSeconds(300)); // Not expired
        
        // Create expired lock (expired seat with same seat and trip)
        expiredLock = new SeatLock();
        expiredLock.setId(2L);
        expiredLock.setSeatNo("A1");
        expiredLock.setTrip(testTrip);
        expiredLock.setBookingId(null); // Not held by any booking
        expiredLock.setStatus(LockStatus.EXPIRED);
        expiredLock.setExpiresAt(now.minusSeconds(60)); // Expired
    }

    @Test
    void reclaimExpiredSeats_Success() {
        // Given
        ConfirmGroupRequestDTO request = new ConfirmGroupRequestDTO();
        request.setBookingId(100L);
        
        when(queryService.findByBookingId(100L)).thenReturn(Arrays.asList(bookingLock));
        when(seatLockRepository.saveAll(any())).thenReturn(Arrays.asList(expiredLock));
        
        // Mock the helper method call with any() for Instant to avoid timing issues
        SeatLockServiceImpl spyService = spy(seatLockService);
        doReturn(Arrays.asList(expiredLock)).when(spyService).findExpiredLocksOrHeldBySeatAndTrip(eq("A1"), eq(1L), any(Instant.class));
        
        // When
        SeatLockActionResponseDTO response = spyService.reclaimExpiredSeats(request);
        
        // Then
        assertEquals("RECLAIMED", response.getStatus());
        assertEquals("Reclaimed 1 expired seats", response.getMessage());
        
        verify(seatLockRepository).saveAll(any());
    }

    @Test
    void reclaimExpiredSeats_NoBookingId() {
        // Given
        ConfirmGroupRequestDTO request = new ConfirmGroupRequestDTO();
        request.setBookingId(null);
        
        // When
        SeatLockActionResponseDTO response = seatLockService.reclaimExpiredSeats(request);
        
        // Then
        assertEquals("BAD_REQUEST", response.getStatus());
        assertEquals("Provide bookingId", response.getMessage());
        
        verifyNoInteractions(queryService, seatLockRepository);
    }

    @Test
    void reclaimExpiredSeats_NoBookingLocksFound() {
        // Given
        ConfirmGroupRequestDTO request = new ConfirmGroupRequestDTO();
        request.setBookingId(100L);
        
        when(queryService.findByBookingId(100L)).thenReturn(Collections.emptyList());
        
        // When
        SeatLockActionResponseDTO response = seatLockService.reclaimExpiredSeats(request);
        
        // Then
        assertEquals("NOT_FOUND", response.getStatus());
        assertEquals("No seat locks found for booking", response.getMessage());
        
        verify(queryService).findByBookingId(100L);
        verifyNoInteractions(seatLockRepository);
    }

    @Test
    void reclaimExpiredSeats_NoExpiredSeatsToReclaim() {
        // Given
        ConfirmGroupRequestDTO request = new ConfirmGroupRequestDTO();
        request.setBookingId(100L);
        
        when(queryService.findByBookingId(100L)).thenReturn(Arrays.asList(bookingLock));
        
        SeatLockServiceImpl spyService = spy(seatLockService);
        doReturn(Collections.emptyList()).when(spyService).findExpiredLocksOrHeldBySeatAndTrip(eq("A1"), eq(1L), any(Instant.class));
        
        // When
        SeatLockActionResponseDTO response = spyService.reclaimExpiredSeats(request);
        
        // Then
        assertEquals("NOT_FOUND", response.getStatus());
        assertEquals("No expired seats available to reclaim", response.getMessage());
        
        verifyNoInteractions(seatLockRepository);
    }
}
