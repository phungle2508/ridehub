// src/main/java/com/ridehub/booking/service/vm/BookingDraftResultVM.java
package com.ridehub.booking.service.vm;

import com.ridehub.booking.service.dto.AppliedPromotionDTO;
import com.ridehub.booking.service.dto.PricingSnapshotDTO;
import java.math.BigDecimal;
import java.util.List;

public class BookingDraftResultVM {
    private Long bookingId;
    private String bookingCode;
    private String status; // DRAFT
    private Integer quantity;
    private BigDecimal totalAmount;

    // echo inputs for client convenience (not persisted yet)
    private Long tripId;
    private List<String> seats;
    private String promoCode;

    private PricingSnapshotDTO pricingSnapshot;
    private AppliedPromotionDTO appliedPromotion;
    private boolean promoApplied;

    public BookingDraftResultVM() {
    }

    // getters/setters
    public BookingDraftResultVM(Long bookingId, String bookingCode, String status, Integer quantity,
            BigDecimal totalAmount, Long tripId, List<String> seats, String promoCode,
            PricingSnapshotDTO pricingSnapshot, AppliedPromotionDTO appliedPromotion, boolean promoApplied) {
        this.bookingId = bookingId;
        this.bookingCode = bookingCode;
        this.status = status;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.tripId = tripId;
        this.seats = seats;
        this.promoCode = promoCode;
        this.pricingSnapshot = pricingSnapshot;
        this.appliedPromotion = appliedPromotion;
        this.promoApplied = promoApplied;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public List<String> getSeats() {
        return seats;
    }

    public void setSeats(List<String> seats) {
        this.seats = seats;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public PricingSnapshotDTO getPricingSnapshot() {
        return pricingSnapshot;
    }

    public void setPricingSnapshot(PricingSnapshotDTO pricingSnapshot) {
        this.pricingSnapshot = pricingSnapshot;
    }

    public AppliedPromotionDTO getAppliedPromotion() {
        return appliedPromotion;
    }

    public void setAppliedPromotion(AppliedPromotionDTO appliedPromotion) {
        this.appliedPromotion = appliedPromotion;
    }

    public boolean isPromoApplied() {
        return promoApplied;
    }

    public void setPromoApplied(boolean promoApplied) {
        this.promoApplied = promoApplied;
    }

}
