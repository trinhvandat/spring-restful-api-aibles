package org.aibles.backendjava.carservice.service.iml;


import org.aibles.backendjava.carservice.exception.CarNotFoundException;
import org.aibles.backendjava.carservice.exception.TeacherNotFoundException;
import org.aibles.backendjava.carservice.model.Car;
import org.aibles.backendjava.carservice.repository.CarRepository;
import org.aibles.backendjava.carservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceIml implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceIml(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car updateCar(int carId, Car carReq) {
        Car result = carRepository.findById(carId)
                .map(car -> {
                    car.setName(carReq.getName());
                    car.setColor(carReq.getColor());
                    return car;
                })
                .map(carRepository::save)
                .orElseThrow(CarNotFoundException::new);
        return result;
    }

    @Override
    public void deleteCar(int carId) {
        carRepository.findById(carId)
                .map(car -> {
                    carRepository.delete(car);
                    return car;
                })
                .orElseThrow(TeacherNotFoundException::new);
    }

    @Override
    public List<Car> listCar() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(int carId) {
        return carRepository.findById(carId)
                .orElseThrow(CarNotFoundException::new);
    }
}
