package com.ticketsystem.ticket.service.mapper;

import com.ticketsystem.ticket.domain.Ticket;
import com.ticketsystem.ticket.service.dto.TicketDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Ticket} and its DTO {@link TicketDTO}.
 */
@Mapper(componentModel = "spring")
public interface TicketMapper extends EntityMapper<TicketDTO, Ticket> {}
