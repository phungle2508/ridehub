package com.ridehub.route.service.mapper;

import com.ridehub.route.domain.Attendant;
import com.ridehub.route.domain.Driver;
import com.ridehub.route.domain.Route;
import com.ridehub.route.domain.Trip;
import com.ridehub.route.domain.Vehicle;
import com.ridehub.route.service.dto.AttendantDTO;
import com.ridehub.route.service.dto.DriverDTO;
import com.ridehub.route.service.dto.RouteDTO;
import com.ridehub.route.service.dto.TripDTO;
import com.ridehub.route.service.dto.VehicleDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Trip} and its DTO {@link TripDTO}.
 */
@Mapper(componentModel = "spring")
public interface TripMapper extends EntityMapper<TripDTO, Trip> {
    @Mapping(target = "route", source = "route")
    @Mapping(target = "vehicle", source = "vehicle")
    @Mapping(target = "driver", source = "driver")
    @Mapping(target = "attendant", source = "attendant")
    TripDTO toDto(Trip s);

    @Named("routeId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    RouteDTO toDtoRouteId(Route route);

    @Named("vehicleId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    VehicleDTO toDtoVehicleId(Vehicle vehicle);

    @Named("driverId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    DriverDTO toDtoDriverId(Driver driver);

    @Named("attendantId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    AttendantDTO toDtoAttendantId(Attendant attendant);

    // @Override
    // @Mapping(target = "route", source = "route", qualifiedByName = "toRouteById")
    // @Mapping(target = "vehicle", source = "vehicle", qualifiedByName = "toVehicleById")
    // @Mapping(target = "driver", source = "driver", qualifiedByName = "toDriverById")
    // @Mapping(target = "attendant", source = "attendant", qualifiedByName = "toAttendantById")
    // Trip toEntity(TripDTO dto);

    // @Named("toRouteById")
    // default Route toRouteById(RouteDTO dto) {
    //     if (dto == null || dto.getId() == null)
    //         return null;
    //     Route r = new Route();
    //     r.setId(dto.getId());
    //     return r;
    // }

    // @Named("toVehicleById")
    // default Vehicle toVehicleById(VehicleDTO dto) {
    //     if (dto == null || dto.getId() == null)
    //         return null;
    //     Vehicle v = new Vehicle();
    //     v.setId(dto.getId());
    //     return v;
    // }

    // @Named("toDriverById")
    // default Driver toDriverById(DriverDTO dto) {
    //     if (dto == null || dto.getId() == null)
    //         return null;
    //     Driver d = new Driver();
    //     d.setId(dto.getId());
    //     return d;
    // }

    // @Named("toAttendantById")
    // default Attendant toAttendantById(AttendantDTO dto) {
    //     if (dto == null || dto.getId() == null)
    //         return null;
    //     Attendant a = new Attendant();
    //     a.setId(dto.getId());
    //     return a;
    // }
}
