package com.example.tikecktingSystem.dto;

import com.example.tikecktingSystem.entity.PaymentEntity;
import com.example.tikecktingSystem.entity.VehicleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketDTO {
    private int ticketNo;
    private String startLocation;
    private String startDateTime;
    private String endLocation;
    private double totalAmount;
    private String endDateTime;
    private String status;
    private PaymentEntity paymentEntity;
    private VehicleEntity vehicle;
}
