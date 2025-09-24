package com.ridehub.route.service.dto.external;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

/**
 * A DTO representing booking data from msbooking service.
 */
public class BookingDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID id;
    private String bookingCode;
    private UUID customerId;
    private Long tripId;
    private String status; // PENDING, CONFIRMED, CANCELLED, COMPLETED
    private BigDecimal totalAmount;
    private List<String> seatNumbers;
    private Instant bookingDate;
    private Instant departureTime;
    private String paymentStatus;
    private String paymentMethod;
    private Instant createdAt;
    private Instant updatedAt;

    // Default constructor
    public BookingDTO() {}

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<String> getSeatNumbers() {
        return seatNumbers;
    }

    public void setSeatNumbers(List<String> seatNumbers) {
        this.seatNumbers = seatNumbers;
    }

    public Instant getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Instant bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Instant getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Instant departureTime) {
        this.departureTime = departureTime;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "BookingDTO{" +
            "id=" + id +
            ", bookingCode='" + bookingCode + '\'' +
            ", customerId=" + customerId +
            ", tripId=" + tripId +
            ", status='" + status + '\'' +
            ", totalAmount=" + totalAmount +
            ", seatNumbers=" + seatNumbers +
            ", bookingDate=" + bookingDate +
            ", departureTime=" + departureTime +
            ", paymentStatus='" + paymentStatus + '\'' +
            ", paymentMethod='" + paymentMethod + '\'' +
            ", createdAt=" + createdAt +
            ", updatedAt=" + updatedAt +
            '}';
    }
}
