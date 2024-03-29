import interfaces.Mentor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CybertekApp {
    public static void main(String[] args) {
        //we need to pass configuration file in container we have beans , all beans mentioned in xml file

//         BeanFactory container = new ClassPathXmlApplicationContext("config.xml");
//          // object top class so we need to cas  , left side always decides accessability
//          Mentor mentor = (Mentor) container.getBean("fullTimeMentor");
//          mentor.createAccount();


//////////////// second option achive BeanFactory by using different interface /////////////////////////////////////////////
        // this clas implemennts BeanFactory , does same thing
        ApplicationContext container = new ClassPathXmlApplicationContext("config.xml");

        Mentor mentor = (Mentor) container.getBean("fullTimeMentor");
       mentor.createAccount();

//        Mentor mentor2 = (Mentor) container.getBean("parttimeMentor");
//        mentor2.createAccount();

////////////////////////// THIRD Option to get beans from container /////////////////////////////////////////////
        // one of option get bean with 2 parameters at this case we can avoid casting as at line 18,15 .
      //  Mentor mentor = container.getBean("parttimeMentor", Mentor.class);

    }
}
