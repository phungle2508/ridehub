package com.ridehub.booking.service;

import com.ridehub.booking.service.dto.PaymentTransactionDTO;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ridehub.booking.domain.PaymentTransaction}.
 */
public interface PaymentTransactionService {
    /**
     * Save a paymentTransaction.
     *
     * @param paymentTransactionDTO the entity to save.
     * @return the persisted entity.
     */
    PaymentTransactionDTO save(PaymentTransactionDTO paymentTransactionDTO);

    /**
     * Updates a paymentTransaction.
     *
     * @param paymentTransactionDTO the entity to update.
     * @return the persisted entity.
     */
    PaymentTransactionDTO update(PaymentTransactionDTO paymentTransactionDTO);

    /**
     * Partially updates a paymentTransaction.
     *
     * @param paymentTransactionDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<PaymentTransactionDTO> partialUpdate(PaymentTransactionDTO paymentTransactionDTO);

    /**
     * Get all the PaymentTransactionDTO where Booking is {@code null}.
     *
     * @return the {@link List} of entities.
     */
    List<PaymentTransactionDTO> findAllWhereBookingIsNull();

    /**
     * Get the "id" paymentTransaction.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PaymentTransactionDTO> findOne(Long id);

    /**
     * Delete the "id" paymentTransaction.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
