package com.ramjo.fleet_management.service;

import com.ramjo.fleet_management.dto.DriverDTO;
import com.ramjo.fleet_management.dto.VehicleRequest;
import com.ramjo.fleet_management.dto.VehicleResponse;
import com.ramjo.fleet_management.entity.Driver;
import com.ramjo.fleet_management.entity.Vehicle;
import com.ramjo.fleet_management.mapper.DriverMapper;
import com.ramjo.fleet_management.mapper.VehicleMapper;
import com.ramjo.fleet_management.repository.DriverRepository;
import com.ramjo.fleet_management.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FleetService {

    public final DriverRepository driverRepository;
    public final VehicleRepository vehicleRepository;
    public final VehicleMapper vehicleMapper;
    public final DriverMapper driverMapper;

    @Transactional
    public DriverDTO registerDriver(DriverDTO driverDTO) {
        Driver driver = driverMapper.toEntity(driverDTO);
        return driverMapper.toDto(driverRepository.save(driver));
    }

    @Transactional
    public VehicleResponse registerVehicle(VehicleRequest vehicleRequest){
        Vehicle vehicle = vehicleMapper.toEntity(vehicleRequest);
        if (vehicleRequest.getDriverId() != null) {
            Optional<Driver> dr = driverRepository.findById(vehicleRequest.getDriverId());
            if(dr.isPresent()){
                vehicle.setDriver(dr.get());
            }else {
                throw new RuntimeException("Driver Not found");
            }
        }
        return vehicleMapper.toDto(vehicleRepository.save(vehicle));
    }

    @Transactional(readOnly=true)
    public List<VehicleResponse> getAllVehicles() {
        return vehicleMapper.toDtoList(vehicleRepository.findAll());
    }

    @Transactional(readOnly = true)
    public List<DriverDTO> getAllDrivers() {
       return driverMapper.toDriverDTOList(driverRepository.findAll());
    }
}
