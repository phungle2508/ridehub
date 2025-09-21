package com.ridehub.route.service.mapper;

import com.ridehub.route.domain.Trip;
import com.ridehub.route.domain.TripSeat;
import com.ridehub.route.service.dto.TripDTO;
import com.ridehub.route.service.dto.TripSeatDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link TripSeat} and its DTO {@link TripSeatDTO}.
 */
@Mapper(componentModel = "spring")
public interface TripSeatMapper extends EntityMapper<TripSeatDTO, TripSeat> {
    @Mapping(target = "trip", source = "trip", qualifiedByName = "tripId")
    TripSeatDTO toDto(TripSeat s);

    @Named("tripId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    TripDTO toDtoTripId(Trip trip);
}
