package com.ridehub.booking.service.impl;

import com.ridehub.booking.domain.Booking;
import com.ridehub.booking.domain.PaymentTransaction;
import com.ridehub.booking.domain.PaymentWebhookLog;
import com.ridehub.booking.domain.Ticket;
import com.ridehub.booking.domain.enumeration.BookingStatus;
import com.ridehub.booking.domain.enumeration.PaymentStatus;
import com.ridehub.booking.repository.BookingRepository;
import com.ridehub.booking.repository.PaymentTransactionRepository;
import com.ridehub.booking.repository.PaymentWebhookLogRepository;
import com.ridehub.booking.repository.TicketRepository;
import com.ridehub.booking.service.PaymentService;
import com.ridehub.booking.service.payment.vnpay.VNPayService;
import com.ridehub.booking.service.payment.momo.MoMoService;
import com.ridehub.booking.service.payment.zalopay.ZaloPayService;
import com.ridehub.booking.service.vm.InitiatePaymentRequestVM;
import com.ridehub.booking.service.vm.PaymentInitiationResultVM;
import com.ridehub.msroute.client.api.SeatLockResourceMsrouteApi;
import com.ridehub.msroute.client.api.TripResourceMsrouteApi;
import com.ridehub.msroute.client.model.SeatLockDTO;
import com.ridehub.msroute.client.model.SeatDTO;
import com.ridehub.msroute.client.model.SeatLockActionRequestDTO;
import com.ridehub.msroute.client.model.SeatLockActionResponseDTO;
import com.ridehub.msroute.client.model.TripDTO;
import com.ridehub.msroute.client.model.TripDetailVM;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

/**
 * Service Implementation for managing Payment operations.
 */
