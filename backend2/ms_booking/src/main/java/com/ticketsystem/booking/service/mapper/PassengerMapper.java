package com.ticketsystem.booking.service.mapper;

import com.ticketsystem.booking.domain.Booking;
import com.ticketsystem.booking.domain.Passenger;
import com.ticketsystem.booking.service.dto.BookingDTO;
import com.ticketsystem.booking.service.dto.PassengerDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Passenger} and its DTO {@link PassengerDTO}.
 */
@Mapper(componentModel = "spring")
public interface PassengerMapper extends EntityMapper<PassengerDTO, Passenger> {
    @Mapping(target = "booking", source = "booking", qualifiedByName = "bookingId")
    PassengerDTO toDto(Passenger s);

    @Named("bookingId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    BookingDTO toDtoBookingId(Booking booking);
}
