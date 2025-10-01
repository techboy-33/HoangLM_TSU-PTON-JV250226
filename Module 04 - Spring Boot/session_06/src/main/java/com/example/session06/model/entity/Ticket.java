package com.example.session06.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "tickets")
public class Ticket {
    @Id
    private String id;
    private String username;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "showtime_id")
    private Showtime showtime;

    private String seatNumber;



    // Phương thức tạo mã vé
    public String generateTicketId() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder ticketId = new StringBuilder();
        String datePart = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        ticketId.append(datePart);
        for (int i = 1; i <= 6; i++) {
            ticketId.append(chars.charAt(random.nextInt(chars.length())));
        }
        return ticketId.toString();
    }
}
