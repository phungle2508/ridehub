package com.ticketsystem.route.service.mapper;

import com.ticketsystem.route.domain.District;
import com.ticketsystem.route.domain.Ward;
import com.ticketsystem.route.service.dto.DistrictDTO;
import com.ticketsystem.route.service.dto.WardDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Ward} and its DTO {@link WardDTO}.
 */
@Mapper(componentModel = "spring")
public interface WardMapper extends EntityMapper<WardDTO, Ward> {
    @Mapping(target = "district", source = "district", qualifiedByName = "districtId")
    WardDTO toDto(Ward s);

    @Named("districtId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    DistrictDTO toDtoDistrictId(District district);
}
