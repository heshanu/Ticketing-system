package com.example.tikecktingSystem.controller;

import com.example.tikecktingSystem.dto.PaymentDTO;
import com.example.tikecktingSystem.dto.TicketDTO;
import com.example.tikecktingSystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TicketDTO> getTicketsDetails() {
        return ticketService.getTickets();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveTicketDetails(@RequestBody TicketDTO ticketDTO) {
        ticketService.addTicket(ticketDTO);
    }

    @PutMapping(value = "/updateStatus",consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateTicketDetails(@RequestBody TicketDTO ticketDTO) {
        System.out.println();
        ticketService.updateTicket(ticketDTO);
    }
}
