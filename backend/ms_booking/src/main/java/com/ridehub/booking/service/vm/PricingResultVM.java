package com.ridehub.booking.service.vm;

import java.io.Serializable;
import java.math.BigDecimal;

import com.ridehub.booking.service.dto.AppliedPromotionDTO;
import com.ridehub.booking.service.dto.PricingSnapshotDTO;

public class PricingResultVM implements Serializable {

    private BigDecimal finalPrice;
    private boolean promoApplied;

    private PricingSnapshotDTO pricingSnapshot;
    private AppliedPromotionDTO appliedPromotion;

    public PricingResultVM() {
    }

    public BigDecimal getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = finalPrice;
    }

    public boolean isPromoApplied() {
        return promoApplied;
    }

    public void setPromoApplied(boolean promoApplied) {
        this.promoApplied = promoApplied;
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
}
