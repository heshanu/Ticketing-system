package com.example.tikecktingSystem.controller;

import com.example.tikecktingSystem.dto.PaymentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {
    @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateTicketDetails(@RequestBody PaymentDTO paymentDTO){
        System.out.println(paymentDTO);
        //restTemplate.put("http://TICKET-SERVICE/api/v1/tickets/updateStatus",paymentDTO);
    }
}
