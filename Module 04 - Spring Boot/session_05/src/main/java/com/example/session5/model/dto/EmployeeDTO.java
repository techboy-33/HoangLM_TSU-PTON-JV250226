package com.example.session5.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmployeeDTO {
    private String name;
    private String dob;
    private String address;
    private String phone;
    private String email;
    private String position;
    private double salary;
    private String startDate;
}
