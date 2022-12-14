package cybertek.services;


import cybertek.interfaces.Course;
import org.springframework.stereotype.Component;

@Component
public class Selenium implements Course {
    @Override
    public void getTeachingHours() {
        System.out.println("weekly Selenium teaching hours 20");
    }
}
