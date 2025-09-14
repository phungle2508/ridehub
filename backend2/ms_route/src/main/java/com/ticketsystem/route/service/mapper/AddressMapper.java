package com.ticketsystem.route.service.mapper;

import com.ticketsystem.route.domain.Address;
import com.ticketsystem.route.domain.Ward;
import com.ticketsystem.route.service.dto.AddressDTO;
import com.ticketsystem.route.service.dto.WardDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Address} and its DTO {@link AddressDTO}.
 */
@Mapper(componentModel = "spring")
public interface AddressMapper extends EntityMapper<AddressDTO, Address> {
    @Mapping(target = "ward", source = "ward", qualifiedByName = "wardId")
    AddressDTO toDto(Address s);

    @Named("wardId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    WardDTO toDtoWardId(Ward ward);
}
