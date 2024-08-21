package com.example.tikecktingSystem.service;

import com.example.tikecktingSystem.dto.PaymentDTO;
import com.example.tikecktingSystem.dto.TicketDTO;

import java.util.List;

public interface TicketService {
    List<TicketDTO> getTickets();
    void addTicket(TicketDTO ticketDTO);
    void updateTicket(TicketDTO ticketDTO);
}
