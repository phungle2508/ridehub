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
         * Find PaymentTransaction by transaction ID (excluding deleted ones).
         */
        @Query("SELECT pt FROM PaymentTransaction pt WHERE pt.transactionId = :transactionId AND (pt.isDeleted = false OR pt.isDeleted IS NULL)")
        Optional<PaymentTransaction> findByTransactionIdAndIsDeletedFalseOrIsDeletedIsNull(
                        @Param("transactionId") String transactionId);

        /**
         * Find transactions by method, multiple statuses, created after date, and not
         * deleted.
         */
        @Query("SELECT pt FROM PaymentTransaction pt WHERE pt.method = :method AND pt.status IN :statuses AND pt.createdAt > :createdAfter AND (pt.isDeleted = false OR pt.isDeleted IS NULL)")
        List<PaymentTransaction> findByMethodAndStatusInAndCreatedAtAfterAndIsDeletedFalseOrIsDeletedIsNull(
                        @Param("method") PaymentMethod method,
                        @Param("statuses") List<PaymentStatus> statuses,
                        @Param("createdAfter") Instant createdAfter);

        /**
         * Find transactions by multiple statuses and not deleted.
         */
        @Query("SELECT pt FROM PaymentTransaction pt WHERE pt.status IN :statuses AND (pt.isDeleted = false OR pt.isDeleted IS NULL)")
        List<PaymentTransaction> findByStatusInAndIsDeletedFalseOrIsDeletedIsNull(
                        @Param("statuses") List<PaymentStatus> statuses);

}
