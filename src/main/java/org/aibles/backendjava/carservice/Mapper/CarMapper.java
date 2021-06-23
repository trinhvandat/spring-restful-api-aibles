package org.aibles.backendjava.carservice.Mapper;

import org.aibles.backendjava.carservice.dto.CarDto;
import org.aibles.backendjava.carservice.model.Car;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    CarDto convertToDto(Car car);

    Car convertToEntity(CarDto carDto);
}
