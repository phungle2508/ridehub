package com.ridehub.booking.repository;

import com.ridehub.booking.domain.PaymentTransaction;
import com.ridehub.booking.domain.enumeration.PaymentMethod;
import com.ridehub.booking.domain.enumeration.PaymentStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class PaymentTransactionRepositoryTest {

    @Autowired
    private PaymentTransactionRepository paymentTransactionRepository;

    private static final String TEST_TRANSACTION_ID = "TEST_TXN_001";

    @BeforeEach
    void setUp() {
        // Clean up any existing test data
        paymentTransactionRepository.deleteAll();
    }

    @Test
    void testFindByTransactionIdAndIsDeletedFalseOrIsDeletedIsNull_WithActiveTransaction() {
        // Create and save an active transaction
        PaymentTransaction transaction = createTestTransaction(TEST_TRANSACTION_ID);
        transaction.setIsDeleted(false);
        paymentTransactionRepository.save(transaction);

        // Test the query
        Optional<PaymentTransaction> result = paymentTransactionRepository
                .findByTransactionIdAndIsDeletedFalseOrIsDeletedIsNull(TEST_TRANSACTION_ID);

        assertThat(result).isPresent();
        PaymentTransaction foundTransaction = result.orElseThrow(() -> new AssertionError("Expected transaction to be present"));
        assertThat(foundTransaction.getTransactionId()).isEqualTo(TEST_TRANSACTION_ID);
        assertThat(foundTransaction.getIsDeleted()).isFalse();
    }

    @Test
    void testFindByTransactionIdAndIsDeletedFalseOrIsDeletedIsNull_WithNullIsDeleted() {
        // Create and save a transaction with null isDeleted
        PaymentTransaction transaction = createTestTransaction(TEST_TRANSACTION_ID);
        transaction.setIsDeleted(null);
        paymentTransactionRepository.save(transaction);

        // Test the query
        Optional<PaymentTransaction> result = paymentTransactionRepository
                .findByTransactionIdAndIsDeletedFalseOrIsDeletedIsNull(TEST_TRANSACTION_ID);

        assertThat(result).isPresent();
        PaymentTransaction foundTransaction = result.orElseThrow(() -> new AssertionError("Expected transaction to be present"));
        assertThat(foundTransaction.getTransactionId()).isEqualTo(TEST_TRANSACTION_ID);
        assertThat(foundTransaction.getIsDeleted()).isNull();
    }

    @Test
    void testFindByTransactionIdAndIsDeletedFalseOrIsDeletedIsNull_WithDeletedTransaction() {
        // Create and save a deleted transaction
        PaymentTransaction transaction = createTestTransaction(TEST_TRANSACTION_ID);
        transaction.setIsDeleted(true);
        transaction.setDeletedAt(Instant.now());
        paymentTransactionRepository.save(transaction);

        // Test the query - should not find deleted transaction
        Optional<PaymentTransaction> result = paymentTransactionRepository
                .findByTransactionIdAndIsDeletedFalseOrIsDeletedIsNull(TEST_TRANSACTION_ID);

        assertThat(result).isEmpty();
    }

    @Test
    void testFindByTransactionIdAndIsDeletedFalseOrIsDeletedIsNull_WithMultipleTransactionsSameId() {
        // This test verifies that even if there are multiple records with the same transactionId
        // (which shouldn't happen due to unique constraint), the query correctly handles it
        
        // Create an active transaction
        PaymentTransaction activeTransaction = createTestTransaction(TEST_TRANSACTION_ID);
        activeTransaction.setIsDeleted(false);
        paymentTransactionRepository.save(activeTransaction);

        // Create a deleted transaction with same ID (this would violate unique constraint in real DB,
        // but we're testing the query logic)
        PaymentTransaction deletedTransaction = createTestTransaction(TEST_TRANSACTION_ID + "_DELETED");
        deletedTransaction.setTransactionId(TEST_TRANSACTION_ID); // Manually set same ID
        deletedTransaction.setIsDeleted(true);
        deletedTransaction.setDeletedAt(Instant.now());
        paymentTransactionRepository.save(deletedTransaction);

        // Test the query - should find only the active one
        Optional<PaymentTransaction> result = paymentTransactionRepository
                .findByTransactionIdAndIsDeletedFalseOrIsDeletedIsNull(TEST_TRANSACTION_ID);

        assertThat(result).isPresent();
        PaymentTransaction foundTransaction = result.orElseThrow(() -> new AssertionError("Expected transaction to be present"));
        assertThat(foundTransaction.getTransactionId()).isEqualTo(TEST_TRANSACTION_ID);
        assertThat(foundTransaction.getIsDeleted()).isFalse();
    }

    @Test
    void testFindByMethodAndStatusInAndCreatedAtAfterAndIsDeletedFalseOrIsDeletedIsNull() {
        // Create multiple test transactions
        Instant cutoffTime = Instant.now().minus(5, ChronoUnit.MINUTES);

        // Active transaction that should be found
        PaymentTransaction activeTransaction = createTestTransaction("ACTIVE_TXN");
        activeTransaction.setIsDeleted(false);
        activeTransaction.setCreatedAt(cutoffTime.plusSeconds(60));
        paymentTransactionRepository.save(activeTransaction);

        // Transaction with null isDeleted that should be found
        PaymentTransaction nullDeletedTransaction = createTestTransaction("NULL_DELETED_TXN");
        nullDeletedTransaction.setIsDeleted(null);
        nullDeletedTransaction.setCreatedAt(cutoffTime.plusSeconds(120));
        paymentTransactionRepository.save(nullDeletedTransaction);

        // Deleted transaction that should NOT be found
        PaymentTransaction deletedTransaction = createTestTransaction("DELETED_TXN");
        deletedTransaction.setIsDeleted(true);
        deletedTransaction.setDeletedAt(Instant.now());
        deletedTransaction.setCreatedAt(cutoffTime.plusSeconds(180));
        paymentTransactionRepository.save(deletedTransaction);

        // Old transaction that should NOT be found
        PaymentTransaction oldTransaction = createTestTransaction("OLD_TXN");
        oldTransaction.setIsDeleted(false);
        oldTransaction.setCreatedAt(cutoffTime.minusSeconds(60));
        paymentTransactionRepository.save(oldTransaction);

        // Test the query
        List<PaymentTransaction> results = paymentTransactionRepository
                .findByMethodAndStatusInAndCreatedAtAfterAndIsDeletedFalseOrIsDeletedIsNull(
                        PaymentMethod.VNPAY,
                        List.of(PaymentStatus.INITIATED, PaymentStatus.SUCCESS),
                        cutoffTime
                );

        assertThat(results).hasSize(2);
        assertThat(results.stream().map(PaymentTransaction::getTransactionId))
                .containsExactlyInAnyOrder("ACTIVE_TXN", "NULL_DELETED_TXN");
    }

    private PaymentTransaction createTestTransaction(String transactionId) {
        PaymentTransaction transaction = new PaymentTransaction();
        transaction.setTransactionId(transactionId);
        transaction.setOrderRef("ORDER_" + transactionId);
        transaction.setMethod(PaymentMethod.VNPAY);
        transaction.setStatus(PaymentStatus.INITIATED);
        transaction.setAmount(java.math.BigDecimal.valueOf(100000));
        transaction.setTime(Instant.now());
        transaction.setGatewayCreateDate("20251010120000");
        transaction.setCreatedAt(Instant.now());
        transaction.setUpdatedAt(Instant.now());
        return transaction;
    }
}
