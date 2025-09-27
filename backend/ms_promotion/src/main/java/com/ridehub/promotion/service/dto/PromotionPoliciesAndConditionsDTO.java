package com.ridehub.promotion.service.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for aggregating all policies and conditions for a specific promotion.
 */
public class PromotionPoliciesAndConditionsDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long promotionId;

    // Policy DTOs
    private List<BuyNGetMFreeDTO> buyNGetMFreePolicies;
    private List<PercentOffTotalDTO> percentOffTotalPolicies;

    // Condition DTOs
    private List<ConditionByDateDTO> dateConditions;
    private List<ConditionByRouteDTO> routeConditions;
    private List<ConditionByLocationDTO> locationConditions;

    public PromotionPoliciesAndConditionsDTO() {
        // Empty constructor for JSON deserialization
    }

    public Long getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Long promotionId) {
        this.promotionId = promotionId;
    }

    public List<BuyNGetMFreeDTO> getBuyNGetMFreePolicies() {
        return buyNGetMFreePolicies;
    }

    public void setBuyNGetMFreePolicies(List<BuyNGetMFreeDTO> buyNGetMFreePolicies) {
        this.buyNGetMFreePolicies = buyNGetMFreePolicies;
    }

    public List<PercentOffTotalDTO> getPercentOffTotalPolicies() {
        return percentOffTotalPolicies;
    }

    public void setPercentOffTotalPolicies(List<PercentOffTotalDTO> percentOffTotalPolicies) {
        this.percentOffTotalPolicies = percentOffTotalPolicies;
    }

    public List<ConditionByDateDTO> getDateConditions() {
        return dateConditions;
    }

    public void setDateConditions(List<ConditionByDateDTO> dateConditions) {
        this.dateConditions = dateConditions;
    }

    public List<ConditionByRouteDTO> getRouteConditions() {
        return routeConditions;
    }

    public void setRouteConditions(List<ConditionByRouteDTO> routeConditions) {
        this.routeConditions = routeConditions;
    }

    public List<ConditionByLocationDTO> getLocationConditions() {
        return locationConditions;
    }

    public void setLocationConditions(List<ConditionByLocationDTO> locationConditions) {
        this.locationConditions = locationConditions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PromotionPoliciesAndConditionsDTO)) {
            return false;
        }

        PromotionPoliciesAndConditionsDTO that = (PromotionPoliciesAndConditionsDTO) o;
        return Objects.equals(promotionId, that.promotionId) &&
               Objects.equals(buyNGetMFreePolicies, that.buyNGetMFreePolicies) &&
               Objects.equals(percentOffTotalPolicies, that.percentOffTotalPolicies) &&
               Objects.equals(dateConditions, that.dateConditions) &&
               Objects.equals(routeConditions, that.routeConditions) &&
               Objects.equals(locationConditions, that.locationConditions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            promotionId,
            buyNGetMFreePolicies,
            percentOffTotalPolicies,
            dateConditions,
            routeConditions,
            locationConditions
        );
    }

    @Override
    public String toString() {
        return "PromotionPoliciesAndConditionsDTO{" +
            "promotionId=" + promotionId +
            ", buyNGetMFreePolicies=" + (buyNGetMFreePolicies != null ? buyNGetMFreePolicies.size() : 0) + " items" +
            ", percentOffTotalPolicies=" + (percentOffTotalPolicies != null ? percentOffTotalPolicies.size() : 0) + " items" +
            ", dateConditions=" + (dateConditions != null ? dateConditions.size() : 0) + " items" +
            ", routeConditions=" + (routeConditions != null ? routeConditions.size() : 0) + " items" +
            ", locationConditions=" + (locationConditions != null ? locationConditions.size() : 0) + " items" +
            '}';
    }
}