@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentServiceImpl.class);

    private final BookingRepository bookingRepository;
    private final PaymentTransactionRepository paymentTransactionRepository;
    private final PaymentWebhookLogRepository paymentWebhookLogRepository;
    private final TicketRepository ticketRepository;
    private final StringRedisTemplate redis;
    private final TripResourceMsrouteApi tripResourceMsrouteApi;
    private final SeatLockResourceMsrouteApi seatLockResourceMsrouteApi;
    private final VNPayService vnPayService;
    private final MoMoService moMoService;
    private final ZaloPayService zaloPayService;

    public PaymentServiceImpl(
            BookingRepository bookingRepository,
            PaymentTransactionRepository paymentTransactionRepository,
            PaymentWebhookLogRepository paymentWebhookLogRepository,
            TicketRepository ticketRepository,
            StringRedisTemplate redis,
            TripResourceMsrouteApi tripResourceMsrouteApi,
            SeatLockResourceMsrouteApi seatLockResourceMsrouteApi,
            VNPayService vnPayService,
            MoMoService moMoService,
            ZaloPayService zaloPayService) {

        this.bookingRepository = bookingRepository;
        this.paymentTransactionRepository = paymentTransactionRepository;
        this.paymentWebhookLogRepository = paymentWebhookLogRepository;
        this.ticketRepository = ticketRepository;
        this.redis = redis;
        this.tripResourceMsrouteApi = tripResourceMsrouteApi;
        this.seatLockResourceMsrouteApi = seatLockResourceMsrouteApi;
        this.vnPayService = vnPayService;
        this.moMoService = moMoService;
        this.zaloPayService = zaloPayService;
    }

    @Override
    @Transactional
    public PaymentInitiationResultVM initiatePayment(InitiatePaymentRequestVM request) {
        LOG.debug("Initiating payment for booking: {}", request.getBookingId());

        // 1) Validate booking exists and is in AWAITING_PAYMENT
        Booking booking = bookingRepository.findById(request.getBookingId())
                .orElseThrow(() -> new IllegalArgumentException("Booking not found: " + request.getBookingId()));

        if (booking.getStatus() != BookingStatus.AWAITING_PAYMENT) {
            throw new IllegalStateException("Booking is not in AWAITING_PAYMENT status: " + booking.getStatus());
        }

        // 2) Create payment transaction (INITIATED)
        String transactionId = generateTransactionId();
        String orderRef = booking.getBookingCode();

        PaymentTransaction transaction = new PaymentTransaction();
        transaction.setTransactionId(transactionId);
        transaction.setOrderRef(orderRef);
        transaction.setMethod(request.getMethod());
        transaction.setStatus(PaymentStatus.INITIATED);
        transaction.setAmount(booking.getTotalAmount());
        transaction.setTime(Instant.now());
        transaction.setCreatedAt(Instant.now());
        transaction.setUpdatedAt(Instant.now());
        transaction.setBooking(booking);

        transaction = paymentTransactionRepository.save(transaction);

        // 3) Generate payment URL based on method
        String paymentUrl = generatePaymentUrl(request, transactionId, orderRef, booking.getTotalAmount());

        // NOTE: keep booking in AWAITING_PAYMENT; do not flip to PAID here
        booking.setPaymentTransaction(transaction);
        booking.setUpdatedAt(Instant.now());
        bookingRepository.save(booking);

        LOG.debug("Payment initiated for booking {} with txn {}", booking.getId(), transactionId);
        return new PaymentInitiationResultVM(paymentUrl, transactionId, orderRef);
    }

    @Override
    @Transactional
    public String processWebhook(String provider, String payload, String signature) {
        LOG.debug("Processing webhook from provider: {}", provider);

        try {
            // 1) Verify signature (mock)
            if (!verifySignature(payload, signature, provider)) {
                LOG.warn("Invalid webhook signature from provider: {}", provider);
                return "INVALID_SIGNATURE";
            }

            // 2) Payload hash for idempotency
            String payloadHash = generateHash(payload);

            // 3) Idempotency check
            Optional<PaymentWebhookLog> existingLog = paymentWebhookLogRepository.findByPayloadHash(payloadHash);
            if (existingLog.isPresent()) {
                LOG.debug("Webhook already processed: {}", payloadHash);
                return "ALREADY_PROCESSED";
            }

            // 4) Parse gateway payload (mock)
            WebhookData webhookData = parseWebhookPayload(payload, provider);

            // 5) Find payment transaction
            Optional<PaymentTransaction> transactionOpt = paymentTransactionRepository
                    .findByTransactionId(webhookData.getTransactionId());

            if (transactionOpt.isEmpty()) {
                LOG.warn("Payment transaction not found: {}", webhookData.getTransactionId());
                return "TRANSACTION_NOT_FOUND";
            }

            PaymentTransaction transaction = transactionOpt.get();
            Booking booking = transaction.getBooking();

            // 6) Insert webhook log (PROCESSING)
            PaymentWebhookLog webhookLog = new PaymentWebhookLog();
            webhookLog.setProvider(provider);
            webhookLog.setPayloadHash(payloadHash);
            webhookLog.setReceivedAt(Instant.now());
            webhookLog.setProcessingStatus("PROCESSING");
            webhookLog.setCreatedAt(Instant.now());
            webhookLog.setPaymentTransaction(transaction);
            paymentWebhookLogRepository.save(webhookLog);

            // 7) Process by mapped status
            PaymentStatus gatewayStatus = mapGatewayStatus(webhookData.getStatus());

            if (gatewayStatus == PaymentStatus.SUCCESS) {
                return processSuccessfulPayment(transaction, booking, webhookLog);
            } else if (gatewayStatus == PaymentStatus.FAILED || gatewayStatus == PaymentStatus.REFUNDED) {
                return processFailedPayment(transaction, booking, webhookLog, gatewayStatus);
            }

            return "PROCESSED";

        } catch (Exception ex) {
            LOG.error("Error processing webhook: {}", ex.getMessage(), ex);
            return "ERROR";
        }
    }

    // === SUCCESS path =========================================================

    private String processSuccessfulPayment(PaymentTransaction transaction, Booking booking,
            PaymentWebhookLog webhookLog) {
        // Update payment transaction
        transaction.setStatus(PaymentStatus.SUCCESS);
        transaction.setUpdatedAt(Instant.now());
        paymentTransactionRepository.save(transaction);

        // Update booking status to CONFIRMED
        booking.setStatus(BookingStatus.CONFIRMED);
        booking.setUpdatedAt(Instant.now());
        bookingRepository.save(booking);

        // Confirm seats in ms-route (authoritative)
        List<String> seatNos = loadSeatNosForBooking(booking);
        confirmSeatLocks(booking, seatNos);

        // Create tickets
        createTicketsForBooking(booking, seatNos);

        // Cache compact view
        String cacheKey = "booking:" + booking.getBookingCode();
        redis.opsForValue().set(cacheKey, "CONFIRMED", Duration.ofDays(1));

        // Finalize webhook log
        webhookLog.setProcessingStatus("SUCCESS");
        webhookLog.setUpdatedAt(Instant.now());
        paymentWebhookLogRepository.save(webhookLog);

        LOG.info("Payment confirmed for booking {}", booking.getBookingCode());
        return "SUCCESS";
    }

    // === FAILED / REFUNDED path ===============================================

    private String processFailedPayment(PaymentTransaction transaction, Booking booking,
            PaymentWebhookLog webhookLog, PaymentStatus status) {
        // Update payment transaction
        transaction.setStatus(status);
        transaction.setUpdatedAt(Instant.now());
        paymentTransactionRepository.save(transaction);

        // Update booking status
        BookingStatus newBookingStatus = (status == PaymentStatus.REFUNDED) ? BookingStatus.REFUNDED
                : BookingStatus.CANCELED;
        booking.setStatus(newBookingStatus);
        booking.setUpdatedAt(Instant.now());
        bookingRepository.save(booking);

        // Cancel seats
        List<String> seatNos = loadSeatNosForBooking(booking);
        cancelSeatLocks(booking, seatNos);

        // Cleanup Redis session
        String sessKey = "booking:sess:" + booking.getId();
        redis.delete(sessKey);

        // Finalize webhook log
        webhookLog.setProcessingStatus(status.name());
        webhookLog.setUpdatedAt(Instant.now());
        paymentWebhookLogRepository.save(webhookLog);

        LOG.info("Payment {} for booking {}", status.name().toLowerCase(Locale.ROOT), booking.getBookingCode());
        return status.name();
    }

    // === Tickets ===============================================================

    private void createTicketsForBooking(Booking booking, List<String> seatNos) {
        // 1) Fetch trip detail
        TripDetailVM trip = tripResourceMsrouteApi.getTripDetail(booking.getTripId());
        TripDTO tripDTO = trip.getTripDTO();

        if (tripDTO == null || tripDTO.getRoute() == null) {
            throw new IllegalStateException("Trip detail/route not found for trip " + booking.getTripId());
        }

        // 2) Per-seat price (or compute using PricingSnapshot if you prefer)
        BigDecimal perSeat = booking.getTotalAmount()
                .divide(new BigDecimal(seatNos.size()), 2, RoundingMode.HALF_UP);

        // 3) seatNo -> seatId map from seatsByFloorId
        Map<String, Long> seatNoToId = buildSeatNoToId(trip);

        // 4) Convert times
        Instant dep = tripDTO.getDepartureTime().toInstant();
        Instant arr = tripDTO.getArrivalTime().toInstant();

        // 5) Persist tickets
        for (String rawSeatNo : seatNos) {
            String seatNo = normSeatNo(rawSeatNo);
            Long seatId = seatNoToId.get(seatNo);
            if (seatId == null) {
                throw new IllegalStateException("SeatId not found for seat " + seatNo + " on trip " + tripDTO.getId());
            }

            Ticket t = new Ticket();
            t.setTicketCode(generateTicketCode());
            t.setPrice(perSeat);
            t.setQrCode(null); // populate if you generate QR
            t.setTimeFrom(dep);
            t.setTimeTo(arr);
            t.setCheckedIn(false);
            t.setTripId(tripDTO.getId());
            t.setRouteId(tripDTO.getRoute().getId());
            t.setSeatId(seatId);
            t.setCreatedAt(Instant.now());
            t.setBooking(booking);

            ticketRepository.save(t);
        }
    }

    private Map<String, Long> buildSeatNoToId(TripDetailVM trip) {
        if (trip == null || trip.getDetailVM() == null || trip.getDetailVM().getSeatsByFloorId() == null) {
            return Map.of();
        }
        Map<String, List<SeatDTO>> byFloor = trip.getDetailVM().getSeatsByFloorId();
        Map<String, Long> out = new LinkedHashMap<>();

        byFloor.values().stream()
                .filter(Objects::nonNull)
                .flatMap(List::stream)
                .filter(Objects::nonNull)
                .forEach(seat -> {
                    String seatNo = seat.getSeatNo();
                    Long id = seat.getId();
                    if (seatNo != null && id != null) {
                        out.putIfAbsent(normSeatNo(seatNo), id);
                    }
                });

        return out;
    }

    private static String normSeatNo(String s) {
        return s == null ? null : s.trim().toUpperCase(Locale.ROOT);
    }

    // === Seat lock finalize ====================================================

    private void confirmSeatLocks(Booking booking, List<String> seatNos) {
        SeatLockActionRequestDTO body = new SeatLockActionRequestDTO();
        body.setBookingId(booking.getId());
        body.setTripId(booking.getTripId());
        body.setSeatNumbers(seatNos);

        SeatLockActionResponseDTO res = seatLockResourceMsrouteApi.confirmSeatLocks(body);
        if (res == null || res.getStatus() == null || !"OK".equalsIgnoreCase(res.getStatus())) {
            throw new IllegalStateException(
                    "Seat confirm failed: " + (res != null ? res.getMessage() : "null response"));
        }
    }

    private void cancelSeatLocks(Booking booking, List<String> seatNos) {
        SeatLockActionRequestDTO body = new SeatLockActionRequestDTO();
        body.setBookingId(booking.getId());
        body.setTripId(booking.getTripId());
        body.setSeatNumbers(seatNos);

        SeatLockActionResponseDTO res = seatLockResourceMsrouteApi.cancelSeatLocks(body);
        if (res == null || res.getStatus() == null || !"OK".equalsIgnoreCase(res.getStatus())) {
            LOG.warn("Seat cancel returned non-OK: {}", res != null ? res.getMessage() : "null response");
        }
    }

    /**
     * Load the seat numbers for this booking.
     * Adjust the Redis key to your actual storage (e.g., set during draft
     * creation).
     */
    @SuppressWarnings("unchecked")
    private List<String> loadSeatNosForBooking(Booking booking) {
        // Try Redis first: e.g., "booking:seats:{bookingId}" holding List<String>
        String key = "booking:seats:" + booking.getId();
        Object obj = redis.opsForValue().get(key);
        if (obj instanceof List<?> raw) {
            List<String> seats = raw.stream().filter(Objects::nonNull).map(Object::toString).toList();
            if (!seats.isEmpty())
                return seats;
        }

        // If not in Redis, you can alternatively query ms-route seat locks by
        // bookingId+tripId.
        // Uncomment when you have the Feign method:
        // List<SeatLockDTO> locks =
        // seatLockResourceMsrouteApi.findActiveLocks(booking.getTripId(),
        // booking.getId());
        // List<String> seats =
        // locks.stream().map(SeatLockDTO::getSeatNo).map(this::normSeatNo).toList();
        // if (!seats.isEmpty()) return seats;

        throw new IllegalStateException(
                "Seat list not found for booking " + booking.getId() + " (expected in Redis key " + key + ")");
    }

    // === Helpers ===============================================================

    private String generateTransactionId() {
        return "TXN-" + RandomStringUtils.randomAlphanumeric(16).toUpperCase(Locale.ROOT);
    }

    private String generateTicketCode() {
        return "TKT-" + RandomStringUtils.randomAlphanumeric(12).toUpperCase(Locale.ROOT);
    }

    private String generatePaymentUrl(InitiatePaymentRequestVM request, String transactionId, String orderRef,
            BigDecimal amount) {
        // Check payment method and delegate to appropriate service
        if (request.getMethod() != null) {
            switch (request.getMethod().name()) {
                case "VNPAY":
                    return vnPayService.createPaymentUrl(request, transactionId, orderRef, amount);
                case "MOMO":
                    return moMoService.createPaymentUrl(request, transactionId, orderRef, amount);
                case "ZALOPAY":
                    return zaloPayService.createPaymentUrl(request, transactionId, orderRef, amount);
            }
        }

        // Default/mock payment gateway for other methods
        String baseUrl = "https://sandbox-payment.gateway.com/pay"; // replace with real gateway
        return String.format("%s?txn=%s&order=%s&amount=%s&return=%s",
                baseUrl, transactionId, orderRef, amount.toString(), request.getReturnUrl());
    }

    private boolean verifySignature(String payload, String signature, String provider) {
        if ("VNPAY".equalsIgnoreCase(provider)) {
            // For VNPay, we'll validate the signature in the parseWebhookPayload method
            // since VNPay uses query parameters instead of a separate signature
            return true;
        } else if ("MOMO".equalsIgnoreCase(provider)) {
            // MoMo signature verification is handled in the parseWebhookPayload method
            return true;
        } else if ("ZALOPAY".equalsIgnoreCase(provider)) {
            // ZaloPay signature verification is handled in the parseWebhookPayload method
            return true;
        }
        // Default signature check for other providers
        return signature != null && !signature.isEmpty();
    }

    private String generateHash(String payload) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(payload.getBytes(StandardCharsets.UTF_8));
            StringBuilder hex = new StringBuilder();
            for (byte b : hash) {
                String h = Integer.toHexString(0xff & b);
                if (h.length() == 1)
                    hex.append('0');
                hex.append(h);
            }
            return hex.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error generating hash", e);
        }
    }

    private WebhookData parseWebhookPayload(String payload, String provider) {
        if ("VNPAY".equalsIgnoreCase(provider)) {
            VNPayService.VNPayWebhookData vnpayData = vnPayService.parseWebhookPayload(payload);
            return new WebhookData(vnpayData.getTransactionId(), vnpayData.getStatus(), vnpayData.getAmount());
        } else if ("MOMO".equalsIgnoreCase(provider)) {
            MoMoService.MoMoWebhookData momoData = moMoService.parseWebhookPayload(payload);
            return new WebhookData(momoData.getTransactionId(), momoData.getStatus(), momoData.getAmount());
        } else if ("ZALOPAY".equalsIgnoreCase(provider)) {
            ZaloPayService.ZaloPayWebhookData zaloData = zaloPayService.parseWebhookPayload(payload);
            return new WebhookData(zaloData.getTransactionId(), zaloData.getStatus(), zaloData.getAmount());
        }

        // Default fallback for unknown providers
        return new WebhookData("TXN-123", "SUCCESS", new BigDecimal("100000"));
    }

    private PaymentStatus mapGatewayStatus(String gatewayStatus) {
        return switch (gatewayStatus.toUpperCase(Locale.ROOT)) {
            case "SUCCESS", "COMPLETED", "PAID" -> PaymentStatus.SUCCESS;
            case "FAILED", "CANCELLED", "REJECTED" -> PaymentStatus.FAILED;
            case "REFUNDED" -> PaymentStatus.REFUNDED;
            default -> PaymentStatus.PROCESSING;
        };
    }

    // Simple DTO for parsed webhook data
    private static class WebhookData {
        private final String transactionId;
        private final String status;
        private final BigDecimal amount;

        WebhookData(String transactionId, String status, BigDecimal amount) {
            this.transactionId = transactionId;
            this.status = status;
            this.amount = amount;
        }

        public String getTransactionId() {
            return transactionId;
        }

        public String getStatus() {
            return status;
        }

        public BigDecimal getAmount() {
            return amount;
        }
    }
}
