package com.ridehub.promotion.service.mapper;

import com.ridehub.promotion.domain.BuyNGetMFree;
import com.ridehub.promotion.domain.Promotion;
import com.ridehub.promotion.service.dto.BuyNGetMFreeDTO;
import com.ridehub.promotion.service.dto.PromotionDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link BuyNGetMFree} and its DTO {@link BuyNGetMFreeDTO}.
 */
@Mapper(componentModel = "spring")
public interface BuyNGetMFreeMapper extends EntityMapper<BuyNGetMFreeDTO, BuyNGetMFree> {
    @Mapping(target = "promotion", source = "promotion", qualifiedByName = "promotionId")
    BuyNGetMFreeDTO toDto(BuyNGetMFree s);

    @Named("promotionId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    PromotionDTO toDtoPromotionId(Promotion promotion);
}
