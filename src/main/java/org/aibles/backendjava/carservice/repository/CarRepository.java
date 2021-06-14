package org.aibles.backendjava.carservice.repository;

import org.aibles.backendjava.carservice.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {

}
