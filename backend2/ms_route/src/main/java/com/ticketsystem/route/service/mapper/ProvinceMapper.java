package com.ticketsystem.route.service.mapper;

import com.ticketsystem.route.domain.Province;
import com.ticketsystem.route.service.dto.ProvinceDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Province} and its DTO {@link ProvinceDTO}.
 */
@Mapper(componentModel = "spring")
public interface ProvinceMapper extends EntityMapper<ProvinceDTO, Province> {}
