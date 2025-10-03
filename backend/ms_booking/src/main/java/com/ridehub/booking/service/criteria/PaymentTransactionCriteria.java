package com.ridehub.booking.service.criteria;

import com.ridehub.booking.domain.enumeration.PaymentMethod;
import com.ridehub.booking.domain.enumeration.PaymentStatus;
import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.ridehub.booking.domain.PaymentTransaction} entity. This class is used
 * in {@link com.ridehub.booking.web.rest.PaymentTransactionResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /payment-transactions?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class PaymentTransactionCriteria implements Serializable, Criteria {

    /**
     * Class for filtering PaymentMethod
     */
    public static class PaymentMethodFilter extends Filter<PaymentMethod> {

        public PaymentMethodFilter() {}

        public PaymentMethodFilter(PaymentMethodFilter filter) {
            super(filter);
        }

        @Override
        public PaymentMethodFilter copy() {
            return new PaymentMethodFilter(this);
        }
    }

    /**
     * Class for filtering PaymentStatus
     */
    public static class PaymentStatusFilter extends Filter<PaymentStatus> {

        public PaymentStatusFilter() {}

        public PaymentStatusFilter(PaymentStatusFilter filter) {
            super(filter);
        }

        @Override
        public PaymentStatusFilter copy() {
            return new PaymentStatusFilter(this);
        }
    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter transactionId;

    private StringFilter orderRef;

    private PaymentMethodFilter method;

    private PaymentStatusFilter status;

    private BigDecimalFilter amount;

    private InstantFilter time;

    private StringFilter gatewayNote;

    private InstantFilter createdAt;

    private InstantFilter updatedAt;

    private BooleanFilter isDeleted;

    private InstantFilter deletedAt;

    private UUIDFilter deletedBy;

    private LongFilter webhooksId;

    private LongFilter bookingId;

    private Boolean distinct;

    public PaymentTransactionCriteria() {}

    public PaymentTransactionCriteria(PaymentTransactionCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.transactionId = other.optionalTransactionId().map(StringFilter::copy).orElse(null);
        this.orderRef = other.optionalOrderRef().map(StringFilter::copy).orElse(null);
        this.method = other.optionalMethod().map(PaymentMethodFilter::copy).orElse(null);
        this.status = other.optionalStatus().map(PaymentStatusFilter::copy).orElse(null);
        this.amount = other.optionalAmount().map(BigDecimalFilter::copy).orElse(null);
        this.time = other.optionalTime().map(InstantFilter::copy).orElse(null);
        this.gatewayNote = other.optionalGatewayNote().map(StringFilter::copy).orElse(null);
        this.createdAt = other.optionalCreatedAt().map(InstantFilter::copy).orElse(null);
        this.updatedAt = other.optionalUpdatedAt().map(InstantFilter::copy).orElse(null);
        this.isDeleted = other.optionalIsDeleted().map(BooleanFilter::copy).orElse(null);
        this.deletedAt = other.optionalDeletedAt().map(InstantFilter::copy).orElse(null);
        this.deletedBy = other.optionalDeletedBy().map(UUIDFilter::copy).orElse(null);
        this.webhooksId = other.optionalWebhooksId().map(LongFilter::copy).orElse(null);
        this.bookingId = other.optionalBookingId().map(LongFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public PaymentTransactionCriteria copy() {
        return new PaymentTransactionCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public Optional<LongFilter> optionalId() {
        return Optional.ofNullable(id);
    }

    public LongFilter id() {
        if (id == null) {
            setId(new LongFilter());
        }
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getTransactionId() {
        return transactionId;
    }

    public Optional<StringFilter> optionalTransactionId() {
        return Optional.ofNullable(transactionId);
    }

    public StringFilter transactionId() {
        if (transactionId == null) {
            setTransactionId(new StringFilter());
        }
        return transactionId;
    }

    public void setTransactionId(StringFilter transactionId) {
        this.transactionId = transactionId;
    }

    public StringFilter getOrderRef() {
        return orderRef;
    }

    public Optional<StringFilter> optionalOrderRef() {
        return Optional.ofNullable(orderRef);
    }

    public StringFilter orderRef() {
        if (orderRef == null) {
            setOrderRef(new StringFilter());
        }
        return orderRef;
    }

    public void setOrderRef(StringFilter orderRef) {
        this.orderRef = orderRef;
    }

    public PaymentMethodFilter getMethod() {
        return method;
    }

    public Optional<PaymentMethodFilter> optionalMethod() {
        return Optional.ofNullable(method);
    }

    public PaymentMethodFilter method() {
        if (method == null) {
            setMethod(new PaymentMethodFilter());
        }
        return method;
    }

    public void setMethod(PaymentMethodFilter method) {
        this.method = method;
    }

    public PaymentStatusFilter getStatus() {
        return status;
    }

    public Optional<PaymentStatusFilter> optionalStatus() {
        return Optional.ofNullable(status);
    }

    public PaymentStatusFilter status() {
        if (status == null) {
            setStatus(new PaymentStatusFilter());
        }
        return status;
    }

    public void setStatus(PaymentStatusFilter status) {
        this.status = status;
    }

    public BigDecimalFilter getAmount() {
        return amount;
    }

    public Optional<BigDecimalFilter> optionalAmount() {
        return Optional.ofNullable(amount);
    }

    public BigDecimalFilter amount() {
        if (amount == null) {
            setAmount(new BigDecimalFilter());
        }
        return amount;
    }

    public void setAmount(BigDecimalFilter amount) {
        this.amount = amount;
    }

    public InstantFilter getTime() {
        return time;
    }

    public Optional<InstantFilter> optionalTime() {
        return Optional.ofNullable(time);
    }

    public InstantFilter time() {
        if (time == null) {
            setTime(new InstantFilter());
        }
        return time;
    }

    public void setTime(InstantFilter time) {
        this.time = time;
    }

    public StringFilter getGatewayNote() {
        return gatewayNote;
    }

    public Optional<StringFilter> optionalGatewayNote() {
        return Optional.ofNullable(gatewayNote);
    }

    public StringFilter gatewayNote() {
        if (gatewayNote == null) {
            setGatewayNote(new StringFilter());
        }
        return gatewayNote;
    }

    public void setGatewayNote(StringFilter gatewayNote) {
        this.gatewayNote = gatewayNote;
    }

    public InstantFilter getCreatedAt() {
        return createdAt;
    }

    public Optional<InstantFilter> optionalCreatedAt() {
        return Optional.ofNullable(createdAt);
    }

    public InstantFilter createdAt() {
        if (createdAt == null) {
            setCreatedAt(new InstantFilter());
        }
        return createdAt;
    }

    public void setCreatedAt(InstantFilter createdAt) {
        this.createdAt = createdAt;
    }

    public InstantFilter getUpdatedAt() {
        return updatedAt;
    }

    public Optional<InstantFilter> optionalUpdatedAt() {
        return Optional.ofNullable(updatedAt);
    }

    public InstantFilter updatedAt() {
        if (updatedAt == null) {
            setUpdatedAt(new InstantFilter());
        }
        return updatedAt;
    }

    public void setUpdatedAt(InstantFilter updatedAt) {
        this.updatedAt = updatedAt;
    }

    public BooleanFilter getIsDeleted() {
        return isDeleted;
    }

    public Optional<BooleanFilter> optionalIsDeleted() {
        return Optional.ofNullable(isDeleted);
    }

    public BooleanFilter isDeleted() {
        if (isDeleted == null) {
            setIsDeleted(new BooleanFilter());
        }
        return isDeleted;
    }

    public void setIsDeleted(BooleanFilter isDeleted) {
        this.isDeleted = isDeleted;
    }

    public InstantFilter getDeletedAt() {
        return deletedAt;
    }

    public Optional<InstantFilter> optionalDeletedAt() {
        return Optional.ofNullable(deletedAt);
    }

    public InstantFilter deletedAt() {
        if (deletedAt == null) {
            setDeletedAt(new InstantFilter());
        }
        return deletedAt;
    }

    public void setDeletedAt(InstantFilter deletedAt) {
        this.deletedAt = deletedAt;
    }

    public UUIDFilter getDeletedBy() {
        return deletedBy;
    }

    public Optional<UUIDFilter> optionalDeletedBy() {
        return Optional.ofNullable(deletedBy);
    }

    public UUIDFilter deletedBy() {
        if (deletedBy == null) {
            setDeletedBy(new UUIDFilter());
        }
        return deletedBy;
    }

    public void setDeletedBy(UUIDFilter deletedBy) {
        this.deletedBy = deletedBy;
    }

    public LongFilter getWebhooksId() {
        return webhooksId;
    }

    public Optional<LongFilter> optionalWebhooksId() {
        return Optional.ofNullable(webhooksId);
    }

    public LongFilter webhooksId() {
        if (webhooksId == null) {
            setWebhooksId(new LongFilter());
        }
        return webhooksId;
    }

    public void setWebhooksId(LongFilter webhooksId) {
        this.webhooksId = webhooksId;
    }

    public LongFilter getBookingId() {
        return bookingId;
    }

    public Optional<LongFilter> optionalBookingId() {
        return Optional.ofNullable(bookingId);
    }

    public LongFilter bookingId() {
        if (bookingId == null) {
            setBookingId(new LongFilter());
        }
        return bookingId;
    }

    public void setBookingId(LongFilter bookingId) {
        this.bookingId = bookingId;
    }

    public Boolean getDistinct() {
        return distinct;
    }

    public Optional<Boolean> optionalDistinct() {
        return Optional.ofNullable(distinct);
    }

    public Boolean distinct() {
        if (distinct == null) {
            setDistinct(true);
        }
        return distinct;
    }

    public void setDistinct(Boolean distinct) {
        this.distinct = distinct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final PaymentTransactionCriteria that = (PaymentTransactionCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(transactionId, that.transactionId) &&
            Objects.equals(orderRef, that.orderRef) &&
            Objects.equals(method, that.method) &&
            Objects.equals(status, that.status) &&
            Objects.equals(amount, that.amount) &&
            Objects.equals(time, that.time) &&
            Objects.equals(gatewayNote, that.gatewayNote) &&
            Objects.equals(createdAt, that.createdAt) &&
            Objects.equals(updatedAt, that.updatedAt) &&
            Objects.equals(isDeleted, that.isDeleted) &&
            Objects.equals(deletedAt, that.deletedAt) &&
            Objects.equals(deletedBy, that.deletedBy) &&
            Objects.equals(webhooksId, that.webhooksId) &&
            Objects.equals(bookingId, that.bookingId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            transactionId,
            orderRef,
            method,
            status,
            amount,
            time,
            gatewayNote,
            createdAt,
            updatedAt,
            isDeleted,
            deletedAt,
            deletedBy,
            webhooksId,
            bookingId,
            distinct
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PaymentTransactionCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalTransactionId().map(f -> "transactionId=" + f + ", ").orElse("") +
            optionalOrderRef().map(f -> "orderRef=" + f + ", ").orElse("") +
            optionalMethod().map(f -> "method=" + f + ", ").orElse("") +
            optionalStatus().map(f -> "status=" + f + ", ").orElse("") +
            optionalAmount().map(f -> "amount=" + f + ", ").orElse("") +
            optionalTime().map(f -> "time=" + f + ", ").orElse("") +
            optionalGatewayNote().map(f -> "gatewayNote=" + f + ", ").orElse("") +
            optionalCreatedAt().map(f -> "createdAt=" + f + ", ").orElse("") +
            optionalUpdatedAt().map(f -> "updatedAt=" + f + ", ").orElse("") +
            optionalIsDeleted().map(f -> "isDeleted=" + f + ", ").orElse("") +
            optionalDeletedAt().map(f -> "deletedAt=" + f + ", ").orElse("") +
            optionalDeletedBy().map(f -> "deletedBy=" + f + ", ").orElse("") +
            optionalWebhooksId().map(f -> "webhooksId=" + f + ", ").orElse("") +
            optionalBookingId().map(f -> "bookingId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
