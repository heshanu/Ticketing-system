package com.example.tikecktingSystem.service.impl;

import com.example.tikecktingSystem.dto.PaymentDTO;
import com.example.tikecktingSystem.dto.TicketDTO;
import com.example.tikecktingSystem.dto.UserDTO;
import com.example.tikecktingSystem.entity.TicketEntity;
import com.example.tikecktingSystem.entity.UserEntity;
import com.example.tikecktingSystem.entity.VehicleEntity;
import com.example.tikecktingSystem.repo.TicketRepo;
import com.example.tikecktingSystem.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepo ticketRepo;

    private TicketDTO mapToTicketDTO(TicketEntity ticket) {
        return new TicketDTO(
                ticket.getTicketNo(),
                ticket.getStartLocation(),
                ticket.getStartDateTime(),
                ticket.getEndLocation(),
                ticket.getTotalAmount(),
                ticket.getStartDateTime(),
                ticket.getStatus(),
                ticket.getPaymentEntity(),
                ticket.getVehicle()
        );

    }

    private TicketEntity mapToTicketEntity(TicketDTO ticketDTO){
        return new TicketEntity(
                ticketDTO.getTicketNo(),
                ticketDTO.getStartLocation(),
                ticketDTO.getStartDateTime(),
                ticketDTO.getEndLocation(),
                ticketDTO.getTotalAmount(),
                ticketDTO.getStartDateTime(),
                ticketDTO.getStatus(),
                ticketDTO.getPaymentEntity(),
                ticketDTO.getVehicle()
        );
    }


    @Override
    public List<TicketDTO> getTickets() {
        log.info("Show all Users");
        return ticketRepo.findAll().stream()
                .map(this::mapToTicketDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void addTicket(TicketDTO ticketDTO) {
        if(ticketRepo.existsById(String.valueOf(ticketDTO.getTicketNo()))){
            throw new RuntimeException("Ticket Id "+ticketDTO.getTicketNo()+" All ready exist");
        }
        TicketEntity vehicle =mapToTicketEntity(ticketDTO);
        ticketRepo.save(vehicle);
    }



    @Override
    public void updateTicket(TicketDTO ticketDTO) {
        if(!ticketRepo.existsById(String.valueOf(ticketDTO.getTicketNo()))){
            throw new RuntimeException("Ticket Id "+ticketDTO.getTicketNo()+" does not exist");
        }
        ticketRepo.save(mapToTicketEntity(ticketDTO));
        log.info("ticket updated",ticketDTO.getTicketNo());
    }
}
