package com.ridehub.promotion.service.mapper;

import com.ridehub.promotion.domain.ConditionRouteItem;
import com.ridehub.promotion.service.dto.ConditionRouteItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * Mapper for the entity {@link ConditionRouteItem} and its DTO {@link ConditionRouteItemDTO}.
 */
@Mapper(componentModel = "spring", uses = { ConditionByRouteMapper.class }, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ConditionRouteItemMapper extends EntityMapper<ConditionRouteItemDTO, ConditionRouteItem> {
    @Override
    @Mapping(source = "condition.id", target = "condition.id")
    ConditionRouteItemDTO toDto(ConditionRouteItem entity);

    @Override
    @Mapping(source = "condition.id", target = "condition.id")
    ConditionRouteItem toEntity(ConditionRouteItemDTO dto);
}
