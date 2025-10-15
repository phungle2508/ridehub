package com.ridehub.booking.service.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for refund request.
 */
public class RefundRequestDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.01", message = "Amount must be greater than 0")
    private BigDecimal amount;

    @NotBlank(message = "Order info is required")
    private String orderInfo;

    @NotBlank(message = "Transaction type is required")
    private String transactionType;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return "RefundRequestDTO{" +
                "amount=" + amount +
                ", orderInfo='" + orderInfo + '\'' +
                ", transactionType='" + transactionType + '\'' +
                '}';
    }
}
