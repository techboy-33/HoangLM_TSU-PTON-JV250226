package com.example.session12.model.dto.request;

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
public class FoodDTO {
    @NotBlank(message = "Food name can not blank")
    private String foodName ;
    @NotBlank(message = "Description can not blank")
    private String description ;
    @NotNull(message = "Price can not null")
    private double price ;
}
