package com.ridehub.promotion.service.mapper;

import com.ridehub.promotion.domain.ConditionByDate;
import com.ridehub.promotion.domain.ConditionDateItem;
import com.ridehub.promotion.service.dto.ConditionByDateDTO;
import com.ridehub.promotion.service.dto.ConditionDateItemDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ConditionDateItemMapper extends EntityMapper<ConditionDateItemDTO, ConditionDateItem> {

    @Named("condDate.idOnly")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ConditionByDateDTO toDtoCondDateIdOnly(ConditionByDate entity);

    @Named("condDate.fromId")
    default ConditionByDate toEntityCondDateFromId(ConditionByDateDTO dto) {
        if (dto == null)
            return null;
        ConditionByDate e = new ConditionByDate();
        e.setId(dto.getId());
        return e;
    }

    @Override
    @Mapping(target = "condition", source = "condition", qualifiedByName = "condDate.idOnly")
    ConditionDateItemDTO toDto(ConditionDateItem s);

    @Override
    @Mapping(target = "condition", source = "condition", qualifiedByName = "condDate.fromId")
    ConditionDateItem toEntity(ConditionDateItemDTO dto);
}
