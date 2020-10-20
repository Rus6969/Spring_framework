package services;

import interfaces.Mentor;

public class FulltimeMentor implements Mentor {
    @Override
    public void createAccount() {
        System.out.println("Full time Mentor is created");

    }
}
