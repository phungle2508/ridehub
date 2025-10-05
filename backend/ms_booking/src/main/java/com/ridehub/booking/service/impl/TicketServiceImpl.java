package com.ridehub.booking.service.impl;

import com.ridehub.booking.domain.Ticket;
import com.ridehub.booking.repository.TicketRepository;
import com.ridehub.booking.service.TicketService;
import com.ridehub.booking.service.dto.TicketDTO;
import com.ridehub.booking.service.mapper.TicketMapper;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.ridehub.booking.domain.Ticket}.
 */
@Service
@Transactional
public class TicketServiceImpl implements TicketService {

    private static final Logger LOG = LoggerFactory.getLogger(TicketServiceImpl.class);

    private final TicketRepository ticketRepository;

    private final TicketMapper ticketMapper;

    public TicketServiceImpl(TicketRepository ticketRepository, TicketMapper ticketMapper) {
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
    }

    @Override
    public TicketDTO save(TicketDTO ticketDTO) {
        LOG.debug("Request to save Ticket : {}", ticketDTO);
        Ticket ticket = ticketMapper.toEntity(ticketDTO);
        ticket = ticketRepository.save(ticket);
        return ticketMapper.toDto(ticket);
    }

    @Override
    public TicketDTO update(TicketDTO ticketDTO) {
        LOG.debug("Request to update Ticket : {}", ticketDTO);
        Ticket ticket = ticketMapper.toEntity(ticketDTO);
        ticket = ticketRepository.save(ticket);
        return ticketMapper.toDto(ticket);
    }

    @Override
    public Optional<TicketDTO> partialUpdate(TicketDTO ticketDTO) {
        LOG.debug("Request to partially update Ticket : {}", ticketDTO);

        return ticketRepository
            .findById(ticketDTO.getId())
            .map(existingTicket -> {
                ticketMapper.partialUpdate(existingTicket, ticketDTO);

                return existingTicket;
            })
            .map(ticketRepository::save)
            .map(ticketMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TicketDTO> findOne(Long id) {
        LOG.debug("Request to get Ticket : {}", id);
        return ticketRepository.findById(id).map(ticketMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete Ticket : {}", id);
        ticketRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TicketDTO> findByBookingCode(String bookingCode) {
        LOG.debug("Request to get Tickets by booking code : {}", bookingCode);
        return ticketRepository.findByBooking_BookingCode(bookingCode)
            .stream()
            .map(ticketMapper::toDto)
            .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TicketDTO> findByTicketCode(String ticketCode) {
        LOG.debug("Request to get Ticket by ticket code : {}", ticketCode);
        return ticketRepository.findByTicketCode(ticketCode)
            .map(ticketMapper::toDto);
    }

    @Override
    public Optional<TicketDTO> checkinTicket(String ticketCode) {
        LOG.debug("Request to check in Ticket with code : {}", ticketCode);
        return ticketRepository.findByTicketCode(ticketCode)
            .map(ticket -> {
                ticket.setCheckedIn(true);
                return ticketRepository.save(ticket);
            })
            .map(ticketMapper::toDto);
    }
}
