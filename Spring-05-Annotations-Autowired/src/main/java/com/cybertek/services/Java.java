package com.cybertek.services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {
     //@Autowired
    private ExtraSessions officeHours;

   //  @Autowired
    public Java(OfficeHours officeHours) {
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
        System.out.println("Weekly java hourse "+(30+officeHours.getHours()));
    }
}
