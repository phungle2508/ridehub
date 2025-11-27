package com.ridehub.promotion.service.mapper;

import com.ridehub.promotion.domain.ConditionByRoute;
import com.ridehub.promotion.domain.ConditionRouteItem;
import com.ridehub.promotion.domain.Promotion;
import com.ridehub.promotion.service.dto.ConditionByRouteDTO;
import com.ridehub.promotion.service.dto.ConditionRouteItemDTO;
import com.ridehub.promotion.service.dto.PromotionDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ConditionByRoute} and its DTO
 * {@link ConditionByRouteDTO}.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ConditionByRouteMapper extends EntityMapper<ConditionByRouteDTO, ConditionByRoute> {

    @Mapping(target = "promotion", source = "promotion", qualifiedByName = "promotionId")
    // ✅ Use a collection-level qualifier so every item is shallow (no 'condition'
    // mapped)
    @Mapping(target = "items", source = "items", qualifiedByName = "routeItems.shallowSet")
    ConditionByRouteDTO toDto(ConditionByRoute s);

    @Named("promotionId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    PromotionDTO toDtoPromotionId(Promotion promotion);

    // --- single item (shallow) ---
    @Named("routeItems.shallow")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "routeId", source = "routeId")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    @Mapping(target = "isDeleted", source = "isDeleted")
    @Mapping(target = "deletedAt", source = "deletedAt")
    @Mapping(target = "deletedBy", source = "deletedBy")
    @Mapping(target = "condition", ignore = true) // 🔒 break back-ref here
    ConditionRouteItemDTO toDtoRouteItemShallow(ConditionRouteItem conditionRouteItem);

    // --- collection of items (shallow) ---
    @Named("routeItems.shallowSet")
    @IterableMapping(qualifiedByName = "routeItems.shallow")
    java.util.Set<ConditionRouteItemDTO> toDtoRouteItemShallowSet(java.util.Set<ConditionRouteItem> items);

    // (optional helper if you need id-only mapping elsewhere)
    @Named("conditionByRouteId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ConditionByRouteDTO toDtoConditionByRouteId(ConditionByRoute conditionByRoute);
}
