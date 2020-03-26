package com.demo.tdd.gg.repository;

import com.demo.tdd.gg.model.Car;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void return_carGivenItsName() {
        Car expected = new Car("audi 5", "petrol");
        testEntityManager.persistFlushFind(expected);

        Car actual = carRepository.findByName("audi 5");
        assertThat(actual).isEqualTo(expected);
    }
} 