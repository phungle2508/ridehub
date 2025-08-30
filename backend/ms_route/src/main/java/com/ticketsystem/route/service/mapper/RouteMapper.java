package com.ticketsystem.route.service.mapper;

import com.ticketsystem.route.domain.Route;
import com.ticketsystem.route.service.dto.RouteDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Route} and its DTO {@link RouteDTO}.
 */
@Mapper(componentModel = "spring")
public interface RouteMapper extends EntityMapper<RouteDTO, Route> {}
