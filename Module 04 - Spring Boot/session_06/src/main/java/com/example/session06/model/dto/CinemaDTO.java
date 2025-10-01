package com.example.session06.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CinemaDTO {
    private String name;
    private String location;
    private Integer capacity;
}
