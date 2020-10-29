package com.cybertek.services;

import com.cybertek.interfaces.Course;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {
    @Override
    public void teachingHours() {
        System.out.println("Weekly teachig classes for Java 30");
    }
}
