package com.ridehub.booking.repository;

import com.ridehub.booking.domain.PaymentTransaction;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Spring Data JPA repository for the PaymentTransaction entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PaymentTransactionRepository
    extends JpaRepository<PaymentTransaction, Long>, JpaSpecificationExecutor<PaymentTransaction> {

    /**
     * Find PaymentTransaction by transaction ID.
     */
    Optional<PaymentTransaction> findByTransactionId(String transactionId);
}
