package com.ridehub.booking.repository;

import com.ridehub.booking.domain.PaymentTransaction;
import com.ridehub.booking.domain.enumeration.PaymentMethod;
import com.ridehub.booking.domain.enumeration.PaymentStatus;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
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

        /**
         * Find pending transactions by method and created after date, ordered by
         * creation time.
         */
        List<PaymentTransaction> findByStatusAndMethodAndCreatedAtAfterOrderByCreatedAtAsc(
                        PaymentStatus status, PaymentMethod method, Instant createdAfter);

        /**
         * Count transactions by status, method, and created after date.
         */
        long countByStatusAndMethodAndCreatedAtAfter(
                        PaymentStatus status, PaymentMethod method, Instant createdAfter);

        /**
         * Count transactions by method and created after date.
         */
        long countByMethodAndCreatedAtAfter(PaymentMethod method, Instant createdAfter);

        @Query("select p.gatewayCreateDate from PaymentTransaction p where p.transactionId = :txnRef")
        Optional<String> findGatewayCreateDateByTxnRef(@Param("txnRef") String txnRef);

}
