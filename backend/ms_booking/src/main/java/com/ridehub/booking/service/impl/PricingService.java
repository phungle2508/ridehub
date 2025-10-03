package com.ridehub.booking.service.impl;

import com.ridehub.booking.service.dto.AppliedPromotionDTO;
import com.ridehub.booking.service.dto.PricingSnapshotDTO;
import com.ridehub.booking.service.vm.PricingResultVM;
import com.ridehub.mspromotion.client.api.PromotionResourceMspromotionApi;
import com.ridehub.mspromotion.client.model.BuyNGetMFreeDTO;
import com.ridehub.mspromotion.client.model.ConditionRouteItemDTO;
import com.ridehub.mspromotion.client.model.PercentOffTotalDTO;
import com.ridehub.mspromotion.client.model.PromotionDetailDTO;

import com.ridehub.msroute.client.api.TripResourceMsrouteApi;
import com.ridehub.msroute.client.model.FloorDTO;
import com.ridehub.msroute.client.model.SeatDTO;
import com.ridehub.msroute.client.model.SeatLockDTO;
import com.ridehub.msroute.client.model.TripDetailVM;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Computes final booking price using:
 * - TripDetailVM from ms-route (baseFare, vehicle, floors, seats, locks)
 * - PromotionDetailDTO from ms-promotion (policies + conditions)
 *
 * NOTE: All Redis caching is disabled/commented so this runs without Redis.
 */
@Service
public class PricingService {
    private static final Logger LOG = LoggerFactory.getLogger(PricingService.class);

    private final PromotionResourceMspromotionApi promotionResourceMspromotionApi;
    private final TripResourceMsrouteApi tripResourceMsrouteApi;

    public PricingService(
            PromotionResourceMspromotionApi promotionResourceMspromotionApi,
            TripResourceMsrouteApi tripResourceMsrouteApi) {
        this.promotionResourceMspromotionApi = promotionResourceMspromotionApi;
        this.tripResourceMsrouteApi = tripResourceMsrouteApi;
    }

