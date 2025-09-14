package com.ticketsystem.route.service.mapper;

import com.ticketsystem.route.domain.Vehicle;
import com.ticketsystem.route.domain.VehicleImage;
import com.ticketsystem.route.service.dto.VehicleDTO;
import com.ticketsystem.route.service.dto.VehicleImageDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link VehicleImage} and its DTO {@link VehicleImageDTO}.
 */
@Mapper(componentModel = "spring")
public interface VehicleImageMapper extends EntityMapper<VehicleImageDTO, VehicleImage> {
    @Mapping(target = "vehicle", source = "vehicle", qualifiedByName = "vehicleId")
    VehicleImageDTO toDto(VehicleImage s);

    @Named("vehicleId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    VehicleDTO toDtoVehicleId(Vehicle vehicle);
}
