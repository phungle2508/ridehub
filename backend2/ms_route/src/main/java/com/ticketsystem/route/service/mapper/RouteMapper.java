package com.ticketsystem.route.service.mapper;

import com.ticketsystem.route.domain.Operator;
import com.ticketsystem.route.domain.Route;
import com.ticketsystem.route.domain.Station;
import com.ticketsystem.route.service.dto.OperatorDTO;
import com.ticketsystem.route.service.dto.RouteDTO;
import com.ticketsystem.route.service.dto.StationDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Route} and its DTO {@link RouteDTO}.
 */
@Mapper(componentModel = "spring")
public interface RouteMapper extends EntityMapper<RouteDTO, Route> {
    @Mapping(target = "origin", source = "origin", qualifiedByName = "stationId")
    @Mapping(target = "destination", source = "destination", qualifiedByName = "stationId")
    @Mapping(target = "operator", source = "operator", qualifiedByName = "operatorId")
    RouteDTO toDto(Route s);

    @Named("stationId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    StationDTO toDtoStationId(Station station);

    @Named("operatorId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    OperatorDTO toDtoOperatorId(Operator operator);
}
