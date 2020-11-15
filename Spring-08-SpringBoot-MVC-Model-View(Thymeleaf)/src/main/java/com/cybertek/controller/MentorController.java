package com.cybertek.controller;

import com.cybertek.enums.Gender;
import com.cybertek.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mentor")
public class MentorController {

        @GetMapping("/list")
        public String showTable(Model model){

            List<Mentor> mentorList = new ArrayList<>();
            mentorList.add(new Mentor("Russell","Samatov",Gender.MALE,43));
            mentorList.add(new Mentor("Inna","Gorbunova",Gender.FEMALE,26));
            mentorList.add(new Mentor("Rustam","Reptiloid",Gender.FEMALE,33));
            mentorList.add(new Mentor("Tambi","Massaev",Gender.MALE,13));


        model.addAttribute("mentors",mentorList);
        return "mentor/mentor-list";


    }
}
