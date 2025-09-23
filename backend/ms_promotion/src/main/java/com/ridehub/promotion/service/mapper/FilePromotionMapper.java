package com.ridehub.promotion.service.mapper;

import com.ridehub.promotion.domain.FilePromotion;
import com.ridehub.promotion.service.dto.FilePromotionDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link FilePromotion} and its DTO {@link FilePromotionDTO}.
 */
@Mapper(componentModel = "spring")
public interface FilePromotionMapper extends EntityMapper<FilePromotionDTO, FilePromotion> {}
