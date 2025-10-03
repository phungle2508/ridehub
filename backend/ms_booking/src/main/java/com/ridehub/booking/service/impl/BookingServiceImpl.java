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

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public BookingServiceImpl(BookingRepository bookingRepository, BookingMapper bookingMapper,
            AppliedPromotionRepository appliedPromoRepo, BookingRepository bookingRepo2,
            PricingService pricingService, PricingSnapshotRepository pricingSnapRepo) {
        this.bookingRepository = bookingRepository;
        this.bookingMapper = bookingMapper;
        this.pricingSnapRepo = pricingSnapRepo;
        this.appliedPromoRepo = appliedPromoRepo;
        this.pricingService = pricingService;
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

    @Override
    @Transactional
    public BookingDraftResultVM createDraft(CreateBookingDraftRequestVM req) {
        // 1) Price it (validates seat availability)
        var pricing = pricingService.computePrice(req.getTripId(), req.getSeats(), req.getPromoCode());

        // 2) Persist Booking (DRAFT)
        Booking b = new Booking();
        b.setBookingCode(generateBookingCode());
        b.setStatus(BookingStatus.DRAFT); // enum, not string
        b.setQuantity(req.getSeats() != null ? req.getSeats().size() : 0);
        b.setTotalAmount(pricing.getFinalPrice());
        b.setBookedAt(Instant.now());
        b.setCustomerId(req.getCustomerId());
        b.setCreatedAt(Instant.now());
        b.setUpdatedAt(Instant.now());
        b = bookingRepository.save(b);

        // 3) Snapshot pricing (normalized to your JDL)
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

        // 4) Snapshot applied promotion (if any)
        if (pricing.isPromoApplied() && pricing.getAppliedPromotion() != null) {
            AppliedPromotionDTO ap = pricing.getAppliedPromotion();
            AppliedPromotion apEntity = new AppliedPromotion();
            apEntity.setPromotionId(ap.getPromotionId()); // set if available
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

        // 5) Build result
        BookingDraftResultVM vm = new BookingDraftResultVM();
        vm.setBookingId(b.getId());
        vm.setBookingCode(b.getBookingCode());
        vm.setStatus(b.getStatus().name()); // if VM expects String
        vm.setQuantity(b.getQuantity());
        vm.setTotalAmount(b.getTotalAmount());

        vm.setTripId(req.getTripId());
        vm.setSeats(req.getSeats());
        vm.setPromoCode(req.getPromoCode());

        vm.setPricingSnapshot(ps);
        vm.setAppliedPromotion(pricing.getAppliedPromotion());
        vm.setPromoApplied(pricing.isPromoApplied());
        return vm;
    }

    private String generateBookingCode() {
        String a = RandomStringUtils.randomAlphanumeric(4).toUpperCase();
        String b = RandomStringUtils.randomAlphanumeric(4).toUpperCase();
        return "RH-" + a + "-" + b;
    }
}
