package com.ticketsystem.route.service.mapper;

import com.ticketsystem.route.domain.Station;
import com.ticketsystem.route.service.dto.StationDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Station} and its DTO {@link StationDTO}.
 */
@Mapper(componentModel = "spring")
public interface StationMapper extends EntityMapper<StationDTO, Station> {}
