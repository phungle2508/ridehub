package com.ridehub.promotion.service.mapper;

import com.ridehub.promotion.domain.FilePromotion;
import com.ridehub.promotion.domain.Promotion;
import com.ridehub.promotion.service.dto.FilePromotionDTO;
import com.ridehub.promotion.service.dto.PromotionDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Promotion} and its DTO {@link PromotionDTO}.
 */
@Mapper(componentModel = "spring")
public interface PromotionMapper extends EntityMapper<PromotionDTO, Promotion> {
    @Mapping(target = "bannerImg", source = "bannerImg", qualifiedByName = "filePromotionId")
    PromotionDTO toDto(Promotion s);

    @Named("filePromotionId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    FilePromotionDTO toDtoFilePromotionId(FilePromotion filePromotion);
}
