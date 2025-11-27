package com.ridehub.booking.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/**
 * A AppliedPromotion.
 */
@Entity
@Table(name = "applied_promotion")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class AppliedPromotion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "promotion_id", nullable = false)
    private Long promotionId;

    @Column(name = "promotion_code")
    private String promotionCode;

    @Column(name = "policy_type")
    private String policyType;

    @Column(name = "percent")
    private Integer percent;

    @Column(name = "max_off", precision = 21, scale = 2)
    private BigDecimal maxOff;

    @NotNull
    @Column(name = "discount_amount", precision = 21, scale = 2, nullable = false)
    private BigDecimal discountAmount;

    @NotNull
    @Column(name = "applied_at", nullable = false)
    private Instant appliedAt;

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

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = { "invoice", "paymentTransaction", "tickets", "appliedPromos", "pricingSnapshots" }, allowSetters = true)
    private Booking booking;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public AppliedPromotion id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPromotionId() {
        return this.promotionId;
    }

    public AppliedPromotion promotionId(Long promotionId) {
        this.setPromotionId(promotionId);
        return this;
    }

    public void setPromotionId(Long promotionId) {
        this.promotionId = promotionId;
    }

    public String getPromotionCode() {
        return this.promotionCode;
    }

    public AppliedPromotion promotionCode(String promotionCode) {
        this.setPromotionCode(promotionCode);
        return this;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public String getPolicyType() {
        return this.policyType;
    }

    public AppliedPromotion policyType(String policyType) {
        this.setPolicyType(policyType);
        return this;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public Integer getPercent() {
        return this.percent;
    }

    public AppliedPromotion percent(Integer percent) {
        this.setPercent(percent);
        return this;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    public BigDecimal getMaxOff() {
        return this.maxOff;
    }

    public AppliedPromotion maxOff(BigDecimal maxOff) {
        this.setMaxOff(maxOff);
        return this;
    }

    public void setMaxOff(BigDecimal maxOff) {
        this.maxOff = maxOff;
    }

    public BigDecimal getDiscountAmount() {
        return this.discountAmount;
    }

    public AppliedPromotion discountAmount(BigDecimal discountAmount) {
        this.setDiscountAmount(discountAmount);
        return this;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Instant getAppliedAt() {
        return this.appliedAt;
    }

    public AppliedPromotion appliedAt(Instant appliedAt) {
        this.setAppliedAt(appliedAt);
        return this;
    }

    public void setAppliedAt(Instant appliedAt) {
        this.appliedAt = appliedAt;
    }

    public Instant getCreatedAt() {
        return this.createdAt;
    }

    public AppliedPromotion createdAt(Instant createdAt) {
        this.setCreatedAt(createdAt);
        return this;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return this.updatedAt;
    }

    public AppliedPromotion updatedAt(Instant updatedAt) {
        this.setUpdatedAt(updatedAt);
        return this;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getIsDeleted() {
        return this.isDeleted;
    }

    public AppliedPromotion isDeleted(Boolean isDeleted) {
        this.setIsDeleted(isDeleted);
        return this;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Instant getDeletedAt() {
        return this.deletedAt;
    }

    public AppliedPromotion deletedAt(Instant deletedAt) {
        this.setDeletedAt(deletedAt);
        return this;
    }

    public void setDeletedAt(Instant deletedAt) {
        this.deletedAt = deletedAt;
    }

    public UUID getDeletedBy() {
        return this.deletedBy;
    }

    public AppliedPromotion deletedBy(UUID deletedBy) {
        this.setDeletedBy(deletedBy);
        return this;
    }

    public void setDeletedBy(UUID deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Booking getBooking() {
        return this.booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public AppliedPromotion booking(Booking booking) {
        this.setBooking(booking);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AppliedPromotion)) {
            return false;
        }
        return getId() != null && getId().equals(((AppliedPromotion) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AppliedPromotion{" +
            "id=" + getId() +
            ", promotionId=" + getPromotionId() +
            ", promotionCode='" + getPromotionCode() + "'" +
            ", policyType='" + getPolicyType() + "'" +
            ", percent=" + getPercent() +
            ", maxOff=" + getMaxOff() +
            ", discountAmount=" + getDiscountAmount() +
            ", appliedAt='" + getAppliedAt() + "'" +
            ", createdAt='" + getCreatedAt() + "'" +
            ", updatedAt='" + getUpdatedAt() + "'" +
            ", isDeleted='" + getIsDeleted() + "'" +
            ", deletedAt='" + getDeletedAt() + "'" +
            ", deletedBy='" + getDeletedBy() + "'" +
            "}";
    }
}
