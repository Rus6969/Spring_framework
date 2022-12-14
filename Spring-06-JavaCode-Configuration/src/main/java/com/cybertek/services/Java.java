package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;


public class Java implements Course {


    private ExtraSessions extraSessions;

    public Java(ExtraSessions extraSessions) {

        this.extraSessions = extraSessions;
    }

    @Override
    public void teachingHours() {
        System.out.println("Weekly teachig classes for Java " + (30 + extraSessions.getHours()));
    }

    @Value("batch12")
    private String batch;
    @Value("${instructor}")
    private String instructor;
    @Value("${days}")
    private String[] days;

    @Override
    public String toString() {
        return "Java{" +
                "batch='" + batch + '\'' +
                ", instructor='" + instructor + '\'' +
                ", days=" + Arrays.toString(days) +
                '}';
    }


}
