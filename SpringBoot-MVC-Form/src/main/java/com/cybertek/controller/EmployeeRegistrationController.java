package com.cybertek.controller;

import com.cybertek.model.Employee;

import com.cybertek.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeRegistrationController {


    @GetMapping("/register")
    public String showForm(Model model){
        model.addAttribute("employ",new Employee());



        return  "index";
    }

    @PostMapping("/confirm")
    public String submitForm(@ModelAttribute("employee") Employee employee){

        System.out.println(employee.toString());

        return "employee-list";
    }
}
