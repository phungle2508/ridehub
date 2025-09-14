package com.ticketsystem.route.service.mapper;

import com.ticketsystem.route.domain.Operator;
import com.ticketsystem.route.service.dto.OperatorDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Operator} and its DTO {@link OperatorDTO}.
 */
@Mapper(componentModel = "spring")
public interface OperatorMapper extends EntityMapper<OperatorDTO, Operator> {}
