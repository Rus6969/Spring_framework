package com.cybertek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @GetMapping("index")
    public String index(){
        return "/index";
    }




// if we enter local host or local host login bring login page
    @GetMapping(value = {"/login","/"})
    public String login(){

        return "login";
    }
}