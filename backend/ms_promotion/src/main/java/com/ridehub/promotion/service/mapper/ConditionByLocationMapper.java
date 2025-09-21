package com.ridehub.promotion.service.mapper;

import com.ridehub.promotion.domain.ConditionByLocation;
import com.ridehub.promotion.domain.Promotion;
import com.ridehub.promotion.service.dto.ConditionByLocationDTO;
import com.ridehub.promotion.service.dto.PromotionDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ConditionByLocation} and its DTO {@link ConditionByLocationDTO}.
 */
@Mapper(componentModel = "spring")
public interface ConditionByLocationMapper extends EntityMapper<ConditionByLocationDTO, ConditionByLocation> {
    @Mapping(target = "promotion", source = "promotion", qualifiedByName = "promotionId")
    ConditionByLocationDTO toDto(ConditionByLocation s);

    @Named("promotionId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    PromotionDTO toDtoPromotionId(Promotion promotion);
}
