package com.ridehub.booking.service.vm;

import com.ridehub.booking.domain.enumeration.BookingStatus;
import com.ridehub.booking.domain.enumeration.PaymentStatus;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public class PaymentWebhookResultVM {

    private String status;
    private String message;
    private Long bookingId;
    private String bookingCode;
    private BookingStatus bookingStatus;
    private PaymentStatus paymentStatus;
    private BigDecimal amount;
    private String transactionId;
    private Instant processedAt;
    private List<TicketVM> tickets;

    public PaymentWebhookResultVM() {
    }

    public PaymentWebhookResultVM(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Instant getProcessedAt() {
        return processedAt;
    }

    public void setProcessedAt(Instant processedAt) {
        this.processedAt = processedAt;
    }

    public List<TicketVM> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketVM> tickets) {
        this.tickets = tickets;
    }

    // Simple TicketVM inner class
    public static class TicketVM {
        private Long id;
        private String ticketCode;
        private String seatNumber;

        public TicketVM() {
        }

        public TicketVM(Long id, String ticketCode, String seatNumber) {
            this.id = id;
            this.ticketCode = ticketCode;
            this.seatNumber = seatNumber;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTicketCode() {
            return ticketCode;
        }

        public void setTicketCode(String ticketCode) {
            this.ticketCode = ticketCode;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public void setSeatNumber(String seatNumber) {
            this.seatNumber = seatNumber;
        }
    }
}
