package com.example.tikecktingSystem.repo;

import com.example.tikecktingSystem.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepo extends JpaRepository<TicketEntity,String> {
}
