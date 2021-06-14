package org.aibles.backendjava.carservice.controller;

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
    public ResponseEntity<Car> createCar(@RequestBody Car car){
        final Car createdCar = carService.createCar(car);
        return new ResponseEntity<>(createdCar, HttpStatus.CREATED);
    }

    @PutMapping("/{car_id}")
    public ResponseEntity<Car> updateCar(@PathVariable("car_id") int carId,
                                         @RequestBody Car car){
        final Car updatedCar = carService.updateCar(carId, car);
        if (updatedCar == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(updatedCar, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{car_id}")
    public ResponseEntity<Void> deleteCar(@PathVariable("car_id") int carId){
        final Car deletedCar = carService.deleteCar(carId);
        if (deletedCar == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @GetMapping
    public ResponseEntity<List<Car>> listCars(){
        final List<Car> cars = carService.listCar();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }
}
