package com.ticketsystem.booking.service.mapper;

import com.ticketsystem.booking.domain.Booking;
import com.ticketsystem.booking.domain.BookingHistory;
import com.ticketsystem.booking.service.dto.BookingDTO;
import com.ticketsystem.booking.service.dto.BookingHistoryDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link BookingHistory} and its DTO {@link BookingHistoryDTO}.
 */
@Mapper(componentModel = "spring")
public interface BookingHistoryMapper extends EntityMapper<BookingHistoryDTO, BookingHistory> {
    @Mapping(target = "booking", source = "booking", qualifiedByName = "bookingId")
    BookingHistoryDTO toDto(BookingHistory s);

    @Named("bookingId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    BookingDTO toDtoBookingId(Booking booking);
}