    /**
     * Main entry point used by BookingService.
     */
    public PricingResultVM computePrice(Long tripId, List<String> seatNos, String promoCode) {
        if (seatNos == null || seatNos.isEmpty()) {
            throw new IllegalArgumentException("Seat list cannot be empty");
        }

        // ===== 1) Get trip details (direct Feign; caching removed) =====
        // String tripCacheKey = "trip:detail:" + tripId;
        // TripDetailVM tripVM = getCached(tripCacheKey, TripDetailVM.class);
        // if (tripVM == null) { ... setCached(...) }
        TripDetailVM tripVM = tripResourceMsrouteApi.getTripDetail(tripId);

        // Extract inputs
        BigDecimal baseFare = nn(tripVM.getTripDTO().getBaseFare(), BigDecimal.ZERO);
        BigDecimal vehicleFactor = nn(tripVM.getDetailVM().getVehicle().getTypeFactor(), BigDecimal.ONE); // default 1
        Long routeId = tripVM.getTripDTO().getRoute().getId();
        LocalDate travelDate = toLocalDate(tripVM.getTripDTO().getDepartureTime());

        // ===== 2) Build lookups: floor factors, seats by seatNo, seatNo → floorId (as
        // String in VM) =====
        Map<Long, BigDecimal> floorFactorById = new HashMap<>();
        if (tripVM.getDetailVM().getFloors() != null) {
            for (FloorDTO f : tripVM.getDetailVM().getFloors()) {
                floorFactorById.put(f.getId(), nn(f.getPriceFactorFloor(), BigDecimal.ONE));
            }
        }

        Map<String, SeatDTO> seatByNo = new HashMap<>();
        Map<String, String> seatFloorId = new HashMap<>(); // matches VM map key type (String)
        Map<String, List<SeatDTO>> byFloor = tripVM.getDetailVM().getSeatsByFloorId();

        if (byFloor != null) {
            for (Map.Entry<String, List<SeatDTO>> e : byFloor.entrySet()) {
                String floorIdStr = e.getKey(); // String key
                for (SeatDTO s : e.getValue()) {
                    seatByNo.put(s.getSeatNo(), s);
                    seatFloorId.put(s.getSeatNo(), floorIdStr);
                }
            }
        }

        // ===== 3) Validate seat availability from SeatLockDTOs (HELD/COMMITTED) =====
        if (tripVM.getSeatLockDTOs() != null && !tripVM.getSeatLockDTOs().isEmpty()) {
            Set<String> taken = tripVM.getSeatLockDTOs().stream()
                    .filter(l -> eqAnyIgnoreCase(l.getStatus(), "HELD", "COMMITTED"))
                    .map(SeatLockDTO::getSeatNo)
                    .collect(Collectors.toSet());

            for (String s : seatNos) {
                if (taken.contains(s)) {
                    throw new IllegalStateException("Seat " + s + " is not available");
                }
            }
        }

        // ===== 4) Compute per-seat prices and total =====
        List<BigDecimal> perSeatPrices = new ArrayList<>(seatNos.size());
        for (String seatNo : seatNos) {
            SeatDTO seat = seatByNo.get(seatNo);
            if (seat == null) {
                throw new IllegalArgumentException("Unknown seat number: " + seatNo);
            }
            String floorIdStr = seatFloorId.get(seatNo);
            Long floorId = parseLongSafe(floorIdStr);
            BigDecimal floorFactor = nn(floorFactorById.getOrDefault(floorId, BigDecimal.ONE), BigDecimal.ONE);
            BigDecimal seatFactor = nn(seat.getPriceFactor(), BigDecimal.ONE);

            BigDecimal perSeat = baseFare
                    .multiply(vehicleFactor)
                    .multiply(floorFactor)
                    .multiply(seatFactor);

            perSeatPrices.add(perSeat);
        }

        BigDecimal total = perSeatPrices.stream().reduce(BigDecimal.ZERO, BigDecimal::add);

        // ===== 5) Apply promotion if present (detail-by-code → local evaluation) =====
        AppliedPromotionDTO applied = null;
        if (promoCode != null && !promoCode.isBlank()) {
            PromotionDetailDTO detail = null;

            try {
                detail = promotionResourceMspromotionApi.getPromotionDetailByCode(promoCode);
            } catch (Exception e) {
                LOG.warn("Failed to load promo detail for code {}: {}", promoCode, e.toString());
            }

            // If we couldn't fetch the detail (or it has no id), DO NOT evaluate/apply.
            if (detail == null || detail.getId() == null) {
                LOG.info("Promo {} ignored: detail {} / id {}", promoCode, (detail == null ? "null" : "non-null"),
                        (detail != null ? detail.getId() : null));
            } else {
                applied = evaluatePromotion(detail, routeId, travelDate, seatNos.size(), perSeatPrices);

                if (applied != null) {
                    // Ensure required linkage is present for persistence later
                    if (applied.getPromotionId() == null) {
                        applied.setPromotionId(detail.getId());
                    }
                    if (applied.getPromotionCode() == null) {
                        applied.setPromotionCode(detail.getCode());
                    }

                    // Only subtract if discount is set
                    if (applied.getDiscountAmount() != null) {
                        total = total.subtract(applied.getDiscountAmount());
                        if (total.compareTo(BigDecimal.ZERO) < 0)
                            total = BigDecimal.ZERO;
                    }
                }
            }
        }

        // ===== 6) Build snapshots/result =====
        PricingSnapshotDTO snap = new PricingSnapshotDTO();
        snap.setBaseFare(baseFare);
        snap.setVehicleFactor(vehicleFactor);
        snap.setFloorFactor(BigDecimal.ONE); // aggregate kept simple
        snap.setSeatFactor(BigDecimal.ONE);
        snap.setFinalPrice(total);

        PricingResultVM out = new PricingResultVM();
        out.setPricingSnapshot(snap);
        out.setAppliedPromotion(applied);
        out.setFinalPrice(total);
        out.setPromoApplied(applied != null);

        return out;
    }

    // =========================
    // Promotion evaluation
    // =========================

