package services;

import com.cybertek.interfaces.Course;
import com.cybertek.interfaces.ExtraSessions;
import lombok.Data;

@Data
public class Java implements Course {
    private ExtraSessions extraSessions;
    //  private OfficeHours officeHours;
// here @Data gets for us getters and setters or we can do command N create getters setters
//    public OfficeHours getOfficeHours() {
//        return officeHours;
//    }
//
//    public void setOfficeHours(OfficeHours officeHours) {// set +officeHours
//        this.officeHours = officeHours;
//    }

    public void getTeachingHours() {
        System.out.println("Weekly Teaching Hours : " + (20 + extraSessions.getHours()));


    }
}
