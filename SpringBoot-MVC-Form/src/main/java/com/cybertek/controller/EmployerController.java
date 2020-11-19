package com.cybertek.controller;

import com.cybertek.dataGenerator.DataGenerator;
import com.cybertek.model.Employee;
import com.cybertek.model.EmployerDemo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/employer")
public class EmployerController {


    @GetMapping("/register")
    public String employerCreate(Model model){
        model.addAttribute("employ",new EmployerDemo());
        model.addAttribute("stateList", DataGenerator.getStateList());

        return  "employer/employer-create";
    }


    @PostMapping("/list")
    public String employerList(@ModelAttribute("employ") EmployerDemo employer,Model model){

        System.out.println(employer.toString());
        model.addAttribute("employer", Arrays.asList(employer));

        int birthYear = LocalDate.parse(employer.getBirthday()).getYear();
        model.addAttribute("age",LocalDate.now().getYear() - birthYear);
        return "employer/employer-list";
    }
}
