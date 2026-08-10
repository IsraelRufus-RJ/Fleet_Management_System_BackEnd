package com.ramjo.fleet_management.controller;

import com.ramjo.fleet_management.dto.ApiResponse;
import com.ramjo.fleet_management.dto.DriverDTO;
import com.ramjo.fleet_management.dto.VehicleRequest;
import com.ramjo.fleet_management.dto.VehicleResponse;
import com.ramjo.fleet_management.entity.Driver;
import com.ramjo.fleet_management.entity.Vehicle;
import com.ramjo.fleet_management.mapper.DriverMapper;
import com.ramjo.fleet_management.mapper.VehicleMapper;
import com.ramjo.fleet_management.repository.DriverRepository;
import com.ramjo.fleet_management.repository.VehicleRepository;
import com.ramjo.fleet_management.service.FleetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:1234")
@RestController
@RequestMapping("api/v1/fleet")
@RequiredArgsConstructor
public class FleetController {
    @Autowired
    VehicleRepository vr;
    @Autowired
    DriverRepository dr;
    @Autowired
    DriverMapper dm;
    @Autowired
    VehicleMapper vm;

    public final FleetService fleetService;

    @GetMapping("vehicles")
    public List<VehicleResponse> getVehicle(){
        return vm.toDtoList(vr.findAll());
    }

    @GetMapping("driver")
    public ApiResponse<List<DriverDTO>> getDriver(){
        List<Driver> ld  = dr.findAll();
        return ApiResponse.ok(dm.toDriverDTOList(ld), "driver returend");
    }

    @PostMapping("/drivers")
    public ResponseEntity<DriverDTO> registerDriver(@Valid @RequestBody DriverDTO driverDTO){
        return new ResponseEntity<>(fleetService.registerDriver(driverDTO), HttpStatus.CREATED);
    }

    @PostMapping("/vehicles")
    public ResponseEntity<VehicleResponse> registerVehicle(@Valid @RequestBody VehicleRequest vehicleRequest){
        //return vehicleRequest.toString();
        return new ResponseEntity<>(fleetService.registerVehicle(vehicleRequest), HttpStatus.CREATED);
    }

}

