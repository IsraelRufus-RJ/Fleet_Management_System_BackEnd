package com.ramjo.fleet_management.mapper;

import com.ramjo.fleet_management.dto.DriverDTO;
import com.ramjo.fleet_management.entity.Driver;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DriverMapper {

    DriverDTO toDto(Driver driver);
    @Mapping(target="id", ignore=true)
    Driver toEntity(DriverDTO driverDTO);
    List<DriverDTO> toDriverDTOList(List<Driver> driverList);
    List<Driver> toDriverList(List<DriverDTO> driverDTOList);
}
