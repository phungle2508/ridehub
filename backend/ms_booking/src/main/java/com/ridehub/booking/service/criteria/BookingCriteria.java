package com.ridehub.booking.service.criteria;

import com.ridehub.booking.domain.enumeration.BookingStatus;
import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.ridehub.booking.domain.Booking} entity. This class is used
 * in {@link com.ridehub.booking.web.rest.BookingResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /bookings?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class BookingCriteria implements Serializable, Criteria {

    /**
     * Class for filtering BookingStatus
     */
    public static class BookingStatusFilter extends Filter<BookingStatus> {

        public BookingStatusFilter() {}

        public BookingStatusFilter(BookingStatusFilter filter) {
            super(filter);
        }

        @Override
        public BookingStatusFilter copy() {
            return new BookingStatusFilter(this);
        }
    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter bookingCode;

    private BookingStatusFilter status;

    private IntegerFilter quantity;

    private BigDecimalFilter totalAmount;

    private InstantFilter bookedAt;

    private UUIDFilter customerId;

    private StringFilter idempotencyKey;

    private InstantFilter createdAt;

    private InstantFilter updatedAt;

    private BooleanFilter isDeleted;

    private InstantFilter deletedAt;

    private UUIDFilter deletedBy;

    private LongFilter invoiceId;

    private LongFilter paymentTransactionId;

    private LongFilter ticketsId;

    private LongFilter appliedPromosId;

    private LongFilter pricingSnapshotsId;

    private Boolean distinct;

    public BookingCriteria() {}

    public BookingCriteria(BookingCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.bookingCode = other.optionalBookingCode().map(StringFilter::copy).orElse(null);
        this.status = other.optionalStatus().map(BookingStatusFilter::copy).orElse(null);
        this.quantity = other.optionalQuantity().map(IntegerFilter::copy).orElse(null);
        this.totalAmount = other.optionalTotalAmount().map(BigDecimalFilter::copy).orElse(null);
        this.bookedAt = other.optionalBookedAt().map(InstantFilter::copy).orElse(null);
        this.customerId = other.optionalCustomerId().map(UUIDFilter::copy).orElse(null);
        this.idempotencyKey = other.optionalIdempotencyKey().map(StringFilter::copy).orElse(null);
        this.createdAt = other.optionalCreatedAt().map(InstantFilter::copy).orElse(null);
        this.updatedAt = other.optionalUpdatedAt().map(InstantFilter::copy).orElse(null);
        this.isDeleted = other.optionalIsDeleted().map(BooleanFilter::copy).orElse(null);
        this.deletedAt = other.optionalDeletedAt().map(InstantFilter::copy).orElse(null);
        this.deletedBy = other.optionalDeletedBy().map(UUIDFilter::copy).orElse(null);
        this.invoiceId = other.optionalInvoiceId().map(LongFilter::copy).orElse(null);
        this.paymentTransactionId = other.optionalPaymentTransactionId().map(LongFilter::copy).orElse(null);
        this.ticketsId = other.optionalTicketsId().map(LongFilter::copy).orElse(null);
        this.appliedPromosId = other.optionalAppliedPromosId().map(LongFilter::copy).orElse(null);
        this.pricingSnapshotsId = other.optionalPricingSnapshotsId().map(LongFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public BookingCriteria copy() {
        return new BookingCriteria(this);
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

    public StringFilter getBookingCode() {
        return bookingCode;
    }

    public Optional<StringFilter> optionalBookingCode() {
        return Optional.ofNullable(bookingCode);
    }

    public StringFilter bookingCode() {
        if (bookingCode == null) {
            setBookingCode(new StringFilter());
        }
        return bookingCode;
    }

    public void setBookingCode(StringFilter bookingCode) {
        this.bookingCode = bookingCode;
    }

    public BookingStatusFilter getStatus() {
        return status;
    }

    public Optional<BookingStatusFilter> optionalStatus() {
        return Optional.ofNullable(status);
    }

    public BookingStatusFilter status() {
        if (status == null) {
            setStatus(new BookingStatusFilter());
        }
        return status;
    }

    public void setStatus(BookingStatusFilter status) {
        this.status = status;
    }

    public IntegerFilter getQuantity() {
        return quantity;
    }

    public Optional<IntegerFilter> optionalQuantity() {
        return Optional.ofNullable(quantity);
    }

    public IntegerFilter quantity() {
        if (quantity == null) {
            setQuantity(new IntegerFilter());
        }
        return quantity;
    }

    public void setQuantity(IntegerFilter quantity) {
        this.quantity = quantity;
    }

    public BigDecimalFilter getTotalAmount() {
        return totalAmount;
    }

    public Optional<BigDecimalFilter> optionalTotalAmount() {
        return Optional.ofNullable(totalAmount);
    }

    public BigDecimalFilter totalAmount() {
        if (totalAmount == null) {
            setTotalAmount(new BigDecimalFilter());
        }
        return totalAmount;
    }

    public void setTotalAmount(BigDecimalFilter totalAmount) {
        this.totalAmount = totalAmount;
    }

    public InstantFilter getBookedAt() {
        return bookedAt;
    }

    public Optional<InstantFilter> optionalBookedAt() {
        return Optional.ofNullable(bookedAt);
    }

    public InstantFilter bookedAt() {
        if (bookedAt == null) {
            setBookedAt(new InstantFilter());
        }
        return bookedAt;
    }

    public void setBookedAt(InstantFilter bookedAt) {
        this.bookedAt = bookedAt;
    }

    public UUIDFilter getCustomerId() {
        return customerId;
    }

    public Optional<UUIDFilter> optionalCustomerId() {
        return Optional.ofNullable(customerId);
    }

    public UUIDFilter customerId() {
        if (customerId == null) {
            setCustomerId(new UUIDFilter());
        }
        return customerId;
    }

    public void setCustomerId(UUIDFilter customerId) {
        this.customerId = customerId;
    }

    public StringFilter getIdempotencyKey() {
        return idempotencyKey;
    }

    public Optional<StringFilter> optionalIdempotencyKey() {
        return Optional.ofNullable(idempotencyKey);
    }

    public StringFilter idempotencyKey() {
        if (idempotencyKey == null) {
            setIdempotencyKey(new StringFilter());
        }
        return idempotencyKey;
    }

    public void setIdempotencyKey(StringFilter idempotencyKey) {
        this.idempotencyKey = idempotencyKey;
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

    public LongFilter getInvoiceId() {
        return invoiceId;
    }

    public Optional<LongFilter> optionalInvoiceId() {
        return Optional.ofNullable(invoiceId);
    }

    public LongFilter invoiceId() {
        if (invoiceId == null) {
            setInvoiceId(new LongFilter());
        }
        return invoiceId;
    }

    public void setInvoiceId(LongFilter invoiceId) {
        this.invoiceId = invoiceId;
    }

    public LongFilter getPaymentTransactionId() {
        return paymentTransactionId;
    }

    public Optional<LongFilter> optionalPaymentTransactionId() {
        return Optional.ofNullable(paymentTransactionId);
    }

    public LongFilter paymentTransactionId() {
        if (paymentTransactionId == null) {
            setPaymentTransactionId(new LongFilter());
        }
        return paymentTransactionId;
    }

    public void setPaymentTransactionId(LongFilter paymentTransactionId) {
        this.paymentTransactionId = paymentTransactionId;
    }

    public LongFilter getTicketsId() {
        return ticketsId;
    }

    public Optional<LongFilter> optionalTicketsId() {
        return Optional.ofNullable(ticketsId);
    }

    public LongFilter ticketsId() {
        if (ticketsId == null) {
            setTicketsId(new LongFilter());
        }
        return ticketsId;
    }

    public void setTicketsId(LongFilter ticketsId) {
        this.ticketsId = ticketsId;
    }

    public LongFilter getAppliedPromosId() {
        return appliedPromosId;
    }

    public Optional<LongFilter> optionalAppliedPromosId() {
        return Optional.ofNullable(appliedPromosId);
    }

    public LongFilter appliedPromosId() {
        if (appliedPromosId == null) {
            setAppliedPromosId(new LongFilter());
        }
        return appliedPromosId;
    }

    public void setAppliedPromosId(LongFilter appliedPromosId) {
        this.appliedPromosId = appliedPromosId;
    }

    public LongFilter getPricingSnapshotsId() {
        return pricingSnapshotsId;
    }

    public Optional<LongFilter> optionalPricingSnapshotsId() {
        return Optional.ofNullable(pricingSnapshotsId);
    }

    public LongFilter pricingSnapshotsId() {
        if (pricingSnapshotsId == null) {
            setPricingSnapshotsId(new LongFilter());
        }
        return pricingSnapshotsId;
    }

    public void setPricingSnapshotsId(LongFilter pricingSnapshotsId) {
        this.pricingSnapshotsId = pricingSnapshotsId;
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
        final BookingCriteria that = (BookingCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(bookingCode, that.bookingCode) &&
            Objects.equals(status, that.status) &&
            Objects.equals(quantity, that.quantity) &&
            Objects.equals(totalAmount, that.totalAmount) &&
            Objects.equals(bookedAt, that.bookedAt) &&
            Objects.equals(customerId, that.customerId) &&
            Objects.equals(idempotencyKey, that.idempotencyKey) &&
            Objects.equals(createdAt, that.createdAt) &&
            Objects.equals(updatedAt, that.updatedAt) &&
            Objects.equals(isDeleted, that.isDeleted) &&
            Objects.equals(deletedAt, that.deletedAt) &&
            Objects.equals(deletedBy, that.deletedBy) &&
            Objects.equals(invoiceId, that.invoiceId) &&
            Objects.equals(paymentTransactionId, that.paymentTransactionId) &&
            Objects.equals(ticketsId, that.ticketsId) &&
            Objects.equals(appliedPromosId, that.appliedPromosId) &&
            Objects.equals(pricingSnapshotsId, that.pricingSnapshotsId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            bookingCode,
            status,
            quantity,
            totalAmount,
            bookedAt,
            customerId,
            idempotencyKey,
            createdAt,
            updatedAt,
            isDeleted,
            deletedAt,
            deletedBy,
            invoiceId,
            paymentTransactionId,
            ticketsId,
            appliedPromosId,
            pricingSnapshotsId,
            distinct
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "BookingCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalBookingCode().map(f -> "bookingCode=" + f + ", ").orElse("") +
            optionalStatus().map(f -> "status=" + f + ", ").orElse("") +
            optionalQuantity().map(f -> "quantity=" + f + ", ").orElse("") +
            optionalTotalAmount().map(f -> "totalAmount=" + f + ", ").orElse("") +
            optionalBookedAt().map(f -> "bookedAt=" + f + ", ").orElse("") +
            optionalCustomerId().map(f -> "customerId=" + f + ", ").orElse("") +
            optionalIdempotencyKey().map(f -> "idempotencyKey=" + f + ", ").orElse("") +
            optionalCreatedAt().map(f -> "createdAt=" + f + ", ").orElse("") +
            optionalUpdatedAt().map(f -> "updatedAt=" + f + ", ").orElse("") +
            optionalIsDeleted().map(f -> "isDeleted=" + f + ", ").orElse("") +
            optionalDeletedAt().map(f -> "deletedAt=" + f + ", ").orElse("") +
            optionalDeletedBy().map(f -> "deletedBy=" + f + ", ").orElse("") +
            optionalInvoiceId().map(f -> "invoiceId=" + f + ", ").orElse("") +
            optionalPaymentTransactionId().map(f -> "paymentTransactionId=" + f + ", ").orElse("") +
            optionalTicketsId().map(f -> "ticketsId=" + f + ", ").orElse("") +
            optionalAppliedPromosId().map(f -> "appliedPromosId=" + f + ", ").orElse("") +
            optionalPricingSnapshotsId().map(f -> "pricingSnapshotsId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
