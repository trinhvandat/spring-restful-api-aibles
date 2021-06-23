package org.aibles.backendjava.carservice.service.iml;


import org.aibles.backendjava.carservice.Mapper.CarMapper;
import org.aibles.backendjava.carservice.dto.CarDto;
import org.aibles.backendjava.carservice.model.Car;
import org.aibles.backendjava.carservice.repository.CarRepository;
import org.aibles.backendjava.carservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceIml implements CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Autowired
    public CarServiceIml(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }


    @Override
    public CarDto createCar(CarDto carDto) {
        Car car = carMapper.convertToEntity(carDto);
        return carMapper.convertToDto(carRepository.save(car));
    }

    @Override
    public CarDto updateCar(int carId, CarDto carDto) {
        Car carReq = convertToEntity(carDto);
        Car result = carRepository.findById(carId)
                .map(car -> {
                    car.setName(carReq.getName());
                    car.setColor(carReq.getColor());
                    return car;
                })
                .map(carRepository::save)
                .orElse(null);
        return convertToDTO(result);
    }

    @Override
    public Car deleteCar(int carId) {
        return carRepository.findById(carId)
                .map(car -> {
                    carRepository.delete(car);
                    return car;
                })
                .orElse(null);
    }

    @Override
    public List<Car> listCar() {
        return carRepository.findAll();
    }

    private Car convertToEntity(CarDto carDto) {
        Car car = new Car();
        car.setId(carDto.getId());
        car.setName(carDto.getName());
        car.setColor(carDto.getColor());

        return car;
    }

    private CarDto convertToDTO(Car car) {
        CarDto carDto = new CarDto();
        carDto.setId(car.getId());
        carDto.setName(car.getName());
        carDto.setColor(car.getColor());

        return carDto;
    }
}
