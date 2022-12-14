package cybertek.services;

import cybertek.interfaces.Course;
import cybertek.interfaces.ExtraSessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Java implements Course {


    private ExtraSessions extraSessions;


    @Override
    public void getTeachingHours() {
        System.out.println("Weekly java hours " +extraSessions.getHours());
    }
}
