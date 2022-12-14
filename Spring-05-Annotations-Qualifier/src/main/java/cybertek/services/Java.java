package cybertek.services;

import cybertek.interfaces.Course;
import cybertek.interfaces.ExtraSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {
    //1 otion to add qualifier by using @Annotation Qqaualidifer on a field level
//    @Autowired
//    @Qualifier("officeHours")
    private ExtraSessions extraSessions;


    @Override
    public void getTeachingHours() {
        System.out.println("Weekly java hours " +30+extraSessions.getHours());
    }
// 2 second option add qualifier annotation under construvtor
    public Java(@Qualifier("officeHours") ExtraSessions extraSessions) {
        this.extraSessions = extraSessions;
    }
}
