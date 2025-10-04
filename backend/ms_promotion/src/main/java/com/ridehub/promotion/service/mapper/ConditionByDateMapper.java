package com.ridehub.promotion.service.mapper;

import com.ridehub.promotion.domain.ConditionByDate;
import com.ridehub.promotion.domain.ConditionDateItem;
import com.ridehub.promotion.domain.Promotion;
import com.ridehub.promotion.service.dto.ConditionByDateDTO;
import com.ridehub.promotion.service.dto.ConditionDateItemDTO;
import com.ridehub.promotion.service.dto.PromotionDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ConditionByDate} and its DTO {@link ConditionByDateDTO}.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ConditionByDateMapper extends EntityMapper<ConditionByDateDTO, ConditionByDate> {
    @Mapping(target = "promotion", source = "promotion", qualifiedByName = "promotionId")
    @Mapping(target = "items", source = "items", qualifiedByName = "conditionDateItemsWithoutCondition")
    ConditionByDateDTO toDto(ConditionByDate s);

    @Named("promotionId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    PromotionDTO toDtoPromotionId(Promotion promotion);

    @Named("conditionDateItemsWithoutCondition")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "specificDate", source = "specificDate")
    @Mapping(target = "weekday", source = "weekday")
    @Mapping(target = "createdAt", source = "createdAt")
    @Mapping(target = "updatedAt", source = "updatedAt")
    @Mapping(target = "isDeleted", source = "isDeleted")
    @Mapping(target = "deletedAt", source = "deletedAt")
    @Mapping(target = "deletedBy", source = "deletedBy")
    @Mapping(target = "condition", ignore = true)
    ConditionDateItemDTO conditionDateItemToDtoWithoutCondition(ConditionDateItem conditionDateItem);

    @Named("conditionByDateId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ConditionByDateDTO toDtoConditionByDateId(ConditionByDate conditionByDate);
}
