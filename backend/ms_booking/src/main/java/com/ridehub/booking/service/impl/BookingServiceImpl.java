package com.ridehub.booking.service.impl;

import com.ridehub.booking.domain.AppliedPromotion;
import com.ridehub.booking.domain.Booking;
import com.ridehub.booking.domain.PricingSnapshot;
import com.ridehub.booking.domain.enumeration.BookingStatus;
import com.ridehub.booking.repository.AppliedPromotionRepository;
import com.ridehub.booking.repository.BookingRepository;
import com.ridehub.booking.repository.PricingSnapshotRepository;
import com.ridehub.booking.service.BookingService;
import com.ridehub.booking.service.dto.AppliedPromotionDTO;
import com.ridehub.booking.service.dto.BookingDTO;
import com.ridehub.booking.service.dto.PricingSnapshotDTO;
import com.ridehub.booking.service.mapper.BookingMapper;
import com.ridehub.booking.service.vm.BookingDraftResultVM;
import com.ridehub.booking.service.vm.CreateBookingDraftRequestVM;
import com.ridehub.booking.web.rest.errors.SeatNotAvailableException;
import com.ridehub.msroute.client.api.SeatLockResourceMsrouteApi;
import com.ridehub.msroute.client.model.SeatLockActionRequestDTO;
import com.ridehub.msroute.client.model.SeatLockRequestDTO;
import com.ridehub.msroute.client.model.SeatLockResponseDTO;
import com.ridehub.msroute.client.model.SeatValidateLockRequestDTO;
import com.ridehub.msroute.client.model.SeatValidateLockResponseDTO;

import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing
 * {@link com.ridehub.booking.domain.Booking}.
 */
