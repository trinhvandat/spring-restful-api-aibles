package org.aibles.backendjava.carservice.service;

import org.aibles.backendjava.carservice.model.Car;

import java.util.List;

public interface CarService {

    Car createCar(Car car);

    Car updateCar(int carId, Car car);

    Car deleteCar(int carId);

    List<Car> listCar();
}
