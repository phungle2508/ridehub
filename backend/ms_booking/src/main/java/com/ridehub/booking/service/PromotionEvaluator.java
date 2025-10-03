// src/main/java/com/ridehub/booking/service/PromotionEvaluator.java
package com.ridehub.booking.service;

import com.ridehub.booking.service.dto.*;
import com.ridehub.mspromotion.client.model.BuyNGetMFreeDTO;
import com.ridehub.mspromotion.client.model.PromotionDetailDTO;

import java.math.BigDecimal;
import java.time.*;
import java.util.*;

public final class PromotionEvaluator {

    private PromotionEvaluator() {
    }

    /** Minimal evaluation: date window, usage limit, route/date conditions. */
    public static AppliedPromotionDTO evaluate(
            PromotionDetailDTO promo,
            Long routeId, // from TripDetailVM.getTripDTO().getRouteId()
            LocalDate travelDate,
            int seatCount,
            List<BigDecimal> perSeatPrices // computed earlier seat-by-seat
    ) {
        // 1) basic active window
        LocalDate today = travelDate != null ? travelDate : LocalDate.now();
        if (promo.getStartDate() != null && today.isBefore(promo.getStartDate()))
            return null;
        if (promo.getEndDate() != null && today.isAfter(promo.getEndDate()))
            return null;

        // 2) usage limit (if provided)
        if (promo.getUsageLimit() != null && promo.getUsedCount() != null
                && promo.getUsedCount() >= promo.getUsageLimit())
            return null;

        // 3) route condition (if provided)
        if (promo.getConditionsRS() != null && !promo.getConditionsRS().isEmpty()) {
            boolean ok = promo.getConditionsRS().stream()
                    .flatMap(cr -> cr.getItems().stream())
                    .anyMatch(item -> Objects.equals(item.getRouteId(), routeId));
            if (!ok)
                return null;
        }

        // 4) date condition (specific dates or weekdays)
        if (promo.getConditionsDS() != null && !promo.getConditionsDS().isEmpty()) {
            boolean dateOk = promo.getConditionsDS().stream().anyMatch(cd -> {
                boolean specOk = cd.getItems().stream()
                        .filter(it -> it.getSpecificDate() != null)
                        .anyMatch(it -> it.getSpecificDate().equals(today));
                boolean weekdayOk = cd.getItems().stream()
                        .filter(it -> it.getWeekday() != null)
                        .anyMatch(it -> it.getWeekday() == today.getDayOfWeek().getValue());
                // If any specific/weekday matches, accept
                return specOk || weekdayOk;
            });
            if (!dateOk)
                return null;
        }

        // 5) choose a policy to apply (PercentOff first; you can extend)
        BigDecimal total = perSeatPrices.stream().reduce(BigDecimal.ZERO, BigDecimal::add);

        // 5a) PercentOffTotal
        if (promo.getPercentOffs() != null && !promo.getPercentOffs().isEmpty()) {
            var best = promo.getPercentOffs().stream()
                    .max(Comparator.comparingInt(p -> Optional.ofNullable(p.getPercent()).orElse(0)))
                    .orElse(null);
            if (best != null && best.getPercent() != null && best.getPercent() > 0) {
                BigDecimal off = total.multiply(BigDecimal.valueOf(best.getPercent()))
                        .divide(BigDecimal.valueOf(100));
                if (best.getMaxOff() != null)
                    off = off.min(best.getMaxOff());

                var dto = new AppliedPromotionDTO();
                dto.setPromotionCode(promo.getCode());
                dto.setPolicyType("PERCENT_OFF");
                dto.setPercent(best.getPercent());
                dto.setMaxOff(best.getMaxOff());
                dto.setDiscountAmount(off);
                return dto;
            }
        }

        // 5b) BuyNGetMFree (optional): make the M cheapest seats free
        if (promo.getBuyNGetMS() != null && !promo.getBuyNGetMS().isEmpty()) {
            var best = promo.getBuyNGetMS().stream()
                    .max(Comparator.comparingInt(BuyNGetMFreeDTO::getGetM))
                    .orElse(null);
            if (best != null && best.getBuyN() != null && best.getGetM() != null) {
                if (seatCount >= best.getBuyN() + best.getGetM()) {
                    var sorted = new ArrayList<>(perSeatPrices);
                    sorted.sort(Comparator.naturalOrder()); // cheapest become free
                    BigDecimal off = sorted.stream()
                            .limit(best.getGetM())
                            .reduce(BigDecimal.ZERO, BigDecimal::add);

                    var dto = new AppliedPromotionDTO();
                    dto.setPromotionCode(promo.getCode());
                    dto.setPolicyType("BUY_N_GET_M_FREE");
                    dto.setPercent(null);
                    dto.setMaxOff(null);
                    dto.setDiscountAmount(off);
                    return dto;
                }
            }
        }

        return null; // no applicable policy
    }
}
