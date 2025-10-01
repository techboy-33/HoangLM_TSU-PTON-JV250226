package com.example.session06.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TicketDTO {
    private String username;
    private String phoneNumber;
    private long showtimeId;
    private String seatNumber;
}
