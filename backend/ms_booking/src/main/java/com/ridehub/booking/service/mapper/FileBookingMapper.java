package com.ridehub.booking.service.mapper;

import com.ridehub.booking.domain.FileBooking;
import com.ridehub.booking.service.dto.FileBookingDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link FileBooking} and its DTO {@link FileBookingDTO}.
 */
@Mapper(componentModel = "spring")
public interface FileBookingMapper extends EntityMapper<FileBookingDTO, FileBooking> {}
