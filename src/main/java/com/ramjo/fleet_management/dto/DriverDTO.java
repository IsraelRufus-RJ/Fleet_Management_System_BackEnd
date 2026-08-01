package com.ramjo.fleet_management.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DriverDTO {
    @NotBlank(message = "Driver name is required")
    private String name;

    @NotBlank(message = "License number is required")
    private String licenseNumber;

    @NotBlank(message = "Phone number is required")
    private String phoneNumber;
}
