package com.cybertek.services;

import com.cybertek.interfaces.Course;
import org.springframework.stereotype.Component;

@Component
public class Selenium  implements Course {
    @Override
    public void teachingHours() {
        System.out.println("teaching Selenium 30 hours");
    }
}
