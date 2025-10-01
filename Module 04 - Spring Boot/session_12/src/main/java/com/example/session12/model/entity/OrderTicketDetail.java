package com.example.session12.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderTicketDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order ;
    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private Ticket ticket ;
    private int quantity ;
    private double priceBuy ;
}
