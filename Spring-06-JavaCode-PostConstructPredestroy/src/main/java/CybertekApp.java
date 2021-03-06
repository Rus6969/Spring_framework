import com.cybertek.interfaces.Course;
import config.CybertekAppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CybertekApp {

    public static void main(String[] args) {
        ApplicationContext container = new AnnotationConfigApplicationContext(CybertekAppConfig.class);
        Course course = container.getBean("selenium", Course.class);
        course.getTeachingHourse();


        ((AnnotationConfigApplicationContext) container).close();


    }
}
