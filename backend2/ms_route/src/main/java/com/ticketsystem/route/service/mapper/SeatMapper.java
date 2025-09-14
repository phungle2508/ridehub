package com.ticketsystem.route.service.mapper;

import com.ticketsystem.route.domain.Seat;
import com.ticketsystem.route.domain.Trip;
import com.ticketsystem.route.service.dto.SeatDTO;
import com.ticketsystem.route.service.dto.TripDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Seat} and its DTO {@link SeatDTO}.
 */
@Mapper(componentModel = "spring")
public interface SeatMapper extends EntityMapper<SeatDTO, Seat> {
    @Mapping(target = "trip", source = "trip", qualifiedByName = "tripId")
    SeatDTO toDto(Seat s);

    @Named("tripId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    TripDTO toDtoTripId(Trip trip);
}
