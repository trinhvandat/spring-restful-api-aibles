package org.aibles.backendjava.carservice.service;

import org.aibles.backendjava.carservice.model.Car;

import java.util.List;

public interface CarService {

    Car createCar(Car carDto);

    Car updateCar(int carId, Car carReq);

    void deleteCar(int carId);

    List<Car> listCar();

    Car getCarById(int carId);
}
