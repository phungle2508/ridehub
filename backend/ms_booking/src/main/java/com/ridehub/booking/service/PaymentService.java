package com.ridehub.booking.service;

import com.ridehub.booking.service.vm.InitiatePaymentRequestVM;
import com.ridehub.booking.service.vm.PaymentInitiationResultVM;
import jakarta.servlet.http.HttpServletRequest;

/**
 * Service Interface for managing Payment operations.
 */
public interface PaymentService {

    /**
     * Initiate payment for a booking.
     *
     * @param request the payment initiation request
     * @param returnUrl the return URL from configuration
     * @param ipAddress the client IP address
     * @return the payment initiation result with payment URL
     */
    PaymentInitiationResultVM initiatePayment(InitiatePaymentRequestVM request, String returnUrl, String ipAddress);

    /**
     * Process payment webhook from gateway.
     *
     * @param provider the payment provider (vnpay, momo, etc.)
     * @param payload the webhook payload
     * @param signature the webhook signature for verification
     * @return processing result message
     */
    String processWebhook(String provider, String payload, String signature);

}
