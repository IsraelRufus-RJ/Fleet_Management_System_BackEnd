package com.ramjo.fleet_management.mapper;

import com.ramjo.fleet_management.dto.VehicleRequest;
import com.ramjo.fleet_management.dto.VehicleResponse;
import com.ramjo.fleet_management.entity.Vehicle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {DriverMapper.class})
public interface VehicleMapper {

    Vehicle toEntity(VehicleRequest vehicleRequest);
    @Mapping(target="formattedCoordinates", expression = "java(vehicle.getLongitude()+ \" , \" + vehicle.getLatitude())")
    VehicleResponse toDto(Vehicle vehicle);
    List<Vehicle> toEntityList(List<VehicleRequest> vehicleRequestList);

    List<VehicleResponse> toDtoList(List<Vehicle> vehicleList);


}
