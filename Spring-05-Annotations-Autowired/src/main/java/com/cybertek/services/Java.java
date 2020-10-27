package com.cybertek.services;

import com.cybertek.interfaces.Course;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {

    private  OfficeHours officeHours;

     @Autowired
    public Java(OfficeHours officeHours) {
        this.officeHours = officeHours;
    }

    @Override
    public void getTeachingHours() {
        System.out.println("Weekly java hourse "+(30+officeHours.getHours()));
    }
}
