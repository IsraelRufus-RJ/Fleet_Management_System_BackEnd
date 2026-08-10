package com.ramjo.fleet_management.dto;

import com.ramjo.fleet_management.entity.Driver;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VehicleRequest {
    @NotBlank(message="Vehicle Identification Number is Required.")
    @Size(min=17, max=17, message = "VIN Should be 17 Character.")
    private String vin;
    @NotBlank(message = "License Plate Number is Required.")
    private String licensePlate;

    @NotBlank(message="Vehicle Model is Required.")
    private String model;

    @NotNull(message = "Longitude is Required")
    @Min(value = -180, message = "Value >= -180")
    @Max(value = 180, message = "Value <= 180")
    private Double longitude;

    @NotNull(message="Latitude is Required")
    @Min(value = -90, message = "Value must be >= -90")
    @Max(value=180, message = "Value must be <= 180")
    private Double latitude;

    private Long driverId;

    private LocalDateTime lastUpdated;
}
