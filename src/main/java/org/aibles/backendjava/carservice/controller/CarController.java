package org.aibles.backendjava.carservice.controller;

import org.aibles.backendjava.carservice.dto.CarDto;
import org.aibles.backendjava.carservice.model.Car;
import org.aibles.backendjava.carservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car carReq){
        final Car createdCar = carService.createCar(carReq);
        return new ResponseEntity<>(createdCar, HttpStatus.CREATED);
    }

    @PutMapping("/{car_id}")
    public ResponseEntity<Car> updateCar(@PathVariable("car_id") int carId,
                                         @RequestBody Car carReq){
        final Car updatedCar = carService.updateCar(carId, carReq);
        return new ResponseEntity<>(updatedCar, HttpStatus.OK);
    }

    @DeleteMapping("/{car_id}")
    public ResponseEntity<Void> deleteCar(@PathVariable("car_id") int carId){
        carService.deleteCar(carId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Car>> listCars(){
        final List<Car> cars = carService.listCar();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id") int carId){
        final Car car = carService.getCarById(carId);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }
}
