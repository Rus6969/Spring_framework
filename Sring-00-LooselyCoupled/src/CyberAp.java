import implementation.Mentor;
import service.FulltimeMentor;
import service.MentorAccount;
import service.PartTimeMentor;

public class CyberAp {
    public static void main(String[] args) {
        //FulltimeMentor fulltimeMentor= new FulltimeMentor();
        PartTimeMentor partTimeMentor = new PartTimeMentor();

        MentorAccount mentor = new MentorAccount(partTimeMentor) ;
        mentor.manageAccount();


    }
}
