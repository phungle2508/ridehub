package com.ridehub.booking.service;

import com.ridehub.booking.service.dto.TicketDTO;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link com.ridehub.booking.domain.Ticket}.
 */
public interface TicketService {
    /**
     * Save a ticket.
     *
     * @param ticketDTO the entity to save.
     * @return the persisted entity.
     */
    TicketDTO save(TicketDTO ticketDTO);

    /**
     * Updates a ticket.
     *
     * @param ticketDTO the entity to update.
     * @return the persisted entity.
     */
    TicketDTO update(TicketDTO ticketDTO);

    /**
     * Partially updates a ticket.
     *
     * @param ticketDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<TicketDTO> partialUpdate(TicketDTO ticketDTO);

    /**
     * Get the "id" ticket.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<TicketDTO> findOne(Long id);

    /**
     * Delete the "id" ticket.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);

    /**
     * Get tickets by booking code.
     *
     * @param bookingCode the booking code.
     * @return the list of entities.
     */
    List<TicketDTO> findByBookingCode(String bookingCode);

    /**
     * Get ticket by ticket code.
     *
     * @param ticketCode the ticket code.
     * @return the entity.
     */
    Optional<TicketDTO> findByTicketCode(String ticketCode);

    /**
     * Check in a ticket.
     *
     * @param ticketCode the ticket code to check in.
     * @return the updated entity.
     */
    Optional<TicketDTO> checkinTicket(String ticketCode);
}
