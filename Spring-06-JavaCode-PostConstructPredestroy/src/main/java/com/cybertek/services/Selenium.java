package com.cybertek.services;

import com.cybertek.interfaces.Course;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Selenium implements Course {
    @Override
    public void getTeachingHourse() {
        System.out.println("Java teaching Hours 30");

    }


    @PostConstruct
    public void postConstruct() {
        System.out.println("Executing PostConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("Executing PostDestroy");
    }
}
