package com.ridehub.booking.service.dto.response;

import java.util.List;

import com.ridehub.booking.service.dto.TicketDTO;

public class TicketResponse {
    private List<TicketDTO> tickets;
    private List<String> qrCodes;

    public TicketResponse(List<TicketDTO> tickets, List<String> qrCodes) {
        this.tickets = tickets;
        this.qrCodes = qrCodes;
    }

    public List<TicketDTO> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketDTO> tickets) {
        this.tickets = tickets;
    }

    public List<String> getQrCodes() {
        return qrCodes;
    }

    public void setQrCodes(List<String> qrCodes) {
        this.qrCodes = qrCodes;
    }
}