package com.ridehub.booking.service.vm;

public class PaymentInitiationResultVM {

    private String paymentUrl;
    private String transactionId;
    private String orderRef;

    public PaymentInitiationResultVM() {
    }

    public PaymentInitiationResultVM(String paymentUrl, String transactionId, String orderRef) {
        this.paymentUrl = paymentUrl;
        this.transactionId = transactionId;
        this.orderRef = orderRef;
    }

    public String getPaymentUrl() {
        return paymentUrl;
    }

    public void setPaymentUrl(String paymentUrl) {
        this.paymentUrl = paymentUrl;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOrderRef() {
        return orderRef;
    }

    public void setOrderRef(String orderRef) {
        this.orderRef = orderRef;
    }
}
