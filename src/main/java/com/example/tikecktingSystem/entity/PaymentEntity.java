package com.example.tikecktingSystem.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Payment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentEntity {
    @Id
    private String paymentNo;
    private String endLocation;
    private double totalAmount;
    private String endDateTime;
    private String status;
    private PaymentMethod paymentMethod;

    @OneToOne(mappedBy = "paymentEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private TicketEntity ticket;
}
