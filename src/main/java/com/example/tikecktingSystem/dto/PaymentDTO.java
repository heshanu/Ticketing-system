package com.example.tikecktingSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDTO {
    private String ticketNo;
    private String endLocation;
    private double totalAmount;
    private String endDateTime;
    private String status;
}
