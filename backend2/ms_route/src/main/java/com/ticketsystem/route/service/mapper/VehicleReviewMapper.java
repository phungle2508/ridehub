package com.ticketsystem.route.service.mapper;

import com.ticketsystem.route.domain.Vehicle;
import com.ticketsystem.route.domain.VehicleReview;
import com.ticketsystem.route.service.dto.VehicleDTO;
import com.ticketsystem.route.service.dto.VehicleReviewDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link VehicleReview} and its DTO {@link VehicleReviewDTO}.
 */
@Mapper(componentModel = "spring")
public interface VehicleReviewMapper extends EntityMapper<VehicleReviewDTO, VehicleReview> {
    @Mapping(target = "vehicle", source = "vehicle", qualifiedByName = "vehicleId")
    VehicleReviewDTO toDto(VehicleReview s);

    @Named("vehicleId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    VehicleDTO toDtoVehicleId(Vehicle vehicle);
}
