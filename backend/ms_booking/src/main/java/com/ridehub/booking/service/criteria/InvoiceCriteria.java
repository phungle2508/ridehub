package com.ridehub.booking.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.ridehub.booking.domain.Invoice} entity. This class is used
 * in {@link com.ridehub.booking.web.rest.InvoiceResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /invoices?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class InvoiceCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter invoiceNo;

    private InstantFilter issuedAt;

    private BigDecimalFilter grossAmount;

    private BigDecimalFilter vatAmount;

    private BigDecimalFilter netAmount;

    private InstantFilter createdAt;

    private InstantFilter updatedAt;

    private BooleanFilter isDeleted;

    private InstantFilter deletedAt;

    private UUIDFilter deletedBy;

    private LongFilter bookingId;

    private Boolean distinct;

    public InvoiceCriteria() {}

    public InvoiceCriteria(InvoiceCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.invoiceNo = other.optionalInvoiceNo().map(StringFilter::copy).orElse(null);
        this.issuedAt = other.optionalIssuedAt().map(InstantFilter::copy).orElse(null);
        this.grossAmount = other.optionalGrossAmount().map(BigDecimalFilter::copy).orElse(null);
        this.vatAmount = other.optionalVatAmount().map(BigDecimalFilter::copy).orElse(null);
        this.netAmount = other.optionalNetAmount().map(BigDecimalFilter::copy).orElse(null);
        this.createdAt = other.optionalCreatedAt().map(InstantFilter::copy).orElse(null);
        this.updatedAt = other.optionalUpdatedAt().map(InstantFilter::copy).orElse(null);
        this.isDeleted = other.optionalIsDeleted().map(BooleanFilter::copy).orElse(null);
        this.deletedAt = other.optionalDeletedAt().map(InstantFilter::copy).orElse(null);
        this.deletedBy = other.optionalDeletedBy().map(UUIDFilter::copy).orElse(null);
        this.bookingId = other.optionalBookingId().map(LongFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public InvoiceCriteria copy() {
        return new InvoiceCriteria(this);
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

    public StringFilter getInvoiceNo() {
        return invoiceNo;
    }

    public Optional<StringFilter> optionalInvoiceNo() {
        return Optional.ofNullable(invoiceNo);
    }

    public StringFilter invoiceNo() {
        if (invoiceNo == null) {
            setInvoiceNo(new StringFilter());
        }
        return invoiceNo;
    }

    public void setInvoiceNo(StringFilter invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public InstantFilter getIssuedAt() {
        return issuedAt;
    }

    public Optional<InstantFilter> optionalIssuedAt() {
        return Optional.ofNullable(issuedAt);
    }

    public InstantFilter issuedAt() {
        if (issuedAt == null) {
            setIssuedAt(new InstantFilter());
        }
        return issuedAt;
    }

    public void setIssuedAt(InstantFilter issuedAt) {
        this.issuedAt = issuedAt;
    }

    public BigDecimalFilter getGrossAmount() {
        return grossAmount;
    }

    public Optional<BigDecimalFilter> optionalGrossAmount() {
        return Optional.ofNullable(grossAmount);
    }

    public BigDecimalFilter grossAmount() {
        if (grossAmount == null) {
            setGrossAmount(new BigDecimalFilter());
        }
        return grossAmount;
    }

    public void setGrossAmount(BigDecimalFilter grossAmount) {
        this.grossAmount = grossAmount;
    }

    public BigDecimalFilter getVatAmount() {
        return vatAmount;
    }

    public Optional<BigDecimalFilter> optionalVatAmount() {
        return Optional.ofNullable(vatAmount);
    }

    public BigDecimalFilter vatAmount() {
        if (vatAmount == null) {
            setVatAmount(new BigDecimalFilter());
        }
        return vatAmount;
    }

    public void setVatAmount(BigDecimalFilter vatAmount) {
        this.vatAmount = vatAmount;
    }

    public BigDecimalFilter getNetAmount() {
        return netAmount;
    }

    public Optional<BigDecimalFilter> optionalNetAmount() {
        return Optional.ofNullable(netAmount);
    }

    public BigDecimalFilter netAmount() {
        if (netAmount == null) {
            setNetAmount(new BigDecimalFilter());
        }
        return netAmount;
    }

    public void setNetAmount(BigDecimalFilter netAmount) {
        this.netAmount = netAmount;
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
        final InvoiceCriteria that = (InvoiceCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(invoiceNo, that.invoiceNo) &&
            Objects.equals(issuedAt, that.issuedAt) &&
            Objects.equals(grossAmount, that.grossAmount) &&
            Objects.equals(vatAmount, that.vatAmount) &&
            Objects.equals(netAmount, that.netAmount) &&
            Objects.equals(createdAt, that.createdAt) &&
            Objects.equals(updatedAt, that.updatedAt) &&
            Objects.equals(isDeleted, that.isDeleted) &&
            Objects.equals(deletedAt, that.deletedAt) &&
            Objects.equals(deletedBy, that.deletedBy) &&
            Objects.equals(bookingId, that.bookingId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            invoiceNo,
            issuedAt,
            grossAmount,
            vatAmount,
            netAmount,
            createdAt,
            updatedAt,
            isDeleted,
            deletedAt,
            deletedBy,
            bookingId,
            distinct
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "InvoiceCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalInvoiceNo().map(f -> "invoiceNo=" + f + ", ").orElse("") +
            optionalIssuedAt().map(f -> "issuedAt=" + f + ", ").orElse("") +
            optionalGrossAmount().map(f -> "grossAmount=" + f + ", ").orElse("") +
            optionalVatAmount().map(f -> "vatAmount=" + f + ", ").orElse("") +
            optionalNetAmount().map(f -> "netAmount=" + f + ", ").orElse("") +
            optionalCreatedAt().map(f -> "createdAt=" + f + ", ").orElse("") +
            optionalUpdatedAt().map(f -> "updatedAt=" + f + ", ").orElse("") +
            optionalIsDeleted().map(f -> "isDeleted=" + f + ", ").orElse("") +
            optionalDeletedAt().map(f -> "deletedAt=" + f + ", ").orElse("") +
            optionalDeletedBy().map(f -> "deletedBy=" + f + ", ").orElse("") +
            optionalBookingId().map(f -> "bookingId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
