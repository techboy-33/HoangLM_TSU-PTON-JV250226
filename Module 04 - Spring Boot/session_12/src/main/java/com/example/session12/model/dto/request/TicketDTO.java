package com.example.session12.model.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TicketDTO {
    @NotBlank(message = "Ticket name can not blank")
    private String ticketName ;
    @NotBlank(message = "Description can not blank")
    private String description ;
    @NotNull(message = "Price can not null")
    @Min(0)
    private double price ;
}
