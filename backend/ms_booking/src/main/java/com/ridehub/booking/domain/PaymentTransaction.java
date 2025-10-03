package com.ridehub.booking.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ridehub.booking.domain.enumeration.PaymentMethod;
import com.ridehub.booking.domain.enumeration.PaymentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/**
 * A PaymentTransaction.
 */
@Entity
@Table(name = "payment_transaction")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class PaymentTransaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(max = 80)
    @Column(name = "transaction_id", length = 80, nullable = false, unique = true)
    private String transactionId;

    @Size(max = 80)
    @Column(name = "order_ref", length = 80)
    private String orderRef;

    @Enumerated(EnumType.STRING)
    @Column(name = "method")
    private PaymentMethod method;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private PaymentStatus status;

    @Column(name = "amount", precision = 21, scale = 2)
    private BigDecimal amount;

    @Column(name = "time")
    private Instant time;

    @Size(max = 1024)
    @Column(name = "gateway_note", length = 1024)
    private String gatewayNote;

    @NotNull
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    @JdbcTypeCode(SqlTypes.VARCHAR)
    @Column(name = "deleted_by", length = 36)
    private UUID deletedBy;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "paymentTransaction")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "paymentTransaction" }, allowSetters = true)
    private Set<PaymentWebhookLog> webhooks = new HashSet<>();

    @JsonIgnoreProperties(value = { "invoice", "paymentTransaction", "tickets", "appliedPromos", "pricingSnapshots" }, allowSetters = true)
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "paymentTransaction")
    private Booking booking;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public PaymentTransaction id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public PaymentTransaction transactionId(String transactionId) {
        this.setTransactionId(transactionId);
        return this;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOrderRef() {
        return this.orderRef;
    }

    public PaymentTransaction orderRef(String orderRef) {
        this.setOrderRef(orderRef);
        return this;
    }

    public void setOrderRef(String orderRef) {
        this.orderRef = orderRef;
    }

    public PaymentMethod getMethod() {
        return this.method;
    }

    public PaymentTransaction method(PaymentMethod method) {
        this.setMethod(method);
        return this;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

    public PaymentStatus getStatus() {
        return this.status;
    }

    public PaymentTransaction status(PaymentStatus status) {
        this.setStatus(status);
        return this;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return this.amount;
    }

    public PaymentTransaction amount(BigDecimal amount) {
        this.setAmount(amount);
        return this;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Instant getTime() {
        return this.time;
    }

    public PaymentTransaction time(Instant time) {
        this.setTime(time);
        return this;
    }

    public void setTime(Instant time) {
        this.time = time;
    }

    public String getGatewayNote() {
        return this.gatewayNote;
    }

    public PaymentTransaction gatewayNote(String gatewayNote) {
        this.setGatewayNote(gatewayNote);
        return this;
    }

    public void setGatewayNote(String gatewayNote) {
        this.gatewayNote = gatewayNote;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public PaymentTransaction createdAt(Instant createdAt) {
        this.setCreatedAt(createdAt);
        return this;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    public PaymentTransaction updatedAt(Instant updatedAt) {
        this.setUpdatedAt(updatedAt);
        return this;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getIsDeleted() {
        return this.isDeleted;
    }

    public PaymentTransaction isDeleted(Boolean isDeleted) {
        this.setIsDeleted(isDeleted);
        return this;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Instant getDeletedAt() {
        return this.deletedAt;
    }

    public PaymentTransaction deletedAt(Instant deletedAt) {
        this.setDeletedAt(deletedAt);
        return this;
    }

    public void setDeletedAt(Instant deletedAt) {
        this.deletedAt = deletedAt;
    }

    public UUID getDeletedBy() {
        return this.deletedBy;
    }

    public PaymentTransaction deletedBy(UUID deletedBy) {
        this.setDeletedBy(deletedBy);
        return this;
    }

    public void setDeletedBy(UUID deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Set<PaymentWebhookLog> getWebhooks() {
        return this.webhooks;
    }

    public void setWebhooks(Set<PaymentWebhookLog> paymentWebhookLogs) {
        if (this.webhooks != null) {
            this.webhooks.forEach(i -> i.setPaymentTransaction(null));
        }
        if (paymentWebhookLogs != null) {
            paymentWebhookLogs.forEach(i -> i.setPaymentTransaction(this));
        }
        this.webhooks = paymentWebhookLogs;
    }

    public PaymentTransaction webhooks(Set<PaymentWebhookLog> paymentWebhookLogs) {
        this.setWebhooks(paymentWebhookLogs);
        return this;
    }

    public PaymentTransaction addWebhooks(PaymentWebhookLog paymentWebhookLog) {
        this.webhooks.add(paymentWebhookLog);
        paymentWebhookLog.setPaymentTransaction(this);
        return this;
    }

    public PaymentTransaction removeWebhooks(PaymentWebhookLog paymentWebhookLog) {
        this.webhooks.remove(paymentWebhookLog);
        paymentWebhookLog.setPaymentTransaction(null);
        return this;
    }

    public Booking getBooking() {
        return this.booking;
    }

    public void setBooking(Booking booking) {
        if (this.booking != null) {
            this.booking.setPaymentTransaction(null);
        }
        if (booking != null) {
            booking.setPaymentTransaction(this);
        }
        this.booking = booking;
    }

    public PaymentTransaction booking(Booking booking) {
        this.setBooking(booking);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PaymentTransaction)) {
            return false;
        }
        return getId() != null && getId().equals(((PaymentTransaction) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PaymentTransaction{" +
            "id=" + getId() +
            ", transactionId='" + getTransactionId() + "'" +
            ", orderRef='" + getOrderRef() + "'" +
            ", method='" + getMethod() + "'" +
            ", status='" + getStatus() + "'" +
            ", amount=" + getAmount() +
            ", time='" + getTime() + "'" +
            ", gatewayNote='" + getGatewayNote() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            ", isDeleted='" + getIsDeleted() + "'" +
            ", deletedAt='" + getDeletedAt() + "'" +
            ", deletedBy='" + getDeletedBy() + "'" +
            "}";
    }
}
