package com.ridehub.route.service.mapper;

import com.ridehub.route.domain.SeatMap;
import com.ridehub.route.service.dto.SeatMapDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link SeatMap} and its DTO {@link SeatMapDTO}.
 */
@Mapper(componentModel = "spring")
public interface SeatMapMapper extends EntityMapper<SeatMapDTO, SeatMap> {}
