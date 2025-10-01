package com.example.session12.model.dto.response;

import com.example.session12.model.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderResponse {
    private long id ;
    private String salesAgent ;
    private double totalAmount ;
    Map<String, Integer> foods ;
    Map<String, Integer> tickets ;
    private LocalDateTime orderDate ;
}
