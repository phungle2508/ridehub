package com.ridehub.route.service.impl;

import com.ridehub.route.domain.Seat;
import com.ridehub.route.domain.SeatLock;
import com.ridehub.route.domain.Trip;
import com.ridehub.route.domain.enumeration.LockStatus;
import com.ridehub.route.repository.SeatLockRepository;
import com.ridehub.route.repository.TripRepository;
import com.ridehub.route.service.SeatLockQueryService;
import com.ridehub.route.service.SeatLockService;
import com.ridehub.route.service.SeatQueryService;
import com.ridehub.route.service.dto.SeatLockDTO;
import com.ridehub.route.service.dto.request.SeatLockActionRequestDTO;
import com.ridehub.route.service.dto.request.SeatLockRequestDTO;
import com.ridehub.route.service.dto.request.SeatValidateLockRequestDTO;
import com.ridehub.route.service.dto.response.SeatLockActionResponseDTO;
import com.ridehub.route.service.dto.response.SeatLockResponseDTO;
import com.ridehub.route.service.dto.response.SeatValidateLockResponseDTO;
import com.ridehub.route.service.mapper.SeatLockMapper;

import jakarta.persistence.EntityNotFoundException;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing
 * {@link com.ridehub.route.domain.SeatLock}.
 */
@Service
@Transactional
public class SeatLockServiceImpl implements SeatLockService {

    private static final Logger LOG = LoggerFactory.getLogger(SeatLockServiceImpl.class);

    private final SeatLockRepository seatLockRepository;
    private final TripRepository tripRepository;
    private final SeatQueryService seatQueryService;
    private final SeatLockMapper seatLockMapper;
    private final SeatLockQueryService seatLockQueryService;

    private static final int LOCK_DURATION_MINUTES = 20; // 20 minutes lock duration as per PlantUML

    public SeatLockServiceImpl(SeatLockRepository seatLockRepository, TripRepository tripRepository,
            SeatQueryService seatQueryService, SeatLockMapper seatLockMapper,
            SeatLockQueryService seatLockQueryService) {
        this.seatLockRepository = seatLockRepository;
        this.tripRepository = tripRepository;
        this.seatQueryService = seatQueryService;
        this.seatLockMapper = seatLockMapper;
        this.seatLockQueryService = seatLockQueryService;
    }

    @Override
    public SeatLockDTO save(SeatLockDTO seatLockDTO) {
        LOG.debug("Request to save SeatLock : {}", seatLockDTO);
        SeatLock seatLock = seatLockMapper.toEntity(seatLockDTO);
        seatLock = seatLockRepository.save(seatLock);
        return seatLockMapper.toDto(seatLock);
    }

    @Override
    public SeatLockDTO update(SeatLockDTO seatLockDTO) {
        LOG.debug("Request to update SeatLock : {}", seatLockDTO);
        SeatLock seatLock = seatLockMapper.toEntity(seatLockDTO);
        seatLock = seatLockRepository.save(seatLock);
        return seatLockMapper.toDto(seatLock);
    }

