package com.demo.tdd.gg.service;

import com.demo.tdd.gg.model.Car;
import com.demo.tdd.gg.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

    private CarService carService;
    private CarRepository carRepository;

    @BeforeEach
    public void setUp() {
        carRepository = mock(CarRepository.class);
        carService = new CarService(carRepository);
    }

    @Test
    public void return_carGivenItsName() {
        String name = "tesla";
        Car expected = new Car(name, "electric");
        when(carRepository.findByName(name)).thenReturn(expected);

        Car actual = carService.detailsFor(name);

        assertThat(actual).isEqualTo(expected);
    }

}