@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    private static final Logger LOG = LoggerFactory.getLogger(BookingServiceImpl.class);

    private final BookingRepository bookingRepository;

    private final BookingMapper bookingMapper;
    private final PricingSnapshotRepository pricingSnapRepo;
    private final AppliedPromotionRepository appliedPromoRepo;
    private final PricingService pricingService;
    private final SeatLockResourceMsrouteApi seatLockResourceMsrouteApi;
    private final StringRedisTemplate redis;

    public BookingServiceImpl(BookingRepository bookingRepository, BookingMapper bookingMapper,
            AppliedPromotionRepository appliedPromoRepo, BookingRepository bookingRepo2,
            PricingService pricingService, PricingSnapshotRepository pricingSnapRepo,
            SeatLockResourceMsrouteApi seatLockResourceMsrouteApi, StringRedisTemplate redis) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
        this.pricingSnapRepo = pricingSnapRepo;
        this.appliedPromoRepo = appliedPromoRepo;
        this.pricingService = pricingService;
        this.seatLockResourceMsrouteApi = seatLockResourceMsrouteApi;
        this.redis = redis;
    }

    @Override
    public BookingDTO save(BookingDTO bookingDTO) {
        LOG.debug("Request to save Booking : {}", bookingDTO);
        Booking booking = bookingMapper.toEntity(bookingDTO);
        booking = bookingRepository.save(booking);
        return bookingMapper.toDto(booking);
    }

    @Override
    public BookingDTO update(BookingDTO bookingDTO) {
        LOG.debug("Request to update Booking : {}", bookingDTO);
        Booking booking = bookingMapper.toEntity(bookingDTO);
        booking = bookingRepository.save(booking);
        return bookingMapper.toDto(booking);
    }

    @Override
    public Optional<BookingDTO> partialUpdate(BookingDTO bookingDTO) {
        LOG.debug("Request to partially update Booking : {}", bookingDTO);

        return bookingRepository
                .findById(bookingDTO.getId())
                .map(existingBooking -> {
                    bookingMapper.partialUpdate(existingBooking, bookingDTO);

                    return existingBooking;
                })
                .map(bookingRepository::save)
                .map(bookingMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<BookingDTO> findOne(Long id) {
        LOG.debug("Request to get Booking : {}", id);
        return bookingRepository.findById(id).map(bookingMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete Booking : {}", id);
        bookingRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public BookingDraftResultVM createSimpleDraft(CreateBookingDraftRequestVM req) {
        LOG.debug("Creating simple draft for price check - tripId: {}, seats: {}, promoCode: {}",
                req.getTripId(), req.getSeats(), req.getPromoCode());
        // === 1️⃣ Validate seat availability before pricing ===
        SeatValidateLockRequestDTO validateRequest = new SeatValidateLockRequestDTO();
        validateRequest.setTripId(req.getTripId());
        validateRequest.setSeatNumbers(req.getSeats());
        validateRequest.setIdemKey(req.getIdemKey());
        
        SeatValidateLockResponseDTO validationResult = seatLockResourceMsrouteApi.validateSeatsOnly(validateRequest);
        
        // Check validation result - seats must be VALIDATED before proceeding
        if (!isValidated(validationResult)) {
            throw new SeatNotAvailableException("Seat validation failed: " + validationResult.getMessage());
        }
        
        // === 2️⃣ Calculate price and validate promotion - no persistence
        var pricing = pricingService.computePrice(req.getTripId(), req.getSeats(), req.getPromoCode());

        // Build result without database operations
        BookingDraftResultVM vm = new BookingDraftResultVM();
        vm.setBookingId(null); // No booking created yet
        vm.setBookingCode(null); // No booking code yet
        vm.setStatus("DRAFT_PRICE_CHECK");
        vm.setQuantity(req.getSeats() != null ? req.getSeats().size() : 0);
        vm.setTotalAmount(pricing.getFinalPrice());
        vm.setTripId(req.getTripId());
        vm.setSeats(req.getSeats());
        vm.setPromoCode(req.getPromoCode());
        vm.setPricingSnapshot(pricing.getPricingSnapshot());
        vm.setAppliedPromotion(pricing.getAppliedPromotion());
        vm.setPromoApplied(pricing.isPromoApplied());

        return vm;
    }

    @Transactional
    @Override
    public BookingDraftResultVM createRealBooking(CreateBookingDraftRequestVM req) {
        String idemKey = "idem:booking:" + req.getIdemKey();
        String sessKey = null;

        // === 1️⃣ Idempotency guard ===
        Boolean isNew = redis.opsForValue().setIfAbsent(idemKey, "LOCKED", Duration.ofSeconds(60));
        if (Boolean.FALSE.equals(isNew)) {
            throw new IllegalStateException("Duplicate booking request detected (idemKey = " + req.getIdemKey() + ")");
        }

        try {
            // === 2️⃣ Validate seat availability before pricing ===
            SeatValidateLockRequestDTO validateRequest = new SeatValidateLockRequestDTO();
            validateRequest.setTripId(req.getTripId());
            validateRequest.setSeatNumbers(req.getSeats());
            validateRequest.setIdemKey(req.getIdemKey());
            
            SeatValidateLockResponseDTO validationResult = seatLockResourceMsrouteApi.validateSeatsOnly(validateRequest);
            
            // Check validation result - seats must be VALIDATED before proceeding
            if (!isValidated(validationResult)) {
                throw new SeatNotAvailableException("Seat validation failed: " + validationResult.getMessage());
            }

            // === 3️⃣ Compute pricing (includes promo caching in PricingService) ===
            var pricing = pricingService.computePrice(req.getTripId(), req.getSeats(), req.getPromoCode());

            // === 4️⃣ Try to lock seats with ms-route FIRST (before any database
            // operations) ===
            SeatLockRequestDTO lockRequest = new SeatLockRequestDTO();
            lockRequest.setBookingId(null); // Will be set after booking creation
            lockRequest.setTripId(req.getTripId());
            lockRequest.setSeatNumbers(req.getSeats());
            lockRequest.setIdemKey(req.getIdemKey());

            var lockResult = seatLockResourceMsrouteApi.tryLockSeats(lockRequest);

            if (!isHeld(lockResult)) {
                throw new SeatNotAvailableException("Seat not available: " + lockResult.getMessage());
            }

            // === 5️⃣ Persist DRAFT booking (only after successful seat lock) ===
            Booking b = new Booking();
            b.setBookingCode(generateBookingCode());
            b.setStatus(BookingStatus.DRAFT);
            b.setQuantity(req.getSeats() != null ? req.getSeats().size() : 0);
            b.setTotalAmount(pricing.getFinalPrice());
            b.setBookedAt(Instant.now());
            b.setCustomerId(req.getCustomerId());
            b.setCreatedAt(Instant.now());
            b.setUpdatedAt(Instant.now());
            b.setTripId(req.getTripId());
            b.setExpiresAt(Instant.now());

            // IMPORTANT: Set lockGroupId using idempotency key for proper seat lock
            // management
            // The idempotency key is used to group related seat locks together
            String lockGroupId = req.getIdemKey();
            if (lockGroupId != null && !lockGroupId.trim().isEmpty()) {
                b.setLockGroupId(lockGroupId);
                LOG.debug("Set lockGroupId {} for booking {} using idempotency key", lockGroupId, b.getBookingCode());
            } else {
                LOG.warn("No idempotency key available for booking {}, seat lock management may be impaired",
                        b.getBookingCode());
            }

            b = bookingRepository.save(b);

            // === 6️⃣ Store booking session state in Redis ===
            sessKey = "booking:sess:" + b.getId();
            redis.opsForValue().set(sessKey, "AWAITING_LOCK", Duration.ofMinutes(20));

            // === 6️⃣b Store seat list in Redis for payment processing ===
            String seatsKey = "booking:seats:" + b.getId();
            redis.opsForValue().set(seatsKey, String.join(",", req.getSeats()), Duration.ofMinutes(20));

            // === 7️⃣ Save pricing snapshot ===
            PricingSnapshotDTO ps = pricing.getPricingSnapshot();
            PricingSnapshot snap = new PricingSnapshot();
            snap.setBaseFare(ps.getBaseFare());
            snap.setVehicleFactor(ps.getVehicleFactor());
            snap.setFloorFactor(ps.getFloorFactor());
            snap.setSeatFactor(ps.getSeatFactor());
            snap.setFinalPrice(ps.getFinalPrice());
            snap.setCreatedAt(Instant.now());
            snap.setBooking(b);
            pricingSnapRepo.save(snap);

            // === 8️⃣ Save applied promotion (if any) ===
            if (pricing.isPromoApplied() && pricing.getAppliedPromotion() != null) {
                AppliedPromotionDTO ap = pricing.getAppliedPromotion();
                AppliedPromotion apEntity = new AppliedPromotion();
                apEntity.setPromotionId(ap.getPromotionId());
                apEntity.setPromotionCode(ap.getPromotionCode());
                apEntity.setPolicyType(ap.getPolicyType());
                apEntity.setPercent(ap.getPercent());
                apEntity.setMaxOff(ap.getMaxOff());
                apEntity.setDiscountAmount(ap.getDiscountAmount());
                apEntity.setAppliedAt(Instant.now());
                apEntity.setCreatedAt(Instant.now());
                apEntity.setBooking(b);
                appliedPromoRepo.save(apEntity);
            }

            // === 9️⃣ Update seat lock with actual booking ID ===
            SeatLockActionRequestDTO updateLockRequest = new SeatLockActionRequestDTO();
            updateLockRequest.setBookingId(b.getId());
            updateLockRequest.setTripId(req.getTripId());
            updateLockRequest.setSeatNumbers(req.getSeats());

            // Note: This assumes ms-route has an endpoint to update lock with booking ID
            // If not available, we might need to include booking ID in the initial lock
            // request

            // === 🔟 Update booking status to AWAITING_PAYMENT ===
            b.setStatus(BookingStatus.AWAITING_PAYMENT);
            b.setUpdatedAt(Instant.now());
            b = bookingRepository.save(b);

            redis.opsForValue().set(sessKey, "AWAITING_PAYMENT", Duration.ofMinutes(20));

            // === 10️⃣ Build success result ===
            BookingDraftResultVM vm = new BookingDraftResultVM();
            vm.setBookingId(b.getId());
            vm.setBookingCode(b.getBookingCode());
            vm.setStatus(b.getStatus().name());
            vm.setQuantity(b.getQuantity());
            vm.setTotalAmount(b.getTotalAmount());
            vm.setTripId(req.getTripId());
            vm.setSeats(req.getSeats());
            vm.setPromoCode(req.getPromoCode());
            vm.setPricingSnapshot(ps);
            vm.setAppliedPromotion(pricing.getAppliedPromotion());
            vm.setPromoApplied(pricing.isPromoApplied());
            return vm;

        } catch (SeatNotAvailableException ex) {
            // Re-throw seat availability exceptions as-is
            throw ex;
        } catch (Exception ex) {
            LOG.error("Real booking creation failed: {}", ex.getMessage(), ex);

            // Cleanup Redis session if it was created
            if (sessKey != null) {
                redis.delete(sessKey);
                redis.delete("booking:seats:" + sessKey.substring("booking:sess:".length()));
            }

            // Note: We should also cancel the seat lock if it was created
            // This would require additional error handling logic

            throw ex;
        }
    }

    private String generateBookingCode() {
        String a = RandomStringUtils.randomAlphanumeric(4).toUpperCase();
        String b = RandomStringUtils.randomAlphanumeric(4).toUpperCase();
        return "RH-" + a + "-" + b;
    }

    private static boolean isHeld(SeatLockResponseDTO r) {
        return r != null && "HELD".equalsIgnoreCase(r.getStatus());
    }

    private static boolean isRejected(SeatLockResponseDTO r) {
        return r != null && "REJECTED".equalsIgnoreCase(r.getStatus());
    }

    private static boolean isValidated(SeatValidateLockResponseDTO r) {
        return r != null && "VALIDATED".equalsIgnoreCase(r.getStatus());
    }

    private static boolean isValidationRejected(SeatValidateLockResponseDTO r) {
        return r != null && "REJECTED".equalsIgnoreCase(r.getStatus());
    }
}
