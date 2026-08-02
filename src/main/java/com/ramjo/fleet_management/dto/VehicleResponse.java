package com.ramjo.fleet_management.dto;

import com.ramjo.fleet_management.entity.Driver;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VehicleResponse {
        private long id;
        private String vin;
        private String licensePlate;
        private String model;
        private Double longitude;
        private Double latitude;
        private String formattedCoordinates;
        private DriverDTO driver;
        private LocalDateTime lastUpdated;
}
