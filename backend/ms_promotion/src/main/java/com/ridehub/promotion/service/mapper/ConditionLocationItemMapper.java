package com.ridehub.promotion.service.mapper;

import com.ridehub.promotion.domain.ConditionLocationItem;
import com.ridehub.promotion.service.dto.ConditionLocationItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * Mapper for the entity {@link ConditionLocationItem} and its DTO {@link ConditionLocationItemDTO}.
 */
@Mapper(componentModel = "spring", uses = { ConditionByLocationMapper.class }, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ConditionLocationItemMapper extends EntityMapper<ConditionLocationItemDTO, ConditionLocationItem> {
    @Override
    @Mapping(source = "condition.id", target = "condition.id")
    ConditionLocationItemDTO toDto(ConditionLocationItem entity);

    @Override
    @Mapping(source = "condition.id", target = "condition.id")
    ConditionLocationItem toEntity(ConditionLocationItemDTO dto);
}
