package com.demo.tdd.gg.controller;

import com.demo.tdd.gg.model.Car;
import com.demo.tdd.gg.service.CarService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Test
    void return_carDetails() throws Exception {
        String name = "fortuner";
        String type = "petrol";
        Car car = new Car(name, type);
        when(carService.detailsFor(name)).thenReturn(car);

        mockMvc.perform(get("/cars/{name}", name))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name").value(name))
                .andExpect(jsonPath("type").value(type));
    }

    @Test
    void return_carNotFound() throws Exception {
        String name = "tesla";
        when(carService.detailsFor(name)).thenReturn(null);

        mockMvc.perform(get("/cars/{name}", name))
                .andExpect(status().isNotFound());
    }
}
