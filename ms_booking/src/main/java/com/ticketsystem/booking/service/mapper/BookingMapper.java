package com.ticketsystem.booking.service.mapper;

import com.ticketsystem.booking.domain.Booking;
import com.ticketsystem.booking.service.dto.BookingDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Booking} and its DTO {@link BookingDTO}.
 */
@Mapper(componentModel = "spring")
public interface BookingMapper extends EntityMapper<BookingDTO, Booking> {}
