package com.ridehub.booking.service.dto;

import java.util.List;

/**
 * Response DTO for tickets retrieved by booking code.
 */
public class TicketsByBookingCodeResponse {
    
    private List<TicketDTO> tickets;
    private List<String> qrCodes;
    
    public TicketsByBookingCodeResponse() {}
    
    public TicketsByBookingCodeResponse(List<TicketDTO> tickets, List<String> qrCodes) {
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
