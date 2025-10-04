package com.ridehub.promotion.service.mapper;

import com.ridehub.promotion.domain.ConditionDateItem;
import com.ridehub.promotion.service.dto.ConditionDateItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ConditionByDateMapper.class})
public interface ConditionDateItemMapper extends EntityMapper<ConditionDateItemDTO, ConditionDateItem> {

    @Override
    @Mapping(source = "condition.id", target = "condition.id")
    ConditionDateItemDTO toDto(ConditionDateItem entity);

    @Override
    @Mapping(source = "condition.id", target = "condition.id")
    ConditionDateItem toEntity(ConditionDateItemDTO dto);

}

