package com.ridehub.booking.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import org.springdoc.core.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link com.ridehub.booking.domain.PaymentWebhookLog} entity. This class is used
 * in {@link com.ridehub.booking.web.rest.PaymentWebhookLogResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /payment-webhook-logs?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class PaymentWebhookLogCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter provider;

    private StringFilter payloadHash;

    private InstantFilter receivedAt;

    private StringFilter processingStatus;

    private InstantFilter createdAt;

    private InstantFilter updatedAt;

    private BooleanFilter isDeleted;

    private InstantFilter deletedAt;

    private UUIDFilter deletedBy;

    private LongFilter paymentTransactionId;

    private Boolean distinct;

    public PaymentWebhookLogCriteria() {}

    public PaymentWebhookLogCriteria(PaymentWebhookLogCriteria other) {
        this.id = other.optionalId().map(LongFilter::copy).orElse(null);
        this.provider = other.optionalProvider().map(StringFilter::copy).orElse(null);
        this.payloadHash = other.optionalPayloadHash().map(StringFilter::copy).orElse(null);
        this.receivedAt = other.optionalReceivedAt().map(InstantFilter::copy).orElse(null);
        this.processingStatus = other.optionalProcessingStatus().map(StringFilter::copy).orElse(null);
        this.createdAt = other.optionalCreatedAt().map(InstantFilter::copy).orElse(null);
        this.updatedAt = other.optionalUpdatedAt().map(InstantFilter::copy).orElse(null);
        this.isDeleted = other.optionalIsDeleted().map(BooleanFilter::copy).orElse(null);
        this.deletedAt = other.optionalDeletedAt().map(InstantFilter::copy).orElse(null);
        this.deletedBy = other.optionalDeletedBy().map(UUIDFilter::copy).orElse(null);
        this.paymentTransactionId = other.optionalPaymentTransactionId().map(LongFilter::copy).orElse(null);
        this.distinct = other.distinct;
    }

    @Override
    public PaymentWebhookLogCriteria copy() {
        return new PaymentWebhookLogCriteria(this);
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

    public StringFilter getProvider() {
        return provider;
    }

    public Optional<StringFilter> optionalProvider() {
        return Optional.ofNullable(provider);
    }

    public StringFilter provider() {
        if (provider == null) {
            setProvider(new StringFilter());
        }
        return provider;
    }

    public void setProvider(StringFilter provider) {
        this.provider = provider;
    }

    public StringFilter getPayloadHash() {
        return payloadHash;
    }

    public Optional<StringFilter> optionalPayloadHash() {
        return Optional.ofNullable(payloadHash);
    }

    public StringFilter payloadHash() {
        if (payloadHash == null) {
            setPayloadHash(new StringFilter());
        }
        return payloadHash;
    }

    public void setPayloadHash(StringFilter payloadHash) {
        this.payloadHash = payloadHash;
    }

    public InstantFilter getReceivedAt() {
        return receivedAt;
    }

    public Optional<InstantFilter> optionalReceivedAt() {
        return Optional.ofNullable(receivedAt);
    }

    public InstantFilter receivedAt() {
        if (receivedAt == null) {
            setReceivedAt(new InstantFilter());
        }
        return receivedAt;
    }

    public void setReceivedAt(InstantFilter receivedAt) {
        this.receivedAt = receivedAt;
    }

    public StringFilter getProcessingStatus() {
        return processingStatus;
    }

    public Optional<StringFilter> optionalProcessingStatus() {
        return Optional.ofNullable(processingStatus);
    }

    public StringFilter processingStatus() {
        if (processingStatus == null) {
            setProcessingStatus(new StringFilter());
        }
        return processingStatus;
    }

    public void setProcessingStatus(StringFilter processingStatus) {
        this.processingStatus = processingStatus;
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
        final PaymentWebhookLogCriteria that = (PaymentWebhookLogCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(provider, that.provider) &&
            Objects.equals(payloadHash, that.payloadHash) &&
            Objects.equals(receivedAt, that.receivedAt) &&
            Objects.equals(processingStatus, that.processingStatus) &&
            Objects.equals(createdAt, that.createdAt) &&
            Objects.equals(updatedAt, that.updatedAt) &&
            Objects.equals(isDeleted, that.isDeleted) &&
            Objects.equals(deletedAt, that.deletedAt) &&
            Objects.equals(deletedBy, that.deletedBy) &&
            Objects.equals(paymentTransactionId, that.paymentTransactionId) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            provider,
            payloadHash,
            receivedAt,
            processingStatus,
            createdAt,
            updatedAt,
            isDeleted,
            deletedAt,
            deletedBy,
            paymentTransactionId,
            distinct
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PaymentWebhookLogCriteria{" +
            optionalId().map(f -> "id=" + f + ", ").orElse("") +
            optionalProvider().map(f -> "provider=" + f + ", ").orElse("") +
            optionalPayloadHash().map(f -> "payloadHash=" + f + ", ").orElse("") +
            optionalReceivedAt().map(f -> "receivedAt=" + f + ", ").orElse("") +
            optionalProcessingStatus().map(f -> "processingStatus=" + f + ", ").orElse("") +
            optionalCreatedAt().map(f -> "createdAt=" + f + ", ").orElse("") +
            optionalUpdatedAt().map(f -> "updatedAt=" + f + ", ").orElse("") +
            optionalIsDeleted().map(f -> "isDeleted=" + f + ", ").orElse("") +
            optionalDeletedAt().map(f -> "deletedAt=" + f + ", ").orElse("") +
            optionalDeletedBy().map(f -> "deletedBy=" + f + ", ").orElse("") +
            optionalPaymentTransactionId().map(f -> "paymentTransactionId=" + f + ", ").orElse("") +
            optionalDistinct().map(f -> "distinct=" + f + ", ").orElse("") +
        "}";
    }
}
