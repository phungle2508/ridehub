package com.ticketsystem.route.service.mapper;

import com.ticketsystem.route.domain.Operator;
import com.ticketsystem.route.domain.ReviewSummary;
import com.ticketsystem.route.domain.Station;
import com.ticketsystem.route.domain.Vehicle;
import com.ticketsystem.route.service.dto.OperatorDTO;
import com.ticketsystem.route.service.dto.ReviewSummaryDTO;
import com.ticketsystem.route.service.dto.StationDTO;
import com.ticketsystem.route.service.dto.VehicleDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Vehicle} and its DTO {@link VehicleDTO}.
 */
@Mapper(componentModel = "spring")
public interface VehicleMapper extends EntityMapper<VehicleDTO, Vehicle> {
    @Mapping(target = "summary", source = "summary", qualifiedByName = "reviewSummaryId")
    @Mapping(target = "homeStation", source = "homeStation", qualifiedByName = "stationId")
    @Mapping(target = "operator", source = "operator", qualifiedByName = "operatorId")
    VehicleDTO toDto(Vehicle s);

    @Named("reviewSummaryId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ReviewSummaryDTO toDtoReviewSummaryId(ReviewSummary reviewSummary);

    @Named("stationId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    StationDTO toDtoStationId(Station station);

    @Named("operatorId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    OperatorDTO toDtoOperatorId(Operator operator);
}
