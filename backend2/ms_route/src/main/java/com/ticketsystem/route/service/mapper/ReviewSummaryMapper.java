package com.ticketsystem.route.service.mapper;

import com.ticketsystem.route.domain.ReviewSummary;
import com.ticketsystem.route.service.dto.ReviewSummaryDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ReviewSummary} and its DTO {@link ReviewSummaryDTO}.
 */
@Mapper(componentModel = "spring")
public interface ReviewSummaryMapper extends EntityMapper<ReviewSummaryDTO, ReviewSummary> {}
