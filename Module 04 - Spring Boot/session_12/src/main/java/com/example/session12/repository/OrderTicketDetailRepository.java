package com.example.session12.repository;

import com.example.session12.model.entity.OrderTicketDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderTicketDetailRepository extends JpaRepository<OrderTicketDetail, Integer> {
    List<OrderTicketDetail> findByOrderId(long orderId);
}
