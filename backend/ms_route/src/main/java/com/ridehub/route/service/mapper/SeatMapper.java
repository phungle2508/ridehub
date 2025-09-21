package com.ridehub.route.service.mapper;

import com.ridehub.route.domain.Floor;
import com.ridehub.route.domain.Seat;
import com.ridehub.route.service.dto.FloorDTO;
import com.ridehub.route.service.dto.SeatDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Seat} and its DTO {@link SeatDTO}.
 */
@Mapper(componentModel = "spring")
public interface SeatMapper extends EntityMapper<SeatDTO, Seat> {
    @Mapping(target = "floor", source = "floor", qualifiedByName = "floorId")
    SeatDTO toDto(Seat s);

    @Named("floorId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    FloorDTO toDtoFloorId(Floor floor);
}
