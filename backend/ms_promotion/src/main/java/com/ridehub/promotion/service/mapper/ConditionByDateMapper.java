package com.ridehub.promotion.service.mapper;

import com.ridehub.promotion.domain.ConditionByDate;
import com.ridehub.promotion.domain.ConditionDateItem;
import com.ridehub.promotion.domain.Promotion;
import com.ridehub.promotion.service.dto.ConditionByDateDTO;
import com.ridehub.promotion.service.dto.ConditionDateItemDTO;
import com.ridehub.promotion.service.dto.PromotionDTO;
import org.mapstruct.*;

import java.util.Set;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ConditionByDateMapper extends EntityMapper<ConditionByDateDTO, ConditionByDate> {

    @Mapping(target = "promotion", source = "promotion", qualifiedByName = "promotionId")
    @Mapping(target = "items", source = "items", qualifiedByName = "dateItems.shallowSet")
    ConditionByDateDTO toDto(ConditionByDate s);

    @Named("promotionId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    PromotionDTO toDtoPromotionId(Promotion promotion);

    // single item shallow
    @Named("dateItems.shallow")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "specificDate", source = "specificDate")
    @Mapping(target = "weekday", source = "weekday")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    @Mapping(target = "isDeleted", source = "isDeleted")
    @Mapping(target = "deletedAt", source = "deletedAt")
    @Mapping(target = "deletedBy", source = "deletedBy")
    @Mapping(target = "condition", ignore = true) // break back-ref here
    ConditionDateItemDTO toDtoDateItemShallow(ConditionDateItem item);

    // collection shallow
    @Named("dateItems.shallowSet")
    @IterableMapping(qualifiedByName = "dateItems.shallow")
    Set<ConditionDateItemDTO> toDtoDateItemShallowSet(Set<ConditionDateItem> items);

    @Named("conditionByDateId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ConditionByDateDTO toDtoConditionByDateId(ConditionByDate conditionByDate);
}
