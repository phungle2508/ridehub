package com.ridehub.promotion.service.mapper;

import com.ridehub.promotion.domain.ConditionByDate;
import com.ridehub.promotion.domain.Promotion;
import com.ridehub.promotion.service.dto.ConditionByDateDTO;
import com.ridehub.promotion.service.dto.PromotionDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ConditionByDate} and its DTO {@link ConditionByDateDTO}.
 */
@Mapper(componentModel = "spring")
public interface ConditionByDateMapper extends EntityMapper<ConditionByDateDTO, ConditionByDate> {
    @Mapping(target = "promotion", source = "promotion", qualifiedByName = "promotionId")
    ConditionByDateDTO toDto(ConditionByDate s);

    @Named("promotionId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    PromotionDTO toDtoPromotionId(Promotion promotion);
}
