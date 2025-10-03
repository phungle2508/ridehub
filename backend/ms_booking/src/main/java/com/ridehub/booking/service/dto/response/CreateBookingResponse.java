package com.ridehub.booking.service.dto.response;

// src/main/java/com/ridehub/booking/service/dto/CreateBookingResponse.java

import java.math.BigDecimal;

public class CreateBookingResponse {
  private String bookingCode;
  private BigDecimal amount;
  private String status;

  public CreateBookingResponse() {
  }

  public CreateBookingResponse(String code, BigDecimal amount, String status) {
    this.bookingCode = code;
    this.amount = amount;
    this.status = status;
  }

  public String getBookingCode() {
    return bookingCode;
  }

  public void setBookingCode(String bookingCode) {
    this.bookingCode = bookingCode;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  // getters/setters
}
