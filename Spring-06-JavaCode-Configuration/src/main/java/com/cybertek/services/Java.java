package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;
import org.springframework.stereotype.Component;


public class Java implements Course {


    private ExtraSessions extraSessions;

    public Java(ExtraSessions extraSessions) {
        this.extraSessions = extraSessions;
    }

    @Override
    public void teachingHours() {
        System.out.println("Weekly teachig classes for Java " +(30+extraSessions.getHours()));
    }
}
