package com.cybertek.controller;
import com.cybertek.enums.Brand;
import com.cybertek.model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/car")
public class CarController {

    @GetMapping("/list")
    public String showTable(Model model){
        List<Car> carList = new ArrayList<>();
        carList.add(new Car(Brand.BMW, 2020, 3.2, "black"));
        carList.add(new Car(Brand.HONDA, 2021, 2.2, "silver"));
        carList.add(new Car(Brand.KIA, 2019, 1.6, "blue"));

        model.addAttribute("tachka",carList);
        return "car/car-list";

    }

}
