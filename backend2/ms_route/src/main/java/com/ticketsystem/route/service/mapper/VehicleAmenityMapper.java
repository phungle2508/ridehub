package com.ticketsystem.route.service.mapper;

import com.ticketsystem.route.domain.Vehicle;
import com.ticketsystem.route.domain.VehicleAmenity;
import com.ticketsystem.route.service.dto.VehicleAmenityDTO;
import com.ticketsystem.route.service.dto.VehicleDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link VehicleAmenity} and its DTO {@link VehicleAmenityDTO}.
 */
@Mapper(componentModel = "spring")
public interface VehicleAmenityMapper extends EntityMapper<VehicleAmenityDTO, VehicleAmenity> {
    @Mapping(target = "vehicle", source = "vehicle", qualifiedByName = "vehicleId")
    VehicleAmenityDTO toDto(VehicleAmenity s);

    @Named("vehicleId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    VehicleDTO toDtoVehicleId(Vehicle vehicle);
}
