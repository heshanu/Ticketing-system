package com.example.tikecktingSystem.repo;

import com.example.tikecktingSystem.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<PaymentEntity,String> {
}
