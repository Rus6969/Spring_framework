package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {

    //field ingection
    //@Autowired
    private ExtraSessions officeHours;
    /// with constructor injection , if there is 1 constructor no need to put Annotation @Aut0wired
    @Autowired
    public Java(ExtraSessions officeHours) {
        this.officeHours = officeHours;
    }

    /*
    //Setter Injection
    @Autowired
    public void setOfficeHours(OfficeHours officeHours) {
        this.officeHours = officeHours;
    }

 */

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly java horse " + (30 + officeHours.getHours()));
    }
}
