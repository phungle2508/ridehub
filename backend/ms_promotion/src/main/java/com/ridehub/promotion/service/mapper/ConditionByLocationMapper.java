package com.ridehub.promotion.service.mapper;

import com.ridehub.promotion.domain.ConditionByLocation;
import com.ridehub.promotion.domain.ConditionLocationItem;
import com.ridehub.promotion.domain.Promotion;
import com.ridehub.promotion.service.dto.ConditionByLocationDTO;
import com.ridehub.promotion.service.dto.ConditionLocationItemDTO;
import com.ridehub.promotion.service.dto.PromotionDTO;
import org.mapstruct.*;

import java.util.Set;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ConditionByLocationMapper extends EntityMapper<ConditionByLocationDTO, ConditionByLocation> {

    @Mapping(target = "promotion", source = "promotion", qualifiedByName = "promotionId")
    // map items shallow (no back-ref)
    @Mapping(target = "items", source = "items", qualifiedByName = "locItems.shallowSet")
    ConditionByLocationDTO toDto(ConditionByLocation s);

    @Named("promotionId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    PromotionDTO toDtoPromotionId(Promotion promotion);

    // single item shallow
    @Named("locItems.shallow")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "provinceId", source = "provinceId")
    @Mapping(target = "districtId", source = "districtId")
    @Mapping(target = "wardId", source = "wardId")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    @Mapping(target = "isDeleted", source = "isDeleted")
    @Mapping(target = "deletedAt", source = "deletedAt")
    @Mapping(target = "deletedBy", source = "deletedBy")
    @Mapping(target = "condition", ignore = true) // break back-ref here
    ConditionLocationItemDTO toDtoLocationItemShallow(ConditionLocationItem item);

    // collection shallow
    @Named("locItems.shallowSet")
    @IterableMapping(qualifiedByName = "locItems.shallow")
    Set<ConditionLocationItemDTO> toDtoLocationItemShallowSet(Set<ConditionLocationItem> items);

    // id-only helper (if you need it elsewhere)
    @Named("conditionByLocationId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ConditionByLocationDTO toDtoConditionByLocationId(ConditionByLocation conditionByLocation);
}