    private AppliedPromotionDTO evaluatePromotion(
            PromotionDetailDTO promo,
            Long routeId,
            LocalDate travelDate,
            int seatCount,
            List<BigDecimal> perSeatPrices) {
        if (promo == null)
            return null;

        LocalDate today = (travelDate != null) ? travelDate : LocalDate.now();

        // 1) Date window
        if (promo.getStartDate() != null && today.isBefore(promo.getStartDate()))
            return null;
        if (promo.getEndDate() != null && today.isAfter(promo.getEndDate()))
            return null;

        // 2) Usage limit
        if (promo.getUsageLimit() != null && promo.getUsedCount() != null
                && promo.getUsedCount() >= promo.getUsageLimit())
            return null;

        // 3) Route conditions
        if (promo.getConditionsRS() != null && !promo.getConditionsRS().isEmpty()) {
            boolean routeOk = promo.getConditionsRS().stream()
                    .flatMap(cr -> (cr.getItems() == null ? Stream.<ConditionRouteItemDTO>empty()
                            : cr.getItems().stream()))
                    .anyMatch(it -> Objects.equals(it.getRouteId(), routeId));
            if (!routeOk)
                return null;
        }

        // 4) Date conditions (specific dates or weekdays)
        if (promo.getConditionsDS() != null && !promo.getConditionsDS().isEmpty()) {
            boolean dateOk = promo.getConditionsDS().stream().anyMatch(cd -> {
                boolean specOk = cd.getItems() != null && cd.getItems().stream()
                        .anyMatch(it -> it.getSpecificDate() != null && it.getSpecificDate().equals(today));
                boolean weekdayOk = cd.getItems() != null && cd.getItems().stream()
                        .anyMatch(it -> it.getWeekday() != null && it.getWeekday() == today.getDayOfWeek().getValue());
                return specOk || weekdayOk;
            });
            if (!dateOk)
                return null;
        }

        // 5) Pick best applicable policy
        BigDecimal total = perSeatPrices.stream().reduce(BigDecimal.ZERO, BigDecimal::add);

        // 5a) PercentOffTotal — choose highest percent (respect maxOff)
        AppliedPromotionDTO bestPercent = null;
        if (promo.getPercentOffs() != null && !promo.getPercentOffs().isEmpty()) {
            PercentOffTotalDTO best = promo.getPercentOffs().stream()
                    .filter(p -> p.getPercent() != null && p.getPercent() > 0)
                    .max(Comparator.comparingInt(PercentOffTotalDTO::getPercent))
                    .orElse(null);
            if (best != null) {
                BigDecimal off = percent(total, best.getPercent());
                if (best.getMaxOff() != null)
                    off = off.min(best.getMaxOff());

                bestPercent = new AppliedPromotionDTO();
                bestPercent.setPromotionCode(promo.getCode());
                bestPercent.setPolicyType("PERCENT_OFF");
                bestPercent.setPercent(best.getPercent());
                bestPercent.setMaxOff(best.getMaxOff());
                bestPercent.setDiscountAmount(off);
            }
        }

        // 5b) BuyNGetMFree — make M cheapest seats free if seatCount >= N+M
        AppliedPromotionDTO bestBnm = null;
        if (promo.getBuyNGetMS() != null && !promo.getBuyNGetMS().isEmpty()) {
            BuyNGetMFreeDTO best = promo.getBuyNGetMS().stream()
                    .filter(b -> b.getBuyN() != null && b.getGetM() != null)
                    .max(Comparator.comparingInt(BuyNGetMFreeDTO::getGetM))
                    .orElse(null);
            if (best != null && seatCount >= best.getBuyN() + best.getGetM()) {
                List<BigDecimal> sorted = perSeatPrices.stream().sorted().collect(Collectors.toList());
                BigDecimal off = sorted.stream().limit(best.getGetM()).reduce(BigDecimal.ZERO, BigDecimal::add);

                bestBnm = new AppliedPromotionDTO();
                bestBnm.setPromotionCode(promo.getCode());
                bestBnm.setPolicyType("BUY_N_GET_M_FREE");
                bestBnm.setDiscountAmount(off);
            }
        }

        // Choose better discount if both available
        if (bestPercent != null && bestBnm != null) {
            return (bestPercent.getDiscountAmount().compareTo(bestBnm.getDiscountAmount()) >= 0) ? bestPercent
                    : bestBnm;
        }
        if (bestPercent != null)
            return bestPercent;
        if (bestBnm != null)
            return bestBnm;

        return null; // no applicable policy
    }

    // =========================
    // Small utilities
    // =========================

    private static boolean eqAnyIgnoreCase(Enum<?> v, String... options) {
        if (v == null)
            return false;
        String name = v.name();
        for (String o : options) {
            if (name.equalsIgnoreCase(o))
                return true;
        }
        return false;
    }

    private static BigDecimal nn(BigDecimal v, BigDecimal def) {
        return v == null ? def : v;
    }

    private static LocalDate toLocalDate(OffsetDateTime odt) {
        if (odt == null)
            return LocalDate.now();
        return odt.toLocalDate();
    }

    private static Long parseLongSafe(String s) {
        if (s == null)
            return null;
        try {
            return Long.parseLong(s);
        } catch (NumberFormatException ex) {
            return null;
        }
    }

    private BigDecimal percent(BigDecimal base, Integer percent) {
        if (base == null || percent == null)
            return BigDecimal.ZERO;
        return base.multiply(BigDecimal.valueOf(percent))
                .divide(BigDecimal.valueOf(100));
    }

    // =========================
    // Redis helpers (disabled)
    // =========================
    // private final StringRedisTemplate redis;
    // private static final ObjectMapper M = new ObjectMapper();
    // private <T> T getCached(String key, Class<T> type) { ... }
    // private void setCached(String key, Object value, Duration ttl) { ... }
}