    @Override
    public Optional<SeatLockDTO> partialUpdate(SeatLockDTO seatLockDTO) {
        LOG.debug("Request to partially update SeatLock : {}", seatLockDTO);

        return seatLockRepository
                .findById(seatLockDTO.getId())
                .map(existingSeatLock -> {
                    seatLockMapper.partialUpdate(existingSeatLock, seatLockDTO);

                    return existingSeatLock;
                })
                .map(seatLockRepository::save)
                .map(seatLockMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SeatLockDTO> findOne(Long id) {
        LOG.debug("Request to get SeatLock : {}", id);
        return seatLockRepository.findById(id).map(seatLockMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete SeatLock : {}", id);
        seatLockRepository.deleteById(id);
    }

    @Override
    @Transactional
    public SeatLockResponseDTO tryLockSeats(SeatLockRequestDTO request) {
        LOG.debug("Request to lock seats for booking: {}, trip: {}, seats: {}",
                request.getBookingId(), request.getTripId(), request.getSeatNumbers());

        // Idempotency fast-path (this is fine to keep as Optional)
        SeatLock existingLock = seatLockQueryService
                .findByIdempotencyKey(request.getIdemKey())
                .orElse(null);

        if (existingLock != null) {
            LOG.info("Idempotent request detected for key: {}", request.getIdemKey());
            return createResponseFromExistingLock(existingLock, request);
        }

        try {
            // ✅ Use orElseThrow instead of isEmpty()/get()
            Trip trip = tripRepository
                    .findById(request.getTripId())
                    .orElseThrow(() -> new EntityNotFoundException("Trip not found: " + request.getTripId()));

            Instant now = Instant.now();

            // Check current active locks
            List<SeatLock> conflictingLocks = seatLockQueryService.findActiveLocksByTripAndSeats(
                    request.getTripId(), request.getSeatNumbers(), LockStatus.HELD, now);

            if (!conflictingLocks.isEmpty()) {
                List<String> unavailableSeats = conflictingLocks.stream()
                        .map(SeatLock::getSeatNo)
                        .distinct()
                        .toList();

                LOG.warn("Seats {} are not available for trip {}", unavailableSeats, request.getTripId());
                return new SeatLockResponseDTO(
                        "REJECTED",
                        "Seats not available: " + String.join(", ", unavailableSeats),
                        request.getBookingId(),
                        request.getTripId());
            }

            // Proceed with locking
            String lockId = UUID.randomUUID().toString();
            Instant expiresAt = now.plus(LOCK_DURATION_MINUTES, ChronoUnit.MINUTES);

            for (String seatNumber : request.getSeatNumbers()) {
                SeatLock seatLock = new SeatLock();
                seatLock.setSeatNo(seatNumber);
                seatLock.setBookingId(request.getBookingId());
                seatLock.setStatus(LockStatus.HELD);
                seatLock.setExpiresAt(expiresAt);
                seatLock.setIdempotencyKey(request.getIdemKey());
                seatLock.setCreatedAt(now);
                seatLock.setIsDeleted(false);
                seatLock.setTrip(trip);

                seatLockRepository.save(seatLock);
            }

            SeatLockResponseDTO response = new SeatLockResponseDTO();
            response.setStatus("HELD");
            response.setMessage("Seats successfully locked");
            response.setBookingId(request.getBookingId());
            response.setTripId(request.getTripId());
            response.setLockId(lockId);
            response.setExpiresAt(expiresAt.getEpochSecond());

            LOG.info("Successfully locked {} seats for booking {} with lockId {}",
                    request.getSeatNumbers().size(), request.getBookingId(), lockId);

            return response;

        } catch (EntityNotFoundException e) { // ✅ map not-found to REJECTED (not 500)
            LOG.warn("Trip not found: {}", request.getTripId());
            return new SeatLockResponseDTO("REJECTED", "Trip not found",
                    request.getBookingId(), request.getTripId());

        } catch (Exception e) {
            LOG.error("Error processing seat lock request for booking {}: {}",
                    request.getBookingId(), e.getMessage(), e);

            return new SeatLockResponseDTO("REJECTED",
                    "Internal error occurred while processing seat lock",
                    request.getBookingId(), request.getTripId());
        }
    }

    private SeatLockResponseDTO createResponseFromExistingLock(SeatLock existingLock, SeatLockRequestDTO request) {
        SeatLockResponseDTO response = new SeatLockResponseDTO();
        response.setBookingId(request.getBookingId());
        response.setTripId(request.getTripId());

        Instant now = Instant.now(); // capture once

        boolean valid = existingLock.getExpiresAt().isAfter(now)
                && LockStatus.HELD.equals(existingLock.getStatus())
                && (existingLock.getIsDeleted() == null || !existingLock.getIsDeleted());

        if (valid) {
            response.setStatus("HELD");
            response.setMessage("Seats successfully locked (cached)");
            response.setExpiresAt(existingLock.getExpiresAt().getEpochSecond());
        } else {
            response.setStatus("REJECTED");
            response.setMessage("Seats not available (cached)");
        }
        return response;
    }

    @Override
    @Transactional
    public SeatLockActionResponseDTO confirmSeatLocks(SeatLockActionRequestDTO request) {
        LOG.debug("Request to confirm seat locks for booking: {}", request.getBookingId());

        List<SeatLock> seatLocks = seatLockQueryService.findByBookingId(request.getBookingId());

        if (seatLocks.isEmpty()) {
            return new SeatLockActionResponseDTO("REJECTED", "No seat locks found for the given booking ID");
        }

        for (SeatLock seatLock : seatLocks) {
            seatLock.setStatus(LockStatus.COMMITTED);
            seatLock.setUpdatedAt(Instant.now());
        }

        seatLockRepository.saveAll(seatLocks);

        return new SeatLockActionResponseDTO("CONFIRMED", "Seat locks confirmed successfully");
    }

    @Override
    @Transactional
    public SeatLockActionResponseDTO cancelSeatLocks(SeatLockActionRequestDTO request) {
        LOG.debug("Request to cancel seat locks for booking: {}", request.getBookingId());

        List<SeatLock> seatLocks = seatLockQueryService.findByBookingId(request.getBookingId());

        if (seatLocks.isEmpty()) {
            return new SeatLockActionResponseDTO("REJECTED", "No seat locks found for the given booking ID");
        }

        for (SeatLock seatLock : seatLocks) {
            seatLock.setStatus(LockStatus.EXPIRED);
            seatLock.setUpdatedAt(Instant.now());
        }

        seatLockRepository.saveAll(seatLocks);

        return new SeatLockActionResponseDTO("CANCELLED", "Seat locks cancelled successfully");
    }

    @Override
    @Transactional
    public SeatValidateLockResponseDTO validateAndLockSeats(SeatValidateLockRequestDTO request) {
        LOG.debug("Request to validate and lock seats for trip: {}, seats: {}",
                request.getTripId(), request.getSeatNumbers());

        // Idempotency fast-path
        SeatLock existingLock = seatLockQueryService
                .findByIdempotencyKey(request.getIdemKey())
                .orElse(null);

        if (existingLock != null) {
            LOG.info("Idempotent request detected for key: {}", request.getIdemKey());
            return createValidateLockResponseFromExistingLock(existingLock, request);
        }

        try {
            // Step 1: Validate trip exists
            Trip trip = tripRepository
                    .findById(request.getTripId())
                    .orElseThrow(() -> new EntityNotFoundException("Trip not found: " + request.getTripId()));

            Instant now = Instant.now();

            // Step 2: Validate seat existence
            List<Seat> existingSeats = seatQueryService.findByTripIdAndSeatNumbers(
                    request.getTripId(), request.getSeatNumbers());

            // Group all seats by normalized seatNo
            Map<String, List<Seat>> groupedSeats = existingSeats.stream()
                    .filter(s -> s.getSeatNo() != null)
                    .collect(Collectors.groupingBy(s -> s.getSeatNo().trim().toUpperCase()));

            // Detect duplicates (same seat number, multiple seats)
            List<String> duplicates = groupedSeats.entrySet().stream()
                    .filter(e -> e.getValue().size() > 1)
                    .map(Map.Entry::getKey)
                    .toList();

            if (!duplicates.isEmpty()) {
                String message = "Duplicate seat numbers detected for trip " + request.getTripId()
                        + ": " + String.join(", ", duplicates);
                return new SeatValidateLockResponseDTO(
                        "REJECTED",
                        message,
                        request.getTripId());
            }

            if (existingSeats.size() != request.getSeatNumbers().size()) {
                // Find which seats don't exist
                List<String> existingSeatNumbers = existingSeats.stream()
                        .map(Seat::getSeatNo)
                        .toList();

                List<String> missingSeats = request.getSeatNumbers().stream()
                        .filter(seatNo -> !existingSeatNumbers.contains(seatNo))
                        .toList();

                LOG.warn("Seats {} do not exist for trip {}", missingSeats, request.getTripId());
                return new SeatValidateLockResponseDTO(
                        "REJECTED",
                        "Unknown seat numbers: " + String.join(", ", missingSeats),
                        request.getTripId());
            }

            // Step 3: Check for conflicting locks
            List<SeatLock> conflictingLocks = seatLockQueryService.findActiveLocksByTripAndSeats(
                    request.getTripId(), request.getSeatNumbers(), LockStatus.HELD, now);

            if (!conflictingLocks.isEmpty()) {
                List<String> unavailableSeats = conflictingLocks.stream()
                        .map(SeatLock::getSeatNo)
                        .distinct()
                        .toList();

                LOG.warn("Seats {} are not available for trip {}", unavailableSeats, request.getTripId());
                return new SeatValidateLockResponseDTO(
                        "REJECTED",
                        "Seats not available: " + String.join(", ", unavailableSeats),
                        request.getTripId());
            }

            // Step 4: Calculate pricing (basic implementation)
            SeatValidateLockResponseDTO.PricingInfo pricing = calculatePricing(trip, existingSeats,
                    request.getPromoCode());

            // Step 5: Lock seats atomically
            String lockGroupId = request.getIdemKey();
            Instant expiresAt = now.plus(LOCK_DURATION_MINUTES, ChronoUnit.MINUTES);

            for (String seatNumber : request.getSeatNumbers()) {
                SeatLock seatLock = new SeatLock();
                seatLock.setSeatNo(seatNumber);
                seatLock.setBookingId(null); // Will be set when actual booking is created
                seatLock.setStatus(LockStatus.HELD);
                seatLock.setExpiresAt(expiresAt);
                seatLock.setIdempotencyKey(request.getIdemKey());
                seatLock.setCreatedAt(now);
                seatLock.setIsDeleted(false);
                seatLock.setTrip(trip);

                seatLockRepository.save(seatLock);
            }

            // Step 6: Create response
            SeatValidateLockResponseDTO response = new SeatValidateLockResponseDTO();
            response.setStatus("HELD");
            response.setMessage("Seats successfully validated and locked");
            response.setLockGroupId(lockGroupId);
            response.setTripId(request.getTripId());
            response.setExpiresAt(expiresAt);
            response.setPricing(pricing);

            LOG.info("Successfully validated and locked {} seats for trip {} with lockGroupId {}",
                    request.getSeatNumbers().size(), request.getTripId(), lockGroupId);

            return response;

        } catch (EntityNotFoundException e) {
            LOG.warn("Trip not found: {}", request.getTripId());
            return new SeatValidateLockResponseDTO("REJECTED", "Trip not found", request.getTripId());

        } catch (Exception e) {
            LOG.error("Error processing seat validate and lock request for trip {}: {}",
                    request.getTripId(), e.getMessage(), e);

            return new SeatValidateLockResponseDTO("REJECTED",
                    "Internal error occurred while processing seat validation and lock",
                    request.getTripId());
        }
    }

    private SeatValidateLockResponseDTO createValidateLockResponseFromExistingLock(
            SeatLock existingLock, SeatValidateLockRequestDTO request) {

        SeatValidateLockResponseDTO response = new SeatValidateLockResponseDTO();
        response.setTripId(request.getTripId());

        Instant now = Instant.now();

        boolean valid = existingLock.getExpiresAt().isAfter(now)
                && LockStatus.HELD.equals(existingLock.getStatus())
                && (existingLock.getIsDeleted() == null || !existingLock.getIsDeleted());

        if (valid) {
            response.setStatus("HELD");
            response.setMessage("Seats successfully validated and locked (cached)");
            response.setLockGroupId(existingLock.getIdempotencyKey());
            response.setExpiresAt(existingLock.getExpiresAt());

            // Recalculate pricing for cached response
            try {
                Trip trip = tripRepository.findById(request.getTripId()).orElse(null);
                if (trip != null) {
                    List<Seat> seats = seatQueryService.findByTripIdAndSeatNumbers(
                            request.getTripId(), request.getSeatNumbers());
                    response.setPricing(calculatePricing(trip, seats, request.getPromoCode()));
                }
            } catch (Exception e) {
                LOG.warn("Failed to recalculate pricing for cached response: {}", e.getMessage());
            }
        } else {
            response.setStatus("REJECTED");
            response.setMessage("Seats not available (cached)");
        }

        return response;
    }

    @Override
    @Transactional(readOnly = true)
    public SeatValidateLockResponseDTO validateSeatsOnly(SeatValidateLockRequestDTO request) {
        LOG.debug("Request to validate seats for trip: {}, seats: {}",
                request.getTripId(), request.getSeatNumbers());

        try {
            // Step 1: Validate trip exists
            Trip trip = tripRepository
                    .findById(request.getTripId())
                    .orElseThrow(() -> new EntityNotFoundException("Trip not found: " + request.getTripId()));

            Instant now = Instant.now();

            // Step 2: Validate seat existence and check for duplicates
            List<Seat> existingSeats = seatQueryService.findByTripIdAndSeatNumbers(
                    request.getTripId(), request.getSeatNumbers());

            // Group all seats by normalized seatNo to detect duplicates in database
            Map<String, List<Seat>> groupedSeats = existingSeats.stream()
                    .filter(s -> s.getSeatNo() != null)
                    .collect(Collectors.groupingBy(s -> s.getSeatNo().trim().toUpperCase()));

            // Detect duplicates (same seat number, multiple seats) in database
            List<String> duplicates = groupedSeats.entrySet().stream()
                    .filter(e -> e.getValue().size() > 1)
                    .map(Map.Entry::getKey)
                    .toList();

            if (!duplicates.isEmpty()) {
                String message = "Duplicate seat numbers detected for trip " + request.getTripId()
                        + ": " + String.join(", ", duplicates);
                return new SeatValidateLockResponseDTO(
                        "REJECTED",
                        message,
                        request.getTripId());
            }

            // Check for duplicate seat numbers in the request
            List<String> uniqueSeatNumbers = request.getSeatNumbers().stream()
                    .distinct()
                    .toList();
            
            if (uniqueSeatNumbers.size() != request.getSeatNumbers().size()) {
                List<String> duplicateSeats = request.getSeatNumbers().stream()
                        .filter(seatNo -> request.getSeatNumbers().indexOf(seatNo) != request.getSeatNumbers().lastIndexOf(seatNo))
                        .distinct()
                        .toList();
                
                LOG.warn("Duplicate seat numbers found in request: {}", duplicateSeats);
                return new SeatValidateLockResponseDTO(
                        "REJECTED",
                        "Duplicate seat numbers in request: " + String.join(", ", duplicateSeats),
                        request.getTripId());
            }

            if (existingSeats.size() != request.getSeatNumbers().size()) {
                // Find which seats don't exist
                List<String> existingSeatNumbers = existingSeats.stream()
                        .map(Seat::getSeatNo)
                        .toList();
                
                List<String> missingSeats = request.getSeatNumbers().stream()
                        .filter(seatNo -> !existingSeatNumbers.contains(seatNo))
                        .toList();

                LOG.warn("Seats {} do not exist for trip {}", missingSeats, request.getTripId());
                return new SeatValidateLockResponseDTO(
                        "REJECTED",
                        "Unknown seat numbers: " + String.join(", ", missingSeats),
                        request.getTripId());
            }

            // Step 3: Check for existing locks (informational only)
            List<SeatLock> existingLocks = seatLockQueryService.findActiveLocksByTripAndSeats(
                    request.getTripId(), request.getSeatNumbers(), LockStatus.HELD, now);

            String message;
            if (!existingLocks.isEmpty()) {
                List<String> lockedSeats = existingLocks.stream()
                        .map(SeatLock::getSeatNo)
                        .distinct()
                        .toList();

                LOG.info("Seats {} are already locked for trip {} (validation only)", lockedSeats, request.getTripId());
                message = "All seats exist but some are already locked: " + String.join(", ", lockedSeats);
            } else {
                message = "All seats are valid and available";
            }

            // Step 4: Create validation response (no locking, no pricing)
            SeatValidateLockResponseDTO response = new SeatValidateLockResponseDTO();
            response.setStatus("VALIDATED");
            response.setMessage(message);
            response.setTripId(request.getTripId());
            // No lockGroupId, expiresAt, or pricing for validation-only response

            LOG.info("Successfully validated {} seats for trip {}",
                    request.getSeatNumbers().size(), request.getTripId());

            return response;

        } catch (EntityNotFoundException e) {
            LOG.warn("Trip not found: {}", request.getTripId());
            return new SeatValidateLockResponseDTO("REJECTED", "Trip not found", request.getTripId());

        } catch (Exception e) {
            LOG.error("Error processing seat validation request for trip {}: {}",
                    request.getTripId(), e.getMessage(), e);

            return new SeatValidateLockResponseDTO("REJECTED",
                    "Internal error occurred while processing seat validation",
                    request.getTripId());
        }
    }

    private SeatValidateLockResponseDTO.PricingInfo calculatePricing(
            Trip trip, List<Seat> seats, String promoCode) {
        
        // Basic pricing calculation - can be enhanced with promotion logic
        BigDecimal baseFare = trip.getBaseFare();
        BigDecimal seatFactor = seats.stream()
                .map(seat -> seat.getPriceFactor() != null ? seat.getPriceFactor() : BigDecimal.ONE)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        
        BigDecimal finalPrice = baseFare.multiply(seatFactor);
        
        // Apply promo code if provided (basic implementation)
        List<String> appliedPromotions = List.of();
        if (promoCode != null && !promoCode.trim().isEmpty()) {
            // Simple 10% discount for demo purposes
            finalPrice = finalPrice.multiply(BigDecimal.valueOf(0.9));
            appliedPromotions = List.of(promoCode + " (10% discount)");
        }
        
        return new SeatValidateLockResponseDTO.PricingInfo(
                baseFare, finalPrice, appliedPromotions, "USD");
    }

}
