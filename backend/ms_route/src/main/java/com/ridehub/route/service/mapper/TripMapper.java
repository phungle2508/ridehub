package com.ridehub.route.service.mapper;

import com.ridehub.route.domain.Attendant;
import com.ridehub.route.domain.Driver;
import com.ridehub.route.domain.Route;
import com.ridehub.route.domain.Trip;
import com.ridehub.route.service.dto.AttendantDTO;
import com.ridehub.route.service.dto.DriverDTO;
import com.ridehub.route.service.dto.RouteDTO;
import com.ridehub.route.service.dto.TripDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Trip} and its DTO {@link TripDTO}.
 */
@Mapper(componentModel = "spring")
public interface TripMapper extends EntityMapper<TripDTO, Trip> {
    @Mapping(target = "driver", source = "driver", qualifiedByName = "driverId")
    @Mapping(target = "attendant", source = "attendant", qualifiedByName = "attendantId")
    @Mapping(target = "route", source = "route", qualifiedByName = "routeId")
    TripDTO toDto(Trip s);

    @Named("driverId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    DriverDTO toDtoDriverId(Driver driver);

    @Named("attendantId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    AttendantDTO toDtoAttendantId(Attendant attendant);

    @Named("routeId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    RouteDTO toDtoRouteId(Route route);
}
