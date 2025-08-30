package com.ticketsystem.route.service.mapper;

import com.ticketsystem.route.domain.Route;
import com.ticketsystem.route.domain.Schedule;
import com.ticketsystem.route.service.dto.RouteDTO;
import com.ticketsystem.route.service.dto.ScheduleDTO;
import java.util.Objects;
import java.util.UUID;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Schedule} and its DTO {@link ScheduleDTO}.
 */
@Mapper(componentModel = "spring")
public interface ScheduleMapper extends EntityMapper<ScheduleDTO, Schedule> {
    @Mapping(target = "route", source = "route", qualifiedByName = "routeId")
    ScheduleDTO toDto(Schedule s);

    @Named("routeId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    RouteDTO toDtoRouteId(Route route);

    default String map(UUID value) {
        return Objects.toString(value, null);
    }
}
