package com.ramjo.fleet_management.controller;

import com.ramjo.fleet_management.dto.DriverDTO;
import com.ramjo.fleet_management.entity.Driver;
import com.ramjo.fleet_management.entity.Vehicle;
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

    @GetMapping("vehicle")
    public List<Vehicle> getVehicle(){
        return vr.findAll();
    }

    @GetMapping("driver")
    public List<DriverDTO> getDriver(){
        List<Driver> ld  = dr.findAll();
        return ld.stream().map((e) -> {DriverDTO ddto = new DriverDTO(); ddto.setName(e.getName()); ddto.setPhoneNumber(e.getPhoneNumber()); ddto.setLicenseNumber(e.getLicenseNumber()); return ddto;}).collect(Collectors.toList());

    }

}
