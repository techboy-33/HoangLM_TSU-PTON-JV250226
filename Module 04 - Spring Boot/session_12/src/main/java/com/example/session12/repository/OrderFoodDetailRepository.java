package com.example.session12.repository;

import com.example.session12.model.entity.OrderFoodDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderFoodDetailRepository extends JpaRepository<OrderFoodDetail, Integer> {
    List<OrderFoodDetail> findByOrderId(long orderId);
}
