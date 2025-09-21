package com.ridehub.promotion.service.mapper;

import com.ridehub.promotion.domain.PercentOffTotal;
import com.ridehub.promotion.domain.Promotion;
import com.ridehub.promotion.service.dto.PercentOffTotalDTO;
import com.ridehub.promotion.service.dto.PromotionDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link PercentOffTotal} and its DTO {@link PercentOffTotalDTO}.
 */
@Mapper(componentModel = "spring")
public interface PercentOffTotalMapper extends EntityMapper<PercentOffTotalDTO, PercentOffTotal> {
    @Mapping(target = "promotion", source = "promotion", qualifiedByName = "promotionId")
    PercentOffTotalDTO toDto(PercentOffTotal s);

    @Named("promotionId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    PromotionDTO toDtoPromotionId(Promotion promotion);
}
