package com.cybertek;

import com.cybertek.entity.Car;
import com.cybertek.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class OrmconfigApplication {
    @Autowired
    CarRepository carRepository;

    public static void main(String[] args) {

        SpringApplication.run(OrmconfigApplication.class, args);
    }

    // here we are using postconstruct method annotation to run it before everything, throught object
    @PostConstruct
    public void dataInit() {
        Car c1 = new Car("KIA", "niro");
        Car c2 = new Car("BMW", "x5");
        Car c3 = new Car("Audi", "Q5");

        // now when we have object we need bring repo to useservice save etc but first we need inject it with help @Autiwired
        // inject repo , now we able use all metjod in car repo . line 13-14


//        List<Car> cars = new ArrayList<>();
//        cars.add(c1);
//        carRepository.saveAll(cars);
        carRepository.save(c1);
        carRepository.save(c2);
        carRepository.save(c3);
        carRepository.count();

        //ORM map object to Db , object values to table data


    }
}
