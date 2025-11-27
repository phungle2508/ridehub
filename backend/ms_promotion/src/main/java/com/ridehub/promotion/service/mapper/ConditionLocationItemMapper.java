package com.ridehub.promotion.service.mapper;

import com.ridehub.promotion.domain.ConditionByLocation;
import com.ridehub.promotion.domain.ConditionLocationItem;
import com.ridehub.promotion.service.dto.ConditionByLocationDTO;
import com.ridehub.promotion.service.dto.ConditionLocationItemDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ConditionLocationItemMapper extends EntityMapper<ConditionLocationItemDTO, ConditionLocationItem> {

    // condition -> DTO (id only)
    @Named("condLoc.idOnly")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ConditionByLocationDTO toDtoCondLocIdOnly(ConditionByLocation entity);

    // DTO -> condition entity (id only)
    @Named("condLoc.fromId")
    default ConditionByLocation toEntityCondLocFromId(ConditionByLocationDTO dto) {
        if (dto == null)
            return null;
        ConditionByLocation e = new ConditionByLocation();
        e.setId(dto.getId());
        return e;
    }

    @Override
    @Mapping(target = "condition", source = "condition", qualifiedByName = "condLoc.idOnly")
    ConditionLocationItemDTO toDto(ConditionLocationItem entity);

    @Override
    @Mapping(target = "condition", source = "condition", qualifiedByName = "condLoc.fromId")
    ConditionLocationItem toEntity(ConditionLocationItemDTO dto);
}
