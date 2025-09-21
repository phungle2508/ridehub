package com.ridehub.promotion.service.mapper;

import com.ridehub.promotion.domain.ConditionByDate;
import com.ridehub.promotion.domain.ConditionDateItem;
import com.ridehub.promotion.service.dto.ConditionByDateDTO;
import com.ridehub.promotion.service.dto.ConditionDateItemDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ConditionDateItem} and its DTO {@link ConditionDateItemDTO}.
 */
@Mapper(componentModel = "spring")
public interface ConditionDateItemMapper extends EntityMapper<ConditionDateItemDTO, ConditionDateItem> {
    @Mapping(target = "condition", source = "condition", qualifiedByName = "conditionByDateId")
    ConditionDateItemDTO toDto(ConditionDateItem s);

    @Named("conditionByDateId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ConditionByDateDTO toDtoConditionByDateId(ConditionByDate conditionByDate);
}
