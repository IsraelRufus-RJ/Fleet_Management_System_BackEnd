package com.ramjo.fleet_management.dto;

import com.ramjo.fleet_management.entity.Driver;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class VehicleRequest {
    
    private String vin;

    private String licensePlate;

    private String model;
    private Double longitude;
    private Double latitude;

    private Driver driver;

    private LocalDateTime lastUpdated;
}
