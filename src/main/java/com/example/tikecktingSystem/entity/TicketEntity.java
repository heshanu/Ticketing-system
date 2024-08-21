package com.example.tikecktingSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Ticket")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TicketEntity {
    @Id
    private int ticketNo;
    private String startLocation;
    private String startDateTime;
    private String endLocation;
    private double totalAmount;
    private String endDateTime;
    private String status;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paymentNo")
    private PaymentEntity paymentEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_nic")
    private VehicleEntity vehicle;
}
