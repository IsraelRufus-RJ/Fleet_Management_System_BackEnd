package com.ramjo.fleet_management.controller;

import com.ramjo.fleet_management.dto.DriverDTO;
import com.ramjo.fleet_management.dto.VehicleResponse;
import com.ramjo.fleet_management.entity.Driver;
import com.ramjo.fleet_management.entity.Vehicle;
import com.ramjo.fleet_management.mapper.DriverMapper;
import com.ramjo.fleet_management.mapper.VehicleMapper;
import com.ramjo.fleet_management.repository.DriverRepository;
import com.ramjo.fleet_management.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/fleet")
public class FleetController {
    @Autowired
    VehicleRepository vr;
    @Autowired
    DriverRepository dr;
    @Autowired
    DriverMapper dm;
    @Autowired
    VehicleMapper vm;

    @GetMapping("vehicle")
    public List<VehicleResponse> getVehicle(){
        return vm.toDtoList(vr.findAll());
    }

    @GetMapping("driver")
    public List<DriverDTO> getDriver(){
        List<Driver> ld  = dr.findAll();
        return dm.toDriverDTOList(ld);
    }

}

