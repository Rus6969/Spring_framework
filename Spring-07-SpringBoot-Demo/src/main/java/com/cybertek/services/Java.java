package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.Extrasessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {
    private  Extrasessions extrasessions;

    @Value("${instructor}")
    private String instructorname;

    @Override
    public String toString() {
        return "Java{" +
                "instructorname='" + instructorname + '\'' +
                '}';
    }

    @Autowired
    public Java(Extrasessions extrasessions) {
        this.extrasessions = extrasessions;
    }

    @Override
    public void teachingHours() {
        System.out.println("teaching Java Classes "+(24+extrasessions.getHours()));

    }
}
