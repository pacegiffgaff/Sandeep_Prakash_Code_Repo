package com.demo.tdd.gg.service;

import com.demo.tdd.gg.controller.CarNotFoundException;
import com.demo.tdd.gg.model.Car;
import com.demo.tdd.gg.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car detailsFor(String name) {
       Car car = carRepository.findByName(name);
       if(car == null){
           throw new CarNotFoundException();
       }
       return car;
    }
}
