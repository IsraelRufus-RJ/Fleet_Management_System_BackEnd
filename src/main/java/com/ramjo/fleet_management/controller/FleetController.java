package com.ramjo.fleet_management.controller;

import com.ramjo.fleet_management.dto.ApiResponse;
import com.ramjo.fleet_management.dto.DriverDTO;
import com.ramjo.fleet_management.dto.VehicleRequest;
import com.ramjo.fleet_management.dto.VehicleResponse;
import com.ramjo.fleet_management.service.FleetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:1234")
@RestController
@RequestMapping("api/v1/fleet")
@RequiredArgsConstructor
public class FleetController {

    public final FleetService fleetService;

    //returns list of vehicles with resp
    @GetMapping("/vehicles")
    public ResponseEntity<ApiResponse<List<VehicleResponse>>> getVehicle(){
        //for response entity ok pass object directly or u can use ok().body(object)
        return ResponseEntity.ok(ApiResponse.ok(fleetService.getAllVehicles(), "Vehicles retrived"));
    }

    @GetMapping("/drivers")
    public ResponseEntity<ApiResponse<List<DriverDTO>>> getDriver(){
        return ResponseEntity.ok(ApiResponse.ok(fleetService.getAllDrivers(), "Drivers retrived"));
    }

    @PostMapping("/drivers")
    public ResponseEntity<ApiResponse<DriverDTO>> registerDriver(@Valid @RequestBody DriverDTO driverDTO){
        // this below response entity is also valid using constructor we pass 2 values the object, the status enum
        //return new ResponseEntity<>(fleetService.registerDriver(driverDTO), HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.ok(fleetService.registerDriver(driverDTO), "Driver created"));
    }

    @PostMapping("/vehicles")
    public ResponseEntity<ApiResponse<VehicleResponse>> registerVehicle(@Valid @RequestBody VehicleRequest vehicleRequest){
        // this below response entity is also valid using constructor we pass 2 values the object, the status enum
        //return new ResponseEntity<>(fleetService.registerVehicle(vehicleRequest), HttpStatus.CREATED);
        //if we give body no need to use .build , it is only use in noContent().build()
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.ok(fleetService.registerVehicle(vehicleRequest), "Vehicle created"));
    }

}

