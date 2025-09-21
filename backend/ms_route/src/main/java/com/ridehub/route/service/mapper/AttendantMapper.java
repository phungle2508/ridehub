package com.ridehub.route.service.mapper;

import com.ridehub.route.domain.Attendant;
import com.ridehub.route.service.dto.AttendantDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Attendant} and its DTO {@link AttendantDTO}.
 */
@Mapper(componentModel = "spring")
public interface AttendantMapper extends EntityMapper<AttendantDTO, Attendant> {}
