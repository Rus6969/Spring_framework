package com.cybertek.controller;

import com.cybertek.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/welcome")
    public String homePage(Model model){

       model.addAttribute("name","Cybertek");
       model.addAttribute("course","MVC");

       String subject = "Collections";
       model.addAttribute("subject",subject);

       //create some random studentid (0-1000) and show it in your UI
        int studentId = new Random().nextInt(1000);
        model.addAttribute("id",studentId);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(5);
        numbers.add(7);
        model.addAttribute("numbers",numbers);

        //print your birthday
        LocalDate birthday = LocalDate.now().minusYears(42);
        model.addAttribute("birthday",birthday);


        //BREAK TILL 1:10 pm

        Student student = new Student(1,"Russell","Samatov");
        model.addAttribute("student",student);


       return "student/welcome";
    }
}
