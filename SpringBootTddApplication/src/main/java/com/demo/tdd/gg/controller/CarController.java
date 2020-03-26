package com.demo.tdd.gg.controller;

import com.demo.tdd.gg.model.Car;
import com.demo.tdd.gg.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars/{name}")
    public Car getCarDetails(@PathVariable String name) {
        Car car = carService.detailsFor(name);
        if (car == null) {
            throw new CarNotFoundException();
        }
        return car;
    }
}
