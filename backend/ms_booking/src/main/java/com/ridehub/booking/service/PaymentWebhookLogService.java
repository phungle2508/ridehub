package com.ridehub.booking.service;

import com.ridehub.booking.service.dto.PaymentWebhookLogDTO;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ridehub.booking.domain.PaymentWebhookLog}.
 */
public interface PaymentWebhookLogService {
    /**
     * Save a paymentWebhookLog.
     *
     * @param paymentWebhookLogDTO the entity to save.
     * @return the persisted entity.
     */
    PaymentWebhookLogDTO save(PaymentWebhookLogDTO paymentWebhookLogDTO);

    /**
     * Updates a paymentWebhookLog.
     *
     * @param paymentWebhookLogDTO the entity to update.
     * @return the persisted entity.
     */
    PaymentWebhookLogDTO update(PaymentWebhookLogDTO paymentWebhookLogDTO);

    /**
     * Partially updates a paymentWebhookLog.
     *
     * @param paymentWebhookLogDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<PaymentWebhookLogDTO> partialUpdate(PaymentWebhookLogDTO paymentWebhookLogDTO);

    /**
     * Get the "id" paymentWebhookLog.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PaymentWebhookLogDTO> findOne(Long id);

    /**
     * Delete the "id" paymentWebhookLog.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
