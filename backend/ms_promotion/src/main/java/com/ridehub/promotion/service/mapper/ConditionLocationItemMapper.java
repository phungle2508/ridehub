package com.ridehub.promotion.service.mapper;

import com.ridehub.promotion.domain.ConditionByLocation;
import com.ridehub.promotion.domain.ConditionLocationItem;
import com.ridehub.promotion.service.dto.ConditionByLocationDTO;
import com.ridehub.promotion.service.dto.ConditionLocationItemDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ConditionLocationItem} and its DTO {@link ConditionLocationItemDTO}.
 */
@Mapper(componentModel = "spring")
public interface ConditionLocationItemMapper extends EntityMapper<ConditionLocationItemDTO, ConditionLocationItem> {
    @Mapping(target = "condition", source = "condition", qualifiedByName = "conditionByLocationId")
    ConditionLocationItemDTO toDto(ConditionLocationItem s);

    @Named("conditionByLocationId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ConditionByLocationDTO toDtoConditionByLocationId(ConditionByLocation conditionByLocation);
}
