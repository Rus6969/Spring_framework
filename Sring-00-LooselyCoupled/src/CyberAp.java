import implementation.Mentor;
import service.FulltimeMentor;
import service.MentorAccount;

public class CyberAp {
    public static void main(String[] args) {
        FulltimeMentor fulltimeMentor= new FulltimeMentor();

        MentorAccount mentor = new MentorAccount(fulltimeMentor) ;
        mentor.manageAccount();
    }
}
