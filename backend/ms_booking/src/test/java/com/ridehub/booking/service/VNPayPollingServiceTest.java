package com.ridehub.booking.service;

import com.ridehub.booking.domain.PaymentTransaction;
import com.ridehub.booking.domain.Booking;
import com.ridehub.booking.domain.enumeration.PaymentMethod;
import com.ridehub.booking.domain.enumeration.PaymentStatus;
import com.ridehub.booking.domain.enumeration.BookingStatus;
import com.ridehub.booking.repository.PaymentTransactionRepository;
import com.ridehub.booking.service.payment.vnpay.VNPayService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VNPayPollingServiceTest {

    @Mock
    private PaymentTransactionRepository paymentTransactionRepository;

    @Mock
    private VNPayService vnPayService;

    @Mock
    private PaymentService paymentService;

    @InjectMocks
    private VNPayPollingService vnPayPollingService;

    private PaymentTransaction testTransaction;
    private Booking testBooking;
    private VNPayService.VNPayQueryResult successfulQueryResult;
    private VNPayService.VNPayQueryResult failedQueryResult;

    @BeforeEach
    void setUp() {
        testTransaction = new PaymentTransaction();
        testTransaction.setId(1L);
        testTransaction.setTransactionId("TEST_TXN_123");
        testTransaction.setOrderRef("ORDER_456");
        testTransaction.setMethod(PaymentMethod.VNPAY);
        testTransaction.setStatus(PaymentStatus.INITIATED);
        testTransaction.setAmount(new BigDecimal("100000"));
        testTransaction.setCreatedAt(Instant.now());
        testTransaction.setUpdatedAt(Instant.now());

        // Create test booking
        testBooking = new Booking();
        testBooking.setId(1L);
        testBooking.setBookingCode("BOOKING_123");
        testBooking.setStatus(BookingStatus.AWAITING_PAYMENT);
        testBooking.setExpiresAt(Instant.now().plus(30, java.time.temporal.ChronoUnit.MINUTES));
        testBooking.setCreatedAt(Instant.now());
        testBooking.setIsDeleted(false);

        // Link transaction to booking
        testTransaction.setBooking(testBooking);

        successfulQueryResult = new VNPayService.VNPayQueryResult(
            true, "00", "Transaction successful", "00", new BigDecimal("100000")
        );

        failedQueryResult = new VNPayService.VNPayQueryResult(
            false, "01", "Transaction not found", null, null
        );
    }

    @Test
    void testPollSpecificTransaction_Success() {
        // Given
        when(paymentTransactionRepository.findByTransactionIdAndIsDeletedFalseOrIsDeletedIsNull("TEST_TXN_123"))
            .thenReturn(Optional.of(testTransaction));
        when(vnPayService.queryTransaction(eq(testTransaction), eq("127.0.0.1")))
            .thenReturn(successfulQueryResult);
        when(paymentService.processWebhook(eq("VNPAY"), anyString(), anyString()))
            .thenReturn("SUCCESS");

        // When
        boolean result = vnPayPollingService.pollSpecificTransaction("TEST_TXN_123");

        // Then
        assertThat(result).isTrue();
        verify(paymentTransactionRepository).save(testTransaction);
        verify(paymentService).processWebhook(eq("VNPAY"), anyString(), anyString());
        assertThat(testTransaction.getStatus()).isEqualTo(PaymentStatus.SUCCESS);
    }

    @Test
    void testPollSpecificTransaction_TransactionNotFound() {
        // Given
        when(paymentTransactionRepository.findByTransactionIdAndIsDeletedFalseOrIsDeletedIsNull("NONEXISTENT_TXN"))
            .thenReturn(Optional.empty());

        // When
        boolean result = vnPayPollingService.pollSpecificTransaction("NONEXISTENT_TXN");

        // Then
        assertThat(result).isFalse();
        verify(vnPayService, never()).queryTransaction(any(PaymentTransaction.class), anyString());
    }

    @Test
    void testPollSpecificTransaction_NotVNPayTransaction() {
        // Given
        testTransaction.setMethod(PaymentMethod.CREDIT_CARD);
        when(paymentTransactionRepository.findByTransactionIdAndIsDeletedFalseOrIsDeletedIsNull("TEST_TXN_123"))
            .thenReturn(Optional.of(testTransaction));

        // When
        boolean result = vnPayPollingService.pollSpecificTransaction("TEST_TXN_123");

        // Then
        assertThat(result).isFalse();
        verify(vnPayService, never()).queryTransaction(any(PaymentTransaction.class), anyString());
    }

    @Test
    void testPollSpecificTransaction_QueryFailed() {
        // Given
        when(paymentTransactionRepository.findByTransactionIdAndIsDeletedFalseOrIsDeletedIsNull("TEST_TXN_123"))
            .thenReturn(Optional.of(testTransaction));
        when(vnPayService.queryTransaction(eq(testTransaction), eq("127.0.0.1")))
            .thenReturn(failedQueryResult);

        // When
        boolean result = vnPayPollingService.pollSpecificTransaction("TEST_TXN_123");

        // Then
        assertThat(result).isFalse();
        verify(paymentTransactionRepository, never()).save(any());
        verify(paymentService, never()).processWebhook(anyString(), anyString(), anyString());
    }

    @Test
    void testDeterminePaymentStatus_Success() {
        // When
        PaymentStatus status = callPrivateMethod("determinePaymentStatus", successfulQueryResult);

        // Then
        assertThat(status).isEqualTo(PaymentStatus.SUCCESS);
    }

    @Test
    void testDeterminePaymentStatus_Processing() {
        // Given
        VNPayService.VNPayQueryResult processingResult = new VNPayService.VNPayQueryResult(
            true, "07", "Transaction processing", "07", null
        );

        // When
        PaymentStatus status = callPrivateMethod("determinePaymentStatus", processingResult);

        // Then
        assertThat(status).isEqualTo(PaymentStatus.PROCESSING);
    }

    @Test
    void testDeterminePaymentStatus_Failed() {
        // Given
        VNPayService.VNPayQueryResult failedResult = new VNPayService.VNPayQueryResult(
            false, "01", "Transaction not found", null, null
        );

        // When
        PaymentStatus status = callPrivateMethod("determinePaymentStatus", failedResult);

        // Then
        assertThat(status).isEqualTo(PaymentStatus.FAILED);
    }

    @Test
    void testPollPendingTransactions() {
        // Given
        List<PaymentTransaction> pendingTransactions = Arrays.asList(testTransaction);
        Instant cutoffTime = Instant.now().minus(24, java.time.temporal.ChronoUnit.HOURS);

        when(paymentTransactionRepository.findByMethodAndStatusInAndCreatedAtAfterAndIsDeletedFalseOrIsDeletedIsNull(
            eq(PaymentMethod.VNPAY), 
            eq(Arrays.asList(PaymentStatus.INITIATED, PaymentStatus.PROCESSING)), 
            eq(cutoffTime)
        )).thenReturn(pendingTransactions);
        
        when(vnPayService.queryTransaction(eq(testTransaction), eq("127.0.0.1")))
            .thenReturn(successfulQueryResult);
        when(paymentService.processWebhook(eq("VNPAY"), anyString(), anyString()))
            .thenReturn("SUCCESS");

        // When
        vnPayPollingService.pollPendingTransactions();

        // Then
        verify(paymentTransactionRepository).save(testTransaction);
        verify(paymentService).processWebhook(eq("VNPAY"), anyString(), anyString());
    }

    @Test
    void testIsBookingExpired_BookingExpired() {
        // Given
        testBooking.setExpiresAt(Instant.now().minus(10, java.time.temporal.ChronoUnit.MINUTES)); // Expired 10 minutes ago
        testBooking.setStatus(BookingStatus.AWAITING_PAYMENT);
        testBooking.setIsDeleted(false);

        // When
        boolean isExpired = callPrivateMethod("isBookingExpired", testTransaction);

        // Then
        assertThat(isExpired).isTrue();
    }

    @Test
    void testIsBookingExpired_BookingNotExpired() {
        // Given
        testBooking.setExpiresAt(Instant.now().plus(30, java.time.temporal.ChronoUnit.MINUTES)); // Expires in 30 minutes
        testBooking.setStatus(BookingStatus.AWAITING_PAYMENT);
        testBooking.setIsDeleted(false);

        // When
        boolean isExpired = callPrivateMethod("isBookingExpired", testTransaction);

        // Then
        assertThat(isExpired).isFalse();
    }

    @Test
    void testIsBookingExpired_NoBookingAssociated() {
        // Given
        testTransaction.setBooking(null);

        // When
        boolean isExpired = callPrivateMethod("isBookingExpired", testTransaction);

        // Then
        assertThat(isExpired).isFalse();
    }

    @Test
    void testIsBookingExpired_BookingNotAwaitingPayment() {
        // Given
        testBooking.setExpiresAt(Instant.now().minus(10, java.time.temporal.ChronoUnit.MINUTES)); // Expired
        testBooking.setStatus(BookingStatus.CONFIRMED); // Not awaiting payment
        testBooking.setIsDeleted(false);

        // When
        boolean isExpired = callPrivateMethod("isBookingExpired", testTransaction);

        // Then
        assertThat(isExpired).isFalse();
    }

    @Test
    void testIsBookingExpired_BookingDeleted() {
        // Given
        testBooking.setExpiresAt(Instant.now().minus(10, java.time.temporal.ChronoUnit.MINUTES)); // Expired
        testBooking.setStatus(BookingStatus.AWAITING_PAYMENT);
        testBooking.setIsDeleted(true); // Deleted

        // When
        boolean isExpired = callPrivateMethod("isBookingExpired", testTransaction);

        // Then
        assertThat(isExpired).isFalse();
    }

    @Test
    void testIsBookingExpired_NoExpirationTime() {
        // Given
        testBooking.setExpiresAt(null); // No expiration time
        testBooking.setStatus(BookingStatus.AWAITING_PAYMENT);
        testBooking.setIsDeleted(false);

        // When
        boolean isExpired = callPrivateMethod("isBookingExpired", testTransaction);

        // Then
        assertThat(isExpired).isFalse();
    }

    @Test
    void testMarkTransactionAsFailedForExpiredBooking() {
        // Given
        testTransaction.setGatewayNote("Original note");

        // When
        callPrivateMethod("markTransactionAsFailedForExpiredBooking", testTransaction);

        // Then
        assertThat(testTransaction.getStatus()).isEqualTo(PaymentStatus.FAILED);
        assertThat(testTransaction.getGatewayNote()).contains("Booking expired - payment automatically marked as failed");
        assertThat(testTransaction.getGatewayNote()).contains("Original note");
        verify(paymentTransactionRepository).save(testTransaction);
    }

    @Test
    void testMarkTransactionAsFailedForExpiredBooking_NoExistingNote() {
        // Given
        testTransaction.setGatewayNote(null);

        // When
        callPrivateMethod("markTransactionAsFailedForExpiredBooking", testTransaction);

        // Then
        assertThat(testTransaction.getStatus()).isEqualTo(PaymentStatus.FAILED);
        assertThat(testTransaction.getGatewayNote()).isEqualTo("Booking expired - payment automatically marked as failed");
        verify(paymentTransactionRepository).save(testTransaction);
    }

    @Test
    void testPollPendingTransactions_WithExpiredBooking() {
        // Given
        testBooking.setExpiresAt(Instant.now().minus(10, java.time.temporal.ChronoUnit.MINUTES)); // Expired
        testBooking.setStatus(BookingStatus.AWAITING_PAYMENT);
        testBooking.setIsDeleted(false);

        List<PaymentTransaction> pendingTransactions = Arrays.asList(testTransaction);
        Instant cutoffTime = Instant.now().minus(24, java.time.temporal.ChronoUnit.HOURS);

        when(paymentTransactionRepository.findByMethodAndStatusInAndCreatedAtAfterAndIsDeletedFalseOrIsDeletedIsNull(
            eq(PaymentMethod.VNPAY), 
            eq(Arrays.asList(PaymentStatus.INITIATED, PaymentStatus.PROCESSING)), 
            eq(cutoffTime)
        )).thenReturn(pendingTransactions);

        // When
        vnPayPollingService.pollPendingTransactions();

        // Then
        verify(paymentTransactionRepository).save(testTransaction);
        assertThat(testTransaction.getStatus()).isEqualTo(PaymentStatus.FAILED);
        assertThat(testTransaction.getGatewayNote()).contains("Booking expired");
        // Verify that VNPay service was NOT called since booking is expired
        verify(vnPayService, never()).queryTransaction(any(PaymentTransaction.class), anyString());
    }

    @Test
    void testPollPendingTransactions_WithNonExpiredBooking() {
        // Given
        testBooking.setExpiresAt(Instant.now().plus(30, java.time.temporal.ChronoUnit.MINUTES)); // Not expired
        testBooking.setStatus(BookingStatus.AWAITING_PAYMENT);
        testBooking.setIsDeleted(false);

        List<PaymentTransaction> pendingTransactions = Arrays.asList(testTransaction);
        Instant cutoffTime = Instant.now().minus(24, java.time.temporal.ChronoUnit.HOURS);

        when(paymentTransactionRepository.findByMethodAndStatusInAndCreatedAtAfterAndIsDeletedFalseOrIsDeletedIsNull(
            eq(PaymentMethod.VNPAY), 
            eq(Arrays.asList(PaymentStatus.INITIATED, PaymentStatus.PROCESSING)), 
            eq(cutoffTime)
        )).thenReturn(pendingTransactions);
        
        when(vnPayService.queryTransaction(eq(testTransaction), eq("127.0.0.1")))
            .thenReturn(successfulQueryResult);
        when(paymentService.processWebhook(eq("VNPAY"), anyString(), anyString()))
            .thenReturn("SUCCESS");

        // When
        vnPayPollingService.pollPendingTransactions();

        // Then
        verify(paymentTransactionRepository).save(testTransaction);
        verify(vnPayService).queryTransaction(eq(testTransaction), eq("127.0.0.1"));
        verify(paymentService).processWebhook(eq("VNPAY"), anyString(), anyString());
    }

    // Helper method to call private methods for testing
    @SuppressWarnings("unchecked")
    private <T> T callPrivateMethod(String methodName, Object... args) {
        try {
            java.lang.reflect.Method method = VNPayPollingService.class.getDeclaredMethod(methodName, 
                args[0].getClass());
            method.setAccessible(true);
            return (T) method.invoke(vnPayPollingService, args);
        } catch (Exception e) {
            throw new RuntimeException("Failed to call private method: " + methodName, e);
        }
    }
}
