package com.ridehub.promotion.service.mapper;

import com.ridehub.promotion.domain.ConditionByRoute;
import com.ridehub.promotion.domain.ConditionRouteItem;
import com.ridehub.promotion.service.dto.ConditionByRouteDTO;
import com.ridehub.promotion.service.dto.ConditionRouteItemDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ConditionRouteItem} and its DTO {@link ConditionRouteItemDTO}.
 */
@Mapper(componentModel = "spring")
public interface ConditionRouteItemMapper extends EntityMapper<ConditionRouteItemDTO, ConditionRouteItem> {
    @Mapping(target = "condition", source = "condition", qualifiedByName = "conditionByRouteId")
    ConditionRouteItemDTO toDto(ConditionRouteItem s);

    @Named("conditionByRouteId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ConditionByRouteDTO toDtoConditionByRouteId(ConditionByRoute conditionByRoute);
}
