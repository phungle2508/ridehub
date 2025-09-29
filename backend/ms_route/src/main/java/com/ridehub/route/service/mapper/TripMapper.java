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
import com.ridehub.route.service.dto.TripDetailDTO;
import com.ridehub.route.service.dto.VehicleDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Trip} and its DTO {@link TripDTO}.
 */
@Mapper(componentModel = "spring")
public interface TripMapper extends EntityMapper<TripDTO, Trip> {
    @Mapping(target = "route", source = "route", qualifiedByName = "routeId")
    @Mapping(target = "vehicle", source = "vehicle", qualifiedByName = "vehicleId")
    @Mapping(target = "driver", source = "driver", qualifiedByName = "driverId")
    @Mapping(target = "attendant", source = "attendant", qualifiedByName = "attendantId")
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

    /**
     * Convert Trip entity to TripDetailDTO for route list display
     */
    @Mapping(target = "tripId", source = "id")
    @Mapping(target = "tripCode", source = "tripCode")
    @Mapping(target = "routeCode", source = "route.routeCode")
    @Mapping(target = "origin", source = "route.origin.name")
    @Mapping(target = "destination", source = "route.destination.name")
    @Mapping(target = "distanceKm", source = "route.distanceKm")
    @Mapping(target = "departureTime", source = "departureTime")
    @Mapping(target = "arrivalTime", source = "arrivalTime")
    @Mapping(target = "vehicleType", source = "vehicle.type")
    @Mapping(target = "vehiclePlateNumber", source = "vehicle.plateNumber")
    @Mapping(target = "vehicleBrand", source = "vehicle.brand")
    @Mapping(target = "driverId", source = "driver.id")
    @Mapping(target = "driverName", source = "driver.staff.name")
    @Mapping(target = "driverLicenseClass", source = "driver.licenseClass")
    @Mapping(target = "driverYearsExperience", source = "driver.yearsExperience")
    @Mapping(target = "attendantId", source = "attendant.id")
    @Mapping(target = "attendantName", source = "attendant.staff.name")
    @Mapping(target = "attendantPhoneNumber", source = "attendant.staff.phoneNumber")
    @Mapping(target = "baseFare", source = "baseFare")
    @Mapping(target = "routeName", ignore = true) // Computed field
    @Mapping(target = "plannedJourney", ignore = true) // Computed field
    @Mapping(target = "status", ignore = true) // Computed field
    TripDetailDTO toTripDetailDto(Trip trip);
}
