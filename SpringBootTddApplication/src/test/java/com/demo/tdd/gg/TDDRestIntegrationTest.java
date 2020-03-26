package com.demo.tdd.gg;

import com.demo.tdd.gg.model.Car;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static java.util.Objects.requireNonNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class TDDRestIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getcar_returnsCarDetails() {
        ResponseEntity<Car> response = restTemplate.getForEntity("/cars/prius", Car.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(requireNonNull(response.getBody()).getName()).isEqualTo("prius");
        assertThat(requireNonNull(response.getBody()).getType()).isEqualTo("hybrid");
    }

    @Test
    public void return_carNotFound_whenGivenAnUnknownCar() {
        ResponseEntity<Car> response = restTemplate.getForEntity("/cars/tesla", Car.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }
}
