package com.ticketsystem.booking.service.mapper;

import com.ticketsystem.booking.domain.Ticket;
import com.ticketsystem.booking.service.dto.TicketDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Ticket} and its DTO {@link TicketDTO}.
 */
@Mapper(componentModel = "spring")
public interface TicketMapper extends EntityMapper<TicketDTO, Ticket> {}
