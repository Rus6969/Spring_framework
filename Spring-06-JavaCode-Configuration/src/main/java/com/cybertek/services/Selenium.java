package com.cybertek.services;

import com.cybertek.interfaces.Course;
import org.springframework.stereotype.Component;

public class Selenium implements Course {
    @Override
    public void teachingHours() {
        System.out.println("Weekly teaching Hours for Selenium 22");
    }
}
