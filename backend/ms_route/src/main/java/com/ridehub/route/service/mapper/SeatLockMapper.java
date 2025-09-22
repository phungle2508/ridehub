package com.ridehub.route.service.mapper;

import com.ridehub.route.domain.SeatLock;
import com.ridehub.route.service.dto.SeatLockDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link SeatLock} and its DTO {@link SeatLockDTO}.
 */
@Mapper(componentModel = "spring")
public interface SeatLockMapper extends EntityMapper<SeatLockDTO, SeatLock> {}
