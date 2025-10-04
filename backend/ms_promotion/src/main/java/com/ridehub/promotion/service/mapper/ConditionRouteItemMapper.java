package com.ridehub.promotion.service.mapper;

import com.ridehub.promotion.domain.ConditionRouteItem;
import com.ridehub.promotion.service.dto.ConditionByRouteDTO;
import com.ridehub.promotion.service.dto.ConditionRouteItemDTO;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

/**
 * Mapper for the entity {@link ConditionRouteItem} and its DTO
 * {@link ConditionRouteItemDTO}.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ConditionRouteItemMapper extends EntityMapper<ConditionRouteItemDTO, ConditionRouteItem> {

    // --- id-only DTO for nested 'condition' (break the cycle) ---
    @Named("condition.idOnly")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ConditionByRouteDTO toDtoConditionIdOnly(com.ridehub.promotion.domain.ConditionByRoute entity);

    // --- entity from DTO (id-only) ---
    @Named("condition.fromDtoId")
    default com.ridehub.promotion.domain.ConditionByRoute toEntityConditionFromDtoId(ConditionByRouteDTO dto) {
        if (dto == null)
            return null;
        var e = new com.ridehub.promotion.domain.ConditionByRoute();
        e.setId(dto.getId());
        return e;
    }

    @Override
    @Mapping(target = "condition", source = "condition", qualifiedByName = "condition.idOnly") // 🔒 id-only
    ConditionRouteItemDTO toDto(ConditionRouteItem entity);

    @Override
    @Mapping(target = "condition", source = "condition", qualifiedByName = "condition.fromDtoId") // 🔒 id-only
    ConditionRouteItem toEntity(ConditionRouteItemDTO dto);
}
