package org.aibles.backendjava.carservice.service;

import org.aibles.backendjava.carservice.dto.CarDto;
import org.aibles.backendjava.carservice.model.Car;

import java.util.List;

public interface CarService {

    CarDto createCar(CarDto carDto);

    CarDto updateCar(int carId, CarDto carDto);

    Car deleteCar(int carId);

    List<Car> listCar();
}
