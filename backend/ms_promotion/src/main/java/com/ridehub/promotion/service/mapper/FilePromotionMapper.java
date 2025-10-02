package com.ridehub.promotion.service.mapper;

import com.ridehub.promotion.domain.FilePromotion;
import com.ridehub.promotion.domain.Promotion;
import com.ridehub.promotion.service.dto.FilePromotionDTO;
import com.ridehub.promotion.service.dto.PromotionDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link FilePromotion} and its DTO {@link FilePromotionDTO}.
 */
@Mapper(componentModel = "spring")
public interface FilePromotionMapper extends EntityMapper<FilePromotionDTO, FilePromotion> {
    @Mapping(target = "promotion", source = "promotion", qualifiedByName = "promotionId")
    FilePromotionDTO toDto(FilePromotion s);

    @Named("promotionId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    PromotionDTO toDtoPromotionId(Promotion promotion);
}
