package com.ticketsystem.route.service.mapper;

import com.ticketsystem.route.domain.Route;
import com.ticketsystem.route.domain.Trip;
import com.ticketsystem.route.service.dto.RouteDTO;
import com.ticketsystem.route.service.dto.TripDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Trip} and its DTO {@link TripDTO}.
 */
@Mapper(componentModel = "spring")
public interface TripMapper extends EntityMapper<TripDTO, Trip> {
    @Mapping(target = "route", source = "route", qualifiedByName = "routeId")
    TripDTO toDto(Trip s);

    @Named("routeId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    RouteDTO toDtoRouteId(Route route);
}
