package com.ridehub.user.service.dto.auth;

/**
 * DTO for OTP send response
 */
public class SendOtpResponseDTO {

    private String txnId;
    private long expiresIn;
    private String message;

    // Constructors
    public SendOtpResponseDTO() {}

    public SendOtpResponseDTO(String txnId, long expiresIn) {
        this.txnId = txnId;
        this.expiresIn = expiresIn;
        this.message = "OTP sent successfully";
    }

    public SendOtpResponseDTO(String txnId, long expiresIn, String message) {
        this.txnId = txnId;
        this.expiresIn = expiresIn;
        this.message = message;
    }

    // Static factory methods
    public static SendOtpResponseDTO success(String txnId, long expiresIn) {
        return new SendOtpResponseDTO(txnId, expiresIn);
    }

    public static SendOtpResponseDTO error(String message) {
        SendOtpResponseDTO response = new SendOtpResponseDTO();
        response.setMessage(message);
        return response;
    }

    // Getters and Setters
    public String getTxnId() {
        return txnId;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SendOtpResponseDTO{" +
            "txnId='" + txnId + '\'' +
            ", expiresIn=" + expiresIn +
            ", message='" + message + '\'' +
            '}';
    }
}
