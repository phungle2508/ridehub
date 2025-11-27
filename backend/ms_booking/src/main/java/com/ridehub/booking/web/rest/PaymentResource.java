package com.ridehub.booking.web.rest;

import com.ridehub.booking.service.PaymentService;
import com.ridehub.booking.service.payment.vnpay.VNPayConfig;
import com.ridehub.booking.service.vm.InitiatePaymentRequestVM;
import com.ridehub.booking.service.vm.PaymentInitiationResultVM;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing Payment operations.
 */
@RestController
@RequestMapping("/api")
public class PaymentResource {

    private static final Logger LOG = LoggerFactory.getLogger(PaymentResource.class);

    private final PaymentService paymentService;
    private final VNPayConfig vnPayConfig;

    public PaymentResource(PaymentService paymentService, VNPayConfig vnPayConfig) {
        this.paymentService = paymentService;
        this.vnPayConfig = vnPayConfig;
    }

    /**
     * {@code POST /bookings/{id}/pay} : Initiate payment for a booking.
     *
     * @param id the booking ID
     * @param request the payment initiation request
     * @param httpRequest the HTTP request to extract IP address
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and payment URL in body.
     */
    @PostMapping("/bookings/{id}/pay")
    public ResponseEntity<PaymentInitiationResultVM> initiatePayment(
            @PathVariable Long id,
            @Valid @RequestBody InitiatePaymentRequestVM request,
            HttpServletRequest httpRequest) {
        
        LOG.debug("REST request to initiate payment for Booking : {}", id);
        
        // Set booking ID from path parameter
        request.setBookingId(id);
        
        // Get returnUrl from configuration
        String returnUrl = vnPayConfig.getReturnUrl();
        
        // Extract IP address from request
        String ipAddress = getClientIpAddress(httpRequest);
        
        PaymentInitiationResultVM result = paymentService.initiatePayment(request, returnUrl, ipAddress);
        
        return ResponseEntity.ok(result);
    }

    /**
     * Extract client IP address from HTTP request.
     */
    private String getClientIpAddress(HttpServletRequest request) {
        String xForwardedFor = request.getHeader("X-Forwarded-For");
        if (xForwardedFor != null && !xForwardedFor.isEmpty()) {
            return xForwardedFor.split(",")[0].trim();
        }
        
        String xRealIp = request.getHeader("X-Real-IP");
        if (xRealIp != null && !xRealIp.isEmpty()) {
            return xRealIp;
        }
        
        return request.getRemoteAddr();
    }
}
