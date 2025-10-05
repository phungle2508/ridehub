package com.ridehub.route.service.impl;

import com.ridehub.route.domain.SeatLock;
import com.ridehub.route.domain.Trip;
import com.ridehub.route.domain.enumeration.LockStatus;
import com.ridehub.route.repository.SeatLockRepository;
import com.ridehub.route.repository.TripRepository;
import com.ridehub.route.service.SeatLockQueryService;
import com.ridehub.route.service.SeatLockService;
import com.ridehub.route.service.dto.SeatLockDTO;
import com.ridehub.route.service.dto.request.SeatLockRequestDTO;
import com.ridehub.route.service.dto.response.SeatLockResponseDTO;
import com.ridehub.route.service.mapper.SeatLockMapper;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.ridehub.route.domain.SeatLock}.
 */
@Service
@Transactional
public class SeatLockServiceImpl implements SeatLockService {

    private static final Logger LOG = LoggerFactory.getLogger(SeatLockServiceImpl.class);

    private final SeatLockRepository seatLockRepository;
    private final TripRepository tripRepository;
    private final SeatLockMapper seatLockMapper;
    private final SeatLockQueryService seatLockQueryService;

    private static final int LOCK_DURATION_MINUTES = 20; // 20 minutes lock duration as per PlantUML

    public SeatLockServiceImpl(SeatLockRepository seatLockRepository, TripRepository tripRepository,
                              SeatLockMapper seatLockMapper, SeatLockQueryService seatLockQueryService) {
        this.seatLockRepository = seatLockRepository;
        this.tripRepository = tripRepository;
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

        // Check idempotency - if this request was already processed using query service
        Optional<SeatLock> existingLock = seatLockQueryService.findByIdempotencyKey(request.getIdemKey());
        if (existingLock.isPresent()) {
            LOG.info("Idempotent request detected for key: {}", request.getIdemKey());
            return createResponseFromExistingLock(existingLock.get(), request);
        }

        try {
            // Validate trip exists
            Optional<Trip> tripOpt = tripRepository.findById(request.getTripId());
            if (tripOpt.isEmpty()) {
                LOG.warn("Trip not found: {}", request.getTripId());
                return new SeatLockResponseDTO("REJECTED", "Trip not found", request.getBookingId(), request.getTripId());
            }

            Trip trip = tripOpt.get();
            Instant now = Instant.now();

            // Check if any of the requested seats are already locked using query service
            List<SeatLock> conflictingLocks = seatLockQueryService.findActiveLocksByTripAndSeats(
                request.getTripId(), request.getSeatNumbers(), LockStatus.HELD, now);

            if (!conflictingLocks.isEmpty()) {
                List<String> unavailableSeats = conflictingLocks.stream()
                    .map(SeatLock::getSeatNo)
                    .distinct()
                    .toList();

                LOG.warn("Seats {} are not available for trip {}", unavailableSeats, request.getTripId());
                return new SeatLockResponseDTO("REJECTED",
                    "Seats not available: " + String.join(", ", unavailableSeats),
                    request.getBookingId(), request.getTripId());
            }

            // All seats are available, proceed with locking
            String lockId = UUID.randomUUID().toString();
            Instant expiresAt = now.plus(LOCK_DURATION_MINUTES, ChronoUnit.MINUTES);

            // Create seat locks for each seat - only save if not exists in repository
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

        // Check if the existing lock is still valid
        if (existingLock.getExpiresAt().isAfter(Instant.now()) &&
            LockStatus.HELD.equals(existingLock.getStatus()) &&
            (existingLock.getIsDeleted() == null || !existingLock.getIsDeleted())) {

            response.setStatus("HELD");
            response.setMessage("Seats successfully locked (cached)");
            response.setExpiresAt(existingLock.getExpiresAt().getEpochSecond());
        } else {
            response.setStatus("REJECTED");
            response.setMessage("Seats not available (cached)");
        }

        return response;
    }
}
